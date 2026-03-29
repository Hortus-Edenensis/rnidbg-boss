package com.zenmen.palmchat.groupchat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b56;
import defpackage.bo0;
import defpackage.il5;
import defpackage.iq5;
import defpackage.sd3;
import defpackage.sy5;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupNameActivity extends BaseActionBarActivity {
    public TextView q;
    public TextView r;
    public EditText s;
    public GroupInfoItem t;
    public ArrayList<ContactInfoItem> u = new ArrayList<>();
    public b56 v;
    public Response.ErrorListener w;
    public Response.Listener<JSONObject> x;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupNameActivity.this.E1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GroupNameActivity.this.hideBaseProgressBar();
            sy5.e(GroupNameActivity.this, R.string.send_failed, 0).g();
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.Listener<JSONObject> {
        public d() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            GroupNameActivity.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
                GroupNameActivity.this.finish();
                sy5.e(GroupNameActivity.this, R.string.send_success, 0).g();
            } else if (iOptInt != 4011) {
                sy5.e(GroupNameActivity.this, R.string.send_failed, 0).g();
            } else {
                GroupNameActivity.this.hideBaseProgressBar();
                new sd3(GroupNameActivity.this).j(R.string.profile_fail).O(R.string.alert_dialog_ok).f(null).e().show();
            }
        }
    }

    public final void C1() {
        this.s = (EditText) findViewById(R.id.edit_text);
        GroupInfoItem groupInfoItem = this.t;
        if (groupInfoItem != null && !TextUtils.isEmpty(groupInfoItem.getGroupName())) {
            this.s.setText(this.t.getGroupName());
            Selection.setSelection(this.s.getText(), this.s.getText().length());
        }
        this.q.setOnClickListener(new a());
        this.s.addTextChangedListener(new b());
        this.w = new c();
        this.x = new d();
    }

    public final void D1(Intent intent) {
        this.t = (GroupInfoItem) intent.getParcelableExtra("group_info_item");
        this.u = intent.getParcelableArrayListExtra("init_members");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047 A[PHI: r0
      0x0047: PHI (r0v34 java.lang.String) = (r0v25 java.lang.String), (r0v20 java.lang.String) binds: [B:23:0x006a, B:13:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E1() {
        String groupRemarkName;
        int memberCount = this.t.getMemberCount();
        String groupOwner = this.t.getGroupOwner();
        if (memberCount < 100 || this.t.getGroupOwner().equals(AccountUtils.p(AppContext.getContext()))) {
            String string = this.s.getText().toString();
            if (il5.p(string)) {
                new sd3(this).T(R.string.update_install_dialog_title).j(R.string.empty_nickname).O(R.string.alert_dialog_ok).f(null).e().show();
                return;
            }
            b56 b56Var = new b56(this.x, this.w);
            this.v = b56Var;
            try {
                b56Var.n(this.t.getGroupId(), string);
                showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
                return;
            } catch (DaoException e2) {
                e2.printStackTrace();
                hideBaseProgressBar();
                return;
            }
        }
        ContactInfoItem contactInfoItemL = bo0.r().l(groupOwner);
        Object obj = "";
        String remarkName = contactInfoItemL != null ? contactInfoItemL.getRemarkName() : "";
        if (!bo0.r().w(groupOwner) || TextUtils.isEmpty(remarkName)) {
            ContactInfoItem contactInfoItem = this.u.get(0);
            if (contactInfoItem != null) {
                groupRemarkName = contactInfoItem.getGroupRemarkName();
                remarkName = contactInfoItem.getNickName();
            } else {
                remarkName = "";
                groupRemarkName = remarkName;
            }
            if (!TextUtils.isEmpty(groupRemarkName)) {
                obj = groupRemarkName;
            } else if (!TextUtils.isEmpty(remarkName)) {
                obj = remarkName;
            }
        }
        new sd3(this).k(getString(R.string.too_many_group_member, obj)).f(new e()).O(R.string.get_it).e().show();
    }

    public final void initActionBar() {
        setSupportActionBar(initToolbar(-1));
        TextView textView = (TextView) getToolbar().findViewById(R.id.title);
        this.r = textView;
        textView.setText(getText(R.string.message_item_group_name_card_title));
        TextView textView2 = (TextView) getToolbar().findViewById(R.id.action_button);
        this.q = textView2;
        textView2.setEnabled(false);
        this.q.setText(R.string.string_save);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_name);
        initActionBar();
        D1(getIntent());
        C1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        b56 b56Var = this.v;
        if (b56Var != null) {
            b56Var.onCancel();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        finish();
        return true;
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
            GroupNameActivity.this.q.setEnabled(true);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {
        public e() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
        }
    }
}
