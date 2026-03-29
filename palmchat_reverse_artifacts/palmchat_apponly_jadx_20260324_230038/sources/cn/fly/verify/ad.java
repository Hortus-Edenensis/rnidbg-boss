package cn.fly.verify;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import cn.fly.verify.fq;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.ss.android.ttvecamera.TELogUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f2060a = new HashMap(1);
    private static final Map<String, String> b = new HashMap(1);
    private static final byte[] c = {58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58};
    private static final byte[] d = {71, 67, 77, 108, 71, 75, 58, 77, 73, 89, 123, 77, 89, 67, 104, 57, 78, 91, 79, 72, 75, 91, 95, 75, 75, 62, 77, 68, 75, 78, 73, 72, 99, 91, 65, 72, 109, 91, 73, Utf8.REPLACEMENT_BYTE, 121, 111, 58, Base64.padSymbol, 103, 97, 68, Base64.padSymbol, 59, 123, 121, 89, 64, 66, 96, 80, 56, 80, 58, 33, 80, 33, 62, 70, 102, 70, 124, 108, 56, 121, 112, Base64.padSymbol, 71, 110, 57, 50, 92, 75, 107, 57, 79, 103, 75, 69, 124, 67, Base64.padSymbol, 124, 80, 122, 57, 98, 104, 75, 114, 99, 105, 70, Base64.padSymbol, 56, 62, 115, 102, 105, 103, 99, 121, 94, 90, 126, 80, 91, 98, 94, 37, 51, 73, 33, 56, Utf8.REPLACEMENT_BYTE, 75, 79, 70, 123, 115, 51, 90, 68, 51, 64, 103, 112, 65, 122, 125, 101, 92, 94, 95, 101, 64, 124, 114, 77, 62, 72, 101, 115, 94, 62, 51, 33, 109, 77, 92, 102, 60, 121, 60, 112, 101, 59, 104, 115, 68, 101, 66, 95, 112, 94, 108, 97, 103, 88, 108, 103, 73, 51, 71, 73, Utf8.REPLACEMENT_BYTE, 57, 66, 124, 77, 50, 77, 125, 65, 90, Utf8.REPLACEMENT_BYTE, 114, 126, 105, 110, 122, 126, 76, 96, 75, 67, 105, 109, 67, 88, Base64.padSymbol, 101, 75, 93, 91, 67, 78, 75, 91, 75, 72};
    private static final byte[] e = {103, 101, 110, 111, 102, 55};
    private static final byte[] f = {44, 121, 115, 121, 126, 111, 103, 55};
    private static final byte[] g = {44, 124, 111, 120, 121, 99, 101, 100, 55};
    private static final byte[] h = {44, 99, 121, 89, 110, 97, 70, 101, 109, 99, 100, 55, 59};
    private static final byte[] i = {44, 100, 111, 126, 125, 101, 120, 97, 94, 115, 122, 111, 55};
    private static final byte[] j = {44, 101, 100, 102, 99, 100, 111, 94, 115, 122, 111, 55};
    private static final byte[] k = {44, 126, 99, 103, 111, 89, 126, 107, 103, 122, 55};
    private static final byte[] l = {44, 104, 126, 55};
    private static final byte[] m = {44, 107, ByteCompanionObject.MAX_VALUE, 126, 98, 94, 115, 122, 111, 55, 56};
    private static final byte[] n = {44, 120, 102, 55, 58, 59, 58, 58, 59};
    private static final byte[] o = {44, 122, 99, 122, 102, 55};
    private static final byte[] p = {44, 101, 122, 111, 120, 107, 126, 101, 120, 94, 115, 122, 111, 55};
    private static final byte[] q = {44, 107, 122, 122, 68, 107, 103, 111, 55};
    private static final byte[] r = {107, 122, 122, 67, 110, 55};
    private static final byte[] s = {44, 105, 102, 99, 111, 100, 126, 94, 115, 122, 111, 55};
    private static final byte[] t = {44, 122, 97, 55};
    private static final byte[] u = {44, 122, 121, 55};
    private static final byte[] v = {44, 108, 101, 120, 103, 107, 126, 55};
    private static final byte[] w = {44, 121, 99, 109, 100, 55};
    private static final byte[] x = {122};
    private static final byte[] y = {97};
    private static final byte[] z = {105, Base64.padSymbol, 62, 104, 50, 107, 51, Utf8.REPLACEMENT_BYTE, 51, 111, 62, Base64.padSymbol, 107, 110, 58, 51};
    private static final byte[] A = {85, 58, 59, 56, 57, 62, Utf8.REPLACEMENT_BYTE, 60, Base64.padSymbol, 50, 51, 107, 104, 105, 110, 111, 108, 109, 98, 99, 96, 97, 102, 103, 100, 101, 122, 123, 120, 121, 126, ByteCompanionObject.MAX_VALUE, 124, 125, 114, 115, 112, 75, 72, 73, 78, 79, 76, 77, 66, 67, 64, 65, 70, 71, 68, 69, 90, 91, 88, 89, 94, 95, 92, 93, 82, 83, 80, 85};
    private static final byte[] B = {57, 58, 58, 56, 58};
    private static final byte[] C = {96, 121, 101, 100};
    private static final byte[] D = {75, 79, 89};
    private static final byte[] E = {75, 79, 89, 37, 73, 72, 73, 37, 90, 65, 73, 89, Base64.padSymbol, 90, 107, 110, 110, 99, 100, 109};
    private static final byte[] F = {66, 103, 107, 105, 89, 66, 75, 59};
    private static byte[] G = {68, 64, 94, 49, 50, 83};

    public static String a() {
        String strSubstring = "";
        try {
            String str = Thread.currentThread().getId() + "" + Process.myPid();
            if (str.length() <= 6) {
                return "ctacco";
            }
            strSubstring = str.substring(0, 6);
            return strSubstring;
        } catch (Throwable unused) {
            return strSubstring;
        }
    }

    public static String b() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                String name = networkInterfaceNextElement.getName();
                if (name == null || (!name.contains("wlan") && !name.equals("eth0"))) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                            String hostAddress = inetAddressNextElement.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append(",");
                                }
                                stringBuffer.append(hostAddress);
                            }
                        }
                    }
                }
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            f.a().a(th);
            return "";
        }
    }

    public static String c(Context context) {
        String strD = al.d();
        return "-1".equals(strD) ? "00000" : strD;
    }

    public static String a(int i2) {
        byte[] bytes = b(A).getBytes(StandardCharsets.UTF_8);
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[i2];
        int length = bytes.length;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            bArr[i3] = bytes[secureRandom.nextInt(length)];
            if (i4 >= i2) {
                return new String(bArr, StandardCharsets.UTF_8);
            }
            i3 = i4;
        }
    }

    public static String b(Context context) {
        String strA = a(context);
        return (TextUtils.isEmpty(strA) || strA.equals(com.igexin.push.core.b.m)) ? "15" : strA.equals("2G") ? "10" : strA.equals("3G") ? "11" : strA.equals("4G") ? BaseWrapper.ENTER_ID_MARKET : strA.equals("5G") ? "16" : strA.equals("WIFI") ? BaseWrapper.ENTER_ID_GAME_CENTER : strA.equals("BOTH") ? BaseWrapper.ENTER_ID_AD_SDK : "15";
    }

    public static String a(Context context) {
        if (context == null) {
            return com.igexin.push.core.b.m;
        }
        String strJ = al.j();
        return ("wifi".equalsIgnoreCase(strJ) && as.b(context)) ? "BOTH" : ("2g".equalsIgnoreCase(strJ) || "3g".equalsIgnoreCase(strJ) || "4g".equalsIgnoreCase(strJ) || NetworkUtil.NETWORK_CLASS_5G.equalsIgnoreCase(strJ) || "wifi".equalsIgnoreCase(strJ)) ? strJ.toUpperCase() : "none".equalsIgnoreCase(strJ) ? com.igexin.push.core.b.m : String.valueOf(al.c());
    }

    public static String b(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                bArr2[i2] = bArr[i2];
                for (byte b2 : G) {
                    bArr2[i2] = (byte) (b2 ^ bArr2[i2]);
                }
            }
            return new String(bArr2);
        } catch (Throwable th) {
            f.a().a(th);
            return "";
        }
    }

    public static String a(Context context, String str) throws Throwable {
        String strB = b(z);
        String lowerCase = fr.b(a(10)).toLowerCase();
        if (lowerCase.length() > 16) {
            lowerCase = lowerCase.substring(0, 16);
        }
        byte[] bytes = lowerCase.getBytes();
        byte b2 = bytes[2];
        if (b2 != bytes[13]) {
            bytes[13] = b2;
        }
        return fr.b(b(strB, (str + "," + new String(bytes)).getBytes(), b(c))).toUpperCase();
    }

    private static byte[] b(String str) throws Throwable {
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        int i5;
        byte b5;
        try {
            byte[] bArr = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, com.umeng.analytics.pro.dn.k, com.umeng.analytics.pro.dn.l, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, TELogUtils.DEBUG_LEVEL_V, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bytes = str.getBytes("US-ASCII");
            int length = bytes.length;
            int i6 = 0;
            while (i6 < length) {
                while (true) {
                    i2 = i6 + 1;
                    b2 = bArr[bytes[i6]];
                    if (i2 >= length || b2 != -1) {
                        break;
                    }
                    i6 = i2;
                }
                if (b2 == -1) {
                    break;
                }
                while (true) {
                    i3 = i2 + 1;
                    b3 = bArr[bytes[i2]];
                    if (i3 >= length || b3 != -1) {
                        break;
                    }
                    i2 = i3;
                }
                if (b3 == -1) {
                    break;
                }
                stringBuffer.append((char) ((b2 << 2) | ((b3 & 48) >>> 4)));
                while (true) {
                    i4 = i3 + 1;
                    byte b6 = bytes[i3];
                    if (b6 != 61) {
                        b4 = bArr[b6];
                        if (i4 >= length || b4 != -1) {
                            break;
                        }
                        i3 = i4;
                    } else {
                        return stringBuffer.toString().getBytes("iso8859-1");
                    }
                }
                if (b4 == -1) {
                    break;
                }
                stringBuffer.append((char) (((b3 & 15) << 4) | ((b4 & 60) >>> 2)));
                while (true) {
                    i5 = i4 + 1;
                    byte b7 = bytes[i4];
                    if (b7 != 61) {
                        b5 = bArr[b7];
                        if (i5 >= length || b5 != -1) {
                            break;
                        }
                        i4 = i5;
                    } else {
                        return stringBuffer.toString().getBytes("iso8859-1");
                    }
                }
                if (b5 == -1) {
                    break;
                }
                stringBuffer.append((char) (b5 | ((b4 & 3) << 6)));
                i6 = i5;
            }
            return stringBuffer.toString().getBytes("iso8859-1");
        } catch (Throwable th) {
            f.a().a(th);
            throw th;
        }
    }

    public static String a(Context context, String str, String str2, String str3, String str4) throws Throwable {
        String str5 = a() + System.currentTimeMillis();
        String str6 = a() + a(10);
        f2060a.put(str5, str6);
        String strA = a(str6);
        StringBuilder sb = new StringBuilder();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strI = al.i();
        sb.append(b(e));
        sb.append(fq.d.j());
        sb.append(b(f));
        sb.append(fq.d.l() + "-" + fq.d.j() + "-A:" + Build.VERSION.RELEASE);
        byte[] bArr = g;
        sb.append(b(bArr));
        sb.append(str4);
        sb.append(b(h));
        sb.append(b(i));
        sb.append(a(context));
        sb.append(b(j));
        sb.append(b(context));
        byte[] bArr2 = k;
        sb.append(b(bArr2));
        sb.append(jCurrentTimeMillis);
        sb.append(b(l));
        sb.append(str3);
        sb.append(b(m));
        sb.append(b(n));
        sb.append(b(o));
        sb.append(b());
        sb.append(b(p));
        sb.append(c(context));
        sb.append(b(q));
        if (strI == null) {
            strI = "";
        }
        sb.append(strI);
        try {
            String upperCase = fr.b(b(str6, sb.toString().getBytes(), b(c))).toUpperCase();
            String strB = b(B);
            String strB2 = b(C);
            String strA2 = a(fr.b(str2 + jCurrentTimeMillis + fq.d.c() + al.a().toUpperCase()).toUpperCase(), str + strB + strB2 + strA + upperCase + jCurrentTimeMillis + "3.0");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(b(x), b(r) + str + b(s) + strB + b(bArr2) + jCurrentTimeMillis + b(t) + strA + b(u) + upperCase + b(v) + strB2 + b(bArr) + "3.0" + b(w) + strA2);
            jSONObject.put(b(y), str5);
            return jSONObject.toString();
        } catch (Throwable th) {
            f.a().a(th);
            throw th;
        }
    }

    private static byte[] b(String str, byte[] bArr, String str2) throws Throwable {
        return a(str, bArr, str2, true);
    }

    public static String a(String str) throws Throwable {
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM).generatePublic(new X509EncodedKeySpec(b(b(d))));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return a(cipher.doFinal(str.getBytes()));
        } catch (Throwable th) {
            f.a().a(th);
            throw th;
        }
    }

    public static String a(String str, String str2) throws Throwable {
        try {
            String strB = b(F);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), strB);
            Mac mac = Mac.getInstance(strB);
            mac.init(secretKeySpec);
            return fr.b(mac.doFinal(str2.getBytes())).toUpperCase();
        } catch (Throwable th) {
            f.a().a(th);
            throw th;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(cArr[(bArr[i2] >> 4) & 15]);
            sb.append(cArr[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    private static byte[] a(String str, byte[] bArr, String str2) throws Throwable {
        return a(str, bArr, str2, false);
    }

    private static byte[] a(String str, byte[] bArr, String str2, boolean z2) throws Throwable {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(StandardCharsets.UTF_8), b(D));
            Cipher cipher = Cipher.getInstance(b(E));
            cipher.init(z2 ? 1 : 2, secretKeySpec, new IvParameterSpec(str2.getBytes(StandardCharsets.UTF_8)));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            f.a().a(th);
            throw th;
        }
    }

    public static byte[] a(byte[] bArr, String str) throws Throwable {
        return a(f2060a.get(str), bArr, b(c));
    }
}
