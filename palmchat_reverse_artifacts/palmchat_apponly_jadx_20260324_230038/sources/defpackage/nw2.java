package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public class nw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f19630a;
    public static final byte[] b = {113, 116, 68, 115, 108, 106, 101, 114, 66, 73, 123, 109, 100, 88, 84};

    public static boolean a() {
        try {
            return TelephonyManager.class.getMethod("getSimCount", new Class[0]) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            k((TelephonyManager) context.getSystemService("phone"));
            Class cls = Integer.TYPE;
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberIdGemini", cls);
            Method declaredMethod2 = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", cls);
            Method declaredMethod3 = TelephonyManager.class.getDeclaredMethod("getPhoneTypeGemini", cls);
            Field declaredField = TelephonyManager.class.getDeclaredField("mtkGeminiSupport");
            if (declaredMethod != null && declaredMethod2 != null && declaredMethod3 != null && declaredField != null) {
                declaredField.setAccessible(true);
                if (((Boolean) declaredField.get(null)).booleanValue()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @SuppressLint({"PrivateApi", "WrongConstant"})
    public static boolean c(Context context) {
        Class<?> cls;
        Object systemService;
        Class<?> cls2;
        try {
            cls = Class.forName("android.telephony.MSimTelephonyManager");
            systemService = context.getSystemService("phone_msim");
            cls2 = Integer.TYPE;
        } catch (Throwable unused) {
        }
        return (systemService == null || cls.getMethod("getDeviceId", cls2) == null || cls.getMethod("getSubscriberId", cls2) == null) ? false : true;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean d(Context context) {
        String str;
        try {
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            str = (String) cls.getMethod("getServiceName", String.class, Integer.TYPE).invoke(cls, "phone", 1);
        } catch (Throwable unused) {
        }
        return (str == null || ((TelephonyManager) context.getSystemService(str)) == null) ? false : true;
    }

    public static int e(TelephonyManager telephonyManager) {
        try {
            return ((Integer) telephonyManager.getClass().getMethod("getSimCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static ArrayList<mw2> f(Context context) {
        if (rv2.x(context, false, "do not get sim info")) {
            return null;
        }
        int i = f19630a;
        if ((i == 0 || i == 1) && a()) {
            f19630a = 1;
            return g(context);
        }
        int i2 = f19630a;
        if ((i2 == 0 || i2 == 2) && b(context)) {
            f19630a = 2;
            return h(context);
        }
        int i3 = f19630a;
        if ((i3 == 0 || i3 == 3) && c(context)) {
            f19630a = 3;
            return i(context);
        }
        int i4 = f19630a;
        if ((i4 == 0 || i4 == 4) && d(context)) {
            f19630a = 4;
            return j(context);
        }
        f19630a = 1;
        return g(context);
    }

    public static ArrayList<mw2> g(Context context) {
        ArrayList<mw2> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int iE = e(telephonyManager);
            if (iE > 0) {
                try {
                    Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getSimSerialNumber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    for (int i = 0; i < iE; i++) {
                        int iL = l(i);
                        mw2 mw2Var = new mw2();
                        try {
                            mw2Var.f19378a = "";
                            mw2Var.c = (String) declaredMethod.invoke(telephonyManager, Integer.valueOf(iL));
                            mw2Var.b = "";
                        } catch (Throwable unused) {
                        }
                        arrayList.add(mw2Var);
                    }
                } catch (Throwable unused2) {
                    arrayList.clear();
                }
            }
        } catch (Throwable unused3) {
            arrayList.clear();
        }
        return arrayList;
    }

    @SuppressLint({"PrivateApi"})
    public static ArrayList<mw2> h(Context context) {
        ArrayList<mw2> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSimSerialNumberGemini", Integer.TYPE);
            ArrayList<Integer> arrayListK = k(telephonyManager);
            for (int i = 0; i < arrayListK.size(); i++) {
                mw2 mw2Var = new mw2();
                try {
                    int iIntValue = arrayListK.get(i).intValue();
                    mw2Var.b = "";
                    mw2Var.f19378a = "";
                    mw2Var.c = (String) declaredMethod.invoke(telephonyManager, Integer.valueOf(iIntValue));
                } catch (Throwable unused) {
                }
                arrayList.add(mw2Var);
            }
            return arrayList;
        } catch (Throwable unused2) {
            return null;
        }
    }

    @SuppressLint({"PrivateApi", "WrongConstant"})
    public static ArrayList<mw2> i(Context context) {
        ArrayList<mw2> arrayList = new ArrayList<>();
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            context.getSystemService("phone_msim");
            mw2 mw2Var = new mw2();
            try {
                mw2Var.f19378a = "";
                mw2Var.b = "";
            } catch (Throwable unused) {
            }
            arrayList.add(mw2Var);
            mw2 mw2Var2 = new mw2();
            try {
                mw2Var2.f19378a = "";
                mw2Var2.b = "";
            } catch (Throwable unused2) {
            }
            arrayList.add(mw2Var2);
            return arrayList;
        } catch (Throwable unused3) {
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static ArrayList<mw2> j(Context context) {
        ArrayList<mw2> arrayList = new ArrayList<>();
        try {
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService((String) cls.getMethod("getServiceName", String.class, Integer.TYPE).invoke(cls, "phone", 1));
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
            mw2 mw2Var = new mw2();
            try {
                mw2Var.b = "";
                mw2Var.f19378a = "";
                mw2Var.c = telephonyManager2.getSimSerialNumber();
            } catch (Throwable unused) {
            }
            arrayList.add(mw2Var);
            mw2 mw2Var2 = new mw2();
            try {
                mw2Var2.b = "";
                mw2Var2.f19378a = "";
                mw2Var2.c = telephonyManager.getSimSerialNumber();
            } catch (Throwable unused2) {
            }
            arrayList.add(mw2Var2);
            return arrayList;
        } catch (Throwable unused3) {
            return null;
        }
    }

    public static ArrayList<Integer> k(TelephonyManager telephonyManager) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            int i = 0;
            for (Field field : TelephonyManager.class.getDeclaredFields()) {
                field.setAccessible(true);
                if (TextUtils.equals(field.getType().getName(), "com.android.internal.telephony.ITelephonyRegistry") && field.get(telephonyManager) != null) {
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
            }
        } catch (Throwable unused) {
            arrayList.clear();
            arrayList.add(0);
            arrayList.add(1);
        }
        return arrayList;
    }

    public static int l(int i) {
        try {
            Method declaredMethod = Class.forName("android.telephony.SubscriptionManager").getDeclaredMethod("getSubId", Integer.TYPE);
            declaredMethod.setAccessible(true);
            int[] iArr = (int[]) declaredMethod.invoke(null, Integer.valueOf(i));
            return iArr.length > 0 ? iArr[0] : i;
        } catch (Throwable unused) {
            return i;
        }
    }
}
