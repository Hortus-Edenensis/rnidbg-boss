package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.bq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout.LayoutParams f4986a;
    private a.nr bg;
    private final List<String> jk;
    private SpannableStringBuilder k;
    private String l;
    private u mv;
    private int my;
    private LinearLayout n;
    private int o;
    private SpannableStringBuilder s;
    private Camera sx;
    private final List<TextView> t;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements LineBackgroundSpan {
        private int b;
        private float fx;
        private int nr;
        private float pn;
        private final Paint u = new Paint();

        @Override // android.text.style.LineBackgroundSpan
        public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
            if (this.fx > 0.0f) {
                this.u.setColor(this.nr);
                this.u.setStrokeWidth(this.fx);
                float f = i4 + this.fx;
                canvas.drawLine(i, f, i2, f, this.u);
            }
            if (this.pn > 0.0f) {
                this.u.setColor(this.b);
                this.u.setStrokeWidth(this.pn);
                float f2 = (i5 + i3) / 2.0f;
                canvas.drawLine(i, f2, i2, f2, this.u);
            }
        }
    }

    public iz(com.bytedance.adsdk.lottie.n nVar, n nVar2, Context context) {
        List<a.fx> listFx;
        super(nVar, nVar2);
        this.f4986a = new LinearLayout.LayoutParams(-2, -2);
        this.jk = new ArrayList();
        this.t = new ArrayList();
        com.bytedance.adsdk.lottie.a aVar = ((x) this).x;
        if (aVar == null || (listFx = aVar.fx()) == null || listFx.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.n = linearLayout;
        linearLayout.setOrientation(0);
        nr(listFx.get(0).jk);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.n.addView(linearLayout2);
        List<String> listS = s();
        int i = 0;
        while (i < listFx.size()) {
            a.fx fxVar = listFx.get(i);
            TextView textView = new TextView(context);
            u(textView, fxVar, (listS == null || i >= listS.size()) ? "" : listS.get(i), i, listFx.size() - 1, listFx.get(0));
            int i2 = fxVar.f4980a;
            if (i2 != 0) {
                this.f4986a.bottomMargin = (int) (i2 * com.bytedance.adsdk.lottie.pn.a.u());
                linearLayout2.addView(textView, this.f4986a);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float fU = com.bytedance.adsdk.lottie.pn.a.u();
        this.my = (int) (((x) this).x.u() * fU);
        int iNr = (int) (((x) this).x.nr() * fU);
        this.o = iNr;
        u(this.n, this.my, iNr);
        a.nr nrVarT = ((x) this).x.t();
        this.bg = nrVarT;
        if (nrVarT != null) {
            this.sx = new Camera();
        }
    }

    private void fx(float f) {
        List<a.fx> listFx;
        com.bytedance.adsdk.lottie.a aVar = ((x) this).x;
        if (aVar == null || (listFx = aVar.fx()) == null || listFx.size() <= 0) {
            return;
        }
        this.n.setOrientation(0);
        nr(listFx.get(0).jk);
        if (this.n.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.n.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.n.removeAllViews();
        if (linearLayout.getChildCount() != listFx.size()) {
            return;
        }
        List<String> listS = s();
        this.t.clear();
        int i = 0;
        while (i < listFx.size()) {
            a.fx fxVar = listFx.get(i);
            TextView textView = (TextView) linearLayout.getChildAt(i);
            this.t.add(textView);
            u(textView, fxVar, (listS == null || i >= listS.size()) ? "" : listS.get(i), i, listFx.size() - 1, listFx.get(0));
            i++;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < listFx.size(); i2++) {
            a.fx fxVar2 = listFx.get(i2);
            TextView textView2 = this.t.get(i2);
            textView2.setAlpha(f);
            linearLayout.setAlpha(f);
            int i3 = fxVar2.f4980a;
            if (i3 != 0) {
                this.f4986a.bottomMargin = (int) (i3 * com.bytedance.adsdk.lottie.pn.a.u());
                linearLayout.addView(textView2, this.f4986a);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.n.setAlpha(f);
        this.n.addView(linearLayout);
        u(this.n, this.my, this.o);
    }

    private void nr(String str) {
        if (TextUtils.isEmpty(str)) {
            this.n.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals("left")) {
            this.n.setGravity(19);
        } else if (str.equals("right")) {
            this.n.setGravity(21);
        } else {
            this.n.setGravity(17);
        }
    }

    private List<String> s() {
        com.bytedance.adsdk.lottie.n nVar;
        bq bqVarKj;
        List<a.fx> listFx;
        if (((x) this).x == null || (nVar = this.nr) == null || (bqVarKj = nVar.kj()) == null) {
            return null;
        }
        String strB = ((x) this).x.b();
        if ((!TextUtils.isEmpty(strB) || !TextUtils.isEmpty(this.l)) && (listFx = ((x) this).x.fx()) != null) {
            String strU = this.l;
            if (TextUtils.isEmpty(strU)) {
                strU = bqVarKj.u(strB);
            }
            if (!TextUtils.isEmpty(strU)) {
                int length = strU.length();
                this.jk.clear();
                for (int i = 0; i < listFx.size(); i++) {
                    a.fx fxVar = listFx.get(i);
                    int iMax = fxVar.u;
                    int iMax2 = fxVar.nr;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.jk.add("");
                    } else {
                        if (listFx.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.jk.add(strU.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.jk;
            }
        }
        return null;
    }

    private void u(TextView textView, a.fx fxVar, String str, int i, int i2, a.fx fxVar2) {
        com.bytedance.adsdk.lottie.n nVar;
        bq bqVarKj;
        if (TextUtils.isEmpty(str)) {
            str = "";
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(fxVar.fx)) {
            textView.setTextColor(Color.parseColor(fxVar.fx));
        } else if (!TextUtils.isEmpty(fxVar.b)) {
            textView.setTextColor(Color.parseColor(fxVar.b));
        }
        if (!TextUtils.isEmpty(fxVar.pn)) {
            textView.setBackgroundColor(Color.parseColor(fxVar.pn));
        }
        if (fxVar.n == 1) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(1, fxVar.iz);
        if (!TextUtils.isEmpty(fxVar.x) && (nVar = this.nr) != null && (bqVarKj = nVar.kj()) != null) {
            try {
                int i3 = Integer.parseInt(bqVarKj.u(fxVar.x));
                if (i3 > 0) {
                    textView.setTextSize(1, i3);
                }
            } catch (Throwable unused) {
            }
        }
        a.fx.u uVar = fxVar.t;
        if (uVar != null && uVar.u > 0 && !TextUtils.isEmpty(uVar.nr)) {
            if (this.s == null) {
                this.s = new SpannableStringBuilder(str);
            }
            if (this.mv == null) {
                this.mv = new u();
            }
            this.mv.nr = Color.parseColor(fxVar.t.nr);
            this.mv.fx = fxVar.t.u * com.bytedance.adsdk.lottie.pn.a.u();
            this.s.clear();
            this.s.clearSpans();
            this.s.append((CharSequence) str);
            this.s.setSpan(this.mv, 0, str.length(), 33);
            textView.setText(this.s);
        }
        a.fx.u uVar2 = fxVar.l;
        if (uVar2 != null && uVar2.u > 0 && !TextUtils.isEmpty(uVar2.nr)) {
            if (this.k == null) {
                this.k = new SpannableStringBuilder(str);
            }
            if (this.mv == null) {
                this.mv = new u();
            }
            this.mv.b = Color.parseColor(fxVar.l.nr);
            this.mv.pn = fxVar.l.u * com.bytedance.adsdk.lottie.pn.a.u();
            this.k.clear();
            this.k.clearSpans();
            this.k.append((CharSequence) str);
            this.k.setSpan(this.mv, 0, str.length(), 33);
            textView.setText(this.k);
        }
        int i4 = fxVar2.s;
        if (i4 > 0) {
            textView.setMaxLines(i4);
            if (fxVar2.mv == 2 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
            if (fxVar2.mv == 1 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.START);
            }
            if (fxVar2.mv == 0 && i == i2) {
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.x, com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        View childAt;
        if (this.n != null) {
            canvas.save();
            canvas.concat(matrix);
            u(i);
            fx(n());
            if (this.sx != null) {
                a.nr nrVar = this.bg;
                if (nrVar.u != 0 || nrVar.nr != 0 || nrVar.fx != 0) {
                    int width = this.my >> 1;
                    int height = this.o >> 1;
                    if (this.n.getChildCount() > 0 && (childAt = this.n.getChildAt(0)) != null) {
                        int left = childAt.getLeft() - this.n.getLeft();
                        int top = childAt.getTop() - this.n.getTop();
                        width = left + (childAt.getWidth() >> 1);
                        height = top + (childAt.getHeight() >> 1);
                    }
                    canvas.translate(width, height);
                    a.nr nrVar2 = this.bg;
                    if (nrVar2.u != 0 || nrVar2.nr != 0) {
                        this.sx.save();
                        int i2 = this.bg.u;
                        if (i2 != 0) {
                            this.sx.rotateX(i2);
                        }
                        int i3 = this.bg.nr;
                        if (i3 != 0) {
                            this.sx.rotateY(i3);
                        }
                        this.sx.applyToCanvas(canvas);
                        this.sx.restore();
                    }
                    int i4 = this.bg.fx;
                    if (i4 != 0) {
                        canvas.rotate(i4);
                    }
                    canvas.translate(-width, -height);
                }
            }
            this.n.draw(canvas);
            canvas.restore();
            return;
        }
        super.nr(canvas, matrix, i);
    }

    private static void u(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void u(String str) {
        this.l = str;
    }
}
