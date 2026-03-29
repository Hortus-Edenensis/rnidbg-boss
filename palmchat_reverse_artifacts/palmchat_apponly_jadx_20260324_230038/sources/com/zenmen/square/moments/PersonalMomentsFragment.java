package com.zenmen.square.moments;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.duration.BaseDurationFragment;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.bean.MomentsDetailEvent;
import com.zenmen.palmchat.friendcircle.netdao.FeedNetDao;
import com.zenmen.palmchat.friendcircle.netdao.NetResponse;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.MomentsDetailFullActivity;
import com.zenmen.square.R$color;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.moments.adapter.PersonalMomentsAdapter;
import com.zenmen.square.ui.widget.SquarePersonLoadFooter;
import defpackage.an1;
import defpackage.bj5;
import defpackage.c74;
import defpackage.ds0;
import defpackage.ei4;
import defpackage.hx3;
import defpackage.ip2;
import defpackage.l50;
import defpackage.pm5;
import defpackage.tq3;
import defpackage.v4;
import defpackage.xu4;
import defpackage.yy2;
import defpackage.zi1;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"LongLogTag"})
public class PersonalMomentsFragment extends BaseDurationFragment implements ip2 {
    public View i;
    public SmartRefreshLayout j;
    public RecyclerView k;
    public TextView l;
    public View m;
    public View n;
    public TextView o;
    public boolean q;
    public ContactInfoItem r;
    public String s;
    public boolean t;
    public int v;
    public long w;
    public PersonalMomentsAdapter x;
    public boolean p = false;
    public CopyOnWriteArrayList<Feed> u = new CopyOnWriteArrayList<>();
    public FeedNetDao.FeedNetListener y = new d();
    public BroadcastReceiver z = new e();
    public g A = new f();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c74 {
        public a() {
        }

        @Override // defpackage.c74
        public void onLoadMore(@NonNull xu4 xu4Var) {
            PersonalMomentsFragment.this.s0(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalMomentsFragment.this.s0(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("targetUid", PersonalMomentsFragment.this.r.getUid());
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            bj5.b().a().E(2, PersonalMomentsFragment.this.getContext(), PersonalMomentsFragment.this.r);
            zn6.j("newpageprofil_postinvite2", "click", new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements FeedNetDao.FeedNetListener {
        public d() {
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onFail(Exception exc) {
            Log.d("PersonalMomentsFragment", "FeedNetListener onFail,  error is " + exc);
            if (PersonalMomentsFragment.this.getContext() == null || PersonalMomentsFragment.this.isDetached()) {
                return;
            }
            PersonalMomentsFragment.this.r0(true);
        }

        @Override // com.zenmen.palmchat.friendcircle.netdao.FeedNetDao.FeedNetListener
        public void onSuccess(NetResponse netResponse, yy2 yy2Var) {
            List<Feed> list;
            if (PersonalMomentsFragment.this.getContext() == null || PersonalMomentsFragment.this.isDetached()) {
                return;
            }
            if (netResponse != null) {
                Log.d("PersonalMomentsFragment", "FeedNetListener onSuccess: " + netResponse.toString());
                if (netResponse.resultCode == 0) {
                    NetResponseData netResponseData = netResponse.data;
                    if (netResponseData != null) {
                        PersonalMomentsFragment.this.p = netResponseData.hasMore;
                        if (PersonalMomentsFragment.this.t && TextUtils.equals(PersonalMomentsFragment.this.r.getUid(), v4.e(PersonalMomentsFragment.this.getActivity())) && PersonalMomentsFragment.this.u.isEmpty()) {
                            Feed feed = new Feed();
                            feed.setFeedId(-1L);
                            feed.setFeedType(-1);
                            feed.setCreateDt(Long.valueOf(System.currentTimeMillis()));
                            PersonalMomentsFragment.this.u.add(feed);
                        }
                        if (netResponseData.feeds != null) {
                            PersonalMomentsFragment.this.u.addAll(netResponseData.feeds);
                            PersonalMomentsFragment.this.x.t(PersonalMomentsFragment.this.u, PersonalMomentsFragment.this.p);
                        } else {
                            PersonalMomentsFragment.this.x.t(PersonalMomentsFragment.this.u, PersonalMomentsFragment.this.p);
                        }
                        PersonalMomentsFragment.this.v = netResponseData.total;
                        if (PersonalMomentsFragment.this.w == 0) {
                            PersonalMomentsFragment.this.t0();
                        }
                        if (PersonalMomentsFragment.this.p && (list = netResponseData.feeds) != null && !list.isEmpty()) {
                            PersonalMomentsFragment.this.w = tq3.e().h(netResponseData.feeds);
                        }
                    } else {
                        Log.d("PersonalMomentsFragment", "NetResponse data is null");
                    }
                } else {
                    Log.d("PersonalMomentsFragment", "NetResponse is Error, resultCode is " + netResponse.resultCode);
                }
            } else {
                Log.d("PersonalMomentsFragment", "NetResponse is null");
            }
            PersonalMomentsFragment.this.r0(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                long longExtra = intent.getLongExtra("feedId", 0L);
                for (Feed feed : PersonalMomentsFragment.this.u) {
                    if (feed.getFeedId().longValue() == longExtra) {
                        PersonalMomentsFragment.this.u.remove(feed);
                        PersonalMomentsFragment.this.x.t(PersonalMomentsFragment.this.u, PersonalMomentsFragment.this.p);
                        PersonalMomentsFragment.this.p0();
                        PersonalMomentsFragment.j0(PersonalMomentsFragment.this);
                        PersonalMomentsFragment.this.t0();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements g {
        public f() {
        }

        @Override // com.zenmen.square.moments.PersonalMomentsFragment.g
        public void a(Feed feed) {
            int i;
            if (l50.a() || feed == null || PersonalMomentsFragment.this.getActivity() == null) {
                return;
            }
            if (feed.getFeedType() == 2 || feed.getFeedType() == 3) {
                ArrayList arrayList = new ArrayList();
                int size = 0;
                if (PersonalMomentsFragment.this.u != null) {
                    for (Feed feed2 : PersonalMomentsFragment.this.u) {
                        if (feed2.getFeedType() == 2 || feed2.getFeedType() == 3) {
                            Feed feed3 = new Feed();
                            feed3.setFeedId(feed2.getFeedId());
                            feed3.setUid(feed2.getUid());
                            feed3.setFeedType(feed2.getFeedType());
                            feed3.setVersion(feed2.getVersion());
                            arrayList.add(feed3);
                            if (feed2.getFeedId().longValue() == feed.getId()) {
                                size = arrayList.size() - 1;
                            }
                        }
                    }
                    i = size;
                } else {
                    i = 0;
                }
                PersonalMomentsFragment.this.getActivity().startActivity(MomentsDetailFullActivity.B1(PersonalMomentsFragment.this.getActivity(), arrayList, i, "from_publish_comment", 20, null));
            } else if (feed.getFeedType() == 1 || feed.getFeedType() == 6 || feed.getFeedType() == 7 || feed.getFeedType() == 4) {
                Intent intentC = ei4.c(feed, feed.getFeedId(), feed.getUid(), 1, PersonalMomentsFragment.this.r, feed.getFeedType());
                intentC.putExtra("fromSource", 20);
                LogUtil.uploadInfoImmediate("dt12", "1", null, null);
                PersonalMomentsFragment.this.startActivity(intentC);
            } else if (feed.getFeedType() == -1) {
                bj5.b().a().c0(PersonalMomentsFragment.this.getActivity(), 13, null, null, null, true);
            }
            HashMap map = new HashMap();
            map.put("from", 20);
            map.put("feedid", feed.getFeedId());
            map.put("feedType", Integer.valueOf(feed.getFeedType()));
            zn6.j("pagediscover_feeds", "click", map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void a(Feed feed);
    }

    public static /* synthetic */ int j0(PersonalMomentsFragment personalMomentsFragment) {
        int i = personalMomentsFragment.v;
        personalMomentsFragment.v = i - 1;
        return i;
    }

    @Override // defpackage.ip2
    public void c(ContactInfoItem contactInfoItem, HashMap<String, Object> map) {
        this.r = contactInfoItem;
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 20;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LocalBroadcastManager.getInstance(com.zenmen.palmchat.c.b()).registerReceiver(this.z, new IntentFilter(tq3.l));
        ds0.a().c(this);
        an1.c().p(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) arguments.getParcelable("user_item_info");
            this.r = contactInfoItem;
            if (contactInfoItem != null) {
                this.s = contactInfoItem.getUid();
            }
            this.t = arguments.getBoolean("v2");
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.t ? R$layout.layout_personal_moments_v2 : R$layout.layout_personal_moments, (ViewGroup) null, false);
        this.i = viewInflate;
        this.l = (TextView) viewInflate.findViewById(R$id.tag_error);
        this.m = this.i.findViewById(R$id.tag_empty);
        this.n = this.i.findViewById(R$id.tag_loading);
        this.o = (TextView) this.i.findViewById(com.zenmen.square.R$id.empty_tips);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.i.findViewById(com.zenmen.square.R$id.refresh_layout);
        this.j = smartRefreshLayout;
        smartRefreshLayout.setRefreshFooter(new SquarePersonLoadFooter(com.zenmen.palmchat.c.b()));
        this.j.setEnableRefresh(false);
        this.j.setOnLoadMoreListener(new a());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("加载失败，点击刷新");
        Resources resources = getResources();
        int i = R$color.Ga;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(i)), 5, 9, 18);
        this.l.setText(spannableStringBuilder);
        this.l.setOnClickListener(new b());
        this.k = (RecyclerView) this.i.findViewById(com.zenmen.square.R$id.recycler_view);
        PersonalMomentsAdapter personalMomentsAdapter = new PersonalMomentsAdapter(getContext(), this.u);
        this.x = personalMomentsAdapter;
        personalMomentsAdapter.s(this.A);
        this.k.setAdapter(this.x);
        if (this.o != null) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("空空如也，邀请Ta发个动态吧 >");
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(getResources().getColor(i)), 5, 16, 18);
            this.o.setText(spannableStringBuilder2);
            this.o.setOnClickListener(new c());
        }
        return this.i;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(com.zenmen.palmchat.c.b()).unregisterReceiver(this.z);
        ds0.a().d(this);
        an1.c().r(this);
        this.u.clear();
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onMomentsFeedEvent(MomentsDetailEvent momentsDetailEvent) {
        if (momentsDetailEvent.eventType != 3 || momentsDetailEvent.feedId == null) {
            return;
        }
        try {
            for (Feed feed : this.u) {
                if (feed.getFeedId().equals(momentsDetailEvent.feedId)) {
                    this.u.remove(feed);
                    this.x.t(this.u, this.p);
                    p0();
                    this.v--;
                    t0();
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (TextUtils.isEmpty(this.s)) {
            r0(false);
        } else {
            s0(false);
        }
    }

    public final void p0() {
        this.m.setVisibility(this.u.isEmpty() ? 0 : 8);
    }

    public final void r0(boolean z) {
        if (z) {
            if (hx3.m(getContext())) {
                Toast.makeText(getContext(), "请求数据失败，请稍后重试", 0).show();
            } else {
                Toast.makeText(getContext(), getContext().getString(R$string.square_network_error), 0).show();
            }
            this.l.setVisibility(this.u.isEmpty() ? 0 : 8);
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(this.u.isEmpty() ? 0 : 8);
            this.l.setVisibility(8);
        }
        this.n.setVisibility(8);
        this.j.finishLoadMore(0);
        this.j.setEnableLoadMore(this.p);
        this.q = false;
    }

    public final void s0(boolean z) {
        Log.i("PersonalMomentsFragment", "load: " + z);
        if (TextUtils.isEmpty(this.s) || this.q) {
            return;
        }
        u0();
        tq3.e().f(this.s, this.w, this.y);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public void t0() {
        LogUtil.d("PersonalMomentsFragment", "onLoadSuccess:" + this.v);
        ds0.a().b(new zi1(PersonalMomentsFragment.class.getName(), this.v));
    }

    public final void u0() {
        this.m.setVisibility(8);
        this.l.setVisibility(8);
        if (this.u.isEmpty()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        this.q = true;
    }
}
