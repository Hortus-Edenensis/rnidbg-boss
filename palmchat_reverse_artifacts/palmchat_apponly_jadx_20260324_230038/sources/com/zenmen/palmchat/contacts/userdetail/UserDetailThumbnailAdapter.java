package com.zenmen.palmchat.contacts.userdetail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.widget.LXPortraitView;
import defpackage.gu;
import defpackage.hc2;
import defpackage.k86;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserDetailThumbnailAdapter extends BaseRecyclerViewAdapter<a> {

    /* JADX INFO: compiled from: SearchBox */
    public static class ViewHolder extends BaseRecyclerViewHolder<a> {
        public LXPortraitView f;
        public View g;
        public View h;
        public View i;
        public a j;

        public ViewHolder(Context context, ViewGroup viewGroup, int i) {
            super(context, viewGroup, i);
            this.f = (LXPortraitView) l(R.id.image_item);
            this.g = l(R.id.root);
            this.i = l(R.id.select);
            this.h = l(R.id.add);
        }

        @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void o(a aVar, int i) {
            this.j = aVar;
            if (aVar != null) {
                if (aVar.d) {
                    this.h.setVisibility(0);
                    this.g.setVisibility(8);
                    return;
                }
                this.h.setVisibility(8);
                this.g.setVisibility(0);
                String str = TextUtils.isEmpty(this.j.b.headIcon) ? this.j.b.headImg : this.j.b.headIcon;
                if (this.j.e) {
                    hc2.a(m()).load(k86.p(str)).placeholder(R.drawable.default_portrait).into(this.f.getPortraitView());
                } else {
                    hc2.a(m()).load(k86.p(str)).placeholder(R.drawable.default_portrait).transform(new gu(10, 2)).into(this.f.getPortraitView());
                }
                if (i == 0) {
                    LXPortraitView lXPortraitView = this.f;
                    ContactInfoItem contactInfoItem = this.j.c;
                    lXPortraitView.setDecor(contactInfoItem != null ? contactInfoItem.getAmulet() : null);
                }
                if (this.j.f13679a) {
                    this.i.setVisibility(0);
                } else {
                    this.i.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements BaseRecyclerViewAdapter.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13679a;
        public ContactInfoItem.Portrait b;
        public ContactInfoItem c;
        public boolean d;
        public boolean e;
    }

    public UserDetailThumbnailAdapter(@NonNull Context context, @NonNull List<a> list) {
        super(context, list);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        ViewHolder viewHolder = new ViewHolder(this.e, viewGroup, R.layout.list_item_user_detail_thumbnail);
        p(viewHolder);
        return viewHolder;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull a aVar) {
        return 0;
    }

    public void s(int i) {
        int i2 = 0;
        while (i2 < this.f.size()) {
            ((a) this.f.get(i2)).f13679a = i2 == i;
            i2++;
        }
        notifyDataSetChanged();
    }
}
