package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class lj0 {
    public static final lj0 b = new lj0(new a(), false);
    public static final lj0 c = new lj0(new b(), false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f19010a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements c {
        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(nj0 nj0Var) {
            nj0Var.a(cn5.c());
            nj0Var.onCompleted();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements c {
        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(nj0 nj0Var) {
            nj0Var.a(cn5.c());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c extends c5<nj0> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d extends s42<nj0, nj0> {
    }

    public lj0(c cVar, boolean z) {
        this.f19010a = z ? kz4.d(cVar) : cVar;
    }
}
