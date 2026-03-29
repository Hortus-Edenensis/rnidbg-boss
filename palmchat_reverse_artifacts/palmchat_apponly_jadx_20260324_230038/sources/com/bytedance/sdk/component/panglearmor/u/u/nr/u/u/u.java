package com.bytedance.sdk.component.panglearmor.u.u.nr.u.u;

import com.bytedance.sdk.component.panglearmor.u.nr.nr;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static com.bytedance.sdk.component.panglearmor.u.nr.u nr(ByteBuffer byteBuffer) throws Exception {
        ByteBuffer byteBufferU = com.bytedance.sdk.component.panglearmor.u.u.nr.u.u.u(byteBuffer);
        byteBufferU.get(new byte[byteBufferU.remaining()]);
        byteBufferU.flip();
        byteBufferU.position(0);
        com.bytedance.sdk.component.panglearmor.u.u.nr.u.u.u(byteBufferU);
        byte[] bArrNr = com.bytedance.sdk.component.panglearmor.u.u.nr.u.u.nr(com.bytedance.sdk.component.panglearmor.u.u.nr.u.u.u(byteBufferU));
        try {
            return new com.bytedance.sdk.component.panglearmor.u.nr.u(String.valueOf(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrNr))).getSubjectDN()), bArrNr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<com.bytedance.sdk.component.panglearmor.u.nr.u> u(nr nrVar, com.bytedance.sdk.component.panglearmor.u.u.fx.nr nrVar2) throws Exception {
        return u(com.bytedance.sdk.component.panglearmor.u.u.nr.u.u.u(nrVar, nrVar2, 1896449818).u);
    }

    public static List<com.bytedance.sdk.component.panglearmor.u.nr.u> u(ByteBuffer byteBuffer) {
        try {
            ByteBuffer byteBufferU = com.bytedance.sdk.component.panglearmor.u.u.nr.u.u.u(byteBuffer);
            if (!byteBufferU.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (byteBufferU.hasRemaining()) {
                try {
                    arrayList.add(nr(com.bytedance.sdk.component.panglearmor.u.u.nr.u.u.u(byteBufferU)));
                } catch (Exception unused) {
                    return null;
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }
}
