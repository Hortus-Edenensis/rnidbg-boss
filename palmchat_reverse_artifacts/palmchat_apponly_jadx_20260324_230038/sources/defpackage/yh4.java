package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yh4 {
    public static String a(String str) {
        String strL;
        if (TextUtils.isEmpty(str) || !str.startsWith("en_")) {
            strL = str;
        } else {
            strL = om1.f().l(str.substring(3));
        }
        LogUtil.i("PhoneEncryptUtil", "decrypt encrypt=" + str + " result =" + strL);
        return strL;
    }

    public static String b(String str) {
        String str2;
        String strM;
        if (TextUtils.isEmpty(str) || (strM = om1.f().m(str)) == null) {
            str2 = str;
        } else {
            str2 = "en_" + strM;
        }
        LogUtil.i("PhoneEncryptUtil", "encrypt content=" + str + " result =" + str2);
        return str2;
    }
}
