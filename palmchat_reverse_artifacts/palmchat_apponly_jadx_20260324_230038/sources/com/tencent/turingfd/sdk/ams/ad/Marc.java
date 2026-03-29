package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.turingfd.sdk.ams.ad.Herbaceous.Cdo;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Marc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f10722a = System.currentTimeMillis();
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final Sculptor d = new Sculptor(false);
    public static final Sculptor e = new Sculptor(true);

    public static void a(Flat flat) {
        Herbaceous herbaceous = Herbaceous.l;
        herbaceous.f10705a = flat;
        if (!herbaceous.c) {
            herbaceous.c = true;
            Ccase.a(flat.b());
            HandlerThread handlerThread = new HandlerThread("TuringFdCore_90_" + Carambola.f10673a + "_ad", -8);
            handlerThread.start();
            herbaceous.b = herbaceous.new Cdo(handlerThread.getLooper(), flat.b());
            Hickory hickory = new Hickory(herbaceous.b);
            herbaceous.d = hickory;
            Lemon lemon = Lemon.g;
            lemon.d = flat;
            lemon.e = hickory;
            String str = Build.BRAND;
            if ("xiaomi".equalsIgnoreCase(str) || "redmi".equalsIgnoreCase(str)) {
                synchronized (lemon.f10712a) {
                    lemon.f10712a.add(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK));
                }
            }
            int[] iArr = Ccatch.f10752a;
            if (iArr.length > 0) {
                synchronized (lemon.f10712a) {
                    for (int i : iArr) {
                        lemon.f10712a.add(Integer.valueOf(i));
                    }
                }
            }
            lemon.b();
            new Grape(herbaceous).start();
        }
        Blackberry.a();
    }

    public static int b(Flat flat) {
        AtomicBoolean atomicBoolean = b;
        if (atomicBoolean.get()) {
            return 0;
        }
        boolean z = true;
        if (flat.h) {
            TextUtils.isEmpty(flat.k);
            String str = flat.k;
            try {
                if (TextUtils.isEmpty(str)) {
                    System.loadLibrary("turingad");
                } else {
                    System.load(str);
                }
            } catch (Throwable th) {
                Log.w("TuringFdJava", th);
                z = false;
            }
            b.set(z);
            if (!z) {
                Log.e("TuringFdJava", "load so failure");
            }
        } else {
            atomicBoolean.set(true);
        }
        return b.get() ? 0 : -10001;
    }

    public static int c(Flat flat) {
        Context contextB = flat.b();
        HashMap map = new HashMap();
        Kiwifruit kiwifruit = Kiwifruit.f;
        boolean zA = Triangulum.a();
        map.put("2008", (zA && kiwifruit.a("e_w_d", false)) ? "1" : "0");
        map.put("2009", (zA && kiwifruit.a("e_r_d", true)) ? "1" : "0");
        map.put("2010", (zA && kiwifruit.a("e_w_nd", true)) ? "1" : "0");
        map.put("2011", (zA && kiwifruit.a("e_r_nd", true)) ? "1" : "0");
        map.put("2025", "0");
        map.put("2028", flat.C ? "1" : "0");
        try {
            int iB = Pyxis.b(TNative$aa.i90_9F87DFDD2CC93068(new SparseArray(), contextB, map, d, e, Loquat.f10716a.b()));
            if (iB == 0) {
                return 0;
            }
            Log.e("TuringFdJava", "native init fail, err: " + iB);
            return -10020;
        } catch (Throwable th) {
            Log.e("TuringFdJava", "native init exception", th);
            return -10020;
        }
    }

    public static String b() {
        Flat flat;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.SIMPLIFIED_CHINESE, "TuringFD v%d", 90));
        sb.append(" (9F87DFDD2CC93068");
        sb.append(", ad");
        sb.append(", b8ba8c8");
        StringBuilder sb2 = new StringBuilder();
        if (!sb2.toString().isEmpty()) {
            sb2.append(x.aQ);
        }
        sb2.append("rfr");
        if (!sb2.toString().isEmpty()) {
            sb2.append(x.aQ);
        }
        sb2.append("rs");
        String string = sb2.toString();
        if (!TextUtils.isEmpty(string)) {
            sb.append(", ");
            sb.append(string);
        }
        sb.append(", ");
        StringBuilder sb3 = new StringBuilder();
        if (!sb3.toString().isEmpty()) {
            sb3.append(x.aQ);
        }
        sb3.append("wup");
        if (!sb3.toString().isEmpty()) {
            sb3.append(x.aQ);
        }
        sb3.append("105548");
        sb.append(sb3.toString());
        sb.append(String.format(Locale.SIMPLIFIED_CHINESE, ", compiled %s)", "2024_10_25_15_29_52"));
        synchronized (Flat.class) {
            flat = Flat.D;
        }
        if (flat != null) {
            sb.append(" [");
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sbA = Banana.a("url(");
            sbA.append(TextUtils.join(",", flat.i));
            sbA.append(")");
            String string2 = sbA.toString();
            if (!sb4.toString().isEmpty()) {
                sb4.append(x.aQ);
            }
            sb4.append(string2);
            String str = "c(" + flat.f + ")";
            if (!sb4.toString().isEmpty()) {
                sb4.append(x.aQ);
            }
            sb4.append(str);
            if (flat.z) {
                if (!sb4.toString().isEmpty()) {
                    sb4.append(x.aQ);
                }
                sb4.append("ext");
            }
            sb.append(sb4.toString());
            sb.append("]");
        }
        return sb.toString();
    }

    public static int a() {
        Flat flat;
        if (!c.get()) {
            return -10002;
        }
        if (Carambola.f10673a == 0) {
            return -10018;
        }
        if (!b.get()) {
            return -10001;
        }
        synchronized (Flat.class) {
            flat = Flat.D;
        }
        return !flat.c().userAgreement() ? -10019 : 0;
    }
}
