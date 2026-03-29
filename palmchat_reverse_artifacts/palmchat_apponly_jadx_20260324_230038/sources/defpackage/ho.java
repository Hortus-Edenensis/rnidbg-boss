package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ho {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, Bundle> f18002a = new HashMap();

    public static Bundle a(Context context) {
        return b(context, context.getPackageName());
    }

    public static Bundle b(Context context, String str) {
        Map<String, Bundle> map = f18002a;
        if (map != null && map.containsKey(str)) {
            return f18002a.get(str);
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            Map<String, Bundle> map2 = f18002a;
            if (map2 != null) {
                map2.put(str, applicationInfo.metaData);
            }
            return applicationInfo.metaData;
        } catch (Exception e) {
            v.c(e);
            return null;
        }
    }

    public static Object c(String str, String str2, Object... objArr) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        if (objArr.length == 0) {
            try {
                return cls.getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (SecurityException e5) {
                e5.printStackTrace();
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        } else {
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Boolean) {
                    clsArr[i] = Boolean.TYPE;
                } else if (obj instanceof Integer) {
                    clsArr[i] = Integer.TYPE;
                } else if (obj instanceof Long) {
                    clsArr[i] = Long.TYPE;
                } else if (obj instanceof Context) {
                    clsArr[i] = Context.class;
                } else {
                    clsArr[i] = obj.getClass();
                }
            }
            try {
                return cls.getMethod(str2, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
            } catch (IllegalArgumentException e9) {
                e9.printStackTrace();
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            } catch (SecurityException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
        }
        return null;
    }
}
