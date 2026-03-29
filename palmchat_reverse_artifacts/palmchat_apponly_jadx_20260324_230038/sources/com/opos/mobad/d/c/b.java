package com.opos.mobad.d.c;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8756a = "FoldUtil";
    private static int b = -1;

    public static boolean a(Context context) {
        if (b == -1) {
            int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
            if (identifier <= 0 || !context.getResources().getBoolean(identifier)) {
                b = 0;
            } else {
                b = 1;
            }
        }
        return b == 1;
    }
}
