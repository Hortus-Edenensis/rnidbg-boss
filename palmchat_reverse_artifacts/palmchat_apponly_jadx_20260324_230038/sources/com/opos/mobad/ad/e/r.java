package com.opos.mobad.ad.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8528a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f8529a = 30000;

        public a a(long j) {
            if (j >= 500 && j <= 30000) {
                this.f8529a = j;
            }
            return this;
        }

        public r a() {
            return new r(this);
        }
    }

    public r(a aVar) {
        this.f8528a = aVar.f8529a;
    }

    public String toString() {
        return "NativeAdParams{fetchTimeout=" + this.f8528a + '}';
    }
}
