package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.fx;
import com.bytedance.adsdk.ugeno.iz.b;
import com.bytedance.adsdk.ugeno.iz.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class UGRatingBar extends FrameLayout {
    private float b;
    private double fx;
    private LinearLayout iz;
    private fx n;
    private float nr;
    private LinearLayout pn;
    private float u;
    private Context x;

    public UGRatingBar(Context context) {
        super(context);
        this.x = context;
        this.pn = new LinearLayout(context);
        this.iz = new LinearLayout(context);
        this.pn.setOrientation(0);
        this.pn.setGravity(GravityCompat.START);
        this.iz.setOrientation(0);
        this.iz.setGravity(GravityCompat.START);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.u, (int) this.nr);
        float f = this.b;
        layoutParams.leftMargin = (int) f;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) f;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.iz();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.u(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.u(i, i2);
        }
        super.onMeasure(i, i2);
        this.pn.measure(i, i2);
        double dFloor = Math.floor(this.fx);
        float f = this.b;
        float f2 = this.u;
        this.iz.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f + f + f2)) * dFloor) + ((double) f) + ((this.fx - dFloor) * ((double) f2))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.pn.getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.nr(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.u(z);
        }
    }

    public void u(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.pn.removeAllViews();
        this.iz.removeAllViews();
        this.u = (int) n.u(this.x, f);
        this.nr = (int) n.u(this.x, f);
        this.fx = d;
        this.b = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(b.nr(this.x, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.iz.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(b.nr(this.x, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.pn.addView(starImageView2);
        }
        addView(this.pn);
        addView(this.iz);
        requestLayout();
    }

    public void u(fx fxVar) {
        this.n = fxVar;
    }
}
