package defpackage;

import android.os.Process;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ee7 {
    public static int a() {
        try {
            return new File(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/fd").listFiles().length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
