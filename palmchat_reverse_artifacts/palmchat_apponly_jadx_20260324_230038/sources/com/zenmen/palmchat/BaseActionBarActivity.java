package com.zenmen.palmchat;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.onekeyfriend.RecommendResultActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.videocall.VideoCallActivity;
import defpackage.ch;
import defpackage.fn2;
import defpackage.k86;
import defpackage.lo3;
import defpackage.pa6;
import defpackage.r75;
import defpackage.sd3;
import defpackage.v66;
import defpackage.vg4;
import defpackage.wg4;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class BaseActionBarActivity extends FrameworkBaseActivity implements ServiceConnection {
    public static final String EXTRA_KEY_FROM_WIFI = "from_wifi";
    public static final String EXTRA_KEY_NEED_BACK2MAINTAB = "need_back_to_maintab";
    public static final String EXTRA_KEY_NEED_BACK2MAINTAB_INEDX = "need_back_to_maintab_index";
    protected static final int REQUEST_CODE_VOIP = 200;
    public static final String TAG = "BaseActionBarActivity";
    private lo3 bindHelper;
    protected Dialog mRewardDialog;
    private Intent mSdkIntent;
    private Intent mShareIntent;
    protected boolean needCheckAccount = true;
    protected boolean mNeedCheckAppIsBackground = true;
    protected boolean needBack2MainTab = false;
    private String needBack2MainTabIndex = "tab_msg";
    private String mainTabIndex = null;
    private boolean hasShare = false;
    private boolean isFromOpenSdk = false;
    private boolean isFloatShow = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "bind_service");
            put("status", "getMessagingServiceInterface is null");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", "bind_service");
            put("status", "onServiceDisconnected_Base");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActionBarActivity.this.mRewardDialog.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f12068a;

        public d(View.OnClickListener onClickListener) {
            this.f12068a = onClickListener;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (!v66.b().f()) {
                try {
                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    intent.setData(Uri.parse("package:" + BaseActionBarActivity.this.getPackageName()));
                    BaseActionBarActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    BaseActionBarActivity.this.openSetting();
                }
            }
            View.OnClickListener onClickListener = this.f12068a;
            if (onClickListener != null) {
                onClickListener.onClick(null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f12069a;

        public e(View.OnClickListener onClickListener) {
            this.f12069a = onClickListener;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            if (!v66.b().f()) {
                Intent intent = new Intent();
                intent.setClass(BaseActionBarActivity.this, CordovaWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("web_url", com.zenmen.palmchat.videocall.a.u);
                bundle.putBoolean("web_show_right_menu", false);
                bundle.putInt("BackgroundColor", -1);
                intent.putExtras(bundle);
                BaseActionBarActivity.this.startActivity(intent);
            }
            View.OnClickListener onClickListener = this.f12069a;
            if (onClickListener != null) {
                onClickListener.onClick(null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {
        public f() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {
        public g() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    private void intercept(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        boolean z = (i == 28 || i == 29) && "honor".equalsIgnoreCase(Build.MANUFACTURER);
        if (context == null || !z) {
            return;
        }
        bundle.setClassLoader(context.getClassLoader());
        Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (bundle2 == null || bundle2.keySet() == null) {
            return;
        }
        Iterator<String> it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            Object obj = bundle2.get(it.next());
            if (obj instanceof Bundle) {
                ((Bundle) obj).setClassLoader(context.getClassLoader());
            }
        }
    }

    private void obtainBaseIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.needBack2MainTab = intent.getBooleanExtra(EXTRA_KEY_NEED_BACK2MAINTAB, false);
                String stringExtra = intent.getStringExtra(EXTRA_KEY_NEED_BACK2MAINTAB_INEDX);
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.needBack2MainTabIndex = stringExtra;
                }
                this.mainTabIndex = intent.getStringExtra("main_index");
                if (com.zenmen.palmchat.route.share.a.l(intent)) {
                    this.mShareIntent = intent;
                    this.hasShare = true;
                }
                if ("com.zenmen.palmchat.openapi.Intent.LX_ENTRY_ACTIVITY".equals(intent.getAction())) {
                    this.isFromOpenSdk = true;
                    this.mSdkIntent = intent;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void bindMessagingService() {
        this.bindHelper.c();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        if (!r75.k() && this.needBack2MainTab) {
            this.needCheckFinishJump = false;
            if (AccountUtils.r(this)) {
                Intent intent = new Intent();
                intent.setClass(this, MainTabsActivity.class);
                intent.putExtra("new_intent_position", this.needBack2MainTabIndex);
                k86.X(intent);
                startActivity(intent);
            }
        }
        if (this.mainTabIndex != null) {
            Intent intent2 = new Intent(RecommendResultActivity.u);
            intent2.putExtra(RecommendResultActivity.v, true);
            sendLocalBroadcast(intent2);
        }
        super.finish();
    }

    public fn2 getMessagingServiceInterface() {
        fn2 fn2VarE = this.bindHelper.e();
        if (fn2VarE == null) {
            AppContext.getContext().initMessagingService("STASRT_REASON_BASEACTIVITY_BIND_NULL");
            LogUtil.i(TAG, 3, new a(), (Throwable) null);
        }
        return fn2VarE;
    }

    public Toolbar initToolbar(int i) {
        return initToolbar(i == 0 ? getString(R.string.app_name) : i > 0 ? getString(i) : null, true);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        intercept(this, bundle);
        super.onCreate(bundle);
        obtainBaseIntent();
        this.bindHelper = new lo3(this, this);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ch.s().q();
        if (this.needCheckAccount && !AccountUtils.t(this)) {
            try {
                if (this.hasShare) {
                    AppContext.getContext().jumpToInitOnAccountIsNullNeedShare(this.mShareIntent);
                } else if (this.isFromOpenSdk) {
                    AppContext.getContext().jumpToInitOnAccountIsNullFromSdk(this.mSdkIntent);
                } else {
                    AppContext.getContext().jumpToInitOnAccountIsNull();
                }
            } catch (Exception unused) {
                AppContext.getContext().jumpToInitOnAccountIsNull();
            }
        }
        boolean z = this instanceof VideoCallActivity;
        if (z) {
            AppContext.getContext();
            if (!AppContext.isFloatWindowOpAllowed(this) && r75.d(AppContext.getContext(), k86.a("is_show_float_view"), false)) {
                r75.o(AppContext.getContext(), k86.a("is_show_float_view"), false);
                showFloatAllow(null);
            }
        }
        if (!z) {
            pa6.B();
        }
        AppContext.getContext();
        if (AppContext.isFloatWindowOpAllowed(this) && !z) {
            if (r75.d(AppContext.getContext(), k86.a("is_show_float_view"), false)) {
                sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_FLOATVIEW_PERMISSION_READY));
            } else if (com.zenmen.palmchat.videocall.a.b()) {
                com.zenmen.palmchat.videocall.a.c();
                VideoCallActivity videoCallActivityO3 = VideoCallActivity.o3();
                if (videoCallActivityO3 != null && videoCallActivityO3.w3()) {
                    startActivity(new Intent(this, (Class<?>) VideoCallActivity.class));
                }
            }
        }
        int i = this.mVoipPermission;
        if (i == 1 && !z) {
            showCameraPermission();
            Intent intent = new Intent(FrameworkBaseActivity.INTENT_ACTION_VOIP_PERMISSION);
            intent.putExtra(this.INTENT_KEY_VOIP_PERMISSION, 0);
            sendLocalBroadcast(intent);
            return;
        }
        if (i != 2 || z) {
            return;
        }
        showMICPermission();
        Intent intent2 = new Intent(FrameworkBaseActivity.INTENT_ACTION_VOIP_PERMISSION);
        intent2.putExtra(this.INTENT_KEY_VOIP_PERMISSION, 0);
        sendLocalBroadcast(intent2);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        LogUtil.i(TAG, 3, new b(), (Throwable) null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNeedCheckAppIsBackground && AppContext.getContext().getTrayPreferences().a("firstTimeToBackground", true) && AppContext.getContext().isBackground()) {
            AppContext.getContext().getTrayPreferences().i("firstTimeToBackground", false);
            vg4 vg4VarA = wg4.a(this);
            vg4VarA.d();
            vg4VarA.a();
        }
    }

    public void setBack2MainTab(boolean z, String str) {
        this.needBack2MainTab = z;
        this.needBack2MainTabIndex = str;
    }

    public void setRedStatusBarColor() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.toolbar_red_bg_color));
    }

    public void showCameraPermission() {
        new sd3(this).T(R.string.video_call_dialog_permission_camera_title).j(R.string.video_call_dialog_permission_camera_content).O(R.string.video_call_dialog_permission_camera_ok).f(new f()).e().show();
    }

    public void showFloatAllow(View.OnClickListener onClickListener) {
        int i = r75.d(AppContext.getContext(), k86.a("Is_Audio"), false) ? R.string.video_call_allow_content_voice : R.string.video_call_allow_content_video;
        if (Build.VERSION.SDK_INT >= 23) {
            new sd3(this).T(R.string.video_call_allow_title).j(i).O(R.string.video_call_allow_setting).f(new d(onClickListener)).e().show();
        } else {
            new sd3(this).T(R.string.video_call_allow_title).j(i).O(R.string.video_call_allow_web).f(new e(onClickListener)).e().show();
        }
    }

    public void showMICPermission() {
        new sd3(this).T(R.string.video_call_dialog_permission_mic_title).j(R.string.video_call_dialog_permission_mic_content).O(R.string.video_call_dialog_permission_mic_ok).f(new g()).e().show();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void showRewardDialog() {
        if (isFinishing() || isPaused()) {
            return;
        }
        if (this.mRewardDialog == null) {
            this.mRewardDialog = new Dialog(this, R.style.dark_dialog);
            View viewInflate = View.inflate(this, R.layout.layout_login_reward, null);
            ((ImageView) viewInflate.findViewById(R.id.close_img)).setOnClickListener(new c());
            this.mRewardDialog.setContentView(viewInflate);
            Window window = this.mRewardDialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            window.setAttributes(attributes);
        }
        if (this.mRewardDialog.isShowing()) {
            return;
        }
        this.mRewardDialog.show();
    }

    public void unBindMessagingService() {
        this.bindHelper.f();
    }

    public Toolbar initToolbar(int i, boolean z) {
        String string;
        if (i == 0) {
            string = getString(R.string.app_name);
        } else {
            string = i > 0 ? getString(i) : null;
        }
        return initToolbar(string, z);
    }

    public Toolbar initToolbar(String str) {
        return initToolbar(str, true);
    }

    public Toolbar initToolbar(String str, boolean z) {
        return initToolbar(R.id.toolbar, str, z);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }
}
