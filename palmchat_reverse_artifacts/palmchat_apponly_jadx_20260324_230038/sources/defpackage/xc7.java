package defpackage;

import android.content.Context;
import com.bytedance.u.nr.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class xc7 implements ni7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21932a;

    public xc7(Context context) {
        this.f21932a = context;
    }

    @Override // defpackage.ni7
    public void a(long j, Thread thread, Throwable th) throws Throwable {
        ql7 ql7VarG = ql7.g(j, this.f21932a, thread, th);
        Context context = this.f21932a;
        fx fxVar = fx.JAVA;
        z07.f(context, fxVar.u(), Thread.currentThread().getName());
        hl7.c().b(fj7.b().c(fxVar, ql7VarG).d());
    }

    @Override // defpackage.ni7
    public boolean u(Throwable th) {
        return true;
    }
}
