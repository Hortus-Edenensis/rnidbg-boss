package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class je1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18390a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final ImageScaleType g;
    public final BitmapFactory.Options h;
    public final int i;
    public final boolean j;
    public final Object k;
    public final ut l;
    public final ut m;
    public final ot n;
    public final Handler o;
    public final boolean p;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18391a = 0;
        public int b = 0;
        public int c = 0;
        public Drawable d = null;
        public Drawable e = null;
        public Drawable f = null;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public ImageScaleType j = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        public BitmapFactory.Options k = new BitmapFactory.Options();
        public int l = 0;
        public boolean m = false;
        public Object n = null;
        public ut o = null;
        public ut p = null;
        public ot q = d41.a();
        public Handler r = null;
        public boolean s = false;

        public a() {
            BitmapFactory.Options options = this.k;
            options.inPurgeable = true;
            options.inInputShareable = true;
        }

        public a A(int i) {
            this.c = i;
            return this;
        }

        public a B(int i) {
            this.f18391a = i;
            return this;
        }

        public a q(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.k.inPreferredConfig = config;
            return this;
        }

        public je1 r() {
            return new je1(this);
        }

        public a s(boolean z) {
            this.h = z;
            return this;
        }

        public a t(boolean z) {
            this.i = z;
            return this;
        }

        public a u(boolean z) {
            this.m = z;
            return this;
        }

        public a v(ot otVar) {
            if (otVar == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.q = otVar;
            return this;
        }

        public a w(ImageScaleType imageScaleType) {
            this.j = imageScaleType;
            return this;
        }

        public a x(ut utVar) {
            this.p = utVar;
            return this;
        }

        public a y(boolean z) {
            this.g = z;
            return this;
        }

        public a z(int i) {
            this.b = i;
            return this;
        }
    }

    public int a(Resources resources) {
        return this.c;
    }

    public int b(Resources resources) {
        return this.f18390a;
    }

    public ImageScaleType c() {
        return this.g;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    public je1(a aVar) {
        this.f18390a = aVar.f18391a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.g;
        this.e = aVar.h;
        this.f = aVar.i;
        this.g = aVar.j;
        this.h = aVar.k;
        this.i = aVar.l;
        this.j = aVar.m;
        this.k = aVar.n;
        this.l = aVar.o;
        this.m = aVar.p;
        this.n = aVar.q;
        this.o = aVar.r;
        this.p = aVar.s;
    }
}
