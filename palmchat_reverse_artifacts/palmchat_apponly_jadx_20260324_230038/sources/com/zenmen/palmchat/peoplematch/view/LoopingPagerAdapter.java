package com.zenmen.palmchat.peoplematch.view;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class LoopingPagerAdapter<T> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f14916a;
    public List<T> b;
    public SparseArray<View> c = new SparseArray<>();
    public boolean d = false;
    public LoopingViewPager e;

    public LoopingPagerAdapter(Context context) {
        this.f14916a = context;
        j(new ArrayList());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int dataPosition = this.e.toDataPosition(i);
        View view = (View) obj;
        viewGroup.removeView(view);
        if (this.d) {
            return;
        }
        this.c.put(h(dataPosition), view);
    }

    public abstract void f(View view, int i, int i2);

    public T g(int i) {
        if (i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<T> list = this.b;
        int size = list != null ? list.size() : 0;
        if (size == 0) {
            return 0;
        }
        return size + 2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public int h(int i) {
        return 0;
    }

    public abstract View i(int i, ViewGroup viewGroup, int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View viewI;
        int dataPosition = this.e.toDataPosition(i);
        int iH = h(dataPosition);
        if (this.c.get(iH, null) == null) {
            viewI = i(iH, viewGroup, dataPosition);
        } else {
            viewI = this.c.get(iH);
            this.c.remove(iH);
        }
        f(viewI, dataPosition, iH);
        viewGroup.addView(viewI);
        return viewI;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void j(List<T> list) {
        this.c = new SparseArray<>();
        this.b = list;
        notifyDataSetChanged();
    }

    public void k(LoopingViewPager loopingViewPager) {
        this.e = loopingViewPager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.d = true;
        super.notifyDataSetChanged();
        this.d = false;
    }
}
