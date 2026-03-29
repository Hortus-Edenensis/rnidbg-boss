package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import cn.fly.verify.fq;
import com.amap.api.col.p0002sl.hb;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class du {
    private static du b = new du();
    private volatile boolean c = false;
    private volatile long d = 0;
    private final ConcurrentHashMap<String, Object> e = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2203a = new AtomicBoolean(false);

    private du() {
    }

    public static du a() {
        return b;
    }

    private boolean d() {
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        fq.a(ax.g()).d().a(new fq.a() { // from class: cn.fly.verify.du.2
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                String strD = bVar.d();
                if (!TextUtils.isEmpty(strD) && !TextUtils.equals("-1", strD)) {
                    linkedBlockingQueue.offer(Boolean.valueOf(!strD.startsWith("460")));
                }
                linkedBlockingQueue.offer(Boolean.valueOf(!du.this.a(ax.g())));
            }
        });
        try {
            Boolean bool = (Boolean) linkedBlockingQueue.poll(120L, TimeUnit.MILLISECONDS);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b() {
        return a(false);
    }

    public ConcurrentHashMap<String, Object> c() {
        return this.e;
    }

    private boolean b(String str) {
        String strD = eg.d();
        if (TextUtils.isEmpty(strD) || strD.length() < str.length()) {
            return false;
        }
        String[] strArrSplit = strD.split("");
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        boolean zEquals = false;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '1') {
                zEquals |= TextUtils.equals(strArrSplit[i], "1");
            } else if (c == '2') {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (arrayList.size() <= 0) {
            return zEquals;
        }
        Iterator it = arrayList.iterator();
        boolean zEquals2 = true;
        while (it.hasNext()) {
            zEquals2 &= TextUtils.equals(strArrSplit[((Integer) it.next()).intValue()], "1");
        }
        return zEquals | zEquals2;
    }

    private void c(boolean z) {
        HashMap map = new HashMap();
        map.put(dx.a("005aedbVbh"), Integer.valueOf(!z ? 1 : 0));
        map.put(dx.a("002:beXa"), fz.a(this.e.get(dx.a("002:beXa")), 0));
        map.put(dx.a("002Qbeba"), fz.a(this.e.get(dx.a("002Qbeba")), 0));
        map.put(dx.a("002IbbKh"), fz.a(this.e.get(dx.a("002IbbKh")), 0));
        map.put(dx.a("0026ddEh"), fz.a(this.e.get(dx.a("0026ddEh")), 0));
        map.put(dx.a("002*bhRg"), fz.a(this.e.get(dx.a("002*bhRg")), 0));
        map.put(dx.a("002Fca2h"), fz.a(this.e.get(dx.a("002Fca2h")), 0));
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(dx.a("004gAbiShd"), "ECMT");
        map2.put(dx.a("004Wba.bgb"), map);
        map2.put(dx.a("0081ba,bgdg$bgbdId"), Long.valueOf(jCurrentTimeMillis));
        cn.a().a(jCurrentTimeMillis, map2);
    }

    private boolean b(final ArrayList<Boolean> arrayList, final List<String> list) {
        fq.c cVarA = fq.a(ax.g());
        if (list == null || list.size() == 0) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            cVarA.b(it.next());
        }
        final boolean[] zArr = {false};
        cVarA.a(new fq.a() { // from class: cn.fly.verify.du.4
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                for (int i = 0; i < list.size(); i++) {
                    boolean zF = bVar.f(i);
                    arrayList.add(Boolean.valueOf(zF));
                    boolean[] zArr2 = zArr;
                    boolean z = zF | zArr2[0];
                    zArr2[0] = z;
                    if (z) {
                        return;
                    }
                }
            }
        });
        return zArr[0];
    }

    public void a(HashMap<String, Object> map, HashMap<String, Object> map2, HashMap<String, Object> map3) {
        try {
            Object obj = this.e.get(dx.a("006dVbdbfbhNd7df"));
            Boolean bool = Boolean.FALSE;
            boolean zBooleanValue = ((Boolean) fz.a(obj, bool)).booleanValue();
            boolean zBooleanValue2 = ((Boolean) fz.a(this.e.get(dx.a("006KccFhQbfbh]dZdf")), bool)).booleanValue();
            HashMap map4 = new HashMap(4);
            map4.put(dx.a("003_bh3dHdf"), Boolean.valueOf(zBooleanValue));
            map4.put(dx.a("003Fbhbgba"), fz.a(map.get(dx.a("003Fbhbgba")), (Object) null));
            if (zBooleanValue || map2 == null) {
                map4.put(dx.a("003Adfbgba"), fz.a(map.get(dx.a("003Adfbgba")), (Object) null));
            } else {
                map4.put(dx.a("003(dfbgba"), fz.a(map2.get(dx.a("003(dfbgba")), (Object) null));
            }
            this.e.put(dx.a("006dAbdbfbhJdQdf"), fv.a(map4));
            if (zBooleanValue) {
                HashMap map5 = new HashMap(4);
                map5.put(dx.a("003Qbh[d(df"), Boolean.valueOf(zBooleanValue2));
                map5.put(dx.a("003Ebhbgba"), fz.a(map.get(dx.a("003Ebhbgba")), (Object) null));
                if (zBooleanValue2 || map3 == null) {
                    map5.put(dx.a("0033dfbgba"), fz.a(map.get(dx.a("0033dfbgba")), (Object) null));
                } else {
                    map5.put(dx.a("0038dfbgba"), fz.a(map3.get(dx.a("0038dfbgba")), (Object) null));
                }
                map5.putAll(this.f);
                this.e.put(dx.a("006DccJh6bfbhDdNdf"), fv.a(map5));
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    private boolean a(final int i) {
        final boolean[] zArr = {true};
        fq.c cVarA = fq.a(ax.g());
        if (i == 0) {
            cVarA.v();
        } else if (i == 1) {
            cVarA.u();
        } else if (i == 2) {
            cVarA.w();
        } else if (i == 3) {
            cVarA.K();
        } else if (i == 4) {
            cVarA.a();
        } else if (i == 5) {
            cVarA.s();
        }
        cVarA.a(new fq.a() { // from class: cn.fly.verify.du.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                ConcurrentHashMap concurrentHashMap;
                String strA;
                int i2;
                int i3 = i;
                if (i3 == 0) {
                    zArr[0] = bVar.v();
                    concurrentHashMap = du.this.e;
                    strA = dx.a("002>be6a");
                    i2 = zArr[0];
                } else if (i3 == 1) {
                    zArr[0] = bVar.u();
                    concurrentHashMap = du.this.e;
                    strA = dx.a("002Ibeba");
                    i2 = zArr[0];
                } else if (i3 == 2) {
                    zArr[0] = bVar.w();
                    concurrentHashMap = du.this.e;
                    strA = dx.a("002Vbb h");
                    i2 = zArr[0];
                } else if (i3 == 3) {
                    zArr[0] = bVar.J();
                    concurrentHashMap = du.this.e;
                    strA = dx.a("002GddMh");
                    i2 = zArr[0];
                } else if (i3 == 4) {
                    zArr[0] = bVar.a();
                    concurrentHashMap = du.this.e;
                    strA = dx.a("002XbhWg");
                    i2 = zArr[0];
                } else {
                    if (i3 != 5) {
                        return;
                    }
                    zArr[0] = bVar.s();
                    concurrentHashMap = du.this.e;
                    strA = dx.a("002+ca.h");
                    i2 = zArr[0];
                }
                concurrentHashMap.put(strA, Integer.valueOf(i2));
            }
        });
        return zArr[0];
    }

    private synchronized boolean b(boolean z) {
        long jLongValue;
        Object objA;
        try {
            if (z) {
                HashMap mapA = fv.a(bv.a().e());
                if (mapA.isEmpty()) {
                    mapA = fv.a(bv.a().d());
                }
                jLongValue = ((Long) fz.a(mapA.get(dx.a("004dadDca")), 5L)).longValue() * 1000;
                objA = fz.a(mapA.get(dx.a("002a:ba")), dx.a("006:fcfcfdfdfdfd"));
            } else {
                jLongValue = ((Long) by.a(dx.a("004dadQca"), 5L)).longValue() * 1000;
                objA = by.a(dx.a("002aCba"), dx.a("006.fcfcfdfdfdfd"));
            }
            String str = (String) objA;
            if (this.d != 0 && System.currentTimeMillis() - this.d <= jLongValue) {
                return this.c;
            }
            boolean zA = a(str);
            if (this.d == 0 || zA != this.c) {
                c(zA);
            }
            this.d = System.currentTimeMillis();
            this.c = zA;
            return zA;
        } catch (Throwable th) {
            en.a().c(th);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage().startsWith("zh") && TextUtils.equals(locale.getCountry(), "CN");
    }

    private boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            char[] charArray = str.toCharArray();
            HashMap map = new HashMap();
            boolean zA = false;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (c == '1') {
                    zA |= a(i);
                } else if (c != '0') {
                    List arrayList = (List) map.get(Character.valueOf(c));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(Integer.valueOf(i));
                    map.put(Character.valueOf(charArray[i]), arrayList);
                }
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) ((Map.Entry) it.next()).getValue()).iterator();
                boolean zA2 = true;
                while (it2.hasNext()) {
                    zA2 &= a(((Integer) it2.next()).intValue());
                }
                zA |= zA2;
            }
            return zA;
        } catch (Throwable th) {
            en.a().c(th);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[PHI: r0
      0x0025: PHI (r0v7 java.lang.String) = (r0v5 java.lang.String), (r0v5 java.lang.String), (r0v0 java.lang.String), (r0v0 java.lang.String) binds: [B:31:0x00d5, B:33:0x00e7, B:5:0x001c, B:7:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, HashMap<String, Object> map) {
        String str2 = "a";
        boolean z = true;
        if (TextUtils.equals(str, "a")) {
            if (((Integer) fz.a(map.get("a"), 0)).intValue() != 1 || !d()) {
                z = false;
            }
        } else {
            if (TextUtils.equals(str, "p")) {
                List<String> list = (List) fz.a(map.get("p"), (Object) null);
                ArrayList<Boolean> arrayList = new ArrayList<>();
                boolean zB = b(arrayList, list);
                this.f.put("p", arrayList);
                return zB;
            }
            if (TextUtils.equals(str, "fp")) {
                List<String> list2 = (List) fz.a(map.get("fp"), (Object) null);
                ArrayList<Boolean> arrayList2 = new ArrayList<>();
                boolean zB2 = b(arrayList2, list2);
                this.f.put("fp", arrayList2);
                return zB2;
            }
            if (TextUtils.equals(str, "s")) {
                boolean zA = a(new ArrayList<>(), (List<String>) fz.a(map.get("s"), (Object) null));
                this.f.put("s", Boolean.valueOf(zA));
                return zA;
            }
            if (TextUtils.equals(str, "fs")) {
                boolean zA2 = a(new ArrayList<>(), (List<String>) fz.a(map.get("fs"), (Object) null));
                this.f.put("fs", Boolean.valueOf(zA2));
                return zA2;
            }
            str2 = "d";
            if (!TextUtils.equals(str, "d")) {
                if (!TextUtils.equals(str, "bl")) {
                    return false;
                }
                boolean zB3 = b((String) fz.a(map.get("bl"), ""));
                this.f.put("bl", Boolean.valueOf(zB3));
                return zB3;
            }
            if (((Integer) fz.a(map.get("d"), 0)).intValue() != 1 || !er.a(ax.g()).d().aw()) {
            }
        }
        this.f.put(str2, Boolean.valueOf(z));
        return z;
    }

    private boolean a(ArrayList<Boolean> arrayList, final List<String> list) {
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        if (list != null && list.size() > 0) {
            fq.c cVarA = fq.a(ax.g());
            for (int i = 0; i < list.size(); i++) {
                cVarA.a(new Intent(list.get(i)), 0);
            }
            cVarA.a(new fq.a() { // from class: cn.fly.verify.du.3
                @Override // cn.fly.verify.fq.a
                public void a(fq.b bVar) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        List<ResolveInfo> listG = bVar.g(i2);
                        if (listG != null && listG.size() > 0) {
                            linkedBlockingQueue.offer(Boolean.TRUE);
                        }
                    }
                    linkedBlockingQueue.offer(Boolean.FALSE);
                }
            });
        }
        try {
            Boolean bool = (Boolean) linkedBlockingQueue.poll(150L, TimeUnit.MILLISECONDS);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(HashMap<String, Object> map) {
        try {
            List<String> list = (List) fz.a(map.get(hb.j), (Object) null);
            if (list != null && list.size() > 0) {
                boolean zA = false;
                for (String str : list) {
                    if (str.contains(",")) {
                        boolean zA2 = true;
                        for (String str2 : str.split(",")) {
                            zA2 &= a(str2, map);
                        }
                        zA |= zA2;
                    } else {
                        zA |= a(str, map);
                    }
                }
                this.e.put(dx.a("006Xcc:hEbfbhYd'df"), Boolean.valueOf(zA ? false : true));
                return !zA;
            }
        } catch (Throwable th) {
            en.a().c(th);
        }
        return true;
    }

    public synchronized boolean a(boolean z) {
        return !b(z);
    }
}
