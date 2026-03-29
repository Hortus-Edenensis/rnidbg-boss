package com.zenmen.palmchat.contacts.userdetail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.giftkit.bean.PackPanelItem;
import defpackage.hc2;
import defpackage.k86;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserDetailGiftAdapter extends BaseRecyclerViewAdapter<a> {
    public boolean j;

    /* JADX INFO: compiled from: SearchBox */
    public static class ViewHolder extends BaseRecyclerViewHolder<a> {
        public ImageView f;
        public TextView g;
        public TextView h;
        public View i;
        public View j;

        public ViewHolder(Context context, ViewGroup viewGroup, int i) {
            super(context, viewGroup, i);
            this.f = (ImageView) l(R.id.iv_icon);
            this.g = (TextView) l(R.id.tv_name);
            this.h = (TextView) l(R.id.tv_num);
            this.i = l(R.id.layout);
            this.j = l(R.id.sendLayout);
        }

        @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void o(a aVar, int i) {
            if (aVar.f13674a == null) {
                this.j.setVisibility(0);
                this.i.setVisibility(8);
                return;
            }
            this.j.setVisibility(8);
            this.i.setVisibility(0);
            hc2.a(m()).load(k86.p(aVar.f13674a.iconUrl)).fitCenter().transition(DrawableTransitionOptions.withCrossFade()).into(this.f);
            this.g.setText(aVar.f13674a.itemName);
            this.h.setText("x" + aVar.f13674a.itemCount);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements BaseRecyclerViewAdapter.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PackPanelItem f13674a;

        public a(PackPanelItem packPanelItem) {
            this.f13674a = packPanelItem;
        }
    }

    public UserDetailGiftAdapter(@NonNull Context context, @NonNull List<a> list) {
        super(context, list);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        ViewHolder viewHolder = new ViewHolder(this.e, viewGroup, R.layout.list_item_user_detail_gift);
        p(viewHolder);
        viewHolder.i.setBackgroundResource(this.j ? R.drawable.bg_list_item_user_detail_gift_v2 : R.drawable.bg_list_item_user_detail_gift);
        return viewHolder;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull a aVar) {
        return 0;
    }

    public void s(boolean z) {
        this.j = z;
    }
}
