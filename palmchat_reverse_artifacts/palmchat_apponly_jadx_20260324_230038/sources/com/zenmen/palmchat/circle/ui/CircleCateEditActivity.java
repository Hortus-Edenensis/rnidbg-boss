package com.zenmen.palmchat.circle.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleCateItem;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.c70;
import defpackage.l50;
import defpackage.sy5;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleCateEditActivity extends BaseActionBarActivity {
    public ClearEditText q;
    public TextView r;
    public String s;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse<CircleCateItem>> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleCateItem> baseResponse) {
            CircleCateEditActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                c70.R().C0(false, new String[0]);
                CircleCateEditActivity.this.setResult(-1);
                CircleCateEditActivity.this.finish();
            } else if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                sy5.e(CircleCateEditActivity.this, R.string.send_failed, 0).g();
            } else {
                sy5.f(CircleCateEditActivity.this, baseResponse.getErrorMsg(), 0).g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(View view) {
        if (l50.a()) {
            return;
        }
        H1();
    }

    public final void D1() {
        this.s = getIntent().getStringExtra("extra_groupid");
    }

    public final void E1() {
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.edit);
        this.q = clearEditText;
        KeyboardKt.a(clearEditText, this, Keyboard$SHOW_FLAG.IMPLICIT, 200L);
        this.q.setClearDrawable(R.drawable.ic_edittext_clear_gray, R.drawable.ic_edittext_clear_gray);
        this.q.addTextChangedListener(new a());
    }

    public final void G1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.circle_cate_edit);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.circle_cate_edit);
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.r = textView;
        textView.setText(R.string.circle_ok);
        this.r.setEnabled(false);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: d70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16991a.F1(view);
            }
        });
    }

    public final void H1() {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        c70.R().v(this.s, this.q.getText().toString(), new b());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_cate_edit);
        G1();
        E1();
        D1();
        if (TextUtils.isEmpty(this.s)) {
            finish();
        }
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
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (CircleCateEditActivity.this.q.getText().toString().trim().length() > 0) {
                CircleCateEditActivity.this.r.setEnabled(true);
            } else {
                CircleCateEditActivity.this.r.setEnabled(false);
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
