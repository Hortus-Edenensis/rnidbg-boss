package com.zenmen.palmchat.peoplenearby;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.discover.DiscoverFunction;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.peoplenearby.ad.PeopleNearbyAdLoadMore;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.SlideUpLayout;
import defpackage.bn0;
import defpackage.bo0;
import defpackage.ch;
import defpackage.ds0;
import defpackage.eg4;
import defpackage.fk2;
import defpackage.fn0;
import defpackage.hx3;
import defpackage.i53;
import defpackage.ig4;
import defpackage.is0;
import defpackage.jg4;
import defpackage.jo6;
import defpackage.k86;
import defpackage.lu3;
import defpackage.m92;
import defpackage.ma3;
import defpackage.n53;
import defpackage.on0;
import defpackage.qm5;
import defpackage.r75;
import defpackage.sd3;
import defpackage.st2;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.tn0;
import defpackage.u13;
import defpackage.u34;
import defpackage.uk5;
import defpackage.v42;
import defpackage.vt2;
import defpackage.vu3;
import defpackage.wc0;
import defpackage.wv3;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PeopleNearbyActivity extends BaseActionBarActivity implements i53, eg4, jg4 {
    public static final String D0 = "PeopleNearbyActivity";
    public ContactInfoItem A;
    public boolean A0;
    public String B;
    public final is0.f B0;
    public MaterialDialog C0;
    public View G;
    public View H;
    public TextView I;
    public LocationEx J;
    public int P;
    public String[] T;
    public wc0 V;
    public m92 W;
    public Response.Listener<JSONObject> X;
    public Response.ErrorListener Y;
    public int Z;
    public com.zenmen.palmchat.peoplenearby.ad.e h0;
    public PeopleNearbyAdLoadMore.Status i0;
    public PeopleNearbyAdLoadMore.Status j0;
    public boolean k0;
    public boolean l0;
    public boolean m0;
    public boolean n0;
    public boolean o0;
    public boolean p0;
    public ig4 q;
    public final int q0;
    public Toolbar r;
    public boolean r0;
    public ListView s;
    public boolean s0;
    public ListView t;
    public boolean t0;
    public LinearLayout u;
    public int u0;
    public TextView v;
    public int v0;
    public ImageView w;
    public int w0;
    public SlideUpLayout x;
    public int x0;
    public BaseAdapter y;
    public boolean y0;
    public BaseAdapter z;
    public final boolean z0;
    public final ArrayList<PeopleNearbyVo> C = new ArrayList<>();
    public final ArrayList<PeopleNearbyVo> E = new ArrayList<>();
    public final ArrayList<PeopleNearbyVo> F = new ArrayList<>();
    public boolean K = false;
    public int L = 0;
    public int M = 1;
    public int N = 0;
    public int O = 1;
    public boolean Q = false;
    public boolean R = true;
    public boolean S = false;
    public final int[] U = {R.drawable.nearby_female_only, R.drawable.nearby_male_only, R.drawable.nearby_view_all, R.drawable.nearby_more_sayhi, R.drawable.nearby_clean};
    public final boolean e0 = false;
    public boolean f0 = false;
    public boolean g0 = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements vu3.d {
        public a() {
        }

        @Override // vu3.d
        public void a() {
            PeopleNearbyActivity.this.E2();
        }

        @Override // vu3.d
        public void onAdClosed() {
            PeopleNearbyActivity.this.E2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a0 implements fk2 {
        @Override // defpackage.fk2
        public Intent a(Context context, fk2.a aVar) {
            int i = (aVar == null || aVar.a() == null) ? 0 : aVar.a().getInt("fromType");
            Intent intentC = st2.c();
            intentC.putExtra("fromType", i);
            return intentC;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements is0.f {
        public b() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            LogUtil.uploadInfoImmediate(PeopleNearbyActivity.this.B, "311", "1", null, null);
            if (tg4.b(PeopleNearbyActivity.this, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
                if (i == 0) {
                    PeopleNearbyActivity.this.P = 1;
                    r75.p(PeopleNearbyActivity.this, k86.a("last_nearby_gender"), PeopleNearbyActivity.this.P);
                    PeopleNearbyActivity.this.R2();
                    return;
                }
                if (i == 1) {
                    PeopleNearbyActivity.this.P = 0;
                    r75.p(PeopleNearbyActivity.this, k86.a("last_nearby_gender"), PeopleNearbyActivity.this.P);
                    PeopleNearbyActivity.this.R2();
                } else if (i == 2) {
                    PeopleNearbyActivity.this.P = 2;
                    r75.p(PeopleNearbyActivity.this, k86.a("last_nearby_gender"), PeopleNearbyActivity.this.P);
                    PeopleNearbyActivity.this.R2();
                } else if (i == 3) {
                    PeopleNearbyActivity.this.F2();
                } else {
                    if (i != 4) {
                        return;
                    }
                    PeopleNearbyActivity.this.A2();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            PeopleNearbyActivity.this.hideBaseProgressBar();
            sy5.e(PeopleNearbyActivity.this, R.string.nearby_clean_fail, 0).g();
            LogUtil.d(PeopleNearbyActivity.D0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                ch.s().y0(0L, true);
                PeopleNearbyActivity.this.finish();
            }
        }

        public d() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            PeopleNearbyActivity.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                new sd3(PeopleNearbyActivity.this).j(R.string.nearby_dialog_cleaned).O(R.string.alert_dialog_ok).f(new a()).e().show();
                LogUtil.uploadInfoImmediate(PeopleNearbyActivity.this.B, "3114", "1", "1", null);
            } else {
                sy5.e(PeopleNearbyActivity.this, R.string.nearby_clean_fail, 0).g();
                LogUtil.uploadInfoImmediate(PeopleNearbyActivity.this.B, "3114", "1", "2", null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14951a;

        public e(String str) {
            this.f14951a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PeopleNearbyActivity.this.r0 = false;
            PeopleNearbyActivity.this.k0 = false;
            PeopleNearbyActivity.this.t0 = true;
            PeopleNearbyActivity.this.h0.F();
            PeopleNearbyActivity.this.y2(true);
            PeopleNearbyActivity.this.updateViews();
            PeopleNearbyActivity.this.z2();
            com.zenmen.palmchat.peoplenearby.ad.c.a().e(this.f14951a).f("x_client_sdkad_tvS").a(com.zenmen.palmchat.peoplenearby.ad.e.g()).h((int) PeopleNearbyActivity.this.h0.t()).k();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14952a;

        public f(int i) {
            this.f14952a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int headerViewsCount = PeopleNearbyActivity.this.s.getHeaderViewsCount();
            ma3.a("logad smooth mSelectPosition = " + PeopleNearbyActivity.this.w0 + ",scrollPos:" + this.f14952a + " adapter:" + PeopleNearbyActivity.this.y.getCount() + " ,mPullData:" + PeopleNearbyActivity.this.E.size(), new Object[0]);
            PeopleNearbyActivity.this.s.smoothScrollToPosition(this.f14952a + headerViewsCount);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f14953a;
        public final /* synthetic */ int b;

        public g(y yVar, int i) {
            this.f14953a = yVar;
            this.b = i;
            put("action", "nearby_location");
            put("loca_auth", 2);
            put("loca_get", 0);
            put("loca_detail", yVar);
            put("loca_code", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f14954a;
        public final /* synthetic */ int b;

        public h(y yVar, int i) {
            this.f14954a = yVar;
            this.b = i;
            put("action", "nearby_location");
            put("loca_auth", 2);
            put("loca_get", 1);
            put("loca_detail", yVar);
            put("loca_code", Integer.valueOf(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends HashMap<String, Object> {
        public i() {
            put("action", "nearby");
            put("status", "get_location_fail");
            put("detail", "Failed to get location ");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends MaterialDialog.e {
        public j() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            try {
                Intent intent = new Intent();
                intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                PeopleNearbyActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.Listener<JSONObject> {
        public k() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject;
            PeopleNearbyActivity.this.hideBaseProgressBar();
            boolean z = false;
            PeopleNearbyActivity.this.Q = false;
            if (PeopleNearbyActivity.this.R) {
                PeopleNearbyActivity peopleNearbyActivity = PeopleNearbyActivity.this;
                peopleNearbyActivity.j0 = peopleNearbyActivity.i0;
            }
            try {
                int i = 1;
                if (jSONObject.getInt("resultCode") != 0 || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
                    PeopleNearbyActivity.this.q.l(true, PeopleNearbyActivity.this.P, PeopleNearbyActivity.this.L, PeopleNearbyActivity.this.E.size(), PeopleNearbyActivity.this.l0);
                } else {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("users");
                    PeopleNearbyActivity.this.M = jSONObjectOptJSONObject.optInt("continueFlag");
                    PeopleNearbyActivity.this.L = jSONObjectOptJSONObject.optInt("nextIndex");
                    PeopleNearbyActivity.this.u0 = jSONObjectOptJSONObject.optInt("totalUsersCount");
                    LogUtil.i("logad", "continueFlag = " + PeopleNearbyActivity.this.M);
                    if (PeopleNearbyActivity.this.R) {
                        LogUtil.i("logad", "totalUsersCount = " + PeopleNearbyActivity.this.u0);
                        PeopleNearbyActivity peopleNearbyActivity2 = PeopleNearbyActivity.this;
                        if (peopleNearbyActivity2.u0 >= com.zenmen.palmchat.peoplenearby.ad.e.o() && PeopleNearbyActivity.this.j0 == PeopleNearbyAdLoadMore.Status.NORMAL) {
                            z = true;
                        }
                        peopleNearbyActivity2.k0 = z;
                        if (PeopleNearbyActivity.this.k0) {
                            com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_nearByS").j();
                        }
                        PeopleNearbyActivity peopleNearbyActivity3 = PeopleNearbyActivity.this;
                        peopleNearbyActivity3.m0 = peopleNearbyActivity3.k0;
                        PeopleNearbyActivity peopleNearbyActivity4 = PeopleNearbyActivity.this;
                        peopleNearbyActivity4.o0 = peopleNearbyActivity4.k0;
                        PeopleNearbyActivity peopleNearbyActivity5 = PeopleNearbyActivity.this;
                        peopleNearbyActivity5.n0 = peopleNearbyActivity5.k0;
                        PeopleNearbyActivity peopleNearbyActivity6 = PeopleNearbyActivity.this;
                        peopleNearbyActivity6.p0 = peopleNearbyActivity6.k0;
                    }
                    if (jSONArrayOptJSONArray != null) {
                        LogUtil.i(PeopleNearbyActivity.D0, "jsonArray count=" + jSONArrayOptJSONArray.length());
                        LogUtil.i("logad", "jsonArray = " + jSONArrayOptJSONArray.length());
                        ArrayList<PeopleNearbyVo> arrayListNearbyListFromJson = PeopleNearbyVo.nearbyListFromJson(jSONArrayOptJSONArray);
                        PeopleNearbyActivity.this.E.addAll(arrayListNearbyListFromJson);
                        PeopleNearbyActivity.this.q.l(false, PeopleNearbyActivity.this.P, PeopleNearbyActivity.this.L, PeopleNearbyActivity.this.E.size(), PeopleNearbyActivity.this.l0);
                        if (jo6.v()) {
                            Iterator<PeopleNearbyVo> it = arrayListNearbyListFromJson.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                PeopleNearbyVo next = it.next();
                                if (!PeopleNearbyActivity.this.f0 && !TextUtils.isEmpty(next.getCarImageUrl())) {
                                    PeopleNearbyActivity.this.f0 = true;
                                    LogUtil.uploadInfoImmediate("fjdrzj001", null, null, null);
                                    break;
                                }
                            }
                        }
                    } else {
                        PeopleNearbyActivity.this.q.l(true, PeopleNearbyActivity.this.P, PeopleNearbyActivity.this.L, PeopleNearbyActivity.this.E.size(), PeopleNearbyActivity.this.l0);
                    }
                    PeopleNearbyActivity.this.updateViews();
                }
                if (PeopleNearbyActivity.this.E.isEmpty()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        if (!TeenagersModeManager.a().d()) {
                            i = 2;
                        }
                        jSONObject2.put("status", i);
                        LogUtil.onClickEvent("nearby_list_empty", null, jSONObject2.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } catch (JSONException e2) {
                PeopleNearbyActivity.this.q.l(true, PeopleNearbyActivity.this.P, PeopleNearbyActivity.this.L, PeopleNearbyActivity.this.E.size(), PeopleNearbyActivity.this.l0);
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.ErrorListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VolleyError f14959a;

            public a(VolleyError volleyError) {
                this.f14959a = volleyError;
                put("action", "nearby_get_list_nearby");
                put("status", "fail");
                put("detail", "error=" + volleyError.toString());
            }
        }

        public l() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            PeopleNearbyActivity.this.Q = false;
            PeopleNearbyActivity.this.hideBaseProgressBar();
            LogUtil.i(PeopleNearbyActivity.D0, 3, new a(volleyError), (Throwable) null);
            PeopleNearbyActivity.this.q.l(true, PeopleNearbyActivity.this.P, PeopleNearbyActivity.this.L, PeopleNearbyActivity.this.E.size(), PeopleNearbyActivity.this.l0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PeopleNearbyActivity.this.y != null) {
                PeopleNearbyActivity.this.y.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f14961a;

        public n(uk5 uk5Var) {
            this.f14961a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14961a.f21235a == 11 && PeopleNearbyActivity.this.q != null) {
                PeopleNearbyActivity.this.q.p();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements vu3.d {
        public o() {
        }

        @Override // vu3.d
        public void a() {
            PeopleNearbyActivity.this.S2();
        }

        @Override // vu3.d
        public void onAdClosed() {
            PeopleNearbyActivity.this.S2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Response.ErrorListener {
        public p() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(PeopleNearbyActivity.D0, "notifyExit: " + volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements Response.Listener<JSONObject> {
        public q() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            int iOptInt = jSONObject.optInt("resultCode");
            LogUtil.d(PeopleNearbyActivity.D0, "notifyExit: resultCode=" + iOptInt);
            if (iOptInt == 0) {
                SPUtil.f14322a.t(SPUtil.SCENE.NEARBY, k86.a("nearby_notify_exit"), Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements SlideUpLayout.d {
        public r() {
        }

        @Override // com.zenmen.palmchat.widget.SlideUpLayout.d
        public void a() {
            PeopleNearbyActivity.this.h3();
        }

        @Override // com.zenmen.palmchat.widget.SlideUpLayout.d
        public void b(boolean z) {
            if (PeopleNearbyActivity.this.q != null) {
                PeopleNearbyActivity.this.q.q(z);
            }
        }

        @Override // com.zenmen.palmchat.widget.SlideUpLayout.d
        public void c() {
            com.zenmen.palmchat.peoplenearby.ad.c.a().f("lx_nearby_up1px").a(com.zenmen.palmchat.peoplenearby.ad.e.g()).k();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements AdapterView.OnItemClickListener {
        public s() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PeopleNearbyVo peopleNearbyVo = (PeopleNearbyVo) adapterView.getItemAtPosition(i);
            if (peopleNearbyVo == null || !peopleNearbyVo.isUnlockAdTip()) {
                if (peopleNearbyVo == null || !PeopleNearbyActivity.this.g3(peopleNearbyVo.isRewardAd())) {
                    if (!TextUtils.isEmpty(peopleNearbyVo.getCarImageUrl())) {
                        LogUtil.uploadInfoImmediate("fjdrzj003", null, null, null, null);
                    }
                    if (peopleNearbyVo.getDistanceHint() == null) {
                        if (TextUtils.isEmpty(peopleNearbyVo.getUid())) {
                            LogUtil.uploadInfoImmediate("pnitemempty", null, null, null, null);
                        } else {
                            ig4.h(PeopleNearbyActivity.this, peopleNearbyVo, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements AbsListView.OnScrollListener {
        public t() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (com.zenmen.palmchat.peoplenearby.ad.e.B()) {
                PeopleNearbyActivity.this.Y2(i, i2);
            } else if (com.zenmen.palmchat.peoplenearby.ad.e.C()) {
                PeopleNearbyActivity.this.a3(i, i2);
            } else {
                PeopleNearbyActivity.this.Z2(i, i2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        
            r1.f14967a.g0 = true;
            com.zenmen.palmchat.utils.log.LogUtil.uploadInfoImmediate("fjdrzj002", null, null, null);
         */
        @Override // android.widget.AbsListView.OnScrollListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                if (!PeopleNearbyActivity.this.g0 && jo6.v()) {
                    try {
                        int firstVisiblePosition = absListView.getFirstVisiblePosition();
                        int lastVisiblePosition = absListView.getLastVisiblePosition();
                        while (true) {
                            if (firstVisiblePosition < lastVisiblePosition) {
                                if (firstVisiblePosition < PeopleNearbyActivity.this.y.getCount() && !TextUtils.isEmpty(((PeopleNearbyVo) PeopleNearbyActivity.this.y.getItem(firstVisiblePosition)).getCarImageUrl())) {
                                    break;
                                } else {
                                    firstVisiblePosition++;
                                }
                            } else {
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                PeopleNearbyActivity.this.z2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
            }
            PeopleNearbyActivity.this.startActivity(on0.a("upload_contact_from_nearby"));
            LogUtil.uploadInfoImmediate("25", null, null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.uploadInfoImmediate("3301", null, null, null);
            int i = TextUtils.isEmpty(tn0.i().k()) ? 2 : 1;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.x.cw, i);
                LogUtil.uploadInfoImmediate("fjdrzj008", null, null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            PeopleNearbyActivity.this.F2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PeopleNearbyActivity peopleNearbyActivity = PeopleNearbyActivity.this;
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.LOCATION;
            if (tg4.d(peopleNearbyActivity, permissionType.permissionList)) {
                BaseActivityPermissionDispatcher.b(PeopleNearbyActivity.this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.PEOPLE_NEARBY_LOCATION);
            } else {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", PeopleNearbyActivity.this.getPackageName(), null));
                PeopleNearbyActivity.this.startActivity(intent);
            }
            zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_permission_1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PeopleNearbyActivity.this.V2();
            PeopleNearbyActivity.this.b3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f14972a;
        public double b;

        public y(LocationEx locationEx) {
            if (locationEx == null) {
                return;
            }
            this.f14972a = locationEx.getLatitude();
            this.b = locationEx.getLongitude();
        }

        public String toString() {
            return "(" + Double.valueOf(this.b).toString() + "," + Double.valueOf(this.f14972a).toString() + ")";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface z {
        void a(ArrayList<PeopleNearbyVo> arrayList, int i);
    }

    public PeopleNearbyActivity() {
        PeopleNearbyAdLoadMore.Status status = PeopleNearbyAdLoadMore.Status.DISABLE;
        this.i0 = status;
        this.j0 = status;
        this.k0 = false;
        this.l0 = false;
        this.m0 = false;
        this.n0 = false;
        this.o0 = false;
        this.p0 = false;
        this.q0 = 10;
        this.r0 = false;
        this.s0 = false;
        this.t0 = false;
        this.y0 = true;
        this.z0 = false;
        this.A0 = false;
        this.B0 = new b();
        this.C0 = null;
    }

    public final void A2() {
        c cVar = new c();
        d dVar = new d();
        if (this.V == null) {
            this.V = new wc0(dVar, cVar);
        }
        try {
            this.V.n();
            showBaseProgressBar(R.string.nearby_loading_clean, false);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public LocationEx B2() {
        return this.J;
    }

    public final void C2(boolean z2) {
        PeopleNearbyAdLoadMore.Status status;
        if (this.J == null) {
            return;
        }
        this.R = z2;
        m92 m92Var = this.W;
        if (m92Var != null) {
            m92Var.onCancel();
        }
        if (this.N >= 500) {
            l3();
            return;
        }
        int i2 = this.M;
        if (i2 == 1 || i2 == 2) {
            this.W = new m92(this.X, this.Y, false);
            try {
                if (z2) {
                    k3();
                    status = this.i0;
                } else {
                    status = this.j0;
                }
                if (z2) {
                    com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_nearByA").j();
                }
                if (status == PeopleNearbyAdLoadMore.Status.DISABLE) {
                    this.W.p(this.q.e(this.J, this.P, this.O, this.Z), this.L);
                } else {
                    boolean z3 = status == PeopleNearbyAdLoadMore.Status.NORMAL;
                    if (z2 && z3) {
                        com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_nearByB").j();
                    }
                    this.W.q(this.q.f(this.J, this.P, this.O, this.Z, z3), this.L);
                    LogUtil.d("logad", "getNearbyV10 inspireVideoFeature = " + z3);
                }
                this.Q = true;
            } catch (DaoException e2) {
                e2.printStackTrace();
                hideBaseProgressBar();
            } catch (JSONException e3) {
                e3.printStackTrace();
                hideBaseProgressBar();
            }
        }
        this.N++;
    }

    public final PeopleNearbyVo D2() {
        PeopleNearbyVo peopleNearbyVo = new PeopleNearbyVo();
        peopleNearbyVo.setUnlockAdTip(true);
        return peopleNearbyVo;
    }

    public final void E2() {
        lu3.a();
        Q2();
        finish();
    }

    public final void F2() {
        startActivity(new Intent(this, (Class<?>) NearbyHistoryActivity.class));
    }

    public final void G2(int i2) {
        Object item;
        if (this.p0 && this.k0 && i2 >= 0 && i2 < this.y.getCount() && (item = this.y.getItem(i2)) != null) {
            int iIndexOf = this.E.indexOf(item);
            int iD = com.zenmen.palmchat.peoplenearby.ad.e.d();
            if (iIndexOf >= iD - 10) {
                int i3 = iD + 10;
                LogUtil.d(D0, "logad smooth---- dataIndex = " + iIndexOf + ",expectCount" + i3 + " adapter:" + this.y.getCount() + ":pull" + this.E.size());
                if (iIndexOf < i3) {
                    this.p0 = false;
                    W2();
                }
            }
        }
    }

    public final boolean H2(PeopleNearbyVo peopleNearbyVo) {
        if (peopleNearbyVo == null) {
            return false;
        }
        return f3(peopleNearbyVo.isUnlockAd(), peopleNearbyVo.isRewardAd());
    }

    public final boolean I2() {
        this.r0 = false;
        this.F.clear();
        int iD = com.zenmen.palmchat.peoplenearby.ad.e.d();
        if (this.E.size() <= iD) {
            return false;
        }
        ma3.f("inflateUnlockData mPullData size = " + this.E.size());
        this.r0 = true;
        this.s0 = true;
        this.C.addAll(this.E.subList(0, iD));
        ma3.f("inflateUnlockData mListData size = " + this.C.size());
        int i2 = iD + 10;
        if (this.E.size() >= i2) {
            this.F.addAll(this.E.subList(iD, i2));
        } else {
            ArrayList<PeopleNearbyVo> arrayList = this.F;
            ArrayList<PeopleNearbyVo> arrayList2 = this.E;
            arrayList.addAll(arrayList2.subList(iD, arrayList2.size()));
            W2();
        }
        for (int i3 = 0; i3 < this.F.size(); i3++) {
            PeopleNearbyVo peopleNearbyVo = this.F.get(i3);
            if (peopleNearbyVo != null && !peopleNearbyVo.isUnlockAdTip()) {
                peopleNearbyVo.setShowUnlockBtn(false);
                peopleNearbyVo.setUnlockAd(true);
            }
        }
        this.t.setVisibility(0);
        ((z) this.z).a(this.F, this.P);
        return true;
    }

    public final void J2() {
        this.X = new k();
        this.Y = new l();
        this.x.setOnSlideUpListener(new r());
    }

    public final void K2() {
        this.H.setVisibility(8);
        this.K = true;
        R2();
    }

    public final void L2() {
        this.T = new String[]{getString(R.string.nearby_more_female), getString(R.string.nearby_more_male), getString(R.string.nearby_more_all), getString(R.string.nearby_more_greet), getString(R.string.nearby_more_clean)};
    }

    public final void M2() {
        this.r = initToolbar(-1);
        this.v = (TextView) findViewById(R.id.actionbar_title);
        this.w = (ImageView) findViewById(R.id.actionbar_title_icon);
        this.v.setText(R.string.settings_item_fujinderen);
        this.w.setVisibility(8);
        setSupportActionBar(this.r);
    }

    public final void N2() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("intent_key_from");
            boolean booleanExtra = intent.getBooleanExtra("intent_key_from_firstentry", false);
            this.Z = intent.getIntExtra("fromType", 0);
            if ("value_intent_from_secretary".equals(stringExtra) || booleanExtra || this.Z == 13) {
                setBack2MainTab(true, "tab_discover");
            }
        }
        n3();
        this.P = r75.e(this, k86.a("last_nearby_gender"));
        this.q = new ig4(this);
        this.s = (ListView) findViewById(R.id.peoplenearby_list);
        this.u = (LinearLayout) findViewById(R.id.new_greet_area);
        this.H = findViewById(R.id.permission_fail);
        this.I = (TextView) findViewById(R.id.permission_add);
        SlideUpLayout slideUpLayout = (SlideUpLayout) findViewById(R.id.slide_up_layout);
        this.x = slideUpLayout;
        slideUpLayout.setEnable(false);
        this.t = (ListView) findViewById(R.id.peoplenearby_bottom_list);
        this.y = new com.zenmen.palmchat.peoplenearby.a(this);
        this.q.g(this.s);
        this.s.setAdapter((ListAdapter) this.y);
        com.zenmen.palmchat.peoplenearby.b bVar = new com.zenmen.palmchat.peoplenearby.b(this);
        this.z = bVar;
        this.t.setAdapter((ListAdapter) bVar);
        this.G = findViewById(R.id.more_friends_area);
        this.A = bo0.r().l(this.B);
        j3(this.P);
        ContactInfoItem contactInfoItem = this.A;
        if (contactInfoItem != null) {
            this.O = contactInfoItem.getGender();
        }
        this.q.k(this.O);
        this.q.q(true);
        this.s.setOnItemClickListener(new s());
        this.s.setOnScrollListener(new t());
        this.G.setOnClickListener(new u());
        this.u.setOnClickListener(new v());
        this.I.setOnClickListener(new w());
    }

    public final boolean O2() {
        if (com.zenmen.palmchat.peoplenearby.ad.e.B()) {
            return m3();
        }
        if (com.zenmen.palmchat.peoplenearby.ad.e.C()) {
            return I2();
        }
        if (this.E.size() < com.zenmen.palmchat.peoplenearby.ad.e.d()) {
            return false;
        }
        this.C.addAll(this.E.subList(0, com.zenmen.palmchat.peoplenearby.ad.e.d()));
        PeopleNearbyVo peopleNearbyVo = new PeopleNearbyVo();
        peopleNearbyVo.setRewardAd(true);
        this.C.add(peopleNearbyVo);
        this.l0 = true;
        return true;
    }

    public final boolean P2(LocationEx locationEx) {
        if (locationEx == null) {
            return false;
        }
        double latitude = locationEx.getLatitude();
        double longitude = locationEx.getLongitude();
        return latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d;
    }

    public final void Q2() {
        if (this.S && !SPUtil.f14322a.a(SPUtil.SCENE.NEARBY, k86.a("nearby_notify_exit"), false)) {
            try {
                new u34(new q(), new p()).n();
            } catch (DaoException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void R2() {
        showBaseProgressBar(R.string.loading, false);
        this.J = null;
        if (this.K) {
            com.zenmen.palmchat.location.d.g().k(LocationScene.OLD_NEARBY, this);
        }
    }

    public final void S2() {
        super.onBackPressed();
        lu3.a();
        Q2();
    }

    public final void T2(String str) {
        runOnUiThread(new e(str));
    }

    public final void U2() {
        this.h0.F();
        this.k0 = false;
        updateViews();
        z2();
        com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("x_client_sdkad_tvS").h((int) this.h0.t()).j();
    }

    public final void V2() {
        this.x.setEnable(false);
        this.x.setBehindViewVisible(8);
        this.r0 = false;
        this.k0 = false;
        this.s0 = false;
        y2(false);
        updateViews();
        z2();
    }

    @Override // defpackage.eg4
    public void W(String str) {
        LogUtil.d(D0 + " logad", "onRewardAdVerify,codeId:" + str);
        if (com.zenmen.palmchat.peoplenearby.ad.e.B()) {
            T2(str);
        } else {
            if (!com.zenmen.palmchat.peoplenearby.ad.e.C()) {
                U2();
                return;
            }
            this.t0 = true;
            this.h0.F();
            com.zenmen.palmchat.peoplenearby.ad.c.a().e(str).f("x_client_sdkad_tvS").a(com.zenmen.palmchat.peoplenearby.ad.e.g()).h((int) this.h0.t()).k();
        }
    }

    public final void W2() {
        ma3.f("logad preloadNearby hasMaskingView：" + this.r0 + "，isLoading：" + this.Q + "，hasShowAdLoadMore：" + this.l0 + "，continueFlag：" + this.M);
        if (this.Q || this.l0) {
            return;
        }
        int i2 = this.M;
        if (i2 == 1 || i2 == 2) {
            LogUtil.d(D0, "logad preloadNearby");
            C2(false);
        }
    }

    public final void X2(int i2, int i3, int i4) {
        if (this.o0 && i4 < this.y.getCount() && i4 >= 0) {
            while (i2 <= i4 && i2 >= 0) {
                Object item = this.y.getItem(i2);
                if ((item instanceof PeopleNearbyVo) && ((PeopleNearbyVo) item).isUnlockAdTip()) {
                    this.v0 = i2;
                    LogUtil.d(D0, "logad smooth bottomPosition = " + i4 + ",mRewardTipViewPos" + this.v0 + ",visibleItemCount" + i3);
                    this.o0 = false;
                    com.zenmen.palmchat.peoplenearby.ad.c.a().f("lx_nearby_dialog_show").a(com.zenmen.palmchat.peoplenearby.ad.e.g()).k();
                    return;
                }
                i2++;
            }
        }
    }

    public final void Y2(int i2, int i3) {
        int i4 = (i2 + i3) - 1;
        int iA = wv3.a();
        if (!this.A0 && this.k0 && i4 >= iA) {
            this.A0 = true;
            wv3.f(this);
        }
        int iQ = com.zenmen.palmchat.peoplenearby.ad.e.q();
        if (this.k0 && iQ >= 0 && i4 >= iQ) {
            this.h0.D(this, false);
        }
        G2(i4);
        X2(i2, i3, i4);
        this.w0 = ((this.v0 + i3) - 2) - 1;
    }

    public final void Z2(int i2, int i3) {
        int i4;
        int i5;
        if (this.k0 && com.zenmen.palmchat.peoplenearby.ad.e.q() >= 0 && (i2 + i3) - 1 >= com.zenmen.palmchat.peoplenearby.ad.e.q()) {
            this.h0.D(this, false);
            if (this.m0) {
                this.m0 = false;
                com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_nearByT").j();
            }
        }
        if (this.n0 && (i2 + i3) - 1 < this.y.getCount()) {
            int i6 = i2;
            while (true) {
                if (i6 > i5 || i6 < 0) {
                    break;
                }
                if (this.E.indexOf(this.y.getItem(i6)) >= com.zenmen.palmchat.peoplenearby.ad.e.d() - 1) {
                    this.n0 = false;
                    com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_nearByU").j();
                    break;
                }
                i6++;
            }
        }
        if (!this.o0 || (i2 + i3) - 1 >= this.y.getCount() || i4 < 0) {
            return;
        }
        Object item = this.y.getItem(i4);
        if ((item instanceof PeopleNearbyVo) && ((PeopleNearbyVo) item).isRewardAd()) {
            this.o0 = false;
            com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_nearByV").j();
        }
    }

    public final void a3(int i2, int i3) {
        Object item;
        int i4 = i2 + i3;
        int i5 = i4 - 1;
        try {
            int iQ = com.zenmen.palmchat.peoplenearby.ad.e.q();
            if (this.k0 && iQ >= 0 && i5 >= iQ) {
                this.h0.D(this, false);
            }
            if (this.n0 && i5 <= this.y.getCount() && (item = this.y.getItem(i2)) != null && this.E.indexOf(item) + i3 >= com.zenmen.palmchat.peoplenearby.ad.e.d() - 1) {
                this.n0 = false;
                this.x.setEnable(true);
                this.x0 = i4;
            }
            G2(i5);
            if (this.x0 == 0) {
                this.x0 = com.zenmen.palmchat.peoplenearby.ad.e.d() + 1;
            }
            this.w0 = this.x0 + i3;
        } catch (Exception unused) {
        }
    }

    public final void b3() {
        int iMax = Math.max(0, Math.min(this.s.getCount() - 1, this.w0));
        ma3.f("logad selectPannerPosToTop scrollPos = " + iMax);
        if (iMax > 0) {
            this.s.postDelayed(new f(iMax), 200L);
        }
    }

    public final void c3(PeopleNearbyAdLoadMore.Status status) {
        this.i0 = status;
    }

    public final void d3() {
        MaterialDialog materialDialog = this.C0;
        if (materialDialog == null || !materialDialog.isShowing()) {
            sd3 sd3Var = new sd3(this);
            sd3Var.T(R.string.string_share_tip);
            sd3Var.j(R.string.string_location_service_disable);
            sd3Var.O(R.string.settings_item_goto_setting);
            sd3Var.h(false);
            sd3Var.K(R.string.alert_dialog_cancel);
            sd3Var.f(new j());
            MaterialDialog materialDialogE = sd3Var.e();
            this.C0 = materialDialogE;
            materialDialogE.show();
        }
    }

    public final boolean e3(boolean z2) {
        com.zenmen.palmchat.peoplenearby.ad.c.a().f("lx_nearby_unlock_button_click").a(com.zenmen.palmchat.peoplenearby.ad.e.g()).k();
        if (!z2) {
            return false;
        }
        if (!this.h0.I()) {
            this.h0.D(this, true);
        }
        return true;
    }

    public final boolean f3(boolean z2, boolean z3) {
        return com.zenmen.palmchat.peoplenearby.ad.e.B() ? e3(z2) : g3(z3);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.S) {
            ds0.a().b(new v42(DiscoverFunction.NEARBY));
        }
    }

    public final boolean g3(boolean z2) {
        if (!z2) {
            return false;
        }
        if (this.h0.I()) {
            com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_nearByBannerC").n(1).j();
        } else {
            this.h0.D(this, true);
            com.zenmen.palmchat.peoplenearby.ad.c.a().e(PeopleNearbyAdLoadMore.i()).f("lx_client_sdkad_nearByBannerC").n(2).j();
        }
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 14;
    }

    public final boolean h3() {
        if (!this.h0.I()) {
            this.h0.D(this, true);
        }
        this.x.smoothClose(false);
        this.q.q(true);
        return true;
    }

    public final void i3() {
        this.N = 0;
        this.E.clear();
        this.M = 2;
        this.L = 0;
        C2(true);
        this.q.o(this.r0, false, false, false, this.j0, 0, this.s0);
    }

    @Override // defpackage.jg4
    public void j0(View view, PeopleNearbyVo peopleNearbyVo, int i2, int i3) {
        H2(peopleNearbyVo);
    }

    public final void j3(int i2) {
        if (i2 == 0) {
            this.w.setImageDrawable(getResources().getDrawable(R.drawable.nearby_screen_male));
            this.w.setVisibility(0);
        } else if (i2 != 1) {
            this.w.setVisibility(8);
        } else {
            this.w.setImageDrawable(getResources().getDrawable(R.drawable.nearby_screen_female));
            this.w.setVisibility(0);
        }
    }

    public final void k3() {
        if (this.y instanceof com.zenmen.palmchat.peoplenearby.a) {
            c3(this.h0.a());
        } else {
            c3(PeopleNearbyAdLoadMore.Status.DISABLE);
        }
    }

    @Override // defpackage.eg4
    public void l0() {
        ma3.f("logad onRewardAdClose   hasRewardVerify = " + this.t0);
        if (com.zenmen.palmchat.peoplenearby.ad.e.B() && this.t0) {
            ma3.f("logad selectPannerPosToTop run");
            b3();
        }
    }

    public final void l3() {
        hideBaseProgressBar();
        ch.s().y0(System.currentTimeMillis(), true);
        this.l0 = false;
        LogUtil.d("logad", "shouldShowAdLoadMore = " + this.k0);
        if (this.k0) {
            ma3.f("shouldShowAdLoadMore = true run");
            this.C.clear();
            LogUtil.d("logad", "dataSize = " + this.E.size() + ", bannerPosition = " + com.zenmen.palmchat.peoplenearby.ad.e.d());
            if (!O2()) {
                this.C.addAll(this.E);
            }
        } else {
            this.C.clear();
            this.C.addAll(this.E);
        }
        ((z) this.y).a(this.C, this.P);
        ma3.f("refresh adapter run mListData size = " + this.C.size());
        if (this.R && this.E.size() > 0) {
            this.s.setSelection(0);
        }
        j3(this.P);
        this.S = true;
    }

    @Override // defpackage.eg4
    public void m0(String str) {
        if (com.zenmen.palmchat.peoplenearby.ad.e.C()) {
            com.zenmen.palmchat.peoplenearby.ad.c.a().e(str).f("lx_nearby_up_reward_video").a(com.zenmen.palmchat.peoplenearby.ad.e.g()).k();
        }
    }

    public final boolean m3() {
        this.r0 = false;
        this.F.clear();
        int iD = com.zenmen.palmchat.peoplenearby.ad.e.d();
        LogUtil.d(D0, "logad newstyle updateUnlockData  mPullData:" + this.E.size() + ",bannerPos:" + iD);
        if (this.E.size() < iD) {
            return false;
        }
        this.r0 = true;
        this.C.addAll(this.E.subList(0, iD));
        this.F.add(D2());
        int i2 = iD + 10;
        if (this.E.size() >= i2) {
            this.F.addAll(this.E.subList(iD, i2));
        } else {
            ArrayList<PeopleNearbyVo> arrayList = this.F;
            ArrayList<PeopleNearbyVo> arrayList2 = this.E;
            arrayList.addAll(arrayList2.subList(iD, arrayList2.size()));
            W2();
        }
        BaseAdapter baseAdapter = this.y;
        if (baseAdapter instanceof com.zenmen.palmchat.peoplenearby.a) {
            ((com.zenmen.palmchat.peoplenearby.a) baseAdapter).p(this);
        }
        for (int i3 = 0; i3 < this.F.size(); i3++) {
            PeopleNearbyVo peopleNearbyVo = this.F.get(i3);
            if (peopleNearbyVo != null && !peopleNearbyVo.isUnlockAdTip()) {
                peopleNearbyVo.setShowUnlockBtn(true);
                peopleNearbyVo.setUnlockAd(true);
            }
        }
        this.C.addAll(this.F);
        return true;
    }

    public final void n3() {
        LogUtil.uploadInfoImmediate(this.B, "330", "1", null, String.valueOf(this.Z));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Bundle extras = getIntent().getExtras();
        String strC = vt2.c(extras);
        String strB = vt2.b(extras);
        if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(strB)) {
            super.onBackPressed();
        } else {
            vu3.n(this, strC, strB, new o());
        }
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new m());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_peoplenearby_ui3);
        this.B = AccountUtils.p(AppContext.getContext());
        com.zenmen.palmchat.peoplenearby.ad.e.L();
        this.h0 = new com.zenmen.palmchat.peoplenearby.ad.e(this);
        M2();
        L2();
        N2();
        J2();
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.LOCATION;
        if (tg4.b(this, permissionType.permissionList)) {
            K2();
        }
        u13.b().a();
        bo0.r().i().j(this);
        ch.s().r().j(this);
        if (tg4.b(this, permissionType.permissionList) && (intent = getIntent()) != null) {
            if (intent.getBooleanExtra("from_daemon", false)) {
                F2();
            } else if (this.Z == 13) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) intent.getParcelableExtra("user_item_info");
                String stringExtra = intent.getStringExtra("rid");
                boolean booleanExtra = intent.getBooleanExtra("isAccept", false);
                if (!TextUtils.isEmpty(stringExtra) && contactInfoItem != null) {
                    bn0.m(this, null, stringExtra, contactInfoItem, booleanExtra, false, "", "");
                }
            }
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            vt2.d(this, intent2.getExtras());
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_info_detail, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.A0 = false;
        wc0 wc0Var = this.V;
        if (wc0Var != null) {
            wc0Var.onCancel();
        }
        m92 m92Var = this.W;
        if (m92Var != null) {
            m92Var.onCancel();
        }
        hideBaseProgressBar();
        this.h0.E();
        bo0.r().i().l(this);
        ch.s().r().l(this);
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        showPopupMenu(this, this.r, this.T, this.U, this.B0, null);
        return true;
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i2, String str) {
        y yVar = new y(locationEx);
        if (locationEx == null || !P2(locationEx)) {
            LogUtil.i(D0, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new h(yVar, i2), (Throwable) null);
        } else {
            LogUtil.i(D0, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new g(yVar, i2), (Throwable) null);
        }
        if (this.J == null && P2(locationEx)) {
            this.J = new LocationEx(locationEx.getLatitude(), locationEx.getLongitude(), locationEx.getCoorType(), "", locationEx.getAddress(), locationEx.getCountry(), locationEx.getCityCode());
            if (!hx3.m(this)) {
                LogUtil.i(D0, 3, new i(), (Throwable) null);
                hideBaseProgressBar();
            }
            i3();
            return;
        }
        if (P2(locationEx)) {
            hideBaseProgressBar();
            return;
        }
        hideBaseProgressBar();
        this.q.l(true, this.P, this.L, this.E.size(), this.l0);
        if (i2 == 12 || !com.zenmen.palmchat.location.b.f(this)) {
            d3();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.menu_more) {
                return super.onOptionsItemSelected(menuItem);
            }
            showPopupMenu(this, this.r, this.T, this.U, this.B0, null);
            return true;
        }
        Bundle extras = getIntent().getExtras();
        String strC = vt2.c(extras);
        String strB = vt2.b(extras);
        if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(strB)) {
            E2();
        } else {
            vu3.n(this, strC, strB, new a());
        }
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_permission_3", null, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z2) {
        super.onPermissionGrant(permissionType, permissionUsage, z2);
        K2();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ig4 ig4Var = this.q;
        if (ig4Var != null) {
            ig4Var.r();
            this.q.p();
        }
        if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList) && !this.K) {
            K2();
        }
        if (com.zenmen.palmchat.peoplenearby.ad.e.C() && this.y0 && this.t0) {
            this.y0 = false;
            new Handler(getMainLooper()).postDelayed(new x(), 500L);
        }
        com.zenmen.palmchat.miniwidget.a.f().d(this);
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        runOnUiThread(new n(uk5Var));
    }

    public final void updateViews() {
        ma3.f("updateViews  run  continueFlag = " + this.M + "   ::::: isShowPullUpFooter = " + this.s0);
        int iMax = Math.max(0, this.u0 - (com.zenmen.palmchat.peoplenearby.ad.e.d() + 10));
        int i2 = this.M;
        if (i2 == 0) {
            l3();
            this.q.o(this.r0, !this.l0, false, false, this.j0, iMax, this.s0);
            return;
        }
        if (i2 == 1) {
            l3();
            this.q.o(this.r0, !this.l0, true, false, this.j0, iMax, this.s0);
        } else if (i2 == 2) {
            R2();
        } else {
            if (i2 != 3) {
                return;
            }
            l3();
            this.q.o(this.r0, !this.l0, false, false, this.j0, iMax, this.s0);
        }
    }

    public final void y2(boolean z2) {
        ArrayList<PeopleNearbyVo> arrayList = this.F;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            PeopleNearbyVo peopleNearbyVo = this.F.get(i2);
            if (peopleNearbyVo != null) {
                peopleNearbyVo.setUnlockAd(false);
            }
        }
        ma3.f("changeUnlockAdStatus run   unlockData size = " + this.F.size());
        if (z2) {
            this.F.remove(0);
        }
    }

    public final void z2() {
        if (((com.zenmen.palmchat.peoplenearby.ad.e.B() || com.zenmen.palmchat.peoplenearby.ad.e.C()) && this.r0) || this.s.getLastVisiblePosition() <= this.s.getCount() - 6 || this.Q || this.l0) {
            return;
        }
        int i2 = this.M;
        if (i2 == 1 || i2 == 2) {
            C2(false);
        }
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    @Override // defpackage.eg4
    public void R() {
    }

    @Override // defpackage.eg4
    public void k() {
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i2, List<LocationEx> list, n53 n53Var) {
    }
}
