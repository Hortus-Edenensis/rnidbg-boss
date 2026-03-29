package com.zenmen.palmchat.activity.search;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
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
import com.zenmen.palmchat.widget.ClearEditText;
import defpackage.bo0;
import defpackage.f45;
import defpackage.hs0;
import defpackage.hx3;
import defpackage.il5;
import defpackage.k86;
import defpackage.m40;
import defpackage.m66;
import defpackage.rn3;
import defpackage.sy5;
import defpackage.v4;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SearchContentActivity extends BaseActionBarActivity implements View.OnClickListener {
    public Toolbar A;
    public com.zenmen.palmchat.activity.search.c B;
    public f45 C;
    public ClearEditText r;
    public ListView s;
    public rn3 w;
    public com.zenmen.palmchat.activity.search.a x;
    public com.zenmen.palmchat.activity.search.a y;
    public com.zenmen.palmchat.activity.search.a z;
    public HashMap<String, GroupInfoItem> q = new HashMap<>();
    public ArrayList<Object> t = new ArrayList<>();
    public ArrayList<Object> u = new ArrayList<>();
    public ArrayList<Object> v = new ArrayList<>();
    public c.d E = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c.d {
        public a() {
        }

        @Override // com.zenmen.palmchat.activity.search.c.d
        public void a(c.f fVar) {
            String strQ = il5.q(SearchContentActivity.this.r.getText().toString().toLowerCase());
            if (TextUtils.isEmpty(strQ)) {
                SearchContentActivity.this.t.clear();
                SearchContentActivity.this.x.notifyDataSetChanged();
                SearchContentActivity.this.u.clear();
                SearchContentActivity.this.y.notifyDataSetChanged();
                SearchContentActivity.this.v.clear();
                SearchContentActivity.this.z.notifyDataSetChanged();
                return;
            }
            if (fVar.f12391a.equals(strQ)) {
                SearchContentActivity.this.t.clear();
                if (fVar.b != null) {
                    SearchContentActivity.this.t.addAll(fVar.b);
                }
                if (SearchContentActivity.this.t.size() > 2) {
                    SearchContentActivity.this.t.add(2, new ContactInfoItem());
                } else {
                    SearchContentActivity.this.t.add(new ContactInfoItem());
                }
                SearchContentActivity.this.x.notifyDataSetChanged();
                SearchContentActivity.this.u.clear();
                if (fVar.c != null) {
                    SearchContentActivity.this.u.addAll(fVar.c.values());
                    SearchContentActivity.this.y.b(fVar.d);
                }
                SearchContentActivity.this.y.notifyDataSetChanged();
                SearchContentActivity.this.v.clear();
                if (fVar.e != null) {
                    SearchContentActivity.this.v.addAll(fVar.e);
                }
                SearchContentActivity.this.z.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchContentActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.e eVar;
            MessageVo messageVo;
            String str;
            SearchContentActivity.this.r.clearFocus();
            ((InputMethodManager) SearchContentActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(SearchContentActivity.this.r.getWindowToken(), 0);
            Object itemAtPosition = adapterView.getItemAtPosition(i);
            if (itemAtPosition instanceof ContactInfoItem) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) itemAtPosition;
                if (TextUtils.isEmpty(contactInfoItem.getUid())) {
                    SearchContentActivity.this.M1();
                    return;
                }
                if (contactInfoItem.getUid() != null && contactInfoItem.getUid().equals(v4.e(AppContext.getContext()))) {
                    Intent intent = new Intent(SearchContentActivity.this, (Class<?>) m66.c());
                    intent.putExtra("user_item_info", contactInfoItem);
                    intent.putExtra("from", 1);
                    SearchContentActivity.this.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(SearchContentActivity.this, (Class<?>) ChatterActivity.class);
                intent2.putExtra("chat_item", contactInfoItem);
                intent2.putExtra("chat_need_back_to_main", false);
                k86.X(intent2);
                SearchContentActivity.this.startActivity(intent2);
                return;
            }
            if (itemAtPosition instanceof GroupInfoItem) {
                if (itemAtPosition != null) {
                    Intent intent3 = new Intent(SearchContentActivity.this, (Class<?>) ChatterActivity.class);
                    intent3.putExtra("chat_item", (GroupInfoItem) itemAtPosition);
                    intent3.putExtra("chat_need_back_to_main", false);
                    k86.X(intent3);
                    SearchContentActivity.this.startActivity(intent3);
                    return;
                }
                return;
            }
            if (!(itemAtPosition instanceof c.e) || (messageVo = (eVar = (c.e) itemAtPosition).b) == null || (str = messageVo.contactRelate) == null) {
                return;
            }
            ChatItem chatItemL = m40.b(str) == 0 ? bo0.r().l(eVar.b.contactRelate) : (ChatItem) SearchContentActivity.this.q.get(m40.d(eVar.b.contactRelate));
            if (chatItemL != null) {
                if (eVar.f12390a != 1) {
                    Intent intent4 = new Intent(SearchContentActivity.this, (Class<?>) MessageSearchResultActivity.class);
                    intent4.putExtra("search_text", il5.q(SearchContentActivity.this.r.getText().toString()));
                    intent4.putExtra("search_relate_contact", chatItemL);
                    intent4.putExtra("search_relate_contact_string", chatItemL.getChatId());
                    SearchContentActivity.this.startActivity(intent4);
                    return;
                }
                Intent intent5 = new Intent(SearchContentActivity.this, (Class<?>) ChatterActivity.class);
                intent5.putExtra("chat_item", chatItemL);
                intent5.putExtra("chat_first_message", eVar.b.time);
                intent5.putExtra("chat_first_message_primary_id", eVar.b._id);
                intent5.putExtra("chat_need_back_to_main", false);
                k86.X(intent5);
                SearchContentActivity.this.startActivity(intent5);
            }
        }
    }

    public final void J1() {
        this.w = new rn3();
        this.x = new com.zenmen.palmchat.activity.search.a(this, 3, this, this.t, this.r, false);
        this.y = new com.zenmen.palmchat.activity.search.a(this, 3, this, this.u, this.r, true);
        this.z = new com.zenmen.palmchat.activity.search.a(this, 3, this, this.v, this.q, this.r, true);
        this.w.a(this.x);
        this.w.a(this.y);
        this.w.a(this.z);
    }

    public final void K1() {
        Toolbar toolbarInitToolbar = initToolbar(-1, false);
        this.A = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.search);
        this.r = clearEditText;
        clearEditText.setClearDrawable(R.drawable.clear_search, R.drawable.clear_search);
        findViewById(R.id.cancel_search).setOnClickListener(new b());
    }

    public final void L1() {
        this.r.addTextChangedListener(new c());
        this.s = (ListView) findViewById(R.id.list);
        this.q = com.zenmen.palmchat.activity.search.c.k();
        this.r.setEnabled(true);
        this.r.requestFocus();
        J1();
        this.s.setAdapter((ListAdapter) this.w);
        this.s.setOnItemClickListener(new d());
    }

    public void M1() {
        String strQ = il5.q(this.r.getText().toString());
        if (!hx3.m(AppContext.getContext())) {
            sy5.e(this, R.string.net_status_unavailable, 1).g();
            return;
        }
        if (TextUtils.isEmpty(strQ)) {
            sy5.f(this, getResources().getString(R.string.toast_phone_wrong), 1).g();
            return;
        }
        String strReplaceAll = strQ.replaceAll("-", "").replaceAll(" ", "");
        if (hs0.g().j(strReplaceAll, AccountUtils.i(this))) {
            com.zenmen.palmchat.activity.search.c.o(this, strReplaceAll);
        } else {
            com.zenmen.palmchat.activity.search.c.o(this, strQ);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 111;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this, (Class<?>) SearchOneTypeContentActivity.class);
        intent.putExtra("keyword", il5.q(this.r.getText().toString()));
        intent.putExtra("type", ((Integer) view.getTag()).intValue());
        startActivity(intent);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_search_content);
        K1();
        L1();
        this.B = new com.zenmen.palmchat.activity.search.c(this.E, true);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        f45 f45Var = this.C;
        if (f45Var != null) {
            f45Var.onCancel();
        }
        this.B.q();
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
        if (TextUtils.isEmpty(this.r.getText().toString())) {
            return;
        }
        this.B.p(2, il5.q(this.r.getText().toString().toLowerCase()));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchContentActivity.this.B.p(2, il5.q(SearchContentActivity.this.r.getText().toString().toLowerCase()));
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
