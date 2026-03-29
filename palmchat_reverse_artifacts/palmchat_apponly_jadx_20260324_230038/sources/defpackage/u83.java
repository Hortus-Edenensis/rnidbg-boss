package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.airbnb.lottie.RenderMode;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class u83 extends Drawable implements Drawable.Callback, Animatable {
    public Paint A;
    public Rect B;
    public Rect C;
    public RectF E;
    public RectF F;
    public Matrix G;
    public Matrix H;
    public boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u73 f21158a;
    public final h93 b;
    public boolean c;
    public boolean d;
    public boolean e;
    public c f;
    public final ArrayList<b> g;
    public final ValueAnimator.AnimatorUpdateListener h;

    @Nullable
    public uq2 i;

    @Nullable
    public String j;

    @Nullable
    public s02 k;
    public boolean l;
    public boolean m;
    public boolean n;

    @Nullable
    public com.airbnb.lottie.model.layer.b o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public RenderMode t;
    public boolean u;
    public final Matrix v;
    public Bitmap w;
    public Canvas x;
    public Rect y;
    public RectF z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (u83.this.o != null) {
                u83.this.o.L(u83.this.b.h());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(u73 u73Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        NONE,
        PLAY,
        RESUME
    }

    public u83() {
        h93 h93Var = new h93();
        this.b = h93Var;
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = c.NONE;
        this.g = new ArrayList<>();
        a aVar = new a();
        this.h = aVar;
        this.m = false;
        this.n = true;
        this.p = 255;
        this.t = RenderMode.AUTOMATIC;
        this.u = false;
        this.v = new Matrix();
        this.I = false;
        h93Var.addUpdateListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(b03 b03Var, Object obj, i93 i93Var, u73 u73Var) {
        u(b03Var, obj, i93Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(u73 u73Var) {
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(u73 u73Var) {
        I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(int i, u73 u73Var) {
        P0(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(int i, u73 u73Var) {
        U0(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(String str, u73 u73Var) {
        V0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(float f, u73 u73Var) {
        W0(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(int i, int i2, u73 u73Var) {
        X0(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(String str, u73 u73Var) {
        Y0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(String str, String str2, boolean z, u73 u73Var) {
        Z0(str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(float f, float f2, u73 u73Var) {
        a1(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(int i, u73 u73Var) {
        b1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(String str, u73 u73Var) {
        c1(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(float f, u73 u73Var) {
        d1(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(float f, u73 u73Var) {
        g1(f);
    }

    public final void A(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    @MainThread
    public void A0() {
        if (this.o == null) {
            this.g.add(new b() { // from class: h83
                @Override // u83.b
                public final void a(u73 u73Var) {
                    this.f17894a.l0(u73Var);
                }
            });
            return;
        }
        z();
        if (v() || Y() == 0) {
            if (isVisible()) {
                this.b.p();
                this.f = c.NONE;
            } else {
                this.f = c.PLAY;
            }
        }
        if (v()) {
            return;
        }
        P0((int) (a0() < 0.0f ? U() : T()));
        this.b.g();
        if (isVisible()) {
            return;
        }
        this.f = c.NONE;
    }

    public final void B(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public void B0() {
        this.b.removeAllListeners();
    }

    public void C0() {
        this.b.removeAllUpdateListeners();
        this.b.addUpdateListener(this.h);
    }

    public final void D(Canvas canvas) {
        com.airbnb.lottie.model.layer.b bVar = this.o;
        u73 u73Var = this.f21158a;
        if (bVar == null || u73Var == null) {
            return;
        }
        this.v.reset();
        if (!getBounds().isEmpty()) {
            this.v.preScale(r2.width() / u73Var.b().width(), r2.height() / u73Var.b().height());
        }
        bVar.d(canvas, this.v, this.p);
    }

    public void D0(Animator.AnimatorListener animatorListener) {
        this.b.removeListener(animatorListener);
    }

    public void E(boolean z) {
        if (this.l == z) {
            return;
        }
        this.l = z;
        if (this.f21158a != null) {
            w();
        }
    }

    @RequiresApi(api = 19)
    public void E0(Animator.AnimatorPauseListener animatorPauseListener) {
        this.b.removePauseListener(animatorPauseListener);
    }

    public boolean F() {
        return this.l;
    }

    public void F0(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.b.removeUpdateListener(animatorUpdateListener);
    }

    @MainThread
    public void G() {
        this.g.clear();
        this.b.g();
        if (isVisible()) {
            return;
        }
        this.f = c.NONE;
    }

    public final void G0(Canvas canvas, com.airbnb.lottie.model.layer.b bVar) {
        if (this.f21158a == null || bVar == null) {
            return;
        }
        I();
        canvas.getMatrix(this.G);
        canvas.getClipBounds(this.y);
        A(this.y, this.z);
        this.G.mapRect(this.z);
        B(this.z, this.y);
        if (this.n) {
            this.F.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            bVar.a(this.F, null, false);
        }
        this.G.mapRect(this.F);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        K0(this.F, fWidth, fHeight);
        if (!f0()) {
            RectF rectF = this.F;
            Rect rect = this.y;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int iCeil = (int) Math.ceil(this.F.width());
        int iCeil2 = (int) Math.ceil(this.F.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        H(iCeil, iCeil2);
        if (this.I) {
            this.v.set(this.G);
            this.v.preScale(fWidth, fHeight);
            Matrix matrix = this.v;
            RectF rectF2 = this.F;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.w.eraseColor(0);
            bVar.d(this.x, this.v, this.p);
            this.G.invert(this.H);
            this.H.mapRect(this.E, this.F);
            B(this.E, this.C);
        }
        this.B.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.w, this.B, this.C, this.A);
    }

    public final void H(int i, int i2) {
        Bitmap bitmap = this.w;
        if (bitmap == null || bitmap.getWidth() < i || this.w.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.w = bitmapCreateBitmap;
            this.x.setBitmap(bitmapCreateBitmap);
            this.I = true;
            return;
        }
        if (this.w.getWidth() > i || this.w.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.w, 0, 0, i, i2);
            this.w = bitmapCreateBitmap2;
            this.x.setBitmap(bitmapCreateBitmap2);
            this.I = true;
        }
    }

    public List<b03> H0(b03 b03Var) {
        if (this.o == null) {
            m63.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.o.c(b03Var, 0, arrayList, new b03(new String[0]));
        return arrayList;
    }

    public final void I() {
        if (this.x != null) {
            return;
        }
        this.x = new Canvas();
        this.F = new RectF();
        this.G = new Matrix();
        this.H = new Matrix();
        this.y = new Rect();
        this.z = new RectF();
        this.A = new o03();
        this.B = new Rect();
        this.C = new Rect();
        this.E = new RectF();
    }

    @MainThread
    public void I0() {
        if (this.o == null) {
            this.g.add(new b() { // from class: p83
                @Override // u83.b
                public final void a(u73 u73Var) {
                    this.f19960a.m0(u73Var);
                }
            });
            return;
        }
        z();
        if (v() || Y() == 0) {
            if (isVisible()) {
                this.b.t();
                this.f = c.NONE;
            } else {
                this.f = c.RESUME;
            }
        }
        if (v()) {
            return;
        }
        P0((int) (a0() < 0.0f ? U() : T()));
        this.b.g();
        if (isVisible()) {
            return;
        }
        this.f = c.NONE;
    }

    @Nullable
    public Bitmap J(String str) {
        uq2 uq2VarP = P();
        if (uq2VarP != null) {
            return uq2VarP.a(str);
        }
        return null;
    }

    public void J0() {
        this.b.v();
    }

    public boolean K() {
        return this.n;
    }

    public final void K0(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    public u73 L() {
        return this.f21158a;
    }

    public void L0(boolean z) {
        this.s = z;
    }

    @Nullable
    public final Context M() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void M0(boolean z) {
        if (z != this.n) {
            this.n = z;
            com.airbnb.lottie.model.layer.b bVar = this.o;
            if (bVar != null) {
                bVar.Q(z);
            }
            invalidateSelf();
        }
    }

    public final s02 N() {
        if (getCallback() == null) {
            return null;
        }
        if (this.k == null) {
            this.k = new s02(getCallback(), null);
        }
        return this.k;
    }

    public boolean N0(u73 u73Var) {
        if (this.f21158a == u73Var) {
            return false;
        }
        this.I = true;
        y();
        this.f21158a = u73Var;
        w();
        this.b.w(u73Var);
        g1(this.b.getAnimatedFraction());
        Iterator it = new ArrayList(this.g).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.a(u73Var);
            }
            it.remove();
        }
        this.g.clear();
        u73Var.v(this.q);
        z();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public int O() {
        return (int) this.b.i();
    }

    public void O0(r02 r02Var) {
        s02 s02Var = this.k;
        if (s02Var != null) {
            s02Var.c(r02Var);
        }
    }

    public final uq2 P() {
        if (getCallback() == null) {
            return null;
        }
        uq2 uq2Var = this.i;
        if (uq2Var != null && !uq2Var.b(M())) {
            this.i = null;
        }
        if (this.i == null) {
            this.i = new uq2(getCallback(), this.j, null, this.f21158a.j());
        }
        return this.i;
    }

    public void P0(final int i) {
        if (this.f21158a == null) {
            this.g.add(new b() { // from class: i83
                @Override // u83.b
                public final void a(u73 u73Var) {
                    this.f18122a.n0(i, u73Var);
                }
            });
        } else {
            this.b.x(i);
        }
    }

    @Nullable
    public String Q() {
        return this.j;
    }

    public void Q0(boolean z) {
        this.d = z;
    }

    @Nullable
    public x83 R(String str) {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            return null;
        }
        return u73Var.j().get(str);
    }

    public void R0(rq2 rq2Var) {
        uq2 uq2Var = this.i;
        if (uq2Var != null) {
            uq2Var.d(rq2Var);
        }
    }

    public boolean S() {
        return this.m;
    }

    public void S0(@Nullable String str) {
        this.j = str;
    }

    public float T() {
        return this.b.k();
    }

    public void T0(boolean z) {
        this.m = z;
    }

    public float U() {
        return this.b.l();
    }

    public void U0(final int i) {
        if (this.f21158a == null) {
            this.g.add(new b() { // from class: o83
                @Override // u83.b
                public final void a(u73 u73Var) {
                    this.f19711a.o0(i, u73Var);
                }
            });
        } else {
            this.b.y(i + 0.99f);
        }
    }

    @Nullable
    public lg4 V() {
        u73 u73Var = this.f21158a;
        if (u73Var != null) {
            return u73Var.n();
        }
        return null;
    }

    public void V0(final String str) {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            this.g.add(new b() { // from class: q83
                @Override // u83.b
                public final void a(u73 u73Var2) {
                    this.f20201a.p0(str, u73Var2);
                }
            });
            return;
        }
        dd3 dd3VarL = u73Var.l(str);
        if (dd3VarL != null) {
            U0((int) (dd3VarL.b + dd3VarL.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float W() {
        return this.b.h();
    }

    public void W0(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) final float f) {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            this.g.add(new b() { // from class: g83
                @Override // u83.b
                public final void a(u73 u73Var2) {
                    this.f17678a.q0(f, u73Var2);
                }
            });
        } else {
            this.b.y(sp3.i(u73Var.p(), this.f21158a.f(), f));
        }
    }

    public RenderMode X() {
        return this.u ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public void X0(final int i, final int i2) {
        if (this.f21158a == null) {
            this.g.add(new b() { // from class: j83
                @Override // u83.b
                public final void a(u73 u73Var) {
                    this.f18344a.r0(i, i2, u73Var);
                }
            });
        } else {
            this.b.z(i, i2 + 0.99f);
        }
    }

    public int Y() {
        return this.b.getRepeatCount();
    }

    public void Y0(final String str) {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            this.g.add(new b() { // from class: k83
                @Override // u83.b
                public final void a(u73 u73Var2) {
                    this.f18595a.s0(str, u73Var2);
                }
            });
            return;
        }
        dd3 dd3VarL = u73Var.l(str);
        if (dd3VarL != null) {
            int i = (int) dd3VarL.b;
            X0(i, ((int) dd3VarL.c) + i);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    @SuppressLint({"WrongConstant"})
    public int Z() {
        return this.b.getRepeatMode();
    }

    public void Z0(final String str, final String str2, final boolean z) {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            this.g.add(new b() { // from class: r83
                @Override // u83.b
                public final void a(u73 u73Var2) {
                    this.f20414a.t0(str, str2, z, u73Var2);
                }
            });
            return;
        }
        dd3 dd3VarL = u73Var.l(str);
        if (dd3VarL == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) dd3VarL.b;
        dd3 dd3VarL2 = this.f21158a.l(str2);
        if (dd3VarL2 != null) {
            X0(i, (int) (dd3VarL2.b + (z ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
    }

    public float a0() {
        return this.b.m();
    }

    public void a1(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) final float f, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) final float f2) {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            this.g.add(new b() { // from class: l83
                @Override // u83.b
                public final void a(u73 u73Var2) {
                    this.f18928a.u0(f, f2, u73Var2);
                }
            });
        } else {
            X0((int) sp3.i(u73Var.p(), this.f21158a.f(), f), (int) sp3.i(this.f21158a.p(), this.f21158a.f(), f2));
        }
    }

    @Nullable
    public ou5 b0() {
        return null;
    }

    public void b1(final int i) {
        if (this.f21158a == null) {
            this.g.add(new b() { // from class: m83
                @Override // u83.b
                public final void a(u73 u73Var) {
                    this.f19159a.v0(i, u73Var);
                }
            });
        } else {
            this.b.A(i);
        }
    }

    @Nullable
    public Typeface c0(String str, String str2) {
        s02 s02VarN = N();
        if (s02VarN != null) {
            return s02VarN.b(str, str2);
        }
        return null;
    }

    public void c1(final String str) {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            this.g.add(new b() { // from class: s83
                @Override // u83.b
                public final void a(u73 u73Var2) {
                    this.f20680a.w0(str, u73Var2);
                }
            });
            return;
        }
        dd3 dd3VarL = u73Var.l(str);
        if (dd3VarL != null) {
            b1((int) dd3VarL.b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public boolean d0() {
        com.airbnb.lottie.model.layer.b bVar = this.o;
        return bVar != null && bVar.O();
    }

    public void d1(final float f) {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            this.g.add(new b() { // from class: n83
                @Override // u83.b
                public final void a(u73 u73Var2) {
                    this.f19458a.x0(f, u73Var2);
                }
            });
        } else {
            b1((int) sp3.i(u73Var.p(), this.f21158a.f(), f));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        m03.a("Drawable#draw");
        if (this.e) {
            try {
                if (this.u) {
                    G0(canvas, this.o);
                } else {
                    D(canvas);
                }
            } catch (Throwable th) {
                m63.b("Lottie crashed in draw!", th);
            }
        } else if (this.u) {
            G0(canvas, this.o);
        } else {
            D(canvas);
        }
        this.I = false;
        m03.b("Drawable#draw");
    }

    public boolean e0() {
        com.airbnb.lottie.model.layer.b bVar = this.o;
        return bVar != null && bVar.P();
    }

    public void e1(boolean z) {
        if (this.r == z) {
            return;
        }
        this.r = z;
        com.airbnb.lottie.model.layer.b bVar = this.o;
        if (bVar != null) {
            bVar.J(z);
        }
    }

    public final boolean f0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r0).getClipChildren();
        }
        return false;
    }

    public void f1(boolean z) {
        this.q = z;
        u73 u73Var = this.f21158a;
        if (u73Var != null) {
            u73Var.v(z);
        }
    }

    public boolean g0() {
        h93 h93Var = this.b;
        if (h93Var == null) {
            return false;
        }
        return h93Var.isRunning();
    }

    public void g1(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) final float f) {
        if (this.f21158a == null) {
            this.g.add(new b() { // from class: f83
                @Override // u83.b
                public final void a(u73 u73Var) {
                    this.f17478a.y0(f, u73Var);
                }
            });
            return;
        }
        m03.a("Drawable#setProgress");
        this.b.x(this.f21158a.h(f));
        m03.b("Drawable#setProgress");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            return -1;
        }
        return u73Var.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            return -1;
        }
        return u73Var.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h0() {
        if (isVisible()) {
            return this.b.isRunning();
        }
        c cVar = this.f;
        return cVar == c.PLAY || cVar == c.RESUME;
    }

    public void h1(RenderMode renderMode) {
        this.t = renderMode;
        z();
    }

    public boolean i0() {
        return this.s;
    }

    public void i1(int i) {
        this.b.setRepeatCount(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.I) {
            return;
        }
        this.I = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return g0();
    }

    public boolean j0() {
        return this.l;
    }

    public void j1(int i) {
        this.b.setRepeatMode(i);
    }

    public void k1(boolean z) {
        this.e = z;
    }

    public void l1(float f) {
        this.b.B(f);
    }

    public void m1(Boolean bool) {
        this.c = bool.booleanValue();
    }

    @Nullable
    public Bitmap o1(String str, @Nullable Bitmap bitmap) {
        uq2 uq2VarP = P();
        if (uq2VarP == null) {
            m63.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapE = uq2VarP.e(str, bitmap);
        invalidateSelf();
        return bitmapE;
    }

    public boolean p1() {
        return this.f21158a.c().size() > 0;
    }

    public void r(Animator.AnimatorListener animatorListener) {
        this.b.addListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void s(Animator.AnimatorPauseListener animatorPauseListener) {
        this.b.addPauseListener(animatorPauseListener);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.p = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        m63.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            c cVar = this.f;
            if (cVar == c.PLAY) {
                A0();
            } else if (cVar == c.RESUME) {
                I0();
            }
        } else if (this.b.isRunning()) {
            z0();
            this.f = c.RESUME;
        } else if (!z3) {
            this.f = c.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        A0();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        G();
    }

    public void t(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.b.addUpdateListener(animatorUpdateListener);
    }

    public <T> void u(final b03 b03Var, final T t, @Nullable final i93<T> i93Var) {
        com.airbnb.lottie.model.layer.b bVar = this.o;
        if (bVar == null) {
            this.g.add(new b() { // from class: t83
                @Override // u83.b
                public final void a(u73 u73Var) {
                    this.f20922a.k0(b03Var, t, i93Var, u73Var);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (b03Var == b03.c) {
            bVar.h(t, i93Var);
        } else if (b03Var.d() != null) {
            b03Var.d().h(t, i93Var);
        } else {
            List<b03> listH0 = H0(b03Var);
            for (int i = 0; i < listH0.size(); i++) {
                listH0.get(i).d().h(t, i93Var);
            }
            zIsEmpty = true ^ listH0.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == d93.E) {
                g1(W());
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final boolean v() {
        return this.c || this.d;
    }

    public final void w() {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            return;
        }
        com.airbnb.lottie.model.layer.b bVar = new com.airbnb.lottie.model.layer.b(this, o13.a(u73Var), u73Var.k(), u73Var);
        this.o = bVar;
        if (this.r) {
            bVar.J(true);
        }
        this.o.Q(this.n);
    }

    public void x() {
        this.g.clear();
        this.b.cancel();
        if (isVisible()) {
            return;
        }
        this.f = c.NONE;
    }

    public void y() {
        if (this.b.isRunning()) {
            this.b.cancel();
            if (!isVisible()) {
                this.f = c.NONE;
            }
        }
        this.f21158a = null;
        this.o = null;
        this.i = null;
        this.b.f();
        invalidateSelf();
    }

    public final void z() {
        u73 u73Var = this.f21158a;
        if (u73Var == null) {
            return;
        }
        this.u = this.t.useSoftwareRendering(Build.VERSION.SDK_INT, u73Var.q(), u73Var.m());
    }

    public void z0() {
        this.g.clear();
        this.b.o();
        if (isVisible()) {
            return;
        }
        this.f = c.NONE;
    }

    @Deprecated
    public void C() {
    }

    public void n1(ou5 ou5Var) {
    }
}
