package com.bytedance.sdk.openadsdk.core.ugeno.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.iz.b;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.n.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx<RoundImageView> {
    protected int ki;
    protected String u;

    public u(Context context) {
        super(context);
        this.ki = 25;
    }

    private void n() {
        if (TextUtils.isEmpty(this.u)) {
            return;
        }
        ((RoundImageView) this.pn).setImageDrawable(null);
        if (this.u.startsWith("local://")) {
            x.u(new a("UG_decode_img") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.u.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(((fx) u.this).nr.getResources(), b.fx(((fx) u.this).nr, u.this.u.replace("local://", "")));
                    if (bitmapDecodeResource != null) {
                        u.this.u(bitmapDecodeResource);
                    }
                }
            });
        } else {
            nr.u(this.u).type(2).to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.u.2
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my myVar) {
                    Object result = myVar.getResult();
                    if (result == null || !(result instanceof Bitmap)) {
                        return;
                    }
                    u.this.u((Bitmap) result);
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                }
            }, 4);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public RoundImageView u() {
        RoundImageView roundImageView = new RoundImageView(this.nr);
        roundImageView.u(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        n();
        ((RoundImageView) this.pn).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.pn).setBorderColor(this.lf);
        ((RoundImageView) this.pn).setCornerRadius(this.w);
        ((RoundImageView) this.pn).setBorderWidth(this.eh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Bitmap bitmap) {
        final Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(this.nr, bitmap, 25);
        if (bitmapU != null) {
            x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.u.3
                @Override // java.lang.Runnable
                public void run() {
                    if (((fx) u.this).pn != null) {
                        ((RoundImageView) ((fx) u.this).pn).setImageBitmap(bitmapU);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.u(str, str2);
        str.hashCode();
        if (str.equals("blurRate")) {
            try {
                this.ki = Integer.parseInt(str2);
            } catch (Exception unused) {
            }
        } else if (str.equals("src")) {
            this.u = str2;
        }
    }
}
