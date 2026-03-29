package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.content.Intent;
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
import defpackage.bu3;
import defpackage.gr2;
import defpackage.h05;
import defpackage.h13;
import defpackage.hr2;
import defpackage.rp2;
import defpackage.vj6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AlbumWebAppViewHolder extends AlbumSingleViewHolder implements View.OnClickListener {
    public Context B;
    public ImageView C;
    public TextView E;
    public ImageView F;
    public TextView G;
    public Feed H;
    public ViewGroup I;

    public AlbumWebAppViewHolder(Context context, ViewGroup viewGroup, int i, boolean z, ContactInfoItem contactInfoItem) {
        super(context, viewGroup, i, z, contactInfoItem);
        this.B = context;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void A(@NonNull Feed feed, int i, int i2) {
        Media media;
        if (feed != null) {
            this.H = feed;
            if (feed.getMediaList() == null || (media = this.H.getMediaList().get(0)) == null) {
                return;
            }
            gr2.j().h(media.thumbUrl, this.C, hr2.m());
            this.G.setText(media.title);
            this.E.setText(media.getSourceName());
            gr2.j().h(media.getSourceIcon(), this.F, hr2.i());
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void C(@NonNull View view) {
        View viewL = l(R$id.web_app_layout);
        View viewL2 = l(R$id.web_app_layout_new);
        viewL.setVisibility(0);
        viewL2.setVisibility(8);
        this.C = (ImageView) x(this.C, R$id.smallvideo_cover);
        this.G = (TextView) x(this.G, R$id.wine_title);
        this.F = (ImageView) x(this.F, R$id.wine_head);
        this.E = (TextView) x(this.E, R$id.wine_name);
        ViewGroup viewGroup = (ViewGroup) x(this.I, R$id.item_smallvideo_field);
        this.I = viewGroup;
        viewGroup.setOnClickListener(this);
    }

    public final void H(String str, Feed feed) {
        if (str == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feed_id", feed.getFeedId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("M32", "1", null, jSONObject.toString());
        h05.g(this.H);
        rp2.a aVar = new rp2.a();
        aVar.l(str);
        aVar.g(-1);
        aVar.k(true);
        aVar.i(h13.n);
        aVar.h(h05.b(feed));
        this.B.startActivity(vj6.a(this.B, aVar));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.item_smallvideo_field || view.getId() == R$id.item_smallvideo_field_new) {
            Media media = this.H.getMediaList().get(0);
            LogUtil.d("WebViewHolder", "jumpToNativeFromShare wid = " + media.wid + "， wineFeedId = " + media.wineFeedId);
            Intent intentE = bu3.g().e(this.B, media.openLink);
            if (intentE != null) {
                this.B.startActivity(intentE);
            } else {
                H(media.url, this.H);
            }
        }
    }
}
