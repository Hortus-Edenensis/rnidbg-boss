package com.zenmen.palmchat.contacts.invite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.d;
import com.zenmen.palmchat.contacts.invite.a;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ao0;
import defpackage.ds0;
import defpackage.g13;
import defpackage.h92;
import defpackage.hx3;
import defpackage.jk2;
import defpackage.k86;
import defpackage.of5;
import defpackage.on0;
import defpackage.ou2;
import defpackage.pf5;
import defpackage.qm5;
import defpackage.rb3;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.vh4;
import defpackage.vn0;
import defpackage.zh;
import defpackage.zn6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.webplatform.jssdk.ContactPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ContactInviteFriendsActivity extends BaseActionBarActivity {
    public SharedPreferences A;
    public String B;
    public h92 G;
    public pf5 H;
    public ContentObserver J;
    public View q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ListView u;
    public View v;
    public View w;
    public com.zenmen.palmchat.contacts.invite.a x;
    public HashMap<String, PhoneContactVo> y = new HashMap<>();
    public ArrayList<PhoneContactVo> z = new ArrayList<>();
    public String C = BaseWrapper.ENTER_ID_OAPS_DEMO;
    public boolean E = false;
    public boolean F = false;
    public n I = new n(this);
    public long K = 0;
    public List<String> L = new ArrayList();
    public long M = 0;
    public boolean N = false;
    public boolean O = false;
    public boolean P = false;
    public boolean Q = false;
    public a.b R = new j();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            try {
                LogUtil.i(BaseActionBarActivity.TAG, "getInviteList response=" + jSONObject.toString());
                int i = jSONObject.getInt("resultCode");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (i == 0 && jSONObjectOptJSONObject != null && ContactInviteFriendsActivity.this.y != null) {
                    ContactInviteFriendsActivity.this.z.clear();
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("contacts");
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                        String strOptString = jSONObject2.optString("encryptPhone");
                        String strOptString2 = jSONObject2.optString("md5Phone");
                        String strOptString3 = jSONObject2.optString("text");
                        PhoneContactVo phoneContactVo = (PhoneContactVo) ContactInviteFriendsActivity.this.y.get(strOptString2);
                        if (phoneContactVo != null && !TextUtils.isEmpty(phoneContactVo.getLocalPhone())) {
                            PhoneContactVo phoneContactVo2 = new PhoneContactVo();
                            if (TextUtils.isEmpty(phoneContactVo.getLocalName())) {
                                phoneContactVo2.setLocalName(phoneContactVo.getLocalPhone());
                            } else {
                                phoneContactVo2.setLocalName(phoneContactVo.getLocalName());
                            }
                            phoneContactVo2.setRecommendText(strOptString3);
                            phoneContactVo2.setMd5Phone(strOptString2);
                            phoneContactVo2.setEncryptPhone(strOptString);
                            phoneContactVo2.setLocalPhone(phoneContactVo.getLocalPhone());
                            ContactInviteFriendsActivity.this.z.add(phoneContactVo2);
                        }
                    }
                }
                ContactInviteFriendsActivity.this.m2();
                ContactInviteFriendsActivity.this.hideBaseProgressBar();
                if (ContactInviteFriendsActivity.this.z.size() == 0) {
                    ContactInviteFriendsActivity.this.i2();
                } else {
                    ContactInviteFriendsActivity.this.r.setVisibility(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ContactInviteFriendsActivity.this.hideBaseProgressBar();
            ContactInviteFriendsActivity.this.i2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f13593a;

        public c(List list) {
            this.f13593a = list;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            JSONObject jSONObject2;
            ContactInviteFriendsActivity.this.hideBaseProgressBar();
            if (ContactInviteFriendsActivity.this.isFinishing()) {
                return;
            }
            try {
                if (jSONObject.getInt("resultCode") == 0 && (jSONObject2 = jSONObject.getJSONObject("data")) != null) {
                    String string = jSONObject2.getString("msg");
                    if (!TextUtils.isEmpty(string)) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (PhoneContactVo phoneContactVo : this.f13593a) {
                            arrayList.add(phoneContactVo.getMd5Phone());
                            arrayList2.add(phoneContactVo.getLocalPhone());
                        }
                        ContactInviteFriendsActivity.this.f2(arrayList);
                        StringBuilder sb = new StringBuilder((String) arrayList2.get(0));
                        for (int i = 1; i < arrayList2.size(); i++) {
                            sb.append(x.aQ);
                            sb.append((String) arrayList2.get(i));
                        }
                        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + ((Object) sb)));
                        intent.putExtra("sms_body", string);
                        ContactInviteFriendsActivity.this.startActivityForResult(intent, 101);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sy5.e(ContactInviteFriendsActivity.this, R.string.default_response_error, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ContactInviteFriendsActivity.this.hideBaseProgressBar();
            sy5.e(ContactInviteFriendsActivity.this, R.string.default_response_error, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            try {
                PhoneContactVo phoneContactVo = (PhoneContactVo) adapterView.getItemAtPosition(i);
                if (ContactInviteFriendsActivity.this.O) {
                    ContactInviteFriendsActivity.this.x.e(phoneContactVo);
                    ContactInviteFriendsActivity.this.k2();
                } else {
                    Intent intent = new Intent(ContactInviteFriendsActivity.this, (Class<?>) InviteDetailActivity.class);
                    intent.putExtra("phone_contact_md5_phone", phoneContactVo.getMd5Phone());
                    intent.putExtra("phone_contact_local_name", phoneContactVo.getLocalName());
                    intent.putExtra("phone_contact_local_phone", phoneContactVo.getLocalPhone());
                    ContactInviteFriendsActivity.this.startActivityForResult(intent, 100);
                    LogUtil.i("logsms", "list: goto detail --> phone = " + phoneContactVo.getMd5Phone());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ContactInviteFriendsActivity.this.startActivity(on0.a("upload_contact_from_invite_friends"));
            LogUtil.onImmediateClickEvent("invite_312", null, null);
            ContactInviteFriendsActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivityPermissionDispatcher.b(ContactInviteFriendsActivity.this, BaseActivityPermissionDispatcher.PermissionType.CONTACT, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT);
            zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_permission_2", null, null);
            LogUtil.onImmediateClickEvent("invite_21", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            for (PhoneContactVo phoneContactVo : ContactInviteFriendsActivity.this.x.c().keySet()) {
                if (ContactInviteFriendsActivity.this.x.c().get(phoneContactVo).booleanValue()) {
                    arrayList.add(phoneContactVo);
                }
            }
            if (arrayList.size() < 1) {
                return;
            }
            ContactInviteFriendsActivity.this.h2(arrayList);
            JSONObject jSONObject = new JSONObject();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(((PhoneContactVo) arrayList.get(0)).getMd5Phone());
                for (int i = 1; i < arrayList.size(); i++) {
                    sb.append(",");
                    sb.append(((PhoneContactVo) arrayList.get(i)).getMd5Phone());
                }
                jSONObject.put("tphone", sb);
                jSONObject.put("invite_count", arrayList.size());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("newinvite_3", null, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends ContentObserver {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ContactInviteFriendsActivity.this.K > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - ContactInviteFriendsActivity.this.M;
                    if ((ContactInviteFriendsActivity.this.N || jCurrentTimeMillis <= 3000) && ContactInviteFriendsActivity.this.L.size() > 0) {
                        LogUtil.i("logsms", "list: send success");
                        Iterator it = ContactInviteFriendsActivity.this.L.iterator();
                        while (it.hasNext()) {
                            ContactInviteFriendsActivity.this.x.f((String) it.next(), 1L);
                        }
                        ContactInviteFriendsActivity.this.x.notifyDataSetChanged();
                        ContactInviteFriendsActivity.this.O = false;
                        ContactInviteFriendsActivity.this.l2();
                        sy5.e(ContactInviteFriendsActivity.this, R.string.sent, 0).g();
                        if (ContactInviteFriendsActivity.this.L.size() == 1) {
                            ds0.a().b(new of5((String) ContactInviteFriendsActivity.this.L.get(0), 2));
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append((String) ContactInviteFriendsActivity.this.L.get(0));
                            for (int i = 1; i < ContactInviteFriendsActivity.this.L.size(); i++) {
                                sb.append(",");
                                sb.append((String) ContactInviteFriendsActivity.this.L.get(i));
                            }
                            jSONObject.put("tphone", sb);
                            jSONObject.put("send_count", ContactInviteFriendsActivity.this.L.size());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        LogUtil.onImmediateClickEvent("newinvite_4", null, jSONObject.toString());
                    }
                    ContactInviteFriendsActivity.this.K = 0L;
                    ContactInviteFriendsActivity.this.L.clear();
                }
            }
        }

        public i(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (uri == null) {
                return;
            }
            Matcher matcher = Pattern.compile("content://sms/recents").matcher(uri.toString());
            ContactInviteFriendsActivity contactInviteFriendsActivity = ContactInviteFriendsActivity.this;
            contactInviteFriendsActivity.P = matcher.matches() | contactInviteFriendsActivity.P;
            ContactInviteFriendsActivity.this.Q |= uri.toString().contains("content://sms/conversations");
            if (!Pattern.compile("content://sms/[0-9]+$").matcher(uri.toString()).matches()) {
                LogUtil.i("logsms", "onChange, ignore -> uri = " + uri);
                return;
            }
            if (vh4.a() && !ContactInviteFriendsActivity.this.P) {
                LogUtil.i("logsms", "onChange, vivo ignore -> uri = " + uri);
                return;
            }
            if (!ContactInviteFriendsActivity.this.Q) {
                LogUtil.i("logsms", "onChange, conversations ignore -> uri = " + uri);
                return;
            }
            LogUtil.i("logsms", "list: onChange -> uri = " + uri);
            ContactInviteFriendsActivity.this.runOnUiThread(new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements a.b {
        public j() {
        }

        @Override // com.zenmen.palmchat.contacts.invite.a.b
        public void a(PhoneContactVo phoneContactVo) {
            if (TextUtils.isEmpty(phoneContactVo.getLocalPhone())) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tphone", phoneContactVo.getMd5Phone());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onImmediateClickEvent("newinvite_1", null, jSONObject.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(phoneContactVo);
            ContactInviteFriendsActivity.this.h2(arrayList);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogUtil.onImmediateClickEvent(ContactInviteFriendsActivity.this.O ? "newinvite_32" : "newinvite_31", null, null);
            ContactInviteFriendsActivity.this.O = !r2.O;
            ContactInviteFriendsActivity.this.l2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends jk2 {
        public l() {
        }

        @Override // defpackage.jk2
        public void c(int i, Cursor cursor) {
            super.c(i, cursor);
            if (i == 10) {
                if (!ContactRequestsVO.buildFromCursorForShow(cursor).isEmpty() && System.currentTimeMillis() - ContactInviteFriendsActivity.this.A.getLong(k86.q(), 0L) <= 259200000) {
                    ContactInviteFriendsActivity.this.a2();
                    return;
                }
                o oVar = new o(new WeakReference(ContactInviteFriendsActivity.this));
                if (ao0.f()) {
                    com.zenmen.palmchat.contacts.d.j().v(oVar, ContactInviteFriendsActivity.this.C);
                } else {
                    com.zenmen.palmchat.contacts.d.j().u(oVar);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactInviteFriendsActivity.this.y = com.zenmen.palmchat.contacts.d.j().n();
            ContactInviteFriendsActivity.this.I.sendEmptyMessageDelayed(0, 0L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<ContactInviteFriendsActivity> f13605a;

        public n(ContactInviteFriendsActivity contactInviteFriendsActivity) {
            this.f13605a = new WeakReference<>(contactInviteFriendsActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && this.f13605a.get() != null) {
                this.f13605a.get().showBaseProgressBar(R.string.text_getting_phone_contact, false);
                this.f13605a.get().b2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<ContactInviteFriendsActivity> f13606a;

        public o(WeakReference<ContactInviteFriendsActivity> weakReference) {
            this.f13606a = weakReference;
        }

        @Override // com.zenmen.palmchat.contacts.d.c
        public void onFinished(HashMap<String, PhoneContactVo> map) {
            ContactInviteFriendsActivity contactInviteFriendsActivity = this.f13606a.get();
            if (contactInviteFriendsActivity != null) {
                contactInviteFriendsActivity.n2(map);
            }
        }
    }

    public final void a2() {
        new g13(new m()).start();
    }

    public final void b2() {
        h92 h92Var = new h92(new a(), new b());
        this.G = h92Var;
        try {
            h92Var.n(this.B);
        } catch (Exception e2) {
            hideBaseProgressBar();
            i2();
            e2.printStackTrace();
        }
    }

    public final void c2() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.contact_invite_friends_title);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.contact_invite_friends_title);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        this.r = textView;
        textView.setText(R.string.contact_invite_select);
        this.r.setVisibility(8);
        this.r.setOnClickListener(new k());
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void d2() {
        this.t = (TextView) findViewById(R.id.notice_text);
        this.v = findViewById(R.id.action_textview);
        this.w = findViewById(R.id.action_layout);
        ListView listView = (ListView) findViewById(R.id.contacts_list);
        this.u = listView;
        listView.setDividerHeight(0);
        com.zenmen.palmchat.contacts.invite.a aVar = new com.zenmen.palmchat.contacts.invite.a(this, this.R);
        this.x = aVar;
        this.u.setAdapter((ListAdapter) aVar);
        this.u.setOnItemClickListener(new e());
        this.q = findViewById(R.id.tv_empty_view);
        findViewById(R.id.go_contact).setOnClickListener(new f());
        TextView textView = (TextView) findViewById(R.id.permission_add);
        this.s = textView;
        textView.setOnClickListener(new g());
        this.v.setOnClickListener(new h());
    }

    public final void e2() {
        finish();
    }

    public final void f2(List<String> list) {
        this.P = false;
        this.Q = false;
        this.K = System.currentTimeMillis();
        this.L.clear();
        this.L.addAll(list);
    }

    public final void g2() {
        Uri uri = Uri.parse("content://sms/");
        this.J = new i(new Handler());
        getContentResolver().registerContentObserver(uri, true, this.J);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 205;
    }

    public final void h2(List<PhoneContactVo> list) {
        if (list == null || list.size() < 1) {
            return;
        }
        this.H = new pf5(new c(list), new d());
        try {
            StringBuilder sb = new StringBuilder();
            for (PhoneContactVo phoneContactVo : list) {
                if (!TextUtils.isEmpty(phoneContactVo.getLocalPhone())) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(phoneContactVo.getLocalPhone().replaceAll("-", "").replaceAll(" ", ""));
                }
            }
            this.H.n(sb.toString());
            showBaseProgressBar(R.string.progress_sending, false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void i2() {
        this.u.setEmptyView(this.q);
        LogUtil.uploadInfoImmediate("invite_31", null, null, null);
        this.r.setVisibility(8);
    }

    public final void j2() {
        com.zenmen.palmchat.contacts.d.j().i();
        showBaseProgressBar(R.string.text_getting_phone_contact, false);
        if (hx3.m(AppContext.getContext())) {
            zh.k(AppContext.getContext().getContentResolver()).i(10, new l(), vn0.f21483a, null, "request_type = ?", new String[]{String.valueOf(101)}, null);
        } else {
            i2();
            sy5.e(this, R.string.net_status_unavailable, 1).g();
            hideBaseProgressBar();
        }
    }

    public final void k2() {
        if (!this.O) {
            this.w.setVisibility(8);
            return;
        }
        this.w.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        for (PhoneContactVo phoneContactVo : this.x.c().keySet()) {
            if (this.x.c().get(phoneContactVo).booleanValue()) {
                arrayList.add(phoneContactVo);
            }
        }
        this.v.setEnabled(arrayList.size() > 0);
    }

    public final void l2() {
        this.r.setText(this.O ? R.string.contact_invite_cancel_select : R.string.contact_invite_select);
        this.x.g(this.O);
        k2();
    }

    public final void m2() {
        if (this.z.size() > 0) {
            this.x.h(this.z);
            String strA = ou2.a();
            if (TextUtils.isEmpty(strA)) {
                this.t.setVisibility(8);
            } else {
                this.t.setVisibility(0);
                this.t.setText(strA);
            }
        }
    }

    public void n2(HashMap<String, PhoneContactVo> map) {
        this.y = map;
        this.I.sendEmptyMessageDelayed(0, 0L);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        e2();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_contact_invite_friends);
        getIntent().getStringExtra(ContactPlugin.EXTRA_KEY_FROM);
        this.A = PreferenceManager.getDefaultSharedPreferences(AppContext.getContext());
        this.B = rb3.c(AccountUtils.i(this) + AccountUtils.k(this));
        d2();
        c2();
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.CONTACT;
        if (tg4.b(this, permissionType.permissionList)) {
            onPermissionGrant(permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT, false);
        } else {
            BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT);
            LogUtil.onImmediateClickEvent("invite_2", null, null);
        }
        try {
            g2();
        } catch (Exception unused) {
        }
        ds0.a().c(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideBaseProgressBar();
        pf5 pf5Var = this.H;
        if (pf5Var != null) {
            pf5Var.onCancel();
        }
        this.I.removeMessages(0);
        zh.k(AppContext.getContext().getContentResolver()).a(10);
        if (this.J != null) {
            getContentResolver().unregisterContentObserver(this.J);
        }
        ds0.a().d(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        e2();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.N = true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        findViewById(R.id.permission_fail).setVisibility(0);
        findViewById(R.id.contacts_list_layout).setVisibility(8);
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList[0])) {
            if (this.E) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", getPackageName(), null));
                startActivity(intent);
                this.F = true;
            } else {
                this.E = true;
            }
        }
        zn6.e(AccountUtils.p(AppContext.getContext()), "lx_client_permission_4", null, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        findViewById(R.id.permission_fail).setVisibility(8);
        findViewById(R.id.contacts_list_layout).setVisibility(0);
        j2();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", z ? 2 : 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.onImmediateClickEvent("invite_3", null, jSONObject.toString());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.F) {
            BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.CONTACT;
            if (tg4.b(this, permissionType.permissionList)) {
                onPermissionGrant(permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT, false);
            }
        }
        this.M = System.currentTimeMillis();
        this.N = false;
    }

    @qm5
    public void onSmsEvent(of5 of5Var) {
        if (of5Var == null || of5Var.b() != 1 || TextUtils.isEmpty(of5Var.a())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(of5Var.a());
        f2(arrayList);
    }
}
