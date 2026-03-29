package com.zenmen.palmchat.chat.temporary;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.ap3;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.fn0;
import defpackage.fu5;
import defpackage.gr2;
import defpackage.hx3;
import defpackage.i65;
import defpackage.iq5;
import defpackage.jw5;
import defpackage.l50;
import defpackage.m66;
import defpackage.nl0;
import defpackage.qm5;
import defpackage.rx4;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.v8;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TemporaryChatInfoActivity extends BaseActionBarActivity {
    public Toolbar q;
    public SocialPortraitView r;
    public TextView s;
    public View t;
    public View u;
    public CheckBox v;
    public ContactInfoItem w;
    public i65 x;
    public boolean y;
    public final Response.ErrorListener z = new i();
    public final Response.Listener<JSONObject> A = new j();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContactInfoItem contactInfoItemL;
            if (TemporaryChatInfoActivity.this.w.getChatType() != 0 || (contactInfoItemL = bo0.r().l(TemporaryChatInfoActivity.this.w.getChatId())) == null) {
                return;
            }
            TemporaryChatInfoActivity.this.V1(contactInfoItemL);
            boolean zE = jw5.e(TemporaryChatInfoActivity.this.w.getSessionConfig());
            if (TemporaryChatInfoActivity.this.v != null) {
                boolean zIsChecked = TemporaryChatInfoActivity.this.v.isChecked();
                if ((!zIsChecked || zE) && (zIsChecked || !zE)) {
                    return;
                }
                TemporaryChatInfoActivity.this.y = true;
                TemporaryChatInfoActivity.this.v.setChecked(!zIsChecked);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TemporaryChatInfoActivity.this.N1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TemporaryChatInfoActivity.this.L1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TemporaryChatInfoActivity.this.M1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements CompoundButton.OnCheckedChangeListener {
        public e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!hx3.m(TemporaryChatInfoActivity.this)) {
                sy5.e(TemporaryChatInfoActivity.this, R.string.net_status_unavailable, 1).g();
            } else if (TemporaryChatInfoActivity.this.y) {
                TemporaryChatInfoActivity.this.y = false;
            } else {
                TemporaryChatInfoActivity.this.T1(z);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ap3.a().B(TemporaryChatInfoActivity.this, nl0.q + "/vip/#/renewal");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {
        public g() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            com.zenmen.palmchat.database.b.j(TemporaryChatInfoActivity.this.w);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends MaterialDialog.e {
        public h() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            TemporaryChatInfoActivity.this.y = true;
            TemporaryChatInfoActivity.this.v.setChecked(false);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            TemporaryChatInfoActivity temporaryChatInfoActivity = TemporaryChatInfoActivity.this;
            temporaryChatInfoActivity.K1(temporaryChatInfoActivity.w.getChatId(), jw5.b(TemporaryChatInfoActivity.this.w.getSessionConfig(), 8));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.ErrorListener {
        public i() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
            TemporaryChatInfoActivity.this.hideBaseProgressBar();
            TemporaryChatInfoActivity.this.U1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.Listener<JSONObject> {
        public j() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            LogUtil.d(BaseActionBarActivity.TAG, jSONObject.toString());
            int iOptInt = jSONObject.optInt("resultCode");
            TemporaryChatInfoActivity.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
            } else if (iOptInt == 1320) {
                rx4.b(TemporaryChatInfoActivity.this, jSONObject);
            } else {
                TemporaryChatInfoActivity.this.U1();
            }
        }
    }

    public final void K1(String str, int i2) {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        try {
            i65 i65Var = new i65(this.A, this.z);
            this.x = i65Var;
            i65Var.n(str, i2);
        } catch (DaoException e2) {
            e2.printStackTrace();
            hideBaseProgressBar();
            U1();
        }
    }

    public final void L1() {
        new sd3(this).k(getString(R.string.string_delete_chat_message_dialog_single, this.w.getNameForShow())).N(R.color.material_dialog_button_text_color_red).K(R.string.alert_dialog_cancel).O(R.string.string_delete_chat_message_dialog_ok).f(new g()).e().show();
    }

    public final void M1() {
        CordovaWebActivity.v2(this, 902, fu5.b, this.w, 1);
    }

    public final void N1() {
        Intent intent = new Intent(this, (Class<?>) m66.c());
        intent.putExtra("from", 5);
        intent.putExtra("user_item_info", this.w);
        startActivity(intent);
    }

    public final void O1() {
        this.s.setText(this.w.getChatName());
        ContactInfoItem contactInfoItem = this.w;
        if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getIconURL())) {
            this.r.setImageResource(R.drawable.default_portrait);
        } else {
            gr2.j().h(this.w.getIconURL(), this.r, bq6.s());
        }
    }

    public final void P1() {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("info_item");
        if (parcelableExtra instanceof ContactInfoItem) {
            this.w = (ContactInfoItem) parcelableExtra;
        } else {
            finish();
        }
    }

    public final void Q1() {
        this.r.setOnClickListener(new b());
        this.t.setOnClickListener(new c());
        this.u.setOnClickListener(new d());
        this.v.setOnCheckedChangeListener(new e());
        if (v8.C(this.w.getUid())) {
            View viewFindViewById = findViewById(R.id.ai_pay_layout_temporary);
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new f());
        }
    }

    public final void R1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        this.q = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void S1() {
        SocialPortraitView socialPortraitView = (SocialPortraitView) findViewById(R.id.portrait);
        this.r = socialPortraitView;
        socialPortraitView.changeShapeType(3);
        this.r.setDegreeForRoundRectangle(24, 24);
        this.s = (TextView) findViewById(R.id.nick_name);
        this.v = (CheckBox) findViewById(R.id.stop_receive_messages_checkbox);
        this.t = findViewById(R.id.delete_chat_message);
        this.u = findViewById(R.id.report_chat);
        this.v.setChecked(jw5.e(this.w.getSessionConfig()));
    }

    public void T1(boolean z) {
        ContactInfoItem contactInfoItem = this.w;
        if (contactInfoItem != null) {
            jw5.j(contactInfoItem.getSessionConfig());
            jw5.g(this.w.getSessionConfig());
            if (z) {
                new sd3(this).T(R.string.add_to_blacklist).j(R.string.blacklist_dialog_content).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).h(false).f(new h()).e().show();
            } else {
                K1(this.w.getChatId(), jw5.a(this.w.getSessionConfig(), 8));
            }
        }
    }

    public final void U1() {
        sy5.e(this, R.string.send_failed, 0).g();
        CheckBox checkBox = this.v;
        if (checkBox != null) {
            this.y = true;
            checkBox.setChecked(true ^ checkBox.isChecked());
        }
    }

    public final void V1(ContactInfoItem contactInfoItem) {
        ContactInfoItem contactInfoItem2 = this.w;
        if (contactInfoItem2 == null || contactInfoItem == null) {
            return;
        }
        if (!fu5.u(contactInfoItem2)) {
            this.w = contactInfoItem;
            return;
        }
        int bizType = this.w.getBizType();
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        contactInfoItemM792clone.setBizType(bizType);
        contactInfoItemM792clone.setSourceType(fu5.n(bizType));
        this.w = contactInfoItemM792clone;
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new a());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bo0.r().i().j(this);
        P1();
        setContentView(R.layout.activity_temporary_chat_info);
        R1();
        S1();
        Q1();
        O1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        i65 i65Var = this.x;
        if (i65Var != null) {
            i65Var.onCancel();
        }
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
}
