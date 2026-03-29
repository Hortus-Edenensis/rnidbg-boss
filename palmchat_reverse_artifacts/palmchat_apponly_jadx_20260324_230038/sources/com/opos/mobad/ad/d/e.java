package com.opos.mobad.ad.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8522a;
    public final boolean b;
    public final b c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8523a = true;
        private boolean b = false;
        private b c = b.NORMAL;

        public a a(b bVar) {
            this.c = bVar;
            return this;
        }

        public a b(boolean z) {
            this.b = z;
            return this;
        }

        public a a(boolean z) {
            this.f8523a = z;
            return this;
        }

        public e a() {
            return new e(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        NORMAL,
        INSTANT_EXIT
    }

    public e(a aVar) {
        this.f8522a = aVar.b;
        this.b = aVar.f8523a;
        this.c = aVar.c;
    }
}
