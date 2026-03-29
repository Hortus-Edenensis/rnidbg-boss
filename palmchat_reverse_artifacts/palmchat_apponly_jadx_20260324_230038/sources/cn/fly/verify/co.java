package cn.fly.verify;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import cn.fly.verify.da;
import cn.fly.verify.dk;
import cn.fly.verify.fl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final de f2160a = new de();
    private static final cx b = new cx();
    private static volatile da c;
    private static volatile da d;

    static {
        try {
            c = new da(new da.a() { // from class: cn.fly.verify.co.1
                @Override // cn.fly.verify.da.a
                public Object a(String str, ArrayList<Object> arrayList) {
                    try {
                        if (co.d != null) {
                            return co.d.a(str, arrayList);
                        }
                        return null;
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
            d = new da(new da.a() { // from class: cn.fly.verify.co.2
                @Override // cn.fly.verify.da.a
                public Object a(String str, ArrayList<Object> arrayList) {
                    return str + "" + arrayList;
                }
            });
            c.a("tt", null);
        } catch (Throwable unused) {
        }
    }

    public static int a() {
        return dk.a();
    }

    public static LinkedList<Object> a(Object obj, Object... objArr) throws Throwable {
        return ((dm) obj).b(objArr);
    }

    public static void a(Context context, String str, String str2, Method method) throws Throwable {
        a(dk.a(str), context, str2, method);
    }

    public static void a(Context context, String str, String str2, HashMap<String, Object> map, HashMap<String, Object> map2) throws Throwable {
        dk.c cVarA = dk.a(str);
        cVarA.a("ss_dhMap", map).a("ss_dataMaps", map2);
        a(cVarA, context, str2, (Method) null);
    }

    public static void a(Context context, byte[] bArr, String str, Method method) throws Throwable {
        a(dk.a(bArr), context, str, method);
    }

    private static void a(dk.c cVar, Context context, String str, Method method) throws Throwable {
        cVar.a(dx.a("012KeeYhd(bh^bgPbgcbPc=chJdg"), cx.class).a(dx.a("003(facfci"), cr.class).a(dx.a("004,fachejdh"), cu.class).a(dx.a("015AchdgdhPbcZbaXed3bhci'f[bhUdbQba"), em.class).a(dx.a("019-chdgdgbhcb'bDbaVab;dfFg9egIdad]bgbb)dObh"), cw.class).a(dx.a("017?chdgeicb cgdcg5egFdMdfcb0eWbb2d.bh"), cz.class).a(dx.a("019Tchdgch4d^bhbbbg ad)eicbKccdag?bgcb)c"), dc.class).a(dx.a("017NchdgeicbMcgdcgLeedcdfPdMbhbb9dKbh"), cy.class).a(dx.a("017,chdgcf,dg.ddcbbhbjei6bee6dc^ba@bj"), db.class).a(dx.a("009*chdgdhYbcBba5ed)bh"), da.class).a(dx.a("003Ffacfei"), fk.class).a(dx.a("0045facfciee"), fl.a.class).a(dx.a("003@dhcbcg"), dy.class).a(cw.class, cw.class).a(cy.class, cy.class).a(dc.class, dd.class).a(db.class, db.class).a(de.class, de.class).a(cx.class, cx.class).a(cr.class, cr.class).a(cu.class, cv.class).a(Context.class, cq.class).a(PackageManager.class, ct.class).a(NotificationManager.class, cs.class).a(dy.class, cp.class).a("ss_opSet", b).a("ss_suls", f2160a).a(dx.a("0153dfdfbf+aLcb$cgdJca]g,ejFb?bhFb'bd"), context).a(dx.a("014]dfdfbfdfVgb[bh6gAej0bGbhKbXbddf"), str).a(dx.a("012Ydfdfbfdf.gb_bh^gUcibgbd0d"), Long.valueOf(System.currentTimeMillis())).a(dx.a("0062dfdfbfbdbaKh"), method).a(dx.a("016aXcbbdbdcbEcbhFdbdfbabjdb2aRbaXa"));
        cVar.a();
    }
}
