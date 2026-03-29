package com.zenmen.palmchat.contacts.recommend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.GreetConfig;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.GhostUserDetailActivity;
import com.zenmen.palmchat.contacts.NewContactRequestSendActivityV2;
import com.zenmen.palmchat.contacts.RecommendRequestSendActivity;
import com.zenmen.palmchat.contacts.d;
import com.zenmen.palmchat.contacts.recommend.b;
import com.zenmen.palmchat.contacts.recommend.c;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ClearEditText;
import defpackage.UI;
import defpackage.ac1;
import defpackage.ad1;
import defpackage.ao0;
import defpackage.bo0;
import defpackage.ch;
import defpackage.cr3;
import defpackage.d45;
import defpackage.ds0;
import defpackage.f7;
import defpackage.g13;
import defpackage.gl0;
import defpackage.gu4;
import defpackage.hs0;
import defpackage.hx3;
import defpackage.ih;
import defpackage.il5;
import defpackage.io0;
import defpackage.iq5;
import defpackage.jk2;
import defpackage.jo6;
import defpackage.k86;
import defpackage.l50;
import defpackage.li4;
import defpackage.m66;
import defpackage.n92;
import defpackage.pm2;
import defpackage.pn5;
import defpackage.qm5;
import defpackage.r75;
import defpackage.rb3;
import defpackage.rl0;
import defpackage.rn0;
import defpackage.rx4;
import defpackage.sn0;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.tn0;
import defpackage.uk5;
import defpackage.vn0;
import defpackage.wh4;
import defpackage.xn0;
import defpackage.z31;
import defpackage.zh;
import defpackage.zn6;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.webplatform.jssdk.ContactPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecommendFriendsActivity extends BaseActionBarActivity implements pm2<Cursor> {
    public ImageView A;
    public ClearEditText B;
    public ListView C;
    public TextView E;
    public com.zenmen.palmchat.contacts.recommend.c F;
    public d45 G;
    public Toolbar K;
    public View L;
    public ListView M;
    public com.zenmen.palmchat.contacts.recommend.b N;
    public View R;
    public TextView S;
    public View T;
    public PhoneContactVo U;
    public f7 V;
    public ih W;
    public TextView X;
    public TextView Y;
    public RelativeLayout Z;
    public TextView e0;
    public n92 f0;
    public SharedPreferences t;
    public String v;
    public String w;
    public TextView z;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public boolean u = true;
    public int x = 99;
    public String y = BaseWrapper.ENTER_ID_SYSTEM_HELPER;
    public boolean H = false;
    public pn5<d45> I = new gl0(new z31());
    public HashMap<String, Integer> J = new HashMap<>();
    public ArrayList<ContactRequestsVO> O = new ArrayList<>();
    public HashMap<String, PhoneContactVo> P = new HashMap<>();
    public ArrayList<PhoneContactVo> Q = new ArrayList<>();
    public a0 g0 = new a0(this);
    public boolean h0 = false;
    public boolean i0 = false;
    public boolean j0 = false;
    public b.c k0 = new w();
    public c.b l0 = new x();
    public JSONArray m0 = new JSONArray();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecommendFriendsActivity.this.B2(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a0 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<RecommendFriendsActivity> f13628a;

        public a0(RecommendFriendsActivity recommendFriendsActivity) {
            this.f13628a = new WeakReference<>(recommendFriendsActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && this.f13628a.get() != null) {
                this.f13628a.get().showBaseProgressBar(R.string.text_getting_phone_contact, false);
                this.f13628a.get().l2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sn0 f13629a;

        public b(sn0 sn0Var) {
            this.f13629a = sn0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13629a == null || RecommendFriendsActivity.this.N == null) {
                return;
            }
            String strB = this.f13629a.b();
            long jA = this.f13629a.a();
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            if (jA == 1) {
                RecommendFriendsActivity.this.N.h(strB, 1L);
            } else {
                RecommendFriendsActivity.this.N.h(strB, 2L);
            }
            RecommendFriendsActivity.this.N.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b0 implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<RecommendFriendsActivity> f13630a;

        public b0(WeakReference<RecommendFriendsActivity> weakReference) {
            this.f13630a = weakReference;
        }

        @Override // com.zenmen.palmchat.contacts.d.c
        public void onFinished(HashMap<String, PhoneContactVo> map) {
            RecommendFriendsActivity recommendFriendsActivity = this.f13630a.get();
            if (recommendFriendsActivity != null) {
                recommendFriendsActivity.F2(map);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Comparator<d45> {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d45 d45Var, d45 d45Var2) {
            return d45Var.c().compareTo(d45Var2.c());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends jk2 {
        public d() {
        }

        @Override // defpackage.jk2
        public void c(int i, Cursor cursor) {
            super.c(i, cursor);
            if (i == 10) {
                if (!ContactRequestsVO.buildFromCursorForShow(cursor).isEmpty() && System.currentTimeMillis() - RecommendFriendsActivity.this.t.getLong(k86.q(), 0L) <= 259200000) {
                    RecommendFriendsActivity.this.k2();
                    return;
                }
                b0 b0Var = new b0(new WeakReference(RecommendFriendsActivity.this));
                if (ao0.f()) {
                    com.zenmen.palmchat.contacts.d.j().v(b0Var, RecommendFriendsActivity.this.p2());
                } else {
                    com.zenmen.palmchat.contacts.d.j().u(b0Var);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendFriendsActivity.this.P = com.zenmen.palmchat.contacts.d.j().n();
            RecommendFriendsActivity.this.g0.sendEmptyMessageDelayed(0, 0L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Comparator<PhoneContactVo> {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContactVo phoneContactVo, PhoneContactVo phoneContactVo2) {
            if (phoneContactVo.getSortId() != phoneContactVo2.getSortId()) {
                return phoneContactVo.getSortId() - phoneContactVo2.getSortId();
            }
            if (phoneContactVo.getSendTime() > phoneContactVo2.getSendTime()) {
                return -1;
            }
            return phoneContactVo.getSendTime() < phoneContactVo2.getSendTime() ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f13636a;

            public a(int i) {
                this.f13636a = i;
                put("action", "pull_phone_contact");
                put("status", "success");
                put("detail", Integer.valueOf(i));
            }
        }

        public g() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(BaseActionBarActivity.TAG, "getContact response=" + jSONObject.toString());
            try {
                int i = jSONObject.getInt("resultCode");
                LogUtil.i(BaseActionBarActivity.TAG, 3, new a(i), (Throwable) null);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (i != 0 || jSONObjectOptJSONObject == null) {
                    RecommendFriendsActivity.this.hideBaseProgressBar();
                    RecommendFriendsActivity.this.y2();
                    return;
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("contacts");
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    RecommendFriendsActivity.this.m0.put(jSONArrayOptJSONArray.get(i2));
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("continueFlag");
                RecommendFriendsActivity.this.r = jSONObjectOptJSONObject.optInt("nextIndex");
                int iOptInt2 = jSONObjectOptJSONObject.optInt("waitingTime");
                RecommendFriendsActivity.this.s = jSONObjectOptJSONObject.optInt("btnShowLimit");
                String strOptString = jSONObjectOptJSONObject.optString("btnName");
                if (!TextUtils.isEmpty(strOptString)) {
                    RecommendFriendsActivity.this.S.setText(strOptString);
                }
                if (RecommendFriendsActivity.this.N.f().size() == 0 || RecommendFriendsActivity.this.N.f().size() > RecommendFriendsActivity.this.s) {
                    RecommendFriendsActivity.this.R.setVisibility(8);
                    RecommendFriendsActivity.this.N.m(false);
                } else {
                    RecommendFriendsActivity.this.R.setVisibility(0);
                    RecommendFriendsActivity.this.N.m(true);
                }
                RecommendFriendsActivity.this.D2();
                if (iOptInt == 1 && iOptInt2 > 0) {
                    RecommendFriendsActivity.this.g0.sendEmptyMessageDelayed(0, iOptInt2);
                    return;
                }
                wh4.a(RecommendFriendsActivity.this.m0, RecommendFriendsActivity.this.u ? false : true, RecommendFriendsActivity.this.O, RecommendFriendsActivity.this.P);
                RecommendFriendsActivity.this.hideBaseProgressBar();
                RecommendFriendsActivity.this.y2();
            } catch (Exception e) {
                e.printStackTrace();
                RecommendFriendsActivity.this.hideBaseProgressBar();
                RecommendFriendsActivity.this.y2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VolleyError f13638a;

            public a(VolleyError volleyError) {
                this.f13638a = volleyError;
                put("action", "pull_phone_contact");
                put("status", "fail");
                put("detail", volleyError.getMessage());
            }
        }

        public h() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RecommendFriendsActivity.this.hideBaseProgressBar();
            LogUtil.i(BaseActionBarActivity.TAG, 3, new a(volleyError), (Throwable) null);
            LogUtil.i(BaseActionBarActivity.TAG, "error=" + volleyError.toString());
            RecommendFriendsActivity.this.y2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f13639a;

        public i(uk5 uk5Var) {
            this.f13639a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk5 uk5Var = this.f13639a;
            if (uk5Var.f21235a != 22) {
                return;
            }
            String str = uk5Var.d;
            if (ad1.j(ad1.k, str)) {
                LogUtil.i("TYPE_DIALOG_PROCESS_MSG_RECEIVED", "onStatusChanged pageIndex = " + str);
                ad1.h().m(ad1.k, RecommendFriendsActivity.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements AdapterView.OnItemClickListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            RecommendFriendsActivity.this.u2(((d45) adapterView.getItemAtPosition(i)).e());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13641a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ContactRequestArgs c;

        public k(boolean z, String str, ContactRequestArgs contactRequestArgs) {
            this.f13641a = z;
            this.b = str;
            this.c = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                RecommendFriendsActivity.this.hideBaseProgressBar();
                if (!this.f13641a) {
                    RecommendFriendsActivity.this.N.h(this.b, 1L);
                    RecommendFriendsActivity.this.N.o(RecommendFriendsActivity.this.Q);
                    wh4.d(RecommendFriendsActivity.this.U.getUid(), RecommendFriendsActivity.this.U.getRequestType());
                    iq5.j(false, new String[0]);
                    return;
                }
                if (RecommendFriendsActivity.this.G != null) {
                    xn0.d().e(RecommendFriendsActivity.this.G.h(), 1L);
                    RecommendFriendsActivity.this.F.notifyDataSetChanged();
                    wh4.d(RecommendFriendsActivity.this.G.h(), RecommendFriendsActivity.this.G.g());
                    return;
                }
                return;
            }
            if (iOptInt == 1) {
                RecommendFriendsActivity.this.j2(this.c, this.b, this.f13641a);
                return;
            }
            if (iOptInt == 1318) {
                RecommendFriendsActivity.this.hideBaseProgressBar();
                sy5.e(RecommendFriendsActivity.this, R.string.send_refuse, 1).g();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                RecommendFriendsActivity.this.hideBaseProgressBar();
                rx4.b(RecommendFriendsActivity.this, jSONObject);
            } else {
                RecommendFriendsActivity.this.hideBaseProgressBar();
                sy5.f(RecommendFriendsActivity.this, rx4.a(jSONObject), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.ErrorListener {
        public l() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RecommendFriendsActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Response.ErrorListener {
        public m() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RecommendFriendsActivity.this.hideBaseProgressBar();
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13644a;
        public final /* synthetic */ String b;

        public n(boolean z, String str) {
            this.f13644a = z;
            this.b = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            RecommendFriendsActivity.this.hideBaseProgressBar();
            if (this.f13644a) {
                xn0.d().e(RecommendFriendsActivity.this.G.h(), 2L);
                RecommendFriendsActivity.this.F.notifyDataSetChanged();
                wh4.d(RecommendFriendsActivity.this.G.h(), RecommendFriendsActivity.this.G.g());
            } else {
                RecommendFriendsActivity.this.N.h(this.b, 2L);
                RecommendFriendsActivity.this.N.o(RecommendFriendsActivity.this.Q);
                wh4.d(RecommendFriendsActivity.this.U.getUid(), RecommendFriendsActivity.this.U.getRequestType());
            }
            rx4.b(RecommendFriendsActivity.this, jSONObject);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements Response.ErrorListener {
        public o() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RecommendFriendsActivity.this.hideBaseProgressBar();
            sy5.e(RecommendFriendsActivity.this, R.string.send_failed, 0).g();
            Log.e(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f13646a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;

        public p(List list, List list2, String str) {
            this.f13646a = list;
            this.b = list2;
            this.c = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            RecommendFriendsActivity.this.hideBaseProgressBar();
            Log.e(BaseActionBarActivity.TAG, "response: " + jSONObject.toString());
            if (jSONObject.optInt("resultCode") != 0) {
                String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                RecommendFriendsActivity recommendFriendsActivity = RecommendFriendsActivity.this;
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = RecommendFriendsActivity.this.getString(R.string.send_failed);
                }
                sy5.f(recommendFriendsActivity, strOptString, 0).g();
                return;
            }
            RecommendFriendsActivity.this.N.i(this.f13646a, 2L);
            RecommendFriendsActivity.this.N.o(RecommendFriendsActivity.this.Q);
            RecommendFriendsActivity.this.D2();
            if (this.b.size() > 0) {
                RecommendFriendsActivity.this.i2(this.b, this.c);
            } else {
                sy5.e(RecommendFriendsActivity.this, R.string.recommend_friend_send_succeed, 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements Response.ErrorListener {
        public q() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            RecommendFriendsActivity.this.hideBaseProgressBar();
            sy5.e(RecommendFriendsActivity.this, R.string.send_failed, 0).g();
            Log.e(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f13648a;

        public r(List list) {
            this.f13648a = list;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            RecommendFriendsActivity.this.hideBaseProgressBar();
            Log.e(BaseActionBarActivity.TAG, "response: " + jSONObject.toString());
            if (jSONObject.optInt("resultCode") == 0) {
                RecommendFriendsActivity.this.N.i(this.f13648a, 2L);
                RecommendFriendsActivity.this.N.o(RecommendFriendsActivity.this.Q);
                RecommendFriendsActivity.this.D2();
                sy5.e(RecommendFriendsActivity.this, R.string.recommend_friend_send_succeed, 0).g();
                return;
            }
            String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            RecommendFriendsActivity recommendFriendsActivity = RecommendFriendsActivity.this;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = RecommendFriendsActivity.this.getString(R.string.send_failed);
            }
            sy5.f(recommendFriendsActivity, strOptString, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements AdapterView.OnItemClickListener {
        public s() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            RecommendFriendsActivity.this.u2((PhoneContactVo) adapterView.getItemAtPosition(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements b.d {
        public t() {
        }

        @Override // com.zenmen.palmchat.contacts.recommend.b.d
        public void onClick() {
            RecommendFriendsActivity.this.D2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<GreetConfig.Word> listA;
            GreetConfig greetConfigF = rl0.h().f();
            String str = (greetConfigF == null || (listA = greetConfigF.a()) == null) ? "" : listA.get(new Random().nextInt(listA.size())).b;
            RecommendFriendsActivity recommendFriendsActivity = RecommendFriendsActivity.this;
            recommendFriendsActivity.h2(recommendFriendsActivity.N.g(), str);
            LogUtil.uploadInfoImmediate("2222", null, null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivityPermissionDispatcher.b(RecommendFriendsActivity.this, BaseActivityPermissionDispatcher.PermissionType.CONTACT, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT);
            zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_permission_2", null, null);
            LogUtil.onImmediateClickEvent("2uploadc", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w implements b.c {
        public w() {
        }

        @Override // com.zenmen.palmchat.contacts.recommend.b.c
        public void a(PhoneContactVo phoneContactVo) {
            PhoneContactItem phoneContactItem;
            PhoneContactItem phoneContactItem2;
            RecommendFriendsActivity.this.U = phoneContactVo;
            if (jo6.r()) {
                Intent intent = new Intent(RecommendFriendsActivity.this, (Class<?>) RecommendRequestSendActivity.class);
                intent.putExtra("uid_key", phoneContactVo.getUid());
                intent.putExtra("user_item_info_key", phoneContactVo);
                intent.putExtra("source_type_key", phoneContactVo.getRequestType() < 200 ? 3 : phoneContactVo.getSourceType());
                intent.putExtra("real_name", phoneContactVo.getRealName());
                intent.putExtra("send_from_type", 3);
                intent.putExtra("subtype_key", RecommendFriendsActivity.this.o2());
                if (TextUtils.isEmpty(phoneContactVo.getMobile())) {
                    String md5Phone = phoneContactVo.getMd5Phone();
                    if (!TextUtils.isEmpty(md5Phone) && (phoneContactItem2 = com.zenmen.palmchat.contacts.d.j().m().get(md5Phone)) != null) {
                        intent.putExtra("new_contact_local_phone_number", phoneContactItem2.y());
                    }
                } else {
                    intent.putExtra("new_contact_local_phone_number", phoneContactVo.getMobile());
                }
                RecommendFriendsActivity.this.startActivityForResult(intent, 100);
            } else if (jo6.t()) {
                Intent intent2 = new Intent(RecommendFriendsActivity.this, (Class<?>) NewContactRequestSendActivityV2.class);
                intent2.putExtra("user_item_info", phoneContactVo);
                intent2.putExtra("uid_key", phoneContactVo.getUid());
                intent2.putExtra("send_from_type", 3);
                intent2.putExtra("new_contact_source_type", phoneContactVo.getRequestType() < 200 ? 3 : phoneContactVo.getSourceType());
                if (TextUtils.isEmpty(phoneContactVo.getMobile())) {
                    String md5Phone2 = phoneContactVo.getMd5Phone();
                    if (!TextUtils.isEmpty(md5Phone2) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(md5Phone2)) != null) {
                        intent2.putExtra("new_contact_local_phone_number", phoneContactItem.y());
                    }
                } else {
                    intent2.putExtra("new_contact_local_phone_number", phoneContactVo.getMobile());
                }
                intent2.putExtra("subtype_key", RecommendFriendsActivity.this.o2());
                intent2.putExtra("extra_request_from", 21);
                intent2.putExtra("extra_request_type", phoneContactVo.getRequestType());
                RecommendFriendsActivity.this.startActivity(intent2);
            } else {
                RecommendFriendsActivity.this.f2(phoneContactVo);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DeviceInfoUtil.UID_TAG, phoneContactVo.getUid());
                if (phoneContactVo.getRequestType() < 200) {
                    jSONObject.put("sourcetype", 3);
                } else {
                    jSONObject.put("sourcetype", 20);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2221", null, null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements c.b {
        public x() {
        }

        @Override // com.zenmen.palmchat.contacts.recommend.c.b
        public void a(d45 d45Var) {
            String strB;
            RecommendFriendsActivity.this.G = d45Var;
            xn0.d().e(d45Var.h(), 2L);
            RecommendFriendsActivity.this.F.notifyDataSetChanged();
            ContactRequestArgs.Builder builder = new ContactRequestArgs.Builder();
            if (d45Var.a() != null) {
                builder.e(ContactRequestArgs.b(d45Var.a()));
            } else if (d45Var.e() != null) {
                builder.e(ContactRequestArgs.c(d45Var.e()));
            }
            builder.d(d45Var.h());
            builder.i(RecommendFriendsActivity.this.n2(d45Var.e())).j(String.valueOf(RecommendFriendsActivity.this.o2()));
            String str = "";
            if (jo6.i()) {
                ContactInfoItem contactInfoItemL = bo0.r().l(d45Var.h());
                if (contactInfoItemL != null && !TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                    strB = contactInfoItemL.getRemarkName();
                } else if (!TextUtils.isEmpty(d45Var.b())) {
                    strB = d45Var.b();
                }
                str = strB;
            }
            builder.g(str);
            RecommendFriendsActivity.this.e2(builder.a(), d45Var.h(), true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DeviceInfoUtil.UID_TAG, d45Var.h());
                if (d45Var.g() < 200) {
                    jSONObject.put("sourcetype", 3);
                } else {
                    jSONObject.put("sourcetype", 20);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("2221", null, null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecommendFriendsActivity.this.B2(true);
        }
    }

    public final void A2() {
        com.zenmen.palmchat.contacts.d.j().i();
        showBaseProgressBar(R.string.text_getting_phone_contact, false);
        if (hx3.m(AppContext.getContext())) {
            zh.k(AppContext.getContext().getContentResolver()).i(10, new d(), vn0.f21483a, null, "request_type = ?", new String[]{String.valueOf(101)}, null);
        } else {
            y2();
            sy5.e(this, R.string.net_status_unavailable, 1).g();
            hideBaseProgressBar();
        }
    }

    public final void B2(boolean z2) {
        if (z2) {
            this.z.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.L.setVisibility(8);
            this.B.requestFocus();
            this.E.setVisibility(0);
            this.K.setNavigationIcon((Drawable) null);
        } else {
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(8);
            this.C.setVisibility(8);
            this.L.setVisibility(0);
            this.B.setText((CharSequence) null);
            this.E.setVisibility(8);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.B.getWindowToken(), 0);
            this.K.setNavigationIcon(R.drawable.selector_arrow_back);
        }
        this.H = z2;
    }

    public final void C2(HashMap<String, PhoneContactVo> map) {
        hideBaseProgressBar();
        ArrayList<PhoneContactVo> arrayList = new ArrayList<>();
        if (map != null) {
            HashMap<String, PhoneContactVo> map2 = this.P;
            if (map2 == null || map2.size() == 0) {
                this.P = com.zenmen.palmchat.contacts.d.j().n();
            }
            Iterator<Map.Entry<String, PhoneContactVo>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                PhoneContactVo value = it.next().getValue();
                if (TextUtils.isEmpty(value.getMd5Phone())) {
                    if (this.P != null) {
                        PhoneContactVo phoneContactVo = this.P.get(hs0.g().d(value.getMobile()));
                        if (phoneContactVo != null && !TextUtils.isEmpty(phoneContactVo.getLocalName())) {
                            value.setLocalName(phoneContactVo.getLocalName());
                        }
                    }
                    value.setLocalNameFirstPinyin(li4.a(value.getLocalName()));
                    value.setLocalNameAllPinyin(li4.b(value.getLocalName()));
                } else {
                    HashMap<String, PhoneContactVo> map3 = this.P;
                    PhoneContactVo phoneContactVo2 = map3 != null ? map3.get(value.getMd5Phone()) : null;
                    if (phoneContactVo2 != null) {
                        value.setLocalName(phoneContactVo2.getLocalName());
                        value.setLocalNameFirstPinyin(li4.a(phoneContactVo2.getLocalName()));
                        value.setLocalNameAllPinyin(li4.b(phoneContactVo2.getLocalName()));
                    } else {
                        value.setLocalNameFirstPinyin(li4.a(value.getLocalName()));
                        value.setLocalNameAllPinyin(li4.b(value.getLocalName()));
                    }
                }
                arrayList.add(value);
            }
        }
        E2(arrayList);
    }

    public final void D2() {
        boolean z2;
        this.N.notifyDataSetChanged();
        Iterator<PhoneContactVo> it = this.N.g().iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            PhoneContactVo next = it.next();
            Log.e(BaseActionBarActivity.TAG, "isSelected: " + next.isSelected() + "+ LocalName:" + next.getLocalName());
            if (next.isSelected()) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            this.S.setEnabled(true);
        } else {
            this.S.setEnabled(false);
        }
    }

    public final void E2(ArrayList<PhoneContactVo> arrayList) {
        try {
            z2(arrayList);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
        this.Q.clear();
        this.Q.addAll(arrayList);
        x2(this.Q);
        this.N.o(this.Q);
        D2();
        if (this.Q.size() == 0 || this.N.f().size() == 0 || this.N.f().size() > this.s) {
            this.R.setVisibility(8);
            this.N.m(false);
        } else {
            this.R.setVisibility(0);
            this.N.m(true);
        }
    }

    public void F2(HashMap<String, PhoneContactVo> map) {
        this.P = map;
        this.g0.sendEmptyMessageDelayed(0, 0L);
        if (this.j0) {
            cr3.a(true);
        }
    }

    public final void e2(ContactRequestArgs contactRequestArgs, String str, boolean z2) {
        if (str == null) {
            return;
        }
        f7 f7Var = new f7(new k(z2, str, contactRequestArgs), new l());
        this.V = f7Var;
        try {
            f7Var.n(contactRequestArgs);
            showBaseProgressBar(R.string.progress_sending, false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void f2(PhoneContactVo phoneContactVo) {
        String localName;
        String str = "";
        if (jo6.i()) {
            ContactInfoItem contactInfoItemL = bo0.r().l(phoneContactVo.getUid());
            if (contactInfoItemL != null && !TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                localName = contactInfoItemL.getRemarkName();
            } else if (!TextUtils.isEmpty(phoneContactVo.getLocalName())) {
                localName = phoneContactVo.getLocalName();
            }
            str = localName;
        }
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(ContactRequestArgs.c(phoneContactVo)).i(n2(phoneContactVo)).j(String.valueOf(o2())).g(str).a();
        if (TextUtils.isEmpty(phoneContactVo.getNickName()) || TextUtils.isEmpty(phoneContactVo.getIconURL())) {
            j2(contactRequestArgsA, phoneContactVo.getUid(), false);
        } else {
            e2(contactRequestArgsA, phoneContactVo.getUid(), false);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (this.H) {
            B2(false);
        } else {
            super.finish();
        }
    }

    public final void g2(List<PhoneContactVo> list, List<PhoneContactVo> list2, String str) {
        o oVar = new o();
        p pVar = new p(list, list2, str);
        JSONArray jSONArray = new JSONArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (PhoneContactVo phoneContactVo : list) {
            if (phoneContactVo.isSelected() && !TextUtils.isEmpty(phoneContactVo.getUid())) {
                if (sb3.length() == 0 && sb.length() == 0) {
                    sb3.append(m2(phoneContactVo));
                } else {
                    sb3.append(",");
                    sb3.append(m2(phoneContactVo));
                }
                if (sb.length() == 0) {
                    sb.append(phoneContactVo.getUid());
                } else {
                    sb.append(",");
                    sb.append(phoneContactVo.getUid());
                }
                if (sb2.length() == 0) {
                    sb2.append(o2());
                } else {
                    sb2.append(",");
                    sb2.append(o2());
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fuids", sb.toString());
            jSONObject.put("sourceType", String.valueOf(3));
            jSONObject.put("subTypes", sb2.toString());
            jSONObject.put("info", str);
            jSONObject.put("remarkName", sb3.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        jSONArray.put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("multiApplys", jSONArray);
            jSONObject2.put("sdid", ac1.v());
            EncryptUtils.setLxData(jSONObject2);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        ih ihVar = new ih(pVar, oVar);
        this.W = ihVar;
        try {
            ihVar.t(jSONObject2);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 203;
    }

    public final void h2(List<PhoneContactVo> list, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (PhoneContactVo phoneContactVo : list) {
            if (phoneContactVo.getRequestType() < 200 || phoneContactVo.getSourceType() == 7) {
                arrayList.add(phoneContactVo);
            } else {
                arrayList2.add(phoneContactVo);
            }
        }
        if (arrayList.size() > 0) {
            g2(arrayList, arrayList2, str);
        } else if (arrayList2.size() > 0) {
            i2(arrayList2, str);
        }
    }

    public final void i2(List<PhoneContactVo> list, String str) {
        q qVar = new q();
        r rVar = new r(list);
        JSONArray jSONArray = new JSONArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        for (PhoneContactVo phoneContactVo : list) {
            if (phoneContactVo.isSelected() && !TextUtils.isEmpty(phoneContactVo.getUid())) {
                if (phoneContactVo.getSourceType() == 22) {
                    if (sb3.length() == 0) {
                        sb3.append(phoneContactVo.getUid());
                    } else {
                        sb3.append(",");
                        sb3.append(phoneContactVo.getUid());
                    }
                    if (sb4.length() == 0) {
                        sb4.append(o2());
                    } else {
                        sb4.append(",");
                        sb4.append(o2());
                    }
                } else {
                    if (sb.length() == 0) {
                        sb.append(phoneContactVo.getUid());
                    } else {
                        sb.append(",");
                        sb.append(phoneContactVo.getUid());
                    }
                    if (sb2.length() == 0) {
                        sb2.append(o2());
                    } else {
                        sb2.append(",");
                        sb2.append(o2());
                    }
                }
            }
        }
        if (sb.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fuids", sb.toString());
                jSONObject.put("sourceType", String.valueOf(20));
                jSONObject.put("subTypes", sb2.toString());
                jSONObject.put("info", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        if (sb3.length() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("fuids", sb3.toString());
                jSONObject2.put("sourceType", String.valueOf(22));
                jSONObject2.put("subTypes", sb4.toString());
                jSONObject2.put("info", str);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            jSONArray.put(jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("multiApplys", jSONArray);
            jSONObject3.put("sdid", ac1.v());
            EncryptUtils.setLxData(jSONObject3);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        ih ihVar = new ih(rVar, qVar);
        this.W = ihVar;
        try {
            ihVar.t(jSONObject3);
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        } catch (DaoException e5) {
            e5.printStackTrace();
        }
    }

    public final void j2(ContactRequestArgs contactRequestArgs, String str, boolean z2) {
        ih ihVar = new ih(new n(z2, str), new m());
        this.W = ihVar;
        try {
            ihVar.r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void k2() {
        new g13(new e()).start();
    }

    public final void l2() {
        if (this.q >= 200) {
            y2();
            return;
        }
        n92 n92Var = new n92(new g(), new h());
        this.f0 = n92Var;
        try {
            n92Var.n(this.w, this.r, false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        this.q++;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[Catch: UnsupportedEncodingException -> 0x004f, TryCatch #0 {UnsupportedEncodingException -> 0x004f, blocks: (B:9:0x0024, B:11:0x002e, B:13:0x0038, B:15:0x0046), top: B:20:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m2(PhoneContactVo phoneContactVo) {
        String strEncode;
        String str = "";
        if (!jo6.i() || phoneContactVo == null || TextUtils.isEmpty(phoneContactVo.getUid())) {
            return "";
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(phoneContactVo.getUid());
        if (contactInfoItemL != null) {
            try {
                if (!TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                    strEncode = URLEncoder.encode(contactInfoItemL.getRemarkName(), "UTF-8");
                } else {
                    if (TextUtils.isEmpty(io0.v(phoneContactVo.getLocalName()))) {
                        return "";
                    }
                    strEncode = URLEncoder.encode(phoneContactVo.getLocalName(), "UTF-8");
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        str = strEncode;
        return str;
    }

    public final String n2(PhoneContactVo phoneContactVo) {
        return phoneContactVo != null ? phoneContactVo.getRequestType() < 200 ? String.valueOf(3) : String.valueOf(phoneContactVo.getSourceType()) : String.valueOf(3);
    }

    public int o2() {
        return this.x;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 100 || i3 != -1) {
            super.onActivityResult(i2, i3, intent);
            return;
        }
        String stringExtra = intent.getStringExtra("uid_key");
        long longExtra = intent.getLongExtra("accept_status", 0L);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if (longExtra == 1) {
            this.N.h(stringExtra, 1L);
        } else {
            this.N.h(stringExtra, 2L);
        }
        this.N.notifyDataSetChanged();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        s2();
    }

    @qm5
    public void onContactRequestSendEvent(sn0 sn0Var) {
        runOnUiThread(new b(sn0Var));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_recommend_friends);
        this.t = PreferenceManager.getDefaultSharedPreferences(AppContext.getContext());
        this.w = rb3.c(AccountUtils.i(this) + AccountUtils.k(this));
        t2();
        r2();
        q2();
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.CONTACT;
        if (tg4.b(this, permissionType.permissionList)) {
            onPermissionGrant(permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT, false);
        }
        UI.c(this, 0, null, this);
        bo0.r().i().j(this);
        ds0.a().c(this);
        LogUtil.uploadInfoImmediate("222", null, null, null);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        if (i2 != 0) {
            return null;
        }
        return new CursorLoader(this, vn0.f21483a, null, "request_type >= ? and request_type != ? and request_type != ? and request_type != ? and request_type != ?", new String[]{String.valueOf(100), String.valueOf(200), Integer.toString(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR), Integer.toString(301), Integer.toString(302)}, "_id DESC");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideBaseProgressBar();
        if (this.u) {
            gu4.c(tn0.i().d(), true);
        } else {
            rn0.l();
            rn0.m();
            gu4.c(0, false);
        }
        f7 f7Var = this.V;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        ih ihVar = this.W;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        n92 n92Var = this.f0;
        if (n92Var != null) {
            n92Var.onCancel();
        }
        this.g0.removeMessages(0);
        zh.k(AppContext.getContext().getContentResolver()).a(10);
        bo0.r().i().l(this);
        ds0.a().d(this);
        xn0.d().a();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        s2();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ch.s().r().l(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList[0])) {
            if (this.h0) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", getPackageName(), null));
                startActivity(intent);
                this.i0 = true;
            } else {
                this.h0 = true;
            }
        }
        zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_permission_4", null, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z2) {
        super.onPermissionGrant(permissionType, permissionUsage, z2);
        findViewById(R.id.permission_fail).setVisibility(8);
        A2();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", z2 ? 2 : 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("2uploadp", null, jSONObject.toString());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ad1.h().m(ad1.k, this);
        try {
            ch.s().r().j(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.i0) {
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.CONTACT;
            if (tg4.b(this, permissionType.permissionList)) {
                onPermissionGrant(permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT, false);
            }
        }
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        LogUtil.i(BaseActionBarActivity.TAG, "onStatusChanged type =" + uk5Var.f21235a);
        runOnUiThread(new i(uk5Var));
    }

    public String p2() {
        return this.y;
    }

    public final void q2() {
        this.K = initToolbar(-1);
        TextView textView = (TextView) findViewById(R.id.title);
        this.z = textView;
        textView.setText(R.string.check_phone_contact);
        ImageView imageView = (ImageView) findViewById(R.id.searchIcon);
        this.A = imageView;
        imageView.setOnClickListener(new y());
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.searchInput);
        this.B = clearEditText;
        clearEditText.setClearDrawable(R.drawable.clear_search, R.drawable.clear_search);
        this.B.addTextChangedListener(new z());
        TextView textView2 = (TextView) findViewById(R.id.cancel_search);
        this.E = textView2;
        textView2.setOnClickListener(new a());
        B2(false);
        setSupportActionBar(this.K);
    }

    public final void r2() {
        this.C = (ListView) findViewById(R.id.contacts_search_list);
        com.zenmen.palmchat.contacts.recommend.c cVar = new com.zenmen.palmchat.contacts.recommend.c(this, this.l0);
        this.F = cVar;
        this.C.setAdapter((ListAdapter) cVar);
        this.C.setOnItemClickListener(new j());
        this.L = findViewById(R.id.contacts_list_layout);
        this.M = (ListView) findViewById(R.id.contacts_list);
        com.zenmen.palmchat.contacts.recommend.b bVar = new com.zenmen.palmchat.contacts.recommend.b(this, this.k0);
        this.N = bVar;
        this.M.setAdapter((ListAdapter) bVar);
        this.M.setOnItemClickListener(new s());
        this.N.l(new t());
        this.R = findViewById(R.id.one_key_area);
        TextView textView = (TextView) findViewById(R.id.btn_one_key_add);
        this.S = textView;
        textView.setOnClickListener(new u());
        this.T = findViewById(R.id.tv_empty_view);
        this.X = (TextView) findViewById(R.id.permission_text);
        this.Y = (TextView) findViewById(R.id.permission_sub_text);
        this.Z = (RelativeLayout) findViewById(R.id.permission_add);
        this.e0 = (TextView) findViewById(R.id.permission_btn_text);
        if (ao0.b()) {
            this.X.setText(ao0.d());
            this.Y.setText(ao0.c());
            this.e0.setText(ao0.a());
        }
        this.Z.setOnClickListener(new v());
    }

    public final void s2() {
        if ("pop_page".equals(this.v)) {
            startActivity(new Intent(this, (Class<?>) ContactActivity.class));
        }
        finish();
    }

    public final void t2() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(ContactPlugin.EXTRA_KEY_FROM);
            if (ContactPlugin.EXTRA_KEY_FROM_H5.equals(string)) {
                LogUtil.onImmediateClickEvent("231", null, null);
            } else if ("upload_contact_from_thread".equals(string)) {
                LogUtil.onImmediateClickEvent("241", null, null);
            } else if ("upload_contact_from_nearby".equals(string)) {
                LogUtil.onImmediateClickEvent("251", null, null);
            } else if ("upload_contact_from_newcontact".equals(string)) {
                LogUtil.onImmediateClickEvent("282", null, null);
            }
            AppContext.getContext().getTrayPreferences().i(k86.n(), true);
        }
        this.u = r75.d(AppContext.getContext(), k86.a("sp_first_friend_recommend"), true);
        tn0.i().A(this.u);
        r75.o(AppContext.getContext(), k86.a("sp_first_friend_recommend"), false);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.v = intent.getStringExtra("from");
        String stringExtra = intent.getStringExtra(ContactPlugin.EXTRA_KEY_FROM);
        if (stringExtra == null) {
            return;
        }
        if (ContactPlugin.EXTRA_KEY_FROM_H5.equals(stringExtra)) {
            this.x = 9;
            this.y = BaseWrapper.ENTER_ID_SHORTCUT;
        } else if (stringExtra.equals("upload_contact_from_thread")) {
            this.x = 10;
            this.y = "24";
        } else if (stringExtra.equals("upload_contact_from_nearby")) {
            this.x = 11;
            this.y = "25";
        } else if (stringExtra.equals("upload_contact_from_menu")) {
            this.x = 12;
            this.y = "26";
        } else if (stringExtra.equals("upload_contact_from_menu_rec")) {
            this.x = 13;
            this.y = "27";
        } else if (stringExtra.equals("upload_contact_from_newcontact")) {
            this.x = 14;
            this.y = "282";
        } else if (stringExtra.equals("upload_contact_from_main")) {
            this.x = 15;
            this.y = "28";
        } else if (stringExtra.equals("upload_contact_from_discover")) {
            this.x = 16;
            this.y = "281";
        } else if (stringExtra.equals("upload_contact_from_ACCOUNT")) {
            this.x = 17;
            this.y = "200";
        } else if (stringExtra.equals("upload_contact_from_crop")) {
            this.x = 18;
            this.y = "29";
        } else if (stringExtra.equals("upload_contact_from_newcontact_menu")) {
            this.x = 20;
            this.y = BaseWrapper.ENTER_ID_TOOLKIT;
        } else if (stringExtra.equals("upload_contact_from_invite_friends")) {
            this.x = 80;
            this.y = BaseWrapper.ENTER_ID_OAPS_DEMO;
        } else if (stringExtra.equals("upload_contact_from_push")) {
            this.x = 81;
            this.y = "32";
        } else if (stringExtra.equals("upload_contact_from_guide")) {
            this.x = 82;
            this.y = BaseWrapper.ENTER_ID_OAPS_ROAMING;
        }
        this.j0 = stringExtra.equals("upload_contact_from_crop");
    }

    public final void u2(PhoneContactVo phoneContactVo) {
        PhoneContactItem phoneContactItem;
        if (l50.a()) {
            return;
        }
        rn0.r(phoneContactVo.getUid());
        if (io0.s(phoneContactVo.getNickName(), phoneContactVo.getIconURL())) {
            Intent intent = new Intent(this, (Class<?>) GhostUserDetailActivity.class);
            intent.putExtra("user_item_info", phoneContactVo);
            intent.putExtra("user_item_info_local_name", phoneContactVo.getLocalName());
            PhoneContactItem phoneContactItem2 = com.zenmen.palmchat.contacts.d.j().m().get(phoneContactVo.getMd5Phone());
            if (phoneContactItem2 != null) {
                intent.putExtra("user_item_info_phone_number", phoneContactItem2.y());
            }
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) m66.c());
        intent2.putExtra("user_item_info", phoneContactVo);
        intent2.putExtra("from", 9);
        intent2.putExtra("extra_request_from", 21);
        intent2.putExtra("extra_request_type", phoneContactVo.getRequestType());
        intent2.putExtra("user_real_name", phoneContactVo.getRealName());
        if (TextUtils.isEmpty(phoneContactVo.getMobile())) {
            String md5Phone = phoneContactVo.getMd5Phone();
            if (!TextUtils.isEmpty(md5Phone) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(md5Phone)) != null) {
                intent2.putExtra("user_detail_local_phone_number", phoneContactItem.y());
            }
        } else {
            intent2.putExtra("user_detail_local_phone_number", phoneContactVo.getMobile());
        }
        if (!jo6.r()) {
            startActivity(intent2);
            return;
        }
        intent2.putExtra("new_request_send_page", true);
        intent2.putExtra("send_from_type", 3);
        startActivityForResult(intent2, 100);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: v2, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        ArrayList<ContactRequestsVO> arrayList;
        if (loader.getId() != 0 || cursor == null) {
            return;
        }
        ArrayList<ContactRequestsVO> arrayListBuildFromCursorForLX16234 = ContactRequestsVO.buildFromCursorForLX16234(cursor, false);
        if (arrayListBuildFromCursorForLX16234.size() != 0 || (arrayList = this.O) == null || arrayList.size() <= 0) {
            this.O.clear();
            this.O.addAll(arrayListBuildFromCursorForLX16234);
            C2(wh4.c(this.O));
        }
    }

    public final void w2() {
        pn5<d45> pn5Var;
        ArrayList<d45> arrayList = new ArrayList<>();
        String strQ = il5.q(this.B.getText().toString().toLowerCase());
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(strQ) && (pn5Var = this.I) != null) {
            try {
                for (d45 d45Var : pn5Var.b(strQ)) {
                    if (!map.containsKey(d45Var.h())) {
                        arrayList.add(d45Var);
                        map.put(d45Var.h(), Boolean.TRUE);
                    }
                }
                Collections.sort(arrayList, new c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.F.c(arrayList);
    }

    public final void x2(ArrayList<PhoneContactVo> arrayList) {
        this.I = new gl0(new z31());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            PhoneContactVo phoneContactVo = arrayList.get(i2);
            d45 d45Var = new d45();
            d45Var.o(phoneContactVo.getUid());
            d45Var.n(phoneContactVo.getRequestType());
            d45Var.k(phoneContactVo.getNickName());
            d45Var.i(phoneContactVo.getLocalName());
            d45Var.m(phoneContactVo.getRecommendText());
            d45Var.j(phoneContactVo.getLocalNameFirstPinyin());
            d45Var.l(phoneContactVo);
            try {
                if (!TextUtils.isEmpty(d45Var.d())) {
                    this.I.a(d45Var.d().toLowerCase(), d45Var);
                }
                if (!TextUtils.isEmpty(d45Var.b())) {
                    this.I.a(d45Var.b().toLowerCase(), d45Var);
                }
                if (!TextUtils.isEmpty(d45Var.f())) {
                    this.I.a(d45Var.f().toLowerCase(), d45Var);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void y2() {
        this.M.setEmptyView(this.T);
    }

    public final void z2(ArrayList<PhoneContactVo> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (PhoneContactVo phoneContactVo : arrayList) {
            if (!this.J.containsKey(phoneContactVo.getUid()) || phoneContactVo.getSortId() == -1) {
                this.J.put(phoneContactVo.getUid(), Integer.valueOf(phoneContactVo.generateSortId()));
            } else if (!bo0.r().w(phoneContactVo.getUid()) || phoneContactVo.getSortId() >= 200) {
                phoneContactVo.setSortId(this.J.get(phoneContactVo.getUid()).intValue());
            } else {
                this.J.put(phoneContactVo.getUid(), Integer.valueOf(phoneContactVo.generateSortId()));
            }
        }
        Collections.sort(arrayList, new f());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class z implements TextWatcher {
        public z() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            try {
                RecommendFriendsActivity.this.w2();
            } catch (Exception e) {
                e.printStackTrace();
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
}
