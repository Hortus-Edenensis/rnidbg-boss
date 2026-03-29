package com.beizi.ad;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f4347a = null;
    private static boolean b = false;

    @RequiresPermission(g.f7481a)
    public static void a(Context context, String str, c cVar) {
        f4347a = cVar;
        com.beizi.ad.internal.c.a().a(context, str);
    }

    public static boolean b() {
        return b;
    }

    public static String c(String str) {
        return com.beizi.ad.internal.c.a().b(str);
    }

    public static void b(String str) {
        com.beizi.ad.internal.c.a().e = str;
    }

    public static c a() {
        return f4347a;
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void a(String str) {
        com.beizi.ad.internal.c.a().a(str);
    }

    public static void a(List<String> list) {
        com.beizi.ad.internal.c.a().a(list);
    }
}
