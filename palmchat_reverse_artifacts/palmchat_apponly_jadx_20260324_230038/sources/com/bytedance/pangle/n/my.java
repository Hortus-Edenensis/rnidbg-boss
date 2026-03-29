package com.bytedance.pangle.n;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class my extends sx {
    private int nr;
    private final byte[] u;

    public my(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.nr = -1;
        this.u = bArr;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof my)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((my) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.n.sx, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.u;
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.nr == -1) {
            try {
                this.nr = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.nr = 0;
            }
        }
        return this.nr;
    }
}
