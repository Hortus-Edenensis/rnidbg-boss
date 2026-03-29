package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapsInitializer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static double f2640a = 0.6499999761581421d;
    public d b;
    public c c;
    public b d;
    public a e;
    public ae f;
    public m g;
    public be h;
    private aw i;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bw<aw> f2641a;
        public boolean b;
        public boolean c;
        String d;
        int e;
        int f;
        String g;
        String h;
        String i;
        String j;
        private boolean l;
        private boolean m;
        private Context n;
        private boolean o;

        public /* synthetic */ a(bi biVar, Context context, byte b) {
            this(context);
        }

        private void c(String str) {
            if (str.equals("")) {
                return;
            }
            int size = this.f2641a.size();
            for (int i = 0; i < size; i++) {
                aw awVar = this.f2641a.get(i);
                if (awVar != null && !awVar.b.equals(str) && awVar.e && awVar.a()) {
                    awVar.a(false);
                }
            }
        }

        private boolean d(String str) {
            bw<aw> bwVar = this.f2641a;
            if (bwVar == null) {
                return false;
            }
            int size = bwVar.size();
            for (int i = 0; i < size; i++) {
                aw awVar = this.f2641a.get(i);
                if (awVar != null && awVar.b.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public final aw b(String str) {
            bw<aw> bwVar;
            if (!str.equals("") && (bwVar = this.f2641a) != null && bwVar.size() != 0) {
                int size = this.f2641a.size();
                for (int i = 0; i < size; i++) {
                    aw awVar = this.f2641a.get(i);
                    if (awVar != null && awVar.b.equals(str)) {
                        return awVar;
                    }
                }
            }
            return null;
        }

        private a(Context context) {
            this.l = false;
            this.m = true;
            this.f2641a = null;
            this.b = false;
            this.c = false;
            this.d = AMap.CHINESE;
            this.e = 0;
            this.f = 0;
            this.h = "SatelliteMap3";
            this.i = "GridTmc3";
            this.j = "SateliteTmc3";
            this.o = false;
            if (context == null) {
                return;
            }
            this.n = context;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = bi.this.h.f2635a;
            int i3 = (i / i2) + 3;
            int i4 = (displayMetrics.heightPixels / i2) + 3;
            int i5 = (i3 * i4) + i3 + i4;
            this.e = i5;
            int i6 = (i5 / 8) + 1;
            this.f = i6;
            if (i6 == 0) {
                this.f = 1;
            } else if (i6 > 5) {
                this.f = 5;
            }
            a(context, AMap.CHINESE);
        }

        public final void a(String str) {
            if (str == null || str.equals("") || this.d.equals(str)) {
                return;
            }
            if (str.equals(AMap.CHINESE) || str.equals("en")) {
                String str2 = z.g;
                if (str2 != null && !str2.equals("")) {
                    this.g = z.g;
                } else if (str.equals(AMap.CHINESE)) {
                    this.g = "GridMapV3";
                } else if (str.equals("en")) {
                    this.g = "GridMapEnV3";
                }
                bi.this.i = b(this.g);
                if (bi.this.i == null) {
                    bi biVar = bi.this;
                    biVar.i = new aw(biVar.h);
                    aw awVar = bi.this.i;
                    bi biVar2 = bi.this;
                    awVar.q = new ce(biVar2, biVar2.i);
                    bi.this.i.j = new cj() { // from class: com.amap.api.col.2sl.bi.a.1
                        @Override // com.amap.api.col.p0002sl.cj
                        public final String a(int i, int i2, int i3) {
                            String str3 = z.h;
                            if (str3 != null && !str3.equals("")) {
                                return String.format(Locale.US, z.h, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                            }
                            bg.a();
                            return String.format(Locale.US, bg.b(), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), a.this.d);
                        }
                    };
                    String str3 = z.h;
                    if (str3 == null || str3.equals("")) {
                        bi.this.i.h = true;
                    } else {
                        bi.this.i.h = false;
                    }
                    bi.this.i.b = this.g;
                    bi.this.i.e = true;
                    bi.this.i.a(true);
                    bi.this.i.f = true;
                    bi.this.i.c = z.c;
                    bi.this.i.d = z.d;
                    a(bi.this.i, this.n);
                }
                a(this.g, true);
                this.d = str;
            }
        }

        public final void b() {
            c cVar = bi.this.c;
            if (cVar == null || cVar.c == null) {
                return;
            }
            bi.this.c.c.postInvalidate();
        }

        private void c() {
            int size = this.f2641a.size();
            for (int i = 0; i < size; i++) {
                aw awVar = this.f2641a.get(i);
                if (awVar != null) {
                    awVar.l = i;
                }
            }
        }

        public final void b(boolean z) {
            this.m = z;
        }

        private void b(Canvas canvas) {
            if (this.m) {
                bi.this.f.a(canvas);
            }
        }

        private void c(Canvas canvas) {
            bi.this.g.j.a(canvas);
        }

        private void a(Context context, String str) {
            if (this.f2641a == null) {
                this.f2641a = new bw<>();
            }
            String str2 = z.g;
            if (str2 != null && !str2.equals("")) {
                this.g = z.g;
            } else if (str.equals(AMap.CHINESE)) {
                this.g = "GridMapV3";
            } else if (str.equals("en")) {
                this.g = "GridMapEnV3";
            }
            aw awVar = new aw(bi.this.h);
            awVar.j = new cj() { // from class: com.amap.api.col.2sl.bi.a.2
                @Override // com.amap.api.col.p0002sl.cj
                public final String a(int i, int i2, int i3) {
                    String str3 = z.h;
                    if (str3 != null && !str3.equals("")) {
                        return String.format(Locale.US, z.h, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                    }
                    bg.a();
                    return String.format(Locale.US, bg.b(), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), a.this.d);
                }
            };
            String str3 = z.h;
            if (str3 != null && !str3.equals("")) {
                awVar.h = false;
            } else {
                awVar.h = true;
            }
            awVar.b = this.g;
            awVar.e = true;
            awVar.f = true;
            awVar.c = z.c;
            awVar.d = z.d;
            awVar.q = new ce(bi.this, awVar);
            awVar.a(true);
            a(awVar, context);
        }

        public final boolean a(String str, boolean z) {
            if (str.equals("")) {
                return false;
            }
            int size = this.f2641a.size();
            for (int i = 0; i < size; i++) {
                aw awVar = this.f2641a.get(i);
                if (awVar != null && awVar.b.equals(str)) {
                    awVar.a(z);
                    if (!awVar.e) {
                        return true;
                    }
                    if (z) {
                        int i2 = awVar.c;
                        if (i2 > awVar.d) {
                            bi.this.c.a(i2);
                            bi.this.c.b(awVar.d);
                        }
                        c(str);
                        bi.this.c.a(false);
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean a(aw awVar, Context context) {
            boolean zAdd = false;
            if (awVar == null || awVar.b.equals("") || d(awVar.b)) {
                return false;
            }
            awVar.p = new bw<>();
            awVar.n = new bj(this.e, this.f, awVar.g, awVar.i, awVar);
            ad adVar = new ad(context, bi.this.c.c.d, awVar);
            awVar.o = adVar;
            adVar.a(awVar.n);
            int size = this.f2641a.size();
            if (awVar.e && size != 0) {
                int i = size - 1;
                while (true) {
                    if (i >= 0) {
                        aw awVar2 = this.f2641a.get(i);
                        if (awVar2 != null && awVar2.e) {
                            this.f2641a.add(i, awVar);
                            break;
                        }
                        i--;
                    } else {
                        break;
                    }
                }
            } else {
                zAdd = this.f2641a.add(awVar);
            }
            c();
            if (awVar.a()) {
                a(awVar.b, true);
            }
            return zAdd;
        }

        public final void a() {
            bw<aw> bwVar = bi.this.e.f2641a;
            if (bwVar == null) {
                return;
            }
            for (aw awVar : bwVar) {
                if (awVar != null) {
                    awVar.b();
                }
            }
            bi.this.e.f2641a.clear();
            bi.this.e.f2641a = null;
        }

        public final void a(boolean z) {
            this.l = z;
        }

        public final void a(Canvas canvas, Matrix matrix, float f, float f2) {
            try {
                if (this.l) {
                    canvas.save();
                    canvas.translate(f, f2);
                    canvas.concat(matrix);
                    a(canvas);
                    if (bi.this.g.i.a()) {
                        b(canvas);
                    }
                    bi.this.g.i.a(canvas);
                    canvas.restore();
                    if (!bi.this.g.i.a()) {
                        b(canvas);
                    }
                    if (!this.b && !this.c) {
                        a(false);
                        bi.this.c.c.a(new Matrix());
                        bi.this.c.c.b(1.0f);
                        bi.this.c.c.j();
                    }
                } else {
                    a(canvas);
                    bi.this.g.i.a(canvas);
                    b(canvas);
                }
                c(canvas);
            } catch (Throwable th) {
                ct.a(th, "Mediator", MediationConstant.RIT_TYPE_DRAW);
            }
        }

        private void a(Canvas canvas) {
            int size = this.f2641a.size();
            for (int i = 0; i < size; i++) {
                aw awVar = this.f2641a.get(i);
                if (awVar != null && awVar.a()) {
                    awVar.a(canvas);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2644a = false;
        int b = 0;

        public b() {
            e();
        }

        private void e() {
            bw<aw> bwVar = bi.this.e.f2641a;
            if (bwVar == null || bwVar.size() == 0) {
                return;
            }
            int size = bi.this.e.f2641a.size();
            for (int i = 0; i < size; i++) {
                bi.this.e.f2641a.get(i);
            }
        }

        public final void a() {
            bw<aw> bwVar;
            if (bi.this.e.o) {
                bi.this.e.b();
            }
            int i = this.b + 1;
            this.b = i;
            if (i < 20 || i % 20 != 0 || (bwVar = bi.this.e.f2641a) == null || bwVar.size() == 0) {
                return;
            }
            int size = bi.this.e.f2641a.size();
            for (int i2 = 0; i2 < size; i2++) {
                bi.this.e.f2641a.get(i2).q.f();
            }
        }

        public final void b() {
            bi biVar = bi.this;
            biVar.c.f2645a = false;
            bw<aw> bwVar = biVar.e.f2641a;
            if (bwVar == null || bwVar.size() == 0) {
                return;
            }
            int size = bi.this.e.f2641a.size();
            for (int i = 0; i < size; i++) {
                bi.this.e.f2641a.get(i).q.b();
            }
        }

        public final void c() {
            bw<aw> bwVar = bi.this.e.f2641a;
            if (bwVar == null || bwVar.size() == 0) {
                return;
            }
            try {
                int size = bi.this.e.f2641a.size();
                for (int i = 0; i < size; i++) {
                    bi.this.e.f2641a.get(i).q.d();
                }
            } catch (Throwable unused) {
            }
        }

        public final void d() {
            ce ceVar;
            bw<aw> bwVar = bi.this.e.f2641a;
            if (bwVar == null || bwVar.size() == 0) {
                return;
            }
            int size = bi.this.e.f2641a.size();
            for (int i = 0; i < size; i++) {
                aw awVar = bi.this.e.f2641a.get(i);
                if (awVar != null && (ceVar = awVar.q) != null) {
                    ceVar.c();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2645a;
        private m c;
        private ArrayList<ck> d;

        public /* synthetic */ c(bi biVar, m mVar, byte b) {
            this(mVar);
        }

        public static int c() {
            return z.n;
        }

        public static int d() {
            return z.o;
        }

        public final void b(af afVar) {
            af afVarF = bi.this.c.f();
            if (afVar == null || afVar.equals(afVarF)) {
                return;
            }
            if (z.s) {
                bi.this.h.l = be.a(afVar);
            }
            a(true);
        }

        public final float e() {
            try {
                return bi.this.h.j;
            } catch (Throwable th) {
                ct.a(th, "Mediator", "getZoomLevel");
                return 0.0f;
            }
        }

        public final af f() {
            af afVarB = be.b(bi.this.h.l);
            bi biVar = bi.this;
            b bVar = biVar.d;
            return (bVar == null || !bVar.f2644a) ? afVarB : biVar.h.m;
        }

        public final m g() {
            return this.c;
        }

        private c(m mVar) {
            this.f2645a = true;
            this.c = mVar;
            this.d = new ArrayList<>();
        }

        public final void a(float f) {
            double d;
            bi biVar = bi.this;
            be beVar = biVar.h;
            if (f != beVar.j) {
                beVar.j = f;
                int i = (int) f;
                double d2 = beVar.d / ((double) (1 << i));
                float f2 = f - i;
                double d3 = f2;
                if (d3 < bi.f2640a) {
                    int i2 = beVar.b;
                    int i3 = (int) (((double) i2) * ((d3 * 0.4d) + 1.0d));
                    beVar.f2635a = i3;
                    d = d2 / (((double) i3) / ((double) i2));
                } else {
                    int i4 = beVar.b;
                    int i5 = (int) (i4 / (2.0f / (2.0f - ((1.0f - f2) * 0.4f))));
                    beVar.f2635a = i5;
                    d = (d2 / 2.0d) / (((double) i5) / ((double) i4));
                }
                beVar.k = d;
                m mVar = biVar.g;
                mVar.c[1] = f;
                mVar.f.a(f);
            }
            a(false);
        }

        public final int b() {
            try {
                return bi.this.h.h;
            } catch (Throwable th) {
                ct.a(th, "Mediator", "getMinZoomLevel");
                return 0;
            }
        }

        public final void b(int i) {
            if (i <= 0) {
                return;
            }
            try {
                bi.this.h.h = i;
                z.b(i);
            } catch (Throwable th) {
                ct.a(th, "Mediator", "setMinZoomLevel");
            }
        }

        public final void a(int i, int i2) {
            if (i == z.n && i2 == z.o) {
                return;
            }
            z.n = i;
            z.o = i2;
            a(false);
        }

        public final void b(ck ckVar) {
            this.d.remove(ckVar);
        }

        public final void a(af afVar) {
            if (afVar == null) {
                return;
            }
            if (z.s) {
                bi.this.h.l = be.a(afVar);
            }
            a(false);
        }

        public final int a() {
            try {
                return bi.this.h.i;
            } catch (Throwable th) {
                ct.a(th, "Mediator", "getMaxZoomLevel");
                return 0;
            }
        }

        public final void a(int i) {
            if (i <= 0) {
                return;
            }
            try {
                bi.this.h.i = i;
                z.a(i);
            } catch (Throwable th) {
                ct.a(th, "Mediator", "setMaxZoomLevel");
            }
        }

        public final void a(ck ckVar) {
            this.d.add(ckVar);
        }

        public final void a(boolean z) {
            cd cdVar;
            Iterator<ck> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().a(z);
            }
            m mVar = bi.this.g;
            if (mVar == null || (cdVar = mVar.i) == null) {
                return;
            }
            cdVar.c();
            bi.this.g.postInvalidate();
        }
    }

    public bi(Context context, m mVar, int i) {
        this.h = null;
        this.g = mVar;
        byte b2 = 0;
        c cVar = new c(this, mVar, b2);
        this.c = cVar;
        be beVar = new be(cVar);
        this.h = beVar;
        beVar.f2635a = i;
        beVar.b = i;
        beVar.a();
        a(context);
        this.e = new a(this, context, b2);
        this.b = new d();
        this.d = new b();
        this.f = new ae(mVar);
        this.c.a(false);
    }

    private static void b() {
        if (MapsInitializer.getUpdateDataActiveEnable()) {
            bp.a();
            String strA = bp.a("updateDataPeriodDate");
            if (strA == null || strA.equals("")) {
                bp.a();
                bp.a("updateDataPeriodDate", ac.a());
                return;
            }
            double dA = ac.a(strA, ac.a());
            bp.a();
            if (dA > bp.a("period_day", z.q)) {
                c();
            }
        }
    }

    private static void c() {
        bp.a();
        String strB = bp.b("cache_path");
        if (strB != null) {
            ad.a(strB);
        }
        bp.a();
        bp.a("updateDataPeriodDate", ac.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context) {
        Field field;
        int i;
        new DisplayMetrics();
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        try {
            field = displayMetrics.getClass().getField("densityDpi");
        } catch (NoSuchFieldException e) {
            ct.a(e, "Mediator", "initialize");
            field = null;
        } catch (SecurityException e2) {
            ct.a(e2, "Mediator", "initialize");
            field = null;
        }
        if (field != null) {
            long j = displayMetrics.widthPixels * displayMetrics.heightPixels;
            try {
                i = field.getInt(displayMetrics);
            } catch (IllegalAccessException e3) {
                ct.a(e3, "Mediator", "initialize");
                i = 160;
            } catch (IllegalArgumentException e4) {
                ct.a(e4, "Mediator", "initialize");
                i = 160;
            }
            if (i <= 120) {
                z.m = 1;
            } else if (i <= 160) {
                z.m = 3;
            } else if (i <= 240 || j > 153600) {
                z.m = 2;
            } else if (j < 153600) {
                z.m = 1;
            }
        } else {
            long j2 = displayMetrics.widthPixels * displayMetrics.heightPixels;
            if (j2 > 153600) {
                z.m = 2;
            } else if (j2 < 153600) {
                z.m = 1;
            } else {
                z.m = 3;
            }
        }
        if (z.m != 2) {
            z.c = 18;
        }
        bp.a(context);
        if (MapsInitializer.getUpdateDataActiveEnable()) {
            bp.a();
            bp.a("UpdateDataActiveEnable", true);
        }
        bp.a();
        MapsInitializer.setUpdateDataActiveEnable(bp.c("UpdateDataActiveEnable"));
        b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements bq {
        private float b = 0.0f;
        private HashMap<Float, Float> c = new HashMap<>();

        public d() {
        }

        @Override // com.amap.api.col.p0002sl.bq
        public final Point a(af afVar, Point point) {
            boolean zIsZoomGesturesEnabled;
            int i;
            int i2;
            if (afVar == null) {
                return null;
            }
            be beVar = bi.this.h;
            PointF pointFA = beVar.a(afVar, beVar.l, beVar.n, beVar.k);
            bk bkVarH = bi.this.c.c.h();
            Point point2 = bi.this.c.c.a().h.n;
            if (bkVarH.m) {
                try {
                    zIsZoomGesturesEnabled = bi.this.g.h.isZoomGesturesEnabled();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    zIsZoomGesturesEnabled = true;
                }
                if (bkVarH.l && zIsZoomGesturesEnabled) {
                    float f = bk.j;
                    float f2 = (int) pointFA.x;
                    PointF pointF = bkVarH.f;
                    float f3 = pointF.x;
                    PointF pointF2 = bkVarH.g;
                    float f4 = ((f2 - f3) * f) + f3 + (pointF2.x - f3);
                    float f5 = (int) pointFA.y;
                    float f6 = pointF.y;
                    float f7 = (f * (f5 - f6)) + f6 + (pointF2.y - f6);
                    i2 = (int) f4;
                    i = (int) f7;
                    if (f4 >= ((double) i2) + 0.5d) {
                        i2++;
                    }
                    if (f7 >= ((double) i) + 0.5d) {
                        i++;
                    }
                } else {
                    int i3 = (int) pointFA.x;
                    i = (int) pointFA.y;
                    i2 = i3;
                }
            } else {
                float f8 = bi.this.h.c;
                int i4 = (int) pointFA.x;
                float f9 = ((i4 - r5) * f8) + point2.x;
                int i5 = (int) pointFA.y;
                float f10 = (f8 * (i5 - r1)) + point2.y;
                i2 = (int) f9;
                int i6 = (int) f10;
                if (f9 >= ((double) i2) + 0.5d) {
                    i2++;
                }
                i = ((double) f10) >= ((double) i6) + 0.5d ? i6 + 1 : i6;
            }
            Point point3 = new Point(i2, i);
            if (point != null) {
                point.x = point3.x;
                point.y = point3.y;
            }
            return point3;
        }

        public final int b(int i, int i2, int i3) {
            return a(i, i2, i3, true);
        }

        @Override // com.amap.api.col.p0002sl.bq
        public final af a(int i, int i2) {
            PointF pointF = new PointF(i, i2);
            be beVar = bi.this.h;
            return beVar.a(pointF, beVar.l, beVar.n, beVar.k, beVar.o);
        }

        public final float a(float f) {
            float fE = bi.this.c.e();
            if (this.c.size() > 30 || fE != this.b) {
                this.b = fE;
                this.c.clear();
            }
            if (!this.c.containsKey(Float.valueOf(f))) {
                float fA = bi.this.h.a(a(0, 0), a(0, 100));
                if (fA <= 0.0f) {
                    return 0.0f;
                }
                this.c.put(Float.valueOf(f), Float.valueOf((f / fA) * 100.0f));
            }
            return this.c.get(Float.valueOf(f)).floatValue();
        }

        public final int a(int i, int i2, int i3) {
            return a(i, i2, i3, false);
        }

        private int a(int i, int i2, int i3, boolean z) {
            if (i <= 0) {
                i = c.c();
            }
            if (i2 <= 0) {
                i2 = c.d();
            }
            af afVarA = a(i3, i2 - i3);
            af afVarA2 = a(i - i3, i3);
            if (z) {
                return Math.abs(afVarA.a() - afVarA2.a());
            }
            return Math.abs(afVarA.b() - afVarA2.b());
        }
    }

    public final void a() {
        this.e.a();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        if (MapsInitializer.getUpdateDataActiveEnable() && z.b()) {
            c();
        }
    }

    public final void a(boolean z) {
        this.e.b(z);
    }
}
