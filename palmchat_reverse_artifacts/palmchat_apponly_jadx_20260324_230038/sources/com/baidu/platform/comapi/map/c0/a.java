package com.baidu.platform.comapi.map.c0;

import android.view.MotionEvent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0104a f4185a = new C0104a(new b(0.0d, 0.0d), new b(1.0d, 0.0d));
    public static final C0104a b = new C0104a(new b(0.0d, 0.0d), new b(0.0d, 1.0d));
    public static final C0104a c = new C0104a(new b(0.0d, 1.0d), new b(0.0d, 0.0d));

    /* JADX INFO: renamed from: com.baidu.platform.comapi.map.c0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0104a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f4186a;
        public b b;

        public C0104a(b bVar, b bVar2) {
            this.f4186a = bVar;
            this.b = bVar2;
        }

        public b a() {
            b bVar = this.f4186a;
            double d = bVar.f4187a;
            b bVar2 = this.b;
            return new b((d + bVar2.f4187a) / 2.0d, (bVar.b + bVar2.b) / 2.0d);
        }

        public double b() {
            b bVar = this.f4186a;
            double d = bVar.f4187a;
            b bVar2 = this.b;
            double d2 = d - bVar2.f4187a;
            double d3 = bVar.b - bVar2.b;
            return Math.sqrt((d2 * d2) + (d3 * d3));
        }

        public d c() {
            b bVar = this.b;
            double d = bVar.f4187a;
            b bVar2 = this.f4186a;
            return new d(d - bVar2.f4187a, bVar.b - bVar2.b);
        }

        public String toString() {
            return C0104a.class.getSimpleName() + "  a : " + this.f4186a.toString() + " b : " + this.b.toString();
        }

        public static C0104a a(MotionEvent motionEvent) {
            return new C0104a(new b(motionEvent.getX(0), motionEvent.getY(0)), new b(motionEvent.getX(1), motionEvent.getY(1)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f4187a;
        public double b;

        public b(double d, double d2) {
            this.f4187a = d;
            this.b = d2;
        }

        public String toString() {
            return b.class.getSimpleName() + " x : " + this.f4187a + " y : " + this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f4188a;
        public final double b;
        public final d c;

        public c(C0104a c0104a, C0104a c0104a2) {
            this.c = new d(c0104a.a(), c0104a2.a());
            this.b = c0104a2.b() / c0104a.b();
            this.f4188a = d.a(c0104a.c(), c0104a2.c());
        }

        public String toString() {
            return c.class.getSimpleName() + " rotate : " + this.f4188a + " scale : " + (this.b * 100.0d) + " move : " + this.c.toString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f4189a;
        public double b;

        public d(double d, double d2) {
            this.f4189a = d;
            this.b = d2;
        }

        public static double a(d dVar, d dVar2) {
            double dAtan2 = Math.atan2(dVar.b, dVar.f4189a) - Math.atan2(dVar2.b, dVar2.f4189a);
            if (dAtan2 > 3.141592653589793d) {
                dAtan2 -= 6.283185307179586d;
            } else if (dAtan2 < -3.141592653589793d) {
                dAtan2 += 6.283185307179586d;
            }
            return (dAtan2 * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return d.class.getSimpleName() + " x : " + this.f4189a + " y : " + this.b;
        }

        public d(b bVar, b bVar2) {
            this.f4189a = bVar2.f4187a - bVar.f4187a;
            this.b = bVar2.b - bVar.b;
        }
    }
}
