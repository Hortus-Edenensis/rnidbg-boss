package com.beizi.fusion.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f4723a;
    private static f e;
    private ExecutorService b = Executors.newFixedThreadPool(4);
    private LruCache<String, Bitmap> c = new LruCache<>(4194304);
    private Handler d = new Handler();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static f a(Context context) {
        if (context == null) {
            ap.b("Illegal Argument: context is null");
        } else {
            f4723a = context;
        }
        return b();
    }

    private static f b() {
        if (e == null) {
            synchronized (f.class) {
                if (e == null) {
                    e = new f();
                }
            }
        }
        return e;
    }

    public b a(String str) {
        return new b(str);
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
        File file = new File(g.b(f4723a), c(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            this.c.put(str, bitmapDecodeFile);
            aVar.a(bitmapDecodeFile);
        } else {
            this.b.submit(new Runnable() { // from class: com.beizi.fusion.tool.f.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setReadTimeout(5000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            f.this.d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.a(bitmapDecodeStream);
                                }
                            });
                            f.this.c.put(str, bitmapDecodeStream);
                            String str2 = str;
                            bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(g.b(f.f4723a), f.c(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        f.this.d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.1.2
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

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4729a;
        ImageView b;

        public b(String str) {
            this.f4729a = str;
        }

        private void b() {
            f.this.d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        public void a(ImageView imageView) {
            this.b = imageView;
            if (TextUtils.isEmpty(this.f4729a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) f.this.c.get(this.f4729a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap bitmapA = a();
            if (bitmapA == null) {
                f.this.b.submit(this);
            } else {
                imageView.setImageBitmap(bitmapA);
                f.this.c.put(this.f4729a, bitmapA);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4729a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() == 200) {
                    final Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    f.this.d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.b.setImageBitmap(bitmapDecodeStream);
                        }
                    });
                    f.this.c.put(this.f4729a, bitmapDecodeStream);
                    String str = this.f4729a;
                    File file = new File(g.b(f.f4723a), f.c(str.substring(str.lastIndexOf("/") + 1)));
                    aa.a("BeiZis", "BeiZiImageUtils run file == " + file);
                    bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
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
            String str = this.f4729a;
            File file = new File(g.b(f.f4723a), f.c(str.substring(str.lastIndexOf("/") + 1)));
            aa.a("BeiZis", "BeiZiImageUtils getBitmapFile file == " + file);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
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
        File file = new File(g.b(f4723a), c(str.substring(str.lastIndexOf("/") + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            this.c.put(str, bitmapDecodeFile);
            aVar.a(bitmapDecodeFile);
        } else {
            this.b.submit(new Runnable() { // from class: com.beizi.fusion.tool.f.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(5000);
                        httpURLConnection.setReadTimeout(5000);
                        if (httpURLConnection.getResponseCode() == 200) {
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                            httpURLConnection.disconnect();
                            f.this.c.put(str, bitmapDecodeStream);
                            String str2 = str;
                            bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(g.b(f.f4723a), f.c(str2.substring(str2.lastIndexOf("/") + 1)))));
                        }
                    } catch (Exception unused) {
                        f.this.d.post(new Runnable() { // from class: com.beizi.fusion.tool.f.2.1
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

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            int i = (b2 >>> 4) & 15;
            int i2 = 0;
            while (true) {
                sb.append((char) ((i < 0 || i > 9) ? (i - 10) + 97 : i + 48));
                i = b2 & 15;
                int i3 = i2 + 1;
                if (i2 >= 1) {
                    break;
                }
                i2 = i3;
            }
        }
        return sb.toString();
    }
}
