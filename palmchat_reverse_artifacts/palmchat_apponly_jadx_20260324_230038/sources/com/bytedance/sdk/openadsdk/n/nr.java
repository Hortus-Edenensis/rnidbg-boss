package com.bytedance.sdk.openadsdk.n;

import android.widget.ImageView;
import com.bytedance.sdk.component.iz.c;
import com.bytedance.sdk.component.iz.s;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.y.m;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static c nr() {
        return (c) com.bytedance.sdk.openadsdk.ats.fx.u("img_service");
    }

    public static com.bytedance.sdk.openadsdk.core.dislike.ui.u u() {
        return new com.bytedance.sdk.openadsdk.core.dislike.ui.u() { // from class: com.bytedance.sdk.openadsdk.n.nr.1
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.u
            public void u(ImageView imageView, String str) {
                nr.u(com.bytedance.sdk.openadsdk.core.n.fx.u(str)).to(imageView);
            }
        };
    }

    public static s u(String str) {
        return u(nr().from(str));
    }

    public static s u(rh rhVar) {
        return u(nr().from(rhVar.u()).width(rhVar.nr()).height(rhVar.fx()).key(rhVar.x()));
    }

    public static InputStream u(String str, String str2) {
        return nr().getCacheStream(str, str2);
    }

    private static s u(s sVar) {
        return m.u() ? sVar.track(new fx()) : sVar;
    }
}
