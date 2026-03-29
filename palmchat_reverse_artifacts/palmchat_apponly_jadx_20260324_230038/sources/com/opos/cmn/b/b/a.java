package com.opos.cmn.b.b;

import com.opos.cmn.an.d.b;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f7816a;

    public a(Class<?> cls) {
        this.f7816a = cls;
    }

    public Field a(String str) {
        try {
            if (this.f7816a == null || b.a(str)) {
                return null;
            }
            return this.f7816a.getDeclaredField(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ReflectEngine", "getDeclareField", e);
            return null;
        }
    }

    public void a(Field field, Object obj, Object obj2) {
        try {
            if (this.f7816a == null || field == null || obj == null) {
                return;
            }
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ReflectEngine", "setFieldValue", e);
        }
    }
}
