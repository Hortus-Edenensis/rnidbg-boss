package com.opos.exoplayer.core.extractor.mp4;

import com.opos.exoplayer.core.util.p;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UUID f8205a;
        private final int b;
        private final byte[] c;

        public a(UUID uuid, int i, byte[] bArr) {
            this.f8205a = uuid;
            this.b = i;
            this.c = bArr;
        }
    }

    public static UUID a(byte[] bArr) {
        a aVarC = c(bArr);
        if (aVarC == null) {
            return null;
        }
        return aVarC.f8205a;
    }

    public static int b(byte[] bArr) {
        a aVarC = c(bArr);
        if (aVarC == null) {
            return -1;
        }
        return aVarC.b;
    }

    private static a c(byte[] bArr) {
        p pVar = new p(bArr);
        if (pVar.c() < 32) {
            return null;
        }
        pVar.c(0);
        if (pVar.o() != pVar.b() + 4 || pVar.o() != d.U) {
            return null;
        }
        int iA = d.a(pVar.o());
        if (iA > 1) {
            com.opos.cmn.an.f.a.c("PsshAtomUtil", "Unsupported pssh version: " + iA);
            return null;
        }
        UUID uuid = new UUID(pVar.q(), pVar.q());
        if (iA == 1) {
            pVar.d(pVar.u() * 16);
        }
        int iU = pVar.u();
        if (iU != pVar.b()) {
            return null;
        }
        byte[] bArr2 = new byte[iU];
        pVar.a(bArr2, 0, iU);
        return new a(uuid, iA, bArr2);
    }

    public static byte[] a(byte[] bArr, UUID uuid) {
        a aVarC = c(bArr);
        if (aVarC == null) {
            return null;
        }
        if (uuid == null || uuid.equals(aVarC.f8205a)) {
            return aVarC.c;
        }
        com.opos.cmn.an.f.a.c("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + aVarC.f8205a + ".");
        return null;
    }
}
