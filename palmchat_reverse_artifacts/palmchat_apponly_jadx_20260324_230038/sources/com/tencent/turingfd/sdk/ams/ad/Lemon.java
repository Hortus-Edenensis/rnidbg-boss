package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Lemon {
    public static final Lemon g = new Lemon();
    public static final Set<Integer> h;
    public Flat d;
    public Hickory e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Integer> f10712a = new HashSet();
    public final Set<Integer> b = new HashSet();
    public final Object c = new Object();
    public final CanisMajor f = new Cdo(this);

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Lemon$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo implements CanisMajor {
        public Cdo(Lemon lemon) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        hashSet.add(6);
        hashSet.add(3);
        hashSet.add(32);
        hashSet.add(5);
        hashSet.add(4);
        hashSet.add(40);
        hashSet.add(43);
        hashSet.add(19);
        hashSet.add(36);
        hashSet.add(45);
        hashSet.add(136);
        hashSet.add(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE));
        hashSet.add(144);
        hashSet.add(10002);
        hashSet.add(10003);
        int i = Carambola.f10673a;
        if (i == 105668 || i == 105928 || i == 108168) {
            hashSet.add(18);
        }
        h = Collections.unmodifiableSet(hashSet);
    }

    public long a(Context context) {
        long jCurrentTimeMillis = 0;
        if (Kiwifruit.f.d()) {
            return 0L;
        }
        try {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            b(context);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            b();
            return jCurrentTimeMillis;
        } catch (Throwable unused) {
            return jCurrentTimeMillis;
        }
    }

    public final void b() {
        Map<Integer, Integer> mapEmptyMap;
        try {
            Cprivate cprivateB = Kiwifruit.f.b();
            if (cprivateB == null || (mapEmptyMap = cprivateB.e) == null) {
                mapEmptyMap = Collections.emptyMap();
            }
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (Map.Entry<Integer, Integer> entry : mapEmptyMap.entrySet()) {
                if (entry.getValue().intValue() == 0) {
                    hashSet.add(entry.getKey());
                } else {
                    hashSet2.add(entry.getKey());
                }
            }
            synchronized (this.b) {
                this.b.clear();
                this.b.addAll(h);
                this.b.addAll(hashSet);
                this.b.removeAll(hashSet2);
                synchronized (this.f10712a) {
                    this.b.addAll(this.f10712a);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final byte[] a(Context context, boolean z) {
        byte[] bArr = new byte[0];
        HashMap map = new HashMap();
        StringBuilder sbA = Banana.a("");
        sbA.append(Carambola.f10673a);
        map.put("1", sbA.toString());
        Flat flat = this.d;
        map.put("101", TextUtils.isEmpty(flat.q) ? "" : flat.q);
        Cprivate cprivateB = Kiwifruit.f.b();
        if (cprivateB != null) {
            map.put("2026", String.valueOf(cprivateB.f10767a));
            map.put("2027", String.valueOf(cprivateB.c));
        }
        map.put("207", Herbaceous.l.a(context).f10700a);
        if (z) {
            map.put("264", Cdefault.a());
        } else {
            map.put("264", "PPNA");
        }
        try {
            SparseArray<Object> sparseArrayE90_9F87DFDD2CC93068 = TNative$aa.e90_9F87DFDD2CC93068(new SparseArray(), context, map, Foxnut.g);
            return Pyxis.b(sparseArrayE90_9F87DFDD2CC93068) != 0 ? bArr : Pyxis.a(sparseArrayE90_9F87DFDD2CC93068);
        } catch (Throwable unused) {
            return bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Context context) {
        try {
            synchronized (this.c) {
                Kiwifruit kiwifruit = Kiwifruit.f;
                if (kiwifruit.d()) {
                    long jA = this.e.a(context, "501");
                    Cprivate cprivateB = kiwifruit.b();
                    if (cprivateB != null) {
                        long j = cprivateB.f;
                        if (j <= 0) {
                            j = 57600;
                        }
                        if (Math.abs(System.currentTimeMillis() - jA) <= j * 1000) {
                            return;
                        }
                    }
                }
                boolean zUserAgreement = this.d.c().userAgreement();
                byte[] bArrA = a(context, zUserAgreement);
                if (bArrA.length == 0) {
                    return;
                }
                Cprivate cprivateA = a(Longan.b.a(4, bArrA, 8119, 18119, this.f).d);
                if (cprivateA == null) {
                    return;
                }
                kiwifruit.a(cprivateA, zUserAgreement);
                if (zUserAgreement) {
                    Hickory hickory = this.e;
                    hickory.getClass();
                    hickory.a(context, "501", "" + System.currentTimeMillis(), true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final Cprivate a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        int i = Foxnut.g;
        if (i == 1) {
            try {
                bArr = Pyxis.a(TNative$aa.f90_9F87DFDD2CC93068(new SparseArray(), bArr, i));
            } catch (Throwable unused) {
                return null;
            }
        } else if (i != 0) {
            bArr = bArr2;
        }
        try {
            Bullace bullace = new Bullace();
            bullace.a(new Dorado(bArr));
            int i2 = bullace.f10670a;
            if (i2 < 0) {
                return null;
            }
            if (i2 == 1) {
                return new Cprivate();
            }
            Cprivate cprivate = bullace.b;
            if (cprivate == null) {
                return new Cprivate();
            }
            Log.e("D" + Carambola.f10673a, "s:" + cprivate.f10767a + ",v:" + cprivate.c);
            for (Map.Entry<Integer, Integer> entry : cprivate.e.entrySet()) {
            }
            Map<String, String> map = cprivate.g;
            if (map != null) {
                for (String str : map.keySet()) {
                }
            }
            return cprivate;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public boolean a(int i) {
        boolean z;
        synchronized (this.b) {
            z = !this.b.contains(Integer.valueOf(i));
        }
        return z;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.b) {
            for (Integer num : this.b) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
