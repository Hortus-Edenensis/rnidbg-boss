package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTRatingBar2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5440a;
    private int b;
    private int fx;
    private int iz;
    private Drawable jk;
    private int n;
    LinearLayout nr;
    private double pn;
    private Drawable t;
    LinearLayout u;
    private int x;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = new LinearLayout(getContext());
        this.nr = new LinearLayout(getContext());
        this.u.setOrientation(0);
        this.u.setGravity(GravityCompat.START);
        this.nr.setOrientation(0);
        this.nr.setGravity(GravityCompat.START);
        this.jk = q.fx(context, "tt_ratingbar_empty_star2");
        this.t = q.fx(context, "tt_ratingbar_full_star2");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fx, this.b);
        layoutParams.leftMargin = this.iz;
        layoutParams.topMargin = this.x;
        layoutParams.rightMargin = this.n;
        layoutParams.bottomMargin = this.f5440a;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public Drawable getEmptyStarDrawable() {
        return this.jk;
    }

    public Drawable getFillStarDrawable() {
        return this.t;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.u.measure(i, i2);
        double dFloor = Math.floor(this.pn);
        int i3 = this.iz;
        int i4 = this.n + i3;
        int i5 = this.fx;
        this.nr.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (i4 + i5)) * dFloor) + ((double) i3) + ((this.pn - dFloor) * ((double) i5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.u.getMeasuredHeight(), 1073741824));
    }

    public void setRating(double d) {
        this.pn = d;
    }

    public void u(int i, int i2) {
        this.fx = i2;
        this.b = i;
    }

    public void u() {
        removeAllViews();
        for (int i = 0; i < 5; i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getFillStarDrawable());
            this.nr.addView(starImageView);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getEmptyStarDrawable());
            this.u.addView(starImageView2);
        }
        addView(this.u);
        addView(this.nr);
        requestLayout();
    }

    public void u(int i, int i2, int i3, int i4) {
        this.iz = i;
        this.x = i2;
        this.n = i3;
        this.f5440a = i4;
    }
}
