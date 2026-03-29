package com.bytedance.sdk.component.fx.u;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements Serializable, Comparable<iz> {
    transient int b;
    final byte[] fx;
    transient String pn;
    static final char[] u = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final iz nr = u(new byte[0]);

    public iz(byte[] bArr) {
        this.fx = bArr;
    }

    public static iz u(byte... bArr) {
        if (bArr != null) {
            return new iz((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public iz b() {
        return fx(com.huawei.openalliance.ad.constant.x.dW);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof iz) {
            iz izVar = (iz) obj;
            int iX = izVar.x();
            byte[] bArr = this.fx;
            if (iX == bArr.length && izVar.u(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public iz fx() {
        return fx("SHA-1");
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.fx);
        this.b = iHashCode;
        return iHashCode;
    }

    public iz iz() {
        int i = 0;
        while (true) {
            byte[] bArr = this.fx;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new iz(bArr2);
            }
            i++;
        }
    }

    public byte[] n() {
        return (byte[]) this.fx.clone();
    }

    public String nr() {
        return nr.u(this.fx);
    }

    public String pn() {
        byte[] bArr = this.fx;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = u;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public String toString() {
        if (this.fx.length == 0) {
            return "[size=0]";
        }
        String strU = u();
        int iU = u(strU, 64);
        if (iU == -1) {
            if (this.fx.length <= 64) {
                return "[hex=" + pn() + "]";
            }
            return "[size=" + this.fx.length + " hex=" + u(0, 64).pn() + "…]";
        }
        String strReplace = strU.substring(0, iU).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iU >= strU.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.fx.length + " text=" + strReplace + "…]";
    }

    public int x() {
        return this.fx.length;
    }

    private iz fx(String str) {
        try {
            return u(MessageDigest.getInstance(str).digest(this.fx));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static iz nr(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((u(str.charAt(i2)) << 4) + u(str.charAt(i2 + 1)));
        }
        return u(bArr);
    }

    public static iz u(String str) {
        if (str != null) {
            iz izVar = new iz(str.getBytes(dw.u));
            izVar.pn = str;
            return izVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String u() {
        String str = this.pn;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.fx, dw.u);
        this.pn = str2;
        return str2;
    }

    private static int u(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
            }
        }
        return (c - c2) + 10;
    }

    public iz u(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.fx;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.fx.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new iz(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public int compareTo(iz izVar) {
        int iX = x();
        int iX2 = izVar.x();
        int iMin = Math.min(iX, iX2);
        for (int i = 0; i < iMin; i++) {
            int iU = u(i) & UByte.MAX_VALUE;
            int iU2 = izVar.u(i) & UByte.MAX_VALUE;
            if (iU != iU2) {
                return iU < iU2 ? -1 : 1;
            }
        }
        if (iX == iX2) {
            return 0;
        }
        return iX < iX2 ? -1 : 1;
    }

    public byte u(int i) {
        return this.fx[i];
    }

    public void u(fx fxVar) {
        byte[] bArr = this.fx;
        fxVar.fx(bArr, 0, bArr.length);
    }

    public boolean u(int i, iz izVar, int i2, int i3) {
        return izVar.u(i2, this.fx, i, i3);
    }

    public boolean u(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.fx;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && dw.u(bArr2, i, bArr, i2, i3);
    }

    public final boolean u(iz izVar) {
        return u(0, izVar, 0, izVar.x());
    }

    public static int u(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
