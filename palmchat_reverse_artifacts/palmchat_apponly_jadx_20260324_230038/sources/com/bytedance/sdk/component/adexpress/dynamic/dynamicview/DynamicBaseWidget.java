package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.sdk.component.adexpress.dynamic.fx.iz;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.dynamic.fx.x;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.utils.qq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class DynamicBaseWidget extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.animation.view.nr, b, pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f5081a;
    protected float b;
    private float bg;
    private float bq;
    private boolean c;
    private qq dw;
    protected float fx;
    protected float iz;
    protected int jk;
    protected View k;
    protected x l;
    protected n mv;
    protected boolean my;
    protected int n;
    private float nr;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.u.nr o;
    protected float pn;
    private boolean q;
    protected DynamicRootView s;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.u sx;
    protected Context t;
    private float u;
    protected int x;
    private static final View.OnTouchListener qq = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener kj = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context);
        this.c = true;
        this.t = context;
        this.s = dynamicRootView;
        this.mv = nVar;
        this.fx = nVar.iz();
        this.b = nVar.x();
        this.pn = nVar.n();
        this.iz = nVar.a();
        this.f5081a = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.fx);
        this.jk = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.b);
        this.x = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.pn);
        this.n = (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.iz);
        x xVar = new x(nVar.jk());
        this.l = xVar;
        if (xVar.sx() > 0) {
            this.x += this.l.sx() * 2;
            this.n += this.l.sx() * 2;
            this.f5081a -= this.l.sx();
            this.jk -= this.l.sx();
            List<n> listT = nVar.t();
            if (listT != null) {
                for (n nVar2 : listT) {
                    nVar2.fx(nVar2.iz() + com.bytedance.sdk.component.adexpress.b.n.nr(this.t, this.l.sx()));
                    nVar2.b(nVar2.x() + com.bytedance.sdk.component.adexpress.b.n.nr(this.t, this.l.sx()));
                    nVar2.u(com.bytedance.sdk.component.adexpress.b.n.nr(this.t, this.l.sx()));
                    nVar2.nr(com.bytedance.sdk.component.adexpress.b.n.nr(this.t, this.l.sx()));
                }
            }
        }
        this.my = this.l.s() > 0.0d;
        this.sx = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.u();
    }

    private void a() {
        if (isShown()) {
            int iU = com.bytedance.sdk.component.adexpress.dynamic.nr.u.u(this.l);
            if (iU == 2) {
                if (this.dw == null) {
                    this.dw = new qq(getContext().getApplicationContext(), 1, this.c, this.q);
                }
                this.dw.u(new qq.u() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.3
                    @Override // com.bytedance.sdk.component.utils.qq.u
                    public void u(int i) {
                        if (i == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.jk();
                        }
                    }
                });
                mv renderRequest = this.s.getRenderRequest();
                if (renderRequest != null) {
                    this.dw.u(renderRequest.sx());
                    this.dw.pn(renderRequest.qq());
                    this.dw.fx(renderRequest.c());
                    this.dw.nr(renderRequest.bq());
                    this.dw.iz(renderRequest.kj());
                    this.dw.u(renderRequest.dw());
                    this.dw.nr(renderRequest.q());
                }
            } else if (iU == 3) {
                if (this.dw == null) {
                    this.dw = new qq(getContext().getApplicationContext(), 2, this.c, this.q);
                }
                this.dw.u(new qq.u() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.4
                    @Override // com.bytedance.sdk.component.utils.qq.u
                    public void u(int i) {
                        if (i == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.jk();
                        }
                    }
                });
                mv renderRequest2 = this.s.getRenderRequest();
                if (renderRequest2 != null) {
                    this.dw.nr(renderRequest2.bq());
                    this.dw.iz(renderRequest2.kj());
                    this.dw.u(renderRequest2.dw());
                    this.dw.nr(renderRequest2.q());
                }
            }
            qq qqVar = this.dw;
            if (qqVar != null) {
                DynamicRootView dynamicRootView = this.s;
                if (dynamicRootView == null) {
                    qqVar.u(0);
                    return;
                }
                mv renderRequest3 = dynamicRootView.getRenderRequest();
                if (renderRequest3 != null) {
                    this.dw.u(renderRequest3.h());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        try {
            View view = this.k;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(kj);
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        x xVar = this.l;
        return (xVar == null || xVar.gi() == 0) ? false : true;
    }

    public boolean fx() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.k;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (b()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = qq;
            onClickListener = kj;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iU = com.bytedance.sdk.component.adexpress.dynamic.nr.u.u(this.l);
            if (iU == 2 || iU == 3) {
                view2.setOnClickListener(kj);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        u(view2);
        nr(view2);
        return true;
    }

    public Drawable getBackgroundDrawable() {
        return u(false, "");
    }

    public boolean getBeginInvisibleAndShow() {
        return this.my;
    }

    public int getClickArea() {
        return this.l.gi();
    }

    public GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.pn.u getDynamicClickListener() {
        return this.s.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.n;
    }

    public iz getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.fx.pn pnVarJk;
        n nVar = this.mv;
        if (nVar == null || (pnVarJk = nVar.jk()) == null) {
            return null;
        }
        return pnVarJk.pn();
    }

    public int getDynamicWidth() {
        return this.x;
    }

    public String getImageObjectFit() {
        return this.l.ay();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.nr
    public float getMarqueeValue() {
        return this.bg;
    }

    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(u(nr(this.l.xg().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.nr
    public float getRippleValue() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.nr
    public float getShineValue() {
        return this.nr;
    }

    public float getStretchValue() {
        return this.bq;
    }

    public void iz() {
        if (x()) {
            return;
        }
        View view = this.k;
        if (view == null) {
            view = this;
        }
        com.bytedance.sdk.component.adexpress.dynamic.animation.u.nr nrVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.u.nr(view, this.mv.jk().pn().ti());
        this.o = nrVar;
        nrVar.u();
    }

    public void nr(View view) {
        iz izVarPn;
        n nVar = this.mv;
        if (nVar == null || (izVarPn = nVar.jk().pn()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(izVarPn.wu()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iz();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        nr();
        super.onDetachedFromWindow();
        if (this.dw != null) {
            DynamicRootView dynamicRootView = this.s;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                this.dw.nr(0);
            } else {
                this.dw.nr(this.s.getRenderRequest().h());
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.sx.u(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.u uVar = this.sx;
        View view = this.k;
        if (view == null) {
            view = this;
        }
        uVar.u(view, i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.dw != null) {
            DynamicRootView dynamicRootView = this.s;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z) {
                    this.dw.u(0);
                    return;
                } else {
                    this.dw.nr(0);
                    return;
                }
            }
            if (z) {
                this.dw.u(this.s.getRenderRequest().h());
            } else {
                this.dw.nr(this.s.getRenderRequest().h());
            }
        }
    }

    public void pn() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.n);
        layoutParams.topMargin = this.jk;
        int i = this.f5081a;
        layoutParams.leftMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public void setCanUseSensor(boolean z) {
        this.c = z;
    }

    public void setMarqueeValue(float f) {
        this.bg = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.u = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.nr = f;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z) {
        this.my = z;
    }

    public void setStretchValue(float f) {
        this.bq = f;
        this.sx.u(this, f);
    }

    public void setUseNewShakeManager(boolean z) {
        this.q = z;
    }

    public boolean x() {
        n nVar = this.mv;
        return nVar == null || nVar.jk() == null || this.mv.jk().pn() == null || this.mv.jk().pn().ti() == null;
    }

    public boolean u() {
        n();
        pn();
        fx();
        return true;
    }

    private List<String> nr(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && i - 1 == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    public void u(int i) {
        x xVar = this.l;
        if (xVar != null && xVar.u(i)) {
            n();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).u(i);
                }
            }
        }
    }

    public void nr() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.u.nr nrVar = this.o;
        if (nrVar != null) {
            nrVar.nr();
        }
    }

    public void u(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.mv.n());
            jSONObject.put("height", this.mv.a());
            if (com.bytedance.sdk.component.adexpress.b.u()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.u.bq, this.l.m());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.u.dw, this.mv.jk().getType());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.u.c, this.mv.fx());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.u.q, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.l.m());
            view.setTag(2097610715, this.mv.jk().getType());
            view.setTag(2097610714, this.mv.fx());
            view.setTag(2097610713, jSONObject.toString());
            int iU = com.bytedance.sdk.component.adexpress.dynamic.nr.u.u(this.l);
            if (iU == 1) {
                view.setTag(2097610707, new Pair(this.l.kj(), Long.valueOf(this.l.z())));
                view.setTag(2097610708, Integer.valueOf(iU));
            }
        } catch (JSONException unused) {
        }
    }

    public Drawable u(boolean z, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iD;
        if (!TextUtils.isEmpty(this.l.xg())) {
            try {
                String strXg = this.l.xg();
                String strSubstring = strXg.substring(strXg.indexOf("(") + 1, strXg.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{x.u(strArrSplit[1]), x.u(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{x.u(strArrSplit[1].substring(0, 7)), x.u(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableU = u(u(strArrSplit[0]), iArr);
                gradientDrawableU.setShape(0);
                gradientDrawableU.setCornerRadius(com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.k()));
                return gradientDrawableU;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fU = com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.k());
        drawable.setCornerRadius(fU);
        if (fU < 1.0f) {
            float fU2 = com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.rh());
            float fU3 = com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.ja());
            float fU4 = com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.bf());
            float fU5 = com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.wq());
            float[] fArr = new float[8];
            if (fU2 > 0.0f) {
                fArr[0] = fU2;
                fArr[1] = fU2;
            }
            if (fU3 > 0.0f) {
                fArr[2] = fU3;
                fArr[3] = fU3;
            }
            if (fU4 > 0.0f) {
                fArr[4] = fU4;
                fArr[5] = fU4;
            }
            if (fU5 > 0.0f) {
                fArr[6] = fU5;
                fArr[7] = fU5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iD = Color.parseColor(str);
        } else {
            iD = this.l.d();
        }
        drawable.setColor(iD);
        if (this.l.o() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.o()), this.l.my());
            return drawable;
        }
        if (this.l.sx() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.l.sx(), this.l.my());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.mv.jk().getType(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new fx((int) fU, this.l.sx());
    }

    public nr u(Bitmap bitmap) {
        return new u(bitmap, null);
    }

    private Drawable[] u(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = x.u(strArrSplit[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable gradientDrawableU = u(u(strArrSplit[0]), iArr);
                gradientDrawableU.setShape(0);
                gradientDrawableU.setCornerRadius(com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.k()));
                drawableArr[(list.size() - 1) - i] = gradientDrawableU;
            }
        }
        return drawableArr;
    }

    public GradientDrawable u(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (iArr.length == 1) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iArr[0]);
                return gradientDrawable;
            }
            return new GradientDrawable(orientation, iArr);
        }
        return new GradientDrawable();
    }

    public GradientDrawable.Orientation u(String str) {
        try {
            int i = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}
