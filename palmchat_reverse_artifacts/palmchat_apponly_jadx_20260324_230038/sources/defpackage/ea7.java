package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ea7 implements nl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zl0 f17251a;
    public SecretKey b;
    public boolean c = false;

    public ea7(zl0 zl0Var) {
        this.f17251a = zl0Var;
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    @Override // defpackage.nl2
    public String a(String str, String str2) {
        String str3;
        if (!this.c) {
            b();
        }
        if (this.b == null) {
            str3 = "mKey is null, return default value";
        } else {
            if (!c(str)) {
                return str2;
            }
            try {
                return new String(jf7.b(this.b, nh2.b(d(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
                str3 = "UnsupportedEncodingException||GeneralSecurityException||IllegalArgumentException";
            }
        }
        Log.e("AGC_Mark", str3);
        return str2;
    }

    public final void b() {
        try {
            this.b = jf7.a(new c87(this.f17251a.getString("/code/code1", null), this.f17251a.getString("/code/code2", null), this.f17251a.getString("/code/code3", null), this.f17251a.getString("/code/code4", null), "PBKDF2WithHmacSHA1", 10000));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("AGC_Mark", "Exception when reading the 'K&I' for 'Config'.");
            this.b = null;
        }
        this.c = true;
    }

    public final String d(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
            Log.e("AGC_Mark", "getRawString exception");
            return "";
        }
    }
}
