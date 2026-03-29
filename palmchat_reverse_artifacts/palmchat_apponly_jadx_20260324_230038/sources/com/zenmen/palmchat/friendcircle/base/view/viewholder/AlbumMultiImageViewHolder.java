package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.ui.widget.photo.newui.MultiImageLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AlbumMultiImageViewHolder extends AlbumSingleViewHolder {
    public MultiImageLayout B;
    public List<Media> C;

    public AlbumMultiImageViewHolder(Context context, ViewGroup viewGroup, int i, boolean z, ContactInfoItem contactInfoItem) {
        super(context, viewGroup, i, z, contactInfoItem);
        this.C = new ArrayList();
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void A(@NonNull Feed feed, int i, int i2) {
        if (feed != null && feed.getMediaList() != null) {
            this.C = feed.getMediaList();
        }
        List<Media> list = this.C;
        if (list != null) {
            this.B.setMediaList(list);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void C(@NonNull View view) {
        this.B = (MultiImageLayout) x(this.B, R$id.circle_image_container_new);
    }
}
