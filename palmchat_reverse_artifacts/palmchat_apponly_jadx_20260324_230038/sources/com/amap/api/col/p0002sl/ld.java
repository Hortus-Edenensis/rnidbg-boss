package com.amap.api.col.p0002sl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.amap.api.col.p0002sl.hu;
import com.amap.api.col.p0002sl.jl;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ld implements kx {
    private static long k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f2958a;
    kh d;
    ig e;
    private Handler g;
    private LocationManager h;
    private a i;
    private ArrayList<jn> f = new ArrayList<>();
    ls b = null;
    lm c = null;
    private volatile boolean j = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ld f2960a;

        public a(ld ldVar) {
            this.f2960a = ldVar;
        }

        public final void a(ld ldVar) {
            this.f2960a = ldVar;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                ld ldVar = this.f2960a;
                if (ldVar != null) {
                    ldVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        public final void a() {
            this.f2960a = null;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public ld(Context context) {
        this.f2958a = null;
        this.f2958a = context;
        ig igVar = new ig();
        this.e = igVar;
        im.a(this.f2958a, igVar, hb.k, 100, 1024000, "0");
        ig igVar2 = this.e;
        int i = md.g;
        boolean z = md.e;
        int i2 = md.f;
        igVar2.f = new iy(context, i, "kKey", new iw(context, z, i2, i2 * 10, "carrierLocKey"));
        this.e.e = new hn();
    }

    private static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static byte[] c(int i) {
        return new byte[]{(byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (i & 255)};
    }

    public static /* synthetic */ byte[] f() {
        return a(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            mg.a();
            if (mm.m(this.f2958a)) {
                mg.a();
                return;
            }
            ArrayList<jn> arrayList = this.f;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<jn> arrayList2 = new ArrayList();
                synchronized (this.f) {
                    arrayList2.addAll(this.f);
                    this.f.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArrA = a(256);
                if (bArrA == null) {
                    return;
                }
                byteArrayOutputStream.write(c(bArrA.length));
                byteArrayOutputStream.write(bArrA);
                for (jn jnVar : arrayList2) {
                    byte[] bArrB = jnVar.b();
                    if (bArrB.length >= 10 && bArrB.length <= 65535) {
                        byte[] bArrB2 = fw.b(bArrA, bArrB, ge.c());
                        byteArrayOutputStream.write(c(bArrB2.length));
                        byteArrayOutputStream.write(bArrB2);
                        byteArrayOutputStream.write(b(jnVar.a()));
                    }
                }
                ih.a(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.e);
            }
        } catch (Throwable th) {
            me.a(th, "clm", "wtD");
        }
    }

    public final void d() {
        try {
            if (mm.m(this.f2958a)) {
                mg.a();
            } else {
                if (System.currentTimeMillis() - k < 60000) {
                    return;
                }
                jc.a().b(new b(2));
            }
        } catch (Throwable unused) {
        }
    }

    public final void e() {
        try {
            jc.a().b(new b(3));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends jd {
        private int b;
        private Location c;

        public b(int i) {
            this.b = i;
        }

        private void b() {
            try {
                mg.a();
                if (this.c != null && ld.this.j) {
                    if (mm.m(ld.this.f2958a)) {
                        mg.a();
                        return;
                    }
                    Bundle extras = this.c.getExtras();
                    int i = extras != null ? extras.getInt("satellites") : 0;
                    if (mm.a(this.c, i)) {
                        return;
                    }
                    ls lsVar = ld.this.b;
                    if (lsVar != null && !lsVar.s) {
                        lsVar.f();
                    }
                    ArrayList<kr> arrayListA = ld.this.b.a();
                    List<kk> listA = ld.this.c.a();
                    jl.a aVar = new jl.a();
                    kq kqVar = new kq();
                    kqVar.i = this.c.getAccuracy();
                    kqVar.f = this.c.getAltitude();
                    kqVar.d = this.c.getLatitude();
                    kqVar.h = this.c.getBearing();
                    kqVar.e = this.c.getLongitude();
                    kqVar.j = this.c.isFromMockProvider();
                    kqVar.f2945a = this.c.getProvider();
                    kqVar.g = this.c.getSpeed();
                    kqVar.l = (byte) i;
                    kqVar.b = System.currentTimeMillis();
                    kqVar.c = this.c.getTime();
                    kqVar.k = this.c.getTime();
                    aVar.f2933a = kqVar;
                    aVar.b = arrayListA;
                    WifiInfo wifiInfoC = ld.this.b.c();
                    if (wifiInfoC != null) {
                        aVar.c = kr.a(lp.a(wifiInfoC));
                    }
                    aVar.d = ls.z;
                    aVar.f = this.c.getTime();
                    aVar.g = (byte) fv.i(ld.this.f2958a);
                    aVar.h = fv.n(ld.this.f2958a);
                    aVar.e = ld.this.b.l();
                    aVar.j = mm.a(ld.this.f2958a);
                    aVar.i = listA;
                    jn jnVarA = kh.a(aVar);
                    if (jnVarA == null) {
                        return;
                    }
                    synchronized (ld.this.f) {
                        ld.this.f.add(jnVarA);
                        if (ld.this.f.size() >= 5) {
                            ld.this.e();
                        }
                    }
                    ld.this.d();
                }
            } catch (Throwable th) {
                me.a(th, "cl", "coll");
            }
        }

        private void c() {
            mg.a();
            if (mm.m(ld.this.f2958a)) {
                mg.a();
                return;
            }
            hu huVarA = null;
            try {
                long unused = ld.k = System.currentTimeMillis();
                if (ld.this.e.f.c()) {
                    huVarA = hu.a(new File(ld.this.e.f2905a), ld.this.e.b);
                    ArrayList arrayList = new ArrayList();
                    byte[] bArrF = ld.f();
                    if (bArrF == null) {
                        try {
                            huVarA.close();
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    List listB = ld.b(huVarA, ld.this.e, arrayList, bArrF);
                    if (listB != null && listB.size() != 0) {
                        ld.this.e.f.a(true);
                        if (kh.a(ge.b(kh.a(lt.a(bArrF), fw.b(bArrF, kh.a(), ge.c()), listB)))) {
                            ld.b(huVarA, arrayList);
                        }
                    }
                    try {
                        huVarA.close();
                        return;
                    } catch (Throwable unused3) {
                        return;
                    }
                }
                if (huVarA != null) {
                    try {
                        huVarA.close();
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable th) {
                try {
                    hd.c(th, "leg", "uts");
                    if (huVarA != null) {
                        try {
                            huVarA.close();
                        } catch (Throwable unused5) {
                        }
                    }
                } catch (Throwable th2) {
                    if (huVarA != null) {
                        try {
                            huVarA.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // com.amap.api.col.p0002sl.jd
        public final void a() {
            int i = this.b;
            if (i == 1) {
                b();
            } else if (i == 2) {
                c();
            } else if (i == 3) {
                ld.this.g();
            }
        }

        public b(ld ldVar, Location location) {
            this(1);
            this.c = location;
        }
    }

    public final void b() {
        try {
            mg.a();
            Handler handler = this.g;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.amap.api.col.2sl.ld.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ls lsVar;
                        try {
                            ld ldVar = ld.this;
                            if (ldVar.d == null || (lsVar = ldVar.b) == null) {
                                return;
                            }
                            kh.b(lsVar.a());
                        } catch (Throwable th) {
                            me.a(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            me.a(th, "cl", "upw");
        }
    }

    public final void c() {
        lm lmVar;
        try {
            mg.a();
            if (this.d == null || (lmVar = this.c) == null) {
                return;
            }
            kh.a(lmVar.a());
        } catch (Throwable th) {
            me.a(th, "cl", "upc");
        }
    }

    public final void a() {
        LocationManager locationManager;
        if (mm.m(this.f2958a)) {
            mg.a();
            return;
        }
        try {
            a aVar = this.i;
            if (aVar != null && (locationManager = this.h) != null) {
                locationManager.removeUpdates(aVar);
            }
            a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (this.j) {
                g();
                this.b.a((ld) null);
                this.c.a((ld) null);
                this.c = null;
                this.b = null;
                this.g = null;
                this.j = false;
            }
        } catch (Throwable th) {
            me.a(th, "clm", "stc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(hu huVar, List<String> list) {
        if (huVar != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    huVar.c(it.next());
                }
                huVar.close();
            } catch (Throwable th) {
                hd.c(th, t.p, "dlo");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:14|(3:105|15|16)|(2:107|17)|(1:(0))(3:97|22|(1:(2:103|25))(3:27|28|(10:33|(7:85|36|37|89|38|39|34)|114|42|95|43|44|87|45|(6:91|50|101|51|113|65)(0))(0)))|99|20) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
    
        r7.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00cc A[EXC_TOP_SPLITTER, PHI: r5 r9 r16
      0x00cc: PHI (r5v3 int) = (r5v4 int), (r5v5 int), (r5v5 int) binds: [B:61:0x00ee, B:75:0x00cc, B:50:0x00c9] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r9v1 com.amap.api.col.2sl.hu$b) = (r9v2 com.amap.api.col.2sl.hu$b), (r9v3 com.amap.api.col.2sl.hu$b), (r9v3 com.amap.api.col.2sl.hu$b) binds: [B:61:0x00ee, B:75:0x00cc, B:50:0x00c9] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r16v3 java.lang.String[]) = (r16v4 java.lang.String[]), (r16v6 java.lang.String[]), (r16v6 java.lang.String[]) binds: [B:61:0x00ee, B:75:0x00cc, B:50:0x00c9] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<jn> b(hu huVar, ig igVar, List<String> list, byte[] bArr) {
        String[] list2;
        String[] strArr;
        hu.b bVarA;
        String str;
        byte[] bArrA;
        byte[] bArr2;
        ArrayList arrayList = new ArrayList();
        try {
            File fileB = huVar.b();
            if (fileB == null || !fileB.exists() || (list2 = fileB.list()) == null) {
                return arrayList;
            }
            int length = list2.length;
            char c = 0;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str2 = list2[i];
                if (str2.contains(".0")) {
                    InputStream inputStreamA = null;
                    try {
                        str = str2.split("\\.")[c];
                    } catch (Throwable unused) {
                    }
                    try {
                        bVarA = huVar.a(str);
                    } catch (Throwable unused2) {
                        strArr = list2;
                        bVarA = null;
                        if (inputStreamA != null) {
                        }
                        if (bVarA == null) {
                        }
                        i++;
                        list2 = strArr;
                        c = 0;
                    }
                    if (bVarA != null) {
                        try {
                            inputStreamA = bVarA.a();
                        } catch (Throwable unused3) {
                            strArr = list2;
                        }
                        if (inputStreamA != null) {
                            byte[] bArr3 = new byte[2];
                            inputStreamA.read(bArr3);
                            int iB = mm.b(bArr3);
                            if (iB != 0 && iB <= 65535) {
                                byte[] bArr4 = new byte[iB];
                                inputStreamA.read(bArr4);
                                byte[] bArr5 = new byte[2];
                                int length2 = 0;
                                while (inputStreamA.read(bArr5) >= 0) {
                                    try {
                                        byte[] bArr6 = new byte[mm.b(bArr5)];
                                        inputStreamA.read(bArr6);
                                        bArrA = fw.a(bArr4, bArr6, ge.c());
                                        length2 += bArrA.length;
                                        bArr2 = new byte[4];
                                        inputStreamA.read(bArr2);
                                        strArr = list2;
                                    } catch (Throwable unused4) {
                                        strArr = list2;
                                    }
                                    try {
                                        arrayList.add(new jn(a(bArr2), fw.b(bArr, ge.b(bArrA), ge.c())));
                                        list2 = strArr;
                                    } catch (Throwable unused5) {
                                        if (inputStreamA != null) {
                                        }
                                        if (bVarA == null) {
                                            try {
                                                bVarA.close();
                                            } catch (Throwable unused6) {
                                            }
                                        }
                                        i++;
                                        list2 = strArr;
                                        c = 0;
                                    }
                                }
                                strArr = list2;
                                i2 += length2;
                                try {
                                    list.add(str);
                                    try {
                                    } catch (Throwable unused7) {
                                        if (inputStreamA != null) {
                                            try {
                                                inputStreamA.close();
                                            } catch (Throwable unused8) {
                                            }
                                        }
                                        if (bVarA == null) {
                                        }
                                        i++;
                                        list2 = strArr;
                                        c = 0;
                                    }
                                } catch (Throwable unused9) {
                                }
                                if (i2 <= igVar.f.b()) {
                                    try {
                                        inputStreamA.close();
                                    } catch (Throwable unused10) {
                                    }
                                    bVarA.close();
                                    i++;
                                    list2 = strArr;
                                    c = 0;
                                }
                            }
                        } else if (inputStreamA != null) {
                            try {
                                inputStreamA.close();
                            } catch (Throwable unused11) {
                            }
                        }
                    } else if (bVarA != null) {
                    }
                    bVarA.close();
                }
                strArr = list2;
                i++;
                list2 = strArr;
                c = 0;
            }
            return arrayList;
        } catch (Throwable th) {
            hd.c(th, t.p, "upc");
        }
        return arrayList;
        try {
            bVarA.close();
            break;
        } catch (Throwable unused12) {
        }
        return arrayList;
    }

    public final void a(lm lmVar, ls lsVar, Handler handler) {
        LocationManager locationManager;
        mg.a();
        if (this.j || lmVar == null || lsVar == null || handler == null) {
            return;
        }
        if (mm.m(this.f2958a)) {
            mg.a();
            return;
        }
        this.j = true;
        this.c = lmVar;
        this.b = lsVar;
        lsVar.a(this);
        this.c.a(this);
        this.g = handler;
        try {
            if (this.h == null) {
                this.h = (LocationManager) this.f2958a.getSystemService("location");
            }
            if (this.i == null) {
                this.i = new a(this);
            }
            this.i.a(this);
            a aVar = this.i;
            if (aVar != null && (locationManager = this.h) != null) {
                locationManager.requestLocationUpdates("passive", 1000L, -1.0f, aVar);
            }
            if (this.d == null) {
                kh khVar = new kh("6.4.5", fr.f(this.f2958a), "S128DF1572465B890OE3F7A13167KLEI", fr.c(this.f2958a), this);
                this.d = khVar;
                khVar.a(fv.k()).b(fv.f(this.f2958a)).c(fv.a(this.f2958a)).d(fv.e(this.f2958a)).e(fv.n()).f(fv.f()).g(Build.MODEL).h(Build.MANUFACTURER).i(Build.BRAND).a(Build.VERSION.SDK_INT).j(Build.VERSION.RELEASE).a(kr.a(fv.h())).k(fv.h());
                kh.b();
            }
        } catch (Throwable th) {
            me.a(th, "col", "init");
        }
    }

    public final void a(Location location) {
        try {
            Handler handler = this.g;
            if (handler != null) {
                handler.post(new b(this, location));
            }
        } catch (Throwable th) {
            hd.c(th, "cl", "olcc");
        }
    }

    @Override // com.amap.api.col.p0002sl.kx
    public final kw a(kv kvVar) {
        try {
            ly lyVar = new ly();
            lyVar.a(kvVar.b);
            lyVar.a(kvVar.f2948a);
            lyVar.a(kvVar.d);
            hx.a();
            ie ieVarC = hx.c(lyVar);
            kw kwVar = new kw();
            kwVar.c = ieVarC.f2902a;
            kwVar.b = ieVarC.b;
            kwVar.f2949a = 200;
            return kwVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(int i) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(EncryptUtils.AES_ENCRYPT_ALGORITHM);
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & UByte.MAX_VALUE) << 24) | (bArr[3] & UByte.MAX_VALUE) | ((bArr[2] & UByte.MAX_VALUE) << 8) | ((bArr[1] & UByte.MAX_VALUE) << 16);
    }
}
