package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.os.Looper;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class sx extends com.bytedance.sdk.component.adexpress.nr.u<BackupView> {
    private com.bytedance.sdk.component.adexpress.nr.fx b;
    private ThemeStatusBroadcastReceiver fx;
    private com.bytedance.sdk.component.adexpress.nr.mv iz;
    private View nr;
    private com.bytedance.sdk.component.adexpress.nr.x pn;
    private BackupView u;

    public sx(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.nr.mv mvVar) {
        this.nr = view;
        this.fx = themeStatusBroadcastReceiver;
        this.iz = mvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr() {
        com.bytedance.sdk.component.adexpress.nr.fx fxVar = this.b;
        boolean z = false;
        if (fxVar != null && fxVar.u((NativeExpressView) this.nr, 0)) {
            z = true;
        }
        if (!z) {
            this.pn.u(107, (String) null);
            return;
        }
        this.iz.x().jk();
        BackupView backupView = (BackupView) this.nr.findViewWithTag("tt_express_backup_fl_tag_26");
        this.u = backupView;
        if (backupView == null) {
            this.pn.u(107, (String) null);
            return;
        }
        backupView.setThemeChangeReceiver(this.fx);
        com.bytedance.sdk.component.adexpress.nr.s sVar = new com.bytedance.sdk.component.adexpress.nr.s();
        BackupView backupView2 = this.u;
        float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
        BackupView backupView3 = this.u;
        float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
        sVar.u(true);
        sVar.u(realWidth);
        sVar.nr(realHeight);
        this.pn.u(this.u, sVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    public void u(com.bytedance.sdk.component.adexpress.nr.x xVar) {
        this.pn = xVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nr();
        } else {
            com.bytedance.sdk.openadsdk.core.bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.sx.1
                @Override // java.lang.Runnable
                public void run() {
                    sx.this.nr();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public BackupView x() {
        return this.u;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.u
    public void u(com.bytedance.sdk.component.adexpress.nr.fx fxVar) {
        this.b = fxVar;
    }
}
