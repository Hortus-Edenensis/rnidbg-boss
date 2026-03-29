package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTRatingBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f5439a;
    private float b;
    private int fx;
    private float iz;
    private Drawable n;
    private int nr;
    private float pn;
    private int u;
    private Drawable x;

    public TTRatingBar(Context context) {
        super(context);
        this.u = 5;
        this.nr = 0;
        this.fx = 0;
        u(context);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.b), Math.round(this.pn)));
        imageView.setPadding(0, 0, Math.round(this.iz), 0);
        return imageView;
    }

    private void u(Context context) {
        setOrientation(0);
        this.x = q.fx(context, "tt_star_empty_bg");
        this.n = q.fx(context, "tt_star_full_bg");
        this.f5439a = q.fx(context, "tt_star_empty_bg");
        this.b = u(context, 15.0f);
        this.pn = u(context, 15.0f);
        this.iz = u(context, 5.0f);
    }

    public Drawable getStarEmptyDrawable() {
        return this.x;
    }

    public int getStarEmptyNum() {
        return this.fx;
    }

    public Drawable getStarFillDrawable() {
        return this.n;
    }

    public int getStarFillNum() {
        return this.u;
    }

    public Drawable getStarHalfDrawable() {
        return this.f5439a;
    }

    public int getStarHalfNum() {
        return this.nr;
    }

    public float getStarImageHeight() {
        return this.pn;
    }

    public float getStarImagePadding() {
        return this.iz;
    }

    public float getStarImageWidth() {
        return this.b;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.x = drawable;
    }

    public void setStarEmptyNum(int i) {
        this.fx = i;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.n = drawable;
    }

    public void setStarFillNum(int i) {
        this.u = i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.f5439a = drawable;
    }

    public void setStarHalfNum(int i) {
        this.nr = i;
    }

    public void setStarImageHeight(float f) {
        this.pn = f;
    }

    public void setStarImagePadding(float f) {
        this.iz = f;
    }

    public void setStarImageWidth(float f) {
        this.b = f;
    }

    private int u(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void u() {
        removeAllViews();
        for (int i = 0; i < getStarFillNum(); i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(getStarFillDrawable());
            addView(starImageView);
        }
        for (int i2 = 0; i2 < getStarHalfNum(); i2++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setImageDrawable(getStarHalfDrawable());
            addView(starImageView2);
        }
        for (int i3 = 0; i3 < getStarEmptyNum(); i3++) {
            ImageView starImageView3 = getStarImageView();
            starImageView3.setImageDrawable(getStarEmptyDrawable());
            addView(starImageView3);
        }
    }
}
