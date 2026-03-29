package cn.fly.verify;

import android.os.SystemClock;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FileOutputStream f2373a;
    private FileLock b;

    public synchronized void a() {
        FileLock fileLock = this.b;
        if (fileLock == null) {
            return;
        }
        try {
            fileLock.release();
        } catch (Throwable unused) {
        }
        this.b = null;
    }

    public synchronized void b() {
        if (this.f2373a == null) {
            return;
        }
        a();
        try {
            this.f2373a.close();
        } catch (Throwable unused) {
        }
        this.f2373a = null;
    }

    private boolean b(boolean z) throws Throwable {
        this.b = z ? this.f2373a.getChannel().lock() : this.f2373a.getChannel().tryLock();
        return this.b != null;
    }

    public synchronized void a(String str) {
        try {
            this.f2373a = new FileOutputStream(str);
        } catch (Throwable unused) {
            FileOutputStream fileOutputStream = this.f2373a;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                this.f2373a = null;
            }
        }
    }

    public synchronized boolean a(boolean z) {
        return a(z, z ? 1000L : 500L, 16L);
    }

    public synchronized boolean a(boolean z, long j, long j2) {
        boolean zB;
        if (this.f2373a == null) {
            return false;
        }
        try {
            return b(z);
        } catch (Throwable th) {
            if (j <= 0 || !(th instanceof OverlappingFileLockException)) {
                en.a().b(th);
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
                while (true) {
                    if (j <= 0) {
                        zB = false;
                        break;
                    }
                    try {
                        Thread.sleep(j2);
                    } catch (Throwable unused) {
                    }
                    try {
                        j = jElapsedRealtime - SystemClock.elapsedRealtime();
                        zB = b(z);
                        break;
                    } catch (Throwable th2) {
                        if (!(th2 instanceof OverlappingFileLockException)) {
                            en.a().b(th);
                            j = -1;
                        } else if (j <= 0) {
                            en.a().b("OverlappingFileLockException and timeout");
                        }
                    }
                }
                if (j > 0) {
                    return zB;
                }
            }
            FileLock fileLock = this.b;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Throwable unused2) {
                }
                this.b = null;
            }
            FileOutputStream fileOutputStream = this.f2373a;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused3) {
                }
                this.f2373a = null;
            }
            return false;
        }
    }
}
