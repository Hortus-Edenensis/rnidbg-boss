package com.zenmen.listui.list;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.listui.list.BaseBean;
import defpackage.lm2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class BaseViewHolder<B extends BaseBean, DB extends ViewDataBinding, P extends lm2> extends RecyclerView.ViewHolder {
    public DB d;
    public P e;

    public BaseViewHolder(View view) {
        super(view);
        m();
    }

    public abstract void l(B b, int i);

    public abstract void m();

    public void n(P p) {
        this.e = p;
    }
}
