package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.c70;
import defpackage.sy5;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleNameSettingActivity extends BaseActionBarActivity {
    public static String t = "circle_info";
    public ClearEditText q;
    public Button r;
    public GroupInfoItem s;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13199a;

        public b(String str) {
            this.f13199a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleNameSettingActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleNameSettingActivity.this, R.string.send_failed, 0).g();
                    return;
                } else {
                    sy5.f(CircleNameSettingActivity.this, baseResponse.getErrorMsg(), 0).g();
                    return;
                }
            }
            CircleNameSettingActivity.this.s.setGroupName(this.f13199a);
            CircleNameSettingActivity.this.startActivity(new Intent(CircleNameSettingActivity.this, (Class<?>) CircleCreateActivity.class));
            c70.R().C0(false, new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H1(View view) {
        E1();
    }

    public final void E1() {
        if (this.s == null) {
            return;
        }
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        String string = this.q.getText().toString();
        c70.R().v0(this.s.getGroupId(), string, new b(string));
    }

    public final void F1() {
        GroupInfoItem groupInfoItem = (GroupInfoItem) getIntent().getParcelableExtra(t);
        this.s = groupInfoItem;
        if (groupInfoItem == null) {
            return;
        }
        this.q.setText(!TextUtils.isEmpty(groupInfoItem.getGroupName()) ? this.s.getGroupName() : this.s.getGroupLocalName());
        ClearEditText clearEditText = this.q;
        clearEditText.setSelection(clearEditText.getText().toString().length());
    }

    public final void G1() {
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.circleNameEt);
        this.q = clearEditText;
        KeyboardKt.a(clearEditText, this, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
        this.q.setClearDrawable(R.drawable.ic_edittext_clear_gray, R.drawable.ic_edittext_clear_gray);
        Button button = (Button) findViewById(R.id.confirmBtn);
        this.r = button;
        button.setEnabled(false);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: va0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21389a.H1(view);
            }
        });
        this.q.addTextChangedListener(new a());
    }

    public final void I1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.circle_input_circle_name);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.circle_input_circle_name);
        TextView textView = (TextView) findViewById(R.id.action_button);
        textView.setBackgroundDrawable(null);
        textView.setText(R.string.circle_jump);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_name_setting);
        I1();
        G1();
        F1();
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
            if (CircleNameSettingActivity.this.q.getText().toString().trim().length() > 0) {
                CircleNameSettingActivity.this.r.setEnabled(true);
            } else {
                CircleNameSettingActivity.this.r.setEnabled(false);
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
