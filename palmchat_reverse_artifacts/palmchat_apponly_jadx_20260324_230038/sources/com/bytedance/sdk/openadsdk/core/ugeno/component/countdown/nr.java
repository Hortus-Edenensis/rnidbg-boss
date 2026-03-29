package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bytedance.adsdk.ugeno.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.adsdk.ugeno.nr.fx<CycleCountDownView> {
    private String hs;
    private String ki;
    private String te;
    private String u;

    public nr(@NonNull Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public CycleCountDownView u() {
        return new CycleCountDownView(this.nr);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "boxImage":
                ((CycleCountDownView) this.pn).setBoxImage(null);
                com.bytedance.adsdk.ugeno.b.u().nr().u(this.f5034a, str2, new u.InterfaceC0173u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.nr.1
                    @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
                    public void u(Bitmap bitmap) {
                        ((CycleCountDownView) ((com.bytedance.adsdk.ugeno.nr.fx) nr.this).pn).setBoxImage(bitmap);
                    }
                });
                break;
            case "before":
                this.u = str2;
                break;
            case "finish":
                this.te = str2;
                break;
            case "text":
                this.hs = str2;
                break;
            case "after":
                this.ki = str2;
                break;
            case "boxFinishImage":
                com.bytedance.adsdk.ugeno.b.u().nr().u(this.f5034a, str2, new u.InterfaceC0173u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.nr.2
                    @Override // com.bytedance.adsdk.ugeno.u.InterfaceC0173u
                    public void u(Bitmap bitmap) {
                        ((CycleCountDownView) ((com.bytedance.adsdk.ugeno.nr.fx) nr.this).pn).setBoxFinish(bitmap);
                    }
                });
                break;
        }
        ((CycleCountDownView) this.pn).u(this.u, this.ki, this.hs, this.te);
    }

    public void u(int i, int i2, int i3, boolean z) {
        T t = this.pn;
        if (t != 0) {
            ((CycleCountDownView) t).u(i, i2, i3);
            ((CycleCountDownView) this.pn).setCanSkip(z);
            ((CycleCountDownView) this.pn).setClickable(z);
            ((CycleCountDownView) this.pn).setEnabled(z);
        }
    }
}
