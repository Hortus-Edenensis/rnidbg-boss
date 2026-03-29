package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f11707a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f913a = false;
    private static long b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11708a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        byte[] f914a;

        public a(byte[] bArr, int i) {
            this.f914a = bArr;
            this.f11708a = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11709a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Bitmap f915a;

        public b(Bitmap bitmap, long j) {
            this.f915a = bitmap;
            this.f11709a = j;
        }
    }

    public static b a(Context context, String str, boolean z) throws Throwable {
        Bitmap bitmapB;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        try {
            try {
                bitmapB = b(context, str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        if (bitmapB != null) {
            bVar.f915a = bitmapB;
            com.xiaomi.push.w.a((Closeable) null);
            return bVar;
        }
        a aVarA = a(str, z);
        if (aVarA == null) {
            com.xiaomi.push.w.a((Closeable) null);
            return bVar;
        }
        bVar.f11709a = aVarA.f11708a;
        byte[] bArr = aVarA.f914a;
        if (bArr != null) {
            if (z) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    int iA = a(context, byteArrayInputStream2);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = iA;
                    bVar.f915a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    byteArrayInputStream = byteArrayInputStream2;
                } catch (Exception e2) {
                    e = e2;
                    byteArrayInputStream = byteArrayInputStream2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream2;
                    com.xiaomi.push.w.a((Closeable) byteArrayInputStream);
                    throw th;
                }
            } else {
                bVar.f915a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
        }
        a(context, aVarA.f914a, str);
        com.xiaomi.push.w.a((Closeable) byteArrayInputStream);
        return bVar;
    }

    private static synchronized Bitmap b(Context context, String str) {
        Bitmap bitmap;
        File file;
        FileInputStream fileInputStream = null;
        Bitmap bitmapDecodeStream = null;
        try {
            file = new File(a(context), com.xiaomi.push.bb.a(str));
        } catch (Throwable th) {
            th = th;
            bitmap = null;
        }
        if (!file.exists()) {
            return null;
        }
        if (System.currentTimeMillis() - file.lastModified() > 1209600000) {
            com.xiaomi.channel.commonutils.logger.b.m74a("The pic cache has expired.");
            return null;
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream2);
            file.setLastModified(System.currentTimeMillis());
            com.xiaomi.push.w.a((Closeable) fileInputStream2);
        } catch (Throwable th2) {
            Bitmap bitmap2 = bitmapDecodeStream;
            fileInputStream = fileInputStream2;
            th = th2;
            bitmap = bitmap2;
            try {
                com.xiaomi.channel.commonutils.logger.b.d("Load bmp from cache error: " + th);
                bitmapDecodeStream = bitmap;
            } finally {
                com.xiaomi.push.w.a((Closeable) fileInputStream);
            }
        }
        return bitmapDecodeStream;
    }

    private static synchronized void b(Context context) {
        String str;
        if (f913a) {
            return;
        }
        f11707a = 0L;
        b = 0L;
        try {
            File file = new File(a(context));
            if (!file.exists()) {
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    f11707a += file2.length();
                    long j = b;
                    if (j <= 0) {
                        b = file2.lastModified();
                    } else {
                        b = Math.min(j, file2.lastModified());
                    }
                }
            }
            f913a = true;
            str = "Init pic cache finish.";
        } catch (Throwable th) {
            try {
                com.xiaomi.channel.commonutils.logger.b.d("Init pic cache error: " + th);
                f913a = true;
                str = "Init pic cache finish.";
            } finally {
                f913a = true;
                com.xiaomi.channel.commonutils.logger.b.b("Init pic cache finish.");
            }
        }
        com.xiaomi.channel.commonutils.logger.b.b(str);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00fe: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:56:0x00fe */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dc A[PHI: r1
      0x00dc: PHI (r1v5 java.net.HttpURLConnection) = (r1v4 java.net.HttpURLConnection), (r1v6 java.net.HttpURLConnection) binds: [B:47:0x00da, B:52:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a a(String str, boolean z) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
            }
            try {
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (z && contentLength > 102400) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + com.xiaomi.push.bb.a(str, 3));
                    com.xiaomi.push.w.a((Closeable) null);
                    httpURLConnection.disconnect();
                    return null;
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("Invalid Http Response Code " + responseCode + " received");
                    com.xiaomi.push.w.a((Closeable) null);
                    httpURLConnection.disconnect();
                    return null;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int i = z ? AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE : 2048000;
                    byte[] bArr = new byte[1024];
                    while (i > 0) {
                        int i2 = inputStream.read(bArr, 0, 1024);
                        if (i2 == -1) {
                            break;
                        }
                        i -= i2;
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                    if (i <= 0) {
                        com.xiaomi.channel.commonutils.logger.b.m74a("length 102400 exhausted.");
                        a aVar = new a(null, AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE);
                        com.xiaomi.push.w.a((Closeable) inputStream);
                        httpURLConnection.disconnect();
                        return aVar;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a aVar2 = new a(byteArray, byteArray.length);
                    com.xiaomi.push.w.a((Closeable) inputStream);
                    httpURLConnection.disconnect();
                    return aVar2;
                } catch (SocketTimeoutException unused) {
                    com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to " + str);
                    com.xiaomi.push.w.a((Closeable) inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (IOException e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.w.a((Closeable) inputStream);
                    if (httpURLConnection != null) {
                    }
                    return null;
                }
            } catch (SocketTimeoutException unused2) {
                inputStream = null;
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.push.w.a(closeable2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (SocketTimeoutException unused3) {
            httpURLConnection = null;
            inputStream = null;
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap a(Context context, String str) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStreamOpenInputStream2;
        Uri uri = Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            } catch (Throwable th) {
                th = th;
                r0 = context;
            }
        } catch (IOException e) {
            e = e;
            inputStreamOpenInputStream2 = null;
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenInputStream = null;
        }
        try {
            int iA = a(context, inputStreamOpenInputStream);
            inputStreamOpenInputStream2 = context.getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = iA;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
                com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream2);
                com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream);
                return bitmapDecodeStream;
            } catch (IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream2);
                com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamOpenInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.w.a((Closeable) r0);
            com.xiaomi.push.w.a((Closeable) inputStreamOpenInputStream);
            throw th;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            int iRound = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
            int i2 = options.outWidth;
            if (i2 <= iRound || (i = options.outHeight) <= iRound) {
                return 1;
            }
            return Math.min(i2 / iRound, i / iRound);
        }
        com.xiaomi.channel.commonutils.logger.b.m74a("decode dimension failed for bitmap.");
        return 1;
    }

    private static void a(Context context, byte[] bArr, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("cannot save small icon cause bitmap is null");
            return;
        }
        m700a(context);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File file = new File(a(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, com.xiaomi.push.bb.a(str));
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                f11707a += file2.length();
                long j = b;
                if (j <= 0) {
                    b = file2.lastModified();
                } else {
                    b = Math.min(j, file2.lastModified());
                }
                com.xiaomi.push.w.a(bufferedOutputStream);
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream2 = bufferedOutputStream;
                com.xiaomi.channel.commonutils.logger.b.d("Save pic error: " + e);
                com.xiaomi.push.w.a(bufferedOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                com.xiaomi.push.w.a(bufferedOutputStream2);
                com.xiaomi.push.w.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        com.xiaomi.push.w.a(fileOutputStream);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static synchronized void m700a(Context context) {
        File file;
        long jLastModified;
        b(context);
        if (f11707a >= 62914560 || System.currentTimeMillis() - b >= 1209600000) {
            try {
                file = new File(a(context));
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("Clear pic cache error: " + th);
            }
            if (!file.exists()) {
                com.xiaomi.channel.commonutils.logger.b.m74a("The pic cache dir do not exists.");
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                a(fileArrListFiles);
                long length = f11707a;
                int length2 = fileArrListFiles.length - 1;
                while (true) {
                    if (length2 < 0) {
                        jLastModified = 0;
                        break;
                    }
                    File file2 = fileArrListFiles[length2];
                    if (file2 != null) {
                        if (length <= 31457280 && System.currentTimeMillis() - file2.lastModified() <= 864000000) {
                            jLastModified = file2.lastModified();
                            break;
                        }
                        length -= file2.length();
                        file2.delete();
                    }
                    length2--;
                }
                f11707a = Math.max(length, 0L);
                b = jLastModified;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m74a("The pic cache file list is null.");
            }
        }
    }

    private static void a(File[] fileArr) {
        if (fileArr != null) {
            try {
                if (fileArr.length > 1) {
                    Arrays.sort(fileArr, new Comparator<File>() { // from class: com.xiaomi.push.service.ae.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            if (file == file2) {
                                return 0;
                            }
                            if (file == null) {
                                return 1;
                            }
                            if (file2 == null) {
                                return -1;
                            }
                            long jLastModified = file.lastModified() - file2.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? 1 : -1;
                        }
                    });
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("Sort pic cache error: " + th);
            }
        }
    }

    private static String a(Context context) {
        return context.getCacheDir().getPath() + File.separator + "mipush_icon";
    }
}
