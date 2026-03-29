package com.beizi.ad.internal.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.LruCache;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s {
    private static s d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f4433a = Executors.newFixedThreadPool(4);
    private LruCache<String, String> b = new LruCache<>(1048576);
    private Handler c = new Handler();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(String str);
    }

    private boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static s a() {
        return b();
    }

    private static s b() {
        if (d == null) {
            synchronized (s.class) {
                if (d == null) {
                    d = new s();
                }
            }
        }
        return d;
    }

    public void a(final Context context, final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            aVar.a(str2);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.d(context), f.a(str.substring(str.lastIndexOf("/") + 1)));
        String absolutePath = (!file.exists() || file.length() <= 0) ? null : file.getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            this.b.put(str, absolutePath);
            aVar.a(absolutePath);
        } else {
            this.f4433a.submit(new Runnable() { // from class: com.beizi.ad.internal.e.s.1
                @Override // java.lang.Runnable
                public void run() {
                    InputStream inputStream;
                    File file2;
                    FileOutputStream fileOutputStream;
                    BufferedInputStream bufferedInputStream;
                    byte[] bArr;
                    try {
                        inputStream = ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
                        String str3 = str;
                        file2 = new File(com.beizi.ad.lance.a.h.d(context), f.a(str3.substring(str3.lastIndexOf("/") + 1)));
                        fileOutputStream = new FileOutputStream(file2);
                        bufferedInputStream = new BufferedInputStream(inputStream);
                        bArr = new byte[1024];
                    } catch (Exception unused) {
                        s.this.c.post(new Runnable() { // from class: com.beizi.ad.internal.e.s.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a();
                            }
                        });
                    }
                    while (true) {
                        int i = bufferedInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                        com.beizi.ad.lance.a.h.e(context);
                    }
                    final String absolutePath2 = file2.getAbsolutePath();
                    s.this.c.post(new Runnable() { // from class: com.beizi.ad.internal.e.s.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(absolutePath2);
                        }
                    });
                    s.this.b.put(str, absolutePath2);
                    fileOutputStream.close();
                    inputStream.close();
                    bufferedInputStream.close();
                    com.beizi.ad.lance.a.h.e(context);
                }
            });
        }
    }

    public void a(final Context context, final String str, final boolean z, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String str2 = this.b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            if (z) {
                if (c()) {
                    aVar.a(str2);
                    return;
                }
                Handler handler = this.c;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.beizi.ad.internal.e.s.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(str2);
                        }
                    });
                    return;
                }
                return;
            }
            aVar.a(str2);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.d(context), f.a(str.substring(str.lastIndexOf("/") + 1)));
        final String absolutePath = (!file.exists() || file.length() <= 0) ? null : file.getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            this.b.put(str, absolutePath);
            if (z) {
                if (c()) {
                    aVar.a(absolutePath);
                    return;
                }
                Handler handler2 = this.c;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.beizi.ad.internal.e.s.3
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(absolutePath);
                        }
                    });
                    return;
                }
                return;
            }
            aVar.a(absolutePath);
            return;
        }
        this.f4433a.submit(new Runnable() { // from class: com.beizi.ad.internal.e.s.4
            @Override // java.lang.Runnable
            public void run() {
                InputStream inputStream;
                String strSubstring;
                File file2;
                FileOutputStream fileOutputStream;
                BufferedInputStream bufferedInputStream;
                byte[] bArr;
                try {
                    inputStream = ((HttpURLConnection) new URL(str).openConnection()).getInputStream();
                    String str3 = str;
                    strSubstring = str3.substring(str3.lastIndexOf("/") + 1);
                    file2 = new File(com.beizi.ad.lance.a.h.d(context), f.a(strSubstring) + "_" + Thread.currentThread().getId() + "_" + System.currentTimeMillis());
                    fileOutputStream = new FileOutputStream(file2);
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    bArr = new byte[1024];
                } catch (Exception unused) {
                    aVar.a();
                }
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                    }
                    com.beizi.ad.lance.a.h.e(context);
                }
                File file3 = new File(com.beizi.ad.lance.a.h.d(context), f.a(strSubstring));
                if (file3.exists()) {
                    file2.delete();
                } else {
                    file2.renameTo(file3);
                }
                final String absolutePath2 = file3.getAbsolutePath();
                if (!z) {
                    aVar.a(absolutePath2);
                } else if (s.this.c != null) {
                    s.this.c.post(new Runnable() { // from class: com.beizi.ad.internal.e.s.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(absolutePath2);
                        }
                    });
                }
                s.this.b.put(str, absolutePath2);
                fileOutputStream.close();
                inputStream.close();
                bufferedInputStream.close();
                com.beizi.ad.lance.a.h.e(context);
            }
        });
    }

    public void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(this.b.get(str))) {
                this.b.remove(str);
            }
            File file = new File(com.beizi.ad.lance.a.h.d(context), f.a(str.substring(str.lastIndexOf("/") + 1)));
            if (!file.exists() || file.length() <= 0) {
                return;
            }
            file.delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
