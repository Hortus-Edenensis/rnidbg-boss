package com.beizi.ad.internal.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.internal.d;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.e.j;
import com.beizi.ad.internal.e.k;
import com.beizi.ad.internal.e.n;
import com.beizi.ad.internal.e.p;
import com.beizi.ad.internal.e.u;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.r;
import com.beizi.ad.model.c;
import com.beizi.ad.model.f;
import com.beizi.ad.model.g;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bq;
import com.wifi.adsdk.download.LxAdDLManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"NewApi"})
public class a {
    private c.h C;
    private String D;
    private String E;
    private String F;
    private f.EnumC0131f G;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private c.b.C0128c O;
    private c.b.C0127b P;
    private int Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.beizi.ad.internal.f f4392a;
    private String aA;
    private String aB;
    private String aC;
    private String aD;
    private c.n aE;
    private String aF;
    private String aG;
    private String aH;
    private com.beizi.ad.internal.c.a aI;
    private String aa;
    private String ab;
    private String ac;
    private c.b.a ad;
    private boolean ae;
    private boolean af;
    private int ah;
    private c.b ai;
    private List<c.l> aj;
    private String ak;
    private String al;
    private String an;
    private String ao;
    private String ap;
    private String aq;
    private String av;
    private String aw;
    private String ax;
    private int ay;
    private String az;
    public String b;
    public String c;
    private String d;
    private String e;
    private f.a f;
    private String z;
    private int g = 0;
    private int h = 1;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private int s = 0;
    private int t = 0;
    private boolean u = false;
    private int v = 0;
    private C0114a w = new C0114a();
    private C0114a x = new C0114a();
    private boolean y = true;
    private boolean A = false;
    private c.e B = new c.e();
    private int H = 0;
    private int ag = -1;
    private List<Pair<e, String>> am = new LinkedList();
    private LinkedList<String> ar = new LinkedList<>();
    private HashMap<String, Object> as = new HashMap<>();
    private boolean at = false;
    private boolean au = false;
    private boolean aJ = true;

