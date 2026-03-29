package com.zenmen.palmchat.widget.byakugallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class GalleryViewPager extends ViewPager {
    public GalleryViewPager(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.ViewPager
    @SuppressLint({"NewApi"})
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        return view instanceof TouchImageView ? ((TouchImageView) view).canScrollHorizontally(i) : super.canScroll(view, z, i, i2, i3);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
