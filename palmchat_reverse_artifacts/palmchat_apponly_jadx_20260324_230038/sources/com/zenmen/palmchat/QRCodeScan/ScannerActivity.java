package com.zenmen.palmchat.QRCodeScan;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.QRCodeScan.ScannerView;
import com.zenmen.palmchat.QRCodeScan.a;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.MediaPickActivity;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.settings.QRCodeActivity;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bo2;
import defpackage.ch;
import defpackage.cq6;
import defpackage.ds0;
import defpackage.hx3;
import defpackage.l84;
import defpackage.pj6;
import defpackage.qm5;
import defpackage.rl0;
import defpackage.s93;
import defpackage.tg4;
import defpackage.uk5;
import defpackage.wg4;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ScannerActivity extends BaseActionBarActivity implements ScannerView.b {
    public static final String FROM = "from";
    private static final String PATH_HELP = "/help/views/";
    private static final String PATH_HELP_CENTER = "/helpCenter/views/";
    private static final int REQUEST_PICK_QRCODE = 0;
    public static final String TAG = "ScannerActivity";
    private long createTime;
    private ObjectAnimator flashAnimator;
    private ImageView flashImageView;
    private View flashLayout;
    private TextView flashTextView;
    private j handler;
    private ScannerView mEmbeddedScanner;
    private String mFrom;
    private RelativeLayout mLytNoneNet;
    private RadioGroup mRadioGroup;
    private TextView mTvPicture;
    private pj6<String> mWebScanDao;
    private boolean isNetworkAvailable = true;
    private boolean hasStartPreview = false;
    private boolean hasShowFlash = false;
    private boolean hasOpenFlash = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.tab_fengmian) {
                ScannerActivity.this.mEmbeddedScanner.swithToFengmian();
            } else {
                if (i != R.id.tab_saoma) {
                    return;
                }
                ScannerActivity.this.mEmbeddedScanner.swithToSaoma();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            Intent intent = new Intent(AppContext.getContext(), (Class<?>) QRCodeActivity.class);
            intent.putExtra("from", "scanner");
            intent.putExtra("code", str);
            ScannerActivity.this.startActivity(intent);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.zenmen.palmchat.QRCodeScan.a.c(new a.e() { // from class: q25
                @Override // com.zenmen.palmchat.QRCodeScan.a.e
                public final void a(String str) {
                    this.f20161a.b(str);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScannerActivity.this.showFlash();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", ScannerActivity.this.hasOpenFlash ? 0 : 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("flashlight_001", null, null, jSONObject.toString());
            if (ScannerActivity.this.hasOpenFlash) {
                ScannerActivity.this.mEmbeddedScanner.closeFlash();
                ScannerActivity.this.hasOpenFlash = false;
            } else {
                ScannerActivity.this.mEmbeddedScanner.openFlash();
                ScannerActivity.this.hasOpenFlash = true;
            }
            ScannerActivity.this.updateFlashView();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (tg4.b(ScannerActivity.this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD.permissionList)) {
                    jSONObject.put("status", 1);
                } else {
                    jSONObject.put("status", 2);
                }
                LogUtil.uploadInfoImmediate("sysxc1", null, null, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BaseActivityPermissionDispatcher.b(ScannerActivity.this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_QRCODE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ScannerActivity.this.flashLayout.setVisibility(4);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wg4.a(ScannerActivity.this).f(false, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScannerActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements bo2.a {
        public h() {
        }

        @Override // bo2.a
        public void onFinish(boolean z) {
            ScannerActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f12126a;

        public i(uk5 uk5Var) {
            this.f12126a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12126a.f21235a != 2) {
                return;
            }
            ScannerActivity.this.updateConnectionStatus();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class j extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ScannerActivity f12127a;

        public j(ScannerActivity scannerActivity) {
            this.f12127a = scannerActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                this.f12127a.showFlash();
            } else {
                if (i != 2) {
                    return;
                }
                this.f12127a.hideFlash();
            }
        }
    }

    private static void bundleThumbnail(int[] iArr, int i2, int i3, Bundle bundle) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, 0, i2, i2, i3, Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
    }

    private void displayScannedResult(String str) {
        Bundle bundle = new Bundle();
        s93 s93VarD = this.mEmbeddedScanner.getDecoder().d();
        bundleThumbnail(this.mEmbeddedScanner.getDecoder().e(), s93VarD.d(), s93VarD.a(), bundle);
        Intent intent = new Intent(this, (Class<?>) ResultActivity.class);
        bundle.putString("result", str);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public static void gotoWebActivity(Activity activity, String str, int i2) {
        Intent intent = new Intent();
        intent.setClass(activity, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putInt("BackgroundColor", -1);
        bundle.putBoolean("web_show_right_menu", false);
        if (!TextUtils.isEmpty(str) && (str.contains(PATH_HELP_CENTER) || str.contains(PATH_HELP))) {
            bundle.putBoolean("extra_key_not_set_status_bar", true);
        }
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFlash() {
        if (this.flashLayout == null) {
            return;
        }
        ObjectAnimator objectAnimator = this.flashAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        View view = this.flashLayout;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 0.0f);
        this.flashAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new e());
        this.flashAnimator.setDuration(300L);
        this.flashAnimator.start();
        this.hasShowFlash = false;
    }

    private void initActionBar() {
        this.mTvPicture = (TextView) findViewById(R.id.action_button);
        findViewById(R.id.iv_back).setOnClickListener(new g());
    }

    private void pickQRCodeImage() {
        Intent intent = new Intent(this, (Class<?>) MediaPickActivity.class);
        intent.putExtra("select_mode_key", 4);
        intent.putExtra("from", "from_qrcode_scanner");
        startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFlash() {
        if (this.flashLayout == null) {
            return;
        }
        ObjectAnimator objectAnimator = this.flashAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.flashLayout.setVisibility(0);
        View view = this.flashLayout;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 1.0f);
        this.flashAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.flashAnimator.start();
        this.hasShowFlash = true;
    }

    private void startPreview() {
        if (!tg4.b(this, BaseActivityPermissionDispatcher.PermissionType.CAMERA.permissionList)) {
            this.mEmbeddedScanner.getScannerTargetView().setVisibility(8);
            return;
        }
        try {
            this.mEmbeddedScanner.startScanner();
            this.mEmbeddedScanner.getScannerTargetView().setVisibility(0);
        } catch (Exception unused) {
            this.mEmbeddedScanner.getScannerTargetView().setVisibility(8);
            wg4.a(this).f(false, 0);
        }
        this.mEmbeddedScanner.setScannerViewEventListener(this);
        this.hasStartPreview = true;
    }

    private void stopPreview() {
        if (this.hasStartPreview) {
            this.mEmbeddedScanner.stopScanner();
            this.hasStartPreview = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConnectionStatus() {
        if (hx3.m(AppContext.getContext())) {
            this.isNetworkAvailable = true;
            this.mLytNoneNet.setVisibility(8);
        } else {
            this.isNetworkAvailable = false;
            this.mLytNoneNet.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFlashView() {
        if (this.flashLayout == null) {
            return;
        }
        if (this.hasOpenFlash) {
            this.flashImageView.setImageResource(R.drawable.ic_flash_close);
            this.flashTextView.setText(R.string.title_flash_close);
            this.flashTextView.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.flashImageView.setImageResource(R.drawable.ic_flash_open);
            this.flashTextView.setText(R.string.title_flash_open);
            this.flashTextView.setTextColor(Color.parseColor("#999999"));
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 115;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0 && i3 == -1) {
            finish();
        }
    }

    @Override // com.zenmen.palmchat.QRCodeScan.ScannerView.b
    public boolean onCodeScanned(String str) {
        LogUtil.i(TAG, "onCodeScanned " + str);
        if (this.isNetworkAvailable && str != null) {
            if ("ScanPlugin".equals(this.mFrom)) {
                Intent intent = new Intent();
                intent.putExtra("result", str);
                setResult(-1, intent);
                finish();
            } else {
                cq6.a(this, str, 1, new h());
            }
        }
        return false;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        this.handler = new j(this);
        this.createTime = System.currentTimeMillis();
        setContentView(R.layout.layout_activity_scanner_b);
        this.mEmbeddedScanner = (ScannerView) findViewById(R.id.scanner);
        this.mLytNoneNet = (RelativeLayout) findViewById(R.id.lyt_none_net);
        initActionBar();
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.scanner_tab);
        this.mRadioGroup = radioGroup;
        radioGroup.setOnCheckedChangeListener(new a());
        if (getIntent() != null) {
            this.mFrom = getIntent().getStringExtra("from");
        }
        findViewById(R.id.my_qrcode_layout).setOnClickListener(new b());
        this.flashLayout = findViewById(R.id.flash_layout);
        this.flashImageView = (ImageView) findViewById(R.id.flash_icon);
        this.flashTextView = (TextView) findViewById(R.id.flash_title);
        View view = this.flashLayout;
        if (view != null) {
            view.setOnClickListener(new c());
        }
        if (rl0.h().d().getDynamicConfig(DynamicConfig.Type.SCAN_ALBUM_BATTERY).isEnable()) {
            this.mTvPicture.setOnClickListener(new d());
        } else {
            this.mTvPicture.setVisibility(8);
        }
        ds0.a().c(this);
        BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.CAMERA, BaseActivityPermissionDispatcher.PermissionUsage.SCAN_CAMERA);
        LogUtil.uploadInfoImmediate("scan_view", "1", null, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        pj6<String> pj6Var = this.mWebScanDao;
        if (pj6Var != null) {
            pj6Var.onCancel();
        }
        ds0.a().d(this);
        super.onDestroy();
    }

    @Override // com.zenmen.palmchat.QRCodeScan.ScannerView.b
    public void onLightScanned(float f2) {
        LogUtil.d("logscan", "light = " + f2);
        if (System.currentTimeMillis() - this.createTime < 800) {
            LogUtil.d("logscan", "<800ms, return");
            return;
        }
        if (this.flashLayout == null || this.hasOpenFlash) {
            return;
        }
        if (f2 > 0.85f && !this.hasShowFlash) {
            this.handler.removeMessages(2);
            if (this.handler.hasMessages(1)) {
                return;
            }
            this.handler.sendEmptyMessageDelayed(1, 400L);
            return;
        }
        if (f2 >= 0.75f || !this.hasShowFlash) {
            return;
        }
        this.handler.removeMessages(1);
        if (this.handler.hasMessages(2)) {
            return;
        }
        this.handler.sendEmptyMessageDelayed(2, 400L);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        stopPreview();
        ch.s().r().l(this);
        if (this.hasOpenFlash) {
            this.mEmbeddedScanner.closeFlash();
            this.hasOpenFlash = false;
            updateFlashView();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDenied(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDenied(permissionType, permissionUsage);
        BaseActivityPermissionDispatcher.PermissionUsage permissionUsage2 = BaseActivityPermissionDispatcher.PermissionUsage.NONE;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDialogCancel(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDialogCancel(permissionType, permissionUsage);
        BaseActivityPermissionDispatcher.PermissionUsage permissionUsage2 = BaseActivityPermissionDispatcher.PermissionUsage.NONE;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionDialogConfirm(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        super.onPermissionDialogConfirm(permissionType, permissionUsage);
        BaseActivityPermissionDispatcher.PermissionUsage permissionUsage2 = BaseActivityPermissionDispatcher.PermissionUsage.NONE;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.MEDIA_PICK_QRCODE) {
            pickQRCodeImage();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        startPreview();
        ch.s().r().j(this);
        updateConnectionStatus();
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        runOnUiThread(new i(uk5Var));
    }

    @qm5
    public void showOpenCameraFailedDialog(l84 l84Var) {
        runOnUiThread(new f());
    }
}
