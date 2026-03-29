package com.zenmen.palmchat.settings.profileedit;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.square.bean.SquareDynamicLifeBeanInfo;
import com.zenmen.square.dynamiclife.DynamicCornerImageView;
import defpackage.a46;
import defpackage.hc2;
import defpackage.je1;
import defpackage.me1;
import defpackage.vl1;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ProfileUserFeedAdapter extends BaseRecyclerViewAdapter<a> {

    /* JADX INFO: compiled from: SearchBox */
    public static class ViewHolder extends BaseRecyclerViewHolder<a> {
        public DynamicCornerImageView f;
        public ImageView g;
        public TextView h;
        public View i;
        public je1 j;
        public a k;

        public ViewHolder(Context context, ViewGroup viewGroup, int i) {
            super(context, viewGroup, i);
            DynamicCornerImageView dynamicCornerImageView = (DynamicCornerImageView) l(R.id.iv_image);
            this.f = dynamicCornerImageView;
            dynamicCornerImageView.setBorderRadius(me1.b(context, 8));
            this.g = (ImageView) l(R.id.iv_video);
            this.h = (TextView) l(R.id.text_thumbnail);
            this.i = l(R.id.allTv);
            this.j = a46.j(this.itemView.getContext(), 4.0f, R.drawable.icon_default_thumbnail);
        }

        public final String q(Media media) {
            if (media.localThumbPath != null && new File(media.localThumbPath).exists()) {
                return media.localThumbPath;
            }
            String str = media.midUrl;
            return str != null ? str : media.url;
        }

        @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void o(a aVar, int i) {
            Feed feed;
            SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo;
            this.k = aVar;
            int iB = a46.b(m(), 72.0f);
            int iB2 = a46.b(m(), 72.0f);
            this.h.setBackgroundResource(R.drawable.shape_feed_text_bg_4);
            this.h.setTextColor(Color.parseColor("#222222"));
            if (aVar != null && (squareDynamicLifeBeanInfo = aVar.f15330a) != null) {
                this.h.setVisibility(squareDynamicLifeBeanInfo.feedType == 1 ? 0 : 8);
                this.f.setVisibility(aVar.f15330a.feedType == 1 ? 8 : 0);
                this.g.setVisibility(aVar.f15330a.feedType == 3 ? 0 : 8);
                if (!TextUtils.isEmpty(aVar.f15330a.thumbUrl) && aVar.f15330a.feedType != 1) {
                    hc2.a(m()).load(a46.g(iB, iB2, aVar.f15330a.thumbUrl)).error(R.drawable.icon_default_thumbnail).into(this.f);
                } else if (!TextUtils.isEmpty(aVar.f15330a.content)) {
                    this.h.setText(vl1.c(aVar.f15330a.content.trim(), this.h.getContext(), vl1.j));
                }
            } else if (aVar != null && (feed = aVar.b) != null) {
                if (feed.getMediaList() == null || aVar.b.getMediaList().size() <= 0) {
                    this.h.setVisibility(0);
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                    this.h.setText(vl1.c(aVar.b.getContent().trim(), this.h.getContext(), vl1.j));
                } else {
                    this.h.setVisibility(8);
                    this.f.setVisibility(0);
                    Media media = aVar.b.getMediaList().get(0);
                    String strQ = media.thumbUrl;
                    if (aVar.b.getFeedType() == 3 || aVar.b.getFeedType() == 6) {
                        strQ = q(media);
                    }
                    if (aVar.b.getFeedType() == 3) {
                        strQ = a46.g(iB, iB2, strQ);
                    }
                    hc2.a(m()).load(strQ).error(R.drawable.icon_default_thumbnail).into(this.f);
                    if (aVar.b.getFeedType() == 3 || aVar.b.getFeedType() == 6) {
                        this.g.setVisibility(0);
                    } else {
                        this.g.setVisibility(8);
                    }
                }
            }
            this.i.setVisibility(i != 3 ? 8 : 0);
            if (i == 3) {
                this.h.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements BaseRecyclerViewAdapter.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SquareDynamicLifeBeanInfo f15330a;
        public Feed b;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.min(super.getItemCount(), 4);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        ViewHolder viewHolder = new ViewHolder(this.e, viewGroup, R.layout.list_item_user_detail_feed_profile);
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
