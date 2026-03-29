package cn.fly.verify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import cn.fly.verify.fq;
import cn.fly.verify.fy;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public class gf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static gf f2387a;
    private volatile Object b;
    private volatile Object c;
    private volatile Object d;
    private volatile Object e = b();
    private volatile Class<?> f;
    private long g;

    private gf() {
    }

    public static gf a() {
        if (f2387a == null) {
            synchronized (gf.class) {
                if (f2387a == null) {
                    f2387a = new gf();
                }
            }
        }
        return f2387a;
    }

    private Object b() {
        HashMap map = new HashMap();
        final int iIdentityHashCode = System.identityHashCode(map);
        try {
            map.put(ec.b("017*dcWdJebdcWbchYchdc0d,fjVgcdZdd;e:cb"), new fy.a<Object[], Object>() { // from class: cn.fly.verify.gf.1
                @Override // cn.fly.verify.fy.a
                public Object a(Object[] objArr) {
                    gf gfVar;
                    Object obj;
                    if (objArr != null) {
                        try {
                            if (objArr.length > 0) {
                                en.a().a("[212] oncge" + objArr[0], new Object[0]);
                                Object obj2 = objArr[0];
                                if (!(obj2 instanceof List) || ((List) obj2).size() <= 0) {
                                    gfVar = gf.this;
                                    obj = objArr[0];
                                } else {
                                    List list = (List) objArr[0];
                                    gfVar = gf.this;
                                    obj = list.get(list.size() - 1);
                                }
                                gfVar.c = obj;
                            }
                        } catch (Throwable th) {
                            try {
                                en.a().a(th);
                                synchronized (gf.this) {
                                    notifyAll();
                                    return null;
                                }
                            } catch (Throwable th2) {
                                synchronized (gf.this) {
                                    notifyAll();
                                    throw th2;
                                }
                            }
                        }
                    }
                    gf.this.c();
                    synchronized (gf.this) {
                        notifyAll();
                    }
                    return null;
                }
            });
            map.put("equals", new fy.a<Object[], Object>() { // from class: cn.fly.verify.gf.2
                @Override // cn.fly.verify.fy.a
                public Object a(Object[] objArr) {
                    Object obj;
                    en.a().a("equals " + objArr, new Object[0]);
                    if (objArr == null || (obj = objArr[0]) == null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf(obj.hashCode() == iIdentityHashCode);
                }
            });
            map.put(ec.b("008gcAeg1g=fjdccbJe"), new fy.a<Object[], Object>() { // from class: cn.fly.verify.gf.3
                @Override // cn.fly.verify.fy.a
                public Object a(Object[] objArr) {
                    en.a().a(ec.b("008gc6egAg=fjdccb9e"), new Object[0]);
                    return Integer.valueOf(iIdentityHashCode);
                }
            });
            return fy.a(map, (Class<?>[]) new Class[]{d()});
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e != null) {
            fy.a(this.d, ec.b("013]ciWeJcedcccVeBdf^iKcb6che@eg"), new Object[]{this.e}, (Class<?>[]) new Class[]{d()}, (Object) null);
        }
    }

    private Class<?> d() {
        if (this.f == null) {
            try {
                this.f = Class.forName(ec.b("033cdCcbcidcchcbec@f%dcHbchTchdcEd.ecebdc9bchHchdcSd:ebchegXhedeUci"));
            } catch (Throwable unused) {
            }
        }
        return this.f;
    }

    private Object a(Context context, int i, int i2, boolean z) {
        Object obj = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (fq.d.b(ec.b("039cdJcbcidcchcbec$ie cicechegegchdc d7ecdkfjfjfgdidicgekdhdgfgcgebfffjdkdjdhffdg")) || fq.d.b(ec.b("041cd1cbcidcchcbecQie@cicechegegchdc0d5ecdkfjfjfgdidicgfjffdkfhdifgcgebfffjdkdjdhffdg"))) {
            if (this.d == null) {
                this.d = fq.d.a(ec.b("008f0dc9bchGchdc%d"));
            }
            if (this.d == null) {
                return null;
            }
            synchronized (this) {
                if (i != 0) {
                    try {
                        if (a(this.d, ec.b("003-ddYi-eg"))) {
                            a(context, ec.b("003-ddOiEeg"), i * 1000);
                        }
                    } finally {
                    }
                }
                if ((i2 != 0) && a(this.d, ec.b("007deh eedccick"))) {
                    a(context, ec.b("007dehUeedccick"), i2 * 1000);
                }
            }
            en.a().a(th);
            return obj;
        }
        if (this.c == null && z) {
            this.c = b(ec.b("003%dd:i5eg"));
            if (this.c == null) {
                this.c = b(ec.b("007deh'eedccick"));
            }
        }
        if (this.c == null) {
            return null;
        }
        this.b = fy.a(fy.a(ec.b("025cd6cbcidcchcbec-f.dc5bch:chdc]d4ecebdcJbch.chdc0d")), this.c);
        Object objA = fy.a(fy.a(ec.b("025cd.cbcidcchcbec(fQdcAbch*chdc0dBecebdcUbchXchdc:d")), this.c);
        try {
            this.g = System.currentTimeMillis();
            this.c = null;
            return objA;
        } catch (Throwable th2) {
            obj = objA;
            th = th2;
        }
    }

    private Object b(String str) {
        if (Build.VERSION.SDK_INT > 25) {
            try {
                return ex.a(ax.g(), str);
            } catch (Throwable unused) {
            }
        }
        return et.a(ax.g()).b(str);
    }

    private void b(Context context, String str, long j) {
        if (Cdo.e()) {
            try {
                et.a(context).a(str, 1000L, 0.0f, this.e);
                wait(j);
            } catch (Throwable th) {
                en.a().a(th);
            }
            c();
        }
    }

    public Object a(Context context, int i, int i2, boolean z, boolean z2) {
        if (!az.a().c()) {
            return az.a().j();
        }
        Object objA = a(z2);
        if (objA == null) {
            synchronized (gf.class) {
                Object objA2 = a(z2);
                objA = objA2 == null ? a(context, i, i2, z) : objA2;
            }
        }
        return objA;
    }

    private Object a(boolean z) {
        if (!z) {
            try {
                if (this.b == null || System.currentTimeMillis() - this.g > 180000) {
                    return null;
                }
                return fy.a(fy.a(ec.b("025cdYcbcidcchcbecSfVdcQbch3chdc[d%ecebdcGbchGchdcAd")), this.b);
            } catch (Throwable th) {
                en.a().a(th);
                return null;
            }
        }
        return null;
    }

    private void a(Context context, String str, long j) {
        if (Build.VERSION.SDK_INT > 25) {
            try {
                Object objA = ex.a(context, str, j);
                if (objA != null) {
                    this.c = objA;
                    return;
                }
                return;
            } catch (Throwable th) {
                en.a().a("[212] cur err " + th, new Object[0]);
            }
        }
        b(context, str, j);
    }

    private boolean a(Object obj, String str) {
        return Cdo.e() && ((Boolean) fy.a(obj, ec.b("017<chegfkcidcccchcb(eXcifgWdc5ed)fe!cb"), Boolean.FALSE, str)).booleanValue();
    }

    public boolean a(String str) {
        return (ec.b("003%ddZi5eg").equalsIgnoreCase(str) && fq.d.b(ec.b("039cd-cbcidcchcbecVieRcicechegegchdcIdVecdkfjfjfgdidicgekdhdgfgcgebfffjdkdjdhffdg"))) || (ec.b("007deh>eedccick").equalsIgnoreCase(str) && fq.d.b(ec.b("039cdFcbcidcchcbec>ie?cicechegegchdc?d3ecdkfjfjfgdidicgekdhdgfgcgebfffjdkdjdhffdg"))) || (ec.b("007deh?eedccick").equalsIgnoreCase(str) && fq.d.b(ec.b("041cd^cbcidcchcbec*ie6cicechegegchdc;d?ecdkfjfjfgdidicgfjffdkfhdifgcgebfffjdkdjdhffdg")));
    }
}
