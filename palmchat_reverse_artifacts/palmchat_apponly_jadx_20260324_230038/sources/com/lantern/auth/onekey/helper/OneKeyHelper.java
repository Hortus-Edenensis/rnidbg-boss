package com.lantern.auth.onekey.helper;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.server.WkPlatform;
import com.lantern.auth.util.report.OneKeyReportInfo;
import defpackage.nl0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class OneKeyHelper {
    public static final String APP_ID_UNICOM = "99166000000000000223";
    public static final String APP_KEY_UNICOM = "59083148dfca5d3c93deae5c8865daed";
    public static final int LOGIN_MODE_UPLINK_CMCC = 1;
    public static final int LOGIN_MODE_UPLINK_MOB = 16;
    public static final int LOGIN_MODE_UPLINK_TELECOM = 8;
    public static final int LOGIN_MODE_UPLINK_UNICOM = 4;
    public static final String MOVETYPE_CMCC = "CMCC_V1";
    public static final String MOVETYPE_MOB = "MOB";
    public static final String MOVETYPE_TELECOM = "TELECOM_V1";
    public static final String MOVETYPE_UNICOM = "UNICOM";
    public static final boolean TEST_UNION = false;
    private String clientId;
    private String clientKey;
    protected Context mContext;

    public OneKeyHelper(Context context) {
        this.mContext = context.getApplicationContext();
        init();
    }

    private String getAppid(String str) {
        String str2 = this.clientId;
        if (str2 != null) {
            return str2;
        }
        try {
            String metaDataString = WkPlatform.getMetaDataString(this.mContext, str + "_id");
            this.clientId = metaDataString;
            if (!TextUtils.isEmpty(metaDataString)) {
                String str3 = this.clientId;
                this.clientId = str3.substring(str3.indexOf(95) + 1);
            }
            try {
                BLLog.d(str + " clientId is " + this.clientId, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            BLLog.e(e2);
        }
        if (TextUtils.isEmpty(this.clientId) && TextUtils.equals("unicom", str)) {
            this.clientId = nl0.k() ? "adcd40a398f0a1732658104266600473" : "dbffc1fe07a0a1732658860507975730";
        }
        return this.clientId;
    }

    private String getKey(String str) {
        String str2 = this.clientKey;
        if (str2 != null) {
            return str2;
        }
        try {
            String metaDataString = WkPlatform.getMetaDataString(this.mContext, str + "_key");
            this.clientKey = metaDataString;
            if (!TextUtils.isEmpty(metaDataString)) {
                String str3 = this.clientKey;
                this.clientKey = str3.substring(str3.indexOf(95) + 1);
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" clientkey is ****");
                sb.append(this.clientKey.substring(r1.length() - 5));
                BLLog.d(sb.toString(), new Object[0]);
            } catch (Exception e) {
                BLLog.e(e);
            }
        } catch (Exception e2) {
            BLLog.e(e2);
        }
        if (TextUtils.isEmpty(this.clientKey) && TextUtils.equals("unicom", str)) {
            this.clientKey = APP_KEY_UNICOM;
        }
        return this.clientKey;
    }

    private String getPrefix() {
        String moveType = getMoveType();
        return TextUtils.equals(MOVETYPE_CMCC, moveType) ? "cmcc" : TextUtils.equals(MOVETYPE_UNICOM, moveType) ? "unicom" : TextUtils.equals(MOVETYPE_TELECOM, moveType) ? "telecom" : "";
    }

    public String getClientIdByType() {
        return getAppid(getPrefix());
    }

    public String getClientKeyByType() {
        return getKey(getPrefix());
    }

    public abstract int getLoginType();

    public abstract String getMoveType();

    public abstract void init();

    public abstract void preLogin(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo);

    public abstract void retryAccessToken(BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo);
}
