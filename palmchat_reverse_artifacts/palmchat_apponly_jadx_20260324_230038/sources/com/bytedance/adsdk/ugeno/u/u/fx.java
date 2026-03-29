package com.bytedance.adsdk.ugeno.u.u;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.sdk.component.utils.k;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PorterDuffXfermode f5047a;
    private float b;
    private String fx;
    private View iz;
    private LinearGradient jk;
    private Paint n;
    private float pn;
    private Matrix t;
    private Paint x;

    public fx(com.bytedance.adsdk.ugeno.nr.fx fxVar, JSONObject jSONObject) {
        super(fxVar, jSONObject);
        this.iz = this.nr.a();
        Paint paint = new Paint();
        this.x = paint;
        paint.setAntiAlias(true);
        this.iz.setLayerType(2, null);
        this.f5047a = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.n = new Paint();
        this.t = new Matrix();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void fx(Canvas canvas) {
        byte b;
        try {
            if (this.nr.su() <= 0.0f) {
                this.x.setXfermode(this.f5047a);
                canvas.drawRect(0.0f, 0.0f, this.b, this.pn, this.x);
                return;
            }
            int iSu = (int) (this.b * this.nr.su());
            int iSu2 = (int) (this.pn * this.nr.su());
            this.x.setXfermode(this.f5047a);
            String str = this.fx;
            switch (str.hashCode()) {
                case -1383228885:
                    b = !str.equals("bottom") ? (byte) -1 : (byte) 2;
                    break;
                case 115029:
                    if (str.equals(Constant.MAP_KEY_TOP)) {
                        b = 3;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        b = 1;
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        b = 0;
                        break;
                    }
                    break;
                default:
                    break;
            }
            if (b == 0) {
                float f = iSu;
                canvas.drawRect(f, 0.0f, this.b, this.pn, this.x);
                this.t.setTranslate(f, this.pn);
                this.jk.setLocalMatrix(this.t);
                this.n.setShader(this.jk);
                if (this.nr.su() <= 1.0f && this.nr.su() > 0.9f) {
                    this.n.setAlpha((int) (255.0f - (this.nr.su() * 255.0f)));
                }
                canvas.drawRect(0.0f, 0.0f, f, this.pn, this.n);
                return;
            }
            if (b == 1) {
                float f2 = iSu;
                canvas.drawRect(0.0f, 0.0f, this.b - f2, this.pn, this.x);
                this.t.setTranslate(this.b - f2, 0.0f);
                this.jk.setLocalMatrix(this.t);
                this.n.setShader(this.jk);
                if (this.nr.su() <= 1.0f && this.nr.su() > 0.9f) {
                    this.n.setAlpha((int) (255.0f - (this.nr.su() * 255.0f)));
                }
                float f3 = this.b;
                canvas.drawRect(f3, this.pn, f3 - f2, 0.0f, this.n);
                return;
            }
            if (b == 2) {
                float f4 = iSu2;
                canvas.drawRect(0.0f, f4, this.b, this.pn, this.x);
                this.t.setTranslate(0.0f, f4);
                this.jk.setLocalMatrix(this.t);
                this.n.setShader(this.jk);
                if (this.nr.su() <= 1.0f && this.nr.su() > 0.9f) {
                    this.n.setAlpha((int) (255.0f - (this.nr.su() * 255.0f)));
                }
                canvas.drawRect(0.0f, 0.0f, this.b, f4, this.n);
                return;
            }
            if (b != 3) {
                return;
            }
            float f5 = iSu2;
            canvas.drawRect(0.0f, 0.0f, this.b, this.pn - f5, this.x);
            this.t.setTranslate(0.0f, this.pn - f5);
            this.jk.setLocalMatrix(this.t);
            this.n.setShader(this.jk);
            if (this.nr.su() <= 1.0f && this.nr.su() > 0.9f) {
                this.n.setAlpha((int) (255.0f - (this.nr.su() * 255.0f)));
            }
            float f6 = this.b;
            float f7 = this.pn;
            canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.n);
        } catch (Throwable th) {
            k.nr("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void nr() {
        this.fx = this.u.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "left");
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void u(Canvas canvas) {
        fx(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void nr(Canvas canvas) {
        fx(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void u(int i, int i2) {
        this.b = i;
        this.pn = i2;
        String str = this.fx;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.jk = new LinearGradient(0.0f, -this.pn, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.jk = new LinearGradient(0.0f, this.pn, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.jk = new LinearGradient(this.b, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.jk = new LinearGradient(-this.b, 0.0f, 0.0f, this.pn, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public List<PropertyValuesHolder> fx() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.u.pn.ALPHA.nr(), 0.0f, 1.0f));
        return arrayList;
    }
}
