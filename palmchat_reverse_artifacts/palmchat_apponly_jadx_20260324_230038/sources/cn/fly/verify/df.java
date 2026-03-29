package cn.fly.verify;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dh f2176a;
    private HashMap<String, Object> c;
    private df e;
    private boolean f;
    private LinkedList<Object> b = new LinkedList<>();
    private HashMap<String, Class<?>> d = new HashMap<>();

    public df(HashMap<String, Object> map, dh dhVar) {
        this.f2176a = dhVar;
        this.c = new HashMap<>(map);
    }

    public Object a() {
        return this.b.pop();
    }

    public df b() {
        df dfVar = new df(new HashMap(), this.f2176a);
        dfVar.e = this;
        return dfVar;
    }

    public df c() {
        return this.e;
    }

    public int d() {
        return this.b.size();
    }

    public void e() {
        this.f = true;
    }

    public boolean f() {
        return this.f;
    }

    public dh g() {
        return this.f2176a;
    }

    public Object a(final Object obj, final boolean z, Class<?>... clsArr) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new InvocationHandler() { // from class: cn.fly.verify.df.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) throws Throwable {
                Throwable th;
                dm dmVar;
                LinkedList<Object> linkedListB;
                try {
                    Object obj3 = obj;
                    dmVar = obj3 != null ? obj3 instanceof dm ? (dm) obj3 : (dm) ((Map) obj3).get(method.getName()) : null;
                } catch (Throwable unused) {
                }
                if (dmVar != null) {
                    if (objArr == null) {
                        objArr = new Object[0];
                    }
                    if (z) {
                        linkedListB = dmVar.b(objArr);
                    } else {
                        try {
                            linkedListB = dmVar.b(objArr);
                        } finally {
                            th = th;
                            try {
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    if (linkedListB.isEmpty()) {
                        return null;
                    }
                    return linkedListB.get(0);
                    th = null;
                } else {
                    th = null;
                }
                if (th == null) {
                    return null;
                }
                throw th;
            }
        });
    }

    public Class<?> b(String str) {
        for (df dfVar = this; dfVar != null; dfVar = dfVar.e) {
            if (dfVar.d.containsKey(str)) {
                return dfVar.d.get(str);
            }
        }
        throw new RuntimeException("Can not find class " + str);
    }

    public Object a(String str) {
        for (df dfVar = this; dfVar != null; dfVar = dfVar.e) {
            if (dfVar.c.containsKey(str)) {
                return dfVar.c.get(str);
            }
        }
        throw new RuntimeException("Can not find \"" + str + "\"");
    }

    public void b(String str, Object obj) {
        if (this.c.containsKey(str)) {
            this.c.put(str, obj);
            return;
        }
        df dfVar = this.e;
        if (dfVar != null) {
            dfVar.b(str, obj);
            return;
        }
        throw new RuntimeException("\"" + str + "\" has not defined");
    }

    public void a(Object obj) {
        this.b.push(obj);
    }

    public void a(String str, Class<?> cls) {
        this.d.put(str, cls);
    }

    public void a(String str, Object obj) {
        if (!this.c.containsKey(str)) {
            this.c.put(str, obj);
            return;
        }
        throw new RuntimeException("\"" + str + "\" has defined");
    }

    public void a(Method method, int i) throws Throwable {
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = a();
        }
        a(method, objArr);
    }

    public void a(Method method, Object[] objArr) throws Throwable {
        Object obj;
        if (Modifier.isStatic(method.getModifiers())) {
            obj = null;
        } else {
            if (objArr.length <= 0) {
                throw new RuntimeException("receiver not found");
            }
            obj = objArr[0];
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                objArr2[i] = objArr[i2];
                i = i2;
            }
            objArr = objArr2;
        }
        method.setAccessible(true);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (method.getParameterTypes()[i3].isInterface()) {
                Object obj2 = objArr[i3];
                if (obj2 instanceof dm) {
                    objArr[i3] = a(obj2, true, method.getParameterTypes()[i3]);
                }
            }
        }
        if (method.getReturnType() == Void.TYPE) {
            method.invoke(obj, objArr);
        } else {
            a(method.invoke(obj, objArr));
        }
    }
}
