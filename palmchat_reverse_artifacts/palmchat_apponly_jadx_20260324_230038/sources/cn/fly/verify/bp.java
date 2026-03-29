package cn.fly.verify;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import cn.fly.verify.fq;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bp extends bh {
    private String c;
    private long d;
    private ArrayList<HashMap<String, String>> e;

    public bp() {
        super(ed.a("002jd"), 0L, ed.a("004jdDfhdj"), 300L, bh.a(ed.a("002jd"), (Long) 0L));
        this.c = null;
        this.d = 0L;
        this.e = null;
        try {
            File fileA = fz.a(ax.g(), dx.c, true);
            if (!fileA.getParentFile().exists()) {
                fileA.getParentFile().mkdirs();
            }
            if (!fileA.exists()) {
                fileA.createNewFile();
            }
            this.c = fileA.getAbsolutePath();
            this.d = bv.a().b(bv.b, -1L);
        } catch (Throwable unused) {
        }
    }

    private boolean m() {
        try {
            File file = new File(this.c);
            file.delete();
            file.createNewFile();
            return true;
        } catch (Throwable th) {
            en.a().a(th);
            return false;
        }
    }

    private static ArrayList<HashMap<String, String>> b(String str) {
        try {
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(fv.a(jSONArray.getJSONObject(i).toString()));
            }
            return arrayList;
        } catch (Throwable th) {
            en.a().b(th);
            return new ArrayList<>();
        }
    }

    private HashMap<String, String> b(ArrayList<HashMap<String, String>> arrayList, String str) {
        for (HashMap<String, String> map : arrayList) {
            if (str.equals(map.get(ed.a("003j_dlee")))) {
                return map;
            }
        }
        return new HashMap<>();
    }

    private ArrayList<HashMap<String, String>> a(String str, String str2) {
        return a(str2, fz.b(new File(str)));
    }

    private static ArrayList<HashMap<String, String>> a(String str, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    return b(fr.c(str.getBytes("UTF-8"), bArr));
                }
            } catch (Throwable th) {
                en.a().b(th);
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ArrayList<HashMap<String, String>> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put(ed.a("008MdjBfcSeddjdc=di"), Long.valueOf(bv.a().b("key_rcdat", -1L)));
            a(0L, "PRTMT", arrayList, map, false);
        } catch (Throwable unused) {
        }
        bv.a().a(bv.b, System.currentTimeMillis());
        return m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<HashMap<String, String>> a(ArrayList<HashMap<String, String>> arrayList) throws Throwable {
        ArrayList<HashMap<String, String>> arrayListA = !TextUtils.isEmpty(this.c) ? a(this.c, fq.d.j()) : null;
        if (arrayListA == null) {
            arrayListA = new ArrayList<>();
        }
        if (arrayListA.isEmpty()) {
            bv.a().a("key_rcdat", System.currentTimeMillis());
        }
        ArrayList<HashMap<String, String>> arrayList2 = this.e;
        if (arrayList2 == null || arrayList2.isEmpty() || by.f2125a) {
            by.f2125a = false;
            this.e = arrayList;
        }
        ArrayList<HashMap<String, String>> arrayList3 = this.e;
        if (arrayList3 != null) {
            for (int i = 0; i < arrayList3.size(); i++) {
                HashMap<String, String> map = arrayList3.get(i);
                String str = map != null ? map.get(ed.a("003j:dlee")) : null;
                if (!TextUtils.isEmpty(str) && a(str)) {
                    HashMap<String, String> mapB = b(arrayListA, str);
                    mapB.put(ed.a("003jFdlee"), str);
                    mapB.put(ed.a("004ed%df;f"), map.get(ed.a("004ed%df;f")));
                    mapB.put(ed.a("007+dd>fLdjfhdiedOe"), map.get(ed.a("007+dd>fLdjfhdiedOe")));
                    int i2 = mapB.get(ed.a("008!djdg!eiBdidf,f_fh")) == null ? 0 : Integer.parseInt(String.valueOf(mapB.get(ed.a("008!djdg!eiBdidf,f_fh"))));
                    mapB.put(ed.a("008$djdg0ei@didfXfZfh"), (((long) i2) + l()) + "");
                    if (!a(arrayListA, str)) {
                        arrayListA.add(mapB);
                    }
                }
            }
        }
        return arrayListA;
    }

    @Override // cn.fly.verify.bh
    public void a() {
        fq.a(ax.g()).a(false, false).a(new fq.a() { // from class: cn.fly.verify.bp.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) throws Throwable {
                ArrayList arrayListA = bp.this.a(bVar.e(new int[0]));
                if (!TextUtils.isEmpty(bp.this.c)) {
                    bp bpVar = bp.this;
                    bpVar.a((ArrayList<HashMap<String, String>>) arrayListA, bpVar.c, fq.d.j());
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - bp.this.d < ((Long) bp.this.a(ed.a("005jdGee$dj"), 3600L)).longValue() * 1000 || !bp.this.b((ArrayList<HashMap<String, String>>) arrayListA)) {
                    return;
                }
                bp.this.d = bv.a().b(bv.b, -1L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<HashMap<String, String>> arrayList, String str, String str2) {
        fz.a(new File(str), a(str2, arrayList));
    }

    private boolean a(final String str) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        fq.a(ax.g()).a(true, str, 0).a(new fq.a() { // from class: cn.fly.verify.bp.2
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                boolean z = false;
                Object objM = bVar.m(new int[0]);
                if (objM == null) {
                    atomicBoolean.set(false);
                    return;
                }
                ApplicationInfo applicationInfoA = fd.a(objM, str);
                if (applicationInfoA != null) {
                    int i = applicationInfoA.flags;
                    boolean z2 = (i & 1) == 0 && (i & 128) == 0;
                    boolean z3 = (i & 2097152) == 0;
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    if (z2 && z3) {
                        z = true;
                    }
                    atomicBoolean2.set(z);
                }
            }
        });
        return atomicBoolean.get();
    }

    private boolean a(ArrayList<HashMap<String, String>> arrayList, String str) {
        Iterator<HashMap<String, String>> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().get(ed.a("003j1dlee")))) {
                return true;
            }
        }
        return false;
    }

    private static byte[] a(String str, ArrayList<HashMap<String, String>> arrayList) {
        new fv();
        String strA = fv.a((Object) arrayList);
        try {
            return fr.a(str, strA);
        } catch (Throwable th) {
            en.a().b(th);
            return strA.getBytes();
        }
    }
}
