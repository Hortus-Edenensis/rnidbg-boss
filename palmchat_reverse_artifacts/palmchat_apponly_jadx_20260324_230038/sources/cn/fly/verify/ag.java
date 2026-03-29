package cn.fly.verify;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.fq;
import com.huawei.hms.framework.common.ContainerUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ag {
    public static String a() {
        StringBuilder sb;
        int i;
        String string = "";
        for (int i2 = 0; i2 < 32; i2++) {
            int iNextInt = new Random(100L).nextInt() % 62;
            if (iNextInt < 26) {
                string = string + (iNextInt + 97);
            } else {
                if (iNextInt < 52) {
                    sb = new StringBuilder();
                    sb.append(string);
                    i = iNextInt + 65;
                } else {
                    sb = new StringBuilder();
                    sb.append(string);
                    i = (iNextInt + 48) - 26;
                }
                sb.append(i - 26);
                string = sb.toString();
            }
        }
        return string;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.huawei.openalliance.ad.constant.x.dW);
            messageDigest.update(str.getBytes(Charset.defaultCharset()));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str, String str2) {
        try {
            PublicKey publicKeyA = a(str);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyA);
            return Base64.encodeToString(cipher.doFinal(str2.getBytes(Charset.defaultCharset())), 0).replace("\n", "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static HashMap<String, Object> d(String str, String str2) {
        String strA = a();
        String strSubstring = strA.substring(0, 16);
        String strSubstring2 = strA.substring(16, 32);
        String strA2 = a("{app:{\"c\":" + fq.d.m() + ",\"md5\":\"" + a(ax.g()) + "\", \"n\":\"" + al.i() + "\",\"pk\":\"" + fq.d.c() + "\",\"v\":\"" + fq.d.f() + "\"},sdk: {\"c\":47,\"cm\":\"CUCC\",\"n\":\"SDKFactory\",\"v\":\"安卓4.0.3开放版Z21041415\"},device:{\"imei\":[],\"os\":\"Android\"},sim:[],data:{\"r\":" + System.currentTimeMillis() + ",\"serviceType\":0,\"privateIp\":\"\",\"compatible\":\"2\",\"newVersion\":\"10\"}}", strSubstring.trim(), strSubstring2.trim());
        StringBuilder sb = new StringBuilder();
        sb.append(strSubstring);
        sb.append(strSubstring2);
        String strC = c(str2, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("/dro/netm/v1.0/qc?apiKey=");
        sb2.append(str);
        sb2.append("&params=");
        sb2.append(strA2);
        sb2.append("&paramsKey=");
        sb2.append(strC);
        String strB = b(sb2.toString());
        HashMap map = new HashMap();
        map.put("apiKey", str);
        map.put("params", strA2);
        map.put("paramsKey", strC);
        HashMap map2 = new HashMap(16);
        if (!TextUtils.isEmpty(strB)) {
            map.put("sign", strB);
            map.put("sign_Type", WkAdxAdConfigMg.DSP_NAME_BAIDU);
            map2.put("sign", strB);
            map2.put("api-protocol", "1.1");
        }
        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("params", map);
        map3.put("sign", map2);
        return map3;
    }

    public static String a(Context context) {
        try {
            String strA = al.a();
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            int length = strA.length() / 2;
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                sb.append(strA.substring(i * 2, i2 * 2));
                if (i < length - 1) {
                    sb.append(":");
                }
                i = i2;
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str, String str2) throws Exception {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) a(str2);
        if (TextUtils.isEmpty(str)) {
            throw new Exception("rsaAes key is null");
        }
        return new String(a(rSAPublicKey, Base64.decode(str, 0)), Charset.defaultCharset()).trim();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strB = b(jSONObject.optString("aesKey"), str2);
            return b(jSONObject.optString("data"), strB.substring(0, 16), strB.substring(16));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() == 0 || str.trim().length() == 0) {
                return null;
            }
            if (str2 == null) {
                throw new Exception("decrypt key is null");
            }
            if (str2.length() != 16) {
                throw new Exception("decrypt key length error");
            }
            if (str3.length() != 16) {
                throw new Exception(" iv decrypt key length error");
            }
            byte[] bArrDecode = Base64.decode(str, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(str2.getBytes("utf-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM), new IvParameterSpec(str3.getBytes("utf-8")));
            return new String(cipher.doFinal(bArrDecode), "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (str.length() == 0 || str.trim().length() == 0 || str2 == null || str2.length() != 16 || str3.length() != 16) {
                    return null;
                }
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new SecretKeySpec(str2.getBytes("utf-8"), EncryptUtils.AES_ENCRYPT_ALGORITHM), new IvParameterSpec(str3.getBytes("utf-8")));
                return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0).replace("\n", "");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a(HashMap<String, Object> map) {
        StringBuilder sb;
        if (map != null) {
            try {
                sb = new StringBuilder();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null && !TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(value.toString(), "UTF-8");
                        sb.append(key);
                        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(strEncode);
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (Exception unused) {
                sb = null;
            }
        } else {
            sb = null;
        }
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 0)));
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] a(RSAPublicKey rSAPublicKey, byte[] bArr) throws Exception {
        if (rSAPublicKey == null) {
            throw new Exception("public key is null");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException unused) {
            throw new InvalidKeyException("InvalidKey");
        } catch (NoSuchAlgorithmException unused2) {
            throw new NoSuchAlgorithmException("NoSuchAlgorithm");
        } catch (BadPaddingException unused3) {
            throw new BadPaddingException("BadPadding");
        } catch (IllegalBlockSizeException unused4) {
            throw new IllegalBlockSizeException("IllegalBlockSize");
        } catch (NoSuchPaddingException unused5) {
            throw new NoSuchPaddingException("NoSuchPadding or not support this padding");
        }
    }
}
