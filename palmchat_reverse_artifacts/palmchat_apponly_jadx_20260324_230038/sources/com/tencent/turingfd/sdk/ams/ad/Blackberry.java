package com.tencent.turingfd.sdk.ams.ad;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.turingfd.sdk.ams.ad.Cthrow;
import com.umeng.analytics.pro.bd;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Blackberry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10665a = Cfinally.a(Cfinally.Z0);
    public static final String b = Cfinally.a(Cfinally.d1);
    public static final AtomicReference<Bryony> c = new AtomicReference<>(null);

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Blackberry$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cdo implements Callable<Bryony> {
        public static final HashMap<String, FutureTask<Bryony>> d = new HashMap<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10666a;
        public final Map<Integer, String> b;
        public final boolean c;

        /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Blackberry$do$do, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0893do implements Comparator<Integer> {
            public C0893do(Cdo cdo) {
            }

            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return num.intValue() - num2.intValue();
            }
        }

        public Cdo(Map<Integer, String> map, boolean z) {
            this.b = map;
            this.c = z;
            if (map == null || map.isEmpty()) {
                this.f10666a = "";
                return;
            }
            TreeMap treeMap = new TreeMap(new C0893do(this));
            treeMap.putAll(map);
            Iterator it = treeMap.keySet().iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append((String) treeMap.get((Integer) it.next()));
            }
            this.f10666a = sb.toString();
        }

        public FutureTask<Bryony> a() {
            FutureTask<Bryony> futureTask;
            HashMap<String, FutureTask<Bryony>> map = d;
            synchronized (map) {
                Iterator<Map.Entry<String, FutureTask<Bryony>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().isDone()) {
                        it.remove();
                    }
                }
                HashMap<String, FutureTask<Bryony>> map2 = d;
                futureTask = map2.get(this.f10666a);
                if (futureTask == null || futureTask.isDone()) {
                    futureTask = new FutureTask<>(this);
                    Cpackage.f10766a.submit(futureTask);
                    map2.put(this.f10666a, futureTask);
                }
            }
            return futureTask;
        }

        @Override // java.util.concurrent.Callable
        public Bryony call() throws Exception {
            Context context;
            synchronized (Ccase.class) {
                context = Ccase.f10751a;
            }
            Betelnut betelnut = new Betelnut();
            try {
                Lemon.g.a(context);
                betelnut.b = 1;
                betelnut.e = System.currentTimeMillis();
                byte[] bArrA = Blackberry.a(context, this.b, betelnut, this.c);
                betelnut.f = System.currentTimeMillis();
                betelnut.c = bArrA.length;
                Bryony bryonyA = Blackberry.a(context, bArrA, betelnut);
                Blackberry.a(context, bryonyA);
                Blackberry.a(context, betelnut);
                return bryonyA;
            } catch (Throwable unused) {
                return new Bryony(-10015);
            }
        }
    }

    public static void a() {
        Context context;
        Gemini<Cfinal> gemini = Berry.f10663a;
        if (Kiwifruit.f.a("enable_risk_click", Carambola.b)) {
            if (Build.VERSION.SDK_INT >= 28 && !Cbreak.a()) {
                Apricot.a();
            }
            Log.i("TRCDM", "erc");
            Nectarine nectarine = Berry.e;
            synchronized (Cthrow.class) {
                WeakHashMap<Activity, Object> weakHashMap = Cthrow.f10776a;
                if (nectarine != null) {
                    synchronized (Ccase.class) {
                        context = Ccase.f10751a;
                    }
                    if (context instanceof Application) {
                        Application application = (Application) context;
                        AtomicReference<Cthrow.Cdo> atomicReference = Cthrow.b;
                        synchronized (atomicReference) {
                            if (atomicReference.get() == null) {
                                HandlerThread handlerThread = new HandlerThread("TuringDispatch");
                                handlerThread.start();
                                Cthrow.Cdo cdo = new Cthrow.Cdo(new Cconst(handlerThread.getLooper(), nectarine));
                                atomicReference.set(cdo);
                                application.registerActivityLifecycleCallbacks(cdo);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Bryony a(Context context, byte[] bArr, Betelnut betelnut) {
        if (bArr.length == 0) {
            return new Bryony(-1000);
        }
        Mango mangoA = Longan.b.a(5, bArr, 8123, 18123, null);
        int i = mangoA.f10720a;
        if (i != 0) {
            return new Bryony(i);
        }
        byte[] bArr2 = mangoA.d;
        try {
            Cantaloupe cantaloupe = new Cantaloupe();
            cantaloupe.f10672a = SkuConfig.INFINITE_COUNT;
            if (betelnut.b == 1) {
                cantaloupe = (Cantaloupe) Peach.a(cantaloupe, bArr2);
            } else {
                Dorado dorado = new Dorado(bArr2);
                dorado.b = "UTF-8";
                cantaloupe.a(dorado);
            }
            if (cantaloupe == null) {
                return new Bryony(-1002);
            }
            int i2 = cantaloupe.f10672a;
            if (i2 == 0) {
                if (TextUtils.isEmpty(cantaloupe.b)) {
                    return new Bryony(-1001);
                }
                Cascara.a(cantaloupe.f, cantaloupe.e);
                int seconds = (int) TimeUnit.MINUTES.toSeconds(10L);
                if (cantaloupe.c < 0) {
                    cantaloupe.c = seconds;
                }
                return new Bryony(0, cantaloupe.b, System.currentTimeMillis(), ((long) cantaloupe.c) * 1000, cantaloupe.d, cantaloupe.e);
            }
            return new Bryony((-2000) - i2);
        } catch (Throwable unused) {
            return new Bryony(SkuConfig.INFINITE_COUNT);
        }
    }

    public static Bryony a(Context context, Map<Integer, String> map, int i, long j) {
        Flat flat;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return new Bryony(-10008);
        }
        Bryony bryonyA = a(context);
        if (bryonyA != null && (bryonyA.e & 1) != 0) {
            i |= 1;
        }
        if (map != null && !map.isEmpty()) {
            i = (i & (-2)) | 2;
        }
        boolean z = (i & 1) != 0;
        boolean z2 = (i & 2) == 0;
        if (z && bryonyA != null) {
            if (Sagittarius.c(context) && Math.abs(System.currentTimeMillis() - bryonyA.c) >= bryonyA.d) {
                new Cdo(null, true).a();
            }
            return bryonyA;
        }
        if (!Sagittarius.c(context)) {
            return (!z2 || bryonyA == null) ? new Bryony(-10012) : bryonyA;
        }
        FutureTask<Bryony> futureTaskA = new Cdo(map, false).a();
        if (j <= 0) {
            try {
                synchronized (Flat.class) {
                    flat = Flat.D;
                }
                j = flat.x;
            } catch (TimeoutException unused) {
                return (!z2 || bryonyA == null) ? new Bryony(-10004) : bryonyA;
            } catch (Exception unused2) {
                return (!z2 || bryonyA == null) ? new Bryony(-10015) : bryonyA;
            }
        }
        return futureTaskA.get(j, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, Betelnut betelnut) {
        long j;
        StringBuilder sbA = Banana.a("5_");
        sbA.append(betelnut.b);
        sbA.append("_");
        sbA.append(betelnut.d);
        sbA.append("_");
        sbA.append(System.currentTimeMillis() - betelnut.f10664a);
        sbA.append("_");
        sbA.append(betelnut.c);
        sbA.append("_");
        long j2 = betelnut.e;
        if (j2 < 0) {
            j = -1;
        } else {
            long j3 = betelnut.f;
            if (j3 >= j2) {
                j = j3 - j2;
            }
        }
        sbA.append(j);
        String string = sbA.toString();
        String str = Hickory.b;
        HashMap map = new HashMap();
        map.put("703", string);
        Hickory.a(context, map);
    }

    public static String a(Context context, int i, Cabstract cabstract, boolean z, boolean z2) {
        Flat flat;
        HashMap map = new HashMap();
        map.put("3", "" + i);
        map.put("3005", z ? "1" : "0");
        map.put("3006", z2 ? "1" : "0");
        if (i == 17 || i == 40) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (Flat.class) {
                flat = Flat.D;
            }
            List<String> listA = UrsaMajor.a(flat.d);
            cabstract.a(-i, System.currentTimeMillis() - jCurrentTimeMillis);
            HashSet hashSet = new HashSet();
            if (!Cimport.a(listA)) {
                hashSet.addAll(listA);
            }
            if (z) {
                Set<String> setC = Kiwifruit.f.c();
                if (setC != null) {
                    hashSet.addAll(setC);
                }
                hashSet.add(context.getPackageName());
            }
            if (!hashSet.isEmpty()) {
                map.put("277", UrsaMajor.a(hashSet));
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            SparseArray<Object> sparseArrayH90_9F87DFDD2CC93068 = TNative$aa.h90_9F87DFDD2CC93068(new SparseArray(), context, map, 0);
            if (Pyxis.b(sparseArrayH90_9F87DFDD2CC93068) != 0) {
                return "";
            }
            String str = (String) Pyxis.a(sparseArrayH90_9F87DFDD2CC93068, 205, String.class);
            int i2 = Damson.f10689a;
            if (str == null) {
                str = "";
            }
            cabstract.f10749a.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis2));
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:292:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0848  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(Context context, Map map, Betelnut betelnut, boolean z) {
        Flat flat;
        long j;
        Lemon lemon;
        char c2;
        boolean z2;
        String string;
        String strA;
        String strA2;
        String strA3;
        String id;
        boolean z3;
        String string2;
        TextUtils.SimpleStringSplitter simpleStringSplitter;
        String strA4;
        BufferedReader bufferedReader;
        String string3;
        Cfinal[] cfinalArr;
        Cfinal[] cfinalArr2;
        boolean zA;
        int i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cabstract cabstract = new Cabstract();
        HashMap map2 = new HashMap();
        StringBuilder sbA = Banana.a("");
        sbA.append(Carambola.f10673a);
        map2.put("1", sbA.toString());
        synchronized (Flat.class) {
            flat = Flat.D;
        }
        if (flat.v) {
            map2.put("2", "1");
        }
        Lemon lemon2 = Lemon.g;
        if (lemon2.a(28)) {
            boolean z4 = flat.s;
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    break;
                }
                Ginkgo ginkgoA = Herbaceous.l.a(context, true, 1);
                int i3 = ginkgoA.c;
                if (i3 != 0) {
                    flat.s = true;
                    if (i3 != 0 && ((i = betelnut.d) == 0 || (i == -10011 && i3 != -10011))) {
                        betelnut.d = i3;
                    }
                    i2++;
                } else {
                    map2.put("207", ginkgoA.f10700a);
                    betelnut.d = 0;
                    break;
                }
            }
            flat.s = z4;
        }
        if (lemon2.a(22)) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            map2.put("205", Cextends.a(context));
            cabstract.a(22, System.currentTimeMillis() - jCurrentTimeMillis2);
        }
        if (lemon2.a(100)) {
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            String strA5 = Centaurus.a(context);
            if (strA5 == null) {
                strA5 = "";
            }
            c2 = 1;
            j = jCurrentTimeMillis;
            lemon = lemon2;
            Bilberry.a(map2, "250", strA5, jCurrentTimeMillis3, cabstract, 100);
        } else {
            j = jCurrentTimeMillis;
            lemon = lemon2;
            c2 = 1;
        }
        if (lemon.a(101)) {
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            int iB = Pear.b(context);
            map2.put("251", iB > 0 ? "1" : "0");
            map2.put("288", String.valueOf(iB));
            cabstract.a(101, System.currentTimeMillis() - jCurrentTimeMillis4);
        }
        if (lemon.a(102)) {
            z2 = false;
            Bilberry.a(map2, "252", Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0 ? "1" : "0", System.currentTimeMillis(), cabstract, 102);
        } else {
            z2 = false;
        }
        if (lemon.a(103)) {
            long jCurrentTimeMillis5 = System.currentTimeMillis();
            StringBuilder sbA2 = Banana.a("");
            sbA2.append(Octans.d(context));
            map2.put("253", sbA2.toString());
            cabstract.a(103, System.currentTimeMillis() - jCurrentTimeMillis5);
        }
        if (lemon.a(104)) {
            long jCurrentTimeMillis6 = System.currentTimeMillis();
            StringBuilder sbA3 = Banana.a("");
            sbA3.append(Octans.b(context));
            map2.put("254", sbA3.toString());
            cabstract.a(104, System.currentTimeMillis() - jCurrentTimeMillis6);
        }
        if (lemon.a(105)) {
            long jCurrentTimeMillis7 = System.currentTimeMillis();
            StringBuilder sbA4 = Banana.a("");
            sbA4.append(Cgoto.a(context));
            map2.put("255", sbA4.toString());
            cabstract.a(105, System.currentTimeMillis() - jCurrentTimeMillis7);
        }
        if (lemon.a(106)) {
            long jCurrentTimeMillis8 = System.currentTimeMillis();
            String strA6 = Octans.a();
            if (strA6 == null) {
                strA6 = "";
            }
            Bilberry.a(map2, "256", strA6, jCurrentTimeMillis8, cabstract, 106);
        }
        if (lemon.a(115)) {
            long jCurrentTimeMillis9 = System.currentTimeMillis();
            String strB = Octans.b();
            if (strB == null) {
                strB = "";
            }
            Bilberry.a(map2, "268", strB, jCurrentTimeMillis9, cabstract, 115);
        }
        if (lemon.a(116)) {
            long jCurrentTimeMillis10 = System.currentTimeMillis();
            String strA7 = Centaurus.a();
            if (strA7 == null) {
                strA7 = "";
            }
            Bilberry.a(map2, "269", strA7, jCurrentTimeMillis10, cabstract, 116);
        }
        if (lemon.a(107)) {
            long jCurrentTimeMillis11 = System.currentTimeMillis();
            String strF = Octans.f(context);
            if (strF == null) {
                strF = "";
            }
            Bilberry.a(map2, "257", strF, jCurrentTimeMillis11, cabstract, 107);
        }
        if (lemon.a(113)) {
            Bilberry.a(map2, "258", Vulpecula.a() ? "1" : "0", System.currentTimeMillis(), cabstract, 113);
        }
        if (lemon.a(114)) {
            long jCurrentTimeMillis12 = System.currentTimeMillis();
            try {
                zA = Vulpecula.a(context);
            } catch (Throwable unused) {
                zA = false;
            }
            Bilberry.a(map2, "259", zA ? "1" : "0", jCurrentTimeMillis12, cabstract, 114);
        }
        long jCurrentTimeMillis13 = System.currentTimeMillis();
        StringBuilder sbA5 = Banana.a("");
        sbA5.append(Octans.a(context));
        map2.put("270", sbA5.toString());
        cabstract.a(117, System.currentTimeMillis() - jCurrentTimeMillis13);
        if (lemon.a(44)) {
            long jCurrentTimeMillis14 = System.currentTimeMillis();
            map2.put("240", Filbert.a());
            cabstract.a(44, System.currentTimeMillis() - jCurrentTimeMillis14);
        }
        if (lemon.a(17)) {
            map2.put("267", a(context, 17, cabstract, z2, z2));
        } else if (lemon.a(40)) {
            map2.put("267", a(context, 40, cabstract, z2, z2));
        } else if (lemon.a(43)) {
            map2.put("267", a(context, 43, cabstract, z2, z2));
        }
        StringBuilder sbA6 = Banana.a("");
        sbA6.append((int) Sagittarius.a(context));
        map2.put("308", sbA6.toString());
        map2.put("303", Hickory.b(context, "703"));
        Lemon lemon3 = Lemon.g;
        if (!lemon3.a(10002)) {
            map2.put("2005", "0");
        }
        map2.put("2001", lemon3.a());
        Gemini<Cfinal> gemini = Berry.f10663a;
        try {
            StringBuilder sb = new StringBuilder();
            Gemini<Cfinal> gemini2 = Berry.b;
            synchronized (gemini2) {
                cfinalArr = (Cfinal[]) gemini2.b.toArray(Berry.c);
                gemini2.b.clear();
            }
            for (Cfinal cfinal : cfinalArr) {
                if (cfinal == null) {
                    break;
                }
                sb.append(cfinal.a());
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            Gemini<Cfinal> gemini3 = Berry.f10663a;
            synchronized (gemini3) {
                cfinalArr2 = (Cfinal[]) gemini3.b.toArray(Berry.c);
                gemini3.b.clear();
            }
            for (Cfinal cfinal2 : cfinalArr2) {
                if (cfinal2 == null) {
                    break;
                }
                sb.append(cfinal2.a());
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            string = sb.toString();
            if (TextUtils.isEmpty(string)) {
                string = "unknown";
            }
        } catch (Throwable unused2) {
            string = "unknown";
        }
        map2.put("273", string);
        HashMap map3 = new HashMap(flat.p);
        if (map != null && !map.isEmpty()) {
            map3.putAll(map);
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = map3.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            sb2.append(iIntValue);
            sb2.append("_");
            sb2.append(Damson.a(",", "%54", Damson.a("_", "%5F", (String) map3.get(Integer.valueOf(iIntValue)))));
            if (it.hasNext()) {
                sb2.append(",");
            }
        }
        map2.put("406", sb2.toString());
        map2.put("402", flat.l);
        Kiwifruit kiwifruit = Kiwifruit.f;
        if (kiwifruit.a("e_r_t", z2)) {
            map2.put("278", "1");
        }
        map2.put("266", Hickory.b(context, "901"));
        long jCurrentTimeMillis15 = System.currentTimeMillis();
        map2.put("272", Chamaeleon.b());
        cabstract.a(118, System.currentTimeMillis() - jCurrentTimeMillis15);
        String string4 = null;
        if (Lemon.g.a(120)) {
            long jCurrentTimeMillis16 = System.currentTimeMillis();
            System.currentTimeMillis();
            HashSet hashSet = new HashSet();
            try {
                bufferedReader = new BufferedReader(new FileReader(Cfinally.a(Cfinally.n)));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        String strA8 = Cepheus.a(line);
                        if (strA8 != null) {
                            hashSet.add(strA8);
                        }
                    } catch (Throwable unused3) {
                    }
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
            Auriga.a(bufferedReader);
            if (hashSet.size() > 0) {
                StringBuilder sb3 = new StringBuilder();
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    sb3.append((String) it2.next());
                    if (it2.hasNext()) {
                        sb3.append(",");
                    }
                }
                string3 = sb3.toString();
            } else {
                string3 = "";
            }
            Bilberry.a(map2, "279", string3, jCurrentTimeMillis16, cabstract, 120);
        }
        long jCurrentTimeMillis17 = System.currentTimeMillis();
        synchronized (Taurus.class) {
            strA = Taurus.a(context, Taurus.b);
        }
        map2.put("309", strA);
        cabstract.b.put(9, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis17));
        if (lemon.a(122)) {
            long jCurrentTimeMillis18 = System.currentTimeMillis();
            try {
                strA4 = Cwhile.a();
            } catch (Throwable unused5) {
                strA4 = "exception";
            }
            Bilberry.a(map2, "280", strA4, jCurrentTimeMillis18, cabstract, 122);
        }
        String strA9 = kiwifruit.a();
        if (strA9 != null) {
            map2.put("2013", strA9);
        }
        if (lemon.a(126)) {
            map2.put("281", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        }
        ITuringDeviceInfoProvider iTuringDeviceInfoProvider = flat.c;
        if (iTuringDeviceInfoProvider != null) {
            try {
                long jCurrentTimeMillis19 = System.currentTimeMillis();
                String imei = iTuringDeviceInfoProvider.getImei();
                if (imei == null) {
                    imei = "";
                }
                map2.put("274", imei);
                cabstract.a(47, System.currentTimeMillis() - jCurrentTimeMillis19);
                long jCurrentTimeMillis20 = System.currentTimeMillis();
                String imsi = iTuringDeviceInfoProvider.getImsi();
                if (imsi == null) {
                    imsi = "";
                }
                map2.put("276", imsi);
                cabstract.a(49, System.currentTimeMillis() - jCurrentTimeMillis20);
                long jCurrentTimeMillis21 = System.currentTimeMillis();
                String androidId = iTuringDeviceInfoProvider.getAndroidId();
                if (androidId == null) {
                    androidId = "";
                }
                map2.put("275", androidId);
                cabstract.a(48, System.currentTimeMillis() - jCurrentTimeMillis21);
            } catch (Throwable th) {
                Log.w("Turing", "invoke info impl exception", th);
            }
        }
        long jCurrentTimeMillis22 = System.currentTimeMillis();
        map2.put("264", Cdefault.a());
        cabstract.a(24, System.currentTimeMillis() - jCurrentTimeMillis22);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("C:");
        sb4.append(z ? "1" : "0");
        Cswitch.a(sb4);
        map2.put("210", sb4.toString());
        if (!kiwifruit.d()) {
            strA2 = Cfinally.a(Cfinally.i1);
        } else {
            strA2 = kiwifruit.a("c_s_l");
        }
        if (strA2 != null) {
            map2.put("2016", strA2);
        }
        if (!kiwifruit.d()) {
            strA3 = Cfinally.a(Cfinally.j1);
        } else {
            strA3 = kiwifruit.a("p_s_l");
        }
        if (strA3 != null) {
            map2.put("2017", strA3);
        }
        String strA10 = kiwifruit.a("p_d_l");
        if (strA10 != null) {
            map2.put("2022", strA10);
        }
        map2.put("2018", String.valueOf(Process.myUid()));
        long jCurrentTimeMillis23 = System.currentTimeMillis();
        PackageManager packageManager = context.getPackageManager();
        try {
            Object objA = Apple.a(packageManager.getClass(), f10665a, packageManager);
            if (objA != null) {
                StringBuilder sb5 = new StringBuilder();
                Class<?> cls = objA.getClass();
                sb5.append(cls.getName());
                sb5.append(",");
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass != null && superclass != Object.class) {
                    sb5.append(superclass.getName());
                }
                sb5.append(",");
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader != null && classLoader != Application.class.getClassLoader()) {
                    sb5.append(classLoader.toString().replace(",", ""));
                }
                string4 = sb5.toString();
            }
        } catch (Throwable unused6) {
        }
        String str = string4;
        cabstract.a(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, System.currentTimeMillis() - jCurrentTimeMillis23);
        if (!TextUtils.isEmpty(str)) {
            map2.put("2019", str);
        }
        if (lemon.a(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID)) {
            long jCurrentTimeMillis24 = System.currentTimeMillis();
            StringBuilder sb6 = new StringBuilder();
            try {
                HashSet hashSet2 = new HashSet();
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                sb6.append(accessibilityManager.isEnabled() ? 1 : 0);
                sb6.append(",");
                sb6.append(accessibilityManager.isTouchExplorationEnabled() ? 1 : 0);
                sb6.append(",");
                boolean z5 = true;
                for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getEnabledAccessibilityServiceList(-1)) {
                    if (z5) {
                        z5 = false;
                    } else {
                        sb6.append(x.aQ);
                    }
                    Ctry.a(sb6, accessibilityServiceInfo);
                    hashSet2.add(accessibilityServiceInfo.getId());
                }
                sb6.append(",");
                sb6.append(Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", -1));
                sb6.append(",");
                String string5 = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
                if (!TextUtils.isEmpty(string5)) {
                    TextUtils.SimpleStringSplitter simpleStringSplitter2 = new TextUtils.SimpleStringSplitter(':');
                    simpleStringSplitter2.setString(string5);
                    boolean z6 = true;
                    while (simpleStringSplitter2.hasNext()) {
                        String next = simpleStringSplitter2.next();
                        if (TextUtils.isEmpty(next) || hashSet2.contains(next)) {
                            simpleStringSplitter = simpleStringSplitter2;
                        } else {
                            String[] strArrSplit = next.split("/");
                            simpleStringSplitter = simpleStringSplitter2;
                            if (strArrSplit.length == 2 && !TextUtils.isEmpty(strArrSplit[0]) && !TextUtils.isEmpty(strArrSplit[c2])) {
                                ComponentName componentName = new ComponentName(strArrSplit[0], strArrSplit[c2]);
                                if (hashSet2.contains(componentName.flattenToShortString()) || hashSet2.contains(componentName.flattenToString())) {
                                }
                            } else {
                                if (z6) {
                                    z6 = false;
                                } else {
                                    sb6.append(x.aQ);
                                }
                                sb6.append(next);
                            }
                        }
                        simpleStringSplitter2 = simpleStringSplitter;
                    }
                }
                sb6.append(",");
                boolean z7 = true;
                for (AccessibilityServiceInfo accessibilityServiceInfo2 : accessibilityManager.getInstalledAccessibilityServiceList()) {
                    if (!hashSet2.contains(accessibilityServiceInfo2.getId()) && !Ctry.a(accessibilityServiceInfo2)) {
                        if (z7) {
                            z7 = false;
                        } else {
                            sb6.append(x.aQ);
                        }
                        Ctry.a(sb6, accessibilityServiceInfo2);
                        accessibilityServiceInfo2.getId();
                    }
                }
                string2 = sb6.toString();
            } catch (Throwable unused7) {
                string2 = bd.b;
            }
            Bilberry.a(map2, "2021", string2, jCurrentTimeMillis24, cabstract, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID);
        }
        if (lemon.a(138)) {
            long jCurrentTimeMillis25 = System.currentTimeMillis();
            map2.put("282", Octans.c(context));
            cabstract.a(138, System.currentTimeMillis() - jCurrentTimeMillis25);
        }
        if (lemon.a(145)) {
            long jCurrentTimeMillis26 = System.currentTimeMillis();
            String strA11 = Lyra.c.b().a();
            if (strA11 != null) {
                map2.put("283", strA11);
            }
            cabstract.a(145, System.currentTimeMillis() - jCurrentTimeMillis26);
        }
        if (lemon.a(MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK)) {
            long jCurrentTimeMillis27 = System.currentTimeMillis();
            String strA12 = Sagittarius.a();
            if (strA12 != null) {
                map2.put("284", strA12);
            }
            cabstract.a(MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK, System.currentTimeMillis() - jCurrentTimeMillis27);
        }
        if (lemon.a(147)) {
            String strA13 = kiwifruit.a("m_c_l_2");
            if (!TextUtils.isEmpty(strA13)) {
                map2.put("2024", strA13);
            }
            String strA14 = kiwifruit.a("nbe_a_t");
            if (!TextUtils.isEmpty(strA14)) {
                try {
                    if (Build.VERSION.SDK_INT <= Integer.parseInt(strA14)) {
                        z3 = true;
                    }
                } catch (Throwable unused8) {
                }
                map2.put("2029", !z3 ? "1" : "0");
            } else {
                z3 = false;
                map2.put("2029", !z3 ? "1" : "0");
            }
        }
        if (lemon.a(149)) {
            long jCurrentTimeMillis28 = System.currentTimeMillis();
            map2.put("285", Octans.c());
            cabstract.a(149, System.currentTimeMillis() - jCurrentTimeMillis28);
        }
        if (lemon.a(150)) {
            long jCurrentTimeMillis29 = System.currentTimeMillis();
            try {
                id = TimeZone.getDefault().getID();
            } catch (Throwable unused9) {
                id = "";
            }
            Bilberry.a(map2, "286", id, jCurrentTimeMillis29, cabstract, 150);
        }
        if (lemon.a(151)) {
            long jCurrentTimeMillis30 = System.currentTimeMillis();
            String strB2 = Sagittarius.b(Ccase.a());
            if (!TextUtils.isEmpty(strB2)) {
                map2.put("287", strB2);
            }
            cabstract.a(151, System.currentTimeMillis() - jCurrentTimeMillis30);
        }
        map2.put("4", cabstract.a());
        try {
            SparseArray<Object> sparseArrayG90_9F87DFDD2CC93068 = TNative$aa.g90_9F87DFDD2CC93068(new SparseArray(), context, map2, betelnut.b);
            int iB2 = Pyxis.b(sparseArrayG90_9F87DFDD2CC93068);
            if (iB2 != 0) {
                Log.i("TuringDebug", "g : " + iB2);
                return new byte[0];
            }
            byte[] bArrA = Pyxis.a(sparseArrayG90_9F87DFDD2CC93068);
            StringBuilder sbA7 = Banana.a("5_");
            sbA7.append(System.currentTimeMillis() - j);
            String string6 = sbA7.toString();
            HashMap map4 = new HashMap();
            map4.put("702", string6);
            Hickory.a(context, map4);
            return bArrA;
        } catch (Throwable th2) {
            Log.w("TuringDebug", th2);
            return new byte[0];
        }
    }

    public static Bryony a(Context context) {
        long j;
        int i;
        Context context2;
        AtomicReference<Bryony> atomicReference = c;
        synchronized (atomicReference) {
            Bryony bryony = atomicReference.get();
            if (bryony == null) {
                String strB = Hickory.b(context, "1001");
                if (TextUtils.isEmpty(strB)) {
                    return null;
                }
                long j2 = 0;
                try {
                    j = Long.parseLong(Hickory.b(context, "1002"));
                } catch (Throwable unused) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(Hickory.b(context, "1003"));
                } catch (Throwable unused2) {
                }
                long j3 = j2;
                try {
                    i = Integer.parseInt(Hickory.b(context, "1004"));
                } catch (Throwable unused3) {
                    i = 0;
                }
                synchronized (Ccase.class) {
                    context2 = Ccase.f10751a;
                }
                bryony = new Bryony(0, strB, j, j3, i, Hickory.b(context2, "1005"));
                c.set(bryony);
            }
            return bryony;
        }
    }

    public static void a(Context context, Bryony bryony) {
        AtomicReference<Bryony> atomicReference = c;
        synchronized (atomicReference) {
            if (bryony.f10669a != 0) {
                return;
            }
            atomicReference.set(bryony);
            String str = Hickory.b;
            if (TextUtils.isEmpty(bryony.b)) {
                return;
            }
            HashMap map = new HashMap();
            map.put("1001", bryony.b);
            map.put("1002", String.valueOf(bryony.c));
            map.put("1003", String.valueOf(bryony.d));
            map.put("1004", String.valueOf(bryony.e));
            String str2 = bryony.f;
            int i = Damson.f10689a;
            if (str2 == null) {
                str2 = "";
            }
            map.put("1005", str2);
            Hickory.a(context, map);
        }
    }
}
