package com.ss.android.ttvecamera;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TECameraExceptionMonitor {
    private static WeakReference<IExceptionMonitor> sExceptionMonitor;

    /* JADX INFO: compiled from: SearchBox */
    public interface IExceptionMonitor {
        void onException(Throwable th);
    }

    public static void monitorException(Throwable th) {
        WeakReference<IExceptionMonitor> weakReference = sExceptionMonitor;
        IExceptionMonitor iExceptionMonitor = weakReference == null ? null : weakReference.get();
        if (iExceptionMonitor != null) {
            iExceptionMonitor.onException(th);
        }
    }

    public static void register(IExceptionMonitor iExceptionMonitor) {
        sExceptionMonitor = iExceptionMonitor == null ? null : new WeakReference<>(iExceptionMonitor);
    }
}
