package com.bytedance.sdk.component.fx.nr.u.x;

import com.bytedance.sdk.component.fx.nr.qq;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class fx extends pn {
    private final Class<?> b;
    private final Method fx;
    private final Method nr;
    private final Class<?> pn;
    private final Method u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements InvocationHandler {
        private final List<String> fx;
        String nr;
        boolean u;

        public u(List<String> list) {
            this.fx = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.component.fx.nr.u.fx.nr;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.u = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.fx;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.fx.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.nr = str;
                            return str;
                        }
                    }
                    String str2 = this.fx.get(0);
                    this.nr = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.nr = (String) objArr[0];
            return null;
        }
    }

    public fx(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.u = method;
        this.nr = method2;
        this.fx = method3;
        this.b = cls;
        this.pn = cls2;
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public void nr(SSLSocket sSLSocket) {
        try {
            this.fx.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to remove alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public void u(SSLSocket sSLSocket, String str, List<qq> list) {
        try {
            this.u.invoke(null, sSLSocket, Proxy.newProxyInstance(pn.class.getClassLoader(), new Class[]{this.b, this.pn}, new u(pn.u(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to set alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public String u(SSLSocket sSLSocket) {
        try {
            u uVar = (u) Proxy.getInvocationHandler(this.nr.invoke(null, sSLSocket));
            boolean z = uVar.u;
            if (!z && uVar.nr == null) {
                pn.nr().u(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (z) {
                return null;
            }
            return uVar.nr;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to get selected protocol", (Exception) e);
        }
    }

    public static pn u() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new fx(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
