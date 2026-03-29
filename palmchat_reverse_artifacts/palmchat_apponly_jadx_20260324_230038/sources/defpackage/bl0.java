package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bl0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f1743a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1743a.post(runnable);
    }
}
