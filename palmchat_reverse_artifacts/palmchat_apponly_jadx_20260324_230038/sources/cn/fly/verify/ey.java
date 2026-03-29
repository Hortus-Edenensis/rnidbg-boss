package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.verify.fq;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ey implements ep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f2269a = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> c = new ConcurrentHashMap<>();
    private Context d;
    private eq e;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a<T> {
        public T f;
        public int g;
        public long h;

        public a(T t) {
            this(t, 1, 0L);
        }

        public abstract T b() throws Throwable;

        public a(T t, int i, long j) {
            this.f = t;
            this.g = i;
            this.h = j;
        }

        public a(T t, long j) {
            this(t, 1, j);
        }
    }

    public ey(Context context) {
        this.d = context;
        this.e = eq.a(context);
    }

    private ArrayList<HashMap<String, String>> i(boolean z) {
        ArrayList<HashMap<String, String>> arrayList;
        synchronized ("gal") {
            arrayList = (ArrayList) a("gal", new a<ArrayList<HashMap<String, String>>>(null) { // from class: cn.fly.verify.ey.26
                @Override // cn.fly.verify.ey.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public ArrayList<HashMap<String, String>> b() throws Throwable {
                    return ey.this.e.s();
                }
            }, z);
        }
        return arrayList;
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Long> A() {
        return (HashMap) a("meio", new a<HashMap<String, Long>>(null) { // from class: cn.fly.verify.ey.14
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Long> b() throws Throwable {
                return ey.this.e.F();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String B() {
        return (String) a("ale", new a<String>(null) { // from class: cn.fly.verify.ey.15
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.i();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String C() {
        return (String) a("sse", new a<String>(null) { // from class: cn.fly.verify.ey.17
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.k();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String D() {
        return Cdo.h() ? f(false) : "forbid";
    }

    @Override // cn.fly.verify.ep
    public String E() {
        String lowerCase = D().toLowerCase();
        return ba.a((TextUtils.isEmpty(lowerCase) || ba.a("004gNgf$gh").equals(lowerCase)) ? "004g:gfAgh" : (lowerCase.startsWith(ba.a("002Pjkgg")) || lowerCase.startsWith(ba.a("002Ojngg")) || lowerCase.startsWith(ba.a("002?lhgg")) || lowerCase.startsWith(ba.a("002Njggg"))) ? "004ehii" : (lowerCase.startsWith(ba.a("004Hhhfkghfk")) || "forbid".equals(lowerCase)) ? "004[hhfkghfk" : "005CgfZkjhUfl");
    }

    @Override // cn.fly.verify.ep
    public String F() {
        String str;
        String lowerCase = D().toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || ba.a("004gTgf8gh").equals(lowerCase)) {
            str = "004gQgf2gh";
        } else if (lowerCase.startsWith(ba.a("004*hhfkghfk"))) {
            str = "004=hhfkghfk";
        } else if (lowerCase.startsWith(ba.a("0024jkgg"))) {
            str = "002Ujkgg";
        } else if (lowerCase.startsWith(ba.a("002!jngg"))) {
            str = "002)jngg";
        } else if (lowerCase.startsWith(ba.a("0027lhgg"))) {
            str = "002>lhgg";
        } else if (lowerCase.startsWith(ba.a("0025jggg"))) {
            str = "002Xjggg";
        } else {
            if (!lowerCase.startsWith(ba.a("009<hg.i-fiDhkDgfgfOkj"))) {
                return lowerCase;
            }
            str = "009)hg_i$fi!hk0gfgfRkj";
        }
        return ba.a(str);
    }

    @Override // cn.fly.verify.ep
    public boolean G() {
        String strE = E();
        return ba.a("004=hhfkghfk").equals(strE) || ba.a("004ehii").equals(strE);
    }

    @Override // cn.fly.verify.ep
    public int H() {
        return ((Integer) a("dtnttp", new a<Integer>(-1, 180000L) { // from class: cn.fly.verify.ey.19
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() throws Throwable {
                return Integer.valueOf(ey.this.e.V());
            }
        })).intValue();
    }

    @Override // cn.fly.verify.ep
    public String I() {
        return (String) a("tize", new a<String>(null) { // from class: cn.fly.verify.ey.20
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.Q();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String J() {
        return (String) a("flvr", new a<String>(null) { // from class: cn.fly.verify.ey.21
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.R();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String K() {
        return (String) a("babd", new a<String>(null) { // from class: cn.fly.verify.ey.22
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.S();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String L() {
        return (String) a("bfsp", new a<String>(null) { // from class: cn.fly.verify.ey.24
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.T();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String M() {
        return (String) a("bopm", new a<String>(null) { // from class: cn.fly.verify.ey.25
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.U();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String N() {
        if (!az.a().h()) {
            return az.a().q();
        }
        if (!Cdo.h()) {
            return "0.0.0.0";
        }
        try {
            Enumeration<NetworkInterface> enumerationA = et.a(this.d).a();
            while (enumerationA.hasMoreElements()) {
                Enumeration<InetAddress> enumerationA2 = et.a(this.d).a(enumerationA.nextElement());
                while (enumerationA2.hasMoreElements()) {
                    InetAddress inetAddressNextElement = enumerationA2.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> O() {
        return i(false);
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> P() {
        ArrayList<HashMap<String, String>> arrayListA;
        synchronized ("gsl") {
            arrayListA = this.e.a(i(false), 2);
        }
        return arrayListA;
    }

    @Override // cn.fly.verify.ep
    public String Q() {
        return (String) a("deky", new a<String>(null) { // from class: cn.fly.verify.ey.27
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.a(false);
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String R() {
        return (String) a("scph", new a<String>(null) { // from class: cn.fly.verify.ey.29
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.t();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String S() {
        return this.e.b(T());
    }

    @Override // cn.fly.verify.ep
    public String T() {
        return (String) a("pne", new a<String>(null) { // from class: cn.fly.verify.ey.31
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.o();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String U() {
        return (String) a("ane", new a<String>(null) { // from class: cn.fly.verify.ey.32
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.p();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public int V() {
        return ((Integer) a("avn", new a<Integer>(-1) { // from class: cn.fly.verify.ey.35
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() throws Throwable {
                return Integer.valueOf(ey.this.e.q());
            }
        })).intValue();
    }

    @Override // cn.fly.verify.ep
    public String W() {
        return (String) a("avne", new a<String>(null) { // from class: cn.fly.verify.ey.36
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.r();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public boolean X() {
        return ((Boolean) a("imp", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.verify.ey.37
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() throws Throwable {
                return Boolean.valueOf(ey.this.e.X());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String Y() {
        return (String) a("cpne", new a<String>(null) { // from class: cn.fly.verify.ey.38
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.Y();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public boolean Z() {
        return ei.a();
    }

    @Override // cn.fly.verify.ep
    public Context aa() {
        return (Context) a((String) null, new a<Context>(null) { // from class: cn.fly.verify.ey.39
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Context b() throws Throwable {
                if (ey.this.d != null) {
                    return ey.this.d;
                }
                Context contextX = eq.x();
                if (contextX != null) {
                    ey.this.d = contextX;
                }
                return contextX;
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String ab() {
        return this.e.d();
    }

    @Override // cn.fly.verify.ep
    public String ac() {
        return this.e.e();
    }

    @Override // cn.fly.verify.ep
    public long ad() {
        return ((Long) a("alut", new a<Long>(0L) { // from class: cn.fly.verify.ey.42
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long b() throws Throwable {
                return Long.valueOf(ey.this.e.Z());
            }
        })).longValue();
    }

    @Override // cn.fly.verify.ep
    public String ae() {
        return (String) a("dvcnm", new a<String>(null) { // from class: cn.fly.verify.ey.43
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.aa();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String af() {
        return (String) a("cgrp", new a<String>(null) { // from class: cn.fly.verify.ey.44
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.ab();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String ag() {
        return (String) a("cinfo", new a<String>(null) { // from class: cn.fly.verify.ey.46
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.ac();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String ah() {
        if (!az.a().d()) {
            return az.a().k();
        }
        String str = null;
        if (Cdo.a()) {
            return (String) a("odmt", new a<String>(str) { // from class: cn.fly.verify.ey.47
                @Override // cn.fly.verify.ey.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String b() throws Throwable {
                    return ey.this.e.ad();
                }
            });
        }
        return null;
    }

    @Override // cn.fly.verify.ep
    public String ai() {
        String strAh = er.a(this.d).d().ah();
        if (!TextUtils.isEmpty(strAh)) {
            try {
                return Base64.encodeToString(fr.a(fr.b(fq.d.k()), strAh), 2);
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        return strAh;
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> aj() {
        return (HashMap) a("alldmt", new a<HashMap<String, Object>>(null) { // from class: cn.fly.verify.ey.48
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Object> b() throws Throwable {
                return ey.this.e.ae();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo ak() {
        return (ApplicationInfo) a("gtaif", new a<ApplicationInfo>(null) { // from class: cn.fly.verify.ey.49
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApplicationInfo b() throws Throwable {
                return et.a(ey.this.d).d();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, Object>> al() {
        return (ArrayList) a("gtwflok", new a<ArrayList<HashMap<String, Object>>>(null, 180000L) { // from class: cn.fly.verify.ey.50
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList<HashMap<String, Object>> b() throws Throwable {
                Boolean bool;
                if (!Cdo.d() || !ey.this.e(ba.a("036fg3feflgffkfehf'lhYflfhfkhjhjfkgf'gDhfimhlgngjkfijfjiggkhngkfjglgmgngmij")) || !ey.this.e(ba.a("036fg*feflgffkfehf.lhCflfhfkhjhjfkgfEgPhfgnimimijglglfjiggkhngkfjglgmgngmij"))) {
                    return null;
                }
                LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                ey.this.e.a(linkedBlockingQueue);
                ey.this.e.A();
                try {
                    bool = (Boolean) linkedBlockingQueue.poll(20000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    en.a().a(th);
                    bool = null;
                }
                if (bool == null || !bool.booleanValue()) {
                    return null;
                }
                return ey.this.e.z();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public long am() {
        return ((Long) a("gtbdt", new a<Long>(0L) { // from class: cn.fly.verify.ey.54
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long b() throws Throwable {
                return Long.valueOf(ey.this.e.af());
            }
        })).longValue();
    }

    @Override // cn.fly.verify.ep
    public double an() {
        return ((Double) a("gtscnin", new a<Double>(Double.valueOf(0.0d)) { // from class: cn.fly.verify.ey.55
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Double b() throws Throwable {
                return Double.valueOf(ey.this.e.ag());
            }
        })).doubleValue();
    }

    @Override // cn.fly.verify.ep
    public int ao() {
        return ((Integer) a("gtscnppi", new a<Integer>(0) { // from class: cn.fly.verify.ey.57
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() throws Throwable {
                return Integer.valueOf(ey.this.e.ah());
            }
        })).intValue();
    }

    @Override // cn.fly.verify.ep
    public boolean ap() {
        return ((Boolean) a("ishmos", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.verify.ey.58
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() throws Throwable {
                return Boolean.valueOf(ey.this.e.ai());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String aq() {
        return (String) a("gthmosv", new a<String>(null) { // from class: cn.fly.verify.ey.59
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.aj();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String ar() {
        return (String) a("gthmosdtlv", new a<String>(null) { // from class: cn.fly.verify.ey.60
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.ak();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public int as() {
        return ((Integer) a((String) null, new a<Integer>(-1) { // from class: cn.fly.verify.ey.61
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() throws Throwable {
                return Integer.valueOf(ey.this.e.al());
            }
        })).intValue();
    }

    @Override // cn.fly.verify.ep
    public int at() {
        return ((Integer) a((String) null, new a<Integer>(-1) { // from class: cn.fly.verify.ey.62
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() throws Throwable {
                return Integer.valueOf(ey.this.e.am());
            }
        })).intValue();
    }

    @Override // cn.fly.verify.ep
    public String au() {
        return (String) a("gtinnerlangmt", new a<String>(null) { // from class: cn.fly.verify.ey.63
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.ao();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public int av() {
        return ((Integer) a("gtgramgendt", new a<Integer>(0) { // from class: cn.fly.verify.ey.65
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() throws Throwable {
                return Integer.valueOf(ey.this.e.ap());
            }
        })).intValue();
    }

    @Override // cn.fly.verify.ep
    public boolean aw() {
        return ((Boolean) a("debbing", new a<Boolean>(Boolean.FALSE, 180000L) { // from class: cn.fly.verify.ey.66
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() throws Throwable {
                return Boolean.valueOf(ey.this.e.ar());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String c(final String str) {
        return (String) a("snm_" + str, new a<String>(null) { // from class: cn.fly.verify.ey.30
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.b(str);
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String d(final String str) {
        return (String) a((String) null, new a<String>(null) { // from class: cn.fly.verify.ey.33
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.c(str);
            }
        });
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> e(boolean z) {
        return (HashMap) a("crtwfo", new a<HashMap<String, Object>>(null, 180000L) { // from class: cn.fly.verify.ey.3
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Object> b() throws Throwable {
                return ey.this.e.y();
            }
        }, z);
    }

    @Override // cn.fly.verify.ep
    public String f(boolean z) {
        return (String) a("nte", new a<String>(null, 180000L) { // from class: cn.fly.verify.ey.18
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.n();
            }
        }, z);
    }

    @Override // cn.fly.verify.ep
    public String g(boolean z) {
        return this.e.a(z);
    }

    @Override // cn.fly.verify.ep
    public String h(boolean z) {
        return (String) a("gtdm", new a<String>(null) { // from class: cn.fly.verify.ey.69
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ej.a().h();
            }
        }, z);
    }

    @Override // cn.fly.verify.ep
    public String j() {
        return (String) a("agi", new a<String>(null) { // from class: cn.fly.verify.ey.71
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.u();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String k() {
        return (String) a("mvn", new a<String>(null) { // from class: cn.fly.verify.ey.34
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.G();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String l() {
        return (String) a("mol", new a<String>(null) { // from class: cn.fly.verify.ey.45
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.b();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String m() {
        return (String) a("mar", new a<String>(null) { // from class: cn.fly.verify.ey.56
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.c();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String n() {
        return (String) a("brd", new a<String>(null) { // from class: cn.fly.verify.ey.67
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.W();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String o() {
        return (String) a("dte", new a<String>(null) { // from class: cn.fly.verify.ey.72
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.w();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public Object p() {
        return a("gtecloc", new a<Object>(null, 180000L) { // from class: cn.fly.verify.ey.73
            @Override // cn.fly.verify.ey.a
            public Object b() throws Throwable {
                return ey.this.e.an();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, Object>> q() {
        return (ArrayList) a("bsnbcl", new a<ArrayList<HashMap<String, Object>>>(null, 180000L) { // from class: cn.fly.verify.ey.2
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList<HashMap<String, Object>> b() throws Throwable {
                return ey.this.e.v();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> r() {
        return e(false);
    }

    @Override // cn.fly.verify.ep
    public int s() {
        return ((Integer) a("ovit", new a<Integer>(-1) { // from class: cn.fly.verify.ey.5
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b() throws Throwable {
                return Integer.valueOf(ey.this.e.f());
            }
        })).intValue();
    }

    @Override // cn.fly.verify.ep
    public String t() {
        return (String) a("ovne", new a<String>(null) { // from class: cn.fly.verify.ey.6
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.g();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String u() {
        return (String) a("ole", new a<String>(null) { // from class: cn.fly.verify.ey.7
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.h();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String v() {
        return (String) a("ocy", new a<String>(null) { // from class: cn.fly.verify.ey.8
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.j();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> w() {
        return (HashMap) a("cio0", new a<HashMap<String, Object>>(null) { // from class: cn.fly.verify.ey.9
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, Object> b() throws Throwable {
                return ey.this.e.B();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public ArrayList<ArrayList<String>> x() {
        return (ArrayList) a("tdio", new a<ArrayList<ArrayList<String>>>(null) { // from class: cn.fly.verify.ey.10
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ArrayList<ArrayList<String>> b() throws Throwable {
                return ey.this.e.C();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public String y() {
        return (String) a("qkl", new a<String>(null) { // from class: cn.fly.verify.ey.11
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.D();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, HashMap<String, Long>> z() {
        return (HashMap) a("siio", new a<HashMap<String, HashMap<String, Long>>>(null) { // from class: cn.fly.verify.ey.13
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, HashMap<String, Long>> b() throws Throwable {
                return ey.this.e.E();
            }
        });
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo a(final String str, final int i) {
        return (ApplicationInfo) a((String) null, new a<ApplicationInfo>(null) { // from class: cn.fly.verify.ey.51
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApplicationInfo b() throws Throwable {
                return et.a(ey.this.d).b(str, i);
            }
        });
    }

    @Override // cn.fly.verify.ep
    public ResolveInfo b(Intent intent, int i) {
        return et.a(this.d).b(intent, i);
    }

    @Override // cn.fly.verify.ep
    public String c(boolean z) {
        return (String) a("car", new a<String>(null) { // from class: cn.fly.verify.ey.12
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.l();
            }
        }, z);
    }

    @Override // cn.fly.verify.ep
    public String d(boolean z) {
        return (String) a("cne", new a<String>(null) { // from class: cn.fly.verify.ey.23
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String b() throws Throwable {
                return ey.this.e.m();
            }
        }, z);
    }

    @Override // cn.fly.verify.ep
    public boolean e() {
        return this.e.M();
    }

    @Override // cn.fly.verify.ep
    public boolean f() {
        return ((Boolean) a("ua0", new a<Boolean>(Boolean.FALSE, 180000L) { // from class: cn.fly.verify.ey.40
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(ey.this.e.L());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean g() {
        return ((Boolean) a("dee1", new a<Boolean>(Boolean.FALSE, 180000L) { // from class: cn.fly.verify.ey.52
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(ey.this.e.K());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean h() {
        return ((Boolean) a("uee", new a<Boolean>(Boolean.FALSE, 180000L) { // from class: cn.fly.verify.ey.64
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(ey.this.e.J());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean i() {
        return ((Boolean) a("wpy", new a<Boolean>(Boolean.FALSE, 180000L) { // from class: cn.fly.verify.ey.70
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(ey.this.e.O());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo a(boolean z, final String str, final int i) {
        return (ApplicationInfo) a("gtaiffce", new a<ApplicationInfo>(null) { // from class: cn.fly.verify.ey.53
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApplicationInfo b() throws Throwable {
                return et.a(ey.this.d).b(str, i);
            }
        }, z);
    }

    @Override // cn.fly.verify.ep
    public Object b(boolean z, int i, String str, int i2) {
        return a(z, i, str, i2);
    }

    @Override // cn.fly.verify.ep
    public boolean c() {
        return ((Boolean) a("pd0", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.verify.ey.16
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(ey.this.e.I());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean d() {
        return ((Boolean) a("dee", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.verify.ey.28
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(ey.this.e.N());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean e(String str) {
        try {
            return this.e.d(str);
        } catch (Throwable th) {
            en.a().a(th);
            return false;
        }
    }

    @Override // cn.fly.verify.ep
    public PackageInfo a(boolean z, int i, final String str, final int i2) {
        return (PackageInfo) a("gpi-" + i + "-" + str + "-" + i2, new a<PackageInfo>(null, i) { // from class: cn.fly.verify.ey.41
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PackageInfo b() throws Throwable {
                return (PackageInfo) et.a(ey.this.d).a(str, i2);
            }
        }, z);
    }

    @Override // cn.fly.verify.ep
    public String b(boolean z) {
        HashMap<String, Object> mapE = e(z);
        if (mapE != null) {
            return (String) mapE.get("bsmt");
        }
        return null;
    }

    @Override // cn.fly.verify.ep
    public Location a(int i, int i2, boolean z) {
        return (Location) a(i, i2, z, false);
    }

    @Override // cn.fly.verify.ep
    public boolean b() {
        return ((Boolean) a("cx0", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.verify.ey.4
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(ey.this.e.H());
            }
        })).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean b(String str) {
        return this.e.e(str);
    }

    @Override // cn.fly.verify.ep
    public Object a(final int i, final int i2, final boolean z, final boolean z2) {
        return a("gctn-" + i + "-" + i2 + "-" + z, new a<Location>(null, 180000L) { // from class: cn.fly.verify.ey.68
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Location b() throws Throwable {
                Object objA = ey.this.e.a(i, i2, z, z2);
                if (objA instanceof Location) {
                    return (Location) objA;
                }
                return null;
            }
        }, z2);
    }

    private <T> T a(String str, a<T> aVar) {
        return (T) a(str, (a) aVar, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T a(String str, a<T> aVar, boolean z) {
        T tB;
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        int iValueOf;
        Object objB = null;
        try {
        } catch (Throwable th) {
            if (th instanceof PackageManager.NameNotFoundException) {
                en.a().b("Exception: " + th.getClass().getName() + ": " + th.getMessage());
            } else {
                en.a().b(th);
            }
        }
        if (str == null) {
            tB = aVar.b();
            return tB != null ? aVar.f : tB;
        }
        Integer num = this.b.get(str);
        if (num != null && (objB = this.f2269a.get(str)) == null && num.intValue() >= aVar.g && !z) {
            return aVar.f;
        }
        Long l = this.c.get(str);
        boolean z2 = false;
        if (l != null && System.currentTimeMillis() >= l.longValue()) {
            z2 = true;
        }
        if (objB == null || z2 || z) {
            objB = aVar.b();
            if (objB != null) {
                this.f2269a.put(str, objB);
                if (aVar.h > 0) {
                    this.c.put(str, Long.valueOf(System.currentTimeMillis() + aVar.h));
                }
            }
            if (num == null) {
                concurrentHashMap = this.b;
                iValueOf = 1;
            } else {
                concurrentHashMap = this.b;
                iValueOf = Integer.valueOf(num.intValue() + 1);
            }
            concurrentHashMap.put(str, iValueOf);
        }
        tB = (T) objB;
        if (tB != null) {
        }
    }

    @Override // cn.fly.verify.ep
    public String a(String str) {
        return this.e.a(str);
    }

    @Override // cn.fly.verify.ep
    public String a(boolean z) {
        HashMap<String, Object> mapE = e(z);
        if (mapE != null) {
            return (String) mapE.get("ssmt");
        }
        return null;
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> a(boolean z, boolean z2) {
        synchronized ("giafce") {
            ArrayList<HashMap<String, String>> arrayListI = i(z2);
            if (z) {
                return this.e.a(arrayListI, 0);
            }
            return this.e.a(arrayListI, 1);
        }
    }

    @Override // cn.fly.verify.ep
    public List<ResolveInfo> a(Intent intent, int i) {
        return et.a(this.d).a(intent, i);
    }

    @Override // cn.fly.verify.ep
    public boolean a() {
        return ((Boolean) a("ird", new a<Boolean>(Boolean.FALSE) { // from class: cn.fly.verify.ey.1
            @Override // cn.fly.verify.ey.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b() {
                return Boolean.valueOf(ey.this.e.a());
            }
        })).booleanValue();
    }
}
