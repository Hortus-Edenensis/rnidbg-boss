package com.zenmen.palmchat.settings.profileedit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.square.dynamiclife.DynamicCornerImageView;
import defpackage.a46;
import defpackage.hc2;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ProfilePortraitAdapter extends BaseRecyclerViewAdapter<a> {

    /* JADX INFO: compiled from: SearchBox */
    public static class ViewHolder extends BaseRecyclerViewHolder<a> {
        public DynamicCornerImageView f;
        public View g;
        public a h;

        public ViewHolder(Context context, ViewGroup viewGroup, int i) {
            super(context, viewGroup, i);
            DynamicCornerImageView dynamicCornerImageView = (DynamicCornerImageView) l(R.id.iv_image);
            this.f = dynamicCornerImageView;
            dynamicCornerImageView.setBorderRadius(me1.b(context, 8));
            this.g = l(R.id.allTv);
        }

        @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void o(a aVar, int i) {
            this.h = aVar;
            int iB = a46.b(m(), 72.0f);
            int iB2 = a46.b(m(), 72.0f);
            this.g.setVisibility(i == 7 ? 0 : 8);
            if (aVar == null || aVar.f15329a == null) {
                return;
            }
            hc2.a(m()).load(a46.g(iB, iB2, aVar.f15329a.thumbUrl)).error(R.drawable.default_portrait).into(this.f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements BaseRecyclerViewAdapter.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ProfilePortraitItem f15329a;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.min(super.getItemCount(), 8);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        ViewHolder viewHolder = new ViewHolder(this.e, viewGroup, R.layout.list_item_user_portait_profile);
        p(viewHolder);
        viewHolder.itemView.setLayoutParams(new FrameLayout.LayoutParams(r(), r()));
        return viewHolder;
    }

    public final int r() {
        return ((me1.g() - me1.b(this.e, 64)) - me1.b(this.e, 15)) / 4;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull a aVar) {
        return 0;
    }
}
