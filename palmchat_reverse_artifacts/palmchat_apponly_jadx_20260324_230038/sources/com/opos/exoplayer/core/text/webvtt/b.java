package com.opos.exoplayer.core.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.opos.exoplayer.core.text.Cue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b extends Cue {
    public final long m;
    public final long n;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f8355a;
        private long b;
        private SpannableStringBuilder c;
        private Layout.Alignment d;
        private float e;
        private int f;
        private int g;
        private float h;
        private int i;
        private float j;

        public a() {
            a();
        }

        private a c() {
            Layout.Alignment alignment = this.d;
            if (alignment == null) {
                this.i = Integer.MIN_VALUE;
            } else {
                int i = C0704b.f8356a[alignment.ordinal()];
                if (i == 1) {
                    this.i = 0;
                } else if (i == 2) {
                    this.i = 1;
                } else if (i != 3) {
                    com.opos.cmn.an.f.a.c("WebvttCueBuilder", "Unrecognized alignment: " + this.d);
                    this.i = 0;
                } else {
                    this.i = 2;
                }
            }
            return this;
        }

        public a a(float f) {
            this.e = f;
            return this;
        }

        public a b(float f) {
            this.h = f;
            return this;
        }

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a b(int i) {
            this.g = i;
            return this;
        }

        public a c(float f) {
            this.j = f;
            return this;
        }

        public a a(long j) {
            this.f8355a = j;
            return this;
        }

        public a b(long j) {
            this.b = j;
            return this;
        }

        public a c(int i) {
            this.i = i;
            return this;
        }

        public a a(Layout.Alignment alignment) {
            this.d = alignment;
            return this;
        }

        public b b() {
            if (this.h != Float.MIN_VALUE && this.i == Integer.MIN_VALUE) {
                c();
            }
            return new b(this.f8355a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public a a(SpannableStringBuilder spannableStringBuilder) {
            this.c = spannableStringBuilder;
            return this;
        }

        public void a() {
            this.f8355a = 0L;
            this.b = 0L;
            this.c = null;
            this.d = null;
            this.e = Float.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = Float.MIN_VALUE;
            this.i = Integer.MIN_VALUE;
            this.j = Float.MIN_VALUE;
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.text.webvtt.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class C0704b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8356a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f8356a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8356a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8356a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public boolean a() {
        return this.d == Float.MIN_VALUE && this.g == Float.MIN_VALUE;
    }

    public b(long j, long j2, CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.m = j;
        this.n = j2;
    }

    public b(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }
}
