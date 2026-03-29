package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.umeng.analytics.pro.dn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class InteractViewContainer extends FrameLayout implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5088a;
    private View b;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.x fx;
    private String iz;
    private boolean jk;
    private com.bytedance.sdk.component.adexpress.nr.mv l;
    private View.OnTouchListener n;
    private DynamicBaseWidget nr;
    private x pn;
    private com.bytedance.sdk.component.adexpress.dynamic.fx.jk t;
    private Context u;
    private RippleView x;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar) {
        super(context);
        this.u = context;
        this.nr = dynamicBaseWidget;
        this.fx = xVar;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.n != null) {
            setOnClickListener((View.OnClickListener) this.nr.getDynamicClickListener());
            performClick();
            if (this.fx.zx()) {
                return;
            }
            setVisibility(8);
        }
    }

    private boolean n() {
        return (this.fx.eh() || TextUtils.equals("9", this.iz) || TextUtils.equals("16", this.iz) || TextUtils.equals(BaseWrapper.ENTER_ID_17, this.iz) || TextUtils.equals(BaseWrapper.ENTER_ID_18, this.iz) || TextUtils.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER, this.iz) || TextUtils.equals("29", this.iz) || TextUtils.equals("10", this.iz)) ? false : true;
    }

    private void x() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.iz = this.fx.xw();
        this.f5088a = this.fx.cj();
        this.jk = this.fx.eh();
        x xVarU = a.u(this.u, this.nr, this.fx, this.t, this.l);
        this.pn = xVarU;
        if (xVarU != null) {
            this.b = xVarU.fx();
            if (this.fx.oa()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.iz, "6")) {
                if (!this.fx.lf() || TextUtils.isEmpty(this.fx.nb())) {
                    this.x = new RippleView(this.u, Color.parseColor("#99000000"));
                } else {
                    this.x = new RippleView(this.u, com.bytedance.sdk.component.adexpress.dynamic.fx.x.u(this.fx.nb()));
                }
                FrameLayout frameLayout = new FrameLayout(this.u);
                frameLayout.addView(this.x, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.x.nr();
                    }
                });
            }
            if (u(this.iz) && com.bytedance.sdk.component.adexpress.b.u()) {
                int color = Color.parseColor("#99000000");
                if (this.fx.lf() && !TextUtils.isEmpty(this.fx.nb())) {
                    try {
                        color = com.bytedance.sdk.component.adexpress.dynamic.fx.x.u(this.fx.nb());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.u);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.pn.fx());
            u(this.pn.fx());
            setVisibility(0);
        }
    }

    public void b() {
        x xVar = this.pn;
        if (xVar != null) {
            xVar.nr();
        }
    }

    public void fx() {
        x xVar = this.pn;
        if (xVar != null) {
            xVar.u();
        }
    }

    public void iz() {
        if (this.b != null && TextUtils.equals(this.iz, "2")) {
            View view = this.b;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).b();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            x xVar = this.pn;
            if (xVar != null) {
                xVar.nr();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.u(e.getMessage());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.n instanceof com.bytedance.sdk.component.adexpress.dynamic.interact.u.fx) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void pn() {
        if (this.b != null && TextUtils.equals(this.iz, "2")) {
            View view = this.b;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).fx();
            }
        }
    }

    private boolean u(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, BaseWrapper.ENTER_ID_SHORTCUT) || TextUtils.equals(str, "25") || TextUtils.equals(str, BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING) || TextUtils.equals(str, "1");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.n
    public void nr() {
        if (n()) {
            setOnClickListener((View.OnClickListener) this.nr.getDynamicClickListener());
            performClick();
            if (this.fx.zx()) {
                return;
            }
            setVisibility(8);
        }
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar, com.bytedance.sdk.component.adexpress.dynamic.fx.jk jkVar, com.bytedance.sdk.component.adexpress.nr.mv mvVar) {
        super(context);
        this.u = context;
        this.nr = dynamicBaseWidget;
        this.fx = xVar;
        this.t = jkVar;
        this.l = mvVar;
        x();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void u(ViewGroup viewGroup) {
        if (this.b == null) {
            return;
        }
        String str = this.iz;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (str.equals("8")) {
                    b = 6;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    b = 7;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (str.equals(BaseWrapper.ENTER_ID_MARKET)) {
                    b = 10;
                }
                break;
            case 1570:
                if (str.equals(BaseWrapper.ENTER_ID_GAME_CENTER)) {
                    b = 11;
                }
                break;
            case 1571:
                if (str.equals(BaseWrapper.ENTER_ID_AD_SDK)) {
                    b = 12;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    b = dn.k;
                }
                break;
            case 1574:
                if (str.equals(BaseWrapper.ENTER_ID_17)) {
                    b = dn.l;
                }
                break;
            case 1575:
                if (str.equals(BaseWrapper.ENTER_ID_18)) {
                    b = 15;
                }
                break;
            case 1598:
                if (str.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER)) {
                    b = 16;
                }
                break;
            case 1600:
                if (str.equals(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING)) {
                    b = 17;
                }
                break;
            case 1601:
                if (str.equals(BaseWrapper.ENTER_ID_SHORTCUT)) {
                    b = 18;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    b = 20;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    b = 21;
                }
                break;
        }
        switch (b) {
            case 0:
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.pn(this, this.f5088a);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.fx.lf() || TextUtils.isEmpty(this.fx.nb())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.iz(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.nr(this, this);
                break;
            case 3:
                if (this.fx.lf() && !TextUtils.isEmpty(this.fx.nb())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.fx.x.u(this.fx.nb()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.fx(this);
                this.b.setTag(2);
                break;
            case 6:
            case 9:
                this.nr.setClipChildren(false);
                this.nr.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.nr.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.iz(this);
                break;
            case 7:
            case 14:
                this.b.setTag(2);
                break;
            case 8:
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.b(this, this.f5088a, this.jk);
                break;
            case 10:
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.fx(this);
                this.b.setTag(2);
                break;
            case 11:
            case 19:
                if (this.iz.equals("24") && com.bytedance.sdk.component.adexpress.b.u()) {
                    this.nr.setClipChildren(false);
                    this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.iz(this);
                } else {
                    this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.pn(this, this.f5088a);
                }
                break;
            case 12:
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.nr(this, this);
                break;
            case 13:
                View view = this.b;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.b).getShakeLayout().setTag(2);
                }
                this.b.setTag(2);
                break;
            case 15:
                View view2 = this.b;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.b).getWriggleLayout().setTag(2);
                }
                this.b.setTag(2);
                break;
            case 16:
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.u(this, this.f5088a, viewGroup);
                break;
            case 17:
                if (com.bytedance.sdk.component.adexpress.b.u()) {
                    this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.n(this, this.jk);
                } else {
                    this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.x(this, this.f5088a, viewGroup);
                }
                break;
            case 18:
                if (com.bytedance.sdk.component.adexpress.b.u()) {
                    this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.iz(this);
                }
                break;
            case 20:
                if (com.bytedance.sdk.component.adexpress.b.u()) {
                    this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.n(this, this.jk);
                }
                break;
            case 21:
                View view3 = this.b;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.b).getShakeView().setTag(2);
                }
                this.n = new com.bytedance.sdk.component.adexpress.dynamic.interact.u.pn(this, this.f5088a);
                break;
        }
        View.OnTouchListener onTouchListener = this.n;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (n()) {
            this.b.setTag(2);
            setOnClickListener((View.OnClickListener) this.nr.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.n
    public void u() {
        if (TextUtils.equals(this.iz, "6")) {
            RippleView rippleView = this.x;
            if (rippleView != null) {
                rippleView.fx();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.a();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.iz, BaseWrapper.ENTER_ID_SYSTEM_HELPER)) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.a();
                }
            }, 400L);
        } else {
            a();
        }
    }
}
