package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.beizi.fusion.BeiZiBiddingConstant;
import com.heytap.mcssdk.constant.a;
import com.igexin.push.f.b.d;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class lx6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f19099a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    public static String b = "phone";

    public static int a(int i) {
        return (i > pa7.f19982a || i <= 0) ? 10001 : 10000;
    }

    public static String b(Context context, String str, String str2) {
        String str3;
        Signature[] signatureArr;
        String str4;
        try {
            signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str3 = "1011";
            be7.b(str3, e);
            signatureArr = null;
        } catch (Exception e2) {
            e = e2;
            str3 = "1082";
            be7.b(str3, e);
            signatureArr = null;
        }
        if (signatureArr == null) {
            return null;
        }
        for (Signature signature : signatureArr) {
            if ("SHA1".equals(str2)) {
                byte[] byteArray = signature.toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest == null) {
                        return null;
                    }
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArrDigest) {
                        sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3));
                    }
                    return sb.toString();
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    str4 = BeiZiBiddingConstant.Adn.ADN_GDT;
                    be7.b(str4, e);
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    str4 = "1083";
                    be7.b(str4, e);
                    return null;
                }
            }
        }
        return null;
    }

    public static String c(String str) {
        try {
            String str2 = new String(Base64.decode(str, 0));
            be7.a("4025: " + str2);
            return str2;
        } catch (Exception e) {
            be7.a("4025: " + e.toString());
            return null;
        }
    }

    public static void d(Context context) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.hasSystemFeature("android.hardware.type.watch")) {
            str = "watch";
        } else if (!packageManager.hasSystemFeature("android.software.leanback")) {
            return;
        } else {
            str = "tv";
        }
        b = str;
    }

    public static void e(Context context, Map<String, gc7> map) {
        String str;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("cache", 0);
            h(sharedPreferences, map, "GUID", "GUID_TIME", "GUID_IV");
            h(sharedPreferences, map, "APID", "APID_TIME", "APID_IV");
            g(sharedPreferences, map, "DUID", "DUID_TIME");
            g(sharedPreferences, map, "AUID", "AUID_TIME");
        } catch (IllegalStateException e) {
            e = e;
            str = BeiZiBiddingConstant.Adn.ADN_HW;
            be7.b(str, e);
        } catch (Exception e2) {
            e = e2;
            str = "1064";
            be7.b(str, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(SharedPreferences.Editor editor, gc7 gc7Var, String str, String str2, String str3) {
        Pair pair;
        Cipher cipher;
        SecretKey secretKeyA;
        String strC = c("U3RkSWRBcHBLZXk=");
        byte[] bytes = gc7Var.f17711a.getBytes();
        try {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
            secretKeyA = jd7.a(strC);
        } catch (Exception e) {
            be7.b(BeiZiBiddingConstant.Adn.ADN_BD, e);
        } catch (InstantiationError unused) {
            Log.e("IDHelper", "1092");
        }
        if (secretKeyA != null) {
            cipher.init(1, secretKeyA);
            pair = new Pair(Base64.encodeToString(cipher.doFinal(bytes), 2), Base64.encodeToString(cipher.getIV(), 2));
            if (pair == null) {
                editor.putString(str, (String) pair.first);
                editor.putLong(str2, gc7Var.b);
                editor.putString(str3, (String) pair.second);
                return;
            }
            return;
        }
        pair = null;
        if (pair == null) {
        }
    }

    public static void g(SharedPreferences sharedPreferences, Map<String, gc7> map, String str, String str2) {
        if (map.containsKey(str)) {
            return;
        }
        String string = sharedPreferences.getString(str, null);
        long j = sharedPreferences.getLong(str2, 0L);
        if (string == null || j == 0) {
            return;
        }
        map.put(str, new gc7(string, j));
    }

    public static void h(SharedPreferences sharedPreferences, Map<String, gc7> map, String str, String str2, String str3) {
        String str4;
        if (map.containsKey(str)) {
            return;
        }
        String string = sharedPreferences.getString(str, null);
        long j = sharedPreferences.getLong(str2, 0L);
        String string2 = sharedPreferences.getString(str3, null);
        if (string == null || j == 0 || string2 == null) {
            return;
        }
        try {
            byte[] bArrB = jd7.b(c("U3RkSWRBcHBLZXk="), string, string2);
            if (bArrB != null) {
                map.put(str, new gc7(new String(bArrB, "ISO-8859-1"), j));
            }
        } catch (UnsupportedEncodingException e) {
            e = e;
            str4 = "1065";
            be7.b(str4, e);
        } catch (Exception e2) {
            e = e2;
            str4 = "1066";
            be7.b(str4, e);
        }
    }

    public static boolean i(Context context, String str) {
        return Build.VERSION.SDK_INT >= 31 || k(context, "android").equals(k(context, str));
    }

    public static long j(String str) {
        str.hashCode();
        switch (str) {
            case "APID":
            case "GUID":
                return 259200000L;
            case "AUID":
                return d.b;
            case "DUID":
                return 86400000L;
            case "OUID":
            case "OUID_STATUS":
                return a.n;
            default:
                return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(Context context, String str) {
        Signature[] signatureArr;
        String str2;
        MessageDigest messageDigest;
        String str3;
        ArrayList arrayList = new ArrayList();
        if (str == null || context == null || str.length() == 0) {
            signatureArr = null;
        } else {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo != null) {
                    signatureArr = packageInfo.signatures;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e) {
                be7.b("1059", e);
            }
        }
        if (signatureArr == null) {
            return "";
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            for (Signature signature : signatureArr) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
                try {
                    byte[] encoded = ((X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream)).getEncoded();
                    StringBuffer stringBuffer = new StringBuffer(encoded.length);
                    for (byte b2 : encoded) {
                        String hexString = Integer.toHexString(((char) b2) & 255);
                        if (hexString.length() < 2) {
                            stringBuffer.append(0);
                        }
                        stringBuffer.append(hexString.toUpperCase());
                    }
                    String string = stringBuffer.toString();
                    try {
                        messageDigest = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e2) {
                        e = e2;
                        str2 = "1060";
                        be7.b(str2, e);
                        messageDigest = null;
                    } catch (Exception e3) {
                        e = e3;
                        str2 = "1061";
                        be7.b(str2, e);
                        messageDigest = null;
                    }
                    if (messageDigest == null) {
                        str3 = "";
                    } else {
                        messageDigest.update(string.getBytes());
                        str3 = String.format("%032x", new BigInteger(1, messageDigest.digest()));
                    }
                    if (!arrayList.contains(str3)) {
                        arrayList.add(str3);
                    }
                    byteArrayInputStream.close();
                } catch (Throwable th) {
                    byteArrayInputStream.close();
                    throw th;
                }
            }
            if (arrayList.isEmpty()) {
                return "";
            }
            Collections.sort(arrayList);
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            StringBuilder sb = new StringBuilder();
            for (String str4 : strArr) {
                sb.append(str4);
                sb.append(",");
            }
            String strSubstring = sb.toString().substring(0, sb.toString().length() - 1);
            return TextUtils.isEmpty(strSubstring) ? "" : strSubstring.length() > 32 ? strSubstring.substring(0, 32) : strSubstring;
        } catch (IOException | CertificateException | Exception unused2) {
            return "";
        }
    }

    public static List<String> l(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 8) == 8) {
            arrayList.add("OUID");
            arrayList.add("OUID_STATUS");
        }
        if ((i & 32) == 32 && !arrayList.contains("OUID_STATUS")) {
            arrayList.add("OUID_STATUS");
        }
        if ((i & 2) == 2) {
            arrayList.add("AUID");
        }
        if ((i & 16) == 16) {
            arrayList.add("GUID");
        }
        if ((i & 1) == 1) {
            arrayList.add("APID");
        }
        if ((i & 4) == 4) {
            arrayList.add("DUID");
        }
        return arrayList;
    }
}
