package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.fx;
import com.bytedance.adsdk.ugeno.u.n;
import com.bytedance.adsdk.ugeno.u.x;
import com.bytedance.adsdk.ugeno.yoga.a;
import com.bytedance.adsdk.ugeno.yoga.b;
import com.bytedance.adsdk.ugeno.yoga.iz;
import com.bytedance.adsdk.ugeno.yoga.jk;
import com.bytedance.adsdk.ugeno.yoga.mv;
import com.bytedance.adsdk.ugeno.yoga.pn;
import com.bytedance.adsdk.ugeno.yoga.s;
import com.bytedance.adsdk.ugeno.yoga.t;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class YogaLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.nr.nr, x {
    private n b;
    private fx fx;
    private final jk nr;
    private final Map<View, jk> u;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        jk jkVarU;
        this.nr.u((com.bytedance.adsdk.ugeno.yoga.x) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.u(this);
            jk yogaNode = virtualYogaLayout.getYogaNode();
            jk jkVar = this.nr;
            jkVar.u(yogaNode, jkVar.u());
            return;
        }
        super.addView(view, i, layoutParams);
        if (this.u.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            jkVarU = ((YogaLayout) view).getYogaNode();
        } else {
            jkVarU = this.u.containsKey(view) ? this.u.get(view) : t.u();
            jkVarU.u(view);
            jkVarU.u((com.bytedance.adsdk.ugeno.yoga.x) new nr());
        }
        u((u) view.getLayoutParams(), jkVarU, view);
        this.u.put(view, jkVarU);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.nr.u()));
        } else {
            jk jkVar2 = this.nr;
            jkVar2.u(jkVarU, jkVar2.u());
        }
    }

    public void b(View view, int i) {
        int iU;
        view.setVisibility(i);
        try {
            jk jkVar = this.u.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (iU = this.nr.u(jkVar)) == -1) {
                    return;
                }
                this.nr.nr(iU);
                view.setTag(151060224, Integer.valueOf(iU));
                u(this.nr);
                return;
            }
            if (tag == null || this.nr.u(jkVar) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.nr.u()) {
                this.nr.u(this.u.get(view), iIntValue);
            } else {
                this.nr.u(this.u.get(view), this.nr.u());
            }
            u(this.nr);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof u;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.nr(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.nr
    public void fx(View view, int i) {
        b(view, i);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new u(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new u(layoutParams);
    }

    public float getBorderRadius() {
        return this.b.u();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getRipple() {
        return this.b.getRipple();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getRubIn() {
        return this.b.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getShine() {
        return this.b.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.u.x
    public float getStretch() {
        return this.b.getStretch();
    }

    public jk getYogaNode() {
        return this.nr;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.nr
    public void nr(int i) {
        jk jkVar = this.nr;
        if (jkVar != null) {
            nr(jkVar, i);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.iz();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.u(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.b();
        }
        if (!(getParent() instanceof YogaLayout)) {
            u(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        u(this.nr, 0.0f, 0.0f);
        fx fxVar2 = this.fx;
        if (fxVar2 != null) {
            fxVar2.u(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            u(i, i2);
        }
        fx fxVar = this.fx;
        if (fxVar != null) {
            int[] iArrU = fxVar.u(i, i2);
            setMeasuredDimension(iArrU[0], iArrU[1]);
        } else {
            setMeasuredDimension(Math.round(this.nr.n()), Math.round(this.nr.a()));
        }
        fx fxVar2 = this.fx;
        if (fxVar2 != null) {
            fxVar2.fx();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.nr(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        fx fxVar = this.fx;
        if (fxVar != null) {
            fxVar.u(z);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            u(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            u(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        u(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        u(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        u(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            u(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            u(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.b.u(i);
    }

    public void setBorderRadius(float f) {
        this.b.u(f);
    }

    public void setRipple(float f) {
        n nVar = this.b;
        if (nVar != null) {
            nVar.nr(f);
        }
    }

    public void setRubIn(float f) {
        n nVar = this.b;
        if (nVar != null) {
            nVar.pn(f);
        }
    }

    public void setShine(float f) {
        n nVar = this.b;
        if (nVar != null) {
            nVar.fx(f);
        }
    }

    public void setStretch(float f) {
        n nVar = this.b;
        if (nVar != null) {
            nVar.b(f);
        }
    }

    public jk u(View view) {
        return this.u.get(view);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new n(this);
        jk jkVarU = t.u();
        this.nr = jkVarU;
        this.u = new HashMap();
        jkVarU.u(this);
        jkVarU.u((com.bytedance.adsdk.ugeno.yoga.x) new nr());
        u((u) generateDefaultLayoutParams(), jkVarU, this);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.nr
    public void u(int i) {
        jk jkVar = this.nr;
        if (jkVar != null) {
            u(jkVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.nr
    public void nr(View view, int i) {
        jk jkVarU;
        if (view == null || (jkVarU = u(view)) == null) {
            return;
        }
        nr(jkVarU, i);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.nr
    public void u(View view, int i) {
        jk jkVarU;
        if (view == null || (jkVarU = u(view)) == null) {
            return;
        }
        u(jkVarU, i);
        view.requestLayout();
    }

    private void nr(jk jkVar, int i) {
        if (i == -1) {
            jkVar.x(100.0f);
        } else if (i == -2) {
            jkVar.pn();
        } else {
            jkVar.iz(i);
        }
    }

    private void u(jk jkVar, int i) {
        if (i == -1) {
            jkVar.pn(100.0f);
        } else if (i == -2) {
            jkVar.b();
        } else {
            jkVar.b(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements com.bytedance.adsdk.ugeno.yoga.x {
        @Override // com.bytedance.adsdk.ugeno.yoga.x
        public long u(jk jkVar, float f, com.bytedance.adsdk.ugeno.yoga.n nVar, float f2, com.bytedance.adsdk.ugeno.yoga.n nVar2) {
            View view = (View) jkVar.jk();
            if (view == null || (view instanceof YogaLayout)) {
                return a.u(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, u(nVar)), View.MeasureSpec.makeMeasureSpec((int) f2, u(nVar2)));
            return a.u(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int u(com.bytedance.adsdk.ugeno.yoga.n nVar) {
            if (nVar == com.bytedance.adsdk.ugeno.yoga.n.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return nVar == com.bytedance.adsdk.ugeno.yoga.n.EXACTLY ? 1073741824 : 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f5056a;
        private float b;
        private float bg;
        private float fx;
        private float iz;
        private float jk;
        private float k;
        private float l;
        private float mv;
        private float my;
        private float n;
        SparseArray<String> nr;
        private float o;
        private float pn;
        private float s;
        private float sx;
        private float t;
        SparseArray<Float> u;
        private float x;

        public u(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof u) {
                u uVar = (u) layoutParams;
                this.u = uVar.u.clone();
                this.nr = uVar.nr.clone();
                return;
            }
            this.u = new SparseArray<>();
            this.nr = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.u.put(15, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.u.put(16, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }

        public void a(float f) {
            this.k = f;
            this.u.put(12, Float.valueOf(f));
        }

        public void b(float f) {
            this.jk = f;
            this.u.put(8, Float.valueOf(f));
        }

        public void fx(float f) {
            this.f5056a = f;
            this.u.put(7, Float.valueOf(f));
        }

        public void iz(float f) {
            this.l = f;
            this.u.put(14, Float.valueOf(f));
        }

        public void jk(float f) {
            this.my = f;
            this.u.put(13, Float.valueOf(f));
        }

        public void k(float f) {
            this.o = f;
            this.u.put(25, Float.valueOf(f));
        }

        public void l(float f) {
            this.b = f;
            this.u.put(18, Float.valueOf(f));
        }

        public void mv(float f) {
            this.pn = f;
            this.u.put(19, Float.valueOf(f));
        }

        public void my(float f) {
            this.sx = f;
            this.u.put(27, Float.valueOf(f));
        }

        public void n(float f) {
            this.s = f;
            this.u.put(11, Float.valueOf(f));
        }

        public void nr(float f) {
            this.n = f;
            this.u.put(6, Float.valueOf(f));
        }

        public void o(float f) {
            this.bg = f;
            this.u.put(28, Float.valueOf(f));
        }

        public void pn(float f) {
            this.t = f;
            this.u.put(9, Float.valueOf(f));
        }

        public void s(float f) {
            this.iz = f;
            this.u.put(20, Float.valueOf(f));
        }

        public void t(float f) {
            this.fx = f;
            this.u.put(17, Float.valueOf(f));
        }

        public void u(float f) {
            this.x = f;
            this.u.put(5, Float.valueOf(f));
        }

        public void x(float f) {
            this.mv = f;
            this.u.put(10, Float.valueOf(f));
        }

        public u(int i, int i2) {
            super(i, i2);
            this.u = new SparseArray<>();
            this.nr = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.u.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.u.put(16, Float.valueOf(i2));
            }
        }
    }

    private void u(jk jkVar) {
        if (jkVar.nr() != null) {
            u(jkVar.nr());
        } else {
            jkVar.u(Float.NaN, Float.NaN);
        }
    }

    public void u(View view, jk jkVar) {
        this.u.put(view, jkVar);
        addView(view);
    }

    private void u(View view, boolean z) {
        jk jkVar = this.u.get(view);
        if (jkVar == null) {
            return;
        }
        jk jkVarNr = jkVar.nr();
        int i = 0;
        while (true) {
            if (i >= jkVarNr.u()) {
                break;
            }
            if (jkVarNr.u(i).equals(jkVar)) {
                jkVarNr.nr(i);
                break;
            }
            i++;
        }
        jkVar.u((Object) null);
        this.u.remove(view);
        if (z) {
            this.nr.u(Float.NaN, Float.NaN);
        }
    }

    private void u(jk jkVar, float f, float f2) {
        View view = (View) jkVar.jk();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(jkVar.iz() + f);
            int iRound2 = Math.round(jkVar.x() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(jkVar.n()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(jkVar.a()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iU = jkVar.u();
        for (int i = 0; i < iU; i++) {
            if (equals(view)) {
                u(jkVar.u(i), f, f2);
            } else if (!(view instanceof YogaLayout)) {
                u(jkVar.u(i), jkVar.iz() + f, jkVar.x() + f2);
            }
        }
    }

    private void u(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.nr.iz(size2);
        }
        if (mode == 1073741824) {
            this.nr.b(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.nr.t(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.nr.jk(size);
        }
        this.nr.u(Float.NaN, Float.NaN);
    }

    public static void u(u uVar, jk jkVar, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            jkVar.u(com.bytedance.adsdk.ugeno.yoga.fx.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                jkVar.nr(b.LEFT, r0.left);
                jkVar.nr(b.TOP, r0.top);
                jkVar.nr(b.RIGHT, r0.right);
                jkVar.nr(b.BOTTOM, r0.bottom);
            }
        }
        for (int i = 0; i < uVar.u.size(); i++) {
            int iKeyAt = uVar.u.keyAt(i);
            float fFloatValue = uVar.u.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                jkVar.fx(com.bytedance.adsdk.ugeno.yoga.u.u(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                jkVar.u(com.bytedance.adsdk.ugeno.yoga.u.u(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                jkVar.nr(com.bytedance.adsdk.ugeno.yoga.u.u(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                jkVar.l(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    jkVar.fx();
                } else {
                    jkVar.fx(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                jkVar.u(pn.u(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                jkVar.u(fFloatValue);
            } else if (iKeyAt == 7) {
                jkVar.nr(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    jkVar.x(100.0f);
                } else if (fFloatValue == -2.0f) {
                    jkVar.pn();
                } else {
                    jkVar.iz(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                jkVar.u(b.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                jkVar.u(iz.u(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                jkVar.u(b.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                jkVar.u(b.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                jkVar.u(b.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                jkVar.a(fFloatValue);
            } else if (iKeyAt == 27) {
                jkVar.n(fFloatValue);
            } else if (iKeyAt == 22) {
                jkVar.nr(b.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                jkVar.nr(b.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                jkVar.nr(b.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                jkVar.nr(b.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                jkVar.fx(b.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                jkVar.fx(b.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                jkVar.fx(b.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                jkVar.fx(b.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                jkVar.u(mv.u(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    jkVar.pn(100.0f);
                } else if (fFloatValue == -2.0f) {
                    jkVar.b();
                } else {
                    jkVar.b(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                jkVar.u(s.u(Math.round(fFloatValue)));
            }
        }
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.fx = fxVar;
    }
}
