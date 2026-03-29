package com.zenmen.palmchat.teenagersmode;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.settings.cert.a;
import com.zenmen.palmchat.teenagersmode.a;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.verifycode.VerifyCodeView;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.a0;
import defpackage.c0;
import defpackage.ry5;
import defpackage.zn6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VerifyPwdActivity extends BaseActionBarActivity {
    public VerifyCodeView q;
    public EditText r;
    public View s;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.zenmen.palmchat.teenagersmode.VerifyPwdActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1110a implements a.b {

            /* JADX INFO: renamed from: com.zenmen.palmchat.teenagersmode.VerifyPwdActivity$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1111a implements c0 {
                public C1111a() {
                }

                @Override // defpackage.c0
                public void a(int i, Intent intent) {
                    LogUtil.i(BaseActionBarActivity.TAG, "switchMode resultCode" + i);
                    if (i == -1) {
                        VerifyPwdActivity.this.finish();
                    }
                }
            }

            public C1110a() {
            }

            @Override // com.zenmen.palmchat.settings.cert.a.b
            public void onResult(boolean z) {
                if (z) {
                    a0.d(VerifyPwdActivity.this).e(com.zenmen.palmchat.teenagersmode.a.d(VerifyPwdActivity.this)).b(new C1111a());
                } else {
                    ry5.a(VerifyPwdActivity.this.getString(R.string.circle_real_name_failed));
                }
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            zn6.c("youth_resetpassword", "click");
            com.zenmen.palmchat.settings.cert.a.a().d(VerifyPwdActivity.this, new C1110a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements VerifyCodeView.c {
        public b() {
        }

        @Override // com.zenmen.palmchat.widget.verifycode.VerifyCodeView.c
        public void d(String str) {
            if (TextUtils.isEmpty(str) || str.length() != 4) {
                return;
            }
            VerifyPwdActivity.this.C1(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.e {
        public c() {
        }

        @Override // com.zenmen.palmchat.teenagersmode.a.e
        public void call() {
            VerifyPwdActivity.this.setResult(-1, new Intent());
            VerifyPwdActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements a.d {
        public d() {
        }

        @Override // com.zenmen.palmchat.teenagersmode.a.d
        public void a() {
            VerifyPwdActivity.this.s.setVisibility(0);
        }

        @Override // com.zenmen.palmchat.teenagersmode.a.d
        public void success() {
            VerifyPwdActivity.this.setResult(-1, new Intent());
            VerifyPwdActivity.this.finish();
        }
    }

    public final void B1() {
        this.q = (VerifyCodeView) findViewById(R.id.verify_edit_square);
        this.r = (EditText) findViewById(R.id.verify_edit_square_test);
        this.s = findViewById(R.id.des);
        this.q.setEditText(this.r);
        this.q.setVisibility(0);
        this.q.hideInput = true;
        this.s.setVisibility(8);
        findViewById(R.id.forget).setOnClickListener(new a());
        this.q.setOnTextChangedListener(new b());
    }

    public final void C1(String str) {
        String strC = TeenagersModeManager.a().c().c();
        if (TextUtils.isEmpty(strC)) {
            TeenagersModeManager.a().c().b(this, str, new d());
        } else if (strC == null || !strC.equals(str)) {
            this.s.setVisibility(0);
        } else {
            TeenagersModeManager.a().c().h(this, str, new c());
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_teenager_verify_pwd);
        initToolbar("输入密码");
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
        KeyboardKt.a(this.r, this, Keyboard$SHOW_FLAG.IMPLICIT, 300L);
    }
}
