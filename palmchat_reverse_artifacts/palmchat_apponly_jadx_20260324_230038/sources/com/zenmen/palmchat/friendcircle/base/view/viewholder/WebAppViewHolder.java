package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qiniu.android.collect.ReportItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.AspectRatioFrameLayout;
import defpackage.bu3;
import defpackage.gr2;
import defpackage.h05;
import defpackage.h13;
import defpackage.hr2;
import defpackage.rp2;
import defpackage.vj6;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class WebAppViewHolder extends MomentsBaseViewHolder implements View.OnClickListener {
    public static String Q = "WebAppViewHolder";
    public Context I;
    public ViewGroup J;
    public ImageView K;
    public AspectRatioFrameLayout L;
    public TextView M;
    public ImageView N;
    public TextView O;
    public Feed P;

    public WebAppViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.I = context;
    }

    public final void E(String str, Feed feed) {
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
        h05.g(this.P);
        rp2.a aVar = new rp2.a();
        aVar.l(str);
        aVar.g(-1);
        aVar.k(true);
        aVar.i(h13.n);
        aVar.h(h05.b(feed));
        this.I.startActivity(vj6.a(this.I, aVar));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.item_smallvideo_field || view.getId() == R$id.item_smallvideo_field_new) {
            Media media = this.P.getMediaList().get(0);
            LogUtil.d(Q, "jumpToNativeFromShare wid = " + media.wid + "， wineFeedId = " + media.wineFeedId);
            Intent intentE = bu3.g().e(this.I, media.openLink);
            if (intentE != null) {
                this.I.startActivity(intentE);
            } else {
                E(media.url, this.P);
            }
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(this.A));
            map.put("feedid", this.P.getFeedId());
            map.put("feedType", Integer.valueOf(this.P.getFeedType()));
            map.put(ReportItem.RequestKeyRequestId, this.P.reqId);
            zn6.j("pagediscover_feeds", "click", map);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void x(@NonNull Feed feed, int i, int i2) {
        Media media;
        if (feed != null) {
            this.P = feed;
            if (feed.getMediaList() == null || (media = this.P.getMediaList().get(0)) == null) {
                return;
            }
            gr2.j().h(media.thumbUrl, this.K, hr2.m());
            this.O.setText(media.title);
            this.M.setText(media.getSourceName());
            gr2.j().h(media.getSourceIcon(), this.N, hr2.i());
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void z(@NonNull View view) {
        View viewL = l(R$id.web_app_layout);
        View viewL2 = l(R$id.web_app_layout_new);
        viewL.setVisibility(0);
        viewL2.setVisibility(8);
        this.K = (ImageView) u(this.K, R$id.smallvideo_cover);
        this.O = (TextView) u(this.O, R$id.wine_title);
        this.N = (ImageView) u(this.N, R$id.wine_head);
        this.M = (TextView) u(this.M, R$id.wine_name);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) u(this.L, R$id.video_content);
        this.L = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setResizeMode(4);
        ViewGroup viewGroup = (ViewGroup) u(this.J, R$id.item_smallvideo_field);
        this.J = viewGroup;
        viewGroup.setOnClickListener(this);
    }
}
