package com.bytedance.sdk.component.nr.u.nr;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements Serializable, Comparable<b> {
    final byte[] b;
    transient String iz;
    transient int pn;
    static final char[] u = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset nr = Charset.forName("UTF-8");
    public static final b fx = u(new byte[0]);

    public b(byte[] bArr) {
        this.b = bArr;
    }

    public static b u(byte... bArr) {
        if (bArr != null) {
            return new b((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public byte[] b() {
        return (byte[]) this.b.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int iFx = bVar.fx();
            byte[] bArr = this.b;
            if (iFx == bArr.length && bVar.u(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int fx() {
        return this.b.length;
    }

    public int hashCode() {
        int i = this.pn;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.b);
        this.pn = iHashCode;
        return iHashCode;
    }

    public String nr() {
        byte[] bArr = this.b;
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
        if (this.b.length == 0) {
            return "[size=0]";
        }
        String strU = u();
        int iU = u(strU, 64);
        if (iU == -1) {
            if (this.b.length <= 64) {
                return "[hex=" + nr() + "]";
            }
            return "[size=" + this.b.length + " hex=" + u(0, 64).nr() + "…]";
        }
        String strReplace = strU.substring(0, iU).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iU >= strU.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.b.length + " text=" + strReplace + "…]";
    }

    public String u() {
        String str = this.iz;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.b, nr);
        this.iz = str2;
        return str2;
    }

    public static b u(String str) {
        if (str != null) {
            b bVar = new b(str.getBytes(jk.u));
            bVar.iz = str;
            return bVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public b u(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.b;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.b.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new b(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte u(int i) {
        return this.b[i];
    }

    public boolean u(int i, b bVar, int i2, int i3) {
        return bVar.u(i2, this.b, i, i3);
    }

    public boolean u(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.b;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && jk.u(bArr2, i, bArr, i2, i3);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        int iFx = fx();
        int iFx2 = bVar.fx();
        int iMin = Math.min(iFx, iFx2);
        for (int i = 0; i < iMin; i++) {
            int iU = u(i) & UByte.MAX_VALUE;
            int iU2 = bVar.u(i) & UByte.MAX_VALUE;
            if (iU != iU2) {
                return iU < iU2 ? -1 : 1;
            }
        }
        if (iFx == iFx2) {
            return 0;
        }
        return iFx < iFx2 ? -1 : 1;
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
