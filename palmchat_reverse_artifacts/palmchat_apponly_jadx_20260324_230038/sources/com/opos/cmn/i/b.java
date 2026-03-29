package com.opos.cmn.i;

import android.app.Activity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static boolean a(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
