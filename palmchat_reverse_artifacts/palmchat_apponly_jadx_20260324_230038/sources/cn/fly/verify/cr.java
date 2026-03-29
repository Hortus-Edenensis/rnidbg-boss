package cn.fly.verify;

import cn.fly.verify.fl;
import java.io.OutputStream;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cr implements dg<cr> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final fl f2165a = new fl();

    public static <T> T a(fk fkVar, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z) throws Throwable {
        return (T) fkVar.a(false, map, map2, str, z);
    }

    public static String a(String str, HashMap<String, Object> map, HashMap<String, String> map2) throws Throwable {
        return f2165a.a(str, map, map2);
    }

    public static String a(String str, HashMap<String, Object> map, HashMap<String, String> map2, fl.a aVar) throws Throwable {
        return f2165a.b(str, map, map2, aVar);
    }

    public static void a(String str, OutputStream outputStream, fl.a aVar) throws Throwable {
        f2165a.a(str, outputStream, aVar);
    }

    @Override // cn.fly.verify.dg
    public boolean a(cr crVar, Class<cr> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if ("hGet".equals(str)) {
            try {
                objArr2[0] = a((String) objArr[0], (HashMap<String, Object>) objArr[1], (HashMap<String, String>) objArr[2]);
            } catch (Throwable th) {
                thArr[0] = th;
                objArr2[0] = null;
            }
            return true;
        }
        if (com.kuaishou.weapon.p0.t.s.equals(str)) {
            try {
                objArr2[0] = a((String) objArr[0], (HashMap) objArr[1], (HashMap) objArr[2], (fl.a) objArr[3]);
            } catch (Throwable th2) {
                thArr[0] = th2;
                objArr2[0] = null;
            }
            return true;
        }
        if (ed.a("008Tdcedff eg*ed$dAdc").equals(str)) {
            try {
                a((String) objArr[0], (OutputStream) objArr[1], (fl.a) objArr[2]);
            } catch (Throwable th3) {
                thArr[0] = th3;
                objArr2[0] = null;
            }
            return true;
        }
        if (!ed.a("0079dj9f^deejdk$ec").equals(str)) {
            return false;
        }
        try {
            objArr2[0] = a((fk) objArr[0], (HashMap) objArr[1], (HashMap) objArr[2], (String) objArr[3], ((Boolean) objArr[4]).booleanValue());
        } catch (Throwable th4) {
            thArr[0] = th4;
            objArr2[0] = null;
        }
        return true;
    }
}
