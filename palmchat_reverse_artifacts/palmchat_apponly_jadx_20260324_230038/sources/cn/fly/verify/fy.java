package cn.fly.verify;

import android.content.BroadcastReceiver;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<String> f2378a;
    private static HashMap<String, Class<?>> b;
    private static HashMap<Class<?>, String> c;
    private static LinkedHashMap<String, Method> d;
    private static LinkedHashMap<String, Constructor<?>> e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a<ArgType, RetType> {
        RetType a(ArgType argtype);
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        f2378a = hashSet;
        hashSet.add(ba.a("009Fji2fMffOfVhfWifgIgg"));
        f2378a.add(ba.a("007Tji]f,ff!f^hffkgf"));
        f2378a.add(ba.a("008>ji4fQff fVhf0gNfkgf"));
        f2378a.add("java.net");
        f2378a.add(ba.a("009Uji8fOff fThffi?k-fkUi"));
        HashMap<String, Class<?>> map = new HashMap<>();
        b = map;
        map.put(ba.a("006Rfegffihg4ih"), Double.TYPE);
        b.put(ba.a("005Ggh!iBgf+fk"), Float.TYPE);
        b.put("long", Long.TYPE);
        b.put(ba.a("003WfkBgk"), Integer.TYPE);
        b.put("short", Short.TYPE);
        b.put("byte", Byte.TYPE);
        b.put(ba.a("004ejf[fl"), Character.TYPE);
        b.put("boolean", Boolean.TYPE);
        b.put("Object", Object.class);
        b.put("String", String.class);
        b.put("Thread", Thread.class);
        b.put(ba.a("008PikfiVggf5hg+ih"), Runnable.class);
        b.put(ba.a("006.glfmhjUkhMfh"), System.class);
        b.put(ba.a("0062fegffihg_ih"), Double.class);
        b.put("Float", Float.class);
        b.put("Long", Long.class);
        b.put("Integer", Integer.class);
        b.put(ba.a("005Kgl1j8gfflDk"), Short.class);
        b.put("Byte", Byte.class);
        b.put(ba.a("009!imKjf<fl%fekh<fl"), Character.class);
        b.put("Boolean", Boolean.class);
        c = new HashMap<>();
        for (Map.Entry<String, Class<?>> entry : b.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        d = new LinkedHashMap<String, Method>() { // from class: cn.fly.verify.fy.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Method> entry2) {
                return size() > 10;
            }
        };
        e = new LinkedHashMap<String, Constructor<?>>() { // from class: cn.fly.verify.fy.2
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Constructor<?>> entry2) {
                return size() > 10;
            }
        };
    }

    public static <T> T a(Object obj, String str) throws Throwable {
        try {
            return (T) b(obj, str);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str, th);
        }
    }

    private static synchronized Class<?> b(String str) {
        Class<?> cls;
        cls = b.get(str);
        if (cls == null) {
            Iterator<String> it = f2378a.iterator();
            while (it.hasNext()) {
                try {
                    a(it.next() + "." + str);
                } catch (Throwable unused) {
                }
                cls = b.get(str);
                if (cls != null) {
                    break;
                }
            }
        }
        return cls;
    }

    private static Object c(Object obj, String str) throws Throwable {
        int i;
        int i2;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i2 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i2 = -1;
                }
                if (i2 != -1) {
                    return ((List) obj).get(i2);
                }
            }
        } else {
            if (ba.a("006ihgQgg*kj").equals(str)) {
                return Integer.valueOf(Array.getLength(obj));
            }
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused2) {
                    i = -1;
                }
                if (i != -1) {
                    return Array.get(obj, i);
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static <T> T d(String str, String str2) throws Throwable {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (Class<?> clsB = b(str); clsB != null; clsB = clsB.getSuperclass()) {
            arrayList.add(clsB);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                return (T) declaredField.get(null);
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2);
    }

    public static <T> T a(Object obj, String str, T t) {
        try {
            return (T) a(obj, str);
        } catch (Throwable th) {
            en.a().a(th);
            return t;
        }
    }

    private static <T> T b(Object obj, String str) throws Throwable {
        Field declaredField;
        if ((obj instanceof List) || obj.getClass().isArray()) {
            return (T) c(obj, str);
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                return (T) declaredField.get(obj);
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    public static <T> T c(String str, String str2) throws Throwable {
        try {
            return (T) d(str, str2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2, th);
        }
    }

    private static void d(Object obj, String str, Object obj2) throws Throwable {
        int i;
        int iByteValue;
        double dLongValue;
        int iByteValue2;
        float fLongValue;
        int iByteValue3;
        short sByteValue;
        int i2;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i2 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i2 = -1;
                }
                if (i2 != -1) {
                    ((List) obj).set(i2, obj2);
                    return;
                }
            }
        } else if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable unused2) {
                i = -1;
            }
            if (i != -1) {
                String name = obj.getClass().getName();
                while (name.startsWith("[")) {
                    name = name.substring(1);
                }
                Class<?> cls = obj2.getClass();
                if (!WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(name)) {
                    Object objValueOf = null;
                    if (ExifInterface.LATITUDE_SOUTH.equals(name)) {
                        if (cls == Short.class) {
                            objValueOf = obj2;
                        } else if (cls == Byte.class) {
                            objValueOf = Short.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if ("I".equals(name)) {
                        if (cls == Integer.class) {
                            objValueOf = obj2;
                        } else {
                            if (cls == Short.class) {
                                sByteValue = ((Short) obj2).shortValue();
                            } else if (cls == Byte.class) {
                                sByteValue = ((Byte) obj2).byteValue();
                            }
                            objValueOf = Integer.valueOf(sByteValue);
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if (ContentClassification.AD_CONTENT_CLASSIFICATION_J.equals(name)) {
                        if (cls == Long.class) {
                            objValueOf = obj2;
                        } else {
                            if (cls == Integer.class) {
                                iByteValue3 = ((Integer) obj2).intValue();
                            } else if (cls == Short.class) {
                                iByteValue3 = ((Short) obj2).shortValue();
                            } else if (cls == Byte.class) {
                                iByteValue3 = ((Byte) obj2).byteValue();
                            }
                            objValueOf = Long.valueOf(iByteValue3);
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if ("F".equals(name)) {
                        if (cls == Float.class) {
                            objValueOf = obj2;
                        } else {
                            if (cls == Long.class) {
                                fLongValue = ((Long) obj2).longValue();
                            } else {
                                if (cls == Integer.class) {
                                    iByteValue2 = ((Integer) obj2).intValue();
                                } else if (cls == Short.class) {
                                    iByteValue2 = ((Short) obj2).shortValue();
                                } else if (cls == Byte.class) {
                                    iByteValue2 = ((Byte) obj2).byteValue();
                                }
                                fLongValue = iByteValue2;
                            }
                            objValueOf = Float.valueOf(fLongValue);
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if ("D".equals(name)) {
                        if (cls == Double.class) {
                            objValueOf = obj2;
                        } else {
                            if (cls == Float.class) {
                                dLongValue = ((Float) obj2).floatValue();
                            } else if (cls == Long.class) {
                                dLongValue = ((Long) obj2).longValue();
                            } else {
                                if (cls == Integer.class) {
                                    iByteValue = ((Integer) obj2).intValue();
                                } else if (cls == Short.class) {
                                    iByteValue = ((Short) obj2).shortValue();
                                } else if (cls == Byte.class) {
                                    iByteValue = ((Byte) obj2).byteValue();
                                }
                                dLongValue = iByteValue;
                            }
                            objValueOf = Double.valueOf(dLongValue);
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if ("Z".equals(name)) {
                        if (cls == Boolean.class) {
                            Array.set(obj, i, obj2);
                            return;
                        }
                    } else if (WkAdxAdConfigMg.DSP_NAME_CSJ.equals(name)) {
                        if (cls == Character.class) {
                            Array.set(obj, i, obj2);
                            return;
                        }
                    } else if (name.equals(cls.getName())) {
                        Array.set(obj, i, obj2);
                        return;
                    }
                } else if (cls == Byte.class) {
                    Array.set(obj, i, obj2);
                    return;
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    public static <T> T a(Object obj, String str, T t, Object... objArr) {
        try {
            return (T) a(obj, str, objArr);
        } catch (Throwable th) {
            en.a().a(th);
            return t;
        }
    }

    private static Object b(String str, Object... objArr) throws Throwable {
        boolean z;
        if (str.startsWith("[")) {
            return c(str, objArr);
        }
        Class<?> clsB = b(str);
        String str2 = clsB.getName() + "#" + objArr.length;
        Constructor<?> constructor = e.get(str2);
        Class<?>[] clsArrA = a(objArr);
        if (constructor != null && a(constructor.getParameterTypes(), clsArrA)) {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        }
        Constructor<?>[] declaredConstructors = clsB.getDeclaredConstructors();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Constructor<?> constructor2 : declaredConstructors) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (a(parameterTypes, clsArrA)) {
                e.put(str2, constructor2);
                constructor2.setAccessible(true);
                return constructor2.newInstance(objArr);
            }
            if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && clsArrA.length >= parameterTypes.length - 1) {
                arrayList.add(constructor2);
                arrayList2.add(parameterTypes);
            }
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            Class[] clsArr = (Class[]) arrayList2.get(i);
            Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            if (b((Class<?>[]) clsArr, clsArrA)) {
                Object[] objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = Array.newInstance(componentType, 0);
                Constructor constructor3 = (Constructor) arrayList.get(i);
                constructor3.setAccessible(true);
                return constructor3.newInstance(objArr);
            }
            int length = clsArr.length - 1;
            while (true) {
                if (length >= clsArrA.length) {
                    z = true;
                    break;
                }
                if (!clsArrA[length].equals(componentType)) {
                    z = false;
                    break;
                }
                length++;
            }
            if (z) {
                int length2 = (clsArrA.length - clsArr.length) + 1;
                Object objNewInstance = Array.newInstance(componentType, length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    Array.set(objNewInstance, i2, objArr[(clsArr.length - 1) + i2]);
                }
                Object[] objArr3 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                objArr3[objArr.length] = objNewInstance;
                Constructor constructor4 = (Constructor) arrayList.get(i);
                constructor4.setAccessible(true);
                return constructor4.newInstance(objArr);
            }
        }
        throw new NoSuchMethodException("className: " + str + ", methodName: <init>");
    }

    private static Object c(String str, Object... objArr) throws Throwable {
        int i = 0;
        String strSubstring = str;
        while (strSubstring.startsWith("[")) {
            i++;
            strSubstring = strSubstring.substring(1);
        }
        int[] iArr = null;
        if (i == objArr.length) {
            int[] iArr2 = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    iArr2[i2] = Integer.parseInt(String.valueOf(objArr[i2]));
                } catch (Throwable unused) {
                }
            }
            iArr = iArr2;
        }
        if (iArr != null) {
            Class<?> clsB = WkAdxAdConfigMg.DSP_NAME_BAIDU.equals(strSubstring) ? Byte.TYPE : ExifInterface.LATITUDE_SOUTH.equals(strSubstring) ? Short.TYPE : "I".equals(strSubstring) ? Integer.TYPE : ContentClassification.AD_CONTENT_CLASSIFICATION_J.equals(strSubstring) ? Long.TYPE : "F".equals(strSubstring) ? Float.TYPE : "D".equals(strSubstring) ? Double.TYPE : "Z".equals(strSubstring) ? Boolean.TYPE : WkAdxAdConfigMg.DSP_NAME_CSJ.equals(strSubstring) ? Character.TYPE : b(strSubstring);
            if (clsB != null) {
                return Array.newInstance(clsB, iArr);
            }
        }
        throw new NoSuchMethodException("className: [" + str + ", methodName: <init>");
    }

    public static <T> T a(Object obj, String str, Object... objArr) throws Throwable {
        try {
            return (T) a((String) null, obj, str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", methodName: " + str, th);
        }
    }

    public static synchronized String b(String str, String str2) throws Throwable {
        if (str2.endsWith(".*")) {
            f2378a.add(str2.substring(0, str2.length() - 2));
            return "*";
        }
        Class<?> cls = Class.forName(str2);
        if (str == null) {
            str = cls.getSimpleName();
        }
        if (b.containsKey(str)) {
            c.remove(b.get(str));
        }
        b.put(str, cls);
        c.put(cls, str);
        return str;
    }

    private static void c(Object obj, String str, Object obj2) throws Throwable {
        Field declaredField;
        if ((obj instanceof List) || obj.getClass().isArray()) {
            d(obj, str, obj2);
            return;
        }
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    public static <T> T a(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        return (T) a((String) null, obj, str, objArr, clsArr);
    }

    public static void b(Object obj, String str, Object obj2) throws Throwable {
        try {
            c(obj, str, obj2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2), th);
        }
    }

    public static <T> T a(Object obj, String str, Object[] objArr, Class<?>[] clsArr, T t) {
        try {
            return (T) a(obj, str, objArr, clsArr);
        } catch (Throwable th) {
            en.a().a(th);
            return t;
        }
    }

    private static void b(String str, String str2, Object obj) throws Throwable {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (Class<?> clsB = b(str); clsB != null; clsB = clsB.getSuperclass()) {
            arrayList.add(clsB);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(null, obj);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj));
    }

    private static <T> T a(String str, Object obj, String str2, Object... objArr) throws Throwable {
        Class<?>[] clsArrA;
        Class<?> clsB = obj == null ? b(str) : obj.getClass();
        boolean z = false;
        if (str2.equals(ba.a("009Vgg2hkNjeZhkj'gffe")) && objArr != null && objArr.length == 2) {
            clsArrA = new Class[]{String.class, Class[].class};
            if (objArr[1] == String.class) {
                objArr[1] = new Class[]{String.class};
            }
        } else {
            clsArrA = (str2.equals("getDeviceId") && objArr != null && objArr.length == 1) ? new Class[]{Integer.TYPE} : (str2.equals(ba.a("006,fkVg-ffgffn)h")) && objArr != null && objArr.length == 2) ? new Class[]{Object.class, Object[].class} : (str2.equals(ba.a("0138hj0hkAgn@eeh*hjhjfkhgEih")) && objArr != null && objArr.length == 1) ? new Class[]{Boolean.TYPE} : a(objArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = clsArrA.length;
        for (int i = 0; i < length; i++) {
            Class<?> cls = clsArrA[i];
            stringBuffer.append(cls == null ? "" : cls.getName());
        }
        String str3 = clsB.getName() + "#" + str2 + "#" + objArr.length + stringBuffer.toString();
        Method method = d.get(str3);
        if (method != null) {
            boolean zIsStatic = Modifier.isStatic(method.getModifiers());
            if (obj == null) {
                z = zIsStatic;
            } else if (!zIsStatic) {
                z = true;
            }
            if (z && a(method.getParameterTypes(), clsArrA)) {
                method.setAccessible(true);
                if (method.getReturnType() != Void.TYPE) {
                    return (T) method.invoke(obj, objArr);
                }
                method.invoke(obj, objArr);
                return null;
            }
        }
        while (clsB != null) {
            try {
                Method declaredMethod = clsB.getDeclaredMethod(str2, clsArrA);
                d.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() != Void.TYPE) {
                    return (T) declaredMethod.invoke(obj, objArr);
                }
                declaredMethod.invoke(obj, objArr);
                return null;
            } catch (InvocationTargetException e2) {
                throw e2;
            } catch (Throwable unused) {
                clsB = clsB.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("className: ");
        Object obj2 = str;
        if (obj != null) {
            obj2 = obj.getClass();
        }
        sb.append(obj2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new NoSuchMethodException(sb.toString());
    }

    private static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z;
        if (clsArr.length - clsArr2.length != 1) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= clsArr2.length) {
                z = true;
                break;
            }
            Class<?> cls = clsArr2[i];
            if (cls != null && !a(clsArr[i], cls) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                z = false;
                break;
            }
            i++;
        }
        return z && clsArr[clsArr.length - 1].isArray();
    }

    private static <T> T a(String str, Object obj, String str2, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        Class<?> clsB = obj == null ? b(str) : obj.getClass();
        String str3 = clsB.getName() + "#" + str2 + "#" + objArr.length;
        Method method = d.get(str3);
        if (method != null) {
            method.setAccessible(true);
            if (method.getReturnType() != Void.TYPE) {
                return (T) method.invoke(obj, objArr);
            }
            method.invoke(obj, objArr);
            return null;
        }
        while (clsB != null) {
            try {
                Method declaredMethod = clsB.getDeclaredMethod(str2, clsArr);
                d.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() != Void.TYPE) {
                    return (T) declaredMethod.invoke(obj, objArr);
                }
                declaredMethod.invoke(obj, objArr);
                return null;
            } catch (InvocationTargetException e2) {
                throw e2;
            } catch (Throwable unused) {
                clsB = clsB.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("className: ");
        Object obj2 = str;
        if (obj != null) {
            obj2 = obj.getClass();
        }
        sb.append(obj2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new NoSuchMethodException(sb.toString());
    }

    public static <T> T a(String str, String str2, T t, Object... objArr) {
        try {
            return (T) a(str, str2, objArr);
        } catch (Throwable th) {
            en.a().a(th);
            return t;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) throws Throwable {
        try {
            return (T) a(str, (Object) null, str2, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", methodName: " + str2, th);
        }
    }

    public static <T> T a(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        return (T) a(str, (Object) null, str2, objArr, clsArr);
    }

    public static Object a(String str, Object... objArr) throws Throwable {
        try {
            return b(str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", methodName: <init>", th);
        }
    }

    public static Object a(final Map<String, a<Object[], Object>> map, Class<?>... clsArr) throws Throwable {
        if (clsArr.length == 0) {
            return null;
        }
        return Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, new InvocationHandler() { // from class: cn.fly.verify.fy.3
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                a aVar = (a) map.get(method.getName());
                if (aVar != null) {
                    return aVar.a(objArr);
                }
                return null;
            }
        });
    }

    public static String a(Class<?> cls) throws Throwable {
        String simpleName = c.get(cls);
        if (simpleName == null) {
            simpleName = cls.getSimpleName();
            if (b.containsKey(simpleName)) {
                c.remove(b.get(simpleName));
            }
            b.put(simpleName, cls);
            c.put(cls, simpleName);
        }
        return simpleName;
    }

    public static String a(String str) throws Throwable {
        return b((String) null, str);
    }

    public static String a(String str, String str2) {
        try {
            return a(str);
        } catch (Throwable th) {
            en.a().a(th);
            return str2;
        }
    }

    public static void a(String str, String str2, Object obj) throws Throwable {
        try {
            b(str, str2, obj);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj), th);
        }
    }

    private static boolean a(Class<?> cls, Class<?> cls2) {
        return (cls == Byte.TYPE && cls2 == Byte.class) || (cls == Short.TYPE && (cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Character.TYPE && (cls2 == Character.class || cls2 == Short.class || cls2 == Byte.class)) || ((cls == Integer.TYPE && (cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Long.TYPE && (cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Float.TYPE && (cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Double.TYPE && (cls2 == Double.class || cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || (cls == Boolean.TYPE && cls2 == Boolean.class))))));
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            Class<?> cls = clsArr2[i];
            if (cls != null && !a(clsArr[i], cls) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static Class<?>[] a(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof BroadcastReceiver) {
                clsArr[i] = BroadcastReceiver.class;
            } else {
                clsArr[i] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }
}
