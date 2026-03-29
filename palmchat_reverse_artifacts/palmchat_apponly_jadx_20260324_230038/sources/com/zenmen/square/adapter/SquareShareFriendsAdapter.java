package com.zenmen.square.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.square.R$layout;
import com.zenmen.square.bean.SquareFriendBean;
import com.zenmen.square.mvp.holder.SquareShareFriendViewHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareShareFriendsAdapter extends BaseRecyclerViewAdapter<SquareFriendBean> {
    public a j;
    public boolean k;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(SquareFriendBean squareFriendBean, View view);
    }

    public SquareShareFriendsAdapter(@NonNull Context context, @NonNull List<SquareFriendBean> list) {
        super(context, list);
        this.k = false;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        SquareShareFriendViewHolder squareShareFriendViewHolder = new SquareShareFriendViewHolder(this.e, viewGroup, R$layout.square_layout_item_share_friend);
        squareShareFriendViewHolder.u(this.j);
        return squareShareFriendViewHolder;
    }

    public List<SquareFriendBean> r() {
        ArrayList arrayList = new ArrayList();
        for (T t : this.f) {
            if (t.selected) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull SquareFriendBean squareFriendBean) {
        return 0;
    }

    public void t(a aVar) {
        this.j = aVar;
    }
}
