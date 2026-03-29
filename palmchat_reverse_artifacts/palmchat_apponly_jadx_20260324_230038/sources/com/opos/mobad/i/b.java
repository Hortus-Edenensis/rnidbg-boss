package com.opos.mobad.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8930a;
    public final long b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8931a = false;
        private long b = -1;

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a a(boolean z) {
            this.f8931a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f8930a = aVar.f8931a;
        this.b = aVar.b;
    }

    public String toString() {
        return "DownloadResponse{success=" + this.f8930a + ", contentLength=" + this.b + '}';
    }
}
