package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static cy f11493a;

    public static File a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("ERROR: Context cannot be null.");
            return null;
        }
        cy cyVar = f11493a;
        if (cyVar != null) {
            return cyVar.a(context);
        }
        com.xiaomi.channel.commonutils.logger.b.d("ERROR: XMSF not configure the instance of LogAgent.");
        return null;
    }
}
