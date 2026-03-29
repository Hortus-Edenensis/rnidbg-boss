package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.lottie.bq;
import com.bytedance.adsdk.lottie.fx;
import com.bytedance.sdk.component.iz.jk;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.huawei.hms.ads.ld;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DynamicLottieView extends LottieAnimationView {
    private boolean b;
    private boolean fx;
    private int iz;
    private Map<String, String> n;
    private String nr;
    private int pn;
    private Map<String, Bitmap> u;
    private int x;

    public DynamicLottieView(Context context) {
        super(context);
        this.u = new HashMap();
    }

    private void jk() {
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.nr + ".json");
        setImageAssetDelegate(new b() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1
            @Override // com.bytedance.adsdk.lottie.b
            public Bitmap u(final a aVar) {
                final String strMv;
                strMv = aVar.mv();
                strMv.hashCode();
                switch (strMv) {
                    case "{appIcon}":
                        if (DynamicLottieView.this.n != null) {
                            strMv = (String) DynamicLottieView.this.n.get("icon");
                            break;
                        }
                        break;
                    case "{adImage}":
                    case "{slot}":
                        if (DynamicLottieView.this.n != null) {
                            strMv = (String) DynamicLottieView.this.n.get(ld.f6599a);
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.u.get(strMv);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.u.u.u.u().pn().from(strMv).type(2).converter(new jk() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.2
                    @Override // com.bytedance.sdk.component.iz.jk
                    public Bitmap coverterTo(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, aVar.u(), aVar.nr(), false);
                        DynamicLottieView.this.u.put(strMv, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                }).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.1
                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onSuccess(my<Bitmap> myVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(myVar.getResult(), aVar.u(), aVar.nr(), false);
                        DynamicLottieView.this.u.put(strMv, bitmapCreateScaledBitmap);
                        DynamicLottieView.this.u(aVar.l(), bitmapCreateScaledBitmap);
                    }

                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onFailed(int i, String str, Throwable th) {
                    }
                });
                return (Bitmap) DynamicLottieView.this.u.get(strMv);
            }
        });
        if (this.n != null) {
            bq bqVar = new bq(this);
            String str = this.n.get("app_name");
            String str2 = this.n.get("description");
            String str3 = this.n.get("title");
            if (this.pn > 0 && str.length() > this.pn) {
                str = str.substring(0, this.pn - 1) + "...";
            } else if (this.pn <= 0) {
                str = "";
            }
            if (this.iz > 0 && str3.length() > this.iz) {
                str3 = str3.substring(0, this.iz - 1) + "...";
            } else if (this.pn <= 0) {
                str3 = "";
            }
            if (this.x > 0 && str2.length() > this.x) {
                str2 = str2.substring(0, this.x - 1) + "...";
            } else if (this.pn <= 0) {
                str2 = "";
            }
            bqVar.nr("{appName}", str);
            bqVar.nr("{adTitle}", str3);
            bqVar.nr("{adDesc}", str2);
            setTextDelegate(bqVar);
            setFontAssetDelegate(new fx() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.2
                @Override // com.bytedance.adsdk.lottie.fx
                public String nr(String str4) {
                    return null;
                }

                @Override // com.bytedance.adsdk.lottie.fx
                public Typeface u(String str4) {
                    return Typeface.MONOSPACE;
                }
            });
        }
        u();
    }

    private void t() {
        setAnimationFromUrl(this.nr);
        setImageAssetDelegate(new b() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3
            @Override // com.bytedance.adsdk.lottie.b
            public Bitmap u(final a aVar) {
                if (aVar == null) {
                    return null;
                }
                final String strS = aVar.s();
                String strMv = aVar.mv();
                if (TextUtils.isEmpty(strS) || !TextUtils.isEmpty(strMv)) {
                    if (!TextUtils.isEmpty(strMv) && TextUtils.isEmpty(strS)) {
                        strS = strMv;
                    } else if (TextUtils.isEmpty(strMv) || TextUtils.isEmpty(strS)) {
                        strS = "";
                    } else {
                        strS = strS + strMv;
                    }
                }
                if (TextUtils.isEmpty(strS)) {
                    return null;
                }
                Bitmap bitmap = DynamicLottieView.this.u == null ? null : (Bitmap) DynamicLottieView.this.u.get(strS);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.u.u.u.u().pn().from(strS).converter(new jk() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.2
                    @Override // com.bytedance.sdk.component.iz.jk
                    public Bitmap coverterTo(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, aVar.u(), aVar.nr(), false);
                        if (DynamicLottieView.this.u != null) {
                            DynamicLottieView.this.u.put(strS, bitmapCreateScaledBitmap);
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }).to(new qq<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.1
                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onSuccess(my<Bitmap> myVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(myVar.getResult(), aVar.u(), aVar.nr(), false);
                        if (DynamicLottieView.this.u != null) {
                            DynamicLottieView.this.u.put(strS, bitmapCreateScaledBitmap);
                        }
                        DynamicLottieView.this.u(aVar.l(), bitmapCreateScaledBitmap);
                    }

                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onFailed(int i, String str, Throwable th) {
                    }
                });
                if (DynamicLottieView.this.u == null) {
                    return null;
                }
                return (Bitmap) DynamicLottieView.this.u.get(strS);
            }
        });
        u();
    }

    public void a() {
        if (TextUtils.isEmpty(this.nr)) {
            return;
        }
        setProgress(0.0f);
        u(this.fx);
        if (this.b) {
            t();
        } else {
            jk();
        }
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iz();
    }

    public void setAnimationsLoop(boolean z) {
        this.fx = z;
    }

    public void setData(Map<String, String> map) {
        this.n = map;
    }

    public void setImageLottieTosPath(String str) {
        this.nr = str;
    }

    public void setLottieAdDescMaxLength(int i) {
        this.x = i;
    }

    public void setLottieAdTitleMaxLength(int i) {
        this.iz = i;
    }

    public void setLottieAppNameMaxLength(int i) {
        this.pn = i;
    }

    public void setOnlyLoadNetImage(boolean z) {
        this.b = z;
    }
}
