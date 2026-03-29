package com.opos.cmn.an.i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f7796a;
    public final ExecutorService b;
    public final ExecutorService c;
    public final ExecutorService d;
    public final ExecutorService e;
    public final ScheduledExecutorService f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ExecutorService f7797a;
        private ExecutorService b;
        private ExecutorService c;
        private ExecutorService d;
        private ExecutorService e;
        private ScheduledExecutorService f;

        public a a(ExecutorService executorService) {
            this.f7797a = executorService;
            return this;
        }

        public a b(ExecutorService executorService) {
            this.b = executorService;
            return this;
        }

        public a c(ExecutorService executorService) {
            this.c = executorService;
            return this;
        }

        public a d(ExecutorService executorService) {
            this.d = executorService;
            return this;
        }

        public a e(ExecutorService executorService) {
            this.e = executorService;
            return this;
        }

        public a a(ScheduledExecutorService scheduledExecutorService) {
            this.f = scheduledExecutorService;
            return this;
        }

        private void b() {
            if (this.f7797a == null) {
                this.f7797a = com.opos.cmn.an.i.a.a();
            }
            if (this.b == null) {
                this.b = com.opos.cmn.an.i.a.b();
            }
            if (this.c == null) {
                this.c = com.opos.cmn.an.i.a.d();
            }
            if (this.d == null) {
                this.d = com.opos.cmn.an.i.a.c();
            }
            if (this.e == null) {
                this.e = com.opos.cmn.an.i.a.e();
            }
            if (this.f == null) {
                this.f = com.opos.cmn.an.i.a.f();
            }
        }

        public d a() {
            b();
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f7796a = aVar.f7797a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "ThreadPoolParams{netExecutorService=" + this.f7796a + ", ioExecutorService=" + this.b + ", bizExecutorService=" + this.c + ", dlExecutorService=" + this.d + ", singleExecutorService=" + this.e + ", scheduleExecutorService=" + this.f + '}';
    }
}
