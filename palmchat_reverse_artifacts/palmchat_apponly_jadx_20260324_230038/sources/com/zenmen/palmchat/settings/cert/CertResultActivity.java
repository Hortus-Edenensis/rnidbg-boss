package com.zenmen.palmchat.settings.cert;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import defpackage.bo0;
import defpackage.ds0;
import defpackage.e00;
import defpackage.f00;
import defpackage.fn0;
import defpackage.i00;
import defpackage.nn4;
import defpackage.qm5;
import defpackage.sy5;
import defpackage.tk5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CertResultActivity extends BaseActionBarActivity {
    public boolean A;
    public String B;
    public boolean C;
    public String E;
    public Toolbar q;
    public ImageView r;
    public ImageView s;
    public TextView t;
    public ImageView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CertResultActivity.this.z) {
                ds0.a().b(new i00());
                e00.a("authentication_result_backbottom_click");
                CertResultActivity.this.finish();
            } else if (CertResultActivity.this.A) {
                sy5.e(AppContext.getContext(), R.string.string_reviewing_toast, 0).g();
                e00.a("authentication_result_scanagain_click");
            } else {
                CertResultActivity.this.startActivity(nn4.a(CertResultActivity.this, 11));
                e00.a("authentication_result_changepicture_click");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CertResultActivity.this.A) {
                CertResultActivity.this.startActivity(nn4.a(CertResultActivity.this, 11));
                e00.a("authentication_result_changepicture_click");
            } else {
                if (CertResultActivity.this.C) {
                    CertResultActivity.this.F1();
                } else {
                    sy5.e(AppContext.getContext(), R.string.string_cert_more_times, 0).g();
                }
                e00.a("authentication_result_scanagain_click");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ds0.a().b(new i00());
            e00.a("authentication_result_back_click");
            CertResultActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CertResultActivity.this.J1();
        }
    }

    public final void F1() {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.PEOPLE_MATCH_CAMERA);
    }

    public final void G1() {
        if (getIntent() != null) {
            this.z = getIntent().getBooleanExtra("cert_result", false);
            this.B = getIntent().getStringExtra("pic_url");
            this.C = getIntent().getBooleanExtra("can_cert", false);
        }
    }

    public final void H1() {
        Toolbar toolbarInitToolbar = initToolbar("", false);
        this.q = toolbarInitToolbar;
        toolbarInitToolbar.setBackgroundResource(R.color.color_trans);
        Toolbar toolbar = this.q;
        toolbar.setPadding(0, toolbar.getPaddingTop(), 0, 0);
        setSupportActionBar(this.q);
        findViewById(R.id.back).setOnClickListener(new c());
    }

    public final void I1() {
        H1();
        this.r = (ImageView) findViewById(R.id.iv_portrait);
        this.s = (ImageView) findViewById(R.id.iv_cert_result);
        this.t = (TextView) findViewById(R.id.tv_reviewing);
        this.u = (ImageView) findViewById(R.id.iv_scan_result);
        this.v = (TextView) findViewById(R.id.cert_success_reminder);
        this.w = (TextView) findViewById(R.id.cert_fail_reminder);
        this.x = (TextView) findViewById(R.id.cert_result_btn1);
        this.y = (TextView) findViewById(R.id.cert_result_btn2);
        this.x.setOnClickListener(new a());
        this.y.setOnClickListener(new b());
        J1();
    }

    public final void J1() {
        ContactInfoItem contactInfoItemL = bo0.r().l(this.E);
        if (contactInfoItemL != null && !TextUtils.isEmpty(contactInfoItemL.getIconURL())) {
            Glide.with((FragmentActivity) this).load2(Uri.parse(contactInfoItemL.getIconURL())).placeholder(R.drawable.default_portrait).error(R.drawable.default_portrait).into(this.r);
        }
        if (!TextUtils.isEmpty(this.B)) {
            Glide.with((FragmentActivity) this).load2(this.B).centerCrop().placeholder(R.drawable.default_portrait).error(R.drawable.default_portrait).into(this.u);
        }
        this.x.setVisibility(0);
        if (this.z) {
            this.v.setVisibility(0);
            this.s.setVisibility(0);
            this.w.setVisibility(8);
            this.y.setVisibility(8);
            this.t.setVisibility(8);
            this.x.setText(R.string.string_cert_result_back);
            this.s.setImageResource(R.drawable.ic_cert_result_success);
            return;
        }
        this.v.setVisibility(8);
        this.y.setVisibility(0);
        if (this.A) {
            this.s.setVisibility(8);
            this.w.setVisibility(4);
            this.t.setVisibility(0);
            this.x.setText(R.string.string_cert_result_rescan);
            this.y.setText(R.string.string_cert_result_edit_portrait);
            return;
        }
        this.s.setVisibility(0);
        this.w.setVisibility(0);
        this.t.setVisibility(8);
        this.x.setText(R.string.string_cert_result_edit_portrait);
        this.y.setText(R.string.string_cert_result_rescan);
        this.s.setImageResource(R.drawable.ic_cert_result_fail);
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        runOnUiThread(new d());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cert_result);
        tk5.a(this);
        ds0.a().c(this);
        bo0.r().i().j(this);
        e00.a("authentication_result_show");
        ds0.a().b(new f00());
        this.E = AccountUtils.p(AppContext.getContext());
        G1();
        I1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bo0.r().i().l(this);
        ds0.a().d(this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        sy5.f(AppContext.getContext(), "请在手机“设置-应用-连信-权限”中开启相机权限。开启后，可以实时帮你完成认证操作。", 1).g();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        finish();
    }

    @qm5
    public void onPortraitChangeSuccessEvent(i00 i00Var) {
        if (isFinishing() || i00Var == null) {
            return;
        }
        this.A = true;
    }
}
