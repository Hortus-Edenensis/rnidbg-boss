package com.tencent.turingfd.sdk.ams.ad;

import android.os.Handler;
import android.os.Message;
import com.tencent.turingfd.sdk.ams.ad.Cthrow;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.for, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cfor implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler.Callback f10762a;
    public final Cnew b;
    public final String c;

    public Cfor(Handler.Callback callback, Cnew cnew, String str) {
        this.f10762a = callback;
        this.b = cnew;
        this.c = str;
    }

    public final boolean a(Message message) {
        Object objA;
        Object obj = message.obj;
        if (obj == null) {
            return false;
        }
        Object objA2 = Apple.a(obj.getClass(), "argi3", message.obj);
        if (!(objA2 instanceof Integer) || (objA = Apple.a(message.obj.getClass(), "arg1", message.obj)) == null) {
            return false;
        }
        Class<?> cls = objA.getClass();
        Class[] clsArr = {Boolean.TYPE, Integer.TYPE};
        Object[] objArr = {Boolean.FALSE, objA2};
        try {
            Method methodA = Apple.a(cls, "setPerformAccessibilityActionResult", (Class<?>[]) clsArr);
            if (methodA != null) {
                methodA.invoke(objA, objArr);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        try {
            if (message.what == 1) {
                Cnew cnew = this.b;
                String str = this.c;
                Cthrow.Cdo cdo = (Cthrow.Cdo) cnew;
                if (!cdo.f10777a.get()) {
                    cdo.b.obtainMessage(1, str).sendToTarget();
                }
                boolean z = Cinterface.f10765a.get() && a(message);
                if (z) {
                    return true;
                }
                Handler.Callback callback = this.f10762a;
                if (callback != null) {
                    return callback.handleMessage(message);
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
