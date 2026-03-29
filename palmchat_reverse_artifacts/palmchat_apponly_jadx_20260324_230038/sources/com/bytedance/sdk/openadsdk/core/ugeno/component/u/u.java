package com.bytedance.sdk.openadsdk.core.ugeno.component.u;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends com.bytedance.adsdk.ugeno.widget.nr.u {
    public u(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.nr.u
    public String t(String str) {
        str.hashCode();
        switch (str) {
            case "unmuted":
                return "tt_ugen_unmuted";
            case "back":
                return "tt_ugen_back";
            case "logo":
                return "tt_ugen_logo";
            case "close":
                return "tt_ugen_close";
            case "muted":
                return "tt_ugen_muted";
            default:
                return "";
        }
    }
}
