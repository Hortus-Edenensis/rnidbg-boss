package me.everything.android.ui.overscroll.adapters;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import defpackage.vn2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ViewPagerOverScrollDecorAdapter implements vn2, ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager f19197a;
    public int b;
    public float c;

    @Override // defpackage.vn2
    public boolean a() {
        return this.b == this.f19197a.getAdapter().getCount() - 1 && this.c == 0.0f;
    }

    @Override // defpackage.vn2
    public boolean b() {
        return this.b == 0 && this.c == 0.0f;
    }

    @Override // defpackage.vn2
    public View getView() {
        return this.f19197a;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.b = i;
        this.c = f;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }
}
