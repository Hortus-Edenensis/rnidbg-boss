package com.bytedance.adsdk.ugeno.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.u.fx;
import com.bytedance.adsdk.ugeno.u.u.u;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private nr f5045a;
    private Context b;
    private ValueAnimator fx;
    private int iz = 1;
    private String n;
    private fx nr;
    private int pn;
    private com.bytedance.adsdk.ugeno.nr.fx u;
    private com.bytedance.adsdk.ugeno.u.u.u x;

    public u(Context context, com.bytedance.adsdk.ugeno.nr.fx fxVar, fx fxVar2) {
        this.u = fxVar;
        this.nr = fxVar2;
        this.b = context;
    }

    public ValueAnimator b() {
        String key;
        com.bytedance.adsdk.ugeno.u.nr.u fxVar;
        fx fxVar2 = this.nr;
        if (fxVar2 == null || this.u == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapNr = fxVar2.nr();
        ArrayList arrayList = new ArrayList();
        if (mapNr != null && !mapNr.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapNr.entrySet()) {
                if (entry != null) {
                    key = entry.getKey();
                    String strFx = pn.u(key).fx();
                    strFx.hashCode();
                    switch (strFx) {
                        case "int":
                            fxVar = new com.bytedance.adsdk.ugeno.u.nr.fx(this.b, this.u, key, entry.getValue());
                            break;
                        case "float":
                            fxVar = new com.bytedance.adsdk.ugeno.u.nr.nr(this.b, this.u, key, entry.getValue());
                            break;
                        case "point":
                            fxVar = new com.bytedance.adsdk.ugeno.u.nr.b(this.b, this.u, key, entry.getValue());
                            break;
                        default:
                            fxVar = null;
                            break;
                    }
                    if (fxVar != null) {
                        arrayList.addAll(fxVar.pn());
                    }
                }
            }
        }
        JSONObject jSONObjectU = this.nr.u();
        if (jSONObjectU != null) {
            com.bytedance.adsdk.ugeno.u.u.u uVarU = u.C0174u.u(this.u, jSONObjectU);
            this.x = uVarU;
            if (uVarU != null) {
                arrayList.addAll(uVarU.fx());
            }
        }
        final View viewA = this.u.a();
        if (viewA == null) {
            return null;
        }
        final fx.u uVarX = this.nr.x();
        if (uVarX != null) {
            viewA.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.u.u.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewA.getWidth();
                    int height = viewA.getHeight();
                    viewA.setPivotX(b.u(uVarX.u, width));
                    viewA.setPivotY(b.u(uVarX.nr, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewA, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.pn = b.u(this.nr.b());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.nr.fx());
        int i = this.pn;
        if (i != Integer.MIN_VALUE) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i);
        }
        this.iz = this.nr.jk();
        this.n = this.nr.a();
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.nr.iz());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(b.u(this.nr.pn()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(b.nr(this.nr.n()));
        objectAnimatorOfPropertyValuesHolder.addListener(this);
        this.fx = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }

    public void fx() {
        ValueAnimator valueAnimator = this.fx;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void nr() {
        ValueAnimator valueAnimator = this.fx;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        nr nrVar = this.f5045a;
        if (nrVar != null) {
            nrVar.nr();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        nr nrVar = this.f5045a;
        if (nrVar != null) {
            nrVar.u();
        }
    }

    public String pn() {
        return this.n;
    }

    public void u() {
        ValueAnimator valueAnimator = this.fx;
        if (valueAnimator == null || this.iz == 0 || this.pn == Integer.MIN_VALUE) {
            return;
        }
        valueAnimator.start();
    }

    public void nr(Canvas canvas) {
        com.bytedance.adsdk.ugeno.u.u.u uVar = this.x;
        if (uVar != null) {
            uVar.nr(canvas);
        }
    }

    public void u(nr nrVar) {
        this.f5045a = nrVar;
    }

    public void u(Canvas canvas) {
        com.bytedance.adsdk.ugeno.u.u.u uVar = this.x;
        if (uVar != null) {
            uVar.u(canvas);
        }
    }

    public void u(int i, int i2) {
        com.bytedance.adsdk.ugeno.u.u.u uVar = this.x;
        if (uVar != null) {
            uVar.u(i, i2);
        }
    }
}
