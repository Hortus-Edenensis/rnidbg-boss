package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.R$anim;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.ui.widget.common.ClickShowMoreLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a46;
import defpackage.fk2;
import defpackage.j9;
import defpackage.kl5;
import defpackage.n5;
import defpackage.ni0;
import defpackage.nq3;
import defpackage.v4;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AlbumSingleViewHolder extends BaseRecyclerViewHolder<Feed> {
    public static String A = "AlbumSingleViewHolder";
    public View f;
    public ClickShowMoreLayout g;
    public ImageView h;
    public View i;
    public View j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public LinearLayout n;
    public int o;
    public Feed p;
    public ni0 q;
    public j9 r;
    public Context s;
    public ContactInfoItem t;
    public int u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public View.OnClickListener z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ClickShowMoreLayout.g {
        public a() {
        }

        @Override // com.zenmen.palmchat.ui.widget.common.ClickShowMoreLayout.g
        public int a(int i) {
            return i + AlbumSingleViewHolder.this.o;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            if (AlbumSingleViewHolder.this.p == null) {
                return;
            }
            a46.C(AlbumSingleViewHolder.this.i, R$anim.square_click_like_anim);
            if (AlbumSingleViewHolder.this.p.getLikesList() == null || AlbumSingleViewHolder.this.p.getLikesList().size() < 0) {
                z = false;
            } else {
                Iterator<Comment> it = AlbumSingleViewHolder.this.p.getLikesList().iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().getFromUid(), v4.e(com.zenmen.palmchat.c.b()))) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, AlbumSingleViewHolder.this.u);
                jSONObject.put("type", z ? 2 : 1);
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M241", "1", null, jSONObject.toString());
            if (z) {
                Long l = new Long(0L);
                if (AlbumSingleViewHolder.this.p != null) {
                    Iterator<Comment> it2 = AlbumSingleViewHolder.this.p.likes.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Comment next = it2.next();
                        if (TextUtils.equals(next.getFromUid(), v4.e(com.zenmen.palmchat.c.b()))) {
                            l = next.getId();
                            break;
                        }
                    }
                }
                AlbumSingleViewHolder.this.r.e(AlbumSingleViewHolder.this.o, AlbumSingleViewHolder.this.p, l);
            } else {
                AlbumSingleViewHolder.this.r.b(AlbumSingleViewHolder.this.o, AlbumSingleViewHolder.this.p);
            }
            AlbumSingleViewHolder albumSingleViewHolder = AlbumSingleViewHolder.this;
            TextView textView = albumSingleViewHolder.l;
            Feed unused2 = albumSingleViewHolder.p;
            textView.setText(Feed.getStringNumForShow(AlbumSingleViewHolder.this.p.getLikeNum(), 1));
            AlbumSingleViewHolder albumSingleViewHolder2 = AlbumSingleViewHolder.this;
            TextView textView2 = albumSingleViewHolder2.m;
            Feed unused3 = albumSingleViewHolder2.p;
            textView2.setText(Feed.getStringNumForShow(AlbumSingleViewHolder.this.p.getCommentNum(), 0));
            AlbumSingleViewHolder.this.k.setImageResource(z ? R$drawable.fc_detail_like : R$drawable.fc_detail_dislike);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlbumSingleViewHolder.this.p == null) {
                return;
            }
            LogUtil.i(AlbumSingleViewHolder.A, "onCommentClickListener");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, AlbumSingleViewHolder.this.u);
                jSONObject.put("type", 1);
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M242", "1", null, jSONObject.toString());
            j9 j9Var = AlbumSingleViewHolder.this.r;
            AlbumSingleViewHolder albumSingleViewHolder = AlbumSingleViewHolder.this;
            j9Var.d(albumSingleViewHolder.itemView, albumSingleViewHolder.o, AlbumSingleViewHolder.this.p.getFeedId().longValue(), null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString(DeviceInfoUtil.UID_TAG, AlbumSingleViewHolder.this.p.getUid());
            aVar.b(bundle);
            AlbumSingleViewHolder.this.s.startActivity(n5.a(AlbumSingleViewHolder.this.s, aVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Feed feed = (Feed) view.getTag(R$id.momentinfo_data_tag_id);
            if (feed != null) {
                AlbumSingleViewHolder.this.q.Q(feed);
                AlbumSingleViewHolder.this.q.N(AlbumSingleViewHolder.this.h);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlbumSingleViewHolder.this.r.c(view.getContext(), AlbumSingleViewHolder.this.p);
        }
    }

    public AlbumSingleViewHolder(Context context, ViewGroup viewGroup, int i, boolean z, ContactInfoItem contactInfoItem) {
        super(context, viewGroup, i);
        this.v = new b();
        this.w = new c();
        this.x = new d();
        this.y = new e();
        this.z = new f();
        C(this.itemView);
        this.t = contactInfoItem;
        this.s = context;
        this.f = x(this.f, R$id.send_fail_banner_area);
        ClickShowMoreLayout clickShowMoreLayout = (ClickShowMoreLayout) x(this.g, R$id.item_text_field);
        this.g = clickShowMoreLayout;
        if (clickShowMoreLayout != null) {
            clickShowMoreLayout.setTextSize(16);
            this.g.setOnStateKeyGenerateListener(new a());
        }
        this.i = l(R$id.btn_like);
        this.k = (ImageView) l(R$id.img_like);
        this.l = (TextView) l(R$id.tv_like);
        this.m = (TextView) l(R$id.tv_cmt);
        this.j = l(R$id.btn_comment);
        this.n = (LinearLayout) x(this.n, R$id.content);
        this.i.setOnClickListener(this.v);
        this.j.setOnClickListener(this.w);
    }

    public final void B(Feed feed) {
        if (this.g != null) {
            if (kl5.c(feed.getContent())) {
                this.g.setVisibility(0);
                this.g.setText(feed.getContent().trim(), feed.getFeedId().longValue());
            } else {
                this.g.setVisibility(8);
            }
        }
        G();
    }

    public void E(j9 j9Var) {
        this.r = j9Var;
    }

    public void F(int i) {
        this.u = i;
    }

    public final void G() {
        boolean z;
        if (this.p.getLikesList() == null || this.p.getLikesList().size() < 0) {
            z = false;
        } else {
            Iterator<Comment> it = this.p.getLikesList().iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getFromUid(), v4.e(com.zenmen.palmchat.c.b()))) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        this.l.setText(Feed.getStringNumForShow(this.p.getLikeNum(), 1));
        this.m.setText(Feed.getStringNumForShow(this.p.getCommentNum(), 0));
        this.k.setImageResource(z ? R$drawable.fc_detail_like : R$drawable.fc_detail_dislike);
    }

    public final View x(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void o(Feed feed, int i) {
        if (feed == null) {
            Log.e(A, "data is null");
            return;
        }
        this.p = feed;
        this.o = i;
        B(feed);
        A(feed, i, n());
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void p(Feed feed, int i, List<Object> list) {
        if (list == null || list.isEmpty() || !list.get(0).equals("like")) {
            return;
        }
        G();
    }

    public void C(@NonNull View view) {
    }

    public void D(nq3.c cVar) {
    }

    public void A(@NonNull Feed feed, int i, int i2) {
    }
}
