package com.opos.mobad.ad.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8530a;
    public final int b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8531a = 0;
        private int b = 0;

        public a a(int i) {
            this.f8531a = i;
            return this;
        }

        public a b(int i) {
            this.b = i;
            return this;
        }

        public s a() {
            return new s(this);
        }
    }

    public s(a aVar) {
        this.f8530a = aVar.f8531a;
        this.b = aVar.b;
    }

    public String toString() {
        return "NativeAdSize{widthInDp=" + this.f8530a + ", heightInDp=" + this.b + '}';
    }
}
