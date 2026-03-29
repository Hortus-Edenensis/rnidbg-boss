package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class pu4 {
    public static void a(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    public static void b(Class<?>[] clsArr, Object[] objArr) throws Exception {
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }

    public static Object c(Object obj, String str, Object[] objArr, Class[] clsArr) throws Exception {
        a(obj);
        b(clsArr, objArr);
        return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static Object d(Class<?> cls, String str, Object[] objArr, Class[] clsArr) throws Exception {
        a(cls);
        b(clsArr, objArr);
        return cls.getMethod(str, clsArr).invoke(cls, objArr);
    }
}
