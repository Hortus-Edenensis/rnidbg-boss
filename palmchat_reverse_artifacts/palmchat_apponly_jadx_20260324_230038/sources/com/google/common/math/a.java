package com.google.common.math;

import defpackage.dm4;
import defpackage.ve1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f6241a;
        public final double b;

        public a a(double d) {
            dm4.d(!Double.isNaN(d));
            return ve1.c(d) ? new d(d, this.b - (this.f6241a * d)) : new e(this.f6241a);
        }

        public b(double d, double d2) {
            this.f6241a = d;
            this.b = d2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6242a = new c();

        public String toString() {
            return "NaN";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f6243a;
        public final double b;
        public a c = null;

        public d(double d, double d2) {
            this.f6243a = d;
            this.b = d2;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f6243a), Double.valueOf(this.b));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f6244a;
        public a b = null;

        public e(double d) {
            this.f6244a = d;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f6244a));
        }
    }

    public static a a() {
        return c.f6242a;
    }

    public static a b(double d2) {
        dm4.d(ve1.c(d2));
        return new d(0.0d, d2);
    }

    public static b c(double d2, double d3) {
        dm4.d(ve1.c(d2) && ve1.c(d3));
        return new b(d2, d3);
    }

    public static a d(double d2) {
        dm4.d(ve1.c(d2));
        return new e(d2);
    }
}
