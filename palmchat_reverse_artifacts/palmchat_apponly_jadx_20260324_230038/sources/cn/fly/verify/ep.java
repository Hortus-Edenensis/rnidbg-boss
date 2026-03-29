package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface ep {
    HashMap<String, Long> A();

    String B();

    String C();

    String D();

    String E();

    String F();

    boolean G();

    int H();

    String I();

    String J();

    String K();

    String L();

    String M();

    String N();

    ArrayList<HashMap<String, String>> O();

    ArrayList<HashMap<String, String>> P();

    String Q();

    String R();

    String S();

    String T();

    String U();

    int V();

    String W();

    boolean X();

    String Y();

    boolean Z();

    ApplicationInfo a(String str, int i);

    ApplicationInfo a(boolean z, String str, int i);

    PackageInfo a(boolean z, int i, String str, int i2);

    Location a(int i, int i2, boolean z);

    Object a(int i, int i2, boolean z, boolean z2);

    String a(String str);

    String a(boolean z);

    ArrayList<HashMap<String, String>> a(boolean z, boolean z2);

    List<ResolveInfo> a(Intent intent, int i);

    boolean a();

    Context aa();

    String ab();

    String ac();

    long ad();

    String ae();

    String af();

    String ag();

    String ah();

    String ai();

    HashMap<String, Object> aj();

    ApplicationInfo ak();

    ArrayList<HashMap<String, Object>> al();

    long am();

    double an();

    int ao();

    boolean ap();

    String aq();

    String ar();

    int as();

    int at();

    String au();

    int av();

    boolean aw();

    ResolveInfo b(Intent intent, int i);

    Object b(boolean z, int i, String str, int i2);

    String b(boolean z);

    boolean b();

    boolean b(String str);

    String c(String str);

    String c(boolean z);

    boolean c();

    String d(String str);

    String d(boolean z);

    boolean d();

    HashMap<String, Object> e(boolean z);

    boolean e();

    boolean e(String str);

    String f(boolean z);

    boolean f();

    String g(boolean z);

    boolean g();

    String h(boolean z);

    boolean h();

    boolean i();

    String j();

    String k();

    String l();

    String m();

    String n();

    String o();

    Object p();

    ArrayList<HashMap<String, Object>> q();

    HashMap<String, Object> r();

    int s();

    String t();

    String u();

    String v();

    HashMap<String, Object> w();

    ArrayList<ArrayList<String>> x();

    String y();

    HashMap<String, HashMap<String, Long>> z();
}
