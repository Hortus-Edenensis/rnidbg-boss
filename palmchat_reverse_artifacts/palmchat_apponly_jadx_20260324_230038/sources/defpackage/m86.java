package defpackage;

import android.util.Base64;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class m86 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f19161a = new Object();
    public static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> b = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19162a;

        public a(String str) {
            this.f19162a = str;
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f19162a, Locale.ENGLISH);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }

    public static String c(long j) {
        return e("yyyyMMdd HH:mm:ss.SSS").format(new Date(j));
    }

    public static String d(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static SimpleDateFormat e(String str) {
        ThreadLocal<SimpleDateFormat> aVar = b.get(str);
        if (aVar == null) {
            synchronized (f19161a) {
                aVar = b.get(str);
                if (aVar == null) {
                    aVar = new a(str);
                    b.put(str, aVar);
                }
            }
        }
        return aVar.get();
    }

    public static byte[] f(byte[] bArr) throws Throwable {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a(byteArrayOutputStream);
                a(gZIPOutputStream2);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                a(byteArrayOutputStream);
                a(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean g(long j, long j2) {
        if (j2 > 0) {
            return j <= 0 || System.currentTimeMillis() > j + j2;
        }
        throw new AssertionError();
    }
}
