package com.zenmen.palmchat.contacts.userdetail;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.contacts.userdetail.UserDetailFeedAdapter;
import com.zenmen.palmchat.friendcircle.bean.MomentsDetailEvent;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.square.DynamicExposeHomeActivity;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.MomentsDetailFullActivity;
import com.zenmen.square.bean.SquareDynamicLifeBeanInfo;
import com.zenmen.square.bean.SquareDynamicLifeResponseBean;
import com.zenmen.square.dynamiclife.DynamicSuperExposeV1Config;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.CommonResponse;
import defpackage.an1;
import defpackage.b05;
import defpackage.bj5;
import defpackage.ds0;
import defpackage.ei4;
import defpackage.fi5;
import defpackage.fk2;
import defpackage.g74;
import defpackage.hx3;
import defpackage.js2;
import defpackage.kj1;
import defpackage.l50;
import defpackage.ma3;
import defpackage.n5;
import defpackage.pm5;
import defpackage.q05;
import defpackage.qm5;
import defpackage.tq3;
import defpackage.tw4;
import defpackage.uo2;
import defpackage.xn3;
import defpackage.yy2;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UserDetailActivity f13685a;
    public com.zenmen.palmchat.contacts.e b;
    public View c;
    public TextView d;
    public View e;
    public RecyclerView f;
    public UserDetailFeedAdapter g;
    public View h;
    public View i;
    public TextView j;
    public TextView k;
    public View l;
    public View m;
    public TextView n;
    public View o;
    public TextView p;
    public TextView q;
    public uo2 r;
    public ContactInfoItem s;
    public ImageView v;
    public DynamicSuperExposeV1Config x;
    public boolean t = true;
    public boolean u = false;
    public boolean w = true;

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.userdetail.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1031a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserDetailActivity f13686a;

        public ViewOnClickListenerC1031a(UserDetailActivity userDetailActivity) {
            this.f13686a = userDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            q05.a("postboost_entrance_pageprofil_old", 2, null);
            DynamicExposeHomeActivity.J1(this.f13686a, 601, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements g74<UserDetailFeedAdapter.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserDetailActivity f13687a;

        public b(UserDetailActivity userDetailActivity) {
            this.f13687a = userDetailActivity;
        }

        @Override // defpackage.g74
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, int i, UserDetailFeedAdapter.a aVar) {
            Feed feed;
            int i2;
            if (l50.a()) {
                return;
            }
            if (aVar != null && aVar.f13669a != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    Bundle bundle = new Bundle();
                    bundle.putString("key_feed_uid", aVar.f13669a.uid);
                    if (aVar.f13669a.feedType == 1) {
                        SquareFeed squareFeed = new SquareFeed();
                        SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo = aVar.f13669a;
                        squareFeed.id = squareDynamicLifeBeanInfo.id;
                        squareFeed.feedType = squareDynamicLifeBeanInfo.feedType;
                        squareFeed.uid = squareDynamicLifeBeanInfo.uid;
                        squareFeed.exid = squareDynamicLifeBeanInfo.exid;
                        MediaViewActivity.B1(16, this.f13687a, squareFeed, false);
                        return;
                    }
                    int i3 = 0;
                    for (int i4 = 0; i4 < a.this.g.f().size(); i4++) {
                        SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo2 = a.this.g.f().get(i4).f13669a;
                        if (squareDynamicLifeBeanInfo2 != null && ((i2 = squareDynamicLifeBeanInfo2.feedType) == 2 || i2 == 3)) {
                            SquareFeed squareFeed2 = new SquareFeed();
                            squareFeed2.id = squareDynamicLifeBeanInfo2.id;
                            squareFeed2.uid = squareDynamicLifeBeanInfo2.uid;
                            squareFeed2.exid = squareDynamicLifeBeanInfo2.exid;
                            squareFeed2.version = squareDynamicLifeBeanInfo2.version;
                            squareFeed2.feedType = squareDynamicLifeBeanInfo2.feedType;
                            arrayList.add(squareFeed2);
                            ma3.a("feed.id " + squareFeed2.id, new Object[0]);
                        } else if (i4 < i) {
                            i3++;
                        }
                    }
                    bundle.putInt("key_target_position", i - i3);
                    MediaViewActivity.C1(16, arrayList, this.f13687a, bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (aVar != null && (feed = aVar.b) != null) {
                if (feed.getFeedType() == 2 || feed.getFeedType() == 3) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<UserDetailFeedAdapter.a> it = a.this.g.f().iterator();
                    int size = 0;
                    while (it.hasNext()) {
                        Feed feed2 = it.next().b;
                        if (feed2 != null && (feed2.getFeedType() == 2 || feed2.getFeedType() == 3)) {
                            Feed feed3 = new Feed();
                            feed3.setFeedId(feed2.getFeedId());
                            feed3.setUid(feed2.getUid());
                            feed3.setFeedType(feed2.getFeedType());
                            feed3.setVersion(feed2.getVersion());
                            arrayList2.add(feed3);
                            if (feed2.getFeedId().longValue() == feed.getId()) {
                                size = arrayList2.size() - 1;
                            }
                        }
                    }
                    this.f13687a.startActivity(MomentsDetailFullActivity.B1(this.f13687a, arrayList2, size, "from_publish_comment", 20, null));
                } else if (feed.getFeedType() == 1 || feed.getFeedType() == 6 || feed.getFeedType() == 7 || feed.getFeedType() == 4) {
                    Intent intentC = ei4.c(feed, feed.getFeedId(), feed.getUid(), 1, a.this.s, feed.getFeedType());
                    intentC.putExtra("fromSource", 20);
                    this.f13687a.startActivity(intentC);
                }
            }
            a.this.m(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.t = true;
            a aVar = a.this;
            aVar.q(aVar.s);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            js2.c();
            a.this.k(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserDetailActivity f13691a;

        public f(UserDetailActivity userDetailActivity) {
            this.f13691a = userDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.f13691a, (Class<?>) UserFeedActivity.class);
            intent.putExtra("extra_user", a.this.s);
            intent.putExtra("extra_tab", a.this.u ? 1 : 0);
            this.f13691a.startActivity(intent);
            a.this.m(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends tw4<CommonResponse<SquareDynamicLifeResponseBean>> {
        public g() {
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<SquareDynamicLifeResponseBean> commonResponse) {
            List<SquareDynamicLifeBeanInfo> list = (commonResponse == null || commonResponse.getData() == null || commonResponse.getData().userDailyLifeList == null || commonResponse.getData().userDailyLifeList.isEmpty()) ? null : commonResponse.getData().userDailyLifeList;
            boolean z = (commonResponse == null || commonResponse.getData() == null || !commonResponse.getData().photoTaskShow) ? false : true;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<SquareDynamicLifeBeanInfo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new UserDetailFeedAdapter.a(it.next()));
                }
                a.this.s(arrayList);
                a.this.j(false, true, z);
            } else if (!a.this.s.getIsStranger()) {
                tq3.e().f(a.this.s.getUid(), 0L, a.this.new i(z));
            } else {
                a.this.s(null);
                a.this.j(false, true, z);
            }
            if (commonResponse == null || commonResponse.getData() == null || commonResponse.getData().errorCode != -1003) {
                return;
            }
            a.this.l();
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            a.this.j(true, true, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fi5 f13693a;

        public h(fi5 fi5Var) {
            this.f13693a = fi5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<UserDetailFeedAdapter.a> listF = a.this.g.f();
            for (int i = 0; i < listF.size(); i++) {
                if (listF.get(i).f13669a != null && listF.get(i).f13669a.id == this.f13693a.f17534a.id) {
                    a.this.g.d(i);
                    if (a.this.g.getItemCount() < 1) {
                        a.this.t = true;
                        a aVar = a.this;
                        aVar.q(aVar.s);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13694a;

        public i(boolean z) {
            this.f13694a = z;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            a.this.j(true, false, this.f13694a);
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            List<Feed> list;
            NetResponseData netResponseData;
            if (netResponse == null || netResponse.resultCode != 0 || (netResponseData = netResponse.data) == null || (list = netResponseData.feeds) == null) {
                list = null;
            }
            if (list == null || list.size() <= 0) {
                a.this.s(null);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<Feed> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new UserDetailFeedAdapter.a(it.next()));
                }
                a.this.s(arrayList);
                a.this.u = true;
            }
            a.this.j(false, false, this.f13694a);
        }
    }

    public a(UserDetailActivity userDetailActivity, com.zenmen.palmchat.contacts.e eVar) {
        this.f13685a = userDetailActivity;
        this.b = eVar;
        this.c = userDetailActivity.findViewById(R.id.feed);
        this.d = (TextView) userDetailActivity.findViewById(R.id.feed_title);
        this.e = userDetailActivity.findViewById(R.id.feed_more);
        this.h = userDetailActivity.findViewById(R.id.feed_complete);
        this.k = (TextView) userDetailActivity.findViewById(R.id.feed_complete_other);
        this.i = userDetailActivity.findViewById(R.id.feed_complete_self);
        this.j = (TextView) userDetailActivity.findViewById(R.id.feed_complete_action);
        this.l = userDetailActivity.findViewById(R.id.feed_status);
        this.n = (TextView) userDetailActivity.findViewById(R.id.feed_error);
        this.m = userDetailActivity.findViewById(R.id.feed_loading);
        this.o = userDetailActivity.findViewById(R.id.feed_complete_task);
        this.p = (TextView) userDetailActivity.findViewById(R.id.feed_part1);
        this.q = (TextView) userDetailActivity.findViewById(R.id.feed_part2);
        this.f = (RecyclerView) userDetailActivity.findViewById(R.id.feed_recycler);
        this.v = (ImageView) userDetailActivity.findViewById(R.id.super_expose_v1_enter_image);
        DynamicSuperExposeV1Config dynamicSuperExposeV1ConfigA = kj1.b().a();
        this.x = dynamicSuperExposeV1ConfigA;
        if (dynamicSuperExposeV1ConfigA != null && !TextUtils.isEmpty(dynamicSuperExposeV1ConfigA.pageprofil_old_url)) {
            q05.s(userDetailActivity, this.v, this.x.pageprofil_old_url, R.drawable.icon_dynamic_super_expose_v1_enter_from1_image, R.drawable.icon_dynamic_super_expose_v1_enter_from1_image);
        }
        this.v.setOnClickListener(new ViewOnClickListenerC1031a(userDetailActivity));
        this.f.setLayoutManager(new LinearLayoutManager(userDetailActivity, 0, false));
        this.f.setItemAnimator(null);
        UserDetailFeedAdapter userDetailFeedAdapter = new UserDetailFeedAdapter(userDetailActivity, null);
        this.g = userDetailFeedAdapter;
        userDetailFeedAdapter.n(new b(userDetailActivity));
        this.f.setAdapter(this.g);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("加载失败，点击刷新");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(userDetailActivity.getResources().getColor(R.color.Ga)), 5, 9, 18);
        this.n.setText(spannableStringBuilder);
        this.n.setOnClickListener(new c());
        this.j.setOnClickListener(new d());
        this.q.setOnClickListener(new e());
        this.e.setOnClickListener(new f(userDetailActivity));
        this.r = bj5.b().c();
        l();
        ds0.a().c(this);
        an1.c().p(this);
    }

    public final void i(boolean z) {
        if (this.g.getItemCount() > 0) {
            this.h.setVisibility(8);
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            return;
        }
        this.h.setVisibility(0);
        this.f.setVisibility(8);
        ContactInfoItem contactInfoItem = this.s;
        if (!(contactInfoItem != null && contactInfoItem.getUid().equals(AccountUtils.p(this.f13685a)))) {
            this.i.setVisibility(8);
            this.o.setVisibility(8);
            this.k.setVisibility(0);
        } else {
            if (!js2.m() || !z) {
                this.i.setVisibility(0);
                this.o.setVisibility(8);
                this.k.setVisibility(8);
                return;
            }
            js2.q(this.f13685a);
            this.i.setVisibility(8);
            if (this.o.getVisibility() != 0) {
                js2.d();
            }
            this.o.setVisibility(0);
            this.k.setVisibility(8);
            this.p.setText(js2.k().c);
            this.q.setText(js2.k().d);
        }
    }

    public final void j(boolean z, boolean z2, boolean z3) {
        ContactInfoItem contactInfoItem;
        if (z) {
            this.t = true;
            if (hx3.m(this.f13685a)) {
                Toast.makeText(this.f13685a, "请求数据失败，请稍后重试", 0).show();
            } else {
                UserDetailActivity userDetailActivity = this.f13685a;
                Toast.makeText(userDetailActivity, userDetailActivity.getString(R.string.square_network_error), 0).show();
            }
            this.l.setVisibility(0);
            this.n.setVisibility(0);
            this.h.setVisibility(8);
            this.f.setVisibility(8);
            n(3);
        } else {
            this.l.setVisibility(8);
            this.n.setVisibility(8);
            if (this.g.getItemCount() > 0) {
                n(!z2 ? 1 : 0);
            } else {
                n(2);
            }
            i(z3);
        }
        this.m.setVisibility(8);
        if (!kj1.b().c().booleanValue() || (contactInfoItem = this.s) == null || contactInfoItem.getUid() == null || q05.e() == null || q05.e().getUid() == null || !this.s.getUid().equals(q05.e().getUid())) {
            return;
        }
        RecyclerView recyclerView = this.f;
        if (recyclerView == null || recyclerView.getAdapter() == null || this.f.getAdapter().getItemCount() <= 0 || this.f.getVisibility() != 0) {
            this.v.setVisibility(8);
            return;
        }
        this.v.setVisibility(0);
        if (this.w) {
            return;
        }
        q05.a("postboost_entrance_pageprofil_old", 1, null);
        this.w = true;
    }

    public final void k(boolean z) {
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        bundle.putString("main_tab", "tab_square");
        bundle.putString("square_tab", "recommendTitle");
        if (z) {
            bundle.putInt("from", 59);
        }
        aVar.b(bundle);
        this.f13685a.startActivity(n5.b(this.f13685a, aVar));
    }

    public void l() {
        this.c.setVisibility(8);
    }

    public void m(int i2) {
        HashMap<String, Object> mapL = this.b.l();
        mapL.put("click", Integer.valueOf(i2));
        zn6.j("newpageprofil_dynamicclick", "click", mapL);
    }

    public void n(int i2) {
        HashMap<String, Object> mapL = this.b.l();
        mapL.put("type", Integer.valueOf(i2));
        zn6.j("newpageprofil_dynamicreshow", "view", mapL);
    }

    public final tw4<CommonResponse<SquareDynamicLifeResponseBean>> o() {
        return new g();
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onMomentsFeedEvent(MomentsDetailEvent momentsDetailEvent) {
        UserDetailFeedAdapter userDetailFeedAdapter;
        if (momentsDetailEvent.eventType != 3 || momentsDetailEvent.feedId == null || (userDetailFeedAdapter = this.g) == null) {
            return;
        }
        List<UserDetailFeedAdapter.a> listF = userDetailFeedAdapter.f();
        for (int i2 = 0; i2 < listF.size(); i2++) {
            Feed feed = listF.get(i2).b;
            if (feed != null && momentsDetailEvent.feedId.equals(feed.getFeedId())) {
                this.g.d(i2);
                if (this.g.getItemCount() < 1) {
                    this.t = true;
                    q(this.s);
                    return;
                }
                return;
            }
        }
    }

    @qm5
    public void onSquareDeleteEvent(fi5 fi5Var) {
        RecyclerView recyclerView = this.f;
        if (recyclerView == null || this.g == null || fi5Var.f17534a == null) {
            return;
        }
        recyclerView.post(new h(fi5Var));
    }

    public void p() {
        ds0.a().d(this);
        an1.c().r(this);
    }

    public void q(ContactInfoItem contactInfoItem) {
        this.c.setVisibility(0);
        if (this.r == null || contactInfoItem == null) {
            return;
        }
        if (this.t || contactInfoItem.getFriendType() != this.s.getFriendType()) {
            b05.d("4");
            this.t = false;
            this.s = contactInfoItem;
            this.u = false;
            r();
            this.r.f(contactInfoItem.getUid(), contactInfoItem.getExid(), xn3.a(), 0L, o());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!mLoadTag=");
        sb.append(!this.t);
        b05.d(sb.toString());
        b05.d("contactInfoItem.getFriendType()=" + contactInfoItem.getFriendType());
        b05.d("this.contactInfoItem.getFriendType()=" + this.s.getFriendType());
    }

    public final void r() {
        this.h.setVisibility(8);
        this.l.setVisibility(0);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.e.setVisibility(8);
    }

    public final void s(List<UserDetailFeedAdapter.a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.g.q(list);
    }
}
