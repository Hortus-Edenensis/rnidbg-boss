package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class dl extends ae.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f11509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Context f268a;

    public dl(Context context, int i) {
        this.f11509a = i;
        this.f268a = context;
    }

    private String d() {
        return "dc_job_result_" + mo207a();
    }

    public abstract gh a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m295a() {
        return di.a(this.f268a, String.valueOf(mo207a()), this.f11509a);
    }

    public abstract String b();

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m296b() {
        return true;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m297c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (m295a()) {
            com.xiaomi.channel.commonutils.logger.b.m74a("DC run job mutual: " + mo207a());
            return;
        }
        df dfVarM293a = dg.a().m293a();
        String strA = dfVarM293a == null ? "" : dfVarM293a.a();
        if (!TextUtils.isEmpty(strA) && m296b()) {
            if (m297c()) {
                SharedPreferences sharedPreferences = this.f268a.getSharedPreferences("mipush_extra", 0);
                if (bb.a(strB).equals(sharedPreferences.getString(d(), null))) {
                    long j = sharedPreferences.getLong(c(), 0L);
                    int iA = com.xiaomi.push.service.ah.a(this.f268a).a(gk.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.f11509a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j) / 1000 < iA) {
                        strB = "same_" + j;
                    }
                }
            }
            gn gnVar = new gn();
            gnVar.a(strB);
            gnVar.a(System.currentTimeMillis());
            gnVar.a(a());
            a(this.f268a, gnVar, strA);
        }
    }

    private String c() {
        return "dc_job_result_time_" + mo207a();
    }

    public static void a(Context context, gn gnVar) {
        df dfVarM293a = dg.a().m293a();
        String strA = dfVarM293a == null ? "" : dfVarM293a.a();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(gnVar.a())) {
            return;
        }
        a(context, gnVar, strA);
    }

    private static void a(Context context, gn gnVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] bArrB = di.b(str, hp.a(gnVar));
        if (bArrB == null || bArrB.length == 0) {
            return;
        }
        synchronized (dj.f11506a) {
            FileLock fileLock = null;
            BufferedOutputStream bufferedOutputStream2 = null;
            fileLock = null;
            fileLock = null;
            fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), "push_cdata.lock");
                    w.m789a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock fileLockLock = randomAccessFile.getChannel().lock();
                        try {
                            File file2 = new File(context.getFilesDir(), "push_cdata.data");
                            if (v.m788a(file2)) {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                                try {
                                    bufferedOutputStream.write(y.a(bArrB.length));
                                    bufferedOutputStream.write(bArrB);
                                    bufferedOutputStream.flush();
                                    file2.setLastModified(0L);
                                    bufferedOutputStream2 = bufferedOutputStream;
                                } catch (IOException e) {
                                    e = e;
                                    fileLock = fileLockLock;
                                    try {
                                        e.printStackTrace();
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException unused) {
                                            }
                                        }
                                        w.a(bufferedOutputStream);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        w.a(bufferedOutputStream);
                                        w.a(randomAccessFile);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileLock = fileLockLock;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    w.a(bufferedOutputStream);
                                    w.a(randomAccessFile);
                                    throw th;
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            w.a(bufferedOutputStream2);
                        } catch (IOException e2) {
                            e = e2;
                            bufferedOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = null;
                randomAccessFile = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
                randomAccessFile = null;
            }
            w.a(randomAccessFile);
        }
    }
}
