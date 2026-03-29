package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumItem;
import defpackage.xo2;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ItemAdapter extends BaseRecyclerViewAdapter<SuperExposeNumItem> {
    public xo2 j;
    public int k;

    public ItemAdapter(@NonNull Context context, xo2 xo2Var, int i) {
        super(context, new ArrayList());
        this.j = xo2Var;
        this.k = i;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        if (i == 0) {
            return new ItemViewHolder(viewGroup.getContext(), viewGroup, this);
        }
        if (i == 1) {
            return new FooterViewHolder(viewGroup.getContext(), viewGroup, this, this.j, this.k);
        }
        return null;
    }

    public int r() {
        xo2 xo2Var = this.j;
        if (xo2Var != null) {
            return xo2Var.a();
        }
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull SuperExposeNumItem superExposeNumItem) {
        return superExposeNumItem.isFooter ? 1 : 0;
    }
}
