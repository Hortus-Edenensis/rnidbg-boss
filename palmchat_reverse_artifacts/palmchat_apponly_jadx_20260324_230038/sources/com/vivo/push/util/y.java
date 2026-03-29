package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class y extends c {
    private Context b;

    public y(Context context) {
        if (context != null) {
            this.b = context;
            a(context);
        }
    }

    private synchronized void a(Context context) {
        a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    public final String c() {
        String string;
        Context context = this.b;
        String packageName = context.getPackageName();
        Object objA = ag.a(context, packageName, "com.vivo.push.app_id");
        if (objA != null) {
            string = objA.toString();
        } else {
            Object objA2 = ag.a(context, packageName, "app_id");
            string = objA2 != null ? objA2.toString() : "";
        }
        return TextUtils.isEmpty(string) ? b("APP_APPID", "") : string;
    }

    public final String d() {
        String string;
        Context context = this.b;
        String packageName = context.getPackageName();
        Object objA = ag.a(context, packageName, "com.vivo.push.api_key");
        if (objA != null) {
            string = objA.toString();
        } else {
            Object objA2 = ag.a(context, packageName, "api_key");
            string = objA2 != null ? objA2.toString() : "";
        }
        return TextUtils.isEmpty(string) ? b("APP_APIKEY", "") : string;
    }
}
