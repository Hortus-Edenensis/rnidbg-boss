package com.lantern.core.network.utils;

import com.lantern.core.network.NEPBResponse;
import com.lantern.core.network.NEPublicMangers;
import com.lantern.core.network.NESecretKey;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NEPBUtils {
    private static final byte PV = 0;

    private static byte[] assembleBusiBytes(byte[] bArr, String[] strArr, byte[][] bArr2) {
        byte length = (byte) (bArr2.length + 1);
        int length2 = bArr.length + 5 + 0;
        for (byte[] bArr3 : bArr2) {
            length2 += bArr3.length + 8;
        }
        byte[] bArr4 = new byte[length2];
        bArr4[0] = length;
        byte[] bArrInt2byte = int2byte(bArr.length);
        System.arraycopy(bArrInt2byte, 0, bArr4, 1, bArrInt2byte.length);
        int length3 = 1 + bArrInt2byte.length;
        System.arraycopy(bArr, 0, bArr4, length3, bArr.length);
        int length4 = length3 + bArr.length;
        for (int i = 0; i < strArr.length; i++) {
            byte[] bArrInt2byte2 = int2byte(Integer.parseInt(strArr[i]));
            System.arraycopy(bArrInt2byte2, 0, bArr4, length4, bArrInt2byte2.length);
            int length5 = length4 + bArrInt2byte2.length;
            byte[] bArrInt2byte3 = int2byte(bArr2[i].length);
            System.arraycopy(bArrInt2byte3, 0, bArr4, length5, bArrInt2byte3.length);
            int length6 = length5 + bArrInt2byte3.length;
            byte[] bArr5 = bArr2[i];
            System.arraycopy(bArr5, 0, bArr4, length6, bArr5.length);
            length4 = length6 + bArr2[i].length;
        }
        return bArr4;
    }

    public static int byte2int(byte[] bArr) {
        return (bArr[3] & UByte.MAX_VALUE) | ((bArr[0] & UByte.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8);
    }

    private static byte[] compress(byte[] bArr) {
        try {
            return NEGZipUtils.compress(bArr);
        } catch (Exception unused) {
            return bArr;
        }
    }

    public static byte[] getRequest(String str, String str2, byte[] bArr) {
        return packageReqBytes(str, NEPublicMangers.getInstance().getSecurityParamsPBNew(str), NEPublicMangers.getInstance().getPublicParams(), new String[]{str2}, bArr);
    }

    public static NEPBResponse getResponse(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        if (byte2int(bArr2) != 0) {
            int length = bArr.length - 4;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, 4, bArr3, 0, length);
            return new NEPBResponse(-1, bArr3);
        }
        byte b = bArr[4];
        byte b2 = bArr[5];
        int length2 = bArr.length - 6;
        byte[] bArr4 = new byte[length2];
        System.arraycopy(bArr, 6, bArr4, 0, length2);
        byte[] bArrDecryptAES = NESecretKey.decryptAES(bArr4);
        NEPBResponse nEPBResponse = null;
        if (bArrDecryptAES == null || bArrDecryptAES.length == 0) {
            return new NEPBResponse(-2, null);
        }
        int i = 1;
        if (b == 1) {
            bArrDecryptAES = NEGZipUtils.unGZip(bArrDecryptAES);
        }
        if (bArrDecryptAES == null || bArrDecryptAES.length == 0) {
            return new NEPBResponse(-3, null);
        }
        byte b3 = bArrDecryptAES[0];
        for (int i2 = 0; i2 < b3; i2++) {
            System.arraycopy(bArrDecryptAES, i, new byte[4], 0, 4);
            int i3 = i + 4;
            byte[] bArr5 = new byte[4];
            System.arraycopy(bArrDecryptAES, i3, bArr5, 0, 4);
            int i4 = i3 + 4;
            int iByte2int = byte2int(bArr5);
            byte[] bArr6 = new byte[iByte2int];
            System.arraycopy(bArrDecryptAES, i4, bArr6, 0, iByte2int);
            i = i4 + iByte2int;
            nEPBResponse = new NEPBResponse(0, bArr6);
        }
        return nEPBResponse;
    }

    public static byte[] int2byte(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static byte[] packageReqBytes(String str, byte[] bArr, byte[] bArr2, String[] strArr, byte[]... bArr3) {
        return packageSecBusiBytes(bArr, NESecretKey.encryptAES(compress(assembleBusiBytes(bArr2, strArr, bArr3))));
    }

    private static byte[] packageSecBusiBytes(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + 5 + bArr2.length];
        bArr3[0] = 0;
        byte[] bArrInt2byte = int2byte(bArr.length);
        System.arraycopy(bArrInt2byte, 0, bArr3, 1, bArrInt2byte.length);
        int length = 1 + bArrInt2byte.length;
        System.arraycopy(bArr, 0, bArr3, length, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, length + bArr.length, bArr2.length);
        return bArr3;
    }
}
