package cn.fly.verify;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile String f2189a = null;
    private static volatile Boolean b = null;
    private static volatile String c = null;
    private static volatile boolean d = false;
    private static HashSet<String> e = new HashSet<>();
    private static final ay f = new ay();

    public static synchronized String a(bd bdVar) {
        HashMap<String, Object> mapB = b(bdVar);
        if (mapB == null) {
            return null;
        }
        return (String) mapB.get(fk.f2351a);
    }

    public static String b() {
        if (a()) {
            return null;
        }
        if (TextUtils.isEmpty(f2189a)) {
            String strA = d().a();
            if (!TextUtils.isEmpty(strA) && TextUtils.isEmpty(f2189a)) {
                f2189a = strA;
            }
        }
        return f2189a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ay d() {
        return f;
    }

    public static boolean a() {
        return !by.a();
    }

    public static synchronized HashMap<String, Object> b(final bd bdVar) {
        boolean z;
        HashMap<String, Object> map;
        boolean z2 = true;
        if (bdVar != null) {
            bu.a(bdVar);
            z = !e.contains(bdVar.a());
            if (z) {
                e.add(bdVar.a());
            }
        } else {
            z = false;
        }
        if (TextUtils.isEmpty(f2189a)) {
            f2189a = d().b();
        } else {
            z2 = z;
        }
        en.a().a("aut pro: " + bdVar + ", ndReg: " + z2 + ", hsReged: " + d, new Object[0]);
        if (z2 || !d) {
            ek.c.execute(new gh() { // from class: cn.fly.verify.dp.1
                @Override // cn.fly.verify.gh
                public void a() {
                    if (by.a(ba.a("002Ufefk"))) {
                        boolean unused = dp.d = true;
                        if (!by.d()) {
                            int i = 0;
                            while (i < 5) {
                                i++;
                                try {
                                    Thread.sleep(5000L);
                                    if (by.d()) {
                                        break;
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                        if (by.d()) {
                            dp.d().a(bdVar, new ge<Void>() { // from class: cn.fly.verify.dp.1.1
                                @Override // cn.fly.verify.ge
                                public void a(Void r1) {
                                }
                            });
                        }
                    }
                }
            });
        }
        if (b == null) {
            String strB = bv.a().b("key_curr_passed_duid", (String) null);
            c = strB;
            b = (TextUtils.isEmpty(strB) || strB.equals(f2189a)) ? Boolean.FALSE : Boolean.TRUE;
        }
        bv.a().a("key_curr_passed_duid", f2189a);
        map = new HashMap<>();
        map.put(fk.f2351a, f2189a);
        map.put("isModified", Boolean.valueOf(b.booleanValue()));
        map.put("duidPrevious", c);
        return map;
    }
}
