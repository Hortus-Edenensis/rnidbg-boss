package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qiniu.android.collect.ReportItem;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$string;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.greendao.model.Media;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.a46;
import defpackage.gr2;
import defpackage.h05;
import defpackage.h13;
import defpackage.hc2;
import defpackage.hr2;
import defpackage.je1;
import defpackage.kc2;
import defpackage.lf5;
import defpackage.rp2;
import defpackage.vj6;
import defpackage.zn6;
import java.util.HashMap;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewHolder extends MomentsBaseViewHolder implements View.OnClickListener {
    public Context I;
    public View J;
    public ImageView K;
    public TextView L;
    public Feed M;
    public ViewGroup N;
    public ViewGroup O;
    public EffectiveShapeView P;
    public TextView Q;
    public TextView R;
    public ImageView S;
    public TextView T;

    public WebViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.I = context;
    }

    public final void E(Media media, Feed feed) {
        int i = media.subType;
        if (i != 1 && i != 3 && i != 2 && i != 4) {
            F(media.url, this.M);
            return;
        }
        try {
            new JSONObject().put("feed_id", feed.getFeedId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (i == 1) {
            lf5.e(this.I, String.valueOf(this.M.getFeedId()), i, media.wid, this.M.getUid());
            return;
        }
        if (i == 3) {
            lf5.e(this.I, String.valueOf(this.M.getFeedId()), i, null, this.M.getUid());
        } else if (i == 2) {
            lf5.e(this.I, String.valueOf(this.M.getFeedId()), i, media.wineTopicId, this.M.getUid());
        } else if (i == 4) {
            lf5.f(this.I, String.valueOf(this.M.getFeedId()), i, media.poiId, media.adCode, media.cityCode, this.M.getUid());
        }
    }

    public final void F(String str, Feed feed) {
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
        h05.g(this.M);
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
        Feed feed;
        if (view.getId() != R$id.item_web_field || (feed = this.M) == null || feed.getMediaList() == null || this.M.getMediaList().size() <= 0) {
            return;
        }
        E(this.M.getMediaList().get(0), this.M);
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(this.A));
        map.put("feedid", this.M.getFeedId());
        map.put("feedType", Integer.valueOf(this.M.getFeedType()));
        map.put(ReportItem.RequestKeyRequestId, this.M.reqId);
        zn6.j("pagediscover_feeds", "click", map);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void x(@NonNull Feed feed, int i, int i2) {
        Media media;
        if (feed != null) {
            this.M = feed;
            if (feed.getMediaList() == null || (media = this.M.getMediaList().get(0)) == null) {
                return;
            }
            int i3 = media.subType;
            je1 je1VarE = hr2.e();
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
                this.N.setVisibility(0);
                this.O.setVisibility(8);
                String str = media.thumbUrl;
                String str2 = media.title;
                kc2<Drawable> kc2VarLoad = hc2.a(m()).load(str);
                int i4 = R$drawable.ic_default_link;
                kc2VarLoad.placeholder(i4).error(i4).transform(new RoundedCornersTransformation(a46.b(m(), 2.0f), 0)).into(this.K);
                this.L.setText(str2);
                return;
            }
            this.N.setVisibility(8);
            this.O.setVisibility(0);
            if (i3 == 1) {
                this.P.changeShapeType(1);
                this.T.setText(m().getText(R$string.moments_web_extra_source_smallvideo_namecard));
            } else {
                this.P.changeShapeType(2);
                this.T.setText(m().getText(R$string.moments_web_extra_source_smallvideo));
            }
            gr2.j().h(media.thumbUrl, this.P, je1VarE);
            gr2.j().h(lf5.c(), this.S, hr2.i());
            this.Q.setText(media.title);
            this.R.setText(media.subTitle);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.MomentsBaseViewHolder
    public void z(@NonNull View view) {
        this.J = u(this.J, R$id.item_web_field);
        this.K = (ImageView) u(this.K, R$id.web_thumb);
        this.L = (TextView) u(this.L, R$id.web_title);
        this.J.setOnClickListener(this);
        this.N = (ViewGroup) u(this.N, R$id.moment_web_item_comment);
        this.O = (ViewGroup) u(this.O, R$id.moment_web_item_extra);
        this.P = (EffectiveShapeView) u(this.P, R$id.moment_web_extra_icon);
        this.Q = (TextView) u(this.Q, R$id.moment_web_extra_title);
        this.R = (TextView) u(this.R, R$id.moment_web_extra_des);
        this.S = (ImageView) u(this.S, R$id.moment_web_extra_source_icon);
        this.T = (TextView) u(this.T, R$id.moment_web_extra_source_name);
    }
}
