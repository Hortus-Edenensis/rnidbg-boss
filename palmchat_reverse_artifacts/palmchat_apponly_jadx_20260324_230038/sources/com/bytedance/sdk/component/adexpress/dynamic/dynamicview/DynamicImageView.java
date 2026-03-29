package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.b.iz;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import com.bytedance.sdk.component.adexpress.dynamic.fx.n;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.iz.c;
import com.bytedance.sdk.component.iz.jk;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.iz.s;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.umeng.analytics.pro.bd;
import defpackage.td;
import defpackage.ud;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {
    private String u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements jk {
        private final WeakReference<Context> u;

        public u(Context context) {
            this.u = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.iz.jk
        public Bitmap coverterTo(Bitmap bitmap) {
            Context context = this.u.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.b.nr.u(context, bitmap, 25);
            }
            return null;
        }
    }

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, n nVar) {
        super(context, dynamicRootView, nVar);
        if (!TextUtils.isEmpty(this.l.tm()) && nVar.bg()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.l.rv());
            dynamicLottieView.setImageLottieTosPath(this.l.tm());
            dynamicLottieView.setLottieAppNameMaxLength(this.l.ju());
            dynamicLottieView.setLottieAdTitleMaxLength(this.l.ob());
            dynamicLottieView.setLottieAdDescMaxLength(this.l.ge());
            dynamicLottieView.setData(nVar.bq());
            this.k = dynamicLottieView;
        } else if (this.l.k() > 0.0f) {
            TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
            this.k = tTRoundRectImageView;
            tTRoundRectImageView.setXRound((int) com.bytedance.sdk.component.adexpress.b.n.u(context, this.l.k()));
            ((TTRoundRectImageView) this.k).setYRound((int) com.bytedance.sdk.component.adexpress.b.n.u(context, this.l.k()));
        } else if (!x() && "arrowButton".equals(nVar.jk().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.l);
            this.k = animationImageView;
        } else if (com.bytedance.sdk.component.adexpress.b.jk.nr(this.l.t())) {
            this.k = new GifView(context);
        } else {
            String strT = this.l.t();
            mv renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest == null || renderRequest.nr() == null || !TextUtils.equals(strT, renderRequest.u())) {
                this.k = new ImageView(context);
            } else {
                this.k = renderRequest.nr();
            }
        }
        this.u = nr(this.l.t());
        this.k.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(nVar.jk().getType())) {
            if (this.l.nr() > 0 || this.l.u() > 0) {
                int iMin = Math.min(this.x, this.n);
                this.x = iMin;
                this.n = Math.min(iMin, this.n);
                this.f5081a = (int) (this.f5081a + com.bytedance.sdk.component.adexpress.b.n.u(context, this.l.nr() + (this.l.u() / 2) + 0.5f));
            } else {
                int iMax = Math.max(this.x, this.n);
                this.x = iMax;
                this.n = Math.max(iMax, this.n);
            }
            this.l.u(this.x / 2);
        }
        addView(this.k, new FrameLayout.LayoutParams(this.x, this.n));
    }

    private boolean a() {
        String strL = this.l.l();
        if (this.l.bq()) {
            return true;
        }
        if (TextUtils.isEmpty(strL)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strL);
            return Math.abs((((float) this.x) / (((float) this.n) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException unused) {
            return false;
        }
    }

    private void u(s sVar) {
        sVar.type(3).to(new qq() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.1
            @Override // com.bytedance.sdk.component.iz.qq
            public void onSuccess(my myVar) {
                Object result = myVar.getResult();
                if (result instanceof byte[]) {
                    DynamicImageView dynamicImageView = DynamicImageView.this;
                    View view = dynamicImageView.k;
                    if (view instanceof ImageView) {
                        iz.nr((ImageView) view, (byte[]) result, dynamicImageView.x, dynamicImageView.n);
                    }
                }
            }

            @Override // com.bytedance.sdk.component.iz.qq
            public void onFailed(int i, String str, Throwable th) {
            }
        }, 4);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.b
    public boolean n() {
        super.n();
        try {
            View view = this.k;
            if (view instanceof UpieImageView) {
                view.setBackgroundColor(this.l.d());
                if (a()) {
                    ((UpieImageView) this.k).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((UpieImageView) this.k).setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    ((UpieImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.l.tm())) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.mv.jk().getType())) {
            ((ImageView) this.k).setImageResource(q.pn(this.t, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.k).getDrawable() != null) {
                ((ImageView) this.k).getDrawable().setAutoMirrored(true);
            }
            this.k.setPadding(0, 0, 0, 0);
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.k.setBackgroundColor(this.l.d());
        String strNr = this.mv.jk().nr();
        if (bd.m.equals(strNr)) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.k).setColorFilter(this.l.x());
            q.u(getContext(), "tt_user", (ImageView) this.k);
            ImageView imageView = (ImageView) this.k;
            int i = this.x;
            imageView.setPadding(i / 10, this.n / 5, i / 10, 0);
        } else if (strNr != null && strNr.startsWith("@")) {
            try {
                ((ImageView) this.k).setImageResource(Integer.parseInt(strNr.substring(1)));
            } catch (Exception unused2) {
            }
        }
        c cVarPn = com.bytedance.sdk.component.adexpress.u.u.u.u().pn();
        String strT = this.l.t();
        if (!TextUtils.isEmpty(strT) && !strT.startsWith("http:") && !strT.startsWith("https:")) {
            DynamicRootView dynamicRootView = this.s;
            strT = a.nr(strT, (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) ? null : this.s.getRenderRequest().gi());
        }
        s sVarKey = cVarPn.from(strT).key(this.u);
        String strO = this.s.getRenderRequest().o();
        if (!TextUtils.isEmpty(strO)) {
            sVarKey.cacheDir(strO);
        }
        if (a()) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_CENTER);
            sVarKey.config(Bitmap.Config.ARGB_4444).type(2).converter(new u(this.t)).to(new nr(this.k, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.b.u()) {
                sVarKey.to((ImageView) this.k);
            }
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.k instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.k).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.bytedance.sdk.component.adexpress.b.u()) {
            u(sVarKey);
        }
        return true;
    }

    public String nr(String str) {
        Map<String, String> mapS = this.s.getRenderRequest().s();
        if (mapS == null || mapS.size() <= 0) {
            return null;
        }
        return mapS.get(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.k;
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !td.a(drawable)) {
                return;
            }
            ud.a(drawable).start();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View view = this.k;
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !td.a(drawable)) {
                return;
            }
            ud.a(drawable).stop();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements qq<Bitmap> {
        private Resources nr;
        private WeakReference<View> u;

        public nr(View view, Resources resources) {
            this.u = new WeakReference<>(view);
            this.nr = resources;
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onSuccess(my<Bitmap> myVar) {
            Bitmap result;
            View view = this.u.get();
            if (view == null || (result = myVar.getResult()) == null || myVar.getOriginResult() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.nr, result));
        }

        @Override // com.bytedance.sdk.component.iz.qq
        public void onFailed(int i, String str, Throwable th) {
        }
    }
}
