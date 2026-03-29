package defpackage;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wy3 {
    public static String a(Context context) {
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        String strC = c();
        return !TextUtils.isEmpty(strC) ? strC : b(context);
    }

    public static String b(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return "";
            }
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (iMyPid == runningAppProcessInfo.pid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String c() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static Object e(Object obj, String str, Object... objArr) {
        Class<?> cls = obj.getClass();
        if (objArr.length == 0) {
            try {
                return cls.getMethod(str, new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return null;
            } catch (SecurityException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj2 = objArr[i];
            if (obj2 instanceof Boolean) {
                clsArr[i] = Boolean.TYPE;
            } else if (obj2 instanceof Integer) {
                clsArr[i] = Integer.TYPE;
            } else if (obj2 instanceof Long) {
                clsArr[i] = Long.TYPE;
            } else if (obj2 instanceof Context) {
                clsArr[i] = Context.class;
            } else {
                clsArr[i] = obj2.getClass();
            }
        }
        try {
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return null;
        } catch (IllegalArgumentException e7) {
            e7.printStackTrace();
            return null;
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
            return null;
        } catch (SecurityException e9) {
            e9.printStackTrace();
            return null;
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Object f(String str, String str2, Object... objArr) {
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
            } catch (IllegalAccessException e7) {
                e7.printStackTrace();
            } catch (IllegalArgumentException e8) {
                e8.printStackTrace();
            } catch (NoSuchMethodException e9) {
                e9.printStackTrace();
            } catch (SecurityException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }
}
