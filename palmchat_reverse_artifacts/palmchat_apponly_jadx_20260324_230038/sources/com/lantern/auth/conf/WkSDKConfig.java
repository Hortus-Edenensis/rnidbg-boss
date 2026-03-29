package com.lantern.auth.conf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lantern.auth.app.PermissionManager;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.server.WkPlatform;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkSDKConfig extends JSONObject {
    public static final String NET_OPERATOR = "{\"operator\": [{\"operatorName\": \"cmcc\",\"operatorCodeSet\": \"46000,46002,46007\"},{\"operatorName\": \"unicom\",\"operatorCodeSet\": \"46001,46006\"},{\"operatorName\": \"telecom\",\"operatorCodeSet\": \"46003,46005,46011\"}]}";

    public WkSDKConfig() {
    }

    public static String getCurrentCarNetType() {
        try {
            JSONObject networkType = AuthnHelper.getInstance(WkSDKManager.getContext()).getNetworkType(WkSDKManager.getContext());
            if (networkType == null) {
                return "unknown";
            }
            String strOptString = networkType.optString("operatortype", "0");
            String strOptString2 = networkType.optString("networktype", "0");
            if (!TextUtils.equals("0", strOptString) && !TextUtils.equals("0", strOptString2)) {
                if (TextUtils.equals("1", strOptString)) {
                    strOptString = "cmcc";
                } else if (TextUtils.equals("2", strOptString)) {
                    strOptString = "unicom";
                } else if (TextUtils.equals("3", strOptString)) {
                    strOptString = "telecom";
                }
                if (TextUtils.equals("1", strOptString2)) {
                    strOptString2 = "g";
                } else if (TextUtils.equals("2", strOptString2)) {
                    strOptString2 = RXScreenCaptureService.KEY_WIDTH;
                } else if (TextUtils.equals("3", strOptString2)) {
                    strOptString2 = "g";
                }
                return strOptString + ContainerUtils.FIELD_DELIMITER + strOptString2;
            }
            return "unknown";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getLoginTypeByNetOperator(JSONObject jSONObject, boolean z) {
        JSONArray jSONArrayOptJSONArray;
        LogUtil.d("sangxiang", "getLoginTypeByNetOperator(" + jSONObject + ")");
        JSONObject networkType = AuthnHelper.getInstance(WkSDKManager.getContext()).getNetworkType(WkSDKManager.getContext());
        if (networkType == null) {
            return 2;
        }
        String strOptString = networkType.optString("operatortype", "0");
        String strOptString2 = networkType.optString("networktype", "0");
        if (TextUtils.equals("0", strOptString) || TextUtils.equals("0", strOptString2)) {
            return 2;
        }
        if (TextUtils.equals("1", strOptString)) {
            strOptString = "cmcc";
        } else if (TextUtils.equals("2", strOptString)) {
            strOptString = "unicom";
        } else if (TextUtils.equals("3", strOptString)) {
            strOptString = "telecom";
        }
        if (!TextUtils.equals("1", strOptString2)) {
            if (TextUtils.equals("2", strOptString2)) {
                strOptString2 = RXScreenCaptureService.KEY_WIDTH;
            } else if (TextUtils.equals("3", strOptString2)) {
                strOptString2 = "g";
            }
        }
        String str = strOptString + ContainerUtils.FIELD_DELIMITER + strOptString2;
        BLLog.d("current is " + str, new Object[0]);
        String lowerCase = str.toLowerCase();
        int i = "unicom&g".equals(lowerCase) ? 4 : "cmcc&g".equals(lowerCase) ? 1 : "telecom&g".equals(lowerCase) ? 8 : 2;
        BLLog.d("final_loginType pre is " + i, new Object[0]);
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("login_type_list")) != null && jSONArrayOptJSONArray.length() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArrayOptJSONArray.length()) {
                    break;
                }
                try {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    String strOptString3 = jSONObject2.optString("login_type_set");
                    int iOptInt = jSONObject2.optInt("login_type", 0);
                    if (!TextUtils.isEmpty(strOptString3) && iOptInt != 0 && strOptString3.toLowerCase().contains(lowerCase)) {
                        i = iOptInt;
                        break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i2++;
            }
        }
        boolean zIsMobLoginOpen = LoginDhidConfig.isMobLoginOpen();
        LogUtil.d("sangxiang", "isMobOpen====》" + zIsMobLoginOpen);
        if (2 != i && zIsMobLoginOpen && z && 8 != i) {
            i = 16;
        }
        BLLog.d("final_loginType is " + i, new Object[0]);
        LogUtil.d("sangxiang", "返回的loginType====》" + i);
        return i;
    }

    private String getNetModel(Context context) {
        String networkType = WkPlatform.getNetworkType(context);
        return (TextUtils.isEmpty(networkType) || isMobileDataOpen(context)) ? "g" : networkType;
    }

    private String getOperator(String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                optString("operator");
                jSONObject = new JSONObject((TextUtils.isEmpty(null) ? NET_OPERATOR : null).replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", ""));
            } catch (Exception unused) {
                jSONObject = new JSONObject(NET_OPERATOR);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("operator");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    String strOptString = jSONObject2.optString("operatorName");
                    if (strOptString == null) {
                        strOptString = "";
                    }
                    String strOptString2 = jSONObject2.optString("operatorCodeSet");
                    if (strOptString2 != null && strOptString2.contains(str)) {
                        return strOptString;
                    }
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean isMobileDataOpen(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean canUplink(String str) {
        return PermissionManager.hanAllPermissions() && getLoginTypeByFilter(str, true) != 2;
    }

    public long getCMCCTimeout() {
        return optLong("cmccTimeout", 8000L);
    }

    public int getLoginTypeByFilter(String str, boolean z) {
        JSONObject jSONObjectOptJSONObject = optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        int loginTypeByNetOperator = getLoginTypeByNetOperator(jSONObjectOptJSONObject, z);
        BLLog.d("loginType " + loginTypeByNetOperator, new Object[0]);
        return loginTypeByNetOperator;
    }

    public boolean isAutoAuthorization() {
        return optInt("autoOauth", 2) == 1;
    }

    public boolean isNativeUI() {
        return optInt("nativeUI", 2) == 1;
    }

    public boolean isTimeValid() {
        return System.currentTimeMillis() - optLong("update_time", 0L) < optLong("expiresIn", 600000L);
    }

    public boolean needFresh() {
        return System.currentTimeMillis() - optLong("update_time", 0L) > optLong("fresh_space", 86400000L);
    }

    public WkSDKConfig(String str) throws JSONException {
        super(str);
    }

    public WkSDKConfig(Map map) {
        super(map);
    }
}
