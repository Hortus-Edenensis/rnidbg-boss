package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.fx.s;
import com.bytedance.adsdk.ugeno.fx.x;
import com.bytedance.adsdk.ugeno.iz.b;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.u;
import defpackage.td;
import defpackage.ud;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends fx<RoundImageView> {
    private float gb;
    private float gl;
    protected boolean hs;
    protected ImageView.ScaleType ki;
    protected String te;
    private int ti;
    protected String u;

    public nr(Context context) {
        super(context);
        this.ki = ImageView.ScaleType.FIT_XY;
        this.ti = -1;
        this.gb = -1.0f;
        this.gl = -1.0f;
    }

    private void ay() {
        if (TextUtils.isEmpty(this.u)) {
            return;
        }
        ((RoundImageView) this.pn).setImageDrawable(null);
        if (this.u.startsWith("local://")) {
            try {
                String strReplace = this.u.replace("local://", "");
                if (TextUtils.equals(x(), "raw")) {
                    ((RoundImageView) this.pn).setImageResource(b.u(this.nr, strReplace));
                    return;
                } else {
                    ((RoundImageView) this.pn).setImageResource(b.nr(this.nr, strReplace));
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (!this.u.startsWith("@")) {
            v();
            return;
        }
        try {
            ((RoundImageView) this.pn).setImageResource(Integer.parseInt(this.u.substring(1)));
        } catch (Exception unused2) {
        }
    }

    private void v() {
        if (this.gb > 0.0f) {
            x xVar = this.dj;
            if (xVar != null) {
                xVar.u();
            }
            com.bytedance.adsdk.ugeno.b.u().nr().u(this.f5034a, this.u, new u.InterfaceC0173u() { // from class: com.bytedance.adsdk.ugeno.widget.image.nr.1
                @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
                public void u(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (((fx) nr.this).dj != null) {
                            x xVar2 = ((fx) nr.this).dj;
                            nr nrVar = nr.this;
                            xVar2.nr(nrVar, nrVar.u);
                            return;
                        }
                        return;
                    }
                    if (((fx) nr.this).dj != null) {
                        x xVar3 = ((fx) nr.this).dj;
                        nr nrVar2 = nr.this;
                        xVar3.u(nrVar2, nrVar2.u);
                    }
                    final Bitmap bitmapU = n.u(((fx) nr.this).nr, bitmap, (int) nr.this.gb);
                    if (bitmapU != null) {
                        n.u(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.nr.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RoundImageView) ((fx) nr.this).pn).setImageBitmap(bitmapU);
                            }
                        });
                    }
                    nr nrVar3 = nr.this;
                    if (nrVar3.hs || nrVar3.gl > 0.0f) {
                        Bitmap bitmapU2 = n.u(((fx) nr.this).nr, bitmap, nr.this.gl > 0.0f ? (int) nr.this.gl : 10);
                        if (bitmapU2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(((fx) nr.this).nr.getResources(), bitmapU2);
                            n.u(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.nr.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((RoundImageView) ((fx) nr.this).pn).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        x xVar2 = this.dj;
        if (xVar2 != null) {
            xVar2.u();
        }
        com.bytedance.adsdk.ugeno.u uVarNr = com.bytedance.adsdk.ugeno.b.u().nr();
        s sVar = this.f5034a;
        String str = this.u;
        T t = this.pn;
        uVarNr.u(sVar, str, (ImageView) t, ((RoundImageView) t).getWidth(), ((RoundImageView) this.pn).getHeight(), new u.InterfaceC0173u() { // from class: com.bytedance.adsdk.ugeno.widget.image.nr.2
            @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
            public void u(Bitmap bitmap) {
                if (bitmap == null) {
                    if (((fx) nr.this).dj != null) {
                        x xVar3 = ((fx) nr.this).dj;
                        nr nrVar = nr.this;
                        xVar3.nr(nrVar, nrVar.u);
                        return;
                    }
                    return;
                }
                if (((fx) nr.this).dj != null) {
                    x xVar4 = ((fx) nr.this).dj;
                    nr nrVar2 = nr.this;
                    xVar4.u(nrVar2, nrVar2.u);
                }
            }
        });
        if (this.hs || this.gl > 0.0f) {
            com.bytedance.adsdk.ugeno.b.u().nr().u(this.f5034a, this.u, new u.InterfaceC0173u() { // from class: com.bytedance.adsdk.ugeno.widget.image.nr.3
                @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
                public void u(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapU = n.u(((fx) nr.this).nr, bitmap, nr.this.gl > 0.0f ? (int) nr.this.gl : 10);
                    n.u(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.nr.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapU != null) {
                                ((RoundImageView) ((fx) nr.this).pn).setBackground(new BitmapDrawable(((fx) nr.this).nr.getResources(), bitmapU));
                            }
                        }
                    });
                }
            });
        }
    }

    private ImageView.ScaleType t(String str) {
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
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx, com.bytedance.adsdk.ugeno.fx
    public void iz() {
        super.iz();
        Drawable drawable = ((RoundImageView) this.pn).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !td.a(drawable)) {
            return;
        }
        ud.a(drawable).stop();
    }

    public void l(String str) {
        this.u = str;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public RoundImageView u() {
        RoundImageView roundImageView = new RoundImageView(this.nr);
        roundImageView.u(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        ay();
        ((RoundImageView) this.pn).setScaleType(this.ki);
        ((RoundImageView) this.pn).setBorderColor(this.lf);
        ((RoundImageView) this.pn).setCornerRadius(this.w);
        ((RoundImageView) this.pn).setBorderWidth(this.eh);
        int i = this.ti;
        if (i != -1) {
            ((RoundImageView) this.pn).setColorFilter(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx, com.bytedance.adsdk.ugeno.fx
    public void pn() {
        super.pn();
        ((RoundImageView) this.pn).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.nr.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((RoundImageView) ((fx) nr.this).pn).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !td.a(drawable)) {
                    return;
                }
                ud.a(drawable).start();
            }
        });
    }

    public String x() {
        return this.te;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.ki = t(str2);
                break;
            case "imageBlur":
                this.gb = com.bytedance.adsdk.ugeno.iz.fx.u(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.hs = com.bytedance.adsdk.ugeno.iz.fx.u(str2, false);
                break;
            case "src":
                this.u = str2;
                break;
            case "tintColor":
                this.ti = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case "imageBgBlur":
                this.gl = com.bytedance.adsdk.ugeno.iz.fx.u(str2, -1.0f);
                break;
        }
    }

    public void nr(Drawable drawable) {
        ((RoundImageView) this.pn).setImageDrawable(drawable);
    }
}
