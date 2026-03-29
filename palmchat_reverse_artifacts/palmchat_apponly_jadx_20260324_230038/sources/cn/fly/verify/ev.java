package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ev implements ep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2261a;

    public ev(Context context) {
        this.f2261a = context;
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Long> A() {
        return (HashMap) a(HashMap.class, fb.a("gmrin", null));
    }

    @Override // cn.fly.verify.ep
    public String B() {
        return (String) a(String.class, fb.a("galgu", null));
    }

    @Override // cn.fly.verify.ep
    public String C() {
        return (String) a(String.class, fb.a("gscsz", null));
    }

    @Override // cn.fly.verify.ep
    public String D() {
        return (String) a(String.class, fb.a("gneypnw", null));
    }

    @Override // cn.fly.verify.ep
    public String E() {
        return (String) a(String.class, fb.a("gnktpfs", null));
    }

    @Override // cn.fly.verify.ep
    public String F() {
        return (String) a(String.class, fb.a("gdtlnktpfs", null));
    }

    @Override // cn.fly.verify.ep
    public boolean G() {
        return ((Boolean) a(Boolean.TYPE, fb.a("cknavbl", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public int H() {
        return ((Integer) a(Integer.TYPE, fb.a("gdntp", null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public String I() {
        return (String) a(String.class, fb.a("gtmne", null));
    }

    @Override // cn.fly.verify.ep
    public String J() {
        return (String) a(String.class, fb.a("gflv", null));
    }

    @Override // cn.fly.verify.ep
    public String K() {
        return (String) a(String.class, fb.a("gbsbd", null));
    }

    @Override // cn.fly.verify.ep
    public String L() {
        return (String) a(String.class, fb.a("gbfspy", null));
    }

    @Override // cn.fly.verify.ep
    public String M() {
        return (String) a(String.class, fb.a("gbplfo", null));
    }

    @Override // cn.fly.verify.ep
    public String N() {
        return (String) a(String.class, fb.a("giads", null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> O() {
        return (ArrayList) a(ArrayList.class, fb.a("gal", null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> P() {
        return (ArrayList) a(ArrayList.class, fb.a("gsl", null));
    }

    @Override // cn.fly.verify.ep
    public String Q() {
        return (String) a(String.class, fb.a("gdvk", null));
    }

    @Override // cn.fly.verify.ep
    public String R() {
        return (String) a(String.class, fb.a("gscpt", null));
    }

    @Override // cn.fly.verify.ep
    public String S() {
        return (String) a(String.class, fb.a("gsnmd", null));
    }

    @Override // cn.fly.verify.ep
    public String T() {
        return (String) a(String.class, fb.a("gpgnm", null));
    }

    @Override // cn.fly.verify.ep
    public String U() {
        return (String) a(String.class, fb.a("gpnmmt", null));
    }

    @Override // cn.fly.verify.ep
    public int V() {
        return ((Integer) a(Integer.TYPE, fb.a("gpvsnm", null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public String W() {
        return (String) a(String.class, fb.a("gpvsme", null));
    }

    @Override // cn.fly.verify.ep
    public boolean X() {
        return ((Boolean) a(Boolean.TYPE, fb.a("cinmnps", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String Y() {
        return (String) a(String.class, fb.a("gcrtpcnm", null));
    }

    @Override // cn.fly.verify.ep
    public boolean Z() {
        return ((Boolean) a(Boolean.TYPE, fb.a("ciafgd", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo a(String str, int i) {
        return (ApplicationInfo) a(ApplicationInfo.class, fb.a("gtaifprm", new ArrayList(Arrays.asList(str, Integer.valueOf(i)))));
    }

    @Override // cn.fly.verify.ep
    public Context aa() {
        return (Context) a(Context.class, fb.a("gaplcn", null));
    }

    @Override // cn.fly.verify.ep
    public String ab() {
        return (String) a(String.class, fb.a("gdvda", null));
    }

    @Override // cn.fly.verify.ep
    public String ac() {
        return (String) a(String.class, fb.a("gdvdtnas", null));
    }

    @Override // cn.fly.verify.ep
    public long ad() {
        return ((Long) a(Long.TYPE, fb.a("galtut", null))).longValue();
    }

    @Override // cn.fly.verify.ep
    public String ae() {
        return (String) a(String.class, fb.a("gdvme", null));
    }

    @Override // cn.fly.verify.ep
    public String af() {
        return (String) a(String.class, fb.a("gcrup", null));
    }

    @Override // cn.fly.verify.ep
    public String ag() {
        return (String) a(String.class, fb.a("gcifm", null));
    }

    @Override // cn.fly.verify.ep
    public String ah() {
        return (String) a(String.class, fb.a("godm", null));
    }

    @Override // cn.fly.verify.ep
    public String ai() {
        return (String) a(String.class, fb.a("godhm", null));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> aj() {
        return (HashMap) a(HashMap.class, fb.a("galdm", null));
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo ak() {
        return (ApplicationInfo) a(ApplicationInfo.class, fb.a("gtaif", null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, Object>> al() {
        return (ArrayList) a(ArrayList.class, fb.a("gtaifok", null));
    }

    @Override // cn.fly.verify.ep
    public long am() {
        return ((Long) a(Long.TYPE, fb.a("gtbdt", null))).longValue();
    }

    @Override // cn.fly.verify.ep
    public double an() {
        return ((Double) a(Double.TYPE, fb.a("gtscnin", null))).doubleValue();
    }

    @Override // cn.fly.verify.ep
    public int ao() {
        return ((Integer) a(Integer.TYPE, fb.a("gtscnppi", null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public boolean ap() {
        return ((Boolean) a(Boolean.TYPE, fb.a("ishmos", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String aq() {
        return (String) a(String.class, fb.a("gthmosv", null));
    }

    @Override // cn.fly.verify.ep
    public String ar() {
        return (String) a(String.class, fb.a("gthmosdtlv", null));
    }

    @Override // cn.fly.verify.ep
    public int as() {
        return ((Integer) a(Integer.TYPE, fb.a("gthmpmst", null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public int at() {
        return ((Integer) a(Integer.TYPE, fb.a("gthmepmst", null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public String au() {
        return (String) a(String.class, fb.a("gtinnerlangmt", null));
    }

    @Override // cn.fly.verify.ep
    public int av() {
        return ((Integer) a(Integer.TYPE, fb.a("gtgramgendt", null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public boolean aw() {
        return ((Boolean) a(Boolean.TYPE, fb.a("ctedebbing", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public ResolveInfo b(Intent intent, int i) {
        return (ResolveInfo) a(ResolveInfo.class, fb.a("rsaciy", new ArrayList(Arrays.asList(intent, Integer.valueOf(i)))));
    }

    @Override // cn.fly.verify.ep
    public String c(String str) {
        return (String) a(String.class, fb.a("gsnmdfp", new ArrayList(Arrays.asList(str))));
    }

    @Override // cn.fly.verify.ep
    public String d(String str) {
        return (String) a(String.class, fb.a("gpnmfp", new ArrayList(Arrays.asList(str))));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> e(boolean z) {
        return (HashMap) a(HashMap.class, fb.a("wmcwifce", new ArrayList(Arrays.asList(Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public String f(boolean z) {
        return (String) a(String.class, fb.a("gneypfce", new ArrayList(Arrays.asList(Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public String g(boolean z) {
        return (String) a(String.class, fb.a("gdvkfc", new ArrayList(Arrays.asList(Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public String h(boolean z) {
        return (String) a(String.class, fb.a("gtdm", new ArrayList(Arrays.asList(Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public boolean i() {
        return ((Boolean) a(Boolean.TYPE, fb.a("iwpxy", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public String j() {
        return (String) a(String.class, fb.a("gavti", null));
    }

    @Override // cn.fly.verify.ep
    public String k() {
        return (String) a(String.class, fb.a("gmivsn", null));
    }

    @Override // cn.fly.verify.ep
    public String l() {
        return (String) a(String.class, fb.a("bgmdl", null));
    }

    @Override // cn.fly.verify.ep
    public String m() {
        return (String) a(String.class, fb.a("gmnft", null));
    }

    @Override // cn.fly.verify.ep
    public String n() {
        return (String) a(String.class, fb.a("gbrd", null));
    }

    @Override // cn.fly.verify.ep
    public String o() {
        return (String) a(String.class, fb.a("gdvtp", null));
    }

    @Override // cn.fly.verify.ep
    public Object p() {
        return a(Object.class, fb.a("gtecloc", null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, Object>> q() {
        return (ArrayList) a(ArrayList.class, fb.a("gnbclin", null));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> r() {
        return e(false);
    }

    @Override // cn.fly.verify.ep
    public int s() {
        return ((Integer) a(Integer.TYPE, fb.a("govsit", null))).intValue();
    }

    @Override // cn.fly.verify.ep
    public String t() {
        return (String) a(String.class, fb.a("govsnm", null));
    }

    @Override // cn.fly.verify.ep
    public String u() {
        return (String) a(String.class, fb.a("golgu", null));
    }

    @Override // cn.fly.verify.ep
    public String v() {
        return (String) a(String.class, fb.a("gocnty", null));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, Object> w() {
        return (HashMap) a(HashMap.class, fb.a("gcuin", null));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<ArrayList<String>> x() {
        return (ArrayList) a(ArrayList.class, fb.a("gtydvin", null));
    }

    @Override // cn.fly.verify.ep
    public String y() {
        return (String) a(String.class, fb.a("gqmkn", null));
    }

    @Override // cn.fly.verify.ep
    public HashMap<String, HashMap<String, Long>> z() {
        return (HashMap) a(HashMap.class, fb.a("gszin", null));
    }

    @Override // cn.fly.verify.ep
    public ApplicationInfo a(boolean z, String str, int i) {
        return (ApplicationInfo) a(ApplicationInfo.class, fb.a("gtaifprmfce", new ArrayList(Arrays.asList(Boolean.valueOf(z), str, Integer.valueOf(i)))));
    }

    @Override // cn.fly.verify.ep
    public Object b(boolean z, int i, String str, int i2) {
        return a(PackageInfo.class, fb.a("gmpfis", new ArrayList(Arrays.asList(Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2)))));
    }

    @Override // cn.fly.verify.ep
    public String c(boolean z) {
        return (String) a(String.class, fb.a("gcriefce", new ArrayList(Arrays.asList(Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public String d(boolean z) {
        return (String) a(String.class, fb.a("gcrnmfce", new ArrayList(Arrays.asList(Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public boolean e() {
        return ((Boolean) a(Boolean.TYPE, fb.a("vnmt", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean f() {
        return ((Boolean) a(Boolean.TYPE, fb.a("ckua", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean g() {
        return ((Boolean) a(Boolean.TYPE, fb.a("dvenbl", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean h() {
        return ((Boolean) a(Boolean.TYPE, fb.a("ubenbl", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public PackageInfo a(boolean z, int i, String str, int i2) {
        return (PackageInfo) a(PackageInfo.class, fb.a("gpgiffist", new ArrayList(Arrays.asList(Boolean.valueOf(z), Integer.valueOf(i), str, Integer.valueOf(i2)))));
    }

    @Override // cn.fly.verify.ep
    public String b(boolean z) {
        return (String) a(String.class, fb.a("gbsifce", new ArrayList(Arrays.asList(Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public boolean c() {
        return ((Boolean) a(Boolean.TYPE, fb.a("ckpd", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean d() {
        return ((Boolean) a(Boolean.TYPE, fb.a("degb", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public boolean e(String str) {
        return ((Boolean) a(Boolean.TYPE, fb.a("ckpmsi", new ArrayList(Arrays.asList(str))))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public Location a(int i, int i2, boolean z) {
        return (Location) a(Location.class, fb.a("glctn", new ArrayList(Arrays.asList(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public boolean b() {
        return ((Boolean) a(Boolean.TYPE, fb.a("cx", null))).booleanValue();
    }

    @Override // cn.fly.verify.ep
    public Object a(int i, int i2, boolean z, boolean z2) {
        return a(Object.class, fb.a("gtelcmefce", new ArrayList(Arrays.asList(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)))));
    }

    @Override // cn.fly.verify.ep
    public boolean b(String str) {
        return ((Boolean) a(Boolean.TYPE, fb.a("ipgist", new ArrayList(Arrays.asList(str))))).booleanValue();
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

    @Override // cn.fly.verify.ep
    public String a(String str) {
        return (String) a(String.class, fb.a("gstmpts", new ArrayList(Arrays.asList(str))));
    }

    @Override // cn.fly.verify.ep
    public String a(boolean z) {
        return (String) a(String.class, fb.a("gsimtfce", new ArrayList(Arrays.asList(Boolean.valueOf(z)))));
    }

    @Override // cn.fly.verify.ep
    public ArrayList<HashMap<String, String>> a(boolean z, boolean z2) {
        return (ArrayList) a(ArrayList.class, fb.a("giafce", new ArrayList(Arrays.asList(Boolean.valueOf(z), Boolean.valueOf(z2)))));
    }

    @Override // cn.fly.verify.ep
    public List<ResolveInfo> a(Intent intent, int i) {
        return (List) a(List.class, fb.a("qritsvc", new ArrayList(Arrays.asList(intent, Integer.valueOf(i)))));
    }

    @Override // cn.fly.verify.ep
    public boolean a() {
        return ((Boolean) a(Boolean.TYPE, fb.a("cird", null))).booleanValue();
    }
}
