package com.zenmen.palmchat.circle.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.c70;
import defpackage.j70;
import defpackage.k80;
import defpackage.oc0;
import defpackage.sy5;
import defpackage.wi0;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleEditDescActivity extends BaseActionBarActivity {
    public String q;
    public Toolbar r;
    public EditText s;
    public TextView t;
    public TextView u;
    public String v;
    public k80 w;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleEditDescActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                if (CircleEditDescActivity.this.w.d(CircleEditDescActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                sy5.e(CircleEditDescActivity.this, R.string.send_failed, 0).g();
            } else {
                c70.R().C0(false, new String[0]);
                Intent intent = new Intent();
                intent.putExtra(LxAdDLManager.ITEM_DESC, CircleEditDescActivity.this.s.getText().toString());
                CircleEditDescActivity.this.setResult(-1, intent);
                CircleEditDescActivity.this.F1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K1(View view) {
        showBaseProgressBar();
        c70.R().u0(this.q, this.s.getText().toString(), new a());
    }

    public final void F1() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        finish();
    }

    public final boolean G1() {
        this.q = getIntent().getStringExtra(j70.f18338a);
        this.v = getIntent().getStringExtra(j70.h);
        return TextUtils.isEmpty(this.q);
    }

    public final void H1() {
        if (!TextUtils.isEmpty(this.v)) {
            this.s.setText(this.v);
            this.s.setSelection(this.v.length());
        }
        this.s.setMaxEms(200);
    }

    public final void I1() {
        this.u.setOnClickListener(new View.OnClickListener() { // from class: l80
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18927a.K1(view);
            }
        });
        this.s.addTextChangedListener(new b());
    }

    public final void J1() {
        Toolbar toolbarInitToolbar = initToolbar("");
        this.r = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.circle_description);
        setSupportActionBar(this.r);
        this.u = (TextView) this.r.findViewById(R.id.action_button);
        this.t = (TextView) findViewById(R.id.circle_input_desc_count);
        this.s = (EditText) findViewById(R.id.circle_input_desc);
        this.u.setTextSize(16.0f);
        this.u.setBackgroundDrawable(null);
        this.u.setTextColor(getResources().getColor(R.color.text_color_222222));
        this.u.setText(R.string.circle_finish);
        KeyboardKt.a(this.s, this, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_desc);
        if (G1()) {
            throw new IllegalArgumentException("缺失GroupId");
        }
        J1();
        I1();
        H1();
        HashMap map = new HashMap();
        map.put("rid", this.q);
        oc0.h("lx_group_edit_intro_show", map);
        this.w = new k80(this.q);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        F1();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        @SuppressLint({"SetTextI18n"})
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            CircleEditDescActivity.this.t.setText(charSequence.length() + "/200");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
