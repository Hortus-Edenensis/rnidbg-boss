package com.oplus.instant.router.callback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.oplus.instant.router.callback.Callback;
import defpackage.h87;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c extends Callback {
    public Context c;
    public String d;
    public Callback e;

    public c(Context context, String str, Callback callback) {
        this.c = context;
        this.d = str;
        this.e = callback;
    }

    public final String a(String str) {
        return str.replace("hap://app/", "hap://on_stack/");
    }

    @Override // com.oplus.instant.router.callback.Callback
    public void onResponse(Callback.Response response) {
        String str;
        StringBuilder sb;
        if (this.e == null) {
            return;
        }
        if (this.c instanceof Activity) {
            if (response.f7565a == 1) {
                Intent intent = new Intent("android.intent.action.instant.on_stack", Uri.parse(a(this.d)));
                intent.putExtra("in_one_task", "1");
                if (intent.resolveActivity(this.c.getPackageManager()) != null) {
                    sb = new StringBuilder();
                } else {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(this.d));
                    if (intent.resolveActivity(this.c.getPackageManager()) != null) {
                        sb = new StringBuilder();
                    } else {
                        response.f7565a = 200;
                        str = "QuickApp is not support";
                    }
                }
                sb.append("req_uri: ");
                sb.append(intent.getDataString());
                h87.b("OneTaskCallback", sb.toString());
                this.c.startActivity(intent);
            }
            this.e.onResponse(response);
        }
        response.f7565a = 200;
        str = "context is not activity";
        response.b = str;
        this.e.onResponse(response);
    }
}
