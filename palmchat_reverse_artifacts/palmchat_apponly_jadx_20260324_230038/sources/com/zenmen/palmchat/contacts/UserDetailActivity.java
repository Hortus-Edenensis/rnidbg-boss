package com.zenmen.palmchat.contacts;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
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
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.constants.ErrorCode;
import com.umeng.analytics.pro.bd;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.find.ConditionHelper;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.find.FindNearByMapActivity;
import com.zenmen.palmchat.activity.photoview.PhotoViewActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.SendMessageActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.chat.gift.GiftMessageHelper;
import com.zenmen.palmchat.chat.temporary.SquareTempChatActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.contacts.e;
import com.zenmen.palmchat.contacts.userdetail.UserProfileGuide;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.utils.ServerException;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.UI;
import defpackage.a65;
import defpackage.ad1;
import defpackage.az2;
import defpackage.b05;
import defpackage.bo0;
import defpackage.bq3;
import defpackage.bw4;
import defpackage.c70;
import defpackage.ch;
import defpackage.db1;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.dt2;
import defpackage.dv0;
import defpackage.e20;
import defpackage.f7;
import defpackage.fk2;
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
import defpackage.m66;
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
import defpackage.uk5;
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
public class UserDetailActivity extends BaseActionBarActivity implements pm2<Cursor>, e.p {
    public static final String G0 = "UserDetailActivity";
    public GroupInfoItem A;
    public String F;
    public long G;
    public long H;
    public ContactRequestsVO I;
    public Boolean M;
    public boolean N;
    public int O;
    public String P;
    public int R;
    public boolean T;
    public Toolbar U;
    public View V;
    public View W;
    public View X;
    public View Y;
    public View Z;
    public com.zenmen.palmchat.contacts.e h0;
    public bw4 j0;
    public q92 k0;
    public o2 l0;
    public bq3 m0;
    public i65 n0;
    public f7 o0;
    public ih p0;
    public ContactInfoItem q;
    public SquareFeed r;
    public String s0;
    public View t;
    public String u;
    public String v;
    public int w0;
    public int x0;
    public boolean y;
    public GroupInfoItem z;
    public boolean s = false;
    public String w = null;
    public String x = "";
    public int B = 0;
    public String C = "";
    public String E = "";
    public int J = -1;
    public int K = 0;
    public int L = 0;
    public String Q = "";
    public int S = 0;
    public boolean e0 = false;
    public boolean f0 = false;
    public int g0 = 0;
    public long i0 = 0;
    public boolean q0 = AppContext.getContext().getTrayPreferences().a(k86.n(), false);
    public j0 r0 = new j0(this);
    public int t0 = -1;
    public int u0 = -1;
    public boolean v0 = false;
    public int y0 = 0;
    public is0.e z0 = new c();
    public boolean A0 = false;
    public boolean B0 = false;
    public Response.ErrorListener C0 = new o();
    public Response.Listener<JSONObject> D0 = new p();
    public Response.ErrorListener E0 = new q();
    public Response.Listener<JSONObject> F0 = new r();

