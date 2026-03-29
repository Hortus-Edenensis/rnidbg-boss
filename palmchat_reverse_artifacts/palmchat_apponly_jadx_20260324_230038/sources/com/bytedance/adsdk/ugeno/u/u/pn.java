package com.bytedance.adsdk.ugeno.u.u;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5048a;
    private float b;
    private float fx;
    private float iz;
    private Path jk;
    private Path l;
    private PorterDuffXfermode mv;
    private boolean n;
    private Paint pn;
    private Path t;
    private String x;

    public pn(com.bytedance.adsdk.ugeno.nr.fx fxVar, JSONObject jSONObject) {
        super(fxVar, jSONObject);
        this.n = true;
        this.f5048a = true;
        Paint paint = new Paint();
        this.pn = paint;
        paint.setAntiAlias(true);
        this.nr.a().setLayerType(2, null);
        this.mv = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.jk = new Path();
        this.t = new Path();
        this.l = new Path();
        this.pn.setXfermode(this.mv);
    }

    private void fx(Canvas canvas) {
        int iWi;
        int iWi2;
        if (this.nr.wi() <= 0.0f) {
            this.pn.setXfermode(this.mv);
            canvas.drawRect(0.0f, 0.0f, this.fx, this.b, this.pn);
            return;
        }
        iWi = (int) (this.fx * this.nr.wi());
        iWi2 = (int) (this.b * this.nr.wi());
        this.pn.setXfermode(this.mv);
        String str = this.x;
        str.hashCode();
        switch (str) {
            case "bottom":
                canvas.drawRect(0.0f, iWi2, this.fx, this.b, this.pn);
                break;
            case "center":
                this.jk.reset();
                this.t.reset();
                this.l.reset();
                this.jk.addCircle(this.fx / 2.0f, this.b / 2.0f, iWi, Path.Direction.CW);
                Path path = this.t;
                float f = this.fx;
                path.addRect(f / 2.0f, 0.0f, f, this.b, Path.Direction.CW);
                this.t.op(this.jk, Path.Op.DIFFERENCE);
                this.l.addRect(0.0f, 0.0f, this.fx / 2.0f, this.b, Path.Direction.CW);
                this.l.op(this.jk, Path.Op.DIFFERENCE);
                canvas.drawPath(this.t, this.pn);
                canvas.drawPath(this.l, this.pn);
                break;
            case "top":
                canvas.drawRect(0.0f, 0.0f, this.fx, this.b - iWi2, this.pn);
                break;
            case "left":
                canvas.drawRect(0.0f, 0.0f, this.fx - iWi, this.b, this.pn);
                break;
            case "right":
                canvas.drawRect(iWi, 0.0f, this.fx, this.b, this.pn);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void nr() {
        this.iz = (float) this.u.optDouble("start", 0.0d);
        this.x = this.u.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "center");
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void u(Canvas canvas) {
        fx(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void u(int i, int i2) {
        if (i > 0 && this.n) {
            this.fx = i;
            this.n = false;
        }
        if (i2 <= 0 || !this.f5048a) {
            return;
        }
        this.b = i2;
        this.f5048a = false;
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void nr(Canvas canvas) {
        fx(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public List<PropertyValuesHolder> fx() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(b(), this.iz, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
