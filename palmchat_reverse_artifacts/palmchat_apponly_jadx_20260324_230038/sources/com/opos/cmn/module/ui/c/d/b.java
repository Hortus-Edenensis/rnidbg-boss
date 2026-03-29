package com.opos.cmn.module.ui.c.d;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.huawei.openalliance.ad.constant.bq;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8077a;
    private com.opos.cmn.module.ui.c.b.a b;
    private Toast c;

    public b(Context context, com.opos.cmn.module.ui.c.b.a aVar) {
        this.f8077a = context.getApplicationContext();
        this.b = aVar;
        this.c = new Toast(this.f8077a);
    }

    public WindowManager.LayoutParams a() {
        Object objA;
        WindowManager.LayoutParams layoutParams = null;
        try {
            Object objA2 = a(this.c, "mTN");
            if (objA2 != null && (objA = a(objA2, "mParams")) != null && (objA instanceof WindowManager.LayoutParams)) {
                layoutParams = (WindowManager.LayoutParams) objA;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CustomToast", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getWindowLayoutParams=");
        sb.append(layoutParams != null ? layoutParams : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("CustomToast", sb.toString());
        return layoutParams;
    }

    public void b() {
        com.opos.cmn.an.f.a.b("CustomToast", bq.b.V);
        this.c.show();
    }

    public void c() {
        com.opos.cmn.an.f.a.b("CustomToast", "cancel");
        this.c.cancel();
    }

    private Object a(Object obj, String str) {
        Field declaredField;
        if (obj == null) {
            return null;
        }
        try {
            if (com.opos.cmn.an.d.b.a(str) || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CustomToast", "", (Throwable) e);
            return null;
        }
    }

    public void a(int i) {
        com.opos.cmn.an.f.a.b("CustomToast", "setDuration duration=" + i);
        this.c.setDuration(i);
    }

    public void a(int i, int i2, int i3) {
        com.opos.cmn.an.f.a.b("CustomToast", "setGravity gravity=" + i + ",xOffset=" + i2 + ",yOffset=" + i3);
        this.c.setGravity(i, i2, i3);
    }

    public void a(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append("setView view=");
        sb.append(view != null ? view : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("CustomToast", sb.toString());
        if (view != null) {
            this.c.setView(view);
        }
    }
}
