package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.b.iz;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.dynamic.fx.x;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.iz.jk;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.iz.s;
import com.bytedance.sdk.component.utils.z;
import com.huawei.hms.ads.ClickAreaSource;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.adsdk.utils.LxAdOSUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    private static String bq = "";
    protected InteractViewContainer bg;
    private ImageView c;
    private volatile boolean dw;
    private Runnable nr;
    private Runnable u;

    /* JADX INFO: compiled from: SearchBox */
    public static class fx implements jk {
        private final int nr;
        private final WeakReference<Context> u;

        public fx(Context context, int i) {
            this.u = new WeakReference<>(context);
            this.nr = i;
        }

        @Override // com.bytedance.sdk.component.iz.jk
        public Bitmap coverterTo(Bitmap bitmap) {
            Context context = this.u.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.b.nr.u(context, bitmap, this.nr);
            }
            return null;
        }
    }

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        this.dw = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = nVar.jk().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.n - ((int) com.bytedance.sdk.component.adexpress.b.n.u(context, this.l.nr() + this.l.u())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.n - ((int) com.bytedance.sdk.component.adexpress.b.n.u(context, this.l.nr() + this.l.u())));
        }
    }

    private void a() {
        if (this.dw) {
            int iWi = this.l.wi();
            int iSu = this.l.su();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.s;
                    if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.bg = new InteractViewContainer(dynamicBaseWidgetImp2.t, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.l);
                    } else {
                        mv renderRequest = DynamicBaseWidgetImp.this.s.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.fx.jk jkVar = new com.bytedance.sdk.component.adexpress.dynamic.fx.jk();
                        jkVar.u(renderRequest.sx());
                        jkVar.nr(renderRequest.bg());
                        jkVar.fx(renderRequest.bq());
                        jkVar.u(renderRequest.dw());
                        jkVar.nr(renderRequest.c());
                        jkVar.fx(renderRequest.q());
                        jkVar.b(renderRequest.qq());
                        jkVar.pn(renderRequest.kj());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.bg = new InteractViewContainer(dynamicBaseWidgetImp4.t, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.l, jkVar, renderRequest);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.nr(dynamicBaseWidgetImp5.bg);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.bg.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.u((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.bg, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.bg.fx();
                }
            };
            this.u = runnable;
            postDelayed(runnable, ((long) iWi) * 1000);
            if (this.l.mh() || iSu >= Integer.MAX_VALUE || iWi >= iSu) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.7
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    if (dynamicBaseWidgetImp.bg != null) {
                        dynamicBaseWidgetImp.dw = false;
                        DynamicBaseWidgetImp.this.bg.b();
                        DynamicBaseWidgetImp.this.bg.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp2.removeView(dynamicBaseWidgetImp2.bg);
                    }
                }
            };
            this.nr = runnable2;
            postDelayed(runnable2, ((long) iSu) * 1000);
        }
    }

    private static String getBuildModel() {
        try {
            bq = z.u();
        } catch (Throwable unused) {
            bq = Build.MODEL;
        }
        if (TextUtils.isEmpty(bq)) {
            bq = Build.MODEL;
        }
        return bq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable nr(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    string = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = x.u(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawableU = u(u(string), iArr);
            gradientDrawableU.setShape(0);
            gradientDrawableU.setCornerRadius(com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.k()));
            return gradientDrawableU;
        } catch (Throwable unused) {
            return null;
        }
    }

    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.x, this.n);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        Drawable backgroundDrawable;
        DynamicRootView dynamicRootView;
        JSONObject jSONObjectOptJSONObject;
        View view = this.k;
        final View view2 = view;
        if (view == null) {
            view2 = this;
        }
        setContentDescription(this.mv.u(this.l.gi()));
        String strJw = this.l.jw();
        String strGi = null;
        String strU = (TextUtils.isEmpty(strJw) || (dynamicRootView = this.s) == null || dynamicRootView.getRenderRequest() == null || this.s.getRenderRequest().pn() == null || (jSONObjectOptJSONObject = this.s.getRenderRequest().pn().optJSONObject(ClickAreaSource.CREATIVE)) == null) ? null : u(jSONObjectOptJSONObject.opt(strJw));
        if (TextUtils.isEmpty(strU)) {
            strU = this.l.dw();
        }
        if (this.l.bq()) {
            com.bytedance.sdk.component.adexpress.u.u.u.u().pn().from(this.l.nr).type(2).converter(new fx(this.t, this.l.bg())).to(new nr(view2, this));
        } else if (!TextUtils.isEmpty(strU)) {
            if (!strU.startsWith("http:") && !strU.startsWith("https:")) {
                DynamicRootView dynamicRootView2 = this.s;
                if (dynamicRootView2 != null && dynamicRootView2.getRenderRequest() != null) {
                    strGi = this.s.getRenderRequest().gi();
                }
                strU = a.nr(strU, strGi);
            }
            s sVarType = com.bytedance.sdk.component.adexpress.u.u.u.u().pn().from(strU).type(2);
            u(sVarType);
            if (com.bytedance.sdk.component.adexpress.b.u()) {
                sVarType.to(new u(view2, this.s, this.mv));
            } else if ((view2 instanceof FrameLayout) && TextUtils.equals(this.mv.jk().getType(), "vessel")) {
                if (com.bytedance.sdk.component.adexpress.b.jk.nr(strU)) {
                    this.c = new GifView(this.t);
                } else {
                    this.c = new ImageView(this.t);
                }
                ((FrameLayout) view2).addView(this.c, new FrameLayout.LayoutParams(-1, -1));
                sVarType.type(3).to(new qq() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.1
                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onSuccess(my myVar) {
                        Object result = myVar.getResult();
                        if (result instanceof byte[]) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            iz.nr(DynamicBaseWidgetImp.this.c, (byte[]) result, dynamicBaseWidgetImp.x, dynamicBaseWidgetImp.n);
                        }
                    }

                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onFailed(int i, String str, Throwable th) {
                    }
                }, 4);
            } else {
                u(sVarType, view2);
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view2.setBackground(backgroundDrawable);
        }
        if (this.l.h() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.l.pb() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable drawableNr = dynamicBaseWidgetImp.nr(dynamicBaseWidgetImp.s.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.l.pb())));
                            if (drawableNr == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                drawableNr = dynamicBaseWidgetImp2.u(true, dynamicBaseWidgetImp2.s.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.l.pb())));
                            }
                            if (drawableNr != null) {
                                view2.setBackground(drawableNr);
                                return;
                            }
                            View view3 = view2;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view3.setBackground(dynamicBaseWidgetImp3.u(true, dynamicBaseWidgetImp3.s.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.l.h() * 1000.0d));
        }
        View view3 = this.k;
        if (view3 != null) {
            view3.setPadding((int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.fx()), (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.nr()), (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.b()), (int) com.bytedance.sdk.component.adexpress.b.n.u(this.t, this.l.u()));
        }
        if (this.my || this.l.s() > 0.0d) {
            setShouldInvisible(true);
            view2.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.k;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        double dBq = this.mv.jk().pn().bq();
        if (dBq < 90.0d && dBq > 0.0d) {
            com.bytedance.sdk.component.utils.jk.nr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (dBq * 1000.0d));
        }
        u(this.mv.jk().pn().bg(), view2);
        if (!TextUtils.isEmpty(this.l.xw())) {
            a();
        }
        super.onAttachedToWindow();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.u);
            removeCallbacks(this.nr);
        } catch (Exception unused) {
        }
    }

    private String u(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return u(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return u((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void u(s sVar, final View view) {
        sVar.to(new qq<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.3
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my<Bitmap> myVar) {
                DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.s;
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().iz()) && !WifiNestConst.NestTypeConst.NEST_SPLASH_AD.equals(DynamicBaseWidgetImp.this.s.getRenderRequest().iz())) {
                    view.setBackground(new BitmapDrawable(myVar.getResult()));
                } else {
                    if (!com.bytedance.sdk.component.adexpress.b.u()) {
                        view.setBackground(new BitmapDrawable(myVar.getResult()));
                        return;
                    }
                    view.setBackground(new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u(myVar.getResult(), ((DynamicRoot) DynamicBaseWidgetImp.this.s.getChildAt(0)).u));
                }
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i, String str, Throwable th) {
            }
        });
    }

    private static void u(s sVar) {
        if (LxAdOSUtils.ROM_SMARTISAN.equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            sVar.config(Bitmap.Config.ARGB_8888);
        }
    }

    private void u(double d, final View view) {
        if (d > 0.0d) {
            com.bytedance.sdk.component.utils.jk.nr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.mv.jk().pn().ti() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements qq<Bitmap> {
        private final WeakReference<DynamicBaseWidget> nr;
        private final WeakReference<View> u;

        public nr(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.u = new WeakReference<>(view);
            this.nr = new WeakReference<>(dynamicBaseWidget);
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onSuccess(my<Bitmap> myVar) {
            Bitmap result;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.u.get();
            if (view == null || (result = myVar.getResult()) == null || myVar.getOriginResult() == null || (dynamicBaseWidget = this.nr.get()) == null) {
                return;
            }
            view.setBackground(dynamicBaseWidget.u(result));
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onFailed(int i, String str, Throwable th) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements qq<Bitmap> {
        private final n fx;
        private final WeakReference<DynamicRootView> nr;
        private final WeakReference<View> u;

        public u(View view, DynamicRootView dynamicRootView, n nVar) {
            this.u = new WeakReference<>(view);
            this.nr = new WeakReference<>(dynamicRootView);
            this.fx = nVar;
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onSuccess(my<Bitmap> myVar) {
            View view = this.u.get();
            if (!com.bytedance.sdk.component.adexpress.b.u()) {
                DynamicRootView dynamicRootView = this.nr.get();
                if (dynamicRootView == null) {
                    return;
                }
                if ("open_ad".equals(dynamicRootView.getRenderRequest().iz()) || WifiNestConst.NestTypeConst.NEST_SPLASH_AD.equals(dynamicRootView.getRenderRequest().iz())) {
                    view.setBackground(new BitmapDrawable(myVar.getResult()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(myVar.getResult()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(myVar.getResult()));
            n nVar = this.fx;
            if (nVar == null || nVar.jk() == null || 6 != this.fx.jk().u() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onFailed(int i, String str, Throwable th) {
        }
    }
}
