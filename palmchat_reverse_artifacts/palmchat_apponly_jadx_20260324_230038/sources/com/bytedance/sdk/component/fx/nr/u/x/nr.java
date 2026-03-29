package com.bytedance.sdk.component.fx.nr.u.x;

import com.bytedance.sdk.component.fx.nr.qq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class nr extends pn {
    final Method nr;
    final Method u;

    public nr(Method method, Method method2) {
        this.u = method;
        this.nr = method2;
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public void u(SSLSocket sSLSocket, String str, List<qq> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listU = pn.u(list);
            this.u.invoke(sSLParameters, listU.toArray(new String[listU.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.u.x.pn
    public String u(SSLSocket sSLSocket) {
        try {
            String str = (String) this.nr.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.fx.nr.u.fx.u("unable to get selected protocols", (Exception) e);
        }
    }

    public static nr u() {
        try {
            return new nr(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
