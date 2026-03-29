package defpackage;

import com.lantern.auth.server.WkParams;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class z63 {
    public static boolean a(String str) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    public static boolean b(String str, String str2) {
        String strTrim;
        boolean z = false;
        try {
            strTrim = str.trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a(strTrim)) {
            if (str2.equals(WkParams.COUNTCODE)) {
                if (strTrim.length() == 11) {
                    z = true;
                }
            } else if (strTrim.length() > 0) {
                z = true;
            }
            return z;
        }
        return z;
    }
}
