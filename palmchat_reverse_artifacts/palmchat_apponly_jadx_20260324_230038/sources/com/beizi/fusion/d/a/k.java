package com.beizi.fusion.d.a;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4639a;
    private Class b;
    private Object c;
    private Method d;

    public k(Context context) {
        this.f4639a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.d = this.b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String a(Context context, Method method) {
        Object obj = this.c;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String a() {
        return a(this.f4639a, this.d);
    }
}
