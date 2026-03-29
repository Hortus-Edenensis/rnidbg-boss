package com.heytap.mcssdk.utils;

import android.os.Binder;
import android.os.UserHandle;
import com.heytap.mcssdk.PushService;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6360a = PushService.class.getSimpleName();
    private static final int b = 100000;

    public static int a() {
        try {
            UserHandle callingUserHandle = Binder.getCallingUserHandle();
            Method declaredMethod = callingUserHandle.getClass().getDeclaredMethod("getIdentifier", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(callingUserHandle, new Object[0])).intValue();
        } catch (Exception e) {
            d.b(f6360a, "get userId exception," + e);
            return 0;
        }
    }

    public static int a(int i, int i2) {
        return (i2 * 100000) + (i % 100000);
    }
}
