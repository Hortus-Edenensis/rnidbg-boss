package defpackage;

import android.os.Handler;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pi7 extends rl7 {
    public pi7(Handler handler, long j, long j2) {
        super(handler, j, j2);
    }

    @Override // java.lang.Runnable
    public void run() {
        String strD = uh7.j().d();
        if (TextUtils.isEmpty(strD) || "0".equals(strD)) {
            d(a());
            mf7.b("[DeviceIdTask] did is null, continue check.");
        } else {
            uh7.c().b(strD);
            mf7.b("[DeviceIdTask] did is ".concat(String.valueOf(strD)));
        }
    }
}
