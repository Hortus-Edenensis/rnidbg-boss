package com.bytedance.adsdk.ugeno.u.u;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends u {
    private int b;
    private int fx;
    private Paint iz;
    private int pn;

    public nr(com.bytedance.adsdk.ugeno.nr.fx fxVar, JSONObject jSONObject) {
        super(fxVar, jSONObject);
        Paint paint = new Paint();
        this.iz = paint;
        paint.setAntiAlias(true);
    }

    private void fx(Canvas canvas) {
        try {
            if (this.nr.cj() > 0.0f) {
                this.iz.setColor(this.fx);
                this.iz.setAlpha((int) ((1.0f - this.nr.cj()) * 255.0f));
                ((ViewGroup) this.nr.a().getParent()).setClipChildren(true);
                canvas.drawCircle(this.b, this.pn, Math.min(r0, r2) * 2 * this.nr.cj(), this.iz);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void nr() {
        this.fx = com.bytedance.adsdk.ugeno.iz.u.u(this.u.optString("backgroundColor"), -1);
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
        this.b = i / 2;
        this.pn = i2 / 2;
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public List<PropertyValuesHolder> fx() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(b(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
