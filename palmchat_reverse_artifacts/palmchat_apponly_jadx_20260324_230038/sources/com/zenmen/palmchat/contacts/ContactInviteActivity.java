package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.openalliance.ad.constant.x;
import com.squareup.okhttp.internal.Base64;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.contacts.d;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.CharIndexView;
import defpackage.gl0;
import defpackage.hx3;
import defpackage.i92;
import defpackage.il5;
import defpackage.k86;
import defpackage.pn5;
import defpackage.tg4;
import defpackage.ug4;
import defpackage.z31;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ContactInviteActivity extends BaseActionBarActivity implements CharIndexView.a {
    public static final String M = "ContactInviteActivity";
    public i92 B;
    public ImageView C;
    public EditText E;
    public ListView F;
    public com.zenmen.palmchat.contacts.a G;
    public CharIndexView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public int q;
    public String r;
    public String s;
    public String t;
    public String u;
    public pn5<Integer> z;
    public int v = 0;
    public int w = 0;
    public ArrayList<j> x = new ArrayList<>();
    public ArrayList<j> y = new ArrayList<>();
    public HashMap<Character, Integer> A = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ContactInviteActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            j jVar = (j) ContactInviteActivity.this.G.getItem(i);
            boolean zE = jVar.e();
            jVar.j(!zE);
            ContactInviteActivity.this.G.notifyDataSetChanged();
            if (zE) {
                ContactInviteActivity.this.y.remove(jVar);
            } else {
                ContactInviteActivity.this.y.add(jVar);
            }
            if (zE) {
                ContactInviteActivity.this.v--;
            } else {
                ContactInviteActivity.this.v++;
            }
            TextView textView = ContactInviteActivity.this.J;
            ContactInviteActivity contactInviteActivity = ContactInviteActivity.this;
            textView.setText(contactInviteActivity.getString(R.string.contact_selected_num, Integer.valueOf(contactInviteActivity.v), Integer.valueOf(ContactInviteActivity.this.w)));
            ContactInviteActivity.this.L.setEnabled(ContactInviteActivity.this.v > 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ContactInviteActivity.this.v > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("redId", ContactInviteActivity.this.u);
                    jSONObject.put("count", ContactInviteActivity.this.v);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("AM406", null, null, jSONObject.toString());
                if (ContactInviteActivity.this.q == 1) {
                    String str = "";
                    for (int i = 0; i < ContactInviteActivity.this.y.size(); i++) {
                        str = str + ((j) ContactInviteActivity.this.y.get(i)).c() + x.aQ;
                    }
                    ContactInviteActivity.this.S1(str);
                }
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < ContactInviteActivity.this.y.size(); i2++) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("phone", ((j) ContactInviteActivity.this.y.get(i2)).c());
                        jSONObject2.put("name", ((j) ContactInviteActivity.this.y.get(i2)).b());
                        jSONArray.put(jSONObject2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                Intent intent = new Intent();
                intent.putExtra("contacts", jSONArray.toString());
                ContactInviteActivity.this.setResult(-1, intent);
                ContactInviteActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {
        public f() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(ContactInviteActivity.M, "getContacts()--error: " + volleyError.toString());
            ContactInviteActivity.this.S1("");
            ContactInviteActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {
        public g() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(ContactInviteActivity.M, "getContacts()--response: " + jSONObject.toString());
            if (jSONObject.optInt("resultCode") != 0) {
                ContactInviteActivity.this.S1("");
                ContactInviteActivity.this.finish();
                return;
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                int length = jSONArray.length();
                if (length == 0) {
                    ContactInviteActivity.this.S1("");
                    ContactInviteActivity.this.finish();
                    return;
                }
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    j jVar = ContactInviteActivity.this.new j();
                    jVar.g(jSONObject2.optString("name"));
                    jVar.i(jSONObject2.optString("pinyin"));
                    jVar.f(jSONObject2.optString("ic"));
                    String strOptString = jSONObject2.optString("phone");
                    if (!TextUtils.isEmpty(strOptString)) {
                        try {
                            strOptString = new String(EncryptUtils.decryptAes(Base64.decode(strOptString.getBytes())));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    jVar.h(strOptString);
                    ContactInviteActivity.this.x.add(jVar);
                }
                ContactInviteActivity contactInviteActivity = ContactInviteActivity.this;
                contactInviteActivity.U1(contactInviteActivity.x);
                ContactInviteActivity.this.G.b(ContactInviteActivity.this.x);
                ContactInviteActivity contactInviteActivity2 = ContactInviteActivity.this;
                contactInviteActivity2.Y1(contactInviteActivity2.x);
                ContactInviteActivity contactInviteActivity3 = ContactInviteActivity.this;
                contactInviteActivity3.w = contactInviteActivity3.x.size();
                TextView textView = ContactInviteActivity.this.J;
                ContactInviteActivity contactInviteActivity4 = ContactInviteActivity.this;
                textView.setText(contactInviteActivity4.getString(R.string.contact_selected_num, Integer.valueOf(contactInviteActivity4.v), Integer.valueOf(ContactInviteActivity.this.w)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ug4.l(ContactInviteActivity.this, "android.permission.READ_CONTACTS")) {
                ContactInviteActivity.this.Z1();
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("redId", ContactInviteActivity.this.u);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("AM405", null, null, jSONObject.toString());
            ContactInviteActivity.this.S1("");
            ContactInviteActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements d.c {
        public i() {
        }

        @Override // com.zenmen.palmchat.contacts.d.c
        public void onFinished(HashMap<String, PhoneContactVo> map) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("redId", ContactInviteActivity.this.u);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (map == null || map.size() <= 0) {
                LogUtil.uploadInfoImmediate("AM405", null, null, jSONObject.toString());
                ContactInviteActivity.this.S1("");
                ContactInviteActivity.this.finish();
            } else {
                LogUtil.uploadInfoImmediate("AM404", null, null, jSONObject.toString());
                if (hx3.m(ContactInviteActivity.this)) {
                    ContactInviteActivity.this.T1();
                } else {
                    ContactInviteActivity.this.S1("");
                    ContactInviteActivity.this.finish();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13322a;
        public String b;
        public String c;
        public String d;
        public boolean e = false;

        public j() {
        }

        public String a() {
            return this.d;
        }

        public String b() {
            return this.f13322a;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.b;
        }

        public boolean e() {
            return this.e;
        }

        public void f(String str) {
            this.d = str;
        }

        public void g(String str) {
            this.f13322a = str;
        }

        public void h(String str) {
            this.c = str;
        }

        public void i(String str) {
            this.b = str;
        }

        public void j(boolean z) {
            this.e = z;
        }
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void F0() {
        this.I.setVisibility(8);
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void P0(char c2) {
        int iIntValue;
        this.I.setText(Character.toString(c2));
        if (this.A.get(Character.valueOf(c2)) == null || (iIntValue = this.A.get(Character.valueOf(c2)).intValue()) < 0) {
            return;
        }
        this.F.setSelection(iIntValue);
    }

    public final void S1(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", this.r);
        startActivity(intent);
    }

    public final void T1() {
        i92 i92Var = new i92(new g(), new f());
        this.B = i92Var;
        try {
            i92Var.n();
        } catch (DaoException e2) {
            e2.printStackTrace();
        }
    }

    public final void U1(ArrayList<j> arrayList) {
        this.A.clear();
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            char cA = com.zenmen.palmchat.contacts.a.a(arrayList.get(i3).d().toUpperCase().charAt(0));
            if (this.A.get(Character.valueOf(cA)) == null) {
                this.A.put(Character.valueOf(cA), Integer.valueOf(i3));
            }
        }
        char c2 = 0;
        while (true) {
            char[] cArr = CharIndexView.charArray;
            if (i2 >= cArr.length) {
                return;
            }
            char c3 = cArr[i2];
            if (this.A.get(Character.valueOf(c3)) != null) {
                c2 = c3;
            } else if (c2 != 0) {
                this.A.put(Character.valueOf(c3), this.A.get(Character.valueOf(c2)));
            }
            i2++;
        }
    }

    public final void V1() {
        ImageView imageView = (ImageView) findViewById(R.id.back_arrow);
        this.C = imageView;
        imageView.setOnClickListener(new a());
        EditText editText = (EditText) findViewById(R.id.search_edit_text);
        this.E = editText;
        editText.addTextChangedListener(new b());
        this.F = (ListView) findViewById(R.id.contacts_list);
        com.zenmen.palmchat.contacts.a aVar = new com.zenmen.palmchat.contacts.a(this, this.x);
        this.G = aVar;
        this.F.setAdapter((ListAdapter) aVar);
        this.F.setOnItemClickListener(new c());
        this.F.setOnScrollListener(new d());
        CharIndexView charIndexView = (CharIndexView) findViewById(R.id.index_view);
        this.H = charIndexView;
        charIndexView.setOnCharacterTouchedListener(this);
        this.I = (TextView) findViewById(R.id.char_indicator);
        this.J = (TextView) findViewById(R.id.tv_send_num);
        this.K = (TextView) findViewById(R.id.tv_send_tip);
        if (TextUtils.isEmpty(this.s)) {
            this.K.setVisibility(8);
        } else {
            this.K.setText(this.s);
        }
        this.L = (TextView) findViewById(R.id.btn_send);
        if (!TextUtils.isEmpty(this.t)) {
            this.L.setText(this.t);
        }
        this.L.setOnClickListener(new e());
    }

    public final void W1() {
        Intent intent = getIntent();
        this.q = intent.getIntExtra("isSend", 0);
        this.r = intent.getStringExtra("content");
        this.s = intent.getStringExtra("title1");
        this.t = intent.getStringExtra("title2");
        this.u = intent.getStringExtra("redId");
    }

    public final void X1(String str) {
        ArrayList<j> arrayList = new ArrayList<>();
        pn5<Integer> pn5Var = this.z;
        if (pn5Var != null) {
            try {
                Iterator<Integer> it = pn5Var.b(str).iterator();
                while (it.hasNext()) {
                    arrayList.add(this.x.get(it.next().intValue()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.G.b(arrayList);
    }

    public final void Y1(ArrayList<j> arrayList) {
        this.z = new gl0(new z31());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            j jVar = arrayList.get(i2);
            try {
                if (!TextUtils.isEmpty(jVar.b())) {
                    this.z.a(jVar.b().toLowerCase() + jVar.c().toLowerCase(), Integer.valueOf(i2));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void Z1() {
        if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
            AppContext.getContext().getTrayPreferences().i(k86.n(), true);
        }
        com.zenmen.palmchat.contacts.d.j().i();
        com.zenmen.palmchat.contacts.d.j().u(new i());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_contact_invite);
        W1();
        V1();
        BaseActivityPermissionDispatcher.PermissionType permissionType = BaseActivityPermissionDispatcher.PermissionType.CONTACT;
        if (tg4.b(this, permissionType.permissionList)) {
            onPermissionGrant(permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT, false);
        } else {
            BaseActivityPermissionDispatcher.b(this, permissionType, BaseActivityPermissionDispatcher.PermissionUsage.CONTACT);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("redId", this.u);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("AM405", null, null, jSONObject.toString());
        S1("");
        finish();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        new Handler().postDelayed(new h(), 100L);
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void r() {
        this.I.setVisibility(0);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String strQ = il5.q(charSequence.toString().toLowerCase());
            if (TextUtils.isEmpty(strQ)) {
                ContactInviteActivity.this.G.b(ContactInviteActivity.this.x);
            } else {
                ContactInviteActivity.this.X1(strQ);
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
    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                ((InputMethodManager) ContactInviteActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(ContactInviteActivity.this.getCurrentFocus().getWindowToken(), 2);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }
}
