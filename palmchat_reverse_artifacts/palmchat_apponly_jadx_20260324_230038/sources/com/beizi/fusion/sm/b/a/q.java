package com.beizi.fusion.sm.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class q implements com.beizi.fusion.sm.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4693a;
    private Class<?> b;
    private Object c;

    @SuppressLint({"PrivateApi"})
    public q(Context context) {
        this.f4693a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            com.beizi.fusion.sm.b.e.a(e);
        }
    }

    private String b() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f4693a);
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        return this.c != null;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f4693a == null || bVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            bVar.a(new com.beizi.fusion.sm.b.d("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new com.beizi.fusion.sm.b.d("OAID query failed");
            }
            com.beizi.fusion.sm.b.e.a("OAID query success: " + strB);
            bVar.a(strB);
        } catch (Exception e) {
            com.beizi.fusion.sm.b.e.a(e);
            bVar.a(e);
        }
    }
}
