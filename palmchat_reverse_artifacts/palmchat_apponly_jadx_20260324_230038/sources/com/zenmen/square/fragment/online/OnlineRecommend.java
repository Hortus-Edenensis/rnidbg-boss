package com.zenmen.square.fragment.online;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseLazyFragment;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.ui.widget.FindSelectTabView;
import defpackage.a46;
import defpackage.a74;
import defpackage.ds0;
import defpackage.hc2;
import defpackage.hx3;
import defpackage.i53;
import defpackage.l50;
import defpackage.n53;
import defpackage.qm5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.to2;
import defpackage.u93;
import defpackage.y64;
import defpackage.z64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class OnlineRecommend extends BaseLazyFragment implements to2 {
    public ViewGroup A;
    public TextView B;
    public String M;
    public FindSelectTabView S;
    public View U;
    public View V;
    public View j;
    public int k;
    public TextView l;
    public TextView m;
    public View n;
    public TextView o;
    public ImageView p;
    public TextView q;
    public View r;
    public View s;
    public TextView t;
    public TextView u;
    public LineMyRecyclerView v;
    public FrameLayout w;
    public ViewGroup x;
    public ViewGroup y;
    public ViewGroup z;
    public int C = 1;
    public int E = 0;
    public int F = 0;
    public int G = Integer.MAX_VALUE;
    public HashMap<Integer, List<OnLineItemData>> H = new HashMap<>();
    public List<OnLineStatusItem> I = null;
    public final int J = 1;
    public int K = 0;
    public Timer L = null;
    public OnLinePublicDialog N = null;
    public boolean O = false;
    public boolean P = false;
    public boolean Q = false;
    public boolean R = false;
    public View T = null;
    public Handler W = new e(Looper.getMainLooper());
    public long X = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            OnlineRecommend.this.D1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            OnlineRecommend.this.D1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 1) {
                return;
            }
            OnlineRecommend.k0(OnlineRecommend.this);
            if (OnlineRecommend.this.K < 0) {
                OnlineRecommend.this.t1();
            } else if (OnlineRecommend.this.m != null) {
                TextView textView = OnlineRecommend.this.m;
                OnlineRecommend onlineRecommend = OnlineRecommend.this;
                textView.setText(onlineRecommend.v1(onlineRecommend.K));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends TimerTask {
        public f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            OnlineRecommend.this.W.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y64 f16386a;

        public g(y64 y64Var) {
            this.f16386a = y64Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f16386a.f22148a;
            if (i == 1) {
                OnlineRecommend.this.x1(false, false);
                if (this.f16386a.b == null || OnlineRecommend.this.v == null) {
                    return;
                }
                LineMyRecyclerView lineMyRecyclerView = OnlineRecommend.this.v;
                y64 y64Var = this.f16386a;
                lineMyRecyclerView.insertMineItem(y64Var.b, y64Var.c);
                return;
            }
            if (i == 2) {
                if (OnlineRecommend.this.v != null) {
                    OnlineRecommend.this.v.startAutoRecyclerScroll();
                }
            } else {
                if (i != 2 || OnlineRecommend.this.v == null) {
                    return;
                }
                OnlineRecommend.this.v.stopAutoRecyclerScroll();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OnlineRecommend onlineRecommend = OnlineRecommend.this;
            onlineRecommend.k = onlineRecommend.w.getHeight();
            OnlineRecommend onlineRecommend2 = OnlineRecommend.this;
            onlineRecommend2.E = onlineRecommend2.k / OnlineRecommend.this.F;
            LogUtil.d("OnLineManagerTag", " initAllOnlineDataLayout onLineRecycleHeight " + OnlineRecommend.this.k + " onLineRecycleNum " + OnlineRecommend.this.E);
            if (OnlineRecommend.this.E > 0) {
                OnlineRecommend.this.H1();
            } else {
                OnlineRecommend.this.p1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (OnlineRecommend.this.X != 0 && jCurrentTimeMillis - OnlineRecommend.this.X <= 3000) {
                sy5.h(OnlineRecommend.this.getContext(), "刷新操作频繁，请稍后再试", 0);
                return;
            }
            OnlineRecommend.this.X = System.currentTimeMillis();
            boolean zIsSelected = OnlineRecommend.this.T.isSelected();
            z64.q(!zIsSelected ? 1 : 0, "click");
            OnlineRecommend.this.T.setSelected(!zIsSelected);
            OnlineRecommend.this.J1();
            OnlineRecommend.this.A1(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            OnlineRecommend.this.s1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (OnlineRecommend.this.I == null || OnlineRecommend.this.I.size() == 0) {
                OnlineRecommend.this.x1(true, false);
            } else {
                OnlineRecommend.this.K1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            OnlineRecommend.this.G1();
        }
    }

    public static /* synthetic */ int V0(OnlineRecommend onlineRecommend) {
        int i2 = onlineRecommend.C;
        onlineRecommend.C = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int k0(OnlineRecommend onlineRecommend) {
        int i2 = onlineRecommend.K;
        onlineRecommend.K = i2 - 1;
        return i2;
    }

    public void A1(boolean z) {
        if (z) {
            this.C = 1;
            this.G = 1;
            this.R = false;
        }
        LogUtil.d("OnLineManagerTag", "loadOnlineData pageNo " + this.C + " lineMaxPage " + this.G + " refresh " + z + " lineListNull " + this.R);
        if (this.R) {
            m1();
        } else {
            com.zenmen.palmchat.location.d.g().k(LocationScene.ONLINE_LOCATION, new d(z));
        }
    }

    public void B1() {
        r1();
    }

    public void C1() {
        this.O = true;
        if (this.j != null) {
            x1(true, false);
        }
    }

    public final void D1() {
        if (hx3.m(getContext())) {
            r1();
        }
    }

    public final void E1() {
        this.r.setVisibility(8);
        this.s.setVisibility(0);
        this.l.setVisibility(0);
        this.n.setVisibility(8);
    }

    public void F1() {
        LogUtil.d("OnLineManagerTag", "onLineRefreshClick");
        A1(true);
    }

    public final void G1() {
        if (a46.o()) {
            if (a46.q()) {
                return;
            }
            BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) getContext(), BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_ONLINE_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.FIND_FRIEND_GET_LOCATION);
        } else {
            try {
                getContext().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void H1() {
        x1(false, false);
        r1();
    }

    public void I1(FindSelectTabView findSelectTabView) {
        this.S = findSelectTabView;
    }

    public final void J1() {
        if (this.T.isSelected()) {
            this.U.setVisibility(8);
            this.V.setVisibility(0);
        } else {
            this.U.setVisibility(0);
            this.V.setVisibility(8);
        }
    }

    @Override // com.zenmen.palmchat.BaseLazyFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        this.P = z;
        if (!z) {
            LineMyRecyclerView lineMyRecyclerView = this.v;
            if (lineMyRecyclerView != null) {
                lineMyRecyclerView.stopAutoRecyclerScroll();
                return;
            }
            return;
        }
        if (this.j != null && this.E > 0) {
            r1();
            this.v.startAutoRecyclerScroll();
            x1(false, true);
        }
        z64.t();
        if (this.w != null) {
            LogUtil.d("", "initAllOnlineDataLayout onUserVisibleChange height " + this.w.getHeight());
        }
        if (this.S != null) {
            LogUtil.d("OnLineManagerTag", "OnLineManagerRed onUserVisibleChange hideShowRedDot");
            this.S.hideLineRedDot();
        }
    }

    public final void K1() {
        LogUtil.d("OnLineManagerTag", "showAddLineDialog statusItems " + this.I);
        z64.g();
        this.v.stopAutoRecyclerScroll();
        OnLinePublicDialog onLinePublicDialog = this.N;
        if (onLinePublicDialog != null && onLinePublicDialog.isShowing()) {
            this.N.dismiss();
            this.N = null;
        }
        OnLinePublicDialog onLinePublicDialog2 = new OnLinePublicDialog(getContext(), this.I);
        this.N = onLinePublicDialog2;
        onLinePublicDialog2.v(0.9f);
        this.N.x(2);
        this.N.getWindow().setSoftInputMode(34);
        this.N.show();
    }

    public final void L1() {
        LineMyRecyclerView lineMyRecyclerView;
        if (this.Q) {
            if (this.P && (lineMyRecyclerView = this.v) != null) {
                lineMyRecyclerView.startAutoRecyclerScrollUp();
            }
            this.x.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setVisibility(8);
            this.A.setVisibility(8);
            return;
        }
        LineMyRecyclerView lineMyRecyclerView2 = this.v;
        if (lineMyRecyclerView2 != null) {
            lineMyRecyclerView2.stopAutoRecyclerScroll();
        }
        this.x.setVisibility(8);
        this.y.setVisibility(0);
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        A1(false);
    }

    @Override // com.zenmen.palmchat.BaseLazyFragment
    public View W() {
        this.j = getLayoutInflater().inflate(R$layout.layout_online_fragment_allview, (ViewGroup) null, false);
        z1();
        E1();
        this.u.setText(z64.d);
        this.B.setText(z64.f);
        this.l.setText(z64.e);
        p1();
        if (this.O) {
            x1(true, false);
        }
        return this.j;
    }

    @Override // defpackage.to2
    public RecyclerView e() {
        return null;
    }

    @Override // defpackage.to2
    public String getSid() {
        return null;
    }

    public final void m1() {
        LineMyRecyclerView lineMyRecyclerView;
        if (this.G <= 0 || (lineMyRecyclerView = this.v) == null) {
            return;
        }
        if (lineMyRecyclerView.getAllSize() >= 10000) {
            A1(true);
            return;
        }
        int i2 = this.G;
        int i3 = i2 > 1 ? this.C % i2 : 1;
        if (i3 != 0) {
            i2 = i3;
        }
        if (this.H.containsKey(Integer.valueOf(i2))) {
            this.C++;
            this.v.setLineListValue(this.H.get(Integer.valueOf(i2)));
        }
    }

    public boolean n1() {
        OnLinePublicDialog onLinePublicDialog = this.N;
        return onLinePublicDialog == null || !onLinePublicDialog.isShowing();
    }

    @Override // com.zenmen.palmchat.BaseLazyFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ds0.a().c(this);
        this.F = a46.b(getContext(), 82.0f);
        LogUtil.d("OnLineManagerTag", "OnlineRecommend onCreate  rootView " + this.j);
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.C = 1;
        this.H.clear();
        Timer timer = this.L;
        if (timer != null) {
            timer.cancel();
            this.L = null;
        }
        try {
            ds0.a().d(this);
        } catch (Exception unused) {
        }
    }

    @qm5
    public void onLineEvent(y64 y64Var) {
        if (y64Var != null) {
            u93.c(new g(y64Var));
        }
    }

    public final void p1() {
        this.j.postDelayed(new i(), 50L);
    }

    public final void r1() {
        if (this.j == null) {
            return;
        }
        if (!hx3.m(getContext())) {
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.z.setVisibility(0);
            this.A.setVisibility(8);
            LineMyRecyclerView lineMyRecyclerView = this.v;
            if (lineMyRecyclerView != null) {
                lineMyRecyclerView.stopAutoRecyclerScroll();
                return;
            }
            return;
        }
        if (a46.p()) {
            L1();
            return;
        }
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
        this.A.setVisibility(0);
        LineMyRecyclerView lineMyRecyclerView2 = this.v;
        if (lineMyRecyclerView2 != null) {
            lineMyRecyclerView2.stopAutoRecyclerScroll();
        }
    }

    public final void s1() {
        new sd3(getActivity()).k("确认删除当前活跃状态？删除后你将无法在活跃大厅中曝光").L("取消").h(false).P("确认").f(new c()).e().show();
    }

    public final void t1() {
        Timer timer = this.L;
        if (timer != null) {
            timer.cancel();
            this.L = null;
        }
        x1(false, false);
    }

    public int u1() {
        return this.E;
    }

    public final String v1(int i2) {
        return z64.x(i2) + " 后状态自动过期";
    }

    public final void w1() {
        this.r.setVisibility(0);
        this.s.setVisibility(8);
        this.l.setVisibility(8);
        this.n.setVisibility(0);
    }

    public final void x1(boolean z, boolean z2) {
        z64.F(z2, new h(z));
    }

    public final void y1() {
        if (this.L == null) {
            Timer timer = new Timer();
            this.L = timer;
            timer.schedule(new f(), 1000L, 1000L);
        }
    }

    public final void z1() {
        this.l = (TextView) this.j.findViewById(R$id.online_status_desc_view);
        this.m = (TextView) this.j.findViewById(R$id.online_status_time);
        this.n = this.j.findViewById(R$id.online_status_dt_layout);
        this.o = (TextView) this.j.findViewById(R$id.online_status_delete);
        this.p = (ImageView) this.j.findViewById(R$id.online_status_show_msg_img);
        this.q = (TextView) this.j.findViewById(R$id.online_status_show_msg_text);
        this.r = this.j.findViewById(R$id.online_status_show_msg_layout);
        this.s = this.j.findViewById(R$id.online_status_add_layout);
        this.u = (TextView) this.j.findViewById(R$id.online_status_add_btn_title);
        this.w = (FrameLayout) this.j.findViewById(R$id.online_data_layout);
        this.z = (ViewGroup) this.j.findViewById(R$id.online_net_error_layout);
        this.A = (ViewGroup) this.j.findViewById(R$id.online_location_error_layout);
        this.x = (ViewGroup) this.j.findViewById(R$id.online_data_success_layout);
        this.y = (ViewGroup) this.j.findViewById(R$id.online_data_error_layout);
        LineMyRecyclerView lineMyRecyclerView = (LineMyRecyclerView) this.j.findViewById(R$id.line_recyclerview);
        this.v = lineMyRecyclerView;
        lineMyRecyclerView.setLineRecommend(this);
        this.t = (TextView) this.j.findViewById(R$id.location_check);
        this.U = this.j.findViewById(R$id.sex_line_normal);
        this.V = this.j.findViewById(R$id.sex_line_select);
        View viewFindViewById = this.j.findViewById(R$id.sex_filter_layout);
        this.T = viewFindViewById;
        viewFindViewById.setSelected(true);
        this.T.setOnClickListener(new j());
        J1();
        this.t.setText(Html.fromHtml("<p ><span style=\"color: #999999; font-size: 12px\">活跃大厅会推荐你附近的活跃用户状态请先</span><span style=\"color: #14CD64\">授权位置权限</span></p>"));
        this.B = (TextView) this.j.findViewById(R$id.online_status_title);
        this.o.setOnClickListener(new k());
        this.s.setOnClickListener(new l());
        this.t.setOnClickListener(new m());
        this.j.findViewById(R$id.net_err_img).setOnClickListener(new a());
        this.j.findViewById(R$id.net_err_refresh).setOnClickListener(new b());
    }

    @Override // defpackage.to2
    public void A() {
    }

    @Override // defpackage.to2
    public void x() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            z64.A(OnlineRecommend.this.M, new a());
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a74 {
            public a() {
            }

            @Override // defpackage.a74
            public void onSuccess(Object obj) {
                OnlineRecommend.this.x1(false, false);
            }

            @Override // defpackage.a74
            public void onError(String str) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements i53 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16382a;

        public d(boolean z) {
            this.f16382a = z;
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            LogUtil.d("OnLineManagerTag", " loadOnlineData onLocationReceived location " + locationEx);
            z64.E(OnlineRecommend.this.T.isSelected(), OnlineRecommend.this.C, System.currentTimeMillis() + "", locationEx, new a());
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a74 {
            public a() {
            }

            @Override // defpackage.a74
            public void onSuccess(Object obj) {
                if (obj instanceof OnLineAllData) {
                    d dVar = d.this;
                    if (dVar.f16382a) {
                        OnlineRecommend.this.H.clear();
                        OnlineRecommend.this.v.initRefreshPos();
                    }
                    OnLineAllData onLineAllData = (OnLineAllData) obj;
                    List<OnLineItemData> list = onLineAllData.list;
                    if (list == null || list.size() <= 0) {
                        OnlineRecommend.this.R = true;
                        OnlineRecommend onlineRecommend = OnlineRecommend.this;
                        onlineRecommend.G = onlineRecommend.C - 1;
                        d dVar2 = d.this;
                        if (dVar2.f16382a) {
                            OnlineRecommend.this.Q = false;
                        } else {
                            OnlineRecommend.this.m1();
                        }
                    } else {
                        OnlineRecommend.this.Q = true;
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < onLineAllData.list.size(); i++) {
                            arrayList.add(onLineAllData.list.get(i));
                        }
                        OnlineRecommend.this.H.put(Integer.valueOf(OnlineRecommend.this.C), arrayList);
                        OnlineRecommend.V0(OnlineRecommend.this);
                        OnlineRecommend onlineRecommend2 = OnlineRecommend.this;
                        onlineRecommend2.G = onlineRecommend2.C;
                        OnlineRecommend.this.v.initLineRecyclerView();
                        OnlineRecommend.this.v.setLineListValue(onLineAllData.list);
                    }
                    OnlineRecommend.this.L1();
                }
            }

            @Override // defpackage.a74
            public void onError(String str) {
            }
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements a74 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16387a;

        public h(boolean z) {
            this.f16387a = z;
        }

        @Override // defpackage.a74
        public void onSuccess(Object obj) {
            if (OnlineRecommend.this.getActivity() == null || OnlineRecommend.this.getActivity().isFinishing() || OnlineRecommend.this.j == null || !(obj instanceof OnLineStatusData)) {
                return;
            }
            try {
                LogUtil.d("", "initMyLineStatus onSuccess start ");
                OnLineStatusData onLineStatusData = (OnLineStatusData) obj;
                if (!(!TextUtils.isEmpty(onLineStatusData.id) && onLineStatusData.expireSeconds > 0)) {
                    OnlineRecommend.this.M = "";
                    OnlineRecommend.this.E1();
                    OnlineRecommend.this.I = onLineStatusData.items;
                    if (this.f16387a) {
                        OnlineRecommend.this.K1();
                        return;
                    }
                    return;
                }
                OnlineRecommend.this.M = onLineStatusData.id;
                OnlineRecommend.this.w1();
                if (!TextUtils.isEmpty(onLineStatusData.bgColor)) {
                    Drawable background = OnlineRecommend.this.r.getBackground();
                    try {
                        if (background instanceof GradientDrawable) {
                            ((GradientDrawable) background).setColor(Color.parseColor(onLineStatusData.bgColor));
                        }
                    } catch (Exception unused) {
                    }
                }
                if (!TextUtils.isEmpty(onLineStatusData.url)) {
                    hc2.a(OnlineRecommend.this.getContext()).load(onLineStatusData.url).error(R$drawable.online_status_msg_bg).into(OnlineRecommend.this.p);
                }
                if (!TextUtils.isEmpty(onLineStatusData.content)) {
                    OnlineRecommend.this.q.setText(onLineStatusData.content);
                }
                int i = onLineStatusData.expireSeconds;
                if (i > 0) {
                    OnlineRecommend.this.K = i;
                    TextView textView = OnlineRecommend.this.m;
                    OnlineRecommend onlineRecommend = OnlineRecommend.this;
                    textView.setText(onlineRecommend.v1(onlineRecommend.K));
                    OnlineRecommend.this.y1();
                }
            } catch (Exception e) {
                LogUtil.d("", "onSuccess Exception " + e.toString());
            }
        }

        @Override // defpackage.a74
        public void onError(String str) {
        }
    }

    @Override // defpackage.to2
    public void i(boolean z) {
    }

    @Override // defpackage.to2
    public void n(RecyclerView.OnScrollListener onScrollListener) {
    }

    @Override // defpackage.to2
    public void u(String str) {
    }

    @Override // defpackage.to2
    public void z(boolean z) {
    }
}
