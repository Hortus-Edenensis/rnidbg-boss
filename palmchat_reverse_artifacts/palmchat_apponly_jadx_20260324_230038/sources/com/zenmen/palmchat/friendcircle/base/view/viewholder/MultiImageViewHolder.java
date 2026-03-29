package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.photoview.FeedBean;
import com.zenmen.palmchat.ui.widget.photo.newui.MultiImageLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ei4;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MultiImageViewHolder extends MomentsBaseViewHolder {
    public MultiImageLayout I;

    public MultiImageViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void v() {
        ArrayList arrayList = new ArrayList();
        for (Media media : this.w.getMediaList()) {
            FeedBean feedBean = new FeedBean();
            MediaItem mediaItem = new MediaItem();
            if (media.localPath != null && new File(media.localPath).exists()) {
                mediaItem.fileFullPath = media.localPath;
            }
            String str = media.url;
            if (str != null) {
                mediaItem.fileFullPath = str;
            }
            mediaItem.thumbnailPath = media.midUrl;
            feedBean.setMediaItem(mediaItem);
            feedBean.setWidth(media.width);
            feedBean.setHeight(media.height);
            arrayList.add(feedBean);
        }
        Activity activity = (Activity) m();
        Feed feed = this.w;
        ei4.e(activity, feed, arrayList, 0, 0, feed.getId(), this.w.getUid(), this.A);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void x(@NonNull Feed feed, int i, int i2) {
        if (feed == null || feed.getMediaList() == null) {
            return;
        }
        LogUtil.d("MultiImageViewHolder", i2 + "");
        this.I.setMediaList(feed.getMediaList());
        this.I.setFeedId(feed.getFeedId());
        this.I.setFeed(feed);
        this.I.setFromTimeLine(true);
        this.I.setFrom(this.A);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void z(@NonNull View view) {
        this.I = (MultiImageLayout) u(this.I, R$id.circle_image_container_new);
    }
}
