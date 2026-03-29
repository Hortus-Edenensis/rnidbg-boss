package com.bytedance.sdk.component.fx.nr.u.nr;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class pn extends RuntimeException {
    private static final Method u;
    private IOException nr;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        u = declaredMethod;
    }

    public pn(IOException iOException) {
        super(iOException);
        this.nr = iOException;
    }

    public IOException u() {
        return this.nr;
    }

    public void u(IOException iOException) {
        u(iOException, this.nr);
        this.nr = iOException;
    }

    private void u(IOException iOException, IOException iOException2) {
        Method method = u;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
