package com.bytedance.pangle.iz;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.iz.iz;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn implements iz.u {
    private static volatile Object nr;
    private static volatile IBinder u;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr extends ResultReceiver {
        private u u;

        public nr(u uVar) {
            super(null);
            this.u = uVar;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
    }

    private static void fx(String str, String str2, String str3) {
        if (nr == null || str == null || str2 == null || str3 == null) {
            return;
        }
        u(nr, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    private static void nr(String str, int i) {
        if (str == null) {
            return;
        }
        String strNr = com.bytedance.pangle.pn.fx.nr(str, i);
        String strPn = com.bytedance.pangle.pn.fx.pn(str, i);
        u(strNr, strPn);
        u(Zeus.getAppApplication().getPackageName(), strPn, com.bytedance.pangle.iz.nr.u());
    }

    private static String[] u(String... strArr) {
        return strArr;
    }

    @Override // com.bytedance.pangle.iz.iz.u
    public boolean u(String str, int i) {
        u();
        nr(str, i);
        boolean zU = u("speed", str, i);
        fx(str, i);
        return zU;
    }

    private static void fx(String str, int i) {
        if (str == null) {
            return;
        }
        nr(com.bytedance.pangle.pn.fx.x(str, i), com.bytedance.pangle.pn.fx.iz(str, i));
        nr(com.bytedance.pangle.pn.fx.pn(str, i));
        nr();
    }

    private static void u() {
        PackageManager packageManager;
        Field fieldU;
        IBinder iBinderAsBinder;
        if (u == null && (fieldU = u((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) != null) {
            Object objU = u(fieldU, packageManager);
            nr = objU;
            if ((objU instanceof IInterface) && (iBinderAsBinder = ((IInterface) nr).asBinder()) != null) {
                u = iBinderAsBinder;
            }
        }
    }

    private static void nr(String str, String str2, String str3) {
        if (nr == null || str == null || str2 == null || str3 == null) {
            return;
        }
        u(nr, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void nr() {
        u(fx(), (u) null);
    }

    private static String[] fx() {
        return u("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static void nr(String str, String str2) {
        try {
            com.bytedance.pangle.util.x.u(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void nr(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private static boolean u(String str, String str2, int i) {
        String strPn = com.bytedance.pangle.pn.fx.pn(str2, i);
        String str3 = com.bytedance.pangle.pn.fx.n(str2, i) + File.separator + com.bytedance.pangle.iz.nr.u(strPn);
        for (int i2 = 1; i2 <= 3; i2++) {
            u(u(str), (u) null);
            if (com.bytedance.pangle.iz.nr.u(str3)) {
                return true;
            }
        }
        return false;
    }

    private static void u(String str, String str2, String str3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 30) {
            nr(str, str2, str3);
        } else if (i == 29) {
            fx(str, str2, str3);
        }
    }

    private static void u(String[] strArr, u uVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeFileDescriptor(FileDescriptor.in);
        parcelObtain.writeFileDescriptor(FileDescriptor.out);
        parcelObtain.writeFileDescriptor(FileDescriptor.err);
        parcelObtain.writeStringArray(strArr);
        parcelObtain.writeStrongBinder(null);
        new nr(uVar).writeToParcel(parcelObtain, 0);
        try {
            u.transact(1598246212, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
    }

    private static String[] u(String str) {
        return u("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static void u(String str, String str2) {
        try {
            com.bytedance.pangle.util.n.u(str, str2);
        } catch (Exception unused) {
        }
    }

    public static Field u(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return u(obj.getClass(), str);
    }

    public static Field u(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object u(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object u(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
