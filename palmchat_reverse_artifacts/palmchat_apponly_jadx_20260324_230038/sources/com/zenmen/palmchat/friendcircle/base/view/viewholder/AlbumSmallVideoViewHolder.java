package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.lf5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AlbumSmallVideoViewHolder extends AlbumSingleViewHolder implements View.OnClickListener {
    public Context B;
    public ImageView C;
    public TextView E;
    public ImageView F;
    public TextView G;
    public ImageView H;
    public Feed I;
    public ViewGroup J;

    public AlbumSmallVideoViewHolder(Context context, ViewGroup viewGroup, int i, boolean z, ContactInfoItem contactInfoItem) {
        super(context, viewGroup, i, z, contactInfoItem);
        this.B = context;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void A(@NonNull Feed feed, int i, int i2) {
        Media media;
        if (feed != null) {
            this.I = feed;
            if (feed.getMediaList() == null || (media = this.I.getMediaList().get(0)) == null) {
                return;
            }
            gr2.j().h(media.midUrl, this.C, hr2.j());
            this.G.setText(media.title);
            this.E.setText(media.getSourceName());
            gr2.j().h(media.getSourceIcon(), this.F, hr2.i());
            gr2.j().h(lf5.c(), this.H, hr2.i());
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void C(@NonNull View view) {
        View viewL = l(R$id.small_video_layout);
        View viewL2 = l(R$id.small_video_layot_new);
        viewL.setVisibility(0);
        viewL2.setVisibility(8);
        this.C = (ImageView) x(this.C, R$id.smallvideo_cover);
        this.G = (TextView) x(this.G, R$id.wine_title);
        this.F = (ImageView) x(this.F, R$id.wine_head);
        this.E = (TextView) x(this.E, R$id.wine_name);
        this.H = (ImageView) x(this.H, R$id.source_icon);
        ViewGroup viewGroup = (ViewGroup) x(this.J, R$id.item_smallvideo_field);
        this.J = viewGroup;
        viewGroup.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.item_smallvideo_field || view.getId() == R$id.item_smallvideo_field_new) {
            Media media = this.I.getMediaList().get(0);
            LogUtil.d("WebViewHolder", "jumpToNativeFromShare wid = " + media.wid + "， wineFeedId = " + media.wineFeedId);
            lf5.e(this.B, String.valueOf(this.I.getFeedId()), 0, media.wineFeedId, this.I.getUid());
        }
    }
}
