package com.cdo.oaps.ad;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f5454a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static int a(char c, int i) throws d {
        int iDigit = Character.digit(c, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new d("Illegal hexadecimal charcter " + c + " at index " + i);
    }

    public Object b(Object obj) throws e {
        try {
            return a(obj instanceof String ? ((String) obj).getBytes() : (byte[]) obj);
        } catch (ClassCastException e) {
            throw new e(e.getMessage());
        }
    }

    public byte[] c(byte[] bArr) {
        return new String(a(bArr)).getBytes();
    }

    public Object a(Object obj) throws d {
        try {
            return a(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e) {
            throw new d(e.getMessage());
        }
    }

    public byte[] b(byte[] bArr) {
        return a(new String(bArr).toCharArray());
    }

    public static byte[] a(char[] cArr) throws d {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new d("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int iA = a(cArr[i], i) << 4;
            int i3 = i + 1;
            int iA2 = iA | a(cArr[i3], i3);
            i = i3 + 1;
            bArr[i2] = (byte) (iA2 & 255);
            i2++;
        }
        return bArr;
    }

    public static char[] a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f5454a;
            cArr[i] = cArr2[(b & 240) >>> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return cArr;
    }
}
