package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Kiwifruit {
    public static final String d = Cfinally.a(Cfinally.a1);
    public static final long e = TimeUnit.HOURS.toMillis(32);
    public static final Kiwifruit f = new Kiwifruit();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Cprivate f10710a = null;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final ReentrantReadWriteLock c = new ReentrantReadWriteLock();

    public void a(Cprivate cprivate, boolean z) {
        this.c.writeLock().lock();
        if (z) {
            try {
                Draco draco = new Draco(128);
                cprivate.a(draco);
                if (Cstrictfp.a(b("2"), Cstatic.b(Cnative.a(draco.a()), Cstatic.a()), true)) {
                    File file = new File(b("1"));
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } finally {
                this.f10710a = cprivate;
                this.c.writeLock().unlock();
            }
        }
    }

    public final String b(String str) {
        Context context;
        synchronized (Ccase.class) {
            context = Ccase.f10751a;
        }
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(BaseWrapper.ENTER_ID_MARKET);
        File file = new File(sb.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str2 + Carambola.f10673a + "_ad_" + str;
    }

    public Set<String> c() {
        String strA = !d() ? Cfinally.a(Cfinally.h1) : a("p_l_h_l");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, strA.split(","));
        return hashSet;
    }

    public final boolean d() {
        return b() != null;
    }

    public final Cprivate b(String str, boolean z) {
        try {
            byte[] bArrA = Cstrictfp.a(str, true);
            if (bArrA == null) {
                return null;
            }
            if (z && ((bArrA = Cnative.b(Cstatic.a(bArrA, Cstatic.a()))) == null || bArrA.length == 0)) {
                return null;
            }
            Cprivate cprivate = new Cprivate();
            cprivate.a(new Dorado(bArrA));
            return cprivate;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Cprivate b() {
        this.c.readLock().lock();
        try {
            if (this.b.get()) {
                return this.f10710a;
            }
            synchronized (this.b) {
                if (this.b.get()) {
                    return this.f10710a;
                }
                Cprivate cprivateB = b(b("2"), true);
                if (cprivateB == null) {
                    cprivateB = b(b("1"), false);
                }
                this.f10710a = cprivateB;
                this.b.set(true);
                return this.f10710a;
            }
        } finally {
            this.c.readLock().unlock();
        }
    }

    public final String a(String str) {
        Cprivate cprivateB;
        Map<String, String> map;
        if (str == null || (cprivateB = b()) == null || (map = cprivateB.g) == null) {
            return null;
        }
        return map.get(str);
    }

    public final boolean a(String str, boolean z) {
        String strA = a(str);
        if (strA == null) {
            return z;
        }
        try {
            return Integer.parseInt(strA) > 0;
        } catch (NumberFormatException unused) {
            return z;
        }
    }

    public String a() {
        String strA;
        if (!d()) {
            strA = Cfinally.a(Cfinally.g1);
        } else {
            strA = a("a_f_ok_c");
        }
        String strA2 = a("a_f_ok_s");
        HashSet<String> hashSet = new HashSet();
        if (!TextUtils.isEmpty(strA)) {
            for (String str : strA.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
        }
        if (!TextUtils.isEmpty(strA2)) {
            Loquat.f10716a.b().a();
            if (Triangulum.a()) {
                for (String str2 : strA2.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str3 : hashSet) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
