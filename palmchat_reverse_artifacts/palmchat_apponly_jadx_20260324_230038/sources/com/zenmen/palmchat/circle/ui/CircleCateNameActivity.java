package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.c70;
import defpackage.j70;
import defpackage.sy5;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleCateNameActivity extends BaseActionBarActivity {
    public String q;
    public String r;
    public Toolbar s;
    public ClearEditText t;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13085a;

        public a(String str) {
            this.f13085a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse.getResultCode() == 0) {
                c70.R().C0(false, new String[0]);
                CircleCateNameActivity.this.D1(this.f13085a);
                sy5.e(CircleCateNameActivity.this, R.string.send_success, 0).g();
            } else {
                CircleCateNameActivity.this.hideBaseProgressBar();
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleCateNameActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleCateNameActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(View view) {
        String string = this.t.getText().toString();
        if (string.length() > 8) {
            sy5.f(this, "最大8个字符", 0).g();
        } else {
            showBaseProgressBar();
            c70.R().F0(this.q, string, new a(string));
        }
    }

    public final void D1(String str) {
        E1();
        Intent intent = new Intent();
        intent.putExtra("cateName", str);
        setResult(-1, intent);
        finish();
    }

    public final void E1() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.t.getWindowToken(), 0);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_cate_name_edit);
        this.q = getIntent().getStringExtra(j70.f18338a);
        this.r = getIntent().getStringExtra("cateName");
        Toolbar toolbarInitToolbar = initToolbar("");
        this.s = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.title_edit_group_cate);
        setSupportActionBar(this.s);
        TextView textView = (TextView) this.s.findViewById(R.id.action_button);
        textView.setText(R.string.circle_ok);
        textView.setOnClickListener(new View.OnClickListener() { // from class: e70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17227a.F1(view);
            }
        });
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.circle_input_desc);
        this.t = clearEditText;
        clearEditText.requestFocus();
        this.t.setClearDrawable(R.drawable.ic_edittext_clear_gray, R.drawable.ic_edittext_clear_gray);
        this.t.addTextChangedListener(new b(textView));
        KeyboardKt.a(this.t, this, Keyboard$SHOW_FLAG.IMPLICIT, 100L);
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        this.t.setText(this.r);
        this.t.setSelection(this.r.length());
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        E1();
        finish();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f13086a;

        public b(TextView textView) {
            this.f13086a = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (CircleCateNameActivity.this.t.getText().toString().trim().length() > 0) {
                this.f13086a.setEnabled(true);
            } else {
                this.f13086a.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
