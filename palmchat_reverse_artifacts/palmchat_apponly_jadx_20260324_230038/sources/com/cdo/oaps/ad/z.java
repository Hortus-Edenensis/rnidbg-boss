package com.cdo.oaps.ad;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class z {
    private static String a(long j, String str, int i, String str2, String str3, String str4, int i2) {
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str5 = "";
        } else {
            str5 = "^out_match_type#" + str4;
        }
        sb.append(str5);
        return Uri.encode("out_package_name=" + str + ContainerUtils.FIELD_DELIMITER + "out_pid" + ContainerUtils.KEY_VALUE_DELIMITER + j + ContainerUtils.FIELD_DELIMITER + "out_operator_type" + ContainerUtils.KEY_VALUE_DELIMITER + i + ContainerUtils.FIELD_DELIMITER + "out_intent_from" + ContainerUtils.KEY_VALUE_DELIMITER + i2 + ContainerUtils.FIELD_DELIMITER + "enter_id" + ContainerUtils.KEY_VALUE_DELIMITER + str2 + ContainerUtils.FIELD_DELIMITER + "enter_params" + ContainerUtils.KEY_VALUE_DELIMITER + sb.toString());
    }

    private static String a(long j, String str, boolean z, String str2, String str3, String str4, int i, String str5) {
        String str6;
        String str7 = "Ext-Module#" + str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str4;
        }
        sb.append(str6);
        return Uri.encode("out_pid=" + j + ContainerUtils.FIELD_DELIMITER + "out_package_name" + ContainerUtils.KEY_VALUE_DELIMITER + str + ContainerUtils.FIELD_DELIMITER + "out_start_download" + ContainerUtils.KEY_VALUE_DELIMITER + z + ContainerUtils.FIELD_DELIMITER + "out_intent_from" + ContainerUtils.KEY_VALUE_DELIMITER + i + ContainerUtils.FIELD_DELIMITER + "enter_id" + ContainerUtils.KEY_VALUE_DELIMITER + str2 + ContainerUtils.FIELD_DELIMITER + "enter_params" + ContainerUtils.KEY_VALUE_DELIMITER + sb.toString() + ContainerUtils.FIELD_DELIMITER + "cpd_params" + ContainerUtils.KEY_VALUE_DELIMITER + str7);
    }

    public static String a(Context context, long j, String str, int i, String str2, String str3, String str4, int i2) {
        return "softmarket://market_pre_download?params=" + a(j, str, i, str2, str3, str4, i2);
    }

    public static String a(Context context, long j, String str, boolean z, boolean z2, String str2, String str3, String str4, int i, String str5) {
        return "softmarket://market_appdetail?params=" + a(j, str, z, str2, str3, str4, i, str5) + ContainerUtils.FIELD_DELIMITER + y.f + ContainerUtils.KEY_VALUE_DELIMITER + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z) {
        return "softmarket://market_mainmenu?params=" + a(str, str2) + ContainerUtils.FIELD_DELIMITER + y.f + ContainerUtils.KEY_VALUE_DELIMITER + (z ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, int i) {
        return "softmarket://market_search_result?params=" + a(str, str2, z, str3, str4, str5, i) + ContainerUtils.FIELD_DELIMITER + y.f + ContainerUtils.KEY_VALUE_DELIMITER + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, boolean z, String str2, String str3, String str4, int i, String str5) {
        return "softmarket://market_latestact?params=" + a(str, str2, str3, str4, i, str4) + ContainerUtils.FIELD_DELIMITER + y.f + ContainerUtils.KEY_VALUE_DELIMITER + (z ? 1 : 0);
    }

    private static String a(String str, String str2) {
        return Uri.encode("enter_id=" + str + ContainerUtils.FIELD_DELIMITER + "enter_params" + ContainerUtils.KEY_VALUE_DELIMITER + ("out_operator#" + str2));
    }

    public static String a(String str, String str2, String str3, String str4, int i, String str5) {
        String str6;
        String str7 = "Ext-Module#" + str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str4;
        }
        sb.append(str6);
        return Uri.encode("url=" + str + ContainerUtils.FIELD_DELIMITER + "out_intent_from" + ContainerUtils.KEY_VALUE_DELIMITER + i + ContainerUtils.FIELD_DELIMITER + "enter_id" + ContainerUtils.KEY_VALUE_DELIMITER + str2 + ContainerUtils.FIELD_DELIMITER + "enter_params" + ContainerUtils.KEY_VALUE_DELIMITER + sb.toString() + ContainerUtils.FIELD_DELIMITER + "cpd_params" + ContainerUtils.KEY_VALUE_DELIMITER + str7);
    }

    private static String a(String str, String str2, boolean z, String str3, String str4, String str5, int i) {
        String str6;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str4);
        if (ab.a(str5)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str5;
        }
        sb.append(str6);
        return Uri.encode("out_package_name=" + str2 + ContainerUtils.FIELD_DELIMITER + "out_app_name" + ContainerUtils.KEY_VALUE_DELIMITER + str + ContainerUtils.FIELD_DELIMITER + "out_operator" + ContainerUtils.KEY_VALUE_DELIMITER + str4 + ContainerUtils.FIELD_DELIMITER + "out_start_download" + ContainerUtils.KEY_VALUE_DELIMITER + z + ContainerUtils.FIELD_DELIMITER + "out_intent_from" + ContainerUtils.KEY_VALUE_DELIMITER + i + ContainerUtils.FIELD_DELIMITER + "enter_id" + ContainerUtils.KEY_VALUE_DELIMITER + str3 + ContainerUtils.FIELD_DELIMITER + "enter_params" + ContainerUtils.KEY_VALUE_DELIMITER + sb.toString());
    }
}
