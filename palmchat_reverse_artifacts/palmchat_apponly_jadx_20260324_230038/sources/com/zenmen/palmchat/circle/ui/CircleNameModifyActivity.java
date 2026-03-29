package com.zenmen.palmchat.circle.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import defpackage.dt2;
import defpackage.k80;
import defpackage.ry5;
import defpackage.sy5;
import defpackage.wi0;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleNameModifyActivity extends BaseActionBarActivity {
    public Toolbar q;
    public ClearEditText r;
    public TextView s;
    public TextView t;
    public GroupInfoItem u;
    public CheckBox v;
    public k80 w;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse == null || baseResponse.getData() == null || !(baseResponse.getData() instanceof Map)) {
                return;
            }
            Object obj = ((Map) baseResponse.getData()).get("permissionType");
            if (obj instanceof Double) {
                int iDoubleValue = (int) ((Double) obj).doubleValue();
                CircleNameModifyActivity.this.u.setPermissionType(iDoubleValue);
                CircleNameModifyActivity.this.N1(iDoubleValue);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13196a;

        public c(boolean z) {
            this.f13196a = z;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleNameModifyActivity.this.hideBaseProgressBar();
            if (baseResponse != null) {
                if (baseResponse.getResultCode() == 0) {
                    ry5.a(CircleNameModifyActivity.this.getString(R.string.send_success));
                    c70.R().C0(false, new String[0]);
                } else {
                    CircleNameModifyActivity.this.v.setChecked(!this.f13196a);
                    ry5.a(TextUtils.isEmpty(baseResponse.getErrorMsg()) ? "网络异常" : baseResponse.getErrorMsg());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13197a;

        public d(String str) {
            this.f13197a = str;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleNameModifyActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                if (CircleNameModifyActivity.this.w.d(CircleNameModifyActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                ry5.a(TextUtils.isEmpty(baseResponse.getErrorMsg()) ? "网络异常" : baseResponse.getErrorMsg());
            } else {
                c70.R().C0(false, new String[0]);
                Intent intent = new Intent();
                intent.putExtra("circleName", this.f13197a);
                CircleNameModifyActivity.this.setResult(-1, intent);
                CircleNameModifyActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I1(View view) {
        L1();
    }

    public static void K1(Activity activity, GroupInfoItem groupInfoItem) {
        Intent intent = new Intent(activity, (Class<?>) CircleNameModifyActivity.class);
        intent.putExtra("key_group_info", groupInfoItem);
        activity.startActivityForResult(intent, 987);
    }

    public final void H1() {
        this.u = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
    }

    public final void J1() {
        Toolbar toolbarInitToolbar = initToolbar(0);
        this.q = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.group_name);
        TextView textView = (TextView) this.q.findViewById(R.id.action_button);
        this.t = textView;
        textView.setText(R.string.circle_finish);
        this.t.setTextColor(getResources().getColorStateList(R.color.toolbar_btn_text_color_btn));
        this.t.setBackgroundDrawable(null);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: ta0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20938a.I1(view);
            }
        });
        setSupportActionBar(this.q);
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.et_circle_name);
        this.r = clearEditText;
        GroupInfoItem groupInfoItem = this.u;
        if (groupInfoItem == null) {
            finish();
            return;
        }
        clearEditText.setText(groupInfoItem.getGroupName());
        ClearEditText clearEditText2 = this.r;
        clearEditText2.setSelection(clearEditText2.getText().length());
        this.r.setClearDrawable(R.drawable.ic_edittext_clear_gray, R.drawable.ic_edittext_clear_gray);
        this.t.setEnabled(!TextUtils.isEmpty(this.r.getText()));
        this.s = (TextView) findViewById(R.id.circle_name_permission_tips);
        CheckBox checkBox = (CheckBox) findViewById(R.id.cb_circle_name_modify_permit);
        this.v = checkBox;
        checkBox.setVisibility(this.u.getRoleType() != 1 ? 8 : 0);
        this.v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ua0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f21171a.M1(compoundButton, z);
            }
        });
        KeyboardKt.a(this.r, this, Keyboard$SHOW_FLAG.IMPLICIT, 200L);
        this.r.addTextChangedListener(new a());
        c70.R().m0(this.u.getGroupId(), new b());
    }

    public final void L1() {
        String string = this.r.getText().toString();
        if (string.equals(this.u.getGroupName())) {
            finish();
        } else if (!dt2.a(string)) {
            sy5.e(AppContext.getContext(), R.string.group_name_empty_alert, 0).g();
        } else {
            c70.R().v0(this.u.getGroupId(), string, new d(string));
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        }
    }

    public final void M1(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            showBaseProgressBar();
            c70.R().t(this.u.getGroupId(), z, new c(z));
        }
    }

    public final void N1(int i) {
        if (this.u.getRoleType() == 1) {
            this.v.setChecked(i == 1);
            this.v.setVisibility(0);
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            return;
        }
        if (this.u.getRoleType() == 2) {
            this.t.setVisibility(0);
            this.v.setVisibility(8);
            if (i == 0) {
                this.s.setVisibility(8);
                return;
            } else {
                this.s.setVisibility(0);
                return;
            }
        }
        if (this.u.getRoleType() == 3) {
            this.v.setVisibility(8);
            if (i == 0) {
                this.s.setVisibility(8);
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
                this.s.setVisibility(0);
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_name_modify_layout);
        H1();
        J1();
        this.w = new k80(this.u);
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
        public void afterTextChanged(Editable editable) {
            CircleNameModifyActivity.this.t.setEnabled(editable.length() > 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
