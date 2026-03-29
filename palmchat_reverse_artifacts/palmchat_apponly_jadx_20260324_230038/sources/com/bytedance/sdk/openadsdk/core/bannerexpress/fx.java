package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends nr {
    public fx(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        super(context, bcVar, nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr
    public com.bytedance.sdk.openadsdk.core.multipro.nr.u t() {
        WeakReference<BannerExpressBackupView> weakReference = this.x;
        if (weakReference != null && weakReference.get() != null) {
            return this.x.get().getVideoModel();
        }
        u uVar = ((nr) this).u;
        if (uVar != null) {
            return ((BannerExpressVideoView) uVar).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.nr
    public void u(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (context == null) {
            return;
        }
        ((nr) this).u = new BannerExpressVideoView(context, bcVar, nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.fx fxVar) {
        u uVar = ((nr) this).u;
        if (uVar != null) {
            uVar.setVideoAdListener(fxVar);
        }
    }
}
