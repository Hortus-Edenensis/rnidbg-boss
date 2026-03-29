package com.vivo.push.util;

import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11310a = -1;

    public static int a() {
        int i = f11310a;
        if (i != -1) {
            return i;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            f11310a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            t.d("MultiUserManager", "getMyUserId = " + f11310a);
            return f11310a;
        } catch (Exception e) {
            t.a("MultiUserManager", "getMyUserId error " + e.getMessage());
            return 0;
        }
    }
}
