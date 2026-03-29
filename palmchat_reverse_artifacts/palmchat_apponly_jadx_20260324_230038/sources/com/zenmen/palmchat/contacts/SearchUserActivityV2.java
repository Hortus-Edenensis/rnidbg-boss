package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.ClearEditText;
import defpackage.UI;
import defpackage.e45;
import defpackage.f45;
import defpackage.hs0;
import defpackage.hx3;
import defpackage.il5;
import defpackage.io0;
import defpackage.l50;
import defpackage.li4;
import defpackage.m66;
import defpackage.me1;
import defpackage.nn0;
import defpackage.pm2;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.vn0;
import defpackage.wh4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SearchUserActivityV2 extends BaseActionBarActivity implements pm2<Cursor> {
    public ClearEditText q;
    public View r;
    public TextView s;
    public View t;
    public View u;
    public ListView v;
    public e45 w;
    public HashMap<String, PhoneContactVo> x = new HashMap<>();
    public HashMap<String, PhoneContactVo> y = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (l50.a()) {
                return;
            }
            LogUtil.uploadInfoImmediate("matchlist_cli", null, null, null);
            PhoneContactVo phoneContactVo = (PhoneContactVo) adapterView.getItemAtPosition(i);
            if (phoneContactVo == null) {
                return;
            }
            if (!io0.s(phoneContactVo.getNickName(), phoneContactVo.getIconURL())) {
                Intent intent = new Intent(SearchUserActivityV2.this, (Class<?>) m66.c());
                intent.putExtra("user_item_info", phoneContactVo);
                intent.putExtra("from", 1);
                SearchUserActivityV2.this.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(SearchUserActivityV2.this, (Class<?>) GhostUserDetailActivity.class);
            intent2.putExtra("user_item_info", phoneContactVo);
            intent2.putExtra("user_item_info_local_name", phoneContactVo.getLocalName());
            PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(phoneContactVo.getMd5Phone());
            if (phoneContactItem != null) {
                intent2.putExtra("user_item_info_phone_number", phoneContactItem.y());
            }
            SearchUserActivityV2.this.startActivity(intent2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if ((i != 3 && i != 0) || keyEvent == null) {
                return false;
            }
            SearchUserActivityV2.this.onSearchClick(null);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            SearchUserActivityV2.this.J1();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            SearchUserActivityV2.this.J1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchUserActivityV2.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Comparator<PhoneContactVo> {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContactVo phoneContactVo, PhoneContactVo phoneContactVo2) {
            return phoneContactVo.getLocalNameFirstPinyin().compareTo(phoneContactVo2.getLocalNameFirstPinyin());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {

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

        public g() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            SearchUserActivityV2.this.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    Intent intent = new Intent(SearchUserActivityV2.this, (Class<?>) m66.c());
                    intent.putExtra("user_item_info", nn0.d(jSONObject.getJSONObject("data")));
                    intent.putExtra("from", 1);
                    SearchUserActivityV2.this.startActivity(intent);
                } else if (i == 1001) {
                    new sd3(SearchUserActivityV2.this).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_token).O(R.string.dialog_confirm).f(new a()).e().show();
                } else {
                    new sd3(SearchUserActivityV2.this).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_user).O(R.string.dialog_confirm).f(new b()).e().show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {
        public h() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            SearchUserActivityV2.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends MaterialDialog.e {
        public i() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    public final String D1() {
        String strQ = il5.q(this.q.getText().toString());
        if (TextUtils.isEmpty(strQ.trim())) {
            return null;
        }
        String strReplaceAll = strQ.replaceAll("-", "").replaceAll(" ", "");
        return hs0.g().j(strReplaceAll, AccountUtils.i(this)) ? strReplaceAll : strQ.replaceAll(" ", "");
    }

    public final void E1() {
        this.v = (ListView) findViewById(R.id.contacts_list);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.activity_search_user_header, (ViewGroup) null);
        this.v.addHeaderView(viewInflate);
        e45 e45Var = new e45(this);
        this.w = e45Var;
        this.v.setAdapter((ListAdapter) e45Var);
        this.v.setOnItemClickListener(new a());
        this.u = findViewById(R.id.sticky);
        this.r = viewInflate.findViewById(R.id.searchContainner);
        this.t = viewInflate.findViewById(R.id.contactTitle);
        this.s = (TextView) findViewById(R.id.searchTv);
        I1();
        this.q.addTextChangedListener(new b());
        this.q.setOnEditorActionListener(new c());
        this.v.setOnScrollListener(new d());
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() != 0 || cursor == null) {
            return;
        }
        this.x = wh4.c(ContactRequestsVO.buildFromCursorForShow(cursor));
        H1();
    }

    public final void G1(String str) {
        showBaseProgressBar(R.string.search_sending, false);
        new f45(new g(), new h()).n(str, AccountUtils.i(AppContext.getContext()), "add_f");
    }

    public final void H1() {
        PhoneContactVo phoneContactVo;
        ArrayList<PhoneContactVo> arrayList = new ArrayList<>();
        String strD1 = D1();
        if (tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList) && this.x != null && !TextUtils.isEmpty(strD1)) {
            HashMap<String, PhoneContactVo> map = this.y;
            if (map == null || map.size() == 0) {
                this.y = com.zenmen.palmchat.contacts.d.j().n();
            }
            Iterator<Map.Entry<String, PhoneContactVo>> it = this.x.entrySet().iterator();
            while (it.hasNext()) {
                PhoneContactVo value = it.next().getValue();
                if (TextUtils.isEmpty(value.getMd5Phone())) {
                    phoneContactVo = this.y.get(hs0.g().d(value.getMobile()));
                } else {
                    phoneContactVo = this.y.get(value.getMd5Phone());
                }
                if (phoneContactVo != null && !TextUtils.isEmpty(phoneContactVo.getLocalPhone()) && phoneContactVo.getLocalPhone().replaceAll("-", "").replaceAll(" ", "").contains(strD1)) {
                    value.setLocalPhone(phoneContactVo.getLocalPhone());
                    if (!TextUtils.isEmpty(phoneContactVo.getLocalName())) {
                        value.setLocalName(phoneContactVo.getLocalName());
                    } else if (TextUtils.isEmpty(value.getLocalName())) {
                        value.setLocalName(value.getNickName());
                    }
                    if (!TextUtils.isEmpty(value.getLocalName())) {
                        value.setLocalNameFirstPinyin(li4.a(value.getLocalName()));
                        value.setLocalNameAllPinyin(li4.b(value.getLocalName()));
                        arrayList.add(value);
                    }
                }
            }
        }
        K1(arrayList);
    }

    public final void I1() {
        String strQ = il5.q(this.q.getText().toString());
        if (TextUtils.isEmpty(strQ)) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        String string = getResources().getString(R.string.search_phone);
        SpannableString spannableString = new SpannableString(string + strQ);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.text_color_black)), 0, string.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.Ga)), string.length(), spannableString.length(), 33);
        this.s.setText(spannableString);
    }

    public final void J1() {
        View view = this.t;
        if (view == null || this.u == null) {
            return;
        }
        if (view.getVisibility() != 0 || this.t.getHeight() <= 0) {
            this.u.setVisibility(4);
            return;
        }
        int[] iArr = new int[2];
        this.t.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.v.getLocationOnScreen(iArr2);
        this.u.setVisibility(iArr[1] <= iArr2[1] ? 0 : 4);
    }

    public final void K1(ArrayList<PhoneContactVo> arrayList) {
        Collections.sort(arrayList, new f());
        this.w.a(D1());
        this.w.b(arrayList);
        if (arrayList.isEmpty()) {
            this.t.setVisibility(8);
            this.v.setPadding(0, 0, 0, 0);
            J1();
        } else {
            this.t.setVisibility(0);
            this.v.setPadding(0, 0, 0, me1.b(this, 7));
            J1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 122;
    }

    public final void initActionBar() {
        initToolbar(-1, false);
        ClearEditText clearEditText = (ClearEditText) getToolbar().findViewById(R.id.search);
        this.q = clearEditText;
        clearEditText.setClearDrawable(R.drawable.clear_search, R.drawable.clear_search);
        findViewById(R.id.cancel_search).setOnClickListener(new e());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_user_v2);
        initActionBar();
        E1();
        UI.c(this, 0, null, this);
        LogUtil.uploadInfoImmediate("addsearch_uv", null, null, null);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        if (i2 != 0) {
            return null;
        }
        return new CursorLoader(this, vn0.f21483a, null, "request_type = ?", new String[]{String.valueOf(101)}, "_id DESC");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void onSearchClick(View view) {
        LogUtil.uploadInfoImmediate("addsearch_rs", null, null, null);
        String strQ = il5.q(this.q.getText().toString());
        if (!hx3.m(AppContext.getContext())) {
            sy5.e(this, R.string.net_status_unavailable, 1).g();
            return;
        }
        if (TextUtils.isEmpty(strQ.trim())) {
            new sd3(this).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_user).O(R.string.dialog_confirm).f(new i()).e().show();
            return;
        }
        String strReplaceAll = strQ.replaceAll("-", "").replaceAll(" ", "");
        if (hs0.g().j(strReplaceAll, AccountUtils.i(this))) {
            G1(strReplaceAll);
        } else {
            G1(strQ.replaceAll(" ", ""));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchUserActivityV2.this.I1();
            SearchUserActivityV2.this.H1();
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
