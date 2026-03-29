package cn.fly.verify;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f2222a = null;
    public static volatile String b = null;
    public static volatile String c = null;
    public static volatile String d = null;
    public static volatile bb e = null;
    public static volatile boolean f = false;
    public static volatile boolean g = false;
    public static volatile boolean h = true;
    public static volatile boolean i = false;
    public static volatile String j;
    private static AtomicBoolean k = new AtomicBoolean(false);
    private static final String l = b("009Cgbdceddiejhbecce.h");
    private static final String m = b("011ZdiCgc^ci(e:diejhbecce1h");
    private static final String n = b("010)gbdcedfkcfegRg<ecce+h");
    private static final String o = b("012CdiYeb.fi%e]cichdecjecceSh");
    private static final String p = b("009$digbdidiejhbecce*h");
    private static final String q = b("010<gbdcedebch4d;ckecceEh");
    private static HashMap<String, HashMap<String, Object>> r = new HashMap<>();

    public static <T> T a(String str) {
        try {
            Bundle bundle = er.a(ax.g()).d().a(ax.g().getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            T t = (T) bundle.get(str);
            if (b("0094gbdcedgjeiHhhiPeg").equals(str) && t != null && (t instanceof String)) {
                return (T) Boolean.valueOf(b("003$cj_eIeg").equalsIgnoreCase(String.valueOf(t)));
            }
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }

    public static String b(String str) {
        return eg.a(str, 98);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(String str, Class<T> cls, bd bdVar) {
        Object obj;
        GZIPInputStream gZIPInputStream;
        HashMap<String, Object> map;
        ObjectInputStream objectInputStream;
        Class cls2;
        T tCast;
        T t = null;
        try {
            String strA = a(bdVar);
            if (r.containsKey(strA)) {
                map = r.get(strA);
                gZIPInputStream = null;
                objectInputStream = null;
            } else {
                try {
                    gZIPInputStream = new GZIPInputStream(ax.g().getResources().getAssets().open(strA));
                    try {
                        objectInputStream = new ObjectInputStream(gZIPInputStream);
                        try {
                            HashMap<String, Object> map2 = (HashMap) objectInputStream.readObject();
                            if (map2 != null) {
                                try {
                                    if (!map2.isEmpty()) {
                                        r.put(strA, map2);
                                    }
                                } catch (Throwable unused) {
                                    map = map2;
                                    try {
                                        en.a().a("No ast file", new Object[0]);
                                    } catch (Throwable th) {
                                        th = th;
                                        obj = null;
                                        t = (T) objectInputStream;
                                        try {
                                            en.a().a(th);
                                            eg.a(t, gZIPInputStream);
                                            return (T) obj;
                                        } catch (Throwable th2) {
                                            eg.a(t, gZIPInputStream);
                                            throw th2;
                                        }
                                    }
                                }
                            }
                            map = map2;
                        } catch (Throwable unused2) {
                            map = null;
                        }
                    } catch (Throwable unused3) {
                        map = null;
                        objectInputStream = null;
                    }
                } catch (Throwable unused4) {
                    map = null;
                    gZIPInputStream = null;
                    objectInputStream = null;
                }
            }
            if (map != null && !map.isEmpty()) {
                obj = map.get(str);
                if (b("009MgbdcedgjeiVhhi7eg").equals(str) && obj != null && (obj instanceof String)) {
                    t = (T) Boolean.valueOf(b("003!cjJe8eg").equalsIgnoreCase(String.valueOf(obj)) || b("004h5cicf0e").equalsIgnoreCase(String.valueOf(obj)));
                } else if (obj != null) {
                    if (cls == null) {
                        t = (T) obj;
                    } else if (cls != Void.class) {
                        try {
                            if (cls == Boolean.TYPE) {
                                if (obj instanceof String) {
                                    tCast = (T) Boolean.valueOf((String) obj);
                                    t = tCast;
                                } else {
                                    cls2 = Boolean.class;
                                    tCast = (T) cls2.cast(obj);
                                    t = tCast;
                                }
                            } else if (cls == Integer.TYPE) {
                                if (obj instanceof String) {
                                    tCast = (T) Integer.valueOf((String) obj);
                                    t = tCast;
                                } else {
                                    cls2 = Integer.class;
                                    tCast = (T) cls2.cast(obj);
                                    t = tCast;
                                }
                            } else if (cls != Byte.TYPE) {
                                cls2 = Character.TYPE;
                                if (cls == cls2) {
                                    if (!(obj instanceof String)) {
                                        cls2 = Character.class;
                                    }
                                } else if (cls == Short.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Short.valueOf((String) obj);
                                        t = tCast;
                                    } else {
                                        cls2 = Short.class;
                                    }
                                } else if (cls == Long.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Long.valueOf((String) obj);
                                        t = tCast;
                                    } else {
                                        cls2 = Long.class;
                                    }
                                } else if (cls != Float.TYPE) {
                                    if (cls != Double.TYPE) {
                                        tCast = cls.cast(obj);
                                    } else if (obj instanceof String) {
                                        tCast = (T) Double.valueOf((String) obj);
                                    } else {
                                        cls2 = Double.class;
                                    }
                                    t = tCast;
                                } else if (obj instanceof String) {
                                    tCast = (T) Float.valueOf((String) obj);
                                    t = tCast;
                                } else {
                                    cls2 = Float.class;
                                }
                                tCast = (T) cls2.cast(obj);
                                t = tCast;
                            } else if (obj instanceof String) {
                                tCast = (T) Byte.valueOf((String) obj);
                                t = tCast;
                            } else {
                                cls2 = Byte.class;
                                tCast = (T) cls2.cast(obj);
                                t = tCast;
                            }
                        } catch (Throwable th3) {
                            try {
                                en.a().a(th3);
                                t = (T) obj;
                            } catch (Throwable th4) {
                                th = th4;
                                t = (T) objectInputStream;
                                en.a().a(th);
                                eg.a(t, gZIPInputStream);
                                return (T) obj;
                            }
                        }
                    }
                }
            }
            eg.a(objectInputStream, gZIPInputStream);
            return t;
        } catch (Throwable th5) {
            th = th5;
            obj = null;
            gZIPInputStream = null;
        }
    }

    private static String a(bd bdVar) {
        String str;
        String str2 = l;
        if (bdVar == null) {
            return str2;
        }
        try {
            String strA = bdVar.a();
            if (b("008Mdieidkfhfgdiejhb").equals(strA)) {
                str = m;
            } else if (b("006^digbdidiejhb").equals(strA)) {
                str = p;
            } else if (b("007Sgbffehebdhdghb").equals(strA)) {
                str = q;
            } else if (b("007%gbffehfkdfdiei").equals(strA)) {
                str = n;
            } else {
                if (!b("009Vdifgfjfifgfhdhekhj").equals(strA)) {
                    return str2;
                }
                str = o;
            }
            return str;
        } catch (Throwable th) {
            en.a().a(th);
            return str2;
        }
    }

    public static void a(Context context) {
        try {
            if (k.compareAndSet(false, true)) {
                try {
                    if (f2222a == null) {
                        String strL = (String) bc.a(null, b("010Ggbdcedgjdk[ii$hb5eJcj"), String.class, null);
                        if (TextUtils.isEmpty(strL)) {
                            strL = bv.a().l();
                            if (TextUtils.isEmpty(strL)) {
                                strL = ei.i();
                            }
                            if (!TextUtils.isEmpty(strL)) {
                                c = strL;
                            }
                        } else {
                            f2222a = strL;
                            c = strL;
                        }
                        bv.a().e(strL);
                    }
                    if (b == null) {
                        String str = (String) bc.a(null, b("013ZgbdcedgjdkVii4di6ebDciHeh"), String.class, null);
                        if (TextUtils.isEmpty(str)) {
                            str = (String) bc.a(null, b("012EgbdcedgjdkCii;di^eGci8eh"), String.class, null);
                        }
                        if (TextUtils.isEmpty(str)) {
                            String strM = bv.a().m();
                            if (!TextUtils.isEmpty(strM)) {
                                d = strM;
                            }
                        } else {
                            b = str;
                            d = str;
                            bv.a().f(str);
                        }
                    }
                } catch (Throwable unused) {
                }
                try {
                    String str2 = (String) bc.a(null, b("006TejdcceGcLch9d"), String.class, null);
                    if (str2 != null) {
                        e = bb.a(str2);
                    }
                } catch (Throwable unused2) {
                    e = bb.DEFAULT;
                }
                j = (String) bc.a(null, b("015]gbdcedgjffcbfichccdcdk]iiGdhcb"), String.class, null);
                f = true;
                String strB = b("0066gbdcedgjfigg");
                Class cls = Boolean.TYPE;
                Boolean bool = Boolean.FALSE;
                g = ((Boolean) bc.a(null, strB, cls, bool)).booleanValue();
                h = ((Boolean) bc.a(null, b("008CgbdcedgjBef3dcdd"), cls, Boolean.TRUE)).booleanValue();
                i = ((Boolean) bc.a(null, b("007$gbdcedgjhcfkfk"), cls, bool)).booleanValue();
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
    }
}
