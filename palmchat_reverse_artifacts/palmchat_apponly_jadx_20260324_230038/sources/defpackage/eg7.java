package defpackage;

import com.alipay.sdk.m.j.c;
import com.huawei.openalliance.ad.constant.x;
import com.oplus.tblplayer.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class eg7 {
    public static String a(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("(^|;)" + str2 + "=\\{([^}]*?)\\}").matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (Throwable th) {
            w97.d(th);
        }
        return Constants.STRING_VALUE_UNSET;
    }

    public static Map<String, String> b() {
        c cVarB = c.b(c.CANCELED.b());
        HashMap map = new HashMap();
        map.put("resultStatus", Integer.toString(cVarB.b()));
        map.put("memo", cVarB.a());
        map.put("result", "");
        return map;
    }

    public static Map<String, String> c(ru6 ru6Var, String str) {
        Map<String, String> mapB = b();
        try {
            return d(str);
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "FormatResultEx", th);
            return mapB;
        }
    }

    public static Map<String, String> d(String str) {
        String[] strArrSplit = str.split(x.aQ);
        HashMap map = new HashMap();
        for (String str2 : strArrSplit) {
            String strSubstring = str2.substring(0, str2.indexOf("={"));
            map.put(strSubstring, e(str2, strSubstring));
        }
        return map;
    }

    public static String e(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }
}
