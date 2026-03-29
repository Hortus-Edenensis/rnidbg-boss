package defpackage;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.framework.R$drawable;
import defpackage.je1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class hr2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static je1 f18034a;
    public static je1 b;
    public static je1 c;
    public static je1 d;
    public static je1 e;
    public static je1 f;
    public static je1 g;
    public static je1 h;
    public static je1 i;
    public static je1 j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ut {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f18035a;
        public final /* synthetic */ int b;

        public a(float f, int i) {
            this.f18035a = f;
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ut {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f18036a;
        public final /* synthetic */ int b;

        public b(float f, int i) {
            this.f18036a = f;
            this.b = i;
        }
    }

    public static je1 a() {
        if (c == null) {
            c = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.ARGB_8888).A(R$drawable.ic_gallery_background).w(ImageScaleType.EXACTLY).r();
        }
        return c;
    }

    public static je1 b(boolean z) {
        return z ? a() : c();
    }

    public static je1 c() {
        if (d == null) {
            d = new je1.a().s(true).t(false).u(true).q(Bitmap.Config.ARGB_8888).A(R$drawable.ic_gallery_background).w(ImageScaleType.EXACTLY).r();
        }
        return d;
    }

    public static je1 d(float f2, int i2) {
        je1.a aVarW = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.EXACTLY);
        int i3 = R$drawable.ic_default_link;
        return aVarW.B(i3).z(i3).A(i3).x(new b(f2, i2)).r();
    }

    public static je1 e() {
        if (g == null) {
            je1.a aVarW = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.EXACTLY);
            int i2 = R$drawable.ic_default_link;
            g = aVarW.B(i2).z(i2).A(i2).r();
        }
        return g;
    }

    public static je1 f(float f2, int i2) {
        je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
        int i3 = R$drawable.ic_details_pic;
        return aVarQ.B(i3).A(i3).z(i3).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).x(new a(f2, i2)).r();
    }

    public static je1 g() {
        if (b == null) {
            je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
            int i2 = R$drawable.ic_details_pic;
            b = aVarQ.B(i2).A(i2).z(i2).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        }
        return b;
    }

    public static je1 h() {
        if (f18034a == null) {
            f18034a = new je1.a().s(true).t(false).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.NONE).v(new bd5()).r();
        }
        return f18034a;
    }

    public static je1 i() {
        if (e == null) {
            je1.a aVarQ = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565);
            int i2 = R$drawable.default_portrait;
            e = aVarQ.B(i2).A(i2).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).z(i2).r();
        }
        return e;
    }

    public static je1 j() {
        if (i == null) {
            je1.a aVarW = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2);
            int i2 = R$drawable.smallvideo_cover_default;
            i = aVarW.B(i2).z(i2).A(i2).r();
        }
        return i;
    }

    public static je1 k() {
        if (f == null) {
            f = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.ARGB_8888).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        }
        return f;
    }

    public static je1 l() {
        if (h == null) {
            je1.a aVarW = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2);
            int i2 = R$drawable.video_default;
            h = aVarW.B(i2).z(i2).A(i2).r();
        }
        return h;
    }

    public static je1 m() {
        if (j == null) {
            j = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        }
        return j;
    }
}
