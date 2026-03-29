package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.bq;
import com.bytedance.adsdk.lottie.pn.nr;
import defpackage.td;
import defpackage.ud;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4994a;
    private ImageView jk;
    private LottieAnimationView l;
    private final Handler mv;
    private float n;
    private final Runnable s;
    private Drawable t;

    public u(com.bytedance.adsdk.lottie.n nVar, n nVar2, Context context) {
        super(nVar, nVar2);
        this.n = -1.0f;
        this.f4994a = -1.0f;
        this.mv = new Handler(Looper.getMainLooper());
        this.s = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.u.5
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.l != null && u.this.l.pn()) {
                    u.this.l.invalidate();
                }
                u.this.mv.postDelayed(u.this.s, 40L);
            }
        };
        if (((x) this).x == null || nVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewNr = nVar.nr();
        this.l = lottieAnimationViewNr;
        if (lottieAnimationViewNr == null) {
            return;
        }
        float fU = com.bytedance.adsdk.lottie.pn.a.u();
        this.n = (int) (((x) this).x.u() * fU);
        this.f4994a = (int) (((x) this).x.nr() * fU);
        bq bqVarKj = nVar.kj();
        String strU = bqVarKj != null ? bqVarKj.u(((x) this).x.mv()) : null;
        if (TextUtils.isEmpty(strU)) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.jk = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jk.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.u.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (u.this.jk == view) {
                    u.this.my();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (u.this.jk == view) {
                    u.this.s();
                    if (Build.VERSION.SDK_INT < 28 || !td.a(u.this.t)) {
                        return;
                    }
                    ud.a(u.this.t).stop();
                }
            }
        });
        this.l.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.u.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (u.this.l == view) {
                    if (u.this.nr()) {
                        u.this.l.removeOnAttachStateChangeListener(this);
                    } else {
                        u.this.u(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.u.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                u.this.o();
                            }
                        });
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (u.this.l == view) {
                    u.this.u(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.u.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewParent parent = u.this.jk.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(u.this.jk);
                            }
                        }
                    });
                }
            }
        });
        u(strU, context);
    }

    private void k() {
        s();
        if (this.l != null) {
            this.mv.postDelayed(this.s, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        if (Build.VERSION.SDK_INT < 28 || !td.a(this.t) || ud.a(this.t).isRunning()) {
            return;
        }
        ud.a(this.t).setRepeatCount(-1);
        ud.a(this.t).start();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.t != null) {
            ViewParent parent = this.jk.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.jk);
            }
            ViewParent parent2 = this.l.getParent();
            if (parent2 instanceof ViewGroup) {
                this.jk.setTranslationX(2.1474836E9f);
                this.jk.setImageDrawable(this.t);
                ((ViewGroup) parent2).addView(this.jk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.mv.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.x, com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        if (this.n <= 0.0f || this.jk == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        u(i);
        float fN = n();
        u(this.jk, (int) this.n, (int) this.f4994a);
        this.jk.setAlpha(fN);
        canvas.clipRect(0.0f, 0.0f, this.n, this.f4994a);
        this.jk.draw(canvas);
        canvas.restore();
    }

    private void u(String str, Context context) {
        File file = new File(com.bytedance.adsdk.lottie.pn.nr.u(context), com.bytedance.sdk.component.utils.x.nr(str));
        if (file.exists()) {
            u(file);
        } else {
            com.bytedance.adsdk.lottie.pn.nr.u(str, context, new nr.u<File>() { // from class: com.bytedance.adsdk.lottie.model.layer.u.3
                @Override // com.bytedance.adsdk.lottie.pn.nr.u
                public void u(File file2) {
                    u.this.u(file2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(File file) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                if (td.a(this.t)) {
                    ud.a(this.t).stop();
                }
                this.t = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
                this.mv.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.u.4
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.o();
                    }
                });
            } catch (IOException unused) {
            }
        }
    }

    private static void u(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
