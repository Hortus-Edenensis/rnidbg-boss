package com.baidu.location.b;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.services.core.AMapException;
import com.baidu.location.Jni;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lantern.auth.server.WkParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c extends com.baidu.location.e.f {
    private static c eu;
    public int A;
    public float B;
    public float C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public int T;
    public boolean U;
    public boolean V;
    public int W;
    public float X;
    public float Y;
    public float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3404a;
    public int aA;
    public float aB;
    public int aC;
    public int aD;
    public int aE;
    public int aF;
    public int aG;
    public int aH;
    public int aI;
    public int aJ;
    public float aK;
    public int aL;
    public int aM;
    public int aN;
    public int aO;
    public int aP;
    public int aQ;
    public int aR;
    public int aS;
    public int aT;
    public int aU;
    public int aV;
    public int aW;
    public int aX;
    public int aY;
    public float aZ;
    public float aa;
    public float ab;
    public float ac;
    public float ad;
    public int ae;
    public int af;
    public int ag;
    public int ah;
    public float ai;
    public float aj;
    public float ak;
    public float al;
    public float am;
    public float an;
    public float ao;
    public float ap;
    public float aq;
    public boolean ar;
    public int as;
    public int at;
    public int au;
    public int av;
    public int aw;
    public int ax;
    public int ay;
    public int az;
    public boolean b;
    public boolean bA;
    public int bB;
    public String bC;
    public boolean bD;
    public boolean bE;
    public boolean bF;
    public boolean bG;
    public int bH;
    public String bI;
    public double bJ;
    public boolean bK;
    public int bL;
    public double bM;
    public boolean bN;
    public int bO;
    public int bP;
    public int bQ;
    public int bR;
    public int bS;
    public double bT;
    public double bU;
    public int bV;
    public int bW;
    public int bX;
    public String bY;
    public int bZ;
    public float ba;
    public float bb;
    public int bc;
    public float bd;
    public float be;
    public float[] bf;
    public float[] bg;
    public float[] bh;
    public float[] bi;
    public float[] bj;
    public float[] bk;
    public int bl;
    public int bm;
    public boolean bn;
    public int bo;
    public float bp;
    public int bq;
    public float br;
    public float bs;
    public float bt;
    public boolean bu;
    public int bv;
    public int bw;
    public float bx;
    public long by;
    public boolean bz;
    public boolean c;
    public int cA;
    public int cB;
    public int cC;
    public int cD;
    public int cE;
    public int cF;
    public int cG;
    public int cH;
    public int cI;
    public double cJ;
    public int cK;
    public long cL;
    public int cM;
    public int cN;
    public float cO;
    public float cP;
    public int cQ;
    public int cR;
    public int cS;
    public int cT;
    public int cU;
    public int cV;
    public int cW;
    public int cX;
    public int cY;
    public String cZ;
    public String ca;
    public int cb;
    public int cc;
    public int cd;
    public String ce;
    public int cf;
    public int cg;
    public int ch;
    public int ci;
    public int cj;
    public int ck;
    public String cl;
    public String cm;

    /* JADX INFO: renamed from: cn, reason: collision with root package name */
    public String f3405cn;
    public String co;
    public int cp;
    public int cq;
    public int cr;
    public int cs;
    public int ct;
    public int cu;
    public int cv;
    public int cw;
    public String cx;
    public int cy;
    public int cz;
    public boolean d;
    public String dA;
    public int dB;
    public int dC;
    public int dD;
    public int dE;
    public int dF;
    public int dG;
    public int dH;
    public int dI;
    public int dJ;
    public int dK;
    public int dL;
    public int dM;
    public int dN;
    public int dO;
    public int dP;
    public int dQ;
    public int dR;
    public int dS;
    public int dT;
    public int dU;
    public int dV;
    public int dW;
    public int dX;
    public int dY;
    public int dZ;
    public int da;
    public int db;
    public int dc;
    public int dd;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    public int f3406de;
    public int df;
    public int dg;
    public int dh;
    public int di;
    public int dj;
    public int dk;
    public int dl;
    public int dm;
    public int dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public int f0do;
    public int dp;
    public int dq;
    public int dr;
    public int ds;
    public int dt;
    public int du;
    public int dv;
    public int dw;
    public int dx;
    public int dy;
    public int dz;
    public boolean e;
    private ArrayList<ArrayList<Float>> eA;
    private ArrayList<ArrayList<Double>> eB;
    public int ea;
    public int eb;
    public long ec;
    public int ed;
    public int ee;
    public int ef;
    private long ev;
    private Handler ew;
    private String ex;
    private double ey;
    private double ez;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int[] z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f3409a = new c();
    }

    private c() {
        this.f3404a = false;
        this.ev = 0L;
        this.ew = null;
        this.ex = null;
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        this.j = 10;
        this.k = 600;
        this.l = 1000;
        this.m = 400;
        this.n = 400;
        this.o = 200;
        this.p = 400;
        this.q = 1;
        this.r = 2;
        this.s = 10;
        this.t = 30;
        this.u = 25;
        this.v = 50;
        this.w = 40;
        this.x = 200;
        this.y = 0;
        this.z = null;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0.1f;
        this.D = 15;
        this.E = 1000;
        this.F = 100;
        this.G = 40;
        this.H = 30;
        this.I = 20;
        this.J = 50;
        this.K = 60;
        this.L = 200;
        this.M = 0;
        this.N = 500;
        this.O = true;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = true;
        this.T = 300;
        this.U = true;
        this.V = true;
        this.W = -1;
        this.ey = 0.0d;
        this.ez = 0.0d;
        this.X = 30.0f;
        this.Y = 100.0f;
        this.Z = 1000.0f;
        this.aa = 30.0f;
        this.ab = 100.0f;
        this.ac = 1000.0f;
        this.ad = 0.0f;
        this.ae = 30;
        this.af = 200;
        this.ag = 30;
        this.ah = 30;
        this.ai = 0.8f;
        this.aj = 500.0f;
        this.ak = 100.0f;
        this.al = 1000.0f;
        this.am = 500.0f;
        this.an = 1000.0f;
        this.ao = 500.0f;
        this.ap = 1000.0f;
        this.aq = 500.0f;
        this.ar = false;
        this.as = 1;
        this.at = 1;
        this.au = 3;
        this.av = 300;
        this.aw = 1000;
        this.ax = 1;
        this.ay = 30000;
        this.az = 0;
        this.aA = 0;
        this.aB = 1.0f;
        this.aC = 0;
        this.aD = 0;
        this.aE = 0;
        this.aF = 0;
        this.aG = 0;
        this.aH = 0;
        this.aI = 30;
        this.aJ = 30;
        this.aK = 1.0f;
        this.aL = 30;
        this.aM = 1;
        this.aN = 1;
        this.aO = 1;
        this.aP = 120;
        this.aQ = 0;
        this.aR = 0;
        this.aS = 0;
        this.aT = 0;
        this.aU = 0;
        this.aV = 0;
        this.aW = 0;
        this.aX = 1;
        this.aY = 3;
        this.aZ = 0.4f;
        this.ba = 0.01f;
        this.bb = 0.4f;
        this.bc = 5;
        this.bd = 0.0f;
        this.be = 0.0f;
        this.bf = new float[]{0.0f};
        this.bg = new float[]{0.0f};
        this.bh = new float[]{0.0f};
        this.bi = new float[]{0.0f};
        this.bj = new float[]{0.0f};
        this.bk = new float[]{0.0f};
        this.bl = 0;
        this.bm = 1;
        this.bn = true;
        this.bo = 1;
        this.bp = 4.0f;
        this.bq = 300;
        this.br = 0.9f;
        this.bs = 1000.0f;
        this.bt = 4.0f;
        this.bu = true;
        this.bv = 1;
        this.bw = 0;
        this.bx = 0.0f;
        this.by = 72L;
        this.eA = null;
        this.eB = null;
        this.bz = false;
        this.bA = false;
        this.bB = 3;
        this.bC = "";
        this.bD = false;
        this.bE = false;
        this.bF = false;
        this.bG = false;
        this.bH = -1;
        this.bI = "NULL";
        this.bJ = 1.0d;
        this.bK = false;
        this.bL = 0;
        this.bM = 1.0d;
        this.bN = false;
        this.bO = 0;
        this.bP = 29;
        this.bQ = 0;
        this.bR = -1;
        this.bS = 1;
        this.bT = 2005.0d;
        this.bU = 2021.0d;
        this.bV = 0;
        this.bW = 0;
        this.bX = 0;
        this.bY = "";
        this.bZ = 0;
        this.ca = "";
        this.cb = 0;
        this.cc = 10;
        this.cd = 4000;
        this.ce = "1,1,300,4,30,10,5,10";
        this.cf = 1;
        this.cg = 1;
        this.ch = 1;
        this.ci = 1;
        this.cj = 1;
        this.ck = 1;
        this.cl = "";
        this.cm = "";
        this.f3405cn = "";
        this.co = "";
        this.cp = 1;
        this.cq = 1;
        this.cr = 1;
        this.cs = 5;
        this.ct = 5;
        this.cu = 0;
        this.cv = 0;
        this.cw = 300;
        this.cx = "25,10,4";
        this.cy = 1;
        this.cz = 1;
        this.cA = 100;
        this.cB = 25;
        this.cC = 10;
        this.cD = 4;
        this.cE = 15;
        this.cF = 2;
        this.cG = 1;
        this.cH = 0;
        this.cI = 0;
        this.cJ = 3.3d;
        this.cK = 1;
        this.cL = 30000L;
        this.cM = 0;
        this.cN = 1;
        this.cO = 0.8f;
        this.cP = 0.2f;
        this.cQ = 0;
        this.cR = 0;
        this.cS = 0;
        this.cT = 1;
        this.cU = 1;
        this.cV = 0;
        this.cW = 1;
        this.cX = 500;
        this.cY = 15;
        this.cZ = null;
        this.da = 1;
        this.db = 0;
        this.dc = 0;
        this.dd = 2000;
        this.f3406de = 1;
        this.df = 0;
        this.dg = -1;
        this.dh = 1;
        this.di = 1;
        this.dj = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.dk = 1800000;
        this.dl = 1;
        this.dm = 30;
        this.dn = 64;
        this.f0do = 1;
        this.dp = 0;
        this.dq = 60000;
        this.dr = 1;
        this.ds = 0;
        this.dt = 0;
        this.du = 1;
        this.dv = 200;
        this.dw = 5;
        this.dx = 5;
        this.dy = 1;
        this.dz = 1;
        this.dA = "10|3|10|20|20";
        this.dB = 2000;
        this.dC = 2000;
        this.dD = 5000;
        this.dE = 200;
        this.dF = 0;
        this.dG = 1;
        this.dH = 1;
        this.dI = 0;
        this.dJ = 10;
        this.dK = 50;
        this.dL = 1;
        this.dM = 1;
        this.dN = 1200;
        this.dO = 1200;
        this.dP = 1200;
        this.dQ = 200;
        this.dR = 80;
        this.dS = 1000;
        this.dT = 100;
        this.dU = 20;
        this.dV = 0;
        this.dW = 1;
        this.dX = 60;
        this.dY = 28;
        this.dZ = 1;
        this.ea = 0;
        this.eb = 1;
        this.ec = 86400000L;
        this.ed = 1;
        this.ee = 30;
        this.ef = 30;
        this.ev = s.a().a("vdrtt", 0L);
        this.ex = s.a().a("mapcity", (String) null);
    }

    public static c b() {
        return a.f3409a;
    }

    private void d() {
        String[] strArrSplit = "1|0|300|80|2|300|80|2|100|40|30|3|8|4050|5|5|0.1|1|1|0|0.325|0.15|3|0.5|1|6|15|10|0.05|10|10|1|5|10|10|30|5|5.5|1|0|1|40|0.5|120|180|20|200|300|600|2|10|2|4|1.02|2|0|20|10|60|2|100|2|10|1|20|0|0.2|0|0|0.5|0|1|1000|10|1|40|5|10|5|0.8|1|5.0|50|6.0|2.0|4.0|1|1|0|0|1|0.5|1|0.0|1|200|100|1|8|5|25|20|1|70.0|110.0|300|1|15|1.0".split("\\|");
        this.bf = new float[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.bf[i] = Float.parseFloat(strArrSplit[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void e() {
        String[] strArrSplit = "1|0.05|60|45|2|300|80|2|100|40|30|3|8|4050|5|5|0.1|1|1|0|0.325|0|0|0.5|1|6|15|10|0.05|10|10|1|5|10|10|30|5|5.5|1|0|1|40|0.5|120|180|20|200|300|600|2|10|2|4|1.02|0|0|20|10|60|2|100|2|10|1|20|1|0.2|0|0|0.5|0|1|1000|10|1|40|5|10|5|0.8|1|5|50|6|2|4|1|1|0|0|1|0.5|1|0|1|200|100|1".split("\\|");
        this.bg = new float[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.bg[i] = Float.parseFloat(strArrSplit[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void f() {
        String[] strArrSplit = "1|0.05|200|80|1|300|80|2|100|40|30|3|8|4050|5|30|0.1|1|1|0|0.325|0|0|0.5|1|5|15|10|0.05|10|10|1|5|10|10|30|5|5.5|1|0|1|40|0.5|120|180|20|200|300|600|2|10|2|4|1.02|0|0|20|10|60|2|100|2|10|1|20|0".split("\\|");
        this.bh = new float[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.bh[i] = Float.parseFloat(strArrSplit[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void g() {
        String[] strArrSplit = "1|0.05|30|25|1|15|80|2|100|40|30|3|8|4050|10|7|0.1|1|1|0.1|0.325|0|0|0.5|1|6|15|10|0.05|10|10|1|5|10|10|30|5|5.5|1|0|1|40|0.5|120|180|20|200|300|600|2|10|2|4|1.02|0|0|20|10|60|2|100|2|10|1|20|0|1|1|0|1".split("\\|");
        this.bi = new float[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.bi[i] = Float.parseFloat(strArrSplit[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void h() {
        String[] strArrSplit = "1|10000|90|5|3|3|85|87|5|10|15|8|5|5".split("\\|");
        this.bj = new float[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.bj[i] = Float.parseFloat(strArrSplit[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void i() {
        String[] strArrSplit = "1|0.05|60|45|2|300|80|2|100|40|30|3|8|4050|5|5|0.1|1|1|0|0.325|0|0|0.5|1|6|15|10|0.05|10|10|1|5|10|10|30|5|5.5|1|0|1|40|0.5|120|180|20|200|300|600|2|10|2|4|1.02|0|0|20|10|60|2|100|2|10|1|20|1|0.2|0|0|0.5|0|1|1000|10|1|40|5|10|5|0.8|1|5|50|6|2|4|1|1|0|0|1|0.5|1|0|1|200|100|1".split("\\|");
        this.bk = new float[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.bk[i] = Float.parseFloat(strArrSplit[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Handler handler = this.ew;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.baidu.location.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.location.e.h.i(com.baidu.location.f.getServiceContext())) {
                    c.this.c();
                } else {
                    c.this.j();
                }
            }
        }, 3000L);
    }

    @Override // com.baidu.location.e.f
    public void a() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.653f);
        stringBuffer.append("&stp=1");
        if (com.baidu.location.e.b.a().c == null) {
            stringBuffer.append("&im=");
            str = com.baidu.location.e.b.a().f3513a;
        } else {
            stringBuffer.append("&cu=");
            str = com.baidu.location.e.b.a().c;
        }
        stringBuffer.append(str);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&abtest=1");
        stringBuffer.append("&fixa9=2");
        stringBuffer.append("&sv=");
        String strSubstring = Build.VERSION.RELEASE;
        if (strSubstring != null && strSubstring.length() > 10) {
            strSubstring = strSubstring.substring(0, 10);
        }
        stringBuffer.append(strSubstring);
        stringBuffer.append("&os=");
        int i = Build.VERSION.SDK_INT;
        stringBuffer.append(i);
        stringBuffer.append("&pack=");
        stringBuffer.append(com.baidu.location.e.b.e);
        stringBuffer.append("&city=");
        stringBuffer.append(this.ex);
        stringBuffer.append("&resid=");
        stringBuffer.append(BaseWrapper.ENTER_ID_MARKET);
        stringBuffer.append("&locmode=");
        stringBuffer.append(com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext()));
        stringBuffer.append("&locper=");
        stringBuffer.append(com.baidu.location.e.h.a(com.baidu.location.f.getServiceContext(), com.kuaishou.weapon.p0.g.g));
        if (this.ez > 0.10000000149011612d && this.ey > 0.10000000149011612d) {
            stringBuffer.append("&x=");
            stringBuffer.append(this.ez);
            stringBuffer.append("&y=");
            stringBuffer.append(this.ey);
        }
        stringBuffer.append("&selftest=");
        stringBuffer.append(0);
        if (i > 25) {
            stringBuffer.append("&rpmmc=");
            stringBuffer.append("0");
        }
        stringBuffer.append("&cnloc=");
        stringBuffer.append(l.a().b());
        if (this.el == null) {
            this.el = new HashMap();
        }
        Map<String, Object> map = this.el;
        if (map != null) {
            map.clear();
            this.el.put(com.igexin.push.g.o.f, Jni.en1(stringBuffer.toString()));
            this.el.put("qt", "vdr");
        }
    }

    public void c() {
        if (this.ew == null) {
            this.ew = new Handler();
        }
        boolean z = true;
        boolean z2 = System.currentTimeMillis() - this.ev > 86400000;
        String strA = s.a().a("vdrconfig_gz", "");
        if (strA != null && !"".equals(strA)) {
            z = z2;
        }
        if (z) {
            this.ev = System.currentTimeMillis();
            s.a().b("vdrtt", this.ev);
            Handler handler = this.ew;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.baidu.location.b.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ExecutorService executorServiceC = x.a().c();
                        if (executorServiceC != null) {
                            c.this.a(executorServiceC, com.baidu.location.e.d.f);
                        } else {
                            c.this.b(com.baidu.location.e.d.f);
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void a(double d, double d2) {
        this.ey = d;
        this.ez = d2;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0ab3 A[Catch: Exception -> 0x150b, TryCatch #13 {Exception -> 0x150b, blocks: (B:12:0x0052, B:14:0x005d, B:16:0x0063, B:17:0x0066, B:18:0x0069, B:22:0x0074, B:24:0x0082, B:26:0x008e, B:28:0x0094, B:30:0x009c, B:31:0x00ae, B:33:0x00b6, B:34:0x00c0, B:36:0x00c8, B:37:0x00d1, B:39:0x00d9, B:40:0x00e2, B:42:0x00ea, B:43:0x00f3, B:45:0x00fb, B:46:0x0105, B:48:0x010d, B:49:0x0117, B:51:0x011f, B:52:0x0128, B:54:0x0130, B:55:0x0139, B:57:0x0141, B:58:0x014a, B:60:0x0152, B:61:0x015c, B:63:0x0165, B:64:0x016d, B:66:0x0175, B:67:0x017e, B:69:0x0186, B:70:0x018f, B:72:0x0197, B:74:0x01a0, B:75:0x01a4, B:76:0x01a9, B:78:0x01b1, B:211:0x042e, B:213:0x0436, B:214:0x043b, B:216:0x0443, B:217:0x0448, B:219:0x0450, B:220:0x0455, B:222:0x045d, B:223:0x0465, B:225:0x046d, B:226:0x0475, B:228:0x047d, B:229:0x0485, B:231:0x048d, B:232:0x0495, B:234:0x049d, B:236:0x04a5, B:237:0x04a9, B:238:0x04ac, B:240:0x04b4, B:242:0x04bc, B:243:0x04c0, B:244:0x04c3, B:246:0x04cb, B:248:0x04d3, B:249:0x04d7, B:250:0x04da, B:252:0x04e2, B:254:0x04ea, B:255:0x04ee, B:256:0x04f1, B:258:0x04f9, B:260:0x0501, B:261:0x0505, B:262:0x0508, B:264:0x0510, B:265:0x051b, B:267:0x0523, B:269:0x052b, B:270:0x052f, B:271:0x0532, B:273:0x053a, B:275:0x0542, B:276:0x0546, B:277:0x0549, B:279:0x0551, B:281:0x0559, B:282:0x055d, B:283:0x0560, B:285:0x0568, B:286:0x0570, B:288:0x0578, B:289:0x0580, B:291:0x0588, B:292:0x0591, B:294:0x0599, B:295:0x05a1, B:297:0x05a9, B:298:0x05b2, B:300:0x05ba, B:301:0x05c3, B:303:0x05cb, B:304:0x05d4, B:306:0x05dc, B:308:0x05e4, B:309:0x05e8, B:310:0x05eb, B:312:0x05f3, B:314:0x05fb, B:315:0x05ff, B:316:0x0602, B:318:0x060a, B:320:0x0612, B:321:0x0616, B:322:0x0619, B:324:0x0621, B:326:0x0629, B:327:0x062d, B:328:0x0630, B:330:0x0638, B:332:0x0640, B:333:0x0644, B:334:0x0647, B:336:0x064f, B:338:0x0657, B:339:0x065b, B:340:0x065e, B:342:0x0666, B:344:0x066e, B:345:0x0672, B:346:0x0675, B:348:0x067d, B:349:0x0685, B:351:0x068d, B:352:0x0695, B:354:0x069d, B:355:0x06a5, B:357:0x06ad, B:358:0x06b5, B:360:0x06bd, B:361:0x06c5, B:363:0x06cd, B:364:0x06d6, B:366:0x06de, B:367:0x06e7, B:369:0x06ef, B:370:0x06f8, B:372:0x0700, B:373:0x0709, B:375:0x0711, B:376:0x071a, B:378:0x0722, B:379:0x072b, B:381:0x0733, B:382:0x073c, B:384:0x0744, B:385:0x074d, B:387:0x0755, B:388:0x075e, B:390:0x0764, B:391:0x076a, B:393:0x0772, B:394:0x077b, B:396:0x0783, B:397:0x078c, B:399:0x0792, B:400:0x0798, B:402:0x079e, B:403:0x07a4, B:405:0x07ac, B:406:0x07b4, B:408:0x07ba, B:409:0x07c0, B:411:0x07c8, B:412:0x07d0, B:414:0x07d8, B:415:0x07e0, B:417:0x07e8, B:418:0x07f0, B:420:0x07f6, B:421:0x07fc, B:423:0x0802, B:424:0x0808, B:426:0x080e, B:427:0x0814, B:429:0x081c, B:430:0x0822, B:432:0x082a, B:433:0x0830, B:435:0x0838, B:436:0x083e, B:438:0x0846, B:439:0x084e, B:441:0x0856, B:442:0x085e, B:444:0x0866, B:445:0x086e, B:447:0x0876, B:448:0x087e, B:450:0x0886, B:451:0x088e, B:453:0x0896, B:454:0x089e, B:456:0x08a6, B:457:0x08ae, B:459:0x08b6, B:460:0x08be, B:462:0x08c6, B:463:0x08cf, B:465:0x08d7, B:466:0x08e0, B:468:0x08e8, B:469:0x08f0, B:471:0x08f8, B:472:0x0900, B:474:0x0908, B:475:0x0910, B:477:0x0918, B:478:0x0920, B:480:0x0928, B:481:0x0931, B:483:0x0939, B:484:0x0942, B:486:0x094a, B:487:0x0953, B:489:0x095b, B:490:0x0963, B:492:0x096b, B:493:0x0973, B:495:0x097b, B:496:0x0983, B:498:0x098b, B:499:0x0993, B:502:0x09a4, B:505:0x09b5, B:508:0x09c6, B:511:0x09d7, B:513:0x09df, B:515:0x09ed, B:516:0x09ef, B:519:0x0a00, B:522:0x0a11, B:524:0x0a19, B:526:0x0a25, B:528:0x0a2d, B:529:0x0a3f, B:531:0x0a42, B:536:0x0a52, B:541:0x0a79, B:543:0x0a81, B:545:0x0a8d, B:547:0x0a93, B:548:0x0a9d, B:550:0x0aa0, B:555:0x0ab0, B:557:0x0ab6, B:559:0x0abe, B:561:0x0aca, B:563:0x0ad0, B:564:0x0ada, B:566:0x0add, B:571:0x0aed, B:573:0x0af3, B:575:0x0afb, B:577:0x0b07, B:579:0x0b0d, B:580:0x0b17, B:582:0x0b1a, B:587:0x0b2a, B:589:0x0b30, B:591:0x0b38, B:593:0x0b44, B:595:0x0b4a, B:596:0x0b54, B:598:0x0b57, B:603:0x0b67, B:605:0x0b6d, B:607:0x0b75, B:609:0x0b81, B:611:0x0b87, B:612:0x0b91, B:614:0x0b94, B:619:0x0ba4, B:621:0x0baa, B:623:0x0bb2, B:625:0x0bba, B:627:0x0bc0, B:629:0x0bce, B:633:0x0bf1, B:635:0x0bf9, B:637:0x0c05, B:638:0x0c0b, B:640:0x0c11, B:641:0x0c17, B:643:0x0c1d, B:644:0x0c23, B:646:0x0c29, B:647:0x0c2f, B:649:0x0c35, B:650:0x0c3b, B:652:0x0c41, B:653:0x0c47, B:655:0x0c4d, B:656:0x0c53, B:658:0x0c5b, B:659:0x0c61, B:661:0x0c69, B:662:0x0c6f, B:664:0x0c77, B:665:0x0c7d, B:667:0x0c85, B:669:0x0c93, B:670:0x0c9c, B:672:0x0ca4, B:673:0x0cad, B:675:0x0cb5, B:676:0x0cbe, B:678:0x0cc6, B:679:0x0ccf, B:681:0x0cd7, B:682:0x0ce0, B:684:0x0ce8, B:685:0x0cf1, B:687:0x0cf9, B:688:0x0d02, B:690:0x0d0a, B:691:0x0d12, B:693:0x0d1a, B:694:0x0d22, B:708:0x0d88, B:730:0x0e14, B:732:0x0e1c, B:733:0x0e24, B:735:0x0e2c, B:736:0x0e34, B:738:0x0e3c, B:739:0x0e44, B:741:0x0e4c, B:742:0x0e54, B:744:0x0e5c, B:745:0x0e64, B:747:0x0e6c, B:748:0x0e74, B:750:0x0e7c, B:751:0x0e84, B:753:0x0e8c, B:754:0x0e94, B:756:0x0e9c, B:757:0x0ea4, B:759:0x0eac, B:760:0x0eb5, B:762:0x0ebd, B:763:0x0ec5, B:765:0x0ecd, B:766:0x0ed5, B:768:0x0edd, B:769:0x0ee5, B:771:0x0eed, B:772:0x0ef5, B:774:0x0efd, B:775:0x0f05, B:777:0x0f0d, B:778:0x0f15, B:780:0x0f1d, B:781:0x0f25, B:783:0x0f2d, B:784:0x0f35, B:786:0x0f3d, B:787:0x0f46, B:789:0x0f4e, B:790:0x0f56, B:792:0x0f5e, B:793:0x0f66, B:795:0x0f6e, B:796:0x0f77, B:798:0x0f7f, B:799:0x0f89, B:801:0x0f91, B:802:0x0f9a, B:804:0x0fa2, B:805:0x0fac, B:807:0x0fb4, B:808:0x0fbe, B:810:0x0fc6, B:811:0x0fce, B:813:0x0fd6, B:814:0x0fde, B:816:0x0fe6, B:817:0x0fee, B:819:0x0ff6, B:820:0x0ffe, B:822:0x1006, B:823:0x100f, B:825:0x1017, B:826:0x1021, B:828:0x1029, B:829:0x1032, B:831:0x103a, B:832:0x1043, B:834:0x104b, B:835:0x1054, B:837:0x105c, B:843:0x1098, B:845:0x10a0, B:846:0x10aa, B:848:0x10b2, B:849:0x10ba, B:851:0x10c2, B:852:0x10cb, B:854:0x10d3, B:855:0x10dd, B:857:0x10e5, B:858:0x10ee, B:860:0x10f6, B:861:0x10fe, B:863:0x1106, B:864:0x110f, B:866:0x1117, B:867:0x111f, B:869:0x1127, B:870:0x1131, B:872:0x1139, B:873:0x1142, B:875:0x114a, B:876:0x1153, B:878:0x115b, B:879:0x1169, B:881:0x1171, B:882:0x117f, B:884:0x1187, B:885:0x1190, B:887:0x1198, B:888:0x11a0, B:890:0x11a8, B:891:0x11b0, B:893:0x11b8, B:894:0x11c0, B:896:0x11c8, B:897:0x11d0, B:899:0x11d8, B:900:0x11e1, B:902:0x11e9, B:903:0x11f2, B:905:0x11fc, B:906:0x1204, B:908:0x120c, B:909:0x1216, B:911:0x121e, B:912:0x1227, B:914:0x122f, B:915:0x1238, B:917:0x1240, B:918:0x124b, B:920:0x1253, B:921:0x125b, B:923:0x1263, B:924:0x126b, B:926:0x1273, B:927:0x127b, B:929:0x1283, B:930:0x128b, B:932:0x1293, B:933:0x129b, B:935:0x12a3, B:937:0x12af, B:939:0x12b7, B:940:0x12c9, B:942:0x12d1, B:943:0x12d9, B:945:0x12e1, B:946:0x12e9, B:948:0x12f1, B:949:0x12f9, B:951:0x1301, B:952:0x1309, B:954:0x1311, B:955:0x1319, B:957:0x1321, B:958:0x1329, B:960:0x1331, B:961:0x1339, B:963:0x1341, B:964:0x1349, B:966:0x1351, B:967:0x135a, B:969:0x1362, B:970:0x136a, B:972:0x1372, B:973:0x137a, B:975:0x1382, B:976:0x138a, B:978:0x1392, B:979:0x13a0, B:981:0x13a8, B:982:0x13b1, B:984:0x13b9, B:985:0x13c3, B:987:0x13cb, B:988:0x13d5, B:990:0x13dd, B:991:0x13e5, B:993:0x13ed, B:994:0x13f5, B:996:0x13fd, B:997:0x1405, B:999:0x140d, B:1000:0x1415, B:1002:0x141d, B:1003:0x1425, B:1005:0x142d, B:1006:0x1435, B:1008:0x143d, B:1009:0x1445, B:1011:0x144d, B:1012:0x1455, B:1014:0x145d, B:1015:0x1465, B:1017:0x146d, B:1018:0x1475, B:1020:0x147d, B:1021:0x1485, B:1023:0x148d, B:1024:0x1495, B:1026:0x149d, B:1027:0x14a5, B:1029:0x14ad, B:1030:0x14b5, B:1032:0x14bd, B:1033:0x14c6, B:1035:0x14ce, B:1036:0x14d9, B:1038:0x14e1, B:1039:0x14ea, B:1041:0x14f2, B:1042:0x14fa, B:1044:0x1502, B:729:0x0e11, B:707:0x0d85, B:618:0x0ba1, B:620:0x0ba7, B:602:0x0b64, B:604:0x0b6a, B:586:0x0b27, B:588:0x0b2d, B:570:0x0aea, B:572:0x0af0, B:554:0x0aad, B:556:0x0ab3, B:535:0x0a4f, B:539:0x0a68, B:540:0x0a6c, B:210:0x042b, B:710:0x0d90, B:712:0x0d9d, B:714:0x0da3, B:716:0x0dab, B:718:0x0db3, B:720:0x0dbb, B:722:0x0dc3, B:724:0x0e00, B:725:0x0e07, B:696:0x0d2a, B:698:0x0d37, B:700:0x0d43, B:702:0x0d74, B:703:0x0d7b), top: B:1085:0x0052, inners: #5, #8, #9, #10, #12, #16, #23, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0af0 A[Catch: Exception -> 0x150b, TryCatch #13 {Exception -> 0x150b, blocks: (B:12:0x0052, B:14:0x005d, B:16:0x0063, B:17:0x0066, B:18:0x0069, B:22:0x0074, B:24:0x0082, B:26:0x008e, B:28:0x0094, B:30:0x009c, B:31:0x00ae, B:33:0x00b6, B:34:0x00c0, B:36:0x00c8, B:37:0x00d1, B:39:0x00d9, B:40:0x00e2, B:42:0x00ea, B:43:0x00f3, B:45:0x00fb, B:46:0x0105, B:48:0x010d, B:49:0x0117, B:51:0x011f, B:52:0x0128, B:54:0x0130, B:55:0x0139, B:57:0x0141, B:58:0x014a, B:60:0x0152, B:61:0x015c, B:63:0x0165, B:64:0x016d, B:66:0x0175, B:67:0x017e, B:69:0x0186, B:70:0x018f, B:72:0x0197, B:74:0x01a0, B:75:0x01a4, B:76:0x01a9, B:78:0x01b1, B:211:0x042e, B:213:0x0436, B:214:0x043b, B:216:0x0443, B:217:0x0448, B:219:0x0450, B:220:0x0455, B:222:0x045d, B:223:0x0465, B:225:0x046d, B:226:0x0475, B:228:0x047d, B:229:0x0485, B:231:0x048d, B:232:0x0495, B:234:0x049d, B:236:0x04a5, B:237:0x04a9, B:238:0x04ac, B:240:0x04b4, B:242:0x04bc, B:243:0x04c0, B:244:0x04c3, B:246:0x04cb, B:248:0x04d3, B:249:0x04d7, B:250:0x04da, B:252:0x04e2, B:254:0x04ea, B:255:0x04ee, B:256:0x04f1, B:258:0x04f9, B:260:0x0501, B:261:0x0505, B:262:0x0508, B:264:0x0510, B:265:0x051b, B:267:0x0523, B:269:0x052b, B:270:0x052f, B:271:0x0532, B:273:0x053a, B:275:0x0542, B:276:0x0546, B:277:0x0549, B:279:0x0551, B:281:0x0559, B:282:0x055d, B:283:0x0560, B:285:0x0568, B:286:0x0570, B:288:0x0578, B:289:0x0580, B:291:0x0588, B:292:0x0591, B:294:0x0599, B:295:0x05a1, B:297:0x05a9, B:298:0x05b2, B:300:0x05ba, B:301:0x05c3, B:303:0x05cb, B:304:0x05d4, B:306:0x05dc, B:308:0x05e4, B:309:0x05e8, B:310:0x05eb, B:312:0x05f3, B:314:0x05fb, B:315:0x05ff, B:316:0x0602, B:318:0x060a, B:320:0x0612, B:321:0x0616, B:322:0x0619, B:324:0x0621, B:326:0x0629, B:327:0x062d, B:328:0x0630, B:330:0x0638, B:332:0x0640, B:333:0x0644, B:334:0x0647, B:336:0x064f, B:338:0x0657, B:339:0x065b, B:340:0x065e, B:342:0x0666, B:344:0x066e, B:345:0x0672, B:346:0x0675, B:348:0x067d, B:349:0x0685, B:351:0x068d, B:352:0x0695, B:354:0x069d, B:355:0x06a5, B:357:0x06ad, B:358:0x06b5, B:360:0x06bd, B:361:0x06c5, B:363:0x06cd, B:364:0x06d6, B:366:0x06de, B:367:0x06e7, B:369:0x06ef, B:370:0x06f8, B:372:0x0700, B:373:0x0709, B:375:0x0711, B:376:0x071a, B:378:0x0722, B:379:0x072b, B:381:0x0733, B:382:0x073c, B:384:0x0744, B:385:0x074d, B:387:0x0755, B:388:0x075e, B:390:0x0764, B:391:0x076a, B:393:0x0772, B:394:0x077b, B:396:0x0783, B:397:0x078c, B:399:0x0792, B:400:0x0798, B:402:0x079e, B:403:0x07a4, B:405:0x07ac, B:406:0x07b4, B:408:0x07ba, B:409:0x07c0, B:411:0x07c8, B:412:0x07d0, B:414:0x07d8, B:415:0x07e0, B:417:0x07e8, B:418:0x07f0, B:420:0x07f6, B:421:0x07fc, B:423:0x0802, B:424:0x0808, B:426:0x080e, B:427:0x0814, B:429:0x081c, B:430:0x0822, B:432:0x082a, B:433:0x0830, B:435:0x0838, B:436:0x083e, B:438:0x0846, B:439:0x084e, B:441:0x0856, B:442:0x085e, B:444:0x0866, B:445:0x086e, B:447:0x0876, B:448:0x087e, B:450:0x0886, B:451:0x088e, B:453:0x0896, B:454:0x089e, B:456:0x08a6, B:457:0x08ae, B:459:0x08b6, B:460:0x08be, B:462:0x08c6, B:463:0x08cf, B:465:0x08d7, B:466:0x08e0, B:468:0x08e8, B:469:0x08f0, B:471:0x08f8, B:472:0x0900, B:474:0x0908, B:475:0x0910, B:477:0x0918, B:478:0x0920, B:480:0x0928, B:481:0x0931, B:483:0x0939, B:484:0x0942, B:486:0x094a, B:487:0x0953, B:489:0x095b, B:490:0x0963, B:492:0x096b, B:493:0x0973, B:495:0x097b, B:496:0x0983, B:498:0x098b, B:499:0x0993, B:502:0x09a4, B:505:0x09b5, B:508:0x09c6, B:511:0x09d7, B:513:0x09df, B:515:0x09ed, B:516:0x09ef, B:519:0x0a00, B:522:0x0a11, B:524:0x0a19, B:526:0x0a25, B:528:0x0a2d, B:529:0x0a3f, B:531:0x0a42, B:536:0x0a52, B:541:0x0a79, B:543:0x0a81, B:545:0x0a8d, B:547:0x0a93, B:548:0x0a9d, B:550:0x0aa0, B:555:0x0ab0, B:557:0x0ab6, B:559:0x0abe, B:561:0x0aca, B:563:0x0ad0, B:564:0x0ada, B:566:0x0add, B:571:0x0aed, B:573:0x0af3, B:575:0x0afb, B:577:0x0b07, B:579:0x0b0d, B:580:0x0b17, B:582:0x0b1a, B:587:0x0b2a, B:589:0x0b30, B:591:0x0b38, B:593:0x0b44, B:595:0x0b4a, B:596:0x0b54, B:598:0x0b57, B:603:0x0b67, B:605:0x0b6d, B:607:0x0b75, B:609:0x0b81, B:611:0x0b87, B:612:0x0b91, B:614:0x0b94, B:619:0x0ba4, B:621:0x0baa, B:623:0x0bb2, B:625:0x0bba, B:627:0x0bc0, B:629:0x0bce, B:633:0x0bf1, B:635:0x0bf9, B:637:0x0c05, B:638:0x0c0b, B:640:0x0c11, B:641:0x0c17, B:643:0x0c1d, B:644:0x0c23, B:646:0x0c29, B:647:0x0c2f, B:649:0x0c35, B:650:0x0c3b, B:652:0x0c41, B:653:0x0c47, B:655:0x0c4d, B:656:0x0c53, B:658:0x0c5b, B:659:0x0c61, B:661:0x0c69, B:662:0x0c6f, B:664:0x0c77, B:665:0x0c7d, B:667:0x0c85, B:669:0x0c93, B:670:0x0c9c, B:672:0x0ca4, B:673:0x0cad, B:675:0x0cb5, B:676:0x0cbe, B:678:0x0cc6, B:679:0x0ccf, B:681:0x0cd7, B:682:0x0ce0, B:684:0x0ce8, B:685:0x0cf1, B:687:0x0cf9, B:688:0x0d02, B:690:0x0d0a, B:691:0x0d12, B:693:0x0d1a, B:694:0x0d22, B:708:0x0d88, B:730:0x0e14, B:732:0x0e1c, B:733:0x0e24, B:735:0x0e2c, B:736:0x0e34, B:738:0x0e3c, B:739:0x0e44, B:741:0x0e4c, B:742:0x0e54, B:744:0x0e5c, B:745:0x0e64, B:747:0x0e6c, B:748:0x0e74, B:750:0x0e7c, B:751:0x0e84, B:753:0x0e8c, B:754:0x0e94, B:756:0x0e9c, B:757:0x0ea4, B:759:0x0eac, B:760:0x0eb5, B:762:0x0ebd, B:763:0x0ec5, B:765:0x0ecd, B:766:0x0ed5, B:768:0x0edd, B:769:0x0ee5, B:771:0x0eed, B:772:0x0ef5, B:774:0x0efd, B:775:0x0f05, B:777:0x0f0d, B:778:0x0f15, B:780:0x0f1d, B:781:0x0f25, B:783:0x0f2d, B:784:0x0f35, B:786:0x0f3d, B:787:0x0f46, B:789:0x0f4e, B:790:0x0f56, B:792:0x0f5e, B:793:0x0f66, B:795:0x0f6e, B:796:0x0f77, B:798:0x0f7f, B:799:0x0f89, B:801:0x0f91, B:802:0x0f9a, B:804:0x0fa2, B:805:0x0fac, B:807:0x0fb4, B:808:0x0fbe, B:810:0x0fc6, B:811:0x0fce, B:813:0x0fd6, B:814:0x0fde, B:816:0x0fe6, B:817:0x0fee, B:819:0x0ff6, B:820:0x0ffe, B:822:0x1006, B:823:0x100f, B:825:0x1017, B:826:0x1021, B:828:0x1029, B:829:0x1032, B:831:0x103a, B:832:0x1043, B:834:0x104b, B:835:0x1054, B:837:0x105c, B:843:0x1098, B:845:0x10a0, B:846:0x10aa, B:848:0x10b2, B:849:0x10ba, B:851:0x10c2, B:852:0x10cb, B:854:0x10d3, B:855:0x10dd, B:857:0x10e5, B:858:0x10ee, B:860:0x10f6, B:861:0x10fe, B:863:0x1106, B:864:0x110f, B:866:0x1117, B:867:0x111f, B:869:0x1127, B:870:0x1131, B:872:0x1139, B:873:0x1142, B:875:0x114a, B:876:0x1153, B:878:0x115b, B:879:0x1169, B:881:0x1171, B:882:0x117f, B:884:0x1187, B:885:0x1190, B:887:0x1198, B:888:0x11a0, B:890:0x11a8, B:891:0x11b0, B:893:0x11b8, B:894:0x11c0, B:896:0x11c8, B:897:0x11d0, B:899:0x11d8, B:900:0x11e1, B:902:0x11e9, B:903:0x11f2, B:905:0x11fc, B:906:0x1204, B:908:0x120c, B:909:0x1216, B:911:0x121e, B:912:0x1227, B:914:0x122f, B:915:0x1238, B:917:0x1240, B:918:0x124b, B:920:0x1253, B:921:0x125b, B:923:0x1263, B:924:0x126b, B:926:0x1273, B:927:0x127b, B:929:0x1283, B:930:0x128b, B:932:0x1293, B:933:0x129b, B:935:0x12a3, B:937:0x12af, B:939:0x12b7, B:940:0x12c9, B:942:0x12d1, B:943:0x12d9, B:945:0x12e1, B:946:0x12e9, B:948:0x12f1, B:949:0x12f9, B:951:0x1301, B:952:0x1309, B:954:0x1311, B:955:0x1319, B:957:0x1321, B:958:0x1329, B:960:0x1331, B:961:0x1339, B:963:0x1341, B:964:0x1349, B:966:0x1351, B:967:0x135a, B:969:0x1362, B:970:0x136a, B:972:0x1372, B:973:0x137a, B:975:0x1382, B:976:0x138a, B:978:0x1392, B:979:0x13a0, B:981:0x13a8, B:982:0x13b1, B:984:0x13b9, B:985:0x13c3, B:987:0x13cb, B:988:0x13d5, B:990:0x13dd, B:991:0x13e5, B:993:0x13ed, B:994:0x13f5, B:996:0x13fd, B:997:0x1405, B:999:0x140d, B:1000:0x1415, B:1002:0x141d, B:1003:0x1425, B:1005:0x142d, B:1006:0x1435, B:1008:0x143d, B:1009:0x1445, B:1011:0x144d, B:1012:0x1455, B:1014:0x145d, B:1015:0x1465, B:1017:0x146d, B:1018:0x1475, B:1020:0x147d, B:1021:0x1485, B:1023:0x148d, B:1024:0x1495, B:1026:0x149d, B:1027:0x14a5, B:1029:0x14ad, B:1030:0x14b5, B:1032:0x14bd, B:1033:0x14c6, B:1035:0x14ce, B:1036:0x14d9, B:1038:0x14e1, B:1039:0x14ea, B:1041:0x14f2, B:1042:0x14fa, B:1044:0x1502, B:729:0x0e11, B:707:0x0d85, B:618:0x0ba1, B:620:0x0ba7, B:602:0x0b64, B:604:0x0b6a, B:586:0x0b27, B:588:0x0b2d, B:570:0x0aea, B:572:0x0af0, B:554:0x0aad, B:556:0x0ab3, B:535:0x0a4f, B:539:0x0a68, B:540:0x0a6c, B:210:0x042b, B:710:0x0d90, B:712:0x0d9d, B:714:0x0da3, B:716:0x0dab, B:718:0x0db3, B:720:0x0dbb, B:722:0x0dc3, B:724:0x0e00, B:725:0x0e07, B:696:0x0d2a, B:698:0x0d37, B:700:0x0d43, B:702:0x0d74, B:703:0x0d7b), top: B:1085:0x0052, inners: #5, #8, #9, #10, #12, #16, #23, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0b2d A[Catch: Exception -> 0x150b, TryCatch #13 {Exception -> 0x150b, blocks: (B:12:0x0052, B:14:0x005d, B:16:0x0063, B:17:0x0066, B:18:0x0069, B:22:0x0074, B:24:0x0082, B:26:0x008e, B:28:0x0094, B:30:0x009c, B:31:0x00ae, B:33:0x00b6, B:34:0x00c0, B:36:0x00c8, B:37:0x00d1, B:39:0x00d9, B:40:0x00e2, B:42:0x00ea, B:43:0x00f3, B:45:0x00fb, B:46:0x0105, B:48:0x010d, B:49:0x0117, B:51:0x011f, B:52:0x0128, B:54:0x0130, B:55:0x0139, B:57:0x0141, B:58:0x014a, B:60:0x0152, B:61:0x015c, B:63:0x0165, B:64:0x016d, B:66:0x0175, B:67:0x017e, B:69:0x0186, B:70:0x018f, B:72:0x0197, B:74:0x01a0, B:75:0x01a4, B:76:0x01a9, B:78:0x01b1, B:211:0x042e, B:213:0x0436, B:214:0x043b, B:216:0x0443, B:217:0x0448, B:219:0x0450, B:220:0x0455, B:222:0x045d, B:223:0x0465, B:225:0x046d, B:226:0x0475, B:228:0x047d, B:229:0x0485, B:231:0x048d, B:232:0x0495, B:234:0x049d, B:236:0x04a5, B:237:0x04a9, B:238:0x04ac, B:240:0x04b4, B:242:0x04bc, B:243:0x04c0, B:244:0x04c3, B:246:0x04cb, B:248:0x04d3, B:249:0x04d7, B:250:0x04da, B:252:0x04e2, B:254:0x04ea, B:255:0x04ee, B:256:0x04f1, B:258:0x04f9, B:260:0x0501, B:261:0x0505, B:262:0x0508, B:264:0x0510, B:265:0x051b, B:267:0x0523, B:269:0x052b, B:270:0x052f, B:271:0x0532, B:273:0x053a, B:275:0x0542, B:276:0x0546, B:277:0x0549, B:279:0x0551, B:281:0x0559, B:282:0x055d, B:283:0x0560, B:285:0x0568, B:286:0x0570, B:288:0x0578, B:289:0x0580, B:291:0x0588, B:292:0x0591, B:294:0x0599, B:295:0x05a1, B:297:0x05a9, B:298:0x05b2, B:300:0x05ba, B:301:0x05c3, B:303:0x05cb, B:304:0x05d4, B:306:0x05dc, B:308:0x05e4, B:309:0x05e8, B:310:0x05eb, B:312:0x05f3, B:314:0x05fb, B:315:0x05ff, B:316:0x0602, B:318:0x060a, B:320:0x0612, B:321:0x0616, B:322:0x0619, B:324:0x0621, B:326:0x0629, B:327:0x062d, B:328:0x0630, B:330:0x0638, B:332:0x0640, B:333:0x0644, B:334:0x0647, B:336:0x064f, B:338:0x0657, B:339:0x065b, B:340:0x065e, B:342:0x0666, B:344:0x066e, B:345:0x0672, B:346:0x0675, B:348:0x067d, B:349:0x0685, B:351:0x068d, B:352:0x0695, B:354:0x069d, B:355:0x06a5, B:357:0x06ad, B:358:0x06b5, B:360:0x06bd, B:361:0x06c5, B:363:0x06cd, B:364:0x06d6, B:366:0x06de, B:367:0x06e7, B:369:0x06ef, B:370:0x06f8, B:372:0x0700, B:373:0x0709, B:375:0x0711, B:376:0x071a, B:378:0x0722, B:379:0x072b, B:381:0x0733, B:382:0x073c, B:384:0x0744, B:385:0x074d, B:387:0x0755, B:388:0x075e, B:390:0x0764, B:391:0x076a, B:393:0x0772, B:394:0x077b, B:396:0x0783, B:397:0x078c, B:399:0x0792, B:400:0x0798, B:402:0x079e, B:403:0x07a4, B:405:0x07ac, B:406:0x07b4, B:408:0x07ba, B:409:0x07c0, B:411:0x07c8, B:412:0x07d0, B:414:0x07d8, B:415:0x07e0, B:417:0x07e8, B:418:0x07f0, B:420:0x07f6, B:421:0x07fc, B:423:0x0802, B:424:0x0808, B:426:0x080e, B:427:0x0814, B:429:0x081c, B:430:0x0822, B:432:0x082a, B:433:0x0830, B:435:0x0838, B:436:0x083e, B:438:0x0846, B:439:0x084e, B:441:0x0856, B:442:0x085e, B:444:0x0866, B:445:0x086e, B:447:0x0876, B:448:0x087e, B:450:0x0886, B:451:0x088e, B:453:0x0896, B:454:0x089e, B:456:0x08a6, B:457:0x08ae, B:459:0x08b6, B:460:0x08be, B:462:0x08c6, B:463:0x08cf, B:465:0x08d7, B:466:0x08e0, B:468:0x08e8, B:469:0x08f0, B:471:0x08f8, B:472:0x0900, B:474:0x0908, B:475:0x0910, B:477:0x0918, B:478:0x0920, B:480:0x0928, B:481:0x0931, B:483:0x0939, B:484:0x0942, B:486:0x094a, B:487:0x0953, B:489:0x095b, B:490:0x0963, B:492:0x096b, B:493:0x0973, B:495:0x097b, B:496:0x0983, B:498:0x098b, B:499:0x0993, B:502:0x09a4, B:505:0x09b5, B:508:0x09c6, B:511:0x09d7, B:513:0x09df, B:515:0x09ed, B:516:0x09ef, B:519:0x0a00, B:522:0x0a11, B:524:0x0a19, B:526:0x0a25, B:528:0x0a2d, B:529:0x0a3f, B:531:0x0a42, B:536:0x0a52, B:541:0x0a79, B:543:0x0a81, B:545:0x0a8d, B:547:0x0a93, B:548:0x0a9d, B:550:0x0aa0, B:555:0x0ab0, B:557:0x0ab6, B:559:0x0abe, B:561:0x0aca, B:563:0x0ad0, B:564:0x0ada, B:566:0x0add, B:571:0x0aed, B:573:0x0af3, B:575:0x0afb, B:577:0x0b07, B:579:0x0b0d, B:580:0x0b17, B:582:0x0b1a, B:587:0x0b2a, B:589:0x0b30, B:591:0x0b38, B:593:0x0b44, B:595:0x0b4a, B:596:0x0b54, B:598:0x0b57, B:603:0x0b67, B:605:0x0b6d, B:607:0x0b75, B:609:0x0b81, B:611:0x0b87, B:612:0x0b91, B:614:0x0b94, B:619:0x0ba4, B:621:0x0baa, B:623:0x0bb2, B:625:0x0bba, B:627:0x0bc0, B:629:0x0bce, B:633:0x0bf1, B:635:0x0bf9, B:637:0x0c05, B:638:0x0c0b, B:640:0x0c11, B:641:0x0c17, B:643:0x0c1d, B:644:0x0c23, B:646:0x0c29, B:647:0x0c2f, B:649:0x0c35, B:650:0x0c3b, B:652:0x0c41, B:653:0x0c47, B:655:0x0c4d, B:656:0x0c53, B:658:0x0c5b, B:659:0x0c61, B:661:0x0c69, B:662:0x0c6f, B:664:0x0c77, B:665:0x0c7d, B:667:0x0c85, B:669:0x0c93, B:670:0x0c9c, B:672:0x0ca4, B:673:0x0cad, B:675:0x0cb5, B:676:0x0cbe, B:678:0x0cc6, B:679:0x0ccf, B:681:0x0cd7, B:682:0x0ce0, B:684:0x0ce8, B:685:0x0cf1, B:687:0x0cf9, B:688:0x0d02, B:690:0x0d0a, B:691:0x0d12, B:693:0x0d1a, B:694:0x0d22, B:708:0x0d88, B:730:0x0e14, B:732:0x0e1c, B:733:0x0e24, B:735:0x0e2c, B:736:0x0e34, B:738:0x0e3c, B:739:0x0e44, B:741:0x0e4c, B:742:0x0e54, B:744:0x0e5c, B:745:0x0e64, B:747:0x0e6c, B:748:0x0e74, B:750:0x0e7c, B:751:0x0e84, B:753:0x0e8c, B:754:0x0e94, B:756:0x0e9c, B:757:0x0ea4, B:759:0x0eac, B:760:0x0eb5, B:762:0x0ebd, B:763:0x0ec5, B:765:0x0ecd, B:766:0x0ed5, B:768:0x0edd, B:769:0x0ee5, B:771:0x0eed, B:772:0x0ef5, B:774:0x0efd, B:775:0x0f05, B:777:0x0f0d, B:778:0x0f15, B:780:0x0f1d, B:781:0x0f25, B:783:0x0f2d, B:784:0x0f35, B:786:0x0f3d, B:787:0x0f46, B:789:0x0f4e, B:790:0x0f56, B:792:0x0f5e, B:793:0x0f66, B:795:0x0f6e, B:796:0x0f77, B:798:0x0f7f, B:799:0x0f89, B:801:0x0f91, B:802:0x0f9a, B:804:0x0fa2, B:805:0x0fac, B:807:0x0fb4, B:808:0x0fbe, B:810:0x0fc6, B:811:0x0fce, B:813:0x0fd6, B:814:0x0fde, B:816:0x0fe6, B:817:0x0fee, B:819:0x0ff6, B:820:0x0ffe, B:822:0x1006, B:823:0x100f, B:825:0x1017, B:826:0x1021, B:828:0x1029, B:829:0x1032, B:831:0x103a, B:832:0x1043, B:834:0x104b, B:835:0x1054, B:837:0x105c, B:843:0x1098, B:845:0x10a0, B:846:0x10aa, B:848:0x10b2, B:849:0x10ba, B:851:0x10c2, B:852:0x10cb, B:854:0x10d3, B:855:0x10dd, B:857:0x10e5, B:858:0x10ee, B:860:0x10f6, B:861:0x10fe, B:863:0x1106, B:864:0x110f, B:866:0x1117, B:867:0x111f, B:869:0x1127, B:870:0x1131, B:872:0x1139, B:873:0x1142, B:875:0x114a, B:876:0x1153, B:878:0x115b, B:879:0x1169, B:881:0x1171, B:882:0x117f, B:884:0x1187, B:885:0x1190, B:887:0x1198, B:888:0x11a0, B:890:0x11a8, B:891:0x11b0, B:893:0x11b8, B:894:0x11c0, B:896:0x11c8, B:897:0x11d0, B:899:0x11d8, B:900:0x11e1, B:902:0x11e9, B:903:0x11f2, B:905:0x11fc, B:906:0x1204, B:908:0x120c, B:909:0x1216, B:911:0x121e, B:912:0x1227, B:914:0x122f, B:915:0x1238, B:917:0x1240, B:918:0x124b, B:920:0x1253, B:921:0x125b, B:923:0x1263, B:924:0x126b, B:926:0x1273, B:927:0x127b, B:929:0x1283, B:930:0x128b, B:932:0x1293, B:933:0x129b, B:935:0x12a3, B:937:0x12af, B:939:0x12b7, B:940:0x12c9, B:942:0x12d1, B:943:0x12d9, B:945:0x12e1, B:946:0x12e9, B:948:0x12f1, B:949:0x12f9, B:951:0x1301, B:952:0x1309, B:954:0x1311, B:955:0x1319, B:957:0x1321, B:958:0x1329, B:960:0x1331, B:961:0x1339, B:963:0x1341, B:964:0x1349, B:966:0x1351, B:967:0x135a, B:969:0x1362, B:970:0x136a, B:972:0x1372, B:973:0x137a, B:975:0x1382, B:976:0x138a, B:978:0x1392, B:979:0x13a0, B:981:0x13a8, B:982:0x13b1, B:984:0x13b9, B:985:0x13c3, B:987:0x13cb, B:988:0x13d5, B:990:0x13dd, B:991:0x13e5, B:993:0x13ed, B:994:0x13f5, B:996:0x13fd, B:997:0x1405, B:999:0x140d, B:1000:0x1415, B:1002:0x141d, B:1003:0x1425, B:1005:0x142d, B:1006:0x1435, B:1008:0x143d, B:1009:0x1445, B:1011:0x144d, B:1012:0x1455, B:1014:0x145d, B:1015:0x1465, B:1017:0x146d, B:1018:0x1475, B:1020:0x147d, B:1021:0x1485, B:1023:0x148d, B:1024:0x1495, B:1026:0x149d, B:1027:0x14a5, B:1029:0x14ad, B:1030:0x14b5, B:1032:0x14bd, B:1033:0x14c6, B:1035:0x14ce, B:1036:0x14d9, B:1038:0x14e1, B:1039:0x14ea, B:1041:0x14f2, B:1042:0x14fa, B:1044:0x1502, B:729:0x0e11, B:707:0x0d85, B:618:0x0ba1, B:620:0x0ba7, B:602:0x0b64, B:604:0x0b6a, B:586:0x0b27, B:588:0x0b2d, B:570:0x0aea, B:572:0x0af0, B:554:0x0aad, B:556:0x0ab3, B:535:0x0a4f, B:539:0x0a68, B:540:0x0a6c, B:210:0x042b, B:710:0x0d90, B:712:0x0d9d, B:714:0x0da3, B:716:0x0dab, B:718:0x0db3, B:720:0x0dbb, B:722:0x0dc3, B:724:0x0e00, B:725:0x0e07, B:696:0x0d2a, B:698:0x0d37, B:700:0x0d43, B:702:0x0d74, B:703:0x0d7b), top: B:1085:0x0052, inners: #5, #8, #9, #10, #12, #16, #23, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0b6a A[Catch: Exception -> 0x150b, TryCatch #13 {Exception -> 0x150b, blocks: (B:12:0x0052, B:14:0x005d, B:16:0x0063, B:17:0x0066, B:18:0x0069, B:22:0x0074, B:24:0x0082, B:26:0x008e, B:28:0x0094, B:30:0x009c, B:31:0x00ae, B:33:0x00b6, B:34:0x00c0, B:36:0x00c8, B:37:0x00d1, B:39:0x00d9, B:40:0x00e2, B:42:0x00ea, B:43:0x00f3, B:45:0x00fb, B:46:0x0105, B:48:0x010d, B:49:0x0117, B:51:0x011f, B:52:0x0128, B:54:0x0130, B:55:0x0139, B:57:0x0141, B:58:0x014a, B:60:0x0152, B:61:0x015c, B:63:0x0165, B:64:0x016d, B:66:0x0175, B:67:0x017e, B:69:0x0186, B:70:0x018f, B:72:0x0197, B:74:0x01a0, B:75:0x01a4, B:76:0x01a9, B:78:0x01b1, B:211:0x042e, B:213:0x0436, B:214:0x043b, B:216:0x0443, B:217:0x0448, B:219:0x0450, B:220:0x0455, B:222:0x045d, B:223:0x0465, B:225:0x046d, B:226:0x0475, B:228:0x047d, B:229:0x0485, B:231:0x048d, B:232:0x0495, B:234:0x049d, B:236:0x04a5, B:237:0x04a9, B:238:0x04ac, B:240:0x04b4, B:242:0x04bc, B:243:0x04c0, B:244:0x04c3, B:246:0x04cb, B:248:0x04d3, B:249:0x04d7, B:250:0x04da, B:252:0x04e2, B:254:0x04ea, B:255:0x04ee, B:256:0x04f1, B:258:0x04f9, B:260:0x0501, B:261:0x0505, B:262:0x0508, B:264:0x0510, B:265:0x051b, B:267:0x0523, B:269:0x052b, B:270:0x052f, B:271:0x0532, B:273:0x053a, B:275:0x0542, B:276:0x0546, B:277:0x0549, B:279:0x0551, B:281:0x0559, B:282:0x055d, B:283:0x0560, B:285:0x0568, B:286:0x0570, B:288:0x0578, B:289:0x0580, B:291:0x0588, B:292:0x0591, B:294:0x0599, B:295:0x05a1, B:297:0x05a9, B:298:0x05b2, B:300:0x05ba, B:301:0x05c3, B:303:0x05cb, B:304:0x05d4, B:306:0x05dc, B:308:0x05e4, B:309:0x05e8, B:310:0x05eb, B:312:0x05f3, B:314:0x05fb, B:315:0x05ff, B:316:0x0602, B:318:0x060a, B:320:0x0612, B:321:0x0616, B:322:0x0619, B:324:0x0621, B:326:0x0629, B:327:0x062d, B:328:0x0630, B:330:0x0638, B:332:0x0640, B:333:0x0644, B:334:0x0647, B:336:0x064f, B:338:0x0657, B:339:0x065b, B:340:0x065e, B:342:0x0666, B:344:0x066e, B:345:0x0672, B:346:0x0675, B:348:0x067d, B:349:0x0685, B:351:0x068d, B:352:0x0695, B:354:0x069d, B:355:0x06a5, B:357:0x06ad, B:358:0x06b5, B:360:0x06bd, B:361:0x06c5, B:363:0x06cd, B:364:0x06d6, B:366:0x06de, B:367:0x06e7, B:369:0x06ef, B:370:0x06f8, B:372:0x0700, B:373:0x0709, B:375:0x0711, B:376:0x071a, B:378:0x0722, B:379:0x072b, B:381:0x0733, B:382:0x073c, B:384:0x0744, B:385:0x074d, B:387:0x0755, B:388:0x075e, B:390:0x0764, B:391:0x076a, B:393:0x0772, B:394:0x077b, B:396:0x0783, B:397:0x078c, B:399:0x0792, B:400:0x0798, B:402:0x079e, B:403:0x07a4, B:405:0x07ac, B:406:0x07b4, B:408:0x07ba, B:409:0x07c0, B:411:0x07c8, B:412:0x07d0, B:414:0x07d8, B:415:0x07e0, B:417:0x07e8, B:418:0x07f0, B:420:0x07f6, B:421:0x07fc, B:423:0x0802, B:424:0x0808, B:426:0x080e, B:427:0x0814, B:429:0x081c, B:430:0x0822, B:432:0x082a, B:433:0x0830, B:435:0x0838, B:436:0x083e, B:438:0x0846, B:439:0x084e, B:441:0x0856, B:442:0x085e, B:444:0x0866, B:445:0x086e, B:447:0x0876, B:448:0x087e, B:450:0x0886, B:451:0x088e, B:453:0x0896, B:454:0x089e, B:456:0x08a6, B:457:0x08ae, B:459:0x08b6, B:460:0x08be, B:462:0x08c6, B:463:0x08cf, B:465:0x08d7, B:466:0x08e0, B:468:0x08e8, B:469:0x08f0, B:471:0x08f8, B:472:0x0900, B:474:0x0908, B:475:0x0910, B:477:0x0918, B:478:0x0920, B:480:0x0928, B:481:0x0931, B:483:0x0939, B:484:0x0942, B:486:0x094a, B:487:0x0953, B:489:0x095b, B:490:0x0963, B:492:0x096b, B:493:0x0973, B:495:0x097b, B:496:0x0983, B:498:0x098b, B:499:0x0993, B:502:0x09a4, B:505:0x09b5, B:508:0x09c6, B:511:0x09d7, B:513:0x09df, B:515:0x09ed, B:516:0x09ef, B:519:0x0a00, B:522:0x0a11, B:524:0x0a19, B:526:0x0a25, B:528:0x0a2d, B:529:0x0a3f, B:531:0x0a42, B:536:0x0a52, B:541:0x0a79, B:543:0x0a81, B:545:0x0a8d, B:547:0x0a93, B:548:0x0a9d, B:550:0x0aa0, B:555:0x0ab0, B:557:0x0ab6, B:559:0x0abe, B:561:0x0aca, B:563:0x0ad0, B:564:0x0ada, B:566:0x0add, B:571:0x0aed, B:573:0x0af3, B:575:0x0afb, B:577:0x0b07, B:579:0x0b0d, B:580:0x0b17, B:582:0x0b1a, B:587:0x0b2a, B:589:0x0b30, B:591:0x0b38, B:593:0x0b44, B:595:0x0b4a, B:596:0x0b54, B:598:0x0b57, B:603:0x0b67, B:605:0x0b6d, B:607:0x0b75, B:609:0x0b81, B:611:0x0b87, B:612:0x0b91, B:614:0x0b94, B:619:0x0ba4, B:621:0x0baa, B:623:0x0bb2, B:625:0x0bba, B:627:0x0bc0, B:629:0x0bce, B:633:0x0bf1, B:635:0x0bf9, B:637:0x0c05, B:638:0x0c0b, B:640:0x0c11, B:641:0x0c17, B:643:0x0c1d, B:644:0x0c23, B:646:0x0c29, B:647:0x0c2f, B:649:0x0c35, B:650:0x0c3b, B:652:0x0c41, B:653:0x0c47, B:655:0x0c4d, B:656:0x0c53, B:658:0x0c5b, B:659:0x0c61, B:661:0x0c69, B:662:0x0c6f, B:664:0x0c77, B:665:0x0c7d, B:667:0x0c85, B:669:0x0c93, B:670:0x0c9c, B:672:0x0ca4, B:673:0x0cad, B:675:0x0cb5, B:676:0x0cbe, B:678:0x0cc6, B:679:0x0ccf, B:681:0x0cd7, B:682:0x0ce0, B:684:0x0ce8, B:685:0x0cf1, B:687:0x0cf9, B:688:0x0d02, B:690:0x0d0a, B:691:0x0d12, B:693:0x0d1a, B:694:0x0d22, B:708:0x0d88, B:730:0x0e14, B:732:0x0e1c, B:733:0x0e24, B:735:0x0e2c, B:736:0x0e34, B:738:0x0e3c, B:739:0x0e44, B:741:0x0e4c, B:742:0x0e54, B:744:0x0e5c, B:745:0x0e64, B:747:0x0e6c, B:748:0x0e74, B:750:0x0e7c, B:751:0x0e84, B:753:0x0e8c, B:754:0x0e94, B:756:0x0e9c, B:757:0x0ea4, B:759:0x0eac, B:760:0x0eb5, B:762:0x0ebd, B:763:0x0ec5, B:765:0x0ecd, B:766:0x0ed5, B:768:0x0edd, B:769:0x0ee5, B:771:0x0eed, B:772:0x0ef5, B:774:0x0efd, B:775:0x0f05, B:777:0x0f0d, B:778:0x0f15, B:780:0x0f1d, B:781:0x0f25, B:783:0x0f2d, B:784:0x0f35, B:786:0x0f3d, B:787:0x0f46, B:789:0x0f4e, B:790:0x0f56, B:792:0x0f5e, B:793:0x0f66, B:795:0x0f6e, B:796:0x0f77, B:798:0x0f7f, B:799:0x0f89, B:801:0x0f91, B:802:0x0f9a, B:804:0x0fa2, B:805:0x0fac, B:807:0x0fb4, B:808:0x0fbe, B:810:0x0fc6, B:811:0x0fce, B:813:0x0fd6, B:814:0x0fde, B:816:0x0fe6, B:817:0x0fee, B:819:0x0ff6, B:820:0x0ffe, B:822:0x1006, B:823:0x100f, B:825:0x1017, B:826:0x1021, B:828:0x1029, B:829:0x1032, B:831:0x103a, B:832:0x1043, B:834:0x104b, B:835:0x1054, B:837:0x105c, B:843:0x1098, B:845:0x10a0, B:846:0x10aa, B:848:0x10b2, B:849:0x10ba, B:851:0x10c2, B:852:0x10cb, B:854:0x10d3, B:855:0x10dd, B:857:0x10e5, B:858:0x10ee, B:860:0x10f6, B:861:0x10fe, B:863:0x1106, B:864:0x110f, B:866:0x1117, B:867:0x111f, B:869:0x1127, B:870:0x1131, B:872:0x1139, B:873:0x1142, B:875:0x114a, B:876:0x1153, B:878:0x115b, B:879:0x1169, B:881:0x1171, B:882:0x117f, B:884:0x1187, B:885:0x1190, B:887:0x1198, B:888:0x11a0, B:890:0x11a8, B:891:0x11b0, B:893:0x11b8, B:894:0x11c0, B:896:0x11c8, B:897:0x11d0, B:899:0x11d8, B:900:0x11e1, B:902:0x11e9, B:903:0x11f2, B:905:0x11fc, B:906:0x1204, B:908:0x120c, B:909:0x1216, B:911:0x121e, B:912:0x1227, B:914:0x122f, B:915:0x1238, B:917:0x1240, B:918:0x124b, B:920:0x1253, B:921:0x125b, B:923:0x1263, B:924:0x126b, B:926:0x1273, B:927:0x127b, B:929:0x1283, B:930:0x128b, B:932:0x1293, B:933:0x129b, B:935:0x12a3, B:937:0x12af, B:939:0x12b7, B:940:0x12c9, B:942:0x12d1, B:943:0x12d9, B:945:0x12e1, B:946:0x12e9, B:948:0x12f1, B:949:0x12f9, B:951:0x1301, B:952:0x1309, B:954:0x1311, B:955:0x1319, B:957:0x1321, B:958:0x1329, B:960:0x1331, B:961:0x1339, B:963:0x1341, B:964:0x1349, B:966:0x1351, B:967:0x135a, B:969:0x1362, B:970:0x136a, B:972:0x1372, B:973:0x137a, B:975:0x1382, B:976:0x138a, B:978:0x1392, B:979:0x13a0, B:981:0x13a8, B:982:0x13b1, B:984:0x13b9, B:985:0x13c3, B:987:0x13cb, B:988:0x13d5, B:990:0x13dd, B:991:0x13e5, B:993:0x13ed, B:994:0x13f5, B:996:0x13fd, B:997:0x1405, B:999:0x140d, B:1000:0x1415, B:1002:0x141d, B:1003:0x1425, B:1005:0x142d, B:1006:0x1435, B:1008:0x143d, B:1009:0x1445, B:1011:0x144d, B:1012:0x1455, B:1014:0x145d, B:1015:0x1465, B:1017:0x146d, B:1018:0x1475, B:1020:0x147d, B:1021:0x1485, B:1023:0x148d, B:1024:0x1495, B:1026:0x149d, B:1027:0x14a5, B:1029:0x14ad, B:1030:0x14b5, B:1032:0x14bd, B:1033:0x14c6, B:1035:0x14ce, B:1036:0x14d9, B:1038:0x14e1, B:1039:0x14ea, B:1041:0x14f2, B:1042:0x14fa, B:1044:0x1502, B:729:0x0e11, B:707:0x0d85, B:618:0x0ba1, B:620:0x0ba7, B:602:0x0b64, B:604:0x0b6a, B:586:0x0b27, B:588:0x0b2d, B:570:0x0aea, B:572:0x0af0, B:554:0x0aad, B:556:0x0ab3, B:535:0x0a4f, B:539:0x0a68, B:540:0x0a6c, B:210:0x042b, B:710:0x0d90, B:712:0x0d9d, B:714:0x0da3, B:716:0x0dab, B:718:0x0db3, B:720:0x0dbb, B:722:0x0dc3, B:724:0x0e00, B:725:0x0e07, B:696:0x0d2a, B:698:0x0d37, B:700:0x0d43, B:702:0x0d74, B:703:0x0d7b), top: B:1085:0x0052, inners: #5, #8, #9, #10, #12, #16, #23, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0ba7 A[Catch: Exception -> 0x150b, TryCatch #13 {Exception -> 0x150b, blocks: (B:12:0x0052, B:14:0x005d, B:16:0x0063, B:17:0x0066, B:18:0x0069, B:22:0x0074, B:24:0x0082, B:26:0x008e, B:28:0x0094, B:30:0x009c, B:31:0x00ae, B:33:0x00b6, B:34:0x00c0, B:36:0x00c8, B:37:0x00d1, B:39:0x00d9, B:40:0x00e2, B:42:0x00ea, B:43:0x00f3, B:45:0x00fb, B:46:0x0105, B:48:0x010d, B:49:0x0117, B:51:0x011f, B:52:0x0128, B:54:0x0130, B:55:0x0139, B:57:0x0141, B:58:0x014a, B:60:0x0152, B:61:0x015c, B:63:0x0165, B:64:0x016d, B:66:0x0175, B:67:0x017e, B:69:0x0186, B:70:0x018f, B:72:0x0197, B:74:0x01a0, B:75:0x01a4, B:76:0x01a9, B:78:0x01b1, B:211:0x042e, B:213:0x0436, B:214:0x043b, B:216:0x0443, B:217:0x0448, B:219:0x0450, B:220:0x0455, B:222:0x045d, B:223:0x0465, B:225:0x046d, B:226:0x0475, B:228:0x047d, B:229:0x0485, B:231:0x048d, B:232:0x0495, B:234:0x049d, B:236:0x04a5, B:237:0x04a9, B:238:0x04ac, B:240:0x04b4, B:242:0x04bc, B:243:0x04c0, B:244:0x04c3, B:246:0x04cb, B:248:0x04d3, B:249:0x04d7, B:250:0x04da, B:252:0x04e2, B:254:0x04ea, B:255:0x04ee, B:256:0x04f1, B:258:0x04f9, B:260:0x0501, B:261:0x0505, B:262:0x0508, B:264:0x0510, B:265:0x051b, B:267:0x0523, B:269:0x052b, B:270:0x052f, B:271:0x0532, B:273:0x053a, B:275:0x0542, B:276:0x0546, B:277:0x0549, B:279:0x0551, B:281:0x0559, B:282:0x055d, B:283:0x0560, B:285:0x0568, B:286:0x0570, B:288:0x0578, B:289:0x0580, B:291:0x0588, B:292:0x0591, B:294:0x0599, B:295:0x05a1, B:297:0x05a9, B:298:0x05b2, B:300:0x05ba, B:301:0x05c3, B:303:0x05cb, B:304:0x05d4, B:306:0x05dc, B:308:0x05e4, B:309:0x05e8, B:310:0x05eb, B:312:0x05f3, B:314:0x05fb, B:315:0x05ff, B:316:0x0602, B:318:0x060a, B:320:0x0612, B:321:0x0616, B:322:0x0619, B:324:0x0621, B:326:0x0629, B:327:0x062d, B:328:0x0630, B:330:0x0638, B:332:0x0640, B:333:0x0644, B:334:0x0647, B:336:0x064f, B:338:0x0657, B:339:0x065b, B:340:0x065e, B:342:0x0666, B:344:0x066e, B:345:0x0672, B:346:0x0675, B:348:0x067d, B:349:0x0685, B:351:0x068d, B:352:0x0695, B:354:0x069d, B:355:0x06a5, B:357:0x06ad, B:358:0x06b5, B:360:0x06bd, B:361:0x06c5, B:363:0x06cd, B:364:0x06d6, B:366:0x06de, B:367:0x06e7, B:369:0x06ef, B:370:0x06f8, B:372:0x0700, B:373:0x0709, B:375:0x0711, B:376:0x071a, B:378:0x0722, B:379:0x072b, B:381:0x0733, B:382:0x073c, B:384:0x0744, B:385:0x074d, B:387:0x0755, B:388:0x075e, B:390:0x0764, B:391:0x076a, B:393:0x0772, B:394:0x077b, B:396:0x0783, B:397:0x078c, B:399:0x0792, B:400:0x0798, B:402:0x079e, B:403:0x07a4, B:405:0x07ac, B:406:0x07b4, B:408:0x07ba, B:409:0x07c0, B:411:0x07c8, B:412:0x07d0, B:414:0x07d8, B:415:0x07e0, B:417:0x07e8, B:418:0x07f0, B:420:0x07f6, B:421:0x07fc, B:423:0x0802, B:424:0x0808, B:426:0x080e, B:427:0x0814, B:429:0x081c, B:430:0x0822, B:432:0x082a, B:433:0x0830, B:435:0x0838, B:436:0x083e, B:438:0x0846, B:439:0x084e, B:441:0x0856, B:442:0x085e, B:444:0x0866, B:445:0x086e, B:447:0x0876, B:448:0x087e, B:450:0x0886, B:451:0x088e, B:453:0x0896, B:454:0x089e, B:456:0x08a6, B:457:0x08ae, B:459:0x08b6, B:460:0x08be, B:462:0x08c6, B:463:0x08cf, B:465:0x08d7, B:466:0x08e0, B:468:0x08e8, B:469:0x08f0, B:471:0x08f8, B:472:0x0900, B:474:0x0908, B:475:0x0910, B:477:0x0918, B:478:0x0920, B:480:0x0928, B:481:0x0931, B:483:0x0939, B:484:0x0942, B:486:0x094a, B:487:0x0953, B:489:0x095b, B:490:0x0963, B:492:0x096b, B:493:0x0973, B:495:0x097b, B:496:0x0983, B:498:0x098b, B:499:0x0993, B:502:0x09a4, B:505:0x09b5, B:508:0x09c6, B:511:0x09d7, B:513:0x09df, B:515:0x09ed, B:516:0x09ef, B:519:0x0a00, B:522:0x0a11, B:524:0x0a19, B:526:0x0a25, B:528:0x0a2d, B:529:0x0a3f, B:531:0x0a42, B:536:0x0a52, B:541:0x0a79, B:543:0x0a81, B:545:0x0a8d, B:547:0x0a93, B:548:0x0a9d, B:550:0x0aa0, B:555:0x0ab0, B:557:0x0ab6, B:559:0x0abe, B:561:0x0aca, B:563:0x0ad0, B:564:0x0ada, B:566:0x0add, B:571:0x0aed, B:573:0x0af3, B:575:0x0afb, B:577:0x0b07, B:579:0x0b0d, B:580:0x0b17, B:582:0x0b1a, B:587:0x0b2a, B:589:0x0b30, B:591:0x0b38, B:593:0x0b44, B:595:0x0b4a, B:596:0x0b54, B:598:0x0b57, B:603:0x0b67, B:605:0x0b6d, B:607:0x0b75, B:609:0x0b81, B:611:0x0b87, B:612:0x0b91, B:614:0x0b94, B:619:0x0ba4, B:621:0x0baa, B:623:0x0bb2, B:625:0x0bba, B:627:0x0bc0, B:629:0x0bce, B:633:0x0bf1, B:635:0x0bf9, B:637:0x0c05, B:638:0x0c0b, B:640:0x0c11, B:641:0x0c17, B:643:0x0c1d, B:644:0x0c23, B:646:0x0c29, B:647:0x0c2f, B:649:0x0c35, B:650:0x0c3b, B:652:0x0c41, B:653:0x0c47, B:655:0x0c4d, B:656:0x0c53, B:658:0x0c5b, B:659:0x0c61, B:661:0x0c69, B:662:0x0c6f, B:664:0x0c77, B:665:0x0c7d, B:667:0x0c85, B:669:0x0c93, B:670:0x0c9c, B:672:0x0ca4, B:673:0x0cad, B:675:0x0cb5, B:676:0x0cbe, B:678:0x0cc6, B:679:0x0ccf, B:681:0x0cd7, B:682:0x0ce0, B:684:0x0ce8, B:685:0x0cf1, B:687:0x0cf9, B:688:0x0d02, B:690:0x0d0a, B:691:0x0d12, B:693:0x0d1a, B:694:0x0d22, B:708:0x0d88, B:730:0x0e14, B:732:0x0e1c, B:733:0x0e24, B:735:0x0e2c, B:736:0x0e34, B:738:0x0e3c, B:739:0x0e44, B:741:0x0e4c, B:742:0x0e54, B:744:0x0e5c, B:745:0x0e64, B:747:0x0e6c, B:748:0x0e74, B:750:0x0e7c, B:751:0x0e84, B:753:0x0e8c, B:754:0x0e94, B:756:0x0e9c, B:757:0x0ea4, B:759:0x0eac, B:760:0x0eb5, B:762:0x0ebd, B:763:0x0ec5, B:765:0x0ecd, B:766:0x0ed5, B:768:0x0edd, B:769:0x0ee5, B:771:0x0eed, B:772:0x0ef5, B:774:0x0efd, B:775:0x0f05, B:777:0x0f0d, B:778:0x0f15, B:780:0x0f1d, B:781:0x0f25, B:783:0x0f2d, B:784:0x0f35, B:786:0x0f3d, B:787:0x0f46, B:789:0x0f4e, B:790:0x0f56, B:792:0x0f5e, B:793:0x0f66, B:795:0x0f6e, B:796:0x0f77, B:798:0x0f7f, B:799:0x0f89, B:801:0x0f91, B:802:0x0f9a, B:804:0x0fa2, B:805:0x0fac, B:807:0x0fb4, B:808:0x0fbe, B:810:0x0fc6, B:811:0x0fce, B:813:0x0fd6, B:814:0x0fde, B:816:0x0fe6, B:817:0x0fee, B:819:0x0ff6, B:820:0x0ffe, B:822:0x1006, B:823:0x100f, B:825:0x1017, B:826:0x1021, B:828:0x1029, B:829:0x1032, B:831:0x103a, B:832:0x1043, B:834:0x104b, B:835:0x1054, B:837:0x105c, B:843:0x1098, B:845:0x10a0, B:846:0x10aa, B:848:0x10b2, B:849:0x10ba, B:851:0x10c2, B:852:0x10cb, B:854:0x10d3, B:855:0x10dd, B:857:0x10e5, B:858:0x10ee, B:860:0x10f6, B:861:0x10fe, B:863:0x1106, B:864:0x110f, B:866:0x1117, B:867:0x111f, B:869:0x1127, B:870:0x1131, B:872:0x1139, B:873:0x1142, B:875:0x114a, B:876:0x1153, B:878:0x115b, B:879:0x1169, B:881:0x1171, B:882:0x117f, B:884:0x1187, B:885:0x1190, B:887:0x1198, B:888:0x11a0, B:890:0x11a8, B:891:0x11b0, B:893:0x11b8, B:894:0x11c0, B:896:0x11c8, B:897:0x11d0, B:899:0x11d8, B:900:0x11e1, B:902:0x11e9, B:903:0x11f2, B:905:0x11fc, B:906:0x1204, B:908:0x120c, B:909:0x1216, B:911:0x121e, B:912:0x1227, B:914:0x122f, B:915:0x1238, B:917:0x1240, B:918:0x124b, B:920:0x1253, B:921:0x125b, B:923:0x1263, B:924:0x126b, B:926:0x1273, B:927:0x127b, B:929:0x1283, B:930:0x128b, B:932:0x1293, B:933:0x129b, B:935:0x12a3, B:937:0x12af, B:939:0x12b7, B:940:0x12c9, B:942:0x12d1, B:943:0x12d9, B:945:0x12e1, B:946:0x12e9, B:948:0x12f1, B:949:0x12f9, B:951:0x1301, B:952:0x1309, B:954:0x1311, B:955:0x1319, B:957:0x1321, B:958:0x1329, B:960:0x1331, B:961:0x1339, B:963:0x1341, B:964:0x1349, B:966:0x1351, B:967:0x135a, B:969:0x1362, B:970:0x136a, B:972:0x1372, B:973:0x137a, B:975:0x1382, B:976:0x138a, B:978:0x1392, B:979:0x13a0, B:981:0x13a8, B:982:0x13b1, B:984:0x13b9, B:985:0x13c3, B:987:0x13cb, B:988:0x13d5, B:990:0x13dd, B:991:0x13e5, B:993:0x13ed, B:994:0x13f5, B:996:0x13fd, B:997:0x1405, B:999:0x140d, B:1000:0x1415, B:1002:0x141d, B:1003:0x1425, B:1005:0x142d, B:1006:0x1435, B:1008:0x143d, B:1009:0x1445, B:1011:0x144d, B:1012:0x1455, B:1014:0x145d, B:1015:0x1465, B:1017:0x146d, B:1018:0x1475, B:1020:0x147d, B:1021:0x1485, B:1023:0x148d, B:1024:0x1495, B:1026:0x149d, B:1027:0x14a5, B:1029:0x14ad, B:1030:0x14b5, B:1032:0x14bd, B:1033:0x14c6, B:1035:0x14ce, B:1036:0x14d9, B:1038:0x14e1, B:1039:0x14ea, B:1041:0x14f2, B:1042:0x14fa, B:1044:0x1502, B:729:0x0e11, B:707:0x0d85, B:618:0x0ba1, B:620:0x0ba7, B:602:0x0b64, B:604:0x0b6a, B:586:0x0b27, B:588:0x0b2d, B:570:0x0aea, B:572:0x0af0, B:554:0x0aad, B:556:0x0ab3, B:535:0x0a4f, B:539:0x0a68, B:540:0x0a6c, B:210:0x042b, B:710:0x0d90, B:712:0x0d9d, B:714:0x0da3, B:716:0x0dab, B:718:0x0db3, B:720:0x0dbb, B:722:0x0dc3, B:724:0x0e00, B:725:0x0e07, B:696:0x0d2a, B:698:0x0d37, B:700:0x0d43, B:702:0x0d74, B:703:0x0d7b), top: B:1085:0x0052, inners: #5, #8, #9, #10, #12, #16, #23, #24 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean z) {
        String str;
        CharSequence charSequence;
        String str2;
        Exception exc;
        String str3;
        String str4;
        String str5;
        String str6;
        CharSequence charSequence2;
        String string;
        double dNextDouble;
        String string2;
        String[] strArrSplit;
        String strA = s.a().a("vdrconfig_gz", "");
        if (!TextUtils.isEmpty(strA)) {
            try {
                byte[] bArrB = com.baidu.location.e.h.b(Base64.decode(strA, 0));
                if (bArrB != null) {
                    strA = new String(bArrB, "UTF-8");
                }
            } catch (Exception unused) {
                strA = null;
            }
        }
        if (strA == null || strA.length() <= 1) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strA);
            if (jSONObject.has("ison")) {
                if (jSONObject.getInt("ison") > 0) {
                    this.b = true;
                } else {
                    this.b = false;
                }
            }
            if (jSONObject.has("hysV2")) {
                this.da = jSONObject.optInt("hysV2", 1);
                if (jSONObject.has("hdyfms")) {
                    String strOptString = jSONObject.optString("hdyfms");
                    if (!"".equals(strOptString) && strOptString.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                        String[] strArrSplit2 = strOptString.split("\\|");
                        if (strArrSplit2.length >= 2) {
                            this.db = Integer.parseInt(strArrSplit2[0]);
                            this.dc = Integer.parseInt(strArrSplit2[1]);
                        }
                    }
                }
            }
            if (jSONObject.has("hdynwot")) {
                this.dd = jSONObject.optInt("hdynwot", 2000);
            }
            if (jSONObject.has("hyp")) {
                this.cZ = jSONObject.optString("hyp", null);
            }
            if (jSONObject.has("navilane")) {
                this.cV = jSONObject.optInt("navilane", 0);
            }
            if (jSONObject.has("navilane_dr")) {
                this.cW = jSONObject.optInt("navilane_dr", 0);
            }
            if (jSONObject.has("navilane_uat")) {
                this.cY = jSONObject.optInt("navilane_uat", 15);
            }
            if (jSONObject.has("navilane_dr_para")) {
                this.cX = jSONObject.optInt("navilane_dr_para", 500);
            }
            if (jSONObject.has("bmsrco")) {
                this.ch = jSONObject.optInt("bmsrco", 1);
            }
            if (jSONObject.has("bhyco")) {
                this.ci = jSONObject.optInt("bhyco", 1);
            }
            if (jSONObject.has("rcapso")) {
                this.cj = jSONObject.optInt("rcapso", 1);
            }
            if (jSONObject.has("rcpgn")) {
                this.cE = jSONObject.optInt("rcpgn", 15);
            }
            if (jSONObject.has("rcjlgt")) {
                this.cF = jSONObject.optInt("rcjlgt", 3);
            }
            if (jSONObject.has("lelogo")) {
                this.dW = jSONObject.optInt("lelogo", 1);
            }
            if (jSONObject.has("hdlrc")) {
                this.r = jSONObject.optInt("hdlrc", 2);
            }
            if (jSONObject.has("splprs")) {
                int iOptInt = jSONObject.optInt("splprs", -1);
                if (iOptInt < 0) {
                    this.df = 0;
                } else {
                    this.df = 1;
                    this.dg = iOptInt;
                }
            }
            if (jSONObject.has("cbds")) {
                this.dh = jSONObject.optInt("cbds");
            }
            try {
                if (jSONObject.has("hploc")) {
                    String string3 = jSONObject.getString("hploc");
                    if (TextUtils.isEmpty(string3) || !string3.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || (strArrSplit = string3.split("\\|")) == null) {
                        str = "\\|";
                    } else {
                        str = "\\|";
                        if (strArrSplit.length >= 2) {
                            try {
                                if (strArrSplit[0].equals("RMS")) {
                                    this.bD = true;
                                } else if (strArrSplit[0].equals("BMS")) {
                                    this.bF = true;
                                } else if (strArrSplit[0].equals("HMS")) {
                                    this.bz = true;
                                } else if (strArrSplit[0].equals("HPMS")) {
                                    this.bG = true;
                                } else if (strArrSplit[0].equals("HMS,BMS")) {
                                    this.bA = true;
                                }
                                if (this.bD || this.bF || this.bz || this.bG || this.bA) {
                                    if (strArrSplit[1].equals("ALL")) {
                                        this.bQ = 1;
                                    } else if (strArrSplit[1].equals("NAVI")) {
                                        this.bQ = 2;
                                    }
                                }
                                this.bC = string3 + "," + this.bD + "," + this.bG + "," + this.bz + "," + this.bF + "," + this.bA + "," + this.bQ;
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    if (jSONObject.has("hplocst")) {
                        this.bB = jSONObject.optInt("hplocst", 3);
                    }
                    if (jSONObject.has("hdlnp")) {
                        this.di = jSONObject.optInt("hdlnp", 1);
                    }
                    if (jSONObject.has("hdlnpt")) {
                        this.dj = jSONObject.optInt("hdlnpt", TTAdConstant.STYLE_SIZE_RADIO_3_2);
                    }
                    if (jSONObject.has("hdldngt")) {
                        this.dk = jSONObject.optInt("hdldngt", 1800000);
                    }
                    if (jSONObject.has("viaduct") && (string2 = jSONObject.getString("viaduct")) != null && "RY".equals(string2)) {
                        this.bE = true;
                    }
                }
            } catch (Exception unused3) {
                str = "\\|";
            }
            try {
                if (jSONObject.has("cfms")) {
                    jSONObject.getJSONArray("cfms");
                }
            } catch (Exception unused4) {
            }
            try {
                if (jSONObject.has("traf_ctrl_value")) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("traf_ctrl_value");
                    if (jSONObjectOptJSONObject.has("subway_switch")) {
                        try {
                            this.bH = jSONObjectOptJSONObject.optInt("subway_switch");
                        } catch (Exception e) {
                            exc = e;
                            charSequence = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                            str2 = ",";
                            exc.printStackTrace();
                        }
                    }
                    if (jSONObjectOptJSONObject.has("subway_paramter")) {
                        this.bI = jSONObjectOptJSONObject.optString("subway_paramter");
                    }
                    if (jSONObjectOptJSONObject.has("sub_col_prob")) {
                        str2 = ",";
                        try {
                            this.bJ = jSONObjectOptJSONObject.optDouble("sub_col_prob");
                            dNextDouble = new Random().nextDouble();
                            charSequence = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                        } catch (Exception e2) {
                            e = e2;
                            charSequence = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                            exc = e;
                            exc.printStackTrace();
                        }
                        try {
                            if (dNextDouble > this.bJ) {
                                this.bK = true;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            exc = e;
                            exc.printStackTrace();
                        }
                    } else {
                        charSequence = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                        str2 = ",";
                    }
                    if (jSONObjectOptJSONObject.has("sub_col_onland")) {
                        this.bO = jSONObjectOptJSONObject.optInt("sub_col_onland");
                    }
                    if (jSONObjectOptJSONObject.has("press_col_switch")) {
                        this.bL = jSONObjectOptJSONObject.optInt("press_col_switch");
                    }
                    if (jSONObjectOptJSONObject.has("press_col_prob")) {
                        this.bM = jSONObjectOptJSONObject.optDouble("press_col_prob");
                        if (new Random().nextDouble() > this.bM) {
                            this.bN = true;
                        } else {
                            this.bN = false;
                        }
                    }
                    if (jSONObjectOptJSONObject.has("traffic_switch")) {
                        this.bX = jSONObjectOptJSONObject.optInt("traffic_switch");
                    }
                    if (jSONObjectOptJSONObject.has("traffic_paramter")) {
                        this.bY = jSONObjectOptJSONObject.optString("traffic_paramter");
                    }
                    if (jSONObjectOptJSONObject.has("gps_checker_switch_android")) {
                        this.bZ = jSONObjectOptJSONObject.optInt("gps_checker_switch_android");
                    }
                    if (jSONObjectOptJSONObject.has("gps_checker_params_android")) {
                        this.ca = jSONObjectOptJSONObject.optString("gps_checker_params_android");
                    }
                    if (jSONObjectOptJSONObject.has(WkParams.MODEL)) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(WkParams.MODEL);
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject2.has("name")) {
                                jSONObjectOptJSONObject2.optString("name");
                            }
                        }
                    }
                } else {
                    charSequence = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                    str2 = ",";
                }
            } catch (Exception e4) {
                e = e4;
                charSequence = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                str2 = ",";
            }
            if (jSONObject.has("rpmp_indoor_model")) {
                jSONObject.optString("rpmp_indoor_model");
            }
            if (jSONObject.has("rpmp_indoor_md5")) {
                jSONObject.optString("rpmp_indoor_md5");
            }
            if (jSONObject.has("rpmp_indoor_ver")) {
                jSONObject.optString("rpmp_indoor_ver");
            }
            if (jSONObject.has("rpmp_indoor_switch")) {
                this.ck = jSONObject.optInt("rpmp_indoor_switch");
            }
            if (jSONObject.has("ipbos")) {
                this.cp = jSONObject.optInt("ipbos");
            }
            if (jSONObject.has("cell_scan_ver")) {
                this.bP = jSONObject.optInt("cell_scan_ver");
            }
            if (jSONObject.has("tvurnd")) {
                this.cu = jSONObject.optInt("tvurnd");
            }
            if (jSONObject.has("vo_t")) {
                if (jSONObject.getInt("vo_t") > 0) {
                    this.e = true;
                } else {
                    this.e = false;
                }
            }
            if (jSONObject.has("vo_ep")) {
                if (jSONObject.getInt("vo_ep") > 0) {
                    this.h = true;
                } else {
                    this.h = false;
                }
            }
            if (jSONObject.has("vo_sl")) {
                if (jSONObject.getInt("vo_sl") > 0) {
                    this.d = true;
                } else {
                    this.d = false;
                }
            }
            if (jSONObject.has("nvso")) {
                if (jSONObject.getInt("nvso") > 0) {
                    this.g = true;
                } else {
                    this.g = false;
                }
            }
            if (jSONObject.has("vo_d")) {
                if (jSONObject.getInt("vo_d") > 0) {
                    this.f = true;
                } else {
                    this.f = false;
                }
            }
            if (jSONObject.has("grrct")) {
                this.by = jSONObject.optInt("grrct", 72);
            }
            if (jSONObject.has("vnrlon")) {
                if (jSONObject.getInt("vnrlon") > 0) {
                    this.O = true;
                } else {
                    this.O = false;
                }
            }
            if (jSONObject.has("vlogon")) {
                if (jSONObject.getInt("vlogon") > 0) {
                    this.P = true;
                } else {
                    this.P = false;
                }
            }
            if (jSONObject.has("vrtlog")) {
                if (jSONObject.getInt("vrtlog") > 0) {
                    this.bn = true;
                } else {
                    this.bn = false;
                }
            }
            if (jSONObject.has("tbs")) {
                this.bo = jSONObject.getInt("tbs");
            }
            if (jSONObject.has("rls")) {
                this.bv = jSONObject.getInt("rls");
            }
            if (jSONObject.has("sdth")) {
                this.bp = (float) jSONObject.getDouble("sdth");
            }
            if (jSONObject.has("couth")) {
                this.bq = jSONObject.getInt("couth");
            }
            if (jSONObject.has("accth")) {
                this.br = (float) jSONObject.getDouble("accth");
            }
            if (jSONObject.has("lenth")) {
                this.bs = (float) jSONObject.getDouble("lenth");
            }
            if (jSONObject.has("seth")) {
                this.bt = (float) jSONObject.getDouble("seth");
            }
            if (jSONObject.has("vcso")) {
                if (jSONObject.getInt("vcso") > 0) {
                    this.Q = true;
                } else {
                    this.Q = false;
                }
            }
            if (jSONObject.has("laeso")) {
                if (jSONObject.getInt("laeso") > 0) {
                    this.V = true;
                } else {
                    this.V = false;
                }
            }
            if (jSONObject.has("vdro")) {
                if (jSONObject.getInt("vdro") > 0) {
                    this.R = true;
                } else {
                    this.R = false;
                }
            }
            if (jSONObject.has("snco")) {
                if (jSONObject.getInt("snco") > 0) {
                    this.S = true;
                } else {
                    this.S = false;
                }
            }
            if (jSONObject.has("vnmlo")) {
                if (jSONObject.getInt("vnmlo") > 0) {
                    this.U = true;
                } else {
                    this.U = false;
                }
            }
            if (jSONObject.has("vtcrf")) {
                if (jSONObject.getInt("vtcrf") > 0) {
                    this.bu = true;
                } else {
                    this.bu = false;
                }
            }
            if (jSONObject.has("vnsl")) {
                if (jSONObject.getInt("vnsl") > 0) {
                    this.ar = true;
                } else {
                    this.ar = false;
                }
            }
            if (jSONObject.has("vt_max_drift")) {
                this.i = jSONObject.getInt("vt_max_drift");
            }
            if (jSONObject.has("wnsgrs")) {
                this.bm = jSONObject.getInt("wnsgrs");
            }
            if (jSONObject.has("snct")) {
                this.T = jSONObject.getInt("snct");
            }
            if (jSONObject.has("vd_cross")) {
                this.j = jSONObject.getInt("vd_cross");
            }
            if (jSONObject.has("vpan")) {
                this.N = jSONObject.getInt("vpan");
            }
            if (jSONObject.has("yw")) {
                this.ai = (float) jSONObject.getDouble("yw");
            }
            if (jSONObject.has("yd1")) {
                this.aj = (float) jSONObject.getDouble("yd1");
            }
            if (jSONObject.has("yd2")) {
                this.ak = (float) jSONObject.getDouble("yd2");
            }
            if (jSONObject.has("yd3")) {
                this.al = (float) jSONObject.getDouble("yd3");
            }
            if (jSONObject.has("yd4")) {
                this.am = (float) jSONObject.getDouble("yd4");
            }
            if (jSONObject.has("yd5")) {
                this.an = (float) jSONObject.getDouble("yd5");
            }
            if (jSONObject.has("yd6")) {
                this.ao = (float) jSONObject.getDouble("yd6");
            }
            if (jSONObject.has("yd7")) {
                this.ap = (float) jSONObject.getDouble("yd7");
            }
            if (jSONObject.has("yd8")) {
                this.aq = (float) jSONObject.getDouble("yd8");
            }
            if (jSONObject.has("vt")) {
                this.k = jSONObject.getInt("vt");
            }
            if (jSONObject.has("vwnp")) {
                this.B = (float) jSONObject.getDouble("vwnp");
            }
            if (jSONObject.has("vtpct")) {
                this.C = (float) jSONObject.getDouble("vtpct");
            }
            if (jSONObject.has("vr")) {
                this.l = jSONObject.getInt("vr");
            }
            if (jSONObject.has("vl")) {
                this.m = jSONObject.getInt("vl");
            }
            if (jSONObject.has("vg")) {
                this.n = jSONObject.getInt("vg");
            }
            if (jSONObject.has("vds")) {
                this.s = jSONObject.getInt("vds");
            }
            if (jSONObject.has("vnt1")) {
                this.ag = jSONObject.getInt("vnt1");
            }
            if (jSONObject.has("vnt2")) {
                this.ah = jSONObject.getInt("vnt2");
            }
            if (jSONObject.has("vndis")) {
                this.af = jSONObject.getInt("vndis");
            }
            if (jSONObject.has("vir")) {
                this.t = jSONObject.getInt("vir");
            }
            if (jSONObject.has("vzo")) {
                this.u = jSONObject.getInt("vzo");
            }
            if (jSONObject.has("vte")) {
                this.v = jSONObject.getInt("vte");
            }
            if (jSONObject.has("vgs")) {
                this.w = jSONObject.getInt("vgs");
            }
            if (jSONObject.has("vdt")) {
                this.x = jSONObject.getInt("vdt");
            }
            if (jSONObject.has("voc")) {
                this.y = jSONObject.getInt("voc");
            }
            if (jSONObject.has("gdco")) {
                this.aN = jSONObject.getInt("gdco");
            }
            if (jSONObject.has("sopt")) {
                this.aO = jSONObject.getInt("sopt");
            }
            if (jSONObject.has("vsd")) {
                this.A = jSONObject.getInt("vsd");
            }
            if (jSONObject.has("vtast")) {
                this.aP = jSONObject.getInt("vtast");
            }
            if (jSONObject.has("otd")) {
                this.aQ = jSONObject.getInt("otd");
            }
            if (jSONObject.has("atrf")) {
                this.aR = jSONObject.getInt("atrf");
            }
            if (jSONObject.has("mdin")) {
                this.aS = jSONObject.getInt("mdin");
            }
            if (jSONObject.has("dmd")) {
                this.aT = jSONObject.getInt("dmd");
            }
            if (jSONObject.has("tunnel_vl")) {
                this.be = (float) jSONObject.getDouble("tunnel_vl");
            }
            if (jSONObject.has("vtarm")) {
                this.bd = (float) jSONObject.getDouble("vtarm");
            }
            if (jSONObject.has("pms")) {
                this.aU = jSONObject.getInt("pms");
            }
            if (jSONObject.has("ipblo")) {
                this.aX = jSONObject.getInt("ipblo");
            }
            if (jSONObject.has("ipbwn")) {
                this.aY = jSONObject.getInt("ipbwn");
            }
            if (jSONObject.has("ipbdalp")) {
                this.bc = jSONObject.getInt("ipbdalp");
            }
            if (jSONObject.has("ipbalp")) {
                this.aZ = (float) jSONObject.getDouble("ipbalp");
            }
            if (jSONObject.has("ipbmt")) {
                this.ba = (float) jSONObject.getDouble("ipbmt");
            }
            if (jSONObject.has("ipbmth")) {
                this.bb = (float) jSONObject.getDouble("ipbmth");
            }
            if (jSONObject.has("ews")) {
                this.bl = jSONObject.getInt("ews");
            }
            if (jSONObject.has("mds")) {
                this.aV = jSONObject.getInt("mds");
            }
            if (jSONObject.has("nps")) {
                this.aW = jSONObject.getInt("nps");
            }
            if (jSONObject.has("raws")) {
                this.bw = jSONObject.getInt("raws");
            }
            if (jSONObject.has("rawp")) {
                try {
                    this.bx = (float) jSONObject.optDouble("rawp");
                } catch (Exception unused5) {
                }
            }
            if (jSONObject.has("tspp")) {
                try {
                    this.bV = jSONObject.optInt("tspp", 0);
                } catch (Exception unused6) {
                }
            }
            if (jSONObject.has("ircbms")) {
                try {
                    this.bW = jSONObject.optInt("ircbms", 0);
                } catch (Exception unused7) {
                }
            }
            if (jSONObject.has("dbds")) {
                try {
                    this.bR = jSONObject.optInt("dbds", -1);
                } catch (Exception unused8) {
                }
            }
            if (jSONObject.has("spic")) {
                String strOptString2 = jSONObject.optString("spic", this.ce);
                if (!TextUtils.isEmpty(strOptString2)) {
                    this.ce = strOptString2;
                }
            }
            if (jSONObject.has("total_spic")) {
                try {
                    this.cf = jSONObject.optInt("total_spic", 0);
                } catch (Exception unused9) {
                }
            }
            if (jSONObject.has("total_spic_2")) {
                try {
                    this.cg = jSONObject.optInt("total_spic_2", 0);
                } catch (Exception unused10) {
                }
            }
            if (jSONObject.has("cfgs_params_mode0_new")) {
                String string4 = jSONObject.getString("cfgs_params_mode0_new");
                if (TextUtils.isEmpty(string4)) {
                    str3 = "vgs";
                    str4 = "vdt";
                    str5 = "voc";
                    str6 = str;
                    charSequence2 = charSequence;
                } else {
                    charSequence2 = charSequence;
                    if (string4.contains(charSequence2)) {
                        str5 = "voc";
                        str6 = str;
                        String[] strArrSplit3 = string4.split(str6);
                        str4 = "vdt";
                        this.bf = new float[strArrSplit3.length];
                        str3 = "vgs";
                        for (int i2 = 0; i2 < strArrSplit3.length; i2++) {
                            try {
                                this.bf[i2] = Float.parseFloat(strArrSplit3[i2]);
                            } catch (NumberFormatException e5) {
                                e5.printStackTrace();
                            }
                        }
                    } else {
                        str3 = "vgs";
                        str4 = "vdt";
                        str5 = "voc";
                        str6 = str;
                    }
                }
                d();
            } else {
                str3 = "vgs";
                str4 = "vdt";
                str5 = "voc";
                str6 = str;
                charSequence2 = charSequence;
                d();
            }
            if (jSONObject.has("cfgs_params_mode1")) {
                String string5 = jSONObject.getString("cfgs_params_mode1");
                if (TextUtils.isEmpty(string5) || !string5.contains(charSequence2)) {
                    e();
                } else {
                    String[] strArrSplit4 = string5.split(str6);
                    this.bg = new float[strArrSplit4.length];
                    for (int i3 = 0; i3 < strArrSplit4.length; i3++) {
                        try {
                            this.bg[i3] = Float.parseFloat(strArrSplit4[i3]);
                        } catch (NumberFormatException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
            }
            if (jSONObject.has("cfgs_params_mode2")) {
                String string6 = jSONObject.getString("cfgs_params_mode2");
                if (TextUtils.isEmpty(string6) || !string6.contains(charSequence2)) {
                    f();
                } else {
                    String[] strArrSplit5 = string6.split(str6);
                    this.bh = new float[strArrSplit5.length];
                    for (int i4 = 0; i4 < strArrSplit5.length; i4++) {
                        try {
                            this.bh[i4] = Float.parseFloat(strArrSplit5[i4]);
                        } catch (NumberFormatException e7) {
                            e7.printStackTrace();
                        }
                    }
                }
            }
            if (jSONObject.has("cfgs_params_mode4")) {
                String string7 = jSONObject.getString("cfgs_params_mode4");
                if (TextUtils.isEmpty(string7) || !string7.contains(charSequence2)) {
                    g();
                } else {
                    String[] strArrSplit6 = string7.split(str6);
                    this.bi = new float[strArrSplit6.length];
                    for (int i5 = 0; i5 < strArrSplit6.length; i5++) {
                        try {
                            this.bi[i5] = Float.parseFloat(strArrSplit6[i5]);
                        } catch (NumberFormatException e8) {
                            e8.printStackTrace();
                        }
                    }
                }
            }
            if (jSONObject.has("cfgs_params_mode5")) {
                String string8 = jSONObject.getString("cfgs_params_mode5");
                if (TextUtils.isEmpty(string8) || !string8.contains(charSequence2)) {
                    h();
                } else {
                    String[] strArrSplit7 = string8.split(str6);
                    this.bj = new float[strArrSplit7.length];
                    for (int i6 = 0; i6 < strArrSplit7.length; i6++) {
                        try {
                            this.bj[i6] = Float.parseFloat(strArrSplit7[i6]);
                        } catch (NumberFormatException e9) {
                            e9.printStackTrace();
                        }
                    }
                }
            }
            if (jSONObject.has("cfgs_params_mode6")) {
                String string9 = jSONObject.getString("cfgs_params_mode6");
                if (TextUtils.isEmpty(string9) || !string9.contains(charSequence2)) {
                    i();
                } else {
                    String[] strArrSplit8 = string9.split(str6);
                    this.bk = new float[strArrSplit8.length];
                    for (int i7 = 0; i7 < strArrSplit8.length; i7++) {
                        try {
                            this.bk[i7] = Float.parseFloat(strArrSplit8[i7]);
                        } catch (NumberFormatException e10) {
                            e10.printStackTrace();
                        }
                    }
                }
            }
            if (jSONObject.has("vsc") && (string = jSONObject.getString("vsc")) != null && string.contains(str2)) {
                String[] strArrSplit9 = string.split(str2);
                this.z = new int[strArrSplit9.length];
                int length = strArrSplit9.length;
                int i8 = 0;
                int i9 = 0;
                while (i8 < length) {
                    String str7 = strArrSplit9[i8];
                    String[] strArr = strArrSplit9;
                    this.z[i9] = 0;
                    if (str7.length() > 0) {
                        try {
                            this.z[i9] = Integer.valueOf(str7).intValue();
                        } catch (Throwable unused11) {
                        }
                    }
                    i9++;
                    i8++;
                    strArrSplit9 = strArr;
                }
            }
            if (jSONObject.has("d")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("d");
                if (jSONObject2.has("vt")) {
                    this.D = jSONObject2.getInt("vt");
                }
                if (jSONObject2.has("vr")) {
                    this.E = jSONObject2.getInt("vr");
                }
                if (jSONObject2.has("vl")) {
                    this.F = jSONObject2.getInt("vl");
                }
                if (jSONObject2.has("vds")) {
                    this.G = jSONObject2.getInt("vds");
                }
                if (jSONObject2.has("vir")) {
                    this.H = jSONObject2.getInt("vir");
                }
                if (jSONObject2.has("vzo")) {
                    this.I = jSONObject2.getInt("vzo");
                }
                if (jSONObject2.has("vte")) {
                    this.J = jSONObject2.getInt("vte");
                }
                String str8 = str3;
                if (jSONObject2.has(str8)) {
                    this.K = jSONObject2.getInt(str8);
                }
                String str9 = str4;
                if (jSONObject2.has(str9)) {
                    this.L = jSONObject2.getInt(str9);
                }
                String str10 = str5;
                if (jSONObject2.has(str10)) {
                    this.M = jSONObject2.getInt(str10);
                }
            }
            if (jSONObject.has(LiveConfigKey.AUDIO)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(LiveConfigKey.AUDIO);
                if (jSONObject3.has("rn0")) {
                    this.X = (float) jSONObject3.getDouble("rn0");
                }
                if (jSONObject3.has("rn1")) {
                    this.Y = (float) jSONObject3.getDouble("rn1");
                }
                if (jSONObject3.has("rn2")) {
                    this.Z = (float) jSONObject3.getDouble("rn2");
                }
                if (jSONObject3.has("rv0")) {
                    this.aa = (float) jSONObject3.getDouble("rv0");
                }
                if (jSONObject3.has("rv1")) {
                    this.ab = (float) jSONObject3.getDouble("rv1");
                }
                if (jSONObject3.has("rv2")) {
                    this.ac = (float) jSONObject3.getDouble("rv2");
                }
                if (jSONObject3.has("rvb")) {
                    this.ad = (float) jSONObject3.getDouble("rvb");
                }
                if (jSONObject3.has("swt")) {
                    this.ae = jSONObject3.getInt("swt");
                }
            }
            if (jSONObject.has("vcr")) {
                this.W = jSONObject.getInt("vcr");
            }
            if (jSONObject.has("vgrids")) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("vgrids");
                    int length2 = jSONArray.length();
                    for (int i10 = 0; i10 < length2; i10++) {
                        String[] strArrSplit10 = jSONArray.getString(i10).split(str2);
                        if (strArrSplit10.length == 4) {
                            ArrayList<Float> arrayList = new ArrayList<>();
                            arrayList.add(Float.valueOf(strArrSplit10[0]));
                            arrayList.add(Float.valueOf(strArrSplit10[1]));
                            arrayList.add(Float.valueOf(strArrSplit10[2]));
                            arrayList.add(Float.valueOf(strArrSplit10[3]));
                            if (this.eA == null) {
                                this.eA = new ArrayList<>();
                            }
                            this.eA.add(arrayList);
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (jSONObject.has("net_vdr_polygon")) {
                try {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("net_vdr_polygon");
                    int length3 = jSONArray2.length();
                    for (int i11 = 0; i11 < length3; i11++) {
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i11);
                        if (jSONObject4 != null && jSONObject4.has("x1") && jSONObject4.has("x2") && jSONObject4.has("y1") && jSONObject4.has("y2")) {
                            ArrayList<Double> arrayList2 = new ArrayList<>();
                            arrayList2.add(Double.valueOf(jSONObject4.getDouble("x1")));
                            arrayList2.add(Double.valueOf(jSONObject4.getDouble("y1")));
                            arrayList2.add(Double.valueOf(jSONObject4.getDouble("x2")));
                            arrayList2.add(Double.valueOf(jSONObject4.getDouble("y2")));
                            if (this.eB == null) {
                                this.eB = new ArrayList<>();
                            }
                            this.eB.add(arrayList2);
                        }
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
                if (jSONObject.has("pps")) {
                    this.as = jSONObject.getInt("pps");
                }
                if (jSONObject.has("ppsw")) {
                    this.at = jSONObject.getInt("ppsw");
                }
                if (jSONObject.has("ppsv")) {
                    this.au = jSONObject.getInt("ppsv");
                }
                if (jSONObject.has("ppsmt")) {
                    this.av = jSONObject.getInt("ppsmt");
                }
                if (jSONObject.has("ppst")) {
                    this.aw = jSONObject.getInt("ppst");
                }
                if (jSONObject.has("spef")) {
                    this.ax = jSONObject.getInt("spef");
                }
                if (jSONObject.has("ppsut")) {
                    this.ay = jSONObject.getInt("ppsut");
                }
                if (jSONObject.has("csps")) {
                    this.az = jSONObject.getInt("csps");
                }
                if (jSONObject.has("cspd")) {
                    this.aA = jSONObject.getInt("cspd");
                }
                if (jSONObject.has("cspr")) {
                    this.aB = (float) jSONObject.getDouble("cspr");
                }
                if (jSONObject.has("ntb")) {
                    this.aC = jSONObject.getInt("ntb");
                }
                if (jSONObject.has("hcs")) {
                    this.aD = jSONObject.getInt("hcs");
                }
                if (jSONObject.has("hss")) {
                    this.aE = jSONObject.getInt("hss");
                }
                if (jSONObject.has("drs")) {
                    this.aF = jSONObject.getInt("drs");
                }
                if (jSONObject.has("rfdd")) {
                    this.aG = jSONObject.getInt("rfdd");
                }
                if (jSONObject.has("ncls")) {
                    this.aH = jSONObject.getInt("ncls");
                }
                if (jSONObject.has("nclw")) {
                    this.aI = jSONObject.getInt("nclw");
                }
                if (jSONObject.has("nvwst")) {
                    this.aJ = jSONObject.getInt("nvwst");
                }
                if (jSONObject.has("ctz")) {
                    this.aK = (float) jSONObject.getDouble("ctz");
                }
                if (jSONObject.has("cdt")) {
                    this.aL = jSONObject.getInt("cdt");
                }
                if (jSONObject.has("ccfb")) {
                    this.aM = jSONObject.getInt("ccfb");
                }
                if (jSONObject.has("epoch_switch")) {
                    this.bS = jSONObject.optInt("epoch_switch", 0);
                }
                if (jSONObject.has("epoch_to")) {
                    this.bU = jSONObject.optDouble("epoch_to", -1.0d);
                }
                if (jSONObject.has("cl_list_switch")) {
                    this.cb = jSONObject.optInt("cl_list_switch", 0);
                }
                if (jSONObject.has("cell_number")) {
                    this.cc = jSONObject.optInt("cell_number", 10);
                }
                if (jSONObject.has("loc_str_length")) {
                    this.cd = jSONObject.optInt("loc_str_length", 4000);
                }
                if (jSONObject.has("hrck")) {
                    this.cl = jSONObject.getString("hrck");
                }
                if (jSONObject.has("hmsk")) {
                    this.cm = jSONObject.getString("hmsk");
                }
                if (jSONObject.has("rmsk")) {
                    this.f3405cn = jSONObject.getString("rmsk");
                }
                if (jSONObject.has("hpstdk")) {
                    this.co = jSONObject.getString("hpstdk");
                }
                if (jSONObject.has("doubt_loc_switch")) {
                    this.cv = jSONObject.optInt("doubt_loc_switch", 0);
                }
                if (jSONObject.has("doubt_loc_time")) {
                    this.cw = jSONObject.optInt("doubt_loc_time", 3600);
                }
                if (jSONObject.has("gps_pre_switch")) {
                    this.cq = jSONObject.optInt("gps_pre_switch", 1);
                }
                if (jSONObject.has("net_pre_switch")) {
                    this.cr = jSONObject.optInt("net_pre_switch", 1);
                }
                if (jSONObject.has("gps_pre_length")) {
                    this.cs = jSONObject.optInt("gps_pre_length", 5);
                }
                if (jSONObject.has("net_pre_length")) {
                    this.ct = jSONObject.optInt("net_pre_length", 5);
                }
            }
            try {
                if (jSONObject.has("iblqp")) {
                    String strOptString3 = jSONObject.optString("iblqp");
                    this.cx = strOptString3;
                    String[] strArrSplit11 = strOptString3.split(str2);
                    if (strArrSplit11.length >= 3) {
                        this.cB = Integer.parseInt(strArrSplit11[0]);
                        this.cC = Integer.parseInt(strArrSplit11[1]);
                        this.cD = Integer.parseInt(strArrSplit11[2]);
                    }
                }
            } catch (Exception unused12) {
            }
            if (jSONObject.has("miytp")) {
                this.cy = jSONObject.optInt("miytp") + 1;
            }
            if (jSONObject.has("itptn")) {
                this.cG = jSONObject.optInt("itptn ");
            }
            if (jSONObject.has("new_cl_scan_switch")) {
                this.cz = jSONObject.optInt("new_cl_scan_switch", 1);
            }
            if (jSONObject.has("new_cl_scan_time")) {
                this.cA = jSONObject.optInt("new_cl_scan_time", 100);
            }
            if (jSONObject.has("click_nlp_switch")) {
                this.cH = jSONObject.optInt("click_nlp_switch", 0);
            }
            if (jSONObject.has("irgs")) {
                this.cJ = jSONObject.optDouble("irgs");
            }
            if (jSONObject.has("pdr_indoor_switch")) {
                this.cI = jSONObject.optInt("pdr_indoor_switch", 0);
            }
            if (jSONObject.has("ilprs")) {
                this.cK = jSONObject.optInt("ilprs");
            }
            if (jSONObject.has("cell_scan_time")) {
                this.cL = jSONObject.optLong("cell_scan_time", 30000L);
            }
            if (jSONObject.has("tunnel_mobile_switch")) {
                this.cM = jSONObject.optInt("tunnel_mobile_switch", 0);
            }
            if (jSONObject.has("new_loc_cache_switch")) {
                this.cN = jSONObject.optInt("new_loc_cache_switch", 1);
            }
            if (jSONObject.has("nc_same_rate")) {
                this.cO = (float) jSONObject.optDouble("nc_same_rate", 0.8d);
            }
            if (jSONObject.has("cl_str_change_rate")) {
                this.cP = (float) jSONObject.optDouble("cl_str_change_rate", 0.2d);
            }
            if (jSONObject.has("wf_high_freq_vdr_loss")) {
                this.cQ = jSONObject.optInt("wf_high_freq_vdr_loss", 0);
            }
            if (jSONObject.has("gnssods")) {
                this.cR = jSONObject.optInt("gnssods");
            }
            if (jSONObject.has("rtdrns")) {
                this.cS = jSONObject.optInt("rtdrns");
            }
            if (jSONObject.has("vcsrps")) {
                this.cT = jSONObject.optInt("vcsrps");
            }
            if (jSONObject.has("nlp_loc_coarse")) {
                this.cU = jSONObject.optInt("nlp_loc_coarse");
            }
            if (jSONObject.has("lspfnis")) {
                this.f3406de = jSONObject.optInt("lspfnis", 1);
            }
            if (jSONObject.has("upload_ssid_switch")) {
                this.dl = jSONObject.optInt("upload_ssid_switch", 1);
            }
            if (jSONObject.has("single_ssid_length_max")) {
                this.dm = jSONObject.optInt("single_ssid_length_max", 30);
            }
            if (jSONObject.has("max_request_ssid_number")) {
                this.dn = jSONObject.optInt("max_request_ssid_number", 64);
            }
            if (jSONObject.has("fix_telephony_crash")) {
                this.f0do = jSONObject.optInt("fix_telephony_crash", 1);
            }
            if (jSONObject.has("is_monitor_index")) {
                this.dp = jSONObject.optInt("is_monitor_index", 0);
            }
            if (jSONObject.has("monitor_frequency")) {
                this.dq = jSONObject.optInt("monitor_frequency", 60000);
            }
            if (jSONObject.has("iens")) {
                this.dr = jSONObject.optInt("iens");
            }
            if (jSONObject.has("kahts")) {
                this.ds = jSONObject.optInt("kahts");
            }
            if (jSONObject.has("kahtsrtk")) {
                this.dt = jSONObject.optInt("kahtsrtk");
            }
            if (jSONObject.has("nvlyps")) {
                this.du = jSONObject.optInt("nvlyps");
            }
            if (jSONObject.has("nvlypsl")) {
                this.dv = jSONObject.optInt("nvlypsl");
            }
            if (jSONObject.has("nvlypsp")) {
                String strOptString4 = jSONObject.optString("nvlypsp");
                if (strOptString4.contains(str6)) {
                    String[] strArrSplit12 = strOptString4.split(str6);
                    if (strArrSplit12.length >= 2) {
                        this.dw = Integer.parseInt(strArrSplit12[0]);
                        this.dx = Integer.parseInt(strArrSplit12[1]);
                    }
                }
            }
            if (jSONObject.has("nvlgfs")) {
                this.dy = jSONObject.optInt("nvlgfs");
            }
            if (jSONObject.has("sppfs")) {
                this.dz = jSONObject.optInt("sppfs");
            }
            if (jSONObject.has("ipsd")) {
                this.dA = jSONObject.optString("ipsd");
            }
            if (jSONObject.has("nipvgdt")) {
                this.dB = jSONObject.optInt("nipvgdt");
            }
            if (jSONObject.has("nipvpyt")) {
                this.dC = jSONObject.optInt("nipvpyt");
            }
            if (jSONObject.has("nipvdcf")) {
                this.dD = jSONObject.optInt("nipvdcf");
            }
            if (jSONObject.has("aordrl")) {
                this.dE = jSONObject.optInt("aordrl");
            }
            if (jSONObject.has("locenc")) {
                this.dF = jSONObject.optInt("locenc");
            }
            if (jSONObject.has("ovgs")) {
                this.dG = jSONObject.optInt("ovgs", 1);
            }
            if (jSONObject.has("vgv2")) {
                this.o = jSONObject.optInt("vgv2");
            }
            if (jSONObject.has("vgwv2")) {
                this.p = jSONObject.optInt("vgwv2");
            }
            if (jSONObject.has("nrdnwsv2")) {
                this.q = jSONObject.optInt("nrdnwsv2");
            }
            if (jSONObject.has("iubs")) {
                this.dH = Integer.parseInt(jSONObject.optString("iubs", "1"));
            }
            if (jSONObject.has("iucd")) {
                this.dI = jSONObject.optInt("iucd", 0);
            }
            if (jSONObject.has("hfat")) {
                this.dJ = jSONObject.optInt("hfat", 10);
            }
            if (jSONObject.has("hmsLocNumber")) {
                this.dK = jSONObject.optInt("hmsLocNumber", 50);
            }
            if (jSONObject.has("rtkms")) {
                this.dL = jSONObject.optInt("rtkms");
            }
            if (jSONObject.has("rtkchdel")) {
                this.dM = jSONObject.optInt("rtkchdel");
            }
            if (jSONObject.has("rtkrawerr")) {
                this.dN = jSONObject.optInt("rtkrawerr");
            }
            if (jSONObject.has("rtkouterr")) {
                this.dO = jSONObject.optInt("rtkouterr");
            }
            if (jSONObject.has("sdkouterr")) {
                this.dP = jSONObject.optInt("sdkouterr");
            }
            if (jSONObject.has("rtkchaerr")) {
                this.dQ = jSONObject.optInt("rtkchaerr");
            }
            if (jSONObject.has("sdkchaerr")) {
                this.dR = jSONObject.optInt("sdkchaerr");
            }
            if (jSONObject.has("navchaerr")) {
                this.dS = jSONObject.optInt("navchaerr");
            }
            if (jSONObject.has("navpchaerr")) {
                this.dT = jSONObject.optInt("navpchaerr");
            }
            if (jSONObject.has("sdkpterr")) {
                this.dU = jSONObject.optInt("sdkpterr");
            }
            if (jSONObject.has("rtkecs")) {
                this.dV = jSONObject.optInt("rtkecs");
            }
            if (jSONObject.has("bfwtl")) {
                this.dX = jSONObject.optInt("bfwtl");
            }
            if (jSONObject.has("ocav")) {
                this.dY = jSONObject.optInt("ocav");
            }
            if (jSONObject.has("hdrs")) {
                this.dZ = jSONObject.optInt("hdrs");
            }
            if (jSONObject.has("iohd")) {
                this.eb = jSONObject.optInt("iohd", 1);
            }
            if (jSONObject.has("ulti")) {
                this.ec = jSONObject.optLong("ulti", 86400000L);
            }
            if (jSONObject.has("sfos")) {
                this.ed = jSONObject.optInt("sfos", 1);
            }
            if (jSONObject.has("csdv")) {
                this.ee = jSONObject.optInt("csdv", 30);
            }
            if (jSONObject.has("frlsi")) {
                this.ef = jSONObject.optInt("frlsi", 30);
            }
        } catch (Exception e13) {
            e13.printStackTrace();
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ex = str;
    }

    @Override // com.baidu.location.e.f
    public void a(boolean z) {
        String str;
        if (!z || (str = this.ej) == null) {
            j();
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("data")) {
                    String string = jSONObject.getString("data");
                    s.a().b("vdrconfig", "");
                    s.a().b("vdrconfig_gz", string);
                    b(true);
                } else if (!this.f3404a) {
                    c();
                    this.f3404a = true;
                }
            } catch (Exception unused) {
                if (!this.f3404a) {
                    c();
                    this.f3404a = true;
                }
            }
        }
        Map<String, Object> map = this.el;
        if (map != null) {
            map.clear();
        }
    }
}
