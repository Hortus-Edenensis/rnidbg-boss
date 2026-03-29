package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.u;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends fx<UgenLottieView> {

    @Deprecated
    private boolean fn;
    private String gb;
    private boolean gl;
    protected final Map<String, Integer> hs;
    private boolean ic;
    private float iq;
    private int je;
    protected HashMap<String, Bitmap> ki;
    protected ImageView.ScaleType te;
    protected ImageView.ScaleType ti;
    protected String u;
    private float wj;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 implements b {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.lottie.b
        public Bitmap u(final a aVar) {
            final String strU;
            if (aVar == null) {
                return null;
            }
            String strS = aVar.s();
            String strMv = aVar.mv();
            if (!TextUtils.isEmpty(strS) && TextUtils.isEmpty(strMv)) {
                strU = com.bytedance.adsdk.ugeno.b.nr.u(strS, ((fx) nr.this).b);
            } else if (!TextUtils.isEmpty(strMv) && TextUtils.isEmpty(strS)) {
                strU = com.bytedance.adsdk.ugeno.b.nr.u(strMv, ((fx) nr.this).b);
            } else if (TextUtils.isEmpty(strMv) || TextUtils.isEmpty(strS)) {
                strU = null;
            } else {
                strU = com.bytedance.adsdk.ugeno.b.nr.u(strS, ((fx) nr.this).b) + com.bytedance.adsdk.ugeno.b.nr.u(strMv, ((fx) nr.this).b);
            }
            if (TextUtils.isEmpty(strU)) {
                return null;
            }
            Bitmap bitmap = nr.this.ki.get(strU);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = nr.this.hs.get(strU);
            if (num == null || num.intValue() == 2) {
                nr.this.hs.put(strU, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            com.bytedance.adsdk.ugeno.b.u().nr().u(((fx) nr.this).f5034a, strU, new u.InterfaceC0173u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr.1.1
                @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
                public void u(Bitmap bitmap2) {
                    if (bitmap2 == null) {
                        nr.this.hs.put(strU, 2);
                        return;
                    }
                    final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, aVar.u(), aVar.nr(), false);
                    nr.this.ki.put(strU, bitmapCreateScaledBitmap);
                    nr.this.hs.remove(strU);
                    n.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.nr.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((UgenLottieView) ((fx) nr.this).pn).u(aVar.l(), bitmapCreateScaledBitmap);
                        }
                    });
                }
            });
            return nr.this.ki.get(strU);
        }
    }

    public nr(Context context) {
        super(context);
        this.gb = "images";
        this.wj = 1.0f;
        this.hs = new ConcurrentHashMap();
        this.te = ImageView.ScaleType.FIT_CENTER;
        this.ti = ImageView.ScaleType.FIT_XY;
        this.ki = new HashMap<>();
    }

    private ImageView.ScaleType l(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private ImageView.ScaleType mv(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    private String t(String str) {
        return (!TextUtils.isEmpty(str) && str.contains("local")) ? str.contains("shake_phone") ? "lottie_json/shake_phone.json" : str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "" : "";
    }

    public void n() {
        ((UgenLottieView) this.pn).u();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UgenLottieView u() {
        UgenLottieView ugenLottieView = new UgenLottieView(this.nr);
        ugenLottieView.u(this);
        return ugenLottieView;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        ((UgenLottieView) this.pn).setProgress(this.iq);
        if (this.wj <= 0.0f) {
            this.wj = 1.0f;
        }
        ((UgenLottieView) this.pn).setSpeed(this.wj);
        if (this.u.startsWith("local")) {
            ((UgenLottieView) this.pn).setAnimation(t(this.u));
            ((UgenLottieView) this.pn).setImageAssetsFolder(this.gb);
        } else {
            ((UgenLottieView) this.pn).setAnimationFromUrl(this.u);
        }
        ((UgenLottieView) this.pn).setImageAssetDelegate(new AnonymousClass1());
        if (h()) {
            ((UgenLottieView) this.pn).setScaleType(this.ti);
        } else {
            ((UgenLottieView) this.pn).setScaleType(this.te);
        }
        if (h()) {
            ((UgenLottieView) this.pn).setRepeatCount(this.je);
        } else {
            ((UgenLottieView) this.pn).u(this.fn);
        }
        n();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
                this.ti = mv(str2);
                break;
            case "scaleType":
                this.te = l(str2);
                break;
            case "progress":
                this.iq = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case "imagePath":
                this.gb = str2;
                break;
            case "autoReverse":
                this.gl = com.bytedance.adsdk.ugeno.iz.fx.u(str2, false);
                break;
            case "src":
                this.u = str2;
                break;
            case "loop":
                if (h()) {
                    this.je = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0);
                    break;
                } else {
                    this.fn = com.bytedance.adsdk.ugeno.iz.fx.u(str2, false);
                    break;
                }
                break;
            case "speed":
                this.wj = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 1.0f);
                break;
            case "autoPlay":
                this.ic = com.bytedance.adsdk.ugeno.iz.fx.u(str2, false);
                break;
            case "autoplay":
                this.ic = com.bytedance.adsdk.ugeno.iz.fx.u(str2, true);
                break;
        }
    }
}
