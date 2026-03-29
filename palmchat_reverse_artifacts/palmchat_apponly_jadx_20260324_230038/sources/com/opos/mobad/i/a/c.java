package com.opos.mobad.i.a;

import android.content.Context;
import com.opos.cmn.func.a.a.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8927a;
    private com.opos.mobad.i.a b;
    private long c;
    private long d;
    private CountDownLatch e;
    private boolean f = false;
    private long g;
    private int h;

    /* JADX INFO: compiled from: SearchBox */
    public class a {
        private RandomAccessFile b;

        public a(File file, long j) {
            if (file == null || -1 == j) {
                return;
            }
            com.opos.cmn.an.f.a.b("DownloadThread", "seekPos=" + j);
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                this.b = randomAccessFile;
                randomAccessFile.seek(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
            }
        }

        public synchronized int a(byte[] bArr, int i, int i2) {
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.write(bArr, i, i2);
                } catch (IOException e) {
                    com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
                    i2 = -1;
                    return i2;
                }
            } else {
                i2 = -1;
            }
            return i2;
        }

        public synchronized void a() {
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
                }
            }
        }
    }

    public c(Context context, com.opos.mobad.i.a aVar, long j, long j2, long j3, CountDownLatch countDownLatch) {
        this.h = -1;
        this.f8927a = context.getApplicationContext();
        this.b = aVar;
        this.g = j;
        this.c = j2;
        this.d = j3;
        this.e = countDownLatch;
        this.h = hashCode();
    }

    public long a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public boolean c() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x013e A[Catch: all -> 0x01a3, Exception -> 0x01a5, DONT_GENERATE, PHI: r8
      0x013e: PHI (r8v18 com.opos.cmn.func.a.a.e) = (r8v17 com.opos.cmn.func.a.a.e), (r8v19 com.opos.cmn.func.a.a.e) binds: [B:47:0x0148, B:40:0x013c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x01a5, blocks: (B:3:0x0036, B:5:0x0041, B:7:0x004e, B:8:0x0051, B:41:0x013e, B:50:0x014d, B:51:0x0150, B:52:0x0151, B:54:0x0182, B:55:0x0188, B:56:0x018b, B:60:0x0195, B:61:0x019c), top: B:74:0x0036, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0182 A[Catch: all -> 0x01a3, Exception -> 0x01a5, TryCatch #4 {Exception -> 0x01a5, blocks: (B:3:0x0036, B:5:0x0041, B:7:0x004e, B:8:0x0051, B:41:0x013e, B:50:0x014d, B:51:0x0150, B:52:0x0151, B:54:0x0182, B:55:0x0188, B:56:0x018b, B:60:0x0195, B:61:0x019c), top: B:74:0x0036, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018b A[Catch: all -> 0x01a3, Exception -> 0x01a5, TryCatch #4 {Exception -> 0x01a5, blocks: (B:3:0x0036, B:5:0x0041, B:7:0x004e, B:8:0x0051, B:41:0x013e, B:50:0x014d, B:51:0x0150, B:52:0x0151, B:54:0x0182, B:55:0x0188, B:56:0x018b, B:60:0x0195, B:61:0x019c), top: B:74:0x0036, outer: #2 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        long j;
        long j2;
        long j3;
        String str;
        com.opos.cmn.an.f.a.b("DownloadThread", "start. threadId=" + this.h + " ,startPos=" + this.c + ",endPos=" + this.d);
        try {
            try {
                if (this.d + 1 > this.c) {
                    HashMap map = new HashMap();
                    Map<String, String> map2 = this.b.f8924a.c;
                    if (map2 != null) {
                        map.putAll(map2);
                    }
                    String str2 = "bytes=" + this.c + "-" + this.d;
                    com.opos.cmn.an.f.a.b("DownloadThread", "rangeProperty=" + str2);
                    map.put(HttpHeaders.RANGE, str2);
                    com.opos.cmn.func.a.a.e eVarA = null;
                    try {
                        try {
                            eVarA = com.opos.cmn.func.a.a.b.a().a(this.f8927a, new d.a().b(this.b.f8924a.b).a(map).a(this.b.f8924a.f7932a).a(this.b.f8924a.d).a());
                        } finally {
                            if (0 != 0) {
                                eVarA.a();
                            }
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
                        if (0 != 0) {
                        }
                        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " ,startPos=" + this.c + ",endPos=" + this.d);
                        j = this.d;
                        j2 = j + 1;
                        j3 = this.c;
                        if (j2 != j3) {
                        }
                        this.f = true;
                    }
                    if (eVarA != null) {
                        com.opos.cmn.an.f.a.b("DownloadThread", "httpResponseEntity.getResponseCode()=" + eVarA.f7934a);
                        int i = eVarA.f7934a;
                        if (206 == i || 200 == i) {
                            InputStream inputStream = eVarA.c;
                            if (inputStream != null) {
                                a aVar = new a(d.b(this.f8927a, this.b), this.c);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    try {
                                        int i2 = inputStream.read(bArr);
                                        if (-1 == i2 || this.c >= this.d) {
                                            break;
                                        }
                                        this.c += (long) aVar.a(bArr, 0, i2);
                                    } finally {
                                        try {
                                        } finally {
                                        }
                                    }
                                }
                            } else {
                                str = "InputStream is null.";
                            }
                        } else {
                            str = "httpResponseEntity.getResponseCode()=" + eVarA.f7934a;
                        }
                    } else {
                        str = "httpResponseEntity is null.";
                    }
                    com.opos.cmn.an.f.a.b("DownloadThread", str);
                }
                com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " ,startPos=" + this.c + ",endPos=" + this.d);
                j = this.d;
                j2 = j + 1;
                j3 = this.c;
            } catch (Throwable th) {
                this.e.countDown();
                throw th;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DownloadThread", "DownloadThread run", (Throwable) e2);
        }
        if (j2 != j3) {
            com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos+1,download success.");
        } else {
            if (this.g != j || j != j3) {
                com.opos.cmn.an.f.a.b("DownloadThread", "start!=endPos,download fail.");
                this.e.countDown();
                com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " end.");
            }
            com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos=contentLength,download success.");
        }
        this.f = true;
        this.e.countDown();
        com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " end.");
    }
}
