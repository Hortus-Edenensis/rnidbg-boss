package com.zenmen.square.dynamiclife;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zenmen.listui.duration.BaseDurationFragment;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.R$color;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.bean.SquareDynamicLifeBeanInfo;
import com.zenmen.square.bean.SquareDynamicLifeResponseBean;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.CommonResponse;
import com.zenmen.square.ui.widget.SquarePersonLoadFooter;
import com.zenmen.square.ui.widget.SquarePersonalHelper;
import defpackage.aj1;
import defpackage.b05;
import defpackage.bj1;
import defpackage.bj5;
import defpackage.c74;
import defpackage.cj1;
import defpackage.dj1;
import defpackage.ds0;
import defpackage.ej1;
import defpackage.fi5;
import defpackage.fj1;
import defpackage.gj1;
import defpackage.go2;
import defpackage.hi5;
import defpackage.hj1;
import defpackage.hx3;
import defpackage.ij1;
import defpackage.ip2;
import defpackage.jj1;
import defpackage.kj1;
import defpackage.l50;
import defpackage.nj1;
import defpackage.q05;
import defpackage.qm5;
import defpackage.sw4;
import defpackage.tw4;
import defpackage.uo2;
import defpackage.v4;
import defpackage.xn3;
import defpackage.xu4;
import defpackage.zi1;
import defpackage.zn6;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"LongLogTag"})
public class PersonalDynamicLifeFragment extends BaseDurationFragment implements ip2 {
    public ej1 C;
    public boolean H;
    public boolean I;
    public ImageView K;
    public View i;
    public TextView j;
    public View k;
    public View l;
    public TextView m;
    public SmartRefreshLayout n;
    public RecyclerView o;
    public uo2 p;
    public ContactInfoItem q;
    public MultiTypeAdapter r;
    public List<Object> s;
    public List<SquareDynamicLifeBeanInfo> t;
    public int x;
    public boolean y;
    public long u = 0;
    public boolean v = false;
    public boolean w = false;
    public String z = null;
    public String A = null;
    public String B = null;
    public boolean E = false;
    public int F = 0;
    public long G = -1;
    public int J = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("from", Integer.valueOf(PersonalDynamicLifeFragment.this.J));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            if (PersonalDynamicLifeFragment.this.E) {
                q05.a("postboost_entrance_pageprofil_new", 2, null);
                bj5.b().a().K(PersonalDynamicLifeFragment.this.getContext(), 603, null);
            } else {
                q05.a("postboost_entrance_pageprofil_old_postlist", 2, null);
                bj5.b().a().K(PersonalDynamicLifeFragment.this.getContext(), 602, null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements c74 {
        public c() {
        }

        @Override // defpackage.c74
        public void onLoadMore(@NonNull xu4 xu4Var) {
            PersonalDynamicLifeFragment.this.y0(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements k {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("from", Integer.valueOf(PersonalDynamicLifeFragment.this.J));
            }
        }

        public d() {
        }

        @Override // com.zenmen.square.dynamiclife.PersonalDynamicLifeFragment.k
        public void a(SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo) {
            if (l50.a()) {
                return;
            }
            if (squareDynamicLifeBeanInfo.isPublish) {
                bj5.b().a().c0(PersonalDynamicLifeFragment.this.getActivity(), 13, null, null, null, true);
                return;
            }
            if (PersonalDynamicLifeFragment.this.F == 2) {
                q05.a("postboost_homepage_choosePost", 2, new a());
                PersonalDynamicLifeFragment.this.r0(squareDynamicLifeBeanInfo);
                return;
            }
            if (squareDynamicLifeBeanInfo.feedType == 1) {
                if (PersonalDynamicLifeFragment.this.F == 1) {
                    return;
                }
                SquareFeed squareFeed = new SquareFeed();
                squareFeed.uid = squareDynamicLifeBeanInfo.uid;
                squareFeed.feedType = squareDynamicLifeBeanInfo.feedType;
                squareFeed.id = squareDynamicLifeBeanInfo.id;
                squareFeed.exid = squareDynamicLifeBeanInfo.exid;
                MediaViewActivity.B1(16, PersonalDynamicLifeFragment.this.getActivity(), squareFeed, false);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                Bundle bundle = new Bundle();
                bundle.putString("key_feed_uid", squareDynamicLifeBeanInfo.uid);
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < PersonalDynamicLifeFragment.this.t.size(); i3++) {
                    SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo2 = (SquareDynamicLifeBeanInfo) PersonalDynamicLifeFragment.this.t.get(i3);
                    int i4 = squareDynamicLifeBeanInfo2.feedType;
                    if (i4 == 3 || i4 == 2) {
                        SquareFeed squareFeed2 = new SquareFeed();
                        squareFeed2.id = squareDynamicLifeBeanInfo2.id;
                        squareFeed2.uid = squareDynamicLifeBeanInfo2.uid;
                        squareFeed2.exid = squareDynamicLifeBeanInfo2.exid;
                        squareFeed2.version = squareDynamicLifeBeanInfo2.version;
                        squareFeed2.feedType = squareDynamicLifeBeanInfo2.feedType;
                        arrayList.add(squareFeed2);
                        if (squareDynamicLifeBeanInfo.id == squareDynamicLifeBeanInfo2.id) {
                            i = i3 - i2;
                        }
                    } else {
                        i2++;
                    }
                }
                bundle.putInt("key_target_position", i);
                MediaViewActivity.C1(PersonalDynamicLifeFragment.this.F == 1 ? 8 : 16, arrayList, PersonalDynamicLifeFragment.this.getActivity(), bundle);
                HashMap map = new HashMap();
                map.put("feedid", Long.valueOf(squareDynamicLifeBeanInfo.id));
                zn6.j("pageprofil_center_feedclick", "click", map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalDynamicLifeFragment.this.y0(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("targetUid", PersonalDynamicLifeFragment.this.q.getUid());
            }
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            bj5.b().a().E(2, PersonalDynamicLifeFragment.this.getContext(), PersonalDynamicLifeFragment.this.q);
            zn6.j("newpageprofil_postinvite1", "click", new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends tw4<CommonResponse<SquareDynamicLifeResponseBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16258a;

        public g(boolean z) {
            this.f16258a = z;
        }

        @Override // defpackage.tw4
        public void a(CommonResponse<SquareDynamicLifeResponseBean> commonResponse) {
            List<SquareDynamicLifeBeanInfo> arrayList;
            if (PersonalDynamicLifeFragment.this.w || PersonalDynamicLifeFragment.this.getContext() == null || PersonalDynamicLifeFragment.this.isDetached()) {
                return;
            }
            if (commonResponse == null || commonResponse.getData() == null || commonResponse.getData().userDailyLifeList == null || commonResponse.getData().userDailyLifeList.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = commonResponse.getData().userDailyLifeList;
                PersonalDynamicLifeFragment.this.x = commonResponse.getData().totalCount;
            }
            if (PersonalDynamicLifeFragment.this.E && !this.f16258a && TextUtils.equals(PersonalDynamicLifeFragment.this.q.getUid(), v4.e(PersonalDynamicLifeFragment.this.getActivity()))) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo = new SquareDynamicLifeBeanInfo();
                squareDynamicLifeBeanInfo.createTime = System.currentTimeMillis();
                squareDynamicLifeBeanInfo.isPublish = true;
                arrayList.add(0, squareDynamicLifeBeanInfo);
            }
            if (arrayList == null || arrayList.isEmpty()) {
                PersonalDynamicLifeFragment.this.v = false;
                if (!this.f16258a) {
                    PersonalDynamicLifeFragment.this.x = 0;
                    PersonalDynamicLifeFragment.this.r.d(null);
                }
                PersonalDynamicLifeFragment.this.w0(false, true);
            } else {
                PersonalDynamicLifeFragment.this.v = !commonResponse.getData().lastVersion;
                PersonalDynamicLifeFragment.this.I0(this.f16258a, arrayList);
                PersonalDynamicLifeFragment.this.w0(false, false);
            }
            if (this.f16258a) {
                return;
            }
            PersonalDynamicLifeFragment.this.A0();
        }

        @Override // defpackage.tw4
        public void b(int i, String str) {
            super.b(i, str);
            Log.i("PersonalDynamicLifeFragment", "onError: " + i + "  " + str);
            if (PersonalDynamicLifeFragment.this.getContext() == null || PersonalDynamicLifeFragment.this.isDetached()) {
                return;
            }
            PersonalDynamicLifeFragment.this.w0(true, true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonalDynamicLifeFragment.this.y0(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonalDynamicLifeFragment.this.y0(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16261a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ SquareDynamicLifeBeanInfo c;

        public j(String str, HashMap map, SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo) {
            this.f16261a = str;
            this.b = map;
            this.c = squareDynamicLifeBeanInfo;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f16261a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            if (!q05.o(PersonalDynamicLifeFragment.this.getActivity()) && z && lXBaseNetBean != null && lXBaseNetBean.isSuccess()) {
                PersonalDynamicLifeFragment.this.C0(this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface k {
        void a(SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo);
    }

    public void A0() {
        LogUtil.d("PersonalDynamicLifeFragment", "onLoadSuccess:" + x0());
        ds0.a().b(new zi1(PersonalDynamicLifeFragment.class.getName(), x0()));
    }

    public final tw4<CommonResponse<SquareDynamicLifeResponseBean>> B0(boolean z) {
        return new g(z);
    }

    public final void C0(SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo) {
        if (squareDynamicLifeBeanInfo.feedType == 1) {
            SquareFeed squareFeed = new SquareFeed();
            squareFeed.uid = squareDynamicLifeBeanInfo.uid;
            squareFeed.feedType = squareDynamicLifeBeanInfo.feedType;
            squareFeed.id = squareDynamicLifeBeanInfo.id;
            squareFeed.exid = squareDynamicLifeBeanInfo.exid;
            squareFeed.content = squareDynamicLifeBeanInfo.content;
            Intent intent = new Intent();
            intent.putExtra("EXTRA_FEED", squareFeed);
            FragmentActivity activity = getActivity();
            getActivity();
            activity.setResult(-1, intent);
            getActivity().finish();
            return;
        }
        try {
            SquareFeed squareFeed2 = new SquareFeed();
            squareFeed2.uid = squareDynamicLifeBeanInfo.uid;
            squareFeed2.feedType = squareDynamicLifeBeanInfo.feedType;
            squareFeed2.id = squareDynamicLifeBeanInfo.id;
            squareFeed2.exid = squareDynamicLifeBeanInfo.exid;
            squareFeed2.content = squareDynamicLifeBeanInfo.content;
            Media media = new Media();
            String str = squareDynamicLifeBeanInfo.url;
            media.thumbUrl = str;
            media.url = str;
            ArrayList arrayList = new ArrayList();
            arrayList.add(media);
            squareFeed2.mediaList = arrayList;
            Intent intent2 = new Intent();
            intent2.putExtra("EXTRA_FEED", squareFeed2);
            FragmentActivity activity2 = getActivity();
            getActivity();
            activity2.setResult(-1, intent2);
            getActivity().finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void E0(boolean z) {
        ContactInfoItem contactInfoItem;
        if (x0() == 0 || this.F == 2 || !kj1.b().c().booleanValue() || (contactInfoItem = this.q) == null || contactInfoItem.getUid() == null || q05.e() == null || q05.e().getUid() == null || !this.q.getUid().equals(q05.e().getUid())) {
            return;
        }
        this.K.setVisibility(z ? 0 : 8);
        if (z) {
            if (this.E) {
                if (this.I) {
                    return;
                }
                this.I = true;
                q05.a("postboost_entrance_pageprofil_new", 1, null);
                return;
            }
            if (this.H) {
                return;
            }
            this.H = true;
            q05.a("postboost_entrance_pageprofil_old_postlist", 1, null);
        }
    }

    public final void G0(boolean z) {
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        if (z) {
            this.r.notifyDataSetChanged();
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        this.y = true;
    }

    public final void I0(boolean z, List<SquareDynamicLifeBeanInfo> list) {
        if (this.r == null) {
            return;
        }
        this.u = list.get(list.size() - 1).version;
        this.t.addAll(list);
        this.s.addAll(s0(list));
        if (this.v) {
            u0();
        } else {
            this.s.add(this.C);
        }
        Log.i("PersonalDynamicLifeFragment", "updateRecycler: " + list.size() + "  " + this.s.size());
        if (z) {
            this.r.notifyDataSetChanged();
            return;
        }
        this.r.d(this.s);
        this.r.notifyDataSetChanged();
        t0();
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        if (z && this.F == 2) {
            q05.a("postboost_homepage_choosePost", 1, new a());
        }
    }

    @Override // defpackage.ip2
    public void c(ContactInfoItem contactInfoItem, HashMap<String, Object> map) {
        this.q = contactInfoItem;
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 13;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ds0.a().c(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.q = (ContactInfoItem) arguments.getParcelable("user_item_info");
            this.F = arguments.getInt("mFrom");
            this.J = arguments.getInt("EXTRA_From_Param");
            this.G = arguments.getLong(SquarePersonalHelper.EXTRA_FEED_ID, -1L);
            this.E = arguments.getBoolean("v2");
            b05.a("fromParam===>" + this.J);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.E ? R$layout.layout_personal_dynamic_life_v2 : R$layout.layout_personal_dynamic_life, (ViewGroup) null, false);
        this.i = viewInflate;
        this.j = (TextView) viewInflate.findViewById(R$id.tag_error);
        this.k = this.i.findViewById(R$id.tag_empty);
        this.K = (ImageView) this.i.findViewById(R$id.iv_dynamic_life_banner);
        DynamicSuperExposeV1Config dynamicSuperExposeV1ConfigA = kj1.b().a();
        if (this.E) {
            if (dynamicSuperExposeV1ConfigA != null && !TextUtils.isEmpty(dynamicSuperExposeV1ConfigA.pageprofil_new_url)) {
                FragmentActivity activity = getActivity();
                ImageView imageView = this.K;
                String str = dynamicSuperExposeV1ConfigA.pageprofil_new_url;
                int i2 = R$drawable.icon_dynamic_super_expose_banner_image;
                q05.s(activity, imageView, str, i2, i2);
            }
        } else if (dynamicSuperExposeV1ConfigA != null && !TextUtils.isEmpty(dynamicSuperExposeV1ConfigA.pageprofil_old_postlist_url)) {
            FragmentActivity activity2 = getActivity();
            ImageView imageView2 = this.K;
            String str2 = dynamicSuperExposeV1ConfigA.pageprofil_old_postlist_url;
            int i3 = R$drawable.icon_dynamic_super_expose_banner_image;
            q05.s(activity2, imageView2, str2, i3, i3);
        }
        this.K.setOnClickListener(new b());
        this.m = (TextView) this.i.findViewById(R$id.empty_tips);
        this.l = this.i.findViewById(R$id.tag_loading);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.i.findViewById(R$id.refresh_layout);
        this.n = smartRefreshLayout;
        smartRefreshLayout.setRefreshFooter(new SquarePersonLoadFooter(com.zenmen.palmchat.c.b()));
        this.n.setEnableRefresh(false);
        this.n.setOnLoadMoreListener(new c());
        this.o = (RecyclerView) this.i.findViewById(R$id.recycler_view);
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter();
        this.r = multiTypeAdapter;
        multiTypeAdapter.c(nj1.class, new jj1());
        this.r.c(aj1.class, new bj1());
        this.r.c(SquareDynamicLifeResponseBean.class, new ij1(getContext(), this.F, new d()));
        this.r.c(ej1.class, new fj1());
        this.r.c(gj1.class, new hj1());
        this.r.c(cj1.class, new dj1());
        this.C = new ej1();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("加载失败，点击刷新");
        Resources resources = getResources();
        int i4 = R$color.Ga;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(i4)), 5, 9, 18);
        this.j.setText(spannableStringBuilder);
        this.j.setOnClickListener(new e());
        if (this.m != null) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("空空如也，邀请Ta发个动态吧 >");
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(getResources().getColor(i4)), 5, 16, 18);
            this.m.setText(spannableStringBuilder2);
            this.m.setOnClickListener(new f());
        }
        this.o.setAdapter(this.r);
        return this.i;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ds0.a().d(this);
        List<Object> list = this.s;
        if (list != null) {
            list.clear();
        }
        List<SquareDynamicLifeBeanInfo> list2 = this.t;
        if (list2 != null) {
            list2.clear();
        }
        this.r = null;
        this.w = false;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @qm5
    public void onSquareDeleteEvent(fi5 fi5Var) {
        View view;
        if (isDetached() || (view = this.i) == null) {
            return;
        }
        view.post(new h());
    }

    @qm5
    public void onSquareDynamicBuySuccess(hi5 hi5Var) {
        View view;
        if (isDetached() || (view = this.i) == null) {
            return;
        }
        view.post(new i());
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        y0(false);
    }

    public void r0(SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo) {
        String str = q05.c() + "/square.feed.super.show.select";
        HashMap map = new HashMap();
        map.put("feedId", Long.valueOf(squareDynamicLifeBeanInfo.id));
        zw4.e(new j(str, map, squareDynamicLifeBeanInfo));
    }

    public final List<Object> s0(List<SquareDynamicLifeBeanInfo> list) {
        ArrayList arrayList = new ArrayList();
        SquareDynamicLifeResponseBean squareDynamicLifeResponseBean = new SquareDynamicLifeResponseBean();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            SquareDynamicLifeBeanInfo squareDynamicLifeBeanInfo = list.get(i2);
            squareDynamicLifeBeanInfo.getYearAndMonthByCreateTime();
            if (!squareDynamicLifeBeanInfo.year.equals(this.z) && !squareDynamicLifeBeanInfo.isCurrentYear()) {
                if (arrayList2.size() > 0) {
                    squareDynamicLifeResponseBean.userDailyLifeList = arrayList2;
                    arrayList.add(squareDynamicLifeResponseBean);
                    arrayList2 = new ArrayList();
                    squareDynamicLifeResponseBean = new SquareDynamicLifeResponseBean();
                }
                arrayList.add(new nj1(squareDynamicLifeBeanInfo.year));
                this.A = null;
                this.B = null;
            }
            if (!squareDynamicLifeBeanInfo.month.equals(this.A)) {
                if (arrayList2.size() > 0) {
                    squareDynamicLifeResponseBean.userDailyLifeList = arrayList2;
                    arrayList.add(squareDynamicLifeResponseBean);
                    arrayList2 = new ArrayList();
                    squareDynamicLifeResponseBean = new SquareDynamicLifeResponseBean();
                }
                if (TextUtils.isEmpty(squareDynamicLifeBeanInfo.city)) {
                    squareDynamicLifeResponseBean.showMonth = squareDynamicLifeBeanInfo.month;
                    this.B = null;
                } else {
                    arrayList.add(new aj1(squareDynamicLifeBeanInfo.month, squareDynamicLifeBeanInfo.city, true));
                }
            } else if (!TextUtils.isEmpty(squareDynamicLifeBeanInfo.city) && !squareDynamicLifeBeanInfo.city.equals(this.B)) {
                squareDynamicLifeResponseBean.userDailyLifeList = arrayList2;
                arrayList.add(squareDynamicLifeResponseBean);
                ArrayList arrayList3 = new ArrayList();
                SquareDynamicLifeResponseBean squareDynamicLifeResponseBean2 = new SquareDynamicLifeResponseBean();
                arrayList.add(new aj1(squareDynamicLifeBeanInfo.month, squareDynamicLifeBeanInfo.city, false));
                arrayList2 = arrayList3;
                squareDynamicLifeResponseBean = squareDynamicLifeResponseBean2;
            } else if (i2 == 0 && this.s.size() > 0) {
                List<Object> list2 = this.s;
                SquareDynamicLifeResponseBean squareDynamicLifeResponseBean3 = (SquareDynamicLifeResponseBean) list2.get(list2.size() - 1);
                arrayList2.addAll(squareDynamicLifeResponseBean3.userDailyLifeList);
                squareDynamicLifeResponseBean.showMonth = squareDynamicLifeResponseBean3.showMonth;
                List<Object> list3 = this.s;
                list3.remove(list3.size() - 1);
            }
            arrayList2.add(squareDynamicLifeBeanInfo);
            if (i2 == list.size() - 1) {
                squareDynamicLifeResponseBean.userDailyLifeList = arrayList2;
                arrayList.add(squareDynamicLifeResponseBean);
            }
            this.z = squareDynamicLifeBeanInfo.year;
            this.A = squareDynamicLifeBeanInfo.month;
            if (!TextUtils.isEmpty(squareDynamicLifeBeanInfo.city)) {
                this.B = squareDynamicLifeBeanInfo.city;
            }
        }
        return arrayList;
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public void t0() {
        if (this.F != 3 || this.G <= 0 || this.s == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.s.size()) {
            if (this.s.get(i2) instanceof SquareDynamicLifeResponseBean) {
                SquareDynamicLifeResponseBean squareDynamicLifeResponseBean = (SquareDynamicLifeResponseBean) this.s.get(i2);
                if (squareDynamicLifeResponseBean.userDailyLifeList != null) {
                    for (int i3 = 0; i3 < squareDynamicLifeResponseBean.userDailyLifeList.size(); i3++) {
                        if (squareDynamicLifeResponseBean.userDailyLifeList.get(i3).id == this.G) {
                            RecyclerView recyclerView = this.o;
                            if (i2 < this.s.size() - 1) {
                                i2++;
                            }
                            recyclerView.smoothScrollToPosition(i2);
                            this.G = -1L;
                            return;
                        }
                    }
                } else {
                    continue;
                }
            }
            i2++;
        }
    }

    public final void u0() {
        List<Object> list = this.s;
        if (list == null || list.size() == 0) {
            return;
        }
        for (Object obj : this.s) {
            if (obj instanceof ej1) {
                this.s.remove(obj);
                return;
            }
        }
    }

    public final void w0(boolean z, boolean z2) {
        List<Object> list;
        boolean z3 = false;
        if (z) {
            if (hx3.m(getContext())) {
                Toast.makeText(getContext(), "请求数据失败，请稍后重试", 0).show();
            } else {
                Toast.makeText(getContext(), getContext().getString(R$string.square_network_error), 0).show();
            }
            TextView textView = this.j;
            List<Object> list2 = this.s;
            textView.setVisibility((list2 == null || list2.isEmpty()) ? 0 : 8);
            this.k.setVisibility(8);
        } else {
            View view = this.k;
            List<Object> list3 = this.s;
            view.setVisibility((list3 == null || list3.isEmpty()) ? 0 : 8);
            this.j.setVisibility(8);
            if (z2 && (list = this.s) != null && list.size() > 0 && !this.v && !this.s.contains(this.C)) {
                this.s.add(this.C);
            }
            this.r.notifyDataSetChanged();
        }
        this.l.setVisibility(8);
        this.n.finishLoadMore(0);
        this.n.setEnableLoadMore(this.v);
        this.y = false;
        if (this.k.getVisibility() != 0 && this.j.getVisibility() != 0) {
            z3 = true;
        }
        E0(z3);
    }

    public int x0() {
        return this.x;
    }

    public final void y0(boolean z) {
        Log.i("PersonalDynamicLifeFragment", "load: " + z);
        if (this.q == null || this.w || this.y) {
            return;
        }
        if (!z) {
            this.B = null;
            this.A = null;
            this.z = null;
            this.s = new ArrayList();
            this.t = new ArrayList();
            this.u = 0L;
        }
        if (this.p == null) {
            this.p = bj5.b().c();
        }
        this.p.f(this.q.getUid(), this.q.getExid(), xn3.a(), this.u, B0(z));
        G0(z);
    }
}
