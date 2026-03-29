package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaDrm;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.p;
import com.huawei.hms.ads.dynamicloader.b;
import com.huawei.openalliance.ad.constant.x;
import com.igexin.assist.sdk.AssistPushConsts;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.turingfd.sdk.ams.ad.Blackberry;
import com.tencent.turingfd.sdk.ams.ad.Cprotected;
import com.tencent.turingfd.sdk.ams.ad.Ginkgo;
import com.tencent.turingfd.sdk.ams.ad.Perseus;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Herbaceous {
    public static final String i = Cfinally.a(Cfinally.b1);
    public static final String j = Cfinally.a(Cfinally.c1);
    public static final String k = Cfinally.a(Cfinally.d1);
    public static final Herbaceous l = new Herbaceous();
    public static final long m = TimeUnit.MINUTES.toMillis(30);
    public static final int[] n = {0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, p.j};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Flat f10705a;
    public Handler b;
    public Hickory d;
    public boolean c = false;
    public final Object e = new Object();
    public final AtomicReference<Ginkgo> f = new AtomicReference<>(null);
    public final AtomicReference<Boolean> g = new AtomicReference<>(Boolean.FALSE);
    public final AtomicReference<FutureTask<Cprotected.Cdo>> h = new AtomicReference<>(null);

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Herbaceous$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f10706a;

        public Cdo(Looper looper, Context context) {
            super(looper);
            this.f10706a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            System.currentTimeMillis();
            int i = message.what;
            if (i == 1) {
                Herbaceous.this.a(this.f10706a, true, 3);
                return;
            }
            if (i != 2) {
                return;
            }
            Herbaceous.this.a(Herbaceous.this.a(this.f10706a, true, false, ((Integer) message.obj).intValue()), false);
            synchronized (Herbaceous.this.g) {
                Herbaceous.this.g.set(Boolean.FALSE);
                Herbaceous.this.g.notifyAll();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Herbaceous herbaceous) {
        Context context;
        Context context2;
        long jLongValue;
        boolean z;
        String name;
        File file;
        herbaceous.getClass();
        synchronized (Ccase.class) {
            context = Ccase.f10751a;
        }
        Melon.a(context, herbaceous.d);
        herbaceous.f10705a.getClass();
        Lemon lemon = Lemon.g;
        lemon.getClass();
        try {
            System.currentTimeMillis();
            lemon.b(context);
            System.currentTimeMillis();
            lemon.b();
        } catch (Throwable unused) {
        }
        if (lemon.a(39)) {
            herbaceous.d.getClass();
            if (TextUtils.isEmpty(Hickory.b(context, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE))) {
                StringBuilder sb = new StringBuilder();
                try {
                    String[] strArrSplit = new String(Cstrictfp.a("/proc/self/maps")).split("\n");
                    HashSet hashSet = new HashSet();
                    for (String str : strArrSplit) {
                        String[] strArrSplit2 = str.split(" +");
                        if (strArrSplit2.length >= 2) {
                            String strTrim = strArrSplit2[strArrSplit2.length - 1].trim();
                            try {
                                file = new File(strTrim);
                            } catch (Throwable unused2) {
                                name = null;
                            }
                            if (file.exists()) {
                                name = file.getName();
                                if (name != null && name.contains("res") && name.endsWith(b.b) && !name.contains("mediatek") && !TextUtils.equals("/system/framework/framework-res.apk", strTrim) && !hashSet.contains(strTrim)) {
                                    hashSet.add(strTrim);
                                    String strA = Cvolatile.a(context, strTrim);
                                    if (strA != null && !TextUtils.equals(strA, "android.auto_generated_rro__") && !TextUtils.equals(strA, "android.overlay")) {
                                        if (sb.length() > 0) {
                                            sb.append(":");
                                        }
                                        sb.append(strA);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                }
                sb.append(",");
                String name2 = Resources.getSystem().getClass().getName();
                if (!TextUtils.equals("android.content.res.Resources", name2)) {
                    sb.append(name2);
                }
                herbaceous.d.a(context, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE, sb.toString().replace("(\\|)|\\s*|\t|\r|\n", ""), true);
            }
        }
        if (herbaceous.f10705a.u && lemon.a(45)) {
            Hickory hickory = herbaceous.d;
            int i2 = Core.b;
            hickory.getClass();
            try {
                jLongValue = Long.valueOf(Hickory.b(context, "902")).longValue();
            } catch (Throwable unused4) {
                jLongValue = 0;
            }
            if (Math.abs(jLongValue - System.currentTimeMillis()) >= Core.f10683a) {
                if (TextUtils.isEmpty(Hickory.b(context, "901"))) {
                    z = true;
                    if (z) {
                        Coconut coconutA = Cumquat.a(context);
                        if (coconutA.f10681a != 0) {
                            coconutA = Cumquat.a();
                        }
                        if (coconutA.f10681a == 0) {
                            String str2 = coconutA.d;
                            HashMap map = new HashMap();
                            map.put("901", str2);
                            Hickory.a(context, map);
                            String string = coconutA.toString();
                            HashMap map2 = new HashMap();
                            map2.put("904", string);
                            Hickory.a(context, map2);
                        }
                    }
                    hickory.b(context, System.currentTimeMillis());
                } else {
                    long jAbs = Math.abs(jLongValue - System.currentTimeMillis());
                    Kiwifruit kiwifruit = Kiwifruit.f;
                    long j2 = Kiwifruit.e;
                    String strA2 = kiwifruit.a("sid_refresh_period");
                    if (strA2 != null) {
                        try {
                            j2 = Long.parseLong(strA2) * 3600000;
                        } catch (NumberFormatException unused5) {
                        }
                    }
                    if (jAbs < j2) {
                        z = false;
                    }
                    if (z) {
                    }
                    hickory.b(context, System.currentTimeMillis());
                }
            }
        }
        Flat flat = herbaceous.f10705a;
        if (flat.r && flat.c().userAgreement()) {
            if (lemon.a(41)) {
                if (((ConcurrentHashMap) Perseus.f10734a).containsKey(Perseus.c)) {
                    new Pegasus((Perseus.Cdo) ((ConcurrentHashMap) Perseus.f10734a).get(Perseus.c), context).start();
                }
            }
            herbaceous.a(herbaceous.f10705a.b(), false, 0);
            String str3 = Blackberry.f10665a;
            synchronized (Ccase.class) {
                context2 = Ccase.f10751a;
            }
            if (Blackberry.a(context2) == null && Sagittarius.c(context)) {
                new Blackberry.Cdo(null, true).a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:356:0x099f  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x09b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0261  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Ginkgo b(Context context, boolean z, int i2) {
        long jLongValue;
        long j2;
        long j3;
        String string;
        long j4;
        int i3;
        long j5;
        boolean z2;
        HashMap map;
        HashMap map2;
        String strA;
        int i4;
        Map<Integer, String> features;
        Mandarin mandarinA;
        NetworkInfo activeNetworkInfo;
        boolean zA;
        boolean z3;
        FutureTask<Cprotected.Cdo> futureTask;
        long jA = Lemon.g.a(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i5 = Foxnut.g;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        ((HashMap) Ccontinue.f10755a).clear();
        HashMap map3 = new HashMap();
        StringBuilder sbA = Banana.a("");
        sbA.append(Carambola.f10673a);
        map3.put("1", sbA.toString());
        Flat flat = this.f10705a;
        if (flat != null && flat.v) {
            map3.put("2", "1");
        }
        Flat flat2 = this.f10705a;
        map3.put("101", TextUtils.isEmpty(flat2.q) ? "" : flat2.q);
        map3.put("207", this.d.a(context).f10700a);
        Flat flat3 = this.f10705a;
        map3.put("209", TextUtils.isEmpty(flat3.g) ? "" : flat3.g);
        boolean z4 = this.f10705a.t;
        Hickory hickory = this.d;
        StringBuilder sb = new StringBuilder();
        Cswitch.a(sb);
        sb.append(",");
        sb.append("F:");
        sb.append(z ? "1" : "0");
        sb.append(",");
        sb.append("PT:");
        sb.append(i5);
        sb.append(",");
        sb.append("PKG:");
        sb.append("1");
        sb.append(",");
        sb.append("SC:");
        sb.append(z4 ? "1" : "0");
        if (Carambola.f10673a == 105748) {
            sb.append(",");
            sb.append("SOTR:");
            sb.append(Cumquat.a().toString() + x.aQ + Cumquat.a(context).toString());
        }
        sb.append(",");
        sb.append("SRT:");
        sb.append(i2);
        String strB = Hickory.b(context, "204");
        if (TextUtils.isEmpty(strB)) {
            StringBuilder sbA2 = Banana.a("0_");
            sbA2.append(z ? "1" : "0");
            strB = sbA2.toString();
        }
        if (!TextUtils.isEmpty(strB)) {
            sb.append(",");
            sb.append("R:");
            sb.append(strB);
        }
        sb.append(",");
        sb.append("US:");
        try {
            jLongValue = Long.valueOf(Hickory.b(context, "503")).longValue();
        } catch (Throwable unused) {
            jLongValue = 0;
        }
        sb.append(jLongValue);
        sb.append("_");
        sb.append(hickory.a(context, "502"));
        sb.append("_");
        sb.append(Process.myUid());
        sb.append(",");
        sb.append("STIF:");
        sb.append(Hickory.b(context, "904"));
        sb.append(",");
        sb.append("GCI:");
        sb.append("b8ba8c8");
        map3.put("210", sb.toString());
        Lemon lemon = Lemon.g;
        map3.put("2001", lemon.a());
        Kiwifruit kiwifruit = Kiwifruit.f;
        int i6 = Carambola.f10673a;
        if (i6 == 105668 || i6 == 105928) {
            if (!lemon.a(17) && !lemon.a(18)) {
                map3.put("1001", "2");
            }
        } else if (!z) {
            map3.put("1001", "1");
        }
        StringBuilder sbA3 = Banana.a("");
        String strA2 = kiwifruit.a("m_p_s");
        if (strA2 == null) {
            j2 = 300;
        } else {
            try {
                j2 = Long.parseLong(strA2) * 1;
            } catch (NumberFormatException unused2) {
                j2 = 300;
            }
        }
        sbA3.append((int) j2);
        map3.put("2012", sbA3.toString());
        if (lemon.a(136) && Triangulum.a(context, k) == 0) {
            map3.put("501", "1");
        }
        if (lemon.a(MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE)) {
            if (Triangulum.a(context, i) == 0) {
                z3 = true;
                if (z3) {
                    map3.put("2020", "-2");
                } else {
                    synchronized (this.h) {
                        futureTask = this.h.get();
                        if (futureTask == null) {
                            futureTask = new FutureTask<>(new Guava(this));
                            Cpackage.b.submit(futureTask);
                            this.h.set(futureTask);
                        }
                    }
                    try {
                        Cprotected.Cdo cdo = futureTask.get(1L, TimeUnit.SECONDS);
                        if (cdo == null) {
                            map3.put("2020", "-1");
                        } else if (!cdo.b || kiwifruit.a("ig_g_a_l", false)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(cdo.b ? "1" : "0");
                            sb2.append(",");
                            sb2.append(cdo.f10768a);
                            map3.put("2020", sb2.toString());
                        } else {
                            map3.put("2020", "1");
                        }
                    } catch (Throwable unused3) {
                        map3.put("2020", "-3");
                    }
                }
            } else {
                if (!context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.containsKey(j)) {
                    z3 = false;
                }
                if (z3) {
                }
            }
        }
        int i7 = 2;
        if (this.f10705a.B || lemon.a(144)) {
            String strA3 = Kiwifruit.f.a("d_i_l");
            if (strA3 == null) {
                strA3 = Kiwifruit.d;
            }
            if (TextUtils.isEmpty(strA3)) {
                j3 = jA;
                string = null;
            } else {
                StringBuilder sb3 = new StringBuilder();
                String[] strArrSplit = strA3.split(",");
                int length = strArrSplit.length;
                int i8 = 0;
                while (i8 < length) {
                    String[] strArrSplit2 = strArrSplit[i8].split(":");
                    if (strArrSplit2.length != i7) {
                        j4 = jA;
                    } else {
                        try {
                            j4 = jA;
                            try {
                                String strA4 = a(Long.parseLong(strArrSplit2[0], 16), Long.parseLong(strArrSplit2[1], 16));
                                if (!TextUtils.isEmpty(strA4)) {
                                    if (sb3.length() > 0) {
                                        sb3.append(",");
                                    }
                                    sb3.append(strA4);
                                }
                            } catch (Throwable unused4) {
                            }
                        } catch (Throwable unused5) {
                            j4 = jA;
                        }
                    }
                    i8++;
                    jA = j4;
                    i7 = 2;
                }
                j3 = jA;
                string = sb3.toString();
            }
            if (TextUtils.isEmpty(string)) {
                map3.put("2023", "");
            } else {
                map3.put("2023", string);
            }
        } else {
            j3 = jA;
        }
        Lemon lemon2 = Lemon.g;
        Kiwifruit kiwifruit2 = Kiwifruit.f;
        if (lemon2.a(41)) {
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            Phoenix phoenixA = Perseus.b;
            if (phoenixA == null || phoenixA.b == 0) {
                if (!((ConcurrentHashMap) Perseus.f10734a).containsKey(Perseus.c)) {
                    phoenixA = Phoenix.a(-10);
                } else if ("main".equals(Thread.currentThread().getName())) {
                    phoenixA = Phoenix.a(-11);
                } else {
                    Perseus.Cdo cdo2 = (Perseus.Cdo) ((ConcurrentHashMap) Perseus.f10734a).get(Perseus.c);
                    if (cdo2 != null && (i3 = cdo2.b) <= 3) {
                        cdo2.b = i3 + 1;
                        Perseus.b = cdo2.f10735a.a(context);
                    }
                    phoenixA = Perseus.b;
                    j5 = jCurrentTimeMillis;
                    z2 = true;
                    map = map3;
                    Gooseberry.a(map3, "100", phoenixA.f10736a, jCurrentTimeMillis3, 20);
                }
                j5 = jCurrentTimeMillis;
                z2 = true;
                map = map3;
                Gooseberry.a(map3, "100", phoenixA.f10736a, jCurrentTimeMillis3, 20);
            } else {
                j5 = jCurrentTimeMillis;
                z2 = true;
                map = map3;
                Gooseberry.a(map3, "100", phoenixA.f10736a, jCurrentTimeMillis3, 20);
            }
        } else {
            map3.put("2003", "0");
            j5 = jCurrentTimeMillis;
            z2 = true;
            map = map3;
        }
        ITuringDeviceInfoProvider iTuringDeviceInfoProvider = this.f10705a.c;
        if (iTuringDeviceInfoProvider != null) {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            map2 = map;
            new Haw(this, atomicBoolean, map, iTuringDeviceInfoProvider, jCurrentTimeMillis4, obj).start();
            synchronized (obj) {
                try {
                    obj.wait(1000L);
                } catch (InterruptedException unused6) {
                }
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis4 > 1000) {
                Log.w("Turing", "invoke info impl timeout");
            }
            atomicBoolean.set(z2);
        } else {
            map2 = map;
        }
        HashMap map4 = map2;
        map4.put("264", Cdefault.a());
        if (lemon2.a(22)) {
            map4.put("205", Cextends.a(context));
            Ccontinue.a(8, Long.valueOf("" + Cextends.f).longValue());
        }
        if (!lemon2.a(10002)) {
            map4.put("2005", "0");
        }
        if (!lemon2.a(10003)) {
            map4.put("2006", "0");
        }
        map4.put("266", Hickory.b(context, "901"));
        if (lemon2.a(115)) {
            String strB2 = Octans.b();
            if (strB2 == null) {
                strB2 = "";
            }
            map4.put("268", strB2);
        }
        if (lemon2.a(116)) {
            String strA5 = Centaurus.a();
            if (strA5 == null) {
                strA5 = "";
            }
            map4.put("269", strA5);
        }
        if (lemon2.a(117)) {
            StringBuilder sbA4 = Banana.a("");
            sbA4.append(Octans.a(context));
            map4.put("270", sbA4.toString());
        }
        if (lemon2.a(46)) {
            StringBuilder sbA5 = Banana.a("");
            sbA5.append(Ctransient.a());
            map4.put("271", sbA5.toString());
        }
        if (lemon2.a(118)) {
            StringBuilder sbA6 = Banana.a("");
            sbA6.append(Chamaeleon.b());
            map4.put("272", sbA6.toString());
        }
        if (lemon2.a(17) || lemon2.a(40)) {
            List<String> listA = UrsaMajor.a(this.f10705a.d);
            HashSet hashSet = new HashSet();
            if (!Cimport.a(listA)) {
                hashSet.addAll(listA);
            }
            Set<String> setC = kiwifruit2.c();
            if (setC != null) {
                hashSet.addAll(setC);
            }
            hashSet.add(context.getPackageName());
            map4.put("277", UrsaMajor.a(hashSet));
        }
        if (lemon2.a(122)) {
            try {
                strA = Cwhile.a();
            } catch (Throwable unused7) {
                strA = "exception";
            }
            map4.put("280", strA);
        }
        if (lemon2.a(126)) {
            map4.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        }
        String strA6 = kiwifruit2.a("x_l2_p_i");
        if (strA6 != null) {
            map4.put("2014", strA6);
        }
        String strA7 = kiwifruit2.a("x_u_p_i");
        if (strA7 != null) {
            map4.put("2015", strA7);
        }
        String strA8 = kiwifruit2.a();
        if (strA8 != null) {
            map4.put("2013", strA8);
        }
        Lemon lemon3 = Lemon.g;
        if (lemon3.a(39)) {
            this.d.getClass();
            map4.put("239", Hickory.b(context, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE));
        }
        if (lemon3.a(100)) {
            long jCurrentTimeMillis5 = System.currentTimeMillis();
            String strA9 = Centaurus.a(context);
            if (strA9 == null) {
                strA9 = "";
            }
            Gooseberry.a(map4, "250", strA9, jCurrentTimeMillis5, 30);
        }
        if (lemon3.a(101)) {
            long jCurrentTimeMillis6 = System.currentTimeMillis();
            int iB = Pear.b(context);
            map4.put("251", iB > 0 ? "1" : "0");
            map4.put("288", String.valueOf(iB));
            Ccontinue.a(31, System.currentTimeMillis() - jCurrentTimeMillis6);
        }
        if (lemon3.a(102)) {
            i4 = 0;
            map4.put("252", Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0 ? "1" : "0");
        } else {
            i4 = 0;
        }
        if (lemon3.a(103)) {
            StringBuilder sbA7 = Banana.a("");
            sbA7.append(Octans.d(context));
            map4.put("253", sbA7.toString());
        }
        if (lemon3.a(104)) {
            StringBuilder sbA8 = Banana.a("");
            sbA8.append(Octans.b(context));
            map4.put("254", sbA8.toString());
        }
        if (lemon3.a(105)) {
            StringBuilder sbA9 = Banana.a("");
            sbA9.append(Cgoto.a(context));
            map4.put("255", sbA9.toString());
        }
        if (lemon3.a(106)) {
            long jCurrentTimeMillis7 = System.currentTimeMillis();
            String strA10 = Octans.a();
            if (strA10 == null) {
                strA10 = "";
            }
            Gooseberry.a(map4, "256", strA10, jCurrentTimeMillis7, 32);
        }
        if (lemon3.a(107)) {
            String strF = Octans.f(context);
            if (strF == null) {
                strF = "";
            }
            map4.put("257", strF);
        }
        if (lemon3.a(113)) {
            Gooseberry.a(map4, "258", Vulpecula.a() ? "1" : "0", System.currentTimeMillis(), 40);
        }
        if (lemon3.a(114)) {
            long jCurrentTimeMillis8 = System.currentTimeMillis();
            try {
                zA = Vulpecula.a(context);
            } catch (Throwable unused8) {
                zA = false;
            }
            Gooseberry.a(map4, "259", zA ? "1" : "0", jCurrentTimeMillis8, 41);
        }
        if (lemon3.a(44)) {
            long jCurrentTimeMillis9 = System.currentTimeMillis();
            map4.put("240", Filbert.a());
            Ccontinue.a(42, System.currentTimeMillis() - jCurrentTimeMillis9);
        }
        if (lemon3.a(138)) {
            map4.put("282", Octans.c(context));
        }
        StringBuilder sbA10 = Banana.a("");
        sbA10.append(this.f10705a.n);
        map4.put("403", sbA10.toString());
        map4.put("402", this.f10705a.l);
        map4.put("404", this.f10705a.m);
        map4.put("401", this.f10705a.o);
        this.f10705a.getClass();
        map4.put(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE, null);
        Map<Integer, String> map5 = this.f10705a.p;
        StringBuilder sb4 = new StringBuilder();
        Iterator<Integer> it = map5.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            sb4.append(iIntValue);
            sb4.append("_");
            sb4.append(Damson.a(",", "%54", Damson.a("_", "%5F", map5.get(Integer.valueOf(iIntValue)))));
            if (it.hasNext()) {
                sb4.append(",");
            }
        }
        map4.put("406", sb4.toString());
        this.d.getClass();
        map4.put("302", Hickory.b(context, ErrorContants.REALTIME_LOADAD_ERROR));
        this.d.getClass();
        map4.put("303", Hickory.b(context, ErrorContants.INIT_LOADAD_ERROR));
        this.d.getClass();
        map4.put("305", Hickory.b(context, "203"));
        map4.put("308", "" + ((int) Sagittarius.a(context)));
        this.d.getClass();
        map4.put("309", Hickory.b(context, "404"));
        this.d.getClass();
        map4.put("310", Hickory.b(context, "205"));
        ITuringIoTFeatureMap iTuringIoTFeatureMap = this.f10705a.e;
        if (iTuringIoTFeatureMap == null || (features = iTuringIoTFeatureMap.getFeatures(context)) == null || features.isEmpty()) {
            features = null;
        }
        try {
            SparseArray<Object> sparseArrayA90_9F87DFDD2CC93068 = TNative$aa.a90_9F87DFDD2CC93068(new SparseArray(), context, map4, features, i5);
            this.d.a(context, ErrorContants.REALTIME_LOADAD_ERROR, (System.currentTimeMillis() - jCurrentTimeMillis2) + "_" + (z ? 1 : 0));
            int iB2 = Pyxis.b(sparseArrayA90_9F87DFDD2CC93068);
            byte[] bArrA = Pyxis.a(sparseArrayA90_9F87DFDD2CC93068);
            StringBuilder sb5 = new StringBuilder();
            String str = (String) Pyxis.a(sparseArrayA90_9F87DFDD2CC93068, 2, String.class);
            int i9 = Damson.f10689a;
            if (str == null) {
                str = "";
            }
            sb5.append(str);
            StringBuilder sb6 = new StringBuilder();
            Iterator it2 = ((HashMap) Ccontinue.f10755a).keySet().iterator();
            while (it2.hasNext()) {
                int iIntValue2 = ((Integer) it2.next()).intValue();
                sb6.append(",");
                sb6.append(iIntValue2);
                sb6.append("_");
                sb6.append(((HashMap) Ccontinue.f10755a).get(Integer.valueOf(iIntValue2)));
            }
            sb5.append(sb6.toString());
            this.d.a(context, "205", sb5.toString());
            Hickory hickory2 = this.d;
            long length2 = bArrA.length;
            hickory2.getClass();
            hickory2.a(context, "203", "" + length2 + "_" + (z ? 1 : 0));
            mandarinA = iB2 != 0 ? Mandarin.a(iB2) : bArrA.length == 0 ? Mandarin.a(-10003) : new Mandarin(i4, bArrA);
        } catch (Throwable unused9) {
            mandarinA = Mandarin.a(-10006);
        }
        Mandarin mandarin = mandarinA;
        long jCurrentTimeMillis10 = System.currentTimeMillis() - j5;
        int i10 = mandarin.f10719a;
        if (i10 != 0) {
            return Ginkgo.a(i10);
        }
        long jCurrentTimeMillis11 = System.currentTimeMillis();
        Mango mangoA = Longan.b.a(1, mandarin.b, 8117, 18117, null);
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null || !message.contains("ACCESS_NETWORK_STATE")) {
                z2 = false;
            }
            if (!z2) {
            }
        }
        if (activeNetworkInfo == null || !(activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
            i4 = -1;
        } else if (activeNetworkInfo.getType() != z2) {
            if (activeNetworkInfo.getType() != 0) {
                i4 = 3;
            } else if (Proxy.getDefaultHost() == null) {
                i4 = Proxy.getHost(context) != null ? 2 : 1;
            }
        }
        this.d.a(context, ErrorContants.INIT_LOADAD_ERROR, i4 + "_" + (System.currentTimeMillis() - jCurrentTimeMillis11) + "_" + j3 + "_" + (z ? 1 : 0) + "_" + mandarin.b.length + "_" + jCurrentTimeMillis10 + "_" + (System.currentTimeMillis() - j5));
        int i11 = mangoA.f10720a;
        return i11 != 0 ? new Ginkgo(i11, Ginkgo.j, mangoA.b, mangoA.c) : a(context, mangoA.d, Foxnut.g);
    }

    public Ginkgo a(Context context) {
        Ginkgo ginkgo;
        Ginkgo ginkgoA;
        synchronized (this.f) {
            ginkgo = this.f.get();
            if (ginkgo == null) {
                Hickory hickory = this.d;
                if (hickory != null) {
                    ginkgoA = hickory.a(context);
                } else {
                    ginkgoA = Ginkgo.a(1);
                }
                ginkgo = ginkgoA;
                this.f.set(ginkgo);
            }
        }
        return ginkgo;
    }

    public final void a(Ginkgo ginkgo, boolean z) {
        synchronized (this.f) {
            try {
                if (ginkgo == null) {
                    return;
                }
                if (z || ginkgo.c == 0) {
                    this.f.set(ginkgo);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        synchronized (this.g) {
            if (this.g.get().booleanValue()) {
                return;
            }
            this.g.set(Boolean.TRUE);
            this.b.sendMessageDelayed(Message.obtain(this.b, 2, 3), 0L);
        }
    }

    public final Ginkgo a(Context context, boolean z, int i2) {
        Ginkgo ginkgoA;
        Ginkgo ginkgoA2 = a(context);
        if (this.f10705a == null) {
            return Ginkgo.a(-10002);
        }
        int iA = a(ginkgoA2);
        if (iA == 1) {
            return ginkgoA2;
        }
        if (iA != 2) {
            if (iA == 3) {
                a();
            }
            return ginkgoA2;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
            return Ginkgo.a(-10008);
        }
        synchronized (this.e) {
            ginkgoA = a(context);
            if (ginkgoA == ginkgoA2 || a(ginkgoA) != 1) {
                synchronized (this.g) {
                    if (!this.g.get().booleanValue()) {
                        this.g.set(Boolean.TRUE);
                        this.b.post(new Grapefruit(this, context, true, i2));
                    }
                    try {
                        this.g.wait(z ? this.f10705a.w : 10000L);
                    } catch (InterruptedException unused) {
                    }
                }
                ginkgoA = a(context);
                if (ginkgoA == ginkgoA2) {
                    ginkgoA = Ginkgo.a(-10004);
                }
            }
        }
        return ginkgoA;
    }

    public final int a(Ginkgo ginkgo) {
        Context context;
        long jLongValue;
        Context context2;
        if (this.f10705a.s || ginkgo.c != 0 || TextUtils.isEmpty(ginkgo.f10700a)) {
            return 2;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (jCurrentTimeMillis >= ginkgo.b) {
            this.f10705a.getClass();
            return 3;
        }
        Hickory hickory = this.d;
        synchronized (Ccase.class) {
            context = Ccase.f10751a;
        }
        hickory.getClass();
        try {
            jLongValue = Long.valueOf(Hickory.b(context, "107")).longValue();
        } catch (Throwable unused) {
            jLongValue = 0;
        }
        Hickory hickory2 = this.d;
        synchronized (Ccase.class) {
            context2 = Ccase.f10751a;
        }
        if (Math.abs(jCurrentTimeMillis - hickory2.a(context2, "108")) < jLongValue) {
            return 1;
        }
        this.f10705a.getClass();
        return 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Ginkgo a(Context context, boolean z, boolean z2, int i2) {
        Context context2;
        Context context3;
        String strA;
        Ginkgo ginkgoA;
        long jLongValue;
        Context context4;
        Context context5;
        boolean z3;
        Context context6;
        long jLongValue2;
        boolean z4;
        if (!Sagittarius.c(context)) {
            return Ginkgo.a(-10012);
        }
        if (!this.f10705a.s) {
            synchronized (Ccase.class) {
                context4 = Ccase.f10751a;
            }
            if (!(Math.abs((System.currentTimeMillis() / 1000) - (this.d.a(context4, "109") / 1000)) > 3600)) {
                return Ginkgo.a(-30015);
            }
            Hickory hickory = this.d;
            synchronized (Ccase.class) {
                context5 = Ccase.f10751a;
            }
            Gemini<Long> geminiA = hickory.a(context5, 30);
            if (geminiA.b.size() == 0) {
                z3 = true;
                if (!z3) {
                    return Ginkgo.a(-10011);
                }
            } else {
                Hickory hickory2 = this.d;
                synchronized (Ccase.class) {
                    context6 = Ccase.f10751a;
                }
                hickory2.getClass();
                try {
                    jLongValue2 = Long.valueOf(Hickory.b(context6, "401")).longValue();
                } catch (Throwable unused) {
                    jLongValue2 = 0;
                }
                if (jLongValue2 <= 0) {
                    z4 = true;
                    if (!z4) {
                        Long first = geminiA.b.getFirst();
                        if (geminiA.b.size() >= geminiA.f10699a && Math.abs(System.currentTimeMillis() - first.longValue()) < m) {
                        }
                    } else if (!z2) {
                        z3 = false;
                    }
                    if (!z3) {
                    }
                } else {
                    long jAbs = Math.abs(System.currentTimeMillis() - geminiA.b.getLast().longValue());
                    int[] iArr = n;
                    int length = jLongValue2 < ((long) iArr.length) ? (int) jLongValue2 : iArr.length - 1;
                    if (length >= 1) {
                        if (iArr[length - 1] >= iArr[length]) {
                            throw new IllegalArgumentException("");
                        }
                        if (jAbs <= TimeUnit.SECONDS.toMillis(new Random().nextInt((r10 - r9) + 1) + r9)) {
                            z4 = false;
                        }
                        if (!z4) {
                        }
                        if (!z3) {
                        }
                    }
                }
            }
        }
        Hickory hickory3 = this.d;
        synchronized (Ccase.class) {
            context2 = Ccase.f10751a;
        }
        Gemini<Long> geminiA2 = hickory3.a(context2, 30);
        geminiA2.a(Long.valueOf(System.currentTimeMillis()));
        Hickory hickory4 = this.d;
        synchronized (Ccase.class) {
            context3 = Ccase.f10751a;
        }
        hickory4.getClass();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < geminiA2.b.size(); i3++) {
            sb.append(geminiA2.b.get(i3));
            if (i3 != geminiA2.b.size() - 1) {
                sb.append("_");
            }
        }
        hickory4.a(context3, "402", sb.toString(), true);
        synchronized (Taurus.class) {
            strA = Taurus.a(context, Taurus.f10742a);
        }
        if (!TextUtils.isEmpty(strA)) {
            this.d.a(context, "404", strA, true);
        }
        Melon.a(context, this.d);
        Hickory hickory5 = this.d;
        long jA = hickory5.a(context, "502");
        int iMyUid = Process.myUid();
        if (jA == 0) {
            hickory5.c(context, 0L);
        } else if (jA != 0 && iMyUid != jA) {
            hickory5.c(context, -1L);
        } else {
            hickory5.c(context, 1L);
        }
        if (Kiwifruit.f.a("e_b_d", false)) {
            SparseArray sparseArray = new SparseArray();
            TNative$aa.c90_9F87DFDD2CC93068(sparseArray, context);
            Pyxis.b(sparseArray);
        }
        try {
            ginkgoA = b(context, z, i2);
        } catch (Throwable th) {
            Log.w("TuringFdJava", th);
            ginkgoA = Ginkgo.a(-10015);
        }
        if (ginkgoA.c == -30015) {
            Hickory hickory6 = this.d;
            long jCurrentTimeMillis = System.currentTimeMillis();
            hickory6.getClass();
            hickory6.a(context, "109", "" + jCurrentTimeMillis, true);
        } else if (this.d.a(context, "109") != 0) {
            Hickory hickory7 = this.d;
            hickory7.getClass();
            hickory7.a(context, "109", "0", true);
        }
        this.d.getClass();
        try {
            jLongValue = Long.valueOf(Hickory.b(context, "401")).longValue();
        } catch (Throwable unused2) {
            jLongValue = 0;
        }
        if (ginkgoA.c < 0) {
            this.d.a(context, jLongValue + 1);
        } else if (jLongValue != 0) {
            this.d.a(context, 0L);
        }
        this.d.getClass();
        if (!TextUtils.isEmpty(Hickory.b(context, "404"))) {
            this.d.a(context, "404", "", true);
        }
        if (ginkgoA.c == 0) {
            Hickory hickory8 = this.d;
            String str = Melon.f10723a;
            long jA2 = hickory8.a(context, "502");
            long jMyUid = Process.myUid();
            if (jA2 != jMyUid) {
                hickory8.a(context, "502", "" + jMyUid, false);
            }
        }
        this.d.a(context, "204", String.format("%d_%d_%d_%d_%d_%d", Integer.valueOf(ginkgoA.c), Integer.valueOf(z ? 1 : 0), Integer.valueOf(i2), 0, Integer.valueOf(ginkgoA.h), Integer.valueOf(ginkgoA.i)));
        return ginkgoA;
    }

    public final Ginkgo a(Context context, byte[] bArr, int i2) {
        try {
            HashMap map = new HashMap();
            if (Kiwifruit.f.a("e_w_t", false)) {
                map.put("2007", "1");
            }
            SparseArray<Object> sparseArrayB90_9F87DFDD2CC93068 = TNative$aa.b90_9F87DFDD2CC93068(new SparseArray(), bArr, map, i2);
            int iB = Pyxis.b(sparseArrayB90_9F87DFDD2CC93068);
            if (iB != 0) {
                return Ginkgo.a(iB);
            }
            Integer num = (Integer) Pyxis.a(sparseArrayB90_9F87DFDD2CC93068, 102, Integer.class);
            if (num == null) {
                return Ginkgo.a(-30000);
            }
            if (num.intValue() < 0) {
                return Ginkgo.a(num.intValue() - 30000);
            }
            String str = (String) Pyxis.a(sparseArrayB90_9F87DFDD2CC93068, 101, String.class);
            int i3 = Damson.f10689a;
            if (str == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return Ginkgo.a(num.intValue() - 10010);
            }
            String str2 = (String) Pyxis.a(sparseArrayB90_9F87DFDD2CC93068, 104, String.class);
            if (str2 == null) {
                str2 = "";
            }
            String str3 = (String) Pyxis.a(sparseArrayB90_9F87DFDD2CC93068, 105, String.class);
            if (str3 == null) {
                str3 = "";
            }
            String str4 = (String) Pyxis.a(sparseArrayB90_9F87DFDD2CC93068, 106, String.class);
            if (str4 == null) {
                str4 = "";
            }
            Integer num2 = (Integer) Pyxis.a(sparseArrayB90_9F87DFDD2CC93068, 107, Integer.class);
            String str5 = (String) Pyxis.a(sparseArrayB90_9F87DFDD2CC93068, 108, String.class);
            if (str5 == null) {
                str5 = "";
            }
            if (num2 == null || num2.intValue() < 3600) {
                num2 = 3600;
            }
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + ((long) num2.intValue());
            Ginkgo.Cdo cdo = new Ginkgo.Cdo(0);
            cdo.b = jCurrentTimeMillis;
            cdo.f10701a = str;
            cdo.d = str2;
            cdo.e = str3;
            cdo.f = str4;
            cdo.g = str5;
            Ginkgo ginkgo = new Ginkgo(cdo);
            Hickory hickory = this.d;
            hickory.getClass();
            HashMap map2 = new HashMap();
            map2.put("101", ginkgo.f10700a);
            map2.put("102", "" + ginkgo.b);
            if (!TextUtils.isEmpty(ginkgo.d)) {
                map2.put("104", ginkgo.d);
            }
            if (!TextUtils.isEmpty(ginkgo.e)) {
                map2.put("105", ginkgo.e);
            }
            if (!TextUtils.isEmpty(ginkgo.f)) {
                map2.put("106", ginkgo.f);
            }
            if (!TextUtils.isEmpty(ginkgo.g)) {
                map2.put("110", ginkgo.g);
            }
            hickory.a(context, (Map<String, String>) map2, true);
            Hickory hickory2 = this.d;
            long jIntValue = num2.intValue();
            hickory2.getClass();
            hickory2.a(context, "107", "" + jIntValue, true);
            hickory2.a(context, "108", "" + (System.currentTimeMillis() / 1000), true);
            return ginkgo;
        } catch (Throwable unused) {
            return Ginkgo.a(-10007);
        }
    }

    public static String a(long j2, long j3) {
        MediaDrm mediaDrm;
        UUID uuid;
        try {
            uuid = new UUID(j2, j3);
            mediaDrm = new MediaDrm(uuid);
        } catch (Throwable unused) {
            mediaDrm = null;
        }
        try {
            byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray.length == 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        mediaDrm.release();
                    } else {
                        mediaDrm.release();
                    }
                } catch (Throwable unused2) {
                }
                return null;
            }
            String str = uuid + ":" + Damson.a(propertyByteArray);
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    mediaDrm.release();
                } else {
                    mediaDrm.release();
                }
            } catch (Throwable unused3) {
            }
            return str;
        } catch (Throwable unused4) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (mediaDrm != null) {
                        mediaDrm.release();
                    }
                } else if (mediaDrm != null) {
                    mediaDrm.release();
                }
            } catch (Throwable unused5) {
            }
            return null;
        }
    }
}
