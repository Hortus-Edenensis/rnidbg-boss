package com.bytedance.adsdk.ugeno.u.u;

import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.iz.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends u {
    private static final float k;
    private static final float my;
    private static final float o;
    private static final float s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f5046a;
    private Paint b;
    private int fx;
    private u.C0170u iz;
    private int jk;
    private boolean l;
    private Path mv;
    private int n;
    private Path pn;
    private float sx;
    private int t;
    private int x;

    static {
        float radians = (float) Math.toRadians(30.0d);
        s = radians;
        k = (float) Math.tan(radians);
        my = (float) Math.cos(radians);
        o = (float) Math.sin(radians);
    }

    public b(com.bytedance.adsdk.ugeno.nr.fx fxVar, JSONObject jSONObject) {
        super(fxVar, jSONObject);
        this.l = true;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.pn = new Path();
        this.f5046a = this.nr.dw();
        this.mv = new Path();
    }

    private void fx(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.nr.tk() > 0.0f) {
                int i = this.jk;
                float f = k;
                float fTk = (i + (i * f)) * this.nr.tk();
                this.mv.reset();
                this.mv.moveTo(fTk, 0.0f);
                int i2 = this.t;
                float f2 = fTk - (i2 * f);
                this.mv.lineTo(f2, i2);
                this.mv.lineTo(f2 + this.fx, this.t);
                this.mv.lineTo(this.fx + fTk, 0.0f);
                this.mv.close();
                float f3 = this.sx;
                float f4 = my * f3;
                float f5 = f3 * o;
                if (!this.l || this.iz == null) {
                    float f6 = fTk + f4;
                    int i3 = this.n;
                    linearGradient = new LinearGradient(fTk, 0.0f, f6, f5, new int[]{i3, this.x, i3}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(fTk, 0.0f, fTk + f4, f5, this.iz.nr, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.b.setShader(linearGradient);
                Path path = this.pn;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.mv, this.b);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void nr() {
        this.fx = (int) n.u(this.nr.a().getContext(), this.u.optInt("shineWidth", 30));
        String strOptString = this.u.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.iz = com.bytedance.adsdk.ugeno.iz.u.nr(str);
        } else {
            int iU = com.bytedance.adsdk.ugeno.iz.u.u(str);
            this.x = iU;
            this.n = com.bytedance.adsdk.ugeno.iz.u.u(iU, 32);
            this.l = false;
        }
        this.sx = my * this.fx;
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    @SuppressLint({"DrawAllocation"})
    public void u(Canvas canvas) {
        fx(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void u(int i, int i2) {
        this.jk = i;
        this.t = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.pn;
            float f = this.f5046a;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public void nr(Canvas canvas) {
        fx(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.u.u.u
    public List<PropertyValuesHolder> fx() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(b(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
