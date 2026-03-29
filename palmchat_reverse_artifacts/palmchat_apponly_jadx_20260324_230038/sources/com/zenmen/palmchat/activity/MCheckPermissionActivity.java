package com.zenmen.palmchat.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.zenmen.find.ConditionHelper;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.location.LocationEx;
import defpackage.a46;
import defpackage.b05;
import defpackage.bj5;
import defpackage.ry5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MCheckPermissionActivity extends BaseActionBarActivity {
    public LocationEx q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MCheckPermissionActivity.this.A1();
        }
    }

    public static void D1(Context context, LocationEx locationEx, boolean z, boolean z2, int i, int i2, int i3) {
        Intent intent = new Intent(context, (Class<?>) MCheckPermissionActivity.class);
        intent.putExtra("key_last_drift_location", locationEx);
        intent.putExtra("KEY_IS_FROM_OLD_NEARBY", z);
        intent.putExtra("KEY_IS_SHOW_SEPARATION_DIALOG", z2);
        intent.putExtra("KEY_CLICK_TYPE", i);
        intent.putExtra("KEY_FROM", i3);
        intent.putExtra("KEY_CLICK_POPTYPE", i2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void A1() {
        if (a46.o()) {
            if (a46.q()) {
                E1();
                return;
            } else {
                BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.FIND_NEARBY_MAP_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.FIND_NEARBY_MAP_GET_LOCATION);
                return;
            }
        }
        ry5.a("请打开位置服务");
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean B1() {
        return a46.o() && a46.q();
    }

    public final void C1() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.q = (LocationEx) intent.getParcelableExtra("key_last_drift_location");
        this.r = intent.getBooleanExtra("KEY_IS_FROM_OLD_NEARBY", false);
        this.s = intent.getBooleanExtra("KEY_IS_SHOW_SEPARATION_DIALOG", false);
        this.t = intent.getIntExtra("KEY_CLICK_TYPE", 0);
        this.u = intent.getIntExtra("KEY_CLICK_POPTYPE", 0);
        this.v = intent.getIntExtra("KEY_FROM", 0);
    }

    public final void E1() {
        bj5.b().a().i(this, ConditionHelper.getInstance().getDriftInfo().location, false, 0, this.u, false, this.v);
        finish();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mcheck_permission);
        C1();
        initToolbar("");
        A1();
        findViewById(R.id.btn_next).setOnClickListener(new a());
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        b05.d("onPermissionGrant=====>权限申请失败！");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        b05.d("onPermissionGrant=====>权限申请成功！");
        E1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (B1()) {
            b05.d("onResume=====>有权限了！");
            E1();
        }
    }
}
