package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class au {
    private static final String Code = "ReflectAPI";

    public static boolean B(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            fh.I(Code, "class not found for %s", str);
            return false;
        }
    }

    public static Class Code(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            fh.I(Code, "classNoFound %s", str);
            return null;
        }
    }

    public static boolean I(String str) {
        return B(str) || Z(str);
    }

    public static Object V(String str) {
        StringBuilder sb;
        try {
            return Class.forName(str).newInstance();
        } catch (ClassNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("createInstance ");
            sb.append(e.getClass().getSimpleName());
            fh.I(Code, sb.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("createInstance ");
            sb.append(e.getClass().getSimpleName());
            fh.I(Code, sb.toString());
            return null;
        }
    }

    public static boolean Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (Throwable unused) {
            fh.I(Code, "class not found for %s", str);
        }
        return ClassLoader.getSystemClassLoader().loadClass(str) != null;
    }

    public static Class Code(Field field) {
        int i;
        if (field == null) {
            fh.I(Code, "null field");
            return null;
        }
        if (Map.class.isAssignableFrom(field.getType())) {
            i = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i = 0;
        }
        return Code(field, i);
    }

    public static Field V(Class cls, String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && cls != null) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                str2 = "getDeclaredField NoSuchFieldException";
                fh.I(Code, str2);
                return null;
            } catch (SecurityException unused2) {
                str2 = "getDeclaredField SecurityException";
                fh.I(Code, str2);
                return null;
            }
        }
        return null;
    }

    public static Class Code(Field field, int i) {
        Type[] actualTypeArguments;
        StringBuilder sb;
        Class<?> cls;
        if (field == null) {
            fh.I(Code, "null field");
            return null;
        }
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) == null || actualTypeArguments.length <= i) {
            return null;
        }
        try {
            Type type = actualTypeArguments[i];
            if (type instanceof Class) {
                cls = (Class) type;
            } else {
                String string = type.toString();
                int iIndexOf = string.indexOf("class ");
                if (iIndexOf < 0) {
                    iIndexOf = 0;
                }
                int iIndexOf2 = string.indexOf("<");
                if (iIndexOf2 < 0) {
                    iIndexOf2 = string.length();
                }
                cls = Class.forName(string.substring(iIndexOf, iIndexOf2));
            }
            return cls;
        } catch (ClassNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getType ");
            sb.append(e.getClass().getSimpleName());
            fh.I(Code, sb.toString());
            return null;
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("getType ");
            sb.append(e.getClass().getSimpleName());
            fh.I(Code, sb.toString());
            return null;
        }
    }

    public static Object Code(Class cls, String str) {
        String str2;
        Field fieldV = V(cls, str);
        if (fieldV == null) {
            return null;
        }
        Code(fieldV, true);
        try {
            return fieldV.get(null);
        } catch (IllegalAccessException unused) {
            str2 = "getFieldValue IllegalAccessException";
            fh.I(Code, str2);
            return null;
        } catch (Exception e) {
            str2 = "getFieldValue " + e.getClass().getSimpleName();
            fh.I(Code, str2);
            return null;
        }
    }

    public static Object Code(Object obj, Class cls, String str, Class<?>[] clsArr, Object[] objArr) {
        StringBuilder sb;
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                Method method = cls.getMethod(str, clsArr);
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            } catch (NoSuchMethodException e) {
                e = e;
                sb = new StringBuilder();
                sb.append("invokeMethod ");
                sb.append(e.getClass().getSimpleName());
                fh.I(Code, sb.toString());
                return null;
            } catch (Throwable th) {
                e = th;
                sb = new StringBuilder();
                sb.append("invokeMethod ");
                sb.append(e.getClass().getSimpleName());
                fh.I(Code, sb.toString());
                return null;
            }
        }
        return null;
    }

    public static Field Code(Field field, boolean z) {
        if (field == null) {
            fh.I(Code, "null clazz");
            return null;
        }
        field.setAccessible(z);
        return field;
    }

    public static boolean Code(String str, String str2, Class<?>[] clsArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Class.forName(str).getDeclaredMethod(str2, clsArr);
                return true;
            } catch (ClassNotFoundException unused) {
                fh.I(Code, "class not found for %s", str);
            } catch (NoSuchMethodException unused2) {
                fh.I(Code, "method not found for %s", str2);
            } catch (Throwable th) {
                fh.I(Code, "isMethodAvailable %s", th.getClass().getSimpleName());
            }
        }
        return false;
    }

    public static Field[] Code(Class cls) {
        if (cls == null) {
            fh.I(Code, "null clazz");
            return null;
        }
        if (cls == Object.class) {
            return null;
        }
        Field[] fieldArrCode = cls.getSuperclass() != null ? Code(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (fieldArrCode == null || fieldArrCode.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + fieldArrCode.length];
        System.arraycopy(fieldArrCode, 0, fieldArr, 0, fieldArrCode.length);
        System.arraycopy(declaredFields, 0, fieldArr, fieldArrCode.length, declaredFields.length);
        return fieldArr;
    }
}
