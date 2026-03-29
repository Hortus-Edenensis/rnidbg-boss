package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.widget.ClearEditText;
import defpackage.f45;
import defpackage.hs0;
import defpackage.hx3;
import defpackage.il5;
import defpackage.m66;
import defpackage.nn0;
import defpackage.sd3;
import defpackage.sy5;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SearchUserActivity extends BaseActionBarActivity {
    public ClearEditText q;
    public View r;
    public TextView s;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if ((i != 3 && i != 0) || keyEvent == null) {
                return false;
            }
            SearchUserActivity.this.onSearchClick(null);
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchUserActivity.this.onBackPressed();
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
            SearchUserActivity.this.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    Intent intent = new Intent(SearchUserActivity.this, (Class<?>) m66.c());
                    intent.putExtra("user_item_info", nn0.d(jSONObject.getJSONObject("data")));
                    intent.putExtra("from", 1);
                    SearchUserActivity.this.startActivity(intent);
                } else if (i == 1001) {
                    new sd3(SearchUserActivity.this).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_token).O(R.string.dialog_confirm).f(new a()).e().show();
                } else {
                    new sd3(SearchUserActivity.this).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_user).O(R.string.dialog_confirm).f(new b()).e().show();
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
            SearchUserActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {
        public f() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    public final void B1() {
        this.r = findViewById(R.id.searchContainner);
        this.s = (TextView) findViewById(R.id.searchTv);
        D1();
        this.q.addTextChangedListener(new a());
        this.q.setOnEditorActionListener(new b());
    }

    public final void C1(String str) {
        showBaseProgressBar(R.string.search_sending, false);
        new f45(new d(), new e()).n(str, AccountUtils.i(AppContext.getContext()), "add_f");
    }

    public final void D1() {
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

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 122;
    }

    public final void initActionBar() {
        initToolbar(-1, false);
        ClearEditText clearEditText = (ClearEditText) getToolbar().findViewById(R.id.search);
        this.q = clearEditText;
        clearEditText.setClearDrawable(R.drawable.clear_search, R.drawable.clear_search);
        findViewById(R.id.cancel_search).setOnClickListener(new c());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_user);
        initActionBar();
        B1();
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
        String strQ = il5.q(this.q.getText().toString());
        if (!hx3.m(AppContext.getContext())) {
            sy5.e(this, R.string.net_status_unavailable, 1).g();
            return;
        }
        if (TextUtils.isEmpty(strQ.trim())) {
            new sd3(this).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_user).O(R.string.dialog_confirm).f(new f()).e().show();
            return;
        }
        String strReplaceAll = strQ.replaceAll("-", "").replaceAll(" ", "");
        if (hs0.g().j(strReplaceAll, AccountUtils.i(this))) {
            C1(strReplaceAll);
        } else {
            C1(strQ.replaceAll(" ", ""));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchUserActivity.this.D1();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
