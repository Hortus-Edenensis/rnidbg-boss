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
import com.qiniu.android.collect.ReportItem;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.R$anim;
import com.zenmen.palmchat.friendcircle.R$color;
import com.zenmen.palmchat.friendcircle.R$drawable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.base.view.adapter.MomentsBaseAdapter;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.ui.widget.commentwidget.CommentContentsLayout;
import com.zenmen.palmchat.ui.widget.common.ClickShowMoreLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.a46;
import defpackage.ap3;
import defpackage.cy5;
import defpackage.dn0;
import defpackage.ei4;
import defpackage.fg6;
import defpackage.fk2;
import defpackage.gr2;
import defpackage.hr2;
import defpackage.k86;
import defpackage.kl5;
import defpackage.l50;
import defpackage.lq3;
import defpackage.n5;
import defpackage.sy5;
import defpackage.tf6;
import defpackage.v4;
import defpackage.wt1;
import defpackage.xh5;
import defpackage.zn6;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MomentsBaseViewHolder extends BaseRecyclerViewHolder<Feed> {
    public static String H = "MomentsBaseViewHolder";
    public int A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public View.OnClickListener E;
    public View.OnClickListener F;
    public View.OnClickListener G;
    public SocialPortraitView f;
    public SocialPortraitView g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public ClickShowMoreLayout l;
    public View m;
    public View n;
    public ImageView o;
    public TextView p;
    public View q;
    public TextView r;
    public TextView s;
    public CommentContentsLayout t;
    public LinearLayout u;
    public int v;
    public Feed w;
    public lq3 x;
    public MomentsBaseAdapter y;
    public Context z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ClickShowMoreLayout.g {
        public a() {
        }

        @Override // com.zenmen.palmchat.ui.widget.common.ClickShowMoreLayout.g
        public int a(int i) {
            return i + MomentsBaseViewHolder.this.v;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MomentsBaseViewHolder.this.v();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ClickShowMoreLayout.h {
        public c() {
        }

        @Override // com.zenmen.palmchat.ui.widget.common.ClickShowMoreLayout.h
        public void onClick() {
            MomentsBaseViewHolder.this.v();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ap3.q(MomentsBaseViewHolder.this.z, "8");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (dn0.a(MomentsBaseViewHolder.this.w.getUid()) == null) {
                sy5.f(MomentsBaseViewHolder.this.m(), "非好友暂无法操作", 1).g();
                return;
            }
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString(DeviceInfoUtil.UID_TAG, MomentsBaseViewHolder.this.w.getUid());
            if (MomentsBaseViewHolder.this.A == 2) {
                bundle.putInt("from", 39);
            } else {
                bundle.putInt("from", 20);
            }
            aVar.b(bundle);
            MomentsBaseViewHolder.this.z.startActivity(n5.a(MomentsBaseViewHolder.this.z, aVar));
            HashMap map = new HashMap();
            map.put("from", Integer.valueOf(MomentsBaseViewHolder.this.A));
            map.put("targetUid", MomentsBaseViewHolder.this.w.getUid());
            map.put("feedType", Integer.valueOf(MomentsBaseViewHolder.this.w.getFeedType()));
            map.put("feedid", MomentsBaseViewHolder.this.w.getFeedId());
            zn6.j("pagediscover_feeds_userbutton", "click", map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MomentsBaseViewHolder.this.x.e(view.getContext(), MomentsBaseViewHolder.this.w);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z;
            a46.C(MomentsBaseViewHolder.this.o, R$anim.square_click_like_anim);
            if (MomentsBaseViewHolder.this.w.getLikesList() != null) {
                Iterator<Comment> it = MomentsBaseViewHolder.this.w.getLikesList().iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().getFromUid(), v4.e(com.zenmen.palmchat.c.b()))) {
                        z = true;
                        break;
                    }
                }
                z = false;
            } else {
                z = false;
            }
            HashMap map = new HashMap();
            map.put("status", Integer.valueOf(z ? 2 : 1));
            map.put("from", Integer.valueOf(MomentsBaseViewHolder.this.A));
            map.put("targetUid", MomentsBaseViewHolder.this.w.getUid());
            map.put("feedType", Integer.valueOf(MomentsBaseViewHolder.this.w.getFeedType()));
            map.put("feedid", MomentsBaseViewHolder.this.w.getFeedId());
            zn6.j("pagediscover_feeds_likebutton", "click", map);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, 1);
                jSONObject.put("type", z ? 2 : 1);
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M241", "1", null, jSONObject.toString());
            if (z) {
                Long l = new Long(0L);
                Feed feed = MomentsBaseViewHolder.this.w;
                if (feed != null) {
                    Iterator<Comment> it2 = feed.likes.iterator();
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
                MomentsBaseViewHolder momentsBaseViewHolder = MomentsBaseViewHolder.this;
                momentsBaseViewHolder.x.h(momentsBaseViewHolder.v, MomentsBaseViewHolder.this.w, l);
            } else {
                MomentsBaseViewHolder momentsBaseViewHolder2 = MomentsBaseViewHolder.this;
                momentsBaseViewHolder2.x.c(momentsBaseViewHolder2.v, MomentsBaseViewHolder.this.w);
            }
            MomentsBaseViewHolder.this.o.setImageResource(z ? R$drawable.icon_praise_selected : R$drawable.icon_praise_none);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.i(MomentsBaseViewHolder.H, "onCommentClickListener");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(az.at, 1);
                jSONObject.put("type", 1);
            } catch (Exception unused) {
            }
            LogUtil.uploadInfoImmediate("M242", "1", null, jSONObject.toString());
            if (view == MomentsBaseViewHolder.this.q) {
                HashMap map = new HashMap();
                map.put("from", Integer.valueOf(MomentsBaseViewHolder.this.A));
                map.put("targetUid", MomentsBaseViewHolder.this.w.getUid());
                map.put("feedType", Integer.valueOf(MomentsBaseViewHolder.this.w.getFeedType()));
                map.put("feedid", MomentsBaseViewHolder.this.w.getFeedId());
                zn6.j("feedcomment", "click", map);
            }
            if (view == MomentsBaseViewHolder.this.t) {
                HashMap map2 = new HashMap();
                map2.put("from", Integer.valueOf(MomentsBaseViewHolder.this.A));
                map2.put("targetUid", MomentsBaseViewHolder.this.w.getUid());
                map2.put("feedType", Integer.valueOf(MomentsBaseViewHolder.this.w.getFeedType()));
                map2.put("feedid", MomentsBaseViewHolder.this.w.getFeedId());
                zn6.j("feedcomment_show", "click", map2);
            }
            MomentsBaseViewHolder momentsBaseViewHolder = MomentsBaseViewHolder.this;
            momentsBaseViewHolder.x.g(momentsBaseViewHolder.itemView, momentsBaseViewHolder.v, MomentsBaseViewHolder.this.w.getFeedId().longValue(), null);
        }
    }

    public MomentsBaseViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        this.B = new d();
        this.C = new e();
        this.E = new f();
        this.F = new g();
        this.G = new h();
        this.z = context;
        z(this.itemView);
        SocialPortraitView socialPortraitView = (SocialPortraitView) u(this.f, R$id.avatar);
        this.f = socialPortraitView;
        socialPortraitView.changeShapeType(3);
        SocialPortraitView socialPortraitView2 = (SocialPortraitView) u(this.g, R$id.gender);
        this.g = socialPortraitView2;
        socialPortraitView2.changeShapeType(3);
        this.h = (TextView) u(this.h, R$id.nick);
        this.i = (TextView) u(this.i, R$id.tv_official);
        this.j = (ImageView) u(this.j, R$id.iv_vip);
        this.k = (TextView) u(this.k, R$id.time);
        this.m = (TextView) u(this.m, R$id.delete);
        this.s = (TextView) u(this.s, R$id.source);
        ClickShowMoreLayout clickShowMoreLayout = (ClickShowMoreLayout) u(this.l, R$id.item_text_field);
        this.l = clickShowMoreLayout;
        if (clickShowMoreLayout != null) {
            clickShowMoreLayout.setOnStateKeyGenerateListener(new a());
        }
        this.n = l(R$id.praise);
        this.o = (ImageView) l(R$id.praise_icon);
        this.p = (TextView) l(R$id.praise_count);
        this.q = l(R$id.comment);
        this.r = (TextView) l(R$id.comment_count);
        CommentContentsLayout commentContentsLayout = (CommentContentsLayout) u(this.t, R$id.comment_layout);
        this.t = commentContentsLayout;
        commentContentsLayout.setOnClickListener(this.G);
        this.u = (LinearLayout) u(this.u, R$id.content);
    }

    private void D() {
        boolean z;
        if (this.w.getLikesList() != null) {
            Iterator<Comment> it = this.w.getLikesList().iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getFromUid(), v4.e(com.zenmen.palmchat.c.b()))) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        this.p.setText(Feed.getPraiseCountShow(this.w.getLikeNum()));
        this.o.setImageResource(z ? R$drawable.icon_praise_selected : R$drawable.icon_praise_none);
        this.r.setText(Feed.getCommentCountShow(this.w.commentNum));
    }

    public void A(MomentsBaseAdapter momentsBaseAdapter) {
        this.y = momentsBaseAdapter;
    }

    public void B(int i) {
        this.A = i;
    }

    public void C(lq3 lq3Var) {
        this.x = lq3Var;
    }

    public void t() {
        this.itemView.setOnClickListener(new b());
        this.l.setTextClickListener(new c());
    }

    public final View u(View view, int i) {
        View view2;
        return (i <= 0 || (view2 = this.itemView) == null || view != null) ? view : view2.findViewById(i);
    }

    public void v() {
        if (l50.a()) {
            return;
        }
        Context context = this.z;
        Feed feed = this.w;
        ei4.d(context, feed, feed.getFeedId(), this.w.getUid(), null, -1, this.w.getFeedType());
        HashMap map = new HashMap();
        map.put("from", Integer.valueOf(this.A));
        map.put("feedid", this.w.getFeedId());
        map.put("feedType", Integer.valueOf(this.w.getFeedType()));
        map.put(ReportItem.RequestKeyRequestId, this.w.reqId);
        zn6.j("pagediscover_feeds", "click", map);
    }

    @Override // com.zenmen.palmchat.friendcircle.base.view.viewholder.BaseRecyclerViewHolder
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void o(Feed feed, int i) {
        ClickShowMoreLayout clickShowMoreLayout;
        if (feed == null) {
            Log.e(H, "data is null");
            return;
        }
        this.w = feed;
        this.v = i;
        y(feed, i);
        this.m.setOnClickListener(this.E);
        this.f.setOnClickListener(this.C);
        this.h.setOnClickListener(this.C);
        this.n.setOnClickListener(this.F);
        this.q.setOnClickListener(this.G);
        this.j.setOnClickListener(this.B);
        x(feed, i, n());
        Feed feed2 = this.w;
        if (feed2 != null && (clickShowMoreLayout = this.l) != null) {
            clickShowMoreLayout.setFeedId(feed2.getFeedId().longValue());
        }
        Feed feed3 = this.w;
        if (feed3 == null || feed3.getFeedType() == 5) {
            return;
        }
        HashMap map = new HashMap();
        MomentsBaseAdapter momentsBaseAdapter = this.y;
        if (momentsBaseAdapter != null) {
            map.put("sid", momentsBaseAdapter.s());
        }
        map.put("targetUid", this.w.getUid());
        map.put(ReportItem.RequestKeyRequestId, this.w.reqId);
        map.put("feedType", Integer.valueOf(this.w.getFeedType()));
        map.put("pagetype", Integer.valueOf(this.A));
        map.put("feedid", this.w.getFeedId());
        zn6.j("pagediscover", "view", map);
    }

    public void y(Feed feed, int i) {
        ContactInfoItem contactInfoItemA = dn0.a(feed.getUid());
        if (contactInfoItemA != null) {
            gr2.j().h(k86.p(contactInfoItemA.getIconURL()), this.f, hr2.i());
            this.h.setText(contactInfoItemA.getNameForShow());
            this.g.setImageResource(contactInfoItemA.getGender() == 1 ? R$drawable.icon_sex_female : R$drawable.icon_sex_male);
            if (contactInfoItemA.isOfficialAccount()) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
            int iG = fg6.g(contactInfoItemA.getExt());
            if (fg6.q(iG)) {
                this.j.setVisibility(0);
                this.j.setImageResource(fg6.c(iG));
            } else {
                this.j.setVisibility(8);
            }
            if (contactInfoItemA.isOfficialAccount()) {
                this.h.setTextColor(this.z.getResources().getColor(R$color.Gg));
            } else {
                this.h.setTextColor(fg6.n(this.z, iG));
            }
        }
        if (this.l != null) {
            if (kl5.c(feed.getContent())) {
                this.l.setVisibility(0);
                this.l.setText(feed.getContent().trim(), feed.getFeedId().longValue());
            } else {
                this.l.setVisibility(8);
            }
        }
        if (feed.getCreateDt() == null || feed.getFeedSource() == wt1.b) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.setText(cy5.h(feed.getCreateDt().longValue()));
        }
        String str = "";
        if (feed.getSource() != null) {
            String appName = feed.getSource().getAppName();
            if (!TextUtils.isEmpty(appName)) {
                str = "" + appName;
            }
            String name = feed.getSource().getName();
            if (!TextUtils.isEmpty(name)) {
                if (!TextUtils.isEmpty(str)) {
                    str = str + "·";
                }
                str = str + name;
            }
        }
        if (this.s != null) {
            if (TextUtils.isEmpty(str)) {
                this.s.setVisibility(8);
            } else {
                this.s.setVisibility(0);
                this.s.setText(str);
            }
        }
        tf6.a((TextUtils.equals(feed.getUid(), v4.e(com.zenmen.palmchat.c.b())) && feed.getFeedSource() == wt1.f21791a) ? 0 : 8, this.m);
        this.t.setVisibility(this.t.addComments(xh5.a(feed.getShowComments()), true) ? 0 : 8);
        D();
    }

    public void z(@NonNull View view) {
    }

    public void x(@NonNull Feed feed, int i, int i2) {
    }
}
