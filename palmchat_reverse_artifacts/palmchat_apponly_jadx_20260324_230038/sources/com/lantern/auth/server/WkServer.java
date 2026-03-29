package com.lantern.auth.server;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.lantern.auth.android.BLPlatform;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLHttp;
import com.lantern.auth.core.BLLog;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkServer {
    protected static final String INITDEV_PID = "00200201";
    protected static final String mUHID = "a0000000000000000000000000000001";
    public String mAESIV;
    public String mAESKey;
    public String mAppId;
    protected Context mContext;
    protected String mDHID;
    protected String mIMEI;
    protected String mMAC;
    public String mMD5Key;

    public WkServer(Context context) {
        this.mContext = context;
        init();
    }

    private static String getInitDevUrl() {
        return String.format("%s%s", "http://sso.51y5.net", "/sso/fa.sec");
    }

    private HashMap<String, String> getParamMap(Context context) {
        HashMap<String, String> params = getParams();
        params.put("pid", INITDEV_PID);
        BLLog.d("getSimSerialNumber " + BLPlatform.getSimSerialNumber(context), new Object[0]);
        params.put(WkParams.SIM, BLPlatform.getSimSerialNumber(context));
        params.put("os", BLPlatform.getOS());
        params.put(WkParams.OSVER, BLPlatform.getOS());
        params.put(WkParams.OSVERCODE, String.valueOf(BLPlatform.getAndroidVersionCode()));
        params.put(WkParams.WKVER, BLPlatform.getAppVersionName(context));
        params.put(WkParams.SCRL, String.valueOf(WkPlatform.getScreenHeightPixels(context)));
        params.put(WkParams.SCRS, String.valueOf(WkPlatform.getScreenWidthPixels(context)));
        params.put(WkParams.MISC, BLPlatform.getDeviceFingerprint());
        params.put(WkParams.MANUF, BLPlatform.getDeviceManufacturer());
        params.put(WkParams.MODEL, BLPlatform.getDeviceModel());
        return sign(INITDEV_PID, params);
    }

    private HashMap<String, String> getParams() {
        HashMap<String, String> map = new HashMap<>();
        map.put(WkParams.SIM, BLPlatform.getSimSerialNumber(this.mContext));
        map.put("appId", this.mAppId);
        map.put(WkParams.LANG, WkPlatform.getLang());
        PrivInfoManager privInfoManager = PrivInfoManager.INSTANCE;
        PackageInfo selfPackageInfo = privInfoManager.getSelfPackageInfo();
        if (selfPackageInfo != null) {
            map.put("verName", selfPackageInfo.versionName);
            map.put("verCode", String.valueOf(selfPackageInfo.versionCode));
        }
        map.put("chanId", WkSDKManager.getChannel());
        map.put(WkParams.IMEI, "");
        map.put("mac", "");
        map.put("android", "");
        map.put("netModel", WkPlatform.getNetworkType(this.mContext));
        map.put(WkParams.NETOPER, privInfoManager.getDefaultNetworkOperator());
        map.put("ts", System.currentTimeMillis() + "");
        return map;
    }

    private void init() {
        this.mIMEI = "";
        this.mMAC = "";
    }

    private HashMap<String, String> sign(String str, HashMap<String, String> map) {
        String string = new JSONObject(map).toString();
        map.clear();
        try {
            map.put("appId", this.mAppId);
            if (!TextUtils.isEmpty(str)) {
                map.put("pid", str);
            }
            map.put("ed", WkSecretKey.encryptAES(Uri.encode(string.trim(), "UTF-8"), this.mAESKey, this.mAESIV));
            map.put("et", "a");
            map.put("st", "m");
            map.put("sign", WkMessageDigest.sign(map, this.mMD5Key));
        } catch (Exception e) {
            BLLog.e(e);
        }
        return map;
    }

    private String syncInitDev() {
        String strPostMap;
        try {
            strPostMap = BLHttp.postMap(getInitDevUrl(), getParamMap(this.mContext));
        } catch (Exception e) {
            e.printStackTrace();
            strPostMap = null;
        }
        if (TextUtils.isEmpty(strPostMap)) {
            return null;
        }
        BLLog.d("JSON:" + strPostMap, new Object[0]);
        try {
            JSONObject jSONObject = new JSONObject(strPostMap);
            boolean zEquals = "0".equals(jSONObject.getString(WkParams.RETCD));
            BLLog.d("retcode=%s,retmsg=%s", Integer.valueOf(zEquals ? 1 : 0), jSONObject.has(WkParams.RETMSG) ? jSONObject.getString(WkParams.RETMSG) : null);
            if (zEquals) {
                return jSONObject.getString("dhid");
            }
        } catch (JSONException e2) {
            BLLog.e(e2);
        }
        return null;
    }

    public synchronized String ensureDHID() {
        String strSyncInitDev;
        strSyncInitDev = syncInitDev();
        this.mDHID = strSyncInitDev;
        return strSyncInitDev;
    }

    public HashMap<String, String> getPublicParams() {
        return getParams();
    }

    public HashMap<String, String> signMap(HashMap<String, String> map) {
        map.put("sign", WkMessageDigest.sign(map, this.mMD5Key));
        return map;
    }

    public HashMap<String, String> signParams(String str, HashMap<String, String> map) {
        return sign(str, map);
    }
}
