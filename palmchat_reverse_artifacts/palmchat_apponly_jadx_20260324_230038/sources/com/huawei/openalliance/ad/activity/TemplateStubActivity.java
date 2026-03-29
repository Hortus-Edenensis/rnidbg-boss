package com.huawei.openalliance.ad.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.fd;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.h;
import com.huawei.hms.ads.jn;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.dg;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class TemplateStubActivity extends d implements fd {
    private static final String Code = "TemplateStubActivity";
    private static AdContentData I;
    private boolean B = false;
    private boolean C = false;
    private IRemoteViewDelegate V;
    private View Z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends IPPSUiEngineCallback.b {
        private WeakReference<TemplateStubActivity> V;

        public a(TemplateStubActivity templateStubActivity) {
            this.V = new WeakReference<>(templateStubActivity);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0020  */
        @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallResult(String str, Bundle bundle) {
            TemplateStubActivity templateStubActivity;
            fh.V(TemplateStubActivity.Code, "onCallResult method: %s", str);
            templateStubActivity = this.V.get();
            str.hashCode();
            switch (str) {
                case "easterEggClick":
                    if (templateStubActivity == null || !jn.Code(templateStubActivity.getApplicationContext()).V(templateStubActivity, TemplateStubActivity.I, bundle, templateStubActivity.getClass().getSimpleName())) {
                        return;
                    }
                    break;
                case "complete":
                    if (templateStubActivity != null) {
                        jn.Code(templateStubActivity).Code(TemplateStubActivity.I, bundle);
                        break;
                    } else {
                        return;
                    }
                    break;
                case "fail":
                    if (templateStubActivity != null) {
                        templateStubActivity.I();
                        jn.Code(templateStubActivity.getApplicationContext()).I(TemplateStubActivity.I, bundle);
                        return;
                    }
                    return;
                case "show":
                    if (templateStubActivity != null) {
                        jn.Code(templateStubActivity.getApplicationContext()).Code(TemplateStubActivity.I, templateStubActivity.getClass().getSimpleName());
                        return;
                    }
                    return;
                case "click":
                    templateStubActivity.C = true;
                    if (templateStubActivity != null) {
                        jn.Code(templateStubActivity.getApplicationContext()).Code(templateStubActivity, TemplateStubActivity.I, bundle, templateStubActivity.getClass().getSimpleName());
                        return;
                    }
                    return;
                case "close":
                    if (templateStubActivity != null) {
                        templateStubActivity.I();
                        jn.Code(templateStubActivity.getApplicationContext()).V(TemplateStubActivity.I, bundle);
                        return;
                    }
                    return;
                case "dismiss":
                    if (templateStubActivity != null) {
                        templateStubActivity.I();
                        jn.Code(templateStubActivity.getApplicationContext()).V(TemplateStubActivity.I);
                        return;
                    }
                    return;
                default:
                    return;
            }
            templateStubActivity.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                View view = (View) ObjectWrapper.unwrap(iRemoteViewDelegate.getView());
                this.Z = view;
                setContentView(view);
            }
        } catch (Throwable th) {
            fh.I(Code, "plugRemoteView " + th.getClass().getSimpleName());
        }
    }

    private void C() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onDestroy();
            }
        } catch (Throwable th) {
            fh.I(Code, "onDestroy failed: " + th.getClass().getSimpleName());
        }
    }

    private void Z() {
        getWindow().setFlags(1024, 1024);
        int i = Build.VERSION.SDK_INT;
        getWindow().addFlags(134217728);
        if (i >= 28) {
            try {
                if (1 == getResources().getConfiguration().orientation) {
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    getWindow().setAttributes(attributes);
                }
            } catch (Throwable th) {
                Log.w(Code, "set CutoutMode error:" + th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.fd
    public AdContentData getContentRecord() {
        return I;
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.hiad_anim_fade_out);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("content");
        Code((AdContentData) ad.V(stringExtra, AdContentData.class, new Class[0]));
        if (bg.V(getApplicationContext())) {
            fh.V(Code, "screen locked");
            jn.Code(getApplicationContext()).Code(I, 1);
            finish();
        }
        IRemoteCreator iRemoteCreatorCode = h.Code(getApplicationContext());
        if (iRemoteCreatorCode == null) {
            jn.Code(getApplicationContext()).Code(I, 2);
            finish();
            return;
        }
        Z();
        Code(safeIntent);
        Bundle bundle2 = new Bundle();
        bundle2.putString("filePath", safeIntent.getStringExtra("filePath"));
        bundle2.putString("content", stringExtra);
        try {
            IRemoteViewDelegate iRemoteViewDelegateNewRemoteViewDelegate = iRemoteCreatorCode.newRemoteViewDelegate(ObjectWrapper.wrap(this), safeIntent.getStringExtra(bq.f.F), null);
            this.V = iRemoteViewDelegateNewRemoteViewDelegate;
            iRemoteViewDelegateNewRemoteViewDelegate.onCreate(bundle2);
            this.V.setCallback(new a(this));
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.TemplateStubActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    TemplateStubActivity.this.B();
                    TemplateStubActivity.this.Code("start", (Bundle) null);
                    bg.Code(TemplateStubActivity.this.Z, TemplateStubActivity.this);
                    TemplateStubActivity.this.Z.startAnimation(AnimationUtils.loadAnimation(TemplateStubActivity.this.getApplicationContext(), R.anim.hiad_anim_fade_in));
                }
            });
        } catch (Throwable th) {
            fh.I(Code, "create remoteViewDelegate err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        fh.V(Code, "onDestroy");
        C();
        jn.Code(getApplicationContext()).V(I);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onPause() {
        super.onPause();
        fh.V(Code, "onPause");
        this.B = true;
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onPause();
            }
        } catch (Throwable th) {
            fh.I(Code, "onPause " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onRestart() {
        super.onRestart();
        fh.V(Code, "onRestart, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onRestart();
            }
        } catch (Throwable th) {
            fh.I(Code, "onRestart " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onResume() {
        super.onResume();
        fh.V(Code, "onResume, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onResume();
            }
        } catch (Throwable th) {
            fh.I(Code, "onResume " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStart();
            }
        } catch (Throwable th) {
            fh.I(Code, "onStart " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onStop() {
        super.onStop();
        fh.V(Code, "onStop");
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStop();
            }
        } catch (Throwable th) {
            fh.I(Code, "onStop " + th.getClass().getSimpleName());
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle Code(String str, Bundle bundle) {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                return iRemoteViewDelegate.sendCommand(str, bundle);
            }
            return null;
        } catch (Throwable th) {
            fh.I(Code, "%s failed: %s ", str, th.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        finish();
        overridePendingTransition(0, R.anim.hiad_anim_fade_out);
    }

    private void Code(Intent intent) {
        try {
            if (!intent.getBooleanExtra(bq.f.y, false)) {
                fh.I(Code, "not need reset");
                return;
            }
            Window window = getWindow();
            if (window == null) {
                fh.I(Code, "window is null");
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = intent.getIntExtra(bq.f.z, window.getAttributes().flags);
            if (!dg.Code(getPackageName())) {
                attributes.flags |= 67108864;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = intent.getIntExtra(bq.f.A, window.getAttributes().layoutInDisplayCutoutMode);
            }
            window.setAttributes(attributes);
            window.setNavigationBarColor(intent.getIntExtra(bq.f.E, window.getNavigationBarColor()));
            View decorView = window.getDecorView();
            if (decorView == null) {
                fh.I(Code, "decorView is null");
            } else {
                decorView.setSystemUiVisibility(intent.getIntExtra(bq.f.G, decorView.getSystemUiVisibility()));
            }
        } catch (Throwable th) {
            fh.I(Code, "inherit err: %s", th.getClass().getSimpleName());
        }
    }

    private static void Code(AdContentData adContentData) {
        I = adContentData;
    }

    @Override // com.huawei.hms.ads.fd
    public boolean Code() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.fd
    public Context getActivityContext() {
        return this;
    }
}
