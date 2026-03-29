package com.opos.mobad.cmn.func.b.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8688a;
    private String b;
    private int c;
    private a d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8689a;
        private int b;
        private int c;
        private int d;
        private int e;

        public int a() {
            return this.f8689a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public String toString() {
            return "CountData{mockCount=" + this.f8689a + ", mockTouchEventCount=" + this.b + ", mockCallClickCount=" + this.c + ", mockPerformClickCount=" + this.d + ", interceptTimes=" + this.e + '}';
        }

        public void a(int i) {
            this.f8689a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void c(int i) {
            this.c = i;
        }

        public void d(int i) {
            this.d = i;
        }

        public void e(int i) {
            this.e = i;
        }
    }

    public int getCount() {
        return this.c;
    }

    public String toString() {
        return "ViewMockEvent{posId='" + this.f8688a + "', templateId='" + this.b + "', count=" + this.c + ", countData=" + this.d + '}';
    }
}
