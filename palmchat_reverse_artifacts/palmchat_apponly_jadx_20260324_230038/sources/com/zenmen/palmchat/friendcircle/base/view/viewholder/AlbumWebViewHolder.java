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
import defpackage.gr2;
import defpackage.h05;
import defpackage.h13;
import defpackage.hr2;
import defpackage.lf5;
import defpackage.rp2;
import defpackage.vj6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AlbumWebViewHolder extends AlbumSingleViewHolder implements View.OnClickListener {
    public Context B;
    public View C;
    public ImageView E;
    public TextView F;
    public Feed G;

    public AlbumWebViewHolder(Context context, ViewGroup viewGroup, int i, boolean z, ContactInfoItem contactInfoItem) {
        super(context, viewGroup, i, z, contactInfoItem);
        this.B = context;
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void A(@NonNull Feed feed, int i, int i2) {
        Media media;
        if (feed != null) {
            this.G = feed;
            if (feed.getMediaList() == null || (media = this.G.getMediaList().get(0)) == null) {
                return;
            }
            String str = media.thumbUrl;
            String str2 = media.title;
            gr2.j().h(str, this.E, hr2.e());
            this.F.setText(str2);
        }
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.AlbumSingleViewHolder
    public void C(@NonNull View view) {
        this.C = x(this.n, R$id.item_web_field);
        this.E = (ImageView) x(this.n, R$id.web_thumb);
        this.F = (TextView) x(this.n, R$id.web_title);
        this.C.setOnClickListener(this);
    }

    public final void H(Media media, Feed feed) {
        int i = media.subType;
        if (i != 1 && i != 3 && i != 2 && i != 4) {
            I(media.url);
            return;
        }
        try {
            new JSONObject().put("feed_id", feed.getFeedId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (i == 1) {
            lf5.e(this.B, String.valueOf(this.G.getFeedId()), i, media.wid, this.G.getUid());
            return;
        }
        if (i == 3) {
            lf5.e(this.B, String.valueOf(this.G.getFeedId()), i, null, this.G.getUid());
        } else if (i == 2) {
            lf5.e(this.B, String.valueOf(this.G.getFeedId()), i, media.wineTopicId, this.G.getUid());
        } else if (i == 4) {
            lf5.f(this.B, String.valueOf(this.G.getFeedId()), i, media.poiId, media.adCode, media.cityCode, this.G.getUid());
        }
    }

    public final void I(String str) {
        if (str == null) {
            return;
        }
        h05.g(this.G);
        rp2.a aVar = new rp2.a();
        aVar.l(str);
        aVar.g(-1);
        aVar.k(true);
        aVar.i(h13.n);
        aVar.h(h05.b(this.G));
        this.B.startActivity(vj6.a(this.B, aVar));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Feed feed;
        if (view.getId() != R$id.item_web_field || (feed = this.G) == null || feed.getMediaList() == null || this.G.getMediaList().size() <= 0) {
            return;
        }
        H(this.G.getMediaList().get(0), this.G);
    }
}
