package cn.jiguang.sdk.impl.dnssrv;

import defpackage.lt0;
import defpackage.nt0;
import defpackage.vk0;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class Name implements Comparable, Serializable {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 63;
    private static final int MAXLABELS = 128;
    private static final int MAXNAME = 255;
    private static final int MAXOFFSETS = 7;
    private static final DecimalFormat byteFormat;
    public static final Name empty;
    private static final byte[] lowercase;
    public static final Name root;
    private static final long serialVersionUID = -7257019940971525644L;
    private static final Name wild;
    private int hashcode;
    private byte[] name;
    private long offsets;
    private static final byte[] emptyLabel = {0};
    private static final byte[] wildLabel = {1, 42};

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        lowercase = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        int i = 0;
        while (true) {
            byte[] bArr = lowercase;
            if (i >= bArr.length) {
                Name name = new Name();
                root = name;
                name.appendSafe(emptyLabel, 0, 1);
                Name name2 = new Name();
                empty = name2;
                name2.name = new byte[0];
                Name name3 = new Name();
                wild = name3;
                name3.appendSafe(wildLabel, 0, 1);
                return;
            }
            if (i < 65 || i > 90) {
                bArr[i] = (byte) i;
            } else {
                bArr[i] = (byte) ((i - 65) + 97);
            }
            i++;
        }
    }

    private Name() {
    }

    private final void append(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = this.name;
        int length = bArr2 == null ? 0 : bArr2.length - offset(0);
        int i3 = i;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i3];
            if (i6 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i7 = i6 + 1;
            i3 += i7;
            i4 += i7;
        }
        int i8 = length + i4;
        if (i8 > 255) {
            throw new IOException();
        }
        int i9 = getlabels();
        int i10 = i9 + i2;
        if (i10 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i8];
        if (length != 0) {
            System.arraycopy(this.name, offset(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i, bArr3, length, i4);
        this.name = bArr3;
        for (int i11 = 0; i11 < i2; i11++) {
            setoffset(i9 + i11, length);
            length += bArr3[length] + 1;
        }
        setlabels(i10);
    }

    private final void appendFromString(String str, byte[] bArr, int i, int i2) throws IOException {
        try {
            append(bArr, i, i2);
        } catch (Exception unused) {
            throw parseException(str, "Name too long");
        }
    }

    private final void appendSafe(byte[] bArr, int i, int i2) {
        try {
            append(bArr, i, i2);
        } catch (Exception unused) {
        }
    }

    private String byteString(byte[] bArr, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i + 1;
        int i3 = bArr[i];
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            int i5 = bArr[i4] & UByte.MAX_VALUE;
            if (i5 <= 32 || i5 >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(byteFormat.format(i5));
            } else if (i5 == 34 || i5 == 40 || i5 == 41 || i5 == 46 || i5 == 59 || i5 == 92 || i5 == 64 || i5 == 36) {
                stringBuffer.append('\\');
                stringBuffer.append((char) i5);
            } else {
                stringBuffer.append((char) i5);
            }
        }
        return stringBuffer.toString();
    }

    public static Name concatenate(Name name, Name name2) throws IOException {
        if (name.isAbsolute()) {
            return name;
        }
        Name name3 = new Name();
        copy(name, name3);
        name3.append(name2.name, name2.offset(0), name2.getlabels());
        return name3;
    }

    private static final void copy(Name name, Name name2) {
        if (name.offset(0) == 0) {
            name2.name = name.name;
            name2.offsets = name.offsets;
            return;
        }
        int iOffset = name.offset(0);
        int length = name.name.length - iOffset;
        int iLabels = name.labels();
        byte[] bArr = new byte[length];
        name2.name = bArr;
        System.arraycopy(name.name, iOffset, bArr, 0, length);
        for (int i = 0; i < iLabels && i < 7; i++) {
            name2.setoffset(i, name.offset(i) - iOffset);
        }
        name2.setlabels(iLabels);
    }

    private final boolean equals(byte[] bArr, int i) {
        int iLabels = labels();
        int iOffset = offset(0);
        for (int i2 = 0; i2 < iLabels; i2++) {
            byte b = this.name[iOffset];
            if (b != bArr[i]) {
                return false;
            }
            iOffset++;
            i++;
            if (b > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i3 = 0;
            while (i3 < b) {
                byte[] bArr2 = lowercase;
                int i4 = iOffset + 1;
                int i5 = i + 1;
                if (bArr2[this.name[iOffset] & UByte.MAX_VALUE] != bArr2[bArr[i] & UByte.MAX_VALUE]) {
                    return false;
                }
                i3++;
                i = i5;
                iOffset = i4;
            }
        }
        return true;
    }

    public static Name fromString(String str, Name name) throws IOException {
        return (!str.equals("@") || name == null) ? str.equals(".") ? root : new Name(str, name) : name;
    }

    private final int getlabels() {
        return (int) (this.offsets & 255);
    }

    private final int offset(int i) {
        if (i == 0 && getlabels() == 0) {
            return 0;
        }
        if (i < 0 || i >= getlabels()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i < 7) {
            return ((int) (this.offsets >>> ((7 - i) * 8))) & 255;
        }
        int iOffset = offset(6);
        for (int i2 = 6; i2 < i; i2++) {
            iOffset += this.name[iOffset] + 1;
        }
        return iOffset;
    }

    private static IOException parseException(String str, String str2) {
        return new IOException("'" + str + "': " + str2);
    }

    private final void setlabels(int i) {
        this.offsets = (this.offsets & (-256)) | ((long) i);
    }

    private final void setoffset(int i, int i2) {
        if (i >= 7) {
            return;
        }
        int i3 = (7 - i) * 8;
        this.offsets = (((long) i2) << i3) | (this.offsets & (~(255 << i3)));
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        Name name = (Name) obj;
        if (this == name) {
            return 0;
        }
        int iLabels = labels();
        int iLabels2 = name.labels();
        int i = iLabels > iLabels2 ? iLabels2 : iLabels;
        for (int i2 = 1; i2 <= i; i2++) {
            int iOffset = offset(iLabels - i2);
            int iOffset2 = name.offset(iLabels2 - i2);
            byte b = this.name[iOffset];
            byte b2 = name.name[iOffset2];
            for (int i3 = 0; i3 < b && i3 < b2; i3++) {
                byte[] bArr = lowercase;
                int i4 = bArr[this.name[(i3 + iOffset) + 1] & UByte.MAX_VALUE] - bArr[name.name[(i3 + iOffset2) + 1] & UByte.MAX_VALUE];
                if (i4 != 0) {
                    return i4;
                }
            }
            if (b != b2) {
                return b - b2;
            }
        }
        return iLabels - iLabels2;
    }

    public int hashCode() {
        int i = this.hashcode;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        int iOffset = offset(0);
        while (true) {
            byte[] bArr = this.name;
            if (iOffset >= bArr.length) {
                this.hashcode = i2;
                return i2;
            }
            i2 += (i2 << 3) + lowercase[bArr[iOffset] & UByte.MAX_VALUE];
            iOffset++;
        }
    }

    public boolean isAbsolute() {
        int iLabels = labels();
        return iLabels != 0 && this.name[offset(iLabels - 1)] == 0;
    }

    public int labels() {
        return getlabels();
    }

    public short length() {
        if (getlabels() == 0) {
            return (short) 0;
        }
        return (short) (this.name.length - offset(0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        return r2.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString(boolean z) {
        int iLabels = labels();
        if (iLabels == 0) {
            return "@";
        }
        int i = 0;
        if (iLabels == 1 && this.name[offset(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int iOffset = offset(0);
        while (true) {
            if (i >= iLabels) {
                break;
            }
            byte b = this.name[iOffset];
            if (b > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b != 0) {
                if (i > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(byteString(this.name, iOffset));
                iOffset += b + 1;
                i++;
            } else if (!z) {
                stringBuffer.append('.');
            }
        }
    }

    public void toWire(nt0 nt0Var, vk0 vk0Var) {
        int iLabels = labels();
        int i = 0;
        while (i < iLabels - 1) {
            Name name = i == 0 ? this : new Name(this, i);
            int iB = vk0Var != null ? vk0Var.b(name) : -1;
            if (iB >= 0) {
                nt0Var.h(49152 | iB);
                return;
            }
            if (vk0Var != null) {
                vk0Var.a(nt0Var.b(), name);
            }
            int iOffset = offset(i);
            byte[] bArr = this.name;
            nt0Var.g(bArr, iOffset, bArr[iOffset] + 1);
            i++;
        }
        nt0Var.k(0);
    }

    public void toWireCanonical(nt0 nt0Var) {
        nt0Var.f(toWireCanonical());
    }

    public Name(String str, Name name) throws IOException {
        int i;
        boolean z;
        int i2;
        if (str.equals("")) {
            throw parseException(str, "empty name");
        }
        if (str.equals("@")) {
            if (name == null) {
                copy(empty, this);
                return;
            } else {
                copy(name, this);
                return;
            }
        }
        if (str.equals(".")) {
            copy(root, this);
            return;
        }
        byte[] bArr = new byte[64];
        int i3 = 0;
        boolean z2 = false;
        int i4 = -1;
        int i5 = 1;
        int i6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            byte bCharAt = (byte) str.charAt(i7);
            if (z2) {
                if (bCharAt >= 48 && bCharAt <= 57 && i3 < 3) {
                    i3++;
                    i6 = (i6 * 10) + (bCharAt - 48);
                    if (i6 > 255) {
                        throw parseException(str, "bad escape");
                    }
                    if (i3 < 3) {
                        continue;
                    } else {
                        bCharAt = (byte) i6;
                    }
                } else if (i3 > 0 && i3 < 3) {
                    throw parseException(str, "bad escape");
                }
                if (i5 > 63) {
                    throw parseException(str, "label too long");
                }
                i2 = i5 + 1;
                bArr[i5] = bCharAt;
                i4 = i5;
                z2 = false;
                i5 = i2;
            } else if (bCharAt == 92) {
                i3 = 0;
                z2 = true;
                i6 = 0;
            } else if (bCharAt != 46) {
                i4 = i4 == -1 ? i7 : i4;
                if (i5 > 63) {
                    throw parseException(str, "label too long");
                }
                i2 = i5 + 1;
                bArr[i5] = bCharAt;
                i5 = i2;
            } else {
                if (i4 == -1) {
                    throw parseException(str, "invalid empty label");
                }
                bArr[0] = (byte) (i5 - 1);
                appendFromString(str, bArr, 0, 1);
                i4 = -1;
                i5 = 1;
            }
        }
        if (i3 > 0 && i3 < 3) {
            throw parseException(str, "bad escape");
        }
        if (z2) {
            throw parseException(str, "bad escape");
        }
        if (i4 == -1) {
            z = true;
            i = 0;
            appendFromString(str, emptyLabel, 0, 1);
        } else {
            i = 0;
            bArr[0] = (byte) (i5 - 1);
            appendFromString(str, bArr, 0, 1);
            z = false;
        }
        if (name == null || z) {
            return;
        }
        appendFromString(str, name.name, name.offset(i), name.getlabels());
    }

    public byte[] toWireCanonical() {
        int iLabels = labels();
        if (iLabels == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.name.length - offset(0)];
        int iOffset = offset(0);
        int i = 0;
        for (int i2 = 0; i2 < iLabels; i2++) {
            byte b = this.name[iOffset];
            if (b <= 63) {
                iOffset++;
                bArr[i] = b;
                i++;
                int i3 = 0;
                while (i3 < b) {
                    bArr[i] = lowercase[this.name[iOffset] & UByte.MAX_VALUE];
                    i3++;
                    i++;
                    iOffset++;
                }
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        return bArr;
    }

    public static Name fromString(String str) throws IOException {
        return fromString(str, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        if (name.hashcode == 0) {
            name.hashCode();
        }
        if (this.hashcode == 0) {
            hashCode();
        }
        if (name.hashcode == this.hashcode && name.labels() == labels()) {
            return equals(name.name, name.offset(0));
        }
        return false;
    }

    public void toWire(nt0 nt0Var, vk0 vk0Var, boolean z) {
        if (z) {
            toWireCanonical(nt0Var);
        } else {
            toWire(nt0Var, vk0Var);
        }
    }

    public String toString() {
        return toString(false);
    }

    public Name(lt0 lt0Var) throws IOException {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int iG = lt0Var.g();
            int i = iG & 192;
            if (i != 0) {
                if (i == 192) {
                    int iG2 = lt0Var.g() + ((iG & (-193)) << 8);
                    if (iG2 < lt0Var.b() - 2) {
                        if (!z2) {
                            lt0Var.k();
                            z2 = true;
                        }
                        lt0Var.c(iG2);
                    } else {
                        throw new IOException("bad compression");
                    }
                } else {
                    throw new IOException("bad label type");
                }
            } else {
                if (getlabels() >= 128) {
                    throw new IOException("too many labels");
                }
                if (iG == 0) {
                    append(emptyLabel, 0, 1);
                    z = true;
                } else {
                    bArr[0] = (byte) iG;
                    lt0Var.d(bArr, 1, iG);
                    append(bArr, 0, 1);
                }
            }
        }
        if (z2) {
            lt0Var.j();
        }
    }

    public Name(byte[] bArr) throws IOException {
        this(new lt0(bArr));
    }

    public Name(Name name, int i) {
        int iLabels = name.labels();
        if (i <= iLabels) {
            this.name = name.name;
            int i2 = iLabels - i;
            setlabels(i2);
            for (int i3 = 0; i3 < 7 && i3 < i2; i3++) {
                setoffset(i3, name.offset(i3 + i));
            }
            return;
        }
        throw new IllegalArgumentException("attempted to remove too many labels");
    }
}
