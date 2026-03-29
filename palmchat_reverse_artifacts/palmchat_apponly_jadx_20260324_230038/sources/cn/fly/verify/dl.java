package cn.fly.verify;

import cn.fly.verify.dk;
import cn.fly.verify.dm;
import cn.fly.verify.dn;
import com.baidu.mapapi.http.HttpClient;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2183a;
    public String b;
    public int c;
    public String d;
    public String e;
    public String f;
    public int g;
    public String h;
    public int i;
    public int j;
    public int k;
    public String l;
    public Object[] m;
    public String n;
    public String[] o;
    public String p;
    public Object q;
    public int r;
    public int s;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2184a;
        public df b;
        public List<Object> c;
        public boolean d;
        public boolean e;
        public ArrayList<dl> f;
        public ArrayList<Object> g;

        public Class<?> a(String str) {
            return this.b.b(str);
        }

        public Object b(String str) {
            return this.b.a(str);
        }

        public Object a() {
            return this.b.a();
        }

        public void b(String str, Object obj) {
            this.b.a(str, obj);
        }

        public void a(Object obj) {
            this.b.a(obj);
        }

        public void a(String str, Class<?> cls) {
            this.b.a(str, cls);
        }

        public void a(String str, Object obj) {
            this.b.b(str, obj);
        }
    }

    public dl() {
    }

    public dl(int i) {
        this.f2183a = i;
    }

    private Object a(Object obj, Class<?> cls) throws Throwable {
        if (obj instanceof ByteArrayOutputStream) {
            return a(((ByteArrayOutputStream) obj).toByteArray(), cls);
        }
        if (obj instanceof byte[]) {
            return a(new String((byte[]) obj, "utf-8"), cls);
        }
        if ((obj instanceof StringBuffer) || (obj instanceof StringBuilder)) {
            return a(obj.toString(), cls);
        }
        if (obj instanceof String) {
            return cls.getConstructor(String.class).newInstance(obj);
        }
        if (obj.getClass().equals(cls)) {
            return obj;
        }
        throw new ClassCastException("Failed to cast " + obj + " to be " + cls.getName() + " at line: " + this.b + "(" + this.c + ")");
    }

    public void b(Class<?> cls, df dfVar) throws Throwable {
        Field declaredField;
        Object objA = dfVar.a();
        while (cls != null) {
            try {
                declaredField = cls.getDeclaredField(this.l);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(null, objA);
                return;
            }
            cls = cls.getSuperclass();
        }
        dl dlVar = new dl(14);
        dlVar.b = this.b;
        dlVar.c = this.c;
        dlVar.n = this.n;
        dlVar.p = "set" + Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        dlVar.i = 1;
        dlVar.a(cls, new Object[]{objA}, dfVar);
    }

    private Object a(Object obj, Object obj2, Class<?> cls, Class<?> cls2) throws Throwable {
        if (obj == null || obj2.equals(obj)) {
            return null;
        }
        if (obj.getClass().equals(cls)) {
            HashMap map = new HashMap();
            a((Map) map, obj, cls, cls2);
            return map;
        }
        if (!obj.getClass().equals(cls2)) {
            return obj;
        }
        Field declaredField = cls2.getDeclaredField("values");
        declaredField.setAccessible(true);
        List list = (List) declaredField.get(obj);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next(), obj2, cls, cls2));
        }
        return arrayList;
    }

    public void b(Object obj, df dfVar) throws Throwable {
        Field declaredField;
        Object objA = dfVar.a();
        if (obj instanceof Map) {
            ((Map) obj).put(this.l, objA);
            return;
        }
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredField = superclass.getDeclaredField(this.l);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(obj, objA);
                return;
            }
        }
        dl dlVar = new dl(12);
        dlVar.b = this.b;
        dlVar.c = this.c;
        dlVar.p = "set" + Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        dlVar.i = 1;
        dlVar.a(obj, new Object[]{objA}, dfVar);
    }

    private String a(InputStream inputStream) throws Throwable {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        MessageDigest messageDigest = MessageDigest.getInstance(ed.a("003Khcfkhi"));
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return a(messageDigest.digest());
            }
            messageDigest.update(bArr, 0, i);
        }
    }

    private String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(dk.a aVar) throws Throwable {
        int i = 0;
        switch (this.f2183a) {
            case 1:
                this.h = (String) aVar.b();
                aVar.a();
                break;
            case 2:
                this.q = aVar.b();
                break;
            case 3:
            case 9:
            case 19:
                this.h = (String) aVar.b();
                break;
            case 4:
            case 5:
                this.k = ((Integer) aVar.b()).intValue();
                break;
            case 6:
                this.s = ((Integer) aVar.b()).intValue();
                break;
            case 7:
                this.r = ((Integer) aVar.b()).intValue();
                break;
            case 10:
            case 35:
                this.d = (String) aVar.b();
                this.e = (String) aVar.b();
                break;
            case 11:
            case 24:
                this.l = (String) aVar.b();
                break;
            case 12:
                this.p = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 13:
            case 26:
                this.n = (String) aVar.b();
                this.l = (String) aVar.b();
                break;
            case 14:
                this.n = (String) aVar.b();
                this.p = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 16:
            case 32:
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 17:
            case 27:
                this.n = (String) aVar.b();
                break;
            case 18:
                this.n = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 20:
                this.f = (String) aVar.b();
                break;
            case 21:
            case 22:
                this.f = (String) aVar.b();
                int iIntValue = ((Integer) aVar.b()).intValue();
                this.g = iIntValue;
                this.g = iIntValue + aVar.c();
                break;
            case 29:
                this.h = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                int iIntValue2 = ((Integer) aVar.b()).intValue();
                this.j = iIntValue2;
                this.j = iIntValue2 + aVar.c();
                break;
            case 31:
                this.h = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 36:
                int iIntValue3 = ((Integer) aVar.b()).intValue();
                this.o = new String[iIntValue3];
                while (i < iIntValue3) {
                    this.o[i] = (String) aVar.b();
                    aVar.a();
                    i++;
                }
                break;
            case 37:
                int iIntValue4 = ((Integer) aVar.b()).intValue();
                this.m = new Object[iIntValue4];
                while (i < iIntValue4) {
                    this.m[i] = aVar.b();
                    i++;
                }
                break;
            case 38:
                int iIntValue5 = ((Integer) aVar.b()).intValue();
                this.o = new String[iIntValue5];
                while (i < iIntValue5) {
                    this.o[i] = (String) aVar.b();
                    i++;
                }
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:427:0x093a  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0953  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0966 A[LOOP:13: B:435:0x095f->B:437:0x0966, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0c6c  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0c9a  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x0c9d  */
    /* JADX WARN: Removed duplicated region for block: B:647:0x096a A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [cn.fly.verify.dl$a] */
    /* JADX WARN: Type inference failed for: r2v103, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v106, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v122 */
    /* JADX WARN: Type inference failed for: r2v174, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r2v176, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r2v177, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v179, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v200, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v208, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v209, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v210 */
    /* JADX WARN: Type inference failed for: r2v216, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v217, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v219, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v221, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v222, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v224, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v258, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v269, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v271, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v289 */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v290 */
    /* JADX WARN: Type inference failed for: r2v291 */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v42, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v46, types: [java.lang.Short] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v63, types: [java.lang.Character] */
    /* JADX WARN: Type inference failed for: r2v71, types: [java.lang.Byte] */
    /* JADX WARN: Type inference failed for: r2v72, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v85, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v86, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v89, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r2v90, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r2v91, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Class] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(a aVar) throws Throwable {
        ?? B;
        boolean zEquals;
        boolean zEquals2;
        float fFloatValue;
        int iIntValue;
        int iFloatValue;
        char cLongValue;
        Object bigDecimal;
        InputStream byteArrayInputStream;
        boolean z;
        OutputStream fileOutputStream;
        byte[] bArr;
        int i;
        double dDoubleValue;
        long jLongValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        int iIntValue6;
        int iIntValue7;
        int iIntValue8;
        int iIntValue9;
        int iIntValue10;
        int iIntValue11;
        Object bigInteger;
        int length;
        int iIntValue12;
        String str;
        Class<?> cls;
        Object objB;
        LinkedList<Object> linkedListB;
        df dfVarB;
        int i2 = 0;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        boolean z2 = false;
        int i3 = 0;
        try {
            switch (this.f2183a) {
                case 1:
                    aVar.b(this.h, aVar.a());
                    return;
                case 2:
                    B = this.q;
                    aVar.a(B);
                    return;
                case 3:
                    B = aVar.b(this.h);
                    aVar.a(B);
                    return;
                case 4:
                    B = aVar.a();
                    Object objA = aVar.a();
                    switch (this.k) {
                        case 12:
                            if (B == 0) {
                                B = objA == null ? Boolean.TRUE : Boolean.FALSE;
                                aVar.a(B);
                                return;
                            } else if (!(B instanceof Number) || !(objA instanceof Number)) {
                                zEquals = B.equals(objA);
                                B = Boolean.valueOf(zEquals);
                                aVar.a(B);
                                return;
                            } else {
                                if (((Number) B).doubleValue() == ((Number) objA).doubleValue()) {
                                    z2 = true;
                                }
                                B = Boolean.valueOf(z2);
                                aVar.a(B);
                                return;
                            }
                        case 13:
                            if (B == 0) {
                                if (objA == null) {
                                }
                                aVar.a(B);
                                return;
                            } else if ((B instanceof Number) && (objA instanceof Number)) {
                                if (((Number) B).doubleValue() != ((Number) objA).doubleValue()) {
                                }
                                B = Boolean.valueOf(z2);
                                aVar.a(B);
                                return;
                            } else {
                                zEquals2 = B.equals(objA);
                                zEquals = !zEquals2;
                                B = Boolean.valueOf(zEquals);
                                aVar.a(B);
                                return;
                            }
                        case 14:
                            if (!(B instanceof Number) || !(objA instanceof Number) ? ((Comparable) B).compareTo(objA) < 0 : ((Number) B).doubleValue() < ((Number) objA).doubleValue()) {
                            }
                            B = Boolean.valueOf(z2);
                            aVar.a(B);
                            return;
                        case 15:
                            if (!(B instanceof Number) || !(objA instanceof Number) ? ((Comparable) B).compareTo(objA) > 0 : ((Number) B).doubleValue() > ((Number) objA).doubleValue()) {
                            }
                            B = Boolean.valueOf(z2);
                            aVar.a(B);
                            return;
                        case 16:
                            if (!(B instanceof Number) || !(objA instanceof Number) ? ((Comparable) B).compareTo(objA) <= 0 : ((Number) B).doubleValue() <= ((Number) objA).doubleValue()) {
                            }
                            B = Boolean.valueOf(z2);
                            aVar.a(B);
                            return;
                        case 17:
                            if (!(B instanceof Number) || !(objA instanceof Number) ? ((Comparable) B).compareTo(objA) >= 0 : ((Number) B).doubleValue() >= ((Number) objA).doubleValue()) {
                            }
                            B = Boolean.valueOf(z2);
                            aVar.a(B);
                            return;
                        case 18:
                            if (String.class.equals(objA)) {
                                B = B == 0 ? 0 : String.valueOf((Object) B);
                            } else if (Number.class.equals(objA)) {
                                String strValueOf = String.valueOf((Object) B);
                                if (!strValueOf.contains(".")) {
                                    try {
                                        try {
                                            B = Integer.valueOf(Integer.parseInt(strValueOf));
                                        } catch (Throwable unused) {
                                            bigInteger = new BigInteger(strValueOf);
                                            B = bigInteger;
                                        }
                                    } catch (Throwable unused2) {
                                        B = Long.valueOf(Long.parseLong(strValueOf));
                                    }
                                } else {
                                    try {
                                        try {
                                            B = Float.valueOf(Float.parseFloat(strValueOf));
                                        } catch (Throwable unused3) {
                                            B = Double.valueOf(Double.parseDouble(strValueOf));
                                        }
                                    } catch (Throwable unused4) {
                                        bigInteger = new BigDecimal(strValueOf);
                                        B = bigInteger;
                                    }
                                }
                                break;
                            } else if (Double.class.equals(objA) || Double.TYPE.equals(objA)) {
                                B = Double.valueOf(String.valueOf((Object) B));
                            } else if (Float.class.equals(objA) || Float.TYPE.equals(objA)) {
                                fFloatValue = Double.valueOf(String.valueOf((Object) B)).floatValue();
                                B = Float.valueOf(fFloatValue);
                            } else if (Integer.class.equals(objA) || Integer.TYPE.equals(objA)) {
                                iIntValue = Double.valueOf(String.valueOf((Object) B)).intValue();
                                B = Integer.valueOf(iIntValue);
                            } else if (Long.class.equals(objA) || Long.TYPE.equals(objA)) {
                                B = Long.valueOf(Double.valueOf(String.valueOf((Object) B)).longValue());
                            } else if (Short.class.equals(objA) || Short.TYPE.equals(objA)) {
                                B = Short.valueOf(Double.valueOf(String.valueOf((Object) B)).shortValue());
                            } else if (Character.class.equals(objA) || Character.TYPE.equals(objA)) {
                                if (B instanceof Integer) {
                                    iFloatValue = ((Integer) B).intValue();
                                } else if (B instanceof Long) {
                                    cLongValue = (char) ((Long) B).longValue();
                                    B = Character.valueOf(cLongValue);
                                } else if (B instanceof Short) {
                                    iFloatValue = ((Short) B).shortValue();
                                } else if (B instanceof Byte) {
                                    iFloatValue = ((Byte) B).byteValue();
                                } else if (B instanceof Double) {
                                    iFloatValue = (int) ((Double) B).doubleValue();
                                } else {
                                    if (!(B instanceof Float)) {
                                        throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                                    }
                                    iFloatValue = (int) ((Float) B).floatValue();
                                }
                                cLongValue = (char) iFloatValue;
                                B = Character.valueOf(cLongValue);
                            } else if (Byte.class.equals(objA) || Byte.TYPE.equals(objA)) {
                                B = Byte.valueOf(Double.valueOf(String.valueOf((Object) B)).byteValue());
                            } else {
                                if (!Boolean.class.equals(objA)) {
                                    if (BigInteger.class.equals(objA)) {
                                        bigDecimal = new BigInteger(String.valueOf((Object) B));
                                    } else if (BigDecimal.class.equals(objA)) {
                                        bigDecimal = new BigDecimal(String.valueOf((Object) B));
                                    } else {
                                        B = ((Class) objA).cast(B);
                                    }
                                    aVar.a(bigDecimal);
                                    return;
                                }
                                if (B != 0) {
                                    if (B instanceof Number) {
                                        if (Double.valueOf(B.toString()).doubleValue() == 0.0d) {
                                        }
                                        B = Boolean.valueOf(z2);
                                    } else if (B instanceof String) {
                                        zEquals = ((String) B).trim().toLowerCase().equals(ed.a("004iJdjdg4f"));
                                        B = Boolean.valueOf(zEquals);
                                    } else if (!(B instanceof Boolean)) {
                                    }
                                }
                            }
                            aVar.a(B);
                            return;
                        case 19:
                            zEquals = ((Class) objA).isInstance(B);
                            B = Boolean.valueOf(zEquals);
                            aVar.a(B);
                            return;
                        case 20:
                            if (B instanceof Collection) {
                                Collection collection = (Collection) B;
                                if (objA instanceof Collection) {
                                    collection.addAll((Collection) objA);
                                    return;
                                } else {
                                    collection.add(objA);
                                    return;
                                }
                            }
                            if ((B instanceof Map) && (objA instanceof Map)) {
                                ((Map) B).putAll((Map) objA);
                                return;
                            }
                            if (objA instanceof String) {
                                byteArrayInputStream = new ByteArrayInputStream(((String) objA).getBytes("utf-8"));
                            } else if (objA instanceof byte[]) {
                                byteArrayInputStream = new ByteArrayInputStream((byte[]) objA);
                            } else if (objA instanceof File) {
                                byteArrayInputStream = new FileInputStream((File) objA);
                            } else if (objA instanceof InputStream) {
                                byteArrayInputStream = (InputStream) objA;
                                z = false;
                                if (!(B instanceof File)) {
                                    File file = (File) B;
                                    if (!file.getParentFile().exists()) {
                                        file.getParentFile().mkdirs();
                                    }
                                    fileOutputStream = new FileOutputStream(file, true);
                                } else {
                                    if (!(B instanceof OutputStream)) {
                                        throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                                    }
                                    fileOutputStream = (OutputStream) B;
                                    z = false;
                                }
                                bArr = new byte[1024];
                                while (true) {
                                    i = byteArrayInputStream.read(bArr);
                                    if (i != -1) {
                                        fileOutputStream.flush();
                                        if (z) {
                                            byteArrayInputStream.close();
                                        }
                                        fileOutputStream.close();
                                        return;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                            } else {
                                if (!(objA instanceof Serializable)) {
                                    throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                                }
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                                objectOutputStream.writeObject(objA);
                                objectOutputStream.flush();
                                objectOutputStream.close();
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            }
                            z = true;
                            if (!(B instanceof File)) {
                            }
                            bArr = new byte[1024];
                            while (true) {
                                i = byteArrayInputStream.read(bArr);
                                if (i != -1) {
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            break;
                        case 21:
                            ?? r2 = B;
                            if (B == 0) {
                                r2 = com.igexin.push.core.b.m;
                            }
                            if (objA == null) {
                                objA = com.igexin.push.core.b.m;
                            }
                            if (!(r2 instanceof Number) || !(objA instanceof Number)) {
                                B = String.valueOf((Object) r2) + String.valueOf(objA);
                                aVar.a(B);
                                return;
                            }
                            if ((r2 instanceof Double) || (objA instanceof Double)) {
                                dDoubleValue = ((Number) r2).doubleValue() + ((Number) objA).doubleValue();
                                B = Double.valueOf(dDoubleValue);
                                aVar.a(B);
                                return;
                            }
                            if ((r2 instanceof Float) || (objA instanceof Float)) {
                                fFloatValue = ((Number) r2).floatValue() + ((Number) objA).floatValue();
                                B = Float.valueOf(fFloatValue);
                                aVar.a(B);
                                return;
                            }
                            if ((r2 instanceof Long) || (objA instanceof Long)) {
                                jLongValue = ((Number) r2).longValue() + ((Number) objA).longValue();
                                B = Long.valueOf(jLongValue);
                                aVar.a(B);
                                return;
                            }
                            if ((r2 instanceof Integer) || (objA instanceof Integer)) {
                                iIntValue2 = ((Number) r2).intValue();
                                iIntValue3 = ((Number) objA).intValue();
                            } else if ((r2 instanceof Short) || (objA instanceof Short)) {
                                iIntValue2 = ((Number) r2).shortValue();
                                iIntValue3 = ((Number) objA).shortValue();
                            } else {
                                iIntValue2 = ((Number) r2).byteValue();
                                iIntValue3 = ((Number) objA).byteValue();
                            }
                            iIntValue = iIntValue2 + iIntValue3;
                            B = Integer.valueOf(iIntValue);
                            aVar.a(B);
                            return;
                        case 22:
                            if (!(B instanceof Number) || !(objA instanceof Number)) {
                                throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                            }
                            if ((B instanceof Double) || (objA instanceof Double)) {
                                dDoubleValue = ((Number) B).doubleValue() - ((Number) objA).doubleValue();
                                B = Double.valueOf(dDoubleValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Float) || (objA instanceof Float)) {
                                fFloatValue = ((Number) B).floatValue() - ((Number) objA).floatValue();
                                B = Float.valueOf(fFloatValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Long) || (objA instanceof Long)) {
                                jLongValue = ((Number) B).longValue() - ((Number) objA).longValue();
                                B = Long.valueOf(jLongValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Integer) || (objA instanceof Integer)) {
                                iIntValue4 = ((Number) B).intValue();
                                iIntValue5 = ((Number) objA).intValue();
                            } else if ((B instanceof Short) || (objA instanceof Short)) {
                                iIntValue4 = ((Number) B).shortValue();
                                iIntValue5 = ((Number) objA).shortValue();
                            } else {
                                iIntValue4 = ((Number) B).byteValue();
                                iIntValue5 = ((Number) objA).byteValue();
                            }
                            iIntValue = iIntValue4 - iIntValue5;
                            B = Integer.valueOf(iIntValue);
                            aVar.a(B);
                            return;
                        case 23:
                            if (!(B instanceof Number) || !(objA instanceof Number)) {
                                throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                            }
                            if ((B instanceof Double) || (objA instanceof Double)) {
                                dDoubleValue = ((Number) B).doubleValue() * ((Number) objA).doubleValue();
                                B = Double.valueOf(dDoubleValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Float) || (objA instanceof Float)) {
                                fFloatValue = ((Number) B).floatValue() * ((Number) objA).floatValue();
                                B = Float.valueOf(fFloatValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Long) || (objA instanceof Long)) {
                                jLongValue = ((Number) B).longValue() * ((Number) objA).longValue();
                                B = Long.valueOf(jLongValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Integer) || (objA instanceof Integer)) {
                                iIntValue6 = ((Number) B).intValue();
                                iIntValue7 = ((Number) objA).intValue();
                            } else if ((B instanceof Short) || (objA instanceof Short)) {
                                iIntValue6 = ((Number) B).shortValue();
                                iIntValue7 = ((Number) objA).shortValue();
                            } else {
                                iIntValue6 = ((Number) B).byteValue();
                                iIntValue7 = ((Number) objA).byteValue();
                            }
                            iIntValue = iIntValue6 * iIntValue7;
                            B = Integer.valueOf(iIntValue);
                            aVar.a(B);
                            return;
                        case 24:
                            if (!(B instanceof Number) || !(objA instanceof Number)) {
                                throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                            }
                            if ((B instanceof Double) || (objA instanceof Double)) {
                                dDoubleValue = ((Number) B).doubleValue() / ((Number) objA).doubleValue();
                                B = Double.valueOf(dDoubleValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Float) || (objA instanceof Float)) {
                                fFloatValue = ((Number) B).floatValue() / ((Number) objA).floatValue();
                                B = Float.valueOf(fFloatValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Long) || (objA instanceof Long)) {
                                jLongValue = ((Number) B).longValue() / ((Number) objA).longValue();
                                B = Long.valueOf(jLongValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Integer) || (objA instanceof Integer)) {
                                iIntValue8 = ((Number) B).intValue();
                                iIntValue9 = ((Number) objA).intValue();
                            } else if ((B instanceof Short) || (objA instanceof Short)) {
                                iIntValue8 = ((Number) B).shortValue();
                                iIntValue9 = ((Number) objA).shortValue();
                            } else {
                                iIntValue8 = ((Number) B).byteValue();
                                iIntValue9 = ((Number) objA).byteValue();
                            }
                            iIntValue = iIntValue8 / iIntValue9;
                            B = Integer.valueOf(iIntValue);
                            aVar.a(B);
                            return;
                        case 25:
                            if (!(B instanceof Number) || !(objA instanceof Number)) {
                                throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                            }
                            if ((B instanceof Double) || (objA instanceof Double)) {
                                dDoubleValue = ((Number) B).doubleValue() % ((Number) objA).doubleValue();
                                B = Double.valueOf(dDoubleValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Float) || (objA instanceof Float)) {
                                fFloatValue = ((Number) B).floatValue() % ((Number) objA).floatValue();
                                B = Float.valueOf(fFloatValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Long) || (objA instanceof Long)) {
                                jLongValue = ((Number) B).longValue() % ((Number) objA).longValue();
                                B = Long.valueOf(jLongValue);
                                aVar.a(B);
                                return;
                            }
                            if ((B instanceof Integer) || (objA instanceof Integer)) {
                                iIntValue10 = ((Number) B).intValue();
                                iIntValue11 = ((Number) objA).intValue();
                            } else if ((B instanceof Short) || (objA instanceof Short)) {
                                iIntValue10 = ((Number) B).shortValue();
                                iIntValue11 = ((Number) objA).shortValue();
                            } else {
                                iIntValue10 = ((Number) B).byteValue();
                                iIntValue11 = ((Number) objA).byteValue();
                            }
                            iIntValue = iIntValue10 % iIntValue11;
                            B = Integer.valueOf(iIntValue);
                            aVar.a(B);
                            return;
                        default:
                            throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                    }
                    break;
                case 5:
                    Object objA2 = aVar.a();
                    if (this.k == 26) {
                        zEquals2 = ((Boolean) objA2).booleanValue();
                        zEquals = !zEquals2;
                        B = Boolean.valueOf(zEquals);
                        aVar.a(B);
                        return;
                    }
                    throw new RuntimeException("Bad operator at line: " + this.b + "(" + this.c + ")");
                case 6:
                    B = new ArrayList();
                    if (this.s == 1) {
                        Object objA3 = aVar.a();
                        if (objA3 == null || !objA3.getClass().isArray()) {
                            B.add(objA3);
                        } else {
                            int length2 = Array.getLength(objA3);
                            for (int i4 = 0; i4 < length2; i4++) {
                                B.add(Array.get(objA3, i4));
                            }
                        }
                    } else {
                        for (int i5 = 0; i5 < this.s; i5++) {
                            B.add(aVar.a());
                        }
                    }
                    aVar.a(B);
                    return;
                case 7:
                    B = new HashMap();
                    for (int i6 = 0; i6 < this.r; i6++) {
                        B.put(aVar.a(), aVar.a());
                    }
                    aVar.a(B);
                    return;
                case 8:
                    Object objA4 = aVar.a();
                    Object objA5 = aVar.a();
                    if (objA4 instanceof List) {
                        List list = (List) objA4;
                        if (objA5 instanceof dn) {
                            Number[] numberArrB = ((dn) objA5).b();
                            int iIntValue13 = numberArrB[0].intValue();
                            if (iIntValue13 < 0) {
                                iIntValue13 += list.size();
                            }
                            int iIntValue14 = numberArrB[1].intValue();
                            if (iIntValue14 < 0) {
                                iIntValue14 += list.size();
                            }
                            B = list.subList(iIntValue13, iIntValue14);
                        } else {
                            int iIntValue15 = ((Integer) objA5).intValue();
                            if (iIntValue15 < 0) {
                                iIntValue15 += list.size();
                            }
                            B = list.get(iIntValue15);
                        }
                    } else if (objA4 instanceof Map) {
                        B = ((Map) objA4).get(objA5);
                    } else if (!objA4.getClass().isArray()) {
                        if (!(objA4 instanceof String)) {
                            throw new IllegalArgumentException(objA4.getClass().getName() + " is not entry");
                        }
                        String str2 = (String) objA4;
                        if (objA5 instanceof dn) {
                            Number[] numberArrB2 = ((dn) objA5).b();
                            iIntValue12 = numberArrB2[0].intValue();
                            length = numberArrB2[1].intValue();
                        } else {
                            length = str2.length();
                            iIntValue12 = ((Integer) objA5).intValue();
                        }
                        if (iIntValue12 < 0) {
                            iIntValue12 += str2.length();
                        }
                        if (length < 0) {
                            length += str2.length();
                        }
                        B = str2.substring(iIntValue12, length);
                    } else if (objA5 instanceof dn) {
                        int length3 = Array.getLength(objA4);
                        Number[] numberArrB3 = ((dn) objA5).b();
                        int iIntValue16 = numberArrB3[0].intValue();
                        if (iIntValue16 < 0) {
                            iIntValue16 += length3;
                        }
                        int iIntValue17 = numberArrB3[1].intValue();
                        if (iIntValue17 < 0) {
                            iIntValue17 += length3;
                        }
                        int i7 = iIntValue17 - iIntValue16;
                        Object objNewInstance = Array.newInstance(objA4.getClass().getComponentType(), i7);
                        System.arraycopy(objA4, iIntValue16, objNewInstance, 0, i7);
                        bigInteger = objNewInstance;
                        B = bigInteger;
                    } else {
                        int iIntValue18 = ((Integer) objA5).intValue();
                        if (iIntValue18 < 0) {
                            iIntValue18 += Array.getLength(objA4);
                        }
                        B = Array.get(objA4, iIntValue18);
                    }
                    aVar.a(B);
                    return;
                case 9:
                    B = aVar.a(this.h);
                    aVar.a(B);
                    return;
                case 10:
                    str = this.e;
                    cls = Class.forName(this.d);
                    aVar.a(str, cls);
                    return;
                case 11:
                    a(aVar.a(), aVar.b);
                    return;
                case 12:
                    Object objA6 = aVar.a();
                    Object[] objArr = new Object[this.i];
                    for (int i8 = 0; i8 < this.i; i8++) {
                        objArr[i8] = aVar.a();
                    }
                    a(objA6, objArr, aVar.b);
                    return;
                case 13:
                    a(aVar.a(this.n), aVar.b);
                    return;
                case 14:
                    Class<?> clsA = aVar.a(this.n);
                    Object[] objArr2 = new Object[this.i];
                    for (int i9 = 0; i9 < this.i; i9++) {
                        objArr2[i9] = aVar.a();
                    }
                    a(clsA, objArr2, aVar.b);
                    return;
                case 15:
                    Object objA7 = aVar.a();
                    dl dlVar = new dl(11);
                    dlVar.b = this.b;
                    dlVar.c = this.c;
                    dlVar.l = (String) aVar.a();
                    dlVar.a(objA7, aVar.b);
                    return;
                case 16:
                    Object objA8 = aVar.a();
                    dl dlVar2 = new dl(12);
                    dlVar2.b = this.b;
                    dlVar2.c = this.c;
                    dlVar2.p = (String) aVar.a();
                    dlVar2.i = this.i;
                    Object[] objArr3 = new Object[this.i];
                    for (int i10 = 0; i10 < this.i; i10++) {
                        objArr3[i10] = aVar.a();
                    }
                    dlVar2.a(objA8, objArr3, aVar.b);
                    return;
                case 17:
                    Class<?> clsA2 = aVar.a(this.n);
                    dl dlVar3 = new dl(13);
                    dlVar3.b = this.b;
                    dlVar3.c = this.c;
                    dlVar3.l = (String) aVar.a();
                    dlVar3.a(clsA2, aVar.b);
                    return;
                case 18:
                    Class<?> clsA3 = aVar.a(this.n);
                    dl dlVar4 = new dl(14);
                    dlVar4.b = this.b;
                    dlVar4.c = this.c;
                    dlVar4.n = this.n;
                    dlVar4.p = (String) aVar.a();
                    dlVar4.i = this.i;
                    Object[] objArr4 = new Object[this.i];
                    for (int i11 = 0; i11 < this.i; i11++) {
                        objArr4[i11] = aVar.a();
                    }
                    dlVar4.a(clsA3, objArr4, aVar.b);
                    return;
                case 19:
                    aVar.a(this.h, aVar.a());
                    return;
                case 20:
                default:
                    return;
                case 21:
                    if (((Boolean) aVar.a()).booleanValue()) {
                        return;
                    }
                    aVar.f2184a = this.g;
                    return;
                case 22:
                    aVar.f2184a = this.g;
                    return;
                case 23:
                    Object objA9 = aVar.a();
                    Object objA10 = aVar.a();
                    Object objA11 = aVar.a();
                    if (objA9 instanceof List) {
                        List list2 = (List) objA9;
                        int iIntValue19 = ((Integer) objA10).intValue();
                        if (iIntValue19 < 0) {
                            iIntValue19 += list2.size();
                        }
                        list2.set(iIntValue19, objA11);
                        return;
                    }
                    if (objA9 instanceof Map) {
                        ((Map) objA9).put(objA10, objA11);
                        return;
                    }
                    if (!objA9.getClass().isArray()) {
                        throw new IllegalArgumentException(objA9.getClass().getName() + " is not entry");
                    }
                    int iIntValue20 = ((Integer) objA10).intValue();
                    if (iIntValue20 < 0) {
                        iIntValue20 += Array.getLength(objA9);
                    }
                    Array.set(objA9, iIntValue20, objA11);
                    return;
                case 24:
                    b(aVar.a(), aVar.b);
                    return;
                case 25:
                    Object objA12 = aVar.a();
                    dl dlVar5 = new dl(24);
                    dlVar5.b = this.b;
                    dlVar5.c = this.c;
                    dlVar5.l = (String) aVar.a();
                    dlVar5.b(objA12, aVar.b);
                    return;
                case 26:
                    b(aVar.a(this.n), aVar.b);
                    return;
                case 27:
                    Class<?> clsA4 = aVar.a(this.n);
                    dl dlVar6 = new dl(26);
                    dlVar6.b = this.b;
                    dlVar6.c = this.c;
                    dlVar6.l = (String) aVar.a();
                    dlVar6.b(clsA4, aVar.b);
                    return;
                case 28:
                    List<Object> list3 = aVar.c;
                    if (list3 != null) {
                        list3.add(aVar.a());
                    }
                    aVar.d = true;
                    aVar.e = true;
                    return;
                case 29:
                    int i12 = aVar.f2184a;
                    int i13 = this.j;
                    if (i13 > 0) {
                        aVar.f2184a = i13;
                    } else {
                        int i14 = i12 + 1;
                        int i15 = 1;
                        i13 = i12;
                        while (i15 > 0) {
                            int i16 = aVar.f.get(i14).f2183a;
                            if (i16 == 29) {
                                i15++;
                            } else if (i16 == 30) {
                                i15--;
                            }
                            if (i15 == 0) {
                                aVar.f2184a = i14;
                                i13 = i14;
                            }
                            i14++;
                        }
                    }
                    int i17 = i12 + 1;
                    B = i17 == i13 ? dm.a(this.h, this.i, aVar.f, aVar.g, i17, i13, aVar.b) : new dm(this.h, this.i, aVar.f, aVar.g, i17, i13, aVar.b);
                    String str3 = this.h;
                    if (str3 != null) {
                        aVar.b(str3, B);
                        return;
                    }
                    aVar.a(B);
                    return;
                case 30:
                    aVar.e = true;
                    return;
                case 31:
                    objB = aVar.b(this.h);
                    if (objB instanceof dm) {
                        dm dmVar = (dm) objB;
                        Object[] objArr5 = new Object[this.i];
                        for (int i18 = 0; i18 < this.i; i18++) {
                            objArr5[i18] = aVar.a();
                        }
                        linkedListB = dmVar.b(objArr5);
                        if (linkedListB.size() <= 0) {
                            return;
                        }
                        B = linkedListB.get(0);
                        aVar.a(B);
                        return;
                    }
                    if (!(objB instanceof Method)) {
                        throw new NoSuchMethodException(this.h + " at line: " + this.b + "(" + this.c + ")");
                    }
                    aVar.b.a((Method) objB, this.i);
                    return;
                case 32:
                    objB = aVar.a();
                    if (objB instanceof dm) {
                        dm dmVar2 = (dm) objB;
                        Object[] objArr6 = new Object[this.i];
                        for (int i19 = 0; i19 < this.i; i19++) {
                            objArr6[i19] = aVar.a();
                        }
                        linkedListB = dmVar2.b(objArr6);
                        if (linkedListB.size() <= 0) {
                            return;
                        }
                        B = linkedListB.get(0);
                        aVar.a(B);
                        return;
                    }
                    if (!(objB instanceof Method)) {
                        throw new RuntimeException("at line: " + this.b + "(" + this.c + ")");
                    }
                    aVar.b.a((Method) objB, this.i);
                    return;
                case 33:
                    dfVarB = aVar.b.b();
                    aVar.b = dfVarB;
                    return;
                case 34:
                    dfVarB = aVar.b.c();
                    aVar.b = dfVarB;
                    return;
                case 35:
                    str = this.e;
                    cls = aVar.a(this.d);
                    aVar.a(str, cls);
                    return;
                case 36:
                    while (true) {
                        String[] strArr = this.o;
                        if (i3 >= strArr.length) {
                            return;
                        }
                        aVar.b(strArr[i3], aVar.a());
                        i3++;
                    }
                    break;
                case 37:
                    while (true) {
                        Object[] objArr7 = this.m;
                        if (i2 >= objArr7.length) {
                            return;
                        }
                        aVar.a(objArr7[i2]);
                        i2++;
                    }
                    break;
                case 38:
                    for (String str4 : this.o) {
                        aVar.a(aVar.b(str4));
                    }
                    return;
            }
        } catch (Throwable unused5) {
        }
    }

    public void a(Class<?> cls, df dfVar) throws Throwable {
        Field declaredField;
        while (true) {
            if (cls == null) {
                dl dlVar = new dl(14);
                dlVar.b = this.b;
                dlVar.c = this.c;
                dlVar.n = this.n;
                dlVar.p = ed.a("003'eeHfi") + Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
                dlVar.i = 1;
                dlVar.a(cls, new Object[0], dfVar);
                return;
            }
            if ("class".equals(this.l)) {
                dfVar.a(cls);
                return;
            }
            if (cls.equals(dk.class) && ed.a("007Sdd7f]djfhdiedFe").equals(this.l)) {
                dfVar.a((Object) 70);
                return;
            }
            if (cls.isEnum()) {
                Object[] enumConstants = cls.getEnumConstants();
                if (enumConstants != null) {
                    for (Object obj : enumConstants) {
                        if (((Enum) obj).name().equals(this.l)) {
                            dfVar.a(obj);
                            return;
                        }
                    }
                } else {
                    continue;
                }
            } else {
                try {
                    declaredField = cls.getDeclaredField(this.l);
                } catch (Throwable unused) {
                    declaredField = null;
                }
                if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                    declaredField.setAccessible(true);
                    dfVar.a(declaredField.get(null));
                    return;
                }
                cls = cls.getSuperclass();
            }
        }
    }

    public void a(Class<?> cls, Object[] objArr, df dfVar) throws Throwable {
        Class<?>[] parameterTypes;
        boolean[] zArr;
        boolean[] zArrA;
        Object obj;
        Class<?> superclass = cls;
        if ("new".equals(this.p)) {
            if (List.class.isAssignableFrom(superclass) && objArr.length == 1 && (obj = objArr[0]) != null && obj.getClass().isArray()) {
                int length = Array.getLength(objArr[0]);
                List arrayList = superclass.equals(List.class) ? new ArrayList(length) : (List) cls.newInstance();
                for (int i = 0; i < length; i++) {
                    arrayList.add(Array.get(objArr[0], i));
                }
                dfVar.a(arrayList);
                return;
            }
            if (Map.class.isAssignableFrom(superclass) && objArr.length == 1 && objArr[0] != null) {
                Map map = superclass.equals(Map.class) ? new HashMap() : (Map) cls.newInstance();
                Object obj2 = objArr[0];
                if (obj2 instanceof Map) {
                    map.putAll((Map) obj2);
                } else {
                    Class<?> cls2 = Class.forName("org.json.JSONObject");
                    a(map, a(objArr[0], cls2), cls2, Class.forName("org.json.JSONArray"));
                }
                dfVar.a(map);
                return;
            }
            if (superclass.equals(dn.class)) {
                if (objArr.length == 2) {
                    dfVar.a(new dn((Number) objArr[0], (Number) objArr[1], null));
                    return;
                }
                if (objArr.length == 3) {
                    dfVar.a(new dn((Number) objArr[0], (Number) objArr[1], (Number) objArr[2]));
                    return;
                }
                throw new NoSuchMethodException("method name: new at line: " + this.b + "(" + this.c + ")");
            }
            boolean[][] zArr2 = new boolean[2][];
            Constructor constructorA = dfVar.g().a(superclass, objArr, zArr2);
            if (constructorA != null) {
                Object[] objArrA = !zArr2[1][0] ? dfVar.g().a(dfVar, constructorA.getParameterTypes(), objArr, zArr2[0]) : objArr;
                constructorA.setAccessible(true);
                dfVar.a(constructorA.newInstance(objArrA));
                return;
            }
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                Class<?>[] parameterTypes2 = constructor.getParameterTypes();
                boolean[] zArr3 = new boolean[1];
                boolean[] zArrA2 = dfVar.g().a(parameterTypes2, objArr, zArr3);
                if (zArrA2 != null) {
                    Object[] objArrA2 = !zArr3[0] ? dfVar.g().a(dfVar, parameterTypes2, objArr, zArrA2) : objArr;
                    constructor.setAccessible(true);
                    dfVar.a(constructor.newInstance(objArrA2));
                    return;
                }
            }
            throw new NoSuchMethodException("method name: new at line: " + this.b + "(" + this.c + ")");
        }
        if (!"fromJson".equals(this.p) || !Map.class.isAssignableFrom(superclass) || objArr.length != 1 || objArr[0] == null) {
            if (superclass.equals(Array.class)) {
                if (this.p.equals(ed.a("011ef<ffei'eUfh5idecf")) && objArr.length == 2) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof Integer) {
                        dfVar.a(Array.newInstance((Class<?>) objArr[0], ((Integer) obj3).intValue()));
                        return;
                    }
                }
                if ("copy".equals(this.p)) {
                    int i2 = this.i;
                    if (i2 == 5) {
                        System.arraycopy(objArr[0], Integer.parseInt(String.valueOf(objArr[1])), objArr[2], Integer.parseInt(String.valueOf(objArr[3])), Integer.parseInt(String.valueOf(objArr[44])));
                        return;
                    }
                    if (i2 == 2) {
                        Object obj4 = objArr[0];
                        System.arraycopy(obj4, 0, objArr[1], 0, Math.min(Array.getLength(obj4), Array.getLength(objArr[1])));
                        return;
                    }
                    throw new NoSuchMethodException("method name: copy at line: " + this.b + "(" + this.c + ")");
                }
            } else if ("quit".equals(this.p) && superclass.equals(dk.class)) {
                dfVar.e();
                return;
            }
            if (dfVar.g().a((Object) null, cls, this.p, objArr, dfVar)) {
                return;
            }
            for (Class<?> superclass2 = superclass; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                boolean[][] zArr4 = new boolean[2][];
                Method methodA = dfVar.g().a(superclass2, this.p, true, objArr, zArr4);
                if (methodA != null) {
                    Object[] objArrA3 = !zArr4[1][0] ? dfVar.g().a(dfVar, methodA.getParameterTypes(), objArr, zArr4[0]) : objArr;
                    methodA.setAccessible(true);
                    if (methodA.getReturnType() == Void.TYPE) {
                        methodA.invoke(null, objArrA3);
                        return;
                    } else {
                        dfVar.a(methodA.invoke(null, objArrA3));
                        return;
                    }
                }
            }
            while (superclass != null) {
                for (Method method : superclass.getDeclaredMethods()) {
                    if (method.getName().equals(this.p) && Modifier.isStatic(method.getModifiers()) && (zArrA = dfVar.g().a((parameterTypes = method.getParameterTypes()), objArr, (zArr = new boolean[1]))) != null) {
                        Object[] objArrA4 = !zArr[0] ? dfVar.g().a(dfVar, parameterTypes, objArr, zArrA) : objArr;
                        method.setAccessible(true);
                        if (method.getReturnType() == Void.TYPE) {
                            method.invoke(null, objArrA4);
                            return;
                        } else {
                            dfVar.a(method.invoke(null, objArrA4));
                            return;
                        }
                    }
                }
                superclass = superclass.getSuperclass();
            }
            throw new NoSuchMethodException("method name: " + this.p + " at line: " + this.b + "(" + this.c + ")");
        }
        this.p = "new";
        a(cls, objArr, dfVar);
    }

    public void a(Object obj, df dfVar) throws Throwable {
        Field declaredField;
        if (obj instanceof Map) {
            dfVar.a(((Map) obj).get(this.l));
            return;
        }
        if (ed.a("006gfe*ee-ih").equals(this.l) && obj.getClass().isArray()) {
            dfVar.a(Integer.valueOf(Array.getLength(obj)));
            return;
        }
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredField = superclass.getDeclaredField(this.l);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                dfVar.a(declaredField.get(obj));
                return;
            }
        }
        dl dlVar = new dl(12);
        dlVar.b = this.b;
        dlVar.c = this.c;
        dlVar.p = ed.a("003<ee=fi") + Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        dlVar.i = 0;
        dlVar.a(obj, new Object[0], dfVar);
    }

    public void a(Object obj, Object[] objArr, df dfVar) throws Throwable {
        byte[] bArr;
        String[] strArr;
        Object obj2;
        dm dmVar;
        String strValueOf;
        Object obj3;
        Class<?>[] parameterTypes;
        boolean[] zArr;
        boolean[] zArrA;
        Object obj4;
        Class<?>[] clsArr;
        Object[] objArrA = objArr;
        int i = 0;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj5 = map.get(this.p);
            if (obj5 != null) {
                if (obj5 instanceof dm) {
                    LinkedList<Object> linkedListB = ((dm) obj5).b(objArrA);
                    if (linkedListB.size() > 0) {
                        dfVar.a(linkedListB.get(0));
                        return;
                    }
                    return;
                }
                if (obj5 instanceof Method) {
                    dfVar.a((Method) obj5, objArrA);
                    return;
                }
            } else {
                if ((ed.a("005j5djedecdk").equals(this.p) || ed.a("011Adg'eOfh%dXef!f)gldjedecdk").equals(this.p)) && objArrA.length == 1 && (obj4 = objArrA[0]) != null) {
                    if (obj4 instanceof Class) {
                        clsArr = new Class[]{(Class) obj4};
                    } else {
                        if (!(obj4 instanceof List)) {
                            throw new NoSuchMethodException("method name: " + this.p + " at line: " + this.b + "(" + this.c + ")");
                        }
                        List list = (List) obj4;
                        clsArr = (Class[]) list.toArray(new Class[list.size()]);
                    }
                    dfVar.a(dfVar.a(obj, ed.a("005jYdjedecdk").equals(this.p), clsArr));
                    return;
                }
                if ("iterator".equals(this.p) && objArrA.length == 0) {
                    dfVar.a(map.entrySet().iterator());
                    return;
                } else if ("toJson".equals(this.p) && objArrA.length == 0) {
                    dfVar.a(Class.forName("org.json.JSONObject").getDeclaredConstructor(Map.class).newInstance(obj));
                    return;
                }
            }
        } else if (obj instanceof dm) {
            dm dmVar2 = (dm) obj;
            if (ed.a("004if@fhDi").equals(this.p)) {
                dfVar.a(dmVar2.a(objArrA));
                return;
            } else if (ed.a("008c5dgdjdjdkdiOeDee").equals(this.p)) {
                dfVar.a(dmVar2.a(dfVar, this.b, this.c));
                return;
            }
        } else if (obj instanceof Method) {
            if (ed.a("004ifQfh_i").equals(this.p)) {
                dm.a aVar = new dm.a();
                df dfVarB = dfVar.b();
                try {
                    dfVarB.a((Method) obj, objArrA);
                    aVar.b = dfVarB.a();
                } catch (Throwable th) {
                    aVar.f2186a = th;
                }
                dfVar.a(aVar);
                return;
            }
            if (ed.a("013<fh<fiVel.ccfQfhfhdife+gf").equals(this.p) && objArrA.length == 1) {
                ((Method) obj).setAccessible(((Boolean) objArrA[0]).booleanValue());
                return;
            }
        } else if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            int size = collection.size();
            if ("toArray".equals(this.p) && objArrA.length == 1 && (obj3 = objArrA[0]) != null && (obj3 instanceof Class)) {
                Object objNewInstance = Array.newInstance((Class<?>) obj3, size);
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Array.set(objNewInstance, i, it.next());
                    i++;
                }
                dfVar.a(objNewInstance);
                return;
            }
        } else if (obj.getClass().isArray()) {
            if ("iterator".equals(this.p) && objArrA.length == 0) {
                ArrayList arrayList = new ArrayList();
                int length = Array.getLength(obj);
                while (i < length) {
                    arrayList.add(Array.get(obj, i));
                    i++;
                }
                dfVar.a(arrayList.iterator());
                return;
            }
            if ("toList".equals(this.p) && objArrA.length == 0) {
                ArrayList arrayList2 = new ArrayList();
                int length2 = Array.getLength(obj);
                while (i < length2) {
                    arrayList2.add(Array.get(obj, i));
                    i++;
                }
                dfVar.a(arrayList2);
                return;
            }
            if (obj.getClass().getComponentType() == Byte.TYPE) {
                if (!ed.a("003(dfdchi").equals(this.p) || objArrA.length != 0) {
                    if (!"hex".equals(this.p) || objArrA.length != 0) {
                        if ("sha".equals(this.p) && objArrA.length == 1) {
                            MessageDigest messageDigest = MessageDigest.getInstance((String) objArrA[0]);
                            messageDigest.update((byte[]) obj);
                            dfVar.a(messageDigest.digest());
                            return;
                        }
                    } else {
                        dfVar.a(a((byte[]) obj));
                        return;
                    }
                } else {
                    byte[] bArr2 = (byte[]) obj;
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, bArr2.length);
                    Object objA = a(byteArrayInputStream);
                    byteArrayInputStream.close();
                    dfVar.a(objA);
                    return;
                }
            }
        } else if (Iterator.class.isAssignableFrom(obj.getClass())) {
            if ("hasNext".equals(this.p)) {
                dfVar.a(Boolean.valueOf(((Iterator) obj).hasNext()));
                return;
            } else if ("next".equals(this.p)) {
                dfVar.a(((Iterator) obj).next());
                return;
            } else if ("remove".equals(this.p)) {
                ((Iterator) obj).remove();
                return;
            }
        } else if (obj instanceof dn.a) {
            if ("hasNext".equals(this.p) && objArrA.length == 0) {
                dfVar.a(Boolean.valueOf(((dn.a) obj).a()));
                return;
            } else if ("next".equals(this.p) && objArrA.length == 0) {
                dfVar.a(((dn.a) obj).b());
                return;
            }
        } else if (obj instanceof dn) {
            if ("iterator".equals(this.p) && objArrA.length == 0) {
                dfVar.a(((dn) obj).a());
                return;
            }
            if ("isInRange".equals(this.p) && objArrA.length == 1) {
                dfVar.a(Boolean.valueOf(((dn) obj).a((Number) objArrA[0])));
                return;
            }
            if ("contains".equals(this.p) && objArrA.length == 1) {
                dfVar.a(Boolean.valueOf(((dn) obj).b((Number) objArrA[0])));
                return;
            } else if ("boundary".equals(this.p) && objArrA.length == 0) {
                dfVar.a(((dn) obj).b());
                return;
            }
        } else if (obj instanceof String) {
            if ("getBytes".equals(this.p)) {
                if (objArrA.length == 0) {
                    dfVar.a(((String) obj).getBytes());
                    return;
                } else if (objArrA.length == 1) {
                    Object obj6 = objArrA[0];
                    if (obj6 instanceof String) {
                        dfVar.a(((String) obj).getBytes((String) obj6));
                        return;
                    }
                }
            } else if ("input".equals(this.p)) {
                if (objArrA.length == 0) {
                    dfVar.a(new FileInputStream((String) obj));
                    return;
                } else if (objArrA.length == 1 && (objArrA[0] instanceof dm)) {
                    FileInputStream fileInputStream = new FileInputStream((String) obj);
                    ((dm) objArrA[0]).b(fileInputStream);
                    fileInputStream.close();
                    return;
                }
            } else if (!"output".equals(this.p)) {
                File file = null;
                String strValueOf2 = null;
                String strValueOf3 = null;
                FileInputStream fileInputStream2 = null;
                arrayList = null;
                Collection arrayList3 = null;
                file = null;
                if (ed.a("012-dj6fd(dcfldjeddffldiFgf").equals(this.p)) {
                    if (objArrA.length == 0) {
                        strValueOf2 = "utf-8";
                    } else if (objArrA.length == 1) {
                        strValueOf2 = String.valueOf(objArrA[0]);
                    }
                    if (strValueOf2 != null) {
                        FileInputStream fileInputStream3 = new FileInputStream((String) obj);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr3 = new byte[4096];
                        while (true) {
                            int i2 = fileInputStream3.read(bArr3);
                            if (i2 == -1) {
                                fileInputStream3.close();
                                byteArrayOutputStream.flush();
                                byteArrayOutputStream.close();
                                dfVar.a(new String(byteArrayOutputStream.toByteArray(), strValueOf2));
                                return;
                            }
                            byteArrayOutputStream.write(bArr3, 0, i2);
                        }
                    }
                } else if (ed.a("011-ffdjdiRifZekedfldiGgf").equals(this.p)) {
                    if (objArrA.length == 1) {
                        strValueOf3 = String.valueOf(objArrA[0]);
                        strValueOf = "utf-8";
                    } else if (objArrA.length == 2) {
                        strValueOf3 = String.valueOf(objArrA[0]);
                        strValueOf = String.valueOf(objArrA[1]);
                    } else {
                        strValueOf = null;
                    }
                    if (strValueOf3 != null) {
                        FileOutputStream fileOutputStream = new FileOutputStream(strValueOf3);
                        fileOutputStream.write(((String) obj).getBytes(strValueOf));
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return;
                    }
                } else if (ed.a("0093djIfd-dcfcdiKef]fh").equals(this.p)) {
                    String str = "utf-8";
                    if (objArrA.length == 0) {
                        dmVar = null;
                        fileInputStream2 = new FileInputStream((String) obj);
                    } else if (objArrA.length == 1) {
                        Object obj7 = objArrA[0];
                        if (obj7 instanceof String) {
                            fileInputStream2 = new FileInputStream((String) obj);
                            str = (String) objArrA[0];
                            dmVar = null;
                        } else {
                            if (obj7 instanceof dm) {
                                fileInputStream2 = new FileInputStream((String) obj);
                                obj2 = objArrA[0];
                                dmVar = (dm) obj2;
                            }
                            dmVar = null;
                        }
                    } else {
                        if (objArrA.length == 2 && (objArrA[0] instanceof String) && (objArrA[1] instanceof dm)) {
                            fileInputStream2 = new FileInputStream((String) obj);
                            str = (String) objArrA[0];
                            obj2 = objArrA[1];
                            dmVar = (dm) obj2;
                        }
                        dmVar = null;
                    }
                    if (fileInputStream2 != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2, str));
                        String line = bufferedReader.readLine();
                        if (dmVar == null) {
                            ArrayList arrayList4 = new ArrayList();
                            while (line != null) {
                                arrayList4.add(line);
                                line = bufferedReader.readLine();
                            }
                            dfVar.a(arrayList4);
                        } else {
                            while (line != null) {
                                dmVar.b(line);
                                line = bufferedReader.readLine();
                            }
                        }
                        bufferedReader.close();
                        return;
                    }
                } else if (ed.a("010+ffdjdiCifIfcdi:efAfh").equals(this.p)) {
                    String str2 = "utf-8";
                    if (objArrA.length >= 1) {
                        if (objArrA.length == 2) {
                            Object obj8 = objArrA[1];
                            if (obj8 instanceof String) {
                                str2 = (String) obj8;
                            }
                        }
                        Object obj9 = objArrA[0];
                        if (obj9 instanceof String) {
                            arrayList3 = new ArrayList();
                            arrayList3.add(objArrA[0]);
                        } else if (obj9 instanceof Collection) {
                            arrayList3 = (Collection) obj9;
                        } else if (obj9.getClass().isArray()) {
                            arrayList3 = new ArrayList();
                            int length3 = Array.getLength(objArrA[0]);
                            for (int i3 = 0; i3 < length3; i3++) {
                                arrayList3.add(Array.get(objArrA[0], i3));
                            }
                        }
                    }
                    if (arrayList3 != null) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream((String) obj);
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            fileOutputStream2.write((it2.next() + HttpClient.NEWLINE).getBytes(str2));
                        }
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return;
                    }
                } else if (ed.a("004fOec;fc").equals(this.p)) {
                    if (objArrA.length == 0) {
                        dfVar.a(Runtime.getRuntime().exec((String) obj));
                        return;
                    }
                    if (objArrA.length == 1 || objArrA.length == 2) {
                        Object obj10 = objArrA[0];
                        if (obj10 instanceof String[]) {
                            strArr = (String[]) obj10;
                        } else if (obj10 instanceof List) {
                            List list2 = (List) obj10;
                            int size2 = list2.size();
                            String[] strArr2 = new String[size2];
                            for (int i4 = 0; i4 < size2; i4++) {
                                Object obj11 = list2.get(i4);
                                strArr2[i4] = obj11 == null ? null : String.valueOf(obj11);
                            }
                            strArr = strArr2;
                        } else {
                            strArr = null;
                        }
                        if (objArrA.length == 2) {
                            Object obj12 = objArrA[1];
                            if (obj12 instanceof File) {
                                file = (File) obj12;
                            }
                        }
                        if (strArr != null) {
                            dfVar.a(Runtime.getRuntime().exec((String) obj, strArr, file));
                            return;
                        }
                    }
                } else if (ed.a("007$efdjeddffjGfFec").equals(this.p) && objArrA.length == 0) {
                    String str3 = (String) obj;
                    int length4 = str3.length();
                    if (length4 % 2 == 1) {
                        length4++;
                        bArr = new byte[length4 / 2];
                        str3 = "0" + str3;
                    } else {
                        bArr = new byte[length4 / 2];
                    }
                    int i5 = 0;
                    while (i < length4) {
                        int i6 = i + 2;
                        bArr[i5] = (byte) Integer.parseInt(str3.substring(i, i6), 16);
                        i5++;
                        i = i6;
                    }
                    dfVar.a(bArr);
                    return;
                }
            } else if (objArrA.length == 0) {
                dfVar.a(new FileOutputStream((String) obj));
                return;
            } else if (objArrA.length == 1 && (objArrA[0] instanceof dm)) {
                FileOutputStream fileOutputStream3 = new FileOutputStream((String) obj);
                ((dm) objArrA[0]).b(fileOutputStream3);
                fileOutputStream3.flush();
                fileOutputStream3.close();
                return;
            }
        } else if (obj instanceof InputStream) {
            if (ed.a("017i*edfk'didXei!ej'dg$iVej_i9dj!fdIdf").equals(this.p) && objArrA.length == 0) {
                dfVar.a(new DataInputStream((InputStream) obj));
                return;
            }
            if (ed.a("021iJedfidgefef'f!djPf dcei$ej+dgUiFejCi+djLfd!df").equals(this.p) && objArrA.length == 0) {
                dfVar.a(new BufferedInputStream((InputStream) obj));
                return;
            }
            if (ed.a("017i8edidileigleiKej)dgOi@ej!i!dj3fdBdf").equals(this.p) && objArrA.length == 0) {
                dfVar.a(new GZIPInputStream((InputStream) obj));
                return;
            } else if (ed.a("019i_edggfehgEfci@eiEejAdgRiUej+iEdj2fdAdf").equals(this.p) && objArrA.length == 0) {
                dfVar.a(new ObjectInputStream((InputStream) obj));
                return;
            } else if (ed.a("003Ldfdchi").equals(this.p) && objArrA.length == 0) {
                a((InputStream) obj);
            }
        } else if (obj instanceof OutputStream) {
            if (ed.a("018i7edfkRdid6ggdg9ijWdgPiUejVi3dj'fdNdf").equals(this.p) && objArrA.length == 0) {
                dfVar.a(new DataOutputStream((OutputStream) obj));
                return;
            }
            if (ed.a("022i?edfidgefef,f)dj=f-dcggdg<ij dg,i4ejKi0djAfd9df").equals(this.p) && objArrA.length == 0) {
                dfVar.a(new BufferedOutputStream((OutputStream) obj));
                return;
            }
            if (ed.a("018i*edidileiglggdgGij)dg)i4ej7iYdj4fd(df").equals(this.p) && objArrA.length == 0) {
                dfVar.a(new GZIPOutputStream((OutputStream) obj));
                return;
            } else if (ed.a("020iQedggfehg1fci:ggdg-ij<dgPiSej0iMdjMfd^df").equals(this.p) && objArrA.length == 0) {
                dfVar.a(new ObjectOutputStream((OutputStream) obj));
                return;
            }
        } else if (obj instanceof Class) {
            if (ed.a("0062didfCjCeddj=i").equals(this.p)) {
                if (objArrA.length == 0) {
                    Class<?> cls = (Class) obj;
                    dfVar.a(cls.getSimpleName(), cls);
                    return;
                } else if (objArrA.length == 1) {
                    Object obj13 = objArrA[0];
                    if (obj13 instanceof String) {
                        dfVar.a((String) obj13, (Class<?>) obj);
                        return;
                    }
                }
            }
        } else if (obj instanceof Throwable) {
            if (ed.a("005ihZdjedff").equals(this.p) && objArrA.length == 0) {
                throw ((Throwable) obj);
            }
        } else if (AccessibleObject.class.isAssignableFrom(obj.getClass()) && ed.a("013=fhDfi_el[ccfEfhfhdife)gf").equals(this.p) && objArrA.length == 1) {
            ((AccessibleObject) obj).setAccessible(((Boolean) objArrA[0]).booleanValue());
            return;
        }
        if (ed.a("004g?edIcOdl").equals(this.p) && objArrA.length > 0 && (objArrA[0] instanceof dm)) {
            synchronized (obj) {
                dm dmVar3 = (dm) objArrA[0];
                int length5 = objArrA.length - 1;
                Object[] objArr2 = new Object[length5];
                if (objArrA.length > 1) {
                    System.arraycopy(objArrA, 1, objArr2, 0, length5);
                }
                LinkedList<Object> linkedListB2 = dmVar3.b(objArr2);
                if (!linkedListB2.isEmpty()) {
                    dfVar.a(linkedListB2.get(0));
                }
            }
            return;
        }
        Class<?> superclass = obj.getClass();
        if (dfVar.g().a(obj, superclass, this.p, objArr, dfVar)) {
            return;
        }
        for (Class<?> superclass2 = superclass; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
            boolean[][] zArr2 = new boolean[2][];
            Method methodA = dfVar.g().a(superclass2, this.p, false, objArr, zArr2);
            if (methodA != null) {
                if (!zArr2[1][0]) {
                    objArrA = dfVar.g().a(dfVar, methodA.getParameterTypes(), objArrA, zArr2[0]);
                }
                methodA.setAccessible(true);
                if (methodA.getReturnType() == Void.TYPE) {
                    methodA.invoke(obj, objArrA);
                    return;
                } else {
                    dfVar.a(methodA.invoke(obj, objArrA));
                    return;
                }
            }
        }
        while (superclass != null) {
            for (Method method : superclass.getDeclaredMethods()) {
                if (method.getName().equals(this.p) && !Modifier.isStatic(method.getModifiers()) && (zArrA = dfVar.g().a((parameterTypes = method.getParameterTypes()), objArrA, (zArr = new boolean[1]))) != null) {
                    if (!zArr[0]) {
                        objArrA = dfVar.g().a(dfVar, parameterTypes, objArrA, zArrA);
                    }
                    method.setAccessible(true);
                    if (method.getReturnType() == Void.TYPE) {
                        method.invoke(obj, objArrA);
                        return;
                    } else {
                        dfVar.a(method.invoke(obj, objArrA));
                        return;
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
        throw new NoSuchMethodException("method name: " + this.p + " at line: " + this.b + "(" + this.c + ")");
    }

    private void a(Map map, Object obj, Class<?> cls, Class<?> cls2) throws Throwable {
        Field declaredField = cls.getDeclaredField("nameValuePairs");
        declaredField.setAccessible(true);
        Map map2 = (Map) declaredField.get(obj);
        Field declaredField2 = cls.getDeclaredField("NULL");
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(null);
        for (Map.Entry entry : map2.entrySet()) {
            map.put(entry.getKey(), a(entry.getValue(), obj2, cls, cls2));
        }
    }
}
