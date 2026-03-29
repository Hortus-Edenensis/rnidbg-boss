package com.zenmen.palmchat.friendcircle.base.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumMultiImageViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSmallVideoViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumVideoViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumWebAppViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumWebViewHolder;
import com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder;
import com.zenmen.palmchat.greendao.model.Feed;
import defpackage.j9;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AlbumSingleitemAdapter extends BaseRecyclerViewAdapter<Feed> {
    public final Context j;
    public j9 k;
    public boolean l;
    public ContactInfoItem m;
    public int n;

    public AlbumSingleitemAdapter(@NonNull Context context, @NonNull List<Feed> list, j9 j9Var, boolean z, ContactInfoItem contactInfoItem, int i) {
        super(context, list);
        this.j = context;
        this.k = j9Var;
        this.l = z;
        this.m = contactInfoItem;
        this.n = i;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public int g(int i) {
        return 0;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    public BaseRecyclerViewHolder h(ViewGroup viewGroup, View view, int i) {
        AlbumSingleViewHolder albumMultiImageViewHolder = i == 2 ? new AlbumMultiImageViewHolder(this.e, viewGroup, R$layout.album_single_multi_image_right, this.l, this.m) : i == 1 ? new AlbumSingleViewHolder(this.e, viewGroup, R$layout.album_single_only_text_right, this.l, this.m) : i == 4 ? new AlbumWebViewHolder(this.e, viewGroup, R$layout.album_single_web_right, this.l, this.m) : i == 3 ? new AlbumVideoViewHolder(this.e, viewGroup, R$layout.album_single_video_right, this.l, this.m) : i == 6 ? new AlbumSmallVideoViewHolder(this.e, viewGroup, R$layout.album_single_smallvideo_right, this.l, this.m) : i == 7 ? new AlbumWebAppViewHolder(this.e, viewGroup, R$layout.album_single_webapp_right, this.l, this.m) : new AlbumSingleViewHolder(this.e, viewGroup, R$layout.album_single_empty_content_right, this.l, this.m);
        albumMultiImageViewHolder.E(this.k);
        albumMultiImageViewHolder.D(null);
        albumMultiImageViewHolder.F(this.n);
        return albumMultiImageViewHolder;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.adapter.BaseRecyclerViewAdapter
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int i(int i, @NonNull Feed feed) {
        return feed.getFeedType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseRecyclerViewHolder<Feed> baseRecyclerViewHolder, int i, List<Object> list) {
        if (list == null || list.isEmpty()) {
            onBindViewHolder(baseRecyclerViewHolder, i);
            return;
        }
        Feed feed = (Feed) this.f.get(i);
        baseRecyclerViewHolder.itemView.setTag(R$id.recycler_view_tag, feed);
        baseRecyclerViewHolder.p(feed, i, list);
        k(baseRecyclerViewHolder, feed, i);
    }
}
