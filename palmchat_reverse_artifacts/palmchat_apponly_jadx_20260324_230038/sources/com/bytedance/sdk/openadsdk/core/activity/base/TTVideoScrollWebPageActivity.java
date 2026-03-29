package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.b.fx;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.res.pn;
import com.bytedance.sdk.openadsdk.widget.TTScrollView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTScrollView f5209a;

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(2114387873);
        this.f5209a = tTScrollView;
        tTScrollView.setListener(new TTScrollView.u() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.widget.TTScrollView.u
            public void u(boolean z) {
                try {
                    fx fxVar = TTVideoScrollWebPageActivity.this.n;
                    if (fxVar != null && (fxVar instanceof b)) {
                        if (!z || fxVar.bq()) {
                            TTVideoScrollWebPageActivity.this.n.iz();
                        } else {
                            ((b) TTVideoScrollWebPageActivity.this.n).iz(false);
                        }
                    }
                } catch (Throwable th) {
                    k.u("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        fx fxVar = this.n;
        if (fxVar != null) {
            fxVar.b(false);
        }
        NativeVideoTsView nativeVideoTsView = ((TTVideoWebPageActivity) this).x;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setVideoAdInteractionListener(new fx.InterfaceC0154fx() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.2
                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void o_() {
                    fx fxVar2;
                    if (TTVideoScrollWebPageActivity.this.f5209a == null || TTVideoScrollWebPageActivity.this.f5209a.u() || (fxVar2 = TTVideoScrollWebPageActivity.this.n) == null) {
                        return;
                    }
                    fxVar2.x();
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void D_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void p_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void q_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.b.fx.InterfaceC0154fx
                public void u(long j, long j2) {
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(pn.jp(this));
    }
}
