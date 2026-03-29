package com.beizi.ad.internal.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f4416a;
    private static h e;
    private ExecutorService b = Executors.newFixedThreadPool(4);
    private LruCache<String, Bitmap> c = new LruCache<>(4194304);
    private Handler d = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    private static h b() {
        if (e == null) {
            synchronized (h.class) {
                if (e == null) {
                    e = new h();
                }
            }
        }
        return e;
    }

    private boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static h a(Context context) {
        if (com.beizi.ad.internal.c.a().j != null) {
            f4416a = com.beizi.ad.internal.c.a().j;
        } else {
            f4416a = context;
        }
        return b();
    }

    public b a(String str) {
        return new b(str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4426a;
        ImageView b;

        public b(String str) {
            this.f4426a = str;
        }

        private void b() {
            h.this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.h.b.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        public void a(ImageView imageView) {
            this.b = imageView;
            if (TextUtils.isEmpty(this.f4426a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) h.this.c.get(this.f4426a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap bitmapA = a();
            if (bitmapA == null) {
                h.this.b.submit(this);
            } else {
                imageView.setImageBitmap(bitmapA);
                h.this.c.put(this.f4426a, bitmapA);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4426a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    h.this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.h.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.b.setImageBitmap(bitmapDecodeStream);
                        }
                    });
                    h.this.c.put(this.f4426a, bitmapDecodeStream);
                    String str = this.f4426a;
                    bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(com.beizi.ad.lance.a.h.c(h.f4416a), f.a(str.substring(str.lastIndexOf("/") + 1)))));
                } else {
                    b();
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e) {
                e.printStackTrace();
                b();
            }
        }

        private Bitmap a() {
            String str = this.f4426a;
            File file = new File(com.beizi.ad.lance.a.h.c(h.f4416a), f.a(str.substring(str.lastIndexOf("/") + 1)));
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
    }

    public void a(final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.c.get(str);
        if (bitmap != null) {
            aVar.a(bitmap);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.d(f4416a), f.a(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            this.c.put(str, bitmapDecodeFile);
            aVar.a(bitmapDecodeFile);
        } else {
            this.b.submit(new Runnable() { // from class: com.beizi.ad.internal.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(2000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            h.this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.h.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.a(bitmapDecodeStream);
                                }
                            });
                            h.this.c.put(str, bitmapDecodeStream);
                            String str2 = str;
                            bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(com.beizi.ad.lance.a.h.d(h.f4416a), f.a(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        h.this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.h.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a();
                            }
                        });
                    }
                    com.beizi.ad.lance.a.h.e(h.f4416a);
                }
            });
        }
    }

    public void b(final String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.c.get(str);
        if (bitmap != null) {
            aVar.a(bitmap);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.c(f4416a), f.a(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            this.c.put(str, bitmapDecodeFile);
            aVar.a(bitmapDecodeFile);
        } else {
            this.b.submit(new Runnable() { // from class: com.beizi.ad.internal.e.h.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(2000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            h.this.c.put(str, bitmapDecodeStream);
                            String str2 = str;
                            bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(com.beizi.ad.lance.a.h.c(h.f4416a), f.a(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        h.this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.h.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a();
                            }
                        });
                    }
                }
            });
        }
    }

    public void a(final String str, final boolean z, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final Bitmap bitmap = this.c.get(str);
        if (bitmap != null) {
            if (z) {
                if (c()) {
                    aVar.a(bitmap);
                    return;
                }
                Handler handler = this.d;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.beizi.ad.internal.e.h.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(bitmap);
                        }
                    });
                    return;
                }
                return;
            }
            aVar.a(bitmap);
            return;
        }
        File file = new File(com.beizi.ad.lance.a.h.d(f4416a), f.a(str.substring(str.lastIndexOf("/") + 1)));
        final Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            this.c.put(str, bitmapDecodeFile);
            if (z) {
                if (c()) {
                    aVar.a(bitmapDecodeFile);
                    return;
                }
                Handler handler2 = this.d;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.beizi.ad.internal.e.h.3
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a(bitmapDecodeFile);
                        }
                    });
                    return;
                }
                return;
            }
            aVar.a(bitmapDecodeFile);
            return;
        }
        this.b.submit(new Runnable() { // from class: com.beizi.ad.internal.e.h.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(2000);
                    if (httpURLConnection.getResponseCode() == 200) {
                        final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                        httpURLConnection.disconnect();
                        if (!z) {
                            aVar.a(bitmapDecodeStream);
                        } else if (h.this.d != null) {
                            h.this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.h.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.a(bitmapDecodeStream);
                                }
                            });
                        }
                        h.this.c.put(str, bitmapDecodeStream);
                        String str2 = str;
                        bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(com.beizi.ad.lance.a.h.d(h.f4416a), f.a(str2.substring(str2.lastIndexOf("/") + 1)))));
                    }
                } catch (Exception unused) {
                    aVar.a();
                }
                com.beizi.ad.lance.a.h.e(h.f4416a);
            }
        });
    }
}
