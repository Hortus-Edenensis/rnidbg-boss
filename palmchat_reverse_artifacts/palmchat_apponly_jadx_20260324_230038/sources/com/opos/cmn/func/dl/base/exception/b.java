package com.opos.cmn.func.dl.base.exception;

import android.content.Context;
import com.opos.cmn.func.dl.base.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f7991a;
    private static Context b;

    private b(Context context) {
        b = context;
    }

    public static b a(Context context) {
        if (f7991a == null) {
            synchronized (b.class) {
                if (f7991a == null) {
                    f7991a = new b(context);
                }
            }
        }
        return f7991a;
    }

    public void a(String str, int i, String str2, long j, e eVar) {
    }
}
