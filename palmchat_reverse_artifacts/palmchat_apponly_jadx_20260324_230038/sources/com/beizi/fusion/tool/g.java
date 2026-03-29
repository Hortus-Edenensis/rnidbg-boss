package com.beizi.fusion.tool;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {
    public static File a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getFilesDir();
        } catch (Exception unused) {
            return context.getFilesDir();
        }
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getCacheDir();
        } catch (Exception unused) {
            return context.getCacheDir();
        }
    }
}
