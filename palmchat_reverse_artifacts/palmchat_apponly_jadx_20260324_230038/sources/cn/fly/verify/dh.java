package cn.fly.verify;

import cn.fly.verify.dm;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Class<?>> f2178a;
    private final HashMap<String, HashMap<String, String[][]>> b = new HashMap<>();
    private final HashMap<Class<?>, dg<?>> c = new HashMap<>();

    static {
        HashMap<String, Class<?>> map = new HashMap<>();
        f2178a = map;
        map.put(ec.b("003_ch!dh"), Integer.TYPE);
        map.put(ec.b("006Kcbdccfed9fe"), Double.TYPE);
        map.put("long", Long.TYPE);
        map.put(ec.b("005KdeMfIdcQch"), Float.TYPE);
        map.put("boolean", Boolean.TYPE);
        map.put("short", Short.TYPE);
        map.put("byte", Byte.TYPE);
        map.put(ec.b("004bgc9ci"), Character.TYPE);
        map.put("void", Void.TYPE);
    }

    public dh() {
        a(dm.a.class, dm.a.class);
    }

    private Class<?> a(String str) {
        Class<?> cls = f2178a.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean b(Class<?> cls, Class<?> cls2) {
        return (cls == Byte.TYPE && cls2 == Byte.class) || (cls == Short.TYPE && (cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Character.TYPE && (cls2 == Character.class || cls2 == Short.class || cls2 == Byte.class)) || ((cls == Integer.TYPE && (cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Long.TYPE && (cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Float.TYPE && (cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Double.TYPE && (cls2 == Double.class || cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || (cls == Boolean.TYPE && cls2 == Boolean.class))))));
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1638)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:310)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public java.lang.reflect.Constructor a(java.lang.Class<?> r12, java.lang.Object[] r13, boolean[][] r14) throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r0 = r11.b
            java.lang.String r1 = r12.getName()
            java.lang.Object r0 = r0.get(r1)
            java.util.HashMap r0 = (java.util.HashMap) r0
            if (r0 == 0) goto L52
            java.lang.String r1 = "<init>"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String[][] r0 = (java.lang.String[][]) r0
            if (r0 == 0) goto L52
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L1b:
            if (r3 >= r1) goto L52
            r4 = r0[r3]
            int r5 = r4.length
            r6 = 1
            int r5 = r5 - r6
            int r7 = r13.length
            if (r5 != r7) goto L4f
            int r5 = r13.length
            java.lang.Class[] r7 = new java.lang.Class[r5]
            r8 = 0
        L29:
            if (r8 >= r5) goto L3b
            int r9 = r8 + 1
            r10 = r4[r9]
            java.lang.Class r10 = r11.a(r10)
            r7[r8] = r10
            if (r10 != 0) goto L39
            r4 = 1
            goto L3c
        L39:
            r8 = r9
            goto L29
        L3b:
            r4 = 0
        L3c:
            if (r4 != 0) goto L4f
            boolean[] r4 = new boolean[r6]
            boolean[] r5 = r11.a(r7, r13, r4)
            if (r5 == 0) goto L4f
            r14[r2] = r5
            r14[r6] = r4
            java.lang.reflect.Constructor r12 = r12.getDeclaredConstructor(r7)
            return r12
        L4f:
            int r3 = r3 + 1
            goto L1b
        L52:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.fly.verify.dh.a(java.lang.Class, java.lang.Object[], boolean[][]):java.lang.reflect.Constructor");
    }

    /*  JADX ERROR: NoSuchElementException in pass: ReplaceNewArray
        java.util.NoSuchElementException
        	at java.base/java.util.TreeMap.key(TreeMap.java:1638)
        	at java.base/java.util.TreeMap.lastKey(TreeMap.java:310)
        	at jadx.core.dex.visitors.ReplaceNewArray.processNewArray(ReplaceNewArray.java:171)
        	at jadx.core.dex.visitors.ReplaceNewArray.processInsn(ReplaceNewArray.java:72)
        	at jadx.core.dex.visitors.ReplaceNewArray.visit(ReplaceNewArray.java:53)
        */
    public java.lang.reflect.Method a(java.lang.Class<?> r16, java.lang.String r17, boolean r18, java.lang.Object[] r19, boolean[][] r20) throws java.lang.Throwable {
        /*
            r15 = this;
            r0 = r15
            r1 = r17
            r2 = r19
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String[][]>> r3 = r0.b
            java.lang.String r4 = r16.getName()
            java.lang.Object r3 = r3.get(r4)
            java.util.HashMap r3 = (java.util.HashMap) r3
            if (r3 == 0) goto L6b
            java.lang.Object r3 = r3.get(r1)
            java.lang.String[][] r3 = (java.lang.String[][]) r3
            if (r3 == 0) goto L6b
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L1e:
            if (r6 >= r4) goto L6b
            r7 = r3[r6]
            r8 = r7[r5]
            r9 = 1
            if (r8 == 0) goto L2b
            r8 = r18
            r10 = 1
            goto L2e
        L2b:
            r8 = r18
            r10 = 0
        L2e:
            if (r8 != r10) goto L32
            r10 = 1
            goto L33
        L32:
            r10 = 0
        L33:
            if (r10 == 0) goto L66
            int r10 = r7.length
            int r10 = r10 - r9
            int r11 = r2.length
            if (r10 != r11) goto L66
            int r10 = r2.length
            java.lang.Class[] r11 = new java.lang.Class[r10]
            r12 = 0
        L3e:
            if (r12 >= r10) goto L50
            int r13 = r12 + 1
            r14 = r7[r13]
            java.lang.Class r14 = r15.a(r14)
            r11[r12] = r14
            if (r14 != 0) goto L4e
            r7 = 1
            goto L51
        L4e:
            r12 = r13
            goto L3e
        L50:
            r7 = 0
        L51:
            if (r7 != 0) goto L66
            boolean[] r7 = new boolean[r9]
            boolean[] r10 = r15.a(r11, r2, r7)
            if (r10 == 0) goto L66
            r20[r5] = r10
            r20[r9] = r7
            r7 = r16
            java.lang.reflect.Method r1 = r7.getDeclaredMethod(r1, r11)
            return r1
        L66:
            r7 = r16
            int r6 = r6 + 1
            goto L1e
        L6b:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.fly.verify.dh.a(java.lang.Class, java.lang.String, boolean, java.lang.Object[], boolean[][]):java.lang.reflect.Method");
    }

    public void a(Class<?> cls, Class<? extends dg<?>> cls2) {
        try {
            dg<?> dgVarNewInstance = cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (this.c.get(cls) == null) {
                this.c.put(cls, dgVarNewInstance);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(byte[] bArr) throws Throwable {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), "utf-8"));
        try {
            try {
                HashMap<String, String[][]> map = null;
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    String strSubstring = line.substring(0, 2);
                    String strSubstring2 = line.substring(2);
                    if (":P".equals(strSubstring)) {
                        arrayList.addAll(Arrays.asList(strSubstring2.split("#")));
                    } else if (":C".equals(strSubstring)) {
                        String str = (String) arrayList.get(Integer.parseInt(strSubstring2));
                        map = this.b.get(str);
                        if (map == null) {
                            map = new HashMap<>();
                            this.b.put(str, map);
                        }
                    } else {
                        String[] strArrSplit = strSubstring2.split("#");
                        String str2 = (String) arrayList.get(Integer.parseInt(strArrSplit[0]));
                        String[][] strArr = new String[Integer.parseInt(strArrSplit[1])][];
                        for (int i = 2; i < strArrSplit.length; i++) {
                            String str3 = strArrSplit[i].startsWith("+") ? "+" : null;
                            if (strArrSplit[i].length() > 1) {
                                String[] strArrSplit2 = strArrSplit[i].substring(1).split(",");
                                String[] strArr2 = new String[strArrSplit2.length + 1];
                                strArr2[0] = str3;
                                int i2 = 0;
                                while (i2 < strArrSplit2.length) {
                                    int i3 = i2 + 1;
                                    strArr2[i3] = (String) arrayList.get(Integer.parseInt(strArrSplit2[i2]));
                                    i2 = i3;
                                }
                                strArr[i - 2] = strArr2;
                            } else {
                                strArr[i - 2] = new String[]{str3};
                            }
                        }
                        map.put(str2, strArr);
                    }
                }
            } finally {
                bufferedReader.close();
            }
        } catch (Throwable unused) {
            this.b.clear();
        }
    }

    public boolean a(Object obj, Class<?> cls, String str, Object[] objArr, df dfVar) throws Throwable {
        dg<?> dgVar = null;
        for (Class<?> superclass = cls; dgVar == null && superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
            dgVar = this.c.get(superclass);
        }
        if (dgVar == null) {
            return false;
        }
        boolean[] zArr = new boolean[1];
        Object[] objArr2 = new Object[1];
        Throwable[] thArr = new Throwable[1];
        boolean zA = dgVar.a(obj, cls, str, objArr, zArr, objArr2, thArr);
        if (zA) {
            Throwable th = thArr[0];
            if (th != null) {
                throw th;
            }
            if (!zArr[0]) {
                dfVar.a(objArr2[0]);
            }
        }
        return zA;
    }

    public Object[] a(df dfVar, Class<?>[] clsArr, Object[] objArr, boolean[] zArr) {
        Object[] objArr2 = new Object[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                if (zArr[i]) {
                    objArr2[i] = dfVar.a(obj, true, clsArr[i]);
                } else {
                    objArr2[i] = obj;
                }
            }
        }
        return objArr2;
    }

    public boolean[] a(Class<?>[] clsArr, Object[] objArr, boolean[] zArr) {
        zArr[0] = true;
        if (clsArr.length != objArr.length) {
            return null;
        }
        boolean[] zArr2 = new boolean[clsArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                Class<?> cls = clsArr[i];
                if (cls.isInterface() && (obj instanceof dm)) {
                    zArr2[i] = true;
                    zArr[0] = false;
                } else {
                    Class<?> cls2 = obj.getClass();
                    if (!b(cls, cls2) && !cls.isAssignableFrom(cls2)) {
                        return null;
                    }
                    zArr2[i] = false;
                }
            }
        }
        return zArr2;
    }
}
