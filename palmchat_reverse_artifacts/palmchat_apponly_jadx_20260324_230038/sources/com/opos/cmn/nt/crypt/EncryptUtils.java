package com.opos.cmn.nt.crypt;

import android.text.TextUtils;
import android.util.Base64;
import com.opos.cmn.an.f.a;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class EncryptUtils {
    public static final int DECRYPT_SCENES_ID_OF_OBTAIN_PHONE_NUMBER = 1;
    private static final byte[] DEFAULT_BYTE_DATA = new byte[0];
    private static final String DEFAULT_DATA = "";
    public static final int ENCRYPT_SCENES_ID_OF_ST = 0;
    public static final int SCENES_ID_OF_LOCAL_DATA = 0;
    public static final int SCENES_ID_OF_NET_DATA = 1;
    private static volatile boolean SO_ENABLED = false;
    private static final String TAG = "EncryptUtils";

    static {
        try {
            System.loadLibrary("ads-c");
            SO_ENABLED = true;
        } catch (Throwable th) {
            SO_ENABLED = false;
            a.c("EncryptUtils", "so error:", th);
        }
    }

    private static final byte[] decodeBase64(String str) {
        byte[] bArr = DEFAULT_BYTE_DATA;
        if (TextUtils.isEmpty(str)) {
            return bArr;
        }
        try {
            return Base64.decode(str.getBytes(StandardCharsets.UTF_8), 2);
        } catch (Exception e) {
            a.c("EncryptUtils", "decodeBase64", e);
            return bArr;
        }
    }

    private static final native byte[] decryptByScenesId(byte[] bArr, int i);

    private static final native byte[] decryptBytesV3(byte[] bArr, int i);

    private static final String encodeBase64(byte[] bArr) {
        if (bArr != null) {
            try {
                return Base64.encodeToString(bArr, 2);
            } catch (Exception e) {
                a.c("EncryptUtils", "encodeBase64", e);
            }
        }
        return "";
    }

    private static final native byte[] encryptByScenesId(byte[] bArr, int i);

    private static final native byte[] encryptBytesV3(byte[] bArr, int i);

    @Deprecated
    public static final String executeDecrypt(String str) {
        return executeDecryptByScenesId(str, 1);
    }

    @Deprecated
    public static final String executeDecryptByScenesId(String str, int i) {
        if (SO_ENABLED && !TextUtils.isEmpty(str)) {
            try {
                byte[] bArrDecodeBase64 = decodeBase64(str);
                if (bArrDecodeBase64 != null && bArrDecodeBase64.length > 0) {
                    byte[] bArrDecryptByScenesId = decryptByScenesId(bArrDecodeBase64, i);
                    String str2 = (bArrDecryptByScenesId == null || bArrDecryptByScenesId.length <= 0) ? "" : new String(bArrDecryptByScenesId, StandardCharsets.UTF_8);
                    if (!TextUtils.isEmpty(str2) && str2.endsWith("sCt4VHQc") && str2.length() > 8) {
                        str2 = str2.substring(0, str2.length() - 8);
                    }
                    return TextUtils.isEmpty(str2) ? "" : str2;
                }
                return "";
            } catch (Throwable th) {
                a.c("EncryptUtils", "executeDecryptByScenesId", th);
            }
        }
        return "";
    }

    public static final byte[] executeDecryptBytesV3(byte[] bArr, int i) {
        if (!SO_ENABLED || bArr == null || bArr.length <= 0) {
            return DEFAULT_BYTE_DATA;
        }
        try {
            byte[] bArrDecryptBytesV3 = decryptBytesV3(bArr, i);
            return bArrDecryptBytesV3 == null ? DEFAULT_BYTE_DATA : bArrDecryptBytesV3;
        } catch (Throwable th) {
            a.c("EncryptUtils", "executeDecryptBytesV3", th);
            return DEFAULT_BYTE_DATA;
        }
    }

    public static final String executeDecryptStringV3(String str, int i) {
        byte[] bArrDecryptBytesV3;
        if (SO_ENABLED && !TextUtils.isEmpty(str)) {
            try {
                byte[] bArrDecodeBase64 = decodeBase64(str);
                if (bArrDecodeBase64 != null && bArrDecodeBase64.length > 0 && (bArrDecryptBytesV3 = decryptBytesV3(bArrDecodeBase64, i)) != null && bArrDecryptBytesV3.length > 0) {
                    String str2 = new String(bArrDecryptBytesV3, StandardCharsets.UTF_8);
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
            } catch (Throwable th) {
                a.c("EncryptUtils", "executeDecryptStringV3", th);
            }
        }
        return "";
    }

    @Deprecated
    public static final String executeEncrypt(String str) {
        return executeEncryptByScenesId(str, 0);
    }

    @Deprecated
    public static final String executeEncryptByScenesId(String str, int i) {
        if (SO_ENABLED && !TextUtils.isEmpty(str)) {
            try {
                byte[] bArrEncryptByScenesId = encryptByScenesId((str + "WTpiiGG9").getBytes(StandardCharsets.UTF_8), i);
                String strEncodeBase64 = (bArrEncryptByScenesId == null || bArrEncryptByScenesId.length <= 0) ? "" : encodeBase64(bArrEncryptByScenesId);
                return TextUtils.isEmpty(strEncodeBase64) ? "" : strEncodeBase64;
            } catch (Throwable th) {
                a.c("EncryptUtils", "executeEncryptByScenesId", th);
            }
        }
        return "";
    }

    public static final byte[] executeEncryptBytesV2(byte[] bArr) {
        return executeEncryptBytesV3(bArr, 1);
    }

    public static final byte[] executeEncryptBytesV3(byte[] bArr, int i) {
        if (!SO_ENABLED || bArr == null || bArr.length <= 0) {
            return DEFAULT_BYTE_DATA;
        }
        try {
            byte[] bArrEncryptBytesV3 = encryptBytesV3(bArr, i);
            return bArrEncryptBytesV3 == null ? DEFAULT_BYTE_DATA : bArrEncryptBytesV3;
        } catch (Throwable th) {
            a.c("EncryptUtils", "executeEncryptBytesV3", th);
            return DEFAULT_BYTE_DATA;
        }
    }

    public static final String executeEncryptStringV3(String str, int i) {
        if (SO_ENABLED && !TextUtils.isEmpty(str)) {
            try {
                byte[] bArrEncryptBytesV3 = encryptBytesV3(str.getBytes(StandardCharsets.UTF_8), i);
                if (bArrEncryptBytesV3 != null && bArrEncryptBytesV3.length > 0) {
                    String strEncodeBase64 = encodeBase64(bArrEncryptBytesV3);
                    if (!TextUtils.isEmpty(strEncodeBase64)) {
                        return strEncodeBase64;
                    }
                }
                return "";
            } catch (Throwable th) {
                a.c("EncryptUtils", "executeEncryptStringV3", th);
            }
        }
        return "";
    }

    @Deprecated
    public static final String executeMD5(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @Deprecated
    public static final String executeSHA256(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static boolean isSoEnabled() {
        return SO_ENABLED;
    }
}
