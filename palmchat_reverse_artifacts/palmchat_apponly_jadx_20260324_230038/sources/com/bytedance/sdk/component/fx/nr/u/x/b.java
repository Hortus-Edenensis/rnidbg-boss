package com.bytedance.sdk.component.fx.nr.u.x;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class b<T> {
    private final Class[] fx;
    private final String nr;
    private final Class<?> u;

    public b(Class<?> cls, String str, Class... clsArr) {
        this.u = cls;
        this.nr = str;
        this.fx = clsArr;
    }

    public Object b(T t, Object... objArr) {
        try {
            return fx(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object fx(T t, Object... objArr) throws InvocationTargetException {
        Method methodU = u(t.getClass());
        if (methodU != null) {
            try {
                return methodU.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(methodU)));
                assertionError.initCause(e);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.nr + " not supported for object " + t);
    }

    public Object nr(T t, Object... objArr) {
        try {
            return u(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean u(T t) {
        return u(t.getClass()) != null;
    }

    public Object u(T t, Object... objArr) throws InvocationTargetException {
        Method methodU = u(t.getClass());
        if (methodU == null) {
            return null;
        }
        try {
            return methodU.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    private Method u(Class<?> cls) {
        Class<?> cls2;
        String str = this.nr;
        if (str == null) {
            return null;
        }
        Method methodU = u(cls, str, this.fx);
        if (methodU == null || (cls2 = this.u) == null || cls2.isAssignableFrom(methodU.getReturnType())) {
            return methodU;
        }
        return null;
    }

    private static Method u(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
