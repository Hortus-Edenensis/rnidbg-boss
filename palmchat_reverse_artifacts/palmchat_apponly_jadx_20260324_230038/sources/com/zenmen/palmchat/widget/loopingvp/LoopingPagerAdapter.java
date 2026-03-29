package com.zenmen.palmchat.widget.loopingvp;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LoopingPagerAdapter<T> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16033a;
    public List<T> b;
    public SparseArray<View> c = new SparseArray<>();
    public boolean d = false;
    public LoopingViewPager e;

    public LoopingPagerAdapter(Context context) {
        this.f16033a = context;
        i(new ArrayList());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int dataPosition = this.e.toDataPosition(i);
        View view = (View) obj;
        viewGroup.removeView(view);
        if (this.d) {
            return;
        }
        this.c.put(g(dataPosition), view);
    }

    public abstract void f(View view, int i, int i2);

    public int g(int i) {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<T> list = this.b;
        int size = list != null ? list.size() : 0;
        return size <= 1 ? size : size + 2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public abstract View h(int i, ViewGroup viewGroup, int i2);

    public void i(List<T> list) {
        this.c = new SparseArray<>();
        this.b = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View viewH;
        int dataPosition = this.e.toDataPosition(i);
        int iG = g(dataPosition);
        if (this.c.get(iG, null) == null) {
            viewH = h(iG, viewGroup, dataPosition);
        } else {
            viewH = this.c.get(iG);
            this.c.remove(iG);
        }
        f(viewH, dataPosition, iG);
        viewGroup.addView(viewH);
        return viewH;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(LoopingViewPager loopingViewPager) {
        this.e = loopingViewPager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.d = true;
        super.notifyDataSetChanged();
        this.d = false;
    }
}
