package com.beizi.fusion.sm.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static String a(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
            if (TextUtils.isEmpty(string) || Boolean.parseBoolean(string)) {
                return "";
            }
            String string2 = Settings.Global.getString(context.getContentResolver(), "oaid");
            return !TextUtils.isEmpty(string2) ? string2 : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