    /* JADX INFO: compiled from: SearchBox */
    public enum ClickMenuItem {
        REMARK,
        REPORT,
        SEND_NAME_CARD,
        BLACKLIST,
        DELETE_CONTACT,
        SPECIAL_ATTENTION
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
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
            w4.B(UserDetailActivity.this, 2, null, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserDetailActivity.this.F2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements is0.e {
        public c() {
        }

        @Override // is0.e
        public void a(int i, String str) {
            if (str.equals(ClickMenuItem.REMARK.name())) {
                UserDetailActivity.this.q3();
                return;
            }
            if (str.equals(ClickMenuItem.REPORT.name())) {
                UserDetailActivity.this.h3();
                return;
            }
            if (str.equals(ClickMenuItem.SEND_NAME_CARD.name())) {
                UserDetailActivity.this.k3();
                return;
            }
            if (str.equals(ClickMenuItem.BLACKLIST.name())) {
                UserDetailActivity.this.e3();
            } else if (str.equals(ClickMenuItem.DELETE_CONTACT.name())) {
                UserDetailActivity.this.H2();
            } else if (str.equals(ClickMenuItem.SPECIAL_ATTENTION.name())) {
                UserDetailActivity.this.i3();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c0 implements View.OnClickListener {
        public c0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = UserDetailActivity.this.Y.getVisibility() == 0;
            HashMap<String, Object> mapP = UserDetailActivity.this.h0.p();
            mapP.put(TtmlNode.TEXT_EMPHASIS_MARK_DOT, Integer.valueOf(z ? 2 : 1));
            zn6.j("pageprofil_top_edit", "click", mapP);
            if (z) {
                UserDetailActivity.this.Y.setVisibility(8);
                com.zenmen.palmchat.settings.b.c().a(2);
            }
            UserDetailActivity.this.startActivity(nn4.a(UserDetailActivity.this, 6));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            UserDetailActivity.this.I2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d0 extends HashMap<String, Object> {
        public d0() {
            put("isFriend", Integer.valueOf(UserDetailActivity.this.g0 == 2 ? 0 : 1));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends AsyncTask<Void, Void, Boolean> {
        public e() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                new va1(UserDetailActivity.this.q).n();
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
            UserDetailActivity.this.hideBaseProgressBar();
            if (!bool.booleanValue()) {
                sy5.f(AppContext.getContext(), UserDetailActivity.this.getText(R.string.send_failed), 1).g();
                return;
            }
            if (UserDetailActivity.this.B == 5) {
                UserDetailActivity.this.setResult(-1);
            }
            UserDetailActivity.this.finish();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            UserDetailActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e0 implements View.OnClickListener {
        public e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            oc3.b(UserDetailActivity.this, 9);
            if (UserDetailActivity.this.q != null) {
                oc3.a("click", UserDetailActivity.this.y0, UserDetailActivity.this.q.getUid(), UserDetailActivity.this.q.getGender(), UserDetailActivity.this.q.getAge());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivity.this.hideBaseProgressBar();
            UserDetailActivity.this.f0 = false;
            LogUtil.d(UserDetailActivity.G0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f0 implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GiftMessageHelper.S(UserDetailActivity.this.q);
            }
        }

        public f0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactInfoItem contactInfoItemL = bo0.r().l(UserDetailActivity.this.q.getUid());
            if (contactInfoItemL == null) {
                if (UserDetailActivity.this.B != 11 || UserDetailActivity.this.q == null) {
                    return;
                }
                UserDetailActivity.this.g0 = 2;
                UserDetailActivity.this.q.setFriendType(1);
                UserDetailActivity.this.h0.X(UserDetailActivity.this.q, UserDetailActivity.this.g0, false);
                return;
            }
            if (contactInfoItemL.getIsStranger()) {
                UserDetailActivity.this.q.setDescription(contactInfoItemL.getDescription());
                UserDetailActivity.this.q.setRemarkName(contactInfoItemL.getRemarkName());
                UserDetailActivity.this.q.setSessionConfig(contactInfoItemL.getSessionConfig());
                UserDetailActivity userDetailActivity = UserDetailActivity.this;
                userDetailActivity.r3(userDetailActivity.q);
            } else {
                contactInfoItemL.setIdentifyCode(UserDetailActivity.this.q.getIdentifyCode());
                contactInfoItemL.setOnline(UserDetailActivity.this.q.isOnline());
                contactInfoItemL.setDistance(UserDetailActivity.this.q.getDistance());
                contactInfoItemL.setCityName(UserDetailActivity.this.q.getCityName());
                contactInfoItemL.setOnlineStatusDesc(UserDetailActivity.this.q.getOnlineStatusDesc());
                contactInfoItemL.setLoveView(UserDetailActivity.this.q.getLoveView());
                contactInfoItemL.setCharmLevel(UserDetailActivity.this.q.getCharmLevel());
                contactInfoItemL.setRichLevel(UserDetailActivity.this.q.getRichLevel());
                UserDetailActivity.this.r3(contactInfoItemL);
            }
            if (UserDetailActivity.this.g0 == 2 && !contactInfoItemL.getIsStranger()) {
                UserDetailActivity.this.g0 = 1;
                UserDetailActivity.this.h0.G();
                if (p05.c()) {
                    UserDetailActivity userDetailActivity2 = UserDetailActivity.this;
                    if (userDetailActivity2.e0) {
                        userDetailActivity2.e0 = false;
                        u93.b(500, new a());
                        if (UserDetailActivity.this.q != null && !q05.o(UserDetailActivity.this.sInstance)) {
                            Intent intent = new Intent();
                            UserDetailActivity.this.l3(intent);
                            UserDetailActivity.this.startActivity(intent);
                        }
                    }
                }
            }
            UserDetailActivity.this.h0.X(UserDetailActivity.this.q, UserDetailActivity.this.g0, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g0 implements Runnable {
        public g0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserDetailActivity.this.y2(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.Listener<JSONObject> {
        public h() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            UserDetailActivity.this.hideBaseProgressBar();
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h0 implements Response.Listener<JSONObject> {
        public h0() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            boolean z;
            if (jSONObject != null) {
                LogUtil.json("loguser", jSONObject.toString(), "response: " + nl0.z + "/userem.getUserDetail.v4");
            }
            try {
                UserDetailActivity.this.hideBaseProgressBar();
                UserDetailActivity.this.h0.F(false);
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP == null || UserDetailActivity.this.g0 == 0) {
                    if (contactInfoItemP != null) {
                        UserDetailActivity.this.q.setLoveView(contactInfoItemP.getLoveView());
                        UserDetailActivity.this.q.setRichLevel(contactInfoItemP.getRichLevel());
                        UserDetailActivity.this.q.setCharmLevel(contactInfoItemP.getCharmLevel());
                        UserDetailActivity.this.q.setLikeCount(contactInfoItemP.getLikeCount());
                        UserDetailActivity.this.q.setFid(contactInfoItemP.getFid());
                    }
                    UserDetailActivity.this.h0.X(UserDetailActivity.this.q, UserDetailActivity.this.g0, false);
                } else {
                    if (ContactInfoItem.isUidAvailable(UserDetailActivity.this.q.getUid())) {
                        contactInfoItemP.setFriendType(UserDetailActivity.this.q.getFriendType());
                        z = false;
                    } else {
                        ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemP.getUid());
                        if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                            UserDetailActivity.this.g0 = 2;
                            contactInfoItemP.setFriendType(1);
                        } else {
                            if (contactInfoItemP.getUid() == null || !contactInfoItemP.getUid().equals(AccountUtils.p(UserDetailActivity.this))) {
                                UserDetailActivity.this.g0 = 1;
                            } else {
                                UserDetailActivity.this.g0 = 0;
                            }
                            contactInfoItemP.setFriendType(0);
                        }
                        z = true;
                    }
                    contactInfoItemP.setIdentifyCode(UserDetailActivity.this.q.getIdentifyCode());
                    if (24 != UserDetailActivity.this.B) {
                        UserDetailActivity.this.u3(contactInfoItemP);
                    }
                    UserDetailActivity.this.r3(contactInfoItemP);
                    UserDetailActivity.this.N2();
                    ContactInfoItem contactInfoItemL2 = bo0.r().l(UserDetailActivity.this.q.getUid());
                    if (contactInfoItemL2 != null) {
                        if (contactInfoItemL2.getIsStranger()) {
                            UserDetailActivity.this.q.setRemarkName(contactInfoItemL2.getRemarkName());
                            UserDetailActivity.this.q.setDescription(contactInfoItemL2.getDescription());
                            UserDetailActivity.this.getContentResolver().insert(ho0.f18003a, nn0.a(UserDetailActivity.this.q));
                        } else {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("account_type", Integer.valueOf(UserDetailActivity.this.q.getAccountType()));
                            contentValues.put("age", UserDetailActivity.this.q.getAge());
                            contentValues.put(com.umeng.ccg.a.A, UserDetailActivity.this.q.getSignature());
                            contentValues.put("data5", contactInfoItemP.getExt() == null ? "" : az2.c(contactInfoItemP.getExt()));
                            UserDetailActivity.this.getContentResolver().update(ho0.f18003a, contentValues, "uid=?", new String[]{UserDetailActivity.this.q.getUid()});
                        }
                    }
                    if (z && contactInfoItemL2 != null) {
                        UserDetailActivity.this.q.setSessionConfig(contactInfoItemL2.getSessionConfig());
                        UserDetailActivity.this.q.setRemarkName(contactInfoItemL2.getRemarkName());
                        UserDetailActivity.this.q.setDescription(contactInfoItemL2.getDescription());
                    }
                    UserDetailActivity.this.t3();
                    UserDetailActivity.this.h0.X(UserDetailActivity.this.q, UserDetailActivity.this.g0, false);
                    if (UserDetailActivity.this.B == 6) {
                        ie2.b(UserDetailActivity.this.q);
                    } else if (UserDetailActivity.this.B == 11) {
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
                    UserDetailActivity.this.q.setUserLabelImg(contactInfoItemP.getUserLabelImg());
                }
                UserDetailActivity.this.h0.y();
                UserDetailActivity.this.h0.S();
                UserDetailActivity.this.h0.Y(UserDetailActivity.this.q.getUserLabelImg());
                LogUtil.onClickEvent("1311", "1", null);
                if (contactInfoItemP != null) {
                    UserDetailActivity.this.q.setFeedSeparation(contactInfoItemP.getFeedSeparation());
                }
                UserDetailActivity.this.O2();
            } catch (JSONException e2) {
                e2.printStackTrace();
                LogUtil.onClickEvent("1311", "2", null);
            }
            if ((UserDetailActivity.this.N || UserDetailActivity.this.M.booleanValue()) && !UserDetailActivity.this.isFinishing()) {
                UserDetailActivity.this.b();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.ErrorListener {
        public i() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivity.this.hideBaseProgressBar();
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i0 implements Response.ErrorListener {
        public i0() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivity.this.hideBaseProgressBar();
            UserDetailActivity.this.h0.F(true);
            UserDetailActivity.this.h0.X(UserDetailActivity.this.q, UserDetailActivity.this.g0, false);
            LogUtil.onClickEvent("1311", "2", null);
            UserDetailActivity.this.h0.x();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13493a;

        public j(ContactInfoItem contactInfoItem) {
            this.f13493a = contactInfoItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q05.o(UserDetailActivity.this.sInstance)) {
                return;
            }
            GiftMessageHelper.T(this.f13493a, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j0 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<UserDetailActivity> f13494a;

        public j0(UserDetailActivity userDetailActivity) {
            this.f13494a = new WeakReference<>(userDetailActivity);
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
            zn6.j("pageprofil_top_vediobutton", "click", UserDetailActivity.this.h0.p());
            UserDetailActivity.this.X2(view.getContext(), "info_footprint");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k0 implements fk2 {
        @Override // defpackage.fk2
        public Intent a(Context context, fk2.a aVar) {
            ContactInfoItem contactInfoItemA;
            PhoneContactItem phoneContactItem;
            Intent intent = new Intent();
            intent.setClass(context, m66.c());
            if (aVar != null) {
                Bundle bundleA = aVar.a();
                String string = bundleA.getString(DeviceInfoUtil.UID_TAG);
                int i = bundleA.getInt("from", -1);
                String string2 = bundleA.getString("json_data");
                ContactInfoItem contactInfoItem = (ContactInfoItem) bundleA.getParcelable("user_item_info");
                SquareFeed squareFeed = (SquareFeed) bundleA.getParcelable("square_feed");
                String string3 = bundleA.getString("group_id");
                int i2 = bundleA.getInt(EventParams.KEY_CT_SDK_POSITION, -1);
                int i3 = bundleA.getInt("click_area", -1);
                if (i == 6 || i == 41 || i == 42) {
                    try {
                        JSONObject jSONObject = new JSONObject(string2);
                        ContactInfoItem contactInfoItem2 = new ContactInfoItem();
                        try {
                            contactInfoItem2.setUid(jSONObject.optString(DeviceInfoUtil.UID_TAG));
                            contactInfoItem2.setExid(jSONObject.optString(bd.h));
                            contactInfoItem2.setNickName(jSONObject.optString("nickname"));
                            contactInfoItem2.setIconURL(jSONObject.optString("headIconUrl"));
                            contactInfoItem2.setBigIconURL(jSONObject.optString("headImgUrl"));
                            contactInfoItem2.setSignature(jSONObject.optString(com.umeng.ccg.a.A));
                            contactInfoItem2.setGender(jSONObject.optInt("sex"));
                            contactInfoItem2.setCountry(jSONObject.optString("country"));
                            contactInfoItem2.setProvince(jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
                            contactInfoItem2.setCity(jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY));
                            contactInfoItem2.setSourceType(jSONObject.optInt("sourceType"));
                            contactInfoItemA = contactInfoItem2;
                        } catch (JSONException e) {
                            e = e;
                            contactInfoItemA = contactInfoItem2;
                            e.printStackTrace();
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        contactInfoItemA = contactInfoItem;
                    }
                } else if (i == 30) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(string2);
                        ContactInfoItem contactInfoItem3 = new ContactInfoItem();
                        try {
                            contactInfoItem3.setUid(jSONObject2.optString(DeviceInfoUtil.UID_TAG));
                            contactInfoItem3.setNickName(jSONObject2.optString("nickname"));
                            contactInfoItem3.setIconURL(jSONObject2.optString("headIconUrl"));
                            contactInfoItem3.setBigIconURL(jSONObject2.optString("headImgUrl"));
                            contactInfoItem3.setSignature(jSONObject2.optString(com.umeng.ccg.a.A));
                            contactInfoItem3.setGender(jSONObject2.optInt("sex"));
                            contactInfoItem3.setCountry(jSONObject2.optString("country"));
                            contactInfoItem3.setProvince(jSONObject2.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
                            contactInfoItem3.setCity(jSONObject2.optString(DistrictSearchQuery.KEYWORDS_CITY));
                            contactInfoItem3.setIdentifyCode(jSONObject2.optString("md5Phone"));
                            contactInfoItem3.setSourceType(jSONObject2.optInt("sourceType"));
                            if (!TextUtils.isEmpty(contactInfoItem3.getIdentifyCode()) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(contactInfoItem3.getIdentifyCode())) != null) {
                                intent.putExtra("user_detail_local_phone_number", phoneContactItem.y());
                            }
                            intent.putExtra("user_real_name", jSONObject2.optInt("realName"));
                            contactInfoItemA = contactInfoItem3;
                        } catch (JSONException e3) {
                            e = e3;
                            contactInfoItemA = contactInfoItem3;
                            e.printStackTrace();
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        contactInfoItemA = contactInfoItem;
                    }
                    intent.putExtra("extra_request_type", 95);
                    intent.putExtra("subtype_key", 95);
                    if (jo6.r()) {
                        intent.putExtra("new_request_send_page", true);
                        intent.putExtra("send_from_type", 12);
                    }
                } else {
                    contactInfoItemA = contactInfoItem;
                }
                if (contactInfoItemA == null) {
                    contactInfoItemA = dn0.a(string);
                }
                if (contactInfoItemA != null) {
                    intent.putExtra("user_item_info", contactInfoItemA);
                    intent.putExtra("group_id", string3);
                    if (i < 0) {
                        intent.putExtra("from", 20);
                    } else {
                        intent.putExtra("from", i);
                    }
                }
                if (squareFeed != null) {
                    intent.putExtra("square_feed", squareFeed);
                }
                intent.putExtra(EventParams.KEY_CT_SDK_POSITION, i2);
                intent.putExtra("click_area", i3);
            }
            return intent;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserDetailActivity.this.A0 = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n extends MaterialDialog.e {
        public n() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            UserDetailActivity.this.B0 = true;
            UserDetailActivity userDetailActivity = UserDetailActivity.this;
            userDetailActivity.G2(userDetailActivity.q.getChatId(), jw5.b(UserDetailActivity.this.q.getSessionConfig(), 8));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Response.ErrorListener {
        public o() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(UserDetailActivity.G0, volleyError.toString());
            UserDetailActivity.this.hideBaseProgressBar();
            UserDetailActivity.this.n3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Response.Listener<JSONObject> {
        public p() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(UserDetailActivity.G0, jSONObject.toString());
            int iOptInt = jSONObject.optInt("resultCode");
            UserDetailActivity.this.hideBaseProgressBar();
            if (iOptInt != 0) {
                if (iOptInt == 1320) {
                    rx4.b(UserDetailActivity.this, jSONObject);
                    return;
                } else {
                    UserDetailActivity.this.n3();
                    return;
                }
            }
            if (UserDetailActivity.this.B0) {
                UserDetailActivity.this.B0 = false;
                if (zg5.j(UserDetailActivity.this.q.getChatId())) {
                    xg5.e().m();
                }
            }
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements Response.ErrorListener {
        public q() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(UserDetailActivity.G0, volleyError.toString());
            UserDetailActivity.this.hideBaseProgressBar();
            sy5.e(AppContext.getContext(), R.string.sv_settings_fail, 0).g();
            UserDetailActivity.this.h0.X(UserDetailActivity.this.q, UserDetailActivity.this.g0, false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Response.Listener<JSONObject> {
        public r() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(UserDetailActivity.G0, jSONObject.toString());
            UserDetailActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") == 0) {
                iq5.j(false, new String[0]);
            } else {
                sy5.e(AppContext.getContext(), R.string.sv_settings_fail, 0).g();
                UserDetailActivity.this.h0.X(UserDetailActivity.this.q, UserDetailActivity.this.g0, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f13504a;

        public t(uk5 uk5Var) {
            this.f13504a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk5 uk5Var = this.f13504a;
            if (uk5Var.f21235a != 22) {
                return;
            }
            String str = uk5Var.d;
            if (UserDetailActivity.this.g0 == 0 && ad1.j(ad1.o, str)) {
                LogUtil.i("TYPE_DIALOG_PROCESS_MSG_RECEIVED", "onStatusChanged pageIndex = " + str);
                ad1.h().m(ad1.o, UserDetailActivity.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Response.ErrorListener {
        public u() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivity.this.hideBaseProgressBar();
            sy5.e(UserDetailActivity.this, R.string.send_failed, 0).g();
            LogUtil.d(UserDetailActivity.G0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.j("pageprofil_top_setting", "click", UserDetailActivity.this.h0.p());
            UserDetailActivity.this.o3();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13507a;
        public final /* synthetic */ ContactRequestsVO b;

        public w(boolean z, ContactRequestsVO contactRequestsVO) {
            this.f13507a = z;
            this.b = contactRequestsVO;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            UserDetailActivity.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                UserDetailActivity.this.e0 = true;
                iq5.j(false, new String[0]);
                return;
            }
            if (iOptInt != 1) {
                if (iOptInt == 1318) {
                    sy5.e(UserDetailActivity.this, R.string.send_refuse, 1).g();
                    return;
                }
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(UserDetailActivity.this, jSONObject);
                    return;
                } else {
                    if (iOptInt == 1330 && UserDetailActivity.this.q != null && UserDetailActivity.this.q.isCancellation()) {
                        return;
                    }
                    sy5.f(UserDetailActivity.this, rx4.a(jSONObject), 0).g();
                    return;
                }
            }
            if (UserDetailActivity.this.N || UserDetailActivity.this.L == 92 || UserDetailActivity.this.L == 95) {
                UserDetailActivity.this.E2(this.f13507a, this.b);
                UserDetailActivity.this.N = false;
                return;
            }
            Intent intent = new Intent(UserDetailActivity.this, (Class<?>) NewContactRequestSendActivity.class);
            intent.putExtra("user_item_info", UserDetailActivity.this.q);
            intent.putExtra("uid_key", UserDetailActivity.this.q.getUid());
            intent.putExtra("new_contact_source_type", UserDetailActivity.this.J);
            intent.putExtra("new_contact_is_reverse", this.f13507a);
            intent.putExtra("new_contact_contactrequst_info", UserDetailActivity.this.I);
            intent.putExtra("new_contact_local_phone_number", UserDetailActivity.this.u);
            intent.putExtra("subtype_key", UserDetailActivity.this.L);
            intent.putExtra("groupid", UserDetailActivity.this.E);
            intent.putExtra("from_user_detail", true);
            intent.putExtra("extra_request_from", UserDetailActivity.this.getIntent().getIntExtra("extra_request_from", 0));
            intent.putExtra("extra_request_type", UserDetailActivity.this.getIntent().getIntExtra("extra_request_type", 0));
            if (UserDetailActivity.this.B == 6) {
                intent.putExtra("groupchat_name", UserDetailActivity.this.x);
            }
            if (this.f13507a) {
                UserDetailActivity.this.startActivityForResult(intent, 101);
            } else {
                UserDetailActivity.this.startActivity(intent);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements Response.ErrorListener {
        public x() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            UserDetailActivity.this.hideBaseProgressBar();
            sy5.e(UserDetailActivity.this, R.string.send_failed, 0).g();
            LogUtil.d(UserDetailActivity.G0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13509a;

        public y(boolean z) {
            this.f13509a = z;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            UserDetailActivity.this.hideBaseProgressBar();
            if (iOptInt != 0 && iOptInt != 1) {
                if (iOptInt == 1320 || iOptInt == 1321) {
                    rx4.b(UserDetailActivity.this, jSONObject);
                    return;
                }
                return;
            }
            if (this.f13509a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 2L);
                contentValues.put("request_type", (Integer) 0);
                contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + UserDetailActivity.this.q.getUid());
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{UserDetailActivity.this.q.getUid()});
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("accept_status", (Long) 2L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{UserDetailActivity.this.q.getUid()});
            }
            UserDetailActivity.this.h0.E();
        }
    }

    public static void U2(Activity activity, int i2, String str, String str2, ContactInfoItem contactInfoItem, int i3, long j2, long j3, String str3, int i4) {
        PhoneContactItem phoneContactItem;
        rn0.r(contactInfoItem.getUid());
        int i5 = i2 < 100 ? 7 : (i2 < 100 || i2 >= 200) ? i2 == 220 ? 19 : 18 : 8;
        Intent intent = new Intent(activity, (Class<?>) m66.c());
        intent.putExtra("user_item_info", contactInfoItem);
        intent.putExtra("from", i5);
        intent.putExtra("rid", str2);
        intent.putExtra("extra_request_from", i3);
        intent.putExtra("extra_request_type", contactInfoItem.getRequestType());
        intent.putExtra("apply_time", j2);
        intent.putExtra("apply_expire_sec", j3);
        if (!TextUtils.isEmpty(str) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str)) != null) {
            intent.putExtra("user_detail_local_phone_number", phoneContactItem.y());
        }
        intent.putExtra("user_real_name", str3);
        intent.putExtra("subtype_key", i4);
        activity.startActivity(intent);
    }

    public static void V2(Activity activity, int i2, String str, String str2, ContactInfoItem contactInfoItem, int i3, String str3, boolean z2) {
        PhoneContactItem phoneContactItem;
        rn0.r(contactInfoItem.getUid());
        if (activity == null) {
            return;
        }
        int i4 = i2 < 100 ? 7 : (i2 < 100 || i2 >= 200) ? i2 == 220 ? 19 : 18 : 8;
        Intent intent = new Intent(activity, (Class<?>) m66.c());
        intent.putExtra("user_item_info", contactInfoItem);
        intent.putExtra("from", i4);
        intent.putExtra("rid", str2);
        intent.putExtra("extra_request_from", i3);
        intent.putExtra("extra_request_type", contactInfoItem.getRequestType());
        intent.putExtra("log_from", z2);
        if (!TextUtils.isEmpty(str) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str)) != null) {
            intent.putExtra("user_detail_local_phone_number", phoneContactItem.y());
        }
        intent.putExtra("user_real_name", str3);
        activity.startActivity(intent);
    }

    public static void W2(Activity activity, int i2, String str, String str2, ContactInfoItem contactInfoItem, int i3, long j2, long j3, String str3, int i4, int i5) {
        PhoneContactItem phoneContactItem;
        rn0.r(contactInfoItem.getUid());
        int i6 = i2 < 100 ? 7 : (i2 < 100 || i2 >= 200) ? i2 == 220 ? 19 : 18 : 8;
        Intent intent = new Intent(activity, (Class<?>) m66.c());
        intent.putExtra("user_item_info", contactInfoItem);
        intent.putExtra("from", i6);
        intent.putExtra("rid", str2);
        intent.putExtra("extra_request_from", i3);
        intent.putExtra("extra_request_type", contactInfoItem.getRequestType());
        intent.putExtra("apply_time", j2);
        intent.putExtra("apply_expire_sec", j3);
        if (!TextUtils.isEmpty(str) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str)) != null) {
            intent.putExtra("user_detail_local_phone_number", phoneContactItem.y());
        }
        intent.putExtra("user_real_name", str3);
        intent.putExtra("subtype_key", i4);
        intent.putExtra("new_request_send_page", true);
        intent.putExtra("send_from_type", i5);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y2(int i2, ContactInfoItem contactInfoItem) {
        if (contactInfoItem != null) {
            this.h0.i(i2, contactInfoItem.getRoleType());
        }
    }

    public static /* synthetic */ Object Z2() {
        return " 跳转到临时聊天界面";
    }

    public static boolean b3(int i2) {
        return 33 == i2 || 40 == i2 || 34 == i2 || 75 == i2 || 41 == i2 || 42 == i2 || 37 == i2 || 38 == i2 || 45 == i2 || 46 == i2 || 48 == i2 || 50 == i2 || 66 == i2 || 68 == i2 || 79 == i2 || 80 == i2 || 85 == i2 || (11 == i2 && jo6.F()) || 73 == i2 || 87 == i2 || 90 == i2 || 74 == i2 || 80 == i2 || 85 == i2 || 112 == i2 || 105 == i2 || 106 == i2 || 107 == i2 || 108 == i2 || 109 == i2 || 110 == i2 || 111 == i2 || 89 == i2 || 88 == i2;
    }

    public static void p3(Context context, int i2, ContactInfoItem contactInfoItem, boolean z2) {
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
        LogUtil.d("ClearAd", "clearCacheAd UserDetailActivity onDestroy");
        db1.c();
    }

    public final void B2() {
        if (this.T) {
            Intent intent = new Intent(this, (Class<?>) RecommendRequestSendActivity.class);
            intent.putExtra("uid_key", this.q.getUid());
            intent.putExtra("user_item_info_key", this.q);
            intent.putExtra("source_type_key", this.J);
            intent.putExtra("subtype_key", this.L);
            intent.putExtra("real_name", this.Q);
            intent.putExtra("send_from_type", this.R);
            intent.putExtra("is_reverse", false);
            intent.putExtra("new_contact_local_phone_number", this.u);
            intent.putExtra("extra_request_from", getIntent().getIntExtra("extra_request_from", 0));
            intent.putExtra("extra_request_type", getIntent().getIntExtra("extra_request_type", 0));
            if (this.B == 6) {
                intent.putExtra("groupchat_name", this.x);
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
        intent2.putExtra("new_contact_source_type", this.J);
        intent2.putExtra("new_contact_is_reverse", false);
        intent2.putExtra("new_contact_local_phone_number", this.u);
        intent2.putExtra("subtype_key", this.L);
        intent2.putExtra("send_from_type", this.R);
        intent2.putExtra("groupid", this.E);
        intent2.putExtra("extra_request_from", getIntent().getIntExtra("extra_request_from", 0));
        intent2.putExtra("extra_request_type", getIntent().getIntExtra("extra_request_type", 0));
        if (this.B == 6) {
            intent2.putExtra("groupchat_name", this.x);
        }
        startActivity(intent2);
    }

    public final void C2(boolean z2, ContactRequestsVO contactRequestsVO) {
        u uVar = new u();
        w wVar = new w(z2, contactRequestsVO);
        if (this.q.getUid() == null) {
            return;
        }
        ContactRequestArgs.Builder builderG = new ContactRequestArgs.Builder().h(z2).b(contactRequestsVO).e(ContactRequestArgs.c(this.q)).i(String.valueOf(this.J)).j(String.valueOf(this.L)).g(this.h0.n());
        if (this.J == 2) {
            builderG.c(ContactRequestArgs.a(this.E));
        }
        LogUtil.i(G0, "addfriend sourceType: " + this.J);
        f7 f7Var = new f7(wVar, uVar);
        this.o0 = f7Var;
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
        x xVar = new x();
        y yVar = new y(z2);
        ContactRequestArgs.Builder builderG = new ContactRequestArgs.Builder().h(z2).b(contactRequestsVO).e(ContactRequestArgs.c(this.q)).i(String.valueOf(this.J)).j(String.valueOf(this.L)).g(this.h0.n());
        if (this.J == 2) {
            builderG.c(ContactRequestArgs.a(this.E));
        }
        ContactRequestArgs contactRequestArgsA = builderG.a();
        this.p0 = new ih(yVar, xVar);
        showBaseProgressBar(getString(R.string.progress_sending), false);
        try {
            this.p0.r(contactRequestArgsA);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void F2() {
        zn6.j("pageprofil_top_retonbutton", "click", this.h0.p());
        if (!this.needBack2MainTab && this.g0 != 0) {
            UserProfileGuide.k(this, 16);
        }
        finish();
    }

    public final void G2(String str, int i2) {
        i65 i65Var = new i65(this.D0, this.C0);
        this.n0 = i65Var;
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
        new sd3(this).T(R.string.string_delete_contact).k(TextUtils.isEmpty(this.q.getNickName()) ? String.format(string, this.q.getUid()) : String.format(string, this.q.getNickName())).N(R.color.material_dialog_button_text_color_red).O(R.string.string_delete).K(R.string.dialog_cancel).f(new d()).e().show();
    }

    public final void I2() {
        new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void J2() {
        Pair<Integer, Integer> pairL = fu5.l(this.q.getBizType());
        if (pairL != null) {
            if (this.L == 0) {
                this.L = ((Integer) pairL.second).intValue();
            }
            if (this.B == 5) {
                this.J = ((Integer) pairL.first).intValue();
                this.L = ((Integer) pairL.second).intValue();
            }
        }
        LogUtil.i("logaddfriend", "obtainDataFromIntent mThreadBizType=" + this.O + "mFrom=" + this.B + "mContactInfoItem.getBizType()=" + this.q.getBizType() + "mContactInfoItem.getSourceType()=" + this.q.getSourceType() + "sourceType=" + this.J + "mSubtype=" + this.L + " from=" + this.B);
    }

    public int K2() {
        int i2 = this.B;
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
        if (i2 == 18 || i2 == 7 || (i2 == 36 && !TextUtils.isEmpty(this.F))) {
            return L2();
        }
        int i3 = this.B;
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
            int i5 = this.O;
            if (i5 == 14) {
                i4 = 14;
            } else if (i5 == 17) {
                i4 = 28;
            } else if (i5 == 22) {
                i4 = 200;
            }
            return fu5.t(i5) ? fu5.n(this.O) : i4;
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

    public void M2(boolean z2) {
        int i2 = this.B;
        if (i2 != 7 && i2 == 36) {
            TextUtils.isEmpty(this.F);
        }
        this.k0 = new q92(new h0(), new i0());
        if (!z2) {
            try {
                this.mBaseProgressDialog.show();
            } catch (DaoException e2) {
                e2.printStackTrace();
                LogUtil.onClickEvent("1311", "2", null);
                return;
            }
        }
        this.k0.n(this.q.getUid(), this.q.getExid());
    }

    public final void N2() {
        if (this.t == null) {
            View viewFindViewById = findViewById(R.id.iv_authen_icon);
            this.t = viewFindViewById;
            viewFindViewById.setOnClickListener(new a());
        }
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem == null || contactInfoItem.getExt() == null || this.q.getExt().getPrcRealName() != 1 || this.q.isCancellation()) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        LogUtil.d("AccountPrAuthenManager", "AccountPrAuthenManager initAuthenView TAG_TYPE_FEED_SEPARATION mFrom " + this.B);
    }

    public final void O2() {
        View viewFindViewById = findViewById(R.id.iv_map_separation_bg);
        this.Z = viewFindViewById;
        viewFindViewById.setOnClickListener(new e0());
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem == null || contactInfoItem.getFeedSeparation() != NearByBean.TAG_TYPE_FEED_SEPARATION) {
            return;
        }
        oc3.a("view", this.y0, this.q.getUid(), this.q.getGender(), this.q.getAge());
        this.Z.setVisibility(0);
        LogUtil.d("MapSeparationManager", "UserDetailActivity2 initSeparationBgView TAG_TYPE_FEED_SEPARATION mFrom " + this.B);
    }

    public final void P2() {
        Toolbar toolbarInitToolbar = initToolbar("", false);
        this.U = toolbarInitToolbar;
        toolbarInitToolbar.setBackgroundResource(R.color.color_trans);
        Toolbar toolbar = this.U;
        toolbar.setPadding(0, toolbar.getPaddingTop(), 0, 0);
        View viewFindViewById = findViewById(R.id.toolbar2);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.height = this.U.getLayoutParams().height;
        viewFindViewById.setLayoutParams(layoutParams);
        setSupportActionBar(this.U);
        findViewById(R.id.back).setOnClickListener(new b());
    }

    public final void Q2() {
        String uid = this.q.getUid();
        if (TextUtils.isEmpty(uid)) {
            uid = bo0.r().u(this.q.getExid());
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(uid);
        if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
            this.g0 = 2;
            this.q.setFriendType(1);
        } else {
            r3(contactInfoItemL);
            this.y0 = 1;
            if (this.q.getUid() == null || !this.q.getUid().equals(AccountUtils.p(this))) {
                this.g0 = 1;
            } else {
                this.g0 = 0;
            }
        }
        this.X = findViewById(R.id.menu_edit_profile);
        this.Y = findViewById(R.id.dot_edit_profile);
        this.V = findViewById(R.id.menu_smallvideo);
        this.W = findViewById(R.id.menu_more);
        this.V.setVisibility(8);
        this.V.setOnClickListener(new k());
        this.W.setOnClickListener(new v());
        this.X.setOnClickListener(new c0());
        t3();
        GroupInfoItem groupInfoItem = this.A;
        int addFriendSwitch = groupInfoItem != null ? groupInfoItem.getAddFriendSwitch() : 1;
        this.h0 = new com.zenmen.palmchat.contacts.e(this, this.B, this.Q, this.w, this.u, this.J, this.F, this.v, this.P, this, this.r0, this.g0 == 0, addFriendSwitch, this.r, this.S);
        this.mBaseProgressDialog = new wn4(this);
        this.h0.X(this.q, this.g0, true);
        final int roleType = this.q.getRoleType();
        this.h0.i(roleType, 0);
        if (!TextUtils.isEmpty(this.E)) {
            c70.R().N(this.E, v4.e(this), new dv0() { // from class: g66
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f17672a.Y2(roleType, (ContactInfoItem) obj);
                }
            });
        }
        M2(true);
        updateCurrentPageInfo(this, new d0());
        if (this.M.booleanValue()) {
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
        contentValues.put("rid", this.F);
        contentValues.put("applyTime", Long.valueOf(this.G));
        contentValues.put("applyExpireSec", Long.valueOf(this.H));
        contentValues.put("request_type", (Integer) 2);
        contentValues.put("read_status", (Long) 1L);
        contentValues.put("readTime", Long.valueOf(ir5.b()));
        contentValues.put("accept_status", (Long) 0L);
        contentValues.put("source_type", Integer.valueOf(this.J));
        contentValues.put("identify_code", this.q.getIdentifyCode());
        rn0.j(contentValues);
    }

    public final boolean S2() {
        return !ContactRequestsVO.isSenderParseFromRid(this.F) && this.G > 0 && System.currentTimeMillis() > this.G + (this.H * 1000);
    }

    public final boolean T2() {
        return jw5.e(this.q.getSessionConfig());
    }

    public boolean a3(int i2) {
        return b3(i2) || this.s;
    }

    @Override // com.zenmen.palmchat.contacts.e.p
    public void b() {
        ContactInfoItem contactInfoItem;
        if (this.g0 != 2) {
            Intent intent = new Intent();
            if (this.B == 11 && this.g0 == 0) {
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
                    if (e20.a() && this.v0) {
                        finish();
                        return;
                    }
                    l3(intent);
                }
            }
            startActivity(intent);
            return;
        }
        int i2 = this.B;
        if ((i2 == 7 || i2 == 36) && !TextUtils.isEmpty(this.F) && !ContactRequestsVO.isSenderParseFromRid(this.F)) {
            z2(this.F);
            return;
        }
        if (this.B == 11 && !jo6.F()) {
            p3(this, this.B, this.q, false);
            return;
        }
        if (a3(this.B)) {
            y2(false);
            return;
        }
        if (this.B != 5 || (contactInfoItem = this.q) == null || !fu5.t(contactInfoItem.getBizType()) || !ContactInfoItem.isUidAvailable(this.q.getUid()) || !tn0.i().v(this.q.getUid(), true)) {
            B2();
            LogUtil.onClickEvent("13111", null, null);
            return;
        }
        z2(this.q.getUid() + "_" + AccountUtils.p(AppContext.getContext()));
    }

    @Override // com.zenmen.palmchat.contacts.e.p
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

    public boolean c3() {
        if (!this.q.getIsStranger() || jw5.e(this.q.getSessionConfig())) {
            return true;
        }
        int i2 = this.B;
        if (i2 != 9 && i2 != 4 && i2 != 1 && i2 != 13 && i2 != 19) {
            if (i2 == 11) {
                if (nw5.h(this.q.getUid())) {
                    return true;
                }
            } else {
                if (i2 != 7 && (i2 != 36 || TextUtils.isEmpty(this.F))) {
                    return true;
                }
                if ((!TextUtils.isEmpty(this.F) && !ContactRequestsVO.isSenderParseFromRid(this.F)) || nw5.h(this.q.getUid())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void d3() {
        Intent intent = getIntent();
        this.B = intent.getIntExtra("from", 0);
        this.t0 = intent.getIntExtra(EventParams.KEY_CT_SDK_POSITION, -1);
        this.u0 = intent.getIntExtra("click_area", -1);
        int i2 = 1;
        this.y = intent.getBooleanExtra("log_from", true);
        this.C = intent.getStringExtra("room_id");
        ik4.d(intent.getBooleanExtra("extra_auto_polish", false));
        this.E = intent.getStringExtra("group_id");
        this.v0 = intent.getBooleanExtra("back_to_chat", false);
        this.F = intent.getStringExtra("rid");
        this.K = intent.getIntExtra("agree_subtype", 0);
        this.L = intent.getIntExtra("subtype_key", 0);
        this.G = intent.getLongExtra("apply_time", 0L);
        this.H = intent.getLongExtra("apply_expire_sec", 0L);
        this.u = intent.getStringExtra("user_detail_local_phone_number");
        this.v = intent.getStringExtra("user_detail_name_card_sender_name");
        this.M = Boolean.valueOf(intent.getBooleanExtra("isAccept", false));
        this.N = intent.getBooleanExtra("autoAdd", false);
        this.Q = intent.getStringExtra("user_real_name");
        this.S = intent.getIntExtra("superExposeMsgTabItem", 0);
        this.q = (ContactInfoItem) intent.getParcelableExtra("user_item_info");
        this.s = intent.getBooleanExtra("extra_can_chat", false);
        SquareFeed squareFeed = (SquareFeed) intent.getParcelableExtra("square_feed");
        this.r = squareFeed;
        if (squareFeed != null) {
            this.s0 = squareFeed.imprId;
        }
        this.z = (GroupInfoItem) intent.getParcelableExtra("pot_user_item_info");
        this.A = (GroupInfoItem) intent.getParcelableExtra("group_chat_info");
        this.R = intent.getIntExtra("send_from_type", 0);
        this.T = intent.getBooleanExtra("new_request_send_page", false);
        this.w0 = intent.getIntExtra("enter_anim", 0);
        this.x0 = intent.getIntExtra("out_anim", 0);
        if (this.q == null) {
            finish();
            return;
        }
        this.O = intent.getIntExtra("thread_biz_type", 0);
        this.w = this.q.getGroupRemarkName();
        this.J = this.q.getSourceType();
        this.P = intent.getStringExtra("distance");
        if (this.B == 6) {
            this.x = intent.getStringExtra("groupchat_name");
        }
        if (this.J == -1) {
            this.J = K2();
        }
        if (this.J == 44) {
            int i3 = this.B;
            if (i3 == 41 || i3 == 42 || this.O == 67 || this.q.getBizType() == 67) {
                this.L = 3;
            } else {
                int i4 = this.B;
                if (i4 == 37 || i4 == 38) {
                    this.L = 4;
                } else {
                    this.L = 1;
                }
            }
        }
        if (this.J == 46) {
            if (this.B == 34 || this.O == 65 || this.q.getBizType() == 65) {
                this.L = 2;
            } else if (this.B == 75) {
                this.L = 3;
            } else {
                this.L = 1;
            }
        }
        int i5 = this.B;
        if (i5 == 61 || i5 == 62 || i5 == 63 || i5 == 65) {
            this.L = 1;
        } else if (i5 == 69) {
            this.L = 4;
        } else if (i5 == 67) {
            this.L = 3;
        } else if (i5 == 66) {
            this.L = 2;
        } else if (i5 == 68) {
            this.L = 6;
        }
        J2();
        if (intent.getBooleanExtra("launch_from_notification", false)) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!this.M.booleanValue()) {
                    i2 = 2;
                }
                jSONObject.put("type", i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("rep1", null, null, jSONObject.toString());
        }
    }

    @Override // com.zenmen.palmchat.contacts.e.p
    public void e() {
        B2();
    }

    public void e3() {
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null) {
            jw5.j(contactInfoItem.getSessionConfig());
            jw5.g(this.q.getSessionConfig());
            if (jw5.e(this.q.getSessionConfig())) {
                G2(this.q.getChatId(), jw5.a(this.q.getSessionConfig(), 8));
            } else {
                new sd3(this).T(R.string.add_to_blacklist).j(R.string.blacklist_dialog_content).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new n()).e().show();
            }
        }
    }

    @Override // com.zenmen.palmchat.contacts.e.p
    public void f() {
        if (S2()) {
            m3();
            return;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog_add_friend_content, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.count);
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_text);
        viewInflate.findViewById(R.id.content).setVisibility(8);
        textView.setText(String.valueOf(30));
        editText.addTextChangedListener(new z(editText, textView));
        new sd3(this).p(viewInflate, false).T(R.string.string_reply).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new a0(editText)).e().show();
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: f3, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            this.h0.L(cursor);
            ArrayList<ContactRequestsVO> arrayListBuildFromCursorForShow = ContactRequestsVO.buildFromCursorForShow(cursor);
            if (arrayListBuildFromCursorForShow == null || arrayListBuildFromCursorForShow.size() <= 0) {
                return;
            }
            this.I = arrayListBuildFromCursorForShow.get(0);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        int i2;
        if (this.i0 != 0 && this.q != null) {
            Intent intent = new Intent();
            intent.putExtra("uid_key", this.q.getUid());
            intent.putExtra("accept_status", this.i0);
            setResult(-1, intent);
        }
        super.finish();
        int i3 = this.w0;
        if (i3 == 0 || (i2 = this.x0) == 0) {
            return;
        }
        overridePendingTransition(i3, i2);
    }

    public void g3(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, PhotoViewActivity.class);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        MediaItem mediaItem = new MediaItem();
        mediaItem.fileFullPath = str;
        mediaItem.thumbnailPath = str2;
        arrayList.add(mediaItem);
        intent.putParcelableArrayListExtra("mediaList", arrayList);
        intent.putExtra("selectIndex", 0);
        intent.putExtra("from_portrait", true);
        intent.putExtra("from_user_portrait", true);
        intent.putExtra("extra_is_friend", bo0.r().w(this.q.getUid()));
        intent.putExtra("show_mode", 0);
        startActivity(intent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 109;
    }

    public final void h3() {
        Intent intent = new Intent();
        intent.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        int i2 = jw5.e(this.q.getSessionConfig()) ? 502 : this.g0 == 1 ? 500 : 503;
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

    public void i3() {
        if (this.q != null) {
            xg5.e().o(this, this.q.getChatId(), !jw5.i(r0.getSessionConfig()), new m(), false, false);
        }
    }

    public final void j3(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", 66 == i2 ? "tab_mine" : "tab_square");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.g("friend_recommend_detail_hi_click", jSONObject);
    }

    public void k3() {
        if (this.q != null) {
            Intent intent = new Intent(this, (Class<?>) SendMessageActivity.class);
            intent.putExtra("extra_share_contact", this.q);
            intent.putExtra("extra_from", 1);
            startActivityForResult(intent, 100);
        }
    }

    public final void l3(Intent intent) {
        intent.setClass(this, ChatterActivity.class);
        intent.putExtra("chat_item", this.q);
        intent.putExtra("thread_biz_type", this.q.getBizType());
        if (e20.a() || fu5.u(this.q)) {
            intent.putExtra("chat_need_back_to_main", false);
            intent.putExtra("chat_back_to_greet", false);
            return;
        }
        int i2 = this.B;
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

    public final void m3() {
        new sd3(this).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new b0()).e().show();
    }

    @Override // com.zenmen.palmchat.contacts.e.p
    public void n0() {
        ContactInfoItem contactInfoItem = this.q;
        String bigIconURL = contactInfoItem == null ? null : contactInfoItem.getBigIconURL();
        ContactInfoItem contactInfoItem2 = this.q;
        g3(bigIconURL, contactInfoItem2 != null ? contactInfoItem2.getIconURL() : null);
    }

    public final void n3() {
        sy5.e(this, R.string.send_failed, 0).g();
    }

    public final void o3() {
        ContactInfoItem contactInfoItem;
        int i2 = this.g0;
        if (i2 != 1) {
            if (i2 == 2) {
                ArrayList<is0.g> arrayList = new ArrayList<>();
                arrayList.add(new is0.g(ClickMenuItem.REMARK.name(), getString(R.string.modify_contact_menu_remark), R.drawable.icon_menu_remark));
                arrayList.add(new is0.g(ClickMenuItem.SPECIAL_ATTENTION.name(), jw5.i(this.q.getSessionConfig()) ? "取消设置特别关注" : "设置为特别关注", R.drawable.icon_menu_special_attention));
                arrayList.add(new is0.g(ClickMenuItem.REPORT.name(), getString(R.string.text_user_deatil_report_text), R.drawable.icon_menu_report));
                if (c3()) {
                    arrayList.add(new is0.g(ClickMenuItem.BLACKLIST.name(), !T2() ? getString(R.string.add_to_blacklist) : getString(R.string.remove_blacklist), R.drawable.icon_menu_blacklist));
                }
                showPopupMenu(this, this.U, arrayList, this.z0, null);
                return;
            }
            return;
        }
        if (fu5.u(this.q)) {
            ArrayList<is0.g> arrayList2 = new ArrayList<>();
            arrayList2.add(new is0.g(ClickMenuItem.REMARK.name(), getString(R.string.modify_contact_menu_remark), R.drawable.icon_menu_remark));
            arrayList2.add(new is0.g(ClickMenuItem.SPECIAL_ATTENTION.name(), jw5.i(this.q.getSessionConfig()) ? "取消设置特别关注" : "设置为特别关注", R.drawable.icon_menu_special_attention));
            arrayList2.add(new is0.g(ClickMenuItem.REPORT.name(), getString(R.string.text_user_deatil_report_text), R.drawable.icon_menu_report));
            arrayList2.add(new is0.g(ClickMenuItem.BLACKLIST.name(), !T2() ? getString(R.string.add_to_blacklist) : getString(R.string.remove_blacklist), R.drawable.icon_menu_blacklist));
            showPopupMenu(this, this.U, arrayList2, this.z0, null);
            return;
        }
        ArrayList<is0.g> arrayList3 = new ArrayList<>();
        arrayList3.add(new is0.g(ClickMenuItem.REMARK.name(), getString(R.string.modify_contact_menu_remark), R.drawable.icon_menu_remark));
        arrayList3.add(new is0.g(ClickMenuItem.SPECIAL_ATTENTION.name(), jw5.i(this.q.getSessionConfig()) ? "取消设置特别关注" : "设置为特别关注", R.drawable.icon_menu_special_attention));
        if (!(v8.h() && (contactInfoItem = this.q) != null && v8.C(contactInfoItem.getUid()))) {
            arrayList3.add(new is0.g(ClickMenuItem.SEND_NAME_CARD.name(), getString(R.string.string_send_name_card), R.drawable.icon_menu_send_name_card));
        }
        if (c3()) {
            arrayList3.add(new is0.g(ClickMenuItem.REPORT.name(), getString(R.string.text_user_deatil_report_text), R.drawable.icon_menu_report));
            arrayList3.add(new is0.g(ClickMenuItem.BLACKLIST.name(), !T2() ? getString(R.string.add_to_blacklist) : getString(R.string.remove_blacklist), R.drawable.icon_menu_blacklist));
        }
        arrayList3.add(new is0.g(ClickMenuItem.DELETE_CONTACT.name(), getString(R.string.string_delete), R.drawable.icon_delete_new));
        showPopupMenu(this, this.U, arrayList3, this.z0, null);
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
            this.F = stringExtra;
            this.h0.H(stringExtra);
            return;
        }
        if (i2 == 102 && i3 == -1) {
            String stringExtra2 = intent.getStringExtra("revertRid");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.F = stringExtra2;
                this.h0.H(stringExtra2);
            }
            this.i0 = intent.getLongExtra("accept_status", 0L);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        F2();
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new f0());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_user_detail);
        ds0.a().c(this);
        d3();
        if (this.q == null) {
            return;
        }
        A2();
        P2();
        Q2();
        bo0.r().i().j(this);
        zn6.j("pageprofil", "view", this.h0.k());
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
        bw4 bw4Var = this.j0;
        if (bw4Var != null) {
            bw4Var.onCancel();
        }
        q92 q92Var = this.k0;
        if (q92Var != null) {
            q92Var.onCancel();
        }
        o2 o2Var = this.l0;
        if (o2Var != null) {
            o2Var.onCancel();
        }
        bq3 bq3Var = this.m0;
        if (bq3Var != null) {
            bq3Var.onCancel();
        }
        i65 i65Var = this.n0;
        if (i65Var != null) {
            i65Var.onCancel();
        }
        f7 f7Var = this.o0;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        ih ihVar = this.p0;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        zh.k(AppContext.getContext().getContentResolver()).a(4096);
        bo0.r().i().l(this);
        this.r0.removeCallbacksAndMessages(null);
        super.onDestroy();
        com.zenmen.palmchat.contacts.e eVar = this.h0;
        if (eVar != null) {
            eVar.B();
        }
        A2();
    }

    @qm5
    public void onFriendRequestSuccessEvent(n42 n42Var) {
        b05.c(new b05.a() { // from class: h66
            @Override // b05.a
            public final Object getValue() {
                return UserDetailActivity.Z2();
            }
        });
        if (q05.o(this.sInstance)) {
            return;
        }
        runOnUiThread(new g0());
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
        o3();
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
        ch.s().r().l(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z2) {
        super.onPermissionGrant(permissionType, permissionUsage, z2);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        LogUtil.d("MapSeparationManager", "UserDetailActivity onRequestPermissionsResult requestCode " + i2);
        if (i2 == BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_FEED_USER_MAP_LOCATION.requestCode && tg4.e(iArr)) {
            FindNearByMapActivity.I3(this, ConditionHelper.getInstance().getDriftInfo().location, false, false, 0, 0, 9);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.h0.C();
        if (this.g0 == 0) {
            this.Y.setVisibility(com.zenmen.palmchat.settings.b.c().d(2) ? 0 : 8);
        }
        if (this.g0 == 0) {
            ad1.h().m(ad1.o, this);
        }
        try {
            ch.s().r().j(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.A0) {
            this.A0 = false;
            if (s34.c() == 1) {
                xg5.e().o(this, this.q.getChatId(), true, new s(), false, false);
            } else {
                sy5.f(this, "设置特别关注必须打开通知栏权限哦！", 0).g();
            }
        }
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        LogUtil.i(G0, "onStatusChanged type =" + uk5Var.f21235a);
        runOnUiThread(new t(uk5Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        ContactInfoItem contactInfoItem;
        if (this.B == 7 && (contactInfoItem = this.q) != null) {
            rn0.r(contactInfoItem.getUid());
        }
        super.onStop();
    }

    public void q3() {
        Intent intent = new Intent(this, io0.h());
        intent.putExtra("fuid", this.q.getUid());
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem != null) {
            intent.putExtra("head_img_url", contactInfoItem.getIconURL());
            intent.putExtra("nick_name", this.q.getNickName());
            intent.putExtra("remark_name", this.q.getRemarkName());
            if (this.q0) {
                String mobile = this.q.getMobile();
                if (jo6.i() && TextUtils.isEmpty(mobile)) {
                    mobile = this.u;
                }
                intent.putExtra("register_mobile_number", mobile);
            }
            intent.putExtra("remark_tel", this.q.getRemarkTel());
            intent.putExtra("description", this.q.getDescription());
            intent.putExtra("is_friend", this.g0 == 1);
            intent.putExtra("hide_register_mobile", this.q.getHideRegisterMobile());
        }
        startActivity(intent);
    }

    public final void r3(ContactInfoItem contactInfoItem) {
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

    public final void s3() {
        h hVar = new h();
        i iVar = new i();
        HashMap map = new HashMap();
        map.put("fuid", this.q.getUid());
        map.put("remarkName", this.h0.n());
        map.put("description", this.q.getDescription());
        bq3 bq3Var = new bq3(hVar, iVar);
        this.m0 = bq3Var;
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

    public final void t3() {
        if (this.g0 == 0) {
            this.W.setVisibility(8);
            this.X.setVisibility(0);
            this.Y.setVisibility(com.zenmen.palmchat.settings.b.c().d(2) ? 0 : 8);
            return;
        }
        ContactInfoItem contactInfoItem = this.q;
        if (contactInfoItem == null || !(a65.e(contactInfoItem) || this.q.isCancellation())) {
            this.W.setVisibility(0);
        } else {
            this.W.setVisibility(8);
        }
        this.X.setVisibility(8);
        this.Y.setVisibility(8);
    }

    public final void u3(ContactInfoItem contactInfoItem) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("from_head_img_url", contactInfoItem.getIconURL());
            contentValues.put("from_nick_name", contactInfoItem.getNickName());
            getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{contactInfoItem.getUid()});
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public final void y2(boolean z2) {
        int bizType;
        int i2;
        if (e20.a() && this.v0) {
            finish();
            return;
        }
        int i3 = this.B;
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
        } else if (i3 != 5 || (bizType = this.O) <= 0) {
            bizType = 64;
        }
        if (bizType == 64 && (i2 = this.J) != -1) {
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
        ContactInfoItem contactInfoItemM792clone = this.q.m792clone();
        contactInfoItemM792clone.setBizType(i4);
        LogUtil.d("", "AIPuuutype bizType " + i4 + " mFrom " + this.B);
        if (p05.c() && z2) {
            u93.b(500, new j(contactInfoItemM792clone));
        }
        if (vi5.b().e()) {
            SquareTempChatActivity.J1(this, contactInfoItemM792clone, i4, this.s0, this.t0, this.u0, this.S);
        } else {
            vi5.b().c(this, 100, new l(contactInfoItemM792clone, i4));
        }
        int i5 = this.B;
        if (68 == i5 || 66 == i5) {
            j3(i5);
        }
    }

    public void z2(String str) {
        showBaseProgressBar(getString(R.string.progress_sending), false);
        f fVar = new f();
        g gVar = new g(str);
        if (this.f0) {
            return;
        }
        o2 o2Var = new o2();
        this.l0 = o2Var;
        try {
            o2Var.n(str, this.K, this.h0.n(), fVar, gVar);
            this.mBaseProgressDialog.show();
            this.f0 = true;
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13486a;

        public g(String str) {
            this.f13486a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            UserDetailActivity.this.hideBaseProgressBar();
            UserDetailActivity.this.f0 = false;
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                UserDetailActivity.this.e0 = true;
                ContentValues contentValues = new ContentValues();
                contentValues.put("accept_status", (Long) 1L);
                AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "rid=?", new String[]{this.f13486a});
                rn0.h(UserDetailActivity.this.q.getUid(), UserDetailActivity.this.K2());
                UserDetailActivity.this.s3();
                return;
            }
            if (iOptInt == 1327) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MediationConstant.KEY_ERROR_MSG);
                mj1.c(UserDetailActivity.this, jSONObjectOptJSONObject.optString("title"), jSONObjectOptJSONObject.optString("part"), jSONObjectOptJSONObject.optString("body"), jSONObjectOptJSONObject.optInt("time"));
                return;
            }
            if (iOptInt == 1306) {
                new sd3(UserDetailActivity.this).T(R.string.update_install_dialog_title).j(R.string.contact_friend_request_expired).O(R.string.contact_add_friend).K(R.string.alert_dialog_cancel).f(new a()).e().show();
                return;
            }
            if (iOptInt == 1320 || iOptInt == 1321) {
                rx4.b(UserDetailActivity.this, jSONObject);
            } else {
                if (iOptInt == 1330 && UserDetailActivity.this.q != null && UserDetailActivity.this.q.isCancellation()) {
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
                UserDetailActivity userDetailActivity = UserDetailActivity.this;
                userDetailActivity.C2(true, userDetailActivity.I);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a0 extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f13472a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Response.ErrorListener {
            public a() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                UserDetailActivity.this.hideBaseProgressBar();
                sy5.e(UserDetailActivity.this, R.string.send_failed, 0).g();
                LogUtil.d(UserDetailActivity.G0, volleyError.toString());
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
                UserDetailActivity.this.hideBaseProgressBar();
                if (iOptInt == 0) {
                    a0 a0Var = a0.this;
                    UserDetailActivity.this.R2(a0Var.f13472a.getText().toString());
                } else if (iOptInt == 1318) {
                    sy5.e(UserDetailActivity.this, R.string.send_failed_refuse, 0).g();
                } else if (iOptInt == 7001) {
                    sy5.e(UserDetailActivity.this, R.string.send_failed_too_often, 0).g();
                } else {
                    sy5.e(UserDetailActivity.this, R.string.send_failed, 0).g();
                }
            }
        }

        public a0(EditText editText) {
            this.f13472a = editText;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (TextUtils.isEmpty(this.f13472a.getText().toString())) {
                return;
            }
            if (UserDetailActivity.this.S2()) {
                UserDetailActivity.this.m3();
                return;
            }
            a aVar = new a();
            b bVar = new b();
            HashMap map = new HashMap();
            map.put("fuid", UserDetailActivity.this.q.getUid());
            map.put("rid", UserDetailActivity.this.F);
            map.put("sourceType", String.valueOf(UserDetailActivity.this.J));
            map.put("info", this.f13472a.getText().toString());
            UserDetailActivity.this.j0 = new bw4(bVar, aVar);
            try {
                UserDetailActivity.this.j0.n(map);
                UserDetailActivity userDetailActivity = UserDetailActivity.this;
                userDetailActivity.showBaseProgressBar(userDetailActivity.getString(R.string.progress_sending), false);
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

    /* JADX INFO: compiled from: SearchBox */
    public class b0 extends MaterialDialog.e {
        public b0() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            UserDetailActivity userDetailActivity = UserDetailActivity.this;
            userDetailActivity.C2(true, userDetailActivity.I);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f13510a;
        public final /* synthetic */ TextView b;

        public z(EditText editText, TextView textView) {
            this.f13510a = editText;
            this.b = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int iD = dt2.d(this.f13510a, charSequence, 60);
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

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements ro2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactInfoItem f13496a;
        public final /* synthetic */ int b;

        public l(ContactInfoItem contactInfoItem, int i) {
            this.f13496a = contactInfoItem;
            this.b = i;
        }

        @Override // ro2.a
        public void onSuccess() {
            UserDetailActivity userDetailActivity = UserDetailActivity.this;
            SquareTempChatActivity.J1(userDetailActivity, this.f13496a, this.b, userDetailActivity.s0, UserDetailActivity.this.t0, UserDetailActivity.this.u0, UserDetailActivity.this.S);
        }

        @Override // ro2.a
        public void onCancel() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public final void X2(Context context, String str) {
    }
}
