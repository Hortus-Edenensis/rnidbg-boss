package com.wifi.ad.core.utils;

import com.umeng.ccg.a;
import java.lang.reflect.Field;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/utils/ReflectUtils;", "", "()V", "getValue", a.F, "clazz", "Ljava/lang/Class;", "fieldName", "", "any", "key", "core_release"}, k = 1, mv = {1, 1, 16})
public final class ReflectUtils {
    public static final ReflectUtils INSTANCE = new ReflectUtils();

    private ReflectUtils() {
    }

    public final Object getValue(Object any, String key) {
        Field declaredField;
        if (any != null) {
            try {
                declaredField = any.getClass().getDeclaredField(key);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else {
            declaredField = null;
        }
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            return declaredField.get(any);
        }
        return null;
    }

    public final Object getValue(Object target, Class<?> clazz, String fieldName) {
        Field declaredField;
        if (fieldName == null) {
            return null;
        }
        if (clazz != null) {
            try {
                declaredField = clazz.getDeclaredField(fieldName);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else {
            declaredField = null;
        }
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        if (declaredField != null) {
            return declaredField.get(target);
        }
        return null;
    }
}
