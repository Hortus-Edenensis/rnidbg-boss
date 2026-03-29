package defpackage;

import android.os.Handler;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class t37 extends iv6 {
    public t37(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (x97.h().c()) {
            kj7.a("[DeviceIdTask] did is done, stop check.");
            return;
        }
        String strF = x97.a().f();
        if (TextUtils.isEmpty(strF) || "0".equals(strF)) {
            b(d());
            str = "[DeviceIdTask] did is null, continue check.";
        } else {
            x97.h().b(strF);
            str = "[DeviceIdTask] did is " + strF;
        }
        kj7.a(str);
    }
}
