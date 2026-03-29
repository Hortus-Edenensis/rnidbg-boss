package com.beizi.ad.internal.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.e;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.internal.d.a;
import com.beizi.ad.internal.e.j;
import com.beizi.ad.internal.e.n;
import com.beizi.ad.internal.e.p;
import com.beizi.ad.internal.e.u;
import com.beizi.ad.internal.g;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.f;
import com.beizi.ad.lance.a.h;
import com.beizi.ad.lance.a.k;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.lance.a.r;
import com.beizi.ad.model.c;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.openalliance.ad.constant.bq;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements com.beizi.ad.e {
    private boolean A;
    private f B;
    private View C;
    private List<View> D;
    private b E;
    private View.OnClickListener F;
    private long H;
    private int I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private c.b.C0127b U;
    private c.b.a V;
    private boolean W;
    private boolean X;
    private int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e.a f4380a;
    private String b;
    private String c;
    private String d;
    private String f;
    private String g;
    private String h;
    private c.b i;
    private String j;
    private double k;
    private String l;
    private String m;
    private String n;
    private HashMap<String, Object> o;
    private a.C0114a x;
    private a.C0114a y;
    private String z;
    private ArrayList<Bitmap> e = new ArrayList<>();
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private ArrayList<String> s = new ArrayList<>();
    private ArrayList<String> t = new ArrayList<>();
    private ArrayList<String> u = new ArrayList<>();
    private ArrayList<String> v = new ArrayList<>();
    private ArrayList<String> w = new ArrayList<>();
    private String G = "";
    private int Y = 0;
    private boolean aa = true;
    private boolean ab = false;
    private long ac = System.currentTimeMillis();
    private boolean ad = true;

    private void n() {
        this.F = new View.OnClickListener() { // from class: com.beizi.ad.internal.c.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (a.this.w != null) {
                        for (String str : a.this.w) {
                            m.a("lance", "setClickListener:" + str);
                            new com.beizi.ad.internal.d(str).execute(new Void[0]);
                        }
                    }
                    Context context = view.getContext();
                    View rootView = view.getRootView();
                    if (rootView != null) {
                        context = rootView.getContext();
                    }
                    a.this.Y = 0;
                    a aVar = a.this;
                    aVar.a(aVar.h, a.this.g, context);
                    if (a.this.E != null) {
                        a.this.E.a();
                    }
                    a.this.w = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private boolean o() {
        if (TextUtils.isEmpty(this.J) || TextUtils.isEmpty(this.O) || TextUtils.isEmpty(this.N) || TextUtils.isEmpty(this.R) || TextUtils.isEmpty(this.T)) {
            return false;
        }
        if (TextUtils.isEmpty(this.Q) && TextUtils.isEmpty(this.P)) {
            return false;
        }
        int i = this.I;
        return i == 2 || i == 5;
    }

    private boolean p() {
        int i = this.I;
        return i == 2 ? !TextUtils.isEmpty(this.M) && this.M.startsWith(HttpHost.DEFAULT_SCHEME_NAME) : i == 5 && !TextUtils.isEmpty(this.M) && this.M.contains("market://");
    }

    @Override // com.beizi.ad.e
    public String l() {
        return this.g;
    }

    @Override // com.beizi.ad.e
    public ApkBean m() {
        int i = this.I;
        if (i != 2 && i != 5) {
            return null;
        }
        ApkBean apkBean = new ApkBean();
        apkBean.setApkName(this.J);
        apkBean.setAppVersion(this.N);
        apkBean.setAppDeveloper(this.O);
        apkBean.setAppPermissionsDesc(this.P);
        apkBean.setAppPermissionsUrl(this.Q);
        apkBean.setAppPrivacyUrl(this.R);
        apkBean.setAppintro(this.T);
        return apkBean;
    }

    @Override // com.beizi.ad.e
    public String c() {
        return this.c;
    }

    @Override // com.beizi.ad.e
    public String d() {
        return this.f;
    }

    @Override // com.beizi.ad.e
    public String e() {
        return this.j;
    }

    @Override // com.beizi.ad.e
    public boolean f() {
        return this.p;
    }

    @Override // com.beizi.ad.e
    public void g() {
        f fVar = this.B;
        if (fVar != null) {
            fVar.a();
        }
        this.p = true;
        this.C = null;
        this.D = null;
        this.E = null;
    }

    @Override // com.beizi.ad.e
    public ArrayList<String> h() {
        return this.s;
    }

    @Override // com.beizi.ad.e
    public ArrayList<String> i() {
        return this.u;
    }

    @Override // com.beizi.ad.e
    public a.C0114a j() {
        return this.x;
    }

    @Override // com.beizi.ad.e
    public a.C0114a k() {
        return this.y;
    }

    public void b(a.C0114a c0114a) {
        this.y = c0114a;
    }

    public void c(String str) {
        this.h = str;
    }

    public void d(String str) {
        this.v.add(str);
    }

    public void e(String str) {
        this.w.add(str);
    }

    @Override // com.beizi.ad.e
    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.g = str;
    }

    private boolean b(Context context) {
        c.b bVar = this.i;
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
        String strU = this.i.u();
        String strV = this.i.v();
        String strW = this.i.w();
        if (!TextUtils.isEmpty(strU) && !TextUtils.isEmpty(strV)) {
            return r.a(context, strU, strV, strW);
        }
        String strX = this.i.x();
        if (!TextUtils.isEmpty(strX)) {
            return r.a(context, strX);
        }
        return false;
    }

    public void a(a.C0114a c0114a) {
        this.x = c0114a;
    }

    public void a(String str) {
        this.G = str;
    }

    public static a a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        ArrayList<String> arrayListA = j.a(j.a(jSONObject, "ImpressionTrackers"));
        a aVar = new a();
        if (arrayListA != null) {
            aVar.v = arrayListA;
        }
        aVar.b = j.c(jSONObject, "Headline");
        aVar.c = j.c(jSONObject, "Body");
        aVar.d = j.c(jSONObject, "Image");
        JSONArray jSONArrayA = j.a(jSONObject, "Images");
        JSONArray jSONArrayA2 = j.a(jSONObject, "Videos");
        JSONArray jSONArrayA3 = j.a(jSONObject, "Texts");
        if (jSONArrayA != null) {
            for (int i = 0; i < jSONArrayA.length(); i++) {
                aVar.s.add((String) jSONArrayA.get(i));
            }
        }
        if (jSONArrayA2 != null) {
            for (int i2 = 0; i2 < jSONArrayA2.length(); i2++) {
                aVar.t.add((String) jSONArrayA2.get(i2));
            }
        }
        if (jSONArrayA3 != null) {
            for (int i3 = 0; i3 < jSONArrayA3.length(); i3++) {
                aVar.u.add((String) jSONArrayA3.get(i3));
            }
        }
        if (jSONObject.has("AppIcon")) {
            aVar.f4380a = e.a.APP_INSTALL;
            aVar.f = j.c(jSONObject, "AppIcon");
            aVar.j = j.c(jSONObject, "Action");
            aVar.k = j.e(jSONObject, "Star");
            aVar.l = j.c(jSONObject, "Store");
            aVar.m = j.c(jSONObject, "Price");
        } else {
            aVar.f4380a = e.a.CONTENT;
            aVar.f = j.c(jSONObject, "Logo");
            aVar.j = j.c(jSONObject, "Action");
            aVar.n = j.c(jSONObject, "Advertiser");
        }
        ArrayList<String> arrayListA2 = j.a(j.a(jSONObject, "ClickTrackers"));
        if (arrayListA2 != null) {
            aVar.w = arrayListA2;
        }
        aVar.o = j.a(j.b(jSONObject, "Custom"));
        return aVar;
    }

    private boolean b(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public void b(boolean z) {
        this.ad = z;
    }

    @Override // com.beizi.ad.e
    public boolean a(final View view, c cVar) {
        if (!this.p && view != null) {
            this.B = new f(view, cVar, new e() { // from class: com.beizi.ad.internal.c.a.1
                @Override // com.beizi.ad.internal.c.e
                public void a() {
                    if (a.this.v == null || a.this.v.size() == 0) {
                        return;
                    }
                    Iterator it = a.this.v.iterator();
                    while (it.hasNext()) {
                        new g(a.this.a((String) it.next(), view)).b();
                    }
                    a.this.v = null;
                }
            });
            this.C = view;
        }
        return false;
    }

    public String a(String str, View view) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.z)) {
            str = str.replace(com.beizi.ad.model.g.f4516a, this.z);
        }
        String strReplace = str;
        if (view != null) {
            if (!TextUtils.isEmpty(this.G)) {
                strReplace = strReplace.replace("__REQUESTUUID__", this.G);
            }
            if (this.A) {
                strReplace = strReplace.replace(com.beizi.ad.model.g.b, "1");
            }
            return n.a(0, view, strReplace);
        }
        return p.a(strReplace, "", "", "", "", "", "", "");
    }

    @Override // com.beizi.ad.e
    public void a(Context context, View view, String str, String str2, String str3, String str4, int i) {
        this.Y = i;
        ArrayList<String> arrayList = this.w;
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String strA = p.a(it.next(), str + "", str2 + "", str3 + "", str4 + "", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), "", i);
                if (!TextUtils.isEmpty(this.G)) {
                    strA = strA.replace("__REQUESTUUID__", this.G);
                }
                if (this.A) {
                    strA = strA.replace(com.beizi.ad.model.g.b, "1");
                }
                new com.beizi.ad.internal.d(n.a(view, strA)).execute(new Void[0]);
            }
        }
        this.w = null;
        if (!a(this.h, this.g, context)) {
            Log.d("lance", "Unable to handle click.");
        }
        b bVar = this.E;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.beizi.ad.e
    public String a() {
        return this.b;
    }

    @Override // com.beizi.ad.e
    public boolean a(final View view, b bVar) {
        if (this.p || view == null) {
            return false;
        }
        this.E = bVar;
        this.C = view;
        final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.c.a.2
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                a.this.H = System.currentTimeMillis();
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (a.this.w != null) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    Iterator it = a.this.w.iterator();
                    while (it.hasNext()) {
                        String strA = p.a((String) it.next(), x + "", y + "", rawX + "", rawY + "", String.valueOf(a.this.H), String.valueOf(System.currentTimeMillis()), "", 0);
                        if (!TextUtils.isEmpty(a.this.G)) {
                            strA = strA.replace("__REQUESTUUID__", a.this.G);
                        }
                        if (a.this.A) {
                            strA = strA.replace(com.beizi.ad.model.g.b, "1");
                        }
                        new com.beizi.ad.internal.d(n.a(view, strA)).execute(new Void[0]);
                    }
                }
                a.this.w = null;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }
        });
        n();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.c.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
        view.setOnClickListener(this.F);
        return true;
    }

    @Override // com.beizi.ad.e
    public boolean a(final View view, List<View> list, b bVar) {
        if (!a(view, bVar)) {
            return false;
        }
        if (list == null || list.size() <= 0) {
            return true;
        }
        view.setOnClickListener(null);
        for (View view2 : list) {
            final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.c.a.4
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    a.this.H = System.currentTimeMillis();
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    if (a.this.w != null) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        Iterator it = a.this.w.iterator();
                        while (it.hasNext()) {
                            String strA = p.a((String) it.next(), x + "", y + "", rawX + "", rawY + "", String.valueOf(a.this.H), String.valueOf(System.currentTimeMillis()), "", 0);
                            if (!TextUtils.isEmpty(a.this.G)) {
                                strA = strA.replace("__REQUESTUUID__", a.this.G);
                            }
                            if (a.this.A) {
                                strA = strA.replace(com.beizi.ad.model.g.b, "1");
                            }
                            new com.beizi.ad.internal.d(n.a(view, strA)).execute(new Void[0]);
                        }
                    }
                    a.this.w = null;
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent motionEvent) {
                }
            });
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.c.a.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
            });
            view2.setOnClickListener(this.F);
        }
        this.D = list;
        return true;
    }

    public void a(c.b bVar) {
        this.i = bVar;
        this.U = bVar.j();
        this.I = bVar.c();
        this.J = bVar.d();
        this.K = bVar.e();
        this.L = bVar.f();
        this.M = bVar.g();
        if (TextUtils.isEmpty(this.K)) {
            this.K = "lance";
        }
        if (TextUtils.isEmpty(this.J)) {
            this.J = "BeiZi";
        }
        if (TextUtils.isEmpty(this.L)) {
            this.L = "Ad Download";
        }
        this.N = bVar.m();
        this.O = bVar.n();
        this.P = bVar.o();
        this.Q = bVar.p();
        this.R = bVar.q();
        this.S = bVar.r();
        this.T = bVar.s();
        c.b.a aVarT = bVar.t();
        this.V = aVarT;
        if (aVarT != null) {
            if (aVarT.a() == 1) {
                this.W = true;
            }
            if (this.V.b() == 1) {
                this.X = true;
            }
            this.Z = this.V.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, Context context) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (!k.a(context, str) && !h.a(context, this.K) && !str.startsWith("hwpps://landingpage") && !str.startsWith(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK) && !str.startsWith("hap://")) {
                    c.b.C0127b c0127b = this.U;
                    if (c0127b != null) {
                        com.beizi.ad.internal.e.k.a(c0127b.i());
                    }
                    a(context, str2);
                } else {
                    c.b.C0127b c0127b2 = this.U;
                    if (c0127b2 != null) {
                        com.beizi.ad.internal.e.k.a(c0127b2.h());
                    }
                    a(context);
                    c.b.C0127b c0127b3 = this.U;
                    if (c0127b3 != null) {
                        com.beizi.ad.internal.e.k.a(c0127b3.e());
                    }
                }
                return true;
            } catch (Exception unused) {
                c.b.C0127b c0127b4 = this.U;
                if (c0127b4 != null) {
                    com.beizi.ad.internal.e.k.a(c0127b4.g());
                }
                a(context, str2);
                return true;
            }
        }
        a(context, str2);
        return true;
    }

    private void a(Context context, String str) {
        try {
            if (o() && p()) {
                int i = this.I;
                if (i == 2) {
                    if (h.a(context, this.K)) {
                        h.b(context, this.K);
                        c.b.C0127b c0127b = this.U;
                        if (c0127b != null) {
                            com.beizi.ad.internal.e.k.a(c0127b.a());
                            return;
                        }
                        return;
                    }
                    a(context, 1);
                    return;
                }
                if (i == 5) {
                    if (k.a(context, this.M)) {
                        if (!this.X && this.Y != 0) {
                            a(context, 2);
                            return;
                        }
                        b(this.M, context);
                        c.b.C0127b c0127b2 = this.U;
                        if (c0127b2 != null) {
                            com.beizi.ad.internal.e.k.a(c0127b2.a());
                            return;
                        }
                        return;
                    }
                    a(str, context);
                    return;
                }
                return;
            }
            a(str, context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(Context context, int i) {
        try {
            File fileA = h.a(context);
            String absolutePath = fileA != null ? fileA.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.M, this.K + com.huawei.hms.ads.dynamicloader.b.b, this.K, absolutePath, this.J, this.L, context.getPackageName() + ".fileprovider", this.U, this.N, this.O, this.P, this.Q, this.R, this.S, this.T);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i);
            bundle.putBoolean("isCanJump", this.W);
            bundle.putBoolean("isDownload", o());
            if (i == 2) {
                c.b.C0127b c0127b = this.U;
                if (c0127b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0127b.a());
                }
                bundle.putString("landingPageUrl", this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                bundle.putString("deeplinkUrl", this.h);
                bundle.putInt("webDeepLink", this.Z);
            }
            Intent intent = new Intent(context, (Class<?>) BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(final Context context) {
        this.ac = System.currentTimeMillis();
        com.beizi.ad.internal.c.a().a(new com.beizi.ad.internal.a() { // from class: com.beizi.ad.internal.c.a.7
            @Override // com.beizi.ad.internal.a
            public void a() {
                try {
                    if (a.this.U != null) {
                        com.beizi.ad.internal.e.k.a(a.this.U.f());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.beizi.ad.internal.a
            public void b() {
                try {
                    if (a.this.ad && System.currentTimeMillis() - a.this.ac <= 2000) {
                        if (a.this.U != null) {
                            com.beizi.ad.internal.e.k.a(a.this.U.j());
                        }
                        a aVar = a.this;
                        aVar.a(aVar.g, context);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Uri uri = Uri.parse(this.h);
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
            if (context != null) {
                context.startActivity(intent);
                return;
            }
            return;
        }
        if (this.h.startsWith("hwpps://landingpage")) {
            Intent intent2 = new Intent();
            intent2.setData(uri);
            intent2.addFlags(268435456);
            if (context != null) {
                context.startActivity(intent2);
                return;
            }
            return;
        }
        if (this.h.startsWith(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
            Intent uri2 = null;
            try {
                uri2 = Intent.parseUri(this.h, 1);
                uri2.addFlags(268435456);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (context != null) {
                context.startActivity(uri2);
                return;
            }
            return;
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", uri);
        intent3.addFlags(805339136);
        if (context != null) {
            context.startActivity(intent3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Context context) {
        if (str != null && !str.isEmpty()) {
            if (b(context)) {
                return true;
            }
            if (!this.aa) {
                if (!b(str, context)) {
                    return false;
                }
                b bVar = this.E;
                if (bVar != null) {
                    bVar.b();
                }
                return true;
            }
            Class clsA = AdActivity.a();
            try {
                WebView webView = new WebView(new MutableContextWrapper(context));
                u.a(webView);
                webView.loadUrl(str, com.beizi.ad.lance.a.j.a());
                com.beizi.ad.internal.activity.a.f4370a.add(webView);
                Intent intent = new Intent(context, (Class<?>) clsA);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.W);
                intent.putExtra("ACTIVITY_CAN_DOWNLOAD", o());
                if (!TextUtils.isEmpty(this.h)) {
                    intent.putExtra("deeplinkUrl", this.h);
                    intent.putExtra("webDeepLink", this.Z);
                }
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                com.beizi.ad.internal.activity.a.f4370a.remove();
            } catch (Exception unused2) {
                return false;
            }
        }
        return false;
    }

    public void a(boolean z) {
        this.A = z;
    }

    @Override // com.beizi.ad.e
    public void a(View view, String str, String str2, String str3, String str4, int i, b bVar) {
        try {
            this.Y = i;
            ArrayList<String> arrayList = this.w;
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String strA = p.a(it.next(), str + "", str2 + "", str3 + "", str4 + "", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), "", i);
                    if (!TextUtils.isEmpty(this.G)) {
                        strA = strA.replace("__REQUESTUUID__", this.G);
                    }
                    if (this.A) {
                        strA = strA.replace(com.beizi.ad.model.g.b, "1");
                    }
                    new com.beizi.ad.internal.d(n.a(view, strA)).execute(new Void[0]);
                }
            }
            this.w = null;
            Context context = view.getContext();
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            a(this.h, this.g, context);
            if (bVar != null) {
                bVar.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
