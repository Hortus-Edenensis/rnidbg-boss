package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pe7 {
    public static String a(ru6 ru6Var, Context context) {
        String strA = ff7.a(ru6Var, context, "pref_trade_token", "");
        w97.f("mspl", "get trade token: " + strA);
        return strA;
    }

    public static String b(String str) {
        String strSubstring = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(x.aQ);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].startsWith("result={") && strArrSplit[i].endsWith("}")) {
                String[] strArrSplit2 = strArrSplit[i].substring(8, r3.length() - 1).split(ContainerUtils.FIELD_DELIMITER);
                int i2 = 0;
                while (true) {
                    if (i2 >= strArrSplit2.length) {
                        break;
                    }
                    if (strArrSplit2[i2].startsWith("trade_token=\"") && strArrSplit2[i2].endsWith("\"")) {
                        strSubstring = strArrSplit2[i2].substring(13, r1.length() - 1);
                        break;
                    }
                    if (strArrSplit2[i2].startsWith("trade_token=")) {
                        strSubstring = strArrSplit2[i2].substring(12);
                        break;
                    }
                    i2++;
                }
            }
        }
        return strSubstring;
    }

    public static void c(ru6 ru6Var, Context context, String str) {
        try {
            String strB = b(str);
            w97.f("mspl", "trade token: " + strB);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            ff7.c(ru6Var, context, "pref_trade_token", strB);
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "SaveTradeTokenError", th);
            w97.d(th);
        }
    }
}
