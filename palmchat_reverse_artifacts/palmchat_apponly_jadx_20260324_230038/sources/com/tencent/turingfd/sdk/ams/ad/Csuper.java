package com.tencent.turingfd.sdk.ams.ad;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.super, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Csuper implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f10774a;
    public final /* synthetic */ Cnew b;
    public final /* synthetic */ String c;

    public Csuper(Window window, Cnew cnew, String str) {
        this.f10774a = window;
        this.b = cnew;
        this.c = str;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        Object objInvoke;
        Object objA;
        try {
            View decorView = this.f10774a.getDecorView();
            decorView.getViewTreeObserver().removeOnPreDrawListener(this);
            Object objInvoke2 = null;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(decorView, new Object[0]);
            } catch (Throwable unused) {
                objInvoke = null;
            }
            if (objInvoke == null) {
                return true;
            }
            try {
                Method methodA = Apple.a(objInvoke.getClass(), "getAccessibilityInteractionController", (Class<?>[]) null);
                if (methodA != null) {
                    objInvoke2 = methodA.invoke(objInvoke, null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (objInvoke2 == null || (objA = Apple.a(objInvoke2.getClass(), "mHandler", objInvoke2)) == null) {
                return true;
            }
            Field declaredField = Handler.class.getDeclaredField("mCallback");
            declaredField.setAccessible(true);
            Handler.Callback callback = (Handler.Callback) declaredField.get(objA);
            if (callback instanceof Cfor) {
                return true;
            }
            declaredField.set(objA, new Cfor(callback, this.b, this.c));
        } catch (Throwable unused2) {
        }
        return true;
    }
}
