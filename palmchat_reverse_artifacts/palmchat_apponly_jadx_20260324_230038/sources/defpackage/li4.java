package defpackage;

import com.oplus.tblplayer.Constants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class li4 {
    public static String a(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c > 127) {
                try {
                    sb.append(oi4.d(c).toCharArray()[0]);
                } catch (Exception unused) {
                    sb.append(Constants.STRING_VALUE_UNSET);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        try {
            return oi4.e(str, "");
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.STRING_VALUE_UNSET;
        }
    }
}
