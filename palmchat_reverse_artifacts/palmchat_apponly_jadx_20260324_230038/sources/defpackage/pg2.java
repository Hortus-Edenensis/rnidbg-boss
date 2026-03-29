package defpackage;

import java.io.Serializable;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class pg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f20010a = "0123456789abcdef".toCharArray();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends pg2 implements Serializable {
        private static final long serialVersionUID = 0;
        public final byte[] b;

        public a(byte[] bArr) {
            this.b = (byte[]) dm4.o(bArr);
        }

        @Override // defpackage.pg2
        public byte[] b() {
            return (byte[]) this.b.clone();
        }

        @Override // defpackage.pg2
        public int o() {
            byte[] bArr = this.b;
            dm4.v(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.b;
            return ((bArr2[3] & UByte.MAX_VALUE) << 24) | (bArr2[0] & UByte.MAX_VALUE) | ((bArr2[1] & UByte.MAX_VALUE) << 8) | ((bArr2[2] & UByte.MAX_VALUE) << 16);
        }

        @Override // defpackage.pg2
        public long p() {
            byte[] bArr = this.b;
            dm4.v(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return w();
        }

        @Override // defpackage.pg2
        public int s() {
            return this.b.length * 8;
        }

        @Override // defpackage.pg2
        public boolean t(pg2 pg2Var) {
            if (this.b.length != pg2Var.v().length) {
                return false;
            }
            int i = 0;
            boolean z = true;
            while (true) {
                byte[] bArr = this.b;
                if (i >= bArr.length) {
                    return z;
                }
                z &= bArr[i] == pg2Var.v()[i];
                i++;
            }
        }

        @Override // defpackage.pg2
        public byte[] v() {
            return this.b;
        }

        public long w() {
            long j = this.b[0] & UByte.MAX_VALUE;
            for (int i = 1; i < Math.min(this.b.length, 8); i++) {
                j |= (((long) this.b[i]) & 255) << (i * 8);
            }
            return j;
        }
    }

    public static pg2 u(byte[] bArr) {
        return new a(bArr);
    }

    public abstract byte[] b();

    public final boolean equals(Object obj) {
        if (!(obj instanceof pg2)) {
            return false;
        }
        pg2 pg2Var = (pg2) obj;
        return s() == pg2Var.s() && t(pg2Var);
    }

    public final int hashCode() {
        if (s() >= 32) {
            return o();
        }
        byte[] bArrV = v();
        int i = bArrV[0] & UByte.MAX_VALUE;
        for (int i2 = 1; i2 < bArrV.length; i2++) {
            i |= (bArrV[i2] & UByte.MAX_VALUE) << (i2 * 8);
        }
        return i;
    }

    public abstract int o();

    public abstract long p();

    public abstract int s();

    public abstract boolean t(pg2 pg2Var);

    public final String toString() {
        byte[] bArrV = v();
        StringBuilder sb = new StringBuilder(bArrV.length * 2);
        for (byte b : bArrV) {
            char[] cArr = f20010a;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    public byte[] v() {
        return b();
    }
}
