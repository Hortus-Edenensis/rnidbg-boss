package com.zenmen.palmchat.conversations.threadsnew;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.material.appbar.AppBarLayout;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.onekeyfriend.RecommendResultActivity;
import com.zenmen.palmchat.chat.MainTabsViewPager;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.NewContactRequestSendActivityV2;
import com.zenmen.palmchat.contacts.RecommendRequestSendActivity;
import com.zenmen.palmchat.conversations.recallbar.view.RecallBar;
import com.zenmen.palmchat.conversations.threadbubble.view.ThreadsBubbleWidget;
import com.zenmen.palmchat.conversations.threadsnew.filter.FilterType;
import com.zenmen.palmchat.conversations.threadsnew.headerview.CardViewV5;
import com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5;
import com.zenmen.palmchat.conversations.threadsnew.newfriend.NewFriendFragment;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.teenagersmode.TeenagersModeActivity;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.advertisement.BubbleWidget;
import defpackage.ad1;
import defpackage.b05;
import defpackage.bo0;
import defpackage.ch;
import defpackage.co5;
import defpackage.ds0;
import defpackage.en0;
import defpackage.ex5;
import defpackage.f7;
import defpackage.hw5;
import defpackage.ih;
import defpackage.io0;
import defpackage.iq5;
import defpackage.is3;
import defpackage.iw5;
import defpackage.jo6;
import defpackage.k86;
import defpackage.lj5;
import defpackage.m66;
import defpackage.mj1;
import defpackage.nl0;
import defpackage.nx3;
import defpackage.o2;
import defpackage.oc0;
import defpackage.p92;
import defpackage.qm5;
import defpackage.qq2;
import defpackage.r75;
import defpackage.rl0;
import defpackage.rn0;
import defpackage.rx4;
import defpackage.sd3;
import defpackage.st2;
import defpackage.sy5;
import defpackage.td3;
import defpackage.uk5;
import defpackage.un0;
import defpackage.uw5;
import defpackage.v34;
import defpackage.vn0;
import defpackage.wh4;
import defpackage.yb0;
import defpackage.zn0;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadsNewFragment extends BaseFragment implements Observer {
    public static final String E = k86.i("ThreadsNewFragment.hideOneKeyFriends");
    public MainTabsViewPager A;
    public ThreadPagerAdapter B;
    public MainTabsActivity f;
    public View g;
    public View h;
    public View i;
    public AppBarLayout j;
    public ThreadHeaderViewV5 k;
    public BubbleWidget l;
    public RecallBar m;
    public ThreadsBubbleWidget n;
    public ex5 o;
    public View p;
    public Button q;
    public zn0 r;
    public iw5 s;
    public com.zenmen.palmchat.conversations.threadsnew.b v;
    public boolean y;
    public boolean t = false;
    public String u = null;
    public co5 w = null;
    public com.zenmen.palmchat.conversations.threadsnew.filter.a x = new com.zenmen.palmchat.conversations.threadsnew.filter.a();
    public BroadcastReceiver z = new k();
    public ThreadHeaderViewV5.d C = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class ThreadPagerAdapter extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap<Integer, Fragment> f13785a;
        public Context b;
        public List<a> c;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f13786a;
            public String b;
            public String c;

            public a(String str, String str2, String str3) {
                this.f13786a = str;
                this.b = str2;
                this.c = str3;
            }
        }

        @SuppressLint({"WrongConstant"})
        public ThreadPagerAdapter(FragmentManager fragmentManager, Context context) {
            super(fragmentManager, BaseFragment.D());
            this.f13785a = new HashMap<>();
            this.c = new ArrayList();
            this.b = context;
        }

        public Fragment f(int i) {
            return this.f13785a.get(Integer.valueOf(i));
        }

        public void g(List<a> list) {
            this.c = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.c.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            LogUtil.i("ThreadPagerAdapter", "getItem" + i);
            Fragment fragmentInstantiate = Fragment.instantiate(this.b, this.c.get(i).b);
            if (fragmentInstantiate instanceof MessageFragment) {
                ((MessageFragment) fragmentInstantiate).S0(ThreadsNewFragment.this.x);
            }
            this.f13785a.put(Integer.valueOf(i), fragmentInstantiate);
            return fragmentInstantiate;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ThreadsNewFragment.this.G();
            if (ThreadsNewFragment.this.getActivity() != null) {
                new sd3(ThreadsNewFragment.this.getActivity()).j(R.string.sent_request_failed).O(R.string.alert_dialog_ok).e().show();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13789a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ en0 d;
        public final /* synthetic */ ContactRequestsVO e;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                c cVar = c.this;
                ThreadsNewFragment.this.x0(cVar.d, cVar.b, true, cVar.c, cVar.e);
            }
        }

        public c(String str, String str2, int i, en0 en0Var, ContactRequestsVO contactRequestsVO) {
            this.f13789a = str;
            this.b = str2;
            this.c = i;
            this.d = en0Var;
            this.e = contactRequestsVO;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 1L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "rid=?", new String[]{this.f13789a});
                rn0.h(this.b, this.c);
                wh4.h(this.d.b().a());
                iq5.j(false, new String[0]);
            } else if (iOptInt == 1327) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MediationConstant.KEY_ERROR_MSG);
                mj1.c(ThreadsNewFragment.this.getActivity(), jSONObjectOptJSONObject.optString("title"), jSONObjectOptJSONObject.optString("part"), jSONObjectOptJSONObject.optString("body"), jSONObjectOptJSONObject.optInt("time"));
            } else if (iOptInt == 1306) {
                new sd3(ThreadsNewFragment.this.getActivity()).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new a()).e().show();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(ThreadsNewFragment.this.getActivity(), jSONObject);
            } else {
                sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
            }
            ThreadsNewFragment.this.G();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ en0 f13791a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ContactRequestArgs e;

        public d(en0 en0Var, String str, boolean z, int i, ContactRequestArgs contactRequestArgs) {
            this.f13791a = en0Var;
            this.b = str;
            this.c = z;
            this.d = i;
            this.e = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                ThreadsNewFragment.this.G();
                wh4.h(this.f13791a.b().a());
                iq5.j(false, new String[0]);
            } else {
                if (iOptInt == 1) {
                    ThreadsNewFragment.this.y0(this.f13791a, this.b, this.c, this.d, this.e);
                    return;
                }
                if (iOptInt == 1318) {
                    ThreadsNewFragment.this.G();
                    sy5.e(ThreadsNewFragment.this.getActivity(), R.string.send_refuse, 1).g();
                } else if (iOptInt == 1320 || iOptInt == 1321) {
                    ThreadsNewFragment.this.G();
                    rx4.b(ThreadsNewFragment.this.getActivity(), jSONObject);
                } else {
                    ThreadsNewFragment.this.G();
                    sy5.f(ThreadsNewFragment.this.getActivity(), rx4.a(jSONObject), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {
        public e() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ThreadsNewFragment.this.G();
            if (ThreadsNewFragment.this.getActivity() != null) {
                new sd3(ThreadsNewFragment.this.getActivity()).j(R.string.sent_request_failed).O(R.string.alert_dialog_ok).e().show();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ThreadsNewFragment.this.G();
            LogUtil.d("ThreadsNewFragment", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13794a;
        public final /* synthetic */ String b;
        public final /* synthetic */ en0 c;

        public g(boolean z, String str, en0 en0Var) {
            this.f13794a = z;
            this.b = str;
            this.c = en0Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            ThreadsNewFragment.this.G();
            if (iOptInt != 0 && iOptInt != 1) {
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(ThreadsNewFragment.this.getActivity(), jSONObject);
                    return;
                }
                return;
            }
            if (this.f13794a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 2L);
                contentValues.put("request_type", (Integer) 0);
                contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + this.b);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{this.b});
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("accept_status", (Long) 2L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{this.b});
            }
            wh4.h(this.c.b().a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ en0 f13795a;
        public final /* synthetic */ ContactRequestArgs b;

        public h(en0 en0Var, ContactRequestArgs contactRequestArgs) {
            this.f13795a = en0Var;
            this.b = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                ThreadsNewFragment.this.G();
                iq5.j(false, new String[0]);
                wh4.h(this.f13795a.b().a());
            } else {
                if (iOptInt == 1) {
                    ThreadsNewFragment.this.w0(this.f13795a, this.b);
                    return;
                }
                if (iOptInt == 1318) {
                    ThreadsNewFragment.this.G();
                    sy5.e(ThreadsNewFragment.this.getActivity(), R.string.send_refuse, 1).g();
                } else if (iOptInt == 1320 || iOptInt == 1321) {
                    ThreadsNewFragment.this.G();
                    rx4.b(ThreadsNewFragment.this.getActivity(), jSONObject);
                } else {
                    ThreadsNewFragment.this.G();
                    sy5.f(ThreadsNewFragment.this.getActivity(), rx4.a(jSONObject), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.ErrorListener {
        public i() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ThreadsNewFragment.this.G();
            sy5.e(ThreadsNewFragment.this.getActivity(), R.string.contact_apply_fail, 1).g();
            LogUtil.d("ThreadsNewFragment", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.ErrorListener {
        public j() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ThreadsNewFragment.this.G();
            sy5.e(ThreadsNewFragment.this.getActivity(), R.string.contact_apply_fail, 1).g();
            LogUtil.d("ThreadsNewFragment", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k extends BroadcastReceiver {
        public k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (RecommendResultActivity.u.equals(intent.getAction())) {
                    if (intent.getBooleanExtra(RecommendResultActivity.v, false)) {
                        ThreadsNewFragment.this.f.j3("tab_discover");
                    }
                } else if (ThreadsNewFragment.E.equals(intent.getAction()) && ThreadsNewFragment.this.t && ThreadsNewFragment.this.p != null && ThreadsNewFragment.this.p.getVisibility() == 0) {
                    ThreadsNewFragment.this.p.setVisibility(8);
                    r75.p(AppContext.getContext(), k86.a("is_new_user"), 1);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ en0 f13799a;

        public l(en0 en0Var) {
            this.f13799a = en0Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            ThreadsNewFragment.this.G();
            rx4.b(ThreadsNewFragment.this.getActivity(), jSONObject);
            rn0.g(this.f13799a.b().b().fromUid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(view.getContext(), TeenagersModeActivity.class);
            view.getContext().startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TeenagersModeManager.a().d()) {
                zt5.c();
                return;
            }
            LogUtil.onClickEvent("93322", null, null);
            Intent intentC = st2.c();
            intentC.putExtra("main_index", "tab_discover");
            ThreadsNewFragment.this.startActivity(intentC);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o extends HashMap<String, Object> {
        public o() {
            put("fromtype", uw5.c() == 0 ? "1" : "2");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ThreadsNewFragment.this.k.update(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f13805a;

        public r(uk5 uk5Var) {
            this.f13805a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f13805a.f21235a;
            if (i == 0) {
                ThreadsNewFragment.this.S0(false);
                return;
            }
            if (i != 2) {
                if (i == 16) {
                    if (ThreadsNewFragment.this.l != null) {
                        ThreadsNewFragment.this.l.update();
                        return;
                    }
                    return;
                }
                if (i == 20) {
                    LogUtil.i("ACTION_NOTIFY_RECIEVE_TOKEN", "onStatusChanged notifyRecieveToken");
                    if (ThreadsNewFragment.this.getActivity() instanceof MainTabsActivity) {
                        if (MainTabsActivity.y2().equals("tab_msg")) {
                            ad1.h().m(ad1.d, ThreadsNewFragment.this.getActivity());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i == 24) {
                    if (ThreadsNewFragment.this.l != null) {
                        ThreadsNewFragment.this.l.update();
                        return;
                    }
                    return;
                }
                if (i == 37) {
                    if (uw5.d() && ThreadsNewFragment.this.v != null && this.f13805a.b == 0) {
                        ThreadsNewFragment.this.v.c(0);
                    }
                    if (ThreadsNewFragment.this.k != null) {
                        ThreadsNewFragment.this.k.updateNotice(ThreadsNewFragment.this.C0(), false);
                    }
                    if (ThreadsNewFragment.this.o != null) {
                        ThreadsNewFragment.this.o.g();
                        return;
                    }
                    return;
                }
                if (i == 54) {
                    if (ThreadsNewFragment.this.v != null) {
                        ThreadsNewFragment.this.v.d();
                        return;
                    }
                    return;
                } else {
                    if (i == 4) {
                        Fragment fragmentA0 = ThreadsNewFragment.this.A0();
                        if (fragmentA0 == null || !(fragmentA0 instanceof MessageFragment)) {
                            return;
                        }
                        ((MessageFragment) fragmentA0).W0();
                        ThreadsNewFragment.this.j.setExpanded(false);
                        return;
                    }
                    if (i != 5) {
                        return;
                    }
                }
            }
            if (ThreadsNewFragment.this.k != null) {
                ThreadsNewFragment.this.k.updateNetworkState();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements td3.e {
        public s() {
        }

        @Override // td3.e
        public void a(td3 td3Var) {
            if (ThreadsNewFragment.this.k == null || ThreadsNewFragment.this.k.mCardView == null) {
                return;
            }
            ThreadsNewFragment.this.k.mCardView.startSuggestCarousel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Fragment A0() {
        Fragment fragmentF;
        MainTabsViewPager mainTabsViewPager = this.A;
        if (mainTabsViewPager != null) {
            int currentItem = mainTabsViewPager.getCurrentItem();
            ThreadPagerAdapter threadPagerAdapter = this.B;
            fragmentF = threadPagerAdapter != null ? threadPagerAdapter.f(currentItem) : null;
        }
        LogUtil.i("ThreadsNewFragment", "getCurrentFragment=" + fragmentF);
        return fragmentF;
    }

    public final List<ThreadPagerAdapter.a> B0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ThreadPagerAdapter.a("tab_msg", MessageFragment.class.getName(), uw5.a()));
        arrayList.add(new ThreadPagerAdapter.a("tab_new_friend", NewFriendFragment.class.getName(), "新朋友"));
        return arrayList;
    }

    public final hw5 C0() {
        return iw5.m().n("b0000");
    }

    public final void E0() {
        List<ThreadPagerAdapter.a> listB0 = B0();
        this.v.b(listB0);
        G0(listB0);
    }

    public final void G0(List<ThreadPagerAdapter.a> list) {
        MainTabsViewPager mainTabsViewPager = (MainTabsViewPager) this.g.findViewById(R.id.content_vp);
        this.A = mainTabsViewPager;
        mainTabsViewPager.setNoScroll(false);
        ThreadPagerAdapter threadPagerAdapter = new ThreadPagerAdapter(getChildFragmentManager(), getContext());
        this.B = threadPagerAdapter;
        threadPagerAdapter.g(list);
        this.A.addOnPageChangeListener(new p());
        this.A.setAdapter(this.B);
        String str = this.u;
        if (str == null || str.equals("tab_msg")) {
            return;
        }
        Q0(1);
    }

    public final void I0(en0 en0Var) {
        CardViewV5 cardViewV5;
        ThreadHeaderViewV5 threadHeaderViewV5 = this.k;
        if (threadHeaderViewV5 != null && (cardViewV5 = threadHeaderViewV5.mCardView) != null) {
            cardViewV5.stopSuggestCarousel();
        }
        new td3.c(getContext()).c(new String[]{AppContext.getContext().getResources().getString(R.string.menu_dialog_card_refresh), AppContext.getContext().getResources().getString(R.string.menu_dialog_card_delete)}).d(new t(en0Var)).b(new s()).a().b();
    }

    @Override // com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        this.y = z;
        if (z) {
            lj5.c().e(getActivity(), "a0000");
            oc0.h("lx_message_group_show", new o());
        }
        if (this.w != null) {
            b05.d("ThreadsNewFragment->onUserVisibleChange()==》" + z);
            this.w.j(z, false);
        }
    }

    public void K0() {
        com.zenmen.palmchat.conversations.threadsnew.filter.a aVar = this.x;
        if (aVar != null) {
            aVar.n(FilterType.ALL);
        }
    }

    public void L0(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(broadcastReceiver, intentFilter);
    }

    public void M0(String str) {
        if (str != null) {
            if (str.equals("tab_msg")) {
                Q0(0);
            } else {
                Q0(1);
            }
        }
    }

    public final void N0() {
        com.zenmen.palmchat.conversations.threadsnew.b bVar = this.v;
        if (bVar != null) {
            bVar.c(0);
        }
    }

    public void O0() {
        if (this.y) {
            lj5.c().e(getActivity(), "a0000");
        }
    }

    public void Q0(int i2) {
        this.A.setCurrentItem(i2, false);
        co5 co5Var = this.w;
        if (co5Var != null) {
            co5Var.g(i2);
        }
        this.x.o(i2 == 0);
        this.k.onTabSelected(i2);
    }

    public void R0(BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(broadcastReceiver);
    }

    public final void S0(boolean z) {
        int currentItem = this.A.getCurrentItem();
        com.zenmen.palmchat.conversations.threadsnew.b bVar = this.v;
        if (bVar != null) {
            bVar.e(currentItem, z);
        }
    }

    public void T0(int i2) {
        com.zenmen.palmchat.conversations.threadsnew.b bVar = this.v;
        if (bVar != null) {
            bVar.f(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f = (MainTabsActivity) getActivity();
        zn0 zn0VarI = zn0.i();
        this.r = zn0VarI;
        zn0VarI.addObserver(this);
        iw5 iw5VarM = iw5.m();
        this.s = iw5VarM;
        iw5VarM.h(this, "b0000");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1001) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == 2) {
            N0();
        } else {
            Q0(1);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.u = getArguments().getString("thread_sub_tab");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RecommendResultActivity.u);
        intentFilter.addAction(E);
        L0(this.z, intentFilter);
        this.t = r75.g(AppContext.getContext(), k86.a("is_new_user"), 1) == 0;
        this.o = new ex5();
        ds0.a().c(this);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_threads_new, viewGroup, false);
        this.g = viewInflate;
        this.j = (AppBarLayout) viewInflate.findViewById(R.id.app_bar_layout);
        this.v = new com.zenmen.palmchat.conversations.threadsnew.b(this, this.g);
        ThreadHeaderViewV5 threadHeaderViewV5 = (ThreadHeaderViewV5) this.g.findViewById(R.id.id_nr_stickylayout_top_view);
        this.k = threadHeaderViewV5;
        threadHeaderViewV5.setOnOperateListener(this.C);
        this.k.update(true);
        this.k.updateNetworkState();
        this.x.j(this.k);
        this.l = (BubbleWidget) this.g.findViewById(R.id.bubble_widget);
        this.n = (ThreadsBubbleWidget) this.g.findViewById(R.id.handinhand_bubble);
        this.m = (RecallBar) this.g.findViewById(R.id.recall_bar);
        this.h = this.g.findViewById(R.id.close_btn);
        this.i = this.g.findViewById(R.id.yong_mode_layout);
        this.h.setOnClickListener(new m());
        if (nl0.g() && this.t) {
            View viewInflate2 = ((ViewStub) this.g.findViewById(R.id.vs_one_key_friend)).inflate();
            this.p = viewInflate2;
            Button button = (Button) viewInflate2.findViewById(R.id.btn_one_key_friend);
            this.q = button;
            button.setOnClickListener(new n());
        }
        E0();
        this.o.c(this.n, this.m);
        this.w = new co5(getContext(), this, this.k);
        if (is3.b().e()) {
            this.g.findViewById(R.id.topBgView).setVisibility(0);
        }
        return this.g;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ds0.a().d(this);
        R0(this.z);
        this.o.d();
        co5 co5Var = this.w;
        if (co5Var != null) {
            co5Var.h();
        }
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        zn0 zn0Var = this.r;
        if (zn0Var != null) {
            zn0Var.deleteObserver(this);
        }
        iw5 iw5Var = this.s;
        if (iw5Var != null) {
            iw5Var.deleteObserver(this);
        }
        super.onDestroyView();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        CardViewV5 cardViewV5;
        super.onPause();
        ThreadHeaderViewV5 threadHeaderViewV5 = this.k;
        if (threadHeaderViewV5 != null && (cardViewV5 = threadHeaderViewV5.mCardView) != null) {
            cardViewV5.stopSuggestCarousel();
        }
        this.o.e();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.i("ThreadsNewFragment", "onResume");
        ThreadHeaderViewV5 threadHeaderViewV5 = this.k;
        if (threadHeaderViewV5 != null) {
            threadHeaderViewV5.updateNetworkState();
            this.k.updateNotice(C0(), true);
            CardViewV5 cardViewV5 = this.k.mCardView;
            if (cardViewV5 != null) {
                cardViewV5.startSuggestCarousel();
            }
        }
        this.l.update();
        this.o.f();
        S0(false);
        qq2.k(getActivity());
        yb0.a().c("onMsgTabSelected");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ch.s().r().j(this);
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        LogUtil.i("ThreadsNewFragment", "onStatusChanged type =" + uk5Var.f21235a);
        this.g.post(new r(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ch.s().r().l(this);
    }

    @qm5
    public void receivedNotifyBannerUpdate(v34 v34Var) {
        Log.i("ThreadsNewFragment", "receivedNotifyBannerUpdate: ");
        ThreadHeaderViewV5 threadHeaderViewV5 = this.k;
        if (threadHeaderViewV5 != null) {
            threadHeaderViewV5.post(new q());
        }
    }

    public final void t0(en0 en0Var, String str, String str2, int i2, ContactRequestsVO contactRequestsVO) {
        String str3;
        String strM;
        b bVar = new b();
        c cVar = new c(str, str2, i2, en0Var, contactRequestsVO);
        o2 o2Var = new o2();
        try {
            String str4 = en0Var.b().b().identifyCode;
            str3 = "";
            if (jo6.i() && io0.t(i2) && !TextUtils.isEmpty(str4)) {
                ContactInfoItem contactInfoItemL = bo0.r().l(str2);
                if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                    PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str4);
                    strM = phoneContactItem != null ? phoneContactItem.m() : "";
                } else {
                    strM = contactInfoItemL.getRemarkName();
                }
                str3 = strM;
            }
            o2Var.n(str, 1, str3, bVar, cVar);
            M(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public void u0(en0 en0Var) {
        String strM = "";
        if (jo6.i() && en0Var.b() != null && io0.t(en0Var.b().b().sourceType)) {
            ContactInfoItem contactInfoItemL = bo0.r().l(en0Var.b().d());
            if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                PhoneContactItem phoneContactItem = (en0Var.b().b() == null || TextUtils.isEmpty(en0Var.b().b().identifyCode)) ? null : com.zenmen.palmchat.contacts.d.j().m().get(en0Var.b().b().identifyCode);
                if (phoneContactItem != null) {
                    strM = phoneContactItem.m();
                }
            } else {
                strM = contactInfoItemL.getRemarkName();
            }
        }
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(ContactRequestArgs.d(en0Var.b())).i(String.valueOf(en0Var.b().b().sourceType)).j(String.valueOf(19)).g(strM).a();
        try {
            new f7(new h(en0Var, contactRequestArgsA), new i()).n(contactRequestArgsA);
            M(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (!(observable instanceof zn0)) {
            if ((observable instanceof iw5) && TextUtils.equals("b0000", (String) obj) && this.k != null && isVisible() && isResumed()) {
                this.k.updateNotice(C0(), false);
                return;
            }
            return;
        }
        if (rl0.h().d().getDynamicConfig(DynamicConfig.Type.CONTACTCARD).isEnable()) {
            if (!zn0.i().e()) {
                this.k.updateContactCard(null);
                return;
            }
            en0 en0Var = (en0) obj;
            if (en0Var != null) {
                this.k.updateContactCard(en0Var);
                un0.e(en0Var);
            }
        }
    }

    public final void w0(en0 en0Var, ContactRequestArgs contactRequestArgs) {
        try {
            new ih(new l(en0Var), new j()).r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void x0(en0 en0Var, String str, boolean z, int i2, ContactRequestsVO contactRequestsVO) {
        String strM = "";
        if (jo6.i() && io0.t(i2) && en0Var.b() != null) {
            ContactInfoItem contactInfoItemL = bo0.r().l(en0Var.b().d());
            if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                PhoneContactItem phoneContactItem = (en0Var.b().b() == null || TextUtils.isEmpty(en0Var.b().b().identifyCode)) ? null : com.zenmen.palmchat.contacts.d.j().m().get(en0Var.b().b().identifyCode);
                if (phoneContactItem != null) {
                    strM = phoneContactItem.m();
                }
            } else {
                strM = contactInfoItemL.getRemarkName();
            }
        }
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().h(z).b(contactRequestsVO).e(ContactRequestArgs.d(en0Var.b())).i(String.valueOf(i2)).j(String.valueOf(19)).g(strM).a();
        try {
            new f7(new d(en0Var, str, z, i2, contactRequestArgsA), new e()).n(contactRequestArgsA);
            M(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void y0(en0 en0Var, String str, boolean z, int i2, ContactRequestArgs contactRequestArgs) {
        try {
            new ih(new g(z, str, en0Var), new f()).r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ en0 f13807a;

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.ErrorListener {
            public b() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                LogUtil.i("ThreadsNewFragment", volleyError.getMessage());
            }
        }

        public t(en0 en0Var) {
            this.f13807a = en0Var;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fuid", this.f13807a.b().b().fromUid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f13807a.a() != 2) {
                if (i == 0) {
                    LogUtil.onImmediateClickEvent("card_passA", null, jSONObject.toString());
                } else if (i == 1) {
                    LogUtil.onImmediateClickEvent("card_delA", null, jSONObject.toString());
                    r75.q(AppContext.getContext(), k86.a("sp_recommend_contact_card_delet_time"), System.currentTimeMillis());
                    ThreadsNewFragment.this.k.updateContactCard(null);
                }
                wh4.f(this.f13807a.b());
                return;
            }
            rn0.g(this.f13807a.b().b().fromUid);
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                LogUtil.onImmediateClickEvent("card_delR", null, jSONObject.toString());
                r75.q(AppContext.getContext(), k86.a("sp_recommend_contact_card_delet_time"), System.currentTimeMillis());
                ThreadsNewFragment.this.k.updateContactCard(null);
                return;
            }
            LogUtil.onImmediateClickEvent("card_passR", null, jSONObject.toString());
            try {
                new p92(new a(), new b()).n(this.f13807a.b().b().fromUid);
            } catch (DaoException e2) {
                e2.printStackTrace();
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Response.Listener<JSONObject> {
            public a() {
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements ViewPager.OnPageChangeListener {
        public p() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ThreadsNewFragment.this.v.c(i);
            if (i == 1) {
                nx3.e("key_new_friend_tab");
            }
            ThreadsNewFragment.this.S0(true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ThreadHeaderViewV5.d {
        public a() {
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5.d
        public void a() {
            iw5.m().p((FrameworkBaseActivity) ThreadsNewFragment.this.getActivity(), "b0000");
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5.d
        public void b(en0 en0Var) {
            PhoneContactItem phoneContactItem;
            if (en0Var == null || en0Var.a() == 3 || en0Var.b() == null) {
                return;
            }
            int i = en0Var.b().b().sourceType;
            int iC = en0Var.b().c();
            String str = en0Var.b().b().requestRid;
            String strD = en0Var.b().d();
            ContactRequestsVO contactRequestsVOB = en0Var.b().b();
            if (iC < 100) {
                ThreadsNewFragment.this.t0(en0Var, str, strD, i, contactRequestsVOB);
                return;
            }
            if (jo6.q() || jo6.s()) {
                Intent intent = new Intent(ThreadsNewFragment.this.getActivity(), (Class<?>) RecommendRequestSendActivity.class);
                intent.putExtra("uid_key", strD);
                intent.putExtra("user_item_info_key", en0Var.b().a());
                intent.putExtra("source_type_key", i);
                intent.putExtra("subtype_key", 19);
                intent.putExtra("real_name", en0Var.b().b().realName);
                if (jo6.s()) {
                    intent.putExtra("auto_send", true);
                }
                intent.putExtra("send_from_type", 1);
                ThreadsNewFragment.this.startActivity(intent);
                LogUtil.onImmediateClickEvent("card_click_a", null, null);
                return;
            }
            if (!jo6.t()) {
                ThreadsNewFragment.this.u0(en0Var);
                return;
            }
            Intent intent2 = new Intent(ThreadsNewFragment.this.getActivity(), (Class<?>) NewContactRequestSendActivityV2.class);
            ContactInfoItem contactInfoItemA = en0Var.b().a();
            ContactRequestsVO contactRequestsVOB2 = en0Var.b().b();
            intent2.putExtra("user_item_info", contactInfoItemA);
            intent2.putExtra("uid_key", strD);
            intent2.putExtra("new_contact_source_type", i);
            intent2.putExtra("send_from_type", 1);
            if (contactInfoItemA != null && !TextUtils.isEmpty(contactInfoItemA.getMobile())) {
                intent2.putExtra("new_contact_local_phone_number", contactInfoItemA.getMobile());
            } else if (contactRequestsVOB2 != null) {
                String str2 = contactRequestsVOB2.identifyCode;
                if (!TextUtils.isEmpty(str2) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str2)) != null) {
                    intent2.putExtra("new_contact_local_phone_number", phoneContactItem.y());
                }
            }
            if (contactInfoItemA != null) {
                intent2.putExtra("extra_request_type", contactInfoItemA.getRequestType());
            }
            intent2.putExtra("subtype_key", 19);
            intent2.putExtra("extra_request_from", 21);
            ThreadsNewFragment.this.startActivity(intent2);
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5.d
        public void c(en0 en0Var) {
            PhoneContactItem phoneContactItemL;
            PhoneContactItem phoneContactItem;
            if (en0Var == null || en0Var.a() == 3 || en0Var.b() == null) {
                return;
            }
            Intent intent = new Intent(ThreadsNewFragment.this.getContext(), (Class<?>) m66.c());
            if (en0Var.b().c() < 100) {
                LogUtil.onImmediateClickEvent("29", null, null);
                intent.putExtra("rid", en0Var.b().b().requestRid);
                intent.putExtra("from", 7);
                String str = en0Var.b().b().identifyCode;
                if (!TextUtils.isEmpty(str) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str)) != null) {
                    intent.putExtra("user_detail_local_phone_number", phoneContactItem.y());
                }
            } else {
                LogUtil.onImmediateClickEvent("212", null, null);
                intent.putExtra("from", 8);
                if (en0Var.b().b() != null && !TextUtils.isEmpty(en0Var.b().b().identifyCode) && (phoneContactItemL = com.zenmen.palmchat.contacts.d.j().l(en0Var.b().b().identifyCode)) != null) {
                    intent.putExtra("user_detail_local_phone_number", phoneContactItemL.y());
                }
                if (jo6.q()) {
                    intent.putExtra("send_from_type", 1);
                    intent.putExtra("new_request_send_page", true);
                }
            }
            intent.putExtra("extra_request_from", 21);
            intent.putExtra("extra_request_type", en0Var.b().c());
            intent.putExtra("user_item_info", en0Var.b().a());
            intent.putExtra("user_real_name", en0Var.b().b().realName);
            ThreadsNewFragment.this.startActivity(intent);
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5.d
        public void e(en0 en0Var) {
            if (en0Var == null || en0Var.a() == 3) {
                return;
            }
            ThreadsNewFragment.this.I0(en0Var);
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5.d
        public void d(int i, int i2) {
        }
    }
}
