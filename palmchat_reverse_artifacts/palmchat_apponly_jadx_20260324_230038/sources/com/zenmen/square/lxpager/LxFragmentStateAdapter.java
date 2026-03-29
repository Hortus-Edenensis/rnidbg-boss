package com.zenmen.square.lxpager;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.zenmen.square.lxpager.BasePagerBean;
import com.zenmen.square.lxpager.PagerFragment;
import defpackage.ma3;
import defpackage.o22;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LxFragmentStateAdapter<T extends PagerFragment, D extends BasePagerBean> extends FragmentStateAdapter {
    public List<D> m;
    public o22 n;
    public int o;

    public LxFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.m = Collections.EMPTY_LIST;
        this.o = 2;
    }

    @Override // com.zenmen.square.lxpager.FragmentStateAdapter
    @NonNull
    public T a(int i) {
        ma3.a("createFragment " + i, new Object[0]);
        T t = (T) m(i);
        t.setArguments(c());
        t.G(this.m.get(i), i);
        return t;
    }

    @Override // com.zenmen.square.lxpager.FragmentStateAdapter
    public boolean containsItem(long j) {
        return true;
    }

    @Override // com.zenmen.square.lxpager.FragmentStateAdapter
    /* JADX INFO: renamed from: d */
    public void onBindViewHolder(@NonNull LxFragmentViewHolder lxFragmentViewHolder, int i) {
        o22 o22Var;
        super.onBindViewHolder(lxFragmentViewHolder, i);
        if ((this.m.size() - i) - 1 > this.o || (o22Var = this.n) == null) {
            return;
        }
        o22Var.n();
    }

    @Override // com.zenmen.square.lxpager.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: e */
    public LxFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LxFragmentViewHolder lxFragmentViewHolderL = LxFragmentViewHolder.l(viewGroup);
        lxFragmentViewHolderL.p(this.n);
        return lxFragmentViewHolderL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<D> list = this.m;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void l(List<D> list, int i, int i2) {
        ma3.a("insertData listSize " + list.size() + " fromPos " + i + " changeCount " + i2, new Object[0]);
        this.m = list;
        notifyDataSetChanged();
    }

    public abstract T m(int i);

    public void n(List<D> list) {
        this.m = list;
        notifyDataSetChanged();
    }

    public void o(o22 o22Var) {
        this.n = o22Var;
    }
}
