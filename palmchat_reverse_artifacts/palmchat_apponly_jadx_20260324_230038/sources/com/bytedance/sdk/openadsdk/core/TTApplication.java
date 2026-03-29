package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.Keep;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTApplication extends Application {
    @Keep
    public Function attach(Function function) {
        if (function == null) {
            return null;
        }
        n.o().u((Function<SparseArray<Object>, Object>) function);
        return null;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(@ForbidWrapParam final Context context) {
        super.attachBaseContext(context);
        ComponentManager.registerActivity("com.byted.pangle", PluginConstants.STUB_STANDARD_ACTIVITY_T, "com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity", "com.bytedance.msdk.api.activity.TTDelegateActivity", "com.bytedance.msdk.api.activity.TTTransparentActivity", "com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity");
        ComponentManager.registerActivity("com.byted.pangle", PluginConstants.STUB_STANDARD_PORTRAIT_ACTIVITY_T, "com.bytedance.sdk.openadsdk.core.activity.base.TTMiddlePageActivity", "com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity", "com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTFullScreenVideoActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTRewardVideoActivity");
        ComponentManager.registerActivity("com.byted.pangle", PluginConstants.STUB_STANDARD_ACTIVITY, "com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTPlayableWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity");
        ComponentManager.registerActivity("com.byted.pangle", PluginConstants.STUB_STANDARD_LANDSCAPE_ACTIVITY, "com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity", "com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTFullScreenVideoLandscapeActivity", "com.bytedance.sdk.openadsdk.core.activity.base.TTRewardVideoLandscapeActivity");
        ComponentManager.registerActivity("com.byted.pangle", PluginConstants.STUB_SINGLE_TASK_ACTIVITY_T, "com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity", "com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity", "com.ss.android.downloadlib.activity.TTDelegateActivity");
        com.bytedance.sdk.openadsdk.core.xg.u.u();
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("init_init") { // from class: com.bytedance.sdk.openadsdk.core.TTApplication.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.jk.t.nr.l();
                com.bytedance.sdk.component.utils.jk.u();
                String strNr = com.bytedance.sdk.component.utils.bq.nr(context);
                if (strNr == null || !strNr.endsWith(":downloader")) {
                    return;
                }
                int iU = com.bytedance.sdk.openadsdk.gi.l.u("com.byted.pangle", 101);
                if (iU > 0) {
                    d.fx = iU;
                }
                com.bytedance.sdk.openadsdk.core.l.a.pn();
            }
        });
    }
}
