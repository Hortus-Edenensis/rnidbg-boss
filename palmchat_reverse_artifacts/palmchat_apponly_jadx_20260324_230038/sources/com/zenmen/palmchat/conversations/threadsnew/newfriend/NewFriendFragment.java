package com.zenmen.palmchat.conversations.threadsnew.newfriend;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.baidu.location.LocationConst;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.ss.android.ttvecamera.BuildConfig;
import com.wifi.ad.core.interactive.WkInteractiveManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseLazyFragment;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.adapter.UserRecommendRecycleAdapter;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.contacts.b;
import com.zenmen.palmchat.conversations.threadsnew.newfriend.NewFriendAdapter;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ImageLoadingView;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.mvp.model.bean.NearByResp;
import com.zenmen.square.ui.widget.SquarePullHeader;
import defpackage.UI;
import defpackage.a46;
import defpackage.b05;
import defpackage.bg2;
import defpackage.bo0;
import defpackage.c74;
import defpackage.ds0;
import defpackage.f7;
import defpackage.fk2;
import defpackage.fu5;
import defpackage.g74;
import defpackage.go2;
import defpackage.h74;
import defpackage.hc2;
import defpackage.i55;
import defpackage.ih;
import defpackage.io0;
import defpackage.iq5;
import defpackage.j74;
import defpackage.jo6;
import defpackage.k86;
import defpackage.mj1;
import defpackage.n5;
import defpackage.nl0;
import defpackage.nw5;
import defpackage.o2;
import defpackage.pm2;
import defpackage.px3;
import defpackage.q05;
import defpackage.qm5;
import defpackage.r8;
import defpackage.rn0;
import defpackage.rx4;
import defpackage.sd3;
import defpackage.sw4;
import defpackage.sy5;
import defpackage.td3;
import defpackage.u93;
import defpackage.v4;
import defpackage.v8;
import defpackage.ve;
import defpackage.vn0;
import defpackage.vs0;
import defpackage.w42;
import defpackage.wh4;
import defpackage.xu4;
import defpackage.zn6;
import defpackage.zw4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NewFriendFragment extends BaseLazyFragment implements pm2<Cursor> {
    public SmartRefreshLayout C;
    public ImageView E;
    public List<ImageView> F;
    public TextView G;
    public String J;
    public View j;
    public View k;
    public RecyclerView l;
    public View m;
    public View n;
    public View o;
    public ImageLoadingView p;
    public NewFriendAdapter q;
    public b.k r;
    public o2 u;
    public f7 v;
    public ih w;
    public int x;
    public UserRecommendRecycleAdapter y;
    public RecyclerView z;
    public int s = 6;
    public int t = 3;
    public List<w42> A = new ArrayList();
    public List<NearByBean> B = new ArrayList();
    public boolean H = false;
    public boolean I = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("type", "1");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("type", "0");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13836a;
        public final /* synthetic */ w42 b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("order", Integer.valueOf(c.this.f13836a + 1));
                put("url", c.this.b.f21614a);
            }
        }

        public c(int i, w42 w42Var) {
            this.f13836a = i;
            this.b = w42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.j("pagemsg_newfrd_recommendfunc", "click", new a());
            ve.o(NewFriendFragment.this.getActivity(), this.b.f21614a, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f13838a;

        public d(HashMap map) {
            this.f13838a = map;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            LogUtil.v("logsquare", "onScrollStateChanged");
            NewFriendFragment.this.x0(this.f13838a, recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            LogUtil.v("logsquare", "onScrolled");
            NewFriendFragment.this.x0(this.f13838a, recyclerView);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f13839a;
        public final /* synthetic */ RecyclerView b;

        public e(HashMap map, RecyclerView recyclerView) {
            this.f13839a = map;
            this.b = recyclerView;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LogUtil.v("logsquare", "onLayoutChange");
            NewFriendFragment.this.x0(this.f13839a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NearByBean f13841a;

        public g(NearByBean nearByBean) {
            this.f13841a = nearByBean;
            put("tuid", nearByBean.exid);
            put("gender", Integer.valueOf(nearByBean.gender));
            put("introtype", Integer.valueOf(nearByBean.extra.type));
            put("distance", Long.valueOf(nearByBean.distance));
            put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, nearByBean.onlineStatusCode == 1 ? BuildConfig.USE_CLOUD_CONFIG : WkInteractiveManager.TimingTypeOff);
            put("page", Integer.valueOf(nearByBean.page));
            put("impr_id", nearByBean.imprId);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13842a;

        public h(String str) {
            this.f13842a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.c("pagemsg_newfrd_noticeboard", "click");
            if (TextUtils.isEmpty(this.f13842a)) {
                return;
            }
            ve.o(NewFriendFragment.this.getActivity(), this.f13842a, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13843a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ContactRequestArgs e;

        public i(ContactInfoItem contactInfoItem, String str, boolean z, int i, ContactRequestArgs contactRequestArgs) {
            this.f13843a = contactInfoItem;
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
                NewFriendFragment.this.G();
                wh4.h(this.f13843a);
                iq5.j(false, new String[0]);
            } else {
                if (iOptInt == 1) {
                    NewFriendFragment.this.p0(this.b, this.c, this.f13843a, this.d, this.e);
                    return;
                }
                if (iOptInt == 1318) {
                    NewFriendFragment.this.G();
                    sy5.e(NewFriendFragment.this.getContext(), R.string.send_refuse, 1).g();
                } else if (iOptInt == 1320 || iOptInt == 1321) {
                    NewFriendFragment.this.G();
                    rx4.b(NewFriendFragment.this.getContext(), jSONObject);
                } else {
                    NewFriendFragment.this.G();
                    sy5.f(NewFriendFragment.this.getContext(), rx4.a(jSONObject), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.ErrorListener {
        public j() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            NewFriendFragment.this.G();
            if (NewFriendFragment.this.getContext() != null) {
                new sd3(NewFriendFragment.this.getContext()).j(R.string.sent_request_failed).O(R.string.alert_dialog_ok).e().show();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            fk2.a aVar = new fk2.a();
            Bundle bundle = new Bundle();
            bundle.putString("main_tab", "tab_find_friend");
            aVar.b(bundle);
            NewFriendFragment.this.startActivity(n5.b(NewFriendFragment.this.getActivity(), aVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.ErrorListener {
        public l() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            NewFriendFragment.this.G();
            LogUtil.d("NewContactFragment", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13847a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ContactInfoItem c;

        public m(boolean z, String str, ContactInfoItem contactInfoItem) {
            this.f13847a = z;
            this.b = str;
            this.c = contactInfoItem;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            NewFriendFragment.this.G();
            if (iOptInt != 0 && iOptInt != 1) {
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(NewFriendFragment.this.getContext(), jSONObject);
                    return;
                } else {
                    if (iOptInt == -1) {
                        sy5.e(NewFriendFragment.this.getContext(), R.string.send_failed, 0).g();
                        return;
                    }
                    return;
                }
            }
            if (this.f13847a) {
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
            wh4.h(this.c);
            rn0.r(this.b);
            if (NewFriendFragment.this.r.f13564a != 14) {
                wh4.d(this.b, this.c.getRequestType());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Response.ErrorListener {
        public n() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            NewFriendFragment.this.G();
            if (NewFriendFragment.this.getContext() != null) {
                new sd3(NewFriendFragment.this.getContext()).j(R.string.sent_request_failed).O(R.string.alert_dialog_ok).e().show();
            }
            LogUtil.d("NewContactFragment", volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13849a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ContactInfoItem d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ContactRequestsVO h;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                contactInfoItem.setUid(o.this.c);
                contactInfoItem.setBizType(0);
                GiftMessageHelper.S(contactInfoItem);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends MaterialDialog.e {
            public b() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                o oVar = o.this;
                NewFriendFragment.this.n0(oVar.c, true, oVar.d, oVar.f13849a, oVar.h);
            }
        }

        public o(int i, String str, String str2, ContactInfoItem contactInfoItem, int i2, String str3, String str4, ContactRequestsVO contactRequestsVO) {
            this.f13849a = i;
            this.b = str;
            this.c = str2;
            this.d = contactInfoItem;
            this.e = i2;
            this.f = str3;
            this.g = str4;
            this.h = contactRequestsVO;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                if (this.f13849a == 28) {
                    LogUtil.onImmediateClickEvent("pm1061", null, null);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 1L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "rid=?", new String[]{this.b});
                rn0.h(this.c, this.f13849a);
                rn0.r(this.c);
                wh4.h(this.d);
                iq5.j(false, new String[0]);
                UserDetailActivity.V2(NewFriendFragment.this.getActivity(), this.e, this.f, this.b, this.d, NewFriendFragment.this.r.c, this.g, this.f13849a != 34);
                u93.b(500, new a());
            } else if (iOptInt == 1306) {
                if (NewFriendFragment.this.getContext() != null) {
                    new sd3(NewFriendFragment.this.getContext()).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new b()).e().show();
                }
            } else if (iOptInt == 1327) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MediationConstant.KEY_ERROR_MSG);
                mj1.c(NewFriendFragment.this.getContext(), jSONObjectOptJSONObject.optString("title"), jSONObjectOptJSONObject.optString("part"), jSONObjectOptJSONObject.optString("body"), jSONObjectOptJSONObject.optInt("time"));
            } else if (iOptInt == -1) {
                sy5.e(NewFriendFragment.this.getContext(), R.string.send_failed, 0).g();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(NewFriendFragment.this.getContext(), jSONObject);
            } else {
                sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
            }
            NewFriendFragment.this.G();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements j74 {
        public p() {
        }

        @Override // defpackage.j74
        public void a(@NonNull xu4 xu4Var) {
            NewFriendFragment.this.s0(false, xu4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements c74 {
        public q() {
        }

        @Override // defpackage.c74
        public void onLoadMore(@NonNull xu4 xu4Var) {
            NewFriendFragment.this.s0(true, xu4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements g74<NewFriendAdapter.b> {
        public r() {
        }

        @Override // defpackage.g74
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(View view, int i, NewFriendAdapter.b bVar) {
            ContactRequestsVO contactRequestsVO = bVar instanceof NewFriendAdapter.a ? ((NewFriendAdapter.a) bVar).f13833a : null;
            if (contactRequestsVO != null) {
                px3.d(contactRequestsVO.fromUid, 0);
                NewFriendFragment.this.E0(contactRequestsVO);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements h74<NewFriendAdapter.b> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f13856a;
            public final /* synthetic */ int b;

            /* JADX INFO: renamed from: com.zenmen.palmchat.conversations.threadsnew.newfriend.NewFriendFragment$s$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1042a extends HashMap<String, Object> {
                public C1042a() {
                    put("fuid", a.this.f13856a);
                }
            }

            public a(String str, int i) {
                this.f13856a = str;
                this.b = i;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                rn0.f(this.f13856a);
                if (this.b < 100) {
                    zn6.j("new_apply_delete", "click", new C1042a());
                }
            }
        }

        public s() {
        }

        @Override // defpackage.h74
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(View view, int i, NewFriendAdapter.b bVar) {
            ContactRequestsVO contactRequestsVO = bVar instanceof NewFriendAdapter.a ? ((NewFriendAdapter.a) bVar).f13833a : null;
            if (contactRequestsVO != null) {
                String str = contactRequestsVO.fromUid;
                if (!(v8.h() && v8.C(str) && contactRequestsVO.aiShowUi == 1)) {
                    new td3.c(NewFriendFragment.this.getContext()).c(new String[]{NewFriendFragment.this.getString(R.string.string_delete)}).d(new a(str, contactRequestsVO.type)).a().b();
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r8 f13858a;

        public t(r8 r8Var) {
            this.f13858a = r8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            NewFriendFragment newFriendFragment = NewFriendFragment.this;
            r8 r8Var = this.f13858a;
            newFriendFragment.G0(r8Var.c, r8Var.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends go2<LXBaseNetBean<NearByResp>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13859a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ xu4 d;
        public final /* synthetic */ int e;

        public u(String str, HashMap map, boolean z, xu4 xu4Var, int i) {
            this.f13859a = str;
            this.b = map;
            this.c = z;
            this.d = xu4Var;
            this.e = i;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f13859a, this.b);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<NearByResp> lXBaseNetBean, Exception exc) {
            NearByResp nearByResp;
            NearByResp nearByResp2;
            NearByResp nearByResp3;
            if (!z) {
                if (this.c) {
                    this.d.finishLoadMore();
                    return;
                } else {
                    this.d.finishRefresh();
                    return;
                }
            }
            if (!this.c) {
                NewFriendFragment.this.B.clear();
                this.d.finishRefresh();
            } else if (lXBaseNetBean == null || (nearByResp = lXBaseNetBean.data) == null || nearByResp.nearbyList == null || !nearByResp.nearbyList.isEmpty()) {
                this.d.finishLoadMore();
            } else {
                this.d.finishLoadMoreWithNoMoreData();
            }
            if (lXBaseNetBean != null && (nearByResp3 = lXBaseNetBean.data) != null && nearByResp3.nearbyList != null && nearByResp3.nearbyList.size() > 0) {
                NewFriendFragment.this.x = this.e;
                int i = 0;
                while (i < lXBaseNetBean.data.nearbyList.size()) {
                    lXBaseNetBean.data.nearbyList.get(i).page = this.e + 1;
                    NearByBean nearByBean = lXBaseNetBean.data.nearbyList.get(i);
                    i++;
                    nearByBean.pos = i;
                }
                NewFriendFragment.this.B.addAll(lXBaseNetBean.data.nearbyList);
                if (NewFriendFragment.this.x == 0) {
                    b05.d("设置可以滚动");
                    NewFriendFragment.this.C.setEnableLoadMore(true);
                    NewFriendFragment.this.n.setVisibility(0);
                }
            }
            if (lXBaseNetBean != null && (nearByResp2 = lXBaseNetBean.data) != null && (nearByResp2.nearbyList == null || nearByResp2.nearbyList.isEmpty())) {
                NewFriendFragment newFriendFragment = NewFriendFragment.this;
                if (newFriendFragment.x == 0 && !this.c) {
                    newFriendFragment.n.setVisibility(8);
                    NewFriendFragment.this.B.clear();
                }
            }
            NewFriendFragment.this.y.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v extends HashMap<String, Object> {
        public v() {
            put("type", "1");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w extends HashMap<String, Object> {
        public w() {
            put("type", "0");
        }
    }

    public final void A0() {
        LogUtil.i("NewContactFragment", "setRequestAsRead");
        rn0.n();
        rn0.l();
        rn0.m();
    }

    public final void B0(RecyclerView recyclerView) {
        HashMap map = new HashMap();
        recyclerView.addOnScrollListener(new d(map));
        recyclerView.addOnLayoutChangeListener(new e(map, recyclerView));
        recyclerView.getAdapter().registerAdapterDataObserver(new f(map, recyclerView));
    }

    public void E0(ContactRequestsVO contactRequestsVO) {
        ThreadChatItem threadChatItemF = nw5.f(contactRequestsVO.fromUid);
        LogUtil.d("", "AIP新朋友加好友uid  ");
        if (threadChatItemF == null || !threadChatItemF.isContactReady) {
            int iG = fu5.g(contactRequestsVO.sourceType, contactRequestsVO.fromUid);
            LogUtil.d("", "AIP新朋友加好友 bizType " + iG);
            fu5.z(contactRequestsVO.fromUid, iG, false, contactRequestsVO.fromHeadIcon, contactRequestsVO.fromNickName);
        } else {
            ChatItem chatItemConvert2ContactOrGroupChatInfo = threadChatItemF.convert2ContactOrGroupChatInfo();
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
            if (chatItemConvert2ContactOrGroupChatInfo instanceof ContactInfoItem) {
                intent.setExtrasClassLoader(ContactInfoItem.class.getClassLoader());
            } else if (chatItemConvert2ContactOrGroupChatInfo instanceof GroupInfoItem) {
                intent.setExtrasClassLoader(GroupInfoItem.class.getClassLoader());
            }
            intent.putExtra("chat_item", chatItemConvert2ContactOrGroupChatInfo);
            intent.putExtra("thread_biz_type", chatItemConvert2ContactOrGroupChatInfo.getBizType());
            intent.putExtra("chat_back_to_greet", false);
            k86.X(intent);
            startActivity(intent);
        }
        i55.c(contactRequestsVO.fromUid, contactRequestsVO.userInfo);
    }

    public final void G0(ContactRequestsVO contactRequestsVO, String str) {
        try {
            this.J = str;
            if (contactRequestsVO == null || this.q == null) {
                return;
            }
            LogUtil.d("AiChatPeopleManagerTag", "NewFriendFragment updateAiCardItem startTriggerToServer scene " + str);
            if (this.q.f() != null) {
                if ("newFriend_empty".equals(str)) {
                    I0(true);
                }
                NewFriendAdapter.a aVar = new NewFriendAdapter.a(contactRequestsVO);
                List<NewFriendAdapter.b> listF = this.q.f();
                List<NewFriendAdapter.b> listT = v8.t(listF);
                if (listT != null && listT.size() > 0) {
                    listF.removeAll(listT);
                    LogUtil.d("AiChatPeopleManagerTag", "NewFriendFragment updateAiCardItem removeAll aiItem scene " + str);
                }
                listF.add(0, aVar);
                this.q.notifyDataSetChanged();
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void I0(boolean z) {
        b05.d("updateUIOnDataLoad方法调用");
        this.p.hide();
        if (SAppUtil.f.b()) {
            if (z) {
                this.C.setVisibility(8);
                this.l.setVisibility(0);
                this.o.setVisibility(0);
            } else {
                u0();
                this.C.setVisibility(0);
                this.l.setVisibility(8);
                this.o.setVisibility(8);
            }
        } else if (z) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.o.setVisibility(0);
        } else {
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.o.setVisibility(8);
        }
    }

    @Override // com.zenmen.palmchat.BaseLazyFragment, com.zenmen.palmchat.BaseFragment
    public void K(boolean z) {
        super.K(z);
        b05.d("NewFriendFragment=====>onUserVisibleChange=====>" + z);
        this.H = z;
        if (Z()) {
            if (this.H) {
                K0(this.q.f() != null && this.q.f().size() > 0);
            }
            if (!z) {
                A0();
            }
            v8.A = z;
        }
    }

    public void K0(boolean z) {
        b05.d("updateUIOnDataLoadWithLog方法调用");
        if (!SAppUtil.f.b()) {
            if (z) {
                zn6.j("pagemsg_newfrd", "view", new a());
                return;
            } else {
                zn6.j("pagemsg_newfrd", "view", new b());
                return;
            }
        }
        if (!z) {
            zn6.j("pagemsg_newfrd", "view", new w());
        } else {
            zn6.c("pagemsg_newfrd_noticeboard", "view");
            zn6.j("pagemsg_newfrd", "view", new v());
        }
    }

    @Override // com.zenmen.palmchat.BaseLazyFragment
    public View W() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_fragment_msg_new_friend, (ViewGroup) null, false);
        this.j = viewInflate;
        ClassicsFooter.REFRESH_FOOTER_NOTHING = "已经到底了~";
        this.p = (ImageLoadingView) viewInflate.findViewById(R.id.loadingView);
        View viewFindViewById = this.j.findViewById(R.id.emptyView);
        this.k = viewFindViewById;
        viewFindViewById.setOnClickListener(new k());
        this.k.setVisibility(8);
        this.l = (RecyclerView) this.j.findViewById(R.id.recycler_view);
        this.l.setLayoutManager(new LinearLayoutManager(getContext()));
        this.l.setItemAnimator(null);
        b.k kVar = new b.k();
        this.r = kVar;
        kVar.f13564a = this.s;
        kVar.b = this.t;
        kVar.c = 21;
        kVar.e = true;
        this.o = this.j.findViewById(R.id.has_data_layout);
        this.C = (SmartRefreshLayout) this.j.findViewById(R.id.refresh_layout);
        this.E = (ImageView) this.j.findViewById(R.id.enter_image);
        this.z = (RecyclerView) this.j.findViewById(R.id.user_recommend_recycleview);
        View viewInflate2 = getLayoutInflater().inflate(R.layout.new_friend_header_layout, (ViewGroup) null);
        viewInflate2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.y = new UserRecommendRecycleAdapter(this.B, getContext(), viewInflate2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.z.setLayoutManager(linearLayoutManager);
        this.z.setAdapter(this.y);
        this.F = new ArrayList();
        ImageView imageView = (ImageView) viewInflate2.findViewById(R.id.image1);
        ImageView imageView2 = (ImageView) viewInflate2.findViewById(R.id.image2);
        ImageView imageView3 = (ImageView) viewInflate2.findViewById(R.id.image3);
        this.F.add(imageView);
        this.F.add(imageView2);
        this.F.add(imageView3);
        int iB = (a46.m(getContext()).x - a46.b(getContext(), 40.0f)) / 2;
        q05.y(imageView, Integer.valueOf(iB), Integer.valueOf((iB * 212) / 168));
        int i2 = (iB * 102) / 168;
        q05.y(imageView2, Integer.valueOf(iB), Integer.valueOf(i2));
        q05.y(imageView3, Integer.valueOf(iB), Integer.valueOf(i2));
        this.m = viewInflate2.findViewById(R.id.function_recommend_layout);
        this.n = viewInflate2.findViewById(R.id.user_recommend_layout);
        this.G = (TextView) viewInflate2.findViewById(R.id.user_recommend_title);
        if (SAppUtil.f.b()) {
            this.m = viewInflate2.findViewById(R.id.function_recommend_layout);
            this.n = viewInflate2.findViewById(R.id.user_recommend_layout);
            this.E.setVisibility(0);
            this.C.setVisibility(8);
            this.C.setEnableLoadMore(false);
            this.C.setOnRefreshListener(new p());
            this.C.setOnLoadMoreListener(new q());
            this.C.setRefreshHeader(new SquarePullHeader(getContext()));
            this.C.setRefreshFooter(new ClassicsFooter(getContext()));
            w0();
            B0(this.z);
        }
        NewFriendAdapter newFriendAdapter = new NewFriendAdapter(getActivity(), this, null, this.r);
        this.q = newFriendAdapter;
        this.l.setAdapter(newFriendAdapter);
        this.q.n(new r());
        this.q.o(new s());
        this.I = false;
        UI.c(getActivity(), 1008611, null, this);
        this.p.show();
        ds0.a().c(this);
        v8.z = true;
        return this.j;
    }

    @qm5
    public void aiChatEvent(r8 r8Var) {
        if (r8Var == null || r8Var.a() != 1) {
            return;
        }
        LogUtil.d("AiChatPeopleManagerTag", "NewFriendFragment aiChatEvent startTriggerToServer");
        u93.c(new t(r8Var));
    }

    public void m0(int i2, String str, String str2, String str3, ContactInfoItem contactInfoItem, int i3, String str4, ContactRequestsVO contactRequestsVO) {
        String remarkName;
        n nVar = new n();
        o oVar = new o(i3, str, str2, contactInfoItem, i2, str3, str4, contactRequestsVO);
        this.u = new o2();
        try {
            String strM = "";
            if (jo6.i() && io0.t(i3)) {
                ContactInfoItem contactInfoItemL = bo0.r().l(str2);
                if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                    PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str3);
                    if (phoneContactItem != null) {
                        strM = phoneContactItem.m();
                    }
                    remarkName = strM;
                } else {
                    remarkName = contactInfoItemL.getRemarkName();
                }
            } else {
                remarkName = strM;
            }
            this.u.n(str, this.r.b, remarkName, nVar, oVar);
            M(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public void n0(String str, boolean z, ContactInfoItem contactInfoItem, int i2, ContactRequestsVO contactRequestsVO) {
        if (str == null) {
            return;
        }
        String strM = "";
        if (jo6.i() && io0.t(i2) && !TextUtils.isEmpty(contactInfoItem.getIdentifyCode())) {
            ContactInfoItem contactInfoItemL = bo0.r().l(str);
            if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(contactInfoItem.getIdentifyCode());
                if (phoneContactItem != null) {
                    strM = phoneContactItem.m();
                }
            } else {
                strM = contactInfoItemL.getRemarkName();
            }
        }
        ContactRequestArgs.Builder builderG = new ContactRequestArgs.Builder().h(z).b(contactRequestsVO).e(ContactRequestArgs.c(contactInfoItem)).i(String.valueOf(i2)).g(strM);
        if (i2 == 3 || this.r.f) {
            builderG.j(String.valueOf(this.r.f13564a));
        }
        ContactRequestArgs contactRequestArgsA = builderG.a();
        f7 f7Var = new f7(new i(contactInfoItem, str, z, i2, contactRequestArgsA), new j());
        this.v = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
            M(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    @Override // defpackage.pm2
    @Nullable
    public Loader<Cursor> onCreateLoader(int i2, @Nullable Bundle bundle) {
        String strE = v4.e(AppContext.getContext());
        String[] strArr = new String[8];
        strArr[0] = Integer.toString(14);
        if (TextUtils.isEmpty(strE)) {
            strE = "";
        }
        strArr[1] = strE;
        strArr[2] = Integer.toString(34);
        strArr[3] = Integer.toString(4);
        strArr[4] = Integer.toString(28);
        strArr[5] = Integer.toString(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR);
        strArr[6] = Integer.toString(301);
        strArr[7] = Integer.toString(302);
        return new CursorLoader(getContext(), vn0.f21483a, null, "source_type!=? and from_uid!=? and source_type!=? and source_type!=? and source_type!=? and request_type!=? and request_type!=? and request_type!=? ", strArr, "_id DESC");
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            ds0.a().d(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.BaseLazyFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    public void p0(String str, boolean z, ContactInfoItem contactInfoItem, int i2, ContactRequestArgs contactRequestArgs) {
        ih ihVar = new ih(new m(z, str, contactInfoItem), new l());
        this.w = ihVar;
        try {
            ihVar.r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public String r0() {
        return this.J;
    }

    public void s0(boolean z, xu4 xu4Var) {
        int i2 = z ? this.x + 1 : 0;
        LocationEx locationExI = q05.i();
        HashMap map = new HashMap();
        if (locationExI != null) {
            map.put("latitude", locationExI.getLatitude() + "");
            map.put("longitude", locationExI.getLongitude() + "");
            b05.d("经度===》" + locationExI.getLatitude());
            b05.d("纬度===》" + locationExI.getLongitude());
        } else {
            b05.d("没有获取经纬度");
        }
        map.put("index", Integer.valueOf(i2));
        zw4.e(new u(nl0.z + "/lbs.square.friends.recommend.pull.v4", map, z, xu4Var, i2));
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(@NonNull Loader<Cursor> loader, @Nullable Cursor cursor) {
        if (cursor != null) {
            LogUtil.d("NewContactFragment", "onLoadFinished count:" + cursor.getCount());
            cursor.moveToPosition(-1);
            ArrayList<ContactRequestsVO> arrayListBuildFromCursorForLX16234 = ContactRequestsVO.buildFromCursorForLX16234(cursor, true);
            y0(arrayListBuildFromCursorForLX16234);
            if (bg2.d()) {
                C0(arrayListBuildFromCursorForLX16234);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<ContactRequestsVO> it = arrayListBuildFromCursorForLX16234.iterator();
            while (it.hasNext()) {
                arrayList.add(new NewFriendAdapter.a(it.next()));
            }
            this.q.q(arrayList);
            if (this.I) {
                I0(arrayListBuildFromCursorForLX16234.size() > 0);
                if (this.H) {
                    K0(arrayListBuildFromCursorForLX16234.size() > 0);
                }
            } else {
                this.I = true;
                I0(arrayListBuildFromCursorForLX16234.size() > 0);
                K0(arrayListBuildFromCursorForLX16234.size() > 0);
            }
            if (!v8.h() || v8.l == null) {
                return;
            }
            String str = arrayListBuildFromCursorForLX16234.size() > 0 ? "newFriend_notEmpty" : "newFriend_empty";
            LogUtil.d("AiChatPeopleManagerTag", "NewFriendFragment onLoadFinished startTriggerToServer AiChatPeopleManager.msgFriendRequest scene " + str);
            G0(v8.l, str);
        }
    }

    public final void u0() {
        try {
            JSONObject config = vs0.a().getConfig("newfriend_emptypage_config");
            b05.d("获取到的newfriend_emptypage_config值为=======>" + config);
            JSONObject jSONObject = config.getJSONObject("function_recommend_android");
            JSONObject jSONObject2 = config.getJSONObject("user_recommendv2_Android");
            jSONObject.optString("title", "");
            String strOptString = jSONObject2.optString("title", "");
            boolean zOptBoolean = jSONObject.optBoolean("status", false);
            boolean zOptBoolean2 = jSONObject2.optBoolean("status", false);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
            this.m.setVisibility(zOptBoolean ? 0 : 8);
            if (!zOptBoolean2) {
                this.n.setVisibility(8);
                this.B.clear();
                this.y.notifyDataSetChanged();
            }
            this.G.setText(strOptString);
            this.A.clear();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length() && i2 < 3; i2++) {
                JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i2);
                String strOptString2 = jSONObject3.optString("url", "");
                b05.d("读取配置====>url====>" + strOptString2);
                String strOptString3 = jSONObject3.optString("pic", "");
                b05.d("读取配置====>pic====>" + strOptString3);
                w42 w42Var = new w42();
                w42Var.b = strOptString3;
                w42Var.f21614a = strOptString2;
                this.A.add(w42Var);
                if (i2 == 0) {
                    hc2.a(getContext()).load(w42Var.b).placeholder(R.drawable.icon_new_friend_zhanwei1).into(this.F.get(i2));
                } else {
                    hc2.a(getContext()).load(w42Var.b).placeholder(R.drawable.icon_new_friend_zhanwei2).into(this.F.get(i2));
                }
                this.F.get(i2).setOnClickListener(new c(i2, w42Var));
            }
            if (!zOptBoolean2) {
                this.C.setEnableRefresh(false);
            } else {
                s0(false, this.C);
                this.C.setEnableRefresh(true);
            }
        } catch (Exception unused) {
            b05.d("读取配置出错！");
            this.C.setEnableRefresh(false);
        }
    }

    public final void w0() {
        try {
            JSONObject config = vs0.a().getConfig("newfriendpage_noticeentry");
            int i2 = 0;
            boolean zOptBoolean = config.optBoolean("status", false);
            String strOptString = config.optString("url", "");
            String strOptString2 = config.optString("pic", "");
            ImageView imageView = this.E;
            if (!zOptBoolean) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            if (!TextUtils.isEmpty(strOptString2)) {
                hc2.a(getContext()).load(strOptString2).into(this.E);
            }
            this.E.setOnClickListener(new h(strOptString));
        } catch (Exception unused) {
            b05.d("读取配置出错！");
        }
    }

    public void x0(HashMap<String, String> map, RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager != null) {
            int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            for (int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() > 1 ? linearLayoutManager.findFirstVisibleItemPosition() : 1; iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
                if (iFindFirstVisibleItemPosition < recyclerView.getAdapter().getItemCount() && iFindFirstVisibleItemPosition < this.B.size() + 1 && iFindFirstVisibleItemPosition >= 0 && recyclerView.getAdapter().getItemCount() > 0) {
                    int i2 = iFindFirstVisibleItemPosition - 1;
                    NearByBean nearByBean = this.B.get(i2);
                    String str = nearByBean.exid + ",位置" + i2;
                    if (!map.containsKey(str)) {
                        map.put(str, str);
                        b05.d("上传数据:" + str);
                        zn6.j("pagemsg_newfrd_recommend_contentshow", "view", new g(nearByBean));
                    }
                }
            }
        }
    }

    public final void y0(ArrayList<ContactRequestsVO> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<ContactRequestsVO> it = arrayList.iterator();
        while (it.hasNext()) {
            ContactRequestsVO next = it.next();
            if (io0.u(next.sourceType) && !bo0.r().w(next.fromUid) && !ContactRequestsVO.isSenderParseFromRid(next.requestRid)) {
                long j2 = next.applyTime;
                if (j2 > 0 && jCurrentTimeMillis > j2 + (next.applyExpireSec * 1000)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f13840a;
        public final /* synthetic */ RecyclerView b;

        public f(HashMap map, RecyclerView recyclerView) {
            this.f13840a = map;
            this.b = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            b05.d("dataChanged");
            NewFriendFragment.this.x0(this.f13840a, this.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            b05.d("dataChanged");
            NewFriendFragment.this.x0(this.f13840a, this.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            b05.d("dataChanged");
            NewFriendFragment.this.x0(this.f13840a, this.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            b05.d("dataChanged");
            NewFriendFragment.this.x0(this.f13840a, this.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            b05.d("dataChanged");
            NewFriendFragment.this.x0(this.f13840a, this.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            super.onItemRangeChanged(i, i2, obj);
            b05.d("dataChanged");
            NewFriendFragment.this.x0(this.f13840a, this.b);
        }
    }

    public final void C0(ArrayList<ContactRequestsVO> arrayList) {
    }

    @Override // defpackage.pm2
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
    }
}
