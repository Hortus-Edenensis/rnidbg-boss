package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fq {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(b bVar) throws Throwable;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        private String A;
        private Object C;
        private ArrayList<HashMap<String, Object>> D;
        private String E;
        private HashMap<String, Object> F;
        private HashMap<String, Object> H;
        private ArrayList<ArrayList<String>> I;
        private String J;
        private HashMap<String, HashMap<String, Long>> K;
        private HashMap<String, Long> L;
        private String M;
        private boolean N;
        private boolean O;
        private boolean P;
        private boolean Q;
        private boolean R;
        private boolean S;
        private boolean T;
        private boolean U;
        private String V;
        private String W;
        private String X;
        private String Y;
        private int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2367a;
        private String aA;
        private int aB;
        private HashMap<String, Object> aD;
        private ArrayList<HashMap<String, Object>> aF;
        private String aG;
        private String aI;
        private boolean aK;
        private ArrayList<HashMap<String, Object>> aL;
        private boolean aP;
        private String aQ;
        private String af;
        private String ag;
        private String ah;
        private long ai;
        private String aj;
        private String ak;
        private String al;
        private String am;
        private String an;
        private HashMap<String, Object> ao;
        private ApplicationInfo ap;
        private long as;
        private double at;
        private int au;
        private boolean av;
        private String aw;
        private String ax;
        private int ay;
        private int az;
        private String b;
        private String d;
        private String g;
        private String h;
        private String j;
        private String l;
        private String n;
        private String o;
        private boolean q;
        private String r;
        private String s;
        private String t;
        private String v;
        private ArrayList<HashMap<String, String>> z;
        private LinkedList<String> c = new LinkedList<>();
        private LinkedList<String> e = new LinkedList<>();
        private LinkedList<String> f = new LinkedList<>();
        private LinkedList<String> i = new LinkedList<>();
        private LinkedList<String> k = new LinkedList<>();
        private LinkedList<String> m = new LinkedList<>();
        private LinkedList<String> p = new LinkedList<>();
        private LinkedList<String> u = new LinkedList<>();
        private LinkedList<String> w = new LinkedList<>();
        private LinkedList<ArrayList<HashMap<String, String>>> x = new LinkedList<>();
        private LinkedList<ArrayList<HashMap<String, String>>> y = new LinkedList<>();
        private LinkedList<Location> B = new LinkedList<>();
        private LinkedList<Boolean> G = new LinkedList<>();
        private LinkedList<List<ResolveInfo>> aa = new LinkedList<>();
        private LinkedList<ResolveInfo> ab = new LinkedList<>();
        private LinkedList<PackageInfo> ac = new LinkedList<>();
        private LinkedList<PackageInfo> ad = new LinkedList<>();
        private LinkedList<PackageInfo> ae = new LinkedList<>();
        private LinkedList<ApplicationInfo> aq = new LinkedList<>();
        private LinkedList<ApplicationInfo> ar = new LinkedList<>();
        private LinkedList<Object> aC = new LinkedList<>();
        private LinkedList<HashMap<String, Object>> aE = new LinkedList<>();
        private LinkedList<String> aH = new LinkedList<>();
        private LinkedList<String> aJ = new LinkedList<>();
        private LinkedList<Object> aM = new LinkedList<>();
        private LinkedList<Object> aN = new LinkedList<>();
        private LinkedList<Object> aO = new LinkedList<>();

        private static <T> T a(LinkedList<T> linkedList, T t, int... iArr) {
            if (linkedList != null) {
                try {
                    if (iArr.length == 0) {
                        return linkedList.get(0);
                    }
                    if (iArr[0] < linkedList.size()) {
                        return linkedList.get(iArr[0]);
                    }
                    en.a().b("WARNING: " + iArr[0] + " out of bound, size: " + linkedList.size());
                } catch (Throwable th) {
                    en.a().a(th);
                }
            }
            return t;
        }

        public String A() {
            return this.am;
        }

        public String B() {
            return this.an;
        }

        public String C() {
            return this.ax;
        }

        public String D() {
            return this.aA;
        }

        public int E() {
            return this.aB;
        }

        public HashMap<String, Object> F() {
            return this.aD;
        }

        public ArrayList<HashMap<String, Object>> G() {
            return this.aF;
        }

        public String H() {
            return this.aG;
        }

        public String I() {
            return this.aI;
        }

        public boolean J() {
            return this.aK;
        }

        public ArrayList<HashMap<String, Object>> K() {
            return this.aL;
        }

        public String L() {
            return this.aQ;
        }

        public String b() {
            return null;
        }

        public String c() {
            return this.g;
        }

        public String d() {
            return this.h;
        }

        public String e() {
            return this.j;
        }

        public String f() {
            return null;
        }

        public String g() {
            return this.l;
        }

        public PackageInfo h(int... iArr) {
            return (PackageInfo) a(this.ac, (Object) null, iArr);
        }

        public ApplicationInfo i(int... iArr) {
            return (ApplicationInfo) a(this.aq, (Object) null, iArr);
        }

        public Object j(int... iArr) {
            return a(this.aC, (Object) null, iArr);
        }

        public ArrayList<HashMap<String, String>> k() {
            return this.z;
        }

        public Object l(int... iArr) {
            return a(this.aM, (Object) null, iArr);
        }

        public Object m(int... iArr) {
            return a(this.aN, (Object) null, iArr);
        }

        public Object n() {
            return this.C;
        }

        public String o() {
            return this.E;
        }

        public HashMap<String, HashMap<String, Long>> p() {
            return this.K;
        }

        public HashMap<String, Long> q() {
            return this.L;
        }

        public String r() {
            return this.M;
        }

        public boolean s() {
            return this.N;
        }

        public boolean t() {
            return this.O;
        }

        public boolean u() {
            return this.P;
        }

        public boolean v() {
            return this.R;
        }

        public boolean w() {
            return this.S;
        }

        public int x() {
            return this.Z;
        }

        public String y() {
            return this.af;
        }

        public String z() {
            return this.aj;
        }

        public String a(int... iArr) {
            return (String) a(this.f, (Object) null, iArr);
        }

        public String b(int... iArr) {
            return (String) a(this.i, "-1", iArr);
        }

        public String c(int... iArr) {
            return (String) a(this.p, ec.b("004d;dc;de"), iArr);
        }

        public String d(int... iArr) {
            return (String) a(this.u, (Object) null, iArr);
        }

        public ArrayList<HashMap<String, String>> e(int... iArr) {
            return (ArrayList) a(this.y, new ArrayList(), iArr);
        }

        public boolean f(int... iArr) {
            return ((Boolean) a(this.G, Boolean.FALSE, iArr)).booleanValue();
        }

        public List<ResolveInfo> g(int... iArr) {
            return (List) a(this.aa, (Object) null, iArr);
        }

        public String h() {
            return this.s;
        }

        public String i() {
            return this.t;
        }

        public String j() {
            return this.v;
        }

        public HashMap<String, Object> k(int... iArr) {
            return (HashMap) a(this.aE, (Object) null, iArr);
        }

        public String l() {
            return this.A;
        }

        public String m() {
            return null;
        }

        public Object n(int... iArr) {
            return a(this.aO, (Object) null, iArr);
        }

        public void a(String str, Object obj) throws Throwable {
            a(str, obj, false);
        }

        /* JADX WARN: Removed duplicated region for block: B:154:0x01c0 A[PHI: r6
          0x01c0: PHI (r6v23 java.util.LinkedList) = (r6v22 java.util.LinkedList), (r6v24 java.util.LinkedList) binds: [B:158:0x01cf, B:152:0x01bc] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:339:0x0412 A[PHI: r6
          0x0412: PHI (r6v16 java.util.LinkedList) = (r6v14 java.util.LinkedList), (r6v15 java.util.LinkedList), (r6v17 java.util.LinkedList) binds: [B:348:0x042f, B:343:0x0421, B:337:0x040e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0062 A[PHI: r6
          0x0062: PHI (r6v34 java.util.LinkedList) = 
          (r6v4 java.util.LinkedList)
          (r6v5 java.util.LinkedList)
          (r6v25 java.util.LinkedList)
          (r6v26 java.util.LinkedList)
          (r6v27 java.util.LinkedList)
          (r6v28 java.util.LinkedList)
          (r6v29 java.util.LinkedList)
          (r6v30 java.util.LinkedList)
          (r6v31 java.util.LinkedList)
          (r6v32 java.util.LinkedList)
          (r6v35 java.util.LinkedList)
         binds: [B:530:0x066c, B:519:0x064d, B:147:0x01ae, B:136:0x018e, B:107:0x0135, B:90:0x0103, B:79:0x00e3, B:68:0x00c4, B:51:0x0093, B:46:0x0086, B:33:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:421:0x050c A[PHI: r6
          0x050c: PHI (r6v12 java.util.LinkedList) = (r6v11 java.util.LinkedList), (r6v13 java.util.LinkedList) binds: [B:425:0x051b, B:419:0x0508] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[PHI: r6
          0x000d: PHI (r6v39 java.util.LinkedList) = (r6v7 java.util.LinkedList), (r6v36 java.util.LinkedList), (r6v37 java.util.LinkedList), (r6v40 java.util.LinkedList) binds: [B:490:0x05f5, B:16:0x002a, B:11:0x001d, B:5:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(String str, Object obj, boolean z) throws Throwable {
            LinkedList linkedList;
            LinkedList linkedList2;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            obj = null;
            Object obj2 = null;
            if ("gmpfo".equals(str)) {
                linkedList2 = this.aM;
                if (z) {
                    obj = null;
                }
            } else if ("gmpfofce".equals(str)) {
                linkedList2 = this.aN;
                if (z) {
                }
            } else {
                if (!"getMpfos".equals(str)) {
                    boolean z2 = false;
                    z2 = false;
                    if ("cird".equals(str)) {
                        this.f2367a = z ? false : ((Boolean) obj).booleanValue();
                        return;
                    }
                    if ("gsimt".equals(str)) {
                        this.b = z ? null : (String) obj;
                        return;
                    }
                    if ("gsimtfce".equals(str)) {
                        linkedList = this.c;
                        if (!z) {
                            obj2 = (String) obj;
                        }
                    } else {
                        if ("gbsi".equals(str)) {
                            this.d = z ? null : (String) obj;
                            return;
                        }
                        if ("gbsifce".equals(str)) {
                            linkedList = this.e;
                            if (!z) {
                            }
                        } else if ("gstmpts".equals(str)) {
                            linkedList = this.f;
                            if (!z) {
                            }
                        } else {
                            if ("gscsz".equals(str)) {
                                this.g = z ? null : (String) obj;
                                return;
                            }
                            if ("gcrie".equals(str)) {
                                this.h = z ? null : (String) obj;
                                return;
                            }
                            if ("gcriefce".equals(str)) {
                                linkedList = this.i;
                                if (!z) {
                                }
                            } else {
                                if ("gcrnm".equals(str)) {
                                    this.j = z ? null : (String) obj;
                                    return;
                                }
                                if ("gcrnmfce".equals(str)) {
                                    linkedList = this.k;
                                    if (!z) {
                                    }
                                } else {
                                    if ("gsnmd".equals(str)) {
                                        this.l = z ? null : (String) obj;
                                        return;
                                    }
                                    if ("gsnmdfp".equals(str)) {
                                        linkedList = this.m;
                                        if (!z) {
                                        }
                                    } else {
                                        if ("gneyp".equals(str)) {
                                            this.n = z ? null : (String) obj;
                                            return;
                                        }
                                        if ("gneypnw".equals(str)) {
                                            this.o = z ? null : (String) obj;
                                            return;
                                        }
                                        if ("gneypfce".equals(str)) {
                                            linkedList = this.p;
                                            if (!z) {
                                            }
                                        } else {
                                            if ("cknavbl".equals(str)) {
                                                this.q = z ? false : ((Boolean) obj).booleanValue();
                                                return;
                                            }
                                            if ("gnktpfs".equals(str)) {
                                                this.r = z ? null : (String) obj;
                                                return;
                                            }
                                            if ("gdtlnktpfs".equals(str)) {
                                                this.s = z ? null : (String) obj;
                                                return;
                                            }
                                            if ("gdvk".equals(str)) {
                                                this.t = z ? null : (String) obj;
                                                return;
                                            }
                                            if ("gdvkfc".equals(str)) {
                                                linkedList = this.u;
                                                if (!z) {
                                                }
                                            } else {
                                                if ("gpnmmt".equals(str)) {
                                                    this.v = z ? null : (String) obj;
                                                    return;
                                                }
                                                if ("gpnmfp".equals(str)) {
                                                    linkedList = this.w;
                                                    if (!z) {
                                                    }
                                                } else if ("gia".equals(str)) {
                                                    linkedList = this.x;
                                                    if (!z) {
                                                        obj2 = (ArrayList) obj;
                                                    }
                                                } else if ("giafce".equals(str)) {
                                                    linkedList = this.y;
                                                    if (!z) {
                                                    }
                                                } else {
                                                    if ("gsl".equals(str)) {
                                                        this.z = z ? null : (ArrayList) obj;
                                                        return;
                                                    }
                                                    if ("gavti".equals(str)) {
                                                        this.A = z ? null : (String) obj;
                                                        return;
                                                    }
                                                    if ("glctn".equals(str)) {
                                                        linkedList = this.B;
                                                        if (!z) {
                                                            obj2 = (Location) obj;
                                                        }
                                                    } else {
                                                        if ("gtecloc".equals(str)) {
                                                            if (z) {
                                                                obj = null;
                                                            }
                                                            this.C = obj;
                                                            return;
                                                        }
                                                        if ("gnbclin".equals(str)) {
                                                            this.D = z ? null : (ArrayList) obj;
                                                            return;
                                                        }
                                                        if ("gdvtp".equals(str)) {
                                                            this.E = z ? null : (String) obj;
                                                            return;
                                                        }
                                                        if ("wmcwi".equals(str)) {
                                                            this.F = z ? null : (HashMap) obj;
                                                            return;
                                                        }
                                                        if ("ipgist".equals(str)) {
                                                            linkedList2 = this.G;
                                                            obj = Boolean.valueOf(z ? false : ((Boolean) obj).booleanValue());
                                                        } else {
                                                            if ("gcuin".equals(str)) {
                                                                this.H = z ? null : (HashMap) obj;
                                                                return;
                                                            }
                                                            if ("gtydvin".equals(str)) {
                                                                this.I = z ? null : (ArrayList) obj;
                                                                return;
                                                            }
                                                            if ("gqmkn".equals(str)) {
                                                                this.J = z ? null : (String) obj;
                                                                return;
                                                            }
                                                            if ("gszin".equals(str)) {
                                                                this.K = z ? null : (HashMap) obj;
                                                                return;
                                                            }
                                                            if ("gmrin".equals(str)) {
                                                                this.L = z ? null : (HashMap) obj;
                                                                return;
                                                            }
                                                            if ("gmivsn".equals(str)) {
                                                                this.M = z ? null : (String) obj;
                                                                return;
                                                            }
                                                            if ("cx".equals(str)) {
                                                                this.N = z ? false : ((Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("ckpd".equals(str)) {
                                                                this.O = z ? false : ((Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("ubenbl".equals(str)) {
                                                                this.P = z ? false : ((Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("dvenbl".equals(str)) {
                                                                this.Q = z ? false : ((Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("ckua".equals(str)) {
                                                                this.R = z ? false : ((Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("vnmt".equals(str)) {
                                                                this.S = z ? false : ((Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("degb".equals(str)) {
                                                                this.T = z ? false : ((Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("iwpxy".equals(str)) {
                                                                this.U = z ? false : ((Boolean) obj).booleanValue();
                                                                return;
                                                            }
                                                            if ("gflv".equals(str)) {
                                                                this.V = z ? null : (String) obj;
                                                                return;
                                                            }
                                                            if ("gbsbd".equals(str)) {
                                                                this.W = z ? null : (String) obj;
                                                                return;
                                                            }
                                                            if ("gbfspy".equals(str)) {
                                                                this.X = z ? null : (String) obj;
                                                                return;
                                                            }
                                                            if ("gbplfo".equals(str)) {
                                                                this.Y = z ? null : (String) obj;
                                                                return;
                                                            }
                                                            if ("gdntp".equals(str)) {
                                                                this.Z = z ? 0 : ((Integer) obj).intValue();
                                                                return;
                                                            }
                                                            if ("qritsvc".equals(str)) {
                                                                linkedList = this.aa;
                                                                if (!z) {
                                                                    obj2 = (List) obj;
                                                                }
                                                            } else if ("rsaciy".equals(str)) {
                                                                linkedList = this.ab;
                                                                if (!z) {
                                                                    obj2 = (ResolveInfo) obj;
                                                                }
                                                            } else if ("gpgif".equals(str)) {
                                                                linkedList = this.ac;
                                                                if (!z) {
                                                                    obj2 = (PackageInfo) obj;
                                                                }
                                                            } else if ("gpgiffcin".equals(str)) {
                                                                linkedList = this.ad;
                                                                if (!z) {
                                                                }
                                                            } else if ("gpgifstrg".equals(str)) {
                                                                linkedList = this.ae;
                                                                if (!z) {
                                                                }
                                                            } else {
                                                                if ("giads".equals(str)) {
                                                                    this.af = z ? null : (String) obj;
                                                                    return;
                                                                }
                                                                if ("gdvda".equals(str)) {
                                                                    this.ag = z ? null : (String) obj;
                                                                    return;
                                                                }
                                                                if ("gdvdtnas".equals(str)) {
                                                                    this.ah = z ? null : (String) obj;
                                                                    return;
                                                                }
                                                                if ("galtut".equals(str)) {
                                                                    this.ai = z ? 0L : ((Long) obj).longValue();
                                                                    return;
                                                                }
                                                                if ("gdvme".equals(str)) {
                                                                    this.aj = z ? null : (String) obj;
                                                                    return;
                                                                }
                                                                if ("gcrup".equals(str)) {
                                                                    this.ak = z ? null : (String) obj;
                                                                    return;
                                                                }
                                                                if ("gcifm".equals(str)) {
                                                                    this.al = z ? null : (String) obj;
                                                                    return;
                                                                }
                                                                if ("godm".equals(str)) {
                                                                    this.am = z ? null : (String) obj;
                                                                    return;
                                                                }
                                                                if ("godhm".equals(str)) {
                                                                    this.an = z ? null : (String) obj;
                                                                    return;
                                                                }
                                                                if ("galdm".equals(str)) {
                                                                    this.ao = z ? null : (HashMap) obj;
                                                                    return;
                                                                }
                                                                if ("gtaif".equals(str)) {
                                                                    this.ap = z ? null : (ApplicationInfo) obj;
                                                                    return;
                                                                }
                                                                if ("gtaifprm".equals(str)) {
                                                                    linkedList = this.aq;
                                                                    if (!z) {
                                                                        obj2 = (ApplicationInfo) obj;
                                                                    }
                                                                } else if ("gtaifprmfce".equals(str)) {
                                                                    linkedList = this.ar;
                                                                    if (!z) {
                                                                    }
                                                                } else {
                                                                    if ("gtbdt".equals(str)) {
                                                                        this.as = z ? 0L : ((Long) obj).longValue();
                                                                        return;
                                                                    }
                                                                    if ("gtscnin".equals(str)) {
                                                                        this.at = z ? 0.0d : ((Double) obj).doubleValue();
                                                                        return;
                                                                    }
                                                                    if ("gtscnppi".equals(str)) {
                                                                        this.au = z ? 0 : ((Integer) obj).intValue();
                                                                        return;
                                                                    }
                                                                    if ("ishmos".equals(str)) {
                                                                        this.av = z ? false : ((Boolean) obj).booleanValue();
                                                                        return;
                                                                    }
                                                                    if ("gthmosv".equals(str)) {
                                                                        this.aw = z ? null : (String) obj;
                                                                        return;
                                                                    }
                                                                    if ("gthmosdtlv".equals(str)) {
                                                                        this.ax = z ? null : (String) obj;
                                                                        return;
                                                                    }
                                                                    if ("gthmpmst".equals(str)) {
                                                                        this.ay = z ? -1 : ((Integer) obj).intValue();
                                                                        return;
                                                                    }
                                                                    if ("gthmepmst".equals(str)) {
                                                                        this.az = z ? -1 : ((Integer) obj).intValue();
                                                                        return;
                                                                    }
                                                                    if ("gtinnerlangmt".equals(str)) {
                                                                        this.aA = z ? null : (String) obj;
                                                                        return;
                                                                    }
                                                                    if ("gtgramgendt".equals(str)) {
                                                                        this.aB = z ? 0 : ((Integer) obj).intValue();
                                                                        return;
                                                                    }
                                                                    if ("gtelcmefce".equals(str)) {
                                                                        linkedList2 = this.aC;
                                                                        if (z) {
                                                                        }
                                                                    } else {
                                                                        if ("gtmwfo".equals(str)) {
                                                                            this.aD = z ? null : (HashMap) obj;
                                                                            return;
                                                                        }
                                                                        if ("wmcwifce".equals(str)) {
                                                                            linkedList = this.aE;
                                                                            if (!z) {
                                                                                obj2 = (HashMap) obj;
                                                                            }
                                                                        } else {
                                                                            if ("gtaifok".equals(str)) {
                                                                                this.aF = z ? null : (ArrayList) obj;
                                                                                return;
                                                                            }
                                                                            if ("gtmcdi".equals(str)) {
                                                                                this.aG = z ? null : (String) obj;
                                                                                return;
                                                                            }
                                                                            if ("gtmcdifce".equals(str)) {
                                                                                linkedList = this.aH;
                                                                                if (!z) {
                                                                                }
                                                                            } else {
                                                                                if ("gtmbcdi".equals(str)) {
                                                                                    this.aI = z ? null : (String) obj;
                                                                                    return;
                                                                                }
                                                                                if (!"gtmbcdifce".equals(str)) {
                                                                                    if ("miwpy".equals(str)) {
                                                                                        this.aK = z ? false : ((Boolean) obj).booleanValue();
                                                                                        return;
                                                                                    }
                                                                                    if ("gtmnbclfo".equals(str)) {
                                                                                        this.aL = z ? null : (ArrayList) obj;
                                                                                        return;
                                                                                    }
                                                                                    if ("ctedebbing".equals(str)) {
                                                                                        if (!z && ((Boolean) obj).booleanValue()) {
                                                                                            z2 = true;
                                                                                        }
                                                                                        this.aP = z2;
                                                                                        return;
                                                                                    }
                                                                                    if ("gtdm".equals(str)) {
                                                                                        this.aQ = z ? null : (String) obj;
                                                                                        return;
                                                                                    }
                                                                                    throw new Throwable("Unknown name to set: " + str + ", value: " + obj);
                                                                                }
                                                                                linkedList = this.aJ;
                                                                                if (!z) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    linkedList.add(obj2);
                    return;
                }
                linkedList2 = this.aO;
                if (z) {
                }
            }
            linkedList2.add(obj);
        }

        public boolean a() {
            return this.f2367a;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f2368a;
        private final LinkedList<a> b;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f2371a;
            public final Object[] b;

            private a(String str, Object... objArr) {
                this.f2371a = str;
                this.b = objArr;
            }
        }

        private c(Context context) {
            this.b = new LinkedList<>();
            this.f2368a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b M() {
            b bVar = new b();
            for (int i = 0; i < this.b.size(); i++) {
                a aVar = this.b.get(i);
                try {
                    String str = aVar.f2371a;
                    bVar.a(str, a(str, aVar.b));
                } catch (Throwable th) {
                    try {
                        en.a().a(th);
                        bVar.a(aVar.f2371a, (Object) null, true);
                    } catch (Throwable th2) {
                        en.a().a(th2);
                    }
                }
            }
            return bVar;
        }

        public c A() {
            this.b.add(new a("gdvme", new Object[0]));
            return this;
        }

        public c B() {
            this.b.add(new a("godm", new Object[0]));
            return this;
        }

        public c C() {
            this.b.add(new a("godhm", new Object[0]));
            return this;
        }

        public c D() {
            this.b.add(new a("gthmosdtlv", new Object[0]));
            return this;
        }

        public c E() {
            this.b.add(new a("gtinnerlangmt", new Object[0]));
            return this;
        }

        public c F() {
            this.b.add(new a("gtgramgendt", new Object[0]));
            return this;
        }

        public c G() {
            this.b.add(new a("gtmwfo", new Object[0]));
            return this;
        }

        public c H() {
            this.b.add(new a("gtaifok", new Object[0]));
            return this;
        }

        public c I() {
            this.b.add(new a("gtmcdi", new Object[0]));
            return this;
        }

        public c J() {
            this.b.add(new a("gtmbcdi", new Object[0]));
            return this;
        }

        public c K() {
            this.b.add(new a("miwpy", new Object[0]));
            return this;
        }

        public c L() {
            this.b.add(new a("gtmnbclfo", new Object[0]));
            return this;
        }

        public c b() {
            return this;
        }

        public c c() {
            this.b.add(new a("gscsz", new Object[0]));
            return this;
        }

        public c d() {
            this.b.add(new a("gcrie", new Object[0]));
            return this;
        }

        public c e() {
            this.b.add(new a("gcrnm", new Object[0]));
            return this;
        }

        public c g() {
            this.b.add(new a("gsnmd", new Object[0]));
            return this;
        }

        public c h() {
            this.b.add(new a("gdtlnktpfs", new Object[0]));
            return this;
        }

        public c i() {
            this.b.add(new a("gdvk", new Object[0]));
            return this;
        }

        public c j() {
            this.b.add(new a("gpnmmt", new Object[0]));
            return this;
        }

        public c k() {
            this.b.add(new a("gsl", new Object[0]));
            return this;
        }

        public c l() {
            this.b.add(new a("gavti", new Object[0]));
            return this;
        }

        public c n() {
            this.b.add(new a("gtecloc", new Object[0]));
            return this;
        }

        public c o() {
            this.b.add(new a("gdvtp", new Object[0]));
            return this;
        }

        public c p() {
            this.b.add(new a("gszin", new Object[0]));
            return this;
        }

        public c q() {
            this.b.add(new a("gmrin", new Object[0]));
            return this;
        }

        public c r() {
            this.b.add(new a("gmivsn", new Object[0]));
            return this;
        }

        public c s() {
            this.b.add(new a("cx", new Object[0]));
            return this;
        }

        public c t() {
            this.b.add(new a("ckpd", new Object[0]));
            return this;
        }

        public c u() {
            this.b.add(new a("ubenbl", new Object[0]));
            return this;
        }

        public c v() {
            this.b.add(new a("ckua", new Object[0]));
            return this;
        }

        public c w() {
            this.b.add(new a("vnmt", new Object[0]));
            return this;
        }

        public c x() {
            this.b.add(new a("gdntp", new Object[0]));
            return this;
        }

        public c y() {
            this.b.add(new a("giads", new Object[0]));
            return this;
        }

        public c z() {
            this.b.add(new a("galtut", new Object[0]));
            return this;
        }

        public c a() {
            this.b.add(new a("cird", new Object[0]));
            return this;
        }

        public c b(String str) {
            this.b.add(new a("ipgist", new Object[]{str}));
            return this;
        }

        public c c(String str, int i) {
            this.b.add(new a("gmpfo", new Object[]{str, Integer.valueOf(i)}));
            return this;
        }

        public c d(boolean z) {
            this.b.add(new a("wmcwifce", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public c e(boolean z) {
            this.b.add(new a("gtdm", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public c a(int i, int i2, boolean z, boolean z2) {
            this.b.add(new a("gtelcmefce", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}));
            return this;
        }

        public c b(String str, int i) {
            this.b.add(new a("gtaifprm", new Object[]{str, Integer.valueOf(i)}));
            return this;
        }

        public c c(boolean z) {
            this.b.add(new a("gdvkfc", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public c a(int i, String str, int i2) {
            this.b.add(new a("getMpfos", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}));
            return this;
        }

        public c b(boolean z) {
            this.b.add(new a("gneypfce", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(a aVar) {
            if (aVar != null) {
                try {
                    aVar.a(new b());
                } catch (Throwable th) {
                    en.a().a(th, "Error from caller", new Object[0]);
                }
            }
        }

        public c a(Intent intent, int i) {
            this.b.add(new a("qritsvc", new Object[]{intent, Integer.valueOf(i)}));
            return this;
        }

        public c a(String str) {
            this.b.add(new a("gstmpts", new Object[]{str}));
            return this;
        }

        public c a(String str, int i) {
            this.b.add(new a("gpgif", new Object[]{str, Integer.valueOf(i)}));
            return this;
        }

        public c a(boolean z) {
            this.b.add(new a("gcriefce", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public c a(boolean z, String str, int i) {
            this.b.add(new a("gmpfofce", new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i)}));
            return this;
        }

        public c a(boolean z, boolean z2) {
            this.b.add(new a("giafce", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}));
            return this;
        }

        private Object a(String str, Object[] objArr) throws Throwable {
            if ("gmpfo".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return er.a(this.f2368a).d().b(false, 0, (String) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gmpfofce".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new Throwable("params illegal: " + objArr);
                }
                return er.a(this.f2368a).d().b(((Boolean) objArr[0]).booleanValue(), 0, (String) objArr[1], ((Integer) objArr[2]).intValue());
            }
            if ("getMpfos".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new Throwable("params illegal: " + objArr);
                }
                return er.a(this.f2368a).d().b(false, ((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue());
            }
            if ("cird".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().a());
            }
            if ("gsimt".equals(str)) {
                return er.a(this.f2368a).d().a(false);
            }
            if ("gsimtfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().a(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gbsi".equals(str)) {
                return er.a(this.f2368a).d().b(false);
            }
            if ("gbsifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().b(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gstmpts".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().a((String) objArr[0]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gscsz".equals(str)) {
                return er.a(this.f2368a).d().C();
            }
            if ("gcrie".equals(str)) {
                return er.a(this.f2368a).d().c(false);
            }
            if ("gcriefce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().c(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gcrnm".equals(str)) {
                return er.a(this.f2368a).d().d(false);
            }
            if ("gcrnmfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().d(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gsnmd".equals(str)) {
                return er.a(this.f2368a).d().S();
            }
            if ("gsnmdfp".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().c((String) objArr[0]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gneyp".equals(str)) {
                return er.a(this.f2368a).d().f(false);
            }
            if ("gneypnw".equals(str)) {
                return er.a(this.f2368a).d().D();
            }
            if ("gneypfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().f(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("cknavbl".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().G());
            }
            if ("gnktpfs".equals(str)) {
                return er.a(this.f2368a).d().E();
            }
            if ("gdtlnktpfs".equals(str)) {
                return er.a(this.f2368a).d().F();
            }
            if ("gdvk".equals(str)) {
                return er.a(this.f2368a).d().Q();
            }
            if ("gdvkfc".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().g(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gpnmmt".equals(str)) {
                return er.a(this.f2368a).d().U();
            }
            if ("gpnmfp".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().d((String) objArr[0]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gia".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().a(((Boolean) objArr[0]).booleanValue(), false);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("giafce".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return er.a(this.f2368a).d().a(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gsl".equals(str)) {
                return er.a(this.f2368a).d().P();
            }
            if ("gscpt".equals(str)) {
                return er.a(this.f2368a).d().R();
            }
            if ("gavti".equals(str)) {
                return er.a(this.f2368a).d().j();
            }
            if ("glctn".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new Throwable("params illegal: " + objArr);
                }
                return er.a(this.f2368a).d().a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
            }
            if ("gtecloc".equals(str)) {
                return er.a(this.f2368a).d().p();
            }
            if ("gnbclin".equals(str)) {
                return er.a(this.f2368a).d().q();
            }
            if ("gdvtp".equals(str)) {
                return er.a(this.f2368a).d().o();
            }
            if ("wmcwi".equals(str)) {
                return er.a(this.f2368a).d().r();
            }
            if ("ipgist".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return Boolean.valueOf(er.a(this.f2368a).d().b((String) objArr[0]));
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gcuin".equals(str)) {
                return er.a(this.f2368a).d().w();
            }
            if ("gtydvin".equals(str)) {
                return er.a(this.f2368a).d().x();
            }
            if ("gqmkn".equals(str)) {
                return er.a(this.f2368a).d().y();
            }
            if ("gszin".equals(str)) {
                return er.a(this.f2368a).d().z();
            }
            if ("gmrin".equals(str)) {
                return er.a(this.f2368a).d().A();
            }
            if ("gmivsn".equals(str)) {
                return er.a(this.f2368a).d().k();
            }
            if ("cx".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().b());
            }
            if ("ckpd".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().c());
            }
            if ("ubenbl".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().h());
            }
            if ("dvenbl".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().g());
            }
            if ("ckua".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().f());
            }
            if ("vnmt".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().e());
            }
            if ("degb".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().d());
            }
            if ("iwpxy".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().i());
            }
            if ("gflv".equals(str)) {
                return er.a(this.f2368a).d().J();
            }
            if ("gbsbd".equals(str)) {
                return er.a(this.f2368a).d().K();
            }
            if ("gbfspy".equals(str)) {
                return er.a(this.f2368a).d().L();
            }
            if ("gbplfo".equals(str)) {
                return er.a(this.f2368a).d().M();
            }
            if ("gdntp".equals(str)) {
                return Integer.valueOf(er.a(this.f2368a).d().H());
            }
            if ("qritsvc".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return er.a(this.f2368a).d().a((Intent) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("rsaciy".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return er.a(this.f2368a).d().b((Intent) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gpgif".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return er.a(this.f2368a).d().a(false, 0, (String) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gpgiffcin".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new Throwable("params illegal: " + objArr);
                }
                return er.a(this.f2368a).d().a(((Boolean) objArr[0]).booleanValue(), 0, (String) objArr[1], ((Integer) objArr[2]).intValue());
            }
            if ("gpgifstrg".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new Throwable("params illegal: " + objArr);
                }
                return er.a(this.f2368a).d().a(false, ((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue());
            }
            if ("giads".equals(str)) {
                return er.a(this.f2368a).d().N();
            }
            if ("gdvda".equals(str)) {
                return er.a(this.f2368a).d().ab();
            }
            if ("gdvdtnas".equals(str)) {
                return er.a(this.f2368a).d().ac();
            }
            if ("galtut".equals(str)) {
                return Long.valueOf(er.a(this.f2368a).d().ad());
            }
            if ("gdvme".equals(str)) {
                return er.a(this.f2368a).d().ae();
            }
            if ("gcrup".equals(str)) {
                return er.a(this.f2368a).d().af();
            }
            if ("gcifm".equals(str)) {
                return er.a(this.f2368a).d().ag();
            }
            if ("godm".equals(str)) {
                return er.a(this.f2368a).d().ah();
            }
            if ("godhm".equals(str)) {
                return er.a(this.f2368a).d().ai();
            }
            if ("galdm".equals(str)) {
                return er.a(this.f2368a).d().aj();
            }
            if ("gtaif".equals(str)) {
                return er.a(this.f2368a).d().ak();
            }
            if ("gtaifprm".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return er.a(this.f2368a).d().a((String) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gtaifprmfce".equals(str)) {
                if (objArr == null || objArr.length != 3) {
                    throw new Throwable("params illegal: " + objArr);
                }
                return er.a(this.f2368a).d().a(((Boolean) objArr[0]).booleanValue(), (String) objArr[1], ((Integer) objArr[2]).intValue());
            }
            if ("gtbdt".equals(str)) {
                return Long.valueOf(er.a(this.f2368a).d().am());
            }
            if ("gtscnin".equals(str)) {
                return Double.valueOf(er.a(this.f2368a).d().an());
            }
            if ("gtscnppi".equals(str)) {
                return Integer.valueOf(er.a(this.f2368a).d().ao());
            }
            if ("ishmos".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().ap());
            }
            if ("gthmosv".equals(str)) {
                return er.a(this.f2368a).d().aq();
            }
            if ("gthmosdtlv".equals(str)) {
                return er.a(this.f2368a).d().ar();
            }
            if ("gthmpmst".equals(str)) {
                return Integer.valueOf(er.a(this.f2368a).d().as());
            }
            if ("gthmepmst".equals(str)) {
                return Integer.valueOf(er.a(this.f2368a).d().at());
            }
            if ("gtinnerlangmt".equals(str)) {
                return er.a(this.f2368a).d().au();
            }
            if ("gtgramgendt".equals(str)) {
                return Integer.valueOf(er.a(this.f2368a).d().av());
            }
            if ("gtelcmefce".equals(str)) {
                return er.a(this.f2368a).d().a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
            }
            if ("gtmwfo".equals(str)) {
                return er.a(this.f2368a).d().e(false);
            }
            if ("wmcwifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().e(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gtaifok".equals(str)) {
                return er.a(this.f2368a).d().al();
            }
            if ("gtmcdi".equals(str)) {
                return er.a(this.f2368a).d().a(false);
            }
            if ("gtmcdifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().a(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gtmbcdi".equals(str)) {
                return er.a(this.f2368a).d().b(false);
            }
            if ("gtmbcdifce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return er.a(this.f2368a).d().b(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("miwpy".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().i());
            }
            if ("gtmnbclfo".equals(str)) {
                return er.a(this.f2368a).d().q();
            }
            if ("ctedebbing".equals(str)) {
                return Boolean.valueOf(er.a(this.f2368a).d().aw());
            }
            if (!"gtdm".equals(str)) {
                return null;
            }
            if (objArr != null && objArr.length == 1) {
                return er.a(this.f2368a).d().h(((Boolean) objArr[0]).booleanValue());
            }
            throw new Throwable("params illegal: " + objArr);
        }

        public void a(final a aVar) {
            try {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                final Boolean bool = fb.b.get();
                final Boolean bool2 = fb.c.get();
                final boolean z2 = z;
                Runnable runnable = new Runnable() { // from class: cn.fly.verify.fq.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            fb.f2347a.set(Boolean.TRUE);
                            fb.b.set(bool);
                            fb.c.set(bool2);
                            final b bVarM = c.this.M();
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                if (z2) {
                                    gc.a(0, new Handler.Callback() { // from class: cn.fly.verify.fq.c.1.1
                                        @Override // android.os.Handler.Callback
                                        public boolean handleMessage(Message message) {
                                            try {
                                                aVar.a(bVarM);
                                            } catch (Throwable th) {
                                                en.a().a(th, "Error from caller", new Object[0]);
                                            }
                                            return false;
                                        }
                                    });
                                } else {
                                    try {
                                        aVar2.a(bVarM);
                                    } catch (Throwable th) {
                                        en.a().a(th, "Error from caller", new Object[0]);
                                    }
                                }
                            }
                            ThreadLocal<Boolean> threadLocal = fb.f2347a;
                            Boolean bool3 = Boolean.FALSE;
                            threadLocal.set(bool3);
                            fb.b.set(bool3);
                            fb.c.set(bool3);
                        } catch (Throwable th2) {
                            en.a().a(th2);
                            c.this.b(aVar);
                        }
                    }
                };
                if (z) {
                    ek.g.execute(runnable);
                } else {
                    runnable.run();
                }
            } catch (Throwable th) {
                en.a().a(th);
                if (aVar != null) {
                    b(aVar);
                }
            }
        }

        public c f() {
            return this;
        }

        public c m() {
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {
        public static <T> T a(Object obj, String str, Object... objArr) {
            return (T) fy.a(obj, str, (Object) null, objArr);
        }

        public static boolean b() {
            return er.a(ax.g()).d().X();
        }

        public static String c() {
            return er.a(ax.g()).d().T();
        }

        public static String d() {
            return er.a(ax.g()).d().Y();
        }

        public static int e() {
            return 1;
        }

        public static String f() {
            return er.a(ax.g()).d().W();
        }

        public static int g() {
            return er.a(ax.g()).d().s();
        }

        public static String h() {
            return er.a(ax.g()).d().t();
        }

        public static String i() {
            return er.a(ax.g()).d().I();
        }

        public static String j() {
            return er.a(ax.g()).d().l();
        }

        public static String k() {
            return er.a(ax.g()).d().m();
        }

        public static String l() {
            return er.a(ax.g()).d().n();
        }

        public static int m() {
            return er.a(ax.g()).d().V();
        }

        public static <T> T a(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
            try {
                return (T) fy.a(obj, str, objArr, clsArr);
            } catch (Throwable th) {
                if (!(th instanceof InvocationTargetException)) {
                    if (!(th instanceof PackageManager.NameNotFoundException)) {
                        en.a().a(th);
                        return null;
                    }
                    en.a().a("Exception: " + th.getClass().getName() + ": " + th.getMessage(), new Object[0]);
                    return null;
                }
                String name = th.getClass().getName();
                String message = th.getMessage();
                Throwable cause = th.getCause();
                if (cause != null) {
                    name = cause.getClass().getName();
                    message = cause.getMessage();
                }
                en.a().a("Exception: " + name + ": " + message, new Object[0]);
                return null;
            }
        }

        public static boolean b(String str) {
            return er.a(ax.g()).d().e(str);
        }

        public static String c(String str) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final String[] strArr = new String[1];
            fq.a(ax.g()).a(str).a(new a() { // from class: cn.fly.verify.fq.d.1
                @Override // cn.fly.verify.fq.a
                public void a(b bVar) {
                    strArr[0] = bVar.a(new int[0]);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                en.a().a(e);
            }
            return strArr[0];
        }

        public static Object a(String str) {
            return eg.d(str);
        }

        public static String a() {
            return er.a(ax.g()).d().R();
        }
    }

    public static c a(Context context) {
        return new c(context);
    }
}
