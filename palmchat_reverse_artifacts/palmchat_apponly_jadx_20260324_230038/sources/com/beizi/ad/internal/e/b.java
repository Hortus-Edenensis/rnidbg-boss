package com.beizi.ad.internal.e;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        @UiThread
        void a();

        @UiThread
        void a(InterfaceC0117b interfaceC0117b);

        @UiThread
        void a(d dVar);
    }

    /* JADX INFO: renamed from: com.beizi.ad.internal.e.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0117b {
        @UiThread
        void a(int i);

        @UiThread
        void a(long j, long j2);

        @WorkerThread
        boolean a(File file);

        @UiThread
        void b(File file);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private HandlerThread f4408a;

        @Nullable
        private InterfaceC0117b b;

        @Nullable
        private Handler c;
        private Handler d = new Handler(Looper.getMainLooper());
        private d e;

        public c() {
            HandlerThread handlerThread = new HandlerThread("download");
            this.f4408a = handlerThread;
            handlerThread.start();
            this.c = new Handler(this.f4408a.getLooper());
        }

        private void b(final File file) {
            this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.b.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.b != null) {
                        c.this.b.b(file);
                    }
                }
            });
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() throws Throwable {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            byte[] bArr;
            RandomAccessFile randomAccessFile;
            d dVar = this.e;
            dVar.f4412a = true;
            File file = new File(dVar.e);
            if (!file.exists() && !file.mkdirs()) {
                a(3);
                return;
            }
            String str = dVar.e + File.separator + dVar.f;
            File file2 = new File(str);
            RandomAccessFile randomAccessFile2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(dVar.d).openConnection();
                try {
                    if (dVar.h != 0) {
                        httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + dVar.h + "-");
                    }
                    httpURLConnection.setRequestProperty("Connection", HTTP.CONN_KEEP_ALIVE);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200 || responseCode == 206) {
                        String headerField = httpURLConnection.getHeaderField(MIME.CONTENT_DISPOSITION);
                        String contentType = httpURLConnection.getContentType();
                        long contentLengthLong = Build.VERSION.SDK_INT >= 24 ? httpURLConnection.getContentLengthLong() : httpURLConnection.getContentLength();
                        if (responseCode == 200) {
                            dVar.h = 0L;
                            dVar.g = contentLengthLong;
                        }
                        Log.d("download", headerField + contentType);
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                bArr = new byte[8192];
                                randomAccessFile = new RandomAccessFile(str, "rw");
                            } catch (IOException e) {
                                e = e;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            randomAccessFile.seek(dVar.h);
                            int i = 0;
                            while (true) {
                                int i2 = inputStream.read(bArr);
                                if (i2 != -1) {
                                    i++;
                                    randomAccessFile.write(bArr, 0, i2);
                                    dVar.h += (long) i2;
                                    if (i % 64 == 0) {
                                        if (dVar.b) {
                                            dVar.f4412a = false;
                                            a(1);
                                            try {
                                                randomAccessFile.getFD().sync();
                                            } catch (IOException unused) {
                                            }
                                            try {
                                                randomAccessFile.close();
                                            } catch (IOException unused2) {
                                            }
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused3) {
                                            }
                                            httpURLConnection.disconnect();
                                            return;
                                        }
                                        if (dVar.c) {
                                            dVar.f4412a = false;
                                            a(6);
                                            try {
                                                randomAccessFile.getFD().sync();
                                            } catch (IOException unused4) {
                                            }
                                            try {
                                                randomAccessFile.close();
                                            } catch (IOException unused5) {
                                            }
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused6) {
                                            }
                                            httpURLConnection.disconnect();
                                            return;
                                        }
                                        if (i % 16 == 0) {
                                            a(dVar.h, dVar.g);
                                        }
                                    }
                                } else {
                                    randomAccessFile.getFD().sync();
                                    if (a(file2)) {
                                        dVar.f4412a = false;
                                        b(file2);
                                    } else {
                                        dVar.f4412a = false;
                                        a(4);
                                    }
                                    randomAccessFile2 = randomAccessFile;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            randomAccessFile2 = randomAccessFile;
                            e.printStackTrace();
                            dVar.f4412a = false;
                            a(5);
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.getFD().sync();
                                } catch (IOException unused7) {
                                }
                            }
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException unused8) {
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused9) {
                                }
                            }
                            if (httpURLConnection == null) {
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.getFD().sync();
                                } catch (IOException unused10) {
                                }
                            }
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException unused11) {
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused12) {
                                }
                            }
                            if (httpURLConnection == null) {
                                throw th;
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } else {
                        dVar.f4412a = false;
                        a(2);
                        inputStream = null;
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.getFD().sync();
                        } catch (IOException unused13) {
                        }
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused14) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused15) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (IOException e4) {
                e = e4;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                inputStream = null;
            }
            httpURLConnection.disconnect();
        }

        @Override // com.beizi.ad.internal.e.b.a
        public void a(InterfaceC0117b interfaceC0117b) {
            this.b = interfaceC0117b;
        }

        @Override // com.beizi.ad.internal.e.b.a
        public void a(d dVar) {
            if (!dVar.f4412a) {
                d dVar2 = this.e;
                if (dVar2 != null && !dVar.equals(dVar2)) {
                    this.e.b = true;
                }
                this.e = dVar;
                dVar.a();
                Handler handler = this.c;
                if (handler != null) {
                    handler.post(this);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Invalid request,it's downloading");
        }

        @Override // com.beizi.ad.internal.e.b.a
        public void a() {
            HandlerThread handlerThread = this.f4408a;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.c = null;
            this.f4408a = null;
        }

        private void a(final long j, final long j2) {
            this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.b != null) {
                        c.this.b.a(j, j2);
                    }
                }
            });
        }

        private boolean a(File file) {
            InterfaceC0117b interfaceC0117b = this.b;
            return interfaceC0117b != null && interfaceC0117b.a(file);
        }

        private void a(final int i) {
            this.d.post(new Runnable() { // from class: com.beizi.ad.internal.e.b.c.3
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.b != null) {
                        c.this.b.a(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f4412a;
        public volatile boolean b;
        public volatile boolean c;
        private String d;
        private String e;
        private String f;
        private volatile long g;
        private volatile long h;

        public d(String str, String str2, String str3) {
            this.d = str;
            this.e = str2;
            this.f = str3;
            a();
        }

        public void a() {
            this.g = 0L;
            this.h = 0L;
            this.b = false;
            this.c = false;
            this.f4412a = false;
        }
    }

    public static a a() {
        return new c();
    }
}
