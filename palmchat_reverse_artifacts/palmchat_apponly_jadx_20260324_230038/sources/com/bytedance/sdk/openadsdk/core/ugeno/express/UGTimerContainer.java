package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class UGTimerContainer extends FrameLayout {
    private com.bytedance.sdk.openadsdk.core.ugeno.t.u u;

    public UGTimerContainer(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar = this.u;
        if (uVar != null) {
            if (i == 0) {
                uVar.u();
            } else {
                uVar.nr();
            }
        }
    }

    public void setTimerHolder(com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar) {
        this.u = uVar;
    }
}
