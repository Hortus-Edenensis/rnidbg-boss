package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBusException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class kg2 extends Handler implements wk4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bg4 f18685a;
    public final int b;
    public final an1 c;
    public boolean d;

    public kg2(an1 an1Var, Looper looper, int i) {
        super(looper);
        this.c = an1Var;
        this.b = i;
        this.f18685a = new bg4();
    }

    @Override // defpackage.wk4
    public void a(an5 an5Var, Object obj) {
        ag4 ag4VarA = ag4.a(an5Var, obj);
        synchronized (this) {
            this.f18685a.a(ag4VarA);
            if (!this.d) {
                this.d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                ag4 ag4VarB = this.f18685a.b();
                if (ag4VarB == null) {
                    synchronized (this) {
                        ag4VarB = this.f18685a.b();
                        if (ag4VarB == null) {
                            return;
                        }
                    }
                }
                this.c.g(ag4VarB);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.d = true;
        } finally {
            this.d = false;
        }
    }
}
