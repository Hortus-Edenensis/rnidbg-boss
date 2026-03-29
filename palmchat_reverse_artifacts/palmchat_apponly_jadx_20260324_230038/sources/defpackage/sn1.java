package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class sn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20789a;
    public final Method b;
    public final int c;
    public boolean d = true;

    public sn1(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventProducer target cannot be null.");
        }
        if (method == null) {
            throw new NullPointerException("EventProducer method cannot be null.");
        }
        this.f20789a = obj;
        this.b = method;
        method.setAccessible(true);
        this.c = ((method.hashCode() + 31) * 31) + obj.hashCode();
    }

    public void a() {
        this.d = false;
    }

    public boolean b() {
        return this.d;
    }

    public Object c() throws InvocationTargetException {
        if (!this.d) {
            throw new IllegalStateException(toString() + " has been invalidated and can no longer produce events.");
        }
        try {
            return this.b.invoke(this.f20789a, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof Error) {
                throw ((Error) e2.getCause());
            }
            throw e2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        sn1 sn1Var = (sn1) obj;
        return this.b.equals(sn1Var.b) && this.f20789a == sn1Var.f20789a;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        return "[EventProducer " + this.b + "]";
    }
}
