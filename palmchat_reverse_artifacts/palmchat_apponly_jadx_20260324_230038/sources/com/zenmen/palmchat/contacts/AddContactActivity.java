package com.zenmen.palmchat.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.QRCodeScan.QRCodeDialog;
import com.zenmen.palmchat.QRCodeScan.ScannerActivity;
import com.zenmen.palmchat.QRCodeScan.a;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.recommend.EnhanceRecommendActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.bo0;
import defpackage.jo6;
import defpackage.k86;
import defpackage.on0;
import org.apache.webplatform.jssdk.ContactPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AddContactActivity extends BaseActionBarActivity {
    public String q;
    public View r;
    public View s;
    public String t;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AddContactActivity.this.startActivity(new Intent(AppContext.getContext(), (Class<?>) (jo6.A() ? SearchUserActivityV2.class : SearchUserActivity.class)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
            }
            Intent intentA = on0.a(AddContactActivity.this.t);
            LogUtil.uploadInfoImmediate(AddContactActivity.this.q, "26", "1", null, null);
            AddContactActivity.this.startActivity(intentA);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!AppContext.getContext().getTrayPreferences().a(k86.n(), false)) {
                AppContext.getContext().getTrayPreferences().i(k86.n(), true);
            }
            Intent intentA = on0.a("upload_contact_from_menu_rec");
            LogUtil.uploadInfoImmediate(AddContactActivity.this.q, "27", "1", null, null);
            AddContactActivity.this.startActivity(intentA);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EnhanceRecommendActivity.H1(AddContactActivity.this);
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "3c11", "1", null, null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            QRCodeDialog.D(str).show(AddContactActivity.this.getSupportFragmentManager(), QRCodeDialog.class.getSimpleName());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.QRCodeScan.a.c(new a.e() { // from class: e7
                @Override // com.zenmen.palmchat.QRCodeScan.a.e
                public final void a(String str) {
                    this.f17226a.b(str);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zenmen.palmchat.videocall.c.f()) {
                return;
            }
            AddContactActivity.this.startActivity(new Intent(AppContext.getContext(), (Class<?>) ScannerActivity.class));
        }
    }

    public final void B1() {
        ((TextView) findViewById(R.id.search_account)).setText(com.zenmen.palmchat.activity.search.c.f());
        findViewById(R.id.search_area).setOnClickListener(new a());
        View viewFindViewById = findViewById(R.id.addPhoneContactArea);
        viewFindViewById.setOnClickListener(new b());
        findViewById(R.id.addRecommendationArea).setOnClickListener(new c());
        findViewById(R.id.mayKnownArea).setOnClickListener(new d());
        if (ac1.C()) {
            viewFindViewById.setVisibility(8);
        }
        TextView textView = (TextView) findViewById(R.id.phone_number);
        this.q = AccountUtils.p(AppContext.getContext());
        ContactInfoItem contactInfoItemL = bo0.r().l(this.q);
        if (contactInfoItemL != null) {
            if (TextUtils.isEmpty(contactInfoItemL.getAccount())) {
                textView.setText(getResources().getString(R.string.add_contact_my_phone_number, k86.O(contactInfoItemL.getMobile())));
            } else {
                textView.setText(getResources().getString(R.string.add_contact_my_accout, contactInfoItemL.getAccount()));
            }
        }
        textView.setOnClickListener(new e());
        findViewById(R.id.scanArea).setOnClickListener(new f());
        this.r = findViewById(R.id.recommendationLayout);
        this.s = findViewById(R.id.mayKnownLayout);
        D1();
    }

    public final void C1() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.t = intent.getStringExtra(ContactPlugin.EXTRA_KEY_FROM);
    }

    public final void D1() {
        this.r.setVisibility(8);
        this.s.setVisibility(0);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 112;
    }

    public final void initActionBar() {
        initToolbar(R.string.add_contact_title);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_add_contact);
        initActionBar();
        C1();
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

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        D1();
    }
}
