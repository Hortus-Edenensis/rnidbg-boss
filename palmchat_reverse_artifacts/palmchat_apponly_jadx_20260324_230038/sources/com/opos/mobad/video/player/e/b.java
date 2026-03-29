package com.opos.mobad.video.player.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.mobad.template.a f10325a;
    public final com.opos.mobad.template.a b;
    public final com.opos.mobad.template.a c;
    public final com.opos.mobad.template.a d;
    public final boolean e;
    public final com.opos.mobad.video.player.b f;
    public final com.opos.mobad.ui.feedback.a g;
    public final boolean h;
    public final com.opos.mobad.video.player.c.a i;
    public final com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> j;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> f10326a;
        private com.opos.mobad.template.a b;
        private com.opos.mobad.video.player.b c;
        private com.opos.mobad.template.a d;
        private com.opos.mobad.ui.feedback.a e;
        private com.opos.mobad.template.a f = null;
        private com.opos.mobad.template.a g = null;
        private com.opos.mobad.video.player.c.a h = null;
        private boolean i = false;
        private boolean j = true;

        public a(com.opos.mobad.template.a aVar, com.opos.mobad.video.player.b bVar, com.opos.mobad.ui.feedback.a aVar2) {
            this.b = aVar;
            this.c = bVar;
            this.e = aVar2;
        }

        public a a(com.opos.mobad.template.a aVar) {
            this.f = aVar;
            return this;
        }

        public a b(com.opos.mobad.template.a aVar) {
            this.g = aVar;
            return this;
        }

        public a c(com.opos.mobad.template.a aVar) {
            this.d = aVar;
            return this;
        }

        public a a(com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar) {
            this.f10326a = aVar;
            return this;
        }

        public a b(boolean z) {
            this.j = z;
            return this;
        }

        public a a(com.opos.mobad.video.player.c.a aVar) {
            this.h = aVar;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.b = aVar.b;
        this.f = aVar.c;
        this.f10325a = aVar.d;
        this.g = aVar.e;
        this.c = aVar.f;
        this.d = aVar.g;
        this.e = aVar.i;
        this.h = aVar.j;
        this.i = aVar.h;
        this.j = aVar.f10326a;
    }

    public void a() {
        com.opos.mobad.ui.feedback.a aVar = this.g;
        if (aVar != null) {
            aVar.a();
        }
        com.opos.mobad.template.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.d();
        }
        com.opos.mobad.video.player.b bVar = this.f;
        if (bVar != null) {
            bVar.c();
        }
        com.opos.mobad.template.a aVar3 = this.c;
        if (aVar3 != null) {
            aVar3.d();
        }
        com.opos.mobad.template.a aVar4 = this.d;
        if (aVar4 != null) {
            aVar4.d();
        }
        com.opos.mobad.video.player.c.a aVar5 = this.i;
        if (aVar5 != null) {
            aVar5.e();
        }
    }
}
