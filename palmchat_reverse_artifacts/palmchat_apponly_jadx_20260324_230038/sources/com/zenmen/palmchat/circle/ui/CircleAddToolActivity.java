package com.zenmen.palmchat.circle.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.a66;
import defpackage.c70;
import defpackage.hc2;
import defpackage.j56;
import defpackage.k86;
import defpackage.sy5;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleAddToolActivity extends BaseActionBarActivity {
    public String A;
    public String B;
    public EffectiveShapeView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public DatingGroupToolBeans.DatingGroupToolBean v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<String>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<String> baseResponse) {
            CircleAddToolActivity.this.hideBaseProgressBar();
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                if (baseResponse == null || TextUtils.isEmpty(baseResponse.getErrorMsg())) {
                    return;
                }
                Toast.makeText(CircleAddToolActivity.this, baseResponse.getErrorMsg(), 0).show();
                return;
            }
            if (CircleAddToolActivity.this.v == null) {
                CircleAddToolActivity.this.v = new DatingGroupToolBeans.DatingGroupToolBean();
                CircleAddToolActivity.this.v.setId(baseResponse.getData());
                CircleAddToolActivity.this.v.setIcon(CircleAddToolActivity.this.y);
                CircleAddToolActivity.this.v.setToolName(CircleAddToolActivity.this.z);
                CircleAddToolActivity.this.v.setDescription(CircleAddToolActivity.this.A);
                CircleAddToolActivity.this.v.setToolPage(CircleAddToolActivity.this.B);
            }
            Intent intent = new Intent();
            intent.putExtra("key_result_dating_tools_info", CircleAddToolActivity.this.v);
            CircleAddToolActivity.this.setResult(-1, intent);
            CircleAddToolActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements j56 {
        public b() {
        }

        @Override // defpackage.j56
        public void onFailed(Throwable th) {
            CircleAddToolActivity.this.hideBaseProgressBar();
            sy5.e(CircleAddToolActivity.this, R.string.circle_cover_upload_fail, 0).g();
        }

        @Override // defpackage.j56
        public void onSuccess(String str, String str2) {
            CircleAddToolActivity.this.hideBaseProgressBar();
            CircleAddToolActivity.this.y = str;
            CircleAddToolActivity.this.x = str2;
            if (CircleAddToolActivity.this.v != null) {
                CircleAddToolActivity.this.v.setIcon(CircleAddToolActivity.this.y);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(View view) {
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_TOOL_IMAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(View view) {
        Intent intent = new Intent(this, (Class<?>) CircleToolInputActivity.class);
        intent.putExtra("intent_type", 101);
        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = this.v;
        if (datingGroupToolBean != null) {
            intent.putExtra("intent_data", datingGroupToolBean.getToolName());
        } else {
            intent.putExtra("intent_data", this.z);
        }
        startActivityForResult(intent, 101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(View view) {
        Intent intent = new Intent(this, (Class<?>) CircleToolInputActivity.class);
        intent.putExtra("intent_type", 102);
        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = this.v;
        if (datingGroupToolBean != null) {
            intent.putExtra("intent_data", datingGroupToolBean.getDescription());
        } else {
            intent.putExtra("intent_data", this.A);
        }
        startActivityForResult(intent, 102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V1(View view) {
        Intent intent = new Intent(this, (Class<?>) CircleToolInputActivity.class);
        intent.putExtra("intent_type", 103);
        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = this.v;
        if (datingGroupToolBean != null) {
            intent.putExtra("intent_data", datingGroupToolBean.getToolPage());
        } else {
            intent.putExtra("intent_data", this.B);
        }
        startActivityForResult(intent, 103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(View view) {
        X1();
    }

    public static void Z1(Activity activity, int i, String str) {
        a2(activity, i, str, null);
    }

    public static void a2(Activity activity, int i, String str, DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean) {
        Intent intent = new Intent(activity, (Class<?>) CircleAddToolActivity.class);
        if (datingGroupToolBean != null) {
            intent.putExtra("key_dating_tools_info", datingGroupToolBean);
        }
        intent.putExtra("key_dating_room_id", str);
        activity.startActivityForResult(intent, i);
    }

    public final boolean N1() {
        if (this.v != null) {
            return true;
        }
        if (TextUtils.isEmpty(this.z)) {
            Toast.makeText(this, "工具名称不能为空", 0).show();
            return false;
        }
        if (TextUtils.isEmpty(this.B)) {
            Toast.makeText(this, "跳转地址不能为空", 0).show();
            return false;
        }
        if (a66.a(this.B)) {
            return true;
        }
        Toast.makeText(this, "跳转地址不合法", 0).show();
        return false;
    }

    public final boolean O1() {
        this.v = (DatingGroupToolBeans.DatingGroupToolBean) getIntent().getSerializableExtra("key_dating_tools_info");
        String stringExtra = getIntent().getStringExtra("key_dating_room_id");
        this.w = stringExtra;
        return TextUtils.isEmpty(stringExtra);
    }

    public final void P1() {
        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = this.v;
        if (datingGroupToolBean != null) {
            if (!TextUtils.isEmpty(datingGroupToolBean.getIcon())) {
                this.r.setVisibility(4);
                this.q.setVisibility(0);
                hc2.b(this).load(this.v.getIcon()).error(R.drawable.icon_circle_tools_default).into(this.q);
            }
            Y1(this.s, this.v.getToolName());
            Y1(this.t, this.v.getDescription());
            Y1(this.u, this.v.getToolPage());
        }
    }

    public final void Q1() {
        findViewById(R.id.layout_tool_icon).setOnClickListener(new View.OnClickListener() { // from class: g60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17669a.S1(view);
            }
        });
        findViewById(R.id.layout_tool_name).setOnClickListener(new View.OnClickListener() { // from class: h60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17876a.T1(view);
            }
        });
        findViewById(R.id.layout_tool_introduce).setOnClickListener(new View.OnClickListener() { // from class: i60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18112a.U1(view);
            }
        });
        findViewById(R.id.layout_tool_jump).setOnClickListener(new View.OnClickListener() { // from class: j60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18332a.V1(view);
            }
        });
        findViewById(R.id.text_save).setOnClickListener(new View.OnClickListener() { // from class: k60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18583a.W1(view);
            }
        });
    }

    public final void R1() {
        setSupportActionBar(initToolbar(getString(R.string.circle_tool_custom)));
        this.q = (EffectiveShapeView) findViewById(R.id.image_tool_icon);
        this.r = (TextView) findViewById(R.id.text_icon_hint);
        this.s = (TextView) findViewById(R.id.text_name_hint);
        this.t = (TextView) findViewById(R.id.text_introduce_hint);
        this.u = (TextView) findViewById(R.id.text_jump_hint);
    }

    public final void X1() {
        if (N1()) {
            showBaseProgressBar("正在加载", false);
            c70 c70VarR = c70.R();
            String str = this.w;
            DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = this.v;
            c70VarR.i(str, datingGroupToolBean == null ? "" : datingGroupToolBean.getId(), this.x, this.z, this.A, this.B, new a());
        }
    }

    public final void Y1(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str)) {
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.color_black2));
        textView.setText(str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("media_pick_photo_key");
            if (k86.I(stringExtra)) {
                this.r.setVisibility(4);
                this.q.setVisibility(0);
                hc2.b(this).load(stringExtra).error(R.drawable.icon_circle_tools_default).into(this.q);
                showBaseProgressBar(getString(R.string.settings_uploading_cover), false);
                c70.R().H0(stringExtra, new b());
                return;
            }
            return;
        }
        if (i == 101 && i2 == -1) {
            if (intent != null) {
                String stringExtra2 = intent.getStringExtra("intent_result");
                if (TextUtils.isEmpty(stringExtra2)) {
                    return;
                }
                Y1(this.s, stringExtra2);
                this.z = stringExtra2;
                DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = this.v;
                if (datingGroupToolBean != null) {
                    datingGroupToolBean.setToolName(stringExtra2);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 102 && i2 == -1) {
            if (intent != null) {
                String stringExtra3 = intent.getStringExtra("intent_result");
                if (TextUtils.isEmpty(stringExtra3)) {
                    return;
                }
                Y1(this.t, stringExtra3);
                this.A = stringExtra3;
                DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean2 = this.v;
                if (datingGroupToolBean2 != null) {
                    datingGroupToolBean2.setDescription(stringExtra3);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 103 && i2 == -1 && intent != null) {
            String stringExtra4 = intent.getStringExtra("intent_result");
            if (TextUtils.isEmpty(stringExtra4)) {
                return;
            }
            Y1(this.u, stringExtra4);
            this.B = stringExtra4;
            DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean3 = this.v;
            if (datingGroupToolBean3 != null) {
                datingGroupToolBean3.setToolPage(stringExtra4);
            }
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_add_tool);
        if (O1()) {
            finish();
            return;
        }
        R1();
        Q1();
        P1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_TOOL_IMAGE) {
            Intent intent = new Intent(this, (Class<?>) MediaPickActivity.class);
            intent.putExtra("select_mode_key", 1);
            intent.putExtra("from", "from_person_info");
            startActivityForResult(intent, 1001);
        }
    }
}
