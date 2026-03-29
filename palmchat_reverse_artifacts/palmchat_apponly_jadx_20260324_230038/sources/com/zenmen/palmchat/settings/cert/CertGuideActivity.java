package com.zenmen.palmchat.settings.cert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.ds0;
import defpackage.e00;
import defpackage.f00;
import defpackage.l50;
import defpackage.qm5;
import defpackage.sy5;
import defpackage.tk5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class CertGuideActivity extends BaseActionBarActivity {
    public Toolbar q;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (SPUtil.f14322a.a(SPUtil.SCENE.CERT, "key_cert_has_authorization", false)) {
                CertGuideActivity.this.B1();
            } else {
                CertGuideActivity.this.startActivity(new Intent(CertGuideActivity.this, (Class<?>) CertAuthorizationActivity.class));
            }
            e00.a("authentication_guide_confirm_click");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e00.a("authentication_guide_back_click");
            CertGuideActivity.this.finish();
        }
    }

    public final void B1() {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.PEOPLE_MATCH_CAMERA);
    }

    public final void C1() {
        Toolbar toolbarInitToolbar = initToolbar("", false);
        this.q = toolbarInitToolbar;
        toolbarInitToolbar.setBackgroundResource(R.color.color_trans);
        Toolbar toolbar = this.q;
        toolbar.setPadding(0, toolbar.getPaddingTop(), 0, 0);
        setSupportActionBar(this.q);
        findViewById(R.id.back).setOnClickListener(new b());
    }

    public final void D1() {
        C1();
        findViewById(R.id.cert_guide_to_cert).setOnClickListener(new a());
    }

    @qm5
    public void onCertResultBackEvent(f00 f00Var) {
        if (isFinishing() || f00Var == null) {
            return;
        }
        finish();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cert_guide);
        tk5.a(this);
        ds0.a().c(this);
        e00.a("authentication_guide_show");
        D1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
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
    }
}
