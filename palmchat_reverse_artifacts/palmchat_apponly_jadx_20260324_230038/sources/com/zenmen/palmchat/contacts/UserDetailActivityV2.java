package com.zenmen.palmchat.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.constants.ErrorCode;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.find.ConditionHelper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.find.FindNearByMapActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.temporary.SquareTempChatActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.contacts.UserDetailActivityV2;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.contacts.userdetail.c;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.utils.ServerException;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.UI;
import defpackage.a65;
import defpackage.az2;
import defpackage.b05;
import defpackage.bo0;
import defpackage.bq3;
import defpackage.bw4;
import defpackage.c70;
import defpackage.ds0;
import defpackage.dt2;
import defpackage.dv0;
import defpackage.e20;
import defpackage.eb1;
import defpackage.f7;
import defpackage.fn0;
import defpackage.fo;
import defpackage.fu5;
import defpackage.ho0;
import defpackage.i65;
import defpackage.ie2;
import defpackage.ih;
import defpackage.ik4;
import defpackage.io0;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.is0;
import defpackage.jo6;
import defpackage.jw5;
import defpackage.k86;
import defpackage.l50;
import defpackage.l92;
import defpackage.mj1;
import defpackage.n42;
import defpackage.nl0;
import defpackage.nn0;
import defpackage.nn4;
import defpackage.nw5;
import defpackage.o2;
import defpackage.oc3;
import defpackage.p05;
import defpackage.pm2;
import defpackage.q05;
import defpackage.q92;
import defpackage.qm5;
import defpackage.r66;
import defpackage.r75;
import defpackage.rn0;
import defpackage.ro2;
import defpackage.rx4;
import defpackage.s34;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.tj2;
import defpackage.tn0;
import defpackage.u93;
import defpackage.un0;
import defpackage.v4;
import defpackage.v8;
import defpackage.va1;
import defpackage.vi5;
import defpackage.vn0;
import defpackage.w4;
import defpackage.wn4;
import defpackage.xg5;
import defpackage.xn3;
import defpackage.yk6;
import defpackage.zg5;
import defpackage.zh;
import defpackage.zn6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserDetailActivityV2 extends BaseActionBarActivity implements pm2<Cursor>, c.p {
    public static final String O0 = "UserDetailActivityV2";
    public String A0;
    public String E;
    public int E0;
    public long F;
    public int F0;
    public long G;
    public ContactRequestsVO H;
    public Boolean L;
    public boolean M;
    public int N;
    public String O;
    public int Q;
    public boolean S;
    public Toolbar T;
    public Toolbar U;
    public View V;
    public View W;
    public View X;
    public View Y;
    public View Z;
    public View e0;
    public View f0;
    public View g0;
    public com.zenmen.palmchat.contacts.userdetail.c j0;
    public bw4 l0;
    public q92 m0;
    public o2 n0;
    public bq3 o0;
    public i65 p0;
    public ContactInfoItem q;
    public f7 q0;
    public SquareFeed r;
    public ih r0;
    public String t;
    public String u;
    public boolean x;
    public GroupInfoItem y;
    public GroupInfoItem z;
    public boolean s = false;
    public String v = null;
    public String w = "";
    public int A = 0;
    public String B = "";
    public String C = "";
    public int I = -1;
    public int J = 0;
    public int K = 0;
    public String P = "";
    public int R = 0;
    public boolean h0 = false;
    public int i0 = 0;
    public long k0 = 0;
    public boolean s0 = false;
    public String[] t0 = {AppContext.getContext().getResources().getString(R.string.modify_contact_menu_remark), AppContext.getContext().getResources().getString(R.string.string_send_name_card), AppContext.getContext().getResources().getString(R.string.string_delete)};
    public int[] u0 = {R.drawable.icon_menu_remark, R.drawable.icon_menu_send_name_card, R.drawable.icon_delete_new};
    public String[] v0 = {AppContext.getContext().getResources().getString(R.string.modify_contact_menu_remark), AppContext.getContext().getResources().getString(R.string.string_send_name_card), AppContext.getContext().getResources().getString(R.string.text_user_deatil_report_text), AppContext.getContext().getResources().getString(R.string.add_to_blacklist), AppContext.getContext().getResources().getString(R.string.string_delete)};
    public String[] w0 = {AppContext.getContext().getResources().getString(R.string.modify_contact_menu_remark), AppContext.getContext().getResources().getString(R.string.string_send_name_card), AppContext.getContext().getResources().getString(R.string.text_user_deatil_report_text), AppContext.getContext().getResources().getString(R.string.remove_blacklist), AppContext.getContext().getResources().getString(R.string.string_delete)};
    public int[] x0 = {R.drawable.icon_menu_remark, R.drawable.icon_menu_send_name_card, R.drawable.icon_menu_report, R.drawable.icon_menu_blacklist, R.drawable.icon_delete_new};
    public boolean y0 = AppContext.getContext().getTrayPreferences().a(k86.n(), false);
    public i0 z0 = new i0(this);
    public int B0 = -1;
    public int C0 = -1;
    public boolean D0 = false;
    public int G0 = 0;
    public is0.e H0 = new b();
    public boolean I0 = false;
    public boolean J0 = false;
    public Response.ErrorListener K0 = new n();
    public Response.Listener<JSONObject> L0 = new o();
    public Response.ErrorListener M0 = new p();
    public Response.Listener<JSONObject> N0 = new q();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserDetailActivityV2.this.F2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements is0.e {
        public b() {
        }

        @Override // is0.e
        public void a(int i, String str) {
            if (str.equals(UserDetailActivity.ClickMenuItem.REMARK.name())) {
                UserDetailActivityV2.this.k3();
                return;
            }
            if (str.equals(UserDetailActivity.ClickMenuItem.REPORT.name())) {
                UserDetailActivityV2.this.b3();
                return;
            }
            if (str.equals(UserDetailActivity.ClickMenuItem.SEND_NAME_CARD.name())) {
                UserDetailActivityV2.this.e3();
                return;
            }
            if (str.equals(UserDetailActivity.ClickMenuItem.BLACKLIST.name())) {
                UserDetailActivityV2.this.Z2();
            } else if (str.equals(UserDetailActivity.ClickMenuItem.DELETE_CONTACT.name())) {
                UserDetailActivityV2.this.H2();
            } else if (str.equals(UserDetailActivity.ClickMenuItem.SPECIAL_ATTENTION.name())) {
                UserDetailActivityV2.this.c3();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b0 extends HashMap<String, Object> {
        public b0() {
            put("isFriend", Integer.valueOf(UserDetailActivityV2.this.i0 == 2 ? 0 : 1));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            UserDetailActivityV2.this.I2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements View.OnClickListener {
        public c0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            oc3.b(UserDetailActivityV2.this, 9);
            if (UserDetailActivityV2.this.q != null) {
                oc3.a("click", UserDetailActivityV2.this.G0, UserDetailActivityV2.this.q.getUid(), UserDetailActivityV2.this.q.getGender(), UserDetailActivityV2.this.q.getAge());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends AsyncTask<Void, Void, Boolean> {
        public d() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                new va1(UserDetailActivityV2.this.q).n();
                return Boolean.TRUE;
            } catch (ServerException unused) {
                return Boolean.FALSE;
            } catch (DaoException unused2) {
                return Boolean.FALSE;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            UserDetailActivityV2.this.hideBaseProgressBar();
            if (!bool.booleanValue()) {
                sy5.f(AppContext.getContext(), UserDetailActivityV2.this.getText(R.string.send_failed), 1).g();
                return;
            }
            if (UserDetailActivityV2.this.A == 5) {
                UserDetailActivityV2.this.setResult(-1);
            }
            UserDetailActivityV2.this.finish();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            UserDetailActivityV2.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GiftMessageHelper.S(UserDetailActivityV2.this.q);
            }
        }

        public d0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactInfoItem contactInfoItemL = bo0.r().l(UserDetailActivityV2.this.q.getUid());
            if (contactInfoItemL == null) {
                if (UserDetailActivityV2.this.A != 11 || UserDetailActivityV2.this.q == null) {
                    return;
                }
                UserDetailActivityV2.this.i0 = 2;
                UserDetailActivityV2.this.q.setFriendType(1);
                UserDetailActivityV2.this.j0.S(UserDetailActivityV2.this.q, UserDetailActivityV2.this.i0, false);
                return;
            }
            contactInfoItemL.setIdentifyCode(UserDetailActivityV2.this.q.getIdentifyCode());
            contactInfoItemL.setOnline(UserDetailActivityV2.this.q.isOnline());
            contactInfoItemL.setDistance(UserDetailActivityV2.this.q.getDistance());
            contactInfoItemL.setCityName(UserDetailActivityV2.this.q.getCityName());
            contactInfoItemL.setOnlineStatusDesc(UserDetailActivityV2.this.q.getOnlineStatusDesc());
            contactInfoItemL.setLoveView(UserDetailActivityV2.this.q.getLoveView());
            contactInfoItemL.setCharmLevel(UserDetailActivityV2.this.q.getCharmLevel());
            contactInfoItemL.setRichLevel(UserDetailActivityV2.this.q.getRichLevel());
            contactInfoItemL.setAlbum(UserDetailActivityV2.this.q.getAlbum());
            UserDetailActivityV2.this.l3(contactInfoItemL);
            if (UserDetailActivityV2.this.i0 == 2 && !contactInfoItemL.getIsStranger()) {
                UserDetailActivityV2.this.i0 = 1;
                UserDetailActivityV2.this.j0.E();
                if (p05.c()) {
                    UserDetailActivityV2 userDetailActivityV2 = UserDetailActivityV2.this;
                    if (userDetailActivityV2.s0) {
                        userDetailActivityV2.s0 = false;
                        u93.b(500, new a());
                        if (UserDetailActivityV2.this.q != null && !q05.o(UserDetailActivityV2.this.sInstance)) {
                            Intent intent = new Intent();
                            UserDetailActivityV2.this.f3(intent);
                            UserDetailActivityV2.this.startActivity(intent);
                        }
                    }
                }
            }
            UserDetailActivityV2.this.j0.S(UserDetailActivityV2.this.q, UserDetailActivityV2.this.i0, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {
        public e() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivityV2.this.hideBaseProgressBar();
            UserDetailActivityV2.this.h0 = false;
            LogUtil.d(UserDetailActivityV2.O0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 implements Runnable {
        public e0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserDetailActivityV2.this.y2(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 implements Response.Listener<JSONObject> {
        public f0() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            boolean z;
            if (jSONObject != null) {
                LogUtil.json("logportrait", jSONObject.toString(), "response: " + nl0.z + "/userem.getUserDetail.v4");
            }
            try {
                UserDetailActivityV2.this.hideBaseProgressBar();
                UserDetailActivityV2.this.j0.D(false);
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP == null || UserDetailActivityV2.this.i0 == 0) {
                    if (contactInfoItemP != null) {
                        UserDetailActivityV2.this.q.setLoveView(contactInfoItemP.getLoveView());
                        UserDetailActivityV2.this.q.setRichLevel(contactInfoItemP.getRichLevel());
                        UserDetailActivityV2.this.q.setCharmLevel(contactInfoItemP.getCharmLevel());
                        UserDetailActivityV2.this.q.setLikeCount(contactInfoItemP.getLikeCount());
                        UserDetailActivityV2.this.q.setAlbum(contactInfoItemP.getAlbum());
                        UserDetailActivityV2.this.q.setFid(contactInfoItemP.getFid());
                    }
                    UserDetailActivityV2.this.j0.S(UserDetailActivityV2.this.q, UserDetailActivityV2.this.i0, false);
                } else {
                    if (ContactInfoItem.isUidAvailable(UserDetailActivityV2.this.q.getUid())) {
                        contactInfoItemP.setFriendType(UserDetailActivityV2.this.q.getFriendType());
                        z = false;
                    } else {
                        ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemP.getUid());
                        if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                            UserDetailActivityV2.this.i0 = 2;
                            contactInfoItemP.setFriendType(1);
                        } else {
                            if (contactInfoItemP.getUid() == null || !contactInfoItemP.getUid().equals(AccountUtils.p(UserDetailActivityV2.this))) {
                                UserDetailActivityV2.this.i0 = 1;
                            } else {
                                UserDetailActivityV2.this.i0 = 0;
                            }
                            contactInfoItemP.setFriendType(0);
                        }
                        z = true;
                    }
                    contactInfoItemP.setIdentifyCode(UserDetailActivityV2.this.q.getIdentifyCode());
                    if (24 != UserDetailActivityV2.this.A) {
                        UserDetailActivityV2.this.o3(contactInfoItemP);
                    }
                    UserDetailActivityV2.this.l3(contactInfoItemP);
                    UserDetailActivityV2.this.N2();
                    ContactInfoItem contactInfoItemL2 = bo0.r().l(UserDetailActivityV2.this.q.getUid());
                    if (contactInfoItemL2 != null) {
                        if (contactInfoItemL2.getIsStranger()) {
                            UserDetailActivityV2.this.q.setRemarkName(contactInfoItemL2.getRemarkName());
                            UserDetailActivityV2.this.q.setDescription(contactInfoItemL2.getDescription());
                            UserDetailActivityV2.this.getContentResolver().insert(ho0.f18003a, nn0.a(UserDetailActivityV2.this.q));
                        } else {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("account_type", Integer.valueOf(UserDetailActivityV2.this.q.getAccountType()));
                            contentValues.put("age", UserDetailActivityV2.this.q.getAge());
                            contentValues.put(com.umeng.ccg.a.A, UserDetailActivityV2.this.q.getSignature());
                            contentValues.put("data5", contactInfoItemP.getExt() == null ? "" : az2.c(contactInfoItemP.getExt()));
                            UserDetailActivityV2.this.getContentResolver().update(ho0.f18003a, contentValues, "uid=?", new String[]{UserDetailActivityV2.this.q.getUid()});
                        }
                    }
                    if (z && contactInfoItemL2 != null) {
                        UserDetailActivityV2.this.q.setSessionConfig(contactInfoItemL2.getSessionConfig());
                        UserDetailActivityV2.this.q.setRemarkName(contactInfoItemL2.getRemarkName());
                        UserDetailActivityV2.this.q.setDescription(contactInfoItemL2.getDescription());
                    }
                    UserDetailActivityV2.this.n3();
                    UserDetailActivityV2.this.j0.S(UserDetailActivityV2.this.q, UserDetailActivityV2.this.i0, false);
                    if (UserDetailActivityV2.this.A == 6) {
                        ie2.b(UserDetailActivityV2.this.q);
                    } else if (UserDetailActivityV2.this.A == 11) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("fuid", contactInfoItemP.getUid());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "3132", "1", null, jSONObject2.toString());
                    }
                    un0.h(contactInfoItemP, false);
                }
                if (contactInfoItemP != null) {
                    UserDetailActivityV2.this.q.setUserLabelImg(contactInfoItemP.getUserLabelImg());
                }
                UserDetailActivityV2.this.j0.y();
                UserDetailActivityV2.this.j0.O();
                UserDetailActivityV2.this.j0.T(UserDetailActivityV2.this.q.getUserLabelImg());
                LogUtil.onClickEvent("1311", "1", null);
                if (contactInfoItemP != null) {
                    UserDetailActivityV2.this.q.setFeedSeparation(contactInfoItemP.getFeedSeparation());
                }
                UserDetailActivityV2.this.O2();
            } catch (JSONException e2) {
                e2.printStackTrace();
                LogUtil.onClickEvent("1311", "2", null);
            }
            if ((UserDetailActivityV2.this.M || UserDetailActivityV2.this.L.booleanValue()) && !UserDetailActivityV2.this.isFinishing()) {
                UserDetailActivityV2.this.b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {
        public g() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            UserDetailActivityV2.this.hideBaseProgressBar();
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 implements Response.ErrorListener {
        public g0() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivityV2.this.hideBaseProgressBar();
            UserDetailActivityV2.this.j0.D(true);
            UserDetailActivityV2.this.j0.S(UserDetailActivityV2.this.q, UserDetailActivityV2.this.i0, false);
            LogUtil.onClickEvent("1311", "2", null);
            UserDetailActivityV2.this.j0.x();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {
        public h() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivityV2.this.hideBaseProgressBar();
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 implements View.OnClickListener {
        public h0() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            boolean z;
            if (l50.a()) {
                return;
            }
            ContactInfoItem contactInfoItemL = bo0.r().l(AccountUtils.p(AppContext.getContext()));
            if (contactInfoItemL == null || contactInfoItemL.getExt() == null) {
                z = false;
            } else {
                z = true;
                if (contactInfoItemL.getExt().getPrcRealName() != 1) {
                }
            }
            w4.B(UserDetailActivityV2.this, 2, null, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13529a;

        public i(ContactInfoItem contactInfoItem) {
            this.f13529a = contactInfoItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q05.o(UserDetailActivityV2.this.sInstance)) {
                return;
            }
            GiftMessageHelper.T(this.f13529a, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i0 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<UserDetailActivityV2> f13530a;

        public i0(UserDetailActivityV2 userDetailActivityV2) {
            this.f13530a = new WeakReference<>(userDetailActivityV2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.j("pageprofil_top_setting", "click", UserDetailActivityV2.this.j0.s());
            UserDetailActivityV2.this.i3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserDetailActivityV2.this.I0 = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m extends MaterialDialog.e {
        public m() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            UserDetailActivityV2.this.J0 = true;
            UserDetailActivityV2 userDetailActivityV2 = UserDetailActivityV2.this;
            userDetailActivityV2.G2(userDetailActivityV2.q.getChatId(), jw5.b(UserDetailActivityV2.this.q.getSessionConfig(), 8));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Response.ErrorListener {
        public n() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(UserDetailActivityV2.O0, volleyError.toString());
            UserDetailActivityV2.this.hideBaseProgressBar();
            UserDetailActivityV2.this.h3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Response.Listener<JSONObject> {
        public o() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(UserDetailActivityV2.O0, jSONObject.toString());
            int iOptInt = jSONObject.optInt("resultCode");
            UserDetailActivityV2.this.hideBaseProgressBar();
            if (iOptInt != 0) {
                if (iOptInt == 1320) {
                    rx4.b(UserDetailActivityV2.this, jSONObject);
                    return;
                } else {
                    UserDetailActivityV2.this.h3();
                    return;
                }
            }
            if (UserDetailActivityV2.this.J0) {
                UserDetailActivityV2.this.J0 = false;
                if (zg5.j(UserDetailActivityV2.this.q.getChatId())) {
                    xg5.e().m();
                }
            }
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Response.ErrorListener {
        public p() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(UserDetailActivityV2.O0, volleyError.toString());
            UserDetailActivityV2.this.hideBaseProgressBar();
            sy5.e(AppContext.getContext(), R.string.sv_settings_fail, 0).g();
            UserDetailActivityV2.this.j0.S(UserDetailActivityV2.this.q, UserDetailActivityV2.this.i0, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements Response.Listener<JSONObject> {
        public q() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(UserDetailActivityV2.O0, jSONObject.toString());
            UserDetailActivityV2.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") == 0) {
                iq5.j(false, new String[0]);
            } else {
                sy5.e(AppContext.getContext(), R.string.sv_settings_fail, 0).g();
                UserDetailActivityV2.this.j0.S(UserDetailActivityV2.this.q, UserDetailActivityV2.this.i0, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements Response.ErrorListener {
        public s() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivityV2.this.hideBaseProgressBar();
            sy5.e(UserDetailActivityV2.this, R.string.send_failed, 0).g();
            LogUtil.d(UserDetailActivityV2.O0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13541a;
        public final /* synthetic */ ContactRequestsVO b;

        public t(boolean z, ContactRequestsVO contactRequestsVO) {
            this.f13541a = z;
            this.b = contactRequestsVO;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            UserDetailActivityV2.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                UserDetailActivityV2.this.s0 = true;
                iq5.j(false, new String[0]);
                return;
            }
            if (iOptInt != 1) {
                if (iOptInt == 1318) {
                    sy5.e(UserDetailActivityV2.this, R.string.send_refuse, 1).g();
                    return;
                }
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(UserDetailActivityV2.this, jSONObject);
                    return;
                } else {
                    if (iOptInt == 1330 && UserDetailActivityV2.this.q != null && UserDetailActivityV2.this.q.isCancellation()) {
                        return;
                    }
                    sy5.f(UserDetailActivityV2.this, rx4.a(jSONObject), 0).g();
                    return;
                }
            }
            if (UserDetailActivityV2.this.M || UserDetailActivityV2.this.K == 92 || UserDetailActivityV2.this.K == 95) {
                UserDetailActivityV2.this.E2(this.f13541a, this.b);
                UserDetailActivityV2.this.M = false;
                return;
            }
            Intent intent = new Intent(UserDetailActivityV2.this, (Class<?>) NewContactRequestSendActivity.class);
            intent.putExtra("user_item_info", UserDetailActivityV2.this.q);
            intent.putExtra("uid_key", UserDetailActivityV2.this.q.getUid());
            intent.putExtra("new_contact_source_type", UserDetailActivityV2.this.I);
            intent.putExtra("new_contact_is_reverse", this.f13541a);
            intent.putExtra("new_contact_contactrequst_info", UserDetailActivityV2.this.H);
            intent.putExtra("new_contact_local_phone_number", UserDetailActivityV2.this.t);
            intent.putExtra("subtype_key", UserDetailActivityV2.this.K);
            intent.putExtra("groupid", UserDetailActivityV2.this.C);
            intent.putExtra("from_user_detail", true);
            intent.putExtra("extra_request_from", UserDetailActivityV2.this.getIntent().getIntExtra("extra_request_from", 0));
            intent.putExtra("extra_request_type", UserDetailActivityV2.this.getIntent().getIntExtra("extra_request_type", 0));
            if (UserDetailActivityV2.this.A == 6) {
                intent.putExtra("groupchat_name", UserDetailActivityV2.this.w);
            }
            if (this.f13541a) {
                UserDetailActivityV2.this.startActivityForResult(intent, 101);
            } else {
                UserDetailActivityV2.this.startActivity(intent);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Response.ErrorListener {
        public u() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivityV2.this.hideBaseProgressBar();
            sy5.e(UserDetailActivityV2.this, R.string.send_failed, 0).g();
            LogUtil.d(UserDetailActivityV2.O0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = UserDetailActivityV2.this.X.getVisibility() == 0;
            HashMap<String, Object> mapS = UserDetailActivityV2.this.j0.s();
            mapS.put(TtmlNode.TEXT_EMPHASIS_MARK_DOT, Integer.valueOf(z ? 2 : 1));
            zn6.j("pageprofil_top_edit", "click", mapS);
            if (z) {
                UserDetailActivityV2.this.X.setVisibility(8);
                UserDetailActivityV2.this.e0.setVisibility(8);
                com.zenmen.palmchat.settings.b.c().a(2);
            }
            UserDetailActivityV2.this.startActivity(nn4.a(UserDetailActivityV2.this, 6));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13544a;

        public w(boolean z) {
            this.f13544a = z;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            UserDetailActivityV2.this.hideBaseProgressBar();
            if (iOptInt != 0 && iOptInt != 1) {
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(UserDetailActivityV2.this, jSONObject);
                    return;
                }
                return;
            }
            if (this.f13544a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 2L);
                contentValues.put("request_type", (Integer) 0);
                contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + UserDetailActivityV2.this.q.getUid());
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{UserDetailActivityV2.this.q.getUid()});
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("accept_status", (Long) 2L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{UserDetailActivityV2.this.q.getUid()});
            }
            UserDetailActivityV2.this.j0.C();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements Runnable {
        public z() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserDetailActivityV2.this.M2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U2(int i2, ContactInfoItem contactInfoItem) {
        if (contactInfoItem != null) {
            this.j0.l(i2, contactInfoItem.getRoleType());
        }
    }

    public static /* synthetic */ Object V2() {
        return " 跳转到临时聊天界面";
    }

    public static void j3(Context context, int i2, ContactInfoItem contactInfoItem, boolean z2) {
        boolean zW = bo0.r().w(contactInfoItem.getUid());
        ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItem.getUid());
        if (contactInfoItemL != null) {
            contactInfoItem = contactInfoItemL;
        }
        if (zW) {
            Intent intent = new Intent(context, (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", contactInfoItem);
            intent.putExtra("chat_need_back_to_main", z2);
            intent.putExtra("chat_back_to_greet", false);
            k86.X(intent);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) NewContactRequestSendActivity.class);
        intent2.putExtra("user_item_info", contactInfoItem);
        intent2.putExtra("uid_key", contactInfoItem.getUid());
        intent2.putExtra("new_contact_source_type", i2 == 11 ? 14 : i2 == 26 ? 28 : -1);
        intent2.putExtra("new_contact_is_reverse", false);
        intent2.putExtra("from_user_detail", true);
        context.startActivity(intent2);
    }

    public final void A2() {
        LogUtil.d("ClearAd", "clearCacheAd UserDetailActivityV2 onDestroy");
        eb1.c();
    }

    public final void B2() {
        if (this.S) {
            Intent intent = new Intent(this, (Class<?>) RecommendRequestSendActivity.class);
            intent.putExtra("uid_key", this.q.getUid());
            intent.putExtra("user_item_info_key", this.q);
            intent.putExtra("source_type_key", this.I);
            intent.putExtra("subtype_key", this.K);
            intent.putExtra("real_name", this.P);
            intent.putExtra("send_from_type", this.Q);
            intent.putExtra("is_reverse", false);
            intent.putExtra("new_contact_local_phone_number", this.t);
            intent.putExtra("extra_request_from", getIntent().getIntExtra("extra_request_from", 0));
            intent.putExtra("extra_request_type", getIntent().getIntExtra("extra_request_type", 0));
            if (this.A == 6) {
                intent.putExtra("groupchat_name", this.w);
            }
            startActivityForResult(intent, 102);
            return;
        }
        if (!jo6.t()) {
            C2(false, null);
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) NewContactRequestSendActivityV2.class);
        intent2.putExtra("user_item_info", this.q);
        intent2.putExtra("uid_key", this.q.getUid());
        intent2.putExtra("new_contact_source_type", this.I);
        intent2.putExtra("new_contact_is_reverse", false);
        intent2.putExtra("new_contact_local_phone_number", this.t);
        intent2.putExtra("subtype_key", this.K);
        intent2.putExtra("send_from_type", this.Q);
        intent2.putExtra("groupid", this.C);
        intent2.putExtra("extra_request_from", getIntent().getIntExtra("extra_request_from", 0));
        intent2.putExtra("extra_request_type", getIntent().getIntExtra("extra_request_type", 0));
        if (this.A == 6) {
            intent2.putExtra("groupchat_name", this.w);
        }
        startActivity(intent2);
    }

    public final void C2(boolean z2, ContactRequestsVO contactRequestsVO) {
        s sVar = new s();
        t tVar = new t(z2, contactRequestsVO);
        if (this.q.getUid() == null) {
            return;
        }
        ContactRequestArgs.Builder builderG = new ContactRequestArgs.Builder().h(z2).b(contactRequestsVO).e(ContactRequestArgs.c(this.q)).i(String.valueOf(this.I)).j(String.valueOf(this.K)).g(this.j0.q());
        if (this.I == 2) {
            builderG.c(ContactRequestArgs.a(this.C));
        }
        LogUtil.i(O0, "addfriend sourceType: " + this.I);
        f7 f7Var = new f7(tVar, sVar);
        this.q0 = f7Var;
        try {
            f7Var.n(builderG.a());
            showBaseProgressBar(getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void D2() {
        if (this.q == null) {
            return;
        }
        yk6.k().i(this, this.q.getUid(), this.q.getExid());
    }

    public final void E2(boolean z2, ContactRequestsVO contactRequestsVO) {
        u uVar = new u();
        w wVar = new w(z2);
        ContactRequestArgs.Builder builderG = new ContactRequestArgs.Builder().h(z2).b(contactRequestsVO).e(ContactRequestArgs.c(this.q)).i(String.valueOf(this.I)).j(String.valueOf(this.K)).g(this.j0.q());
        if (this.I == 2) {
            builderG.c(ContactRequestArgs.a(this.C));
        }
        ContactRequestArgs contactRequestArgsA = builderG.a();
        this.r0 = new ih(wVar, uVar);
        showBaseProgressBar(getString(R.string.progress_sending), false);
        try {
            this.r0.r(contactRequestArgsA);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void F2() {
        zn6.j("pageprofil_top_retonbutton", "click", this.j0.s());
        if (!this.needBack2MainTab && this.i0 != 0) {
            UserProfileGuide.k(this, 16);
        }
        finish();
    }

    public final void G2(String str, int i2) {
        i65 i65Var = new i65(this.L0, this.K0);
        this.p0 = i65Var;
        try {
            i65Var.n(str, i2);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
        }
    }

    public final void H2() {
        String string = AppContext.getContext().getResources().getString(R.string.delete_contact_confirm_message);
        new sd3(this).T(R.string.string_delete_contact).k(TextUtils.isEmpty(this.q.getNickName()) ? String.format(string, this.q.getUid()) : String.format(string, this.q.getNickName())).N(R.color.material_dialog_button_text_color_red).O(R.string.string_delete).K(R.string.dialog_cancel).f(new c()).e().show();
    }

    public final void I2() {
        new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void J2() {
        Pair<Integer, Integer> pairL = fu5.l(this.q.getBizType());
        if (pairL != null) {
            if (this.K == 0) {
                this.K = ((Integer) pairL.second).intValue();
            }
            if (this.A == 5) {
                this.I = ((Integer) pairL.first).intValue();
                this.K = ((Integer) pairL.second).intValue();
            }
        }
        LogUtil.i("logaddfriend", "obtainDataFromIntent mThreadBizType=" + this.N + "mFrom=" + this.A + "mContactInfoItem.getBizType()=" + this.q.getBizType() + "mContactInfoItem.getSourceType()=" + this.q.getSourceType() + "sourceType=" + this.I + "mSubtype=" + this.K + " from=" + this.A);
    }

    public int K2() {
        int i2 = this.A;
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 4) {
            return 1;
        }
        if (i2 == 6) {
            return 2;
        }
        if (i2 == 22) {
            return 16;
        }
        if (i2 == 8 || i2 == 9) {
            return 3;
        }
        if (i2 == 19) {
            return 20;
        }
        if (i2 == 18 || i2 == 7 || (i2 == 36 && !TextUtils.isEmpty(this.E))) {
            return L2();
        }
        int i3 = this.A;
        if (i3 == 10) {
            return 6;
        }
        int i4 = 11;
        if (i3 == 11) {
            return 14;
        }
        if (i3 == 26) {
            return 28;
        }
        if (i3 == 5) {
            int i5 = this.N;
            if (i5 == 14) {
                i4 = 14;
            } else if (i5 == 17) {
                i4 = 28;
            } else if (i5 == 22) {
                i4 = 200;
            }
            return fu5.t(i5) ? fu5.n(this.N) : i4;
        }
        if (i3 == 13) {
            return 7;
        }
        if (i3 == 24) {
            return 23;
        }
        if (i3 == 31) {
            return 38;
        }
        if (i3 != 33 && i3 != 40 && i3 != 42 && i3 != 41) {
            if (i3 == 45 || i3 == 46) {
                return 45;
            }
            if (i3 != 37 && i3 != 38) {
                if (i3 == 48 || i3 == 34 || i3 == 75) {
                    return 46;
                }
                if (i3 == 50) {
                    return 47;
                }
                return (i3 == 61 || i3 == 89 || i3 == 62 || i3 == 79 || i3 == 80 || i3 == 85 || i3 == 88) ? 60 : -1;
            }
        }
        return 44;
    }

    public final int L2() {
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null) {
            try {
                return contactInfoItem.getSourceType();
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public void M2() {
        int i2 = this.A;
        if (i2 != 7 && i2 == 36) {
            TextUtils.isEmpty(this.E);
        }
        q92 q92Var = new q92(new f0(), new g0());
        this.m0 = q92Var;
        try {
            q92Var.n(this.q.getUid(), this.q.getExid());
        } catch (DaoException e2) {
            e2.printStackTrace();
            LogUtil.onClickEvent("1311", "2", null);
        }
    }

    public final void N2() {
        if (this.g0 == null) {
            View viewFindViewById = findViewById(R.id.iv_authen_icon);
            this.g0 = viewFindViewById;
            viewFindViewById.setOnClickListener(new h0());
        }
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem == null || contactInfoItem.getExt() == null || this.q.getExt().getPrcRealName() != 1 || this.q.isCancellation()) {
            this.g0.setVisibility(8);
            return;
        }
        this.g0.setVisibility(0);
        LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager2 initAuthenView TAG_TYPE_FEED_SEPARATION mFrom " + this.A);
    }

    public final void O2() {
        View viewFindViewById = findViewById(R.id.iv_map_separation_bg);
        this.f0 = viewFindViewById;
        viewFindViewById.setOnClickListener(new c0());
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem == null || contactInfoItem.getFeedSeparation() != NearByBean.TAG_TYPE_FEED_SEPARATION) {
            return;
        }
        oc3.a("view", this.G0, this.q.getUid(), this.q.getGender(), this.q.getAge());
        this.f0.setVisibility(0);
        LogUtil.d("MapSeparationManager", "UserDetailActivity2 initSeparationBgView TAG_TYPE_FEED_SEPARATION mFrom " + this.A);
    }

    public final void P2() {
        Toolbar toolbarInitToolbar = initToolbar("", false);
        this.T = toolbarInitToolbar;
        toolbarInitToolbar.setPadding(0, toolbarInitToolbar.getPaddingTop(), 0, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        this.U = toolbar;
        ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
        layoutParams.height = this.T.getLayoutParams().height;
        this.U.setLayoutParams(layoutParams);
        this.U.setPadding(0, this.T.getPaddingTop(), 0, 0);
        setSupportActionBar(this.T);
        a aVar = new a();
        findViewById(R.id.back).setOnClickListener(aVar);
        findViewById(R.id.back2).setOnClickListener(aVar);
    }

    public final void Q2() {
        String uid = this.q.getUid();
        if (TextUtils.isEmpty(uid)) {
            uid = bo0.r().u(this.q.getExid());
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(uid);
        if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
            this.i0 = 2;
            this.q.setFriendType(1);
        } else {
            l3(contactInfoItemL);
            this.G0 = 1;
            if (this.q.getUid() == null || !this.q.getUid().equals(AccountUtils.p(this))) {
                this.i0 = 1;
            } else {
                this.i0 = 0;
            }
        }
        this.W = findViewById(R.id.menu_edit_profile);
        this.Z = findViewById(R.id.menu_edit_profile2);
        this.X = findViewById(R.id.dot_edit_profile);
        this.e0 = findViewById(R.id.dot_edit_profile2);
        this.V = findViewById(R.id.menu_more);
        this.Y = findViewById(R.id.menu_more2);
        k kVar = new k();
        this.V.setOnClickListener(kVar);
        this.Y.setOnClickListener(kVar);
        v vVar = new v();
        this.W.setOnClickListener(vVar);
        this.Z.setOnClickListener(vVar);
        n3();
        GroupInfoItem groupInfoItem = this.z;
        int addFriendSwitch = groupInfoItem != null ? groupInfoItem.getAddFriendSwitch() : 1;
        this.j0 = new com.zenmen.palmchat.contacts.userdetail.c(this, this.A, this.P, this.v, this.t, this.I, this.E, this.u, this.O, this, this.z0, this.i0 == 0, addFriendSwitch, this.r, this.R);
        this.mBaseProgressDialog = new wn4(this);
        this.j0.S(this.q, this.i0, true);
        final int roleType = this.q.getRoleType();
        this.j0.l(roleType, 0);
        if (!TextUtils.isEmpty(this.C)) {
            c70.R().N(this.C, v4.e(this), new dv0() { // from class: j66
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f18337a.U2(roleType, (ContactInfoItem) obj);
                }
            });
        }
        M2();
        updateCurrentPageInfo(this, new b0());
        if (this.L.booleanValue()) {
            com.zenmen.palmchat.utils.a.E().t(0);
        }
    }

    public final void R2(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("send_time", Long.valueOf(ir5.b()));
        contentValues.put("from_uid", this.q.getUid());
        contentValues.put("mid", xn3.a());
        contentValues.put("from_nick_name", this.q.getNickName());
        contentValues.put("from_head_img_url", this.q.getIconURL());
        contentValues.put("from_signature", this.q.getSignature());
        contentValues.put("request_info", str);
        contentValues.put("user_info", "");
        contentValues.put("rid", this.E);
        contentValues.put("applyTime", Long.valueOf(this.F));
        contentValues.put("applyExpireSec", Long.valueOf(this.G));
        contentValues.put("request_type", (Integer) 2);
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(ir5.b()));
        contentValues.put("accept_status", (Long) 0L);
        contentValues.put("source_type", Integer.valueOf(this.I));
        contentValues.put("identify_code", this.q.getIdentifyCode());
        rn0.j(contentValues);
    }

    public final boolean S2() {
        return !ContactRequestsVO.isSenderParseFromRid(this.E) && this.F > 0 && System.currentTimeMillis() > this.F + (this.G * 1000);
    }

    public final boolean T2() {
        return jw5.e(this.q.getSessionConfig());
    }

    public boolean W2(int i2) {
        return UserDetailActivity.b3(i2) || this.s;
    }

    public boolean X2() {
        if (!this.q.getIsStranger() || jw5.e(this.q.getSessionConfig())) {
            return true;
        }
        int i2 = this.A;
        if (i2 != 9 && i2 != 4 && i2 != 1 && i2 != 13 && i2 != 19) {
            if (i2 == 11) {
                if (nw5.h(this.q.getUid())) {
                    return true;
                }
            } else {
                if (i2 != 7 && (i2 != 36 || TextUtils.isEmpty(this.E))) {
                    return true;
                }
                if ((!TextUtils.isEmpty(this.E) && !ContactRequestsVO.isSenderParseFromRid(this.E)) || nw5.h(this.q.getUid())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void Y2() {
        Intent intent = getIntent();
        this.A = intent.getIntExtra("from", 0);
        this.B0 = intent.getIntExtra(EventParams.KEY_CT_SDK_POSITION, -1);
        this.C0 = intent.getIntExtra("click_area", -1);
        int i2 = 1;
        this.x = intent.getBooleanExtra("log_from", true);
        this.B = intent.getStringExtra("room_id");
        ik4.d(intent.getBooleanExtra("extra_auto_polish", false));
        this.C = intent.getStringExtra("group_id");
        this.D0 = intent.getBooleanExtra("back_to_chat", false);
        this.E = intent.getStringExtra("rid");
        this.J = intent.getIntExtra("agree_subtype", 0);
        this.K = intent.getIntExtra("subtype_key", 0);
        this.F = intent.getLongExtra("apply_time", 0L);
        this.G = intent.getLongExtra("apply_expire_sec", 0L);
        this.t = intent.getStringExtra("user_detail_local_phone_number");
        this.u = intent.getStringExtra("user_detail_name_card_sender_name");
        this.L = Boolean.valueOf(intent.getBooleanExtra("isAccept", false));
        this.M = intent.getBooleanExtra("autoAdd", false);
        this.P = intent.getStringExtra("user_real_name");
        this.R = intent.getIntExtra("superExposeMsgTabItem", 0);
        this.q = (ContactInfoItem) intent.getParcelableExtra("user_item_info");
        this.s = intent.getBooleanExtra("extra_can_chat", false);
        SquareFeed squareFeed = (SquareFeed) intent.getParcelableExtra("square_feed");
        this.r = squareFeed;
        if (squareFeed != null) {
            this.A0 = squareFeed.imprId;
        }
        this.y = (GroupInfoItem) intent.getParcelableExtra("pot_user_item_info");
        this.z = (GroupInfoItem) intent.getParcelableExtra("group_chat_info");
        this.Q = intent.getIntExtra("send_from_type", 0);
        this.S = intent.getBooleanExtra("new_request_send_page", false);
        this.E0 = intent.getIntExtra("enter_anim", 0);
        this.F0 = intent.getIntExtra("out_anim", 0);
        if (this.q == null) {
            finish();
            return;
        }
        this.N = intent.getIntExtra("thread_biz_type", 0);
        this.v = this.q.getGroupRemarkName();
        this.I = this.q.getSourceType();
        this.O = intent.getStringExtra("distance");
        if (this.A == 6) {
            this.w = intent.getStringExtra("groupchat_name");
        }
        if (this.I == -1) {
            this.I = K2();
        }
        if (this.I == 44) {
            int i3 = this.A;
            if (i3 == 41 || i3 == 42 || this.N == 67 || this.q.getBizType() == 67) {
                this.K = 3;
            } else {
                int i4 = this.A;
                if (i4 == 37 || i4 == 38) {
                    this.K = 4;
                } else {
                    this.K = 1;
                }
            }
        }
        if (this.I == 46) {
            if (this.A == 34 || this.N == 65 || this.q.getBizType() == 65) {
                this.K = 2;
            } else if (this.A == 75) {
                this.K = 3;
            } else {
                this.K = 1;
            }
        }
        int i5 = this.A;
        if (i5 == 61 || i5 == 62 || i5 == 63 || i5 == 65) {
            this.K = 1;
        } else if (i5 == 69) {
            this.K = 4;
        } else if (i5 == 67) {
            this.K = 3;
        } else if (i5 == 66) {
            this.K = 2;
        } else if (i5 == 68) {
            this.K = 6;
        }
        J2();
        if (intent.getBooleanExtra("launch_from_notification", false)) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!this.L.booleanValue()) {
                    i2 = 2;
                }
                jSONObject.put("type", i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("rep1", null, null, jSONObject.toString());
        }
    }

    public void Z2() {
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null) {
            jw5.j(contactInfoItem.getSessionConfig());
            jw5.g(this.q.getSessionConfig());
            if (jw5.e(this.q.getSessionConfig())) {
                G2(this.q.getChatId(), jw5.a(this.q.getSessionConfig(), 8));
            } else {
                new sd3(this).T(R.string.add_to_blacklist).j(R.string.blacklist_dialog_content).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new m()).e().show();
            }
        }
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: a3, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            this.j0.J(cursor);
            ArrayList<ContactRequestsVO> arrayListBuildFromCursorForShow = ContactRequestsVO.buildFromCursorForShow(cursor);
            if (arrayListBuildFromCursorForShow == null || arrayListBuildFromCursorForShow.size() <= 0) {
                return;
            }
            this.H = arrayListBuildFromCursorForShow.get(0);
        }
    }

    @Override // com.zenmen.palmchat.contacts.userdetail.c.p
    public void b() {
        ContactInfoItem contactInfoItem;
        if (this.i0 != 2) {
            Intent intent = new Intent();
            if (this.A == 11 && this.i0 == 0) {
                LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "3121", "1", null, null);
                intent = nn4.a(this, 4);
            } else {
                ContactInfoItem contactInfoItem2 = this.q;
                if (contactInfoItem2 == null) {
                    return;
                }
                if (contactInfoItem2.isCancellation()) {
                    I2();
                    return;
                } else {
                    if (e20.a() && this.D0) {
                        finish();
                        return;
                    }
                    f3(intent);
                }
            }
            startActivity(intent);
            return;
        }
        int i2 = this.A;
        if ((i2 == 7 || i2 == 36) && !TextUtils.isEmpty(this.E) && !ContactRequestsVO.isSenderParseFromRid(this.E)) {
            z2(this.E);
            return;
        }
        if (this.A == 11 && !jo6.F()) {
            j3(this, this.A, this.q, false);
            return;
        }
        if (W2(this.A)) {
            y2(false);
            return;
        }
        if (this.A != 5 || (contactInfoItem = this.q) == null || !fu5.t(contactInfoItem.getBizType()) || !ContactInfoItem.isUidAvailable(this.q.getUid()) || !tn0.i().v(this.q.getUid(), true)) {
            B2();
            LogUtil.onClickEvent("13111", null, null);
            return;
        }
        z2(this.q.getUid() + "_" + AccountUtils.p(AppContext.getContext()));
    }

    public final void b3() {
        Intent intent = new Intent();
        intent.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        int i2 = jw5.e(this.q.getSessionConfig()) ? 502 : this.i0 == 1 ? 500 : 503;
        bundle.putString("web_url", tj2.l() + "uid=" + AccountUtils.p(AppContext.getContext()) + "&sourceType=" + i2 + "&uidTo=" + this.q.getChatId() + "&type=1&from=3");
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        bundle.putInt("sourceType", i2);
        bundle.putString("uidTo", this.q.getChatId());
        bundle.putParcelable("contactInfoItem", this.q);
        intent.putExtras(bundle);
        startActivity(intent);
        fo.a(3);
    }

    @Override // com.zenmen.palmchat.contacts.userdetail.c.p
    public void c() {
        if (com.zenmen.palmchat.videocall.c.f()) {
            return;
        }
        if (!com.zenmen.palmchat.videocall.c.e()) {
            sy5.e(this, R.string.service_not_available, 0).g();
        } else {
            r75.p(AppContext.getContext(), k86.a("sp_has_used_videocall_guidence"), 0);
            new com.zenmen.palmchat.videocall.b(this, this.q, null).h();
        }
    }

    public void c3() {
        if (this.q != null) {
            xg5.e().o(this, this.q.getChatId(), !jw5.i(r0.getSessionConfig()), new l(), false, false);
        }
    }

    public final void d3(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", 66 == i2 ? "tab_mine" : "tab_square");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.g("friend_recommend_detail_hi_click", jSONObject);
    }

    @Override // com.zenmen.palmchat.contacts.userdetail.c.p
    public void e() {
        B2();
    }

    public void e3() {
        if (this.q != null) {
            Intent intent = new Intent(this, (Class<?>) SendMessageActivity.class);
            intent.putExtra("extra_share_contact", this.q);
            intent.putExtra("extra_from", 1);
            startActivityForResult(intent, 100);
        }
    }

    @Override // com.zenmen.palmchat.contacts.userdetail.c.p
    public void f() {
        if (S2()) {
            g3();
            return;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog_add_friend_content, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.count);
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_text);
        viewInflate.findViewById(R.id.content).setVisibility(8);
        textView.setText(String.valueOf(30));
        editText.addTextChangedListener(new x(editText, textView));
        new sd3(this).p(viewInflate, false).T(R.string.string_reply).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new y(editText)).e().show();
    }

    public final void f3(Intent intent) {
        intent.setClass(this, ChatterActivity.class);
        intent.putExtra("chat_item", this.q);
        intent.putExtra("thread_biz_type", this.q.getBizType());
        if (e20.a() || fu5.u(this.q)) {
            intent.putExtra("chat_need_back_to_main", false);
            intent.putExtra("chat_back_to_greet", false);
            return;
        }
        int i2 = this.A;
        if (i2 == 11) {
            intent.putExtra("chat_need_back_to_main", false);
            intent.putExtra("chat_back_to_greet", false);
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "3131", "1", null, null);
        } else if (i2 != 31 && i2 != 32) {
            k86.X(intent);
        } else {
            intent.putExtra("chat_need_back_to_main", false);
            intent.putExtra("chat_back_to_greet", false);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        int i2;
        if (this.k0 != 0 && this.q != null) {
            Intent intent = new Intent();
            intent.putExtra("uid_key", this.q.getUid());
            intent.putExtra("accept_status", this.k0);
            setResult(-1, intent);
        }
        super.finish();
        int i3 = this.E0;
        if (i3 == 0 || (i2 = this.F0) == 0) {
            return;
        }
        overridePendingTransition(i3, i2);
    }

    public final void g3() {
        new sd3(this).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new a0()).e().show();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 109;
    }

    public final void h3() {
        sy5.e(this, R.string.send_failed, 0).g();
    }

    public final void i3() {
        ContactInfoItem contactInfoItem;
        int i2 = this.i0;
        if (i2 != 1) {
            if (i2 == 2) {
                ArrayList<is0.g> arrayList = new ArrayList<>();
                arrayList.add(new is0.g(UserDetailActivity.ClickMenuItem.REMARK.name(), getString(R.string.modify_contact_menu_remark), R.drawable.icon_menu_remark));
                arrayList.add(new is0.g(UserDetailActivity.ClickMenuItem.SPECIAL_ATTENTION.name(), jw5.i(this.q.getSessionConfig()) ? "取消设置特别关注" : "设置为特别关注", R.drawable.icon_menu_special_attention));
                arrayList.add(new is0.g(UserDetailActivity.ClickMenuItem.REPORT.name(), getString(R.string.text_user_deatil_report_text), R.drawable.icon_menu_report));
                if (X2()) {
                    arrayList.add(new is0.g(UserDetailActivity.ClickMenuItem.BLACKLIST.name(), !T2() ? getString(R.string.add_to_blacklist) : getString(R.string.remove_blacklist), R.drawable.icon_menu_blacklist));
                }
                showPopupMenu(this, this.T, arrayList, this.H0, null);
                return;
            }
            return;
        }
        if (fu5.u(this.q)) {
            ArrayList<is0.g> arrayList2 = new ArrayList<>();
            arrayList2.add(new is0.g(UserDetailActivity.ClickMenuItem.REMARK.name(), getString(R.string.modify_contact_menu_remark), R.drawable.icon_menu_remark));
            arrayList2.add(new is0.g(UserDetailActivity.ClickMenuItem.SPECIAL_ATTENTION.name(), jw5.i(this.q.getSessionConfig()) ? "取消设置特别关注" : "设置为特别关注", R.drawable.icon_menu_special_attention));
            arrayList2.add(new is0.g(UserDetailActivity.ClickMenuItem.REPORT.name(), getString(R.string.text_user_deatil_report_text), R.drawable.icon_menu_report));
            arrayList2.add(new is0.g(UserDetailActivity.ClickMenuItem.BLACKLIST.name(), !T2() ? getString(R.string.add_to_blacklist) : getString(R.string.remove_blacklist), R.drawable.icon_menu_blacklist));
            showPopupMenu(this, this.T, arrayList2, this.H0, null);
            return;
        }
        ArrayList<is0.g> arrayList3 = new ArrayList<>();
        arrayList3.add(new is0.g(UserDetailActivity.ClickMenuItem.REMARK.name(), getString(R.string.modify_contact_menu_remark), R.drawable.icon_menu_remark));
        arrayList3.add(new is0.g(UserDetailActivity.ClickMenuItem.SPECIAL_ATTENTION.name(), jw5.i(this.q.getSessionConfig()) ? "取消设置特别关注" : "设置为特别关注", R.drawable.icon_menu_special_attention));
        if (!(v8.h() && (contactInfoItem = this.q) != null && v8.C(contactInfoItem.getUid()))) {
            arrayList3.add(new is0.g(UserDetailActivity.ClickMenuItem.SEND_NAME_CARD.name(), getString(R.string.string_send_name_card), R.drawable.icon_menu_send_name_card));
        }
        if (X2()) {
            arrayList3.add(new is0.g(UserDetailActivity.ClickMenuItem.REPORT.name(), getString(R.string.text_user_deatil_report_text), R.drawable.icon_menu_report));
            arrayList3.add(new is0.g(UserDetailActivity.ClickMenuItem.BLACKLIST.name(), !T2() ? getString(R.string.add_to_blacklist) : getString(R.string.remove_blacklist), R.drawable.icon_menu_blacklist));
        }
        arrayList3.add(new is0.g(UserDetailActivity.ClickMenuItem.DELETE_CONTACT.name(), getString(R.string.string_delete), R.drawable.icon_delete_new));
        showPopupMenu(this, this.T, arrayList3, this.H0, null);
    }

    public void k3() {
        Intent intent = new Intent(this, io0.h());
        intent.putExtra("fuid", this.q.getUid());
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null) {
            intent.putExtra("head_img_url", contactInfoItem.getIconURL());
            intent.putExtra("nick_name", this.q.getNickName());
            intent.putExtra("remark_name", this.q.getRemarkName());
            if (this.y0) {
                String mobile = this.q.getMobile();
                if (jo6.i() && TextUtils.isEmpty(mobile)) {
                    mobile = this.t;
                }
                intent.putExtra("register_mobile_number", mobile);
            }
            intent.putExtra("remark_tel", this.q.getRemarkTel());
            intent.putExtra("description", this.q.getDescription());
            intent.putExtra("is_friend", this.i0 == 1);
            intent.putExtra("hide_register_mobile", this.q.getHideRegisterMobile());
        }
        startActivity(intent);
    }

    public final void l3(ContactInfoItem contactInfoItem) {
        ContactInfoItem contactInfoItem2 = this.q;
        if (contactInfoItem2 == null || contactInfoItem == null) {
            return;
        }
        if (!fu5.u(contactInfoItem2) || (!fu5.k(this.q.getBizType()).saveInTempTable && !contactInfoItem.getIsStranger())) {
            this.q = contactInfoItem;
            return;
        }
        int bizType = this.q.getBizType();
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        contactInfoItemM792clone.setBizType(bizType);
        contactInfoItemM792clone.setSourceType(fu5.n(bizType));
        this.q = contactInfoItemM792clone;
    }

    public final void m3() {
        g gVar = new g();
        h hVar = new h();
        HashMap map = new HashMap();
        map.put("fuid", this.q.getUid());
        map.put("remarkName", this.j0.q());
        map.put("description", this.q.getDescription());
        bq3 bq3Var = new bq3(gVar, hVar);
        this.o0 = bq3Var;
        try {
            bq3Var.n(map);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
            iq5.j(false, new String[0]);
        } catch (JSONException e3) {
            e3.printStackTrace();
            hideBaseProgressBar();
            iq5.j(false, new String[0]);
        }
    }

    public final void n3() {
        if (this.i0 == 0) {
            this.V.setVisibility(8);
            this.Y.setVisibility(8);
            this.W.setVisibility(0);
            this.Z.setVisibility(0);
            this.X.setVisibility(com.zenmen.palmchat.settings.b.c().d(2) ? 0 : 8);
            this.e0.setVisibility(com.zenmen.palmchat.settings.b.c().d(2) ? 0 : 8);
            return;
        }
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem == null || !(a65.e(contactInfoItem) || this.q.isCancellation())) {
            this.V.setVisibility(0);
            this.Y.setVisibility(0);
        } else {
            this.V.setVisibility(8);
            this.Y.setVisibility(8);
        }
        this.W.setVisibility(8);
        this.Z.setVisibility(8);
        this.X.setVisibility(8);
        this.e0.setVisibility(8);
    }

    public final void o3(ContactInfoItem contactInfoItem) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("from_head_img_url", contactInfoItem.getIconURL());
            contentValues.put("from_nick_name", contactInfoItem.getNickName());
            getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{contactInfoItem.getUid()});
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1) {
            finish();
            return;
        }
        if (i2 == 101 && i3 == -1) {
            String stringExtra = intent.getStringExtra("revertRid");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.E = stringExtra;
            this.j0.F(stringExtra);
            return;
        }
        if (i2 == 102 && i3 == -1) {
            String stringExtra2 = intent.getStringExtra("revertRid");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.E = stringExtra2;
                this.j0.F(stringExtra2);
            }
            this.k0 = intent.getLongExtra("accept_status", 0L);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        F2();
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new d0());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ds0.a().c(this);
        setContentView(R.layout.layout_activity_user_detail_v2);
        Y2();
        if (this.q == null) {
            return;
        }
        A2();
        P2();
        Q2();
        bo0.r().i().j(this);
        zn6.j("pageprofil", "view", this.j0.n());
        N2();
        D2();
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        return new CursorLoader(this, vn0.f21483a, null, "from_uid=?", new String[]{this.q.getUid()}, "_id DESC ");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ds0.a().d(this);
        if (this.q == null) {
            super.onDestroy();
            return;
        }
        bw4 bw4Var = this.l0;
        if (bw4Var != null) {
            bw4Var.onCancel();
        }
        q92 q92Var = this.m0;
        if (q92Var != null) {
            q92Var.onCancel();
        }
        o2 o2Var = this.n0;
        if (o2Var != null) {
            o2Var.onCancel();
        }
        bq3 bq3Var = this.o0;
        if (bq3Var != null) {
            bq3Var.onCancel();
        }
        i65 i65Var = this.p0;
        if (i65Var != null) {
            i65Var.onCancel();
        }
        f7 f7Var = this.q0;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        ih ihVar = this.r0;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        zh.k(AppContext.getContext().getContentResolver()).a(4096);
        bo0.r().i().l(this);
        this.z0.removeCallbacksAndMessages(null);
        super.onDestroy();
        com.zenmen.palmchat.contacts.userdetail.c cVar = this.j0;
        if (cVar != null) {
            cVar.z();
        }
        A2();
    }

    @qm5
    public void onFriendRequestSuccessEvent(n42 n42Var) {
        b05.c(new b05.a() { // from class: i66
            @Override // b05.a
            public final Object getValue() {
                return UserDetailActivityV2.V2();
            }
        });
        if (q05.o(this.sInstance)) {
            return;
        }
        runOnUiThread(new e0());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent);
        }
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null && a65.e(contactInfoItem)) {
            return true;
        }
        i3();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        F2();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        UI.a(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z2) {
        super.onPermissionGrant(permissionType, permissionUsage, z2);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        LogUtil.d("MapSeparationManager", "UserDetailActivity2 onRequestPermissionsResult requestCode " + i2);
        if (i2 == BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_FEED_USER_MAP_LOCATION.requestCode && tg4.e(iArr)) {
            FindNearByMapActivity.I3(this, ConditionHelper.getInstance().getDriftInfo().location, false, false, 0, 0, 9);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.j0.A();
        if (this.i0 == 0) {
            this.X.setVisibility(com.zenmen.palmchat.settings.b.c().d(2) ? 0 : 8);
            this.e0.setVisibility(com.zenmen.palmchat.settings.b.c().d(2) ? 0 : 8);
        }
        if (this.I0) {
            this.I0 = false;
            if (s34.c() == 1) {
                xg5.e().o(this, this.q.getChatId(), true, new r(), false, false);
            } else {
                sy5.f(this, "设置特别关注必须打开通知栏权限哦！", 0).g();
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ContactInfoItem contactInfoItem;
        if (this.A == 7 && (contactInfoItem = this.q) != null) {
            rn0.r(contactInfoItem.getUid());
        }
        super.onStop();
    }

    @qm5
    public void onUpdateEvent(r66 r66Var) {
        runOnUiThread(new z());
    }

    public final void y2(boolean z2) {
        int bizType;
        int i2;
        if (e20.a() && this.D0) {
            finish();
            return;
        }
        int i3 = this.A;
        if (i3 == 34) {
            bizType = 65;
        } else if (i3 == 41 || i3 == 42) {
            bizType = 67;
        } else if (i3 == 45 || i3 == 46) {
            bizType = 66;
        } else if (i3 == 48) {
            bizType = 68;
        } else if (i3 == 50) {
            bizType = 69;
        } else if (i3 == 11) {
            bizType = ErrorCode.TRAFFIC_CONTROL_DAY;
        } else if (i3 == 66) {
            bizType = 5002;
        } else if (i3 == 68) {
            bizType = ErrorCode.PACKAGE_NAME_ERROR;
        } else if (i3 == 75) {
            bizType = 5016;
        } else if (i3 == 0) {
            ThreadChatItem threadChatItemF = nw5.f(this.q.getChatId());
            bizType = (threadChatItemF != null && threadChatItemF.isContactReady && threadChatItemF.activeStatus == 1) ? threadChatItemF.bizType : 5000;
        } else if (i3 == 79) {
            bizType = fu5.s(this.q.getBizType()) ? this.q.getBizType() : ErrorCode.AD_POS_ID_BLOCKED;
        } else if (i3 == 80) {
            bizType = ErrorCode.AD_TYPE_DEPRECATED;
        } else if (i3 == 85) {
            bizType = 5023;
        } else if (i3 == 86) {
            bizType = 5032;
        } else if (i3 == 112) {
            bizType = ErrorCode.BIDDING_C2S_NO_AD;
        } else if (i3 == 106) {
            bizType = ErrorCode.DOWNLOADED_NOT_INSTALL_APK;
        } else if (i3 == 107) {
            bizType = 5046;
        } else if (i3 == 108) {
            bizType = ErrorCode.SPLASH_PRELOAD_NOT_MATCH_NO_AD;
        } else if (i3 == 109) {
            bizType = 5048;
        } else if (i3 == 110) {
            bizType = 5049;
        } else if (i3 == 111) {
            bizType = 5050;
        } else if (i3 == 87) {
            bizType = 5030;
        } else if (i3 == 105) {
            bizType = this.q.getBizType();
        } else if (i3 == 90) {
            bizType = ErrorCode.NO_AD_FILL_FOR_MULTI;
        } else if (i3 == 88) {
            bizType = 5033;
        } else if (i3 == 89) {
            bizType = ErrorCode.BIDDING_C2S_TIMEOUT;
        } else if (i3 != 5 || (bizType = this.N) <= 0) {
            bizType = 64;
        }
        if (bizType == 64 && (i2 = this.I) != -1) {
            bizType = fu5.f(i2, 5000);
        }
        int i4 = bizType;
        if (TextUtils.isEmpty(this.q.getUid())) {
            sy5.e(this, R.string.user_detail_uid_invalid, 1).g();
            return;
        }
        if (bo0.r().l(this.q.getUid()) == null) {
            AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.c(this.q));
        }
        LogUtil.d("", "AIPuuutype2 bizType " + i4 + " mFrom " + this.A);
        ContactInfoItem contactInfoItemM792clone = this.q.m792clone();
        contactInfoItemM792clone.setBizType(i4);
        if (p05.c() && z2) {
            u93.b(500, new i(contactInfoItemM792clone));
        }
        if (vi5.b().e()) {
            SquareTempChatActivity.J1(this, contactInfoItemM792clone, i4, this.A0, this.B0, this.C0, this.R);
        } else {
            vi5.b().c(this, 100, new j(contactInfoItemM792clone, i4));
        }
        int i5 = this.A;
        if (68 == i5 || 66 == i5) {
            d3(i5);
        }
    }

    public void z2(String str) {
        showBaseProgressBar(getString(R.string.progress_sending), false);
        e eVar = new e();
        f fVar = new f(str);
        if (this.h0) {
            return;
        }
        o2 o2Var = new o2();
        this.n0 = o2Var;
        try {
            o2Var.n(str, this.J, this.j0.q(), eVar, fVar);
            this.mBaseProgressDialog.show();
            this.h0 = true;
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13522a;

        public f(String str) {
            this.f13522a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            UserDetailActivityV2.this.hideBaseProgressBar();
            UserDetailActivityV2.this.h0 = false;
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                UserDetailActivityV2.this.s0 = true;
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 1L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "rid=?", new String[]{this.f13522a});
                rn0.h(UserDetailActivityV2.this.q.getUid(), UserDetailActivityV2.this.K2());
                UserDetailActivityV2.this.m3();
                return;
            }
            if (iOptInt == 1327) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MediationConstant.KEY_ERROR_MSG);
                mj1.c(UserDetailActivityV2.this, jSONObjectOptJSONObject.optString("title"), jSONObjectOptJSONObject.optString("part"), jSONObjectOptJSONObject.optString("body"), jSONObjectOptJSONObject.optInt("time"));
                return;
            }
            if (iOptInt == 1306) {
                new sd3(UserDetailActivityV2.this).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new a()).e().show();
                return;
            }
            if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(UserDetailActivityV2.this, jSONObject);
            } else {
                if (iOptInt == 1330 && UserDetailActivityV2.this.q != null && UserDetailActivityV2.this.q.isCancellation()) {
                    return;
                }
                sy5.f(AppContext.getContext(), rx4.a(jSONObject), 0).g();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                UserDetailActivityV2 userDetailActivityV2 = UserDetailActivityV2.this;
                userDetailActivityV2.C2(true, userDetailActivityV2.H);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 extends MaterialDialog.e {
        public a0() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            UserDetailActivityV2 userDetailActivityV2 = UserDetailActivityV2.this;
            userDetailActivityV2.C2(true, userDetailActivityV2.H);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f13545a;
        public final /* synthetic */ TextView b;

        public x(EditText editText, TextView textView) {
            this.f13545a = editText;
            this.b = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int iD = dt2.d(this.f13545a, charSequence, 60);
            if (iD <= 60) {
                this.b.setText(((int) Math.floor(((double) (60 - iD)) * 0.5d)) + "");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f13546a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Response.ErrorListener {
            public a() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                UserDetailActivityV2.this.hideBaseProgressBar();
                sy5.e(UserDetailActivityV2.this, R.string.send_failed, 0).g();
                LogUtil.d(UserDetailActivityV2.O0, volleyError.toString());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.Listener<JSONObject> {
            public b() {
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
                int iOptInt = jSONObject.optInt("resultCode");
                UserDetailActivityV2.this.hideBaseProgressBar();
                if (iOptInt == 0) {
                    y yVar = y.this;
                    UserDetailActivityV2.this.R2(yVar.f13546a.getText().toString());
                } else if (iOptInt == 1318) {
                    sy5.e(UserDetailActivityV2.this, R.string.send_failed_refuse, 0).g();
                } else if (iOptInt == 7001) {
                    sy5.e(UserDetailActivityV2.this, R.string.send_failed_too_often, 0).g();
                } else {
                    sy5.e(UserDetailActivityV2.this, R.string.send_failed, 0).g();
                }
            }
        }

        public y(EditText editText) {
            this.f13546a = editText;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (TextUtils.isEmpty(this.f13546a.getText().toString())) {
                return;
            }
            if (UserDetailActivityV2.this.S2()) {
                UserDetailActivityV2.this.g3();
                return;
            }
            a aVar = new a();
            b bVar = new b();
            HashMap map = new HashMap();
            map.put("fuid", UserDetailActivityV2.this.q.getUid());
            map.put("rid", UserDetailActivityV2.this.E);
            map.put("sourceType", String.valueOf(UserDetailActivityV2.this.I));
            map.put("info", this.f13546a.getText().toString());
            UserDetailActivityV2.this.l0 = new bw4(bVar, aVar);
            try {
                UserDetailActivityV2.this.l0.n(map);
                UserDetailActivityV2 userDetailActivityV2 = UserDetailActivityV2.this;
                userDetailActivityV2.showBaseProgressBar(userDetailActivityV2.getString(R.string.progress_sending), false);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
        }
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements ro2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13531a;
        public final /* synthetic */ int b;

        public j(ContactInfoItem contactInfoItem, int i) {
            this.f13531a = contactInfoItem;
            this.b = i;
        }

        @Override // ro2.a
        public void onSuccess() {
            UserDetailActivityV2 userDetailActivityV2 = UserDetailActivityV2.this;
            SquareTempChatActivity.J1(userDetailActivityV2, this.f13531a, this.b, userDetailActivityV2.A0, UserDetailActivityV2.this.B0, UserDetailActivityV2.this.C0, UserDetailActivityV2.this.R);
        }

        @Override // ro2.a
        public void onCancel() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
