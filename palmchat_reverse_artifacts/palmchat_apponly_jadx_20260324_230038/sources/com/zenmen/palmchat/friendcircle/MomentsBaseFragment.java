package com.zenmen.palmchat.friendcircle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.beizi.fusion.widget.ScrollClickView;
import com.huawei.openalliance.ad.constant.az;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.listui.duration.BaseDurationFragment;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.a;
import com.zenmen.palmchat.friendcircle.base.view.adapter.MomentsBaseAdapter;
import com.zenmen.palmchat.friendcircle.bean.MomentsDetailEvent;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.ui.widget.commentwidget.CommentWidget;
import com.zenmen.palmchat.ui.widget.common.ClickShowMoreLayout;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.an1;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.fs3;
import defpackage.hk0;
import defpackage.hn2;
import defpackage.in2;
import defpackage.k86;
import defpackage.lq3;
import defpackage.mq3;
import defpackage.nq3;
import defpackage.oq3;
import defpackage.pm5;
import defpackage.q46;
import defpackage.qf6;
import defpackage.qm5;
import defpackage.r46;
import defpackage.r75;
import defpackage.ru3;
import defpackage.sq3;
import defpackage.st1;
import defpackage.sy5;
import defpackage.tq3;
import defpackage.u6;
import defpackage.vq3;
import defpackage.w50;
import defpackage.xn3;
import defpackage.ym;
import defpackage.yy2;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MomentsBaseFragment<T extends com.zenmen.palmchat.friendcircle.a> extends BaseDurationFragment implements hn2 {
    public T i;
    public oq3 j;
    public List<Feed> k;
    public MomentsBaseAdapter l;
    public lq3 m;
    public ym n;
    public u6 o;
    public ru3 p;
    public String u;
    public hk0 v;
    public qf6 z;
    public long q = 0;
    public long r = 0;
    public long s = 0;
    public int t = 1;
    public long w = 0;
    public boolean x = false;
    public boolean y = false;
    public r46 A = new b();
    public final BroadcastReceiver B = new c();
    public FeedNetDao.FeedNetListener C = new d();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.InterfaceC1048a {
        public a() {
        }

        @Override // com.zenmen.palmchat.friendcircle.a.InterfaceC1048a
        public void a() {
            LogUtil.i("MomentsBaseFragment", "onLoadMore");
            MomentsBaseFragment.this.u = xn3.a();
            MomentsBaseFragment.this.t++;
            long jG = tq3.e().g(MomentsBaseFragment.this.k);
            long j = MomentsBaseFragment.this.s;
            MomentsBaseFragment momentsBaseFragment = MomentsBaseFragment.this;
            FeedNetDao.getTimeline(momentsBaseFragment.u, momentsBaseFragment.t, momentsBaseFragment.A0(), jG, MomentsBaseFragment.this.w, j, null, MomentsBaseFragment.this.C);
            MomentsBaseFragment.this.r = Calendar.getInstance().getTimeInMillis();
        }

        @Override // com.zenmen.palmchat.friendcircle.a.InterfaceC1048a
        public void g(int i) {
            LogUtil.i("MomentsBaseFragment", com.alipay.sdk.m.x.d.p);
            MomentsBaseFragment.this.u = xn3.a();
            MomentsBaseFragment momentsBaseFragment = MomentsBaseFragment.this;
            momentsBaseFragment.t = 1;
            long jH = r75.h(momentsBaseFragment.getContext(), k86.a("sp_moments_refresh_time"));
            MomentsBaseFragment momentsBaseFragment2 = MomentsBaseFragment.this;
            String str = momentsBaseFragment2.u;
            int i2 = momentsBaseFragment2.t;
            String strA0 = momentsBaseFragment2.A0();
            MomentsBaseFragment momentsBaseFragment3 = MomentsBaseFragment.this;
            FeedNetDao.getTimeline(str, i2, strA0, 0L, jH, 0L, null, new h(momentsBaseFragment3.u, i));
            MomentsBaseFragment.this.q = Calendar.getInstance().getTimeInMillis();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements r46 {
        public b() {
        }

        @Override // defpackage.r46
        public void a(q46 q46Var) {
            if (q46Var != null) {
                LogUtil.d("logmoments", "onInfoGot: count = " + q46Var.a());
                ContactInfoItem contactInfoItemA = dn0.a(q46Var.c());
                if (contactInfoItemA == null) {
                    MomentsBaseFragment.this.i.a(null, q46Var.a());
                } else {
                    MomentsBaseFragment.this.i.a(contactInfoItemA.getIconURL(), q46Var.a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                intent.getAction();
                intent.getStringExtra("pageIndex");
            }
            sq3.o().s(MomentsBaseFragment.this.A);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements FeedNetDao.FeedNetListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "pull_feed");
                put("status", "up");
                put(com.umeng.analytics.pro.f.p, Long.valueOf(MomentsBaseFragment.this.r));
                put(com.umeng.analytics.pro.f.q, Long.valueOf(Calendar.getInstance().getTimeInMillis()));
                put(ActionUtils.IS_SUCCESS, Boolean.TRUE);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "pull_feed");
                put("status", "up");
                put(com.umeng.analytics.pro.f.p, Long.valueOf(MomentsBaseFragment.this.q));
                put(com.umeng.analytics.pro.f.q, Long.valueOf(Calendar.getInstance().getTimeInMillis()));
                put(ActionUtils.IS_SUCCESS, Boolean.FALSE);
            }
        }

        public d() {
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            LogUtil.i("MomentsBaseFragment", "FeedNetListener onFail,  error is " + exc);
            LogUtil.i("MomentsBaseFragment", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(), (Throwable) null);
            MomentsBaseFragment.this.i.h(false, true);
            MomentsBaseFragment.this.x0();
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            List<Feed> list;
            boolean z = false;
            boolean z2 = true;
            if (netResponse == null) {
                LogUtil.i("MomentsBaseFragment", "NetResponse is null");
            } else if (netResponse.resultCode == 0) {
                LogUtil.i("MomentsBaseFragment", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(), (Throwable) null);
                NetResponseData netResponseData = netResponse.data;
                if (netResponseData != null && (list = netResponseData.feeds) != null && list.size() > 0) {
                    z = true;
                }
                if (netResponseData != null) {
                    List<Feed> list2 = netResponseData.feeds;
                    if (list2 != null) {
                        Iterator<Feed> it = list2.iterator();
                        while (it.hasNext()) {
                            Feed next = it.next();
                            if (next.getStatus() == tq3.f) {
                                it.remove();
                            } else {
                                next.reqId = MomentsBaseFragment.this.u;
                            }
                        }
                    }
                    MomentsBaseFragment.this.s = netResponseData.tipVersion;
                    if (MomentsBaseFragment.this.k.size() > 0 && ((Feed) MomentsBaseFragment.this.k.get(MomentsBaseFragment.this.k.size() - 1)).getFeedType() == 201) {
                        MomentsBaseFragment.this.k.remove(MomentsBaseFragment.this.k.size() - 1);
                        MomentsBaseFragment.this.l.d(MomentsBaseFragment.this.l.getItemCount() - 1);
                    }
                    List<Feed> listG = st1.f().g(MomentsBaseFragment.this.k, netResponseData.feeds);
                    if (!z) {
                        Feed feed = new Feed();
                        feed.setFeedType(201);
                        listG.add(feed);
                    }
                    MomentsBaseFragment.this.k.addAll(listG);
                    MomentsBaseFragment.this.l.c(listG);
                    if (vq3.m()) {
                        vq3.e(MomentsBaseFragment.this.getActivity());
                    } else {
                        w50.d(MomentsBaseFragment.this.getActivity());
                    }
                } else {
                    LogUtil.i("MomentsBaseFragment", "NetResponse data is null");
                }
                z2 = z;
                z = true;
            } else {
                LogUtil.i("MomentsBaseFragment", "NetResponse is Error, resultCode is " + netResponse.resultCode);
            }
            MomentsBaseFragment.this.i.h(z, z2);
            MomentsBaseFragment.this.x0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements nq3.b {
        public e() {
        }

        @Override // nq3.b
        public void a(int i, Object obj, int i2) {
            if (i == 1) {
                sy5.e(MomentsBaseFragment.this.getContext(), R$string.square_comment_send_success, 1).g();
                return;
            }
            if (i == 2 && (obj instanceof in2)) {
                in2 in2Var = (in2) obj;
                if (!TextUtils.isEmpty(in2Var.getErrorMsg())) {
                    sy5.f(MomentsBaseFragment.this.getContext(), in2Var.getErrorMsg(), 1).g();
                    return;
                }
                if (in2Var.getCode() != 1901 && in2Var.getCode() != 1911) {
                    sy5.e(MomentsBaseFragment.this.getContext(), R$string.square_http_error, 1).g();
                } else if (in2Var.getCode() == 1911) {
                    sy5.e(MomentsBaseFragment.this.getContext(), R$string.feed_comment_delete_error, 1).g();
                } else {
                    sy5.e(MomentsBaseFragment.this.getContext(), R$string.feed_content_delete_error, 1).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MomentsBaseFragment.this.z.g(MomentsBaseFragment.this.i.c());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ mq3 f13992a;

        public g(mq3 mq3Var) {
            this.f13992a = mq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MomentsBaseFragment.this.l == null || this.f13992a.f19293a == MomentsBaseFragment.this.l.r()) {
                return;
            }
            MomentsBaseFragment.this.l.w(this.f13992a.f19293a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements FeedNetDao.FeedNetListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13993a;
        public String b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("action", "pull_feed");
                put("status", ScrollClickView.DIR_DOWN);
                put(com.umeng.analytics.pro.f.p, Long.valueOf(MomentsBaseFragment.this.q));
                put(com.umeng.analytics.pro.f.q, Long.valueOf(Calendar.getInstance().getTimeInMillis()));
                put(ActionUtils.IS_SUCCESS, Boolean.TRUE);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "pull_feed");
                put("status", ScrollClickView.DIR_DOWN);
                put(com.umeng.analytics.pro.f.p, Long.valueOf(MomentsBaseFragment.this.q));
                put(com.umeng.analytics.pro.f.q, Long.valueOf(Calendar.getInstance().getTimeInMillis()));
                put(ActionUtils.IS_SUCCESS, Boolean.FALSE);
            }
        }

        public h(String str, int i) {
            this.f13993a = i;
            this.b = str;
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            LogUtil.i("MomentsBaseFragment", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(), (Throwable) null);
            MomentsBaseFragment.this.i.i(false);
            MomentsBaseFragment.this.x0();
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            w50.F();
            vq3.s();
            boolean z = false;
            if (netResponse == null) {
                LogUtil.i("MomentsBaseFragment", "NetResponse is null");
            } else if (netResponse.resultCode == 0) {
                LogUtil.i("MomentsBaseFragment", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(), (Throwable) null);
                NetResponseData netResponseData = netResponse.data;
                MomentsBaseFragment.this.L0(yy2Var);
                if (netResponseData != null) {
                    List<Feed> list = netResponseData.feeds;
                    if (list != null) {
                        Iterator<Feed> it = list.iterator();
                        while (it.hasNext()) {
                            Feed next = it.next();
                            if (next.getStatus() == tq3.f) {
                                it.remove();
                            } else {
                                next.reqId = this.b;
                            }
                        }
                    }
                    MomentsBaseFragment.this.j.e(netResponseData.feeds);
                    MomentsBaseFragment.this.s = netResponseData.tipVersion;
                    ArrayList arrayList = new ArrayList();
                    for (Feed feed : MomentsBaseFragment.this.l.f()) {
                        if (feed.getFeedType() > 100 && feed.getFeedType() < 200) {
                            arrayList.add(feed);
                        }
                    }
                    MomentsBaseFragment.this.k = st1.f().g(null, netResponseData.feeds);
                    MomentsBaseFragment.this.k.addAll(0, arrayList);
                    MomentsBaseFragment.this.l.q(MomentsBaseFragment.this.k);
                    if (MomentsBaseFragment.this.x) {
                        sq3.o().H(MomentsBaseFragment.this.getContext());
                    }
                    if (this.f13993a != 1) {
                        MomentsBaseFragment.this.y = true;
                    }
                    if (this.f13993a == 2) {
                        r75.q(com.zenmen.palmchat.c.b(), k86.a("sp_moments_click_time"), System.currentTimeMillis());
                        if (vq3.m()) {
                            vq3.e(MomentsBaseFragment.this.getActivity());
                        } else {
                            w50.d(MomentsBaseFragment.this.getActivity());
                        }
                    }
                } else {
                    LogUtil.i("MomentsBaseFragment", "NetResponse data is null");
                }
                z = true;
            } else {
                MomentsBaseFragment.this.l.q(MomentsBaseFragment.this.k);
                LogUtil.i("MomentsBaseFragment", "NetResponse is Error, resultCode is " + netResponse.resultCode);
            }
            MomentsBaseFragment.this.i.i(z);
            MomentsBaseFragment.this.x0();
        }
    }

    public abstract String A0();

    public final void B0() {
        this.k = new ArrayList();
        this.m = new lq3(this, getContext());
        MomentsBaseAdapter momentsBaseAdapter = new MomentsBaseAdapter(getActivity(), this.k, this.m, o());
        this.l = momentsBaseAdapter;
        momentsBaseAdapter.setHasStableIds(true);
        this.l.x(getSid());
        this.l.w(st1.f().l());
        this.i.k(this.l);
        ym ymVar = new ym(this.i.c());
        this.n = ymVar;
        ymVar.n(false);
        u6 u6Var = new u6(this.i.c());
        this.o = u6Var;
        u6Var.n(false);
        ru3 ru3Var = new ru3(this.i.c());
        this.p = ru3Var;
        ru3Var.l(false);
    }

    @Override // defpackage.hn2
    public void C(@Nullable View view, int i, long j, CommentWidget commentWidget) {
        Feed feedE = this.l.e(i);
        if (feedE == null) {
            return;
        }
        if (feedE.commentNum == 0) {
            K0(feedE);
        } else {
            nq3.a().f(getContext(), feedE, o(), 0);
        }
    }

    public final void C0() {
        this.w = r75.h(getContext(), k86.a("sp_moments_refresh_time"));
    }

    public final void E0() {
        qf6 qf6Var = new qf6();
        this.z = qf6Var;
        qf6Var.i(this.i.c());
    }

    public final void G0() {
        LogUtil.d("logmoments", "loadLocalFeeds: begin");
        List<Feed> listD = this.j.d();
        if (listD == null || listD.size() <= 0) {
            LogUtil.d("logmoments", "loadLocalFeeds: end, size=0");
        } else {
            LogUtil.d("logmoments", "loadLocalFeeds: end, size=" + listD.size());
            this.k = listD;
            this.l.q(listD);
            x0();
            this.s = tq3.e().i(this.k);
        }
        T t = this.i;
        List<Feed> list = this.k;
        t.g(list != null && list.size() > 0);
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void I() {
        super.I();
        G0();
        I0();
    }

    public void I0() {
        LogUtil.i("MomentsBaseFragment", "preload");
        String strA = xn3.a();
        this.u = strA;
        this.t = 1;
        FeedNetDao.getTimeline(strA, 1, A0(), 0L, 0L, 0L, 1, new h(this.u, 1));
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        View view;
        super.K(z);
        LogUtil.i("MomentsBaseFragment", "onUserVisibleChange" + z + " " + this.h);
        boolean z2 = z && this.h;
        if (z2 && this.z != null && (view = this.i.c) != null) {
            view.postDelayed(new f(), 200L);
        }
        ym ymVar = this.n;
        if (ymVar != null) {
            ymVar.n(z2);
        }
        u6 u6Var = this.o;
        if (u6Var != null) {
            u6Var.n(z2);
        }
        ru3 ru3Var = this.p;
        if (ru3Var != null) {
            ru3Var.l(z2);
        }
    }

    public final void K0(Feed feed) {
        nq3.a().g(getActivity(), feed, o(), 0, new e());
    }

    public final void L0(yy2 yy2Var) {
        JSONObject jSONObject = yy2Var.d;
        JSONObject jSONObjectOptJSONObject = jSONObject != null ? jSONObject.optJSONObject("nearbyBanner") : null;
        if (jSONObjectOptJSONObject == null) {
            this.i.m(false, null, null, null);
            return;
        }
        jSONObjectOptJSONObject.optString(EventParams.KEY_CT_SDK_POSITION);
        String strOptString = jSONObjectOptJSONObject.optString("label");
        String strOptString2 = jSONObjectOptJSONObject.optString("content");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("data");
        String[] strArr = new String[3];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                strArr[i] = jSONArrayOptJSONArray.getString(i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.i.m(true, strOptString, strOptString2, strArr);
    }

    @Override // defpackage.hn2
    public void U(int i, List<Comment> list) {
        Feed feedE = this.l.e(i);
        if (feedE != null) {
            feedE.setLikesList(list);
            this.l.notifyItemChanged(i);
        }
    }

    @Override // defpackage.hn2
    public void d0(Feed feed) {
        int iIndexOf = this.l.f().indexOf(feed);
        if (iIndexOf < 0) {
            return;
        }
        this.l.d(iIndexOf);
        this.k.remove(feed);
        this.i.e();
        x0();
        if (feed != null) {
            MomentsDetailEvent momentsDetailEvent = new MomentsDetailEvent();
            momentsDetailEvent.eventType = 3;
            momentsDetailEvent.feedId = feed.getFeedId();
            an1.c().l(momentsDetailEvent);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(az.at, 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("M41", null, jSONObject.toString());
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public void i(boolean z) {
        super.i(z);
        LogUtil.i("MomentsBaseFragment", "onSupperSelect" + z + " " + isResumed());
        ym ymVar = this.n;
        if (ymVar != null) {
            ymVar.n(z && isResumed());
        }
        u6 u6Var = this.o;
        if (u6Var != null) {
            u6Var.n(z && isResumed());
        }
        ru3 ru3Var = this.p;
        if (ru3Var != null) {
            ru3Var.l(z && isResumed());
        }
    }

    @qm5
    public void onAdVisibilityUpdated(mq3 mq3Var) {
        LogUtil.d("MomentsBaseFragment", "onAdVisibilityUpdated event = " + mq3Var.f19293a);
        View view = this.i.c;
        if (view != null) {
            view.post(new g(mq3Var));
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = new oq3();
        this.i = (T) y0(getActivity(), new a());
        this.v = new hk0();
        w50.F();
        vq3.s();
        ds0.a().c(this);
        an1.c().p(this);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewD = this.i.d(layoutInflater);
        E0();
        C0();
        B0();
        fs3.b(5);
        return viewD;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ClickShowMoreLayout.TEXT.clear();
        vq3.f();
        try {
            hk0 hk0Var = this.v;
            if (hk0Var != null) {
                hk0Var.unsubscribe();
                this.v = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.i.f();
        ym ymVar = this.n;
        if (ymVar != null) {
            ymVar.k();
        }
        u6 u6Var = this.o;
        if (u6Var != null) {
            u6Var.k();
        }
        ru3 ru3Var = this.p;
        if (ru3Var != null) {
            ru3Var.i();
        }
        this.l.u();
        ds0.a().d(this);
        an1.c().r(this);
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onMomentsFeedEvent(MomentsDetailEvent momentsDetailEvent) {
        MomentsBaseAdapter momentsBaseAdapter;
        MomentsBaseAdapter momentsBaseAdapter2;
        if (momentsDetailEvent.eventType == 0) {
            sq3.o().H(getContext());
            this.i.b(0);
        }
        if (momentsDetailEvent.eventType == 2 && momentsDetailEvent.feed != null && (momentsBaseAdapter2 = this.l) != null) {
            List<Feed> listF = momentsBaseAdapter2.f();
            int i = 0;
            while (true) {
                if (i >= listF.size()) {
                    break;
                }
                Feed feed = listF.get(i);
                if (momentsDetailEvent.feed.getFeedId().equals(feed.getFeedId())) {
                    feed.setLikesList(momentsDetailEvent.feed.getLikesList());
                    feed.setShowComments(momentsDetailEvent.feed.getShowComments());
                    Feed feed2 = momentsDetailEvent.feed;
                    feed.commentNum = feed2.commentNum;
                    feed.setComments(feed2.getComments());
                    this.l.notifyItemChanged(i);
                    LogUtil.d("logmoments", "update feed: like = " + momentsDetailEvent.feed.getLikeNum() + ", pos = " + i);
                    break;
                }
                i++;
            }
        }
        if (momentsDetailEvent.eventType != 3 || momentsDetailEvent.feedId == null || (momentsBaseAdapter = this.l) == null) {
            return;
        }
        List<Feed> listF2 = momentsBaseAdapter.f();
        for (int i2 = 0; i2 < listF2.size(); i2++) {
            Feed feed3 = listF2.get(i2);
            if (momentsDetailEvent.feedId.equals(feed3.getFeedId())) {
                this.k.remove(feed3);
                this.l.d(i2);
                x0();
                LogUtil.d("logmoments", "delete feed: id = " + feed3.getFeedId() + ", pos = " + i2);
                return;
            }
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        LogUtil.i("MomentsBaseFragment", "onPause");
        super.onPause();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.B);
        this.l.v();
        ym ymVar = this.n;
        if (ymVar != null) {
            ymVar.l();
        }
        u6 u6Var = this.o;
        if (u6Var != null) {
            u6Var.l();
        }
        ru3 ru3Var = this.p;
        if (ru3Var != null) {
            ru3Var.j();
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sq3.o().s(this.A);
        T t = this.i;
        if (t != null) {
            t.j();
        }
        IntentFilter intentFilter = new IntentFilter(FrameworkBaseActivity.ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED);
        intentFilter.addAction(tq3.i);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.B, intentFilter);
        ym ymVar = this.n;
        if (ymVar != null) {
            ymVar.m();
        }
        u6 u6Var = this.o;
        if (u6Var != null) {
            u6Var.m();
        }
        ru3 ru3Var = this.p;
        if (ru3Var != null) {
            ru3Var.k();
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public void u(String str) {
        super.u(str);
        MomentsBaseAdapter momentsBaseAdapter = this.l;
        if (momentsBaseAdapter != null) {
            momentsBaseAdapter.x(str);
        }
    }

    public final void x0() {
        if (this.k == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2).getFeedType() <= 100) {
                i++;
            }
        }
        if (i != 0) {
            this.i.l(false);
            return;
        }
        if (this.k.size() > 0) {
            List<Feed> list = this.k;
            if (list.get(list.size() - 1).getFeedType() == 201) {
                List<Feed> list2 = this.k;
                list2.remove(list2.size() - 1);
                MomentsBaseAdapter momentsBaseAdapter = this.l;
                momentsBaseAdapter.d(momentsBaseAdapter.getItemCount() - 1);
            }
        }
        this.i.l(true);
    }

    public abstract T y0(Activity activity, a.InterfaceC1048a interfaceC1048a);
}
