package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class yb7 implements nl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecretKey f22173a;
    public final c87 b;
    public boolean c = false;

    public yb7(c87 c87Var) {
        this.b = c87Var;
    }

    @Override // defpackage.nl2
    public String a(String str, String str2) {
        if (!this.c) {
            b();
        }
        if (this.f22173a != null && !TextUtils.isEmpty(str)) {
            try {
                return new String(jf7.b(this.f22173a, nh2.b(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e) {
                Log.e("AGC_LocalResource", "decrypt exception:" + e.getMessage());
            }
        }
        return str2;
    }

    public final void b() {
        try {
            this.f22173a = jf7.a(this.b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("AGC_LocalResource", "Exception when reading the 'K&I' for 'Config'.");
            this.f22173a = null;
        }
        this.c = true;
    }
}
