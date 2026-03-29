package com.zenmen.square.lxpager;

import android.view.View;
import androidx.fragment.app.Fragment;
import defpackage.hg1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PagerFragment extends Fragment {
    public LxFragmentViewHolder d;

    public abstract View D();

    public abstract boolean E();

    public abstract void G(BasePagerBean basePagerBean, int i);

    public void I(LxFragmentViewHolder lxFragmentViewHolder) {
        this.d = lxFragmentViewHolder;
    }

    public abstract void J();

    public abstract void K();

    public abstract void L(hg1 hg1Var);

    public String getSid() {
        return "";
    }

    public void F() {
    }
}