    /* JADX INFO: renamed from: com.beizi.ad.internal.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0114a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f4394a = 0;
        public static int b = 1;
        String c;
        int d = 0;

        public int b() {
            return this.d;
        }

        public String a() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            this.d = i;
        }
    }

    public a(String str, Map<String, List<String>> map, com.beizi.ad.internal.f fVar) {
        if (str == null) {
            return;
        }
        this.f4392a = fVar;
        this.aD = str;
        try {
            a(c.o.c(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        V();
    }

    private boolean W() {
        if (TextUtils.isEmpty(this.R) || TextUtils.isEmpty(this.W) || TextUtils.isEmpty(this.V) || TextUtils.isEmpty(this.Z) || TextUtils.isEmpty(this.ab)) {
            return false;
        }
        if (TextUtils.isEmpty(this.Y) && TextUtils.isEmpty(this.X)) {
            return false;
        }
        int i = this.Q;
        return i == 2 || i == 5;
    }

    private boolean X() {
        int i = this.Q;
        return i == 2 ? !TextUtils.isEmpty(this.U) && this.U.startsWith(HttpHost.DEFAULT_SCHEME_NAME) : i == 5 && !TextUtils.isEmpty(this.U) && this.U.contains("market://");
    }

    private boolean c(c.o oVar) {
        if (oVar.a() > 0) {
            c.p pVar = oVar.c().get(0);
            this.d = pVar.a();
            this.e = pVar.b();
            this.f = pVar.c();
            this.g = pVar.d();
            this.h = pVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.l = Integer.parseInt(pVar.f());
            this.k = Integer.parseInt(pVar.g());
            if (pVar.h() != null && (i() == f.a.ADP_TABLE || i() == f.a.ADP_CUSTOMER)) {
                c.g gVarH = pVar.h();
                this.i = Integer.parseInt(gVarH.a());
                this.j = Integer.parseInt(gVarH.b());
            } else if (!n.a(pVar.b()) && i() == f.a.ADP_IVIDEO) {
                a("REWARD_ITEM", pVar.b());
            }
            this.m = pVar.o();
            this.n = pVar.m();
            this.o = pVar.q();
            this.p = pVar.n();
            this.q = pVar.i();
            this.r = pVar.k();
            this.s = pVar.l();
            this.t = pVar.j();
            this.u = pVar.p();
            List<c.d> listR = pVar.r();
            if (listR != null && listR.size() > 0) {
                this.z = listR.get(0).i();
                this.D = listR.get(0).k();
                this.al = listR.get(0).b();
                this.H = listR.get(0).l();
                this.aF = listR.get(0).n();
                this.aG = listR.get(0).o();
                this.aH = listR.get(0).p();
            }
            this.C = pVar.t();
            if (this.m && this.l == 0 && this.k == 0) {
                this.l = 720;
                this.k = 1280;
            }
            if (pVar.s() > 0) {
                int i = 0;
                for (c.d dVar : pVar.r()) {
                    if (i == 0) {
                        this.al = dVar.b();
                        m.a("BeiZisAd", "mAdid = " + this.al);
                    }
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.ak = dVar.a();
                        c.C0129c c0129cE = dVar.e();
                        if (c0129cE != null) {
                            if (c0129cE.a() != null) {
                                this.w.a(c0129cE.a());
                                this.w.a(C0114a.f4394a);
                            } else {
                                this.w.a(c0129cE.b());
                                this.w.a(C0114a.b);
                            }
                            if (c0129cE.c() != null) {
                                this.x.a(c0129cE.c());
                                this.x.a(C0114a.f4394a);
                            } else {
                                this.x.a(c0129cE.d());
                                this.x.a(C0114a.b);
                            }
                        }
                        if (dVar.d() > 0) {
                            for (c.a aVar : dVar.f()) {
                                if (this.n) {
                                    for (int i2 = 0; i2 < aVar.d(); i2++) {
                                        if (!n.a(aVar.c().get(i2).a())) {
                                            this.ar.add(aVar.c().get(i2).b());
                                        }
                                    }
                                }
                                a(aVar.b());
                                b(aVar);
                                if ((aVar.a() == f.EnumC0131f.RENDER_VIDEO || aVar.a() == f.EnumC0131f.RENDER_VAST_VIDEO) && aVar.d() > 0) {
                                    this.am.add(Pair.create(e.VIDEO, aVar.c().get(0).b()));
                                } else {
                                    String strA = a(aVar);
                                    this.am.add(Pair.create(e.HTML, strA));
                                    if (strA.contains("mraid.js")) {
                                        a("MRAID", Boolean.TRUE);
                                    }
                                }
                            }
                        }
                        if (dVar.c() != null) {
                            c.b bVarC = dVar.c();
                            a(bVarC);
                            this.ao = bVarC.a();
                            this.aq = bVarC.h();
                            if (this.f4392a == com.beizi.ad.internal.f.REWARDEDVIDEO) {
                                this.ap = bVarC.b();
                            } else {
                                this.ap = Uri.decode(bVarC.b());
                            }
                            c.l lVarI = bVarC.i();
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.a())) {
                                this.b = lVarI.a();
                            }
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.b())) {
                                this.c = lVarI.b();
                            }
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.c())) {
                                this.an = lVarI.c();
                            }
                        }
                        c.e eVarJ = dVar.j();
                        if (eVarJ != null) {
                            this.B.a(eVarJ.a());
                            this.B.a(eVarJ.b());
                            this.B.b(eVarJ.c());
                        }
                    }
                    i++;
                    if (!this.am.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (this.am.isEmpty()) {
            return false;
        }
        this.at = true;
        return true;
    }

    private boolean d(c.o oVar) {
        if (oVar.a() > 0) {
            for (c.p pVar : oVar.c()) {
                this.n = pVar.m();
                if (pVar.s() > 0) {
                    for (c.d dVar : pVar.r()) {
                        if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                            if (dVar.d() > 0) {
                                for (c.a aVar : dVar.f()) {
                                    if (this.n) {
                                        for (int i = 0; i < aVar.d(); i++) {
                                            if (!n.a(aVar.c().get(i).a())) {
                                                this.ar.add(aVar.c().get(i).b());
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
        if (this.ar.isEmpty()) {
            return false;
        }
        this.at = true;
        return true;
    }

    private boolean e(c.o oVar) {
        if (oVar.a() > 0) {
            c.p pVar = oVar.c().get(0);
            this.d = pVar.a();
            this.e = pVar.b();
            this.f = pVar.c();
            this.g = pVar.d();
            this.h = pVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.l = Integer.parseInt(pVar.f());
            this.k = Integer.parseInt(pVar.g());
            List<c.d> listR = pVar.r();
            if (listR != null && listR.size() > 0) {
                this.z = listR.get(0).i();
                this.D = listR.get(0).k();
                this.al = listR.get(0).b();
                this.H = listR.get(0).l();
                this.aF = listR.get(0).n();
                this.aG = listR.get(0).o();
                this.aH = listR.get(0).p();
            }
            this.C = pVar.t();
            this.m = pVar.o();
            this.n = pVar.m();
            this.o = pVar.q();
            this.p = pVar.n();
            this.q = pVar.i();
            this.r = pVar.k();
            this.s = pVar.l();
            this.t = pVar.j();
            this.u = pVar.p();
            if (this.m && this.l == 0 && this.k == 0) {
                this.l = 720;
                this.k = 1280;
            }
            if (pVar.s() > 0) {
                for (c.d dVar : pVar.r()) {
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.ak = dVar.a();
                        if (dVar.d() >= 0) {
                            for (c.a aVar : dVar.f()) {
                                if (this.n) {
                                    for (int i = 0; i < aVar.d(); i++) {
                                        if (!n.a(aVar.c().get(i).a())) {
                                            this.ar.add(aVar.c().get(i).b());
                                        }
                                    }
                                }
                                if (aVar.a() == f.EnumC0131f.RENDER_JSON && aVar.d() > 0) {
                                    try {
                                        c.C0129c c0129cE = dVar.e();
                                        if (c0129cE != null) {
                                            if (c0129cE.a() != null) {
                                                this.w.a(c0129cE.a());
                                                this.w.a(C0114a.f4394a);
                                            } else {
                                                this.w.a(c0129cE.b());
                                                this.w.a(C0114a.b);
                                            }
                                            if (c0129cE.c() != null) {
                                                this.x.a(c0129cE.c());
                                                this.x.a(C0114a.f4394a);
                                            } else {
                                                this.x.a(c0129cE.d());
                                                this.x.a(C0114a.b);
                                            }
                                        }
                                        com.beizi.ad.internal.c.a aVarA = com.beizi.ad.internal.c.a.a(new JSONObject(aVar.b()));
                                        this.aI = aVarA;
                                        aVarA.b(k());
                                        this.aI.a(j());
                                        this.F = this.aI.b();
                                        if (dVar.c() != null) {
                                            a(dVar.c());
                                            c.b bVarC = dVar.c();
                                            this.ao = bVarC.a();
                                            this.ap = bVarC.b();
                                            this.aq = bVarC.h();
                                            this.aI.b(!n.a(this.ao) ? this.ao : this.aq);
                                            this.aI.c(this.ap);
                                            this.aI.a(dVar.c());
                                            c.l lVarI = bVarC.i();
                                            if (lVarI != null && !TextUtils.isEmpty(lVarI.a())) {
                                                this.aI.d(lVarI.a());
                                            }
                                            if (lVarI != null && !TextUtils.isEmpty(lVarI.b())) {
                                                this.aI.e(lVarI.b());
                                            }
                                            List<c.l> listL = bVarC.l();
                                            if (listL != null && listL.size() > 0) {
                                                for (int i2 = 0; i2 < listL.size(); i2++) {
                                                    String strB = listL.get(i2).b();
                                                    if (!TextUtils.isEmpty(strB)) {
                                                        this.aI.e(strB);
                                                    }
                                                    String strA = listL.get(i2).a();
                                                    if (!TextUtils.isEmpty(strA)) {
                                                        this.aI.d(strA);
                                                    }
                                                }
                                            }
                                        }
                                        c.e eVarJ = dVar.j();
                                        if (eVarJ != null) {
                                            this.B.a(eVarJ.a());
                                            this.B.a(eVarJ.b());
                                            this.B.b(eVarJ.c());
                                        }
                                    } catch (JSONException unused) {
                                    }
                                    if (this.aI != null) {
                                        this.at = true;
                                        return true;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        if (this.am.isEmpty()) {
            return false;
        }
        this.at = true;
        return true;
    }

    private boolean f(c.o oVar) {
        if (oVar.a() > 0) {
            c.p pVar = oVar.c().get(0);
            this.d = pVar.a();
            this.e = pVar.b();
            this.f = pVar.c();
            this.g = pVar.d();
            this.h = pVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.l = Integer.parseInt(pVar.f());
            this.k = Integer.parseInt(pVar.g());
            if (pVar.h() != null && (i() == f.a.ADP_TABLE || i() == f.a.ADP_CUSTOMER)) {
                c.g gVarH = pVar.h();
                this.i = Integer.parseInt(gVarH.a());
                this.j = Integer.parseInt(gVarH.b());
            } else if (!n.a(pVar.b()) && i() == f.a.ADP_IVIDEO) {
                a("REWARD_ITEM", pVar.b());
            }
            this.m = pVar.o();
            this.n = pVar.m();
            this.o = pVar.q();
            this.p = pVar.n();
            this.q = pVar.i();
            this.r = pVar.k();
            this.s = pVar.l();
            this.t = pVar.j();
            this.u = pVar.p();
            List<c.d> listR = pVar.r();
            if (listR != null && listR.size() > 0) {
                this.z = listR.get(0).i();
                this.D = listR.get(0).k();
                this.al = listR.get(0).b();
                this.H = listR.get(0).l();
                this.aF = listR.get(0).n();
                this.aG = listR.get(0).o();
                this.aH = listR.get(0).p();
            }
            this.C = pVar.t();
            if (this.m && this.l == 0 && this.k == 0) {
                this.l = 720;
                this.k = 1280;
            }
            if (pVar.s() > 0) {
                int i = 0;
                for (c.d dVar : pVar.r()) {
                    if (i == 0) {
                        this.al = dVar.b();
                        m.a("BeiZisAd", "mAdid = " + this.al);
                    }
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.ak = dVar.a();
                        c.C0129c c0129cE = dVar.e();
                        if (c0129cE != null) {
                            if (c0129cE.a() != null) {
                                this.w.a(c0129cE.a());
                                this.w.a(C0114a.f4394a);
                            } else {
                                this.w.a(c0129cE.b());
                                this.w.a(C0114a.b);
                            }
                            if (c0129cE.c() != null) {
                                this.x.a(c0129cE.c());
                                this.x.a(C0114a.f4394a);
                            } else {
                                this.x.a(c0129cE.d());
                                this.x.a(C0114a.b);
                            }
                        }
                        if (dVar.d() > 0) {
                            for (c.a aVar : dVar.f()) {
                                if (this.n) {
                                    for (int i2 = 0; i2 < aVar.d(); i2++) {
                                        if (!n.a(aVar.c().get(i2).a())) {
                                            this.ar.add(aVar.c().get(i2).b());
                                        }
                                    }
                                }
                                a(aVar.b());
                                this.G = aVar.a();
                                if (aVar.d() > 0) {
                                    this.F = aVar.c().get(0).b();
                                }
                            }
                        }
                        if (dVar.c() != null) {
                            c.b bVarC = dVar.c();
                            a(bVarC);
                            this.ao = bVarC.a();
                            this.aq = bVarC.h();
                            if (this.f4392a == com.beizi.ad.internal.f.REWARDEDVIDEO) {
                                this.ap = bVarC.b();
                            } else {
                                this.ap = Uri.decode(bVarC.b());
                            }
                            c.l lVarI = bVarC.i();
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.a())) {
                                this.b = lVarI.a();
                            }
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.b())) {
                                this.c = lVarI.b();
                            }
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.c())) {
                                this.an = lVarI.c();
                            }
                        }
                        c.e eVarJ = dVar.j();
                        if (eVarJ != null) {
                            this.B.a(eVarJ.a());
                            this.B.a(eVarJ.b());
                            this.B.b(eVarJ.c());
                        }
                    }
                    i++;
                    if (!TextUtils.isEmpty(this.F)) {
                        break;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.F)) {
            return false;
        }
        this.at = true;
        return true;
    }

    public boolean A() {
        return TextUtils.isEmpty(this.ap) && W() && X();
    }

    public Map B() {
        if (this.B == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("forceUnreal", Boolean.valueOf(this.B.a()));
        if (this.B.b() > 0.0d) {
            map.put("maxAcc", Double.valueOf(this.B.b()));
        }
        if (this.B.c() > 0.0d) {
            map.put("angle", Double.valueOf(this.B.c()));
        }
        return map;
    }

    public String C() {
        try {
            JSONObject jSONObject = new JSONObject();
            c.h hVar = this.C;
            if (hVar != null) {
                jSONObject.put("raiseSortPrice", hVar.a());
                jSONObject.put("effectRate", this.C.b());
                jSONObject.put("auctionType", this.C.c());
                jSONObject.put("isLastLook", this.C.d());
                jSONObject.put("winPriceMin", this.C.e());
                jSONObject.put("winPriceMax", this.C.f());
                jSONObject.put(az.u, this.C.g());
            } else {
                jSONObject.put("raiseSortPrice", -1);
                jSONObject.put("effectRate", -1);
                jSONObject.put("auctionType", -1);
                jSONObject.put("isLastLook", -1);
                jSONObject.put("winPriceMin", "");
                jSONObject.put("winPriceMax", "");
                jSONObject.put(az.u, "");
            }
            try {
                if (!TextUtils.isEmpty(this.D)) {
                    jSONObject.put("secondPrice", Integer.parseInt(this.D));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return com.beizi.ad.lance.a.a.a(l.a(), com.beizi.ad.internal.e.c.a(jSONObject.toString()));
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public String D() {
        return this.F;
    }

    public f.EnumC0131f E() {
        return this.G;
    }

    public String F() {
        return this.aC;
    }

    public int G() {
        return this.H;
    }

    public String H() {
        return this.aD;
    }

    public String I() {
        return this.aA;
    }

    public int J() {
        return this.ay;
    }

    public c.n K() {
        return this.aE;
    }

    public String L() {
        return this.aF;
    }

    public String M() {
        return this.ap;
    }

    public String N() {
        return this.ao;
    }

    public String O() {
        return this.U;
    }

    public String P() {
        c.b bVar = this.ai;
        if (bVar == null) {
            return null;
        }
        return bVar.u();
    }

    public String Q() {
        c.b bVar = this.ai;
        if (bVar == null) {
            return null;
        }
        return bVar.v();
    }

    public String R() {
        return this.aG;
    }

    public String S() {
        return this.aH;
    }

    public boolean T() {
        return this.ae;
    }

    public boolean U() {
        return this.ah == 1;
    }

    public void a(boolean z) {
    }

    public void b(Map map) {
    }

    public int g() {
        return this.s;
    }

    public int h() {
        return this.t;
    }

    public f.a i() {
        return this.f;
    }

    public C0114a j() {
        return this.w;
    }

    public C0114a k() {
        return this.x;
    }

    public String l() {
        return this.R;
    }

    public String m() {
        return this.S;
    }

    public String n() {
        return this.V;
    }

    public String o() {
        return this.W;
    }

    public String p() {
        return this.X;
    }

    public String q() {
        return this.Y;
    }

    public String r() {
        return this.Z;
    }

    public String s() {
        return this.ab;
    }

    public int t() {
        return this.Q;
    }

    public String u() {
        return this.av;
    }

    public String v() {
        return this.aw;
    }

    public String w() {
        return this.az;
    }

    public String x() {
        return this.ax;
    }

    public boolean y() {
        return !TextUtils.isEmpty(this.ax);
    }

    public String z() {
        return this.aB;
    }

    private boolean g(c.o oVar) {
        if (oVar.a() > 0) {
            c.p pVar = oVar.c().get(0);
            this.d = pVar.a();
            this.e = pVar.b();
            this.f = pVar.c();
            this.g = pVar.d();
            this.h = pVar.e() == f.h.PORTRAIT ? 1 : 2;
            this.l = Integer.parseInt(pVar.f());
            this.k = Integer.parseInt(pVar.g());
            if (pVar.h() != null && (i() == f.a.ADP_TABLE || i() == f.a.ADP_CUSTOMER)) {
                c.g gVarH = pVar.h();
                this.i = Integer.parseInt(gVarH.a());
                this.j = Integer.parseInt(gVarH.b());
            } else if (!n.a(pVar.b()) && i() == f.a.ADP_IVIDEO) {
                a("REWARD_ITEM", pVar.b());
            }
            this.m = pVar.o();
            this.n = pVar.m();
            this.o = pVar.q();
            this.p = pVar.n();
            this.q = pVar.i();
            this.r = pVar.k();
            this.s = pVar.l();
            this.t = pVar.j();
            this.u = pVar.p();
            List<c.d> listR = pVar.r();
            if (listR != null && listR.size() > 0) {
                this.z = listR.get(0).i();
                this.D = listR.get(0).k();
                this.al = listR.get(0).b();
                this.H = listR.get(0).l();
                this.aF = listR.get(0).n();
                this.aG = listR.get(0).o();
                this.aH = listR.get(0).p();
            }
            this.C = pVar.t();
            if (this.m && this.l == 0 && this.k == 0) {
                this.l = 720;
                this.k = 1280;
            }
            if (pVar.s() > 0) {
                int i = 0;
                for (c.d dVar : pVar.r()) {
                    if (i == 0) {
                        this.al = dVar.b();
                        m.a("BeiZisAd", "mAdid = " + this.al);
                    }
                    if (dVar.h() <= 0 || dVar.g().get(0) == null) {
                        this.ak = dVar.a();
                        c.C0129c c0129cE = dVar.e();
                        if (c0129cE != null) {
                            if (c0129cE.a() != null) {
                                this.w.a(c0129cE.a());
                                this.w.a(C0114a.f4394a);
                            } else {
                                this.w.a(c0129cE.b());
                                this.w.a(C0114a.b);
                            }
                            if (c0129cE.c() != null) {
                                this.x.a(c0129cE.c());
                                this.x.a(C0114a.f4394a);
                            } else {
                                this.x.a(c0129cE.d());
                                this.x.a(C0114a.b);
                            }
                        }
                        if (dVar.d() > 0) {
                            for (c.a aVar : dVar.f()) {
                                if (this.n) {
                                    for (int i2 = 0; i2 < aVar.d(); i2++) {
                                        if (!n.a(aVar.c().get(i2).a())) {
                                            this.ar.add(aVar.c().get(i2).b());
                                        }
                                    }
                                }
                                b(aVar.b());
                            }
                        }
                        if (dVar.c() != null) {
                            c.b bVarC = dVar.c();
                            a(bVarC);
                            this.ao = bVarC.a();
                            this.aq = bVarC.h();
                            if (this.f4392a == com.beizi.ad.internal.f.REWARDEDVIDEO) {
                                this.ap = bVarC.b();
                            } else {
                                this.ap = Uri.decode(bVarC.b());
                            }
                            c.l lVarI = bVarC.i();
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.a())) {
                                this.b = lVarI.a();
                            }
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.b())) {
                                this.c = lVarI.b();
                            }
                            if (lVarI != null && !TextUtils.isEmpty(lVarI.c())) {
                                this.an = lVarI.c();
                            }
                        }
                        c.e eVarJ = dVar.j();
                        if (eVarJ != null) {
                            this.B.a(eVarJ.a());
                            this.B.a(eVarJ.b());
                            this.B.b(eVarJ.c());
                        }
                        this.aE = dVar.m();
                    }
                    i++;
                    if (!this.am.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.ax) && TextUtils.isEmpty(this.aA)) {
            return false;
        }
        this.at = true;
        return true;
    }

    public void b(boolean z) {
        this.A = z;
    }

    private void a(c.b bVar) {
        this.ai = bVar;
        this.aj = bVar.l();
        this.O = bVar.k();
        this.P = bVar.j();
        this.Q = bVar.c();
        this.R = bVar.d();
        this.S = bVar.e();
        this.T = bVar.f();
        this.U = bVar.g();
        if (TextUtils.isEmpty(this.S)) {
            this.S = "lance";
        }
        if (TextUtils.isEmpty(this.R)) {
            this.R = "BeiZi";
        }
        if (TextUtils.isEmpty(this.T)) {
            this.T = "Ad Download";
        }
        this.V = bVar.m();
        this.W = bVar.n();
        this.X = bVar.o();
        this.Y = bVar.p();
        this.Z = bVar.q();
        this.aa = bVar.r();
        this.ab = bVar.s();
        c.b.a aVarT = bVar.t();
        this.ad = aVarT;
        if (aVarT != null) {
            if (aVarT.a() == 1) {
                this.ae = true;
            }
            if (this.ad.b() == 1) {
                this.af = true;
            }
            this.ah = this.ad.c();
        }
    }

    private boolean b(c.o oVar) {
        return oVar.b() == 0;
    }

    public String b() {
        return this.z;
    }

    private void b(final Context context) {
        if (context == null) {
            return;
        }
        com.beizi.ad.internal.c.a().a(new com.beizi.ad.internal.a() { // from class: com.beizi.ad.internal.d.a.1
            @Override // com.beizi.ad.internal.a
            public void a() {
                try {
                    if (a.this.P != null) {
                        k.a(a.this.P.f());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.beizi.ad.internal.a
            public void b() {
                try {
                    if (a.this.aJ) {
                        if (a.this.P != null) {
                            k.a(a.this.P.j());
                        }
                        a.this.c(context);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Uri uri = Uri.parse(this.ap);
        if (uri.getScheme() != null && uri.getScheme().equals("bzopen") && !TextUtils.isEmpty(uri.getHost()) && uri.getPathSegments().size() > 0) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.LAUNCHER");
            String queryParameter = uri.getQueryParameter(bq.f.z);
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                        intent.setFlags(Integer.parseInt(queryParameter));
                    } else {
                        intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            intent.setComponent(new ComponentName(uri.getHost(), uri.getPathSegments().get(0)));
            String queryParameter2 = uri.getQueryParameter("rect");
            if (!TextUtils.isEmpty(queryParameter2)) {
                try {
                    String[] strArrSplit = queryParameter2.split(":");
                    if (strArrSplit.length == 4) {
                        Rect rect = new Rect();
                        rect.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
                        intent.setSourceBounds(rect);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            context.startActivity(intent);
            return;
        }
        if (this.ap.startsWith("hwpps://landingpage")) {
            Intent intent2 = new Intent();
            intent2.setData(uri);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
            return;
        }
        if (this.ap.startsWith(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
            Intent uri2 = null;
            try {
                uri2 = Intent.parseUri(this.ap, 1);
                uri2.addFlags(268435456);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            context.startActivity(uri2);
            return;
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", uri);
        intent3.addFlags(805339136);
        context.startActivity(intent3);
    }

    public boolean d() {
        return this.at;
    }

    private void V() {
    }

    private boolean d(Context context) {
        c.b bVar = this.ai;
        if (bVar == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (bVar.y() == 0) {
            return false;
        }
        String strU = this.ai.u();
        String strV = this.ai.v();
        String strW = this.ai.w();
        if (!TextUtils.isEmpty(strU) && !TextUtils.isEmpty(strV)) {
            return r.a(context, strU, strV, strW);
        }
        String strX = this.ai.x();
        if (!TextUtils.isEmpty(strX)) {
            return r.a(context, strX);
        }
        return false;
    }

    public void d(View view, String str) {
        c.b bVar;
        List<c.l> listL;
        String strG;
        if (this.L || (bVar = this.ai) == null || (listL = bVar.l()) == null) {
            return;
        }
        this.L = true;
        for (int i = 0; i < listL.size(); i++) {
            c.l lVar = listL.get(i);
            if (lVar != null && !TextUtils.isEmpty(lVar.g()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strG = lVar.g().replace("__REQUESTUUID__", str);
                } else {
                    strG = lVar.g();
                }
                if (this.I) {
                    strG = strG.replace(g.b, "1");
                }
                new d(n.a(0, view, strG)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    private void a(c.o oVar) {
        if (b(oVar)) {
            com.beizi.ad.internal.f fVar = this.f4392a;
            if (fVar == com.beizi.ad.internal.f.PREFETCH) {
                d(oVar);
                return;
            }
            if (fVar == com.beizi.ad.internal.f.NEW_SPLASH) {
                f(oVar);
                return;
            }
            if (fVar == com.beizi.ad.internal.f.REWARDEDVIDEO) {
                g(oVar);
            } else if (fVar != com.beizi.ad.internal.f.NATIVE) {
                c(oVar);
            } else {
                e(oVar);
            }
        }
    }

    public void d(boolean z) {
        try {
            this.aJ = z;
            com.beizi.ad.internal.c.a aVar = this.aI;
            if (aVar != null) {
                aVar.b(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String a(c.a aVar) {
        if (aVar.a() != f.EnumC0131f.RENDER_H5 && aVar.a() != f.EnumC0131f.RENDER_PIC) {
            return "";
        }
        if (aVar.a() == f.EnumC0131f.RENDER_PIC && aVar.d() > 0) {
            return "<!DOCTYPE html>\n<html lang=\"en\" style=\"width: 100%; height: 100%;\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" id=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1\">\n    <title>Document</title>\n</head>\n<body style=\"width: 100%; height: 100%; padding: 0; margin: 0;\">\n<img style=\"width: 100%; height: 100%\" src=\"__IMAGE_SRC_PATH__\" alt=\"\"/>\n</body>\n</html><!DOCTYPE html>".replace("__IMAGE_SRC_PATH__", aVar.c().get(0).b());
        }
        Matcher matcher = Pattern.compile("\\{(\\d+)\\.value\\}").matcher(aVar.b());
        HashMap map = new HashMap();
        for (int i = 0; i < aVar.d(); i++) {
            map.put(Integer.valueOf(i), aVar.c().get(i).b());
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            Integer numValueOf = Integer.valueOf(Integer.parseInt(matcher.group(1)));
            if (map.get(numValueOf) != null) {
                matcher.appendReplacement(stringBuffer, (String) map.get(numValueOf));
            } else {
                matcher.appendReplacement(stringBuffer, "");
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private void b(c.a aVar) {
        List<c.f> listC;
        c.f fVar;
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.a() != f.EnumC0131f.RENDER_PIC || (listC = aVar.c()) == null || listC.size() == 0 || (fVar = listC.get(0)) == null) {
                return;
            }
            this.aC = fVar.b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("title")) {
                    this.av = j.c(jSONObject, "title");
                }
                if (jSONObject.has(LxAdDLManager.ITEM_DESC)) {
                    this.aw = j.c(jSONObject, LxAdDLManager.ITEM_DESC);
                }
                if (jSONObject.has("appIcon")) {
                    this.aB = j.c(jSONObject, "appIcon");
                }
                if (jSONObject.has("lauchImageUrl")) {
                    this.aA = j.c(jSONObject, "lauchImageUrl");
                }
                if (jSONObject.has("videoUrl")) {
                    this.ax = j.c(jSONObject, "videoUrl");
                }
                if (jSONObject.has(az.bb)) {
                    this.ay = j.d(jSONObject, az.bb);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public com.beizi.ad.e a() {
        return this.aI;
    }

    public void a(String str, Object obj) {
        this.as.put(str, obj);
    }

    public void a(View view, String str) {
        List<c.l> listL;
        String strA;
        int i = this.v;
        if (i <= 0) {
            this.v = i + 1;
            if (!n.a(this.b)) {
                if (!TextUtils.isEmpty(this.E)) {
                    this.b = this.c.replace(g.f4516a, this.E);
                }
                if (this.I) {
                    this.b = this.c.replace(g.b, "1");
                }
                this.b = p.a(this.b, "", "", "", "", "", "", "");
                new d(this.b).execute(new Void[0]);
                this.b = "";
            }
            c.b bVar = this.ai;
            if (bVar == null || (listL = bVar.l()) == null) {
                return;
            }
            for (int i2 = 0; i2 < listL.size(); i2++) {
                c.l lVar = listL.get(i2);
                if (lVar != null && !TextUtils.isEmpty(lVar.a()) && view != null) {
                    if (!TextUtils.isEmpty(str)) {
                        strA = lVar.a().replace("__REQUESTUUID__", str);
                    } else {
                        strA = lVar.a();
                    }
                    if (!TextUtils.isEmpty(this.E)) {
                        strA = strA.replace(g.f4516a, this.E);
                    }
                    if (this.I) {
                        strA = strA.replace(g.b, "1");
                    }
                    new d(n.a(0, view, strA)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
                }
            }
        }
    }

    public void b(View view, String str) {
        c.b bVar;
        List<c.l> listL;
        String strD;
        if (this.J || (bVar = this.ai) == null || (listL = bVar.l()) == null) {
            return;
        }
        this.J = true;
        for (int i = 0; i < listL.size(); i++) {
            c.l lVar = listL.get(i);
            if (lVar != null && !TextUtils.isEmpty(lVar.d()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strD = lVar.d().replace("__REQUESTUUID__", str);
                } else {
                    strD = lVar.d();
                }
                if (this.I) {
                    strD = strD.replace(g.b, "1");
                }
                new d(n.a(0, view, strD)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        View rootView;
        String strA;
        m.a("BeiZisAd", "handleClick========" + z);
        Context context = null;
        if (!z) {
            if (!n.a(this.c)) {
                String strA2 = p.a(this.c, str, str2, str3, str4, str5, str6, "");
                this.c = strA2;
                if (this.I) {
                    this.c = strA2.replace(g.b, "1");
                }
                new d(this.c).execute(new Void[0]);
                this.c = "";
            }
            if (this.ai != null && this.aj != null) {
                for (int i = 0; i < this.aj.size(); i++) {
                    c.l lVar = this.aj.get(i);
                    if (lVar != null && !TextUtils.isEmpty(lVar.b())) {
                        if (!TextUtils.isEmpty(str7)) {
                            strA = p.a(lVar.b(), str, str2, str3, str4, str5, str6, "").replace("__REQUESTUUID__", str7);
                        } else {
                            strA = p.a(lVar.b(), str, str2, str3, str4, str5, str6, "");
                        }
                        if (this.I) {
                            strA = strA.replace(g.b, "1");
                        }
                        new d(n.a(view, strA)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
                    }
                }
                this.aj = null;
            }
        }
        m.a("BeiZisAd", "mDeepLinkUrl:" + this.ap + ",appDownloadURL = " + this.U + ",mLandingPageUrl = " + this.ao);
        if (view != null) {
            try {
                context = view.getContext();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!(context instanceof Activity) && view != null && view.getRootView() != null && (rootView = view.getRootView()) != null) {
            context = rootView.getContext();
        }
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.ap)) {
            try {
                if (!com.beizi.ad.lance.a.k.a(context, this.ap) && !h.a(context, this.S) && !this.ap.startsWith("hwpps://landingpage") && !this.ap.startsWith(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK) && !this.ap.startsWith("hap://")) {
                    c.b.C0127b c0127b = this.P;
                    if (c0127b != null) {
                        k.a(c0127b.i());
                    }
                    a(context);
                    return;
                }
                c.b.C0127b c0127b2 = this.P;
                if (c0127b2 != null) {
                    k.a(c0127b2.h());
                }
                b(context);
                c.b.C0127b c0127b3 = this.P;
                if (c0127b3 != null) {
                    k.a(c0127b3.e());
                    return;
                }
                return;
            } catch (Exception unused) {
                c.b.C0127b c0127b4 = this.P;
                if (c0127b4 != null) {
                    k.a(c0127b4.g());
                }
                a(context);
                return;
            }
        }
        a(context);
    }

    public boolean f() {
        return this.q;
    }

    public boolean e() {
        return this.p;
    }

    public void f(View view, String str) {
        c.b bVar;
        List<c.l> listL;
        String strE;
        if (this.N || (bVar = this.ai) == null || (listL = bVar.l()) == null) {
            return;
        }
        this.N = true;
        for (int i = 0; i < listL.size(); i++) {
            c.l lVar = listL.get(i);
            if (lVar != null && !TextUtils.isEmpty(lVar.e()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strE = lVar.e().replace("__REQUESTUUID__", str);
                } else {
                    strE = lVar.e();
                }
                if (this.I) {
                    strE = strE.replace(g.b, "1");
                }
                new d(n.a(0, view, strE)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    public void e(View view, String str) {
        c.b bVar;
        List<c.l> listL;
        String strH;
        if (this.M || (bVar = this.ai) == null || (listL = bVar.l()) == null) {
            return;
        }
        this.M = true;
        for (int i = 0; i < listL.size(); i++) {
            c.l lVar = listL.get(i);
            if (lVar != null && !TextUtils.isEmpty(lVar.h()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strH = lVar.h().replace("__REQUESTUUID__", str);
                } else {
                    strH = lVar.h();
                }
                if (this.I) {
                    strH = strH.replace(g.b, "1");
                }
                new d(n.a(0, view, strH)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    public String c() {
        return this.al;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        if (context == null || d(context) || TextUtils.isEmpty(this.ao) || !this.ao.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            return;
        }
        try {
            if (this.y) {
                Class clsA = AdActivity.a();
                try {
                    WebView webView = new WebView(new MutableContextWrapper(context));
                    u.a(webView);
                    webView.loadUrl(this.ao, com.beizi.ad.lance.a.j.a());
                    com.beizi.ad.internal.activity.a.f4370a.add(webView);
                    Intent intent = new Intent(com.beizi.ad.internal.c.a().c(), (Class<?>) clsA);
                    intent.setFlags(268435456);
                    intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                    intent.putExtra("ACTIVITY_CAN_JUMP", this.ae);
                    intent.putExtra("ACTIVITY_CAN_DOWNLOAD", W());
                    if (!TextUtils.isEmpty(this.ap)) {
                        intent.putExtra("deeplinkUrl", this.ap);
                        intent.putExtra("webDeepLink", this.ah);
                    }
                    context.startActivity(intent);
                    return;
                } catch (ActivityNotFoundException unused) {
                    com.beizi.ad.internal.activity.a.f4370a.remove();
                    return;
                }
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(this.ao)));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        } catch (Exception unused2) {
        }
    }

    public void c(boolean z) {
        this.I = z;
    }

    public void c(View view, String str) {
        c.b bVar;
        List<c.l> listL;
        String strF;
        if (this.K || (bVar = this.ai) == null || (listL = bVar.l()) == null) {
            return;
        }
        this.K = true;
        for (int i = 0; i < listL.size(); i++) {
            c.l lVar = listL.get(i);
            if (lVar != null && !TextUtils.isEmpty(lVar.f()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strF = lVar.f().replace("__REQUESTUUID__", str);
                } else {
                    strF = lVar.f();
                }
                if (this.I) {
                    strF = strF.replace(g.b, "1");
                }
                new d(n.a(0, view, strF)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }

    private void a(Context context) {
        try {
            if (W() && X()) {
                int i = this.Q;
                if (i == 2) {
                    if (h.a(context, this.S)) {
                        h.b(context, this.S);
                        c.b.C0127b c0127b = this.P;
                        if (c0127b != null) {
                            k.a(c0127b.a());
                            return;
                        }
                        return;
                    }
                    a(context, 1);
                    return;
                }
                if (i == 5) {
                    if (com.beizi.ad.lance.a.k.a(context, this.U)) {
                        if (!this.af && this.ag != 0) {
                            a(context, 2);
                            return;
                        }
                        a(this.U, context);
                        c.b.C0127b c0127b2 = this.P;
                        if (c0127b2 != null) {
                            k.a(c0127b2.a());
                            return;
                        }
                        return;
                    }
                    c(context);
                    return;
                }
                return;
            }
            c(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(Context context, int i) {
        try {
            File fileA = h.a(context);
            String absolutePath = fileA != null ? fileA.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.U, this.S + com.huawei.hms.ads.dynamicloader.b.b, this.S, absolutePath, this.R, this.T, context.getPackageName() + ".fileprovider", this.P, this.V, this.W, this.X, this.Y, this.Z, this.aa, this.ab);
            apkBean.setFileMD5(this.ac);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i);
            bundle.putBoolean("isCanJump", this.ae);
            bundle.putBoolean("isDownload", W());
            if (i == 2) {
                c.b.C0127b c0127b = this.P;
                if (c0127b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0127b.a());
                }
                bundle.putString("landingPageUrl", this.ao);
            }
            if (!TextUtils.isEmpty(this.ap)) {
                bundle.putString("deeplinkUrl", this.ap);
                bundle.putInt("webDeepLink", this.ah);
            }
            Intent intent = new Intent(context, (Class<?>) BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    public void a(View view, com.beizi.ad.model.d dVar, String str, String str2, boolean z, String str3, int i) {
        String strA;
        m.a("BeiZisAd", "handleClick========" + z);
        this.ag = i;
        Context context = null;
        if (!z) {
            if (!n.a(this.c)) {
                this.c = p.a(this.c, dVar, str, str2, "", i);
                new d(this.c).execute(new Void[0]);
                this.c = "";
            }
            if (this.ai != null && this.aj != null) {
                for (int i2 = 0; i2 < this.aj.size(); i2++) {
                    c.l lVar = this.aj.get(i2);
                    if (lVar != null && !TextUtils.isEmpty(lVar.b())) {
                        if (!TextUtils.isEmpty(str3)) {
                            strA = p.a(lVar.b(), dVar, str, str2, "", i).replace("__REQUESTUUID__", str3);
                        } else {
                            strA = p.a(lVar.b(), dVar, str, str2, "", i);
                        }
                        if (this.I) {
                            strA = strA.replace(g.b, "1");
                        }
                        new d(n.a(view, strA)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
                    }
                }
                this.aj = null;
            }
        }
        m.a("BeiZisAd", "mDeepLinkUrl:" + this.ap + ",appDownloadURL = " + this.U + ",mLandingPageUrl = " + this.ao);
        if (view != null) {
            try {
                context = view.getContext();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        m.a("BeiZisAd", "context:" + context + "; flag =" + (context instanceof Activity));
        if (!(context instanceof Activity) && view != null && view.getRootView() != null) {
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            m.a("BeiZisAd", " rootView context:" + context + "; flag =" + (context instanceof Activity));
        }
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.ap)) {
            try {
                if (!com.beizi.ad.lance.a.k.a(context, this.ap) && !h.a(context, this.S) && !this.ap.startsWith("hwpps://landingpage") && !this.ap.startsWith(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK) && !this.ap.startsWith("hap://")) {
                    c.b.C0127b c0127b = this.P;
                    if (c0127b != null) {
                        k.a(c0127b.i());
                    }
                    a(context);
                    return;
                }
                c.b.C0127b c0127b2 = this.P;
                if (c0127b2 != null) {
                    k.a(c0127b2.h());
                }
                b(context);
                c.b.C0127b c0127b3 = this.P;
                if (c0127b3 != null) {
                    k.a(c0127b3.e());
                    return;
                }
                return;
            } catch (Exception unused) {
                c.b.C0127b c0127b4 = this.P;
                if (c0127b4 != null) {
                    k.a(c0127b4.g());
                }
                a(context);
                return;
            }
        }
        a(context);
    }

    private void a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(str);
                this.av = j.c(jSONObject, "Headline");
                this.aw = j.c(jSONObject, "Body");
                this.aB = j.c(jSONObject, "AppIcon");
                JSONArray jSONArrayA = j.a(jSONObject, "Images");
                JSONArray jSONArrayA2 = j.a(jSONObject, "Videos");
                if (jSONArrayA != null && jSONArrayA.length() > 0) {
                    this.az = (String) jSONArrayA.get(0);
                }
                if (jSONArrayA2 != null && jSONArrayA2.length() > 0) {
                    this.ax = (String) jSONArrayA2.get(0);
                }
                if (jSONObject.has("apkFileMD5")) {
                    this.ac = j.c(jSONObject, "apkFileMD5");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(Map map) {
        Object obj;
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null) {
                if (obj instanceof String) {
                    this.E = (String) obj;
                }
                if (TextUtils.isEmpty(this.E)) {
                    return;
                }
                this.E = com.beizi.ad.lance.a.a.a(l.a(), this.E);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(View view, com.beizi.ad.model.d dVar, String str, String str2, String str3, int i) {
        String strA;
        try {
            this.ag = i;
            if (!n.a(this.c)) {
                this.c = p.a(this.c, dVar, str, str2, "", i);
                new d(this.c).execute(new Void[0]);
                this.c = "";
            }
            if (this.ai == null || this.aj == null) {
                return;
            }
            for (int i2 = 0; i2 < this.aj.size(); i2++) {
                c.l lVar = this.aj.get(i2);
                if (lVar != null && !TextUtils.isEmpty(lVar.b())) {
                    if (!TextUtils.isEmpty(str3)) {
                        strA = p.a(lVar.b(), dVar, str, str2, "", i).replace("__REQUESTUUID__", str3);
                    } else {
                        strA = p.a(lVar.b(), dVar, str, str2, "", i);
                    }
                    if (this.I) {
                        strA = strA.replace(g.b, "1");
                    }
                    new d(n.a(view, strA)).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
                }
            }
            this.aj = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
