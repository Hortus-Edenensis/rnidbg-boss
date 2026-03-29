package com.baidu.sec.privacy.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f4286a;
    public final Context b;
    public PublicKey c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<c> {
        public a(d dVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            int i = cVar2.c - cVar.c;
            if (i != 0) {
                return i;
            }
            boolean z = cVar.b;
            if (z && cVar2.b) {
                return 0;
            }
            if (z) {
                return -1;
            }
            if (cVar2.b) {
                return 1;
            }
            return i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public static byte[] a(byte[] bArr) {
            return a(bArr, bArr.length);
        }

        public static byte[] a(byte[] bArr, int i) {
            byte b;
            int i2;
            int i3 = (i / 4) * 3;
            if (i3 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i3];
            int i4 = i;
            int i5 = 0;
            while (true) {
                byte b2 = bArr[i4 - 1];
                b = 10;
                if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                    if (b2 != 61) {
                        break;
                    }
                    i5++;
                }
                i4--;
            }
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i6 < i4) {
                byte b3 = bArr[i6];
                if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                    if (b3 >= 65 && b3 <= 90) {
                        i2 = b3 - 65;
                    } else if (b3 >= 97 && b3 <= 122) {
                        i2 = b3 - 71;
                    } else if (b3 >= 48 && b3 <= 57) {
                        i2 = b3 + 4;
                    } else if (b3 == 43) {
                        i2 = 62;
                    } else {
                        if (b3 != 47) {
                            return null;
                        }
                        i2 = 63;
                    }
                    i8 = ((byte) i2) | (i8 << 6);
                    if (i9 % 4 == 3) {
                        int i10 = i7 + 1;
                        bArr2[i7] = (byte) ((16711680 & i8) >> 16);
                        int i11 = i10 + 1;
                        bArr2[i10] = (byte) ((65280 & i8) >> 8);
                        bArr2[i11] = (byte) (i8 & 255);
                        i7 = i11 + 1;
                    }
                    i9++;
                }
                i6++;
                b = 10;
            }
            if (i5 > 0) {
                int i12 = i8 << (i5 * 6);
                int i13 = i7 + 1;
                bArr2[i7] = (byte) ((i12 & 16711680) >> 16);
                if (i5 == 1) {
                    i7 = i13 + 1;
                    bArr2[i13] = (byte) ((i12 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                } else {
                    i7 = i13;
                }
            }
            byte[] bArr3 = new byte[i7];
            System.arraycopy(bArr2, 0, bArr3, 0, i7);
            return bArr3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ApplicationInfo f4287a;
        public boolean b;
        public int c;
        public boolean d;

        public /* synthetic */ c(a aVar) {
            this();
        }

        public c() {
            this.c = 0;
            this.d = false;
            this.b = false;
        }
    }

    /* JADX INFO: renamed from: com.baidu.sec.privacy.f.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0112d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4288a;
        public String b;
        public int c = 0;

        public static boolean a(int i) {
            return i >= 14;
        }

        public static boolean b(String str) {
            return TextUtils.isEmpty(str);
        }

        public boolean c() {
            return b(this.b);
        }

        public boolean b() {
            return a(this.c);
        }

        public static C0112d a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                String str2 = "0";
                String strOptString = "0";
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!d.d("ZGV2aWNlaWQ=").equals(next) && !d.d("dmVy").equals(next)) {
                        strOptString = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(d.d("ZGV2aWNlaWQ="));
                jSONObject.getInt(d.d("dmVy"));
                int length = TextUtils.isEmpty(strOptString) ? 0 : strOptString.length();
                if (!TextUtils.isEmpty(string)) {
                    C0112d c0112d = new C0112d();
                    c0112d.f4288a = string;
                    c0112d.c = length;
                    if (length >= 14) {
                        return c0112d;
                    }
                    if (!TextUtils.isEmpty(strOptString)) {
                        str2 = strOptString;
                    }
                    c0112d.b = str2;
                    return c0112d;
                }
            } catch (Exception e) {
                com.baidu.sec.privacy.f.c.a(e);
            }
            return null;
        }

        public static C0112d b(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C0112d c0112d = new C0112d();
            c0112d.f4288a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            c0112d.c = length;
            if (length >= 14) {
                return c0112d;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            c0112d.b = str2;
            return c0112d;
        }

        public String a() {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f4288a + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {
        public static byte[] a() {
            return new byte[]{48, -126, 3, 99, 48, -126, 2, 75, -96, 3, 2, 1, 2, 2, 4, 106, -93, 120, 122, 48, dn.k, 6, 9, 42, -122, 72, -122, -9, dn.k, 1, 1, 11, 5, 0, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, dn.l, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, dn.l, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, dn.l, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, dn.l, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, dn.l, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, 32, 23, dn.k, 49, 53, 49, 48, 50, 49, 48, 52, 51, 54, 51, 55, 90, 24, 15, 50, 48, 55, 48, 48, 55, 50, 52, 48, 52, 51, 54, 51, 55, 90, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, dn.l, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, dn.l, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, dn.l, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, dn.l, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, dn.l, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, -126, 1, 34, 48, dn.k, 6, 9, 42, -122, 72, -122, -9, dn.k, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -86, -91, -2, -41, ByteCompanionObject.MAX_VALUE, 37, -25, -33, 93, 51, -73, 32, -81, Base64.padSymbol, 108, 37, 126, dn.l, -125, 125, -55, -29, 34, -60, 84, -67, -46, 125, -93, -67, -27, 97, 54, 35, 0, -6, 83, 67, -116, 43, -24, 26, 88, -5, 33, 27, -105, 49, 76, -70, -32, 105, -48, 67, 69, 102, -111, -81, 93, -103, -18, 17, 55, 81, -34, -80, -76, -13, -84, 6, 91, 10, 48, -56, -1, 45, 9, 23, 34, 6, 103, 35, -51, 29, 70, -19, -51, 20, -39, -43, -97, 75, 23, -124, -101, -71, -75, -107, -88, -13, -71, 80, 90, -76, -119, 51, -80, 118, ByteCompanionObject.MIN_VALUE, -12, -108, 98, -29, -27, 60, -119, -74, 110, Base64.padSymbol, 51, -22, 53, 66, -99, -45, -25, 111, -121, 25, -72, ByteCompanionObject.MAX_VALUE, 3, 51, -100, 57, -90, 116, -59, -117, 74, -71, 121, 59, 19, -8, -109, 33, -14, 76, -105, -127, -23, 5, 99, -82, 22, -99, 51, 78, -26, 77, -52, -29, 121, 42, -76, 20, 2, 116, 111, -76, 2, -78, -90, -54, 81, 115, 82, 50, 124, -83, 96, 20, -40, -118, 105, 90, -70, 120, -33, -110, 12, -15, 38, 34, -125, -116, 69, -54, -103, -109, -124, 26, 94, -89, -98, -11, -66, 89, 48, -68, -51, 107, -60, 12, 114, -71, 119, 49, -31, -65, 113, -99, 3, -90, 79, -88, -38, -87, -25, -38, 41, 110, -25, 29, 49, 124, -76, -91, 77, -11, -90, 114, -63, 118, -22, -5, -124, 19, 22, -74, -75, 78, 28, 47, -69, 2, 3, 1, 0, 1, -93, 33, 48, TELogUtils.DEBUG_LEVEL_V, 48, 29, 6, 3, 85, 29, dn.l, 4, 22, 4, 20, -41, -108, 33, -126, -103, 35, 115, -83, 99, 110, -39, 110, -125, -118, -69, 87, -103, 30, 12, -53, 48, dn.k, 6, 9, 42, -122, 72, -122, -9, dn.k, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 0, -117, 0, -28, 51, 26, -4, -15, 86, ByteCompanionObject.MAX_VALUE, dn.l, -101, -48, 121, 115, -53, -72, -22, 4, -83, 49, 106, -15, -44, -116, -105, 19, 65, -32, 65, 92, 21, 51, Base64.padSymbol, -21, -74, 71, 91, 64, 75, -72, -48, 102, 17, -120, -23, -68, 51, 23, -104, 107, 65, -30, 109, -6, 46, -44, -46, -73, -54, -55, Utf8.REPLACEMENT_BYTE, 77, -54, -11, -51, 27, -1, 114, 86, -80, 28, -89, 29, -20, 49, -8, 57, -7, -30, Base64.padSymbol, -108, -6, -60, 113, 45, -32, -93, 19, -62, -89, 106, 91, 96, -48, 90, -59, 46, 104, 111, -88, 51, -39, 40, -36, -113, 86, -92, 25, 30, 94, -13, -15, -57, 59, -21, -111, 104, -50, -3, -121, -90, -43, Base64.padSymbol, 105, -3, 57, 69, 51, -3, -31, 105, -12, 19, 77, -82, -120, 121, 108, -63, -126, 46, -43, dn.l, -56, 21, 47, Utf8.REPLACEMENT_BYTE, -104, -7, 113, 57, 100, -9, -12, -101, 107, -77, -64, 91, -104, -61, 0, -7, -72, -19, 75, 12, 111, ByteCompanionObject.MAX_VALUE, -115, -46, -99, -111, -93, -67, -42, -66, 32, 81, 70, 109, -57, 10, 19, -49, -44, 59, 21, TELogUtils.DEBUG_LEVEL_V, -61, -59, 83, -14, 43, 73, -88, 120, -58, -46, 46, 66, 41, -2, -70, -6, -42, 103, 8, 4, 89, 110, -122, 68, -86, 62, -68, dn.k, -117, 35, -52, -6, 106, -91, 91, -62, -56, -26, -41, -109, 68, -102, -43, -29, 113, 43, -126, -127, 122, -47, -30, -96, -2, 78, 44, -92, -38, -124, -102, 73, -105, -66, 5, -85, -7, 56};
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f {
        public static byte[] a(byte[] bArr) {
            try {
                return MessageDigest.getInstance("SHA-1").digest(bArr);
            } catch (Exception e) {
                d.b(e);
                return new byte[0];
            }
        }
    }

    static {
        new String(b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, Base64.padSymbol}));
        new String(b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, Base64.padSymbol}));
    }

    public d(Context context) throws Throwable {
        this.b = context.getApplicationContext();
        c();
    }

    public static void b(Throwable th) {
    }

    public static String d(String str) {
        return new String(b.a(str.getBytes()));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() throws Throwable {
        Throwable th;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(e.a());
                try {
                    this.c = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2).getPublicKey();
                    byteArrayInputStream2.close();
                } catch (Exception e2) {
                    e = e2;
                    byteArrayInputStream = byteArrayInputStream2;
                    try {
                        b(e);
                        if (byteArrayInputStream == null) {
                        } else {
                            byteArrayInputStream.close();
                        }
                    } catch (Throwable th2) {
                        byteArrayInputStream2 = byteArrayInputStream;
                        th = th2;
                        ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream2;
                        th = th;
                        byteArrayInputStream = byteArrayInputStream3;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e3) {
                                b(e3);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ByteArrayInputStream byteArrayInputStream32 = byteArrayInputStream2;
                    th = th;
                    byteArrayInputStream = byteArrayInputStream32;
                    if (byteArrayInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                b(e4);
            }
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th4) {
            th = th4;
            if (byteArrayInputStream != null) {
            }
            throw th;
        }
    }

    public final String e(String str) {
        return "0";
    }

    public final String f(String str) {
        try {
            return Settings.System.getString(this.b.getContentResolver(), str);
        } catch (Exception e2) {
            b(e2);
            return null;
        }
    }

    public static String b(Context context) {
        C0112d c0112dA = a(context);
        return c0112dA != null ? c0112dA.a() : "";
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & UByte.MAX_VALUE);
                str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public final boolean b(String str) {
        return this.b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public final C0112d b() {
        return C0112d.b(f("com.baidu.deviceid"), f("bd_setting_i"));
    }

    public final String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = a(f.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "";
    }

    public final List<c> a(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.b.getPackageManager();
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] bArrA = b.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(bArrA));
                                c cVar = new c(null);
                                cVar.c = jSONObject.getInt("priority");
                                cVar.f4287a = resolveInfo.activityInfo.applicationInfo;
                                if (this.b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    cVar.b = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i = 0; i < length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] bArrA2 = a(b.a(string2.getBytes()), this.c);
                                            if (bArrA2 != null && Arrays.equals(bArrA2, f.a(bArrA))) {
                                                cVar.d = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(cVar);
                            }
                        }
                    } catch (Exception e2) {
                        b(e2);
                    }
                }
            }
        }
        Collections.sort(arrayList, new a(this));
        return arrayList;
    }

    public final boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    public static String a(File file) throws Throwable {
        FileReader fileReader;
        char[] cArr;
        CharArrayWriter charArrayWriter;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                try {
                    cArr = new char[8192];
                    charArrayWriter = new CharArrayWriter();
                } catch (Exception e2) {
                    e = e2;
                    b(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                            b(e3);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
            }
        } catch (Exception e4) {
            e = e4;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        while (true) {
            int i = fileReader.read(cArr);
            if (i <= 0) {
                break;
            }
            charArrayWriter.write(cArr, 0, i);
            th = th;
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (Exception e5) {
                    b(e5);
                }
            }
            throw th;
        }
        String string = charArrayWriter.toString();
        try {
            fileReader.close();
        } catch (Exception e6) {
            b(e6);
        }
        return string;
    }

    public static C0112d a(Context context) {
        return new d(context).a();
    }

    public final C0112d a() {
        List<c> listA = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName()), true);
        boolean z = false;
        if (listA == null || listA.size() == 0) {
            for (int i = 0; i < 3; i++) {
            }
        } else {
            boolean z2 = listA.get(0).d;
            if (!z2) {
                for (int i2 = 0; i2 < 3; i2++) {
                }
            }
            z = z2;
        }
        File file = new File(this.b.getFilesDir(), "libcuid.so");
        C0112d c0112dA = file.exists() ? C0112d.a(c(a(file))) : null;
        if (c0112dA == null) {
            f4286a |= 16;
            List<c> listA2 = a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (listA2 != null) {
                File filesDir = this.b.getFilesDir();
                String name = "files".equals(filesDir.getName()) ? "files" : filesDir.getName();
                for (c cVar : listA2) {
                    if (!cVar.b) {
                        File file2 = new File(new File(cVar.f4287a.dataDir, name), "libcuid.so");
                        if (file2.exists() && (c0112dA = C0112d.a(c(a(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (c0112dA == null) {
            c0112dA = C0112d.a(c(f("com.baidu.deviceid.v2")));
        }
        boolean zB = b(com.kuaishou.weapon.p0.g.i);
        if (c0112dA == null && zB) {
            f4286a |= 2;
        }
        if (c0112dA == null) {
            f4286a |= 8;
            c0112dA = b();
        }
        if (c0112dA == null && zB) {
            f4286a |= 1;
            e("");
        }
        a(c0112dA);
        return c0112dA;
    }

    public final boolean a(C0112d c0112d) {
        if (c0112d == null) {
            return false;
        }
        if (c0112d.b()) {
            c0112d.b = "O";
            return true;
        }
        if (!c0112d.c()) {
            return false;
        }
        c0112d.b = "0";
        return true;
    }
}
