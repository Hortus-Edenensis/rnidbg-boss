package com.zenmen.palmchat.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.PermissionDialogUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ap3;
import defpackage.b05;
import defpackage.ds0;
import defpackage.fk2;
import defpackage.go0;
import defpackage.is0;
import defpackage.k86;
import defpackage.kd5;
import defpackage.m5;
import defpackage.me1;
import defpackage.n5;
import defpackage.oy4;
import defpackage.p22;
import defpackage.pg4;
import defpackage.sd3;
import defpackage.sg4;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.v4;
import defpackage.vs0;
import defpackage.wn4;
import defpackage.zs1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FrameworkBaseActivity extends AppCompatActivity implements zs1.a {
    public static final int EXTRA_KET_FLOAT_VIEW = 11;
    public static final long KEY_HOC_TOAST_INTERVAL = 3000;
    public static final String PARAMS_INTENT_FINISH_FORWARD_URL = "backUrl";
    public static final String STASRT_REASON_BASEACTIVITY_ONRESUME = "STASRT_REASON_BASEACTIVITY_ONRESUME";
    public static final String TAG = "FrameworkBaseActivity";
    private static long lastHocTime;
    private String CLASS_NAME;
    public wn4 mBaseProgressDialog;
    public kd5 mSimpleProgressDialog;
    protected Toolbar mToolbar;
    public Activity sInstance;
    public static final String INTENT_ACTION_FINISH_ACTIVITY = k86.i("INTENT_ACTION_FINISH_ACTIVITY");
    public static final String INTENT_ACTION_UPDATE_CHECKED = k86.i("INTENT_ACTION_UPDATE_CHECKED");
    public static final String INTENT_ACTION_KICKOUT = k86.i("INTENT_ACTION_KICKOUT");
    public static final String INTENT_ACTION_LOGIN_REWARD = k86.i("INTENT_ACTION_LOGIN_REWARD");
    public static final String INTENT_ACTION_VOIP_PERMISSION = k86.i("INTENT_ACTION_VOIP_PERMISSION");
    public static final String INTENT_ACTION_HOC_TOAST = k86.i("INTENT_ACTION_HOC_TOAST");
    public static final String INTENT_ACTION_FLOATVIEW_PERMISSION_READY = k86.i("INTENT_ACTION_FLOATVIEW_PERMISSION_READY");
    public static final String ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED = k86.i("ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED");
    private boolean isPause = true;
    private is0 mCustomPopupMenuHelper = new is0();
    protected int mVoipPermission = 0;
    private boolean isNeedCheckInitPermission = true;
    private boolean needShowKickOutDialog = true;
    protected String INTENT_KEY_VOIP_PERMISSION = "VOIP_PERMISSION_TYPE";
    private boolean hasCheckStorage = false;
    private String backUrl = null;
    private BaseActivityPermissionDispatcher.PermissionUsage mPermissionUsage = BaseActivityPermissionDispatcher.PermissionUsage.NONE;
    private Dialog permissionDescriptionDialogOnSysProcessing = null;
    private BroadcastReceiver mActivityBroadCastReceiver = new a();
    protected boolean needCheckFinishJump = true;
    private MaterialDialog mDataStorageFullDialog = null;
    private MaterialDialog mSDcardStorageFullDialog = null;
    private MaterialDialog mKickOutDialog = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if (action.equals(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY)) {
                FrameworkBaseActivity.this.finish();
                return;
            }
            if (action.equals(FrameworkBaseActivity.INTENT_ACTION_KICKOUT)) {
                FrameworkBaseActivity.this.showKickoutDialog();
                return;
            }
            if (action.equals(FrameworkBaseActivity.INTENT_ACTION_UPDATE_CHECKED)) {
                FrameworkBaseActivity.this.onNewVersionChecked();
                return;
            }
            if (action.equals(FrameworkBaseActivity.INTENT_ACTION_LOGIN_REWARD)) {
                FrameworkBaseActivity.this.showRewardDialog();
                return;
            }
            if (action.equals(FrameworkBaseActivity.INTENT_ACTION_VOIP_PERMISSION)) {
                FrameworkBaseActivity frameworkBaseActivity = FrameworkBaseActivity.this;
                frameworkBaseActivity.mVoipPermission = intent.getIntExtra(frameworkBaseActivity.INTENT_KEY_VOIP_PERMISSION, 0);
            } else if (action.equals(FrameworkBaseActivity.INTENT_ACTION_HOC_TOAST)) {
                FrameworkBaseActivity.this.showHocKickoutToast();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {
        public b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            com.zenmen.palmchat.c.a().logoutAndExitApp();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            FrameworkBaseActivity.this.onKickOutConfirmed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrameworkBaseActivity.this.onNavigationClick(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseActivityPermissionDispatcher.PermissionType f13974a;
        public final /* synthetic */ BaseActivityPermissionDispatcher.PermissionUsage b;

        public f(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
            this.f13974a = permissionType;
            this.b = permissionUsage;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            FrameworkBaseActivity.this.onPermissionDialogCancel(this.f13974a, this.b);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            FrameworkBaseActivity.this.jump2Setting();
            FrameworkBaseActivity.this.onPermissionDialogConfirm(this.f13974a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f13975a = false;

        public static void b(Context context) {
            if (f13975a) {
                try {
                    List<ActivityManager.AppTask> appTasks = ((ActivityManager) context.getSystemService("activity")).getAppTasks();
                    if (appTasks == null || appTasks.size() <= 0 || appTasks.get(0) == null || Build.VERSION.SDK_INT < 23) {
                        f13975a = false;
                        return;
                    }
                    LogUtil.i("BackHandler", "tasks--------------" + appTasks.size());
                    ActivityManager.AppTask appTask = appTasks.get(0);
                    String className = appTask.getTaskInfo().topActivity.getClassName();
                    String className2 = appTask.getTaskInfo().baseActivity.getClassName();
                    int i = appTask.getTaskInfo().numActivities;
                    LogUtil.i("BackHandler", "task=" + appTask.getTaskInfo().toString() + "  count=" + i + "   top" + className + "   base=" + className2);
                    if (className2.equals("com.zenmen.palmchat.MainTabsActivity")) {
                        f13975a = false;
                        return;
                    }
                    if (i != 1 || className.equals("com.zenmen.palmchat.login.InitActivity")) {
                        return;
                    }
                    if (!TextUtils.isEmpty(v4.e(context))) {
                        LogUtil.i("BackHandler", "start mainActivity!!!!!!!");
                        context.startActivity(n5.b(context, new fk2.a()));
                    }
                    f13975a = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    f13975a = false;
                }
            }
        }

        public static void c(boolean z) {
            f13975a = z;
        }
    }

    private void checkStorage() {
        if (!needCheckStorage() || this.hasCheckStorage) {
            return;
        }
        this.hasCheckStorage = true;
        if (com.zenmen.palmchat.c.a().isDataStorageFull()) {
            showDataStorageFullDialog();
        } else if (com.zenmen.palmchat.c.a().isSDCardStorageFull()) {
            showSDcardStorageFullDialog();
        }
    }

    private void disableAutoFill() {
        if (Build.VERSION.SDK_INT >= 26) {
            getWindow().getDecorView().setImportantForAutofill(8);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getPermissionDes(BaseActivityPermissionDispatcher.PermissionType permissionType) {
        String str;
        String[] strArr = permissionType.permissionList;
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.VIDEO_CALL) {
            return getString(R$string.string_permission_videocall);
        }
        if (permissionType == BaseActivityPermissionDispatcher.PermissionType.VIDEO_RECORD) {
            return getString(R$string.string_permission_videorecord);
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = strArr[i];
            if (!tg4.b(this, str)) {
                break;
            }
            i++;
        }
        if (str == null) {
            str = strArr[0];
        }
        if (str != null) {
            switch (str) {
                case "android.permission.READ_CALENDAR":
                case "android.permission.WRITE_CALENDAR":
                    return getString(R$string.string_permission_calendar);
                case "android.permission.ACCESS_FINE_LOCATION":
                    return getString(R$string.string_permission_location);
                case "android.permission.READ_PHONE_STATE":
                    return getString(R$string.string_permission_phone_state);
                case "android.permission.CAMERA":
                    return getString(R$string.string_permission_camera);
                case "android.permission.WRITE_EXTERNAL_STORAGE":
                    return getString(R$string.string_permission_storage);
                case "android.permission.RECORD_AUDIO":
                    return getString(R$string.string_permission_audio);
                case "android.permission.READ_CONTACTS":
                    return getString(R$string.string_permission_contact);
            }
        }
        return "PermissionDeny";
    }

    private int getThemeColor() {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getTheme();
        int i = R$attr.colorPrimary;
        theme.resolveAttribute(i, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(typedValue.resourceId, new int[]{i});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }

    private void parseIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            this.backUrl = intent.getStringExtra(PARAMS_INTENT_FINISH_FORWARD_URL);
        } catch (Exception unused) {
        }
    }

    private void showDataStorageFullDialog() {
        if (this.mDataStorageFullDialog == null) {
            this.mDataStorageFullDialog = new sd3(this).h(false).U(getString(R$string.storage_is_full_title)).k(getString(R$string.storage_is_full_content)).O(R$string.exit_close).f(new b()).e();
        }
        if (this.mDataStorageFullDialog.isShowing()) {
            return;
        }
        this.mDataStorageFullDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHocKickoutToast() {
        if (System.currentTimeMillis() - lastHocTime > 3000) {
            LogUtil.i(TAG, "showHocKickoutToast");
            lastHocTime = System.currentTimeMillis();
            sy5.e(this, R$string.hotchat_kickout_toast, 0).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKickoutDialog() {
        if (isFinishing() || this.isPause || !this.needShowKickOutDialog) {
            return;
        }
        if (this.mKickOutDialog == null) {
            String strB = vs0.a().b("Logout_msg");
            if (TextUtils.isEmpty(strB)) {
                strB = getString(R$string.account_kickout_content);
            }
            sd3 sd3Var = new sd3(this);
            sd3Var.T(R$string.update_install_dialog_title).k(strB).O(R$string.alert_dialog_ok).h(false).f(new d());
            this.mKickOutDialog = sd3Var.e();
        }
        if (this.mKickOutDialog.isShowing()) {
            return;
        }
        this.mKickOutDialog.show();
    }

    private void showSDcardStorageFullDialog() {
        if (this.mSDcardStorageFullDialog == null) {
            this.mSDcardStorageFullDialog = new sd3(this).h(false).T(R$string.sd_storage_is_full_title).j(R$string.sd_storage_is_full_content).O(R$string.alert_dialog_ok).f(new c()).e();
        }
        if (this.mSDcardStorageFullDialog.isShowing()) {
            return;
        }
        this.mSDcardStorageFullDialog.show();
    }

    @Override // android.app.Activity
    public void finish() {
        LogUtil.i("BackHandler", "finish---" + getClass().getName() + " needCheckFinishJump=" + this.needCheckFinishJump + " needJump2MainOnFinish=" + g.f13975a);
        if (!TextUtils.isEmpty(this.backUrl) && ap3.a().O(this.backUrl)) {
            ap3.a().a0(this, this.backUrl);
        } else if (this.needCheckFinishJump) {
            g.b(this);
        }
        super.finish();
    }

    @Override // zs1.a
    public String formatStackForLog() {
        return null;
    }

    public boolean getNeedCheckInitPermission() {
        return this.isNeedCheckInitPermission && !pg4.a();
    }

    public int getPageId() {
        return -1;
    }

    public BaseActivityPermissionDispatcher.PermissionUsage getPermissionUsage() {
        return this.mPermissionUsage;
    }

    public Toolbar getToolbar() {
        return this.mToolbar;
    }

    public void hideBaseProgressBar() {
        wn4 wn4Var = this.mBaseProgressDialog;
        if (wn4Var != null) {
            try {
                wn4Var.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void hidePopupMenu() {
        this.mCustomPopupMenuHelper.b(this);
    }

    public void hideSimpleProgressBar() {
        kd5 kd5Var = this.mSimpleProgressDialog;
        if (kd5Var != null) {
            try {
                kd5Var.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public Toolbar initToolbar(int i, String str, boolean z) {
        return initToolbar((Toolbar) findViewById(i), str, z);
    }

    public boolean isPaused() {
        return this.isPause;
    }

    public void jump2Setting() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivity(intent);
    }

    public boolean needCheckStorage() {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException unused) {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        m5.c(this, bundle);
        p22.f19923a.b(this, bundle);
        super.onCreate(bundle);
        parseIntent(getIntent());
        if (!oy4.b()) {
            setStatusBarColor();
        }
        IntentFilter intentFilter = new IntentFilter(INTENT_ACTION_FINISH_ACTIVITY);
        intentFilter.addAction(INTENT_ACTION_UPDATE_CHECKED);
        intentFilter.addAction(INTENT_ACTION_KICKOUT);
        intentFilter.addAction(INTENT_ACTION_LOGIN_REWARD);
        intentFilter.addAction(INTENT_ACTION_VOIP_PERMISSION);
        intentFilter.addAction(INTENT_ACTION_HOC_TOAST);
        registerLocalReceiver(this.mActivityBroadCastReceiver, intentFilter);
        this.CLASS_NAME = getLocalClassName();
        LogUtil.d("tang", this.CLASS_NAME + " : onCreate()");
        this.sInstance = this;
        b05.a(this.CLASS_NAME + " : onCreate()");
        if (!getNeedCheckInitPermission() || tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.INITB.permissionList)) {
            return;
        }
        com.zenmen.palmchat.c.a().onInitPermissionDenied();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        hideBaseProgressBar();
        unregisterLocalReceiver(this.mActivityBroadCastReceiver);
        super.onDestroy();
        LogUtil.d("tang", this.CLASS_NAME + " : onDestroy()");
    }

    public void onKickOutConfirmed() {
        com.zenmen.palmchat.c.a().onKickOutConfirmed();
    }

    public void onNavigationClick(View view) {
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
        LogUtil.d("tang", this.CLASS_NAME + " : onNewIntent()");
    }

    public void onNewVersionChecked() {
        com.zenmen.palmchat.c.a().onNewVersionChecked(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.isPause = true;
        hidePopupMenu();
        super.onPause();
        LogUtil.d("tang", this.CLASS_NAME + " : onPause()");
    }

    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        LogUtil.i(TAG, "onPermissionDenied" + permissionType + permissionUsage);
        LogUtil.onImmediateClickEvent("permission01b", null, BaseActivityPermissionDispatcher.e(permissionType, permissionUsage, true));
        Dialog dialog = this.permissionDescriptionDialogOnSysProcessing;
        if (dialog != null && dialog.isShowing()) {
            this.permissionDescriptionDialogOnSysProcessing.dismiss();
            this.permissionDescriptionDialogOnSysProcessing = null;
            if (permissionUsage.needShowDesOnSysProcessing <= 1) {
                return;
            }
        }
        showPermissionDenyDialog(permissionType, permissionUsage);
        if (permissionUsage == null || permissionUsage.usageNum != 50) {
            return;
        }
        ds0.a().b(new sg4(false));
    }

    public void onPermissionDialogCancel(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        LogUtil.i(TAG, "onPermissionDialogCancel" + permissionType);
        LogUtil.onImmediateClickEvent("permission02b", null, BaseActivityPermissionDispatcher.d(permissionType, permissionUsage));
    }

    public void onPermissionDialogConfirm(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        LogUtil.i(TAG, "onPermissionDialogConfirm" + permissionType);
        LogUtil.onImmediateClickEvent("permission02a", null, BaseActivityPermissionDispatcher.d(permissionType, permissionUsage));
    }

    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        LogUtil.i(TAG, "onPermissionGrant" + permissionType + permissionUsage);
        if (z) {
            LogUtil.onImmediateClickEvent("permission01a", null, BaseActivityPermissionDispatcher.d(permissionType, permissionUsage));
            if (permissionType == BaseActivityPermissionDispatcher.PermissionType.CONTACT) {
                go0.l();
            }
        }
        Dialog dialog = this.permissionDescriptionDialogOnSysProcessing;
        if (dialog != null && dialog.isShowing()) {
            this.permissionDescriptionDialogOnSysProcessing.dismiss();
            this.permissionDescriptionDialogOnSysProcessing = null;
        }
        if (permissionUsage == null || permissionUsage.usageNum != 50) {
            return;
        }
        ds0.a().b(new sg4(true));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        BaseActivityPermissionDispatcher.j(this, i, iArr);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        LogUtil.d("tang", this.CLASS_NAME + " : onRestart()");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        checkStorage();
        com.zenmen.palmchat.c.a().initMessagingService(STASRT_REASON_BASEACTIVITY_ONRESUME);
        this.isPause = false;
        LogUtil.d("tang", this.CLASS_NAME + " : onResume()");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        try {
            super.onStart();
        } catch (Exception unused) {
        }
        LogUtil.d("tang", this.CLASS_NAME + " : onStart()");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LogUtil.d("tang", this.CLASS_NAME + " : onStop()");
    }

    public void openSetting() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivityForResult(intent, 11);
    }

    public void registerLocalReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

    public void sendLocalBroadcast(Intent intent) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        if (oy4.b()) {
            setStatusBarColor();
        }
    }

    public void setNeedCheckInitPermission(boolean z) {
        this.isNeedCheckInitPermission = z;
    }

    public void setNeedShowKickOutDialog(boolean z) {
        this.needShowKickOutDialog = z;
    }

    public void setPermissionUsage(BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        this.mPermissionUsage = permissionUsage;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (m5.d(this, i)) {
            super.setRequestedOrientation(i);
        }
    }

    public void setStatusBarColor() {
        me1.k(getWindow(), com.zenmen.palmchat.c.a().getStatusBarColor());
    }

    public void showBaseProgressBar() {
        if (isFinishing()) {
            return;
        }
        if (this.mBaseProgressDialog == null) {
            wn4 wn4Var = new wn4(this);
            this.mBaseProgressDialog = wn4Var;
            wn4Var.setCancelable(false);
            this.mBaseProgressDialog.b(getString(R$string.progress_sending));
        }
        this.mBaseProgressDialog.show();
    }

    public void showDescriptionDialogOnSysProcessing(BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, BaseActivityPermissionDispatcher.PermissionType permissionType) {
        ArrayList arrayList = new ArrayList();
        for (String str : permissionType.permissionList) {
            if (!tg4.b(this, str)) {
                arrayList.add(str);
            }
        }
        this.permissionDescriptionDialogOnSysProcessing = PermissionDialogUtil.e(this, permissionUsage, (String[]) arrayList.toArray(new String[0]));
    }

    public void showPermissionDenyDialog(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        if (permissionUsage == null || permissionUsage.needShowPermissionDeniedDialog) {
            new sd3(this).T(R$string.update_install_dialog_title).k(getPermissionDes(permissionType)).K(R$string.alert_dialog_cancel).O(R$string.settings_item_shezhi).f(new f(permissionType, permissionUsage)).h(false).e().show();
            LogUtil.onImmediateClickEvent("permission02", null, BaseActivityPermissionDispatcher.d(permissionType, permissionUsage));
        }
    }

    public void showPermissionDescriptionDialog(BaseActivityPermissionDispatcher.b bVar, BaseActivityPermissionDispatcher.PermissionType permissionType) {
        throw new UnsupportedOperationException("showPermissionDescriptionDialog should be override");
    }

    public void showPopupMenu(Activity activity, View view, ArrayList<is0.g> arrayList, is0.e eVar, is0.h hVar) {
        this.mCustomPopupMenuHelper.c(activity, view, arrayList, eVar, hVar, false);
    }

    public void showRequestFailDialog(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        new sd3(this).k(str).O(R$string.alert_dialog_ok).f(null).e().show();
    }

    public void showSimpleProgressBar() {
        if (isFinishing()) {
            return;
        }
        if (this.mSimpleProgressDialog == null) {
            kd5 kd5Var = new kd5(this);
            this.mSimpleProgressDialog = kd5Var;
            kd5Var.setCancelable(false);
        }
        this.mSimpleProgressDialog.show();
    }

    public void unregisterLocalReceiver(BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override // zs1.a
    public void updateCurrentPageInfo(Activity activity, HashMap map) {
        zs1.d(this, map);
    }

    public Toolbar initToolbar(Toolbar toolbar, String str, boolean z) {
        this.mToolbar = toolbar;
        toolbar.setPadding(0, me1.h(this), 0, 0);
        ViewGroup.LayoutParams layoutParams = this.mToolbar.getLayoutParams();
        layoutParams.height = me1.h(this) + me1.b(this, 48);
        this.mToolbar.setLayoutParams(layoutParams);
        if (getThemeColor() == getResources().getColor(R$color.theme_color_primary)) {
            this.mToolbar.setBackgroundResource(R$color.color_FFFFFF);
        }
        Toolbar toolbar2 = this.mToolbar;
        if (toolbar2 != null) {
            if (str != null) {
                toolbar2.setTitle(str);
            }
            if (z) {
                this.mToolbar.setNavigationIcon(R$drawable.selector_arrow_back);
                this.mToolbar.setNavigationOnClickListener(new e());
            }
        }
        return this.mToolbar;
    }

    public void setStatusBarColor(int i) {
        me1.k(getWindow(), i);
    }

    public void showPopupMenu(Activity activity, View view, String[] strArr, int[] iArr, is0.f fVar, is0.h hVar) {
        this.mCustomPopupMenuHelper.d(activity, view, strArr, iArr, fVar, hVar, false);
    }

    public void showPopupMenu(Activity activity, View view, String[] strArr, int[] iArr, is0.f fVar, is0.h hVar, boolean z) {
        this.mCustomPopupMenuHelper.d(activity, view, strArr, iArr, fVar, hVar, z);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        if (oy4.b()) {
            setStatusBarColor();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        if (oy4.b()) {
            setStatusBarColor();
        }
    }

    public void showBaseProgressBar(int i, boolean z) {
        showBaseProgressBar(getString(i), z);
    }

    public void showBaseProgressBar(String str, boolean z) {
        showBaseProgressBar(str, z, true);
    }

    public void showBaseProgressBar(String str, boolean z, boolean z2) {
        if (isFinishing()) {
            return;
        }
        try {
            wn4 wn4Var = this.mBaseProgressDialog;
            if (wn4Var == null || !wn4Var.isShowing()) {
                wn4 wn4Var2 = new wn4(this);
                this.mBaseProgressDialog = wn4Var2;
                wn4Var2.setCancelable(false);
                this.mBaseProgressDialog.b(str);
                this.mBaseProgressDialog.setCanceledOnTouchOutside(z);
                this.mBaseProgressDialog.setCancelable(z2);
            }
            this.mBaseProgressDialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
        }
    }

    @Deprecated
    public void showRewardDialog() {
    }
}
