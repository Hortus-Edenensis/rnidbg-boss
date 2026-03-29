package com.lantern.auth.assit;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WkMResource {
    public static int getIdByName(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext.getResources().getIdentifier(str2, str, applicationContext.getPackageName());
    }
}
