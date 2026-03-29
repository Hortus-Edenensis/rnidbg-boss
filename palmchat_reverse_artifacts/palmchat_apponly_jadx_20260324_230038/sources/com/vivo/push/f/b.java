package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class b {
    private static volatile b c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f11230a;
    private Context b;

    private b() {
    }

    public static synchronized b a() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    public final synchronized a a(Context context) {
        a aVar = this.f11230a;
        if (aVar != null) {
            return aVar;
        }
        if (context == null) {
            return null;
        }
        if (aVar == null) {
            Context context2 = ContextDelegate.getContext(context.getApplicationContext());
            this.b = context2;
            this.f11230a = new c(context2);
        }
        return this.f11230a;
    }
}
