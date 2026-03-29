package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int b;
    private int iz;
    private int pn;
    Paint u;
    Path nr = new Path();
    Path fx = new Path();

    public u() {
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
    }

    public void u(Canvas canvas, nr nrVar, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        float[] fArrNr;
        if (nrVar.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.u.u.u.u().fx() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArrNr = x.nr(str);
                    } catch (Exception unused) {
                        fArrNr = null;
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (str.startsWith("#")) {
                    this.u.setColor(Color.parseColor(str));
                    this.u.setAlpha(90);
                } else if (fArrNr != null) {
                    this.u.setColor(n.u(fArrNr[3] * (1.0f - nrVar.getRippleValue()), fArrNr[0] / 256.0f, fArrNr[1] / 256.0f, fArrNr[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            canvas.drawCircle(this.b, this.pn, Math.min(r1, r4) * 2 * nrVar.getRippleValue(), this.u);
        }
        if (nrVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.nr.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.b * 4) + (iIntValue2 * 2)) + (this.pn * 2)) * nrVar.getShineValue())) - ((this.pn * 2) + iIntValue2);
                float f = shineValue;
                int i = this.pn;
                this.u.setShader(new LinearGradient(f, 0.0f, ((iIntValue2 + i) / 2) + shineValue, i / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.u.setStrokeWidth(this.b * 2);
                Path path = this.fx;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i2 = shineValue + iIntValue2;
                canvas.drawLine(f, 0.0f, i2 + r1, this.pn, this.u);
            }
        }
        if (nrVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.nr.reset();
                this.nr.moveTo(0.0f, 0.0f);
                this.nr.lineTo(this.b * 2, 0.0f);
                this.nr.lineTo(this.b * 2, this.pn * 2);
                this.nr.lineTo(0.0f, this.pn * 2);
                this.nr.lineTo(0.0f, 0.0f);
                this.u.setShader(new LinearGradient(0.0f, 0.0f, this.b * 2, this.pn * 2, new int[]{(int) (nrVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - nrVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.u.setColor(SupportMenu.CATEGORY_MASK);
                this.u.setStyle(Paint.Style.STROKE);
                this.u.setStrokeWidth(iIntValue);
                canvas.drawPath(this.nr, this.u);
            }
        }
    }

    public void u(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.iz * f);
        view.setTranslationX((r1 - r6) / 2);
        if (view instanceof DynamicImageView) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.iz - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void u(View view, int i, int i2) {
        String str;
        this.b = i / 2;
        this.pn = i2 / 2;
        if (this.iz == 0 && view.getLayoutParams().width > 0) {
            this.iz = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.fx.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.b * 2);
            view.setPivotY(this.pn);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.pn);
        } else {
            view.setPivotX(this.b);
            view.setPivotY(this.pn);
        }
    }
}
