package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import defpackage.c70;
import defpackage.dv0;
import defpackage.j70;
import defpackage.k80;
import defpackage.mc1;
import defpackage.oc0;
import defpackage.qa0;
import defpackage.ry5;
import defpackage.wi0;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CirclePrivilageActivity extends BaseActionBarActivity {
    public View A;
    public View B;
    public TextView C;
    public k80 E;
    public GroupInfoItem q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public int v = 1001;
    public int w = 1002;
    public int x = 1003;
    public CheckBox y;
    public CheckBox z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse == null || baseResponse.getData() == null || !(baseResponse.getData() instanceof Map)) {
                return;
            }
            Object obj = ((Map) baseResponse.getData()).get("showHisSwitch");
            if (obj instanceof Double) {
                CirclePrivilageActivity.this.y.setChecked(((Double) obj).doubleValue() == 1.0d);
            }
        }
    }

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
                double dDoubleValue = ((Double) obj).doubleValue();
                CirclePrivilageActivity.this.q.setPermissionType((int) dDoubleValue);
                CirclePrivilageActivity.this.C.setText(1.0d == dDoubleValue ? R.string.circle_name_permit_admin_owner : R.string.circle_name_permit_all_member);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = CirclePrivilageActivity.this.getIntent();
            intent.setClass(CirclePrivilageActivity.this, CircleAdministratorActivity.class);
            CirclePrivilageActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = CirclePrivilageActivity.this.getIntent();
            intent.setClass(CirclePrivilageActivity.this, CircleForbiddenActivity.class);
            CirclePrivilageActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = CirclePrivilageActivity.this.getIntent();
            intent.setClass(CirclePrivilageActivity.this, CircleMemberListActivity.class);
            intent.putExtra("type", "transfer");
            CirclePrivilageActivity.this.startActivityForResult(intent, 122);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements mc1.a {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends wi0<BaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f13222a;

            public a(int i) {
                this.f13222a = i;
            }

            @Override // defpackage.wi0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(BaseResponse baseResponse) {
                CirclePrivilageActivity.this.hideBaseProgressBar();
                if (baseResponse != null) {
                    if (baseResponse.getResultCode() != 0) {
                        ry5.a(baseResponse.getErrorMsg());
                        return;
                    }
                    CirclePrivilageActivity.this.q.setPermissionType(this.f13222a);
                    CirclePrivilageActivity.this.C.setText(1 == this.f13222a ? R.string.circle_name_permit_admin_owner : R.string.circle_name_permit_all_member);
                    ry5.a(CirclePrivilageActivity.this.getString(R.string.send_success));
                    c70.R().C0(false, new String[0]);
                }
            }
        }

        public f() {
        }

        @Override // mc1.a
        public void a(int i) {
            CirclePrivilageActivity.this.showBaseProgressBar();
            c70.R().t(CirclePrivilageActivity.this.q.getGroupId(), i == 1, new a(i));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13223a;

        public g(boolean z) {
            this.f13223a = z;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CirclePrivilageActivity.this.hideBaseProgressBar();
            if (baseResponse != null) {
                if (baseResponse.getResultCode() == 0) {
                    ry5.a(CirclePrivilageActivity.this.getString(R.string.send_success));
                    c70.R().C0(false, new String[0]);
                } else {
                    CirclePrivilageActivity.this.y.setChecked(!this.f13223a);
                    if (CirclePrivilageActivity.this.E.d(CirclePrivilageActivity.this, baseResponse.getResultCode(), baseResponse.getErrorMsg())) {
                        return;
                    }
                    ry5.a(baseResponse.getErrorMsg());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends wi0<BaseResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f13224a;

        public h(boolean z) {
            this.f13224a = z;
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CirclePrivilageActivity.this.hideBaseProgressBar();
            if (baseResponse != null) {
                if (baseResponse.getResultCode() == 0) {
                    ry5.a(CirclePrivilageActivity.this.getString(R.string.send_success));
                    c70.R().C0(false, new String[0]);
                    return;
                }
                CirclePrivilageActivity.this.z.setChecked(!this.f13224a);
                String errorMsg = baseResponse.getErrorMsg();
                if (TextUtils.isEmpty(errorMsg)) {
                    errorMsg = "请求失败";
                }
                ry5.a(errorMsg);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements dv0<List<ContactInfoItem>> {
        public i() {
        }

        @Override // defpackage.dv0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(List<ContactInfoItem> list) {
            if (list != null && list.size() > 0) {
                CirclePrivilageActivity.this.s.setVisibility(8);
            } else {
                CirclePrivilageActivity.this.s.setVisibility(0);
                CirclePrivilageActivity.this.s.setText("无");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1(List list) {
        if (list == null || list.size() <= 0) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.r.setText("禁言" + list.size() + "人");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1(View view) {
        W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(View view) {
        V1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(View view) {
        Intent intent = new Intent(this, (Class<?>) CircleEditWelcomeActivity.class);
        intent.putExtra(j70.f18338a, this.q.getGroupId());
        intent.putExtra("intent_wel_content", this.q.getWelContent());
        startActivityForResult(intent, this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(View view) {
        Intent intent = new Intent(this, (Class<?>) CircleChooseSearchFunActivity.class);
        intent.putExtra("groupId", this.q.getGroupId());
        intent.putExtra("recmdSwitch", this.q.getRecmdSwitch());
        intent.putExtra("fromtype", "0");
        startActivityForResult(intent, this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(View view) {
        Intent intent = new Intent(this, (Class<?>) CircleJoinSettingActivity.class);
        intent.putExtra("key_group_info", this.q);
        startActivityForResult(intent, this.v);
    }

    public final void O1() {
        c70.R().L(this.q.getGroupId(), 2, new i());
        if (this.q.getDiffuse() != 1) {
            c70.R().O(this.q.getGroupId(), new dv0() { // from class: db0
                @Override // defpackage.dv0
                public final void onResponse(Object obj) {
                    this.f17011a.P1((List) obj);
                }
            });
        } else {
            this.r.setVisibility(0);
            this.r.setText("全员禁言");
        }
    }

    public final void V1() {
        Intent intent = new Intent(this, (Class<?>) CircleBlackListActivity.class);
        intent.putExtra("key_group_info", this.q);
        startActivity(intent);
    }

    public final void W1() {
        new mc1(this, this.q.getPermissionType(), new f()).show();
    }

    public final void X1(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            showBaseProgressBar();
            qa0.i().o(this.q.getGroupId(), z, new h(z));
        }
    }

    public final void Y1(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            showBaseProgressBar();
            qa0.i().p(this.q.getGroupId(), z, new g(z));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int intExtra;
        GroupInfoItem groupInfoItem;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 122 && i3 == -1) {
        }
        if (i2 == this.v && i3 == -1 && (groupInfoItem = (GroupInfoItem) intent.getParcelableExtra("key_group_info")) != null) {
            this.q.setAddType(groupInfoItem.getAddType());
            this.q.setInviteSwitch(groupInfoItem.getInviteSwitch());
            this.q.setInviteCheckSwitch(groupInfoItem.getInviteCheckSwitch());
            Intent intent2 = new Intent();
            intent2.putExtra("key_group_info", this.q);
            setResult(-1, intent2);
        }
        if (i2 == this.w && i3 == -1 && (intExtra = intent.getIntExtra("recmdSwitch", -1)) != -1) {
            this.q.setRecmdSwitch(intExtra);
            Intent intent3 = new Intent();
            intent3.putExtra("key_group_info", this.q);
            setResult(-1, intent3);
        }
        if (i2 == this.x && i3 == -1) {
            String stringExtra = intent.getStringExtra("intent_wel_content");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.q.setWelContent(stringExtra);
            Intent intent4 = new Intent();
            intent4.putExtra("key_group_info", this.q);
            setResult(-1, intent4);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_privilage);
        setSupportActionBar(initToolbar(R.string.circle_member_manager));
        this.q = (GroupInfoItem) getIntent().getParcelableExtra("key_group_info");
        View viewFindViewById = findViewById(R.id.layout_circle_member_manage);
        View viewFindViewById2 = findViewById(R.id.layout_circle_member_forbidden);
        View viewFindViewById3 = findViewById(R.id.layout_circle_transfer);
        View viewFindViewById4 = findViewById(R.id.layout_circle_group_join);
        View viewFindViewById5 = findViewById(R.id.layout_circle_group_search);
        View viewFindViewById6 = findViewById(R.id.layout_circle_group_welcome);
        this.B = findViewById(R.id.ll_circle_allow_add_friend);
        this.z = (CheckBox) findViewById(R.id.circle_allow_add_friend_checkbox);
        this.t = (TextView) findViewById(R.id.text_join_detail);
        this.u = (TextView) findViewById(R.id.text_search);
        findViewById(R.id.ll_circle_allow_see_history_wrapper).setVisibility((oc0.f() && oc0.a()) ? 0 : 8);
        this.A = findViewById(R.id.layout_circle_group_name_modify_block);
        this.C = (TextView) findViewById(R.id.tv_circle_name_modify_permission);
        this.A.setVisibility((this.q.getRoleType() == 1 && oc0.f() && oc0.b()) ? 0 : 8);
        this.A.setOnClickListener(new View.OnClickListener() { // from class: eb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17253a.Q1(view);
            }
        });
        findViewById(R.id.circle_black_name_list_rl).setOnClickListener(new View.OnClickListener() { // from class: fb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17494a.R1(view);
            }
        });
        this.y = (CheckBox) findViewById(R.id.circle_allow_see_history_checkbox);
        if (oc0.f() && oc0.a()) {
            this.y.setChecked(this.q.getShowHisSwitch() == 1);
            c70.R().n0(this.q.getGroupId(), new a());
        }
        if (this.q.getRoleType() == 1 && oc0.f() && oc0.b()) {
            this.C.setText(1 == this.q.getPermissionType() ? R.string.circle_name_permit_admin_owner : R.string.circle_name_permit_all_member);
            c70.R().m0(this.q.getGroupId(), new b());
        }
        if ((this.q.getRoleType() == 1 || this.q.getRoleType() == 2) && oc0.f()) {
            this.B.setVisibility(0);
            this.z.setChecked(this.q.getAddFriendSwitch() == 1);
        } else {
            this.B.setVisibility(8);
        }
        this.y.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: gb0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f17695a.Y1(compoundButton, z);
            }
        });
        this.z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: hb0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f17906a.X1(compoundButton, z);
            }
        });
        viewFindViewById6.setOnClickListener(new View.OnClickListener() { // from class: ib0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18140a.S1(view);
            }
        });
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: jb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18368a.T1(view);
            }
        });
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: kb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18613a.U1(view);
            }
        });
        viewFindViewById.setVisibility(this.q.getRoleType() == 1 ? 0 : 8);
        viewFindViewById.setOnClickListener(new c());
        viewFindViewById2.setOnClickListener(new d());
        viewFindViewById3.setOnClickListener(new e());
        this.s = (TextView) findViewById(R.id.managerNumTv);
        this.r = (TextView) findViewById(R.id.forbiddenNumTv);
        this.E = new k80(this.q);
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
        O1();
    }
}
