package cn.shuzilm.core;

import android.content.Context;
import android.os.Looper;
import android.telephony.TelephonyManager;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f2481a;
    final /* synthetic */ boolean b;

    public l(Context context, boolean z) {
        this.f2481a = context;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        FileOutputStream fileOutputStreamOpenFileOutput;
        FileLock fileLockTryLock = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.f2481a.openFileOutput("du.lock", 0);
                try {
                    fileLockTryLock = fileOutputStreamOpenFileOutput.getChannel().tryLock();
                    if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                        DUHelper.b(1);
                        DUHelper.e(DUHelper.mContext);
                        try {
                            System.loadLibrary(com.umeng.analytics.pro.f.ac);
                            if (!DUHelper.d.D) {
                                if (Looper.myLooper() == null) {
                                    Looper.prepare();
                                }
                                if (Looper.myLooper() != null) {
                                    ((TelephonyManager) DUHelper.mContext.getSystemService("phone")).listen(DUHelper.d, 256);
                                    if (this.b) {
                                        DUHelper.d.k(this.f2481a);
                                    }
                                }
                                DUHelper.m(DUHelper.mContext);
                            }
                            DUHelper.d.D = true;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        fileLockTryLock.release();
                        fileOutputStreamOpenFileOutput.close();
                        return;
                    }
                    if (fileLockTryLock != null) {
                        try {
                            fileLockTryLock.release();
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    fileOutputStreamOpenFileOutput.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (fileLockTryLock != null) {
                            fileLockTryLock.release();
                        }
                        if (fileOutputStreamOpenFileOutput != null) {
                            fileOutputStreamOpenFileOutput.close();
                        }
                    } catch (Throwable th3) {
                        if (fileLockTryLock != null) {
                            try {
                                fileLockTryLock.release();
                            } catch (Throwable unused2) {
                                throw th3;
                            }
                        }
                        if (fileOutputStreamOpenFileOutput != null) {
                            fileOutputStreamOpenFileOutput.close();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable unused3) {
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStreamOpenFileOutput = null;
        }
    }
}
