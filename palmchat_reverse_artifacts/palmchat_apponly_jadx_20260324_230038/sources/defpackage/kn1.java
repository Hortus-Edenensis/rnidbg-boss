package defpackage;

import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.jn1;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0014\u0010\f\u001a\u00020\t8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkn1;", "Lin1;", "", WkAdxAdConfigMg.DSP_NAME_CSJ, "", "now", "Ljn1$a;", "delayedTask", WkAdxAdConfigMg.DSP_NAME_BAIDU, "Ljava/lang/Thread;", "y", "()Ljava/lang/Thread;", "thread", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class kn1 extends in1 {
    public void B(long now, jn1.a delayedTask) {
        c51.f.N(now, delayedTask);
    }

    public final void C() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            a2.a();
            LockSupport.unpark(thread);
        }
    }

    /* JADX INFO: renamed from: y */
    public abstract Thread getThread();
}
