package com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.b;
import com.bytedance.adsdk.ugeno.fx.x;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.nr.fx;
import com.bytedance.adsdk.ugeno.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx<BrokenImage> {
    private volatile boolean hs;
    private float ki;
    protected String u;

    public u(Context context) {
        super(context);
        this.hs = false;
    }

    private void n() {
        x xVar = this.dj;
        if (xVar != null) {
            xVar.u();
        }
        b.u().nr().u(this.f5034a, this.u, new u.InterfaceC0173u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage.u.1
            @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
            public void u(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (((fx) u.this).dj != null) {
                        x xVar2 = ((fx) u.this).dj;
                        u uVar = u.this;
                        xVar2.nr(uVar, uVar.u);
                        return;
                    }
                    return;
                }
                final Bitmap[] bitmapArr = new Bitmap[1];
                if (u.this.ki > 0.0f) {
                    bitmapArr[0] = n.u(((fx) u.this).nr, bitmap, (int) u.this.ki);
                }
                n.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage.u.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrokenImage brokenImage = (BrokenImage) ((fx) u.this).pn;
                        Bitmap bitmap2 = bitmapArr[0];
                        if (bitmap2 == null) {
                            bitmap2 = bitmap;
                        }
                        brokenImage.setBitmap(bitmap2);
                    }
                });
                if (((fx) u.this).dj != null) {
                    x xVar3 = ((fx) u.this).dj;
                    u uVar2 = u.this;
                    xVar3.u(uVar2, uVar2.u);
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx, com.bytedance.adsdk.ugeno.fx
    public void iz() {
        super.iz();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        n();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx, com.bytedance.adsdk.ugeno.fx
    public void pn() {
        super.pn();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public BrokenImage u() {
        BrokenImage brokenImage = new BrokenImage(this.nr);
        brokenImage.u(this);
        return brokenImage;
    }

    public void u(final int i, final int i2, final int i3) {
        if (this.hs) {
            return;
        }
        this.hs = true;
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage.u.2
            @Override // java.lang.Runnable
            public void run() {
                ((BrokenImage) ((fx) u.this).pn).u(i, i2);
                ((BrokenImage) ((fx) u.this).pn).u(i3);
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.u(str, str2);
        str.hashCode();
        if (str.equals("imageBlur")) {
            this.ki = com.bytedance.adsdk.ugeno.iz.fx.u(str2, -1.0f);
        } else if (str.equals("src")) {
            this.u = str2;
        }
    }
}
