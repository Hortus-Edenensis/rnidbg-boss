package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.c;
import com.zenmen.palmchat.contacts.d;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo0;
import defpackage.f7;
import defpackage.g13;
import defpackage.gl0;
import defpackage.hx3;
import defpackage.ih;
import defpackage.il5;
import defpackage.io0;
import defpackage.iq5;
import defpackage.ir5;
import defpackage.jo6;
import defpackage.k86;
import defpackage.l16;
import defpackage.li4;
import defpackage.m66;
import defpackage.n92;
import defpackage.pn5;
import defpackage.rb3;
import defpackage.rx4;
import defpackage.sy5;
import defpackage.z31;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.webplatform.jssdk.ContactPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PhoneContactActivity extends BaseActionBarActivity {
    public static final String P = "PhoneContactActivity";
    public String A;
    public HashMap<String, PhoneContactVo> B;
    public f7 G;
    public ih H;
    public n92 I;
    public SharedPreferences K;
    public PhoneContactVo N;
    public TextView q;
    public ImageView r;
    public EditText s;
    public ListView u;
    public com.zenmen.palmchat.contacts.c v;
    public l16 w;
    public TextView x;
    public pn5<PhoneContactVo> y;
    public boolean t = false;
    public ArrayList<PhoneContactVo> z = new ArrayList<>();
    public HashMap<String, PhoneContactVo> C = new HashMap<>();
    public int E = 0;
    public int F = 0;
    public int J = -1;
    public boolean L = false;
    public o M = new o(this);
    public c.b O = new j();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<PhoneContactVo> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContactVo phoneContactVo, PhoneContactVo phoneContactVo2) {
            return phoneContactVo.getLocalNameFirstPinyin().compareTo(phoneContactVo2.getLocalNameFirstPinyin());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strE = PhoneContactActivity.this.w.e(k86.r(), "");
            if (TextUtils.isEmpty(strE) || TextUtils.isEmpty(strE.substring(1, strE.length() - 1))) {
                if (hx3.m(AppContext.getContext())) {
                    return;
                }
                sy5.e(PhoneContactActivity.this, R.string.net_status_unavailable, 1).g();
            } else {
                try {
                    PhoneContactActivity.this.i2(PhoneContactVo.buildListFromJson(new JSONArray(strE)), false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhoneContactActivity.this.B = com.zenmen.palmchat.contacts.d.j().n();
            PhoneContactActivity.this.M.sendEmptyMessageDelayed(0, 0L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhoneContactActivity.this.f2(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13406a;
        public final /* synthetic */ PhoneContactVo b;
        public final /* synthetic */ ContactRequestArgs c;

        public f(String str, PhoneContactVo phoneContactVo, ContactRequestArgs contactRequestArgs) {
            this.f13406a = str;
            this.b = phoneContactVo;
            this.c = contactRequestArgs;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                PhoneContactActivity.this.hideBaseProgressBar();
                if (PhoneContactActivity.this.N != null) {
                    Iterator it = PhoneContactActivity.this.z.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PhoneContactVo phoneContactVo = (PhoneContactVo) it.next();
                        if (phoneContactVo.getUid().equals(PhoneContactActivity.this.N.getUid())) {
                            phoneContactVo.setIsFriend(0);
                            PhoneContactActivity.this.v.e(PhoneContactActivity.this.z);
                            break;
                        }
                    }
                }
                iq5.j(false, new String[0]);
                return;
            }
            if (iOptInt == 1) {
                PhoneContactActivity.this.U1(this.f13406a, this.b, this.c);
                return;
            }
            if (iOptInt == 1318) {
                PhoneContactActivity.this.hideBaseProgressBar();
                sy5.e(PhoneContactActivity.this, R.string.send_refuse, 1).g();
            } else if (iOptInt == 1320 || iOptInt == 1321) {
                PhoneContactActivity.this.hideBaseProgressBar();
                rx4.b(PhoneContactActivity.this, jSONObject);
            } else {
                PhoneContactActivity.this.hideBaseProgressBar();
                sy5.f(PhoneContactActivity.this, rx4.a(jSONObject), 0).g();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.ErrorListener {
        public g() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            PhoneContactActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {
        public h() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            PhoneContactActivity.this.hideBaseProgressBar();
            LogUtil.d(PhoneContactActivity.P, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneContactVo f13409a;

        public i(PhoneContactVo phoneContactVo) {
            this.f13409a = phoneContactVo;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            PhoneContactActivity.this.hideBaseProgressBar();
            rx4.b(PhoneContactActivity.this, jSONObject);
            this.f13409a.setApplyFriendTime(ir5.b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements c.b {
        public j() {
        }

        @Override // com.zenmen.palmchat.contacts.c.b
        public void a(PhoneContactVo phoneContactVo) {
            PhoneContactActivity.this.N = phoneContactVo;
            phoneContactVo.setIsClicked(true);
            PhoneContactActivity.this.v.notifyDataSetChanged();
            PhoneContactActivity.this.S1(phoneContactVo.getUid(), phoneContactVo);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements AdapterView.OnItemClickListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PhoneContactItem phoneContactItem;
            PhoneContactVo phoneContactVo = (PhoneContactVo) adapterView.getItemAtPosition(i);
            PhoneContactActivity.this.N = phoneContactVo;
            Intent intent = new Intent(PhoneContactActivity.this, (Class<?>) m66.c());
            intent.putExtra("user_item_info", phoneContactVo);
            intent.putExtra("from", 9);
            String md5Phone = phoneContactVo.getMd5Phone();
            if (!TextUtils.isEmpty(md5Phone) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(md5Phone)) != null) {
                intent.putExtra("user_detail_local_phone_number", phoneContactItem.y());
            }
            PhoneContactActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f13412a;

        public l(ArrayList arrayList) {
            this.f13412a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13412a != null) {
                PhoneContactActivity.this.y = new gl0(new z31());
                for (int i = 0; i < this.f13412a.size(); i++) {
                    PhoneContactVo phoneContactVo = (PhoneContactVo) this.f13412a.get(i);
                    if (phoneContactVo != null) {
                        if (!TextUtils.isEmpty(phoneContactVo.getLocalName())) {
                            PhoneContactActivity.this.y.a(phoneContactVo.getLocalName(), phoneContactVo);
                        }
                        if (!TextUtils.isEmpty(phoneContactVo.getNickName())) {
                            PhoneContactActivity.this.y.a(phoneContactVo.getNickName(), phoneContactVo);
                        }
                        if (!TextUtils.isEmpty(phoneContactVo.getFirstPinyin())) {
                            PhoneContactActivity.this.y.a(phoneContactVo.getFirstPinyin().toLowerCase(), phoneContactVo);
                        }
                        if (!TextUtils.isEmpty(phoneContactVo.getAllPinyin())) {
                            PhoneContactActivity.this.y.a(phoneContactVo.getAllPinyin().toLowerCase(), phoneContactVo);
                        }
                        if (!TextUtils.isEmpty(phoneContactVo.getLocalNameFirstPinyin())) {
                            PhoneContactActivity.this.y.a(phoneContactVo.getLocalNameFirstPinyin().toLowerCase(), phoneContactVo);
                        }
                        if (!TextUtils.isEmpty(phoneContactVo.getLocalNameAllPinyin())) {
                            PhoneContactActivity.this.y.a(phoneContactVo.getLocalNameAllPinyin().toLowerCase(), phoneContactVo);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f13413a;

        public m(long j) {
            this.f13413a = j;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.i(PhoneContactActivity.P, "getContact response=" + jSONObject.toString());
            LogUtil.i("calculate", "pulltime: " + (System.currentTimeMillis() - this.f13413a));
            try {
                if (jSONObject.getInt("resultCode") != 0) {
                    PhoneContactActivity.this.h2();
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    PhoneContactActivity.this.h2();
                    return;
                }
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("contacts");
                if (jSONArrayOptJSONArray != null) {
                    PhoneContactActivity.this.T1(PhoneContactVo.buildListFromJson(jSONArrayOptJSONArray));
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("continueFlag");
                PhoneContactActivity.this.E = jSONObjectOptJSONObject.optInt("nextIndex");
                int iOptInt2 = jSONObjectOptJSONObject.optInt("waitingTime");
                if (iOptInt != 1 || iOptInt2 <= 0) {
                    PhoneContactActivity.this.h2();
                } else {
                    PhoneContactActivity.this.M.sendEmptyMessageDelayed(0, iOptInt2);
                }
            } catch (JSONException e) {
                PhoneContactActivity.this.h2();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements Response.ErrorListener {
        public n() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i(PhoneContactActivity.P, "error=" + volleyError.toString());
            PhoneContactActivity.this.h2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<PhoneContactActivity> f13415a;

        public o(PhoneContactActivity phoneContactActivity) {
            this.f13415a = new WeakReference<>(phoneContactActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0 || this.f13415a.get() == null || this.f13415a.get().isFinishing()) {
                return;
            }
            if (this.f13415a.get().E == 0) {
                this.f13415a.get().showBaseProgressBar(R.string.text_getting_phone_contact, false);
            }
            this.f13415a.get().X1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<PhoneContactActivity> f13416a;

        public p(WeakReference<PhoneContactActivity> weakReference) {
            this.f13416a = weakReference;
        }

        @Override // com.zenmen.palmchat.contacts.d.c
        public void onFinished(HashMap<String, PhoneContactVo> map) {
            PhoneContactActivity phoneContactActivity = this.f13416a.get();
            if (phoneContactActivity != null) {
                phoneContactActivity.j2(map);
            }
        }
    }

    public final void S1(String str, PhoneContactVo phoneContactVo) {
        if (str == null) {
            return;
        }
        String strM = "";
        if (jo6.i() && io0.t(3) && !TextUtils.isEmpty(phoneContactVo.getMd5Phone())) {
            ContactInfoItem contactInfoItemL = bo0.r().l(str);
            if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(phoneContactVo.getMd5Phone());
                if (phoneContactItem != null) {
                    strM = phoneContactItem.m();
                }
            } else {
                strM = contactInfoItemL.getRemarkName();
            }
        }
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(ContactRequestArgs.c(phoneContactVo)).i(String.valueOf(3)).j(String.valueOf(this.J)).g(strM).a();
        f7 f7Var = new f7(new f(str, phoneContactVo, contactRequestArgsA), new g());
        this.G = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
            showBaseProgressBar(R.string.progress_sending, false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void T1(ArrayList<PhoneContactVo> arrayList) {
        if (arrayList != null) {
            for (PhoneContactVo phoneContactVo : arrayList) {
                if (phoneContactVo != null && phoneContactVo.getUid() != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.z.size()) {
                            break;
                        }
                        if (this.z.get(i2).getUid().equals(phoneContactVo.getUid())) {
                            phoneContactVo.setApplyFriendTime(this.z.get(i2).getApplyFriendTime());
                            phoneContactVo.setCycleShowTime(this.z.get(i2).getCycleShowTime());
                            phoneContactVo.setSendTime(this.z.get(i2).getSendTime());
                            break;
                        }
                        i2++;
                    }
                    if (phoneContactVo.getSendTime() == 0) {
                        phoneContactVo.setSendTime(ir5.b());
                    }
                    this.C.put(phoneContactVo.getUid(), phoneContactVo);
                }
            }
        }
    }

    public final void U1(String str, PhoneContactVo phoneContactVo, ContactRequestArgs contactRequestArgs) {
        h hVar = new h();
        i iVar = new i(phoneContactVo);
        if (this.H == null) {
            this.H = new ih(iVar, hVar);
        }
        try {
            this.H.r(contactRequestArgs);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final void V1() {
        this.w.a(k86.n(), false);
        com.zenmen.palmchat.contacts.d.j().i();
        e2();
    }

    public final void W1() {
        new g13(new c()).start();
    }

    public final void X1() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.F >= 200) {
            h2();
            return;
        }
        n92 n92Var = new n92(new m(jCurrentTimeMillis), new n());
        this.I = n92Var;
        try {
            n92Var.n(this.A, this.E, false);
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        this.F++;
    }

    public final void Y1(ArrayList<PhoneContactVo> arrayList) {
        this.M.post(new l(arrayList));
    }

    public final void Z1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        TextView textView = (TextView) findViewById(R.id.title);
        this.q = textView;
        textView.setText(R.string.check_phone_contacts);
        ImageView imageView = (ImageView) findViewById(R.id.searchIcon);
        this.r = imageView;
        imageView.setOnClickListener(new d());
        EditText editText = (EditText) findViewById(R.id.searchInput);
        this.s = editText;
        editText.addTextChangedListener(new e());
        f2(false);
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void a2() {
        this.K = PreferenceManager.getDefaultSharedPreferences(AppContext.getContext());
        this.x = (TextView) findViewById(R.id.no_zx_contact_view);
        ListView listView = (ListView) findViewById(R.id.contacts_list);
        this.u = listView;
        listView.setEmptyView(findViewById(R.id.empty_view));
        com.zenmen.palmchat.contacts.c cVar = new com.zenmen.palmchat.contacts.c(this, this.O);
        this.v = cVar;
        this.u.setAdapter((ListAdapter) cVar);
        this.u.setOnItemClickListener(new k());
    }

    public final void b2() {
        String stringExtra;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(ContactPlugin.EXTRA_KEY_FROM);
            if (!TextUtils.isEmpty(string) && string.equals(ContactPlugin.EXTRA_KEY_FROM_H5)) {
                LogUtil.uploadInfoImmediate("231", null, null, null);
                this.J = 1;
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
            }
        }
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra(ContactPlugin.EXTRA_KEY_FROM)) == null) {
            return;
        }
        if (stringExtra.equals("upload_contact_from_thread")) {
            this.J = 2;
            return;
        }
        if (stringExtra.equals("upload_contact_from_nearby")) {
            this.J = 3;
            return;
        }
        if (stringExtra.equals("upload_contact_from_menu")) {
            this.J = 4;
            return;
        }
        if (stringExtra.equals("upload_contact_from_newcontact")) {
            this.J = 5;
        } else if (stringExtra.equals("upload_contact_from_discover")) {
            this.J = 7;
        } else if (stringExtra.equals("upload_contact_from_ACCOUNT")) {
            this.J = 8;
        }
    }

    public final void c2() {
        ArrayList<PhoneContactVo> arrayList = new ArrayList<>();
        String strQ = il5.q(this.s.getText().toString().toLowerCase());
        if (TextUtils.isEmpty(strQ)) {
            arrayList.addAll(this.z);
        } else {
            pn5<PhoneContactVo> pn5Var = this.y;
            if (pn5Var != null) {
                for (PhoneContactVo phoneContactVo : pn5Var.b(strQ)) {
                    if (!arrayList.contains(phoneContactVo)) {
                        arrayList.add(phoneContactVo);
                    }
                }
            }
        }
        d2(arrayList);
        this.v.e(arrayList);
    }

    public final void d2(ArrayList<PhoneContactVo> arrayList) {
        Collections.sort(arrayList, new a());
    }

    public final void e2() {
        showBaseProgressBar(R.string.text_getting_phone_contact, false);
        this.M.post(new b());
        if (!hx3.m(AppContext.getContext())) {
            hideBaseProgressBar();
            return;
        }
        String strE = this.w.e(k86.r(), "");
        if (!TextUtils.isEmpty(strE) && !TextUtils.isEmpty(strE.substring(1, strE.length() - 1))) {
            this.L = true;
        }
        if (System.currentTimeMillis() - this.K.getLong(k86.q(), 0L) <= 259200000 && this.L) {
            W1();
        } else {
            com.zenmen.palmchat.contacts.d.j().u(new p(new WeakReference(this)));
        }
    }

    public final void f2(boolean z) {
        if (z) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(0);
            this.s.requestFocus();
        } else {
            this.q.setVisibility(0);
            this.r.setVisibility(0);
            this.s.setVisibility(8);
            this.s.setText((CharSequence) null);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.s.getWindowToken(), 0);
        }
        this.t = z;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (this.t) {
            f2(false);
        } else {
            super.finish();
        }
    }

    public final void g2(HashMap<String, PhoneContactVo> map) {
        ArrayList<PhoneContactVo> arrayList = new ArrayList<>();
        if (map != null && this.B != null) {
            Iterator<Map.Entry<String, PhoneContactVo>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                PhoneContactVo value = it.next().getValue();
                PhoneContactVo phoneContactVo = this.B.get(value.getMd5Phone());
                if (phoneContactVo != null) {
                    value.setLocalName(phoneContactVo.getLocalName());
                    value.setLocalNameFirstPinyin(li4.a(phoneContactVo.getLocalName()));
                    value.setLocalNameAllPinyin(li4.b(phoneContactVo.getLocalName()));
                    arrayList.add(value);
                }
            }
        }
        i2(arrayList, true);
    }

    public final void h2() {
        hideBaseProgressBar();
        g2(this.C);
    }

    public final void i2(ArrayList<PhoneContactVo> arrayList, boolean z) {
        d2(arrayList);
        this.z.clear();
        this.z.addAll(arrayList);
        Y1(this.z);
        this.v.e(this.z);
        if (z && this.z.size() == 0) {
            this.x.setVisibility(0);
        }
        LogUtil.i(P, "updateUiOnDataReady size =" + this.z.size());
    }

    public void j2(HashMap<String, PhoneContactVo> map) {
        if (isFinishing()) {
            return;
        }
        this.B = map;
        this.M.sendEmptyMessageDelayed(0, 0L);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            this.N.setApplyFriendTime(ir5.b());
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.w = AppContext.getContext().getTrayPreferences();
        this.A = rb3.c(AccountUtils.i(this) + AccountUtils.k(this));
        setContentView(R.layout.layout_activity_phone_contact);
        b2();
        a2();
        Z1();
        V1();
        LogUtil.i(P, "old mSubtype: " + this.J);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideBaseProgressBar();
        f7 f7Var = this.G;
        if (f7Var != null) {
            f7Var.onCancel();
        }
        ih ihVar = this.H;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        n92 n92Var = this.I;
        if (n92Var != null) {
            n92Var.onCancel();
        }
        this.M.removeMessages(0);
        this.w.h(k86.r(), PhoneContactVo.genJsonStringFromList(this.z));
        bo0.r().i().l(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.N != null) {
            ContactInfoItem contactInfoItemL = bo0.r().l(this.N.getUid());
            if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                for (PhoneContactVo phoneContactVo : this.z) {
                    if (phoneContactVo.getUid().equals(this.N.getUid())) {
                        phoneContactVo.setIsFriend(1);
                        this.v.e(this.z);
                        return;
                    }
                }
                return;
            }
            for (PhoneContactVo phoneContactVo2 : this.z) {
                if (phoneContactVo2.getUid().equals(this.N.getUid())) {
                    phoneContactVo2.setIsFriend(0);
                    this.v.e(this.z);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PhoneContactActivity.this.c2();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
