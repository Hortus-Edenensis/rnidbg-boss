package com.zenmen.palmchat.circle.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.bean.CircleApplyGroupType;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.c70;
import defpackage.dv0;
import defpackage.k86;
import defpackage.sd3;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleApplyGroupActivity extends BaseActionBarActivity {
    public String q;
    public TextView r;
    public EditText s;
    public CircleApplyGroupType t;
    public int u;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: com.zenmen.palmchat.circle.ui.CircleApplyGroupActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1008a extends MaterialDialog.e {
            public C1008a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(GroupInfoItem groupInfoItem) {
            if (groupInfoItem == null || CircleApplyGroupActivity.this.isFinishing()) {
                return;
            }
            Intent intent = new Intent(CircleApplyGroupActivity.this, (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", groupInfoItem);
            if (CircleApplyGroupActivity.this.u == 10) {
                intent.putExtra("fromType", 10);
            }
            k86.X(intent);
            CircleApplyGroupActivity.this.startActivity(intent);
            CircleApplyGroupActivity.this.finish();
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleApplyGroupActivity.this.hideBaseProgressBar();
            if (baseResponse == null) {
                return;
            }
            if (baseResponse.getResultCode() == 0) {
                CircleApplyGroupActivity.this.finish();
                return;
            }
            if (baseResponse.getResultCode() == 4001 || baseResponse.getResultCode() == 4006) {
                Toast.makeText(CircleApplyGroupActivity.this, baseResponse.getErrorMsg(), 0).show();
                c70.R().K(CircleApplyGroupActivity.this.t.getRoomId(), new dv0() { // from class: p60
                    @Override // defpackage.dv0
                    public final void onResponse(Object obj) {
                        this.f19947a.c((GroupInfoItem) obj);
                    }
                });
            } else {
                if (baseResponse.getResultCode() == 4027 || baseResponse.getResultCode() == 5077) {
                    new sd3(CircleApplyGroupActivity.this).k(baseResponse.getErrorMsg()).O(R.string.red_packet_timeout_know).f(new C1008a()).e().show();
                    return;
                }
                Toast.makeText(CircleApplyGroupActivity.this, baseResponse.getErrorMsg(), 0).show();
                if (baseResponse.getResultCode() == 5075) {
                    CircleApplyGroupActivity.this.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G1(View view) {
        H1();
    }

    public static void J1(Activity activity, CircleApplyGroupType circleApplyGroupType, int i, String str) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) CircleApplyGroupActivity.class);
        intent.putExtra("circle_apply_type_info", circleApplyGroupType);
        intent.putExtra("key_apply_group_source", i);
        intent.putExtra("join_circle_extra_data", str);
        activity.startActivity(intent);
    }

    public final boolean D1() {
        Intent intent = getIntent();
        this.t = (CircleApplyGroupType) intent.getSerializableExtra("circle_apply_type_info");
        this.u = intent.getIntExtra("key_apply_group_source", 0);
        this.q = intent.getStringExtra("join_circle_extra_data");
        if (this.u != 0) {
            return this.t == null;
        }
        throw new IllegalArgumentException("缺少applyGroupSource参数");
    }

    public final void E1() {
        CircleApplyGroupType circleApplyGroupType = this.t;
        if (circleApplyGroupType != null) {
            if (circleApplyGroupType.getIdentityCheck() != null && this.t.getIdentityCheck().getCheckType() != 1) {
                String checkQuestion = this.t.getIdentityCheck().getCheckQuestion();
                if (!TextUtils.isEmpty(checkQuestion)) {
                    this.r.setText(checkQuestion);
                    return;
                }
            }
            this.r.setText(R.string.circle_apply_group_default_question);
        }
    }

    public final void F1() {
        I1();
        this.r = (TextView) findViewById(R.id.circle_apply_group_title);
        this.s = (EditText) findViewById(R.id.circle_apply_group_edit_content);
    }

    public final void H1() {
        CircleApplyGroupType.CheckMode identityCheck;
        CircleApplyGroupType circleApplyGroupType = this.t;
        if (circleApplyGroupType == null || (identityCheck = circleApplyGroupType.getIdentityCheck()) == null) {
            return;
        }
        int checkType = identityCheck.getCheckType();
        if (checkType != 2) {
            if (checkType == 3) {
                if (!identityCheck.getCheckAnswer().equals(this.s.getText().toString())) {
                    Toast.makeText(this, "回答错误！", 0).show();
                    return;
                }
            }
        } else if (TextUtils.isEmpty(this.s.getText().toString())) {
            Toast.makeText(this, "回答不能为空", 0).show();
            return;
        }
        showBaseProgressBar();
        c70.R().j(this.t.getRoomId(), this.u, this.s.getText().toString(), this.q, new a());
    }

    public final void I1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.circle_join_proposal);
        setSupportActionBar(toolbarInitToolbar);
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.circle_join_proposal);
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.action_button);
        textView.setTextSize(16.0f);
        textView.setBackgroundDrawable(null);
        textView.setTextColor(getResources().getColor(R.color.text_color_222222));
        textView.setText(R.string.send);
        textView.setOnClickListener(new View.OnClickListener() { // from class: o60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19700a.G1(view);
            }
        });
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_apply_group);
        if (D1()) {
            finish();
        } else {
            F1();
            E1();
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
}
