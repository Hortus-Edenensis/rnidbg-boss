package defpackage;

import android.os.Process;
import com.cdadata.sdk.api.ZMDataSDKManager;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class f57 implements Thread.UncaughtExceptionHandler {
    public static volatile f57 b;
    public static final List<q57> c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f17461a = Thread.getDefaultUncaughtExceptionHandler();

    public f57() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            Iterator<q57> it = c.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Exception e) {
                    g57.a(e);
                }
            }
            ZMDataSDKManager.getInstance().getZmUploadEvent().a();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
                g57.a(e2);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f17461a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                Process.killProcess(Process.myPid());
                System.exit(1);
            }
        } catch (Exception unused) {
        }
    }
}
