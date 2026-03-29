package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ip extends it {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2914a;
    private String b;
    private hq e;
    private Object[] f;

    public ip(Context context, it itVar, hq hqVar, String str, Object... objArr) {
        super(itVar);
        this.f2914a = context;
        this.b = str;
        this.e = hqVar;
        this.f = objArr;
    }

    private String b() {
        try {
            return String.format(ge.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            hd.c(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.col.p0002sl.it
    public final byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        String strA = ge.a(bArr);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return ge.a("{\"pinfo\":\"" + ge.a(this.e.b(ge.a(b()))) + "\",\"els\":[" + strA + "]}");
    }
}
