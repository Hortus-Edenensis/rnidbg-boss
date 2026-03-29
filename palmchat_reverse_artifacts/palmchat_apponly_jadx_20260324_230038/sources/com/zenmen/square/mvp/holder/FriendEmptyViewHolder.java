package com.zenmen.square.mvp.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.listui.list.a;
import com.zenmen.square.R$layout;
import com.zenmen.square.databinding.LayoutSquareEmptyFriendBinding;
import com.zenmen.square.mvp.model.bean.SquareFeed;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FriendEmptyViewHolder extends BaseViewHolder<SquareFeed, LayoutSquareEmptyFriendBinding, a> {
    public FriendEmptyViewHolder(View view) {
        super(view);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [DB extends androidx.databinding.ViewDataBinding, androidx.databinding.ViewDataBinding] */
    @Override // com.zenmen.listui.list.BaseViewHolder
    public void m() {
        ?? Inflate = DataBindingUtil.inflate(LayoutInflater.from(this.itemView.getContext()), R$layout.layout_square_empty_friend, (ViewGroup) this.itemView, false);
        this.d = Inflate;
        ((ViewGroup) this.itemView).addView(((LayoutSquareEmptyFriendBinding) Inflate).getRoot());
    }

    @Override // com.zenmen.listui.list.BaseViewHolder
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(SquareFeed squareFeed, int i) {
        ((LayoutSquareEmptyFriendBinding) this.d).b(squareFeed);
        ((LayoutSquareEmptyFriendBinding) this.d).executePendingBindings();
    }
}
