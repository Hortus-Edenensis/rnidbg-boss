package com.zenmen.palmchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.DaemonConfig;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.loginnew.b;
import com.zenmen.palmchat.modulemanager.module.ZMDataSDKModule;
import com.zenmen.palmchat.peoplenearby.ad.d;
import com.zenmen.palmchat.peoplenearby.ad.e;
import com.zenmen.palmchat.utils.HttpsHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.ae2;
import defpackage.bp4;
import defpackage.di6;
import defpackage.dp4;
import defpackage.e52;
import defpackage.g13;
import defpackage.g9;
import defpackage.jo6;
import defpackage.k86;
import defpackage.kc3;
import defpackage.mp3;
import defpackage.ms;
import defpackage.ns;
import defpackage.og4;
import defpackage.pg4;
import defpackage.r75;
import defpackage.s15;
import defpackage.tg4;
import defpackage.ts2;
import defpackage.v63;
import defpackage.vq3;
import defpackage.vt0;
import defpackage.w50;
import defpackage.x63;
import defpackage.yn6;
import defpackage.zn6;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class InitActivity extends FrameworkBaseActivity {
    public ts2 r;
    public og4 s;
    public int q = 0;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public String x = null;
    public Handler y = new Handler(Looper.getMainLooper());
    public boolean z = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            InitActivity.this.r.s();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            BaseActivityPermissionDispatcher.b(InitActivity.this, BaseActivityPermissionDispatcher.PermissionType.CONTACT, BaseActivityPermissionDispatcher.PermissionUsage.INIT_CONTACT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G1() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        LogUtil.i("InitActivity", "startUpdateTaiChiConfig");
        DaemonConfig.n();
        di6.c();
        yn6.o(this);
        w50.F();
        vq3.s();
        d.p();
        e.L();
        ZMDataSDKModule.updateEnable();
        mp3.d();
        e52.b();
        ms.i();
        ns.c().g(AppContext.getContext());
        g9.h();
        LogUtil.i("InitActivity", "endUpdateTaiChiConfig, totalTime: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
    }

    public void C1() {
        if (pg4.a()) {
            this.t = true;
            D1();
        } else {
            if (this.t || this.s.h()) {
                return;
            }
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.INITB, BaseActivityPermissionDispatcher.PermissionUsage.INITB);
        }
    }

    public final void D1() {
        ac1.k(this);
        if (!v63.b() || tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList)) {
            this.r.s();
        } else {
            v63.c(this, new a());
        }
    }

    public int E1() {
        return this.q;
    }

    public boolean F1() {
        return this.s.h();
    }

    public final void H1() {
        getIntent();
    }

    public final boolean I1() {
        Intent intent = getIntent();
        if (intent != null) {
            Set<String> categories = intent.getCategories();
            if ((intent.getFlags() & 4194304) != 0 && categories != null && categories.contains("android.intent.category.LAUNCHER")) {
                return true;
            }
        }
        return false;
    }

    public final void J1(Bundle bundle) {
        try {
            Intent intent = getIntent();
            boolean z = false;
            this.v = intent.getBooleanExtra("key_has_share", false);
            this.w = intent.getBooleanExtra("key_is_from_opensdk", false);
            this.x = intent.getStringExtra("_lxapi_appid");
            this.q = intent.getIntExtra("key_from", 0);
            com.zenmen.palmchat.utils.a aVarE = com.zenmen.palmchat.utils.a.E();
            if (this.q == 2 && jo6.z()) {
                z = true;
            }
            aVarE.C0(z);
            if (this.q == 1) {
                LogUtil.uploadInfoImmediate("ar04", null, null, null);
                DaemonConfig.h(this);
            }
            int i = this.q;
            if (i == 2 || i == 3) {
                bp4.g();
                dp4.a().g(this.q == 3 ? 3 : 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void K1(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = null;
        try {
            ae2.g(jSONObject, null);
            JSONArray jSONArray = jSONObject.getJSONArray("modRooms");
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject2 = jSONArray.getJSONObject(0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject2 != null) {
            Intent intent = new Intent(this, (Class<?>) ChatterActivity.class);
            GroupInfoItem groupInfoItem = new GroupInfoItem();
            groupInfoItem.setGroupId(jSONObject2.optString("id"));
            groupInfoItem.setGroupHeadImgUrl(jSONObject2.optString("headImgUrl"));
            groupInfoItem.setGroupName(jSONObject2.optString("name"));
            intent.putExtra("chat_item", groupInfoItem);
            k86.X(intent);
            startActivity(intent);
        }
    }

    public final void L1() {
        new g13(new Runnable() { // from class: ss2
            @Override // java.lang.Runnable
            public final void run() {
                this.f20831a.G1();
            }
        }).start();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            ts2 ts2Var = this.r;
            if (ts2Var == null || !ts2Var.q()) {
                super.onBackPressed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        kc3.c().o(getIntent());
        setNeedCheckInitPermission(false);
        setNeedShowKickOutDialog(false);
        super.onCreate(bundle);
        H1();
        LogUtil.i("InitActivity", "onCreate");
        J1(bundle);
        if (r75.d(AppContext.getContext(), "is_first_launch", true)) {
            com.zenmen.palmchat.utils.a.E().F0(AppContext.getContext(), null, 1);
        }
        vt0.d().m();
        L1();
        b.u().o();
        this.s = new og4(this);
        this.r = new ts2(this);
        if (I1()) {
            finish();
            return;
        }
        this.r.r(getIntent());
        s15.a(this);
        LogUtil.i("zxHostName", "initactivity");
        HttpsHelper.getmInstance();
        HttpsHelper.writeHostName();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtil.i("InitActivity", "onNewIntent");
        ts2 ts2Var = this.r;
        if (ts2Var != null) {
            ts2Var.t(intent);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.r.u();
        LogUtil.i("InitActivity", "onPause");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        BaseActivityPermissionDispatcher.PermissionUsage permissionUsage2 = BaseActivityPermissionDispatcher.PermissionUsage.INITA2;
        if (permissionUsage != permissionUsage2 && permissionUsage != BaseActivityPermissionDispatcher.PermissionUsage.INITB) {
            if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.INIT_CONTACT) {
                this.r.s();
                return;
            }
            return;
        }
        BaseActivityPermissionDispatcher.PermissionType permissionType2 = BaseActivityPermissionDispatcher.PermissionType.INITB;
        if (permissionType == permissionType2) {
            if (this.t || this.s.h()) {
                return;
            }
            BaseActivityPermissionDispatcher.b(this, permissionType2, BaseActivityPermissionDispatcher.PermissionUsage.INITB);
            return;
        }
        if (permissionUsage == permissionUsage2) {
            HashMap<String, Object> mapD = x63.d();
            mapD.put("result", "prohibit");
            LogUtil.uploadInfoImmediate("lx_client_login_devicepopclick", mapD);
            zn6.j("lx_client_login_devicepopclick", "click", mapD);
        }
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_init_permission_deny_timestamp", Long.valueOf(System.currentTimeMillis()));
        D1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDialogCancel(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDialogCancel(permissionType, permissionUsage);
        if (pg4.a()) {
            D1();
        } else {
            finish();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDialogConfirm(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDialogConfirm(permissionType, permissionUsage);
        if (pg4.a()) {
            this.u = true;
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        BaseActivityPermissionDispatcher.PermissionUsage permissionUsage2 = BaseActivityPermissionDispatcher.PermissionUsage.INITA2;
        if (permissionUsage != permissionUsage2 && permissionUsage != BaseActivityPermissionDispatcher.PermissionUsage.INITB) {
            if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.INIT_CONTACT) {
                this.r.s();
            }
        } else {
            if (this.t) {
                return;
            }
            this.t = true;
            if (permissionUsage == permissionUsage2) {
                HashMap<String, Object> mapD = x63.d();
                mapD.put("result", "agree");
                LogUtil.uploadInfoImmediate("lx_client_login_devicepopclick", mapD);
                zn6.j("lx_client_login_devicepopclick", "click", mapD);
            }
            D1();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LogUtil.i("InitActivity", "onResume");
        this.r.v();
        if (r75.l()) {
            if (this.u) {
                D1();
                this.u = false;
            } else if (!this.z && !pg4.a() && !this.t && !this.s.h()) {
                BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.INITB, BaseActivityPermissionDispatcher.PermissionUsage.INITB);
            }
            ac1.k(this);
        }
        this.z = false;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        LogUtil.i("InitActivity", "onStart");
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LogUtil.i("InitActivity", "onStop");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        LogUtil.i("InitActivity", "onWindowFocusChanged" + z);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void showPermissionDescriptionDialog(BaseActivityPermissionDispatcher.b bVar, BaseActivityPermissionDispatcher.PermissionType permissionType) {
        this.s.i(bVar, permissionType);
    }
}
