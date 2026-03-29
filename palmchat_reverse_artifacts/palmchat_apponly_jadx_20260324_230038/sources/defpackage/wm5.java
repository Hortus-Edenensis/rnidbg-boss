package defpackage;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class wm5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f21753a;
    public final ThreadMode b;
    public final Class<?> c;
    public final int d;
    public final boolean e;
    public String f;

    public wm5(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f21753a = method;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    public final synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f21753a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f21753a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wm5)) {
            return false;
        }
        a();
        wm5 wm5Var = (wm5) obj;
        wm5Var.a();
        return this.f.equals(wm5Var.f);
    }

    public int hashCode() {
        return this.f21753a.hashCode();
    }
}
