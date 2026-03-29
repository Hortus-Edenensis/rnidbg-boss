package com.squareup.okhttp.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Platform {
    private static final Platform PLATFORM = findPlatform();
    private Constructor<DeflaterOutputStream> deflaterConstructor;

    /* JADX INFO: compiled from: SearchBox */
    public static class Android23 extends Platform {
        protected final Class<?> openSslSocketClass;
        private final Method setHostname;
        private final Method setUseSessionTickets;

        @Override // com.squareup.okhttp.internal.Platform
        public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (SecurityException e) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e);
                throw iOException;
            }
        }

        @Override // com.squareup.okhttp.internal.Platform
        public void enableTlsExtensions(SSLSocket sSLSocket, String str) {
            super.enableTlsExtensions(sSLSocket, str);
            if (this.openSslSocketClass.isInstance(sSLSocket)) {
                try {
                    this.setUseSessionTickets.invoke(sSLSocket, Boolean.TRUE);
                    this.setHostname.invoke(sSLSocket, str);
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        private Android23(Class<?> cls, Method method, Method method2) {
            this.openSslSocketClass = cls;
            this.setUseSessionTickets = method;
            this.setHostname = method2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Android41 extends Android23 {
        private final Method getNpnSelectedProtocol;
        private final Method setNpnProtocols;

        @Override // com.squareup.okhttp.internal.Platform
        public byte[] getNpnSelectedProtocol(SSLSocket sSLSocket) {
            if (!this.openSslSocketClass.isInstance(sSLSocket)) {
                return null;
            }
            try {
                return (byte[]) this.getNpnSelectedProtocol.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.squareup.okhttp.internal.Platform
        public void setNpnProtocols(SSLSocket sSLSocket, byte[] bArr) {
            if (this.openSslSocketClass.isInstance(sSLSocket)) {
                try {
                    this.setNpnProtocols.invoke(sSLSocket, bArr);
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        private Android41(Class<?> cls, Method method, Method method2, Method method3, Method method4) {
            super(cls, method, method2);
            this.setNpnProtocols = method3;
            this.getNpnSelectedProtocol = method4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class JdkWithJettyNpnPlatform extends Platform {
        private final Class<?> clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Class<?> serverProviderClass;

        public JdkWithJettyNpnPlatform(Method method, Method method2, Class<?> cls, Class<?> cls2) {
            this.putMethod = method;
            this.getMethod = method2;
            this.clientProviderClass = cls;
            this.serverProviderClass = cls2;
        }

        @Override // com.squareup.okhttp.internal.Platform
        public byte[] getNpnSelectedProtocol(SSLSocket sSLSocket) {
            try {
                JettyNpnProvider jettyNpnProvider = (JettyNpnProvider) Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
                if (!jettyNpnProvider.unsupported && jettyNpnProvider.selected == null) {
                    Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?");
                    return null;
                }
                if (jettyNpnProvider.unsupported) {
                    return null;
                }
                return jettyNpnProvider.selected.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                throw new AssertionError();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            } catch (InvocationTargetException unused3) {
                throw new AssertionError();
            }
        }

        @Override // com.squareup.okhttp.internal.Platform
        public void setNpnProtocols(SSLSocket sSLSocket, byte[] bArr) {
            try {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < bArr.length) {
                    int i2 = i + 1;
                    byte b = bArr[i];
                    arrayList.add(new String(bArr, i2, b, "US-ASCII"));
                    i = b + i2;
                }
                this.putMethod.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new JettyNpnProvider(arrayList)));
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class JettyNpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public JettyNpnProvider(List<String> list) {
            this.protocols = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if (name.equals("selectProtocol") && String.class == returnType && objArr.length == 1 && ((obj2 = objArr[0]) == null || (obj2 instanceof List))) {
                String str = this.protocols.get(0);
                this.selected = str;
                return str;
            }
            if (!name.equals("protocolSelected") || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.selected = (String) objArr[0];
            return null;
        }
    }

    private static Platform findPlatform() {
        Class<?> cls;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                try {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.npn.NextProtoNego");
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.npn.NextProtoNego$Provider");
                    return new JdkWithJettyNpnPlatform(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod("get", SSLSocket.class), Class.forName("org.eclipse.jetty.npn.NextProtoNego$ClientProvider"), Class.forName("org.eclipse.jetty.npn.NextProtoNego$ServerProvider"));
                } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                    return new Platform();
                }
            }
        } catch (ClassNotFoundException unused3) {
            cls = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        Method method = cls.getMethod("setUseSessionTickets", Boolean.TYPE);
        Method method2 = cls.getMethod("setHostname", String.class);
        try {
            return new Android41(cls, method, method2, cls.getMethod("setNpnProtocols", byte[].class), cls.getMethod("getNpnSelectedProtocol", new Class[0]));
        } catch (NoSuchMethodException unused4) {
            return new Android23(cls, method, method2);
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public byte[] getNpnSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public void logW(String str) {
        System.out.println(str);
    }

    public OutputStream newDeflaterOutputStream(OutputStream outputStream, Deflater deflater, boolean z) {
        try {
            Constructor<DeflaterOutputStream> constructor = this.deflaterConstructor;
            if (constructor == null) {
                constructor = DeflaterOutputStream.class.getConstructor(OutputStream.class, Deflater.class, Boolean.TYPE);
                this.deflaterConstructor = constructor;
            }
            return constructor.newInstance(outputStream, deflater, Boolean.valueOf(z));
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException unused2) {
            throw new UnsupportedOperationException("Cannot SPDY; no SYNC_FLUSH available");
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException(e2.getCause());
        }
    }

    public void supportTlsIntolerantServer(SSLSocket sSLSocket) {
        sSLSocket.setEnabledProtocols(new String[]{"SSLv3"});
    }

    public URI toUriLenient(URL url) throws URISyntaxException {
        return url.toURI();
    }

    public void tagSocket(Socket socket) throws SocketException {
    }

    public void untagSocket(Socket socket) throws SocketException {
    }

    public void enableTlsExtensions(SSLSocket sSLSocket, String str) {
    }

    public void setNpnProtocols(SSLSocket sSLSocket, byte[] bArr) {
    }
}
