package com.lantern.auth.app;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.openapi.BuildInfo;
import com.lantern.auth.server.WkPlatform;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import defpackage.zn6;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FunDC {
    public static String AUTH_FAIL = "authfa";
    public static String AUTH_FUNID_BASE = "_opensdk_login";
    public static String AUTH_FUNID_NETERR = "sdk_auth_neterr";
    public static String AUTH_FUNID_WEB_ERR = "sdk_auth_web_err";
    public static String AUTH_LOAD_ERR = "authle";
    public static String AUTH_NATVIE_CANCEL = "authnatcancel";
    public static String AUTH_OK = "authok";
    public static String AUTH_REQ_FAIL = "authreqfa";
    public static String AUTH_REQ_SUC = "authreqsuc";
    public static String AUTH_START = "auths";
    public static String AUTH_START_I = "authsi";
    public static String AUTH_START_L = "authl";
    public static String AUTH_START_NO = "authsn";
    public static String AUTH_START_NOIN = "authsni";
    public static String AUTH_SUC = "authsuc";
    public static final int ID_AUTH_1004 = 1004;
    public static final int ID_AUTH_1005 = 1005;
    public static final int ID_AUTH_1006 = 1006;
    public static final int ID_AUTH_1007 = 1007;
    public static final int ID_AUTH_1008 = 1008;
    public static final int ID_AUTH_1009 = 1009;
    public static final int ID_AUTH_1010 = 1010;
    public static final int ID_AUTH_1011 = 1011;
    public static final int ID_AUTH_1012 = 1012;
    public static final int ID_AUTH_1013 = 1013;
    public static final int ID_AUTH_1014 = 1014;
    public static final int ID_AUTH_1015 = 1015;
    public static final int ID_AUTH_1016 = 1016;
    public static final int ID_AUTH_1017 = 1017;
    public static final int ID_AUTH_1018 = 1018;
    public static final int ID_AUTH_1019 = 1019;
    public static final int ID_AUTH_1020 = 1020;
    public static final int ID_AUTH_1021 = 1021;
    public static final int ID_AUTH_1022 = 1022;
    public static final int ID_AUTH_1023 = 1023;
    public static final int ID_AUTH_1024 = 1024;
    public static final int ID_AUTH_1025 = 1025;
    public static final int ID_AUTH_1026 = 1026;
    public static final int ID_AUTH_1027 = 1027;
    public static final int ID_AUTH_1028 = 1028;
    public static final int ID_AUTH_1029 = 1029;
    public static final int ID_AUTH_1030 = 1030;
    public static final int ID_AUTH_1031 = 1031;
    public static final int ID_AUTH_1032 = 1032;
    public static final int ID_AUTH_1033 = 1033;
    public static final int ID_AUTH_1034 = 1034;
    public static final int ID_AUTH_1038 = 1038;
    public static final int ID_AUTH_1039 = 1039;
    public static final int ID_AUTH_1040 = 1040;
    public static final int ID_AUTH_1041 = 1041;
    public static final int ID_AUTH_1042 = 1042;
    public static final int ID_AUTH_1043 = 1043;
    public static final int ID_AUTH_1044 = 1044;
    public static final int ID_AUTH_1045 = 1045;
    public static final int ID_AUTH_1046 = 1046;
    public static final int ID_AUTH_1047 = 1047;
    public static final int ID_AUTH_1048 = 1048;
    public static final int ID_AUTH_1049 = 1049;
    public static final int ID_AUTH_1050 = 1050;
    public static final int ID_AUTH_1051 = 1051;
    public static final int ID_AUTH_1052 = 1052;
    public static final int ID_AUTH_1053 = 1053;
    public static final int ID_AUTH_1054 = 1054;
    public static final int ID_AUTH_1055 = 1055;
    public static final int ID_AUTH_1056 = 1056;
    public static final int ID_AUTH_1057 = 1057;
    public static final int ID_AUTH_1058 = 1058;
    public static final int ID_AUTH_1059 = 1059;
    public static final int ID_AUTH_1060 = 1060;
    public static final int ID_AUTH_1061 = 1061;
    public static final int ID_AUTH_1062 = 1062;
    public static final int ID_AUTH_1063 = 1063;
    public static final int ID_AUTH_1064 = 1064;
    public static final int ID_AUTH_1065 = 1065;
    public static final int ID_AUTH_1066 = 1066;
    public static final int ID_AUTH_1067 = 1067;
    public static final int ID_AUTH_1068 = 1068;
    public static final int ID_AUTH_1069 = 1069;
    public static final int ID_AUTH_1070 = 1070;
    public static final int ID_AUTH_1071 = 1071;
    public static final int ID_AUTH_1072 = 1072;
    public static final int ID_AUTH_1073 = 1073;
    public static final int ID_AUTH_1074 = 1074;
    public static final int ID_AUTH_1075 = 1075;
    public static final int ID_AUTH_1076 = 1076;
    public static final int ID_AUTH_1077 = 1077;
    public static final int ID_AUTH_1078 = 1078;
    public static final int ID_AUTH_1079 = 1079;
    public static final int ID_AUTH_1080 = 1080;
    public static final int ID_AUTH_1081 = 1081;
    public static final int ID_AUTH_1082 = 1082;
    public static final int ID_AUTH_1083 = 1083;
    public static final int ID_AUTH_1084 = 1084;
    public static final int ID_AUTH_1085 = 1085;
    public static final int ID_AUTH_1086 = 1086;
    public static final int ID_AUTH_1087 = 1087;
    public static boolean isMDA = true;

    public static HashMap<String, String> genExt(String str, String str2) {
        HashMap<String, String> netInfo = getNetInfo(WkSDKManager.getContext());
        if (!TextUtils.isEmpty(str) && str2 != null) {
            netInfo.put(str, str2);
        }
        netInfo.put("ver", BuildInfo.VERSION);
        netInfo.put("ot_ver", "MOB-3.4.0");
        return netInfo;
    }

    public static HashMap<String, String> getNetInfo(Context context) {
        HashMap<String, String> map = new HashMap<>();
        map.put("netOperator", PrivInfoManager.INSTANCE.getDefaultNetworkOperator());
        String networkType = WkPlatform.getNetworkType(context);
        if (!TextUtils.isEmpty(networkType) && RXScreenCaptureService.KEY_WIDTH.equals(networkType) && AuthUtils.isMobileDataOpen(context)) {
            networkType = "wg";
        }
        map.put("netModel", networkType);
        return map;
    }

    public static boolean isMDA() {
        return isMDA;
    }

    public static void onEvent(String str) {
        try {
            onEvent(str, genExt(null, null));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onEventById(int i) {
        BLLog.d("id is " + i, new Object[0]);
        HashMap<String, String> mapGenExt = genExt(null, null);
        mapGenExt.put("fun_id", i + "");
        onEvent(AUTH_FUNID_BASE, mapGenExt);
    }

    public static void onEventByType(int i, int i2) {
        onEventById(i, "loginType", i2 + "");
    }

    public static void onEvent(String str, Map<String, String> map) {
        try {
            map.put("deviceID", TextUtils.isEmpty(WkSDKManager.getDeviceId()) ? "empty" : WkSDKManager.getDeviceId());
            if (!AUTH_FUNID_BASE.equals(str)) {
                map.put("fun_id", str);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject = new JSONObject(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str2 = AUTH_FUNID_BASE;
            BLLog.d(String.format("funid %s ext %s", str2, jSONObject.toString()), new Object[0]);
            zn6.g(str2, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onEventById(int i, HashMap<String, String> map) {
        BLLog.d("id is " + i, new Object[0]);
        map.put("fun_id", i + "");
        onEvent(AUTH_FUNID_BASE, map);
    }

    public static void onEventById(int i, String str, String str2) {
        BLLog.d("id is " + i, new Object[0]);
        HashMap<String, String> mapGenExt = genExt(str, str2);
        mapGenExt.put("fun_id", i + "");
        onEvent(AUTH_FUNID_BASE, mapGenExt);
    }
}
