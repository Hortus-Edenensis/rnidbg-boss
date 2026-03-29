package com.zenmen.square.frienddetail.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.x.d;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.listui.duration.BaseDurationActivity;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.base.view.adapter.AlbumSingleitemAdapter;
import com.zenmen.palmchat.friendcircle.bean.MomentsDetailEvent;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.ui.widget.commentwidget.CommentWidget;
import com.zenmen.palmchat.ui.widget.pullrecyclerview.StaticRecyclerView;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.ui.CommentListView;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.mvp.model.bean.SquareFeedForChatCard;
import defpackage.a46;
import defpackage.ai5;
import defpackage.an1;
import defpackage.az2;
import defpackage.bj5;
import defpackage.cy5;
import defpackage.dn0;
import defpackage.fg6;
import defpackage.fk2;
import defpackage.gr2;
import defpackage.h05;
import defpackage.hn2;
import defpackage.i74;
import defpackage.is0;
import defpackage.j9;
import defpackage.k86;
import defpackage.l50;
import defpackage.n5;
import defpackage.py5;
import defpackage.qj5;
import defpackage.rq3;
import defpackage.sy5;
import defpackage.tq3;
import defpackage.v4;
import defpackage.xt1;
import defpackage.yy2;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MomentsDetailHalfActivity extends BaseDurationActivity implements i74, StaticRecyclerView.f, hn2, xt1.a {
    public String A;
    public int E;
    public EffectiveShapeView G;
    public ImageView H;
    public ImageView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public ImageView N;
    public View O;
    public ContactInfoItem P;
    public View Q;
    public CommentListView R;
    public xt1 S;
    public SquareFeed T;
    public rq3 U;
    public int V;
    public py5 W;
    public View X;
    public Toolbar r;
    public RecyclerView s;
    public List<Feed> t;
    public AlbumSingleitemAdapter u;
    public j9 v;
    public long w;
    public int x;
    public Feed y;
    public String z;
    public boolean B = false;
    public int C = -1;
    public boolean F = false;
    public FeedNetDao.FeedNetListener Y = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FeedNetDao.FeedNetListener {
        public a() {
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            MomentsDetailHalfActivity.this.H1();
            Log.d("MomentsSIActivity", "FeedNetListener onFail,  error is " + exc);
            MomentsDetailHalfActivity.this.P1("");
            if (MomentsDetailHalfActivity.this.y == null) {
                MomentsDetailHalfActivity.this.finish();
            }
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            MomentsDetailHalfActivity.this.H1();
            Log.d("MomentsSIActivity", "FeedNetListener onSuccess");
            if (netResponse == null) {
                Log.d("MomentsSIActivity", "NetResponse is null");
                MomentsDetailHalfActivity.this.P1("");
                if (MomentsDetailHalfActivity.this.y == null) {
                    MomentsDetailHalfActivity.this.finish();
                    return;
                }
                return;
            }
            int i = netResponse.resultCode;
            if (i == 0) {
                NetResponseData netResponseData = netResponse.data;
                Feed feed = new Feed(Long.valueOf(netResponseData.feedId), Long.valueOf(netResponseData.clientId), netResponseData.uid, Long.valueOf(netResponseData.createDt), netResponseData.content, netResponseData.feedType, netResponseData.privateStatus, netResponseData.status, netResponseData.cover, Long.valueOf(netResponseData.version), Integer.valueOf(netResponseData.feedSource), netResponseData.location, netResponseData.mediaList);
                feed.setSource(netResponseData.source);
                feed.setCommentList(netResponseData.comments);
                feed.setLikesList(netResponseData.likes);
                feed.setShowComments(netResponseData.showComments);
                feed.commentNum = netResponseData.commentNum;
                MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
                momentsDetailEvent.eventType = 2;
                momentsDetailEvent.feed = feed;
                an1.c().l(momentsDetailEvent);
                MomentsDetailHalfActivity.this.y = feed;
                MomentsDetailHalfActivity.this.R1();
                return;
            }
            if (i != 1901) {
                MomentsDetailHalfActivity.this.P1(netResponse.errorMsg);
                if (MomentsDetailHalfActivity.this.y == null) {
                    MomentsDetailHalfActivity.this.finish();
                    return;
                }
                return;
            }
            MomentsDetailEvent momentsDetailEvent2 = new MomentsDetailEvent();
            momentsDetailEvent2.eventType = 3;
            momentsDetailEvent2.feedId = Long.valueOf(MomentsDetailHalfActivity.this.w);
            an1.c().l(momentsDetailEvent2);
            if (TextUtils.isEmpty(netResponse.errorMsg)) {
                MomentsDetailHalfActivity.this.P1("动态已删除");
            } else {
                MomentsDetailHalfActivity.this.P1(netResponse.errorMsg);
            }
            MomentsDetailHalfActivity.this.finish();
            Log.d("MomentsSIActivity", "NetResponse is Error, resultCode is " + netResponse.resultCode);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements is0.f {
        public b() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i != 0) {
                return;
            }
            j9 j9Var = MomentsDetailHalfActivity.this.v;
            MomentsDetailHalfActivity momentsDetailHalfActivity = MomentsDetailHalfActivity.this;
            j9Var.c(momentsDetailHalfActivity, momentsDetailHalfActivity.y);
        }
    }

    @Override // defpackage.hn2
    public void C(@Nullable View view, int i, long j, CommentWidget commentWidget) throws Throwable {
        this.U.S();
    }

    public final void H1() {
        this.X.setVisibility(8);
    }

    public final void I1() {
        if (this.P == null) {
            this.P = dn0.a(this.y.getUid());
        }
        SquareFeed squareFeedConvertToSquareFeed = SquareFeed.convertToSquareFeed(this.y, this.P);
        this.T = squareFeedConvertToSquareFeed;
        rq3 rq3Var = new rq3(this, squareFeedConvertToSquareFeed);
        this.U = rq3Var;
        rq3Var.F(this.O);
        this.U.P(new ResultBean(), 0, 4);
    }

    public final void J1() {
        this.t = new ArrayList();
        if (this.y == null) {
            Q1();
        }
        tq3.e().d(this.w, this.Y, this.z);
        j9 j9Var = new j9(this, this);
        this.v = j9Var;
        AlbumSingleitemAdapter albumSingleitemAdapter = new AlbumSingleitemAdapter(this, this.t, j9Var, this.B, this.P, this.E);
        this.u = albumSingleitemAdapter;
        this.s.setAdapter(albumSingleitemAdapter);
        h05.i(this.y);
    }

    public final void K1() {
        this.r = initToolbar(R$id.toolbar, "", false);
    }

    public final void L1() {
        this.R = (CommentListView) findViewById(com.zenmen.square.R$id.commentList);
        this.N = (ImageView) findViewById(com.zenmen.square.R$id.btn_more);
        this.M = (TextView) findViewById(com.zenmen.square.R$id.btn_chat);
        this.Q = findViewById(com.zenmen.square.R$id.feed_detail_title_bar);
        this.G = (EffectiveShapeView) findViewById(com.zenmen.square.R$id.img_feed_detail_avatar);
        this.H = (ImageView) findViewById(com.zenmen.square.R$id.sex_iv);
        this.J = (TextView) findViewById(com.zenmen.square.R$id.nick_name);
        this.K = (TextView) findViewById(com.zenmen.square.R$id.tv_official);
        this.I = (ImageView) findViewById(com.zenmen.square.R$id.iv_vip);
        this.L = (TextView) findViewById(R$id.create_time);
        this.X = findViewById(com.zenmen.square.R$id.mask);
        RecyclerView recyclerView = (RecyclerView) findViewById(com.zenmen.square.R$id.recycler);
        this.s = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.s.setLayoutManager(new LinearLayoutManager(this, 1, false));
    }

    public final void M1(ContactInfoItem contactInfoItem) {
        if (contactInfoItem == null) {
            return;
        }
        String strC = az2.c(SquareFeedForChatCard.parse(this.T));
        HashMap map = new HashMap();
        if (contactInfoItem.getIsStranger()) {
            map.put("relationtype", 0);
            qj5.h0(this.T, map);
            bj5.b().a().r(this, contactInfoItem, strC);
        } else {
            map.put("relationtype", 1);
            qj5.h0(this.T, map);
            bj5.b().a().B(this, contactInfoItem, strC);
        }
    }

    public boolean N1(SquareFeed squareFeed, Feed feed) {
        if (feed == null || squareFeed.id != feed.getId()) {
            return false;
        }
        feed.commentNum = squareFeed.discussionNum;
        return true;
    }

    public final void O1() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.x = intent.getIntExtra("feed_type", 0);
        Feed feed = (Feed) intent.getParcelableExtra("extra_feed");
        this.y = feed;
        if (feed != null) {
            this.w = feed.getFeedId().longValue();
            this.z = this.y.getUid();
        } else {
            this.w = intent.getLongExtra("extra_feed_id", -1L);
            this.z = intent.getStringExtra("extra_feed_uid");
        }
        this.A = intent.getStringExtra("extra_operator_id");
        this.B = dn0.d(this.z);
        ContactInfoItem contactInfoItem = (ContactInfoItem) intent.getParcelableExtra("user_detail_contact_info");
        this.P = contactInfoItem;
        if (contactInfoItem == null) {
            this.P = dn0.a(this.z);
        } else {
            this.z = contactInfoItem.getUid();
        }
        this.C = intent.getIntExtra("extra_from", -1);
        this.V = intent.getIntExtra("fromSource", -1);
        int i = this.C;
        if (i == 1) {
            this.E = 2;
        } else if (i == 0) {
            this.E = 1;
        } else {
            this.E = 4;
        }
        this.F = intent.getBooleanExtra("float_view_show", false);
    }

    public final void P1(String str) {
        if (TextUtils.isEmpty(str)) {
            this.W.d(this, "网络异常，请稍后再试", 0);
        } else {
            this.W.d(this, str, 0);
        }
    }

    public final void Q1() {
        this.X.setVisibility(0);
    }

    public final void R1() {
        if (this.y == null) {
            return;
        }
        this.t.clear();
        this.t.add(this.y);
        this.u.q(this.t);
        S1(this.y);
        I1();
    }

    public final void S1(Feed feed) {
        if (TextUtils.equals(feed.getUid(), v4.e(c.b()))) {
            this.M.setVisibility(4);
            this.N.setVisibility(0);
        } else {
            ContactInfoItem contactInfoItem = this.P;
            this.M.setText(contactInfoItem != null && !contactInfoItem.getIsStranger() ? getString(R$string.square_btn_go_normal_chat) : ai5.k().g().getSquareChatText(this));
            this.M.setVisibility(0);
            this.N.setVisibility(4);
        }
        if (this.P != null) {
            this.L.setVisibility(0);
            this.L.setText(cy5.h(feed.getCreateDt().longValue()));
            this.G.setBorderColor(Color.parseColor("#ffffff"));
            gr2.j().h(k86.p(this.P.getIconURL()), this.G, a46.l());
            this.J.setVisibility(0);
            this.J.setText("" + this.P.getNameForShow());
            if (this.P.getGender() == 1) {
                this.H.setImageResource(R$drawable.icon_sex_female);
            } else {
                this.H.setImageResource(R$drawable.icon_sex_male);
            }
            int iG = fg6.g(this.P.getExt());
            if (fg6.q(iG)) {
                this.I.setImageResource(fg6.e(iG));
                this.I.setVisibility(0);
            } else {
                this.I.setVisibility(8);
            }
            if (this.P.isOfficialAccount()) {
                this.K.setVisibility(0);
                this.J.setTextColor(getResources().getColor(R$color.Gg));
            } else {
                this.K.setVisibility(8);
                this.J.setTextColor(fg6.n(this, iG));
            }
        }
        HashMap map = new HashMap();
        map.put("report_type", "view");
        if (feed.getFeedType() == 1) {
            zn6.h("pagediscover_wordspagedetail", "view", map);
            return;
        }
        if (feed.getFeedType() == 6) {
            zn6.h("pagediscover_vediopagedetail", "view", map);
        } else if (feed.getFeedType() == 7) {
            zn6.h("pagediscover_applicationpagedetail", "view", map);
        } else if (feed.getFeedType() == 4) {
            zn6.h("pagediscover_linkpagedetail", "view", map);
        }
    }

    @Override // defpackage.hn2
    public void U(int i, List<Comment> list) {
        Feed feedE = this.u.e(i);
        if (feedE != null) {
            feedE.setLikesList(list);
            this.u.notifyItemChanged(i, "like");
            MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
            momentsDetailEvent.eventType = 2;
            momentsDetailEvent.feed = feedE;
            an1.c().l(momentsDetailEvent);
        }
    }

    @Override // com.zenmen.palmchat.ui.widget.pullrecyclerview.StaticRecyclerView.f
    public boolean Y(MotionEvent motionEvent) {
        return false;
    }

    @Override // xt1.a
    public void Y0(SquareFeedEvent squareFeedEvent) {
        if (this.y != null && squareFeedEvent.eventType == 2) {
            Feed feedE = this.u.e(0);
            if (N1(squareFeedEvent.feed, feedE) && feedE != null) {
                this.u.notifyItemChanged(0);
            }
        }
    }

    @Override // defpackage.i74
    public void a() {
        Log.d("MomentsSIActivity", "onLoadMore");
    }

    @Override // defpackage.hn2
    public void d0(@NonNull Feed feed) {
        if (feed != null) {
            MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
            momentsDetailEvent.eventType = 3;
            momentsDetailEvent.feedId = feed.getFeedId();
            an1.c().l(momentsDetailEvent);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(az.at, 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("M41", null, jSONObject.toString());
        int iIndexOf = this.u.f().indexOf(feed);
        if (iIndexOf < 0) {
            return;
        }
        this.u.d(iIndexOf);
        finish();
    }

    @Override // defpackage.i74
    public void g(int i) {
        Log.d("MomentsSIActivity", d.p);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 603;
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity
    public int o() {
        int i = this.x;
        if (i == 1) {
            return 21;
        }
        if (i == 4) {
            return 24;
        }
        if (i == 6) {
            return 22;
        }
        if (i == 7) {
            return 23;
        }
        return i;
    }

    public void onArrowPress(View view) {
        finish();
    }

    public void onAvatarClick(View view) {
        if (this.y == null) {
            return;
        }
        if (this.V == 20) {
            finish();
            return;
        }
        fk2.a aVar = new fk2.a();
        Bundle bundle = new Bundle();
        bundle.putString(DeviceInfoUtil.UID_TAG, this.y.getUid());
        aVar.b(bundle);
        startActivity(n5.a(this, aVar));
    }

    public void onChatBtnClick(View view) {
        Feed feed = this.y;
        if (feed == null) {
            return;
        }
        ContactInfoItem contactInfoItem = this.P;
        if (contactInfoItem != null) {
            M1(contactInfoItem);
            return;
        }
        ContactInfoItem contactInfoItemA = dn0.a(feed.getUid());
        this.P = contactInfoItemA;
        if (contactInfoItemA != null) {
            M1(contactInfoItemA);
        } else {
            sy5.f(this, getString(R$string.get_user_info_failed), 0).g();
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        O1();
        super.onCreate(bundle);
        this.W = py5.b();
        if (this.P == null) {
            P1("非好友暂无法操作");
            finish();
            return;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.layout_moments_detail_half, (ViewGroup) null);
        this.O = viewInflate;
        setContentView(viewInflate);
        L1();
        K1();
        J1();
        R1();
        this.S = new xt1(this);
        an1.c().p(this.S);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.S != null) {
            an1.c().r(this.S);
        }
        super.onDestroy();
    }

    public void onMoreBtnClick(View view) {
        if (this.y == null || l50.a()) {
            return;
        }
        showPopupMenu(this, this.Q, new String[]{getResources().getString(R$string.delete)}, new int[]{R$drawable.ic_square_media_view_delete}, new b(), null);
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AlbumSingleitemAdapter albumSingleitemAdapter = this.u;
        if (albumSingleitemAdapter != null) {
            albumSingleitemAdapter.q(this.t);
        }
    }
}
