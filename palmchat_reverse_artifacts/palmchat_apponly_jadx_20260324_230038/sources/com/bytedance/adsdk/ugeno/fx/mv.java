package com.bytedance.adsdk.ugeno.fx;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.fx.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mv {
    private View b;
    private AnimatorSet fx = new AnimatorSet();
    private int iz;
    private u nr;
    private int pn;
    Paint u;
    private String x;

    public mv(View view, u uVar) {
        this.b = view;
        this.nr = uVar;
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
    }

    public void nr() {
        AnimatorSet animatorSet = this.fx;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u() {
        ObjectAnimator objectAnimator;
        ArrayList arrayList = new ArrayList();
        List<u.C0169u> listFx = this.nr.fx();
        if (listFx == null || listFx.size() <= 0) {
            return;
        }
        for (u.C0169u c0169u : listFx) {
            if (c0169u != null) {
                objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0169u.u());
                if (TextUtils.equals(c0169u.getType(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0169u.getType(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0169u.getType());
                }
                objectAnimator.setStartDelay(c0169u.b());
                objectAnimator.setTarget(this.b);
                if (TextUtils.equals(c0169u.getType(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0169u.pn(), (int) c0169u.iz());
                } else {
                    objectAnimator.setFloatValues(c0169u.pn(), c0169u.iz());
                }
                int iNr = (int) this.nr.nr();
                if (iNr != 0) {
                    objectAnimator.setRepeatCount(iNr);
                } else {
                    objectAnimator.setRepeatCount((int) c0169u.nr());
                }
                if (TextUtils.equals(c0169u.getType(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strIz = this.nr.iz();
                if (TextUtils.isEmpty(strIz)) {
                    strIz = c0169u.fx();
                }
                if (TextUtils.equals(strIz, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0169u.x() != null && c0169u.x().length > 0) {
                    objectAnimator.setFloatValues(c0169u.x());
                }
                if (TextUtils.equals(c0169u.getType(), "rotationX")) {
                    this.b.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.fx.mv.1
                        @Override // java.lang.Runnable
                        public void run() {
                            mv.this.b.setPivotX(mv.this.b.getWidth() / 2.0f);
                            mv.this.b.setPivotY(mv.this.b.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0169u.getType(), "ripple")) {
                    this.x = c0169u.a();
                }
                String strN = c0169u.n();
                strN.hashCode();
                switch (strN) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.nr.b() != 0) {
            this.fx.setDuration(this.nr.b());
        }
        this.fx.setStartDelay(this.nr.pn());
        if (TextUtils.equals(this.nr.u(), "sequentially")) {
            this.fx.playSequentially(arrayList);
        } else {
            this.fx.playTogether(arrayList);
        }
        this.fx.start();
    }

    public void u(Canvas canvas, pn pnVar) {
        try {
            if (pnVar.getRipple() == 0.0f || TextUtils.isEmpty(this.x)) {
                return;
            }
            this.u.setColor(com.bytedance.adsdk.ugeno.iz.u.u(this.x));
            this.u.setAlpha(90);
            ((ViewGroup) this.b.getParent()).setClipChildren(true);
            canvas.drawCircle(this.pn, this.iz, Math.min(r0, r2) * 2 * pnVar.getRipple(), this.u);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void u(int i, int i2) {
        this.pn = i / 2;
        this.iz = i2 / 2;
    }
}
