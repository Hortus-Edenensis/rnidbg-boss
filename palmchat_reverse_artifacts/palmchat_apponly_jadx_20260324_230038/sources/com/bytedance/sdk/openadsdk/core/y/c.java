package com.bytedance.sdk.openadsdk.core.y;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c {
    public static void u(final Uri uri, final com.bytedance.sdk.openadsdk.core.ja jaVar) {
        if (jaVar == null || !jaVar.u(uri)) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.c.1
                @Override // java.lang.Runnable
                public void run() {
                    jaVar.nr(uri);
                }
            });
        } catch (Exception unused) {
        }
    }

    public static void u(final com.bytedance.sdk.component.mv.fx fxVar, final int i, final boolean z) {
        if (fxVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.c.2
            @Override // java.lang.Runnable
            public void run() {
                String userAgentString = fxVar.getUserAgentString();
                if (TextUtils.isEmpty(userAgentString)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(userAgentString);
                sb.append(" open_news open_news_u_s/");
                sb.append(i);
                if (z) {
                    sb.append("/");
                    sb.append(jp.a());
                }
                fxVar.setUserAgentString(sb.toString());
            }
        });
    }
}
