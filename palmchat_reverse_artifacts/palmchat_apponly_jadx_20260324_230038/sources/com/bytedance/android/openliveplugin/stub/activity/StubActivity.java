package com.bytedance.android.openliveplugin.stub.activity;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformProxyActivity;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.JavaCallsUtils;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.api.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class StubActivity {

    /* JADX INFO: compiled from: SearchBox */
    public static class Activity_Portrait extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.nr
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Activity_Portrait2 extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.nr
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Activity_Portrait3 extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.nr
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Activity_Portrait4 extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.nr
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Activity_Portrait5 extends SuperActivity {
        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.nr
        public /* bridge */ /* synthetic */ String getPluginPkgName() {
            return super.getPluginPkgName();
        }

        @Override // com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity, com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SuperActivity extends ZeusPlatformProxyActivity {
        Handler handler;

        /* JADX INFO: Access modifiers changed from: private */
        public void execAsyncCheckReport() {
            LivePluginHelper.sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                    if (liveRoomService != null) {
                        SuperActivity superActivity = SuperActivity.this;
                        if (superActivity.mTargetActivity != null) {
                            try {
                                liveRoomService.callExpandMethod("report_window_focus_change", JavaCallsUtils.getField(superActivity, "mToken"), SuperActivity.this.mTargetActivity.getClass().getCanonicalName());
                            } catch (Throwable th) {
                                iz.u(th);
                            }
                        }
                    }
                }
            });
        }

        @Override // com.bytedance.pangle.activity.GenerateProxyActivity, com.bytedance.pangle.activity.nr
        public String getPluginPkgName() {
            return "com.byted.live.lite";
        }

        @Override // com.bytedance.pangle.activity.GenerateProxyActivity, android.app.Activity, android.view.Window.Callback
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z) {
                return;
            }
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            this.handler.post(new Runnable() { // from class: com.bytedance.android.openliveplugin.stub.activity.StubActivity.SuperActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    SuperActivity.this.execAsyncCheckReport();
                }
            });
        }
    }
}
