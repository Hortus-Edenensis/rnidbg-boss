package defpackage;

import com.zenmen.palmchat.c;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nl0 {
    public static String A = null;
    public static String B = null;
    public static final String[] C = {"https://118.184.189.131", "https://118.184.189.133", "https://118.184.189.135", "https://118.184.189.137"};
    public static final String[] D;
    public static final String[] E;
    public static final String[] F;
    public static final String[] G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19552a = "release";
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f19553a;
        public static String b;
        public static String c;
        public static String d;
        public static String e;
        public static String f;
        public static String g;
        public static String h;
        public static String i;
        public static String j;
        public static String k;
        public static String l;
        public static String m;
        public static String n;
        public static String o;
        public static String p;
        public static String q;
        public static String r;

        /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void t() {
            String str = "http://short3.lx-qa.com";
            f19553a = nl0.g() ? nl0.c().equals("release") ? "http://short.lianxinapp.com" : nl0.c().equals("debug") ? "http://short1.lx-qa.com" : nl0.c().equals("debug2") ? "http://short2.lx-qa.com" : nl0.c().equals("debug3") ? "http://short3.lx-qa.com" : "http://short0.lx-qa.com" : "http://short.zmchat.lianxinapp.com";
            String str2 = "https://short0.lx-qa.com";
            String str3 = "https://short1.lx-qa.com";
            b = nl0.g() ? nl0.c().equals("release") ? "https://short.lianxinapp.com" : nl0.c().equals("debug") ? "https://short1.lx-qa.com" : nl0.c().equals("debug2") ? "https://short2.lx-qa.com" : nl0.c().equals("debug3") ? "https://short3.lx-qa.com" : "https://short0.lx-qa.com" : "https://short.zmchat.lianxinapp.com";
            if (!nl0.g()) {
                str2 = "https://short.zmchat.lianxinapp.com";
            } else if (nl0.h()) {
                str2 = "https://short-pre.lianxinapp.com";
            } else if (nl0.c().equals("release")) {
                str2 = "https://short.lianxinapp.com";
            } else if (!nl0.c().equals("debug")) {
                if (nl0.c().equals("debug2")) {
                    str2 = "https://short2.lx-qa.com";
                } else if (nl0.c().equals("debug3")) {
                    str2 = "https://short1.lx-qa.com";
                }
            }
            c = str2;
            d = nl0.g() ? nl0.c().equals("release") ? "http://static.lianxinapp.com" : nl0.c().equals("debug") ? "http://static1.lx-qa.com" : nl0.c().equals("debug2") ? "http://static2.lx-qa.com" : nl0.c().equals("debug3") ? "http://static3.lx-qa.com" : "http://static0.lx-qa.com" : "http://static.zmchat.lianxinapp.com";
            e = nl0.g() ? nl0.c().equals("release") ? "http://pstore.lianxinapp.com" : nl0.c().equals("debug") ? "http://pstore1.lx-qa.com" : nl0.c().equals("debug2") ? "http://pstore2.lx-qa.com" : nl0.c().equals("debug3") ? "http://pstore3.lx-qa.com" : "http://pstore0.lx-qa.com" : "http://pstore.zmchat.lianxinapp.com";
            f = nl0.g() ? nl0.c().equals("release") ? "https://redpacket.lianxinapp.com" : nl0.c().equals("debug") ? "https://red1.lx-qa.com" : nl0.c().equals("debug2") ? "https://red2.lx-qa.com" : nl0.c().equals("debug3") ? "https://red3.lx-qa.com" : "https://red0.lx-qa.com" : "https://redpacket-zm.lianxinapp.com";
            if (!nl0.g()) {
                str = "https://redpacket-zm.lianxinapp.com";
            } else if (nl0.c().equals("release")) {
                str = "https://redpacket.lianxinapp.com";
            } else if (nl0.c().equals("debug")) {
                str = "http://short1.lx-qa.com";
            } else if (nl0.c().equals("debug2")) {
                str = "http://short2.lx-qa.com";
            } else if (!nl0.c().equals("debug3")) {
                str = "http://short0.lx-qa.com";
            }
            g = str;
            h = nl0.g() ? nl0.c().equals("release") ? "https://storage.lianxinapp.com" : nl0.c().equals("debug") ? "https://storage1.lx-qa.com" : nl0.c().equals("debug2") ? "https://storage2.lx-qa.com" : nl0.c().equals("debug3") ? "https://storage3.lx-qa.com" : "https://storage0.lx-qa.com" : "http://storage-zmchat.lianxinapp.com";
            i = nl0.g() ? nl0.c().equals("release") ? "https://fmedia.lianxinapp.com" : nl0.c().equals("debug") ? "https://fmedia1.lx-qa.com" : nl0.c().equals("debug2") ? "https://fmedia2.lx-qa.com" : nl0.c().equals("debug3") ? "https://fmedia3.lx-qa.com" : "https://fmedia0.lx-qa.com" : "http://fmedia-zmchat.lianxinapp.com";
            j = nl0.g() ? nl0.c().equals("release") ? "https://tmedia.lianxinapp.com" : nl0.c().equals("debug") ? "https://tmedia1.lx-qa.com" : nl0.c().equals("debug2") ? "https://tmedia2.lx-qa.com" : nl0.c().equals("debug3") ? "https://tmedia3.lx-qa.com" : "https://tmedia0.lx-qa.com" : "http://tmedia-zmchat.lianxinapp.com";
            String str4 = "http://heartbeat.lianxinapp.com";
            if (nl0.g() && !nl0.c().equals("release")) {
                str4 = nl0.c().equals("debug") ? "http://heartbeat1.lx-qa.com" : nl0.c().equals("debug2") ? "http://heartbeat2.lx-qa.com" : nl0.c().equals("debug3") ? "http://heartbeat3.lx-qa.com" : "http://heartbeat0.lx-qa.com";
            }
            k = str4;
            l = nl0.g() ? nl0.c().equals("release") ? "https://log.lianxinapp.com" : nl0.c().equals("debug") ? "https://log1.lx-qa.com" : nl0.c().equals("debug2") ? "https://log2.lx-qa.com" : nl0.c().equals("debug3") ? "https://log3.lx-qa.com" : "https://log0.lx-qa.com" : "https://log.zmchat.lianxinapp.com";
            m = nl0.g() ? nl0.c().equals("release") ? "https://dp.lianxinapp.com" : nl0.c().equals("debug") ? "https://dp1.lx-qa.com" : nl0.c().equals("debug2") ? "https://dp2.lx-qa.com" : nl0.c().equals("debug3") ? "https://dp3.lx-qa.com" : "https://dp0.lx-qa.com" : "https://dp.zmchat.lianxinapp.com";
            if (!nl0.g() || nl0.c().equals("release")) {
                str3 = "https://dn.lianxinapp.com";
            } else if (!nl0.c().equals("debug")) {
                str3 = "https://dn.lx-qa.com";
                if (!nl0.c().equals("debug2")) {
                    nl0.c().equals("debug3");
                }
            }
            n = str3;
            String str5 = "https://openapi.lianxinapp.com";
            if (nl0.g() && !nl0.c().equals("release")) {
                str5 = nl0.c().equals("debug") ? "https://openapi1.lx-qa.com" : nl0.c().equals("debug2") ? "https://openapi2.lx-qa.com" : nl0.c().equals("debug3") ? "https://openapi3.lx-qa.com" : "https://openapi0.lx-qa.com";
            }
            o = str5;
            p = nl0.g() ? nl0.c().equals("release") ? "callnotify.voip.lianxinapp.com" : nl0.c().equals("debug") ? "callnotify.voip1.lx-qa.com" : nl0.c().equals("debug2") ? "callnotify.voip2.lx-qa.com" : nl0.c().equals("debug3") ? "callnotify.voip3.lx-qa.com" : "callnotify.voip0.lx-qa.com" : "callnotify-zm.voip.lianxinapp.com";
            q = nl0.g() ? nl0.c().equals("release") ? "webgate.voip.lianxinapp.com" : nl0.c().equals("debug") ? "webgate.voip1.lx-qa.com" : nl0.c().equals("debug2") ? "webgate.voip2.lx-qa.com" : nl0.c().equals("debug3") ? "webgate.voip3.lx-qa.com" : "webgate.voip0.lx-qa.com" : "webgate-zm.voip.lianxinapp.com";
            String str6 = "https://assets.cdn.lianxinapp.com";
            if (nl0.g()) {
                if (nl0.h()) {
                    str6 = "https://assets-pre.lianxinapp.com";
                } else if (!nl0.c().equals("release")) {
                    str6 = nl0.c().equals("debug") ? "https://short1.lx-qa.com/mapps" : nl0.c().equals("debug2") ? "https://short2.lx-qa.com/mapps" : nl0.c().equals("debug3") ? "https://short3.lx-qa.com/mapps" : "https://short0.lx-qa.com/mapps";
                }
            }
            r = str6;
        }
    }

    static {
        String[] strArr = {"https://163.53.168.225"};
        D = strArr;
        E = strArr;
        F = strArr;
        G = strArr;
    }

    public static ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(a.f19553a);
        arrayList.add(a.b);
        arrayList.add(a.d);
        arrayList.add(a.e);
        arrayList.add(a.h);
        arrayList.add(a.i);
        arrayList.add(a.f);
        arrayList.add(a.l);
        arrayList.add(a.m);
        arrayList.add(a.o);
        arrayList.add(a.p);
        arrayList.add("https://palmchat.cdn.lianxinapp.com");
        arrayList.add("https://assets.cdn.lianxinapp.com");
        arrayList.add("https://repositorycdn.lx0.cn");
        arrayList.add("https://h5.lianxinapp.com");
        arrayList.add("https://rescdn.lx0.cn");
        arrayList.add("https://albumcdn.lx0.cn");
        arrayList.add("https://squarecdn.lx0.cn");
        arrayList.add("https://avatar.cdn.lianxinapp.com");
        return arrayList;
    }

    public static String[] b() {
        return g() ? c().equals("release") ? C : c().equals("debug") ? D : c().equals("debug2") ? E : c().equals("debug3") ? G : F : C;
    }

    public static String c() {
        return f19552a;
    }

    public static void d(String str) {
        f19552a = str;
        a.t();
        e();
    }

    public static void e() {
        b = a.b;
        c = a.b;
        d = a.c;
        e = a.f;
        f = a.h;
        g = a.i;
        h = a.j;
        i = a.k;
        j = a.o;
        k = a.g;
        l = a.n;
        String str = b;
        m = str;
        n = str;
        o = str;
        p = str;
        q = a.r;
        r = a.m;
        s = b;
        t = c;
        u = a.b;
        v = a.l;
        w = a.e;
        x = a.p;
        y = a.q;
        z = a.b + "/one/ax";
        A = z + "/ad.info.show.v3";
        B = z + "/media.sdk.info";
    }

    public static boolean f() {
        return c.c().equals("com.zenmen.im");
    }

    public static boolean g() {
        return c.c().equals("com.zenmen.palmchat");
    }

    public static boolean h() {
        return "release".equals(c()) && ac1.r.equals(ac1.p(c.b()));
    }

    public static boolean i(String str) {
        return str != null && (str.startsWith(a.f) || str.startsWith(a.g));
    }

    public static boolean j() {
        return false;
    }

    public static boolean k() {
        return c().equals("release");
    }
}
