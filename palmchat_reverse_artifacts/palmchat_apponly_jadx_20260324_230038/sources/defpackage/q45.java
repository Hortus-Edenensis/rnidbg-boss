package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class q45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20178a = "SecureX509SingleInstance";
    public static volatile r45 b;

    @SuppressLint({"NewApi"})
    public static r45 a(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        InputStream inputStreamOpen;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        wp0.b(context);
        if (b == null) {
            synchronized (q45.class) {
                if (b == null) {
                    try {
                        inputStreamOpen = zt.n(context);
                    } catch (RuntimeException unused) {
                        ga7.d(f20178a, "get files bks error");
                        inputStreamOpen = null;
                    }
                    if (inputStreamOpen == null) {
                        ga7.e(f20178a, "get assets bks");
                        inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        ga7.e(f20178a, "get files bks");
                    }
                    b = new r45(inputStreamOpen, "");
                }
            }
        }
        ga7.b(f20178a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return b;
    }
}
