package com.tencent.turingfd.sdk.ams.ad;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Almond {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0011 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0012 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(Class<?> cls, String str, Object obj) {
        Field declaredField;
        try {
            declaredField = cls.getDeclaredField(str);
        } catch (Throwable unused) {
        }
        if (declaredField != null) {
            declaredField.setAccessible(true);
            if (declaredField != null) {
                return null;
            }
            try {
                return declaredField.get(obj);
            } catch (Throwable unused2) {
                return null;
            }
        }
        declaredField = null;
        if (declaredField != null) {
        }
    }
}
