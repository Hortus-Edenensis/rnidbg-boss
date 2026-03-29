package com.zenmen.palmchat.circle.ui.adapter;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.lp2;
import defpackage.nk2;
import defpackage.ps0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class BaseFragPageAdapterVp<T, V extends lp2> extends ps0 implements nk2<T, V> {
    public List<T> h;

    public BaseFragPageAdapterVp(@NonNull FragmentManager fragmentManager, int i) {
        super(fragmentManager, i);
        this.h = new ArrayList();
    }

    @Override // defpackage.ps0, androidx.viewpager.widget.PagerAdapter
    @SuppressLint({"LongLogTag"})
    public /* bridge */ /* synthetic */ void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public <W extends nk2<T, V>> W f(List<T> list) {
        g(list);
        notifyDataSetChanged();
        return this;
    }

    @Override // defpackage.ps0, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ void finishUpdate(@NonNull ViewGroup viewGroup) {
        super.finishUpdate(viewGroup);
    }

    public <W extends nk2<T, V>> W g(List<T> list) {
        this.h.addAll(list);
        return this;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.h.size();
    }

    @Override // defpackage.ps0
    @NonNull
    public Fragment getItem(int i) {
        return h(this.h.get(i), i);
    }

    public abstract Fragment h(T t, int i);

    @Override // defpackage.ps0, androidx.viewpager.widget.PagerAdapter
    @NonNull
    @SuppressLint({"LongLogTag"})
    public /* bridge */ /* synthetic */ Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    @Override // defpackage.ps0, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return super.isViewFromObject(view, obj);
    }

    @Override // defpackage.ps0, androidx.viewpager.widget.PagerAdapter
    @SuppressLint({"LongLogTag"})
    public /* bridge */ /* synthetic */ void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        super.restoreState(parcelable, classLoader);
    }

    @Override // defpackage.ps0, androidx.viewpager.widget.PagerAdapter
    @Nullable
    public /* bridge */ /* synthetic */ Parcelable saveState() {
        return super.saveState();
    }

    @Override // defpackage.ps0, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }

    @Override // defpackage.ps0, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ void startUpdate(@NonNull ViewGroup viewGroup) {
        super.startUpdate(viewGroup);
    }

    @Override // defpackage.nk2
    public void a(V v, int i, T t) {
    }

    @Override // defpackage.nk2
    public void c(V v, int i, boolean z, float f, V v2, int i2, boolean z2, float f2) {
    }
}
