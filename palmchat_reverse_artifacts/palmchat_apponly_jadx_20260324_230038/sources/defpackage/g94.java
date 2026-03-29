package defpackage;

import defpackage.n54;
import defpackage.x25;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class g94<T> implements n54.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x25 f17684a;
    public final n54<T> b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements b5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sm5 f17685a;
        public final /* synthetic */ x25.a b;

        /* JADX INFO: renamed from: g94$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1196a extends sm5<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Thread f17686a;

            /* JADX INFO: renamed from: g94$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1197a implements kn4 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ kn4 f17687a;

                /* JADX INFO: renamed from: g94$a$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: SearchBox */
                public class C1198a implements b5 {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ long f17688a;

                    public C1198a(long j) {
                        this.f17688a = j;
                    }

                    @Override // defpackage.b5
                    public void call() {
                        C1197a.this.f17687a.request(this.f17688a);
                    }
                }

                public C1197a(kn4 kn4Var) {
                    this.f17687a = kn4Var;
                }

                @Override // defpackage.kn4
                public void request(long j) {
                    if (C1196a.this.f17686a == Thread.currentThread()) {
                        this.f17687a.request(j);
                    } else {
                        a.this.b.a(new C1198a(j));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1196a(sm5 sm5Var, Thread thread) {
                super(sm5Var);
                this.f17686a = thread;
            }

            @Override // defpackage.o54
            public void onCompleted() {
                try {
                    a.this.f17685a.onCompleted();
                } finally {
                    a.this.b.unsubscribe();
                }
            }

            @Override // defpackage.o54
            public void onError(Throwable th) {
                try {
                    a.this.f17685a.onError(th);
                } finally {
                    a.this.b.unsubscribe();
                }
            }

            @Override // defpackage.o54
            public void onNext(T t) {
                a.this.f17685a.onNext(t);
            }

            @Override // defpackage.sm5
            public void setProducer(kn4 kn4Var) {
                a.this.f17685a.setProducer(new C1197a(kn4Var));
            }
        }

        public a(sm5 sm5Var, x25.a aVar) {
            this.f17685a = sm5Var;
            this.b = aVar;
        }

        @Override // defpackage.b5
        public void call() {
            g94.this.b.x(new C1196a(this.f17685a, Thread.currentThread()));
        }
    }

    public g94(n54<T> n54Var, x25 x25Var) {
        this.f17684a = x25Var;
        this.b = n54Var;
    }

    @Override // defpackage.c5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(sm5<? super T> sm5Var) {
        x25.a aVarA = this.f17684a.a();
        sm5Var.add(aVarA);
        aVarA.a(new a(sm5Var, aVarA));
    }
}
