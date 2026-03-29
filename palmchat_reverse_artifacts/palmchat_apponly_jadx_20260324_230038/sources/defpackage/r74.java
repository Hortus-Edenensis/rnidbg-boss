package defpackage;

import defpackage.n54;
import defpackage.x25;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class r74 implements n54.a<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20408a;
    public final TimeUnit b;
    public final x25 c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sm5 f20409a;

        public a(sm5 sm5Var) {
            this.f20409a = sm5Var;
        }

        @Override // defpackage.b5
        public void call() {
            try {
                this.f20409a.onNext(0L);
                this.f20409a.onCompleted();
            } catch (Throwable th) {
                yn1.e(th, this.f20409a);
            }
        }
    }

    public r74(long j, TimeUnit timeUnit, x25 x25Var) {
        this.f20408a = j;
        this.b = timeUnit;
        this.c = x25Var;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(sm5<? super Long> sm5Var) {
        x25.a aVarA = this.c.a();
        sm5Var.add(aVarA);
        aVarA.b(new a(sm5Var), this.f20408a, this.b);
    }
}
