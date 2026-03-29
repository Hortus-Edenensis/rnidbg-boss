package com.zenmen.palmchat.circle.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.c70;
import defpackage.k80;
import defpackage.sy5;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleJoinSettingActivity extends BaseActionBarActivity {
    public int A = -1;
    public int B = -1;
    public int C = -1;
    public GroupInfoItem E;
    public LinearLayout F;
    public k80 G;
    public RelativeLayout q;
    public ImageView r;
    public RelativeLayout s;
    public ImageView t;
    public RelativeLayout u;
    public ImageView v;
    public RelativeLayout w;
    public RelativeLayout x;
    public CheckBox y;
    public CheckBox z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<GroupInfoItem>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<GroupInfoItem> baseResponse) {
            CircleJoinSettingActivity.this.hideBaseProgressBar();
            CircleJoinSettingActivity.this.E = baseResponse.getData();
            CircleJoinSettingActivity circleJoinSettingActivity = CircleJoinSettingActivity.this;
            circleJoinSettingActivity.A = circleJoinSettingActivity.E.getAddType();
            CircleJoinSettingActivity circleJoinSettingActivity2 = CircleJoinSettingActivity.this;
            circleJoinSettingActivity2.B = circleJoinSettingActivity2.E.getInviteSwitch();
            CircleJoinSettingActivity circleJoinSettingActivity3 = CircleJoinSettingActivity.this;
            circleJoinSettingActivity3.C = circleJoinSettingActivity3.E.getInviteCheckSwitch();
            CircleJoinSettingActivity.this.S1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13173a;

        public b(int i) {
            this.f13173a = i;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleJoinSettingActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                CircleJoinSettingActivity.this.A = this.f13173a;
                CircleJoinSettingActivity.this.a2();
            } else {
                if (CircleJoinSettingActivity.this.G.d(CircleJoinSettingActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleJoinSettingActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleJoinSettingActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13174a;

        public c(int i) {
            this.f13174a = i;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleJoinSettingActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                CircleJoinSettingActivity.this.A = this.f13174a;
                CircleJoinSettingActivity.this.a2();
            } else {
                if (CircleJoinSettingActivity.this.G.d(CircleJoinSettingActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleJoinSettingActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleJoinSettingActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13175a;

        public d(int i) {
            this.f13175a = i;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleJoinSettingActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                CircleJoinSettingActivity.this.B = this.f13175a;
                CircleJoinSettingActivity.this.Z1();
            } else {
                if (CircleJoinSettingActivity.this.G.d(CircleJoinSettingActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleJoinSettingActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleJoinSettingActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13176a;

        public e(int i) {
            this.f13176a = i;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleJoinSettingActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() == 0) {
                CircleJoinSettingActivity.this.C = this.f13176a;
                CircleJoinSettingActivity.this.Y1();
            } else {
                if (CircleJoinSettingActivity.this.G.d(CircleJoinSettingActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                    return;
                }
                if (TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    sy5.e(CircleJoinSettingActivity.this, R.string.send_failed, 0).g();
                } else {
                    sy5.f(CircleJoinSettingActivity.this, baseResponse.getErrorMsg(), 0).g();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(View view) {
        b2(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(View view) {
        b2(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V1(View view) {
        b2(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(CompoundButton compoundButton, boolean z) {
        R1(z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(CompoundButton compoundButton, boolean z) {
        P1(z ? 1 : 0);
    }

    public final void P1(int i) {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        c70.R().p(this.E.getGroupId(), this.A, this.B, i, new e(i));
    }

    public final void Q1(int i) {
        if (i == 2) {
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            c70.R().s(this.E.getGroupId(), i, new b(i));
        } else {
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            c70.R().r(this.E.getGroupId(), i, new c(i));
        }
    }

    public final void R1(int i) {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        c70.R().q(this.E.getGroupId(), this.A, i, this.C, new d(i));
    }

    public final void S1() {
        this.q = (RelativeLayout) findViewById(R.id.rl_allow_all);
        this.r = (ImageView) findViewById(R.id.image_allow_all);
        this.s = (RelativeLayout) findViewById(R.id.rl_need_check);
        this.t = (ImageView) findViewById(R.id.image_need_check);
        this.u = (RelativeLayout) findViewById(R.id.rl_forbid_all);
        this.v = (ImageView) findViewById(R.id.image_forbid_all);
        this.w = (RelativeLayout) findViewById(R.id.rl_allow_member_invite);
        this.y = (CheckBox) findViewById(R.id.checkbox_allow_member_invite);
        this.x = (RelativeLayout) findViewById(R.id.rl_admin_check);
        this.z = (CheckBox) findViewById(R.id.checkbox_admin_check);
        this.F = (LinearLayout) findViewById(R.id.lin_check);
        a2();
        Z1();
        Y1();
        this.q.setOnClickListener(new View.OnClickListener() { // from class: u90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21161a.T1(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: v90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21384a.U1(view);
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: w90
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21641a.V1(view);
            }
        });
        this.y.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: x90
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f21905a.W1(compoundButton, z);
            }
        });
        this.z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: y90
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f22164a.X1(compoundButton, z);
            }
        });
    }

    public final void Y1() {
        if (this.C == 1) {
            this.z.setChecked(true);
        } else {
            this.z.setChecked(false);
        }
    }

    public final void Z1() {
        if (this.B == 1) {
            this.y.setChecked(true);
            this.x.setVisibility(0);
        } else {
            this.y.setChecked(false);
            this.x.setVisibility(8);
        }
    }

    public final void a2() {
        int i = this.A;
        if (i == 1) {
            this.r.setVisibility(0);
            this.t.setVisibility(8);
            this.v.setVisibility(8);
            this.F.setVisibility(8);
            return;
        }
        if (i == 2) {
            this.r.setVisibility(8);
            this.t.setVisibility(0);
            this.v.setVisibility(8);
            this.F.setVisibility(0);
            return;
        }
        if (i != 3) {
            return;
        }
        this.r.setVisibility(8);
        this.t.setVisibility(8);
        this.v.setVisibility(0);
        this.F.setVisibility(8);
    }

    public final void b2(int i) {
        if (this.A == i) {
            return;
        }
        Q1(i);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_group_join);
        setSupportActionBar(initToolbar("加群方式"));
        GroupInfoItem groupInfoItem = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
        if (groupInfoItem == null) {
            finish();
            return;
        }
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        c70.R().S(groupInfoItem.getGroupId(), new a());
        this.G = new k80(groupInfoItem);
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
