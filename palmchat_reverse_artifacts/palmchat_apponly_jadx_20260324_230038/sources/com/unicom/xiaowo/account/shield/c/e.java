package com.unicom.xiaowo.account.shield.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e {
    public static byte[] a() {
        try {
            byte[] bArr = new byte[61400];
            int[] iArr = new int[15350];
            int length = 0;
            for (int i = 0; i < 4; i++) {
                int[] iArr2 = (int[]) com.unicom.xiaowo.account.shield.a.e.a(i);
                System.arraycopy(iArr2, 0, iArr, length, iArr2.length);
                length += iArr2.length;
            }
            byte[] bArrA = f.a(iArr);
            System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }
}
