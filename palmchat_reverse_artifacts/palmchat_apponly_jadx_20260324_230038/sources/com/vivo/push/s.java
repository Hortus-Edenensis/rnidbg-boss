package com.vivo.push;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f11282a;
    private int b;
    private v c;

    public s(v vVar) {
        this.b = -1;
        this.c = vVar;
        int iB = vVar.b();
        this.b = iB;
        if (iB < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f11282a = m.a().h();
    }

    public final int a() {
        return this.b;
    }

    public abstract void a(v vVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f11282a;
        if (context != null && !(this.c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.t.a(context, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        v vVar = this.c;
        sb.append(vVar == null ? "[null]" : vVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
