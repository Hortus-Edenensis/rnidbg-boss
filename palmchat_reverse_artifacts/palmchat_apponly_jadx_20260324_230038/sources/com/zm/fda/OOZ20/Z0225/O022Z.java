package com.zm.fda.OOZ20.Z0225;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.be;
import com.zm.fda.Z0O00.O022Z;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f16639a = 0;

    public static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] b(byte[] bArr) {
        return ZZ00Z.a(bArr);
    }

    public static byte[] c(byte[] bArr) {
        return b(com.zm.fda.OOZ20.ZZ00Z.b(bArr, 1));
    }

    public static com.zm.fda.Z0O00.O022Z d(byte[] bArr) {
        byte[] bArrA = com.zm.fda.OOZ20.ZZ00Z.a(ZZ00Z.b(bArr), 1);
        if (bArrA == null) {
            return null;
        }
        String str = new String(bArrA);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new O022Z.ZZ00Z().a(jSONObject.optString(be.g)).a(jSONObject.getInt("code")).a(jSONObject.optLong("timestamp")).a();
            } catch (Exception e) {
                Log.e("NEPBUtils", "getResponseBean error", e);
            }
        }
        return null;
    }

    public static byte[] a(String str, byte[] bArr, byte[] bArr2, String[] strArr, byte[]... bArr3) {
        return a(bArr, com.zm.fda.OOZ20.ZZ00Z.b(b(a(bArr2, strArr, bArr3)), 0));
    }

    public static byte[] a(byte[] bArr, String[] strArr, byte[][] bArr2) {
        byte length = (byte) (bArr2.length + 1);
        int length2 = bArr.length + 5;
        for (byte[] bArr3 : bArr2) {
            length2 += bArr3.length + 8;
        }
        byte[] bArr4 = new byte[length2];
        bArr4[0] = length;
        byte[] bArrA = a(bArr.length);
        System.arraycopy(bArrA, 0, bArr4, 1, bArrA.length);
        int length3 = bArrA.length + 1;
        System.arraycopy(bArr, 0, bArr4, length3, bArr.length);
        int length4 = length3 + bArr.length;
        for (int i = 0; i < strArr.length; i++) {
            byte[] bArrA2 = a(Integer.parseInt(strArr[i]));
            System.arraycopy(bArrA2, 0, bArr4, length4, bArrA2.length);
            int length5 = length4 + bArrA2.length;
            byte[] bArrA3 = a(bArr2[i].length);
            System.arraycopy(bArrA3, 0, bArr4, length5, bArrA3.length);
            int length6 = length5 + bArrA3.length;
            byte[] bArr5 = bArr2[i];
            System.arraycopy(bArr5, 0, bArr4, length6, bArr5.length);
            length4 = length6 + bArr2[i].length;
        }
        return bArr4;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + 5 + bArr2.length];
        bArr3[0] = 0;
        byte[] bArrA = a(bArr.length);
        System.arraycopy(bArrA, 0, bArr3, 1, bArrA.length);
        int length = bArrA.length + 1;
        System.arraycopy(bArr, 0, bArr3, length, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, length + bArr.length, bArr2.length);
        return bArr3;
    }

    public static int a(byte[] bArr) {
        return (bArr[3] & UByte.MAX_VALUE) | ((bArr[0] & UByte.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8);
    }
}
