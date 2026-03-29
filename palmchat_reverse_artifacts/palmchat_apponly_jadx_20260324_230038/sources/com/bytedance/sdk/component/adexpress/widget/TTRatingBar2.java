package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.adexpress.b.n;
import com.bytedance.sdk.component.adexpress.dynamic.b.t;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTRatingBar2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f5114a = (t.nr("", 0.0f, true)[1] / 2) + 1;
    private static final int jk = (t.nr("", 0.0f, true)[1] / 2) + 3;
    private float b;
    private float fx;
    private Drawable iz;
    private float n;
    LinearLayout nr;
    private Drawable pn;
    LinearLayout u;
    private double x;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = new LinearLayout(getContext());
        this.nr = new LinearLayout(getContext());
        this.u.setOrientation(0);
        this.u.setGravity(GravityCompat.START);
        this.nr.setOrientation(0);
        this.nr.setGravity(GravityCompat.START);
        this.pn = q.fx(context, "tt_star_thick");
        this.iz = q.fx(context, "tt_star");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.fx, (int) this.b));
        imageView.setPadding(1, f5114a, 1, jk);
        return imageView;
    }

    public Drawable getStarEmptyDrawable() {
        return this.pn;
    }

    public Drawable getStarFillDrawable() {
        return this.iz;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.u.measure(i, i2);
        double d = this.x;
        float f = this.fx;
        this.nr.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.u.getMeasuredHeight(), 1073741824));
        if (this.n > 0.0f) {
            this.u.setPadding(0, ((int) (r7.getMeasuredHeight() - this.n)) / 2, 0, 0);
            this.nr.setPadding(0, ((int) (this.u.getMeasuredHeight() - this.n)) / 2, 0, 0);
        }
    }

    public void u(double d, int i, int i2, int i3) {
        float f = i2;
        this.fx = (int) n.fx(getContext(), f);
        this.b = (int) n.fx(getContext(), f);
        this.x = d;
        this.n = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.nr.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.u.addView(starImageView2);
        }
        addView(this.u);
        addView(this.nr);
        requestLayout();
    }
}
