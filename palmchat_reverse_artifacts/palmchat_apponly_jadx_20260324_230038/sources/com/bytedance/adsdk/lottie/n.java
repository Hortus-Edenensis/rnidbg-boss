package com.bytedance.adsdk.lottie;

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
import android.view.ViewParent;
import android.widget.ImageView;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.adsdk.lottie.b.c;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.IntRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n extends Drawable implements Animatable, Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private nr f5002a;
    private iz b;
    private dw bc;
    private Paint bf;
    private boolean bg;
    private com.bytedance.adsdk.lottie.model.layer.b bq;
    private boolean c;
    private Bitmap d;
    private int dw;
    bq fx;
    private final Matrix gi;
    private Canvas h;
    private boolean iz;
    private RectF ja;
    private final ArrayList<u> jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private Matrix f5003jp;
    private com.bytedance.adsdk.lottie.nr.u k;
    private bg kj;
    private com.bytedance.adsdk.lottie.nr.nr l;
    private RectF m;
    private String mv;
    private Map<String, Typeface> my;
    private boolean n;
    fx nr;
    private boolean o;
    private boolean oa;
    private Rect pb;
    private final com.bytedance.adsdk.lottie.pn.iz pn;
    private boolean q;
    private boolean qq;
    private Rect rh;
    private b s;
    private boolean sx;
    private final ValueAnimator.AnimatorUpdateListener t;
    String u;
    private Rect wq;
    private boolean x;
    private RectF xg;
    private LottieAnimationView xw;
    private Matrix y;
    private boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public enum nr {
        NONE,
        PLAY,
        RESUME
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(iz izVar);
    }

    public n(LottieAnimationView lottieAnimationView) {
        com.bytedance.adsdk.lottie.pn.iz izVar = new com.bytedance.adsdk.lottie.pn.iz();
        this.pn = izVar;
        this.iz = true;
        this.x = false;
        this.n = false;
        this.f5002a = nr.NONE;
        this.jk = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.n.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (n.this.bq != null) {
                    n.this.bq.u(n.this.pn.iz());
                }
            }
        };
        this.t = animatorUpdateListener;
        this.sx = false;
        this.bg = true;
        this.dw = 255;
        this.kj = bg.AUTOMATIC;
        this.z = false;
        this.gi = new Matrix();
        this.oa = false;
        this.xw = lottieAnimationView;
        izVar.addUpdateListener(animatorUpdateListener);
    }

    private void bf() {
        iz izVar = this.b;
        if (izVar == null) {
            return;
        }
        this.z = this.kj.u(Build.VERSION.SDK_INT, izVar.u(), izVar.nr());
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private boolean jp() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }

    private void m() {
        if (this.h != null) {
            return;
        }
        this.h = new Canvas();
        this.m = new RectF();
        this.f5003jp = new Matrix();
        this.y = new Matrix();
        this.rh = new Rect();
        this.ja = new RectF();
        this.bf = new com.bytedance.adsdk.lottie.u.u();
        this.wq = new Rect();
        this.pb = new Rect();
        this.xg = new RectF();
    }

    private com.bytedance.adsdk.lottie.nr.nr pb() {
        com.bytedance.adsdk.lottie.nr.nr nrVar = this.l;
        if (nrVar != null && !nrVar.u(getContext())) {
            this.l = null;
        }
        if (this.l == null) {
            this.l = new com.bytedance.adsdk.lottie.nr.nr(getCallback(), this.mv, this.s, this.b.o());
        }
        return this.l;
    }

    private boolean wq() {
        return this.iz || this.x;
    }

    private com.bytedance.adsdk.lottie.nr.u xg() {
        if (getCallback() == null) {
            return null;
        }
        if (this.k == null) {
            com.bytedance.adsdk.lottie.nr.u uVar = new com.bytedance.adsdk.lottie.nr.u(getCallback(), this.nr);
            this.k = uVar;
            String str = this.u;
            if (str != null) {
                uVar.u(str);
            }
        }
        return this.k;
    }

    public sx a() {
        iz izVar = this.b;
        if (izVar != null) {
            return izVar.fx();
        }
        return null;
    }

    public boolean b() {
        return this.bg;
    }

    public void bg() {
        this.pn.removeAllListeners();
    }

    public int bq() {
        return (int) this.pn.x();
    }

    public int c() {
        return this.pn.getRepeatCount();
    }

    public void d() {
        this.jk.clear();
        this.pn.cancel();
        if (isVisible()) {
            return;
        }
        this.f5002a = nr.NONE;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        pn.u("Drawable#draw");
        try {
            if (this.z) {
                u(canvas, this.bq);
            } else {
                u(canvas);
            }
        } catch (Throwable th) {
            com.bytedance.adsdk.lottie.pn.pn.nr("Lottie crashed in draw!", th);
        }
        this.oa = false;
        pn.nr("Drawable#draw");
    }

    @SuppressLint({"WrongConstant"})
    public int dw() {
        return this.pn.getRepeatMode();
    }

    public com.bytedance.adsdk.lottie.model.layer.b fx() {
        return this.bq;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.dw;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        iz izVar = this.b;
        if (izVar == null) {
            return -1;
        }
        return izVar.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        iz izVar = this.b;
        if (izVar == null) {
            return -1;
        }
        return izVar.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public iz gi() {
        return this.b;
    }

    public void h() {
        this.jk.clear();
        this.pn.mv();
        if (isVisible()) {
            return;
        }
        this.f5002a = nr.NONE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.oa) {
            return;
        }
        this.oa = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return q();
    }

    public boolean iz() {
        return this.sx;
    }

    public RectF ja() {
        return this.m;
    }

    public boolean jk() {
        return this.qq;
    }

    public float k() {
        return this.pn.k();
    }

    public bq kj() {
        return this.fx;
    }

    @MainThread
    public void l() {
        if (this.bq == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.6
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar) {
                    n.this.l();
                }
            });
            return;
        }
        bf();
        if (wq() || c() == 0) {
            if (isVisible()) {
                this.pn.t();
                this.f5002a = nr.NONE;
            } else {
                this.f5002a = nr.PLAY;
            }
        }
        if (wq()) {
            return;
        }
        fx((int) (o() < 0.0f ? k() : my()));
        this.pn.l();
        if (isVisible()) {
            return;
        }
        this.f5002a = nr.NONE;
    }

    @MainThread
    public void mv() {
        this.jk.clear();
        this.pn.l();
        if (isVisible()) {
            return;
        }
        this.f5002a = nr.NONE;
    }

    public float my() {
        return this.pn.my();
    }

    public boolean n() {
        return this.z;
    }

    public float o() {
        return this.pn.jk();
    }

    public String pn() {
        return this.mv;
    }

    public boolean q() {
        com.bytedance.adsdk.lottie.pn.iz izVar = this.pn;
        if (izVar == null) {
            return false;
        }
        return izVar.isRunning();
    }

    public boolean qq() {
        if (isVisible()) {
            return this.pn.isRunning();
        }
        nr nrVar = this.f5002a;
        return nrVar == nr.PLAY || nrVar == nr.RESUME;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float rh() {
        return this.pn.iz();
    }

    @MainThread
    public void s() {
        if (this.bq == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.7
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar) {
                    n.this.s();
                }
            });
            return;
        }
        bf();
        if (wq() || c() == 0) {
            if (isVisible()) {
                this.pn.s();
                this.f5002a = nr.NONE;
            } else {
                this.f5002a = nr.RESUME;
            }
        }
        if (wq()) {
            return;
        }
        fx((int) (o() < 0.0f ? k() : my()));
        this.pn.l();
        if (isVisible()) {
            return;
        }
        this.f5002a = nr.NONE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.dw = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.bytedance.adsdk.lottie.pn.pn.nr("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            nr nrVar = this.f5002a;
            if (nrVar == nr.PLAY) {
                l();
            } else if (nrVar == nr.RESUME) {
                s();
            }
        } else if (this.pn.isRunning()) {
            h();
            this.f5002a = nr.RESUME;
        } else if (!z3) {
            this.f5002a = nr.NONE;
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
        l();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        mv();
    }

    public void sx() {
        this.pn.removeAllUpdateListeners();
        this.pn.addUpdateListener(this.t);
    }

    public void t() {
        if (this.pn.isRunning()) {
            this.pn.cancel();
            if (!isVisible()) {
                this.f5002a = nr.NONE;
            }
        }
        this.b = null;
        com.bytedance.adsdk.lottie.model.layer.b bVar = this.bq;
        if (bVar != null) {
            u(bVar);
        }
        this.bq = null;
        this.l = null;
        this.pn.n();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public bg x() {
        return this.z ? bg.SOFTWARE : bg.HARDWARE;
    }

    public boolean z() {
        return this.my == null && this.fx == null && this.b.k().size() > 0;
    }

    public void b(boolean z) {
        if (this.q == z) {
            return;
        }
        this.q = z;
        com.bytedance.adsdk.lottie.model.layer.b bVar = this.bq;
        if (bVar != null) {
            bVar.u(z);
        }
    }

    public void fx(boolean z) {
        this.c = z;
        iz izVar = this.b;
        if (izVar != null) {
            izVar.nr(z);
        }
    }

    public void iz(boolean z) {
        this.n = z;
    }

    public void n(boolean z) {
        this.pn.fx(z);
    }

    public LottieAnimationView nr() {
        return this.xw;
    }

    public void pn(boolean z) {
        this.qq = z;
    }

    public void u(dw dwVar) {
        this.bc = dwVar;
    }

    public void x(boolean z) {
        this.x = z;
    }

    public a iz(String str) {
        iz izVar = this.b;
        if (izVar == null) {
            return null;
        }
        return izVar.o().get(str);
    }

    public void nr(boolean z) {
        this.sx = z;
    }

    public void pn(int i) {
        this.pn.setRepeatCount(i);
    }

    public dw u() {
        return this.bc;
    }

    public void x(String str) {
        this.u = str;
        com.bytedance.adsdk.lottie.nr.u uVarXg = xg();
        if (uVarXg != null) {
            uVarXg.u(str);
        }
    }

    public void nr(final int i) {
        if (this.b == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.10
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar) {
                    n.this.nr(i);
                }
            });
        } else {
            this.pn.nr(i + 0.99f);
        }
    }

    public Bitmap pn(String str) {
        com.bytedance.adsdk.lottie.nr.nr nrVarPb = pb();
        if (nrVarPb != null) {
            return nrVarPb.u(str);
        }
        return null;
    }

    public void u(boolean z, Context context) {
        if (this.o == z) {
            return;
        }
        this.o = z;
        if (this.b != null) {
            u(context);
        }
    }

    public void fx(final String str) {
        iz izVar = this.b;
        if (izVar == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.13
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar2) {
                    n.this.fx(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.iz izVarFx = izVar.fx(str);
        if (izVarFx != null) {
            nr((int) (izVarFx.u + izVarFx.nr));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void b(final String str) {
        iz izVar = this.b;
        if (izVar == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.2
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar2) {
                    n.this.b(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.iz izVarFx = izVar.fx(str);
        if (izVarFx != null) {
            int i = (int) izVarFx.u;
            u(i, ((int) izVarFx.nr) + i);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void nr(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) final float f) {
        iz izVar = this.b;
        if (izVar == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.11
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar2) {
                    n.this.nr(f);
                }
            });
        } else {
            this.pn.nr(com.bytedance.adsdk.lottie.pn.n.u(izVar.iz(), this.b.x(), f));
        }
    }

    public void u(boolean z) {
        if (z != this.bg) {
            this.bg = z;
            com.bytedance.adsdk.lottie.model.layer.b bVar = this.bq;
            if (bVar != null) {
                bVar.nr(z);
            }
            invalidateSelf();
        }
    }

    public void fx(float f) {
        this.pn.fx(f);
    }

    public void nr(final String str) {
        iz izVar = this.b;
        if (izVar == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.12
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar2) {
                    n.this.nr(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.iz izVarFx = izVar.fx(str);
        if (izVarFx != null) {
            u((int) izVarFx.u);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void fx(final int i) {
        if (this.b == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.4
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar) {
                    n.this.fx(i);
                }
            });
        } else {
            this.pn.u(i);
        }
    }

    public void b(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) final float f) {
        if (this.b == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.5
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar) {
                    n.this.b(f);
                }
            });
            return;
        }
        pn.u("Drawable#setProgress");
        this.pn.u(this.b.u(f));
        pn.nr("Drawable#setProgress");
    }

    public void u(String str) {
        this.mv = str;
    }

    public boolean u(iz izVar, Context context) {
        if (this.b == izVar) {
            return false;
        }
        this.oa = true;
        t();
        this.b = izVar;
        u(context);
        this.pn.u(izVar);
        b(this.pn.getAnimatedFraction());
        Iterator it = new ArrayList(this.jk).iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            if (uVar != null) {
                uVar.u(izVar);
            }
            it.remove();
        }
        this.jk.clear();
        izVar.nr(this.c);
        bf();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void nr(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pn.removeUpdateListener(animatorUpdateListener);
    }

    public void nr(Animator.AnimatorListener animatorListener) {
        this.pn.removeListener(animatorListener);
    }

    private void nr(int i, int i2) {
        Bitmap bitmap = this.d;
        if (bitmap != null && bitmap.getWidth() >= i && this.d.getHeight() >= i2) {
            if (this.d.getWidth() > i || this.d.getHeight() > i2) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.d, 0, 0, i, i2);
                this.d = bitmapCreateBitmap;
                this.h.setBitmap(bitmapCreateBitmap);
                this.oa = true;
                return;
            }
            return;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.d = bitmapCreateBitmap2;
        this.h.setBitmap(bitmapCreateBitmap2);
        this.oa = true;
    }

    public void b(int i) {
        this.pn.setRepeatMode(i);
    }

    public void u(bg bgVar) {
        this.kj = bgVar;
        bf();
    }

    private void u(Context context) {
        iz izVar = this.b;
        if (izVar == null) {
            return;
        }
        com.bytedance.adsdk.lottie.model.layer.b bVar = this.bq;
        if (bVar != null) {
            u(bVar);
        }
        com.bytedance.adsdk.lottie.model.layer.b bVar2 = new com.bytedance.adsdk.lottie.model.layer.b(this, c.u(izVar), izVar.s(), izVar, context);
        this.bq = bVar2;
        if (this.q) {
            bVar2.u(true);
        }
        this.bq.nr(this.bg);
    }

    private void u(com.bytedance.adsdk.lottie.model.layer.b bVar) {
        if (bVar != null) {
            bVar.fx();
            List<com.bytedance.adsdk.lottie.model.layer.fx> listS = bVar.s();
            if (listS != null) {
                for (com.bytedance.adsdk.lottie.model.layer.fx fxVar : listS) {
                    if (fxVar instanceof com.bytedance.adsdk.lottie.model.layer.b) {
                        u((com.bytedance.adsdk.lottie.model.layer.b) fxVar);
                    } else if (fxVar != null) {
                        fxVar.fx();
                    }
                }
            }
        }
    }

    public void u(final int i) {
        if (this.b == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.8
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar) {
                    n.this.u(i);
                }
            });
        } else {
            this.pn.u(i);
        }
    }

    public void u(final float f) {
        iz izVar = this.b;
        if (izVar == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.9
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar2) {
                    n.this.u(f);
                }
            });
        } else {
            u((int) com.bytedance.adsdk.lottie.pn.n.u(izVar.iz(), this.b.x(), f));
        }
    }

    public void u(final int i, final int i2) {
        if (this.b == null) {
            this.jk.add(new u() { // from class: com.bytedance.adsdk.lottie.n.3
                @Override // com.bytedance.adsdk.lottie.n.u
                public void u(iz izVar) {
                    n.this.u(i, i2);
                }
            });
        } else {
            this.pn.u(i, i2 + 0.99f);
        }
    }

    public void u(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pn.addUpdateListener(animatorUpdateListener);
    }

    public void u(Animator.AnimatorListener animatorListener) {
        this.pn.addListener(animatorListener);
    }

    public void u(Boolean bool) {
        this.iz = bool.booleanValue();
    }

    public void u(b bVar) {
        this.s = bVar;
        com.bytedance.adsdk.lottie.nr.nr nrVar = this.l;
        if (nrVar != null) {
            nrVar.u(bVar);
        }
    }

    public void u(fx fxVar) {
        this.nr = fxVar;
        com.bytedance.adsdk.lottie.nr.u uVar = this.k;
        if (uVar != null) {
            uVar.u(fxVar);
        }
    }

    public void u(Map<String, Typeface> map) {
        if (map == this.my) {
            return;
        }
        this.my = map;
        invalidateSelf();
    }

    public void u(bq bqVar) {
        this.fx = bqVar;
    }

    public Bitmap u(String str, Bitmap bitmap) {
        com.bytedance.adsdk.lottie.nr.nr nrVarPb = pb();
        if (nrVarPb == null) {
            com.bytedance.adsdk.lottie.pn.pn.nr("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapU = nrVarPb.u(str, bitmap);
        invalidateSelf();
        return bitmapU;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface u(com.bytedance.adsdk.lottie.model.fx fxVar) {
        Map<String, Typeface> map = this.my;
        if (map != null) {
            String strU = fxVar.u();
            if (map.containsKey(strU)) {
                return map.get(strU);
            }
            String strNr = fxVar.nr();
            if (map.containsKey(strNr)) {
                return map.get(strNr);
            }
            String str = fxVar.u() + "-" + fxVar.fx();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.lottie.nr.u uVarXg = xg();
        if (uVarXg != null) {
            return uVarXg.u(fxVar);
        }
        return null;
    }

    private void u(Canvas canvas) {
        com.bytedance.adsdk.lottie.model.layer.b bVar = this.bq;
        iz izVar = this.b;
        if (bVar == null || izVar == null) {
            return;
        }
        this.gi.reset();
        if (!getBounds().isEmpty()) {
            this.gi.preScale(r2.width() / izVar.b().width(), r2.height() / izVar.b().height());
            this.gi.preTranslate(r2.left, r2.top);
        }
        bVar.u(canvas, this.gi, this.dw);
    }

    private void u(Canvas canvas, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        if (this.b == null || bVar == null) {
            return;
        }
        m();
        canvas.getMatrix(this.f5003jp);
        canvas.getClipBounds(this.rh);
        u(this.rh, this.ja);
        this.f5003jp.mapRect(this.ja);
        u(this.ja, this.rh);
        if (this.bg) {
            this.m.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            bVar.u(this.m, (Matrix) null, false);
        }
        this.f5003jp.mapRect(this.m);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        u(this.m, fWidth, fHeight);
        if (!jp()) {
            RectF rectF = this.m;
            Rect rect = this.rh;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int iCeil = (int) Math.ceil(this.m.width());
        int iCeil2 = (int) Math.ceil(this.m.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        nr(iCeil, iCeil2);
        if (this.oa) {
            this.gi.set(this.f5003jp);
            this.gi.preScale(fWidth, fHeight);
            Matrix matrix = this.gi;
            RectF rectF2 = this.m;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.d.eraseColor(0);
            bVar.u(this.h, this.gi, this.dw);
            this.f5003jp.invert(this.y);
            this.y.mapRect(this.xg, this.m);
            u(this.xg, this.pb);
        }
        this.wq.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.d, this.wq, this.pb, this.bf);
    }

    private void u(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void u(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void u(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }
}
