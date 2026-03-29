package com.opos.cmn.module.ui.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static void a(Context context, String str, String str2, Class<?> cls) {
        if (context != null && str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = new Intent(context, cls);
                    intent.putExtra("loadUrl", str);
                    intent.putExtra("title", str2);
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    return;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("WebActivityTools", "start failed", e);
                return;
            }
        }
        com.opos.cmn.an.f.a.b("WebActivityTools", "start failed, params error");
    }
}
