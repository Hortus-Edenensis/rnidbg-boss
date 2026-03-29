package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class eu implements ep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f2260a;

    public eu(HashMap<String, Object> map) {
        this.f2260a = map;
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Long> A() {
        return (HashMap) a(HashMap.class, a("gmrin", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String B() {
        return (String) a(String.class, a("galgu", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String C() {
        return (String) a(String.class, a("gscsz", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String D() {
        return (String) a(String.class, a("gneypnw", new Object[0]));
    }

    @Override // cn.fly.verify.ep
    public String E() {
        return (String) a(String.class, a("gnktpfs", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String F() {
        return (String) a(String.class, a("gdtlnktpfs", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public boolean G() {
        return ((Boolean) a(Boolean.TYPE, a("cknavbl", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public int H() {
        return ((Integer) a(Integer.TYPE, a("gdntp", (Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public String I() {
        return (String) a(String.class, a("gtmne", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String J() {
        return (String) a(String.class, a("gflv", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String K() {
        return (String) a(String.class, a("gbsbd", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String L() {
        return (String) a(String.class, a("gbfspy", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String M() {
        return (String) a(String.class, a("gbplfo", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String N() {
        return (String) a(String.class, a("giads", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> O() {
        return (ArrayList) a(ArrayList.class, a("gal", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> P() {
        return (ArrayList) a(ArrayList.class, a("gsl", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String Q() {
        return (String) a(String.class, a("gdvk", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String R() {
        return (String) a(String.class, a("gscpt", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String S() {
        return (String) a(String.class, a("gsnmd", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String T() {
        return (String) a(String.class, a("gpgnm", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String U() {
        return (String) a(String.class, a("gpnmmt", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public int V() {
        return ((Integer) a(Integer.TYPE, a("gpvsnm", (Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public String W() {
        return (String) a(String.class, a("gpvsme", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public boolean X() {
        return ((Boolean) a(Boolean.TYPE, a("cinmnps", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String Y() {
        return (String) a(String.class, a("gcrtpcnm", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public boolean Z() {
        return ((Boolean) a(Boolean.TYPE, a("ciafgd", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo a(String str, int i) {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaifprm", str, Integer.valueOf(i)));
    }

    @Override // cn.fly.verify.ep
    public Context aa() {
        return (Context) a(Context.class, a("gaplcn", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String ab() {
        return (String) a(String.class, a("gdvda", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String ac() {
        return (String) a(String.class, a("gdvdtnas", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public long ad() {
        return ((Long) a(Long.TYPE, a("galtut", (Object[]) null))).longValue();
    }

    @Override // cn.fly.verify.ep
    public String ae() {
        return (String) a(String.class, a("gdvme", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String af() {
        return (String) a(String.class, a("gcrup", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String ag() {
        return (String) a(String.class, a("gcifm", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String ah() {
        return (String) a(String.class, a("godm", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String ai() {
        return (String) a(String.class, a("godhm", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> aj() {
        return (HashMap) a(HashMap.class, a("galdm", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo ak() {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaif", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, Object>> al() {
        return (ArrayList) a(ArrayList.class, a("gtaifok", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public long am() {
        return ((Long) a(Long.TYPE, a("gtbdt", (Object[]) null))).longValue();
    }

    @Override // cn.fly.verify.ep
    public double an() {
        return ((Double) a(Double.TYPE, a("gtscnin", (Object[]) null))).doubleValue();
    }

    @Override // cn.fly.verify.ep
    public int ao() {
        return ((Integer) a(Integer.TYPE, a("gtscnppi", (Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public boolean ap() {
        return ((Boolean) a(Boolean.TYPE, a("ishmos", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String aq() {
        return (String) a(String.class, a("gthmosv", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String ar() {
        return (String) a(String.class, a("gthmosdtlv", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public int as() {
        return ((Integer) a(Integer.TYPE, a("gthmpmst", (Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public int at() {
        return ((Integer) a(Integer.TYPE, a("gthmepmst", (Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public String au() {
        return (String) a(String.class, a("gtinnerlangmt", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public int av() {
        return ((Integer) a(Integer.TYPE, a("gtgramgendt", (Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public boolean aw() {
        return ((Boolean) a(Boolean.TYPE, a("ctedebbing", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public ResolveInfo b(Intent intent, int i) {
        return (ResolveInfo) a(ResolveInfo.class, a("rsaciy", intent, Integer.valueOf(i)));
    }

    @Override // cn.fly.verify.ep
    public String c(String str) {
        return (String) a(String.class, a("gsnmdfp", str));
    }

    @Override // cn.fly.verify.ep
    public String d(String str) {
        return (String) a(String.class, a("gpnmfp", str));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> e(boolean z) {
        return (HashMap) a(HashMap.class, a("wmcwifce", Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public String f(boolean z) {
        return (String) a(String.class, a("gneypfce", Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public String g(boolean z) {
        return (String) a(String.class, a("gdvkfc", Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public String h(boolean z) {
        return (String) a(String.class, a("gtdm", Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public boolean i() {
        return ((Boolean) a(Boolean.TYPE, a("iwpxy", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String j() {
        return (String) a(String.class, a("gavti", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String k() {
        return (String) a(String.class, a("gmivsn", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String l() {
        return (String) a(String.class, a("bgmdl", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String m() {
        return (String) a(String.class, a("gmnft", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String n() {
        return (String) a(String.class, a("gbrd", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String o() {
        return (String) a(String.class, a("gdvtp", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public Object p() {
        return a(Object.class, a("gtecloc", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, Object>> q() {
        return (ArrayList) a(ArrayList.class, a("gnbclin", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> r() {
        return e(false);
    }

    @Override // cn.fly.verify.ep
    public int s() {
        return ((Integer) a(Integer.TYPE, a("govsit", (Object[]) null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public String t() {
        return (String) a(String.class, a("govsnm", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String u() {
        return (String) a(String.class, a("golgu", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String v() {
        return (String) a(String.class, a("gocnty", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> w() {
        return (HashMap) a(HashMap.class, a("gcuin", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<ArrayList<String>> x() {
        return (ArrayList) a(ArrayList.class, a("gtydvin", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public String y() {
        return (String) a(String.class, a("gqmkn", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, HashMap<String, Long>> z() {
        return (HashMap) a(HashMap.class, a("gszin", (Object[]) null));
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo a(boolean z, String str, int i) {
        return (ApplicationInfo) a(ApplicationInfo.class, a("gtaifprmfce", Boolean.valueOf(z), str, Integer.valueOf(i)));
    }

    @Override // cn.fly.verify.ep
    public Object b(boolean z, int i, String str, int i2) {
        return a(Object.class, a("gpgiffist", Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2)));
    }

    @Override // cn.fly.verify.ep
    public String c(boolean z) {
        return (String) a(String.class, a("gcriefce", Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public String d(boolean z) {
        return (String) a(String.class, a("gcrnmfce", Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public boolean e() {
        return ((Boolean) a(Boolean.TYPE, a("vnmt", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean f() {
        return ((Boolean) a(Boolean.TYPE, a("ckua", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean g() {
        return ((Boolean) a(Boolean.TYPE, a("dvenbl", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean h() {
        return ((Boolean) a(Boolean.TYPE, a("ubenbl", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public PackageInfo a(boolean z, int i, String str, int i2) {
        return (PackageInfo) a(PackageInfo.class, a("gpgiffist", Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2)));
    }

    @Override // cn.fly.verify.ep
    public String b(boolean z) {
        return (String) a(String.class, a("gbsifce", Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public boolean c() {
        return ((Boolean) a(Boolean.TYPE, a("ckpd", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean d() {
        return ((Boolean) a(Boolean.TYPE, a("degb", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean e(String str) {
        return ((Boolean) a(Boolean.TYPE, a("ckpmsi", str))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public Location a(int i, int i2, boolean z) {
        return (Location) a(Location.class, a("glctn", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public boolean b() {
        return ((Boolean) a(Boolean.TYPE, a("cx", (Object[]) null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public Object a(int i, int i2, boolean z, boolean z2) {
        return a(Object.class, a("gtelcmefce", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)));
    }

    @Override // cn.fly.verify.ep
    public boolean b(String str) {
        return ((Boolean) a(Boolean.TYPE, a("ipgist", str))).booleanValue();
    }

    private <T> T a(Class<T> cls, Object obj) {
        T tCast;
        Class cls2;
        T t = (T) null;
        if (cls != null && obj != null && cls != Void.class) {
            try {
                if (cls == Boolean.TYPE) {
                    cls2 = Boolean.class;
                } else if (cls == Integer.TYPE) {
                    cls2 = Integer.class;
                } else if (cls == Byte.TYPE) {
                    cls2 = Byte.class;
                } else if (cls == Character.TYPE) {
                    cls2 = Character.class;
                } else if (cls == Short.TYPE) {
                    cls2 = Short.class;
                } else if (cls == Long.TYPE) {
                    cls2 = Long.class;
                } else if (cls == Float.TYPE) {
                    cls2 = Float.class;
                } else if (cls == Double.TYPE) {
                    cls2 = Double.class;
                } else {
                    tCast = cls.cast(obj);
                    t = tCast;
                }
                tCast = (T) cls2.cast(obj);
                t = tCast;
            } catch (Throwable th) {
                en.a().a(th);
            }
        }
        return t == null ? cls == Boolean.TYPE ? (T) Boolean.FALSE : cls == Integer.TYPE ? (T) (-1) : cls == Byte.TYPE ? (T) (byte) 0 : cls == Character.TYPE ? (T) (char) 0 : cls == Short.TYPE ? (T) (short) 0 : cls == Long.TYPE ? (T) 0L : cls == Float.TYPE ? (T) Float.valueOf(0.0f) : cls == Double.TYPE ? (T) Double.valueOf(0.0d) : t : t;
    }

    private Object a(String str, Object... objArr) {
        LinkedList<Object> linkedListA;
        try {
            HashMap<String, Object> map = this.f2260a;
            if (map == null || !map.containsKey(str) || (linkedListA = co.a(this.f2260a.get(str), objArr)) == null || linkedListA.isEmpty()) {
                return null;
            }
            return linkedListA.get(0);
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    @Override // cn.fly.verify.ep
    public String a(String str) {
        return (String) a(String.class, a("gstmpts", str));
    }

    @Override // cn.fly.verify.ep
    public String a(boolean z) {
        return (String) a(String.class, a("gsimtfce", Boolean.valueOf(z)));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> a(boolean z, boolean z2) {
        return (ArrayList) a(ArrayList.class, a("giafce", Boolean.valueOf(z), Boolean.valueOf(z2)));
    }

    @Override // cn.fly.verify.ep
    public List<ResolveInfo> a(Intent intent, int i) {
        return (List) a(List.class, a("qritsvc", intent, Integer.valueOf(i)));
    }

    @Override // cn.fly.verify.ep
    public boolean a() {
        return ((Boolean) a(Boolean.TYPE, a("cird", (Object[]) null))).booleanValue();
    }
}
