package com.bytedance.sdk.openadsdk.ats;

import android.content.Context;
import com.bytedance.sdk.component.b.jk;
import com.bytedance.sdk.component.b.l;
import com.bytedance.sdk.component.b.t;
import com.bytedance.sdk.component.iz.bg;
import com.bytedance.sdk.component.iz.c;
import com.bytedance.sdk.component.iz.q;
import com.bytedance.sdk.openadsdk.core.y.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class u {
    private pn b;
    private List<String> fx;
    private final Map<String, Object> u = new HashMap();
    private final Map<String, Object> nr = new HashMap();

    private <T> T u(Class<T> cls) {
        if (cls == bg.class) {
            return (T) com.bytedance.sdk.openadsdk.n.u.u();
        }
        if (cls == Context.class) {
            return (T) com.bytedance.sdk.openadsdk.n.u.getContext();
        }
        if (cls == c.class) {
            return (T) com.bytedance.sdk.openadsdk.n.u.u(com.bytedance.sdk.openadsdk.n.u.getContext(), com.bytedance.sdk.openadsdk.n.u.u());
        }
        return null;
    }

    public x nr(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        switch (str.hashCode()) {
            case -1543207689:
                cls = com.bytedance.sdk.component.b.u.u.class;
                cls2 = a.class;
                cls3 = com.bytedance.sdk.component.b.u.nr.class;
                break;
            case -1535463234:
                cls = t.class;
                cls2 = n.class;
                cls3 = l.class;
                break;
            case -1083272647:
                cls = c.class;
                cls2 = com.bytedance.sdk.component.iz.fx.nr.class;
                cls3 = q.class;
                break;
            case -987979858:
                cls = com.bytedance.sdk.openadsdk.core.rh.fx.class;
                cls2 = com.bytedance.sdk.openadsdk.core.rh.iz.class;
                cls3 = com.bytedance.sdk.openadsdk.core.rh.b.class;
                break;
            case 96891546:
                cls = com.bytedance.sdk.component.b.x.class;
                cls2 = com.bytedance.sdk.openadsdk.core.qq.fx.class;
                cls3 = com.bytedance.sdk.component.b.n.class;
                break;
            case 658907061:
                cls = com.bytedance.sdk.component.b.u.class;
                cls2 = nr.class;
                cls3 = com.bytedance.sdk.component.b.b.class;
                break;
            case 1209788376:
                cls = com.bytedance.sdk.component.b.a.class;
                cls2 = b.class;
                cls3 = jk.class;
                break;
            case 1390272937:
                cls = com.bytedance.sdk.component.b.pn.class;
                cls2 = com.bytedance.sdk.openadsdk.core.qq.b.class;
                cls3 = com.bytedance.sdk.component.b.iz.class;
                break;
            default:
                return null;
        }
        return new x(cls, cls2, cls3, true, 0);
    }

    public Map<String, Object> u() {
        return this.u;
    }

    public <T> T u(String str) {
        if (str == null) {
            pn pnVar = this.b;
            if (pnVar != null) {
                pnVar.u("", (Throwable) new RuntimeException("null key"));
            }
            return null;
        }
        T t = (T) this.u.get(str);
        if (t == null) {
            t = (T) this.nr.get(str);
        }
        if (t != null) {
            return t;
        }
        x xVarNr = nr(str);
        if (xVarNr == null) {
            pn pnVar2 = this.b;
            if (pnVar2 != null) {
                pnVar2.u(str, (Throwable) new RuntimeException("clazz not register"));
            }
            return null;
        }
        return (T) u(str, xVarNr);
    }

    private Object u(String str, x xVar) {
        Object objU = null;
        try {
            if (xVar.b) {
                objU = this.u.get(str);
                if (objU != null) {
                    return objU;
                }
                synchronized (xVar.nr) {
                    objU = this.u.get(str);
                    if (objU == null) {
                        objU = u((Class<Object>) xVar.nr, (Class<Object>) xVar.u);
                        this.u.put(str, objU);
                    }
                }
                return objU;
            }
            return u((Class) xVar.nr, (Class) xVar.u);
        } catch (Throwable th) {
            pn pnVar = this.b;
            if (pnVar == null) {
                return objU;
            }
            pnVar.u(str, th);
            return objU;
        }
    }

    public Object u(String str, Object obj) {
        x xVarNr = nr(str);
        if (xVarNr == null) {
            pn pnVar = this.b;
            if (pnVar != null) {
                pnVar.u(str, (Throwable) new RuntimeException("reuseservice not register"));
            }
            return null;
        }
        try {
            Object objNewInstance = xVarNr.fx.getDeclaredConstructor(Function.class).newInstance(obj);
            if (xVarNr.b) {
                this.u.put(str, objNewInstance);
            }
            return objNewInstance;
        } catch (Exception e) {
            pn pnVar2 = this.b;
            if (pnVar2 != null) {
                pnVar2.u(xVarNr.u.getName(), xVarNr.nr.getName(), "reuse failed", e);
            }
            return null;
        }
    }

    private <T> T u(Class<T> cls, Class<T> cls2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T t = (T) u(cls2);
        if (t != null) {
            return t;
        }
        T t2 = (T) u(cls);
        if (t2 != null) {
            return t2;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors.length > 0) {
            Constructor<?> constructor = declaredConstructors[0];
            try {
                constructor.setAccessible(true);
            } catch (Exception unused) {
            }
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length != 0) {
                Object[] objArr = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    Object objU = u(parameterTypes[i]);
                    if (objU != null) {
                        objArr[i] = objU;
                    } else {
                        throw new RuntimeException("params type " + parameterTypes[i] + "  for " + cls + " not config!");
                    }
                }
                return (T) constructor.newInstance(objArr);
            }
        }
        return cls.newInstance();
    }

    public void u(String str, Object obj, int i) {
        x xVarNr = nr(str);
        if (xVarNr == null || obj == null || xVarNr.pn > i) {
            return;
        }
        List<String> list = this.fx;
        if (list == null || !list.contains(str)) {
            try {
                Object objNewInstance = xVarNr.fx.getDeclaredConstructor(Function.class).newInstance(obj);
                this.nr.put(str, objNewInstance);
                pn pnVar = this.b;
                if (pnVar != null) {
                    pnVar.u(str, objNewInstance);
                }
            } catch (Exception e) {
                pn pnVar2 = this.b;
                if (pnVar2 != null) {
                    pnVar2.u(xVarNr.u.getName(), xVarNr.nr.getName(), "reuse failed", e);
                }
            }
        }
    }
}
