package com.kwad.sdk.crash.handler;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Keep
public final class NativeCrashHandler extends b {
    private static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    private static final String TAG = "NativeCrashHandler";
    private static ExceptionMessage mMessage = new NativeExceptionMessage();
    private File mMessageFile;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final NativeCrashHandler aUe = new NativeCrashHandler();
    }

    public static native void doCrash();

    public static native void doFakeCrash();

    public static native void doMemoryCorruption();

    public static native void doNativeFdOverLimitCrash();

    public static NativeCrashHandler getInstance() {
        return a.aUe;
    }

    public static native void install(@NonNull String str, @NonNull String str2, int i);

    /* JADX WARN: Removed duplicated region for block: B:45:0x0214 A[Catch: all -> 0x0229, TRY_LEAVE, TryCatch #2 {all -> 0x0229, blocks: (B:42:0x01c0, B:43:0x01ea, B:45:0x0214), top: B:73:0x01c0, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void onCallFromNative(long j) {
        com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative");
        b.isExceptionHappened.set(true);
        b.sCrashingPid = String.valueOf(Process.myPid());
        File file = getInstance().mLogDir;
        File file2 = getInstance().mLogcatFile;
        File file3 = getInstance().mMessageFile;
        File file4 = getInstance().mJavaTraceFile;
        File file5 = getInstance().mMemoryInfoFile;
        e uploader = getInstance().getUploader();
        try {
            if (!file.exists() && !file.mkdirs()) {
                StringBuilder sb = new StringBuilder();
                ExceptionMessage exceptionMessage = mMessage;
                sb.append(exceptionMessage.mErrorMessage);
                sb.append("create ");
                sb.append(file.getPath());
                sb.append(" failed!\n");
                exceptionMessage.mErrorMessage = sb.toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            if (!getInstance().mDumpDir.exists() && !getInstance().mDumpDir.mkdirs()) {
                StringBuilder sb2 = new StringBuilder();
                ExceptionMessage exceptionMessage2 = mMessage;
                sb2.append(exceptionMessage2.mErrorMessage);
                sb2.append("create ");
                sb2.append(getInstance().mDumpDir.getPath());
                sb2.append(" failed!\n");
                exceptionMessage2.mErrorMessage = sb2.toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            if (file2 == null) {
                file2 = new File(getInstance().mDumpDir, "logcat");
            }
            if (file3 == null) {
                file3 = new File(getInstance().mDumpDir, "message");
            }
            if (file4 == null) {
                file4 = new File(getInstance().mDumpDir, "all_java_backtrace");
            }
            if (file5 == null) {
                file5 = new File(getInstance().mDumpDir, "meminfo");
            }
            g.b(null, mMessage, com.kwad.sdk.crash.e.Nj().getContext());
            g.a(mMessage, getInstance().getCrashType());
            mMessage.mLogUUID = g.gk(getInstance().mDumpDir.getName());
            try {
                com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative write message " + mMessage.toJson().toString());
                g.a(file3, mMessage.toJson().toString());
                g.H(file4);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpDir);
                getInstance().uploadRemainingExceptions();
                g.I(file5);
                g.F(file2);
                if (getInstance().mExceptionListener != null) {
                    getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                if (uploader != null) {
                    g.q(th);
                }
            }
        } catch (Throwable th2) {
            try {
                StringBuilder sb3 = new StringBuilder();
                ExceptionMessage exceptionMessage3 = mMessage;
                sb3.append(exceptionMessage3.mErrorMessage);
                sb3.append(th2);
                exceptionMessage3.mErrorMessage = sb3.toString();
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", Log.getStackTraceString(th2));
                if (file3 != null) {
                    try {
                        com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative write message " + mMessage.toJson().toString());
                        g.a(file3, mMessage.toJson().toString());
                        g.H(file4);
                        getInstance().backupLogFiles(file);
                        g.a(uploader, TAG, getInstance().mDumpDir);
                        getInstance().uploadRemainingExceptions();
                        g.I(file5);
                        g.F(file2);
                        if (getInstance().mExceptionListener == null) {
                            getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
                        if (uploader != null) {
                            g.q(th3);
                            return;
                        }
                        return;
                    }
                }
                g.H(file4);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpDir);
                getInstance().uploadRemainingExceptions();
                g.I(file5);
                g.F(file2);
                if (getInstance().mExceptionListener == null) {
                }
            } finally {
                if (file3 != null) {
                    try {
                    } catch (Throwable th4) {
                    }
                }
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final int getCrashType() {
        return 4;
    }

    public final void init(@NonNull File file, boolean z, @NonNull final String str, com.kwad.sdk.crash.report.c cVar) {
        super.init(file, null, cVar);
        if (com.kwad.sdk.crash.b.MU()) {
            this.mLogDir = file;
            if (!file.exists()) {
                this.mLogDir.mkdirs();
            }
            this.mDumpDir = new File(file, b.FILE_NAME_BASE + "-native-0");
            this.mLogcatFile = new File(this.mDumpDir, "logcat");
            this.mMessageFile = new File(this.mDumpDir, "message");
            this.mJavaTraceFile = new File(this.mDumpDir, "all_java_backtrace");
            this.mMemoryInfoFile = new File(this.mDumpDir, "meminfo");
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.kwad.sdk.crash.handler.NativeCrashHandler.1
                        @Override // android.os.MessageQueue.IdleHandler
                        public final boolean queueIdle() {
                            com.kwad.sdk.core.d.c.d(NativeCrashHandler.TAG, "native install in idle" + NativeCrashHandler.this.mDumpDir.getPath());
                            NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), str, Build.VERSION.SDK_INT);
                            return false;
                        }
                    });
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.kwad.sdk.crash.handler.NativeCrashHandler.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.c.e(NativeCrashHandler.TAG, "native install in main:" + NativeCrashHandler.this.mDumpDir.getPath());
                            NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), str, Build.VERSION.SDK_INT);
                        }
                    });
                }
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(getUploader());
        for (File file : fileArr) {
            gVar.a(file, countDownLatch);
        }
    }

    private NativeCrashHandler() {
    }
}
