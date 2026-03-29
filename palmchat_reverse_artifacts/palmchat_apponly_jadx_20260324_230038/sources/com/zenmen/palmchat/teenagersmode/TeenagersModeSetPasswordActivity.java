package com.zenmen.palmchat.teenagersmode;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.teenagersmode.a;
import com.zenmen.palmchat.widget.verifycode.VerifyCodeView;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.cl6;
import defpackage.zn6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TeenagersModeSetPasswordActivity extends BaseActionBarActivity {
    public VerifyCodeView q;
    public EditText r;
    public VerifyCodeView s;
    public EditText t;
    public boolean u;
    public boolean v;
    public TextView w;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements VerifyCodeView.c {
        public a() {
        }

        @Override // com.zenmen.palmchat.widget.verifycode.VerifyCodeView.c
        public void d(String str) {
            if (!TextUtils.isEmpty(str) && !TeenagersModeSetPasswordActivity.this.u) {
                TeenagersModeSetPasswordActivity.this.u = true;
            }
            if (TextUtils.isEmpty(str) || str.length() != cl6.f()) {
                return;
            }
            TeenagersModeSetPasswordActivity.this.q.clearFocus();
            TeenagersModeSetPasswordActivity.this.t.clearFocus();
            TeenagersModeSetPasswordActivity.this.s.requestFocus();
            TeenagersModeSetPasswordActivity.this.t.requestFocus();
            TeenagersModeSetPasswordActivity.this.s.hideBg = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements VerifyCodeView.c {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.e {
            public a() {
            }

            @Override // com.zenmen.palmchat.teenagersmode.a.e
            public void call() {
                TeenagersModeSetPasswordActivity.this.setResult(-1, new Intent());
                TeenagersModeSetPasswordActivity.this.finish();
            }
        }

        public b() {
        }

        @Override // com.zenmen.palmchat.widget.verifycode.VerifyCodeView.c
        public void d(String str) {
            if (!TextUtils.isEmpty(str) && !TeenagersModeSetPasswordActivity.this.v) {
                TeenagersModeSetPasswordActivity.this.v = true;
            }
            if (TextUtils.isEmpty(str) || str.length() != cl6.f()) {
                return;
            }
            if (TeenagersModeSetPasswordActivity.this.q.getVcText().equals(TeenagersModeSetPasswordActivity.this.s.getVcText())) {
                com.zenmen.palmchat.teenagersmode.a aVarC = TeenagersModeManager.a().c();
                TeenagersModeSetPasswordActivity teenagersModeSetPasswordActivity = TeenagersModeSetPasswordActivity.this;
                aVarC.h(teenagersModeSetPasswordActivity, teenagersModeSetPasswordActivity.q.getVcText(), new a());
                return;
            }
            TeenagersModeSetPasswordActivity.this.w.setText("两次密码输入不一致！请重新输入");
            TeenagersModeSetPasswordActivity.this.q.clearVcText();
            TeenagersModeSetPasswordActivity.this.s.clearVcText();
            TeenagersModeSetPasswordActivity.this.r.setText("");
            TeenagersModeSetPasswordActivity.this.t.setText("");
            TeenagersModeSetPasswordActivity.this.q.requestFocus();
            TeenagersModeSetPasswordActivity.this.r.requestFocus();
            VerifyCodeView verifyCodeView = TeenagersModeSetPasswordActivity.this.s;
            verifyCodeView.hideBg = true;
            verifyCodeView.clearFocus();
            TeenagersModeSetPasswordActivity.this.t.clearFocus();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                TeenagersModeSetPasswordActivity teenagersModeSetPasswordActivity = TeenagersModeSetPasswordActivity.this;
                VerifyCodeView verifyCodeView = teenagersModeSetPasswordActivity.q;
                verifyCodeView.hideBg = false;
                teenagersModeSetPasswordActivity.s.hideBg = true;
                verifyCodeView.invalidate();
                TeenagersModeSetPasswordActivity.this.s.invalidate();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                TeenagersModeSetPasswordActivity teenagersModeSetPasswordActivity = TeenagersModeSetPasswordActivity.this;
                VerifyCodeView verifyCodeView = teenagersModeSetPasswordActivity.q;
                verifyCodeView.hideBg = true;
                teenagersModeSetPasswordActivity.s.hideBg = false;
                verifyCodeView.invalidate();
                TeenagersModeSetPasswordActivity.this.s.invalidate();
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_teenagers_mode_set_password);
        initToolbar("设置新密码");
        zn6.c("youth_password", "view");
        this.q = (VerifyCodeView) findViewById(R.id.verify_edit_square);
        this.r = (EditText) findViewById(R.id.verify_edit_square_test);
        this.w = (TextView) findViewById(R.id.error_txt);
        this.q.setEditText(this.r);
        this.q.setVisibility(0);
        this.q.setOnTextChangedListener(new a());
        this.s = (VerifyCodeView) findViewById(R.id.verify_edit_square1);
        EditText editText = (EditText) findViewById(R.id.verify_edit_square_test1);
        this.t = editText;
        this.s.setEditText(editText);
        this.s.setVisibility(0);
        this.s.setOnTextChangedListener(new b());
        this.r.setOnFocusChangeListener(new c());
        this.t.setOnFocusChangeListener(new d());
        this.q.hideInput = true;
        VerifyCodeView verifyCodeView = this.s;
        verifyCodeView.hideInput = true;
        verifyCodeView.clearFocus();
        this.t.clearFocus();
        this.s.hideBg = true;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        KeyboardKt.a(this.r, this, Keyboard$SHOW_FLAG.IMPLICIT, 300L);
    }
}
