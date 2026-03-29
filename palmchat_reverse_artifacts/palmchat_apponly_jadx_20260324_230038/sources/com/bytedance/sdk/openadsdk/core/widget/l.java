package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5401a;
    private float[] b;
    private int[] fx;
    private int iz;
    private RectF jk;
    private int n;
    private int nr;
    private LinearGradient pn;
    private Paint t;
    private int u;
    private int x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5402a;
        private float[] b;
        private int[] fx;
        private int n;
        private LinearGradient pn;
        private int u = q.a(dw.getContext(), "tt_ssxinmian8");
        private int nr = q.a(dw.getContext(), "tt_ssxinxian3");
        private int iz = 10;
        private int x = 16;

        public u() {
            this.n = 0;
            this.f5402a = 0;
            this.n = 0;
            this.f5402a = 0;
        }

        public u b(int i) {
            this.n = i;
            return this;
        }

        public u fx(int i) {
            this.iz = i;
            return this;
        }

        public u nr(int i) {
            this.nr = i;
            return this;
        }

        public u pn(int i) {
            this.f5402a = i;
            return this;
        }

        public u u(int i) {
            this.u = i;
            return this;
        }

        public u u(int[] iArr) {
            this.fx = iArr;
            return this;
        }

        public l u() {
            return new l(this.u, this.fx, this.b, this.nr, this.pn, this.iz, this.x, this.n, this.f5402a);
        }
    }

    public l(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.u = i;
        this.fx = iArr;
        this.b = fArr;
        this.nr = i2;
        this.pn = linearGradient;
        this.iz = i3;
        this.x = i4;
        this.n = i5;
        this.f5401a = i6;
    }

    private void u() {
        int[] iArr;
        Paint paint = new Paint();
        this.t = paint;
        paint.setAntiAlias(true);
        this.t.setShadowLayer(this.x, this.n, this.f5401a, this.nr);
        if (this.jk == null || (iArr = this.fx) == null || iArr.length <= 1) {
            this.t.setColor(this.u);
            return;
        }
        float[] fArr = this.b;
        boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
        Paint paint2 = this.t;
        LinearGradient linearGradient = this.pn;
        if (linearGradient == null) {
            RectF rectF = this.jk;
            linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.fx, z ? this.b : null, Shader.TileMode.CLAMP);
        }
        paint2.setShader(linearGradient);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.jk == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.x;
            int i3 = this.n;
            int i4 = bounds.top + i2;
            int i5 = this.f5401a;
            this.jk = new RectF((i + i2) - i3, i4 - i5, (bounds.right - i2) - i3, (bounds.bottom - i2) - i5);
        }
        if (this.t == null) {
            u();
        }
        RectF rectF = this.jk;
        int i6 = this.iz;
        canvas.drawRoundRect(rectF, i6, i6, this.t);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.t;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.t;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void u(View view, u uVar) {
        if (view == null || uVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(uVar.u());
    }
}
