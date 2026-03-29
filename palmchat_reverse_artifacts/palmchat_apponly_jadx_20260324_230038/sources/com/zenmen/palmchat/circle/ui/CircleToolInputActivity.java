package com.zenmen.palmchat.circle.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import defpackage.a66;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleToolInputActivity extends BaseActionBarActivity {
    public int q = -1;
    public String r;
    public String s;
    public int t;
    public String u;
    public TextView v;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H1(EditText editText, View view) {
        if (editText.getText() == null) {
            return;
        }
        String strTrim = editText.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            return;
        }
        if (this.q == 103 && ((!strTrim.startsWith("http://") && !strTrim.startsWith("https://")) || !a66.a(strTrim))) {
            Toast.makeText(this, "地址不合法", 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("intent_result", strTrim);
        setResult(-1, intent);
        finish();
    }

    public final void F1() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        this.q = intent.getIntExtra("intent_type", -1);
        this.u = intent.getStringExtra("intent_data");
        switch (this.q) {
            case 101:
                this.r = getString(R.string.circle_tool_name);
                this.s = "请输入工具名称（最多四个汉字）";
                this.t = 4;
                break;
            case 102:
                this.r = getString(R.string.circle_tool_introduce);
                this.s = "请输入工具描述";
                this.t = 15;
                break;
            case 103:
                this.r = getString(R.string.circle_tool_jump);
                this.s = "请输入跳转链接";
                break;
            default:
                finish();
                break;
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void G1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        setSupportActionBar(toolbarInitToolbar);
        TextView textView = (TextView) getToolbar().findViewById(R.id.action_button);
        this.v = textView;
        textView.setText(R.string.modify_contact_info_finish);
        this.v.setEnabled(false);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(this.r);
        setSupportActionBar(toolbarInitToolbar);
        TextView textView2 = (TextView) findViewById(R.id.circle_input_desc_count);
        final EditText editText = (EditText) findViewById(R.id.circle_input_desc);
        TextView textView3 = (TextView) findViewById(R.id.circle_input_tip);
        if (this.t > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.t)});
        }
        editText.setHint(this.s);
        if (this.q == 102) {
            textView2.setText("0/" + this.t);
        }
        if (this.q == 101) {
            textView3.setText("工具名称最多4个汉字");
        }
        if (this.q == 103) {
            textView3.setText("地址请以http://xxx或https://xxx协议开始");
        }
        if (!TextUtils.isEmpty(this.u)) {
            editText.setText(this.u);
            editText.setSelection(this.u.length());
            if (this.q == 102) {
                textView2.setText(this.u.length() + "/" + this.t);
            }
        }
        editText.addTextChangedListener(new a(textView2));
        this.v.setOnClickListener(new View.OnClickListener() { // from class: nc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19487a.H1(editText, view);
            }
        });
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tool_input);
        F1();
        G1();
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f13256a;

        public a(TextView textView) {
            this.f13256a = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (CircleToolInputActivity.this.q == 102) {
                this.f13256a.setText(charSequence.length() + "/" + CircleToolInputActivity.this.t);
            }
            if (TextUtils.isEmpty(charSequence)) {
                CircleToolInputActivity.this.v.setEnabled(false);
            } else if (TextUtils.isEmpty(CircleToolInputActivity.this.u) || !CircleToolInputActivity.this.u.equals(charSequence.toString())) {
                CircleToolInputActivity.this.v.setEnabled(true);
            } else {
                CircleToolInputActivity.this.v.setEnabled(false);
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
