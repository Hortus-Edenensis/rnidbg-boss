package defpackage;

import androidx.media3.common.util.HandlerWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pj4 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HandlerWrapper f20027a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f20027a.post(runnable);
    }
}
