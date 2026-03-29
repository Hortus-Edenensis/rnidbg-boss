package com.amap.api.col.p0002sl;

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
public final class io extends it {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hq f2913a;

    public io() {
        this.f2913a = new hs();
    }

    @Override // com.amap.api.col.p0002sl.it
    public final byte[] a(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        return this.f2913a.b(bArr);
    }

    public io(it itVar) {
        super(itVar);
        this.f2913a = new hs();
    }
}
