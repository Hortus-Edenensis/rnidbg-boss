package com.bytedance.adsdk.ugeno.widget.fx;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u extends com.bytedance.adsdk.ugeno.nr.u<UGFrameLayout> {
    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        str.hashCode();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                nr(str, str2);
                break;
        }
    }
}
