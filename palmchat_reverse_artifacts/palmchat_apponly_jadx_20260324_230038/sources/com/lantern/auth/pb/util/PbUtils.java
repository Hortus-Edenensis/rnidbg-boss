package com.lantern.auth.pb.util;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.lantern.auth.android.BLPlatform;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLLog;
import com.lantern.auth.http.HttpSign;
import com.lantern.auth.pb.PBResponse;
import com.lantern.auth.pb.pb_client.ProtobufRequestBeanOuterClass;
import com.lantern.auth.pb.pb_client.SecurityParameterOuterClass;
import com.lantern.auth.server.WkPlatform;
import com.lantern.auth.server.WkSecretKey;
import com.zenmen.palmchat.privinfo.PrivInfoManager;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PbUtils {
    private static final String BAD_CHAR_PATTERN = "\u0000|\u0001|\u0002|\u0003|\u0004|\u0005|\u0006|\u0007";
    private static final String BAD_MAC = "\u0000\u0000:\u0000\u0000:\u0000\u0000:\u0000\u0000:\u0000\u0000:\u0000\u0000";
    private static final String BAD_MAC_REPLACE = "00:00:00:00:00:00";
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

    public static String checkBSSID(String str) {
        return (BAD_MAC.equals(str) || BAD_MAC_REPLACE.equals(str)) ? "" : str;
    }

    public static String checkSSID(String str) {
        String strRemoveDoubleQuotes = removeDoubleQuotes(str);
        return isBadSSID(strRemoveDoubleQuotes) ? "" : strRemoveDoubleQuotes.replaceAll(BAD_CHAR_PATTERN, "*");
    }

    private static byte[] compress(byte[] bArr) {
        try {
            return PbGZipUtils.compress(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return bArr;
        }
    }

    public static byte[] getPublicParamsPBNew() {
        ProtobufRequestBeanOuterClass.ProtobufRequestBean.Builder builderNewBuilder = ProtobufRequestBeanOuterClass.ProtobufRequestBean.newBuilder();
        Context context = WkSDKManager.getContext();
        builderNewBuilder.setAppId(WkSDKManager.getSign().mAppId);
        builderNewBuilder.setLang(WkPlatform.getLang());
        builderNewBuilder.setVerCode(String.valueOf(BLPlatform.getAppVersionCode(context)));
        builderNewBuilder.setVerName(BLPlatform.getAppVersionName(context));
        builderNewBuilder.setChanId(WkSDKManager.getChannel());
        builderNewBuilder.setImei("");
        builderNewBuilder.setMac("");
        if (WkSDKManager.getDeviceId() != null) {
            builderNewBuilder.setDhid(WkSDKManager.getDeviceId());
        }
        builderNewBuilder.setNetModel(PrivInfoManager.INSTANCE.getNetworkType());
        builderNewBuilder.setCapBssid("");
        builderNewBuilder.setCapSsid("");
        builderNewBuilder.setTs(System.currentTimeMillis() + "");
        return builderNewBuilder.build().toByteArray();
    }

    public static byte[] getRequest(String str, byte[] bArr) {
        return packageReqBytes(getSecurityParamsPBNew(), getPublicParamsPBNew(), new String[]{str}, bArr);
    }

    public static PBResponse getResponse(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        if (byte2int(bArr2) != 0) {
            int length = bArr.length - 4;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, 4, bArr3, 0, length);
            return new PBResponse(-1, bArr3);
        }
        byte b = bArr[4];
        byte b2 = bArr[5];
        int length2 = bArr.length - 6;
        byte[] bArr4 = new byte[length2];
        System.arraycopy(bArr, 6, bArr4, 0, length2);
        byte[] bArrDecryptAES = WkSecretKey.decryptAES(bArr4, WkSDKManager.getSign().mAESKey, WkSDKManager.getSign().mAESIV);
        PBResponse pBResponse = null;
        if (bArrDecryptAES == null || bArrDecryptAES.length == 0) {
            return new PBResponse(-2, null);
        }
        int i = 1;
        if (b == 1) {
            bArrDecryptAES = PbGZipUtils.unGZip(bArrDecryptAES);
        }
        if (bArrDecryptAES == null || bArrDecryptAES.length == 0) {
            return new PBResponse(-3, null);
        }
        byte b3 = bArrDecryptAES[0];
        for (int i2 = 0; i2 < b3; i2++) {
            byte[] bArr5 = new byte[4];
            System.arraycopy(bArrDecryptAES, i, bArr5, 0, 4);
            int i3 = i + 4;
            byte[] bArr6 = new byte[4];
            System.arraycopy(bArrDecryptAES, i3, bArr6, 0, 4);
            int i4 = i3 + 4;
            int iByte2int = byte2int(bArr6);
            byte[] bArr7 = new byte[iByte2int];
            System.arraycopy(bArrDecryptAES, i4, bArr7, 0, iByte2int);
            i = i4 + iByte2int;
            BLLog.i("response pid:" + byte2int(bArr5));
            pBResponse = new PBResponse(0, bArr7);
        }
        return pBResponse;
    }

    public static byte[] getSecurityParamsPBNew() {
        SecurityParameterOuterClass.SecurityParameter.Builder builderNewBuilder = SecurityParameterOuterClass.SecurityParameter.newBuilder();
        Context context = WkSDKManager.getContext();
        builderNewBuilder.setAppId(WkSDKManager.getSign().mAppId);
        if (WkSDKManager.getDeviceId() != null) {
            builderNewBuilder.setDhid(WkSDKManager.getDeviceId());
        }
        builderNewBuilder.setChanId(WkSDKManager.getChannel());
        builderNewBuilder.setLang(WkPlatform.getLang());
        builderNewBuilder.setImei("");
        builderNewBuilder.setEt("a");
        builderNewBuilder.setVerCode(String.valueOf(BLPlatform.getAppVersionCode(context)));
        return builderNewBuilder.build().toByteArray();
    }

    private static byte[] int2byte(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static boolean isBadSSID(String str) {
        return TextUtils.isEmpty(str) || str.startsWith("0x") || str.startsWith("0X") || str.equalsIgnoreCase("<unknown ssid>") || str.equalsIgnoreCase(b.m);
    }

    private static byte[] packageReqBytes(byte[] bArr, byte[] bArr2, String[] strArr, byte[]... bArr3) {
        byte[] bArrCompress = compress(assembleBusiBytes(bArr2, strArr, bArr3));
        HttpSign sign = WkSDKManager.getSign();
        return packageSecBusiBytes(bArr, WkSecretKey.encryptAES(bArrCompress, sign.mAESKey, sign.mAESIV));
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

    private static String removeDoubleQuotes(String str) {
        int length;
        if (TextUtils.isEmpty(str) || (length = str.length()) <= 1 || str.charAt(0) != '\"') {
            return str;
        }
        int i = length - 1;
        return str.charAt(i) == '\"' ? str.substring(1, i) : str;
    }
}
