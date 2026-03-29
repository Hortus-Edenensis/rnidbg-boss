package com.zenmen.palmchat.activity.search;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.search.c;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.bo0;
import defpackage.f45;
import defpackage.il5;
import defpackage.k86;
import defpackage.m40;
import defpackage.m66;
import defpackage.nn0;
import defpackage.rn3;
import defpackage.sd3;
import defpackage.sy5;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SearchOneTypeContentActivity extends BaseActionBarActivity {
    public static final String G = SearchContentActivity.class.getSimpleName();
    public Toolbar A;
    public com.zenmen.palmchat.activity.search.c B;
    public int C;
    public String E;
    public EditText r;
    public ListView s;
    public rn3 w;
    public com.zenmen.palmchat.activity.search.a x;
    public com.zenmen.palmchat.activity.search.a y;
    public com.zenmen.palmchat.activity.search.a z;
    public HashMap<String, GroupInfoItem> q = new HashMap<>();
    public ArrayList<Object> t = new ArrayList<>();
    public ArrayList<Object> u = new ArrayList<>();
    public ArrayList<Object> v = new ArrayList<>();
    public c.d F = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c.d {
        public a() {
        }

        @Override // com.zenmen.palmchat.activity.search.c.d
        public void a(c.f fVar) {
            if (TextUtils.isEmpty(il5.q(SearchOneTypeContentActivity.this.r.getText().toString().toLowerCase()))) {
                SearchOneTypeContentActivity.this.t.clear();
                SearchOneTypeContentActivity.this.x.notifyDataSetChanged();
                SearchOneTypeContentActivity.this.u.clear();
                SearchOneTypeContentActivity.this.y.notifyDataSetChanged();
                SearchOneTypeContentActivity.this.v.clear();
                SearchOneTypeContentActivity.this.z.notifyDataSetChanged();
                return;
            }
            SearchOneTypeContentActivity.this.t.clear();
            if (fVar.b != null) {
                SearchOneTypeContentActivity.this.t.addAll(fVar.b);
            }
            SearchOneTypeContentActivity.this.x.notifyDataSetChanged();
            SearchOneTypeContentActivity.this.u.clear();
            if (fVar.c != null) {
                SearchOneTypeContentActivity.this.u.addAll(fVar.c.values());
                SearchOneTypeContentActivity.this.y.b(fVar.d);
            }
            SearchOneTypeContentActivity.this.y.notifyDataSetChanged();
            SearchOneTypeContentActivity.this.v.clear();
            if (fVar.e != null) {
                SearchOneTypeContentActivity.this.v.addAll(fVar.e);
                SearchOneTypeContentActivity.this.z.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.e eVar;
            MessageVo messageVo;
            String str;
            Object itemAtPosition = adapterView.getItemAtPosition(i);
            if (itemAtPosition instanceof ContactInfoItem) {
                if (TextUtils.isEmpty(((ContactInfoItem) itemAtPosition).getUid())) {
                    SearchOneTypeContentActivity.this.P1();
                    return;
                }
                if (itemAtPosition != null) {
                    Intent intent = new Intent(SearchOneTypeContentActivity.this, (Class<?>) ChatterActivity.class);
                    intent.putExtra("chat_item", (ContactInfoItem) itemAtPosition);
                    intent.putExtra("chat_need_back_to_main", false);
                    k86.X(intent);
                    SearchOneTypeContentActivity.this.startActivity(intent);
                    return;
                }
                return;
            }
            if (itemAtPosition instanceof GroupInfoItem) {
                if (itemAtPosition != null) {
                    Intent intent2 = new Intent(SearchOneTypeContentActivity.this, (Class<?>) ChatterActivity.class);
                    intent2.putExtra("chat_item", (GroupInfoItem) itemAtPosition);
                    intent2.putExtra("chat_need_back_to_main", false);
                    k86.X(intent2);
                    SearchOneTypeContentActivity.this.startActivity(intent2);
                    return;
                }
                return;
            }
            if (!(itemAtPosition instanceof c.e) || (messageVo = (eVar = (c.e) itemAtPosition).b) == null || (str = messageVo.contactRelate) == null) {
                return;
            }
            ChatItem chatItemL = m40.b(str) == 0 ? bo0.r().l(eVar.b.contactRelate) : (ChatItem) SearchOneTypeContentActivity.this.q.get(m40.d(eVar.b.contactRelate));
            if (chatItemL != null) {
                if (eVar.f12390a != 1) {
                    Intent intent3 = new Intent(SearchOneTypeContentActivity.this, (Class<?>) MessageSearchResultActivity.class);
                    intent3.putExtra("search_text", il5.q(SearchOneTypeContentActivity.this.r.getText().toString()));
                    intent3.putExtra("search_relate_contact", chatItemL);
                    intent3.putExtra("search_relate_contact_string", chatItemL.getChatId());
                    SearchOneTypeContentActivity.this.startActivity(intent3);
                    return;
                }
                Intent intent4 = new Intent(SearchOneTypeContentActivity.this, (Class<?>) ChatterActivity.class);
                intent4.putExtra("chat_item", chatItemL);
                intent4.putExtra("chat_first_message", eVar.b.time);
                intent4.putExtra("chat_first_message_primary_id", eVar.b._id);
                intent4.putExtra("chat_need_back_to_main", false);
                k86.X(intent4);
                SearchOneTypeContentActivity.this.startActivity(intent4);
            }
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
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends MaterialDialog.e {
            public b() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public d() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            SearchOneTypeContentActivity.this.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    Intent intent = new Intent(SearchOneTypeContentActivity.this, (Class<?>) m66.c());
                    intent.putExtra("user_item_info", nn0.d(jSONObject.getJSONObject("data")));
                    intent.putExtra("from", 1);
                    SearchOneTypeContentActivity.this.startActivity(intent);
                } else if (i == 1001) {
                    new sd3(SearchOneTypeContentActivity.this).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_token).O(R.string.dialog_confirm).f(new a()).e().show();
                } else {
                    new sd3(SearchOneTypeContentActivity.this).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_user).O(R.string.dialog_confirm).f(new b()).e().show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.ErrorListener {
        public e() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            SearchOneTypeContentActivity.this.hideBaseProgressBar();
        }
    }

    public final void L1() {
        this.w = new rn3();
        this.x = new com.zenmen.palmchat.activity.search.a(this, this.t, this.r);
        this.y = new com.zenmen.palmchat.activity.search.a(this, this.u, this.r);
        this.z = new com.zenmen.palmchat.activity.search.a(this, this.v, this.q, this.r);
        this.w.a(this.x);
        this.w.a(this.y);
        this.w.a(this.z);
    }

    public final void M1() {
        this.E = getIntent().getStringExtra("keyword");
        this.C = getIntent().getIntExtra("type", -1);
        this.B = new com.zenmen.palmchat.activity.search.c(this.F, true);
    }

    public final void N1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        this.A = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        EditText editText = (EditText) findViewById(R.id.search);
        this.r = editText;
        int i = this.C;
        if (i == 0) {
            editText.setHint(R.string.search_contacts);
        } else if (i == 1) {
            editText.setHint(R.string.search_groups);
        } else {
            if (i != 2) {
                return;
            }
            editText.setHint(R.string.search_messages);
        }
    }

    public final void O1() {
        this.r.addTextChangedListener(new b());
        this.s = (ListView) findViewById(R.id.list);
        this.q = com.zenmen.palmchat.activity.search.c.k();
        this.r.setEnabled(true);
        this.r.requestFocus();
        if (!TextUtils.isEmpty(this.E)) {
            this.r.setText(this.E);
        }
        L1();
        this.s.setAdapter((ListAdapter) this.w);
        this.s.setOnItemClickListener(new c());
    }

    public void P1() {
        String strQ = il5.q(this.r.getText().toString());
        if (TextUtils.isEmpty(strQ)) {
            sy5.f(this, getResources().getString(R.string.toast_phone_wrong), 1).g();
        } else {
            Q1(strQ);
        }
    }

    public final void Q1(String str) {
        showBaseProgressBar(R.string.progress_sending, false);
        new f45(new d(), new e()).n(str, AccountUtils.i(AppContext.getContext()), "list_m");
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_search_content);
        M1();
        N1();
        O1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.B.q();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchOneTypeContentActivity searchOneTypeContentActivity = SearchOneTypeContentActivity.this;
            searchOneTypeContentActivity.E = il5.q(searchOneTypeContentActivity.r.getText().toString().toLowerCase());
            int i4 = SearchOneTypeContentActivity.this.C;
            if (i4 == 0) {
                SearchOneTypeContentActivity.this.B.p(0, il5.q(SearchOneTypeContentActivity.this.r.getText().toString().toLowerCase()));
            } else if (i4 == 1) {
                SearchOneTypeContentActivity.this.B.p(3, il5.q(SearchOneTypeContentActivity.this.r.getText().toString().toLowerCase()));
            } else {
                if (i4 != 2) {
                    return;
                }
                SearchOneTypeContentActivity.this.B.p(4, il5.q(SearchOneTypeContentActivity.this.r.getText().toString().toLowerCase()));
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
