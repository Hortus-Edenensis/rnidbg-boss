package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class nz4 {
    public static final nz4 f = new nz4();
    public static final jz4 g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<jz4> f19643a = new AtomicReference<>();
    public final AtomicReference<lz4> b = new AtomicReference<>();
    public final AtomicReference<pz4> c = new AtomicReference<>();
    public final AtomicReference<iz4> d = new AtomicReference<>();
    public final AtomicReference<oz4> e = new AtomicReference<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends jz4 {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends iz4 {
        public b() {
        }
    }

    @Deprecated
    public static nz4 c() {
        return f;
    }

    public static Object e(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            Iterator it = properties2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String string = entry.getKey().toString();
                if (string.startsWith("rxjava.plugin.") && string.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                    String str = "rxjava.plugin." + string.substring(0, string.length() - 6).substring(14) + ".impl";
                    String property2 = properties2.getProperty(str);
                    if (property2 == null) {
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                    property = property2;
                }
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e);
        } catch (ClassNotFoundException e2) {
            throw new IllegalStateException(simpleName + " implementation class not found: " + property, e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e3);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e4);
        }
    }

    public iz4 a() {
        if (this.d.get() == null) {
            Object objE = e(iz4.class, System.getProperties());
            if (objE == null) {
                g23.a(this.d, null, new b());
            } else {
                g23.a(this.d, null, (iz4) objE);
            }
        }
        return this.d.get();
    }

    public jz4 b() {
        if (this.f19643a.get() == null) {
            Object objE = e(jz4.class, System.getProperties());
            if (objE == null) {
                g23.a(this.f19643a, null, g);
            } else {
                g23.a(this.f19643a, null, (jz4) objE);
            }
        }
        return this.f19643a.get();
    }

    public lz4 d() {
        if (this.b.get() == null) {
            Object objE = e(lz4.class, System.getProperties());
            if (objE == null) {
                g23.a(this.b, null, mz4.f());
            } else {
                g23.a(this.b, null, (lz4) objE);
            }
        }
        return this.b.get();
    }

    public oz4 f() {
        if (this.e.get() == null) {
            Object objE = e(oz4.class, System.getProperties());
            if (objE == null) {
                g23.a(this.e, null, oz4.h());
            } else {
                g23.a(this.e, null, (oz4) objE);
            }
        }
        return this.e.get();
    }

    public pz4 g() {
        if (this.c.get() == null) {
            Object objE = e(pz4.class, System.getProperties());
            if (objE == null) {
                g23.a(this.c, null, qz4.f());
            } else {
                g23.a(this.c, null, (pz4) objE);
            }
        }
        return this.c.get();
    }
}
