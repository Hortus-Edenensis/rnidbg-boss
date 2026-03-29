package cn.fly.verify;

import android.content.pm.ApplicationInfo;
import android.media.MediaDrm;
import android.os.Build;
import android.text.TextUtils;
import cn.fly.verify.ay;
import cn.fly.verify.fq;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ej {
    private static volatile ej e;
    private HashMap<String, Integer> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f2237a = null;
    private volatile String b = null;
    private volatile String c = null;
    private volatile String d = null;
    private final byte[] g = new byte[0];
    private final byte[] h = new byte[0];

    private ej() {
    }

    public static ej a() {
        if (e == null) {
            synchronized (ej.class) {
                if (e == null) {
                    e = new ej();
                }
            }
        }
        return e;
    }

    private String j() {
        StringBuilder sb;
        String string;
        if (!TextUtils.isEmpty(h())) {
            sb = new StringBuilder();
            sb.append(BaseWrapper.ENTER_ID_MARKET);
            string = h();
        } else if (!TextUtils.isEmpty(g())) {
            sb = new StringBuilder();
            sb.append(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING);
            string = g();
        } else if (TextUtils.isEmpty(l())) {
            sb = new StringBuilder();
            sb.append("42");
            string = UUID.randomUUID().toString();
        } else {
            sb = new StringBuilder();
            sb.append("32");
            string = this.d;
        }
        sb.append(c(string));
        return sb.toString();
    }

    private String k() {
        StringBuilder sb;
        String string;
        if (TextUtils.isEmpty(h())) {
            sb = new StringBuilder();
            sb.append("42");
            string = UUID.randomUUID().toString();
        } else {
            sb = new StringBuilder();
            sb.append(BaseWrapper.ENTER_ID_MARKET);
            string = h();
        }
        sb.append(c(string));
        return sb.toString();
    }

    private String l() {
        fq.a(ax.g()).B().a(new fq.a() { // from class: cn.fly.verify.ej.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                String strA = bVar.A();
                List<String> listAsList = Arrays.asList("00000000-0000-0000-0000-000000000000", "00000000000000000000000000000000");
                ay.d dVarJ = bv.a().j();
                if (dVarJ != null && dVarJ.d() != null) {
                    listAsList = dVarJ.d();
                }
                if (TextUtils.isEmpty(strA) || listAsList.contains(strA)) {
                    return;
                }
                ej.this.d = strA;
            }
        });
        return this.d;
    }

    private String m() throws Throwable {
        final String[] strArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ek.c.execute(new gh() { // from class: cn.fly.verify.ej.3
            @Override // cn.fly.verify.gh
            public void a() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = bq.a("061hAfdkgeeiighii$g]fgjkik^gd;geee<h.iigiHdg;fgedimgeejffejgfjkiikgjkiege]jJfffdPd?fdijgfWd,gfgefegiffijedifigifRdCiiigigjkjkPd;iggh");
                UUID uuid = new UUID(-1301668207276963122L, -6645017420763422227L);
                MediaDrm mediaDrm = null;
                try {
                    try {
                        MediaDrm mediaDrm2 = new MediaDrm(uuid);
                        try {
                            ew.a(ax.g()).a(mediaDrm2.getClass(), mediaDrm2, bq.a("012fejKejeeHgNeigiKgjBehZk"), new Class[]{Object.class, byte[].class, String.class}, new Object[]{new WeakReference(mediaDrm2), ej.this.a(uuid), strA});
                            byte[] propertyByteArray = mediaDrm2.getPropertyByteArray(bq.a("014Aed-gEeeej6dgYfh2fXejefeh%gDfjed"));
                            strArr[0] = fr.a(propertyByteArray, 0, propertyByteArray.length);
                            en.a().a("rddd wv c " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                            countDownLatch.countDown();
                            int i = Build.VERSION.SDK_INT;
                            mediaDrm2.release();
                        } catch (Throwable th) {
                            th = th;
                            mediaDrm = mediaDrm2;
                            try {
                                en.a().a(th);
                                countDownLatch.countDown();
                                if (Build.VERSION.SDK_INT < 28 ? mediaDrm != null : mediaDrm != null) {
                                    mediaDrm.release();
                                }
                            } catch (Throwable th2) {
                                try {
                                    countDownLatch.countDown();
                                    if (Build.VERSION.SDK_INT < 28 ? mediaDrm != null : mediaDrm != null) {
                                        mediaDrm.release();
                                    }
                                } catch (Throwable th3) {
                                    en.a().a(th3);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        en.a().a(th4);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        });
        countDownLatch.await(3L, TimeUnit.SECONDS);
        return strArr[0];
    }

    private String n() {
        long j;
        final String[] strArr = new String[1];
        if (by.a(bq.a("003ehh"))) {
            try {
                String strB = bv.a().b("key_pddt", (String) null);
                strArr[0] = strB;
                if (!TextUtils.isEmpty(strB)) {
                    long jB = bv.a().b("key_lgpdt", 0L);
                    try {
                        j = Long.parseLong(String.valueOf(by.a(bq.a("006?gielgiffTek"), 604800))) * 1000;
                    } catch (Throwable unused) {
                        j = com.igexin.push.f.b.d.b;
                    }
                    if (System.currentTimeMillis() - jB < j) {
                        en.a().a("rddd che p useable", new Object[0]);
                        return strArr[0];
                    }
                }
                if ((bq.a("004@eeejeefe").equalsIgnoreCase(fq.d.k()) && Build.VERSION.SDK_INT <= 25) || (bq.a("006i4ehNe0gg3gIej").equalsIgnoreCase(fq.d.k()) && Build.VERSION.SDK_INT <= 22)) {
                    return null;
                }
                final List<String> listO = o();
                if (!listO.isEmpty()) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final StringBuilder sb = new StringBuilder();
                    fq.c cVarA = fq.a(ax.g());
                    Iterator<String> it = listO.iterator();
                    while (it.hasNext()) {
                        cVarA.b(it.next(), 1);
                    }
                    cVarA.a(new fq.a() { // from class: cn.fly.verify.ej.4
                        @Override // cn.fly.verify.fq.a
                        public void a(fq.b bVar) {
                            int i = 0;
                            for (int i2 = 0; i2 < listO.size(); i2++) {
                                try {
                                    ApplicationInfo applicationInfoI = bVar.i(i2);
                                    if (applicationInfoI != null) {
                                        sb.append((String) listO.get(i2));
                                        sb.append(fd.a(applicationInfoI, (String) listO.get(i2)));
                                        i++;
                                    }
                                } finally {
                                    countDownLatch.countDown();
                                }
                            }
                            if (i > 0) {
                                StringBuilder sb2 = sb;
                                String str = Build.BRAND;
                                Locale locale = Locale.ROOT;
                                sb2.append(str.toUpperCase(locale));
                                sb2.append(Build.MODEL.toUpperCase(locale));
                                sb2.append(Build.MANUFACTURER.toUpperCase(locale));
                                sb.append(i);
                                strArr[0] = fr.b(sb.toString());
                                bv.a().a("key_pddt", strArr[0]);
                                bv.a().a("key_lgpdt", System.currentTimeMillis());
                            }
                        }
                    });
                    try {
                        countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        return strArr[0];
    }

    private List<String> o() {
        final ArrayList arrayList = new ArrayList();
        fq.a(ax.g()).k().a(new fq.a() { // from class: cn.fly.verify.ej.5
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                if (bVar.k() == null || bVar.k().isEmpty()) {
                    return;
                }
                Iterator<HashMap<String, String>> it = bVar.k().iterator();
                while (it.hasNext()) {
                    String str = it.next().get(bq.a("003kYemff"));
                    if (str != null && !str.contains("com.google.android") && !str.contains("com.miui.packageinstaller")) {
                        arrayList.add(str);
                    }
                }
                Collections.sort(arrayList);
            }
        });
        return arrayList;
    }

    public String b() {
        return "2";
    }

    public String c() {
        if (TextUtils.isEmpty(this.b)) {
            String strB = bv.a().b("key_rdt2", (String) null);
            if (!TextUtils.isEmpty(strB)) {
                this.b = strB;
            }
        }
        return this.b;
    }

    public boolean d() {
        if (!TextUtils.isEmpty(this.b)) {
            return false;
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(this.b)) {
                return false;
            }
            return TextUtils.isEmpty(bv.a().b("key_rdt2", (String) null));
        }
    }

    public synchronized String e() {
        String strC;
        strC = c();
        if (TextUtils.isEmpty(strC)) {
            strC = j();
            this.b = strC;
            if (!TextUtils.isEmpty(strC)) {
                bv.a().a("key_rdt2", strC);
            }
        }
        return strC;
    }

    public String f() {
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            strC = k();
            this.b = strC;
            if (!TextUtils.isEmpty(strC)) {
                bv.a().a("key_rdt2", strC);
            }
        }
        return strC;
    }

    public String g() {
        if (TextUtils.isEmpty(this.c)) {
            synchronized (this.h) {
                if (TextUtils.isEmpty(this.c)) {
                    this.c = n();
                }
            }
        }
        return this.c;
    }

    public String h() {
        if (TextUtils.isEmpty(this.f2237a)) {
            synchronized (this.g) {
                if (TextUtils.isEmpty(this.f2237a)) {
                    try {
                        this.f2237a = m();
                        b(this.f2237a);
                    } catch (Throwable th) {
                        en.a().a(th);
                    }
                }
            }
        }
        return this.f2237a;
    }

    public HashMap<String, Integer> i() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[Catch: all -> 0x00af, LOOP:0: B:16:0x0053->B:18:0x0056, LOOP_END, TryCatch #0 {all -> 0x00af, blocks: (B:4:0x0008, B:8:0x001a, B:10:0x0021, B:12:0x0030, B:13:0x0035, B:15:0x003e, B:18:0x0056, B:19:0x005e, B:20:0x0067, B:22:0x006d, B:23:0x007f, B:25:0x0099, B:14:0x0039, B:7:0x0015), top: B:30:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d A[Catch: all -> 0x00af, LOOP:1: B:20:0x0067->B:22:0x006d, LOOP_END, TryCatch #0 {all -> 0x00af, blocks: (B:4:0x0008, B:8:0x001a, B:10:0x0021, B:12:0x0030, B:13:0x0035, B:15:0x003e, B:18:0x0056, B:19:0x005e, B:20:0x0067, B:22:0x006d, B:23:0x007f, B:25:0x0099, B:14:0x0039, B:7:0x0015), top: B:30:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #0 {all -> 0x00af, blocks: (B:4:0x0008, B:8:0x001a, B:10:0x0021, B:12:0x0030, B:13:0x0035, B:15:0x003e, B:18:0x0056, B:19:0x005e, B:20:0x0067, B:22:0x006d, B:23:0x007f, B:25:0x0099, B:14:0x0039, B:7:0x0015), top: B:30:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(String str) {
        int size;
        int iMin;
        int i;
        int iValueOf;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap map = (HashMap) bv.a().a("key_drds");
            if (map == null) {
                map = new HashMap();
            }
            if (map.containsKey(str)) {
                int iIntValue = ((Integer) map.get(str)).intValue();
                iValueOf = iIntValue < 100000 ? Integer.valueOf(iIntValue + 1) : 1;
                ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: cn.fly.verify.ej.2
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                        return entry2.getValue().compareTo(entry.getValue());
                    }
                });
                for (size = arrayList.size(); size > 7; size--) {
                    arrayList.remove(size - 1);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : arrayList) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                bv.a().a("key_drds", linkedHashMap);
                this.f = new LinkedHashMap();
                iMin = Math.min(3, arrayList.size());
                for (i = 0; i < iMin; i++) {
                    Map.Entry entry2 = (Map.Entry) arrayList.get(i);
                    this.f.put(entry2.getKey(), entry2.getValue());
                }
            }
            map.put(str, iValueOf);
            ArrayList<Map.Entry> arrayList2 = new ArrayList(map.entrySet());
            Collections.sort(arrayList2, new Comparator<Map.Entry<String, Integer>>() { // from class: cn.fly.verify.ej.2
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(Map.Entry<String, Integer> entry3, Map.Entry<String, Integer> entry22) {
                    return entry22.getValue().compareTo(entry3.getValue());
                }
            });
            while (size > 7) {
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (r2.hasNext()) {
            }
            bv.a().a("key_drds", linkedHashMap2);
            this.f = new LinkedHashMap();
            iMin = Math.min(3, arrayList2.size());
            while (i < iMin) {
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    private String c(String str) {
        StringBuilder sb = new StringBuilder(str);
        String strK = fq.d.k();
        String strJ = fq.d.j();
        if (!TextUtils.isEmpty(strK)) {
            sb.append(strK.trim().toUpperCase());
        }
        if (!TextUtils.isEmpty(strJ)) {
            sb.append(strJ.trim().toUpperCase());
        }
        return fr.b(sb.toString());
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.b)) {
            return;
        }
        en.a().a("rddd saveRD pre is " + this.b + " cur is " + str, new Object[0]);
        bv.a().a("key_rdt2", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i = 0; i < 8; i++) {
            int i2 = (7 - i) * 8;
            bArr[i] = (byte) (mostSignificantBits >>> i2);
            bArr[i + 8] = (byte) (leastSignificantBits >>> i2);
        }
        return bArr;
    }
}
