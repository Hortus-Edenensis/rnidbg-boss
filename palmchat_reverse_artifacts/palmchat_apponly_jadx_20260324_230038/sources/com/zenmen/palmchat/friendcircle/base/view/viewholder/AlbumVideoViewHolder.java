package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.ei4;
import defpackage.gr2;
import defpackage.je1;
import defpackage.k86;
import defpackage.lf5;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AlbumVideoViewHolder extends AlbumSingleViewHolder implements View.OnClickListener {
    public Context B;
    public RelativeLayout C;
    public ImageView E;
    public Feed F;
    public ImageView G;
    public int H;
    public int I;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Media f14014a;

        public a(Media media) {
            this.f14014a = media;
            put("wid", media.wid);
        }
    }

    public AlbumVideoViewHolder(Context context, ViewGroup viewGroup, int i, boolean z, ContactInfoItem contactInfoItem) {
        super(context, viewGroup, i, z, contactInfoItem);
        this.H = 0;
        this.I = 0;
        this.B = context;
        this.H = a46.b(this.itemView.getContext(), 180.0f);
        this.I = a46.b(this.itemView.getContext(), 208.0f);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void A(@NonNull Feed feed, int i, int i2) {
        if (feed == null || feed.getMediaList() == null || feed.getMediaList().size() == 0) {
            return;
        }
        this.F = feed;
        this.E.setImageDrawable(null);
        Media media = this.F.getMediaList().get(0);
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        if (media.getHeight() >= media.getWidth()) {
            int i3 = this.H;
            layoutParams.width = i3;
            layoutParams.height = Math.round((i3 / 3.0f) * 4.0f);
        } else {
            int i4 = this.I;
            layoutParams.width = i4;
            layoutParams.height = Math.round((i4 / 4.0f) * 3.0f);
        }
        this.C.setLayoutParams(layoutParams);
        String strH = H(media);
        if (strH == null) {
            return;
        }
        gr2.j().h(k86.p(strH), this.E, new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).r());
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void C(@NonNull View view) {
        this.C = (RelativeLayout) x(this.n, R$id.item_video_field);
        this.E = (ImageView) x(this.n, R$id.video_cover);
        this.G = (ImageView) x(this.n, R$id.video_play_btn);
        this.C.setOnClickListener(this);
    }

    public final String H(Media media) {
        if (media.localThumbPath != null && new File(media.localThumbPath).exists()) {
            return media.localThumbPath;
        }
        String str = media.midUrl;
        return str != null ? str : media.url;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Feed feed;
        if (view.getId() != R$id.item_video_field) {
            if (view.getId() != R$id.video_tag || (feed = this.F) == null || feed.getMediaList() == null || this.F.getMediaList().size() <= 0) {
                return;
            }
            Media media = this.F.getMediaList().get(0);
            lf5.g(this.B, media.wid);
            LogUtil.uploadInfoImmediate("dou_M36_source", new a(media));
            return;
        }
        Feed feed2 = this.F;
        if (feed2 == null || feed2.getMediaList() == null || this.F.getMediaList().size() <= 0) {
            return;
        }
        List<Media> mediaList = this.F.getMediaList();
        ArrayList arrayList = new ArrayList();
        if (mediaList == null || mediaList.size() <= 0) {
            return;
        }
        for (Media media2 : mediaList) {
            FeedBean feedBean = new FeedBean();
            MediaItem mediaItem = new MediaItem();
            mediaItem.fileFullPath = media2.videoUrl;
            mediaItem.thumbnailPath = media2.url;
            mediaItem.localPath = media2.localPath;
            mediaItem.localThumbPath = media2.localThumbPath;
            mediaItem.mimeType = 1;
            mediaItem.playLength = media2.videoDuration;
            feedBean.setMediaItem(mediaItem);
            feedBean.setWidth(media2.width);
            feedBean.setHeight(media2.height);
            feedBean.setFeedId(this.F.getFeedId().longValue());
            feedBean.setCreateDt(this.F.getCreateDt().longValue());
            feedBean.setUid(this.F.getUid());
            arrayList.add(feedBean);
        }
        ei4.j((Activity) this.B, arrayList, 0, this.F, 0);
    }
}
