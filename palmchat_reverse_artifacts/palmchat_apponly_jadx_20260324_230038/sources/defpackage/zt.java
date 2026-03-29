package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.common.PackageConstants;
import com.huawei.openalliance.ad.constant.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class zt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f22505a = Uri.parse("content://com.huawei.hwid");
    public static final String[] b = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", PackageConstants.SERVICES_SIGNATURE_V3};

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            ga7.f("BksUtil", "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            ga7.b("BksUtil", "create directory  success");
            return 0;
        }
        ga7.d("BksUtil", "create directory  failed");
        return -1;
    }

    public static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + "aegis";
        }
        return context.getApplicationContext().getFilesDir() + File.separator + "aegis";
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static void d(InputStream inputStream, Context context) throws Throwable {
        FileOutputStream fileOutputStream;
        if (inputStream == null || context == null) {
            return;
        }
        String strB = b(context);
        if (!new File(strB).exists()) {
            a(strB);
        }
        File file = new File(strB, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        ?? r7 = 0;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                ga7.e("BksUtil", "write output stream ");
                fileOutputStream = new FileOutputStream(file);
                r7 = 2048;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused) {
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int i = inputStream.read(bArr, 0, 2048);
                if (i == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            }
            e87.c(fileOutputStream);
        } catch (IOException unused2) {
            fileOutputStream2 = fileOutputStream;
            ga7.d("BksUtil", " IOException");
            e87.c(fileOutputStream2);
            r7 = fileOutputStream2;
        } catch (Throwable th2) {
            th = th2;
            r7 = fileOutputStream;
            e87.c(r7);
            throw th;
        }
    }

    public static byte[] e(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e("BksUtil", "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("BksUtil", "PackageManager.NameNotFoundException : " + e.getMessage());
        } catch (Exception e2) {
            Log.e("BksUtil", "get pm exception : " + e2.getMessage());
        }
        return new byte[0];
    }

    public static String f(Context context) {
        return b(context) + File.separator + "hmsrootcas.bks";
    }

    public static String g(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(x.dW);
            messageDigest.update(bArr);
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            ga7.d("BksUtil", "inputstraem exception");
            return "";
        }
    }

    public static boolean h(Context context, String str) {
        return PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(j(e(context, str)));
    }

    public static boolean i(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ga7.e("BksUtil", "hms version code is : " + str);
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = "4.0.2.300".split("\\.");
        int length = strArrSplit.length;
        int length2 = strArrSplit2.length;
        int iMax = Math.max(length, length2);
        int i2 = 0;
        while (i2 < iMax) {
            if (i2 < length) {
                try {
                    i = Integer.parseInt(strArrSplit[i2]);
                } catch (Exception e) {
                    ga7.d("BksUtil", " exception : " + e.getMessage());
                    return i2 >= length2;
                }
            } else {
                i = 0;
            }
            int i3 = i2 < length2 ? Integer.parseInt(strArrSplit2[i2]) : 0;
            if (i < i3) {
                return false;
            }
            if (i > i3) {
                return true;
            }
            i2++;
        }
        return true;
    }

    public static String j(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return c(MessageDigest.getInstance(x.dW).digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            Log.e("BksUtil", "NoSuchAlgorithmException" + e.getMessage());
            return "";
        }
    }

    public static boolean k(Context context) {
        return new File(b(context) + File.separator + "hmsrootcas.bks").exists();
    }

    public static boolean l(Context context, String str) {
        byte[] bArrE = e(context, str);
        for (String str2 : b) {
            if (str2.equalsIgnoreCase(j(bArrE))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:19|(2:21|(3:23|24|25))|66|26|(5:71|27|28|68|29)|(8:30|(1:32)(1:73)|52|53|54|55|56|57)|33|70|34|(1:40)(1:39)|41|55|56|57) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00de, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00df, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e0, code lost:
    
        r4 = r1;
        r1 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0115: MOVE (r8 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:278), block:B:59:0x0115 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized InputStream m(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ?? r2;
        ByteArrayInputStream byteArrayInputStream3;
        InputStream inputStreamOpenInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        ga7.e("BksUtil", "get bks from tss begin");
        if (context != null) {
            wp0.b(context);
        }
        Context contextA = wp0.a();
        ByteArrayInputStream byteArrayInputStream4 = null;
        if (contextA == null) {
            ga7.d("BksUtil", "context is null");
            return null;
        }
        if (!i(zb7.a("com.huawei.hwid")) && !i(zb7.a("com.huawei.hms"))) {
            ga7.d("BksUtil", "hms version code is too low : " + zb7.a("com.huawei.hwid"));
            return null;
        }
        boolean zL = l(contextA, "com.huawei.hwid");
        boolean z = zL;
        if (!zL) {
            boolean zH = h(contextA, "com.huawei.hms");
            z = zH;
            if (!zH) {
                ga7.d("BksUtil", "hms sign error");
                return null;
            }
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayInputStream2 = null;
            byteArrayInputStream4 = byteArrayInputStream;
            r2 = z;
        }
        try {
            inputStreamOpenInputStream = contextA.getContentResolver().openInputStream(Uri.withAppendedPath(f22505a, "files/hmsrootcas.bks"));
            try {
                bArr = new byte[1024];
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream2 = null;
            r2 = byteArrayOutputStream;
            byteArrayInputStream3 = byteArrayInputStream2;
            inputStreamOpenInputStream = byteArrayInputStream4;
            ?? r22 = r2;
            e87.b(inputStreamOpenInputStream);
            e87.c(r22);
            e87.b(byteArrayInputStream3);
            throw th;
        }
        while (true) {
            int i = inputStreamOpenInputStream.read(bArr);
            if (i <= -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            ga7.d("BksUtil", "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
            e87.b(inputStreamOpenInputStream);
            e87.c(byteArrayOutputStream);
            e87.b(byteArrayInputStream4);
            return n(contextA);
        }
        byteArrayOutputStream.flush();
        byteArrayInputStream3 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        String strB = qd7.b("bks_hash", "", contextA);
        String strG = g(byteArrayOutputStream.toByteArray());
        if (k(contextA) && strB.equals(strG)) {
            ga7.e("BksUtil", "bks not update");
        } else {
            ga7.e("BksUtil", "update bks and sp");
            d(byteArrayInputStream3, contextA);
            qd7.e("bks_hash", strG, contextA);
        }
        e87.b(inputStreamOpenInputStream);
        e87.c(byteArrayOutputStream);
        e87.b(byteArrayInputStream3);
        return n(contextA);
    }

    public static InputStream n(Context context) {
        if (!k(context)) {
            return null;
        }
        ga7.e("BksUtil", "getFilesBksIS ");
        try {
            return new FileInputStream(f(context));
        } catch (FileNotFoundException unused) {
            ga7.d("BksUtil", "FileNotFoundExceptio: ");
            return null;
        }
    }
}
