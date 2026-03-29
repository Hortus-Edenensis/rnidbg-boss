package com.zenmen.listui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.listui.duration.BaseDurationFragment;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseRecyclerAdapter;
import defpackage.lm2;
import defpackage.nm2;
import defpackage.om2;
import defpackage.ry5;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class BaseListFragment<T extends BaseRecyclerAdapter, M extends om2, B extends BaseBean, P extends lm2> extends BaseDurationFragment implements nm2<B> {
    public P i;
    public T j;
    public M k;

    public abstract T V();

    public Context W() {
        return getActivity();
    }

    public RecyclerView.LayoutManager Y() {
        return null;
    }

    public abstract int Z();

    public abstract M c0();

    public P e0() {
        return this.i;
    }

    public void h0(List<B> list, int i, int i2) {
        this.j.b(list, i, i2);
    }

    public void j0(int i, B b) {
        this.j.notifyItemInserted(i);
        if (i == 0 || (o() == 1 && i == 1)) {
            mo794e().scrollToPosition(0);
        }
    }

    public abstract P k0();

    public void l0(List<B> list) {
        this.j.d(list);
    }

    public void m0(int i) {
        this.j.notifyItemRemoved(i);
    }

    public void n0(String str) {
        if (getUserVisibleHint()) {
            ry5.a(str);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(Z(), viewGroup, false);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.i.onDestroy();
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.i.onResume();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        P p = (P) k0();
        this.i = p;
        p.f(V());
    }

    public void r0(int i) {
        this.j.notifyItemChanged(i);
    }

    public void p0(PageState pageState) {
    }
}
