package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.renderview.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class TTLottieVideoContainer extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.nr {
    private nr.u u;

    public TTLottieVideoContainer(Context context) {
        super(context);
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(nr.u uVar) {
        this.u = uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.nr
    public void u(com.bykv.vk.openvk.component.video.api.renderview.u uVar) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.nr
    public void u(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.nr
    public View getView() {
        return this;
    }
}
