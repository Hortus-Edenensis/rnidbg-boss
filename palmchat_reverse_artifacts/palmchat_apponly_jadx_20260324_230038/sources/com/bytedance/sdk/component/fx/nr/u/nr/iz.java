package com.bytedance.sdk.component.fx.nr.u.nr;

import com.bytedance.sdk.component.fx.nr.bg;
import com.bytedance.sdk.component.fx.nr.ja;
import com.bytedance.sdk.component.fx.nr.my;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class iz {
    private final my b;
    private final com.bytedance.sdk.component.fx.nr.pn fx;
    private int iz;
    private final b nr;
    private final com.bytedance.sdk.component.fx.nr.u u;
    private List<Proxy> pn = Collections.emptyList();
    private List<InetSocketAddress> x = Collections.emptyList();
    private final List<ja> n = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        private int nr = 0;
        private final List<ja> u;

        public u(List<ja> list) {
            this.u = list;
        }

        public List<ja> fx() {
            return new ArrayList(this.u);
        }

        public ja nr() {
            if (!u()) {
                throw new NoSuchElementException();
            }
            List<ja> list = this.u;
            int i = this.nr;
            this.nr = i + 1;
            return list.get(i);
        }

        public boolean u() {
            return this.nr < this.u.size();
        }
    }

    public iz(com.bytedance.sdk.component.fx.nr.u uVar, b bVar, com.bytedance.sdk.component.fx.nr.pn pnVar, my myVar) throws IOException {
        this.u = uVar;
        this.nr = bVar;
        this.fx = pnVar;
        this.b = myVar;
        u(uVar.u(), uVar.n());
    }

    private Proxy b() throws IOException {
        if (!fx()) {
            throw new SocketException("No route to " + this.u.u().x() + "; exhausted proxy configurations: " + this.pn);
        }
        List<Proxy> list = this.pn;
        int i = this.iz;
        this.iz = i + 1;
        Proxy proxy = list.get(i);
        u(proxy);
        return proxy;
    }

    private boolean fx() {
        return this.iz < this.pn.size();
    }

    public u nr() throws IOException {
        if (!u()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (fx()) {
            Proxy proxyB = b();
            int size = this.x.size();
            for (int i = 0; i < size; i++) {
                ja jaVar = new ja(this.u, proxyB, this.x.get(i));
                if (this.nr.fx(jaVar)) {
                    this.n.add(jaVar);
                } else {
                    arrayList.add(jaVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.n);
            this.n.clear();
        }
        return new u(arrayList);
    }

    public boolean u() {
        return fx() || !this.n.isEmpty();
    }

    public void u(ja jaVar, IOException iOException) {
        if (jaVar.nr().type() != Proxy.Type.DIRECT && this.u.x() != null) {
            this.u.x().connectFailed(this.u.u().nr(), jaVar.nr().address(), iOException);
        }
        this.nr.u(jaVar);
    }

    private void u(bg bgVar, Proxy proxy) throws IOException {
        List<Proxy> listU;
        if (proxy != null) {
            this.pn = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> listSelect = this.u.x().select(bgVar.nr());
                if (listSelect != null && !listSelect.isEmpty()) {
                    listU = com.bytedance.sdk.component.fx.nr.u.fx.u(listSelect);
                } else {
                    listU = com.bytedance.sdk.component.fx.nr.u.fx.u(Proxy.NO_PROXY);
                }
                this.pn = listU;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.iz = 0;
    }

    private void u(Proxy proxy) throws IOException {
        String strX;
        int iN;
        this.x = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress socketAddressAddress = proxy.address();
            if (socketAddressAddress instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                strX = u(inetSocketAddress);
                iN = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
        } else {
            strX = this.u.u().x();
            iN = this.u.u().n();
        }
        if (iN > 0 && iN <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.x.add(InetSocketAddress.createUnresolved(strX, iN));
                return;
            }
            List<InetAddress> listU = this.u.nr().u(strX);
            if (listU.isEmpty()) {
                return;
            }
            int size = listU.size();
            for (int i = 0; i < size; i++) {
                this.x.add(new InetSocketAddress(listU.get(i), iN));
            }
            return;
        }
        throw new SocketException("No route to " + strX + ":" + iN + "; port is out of range");
    }

    public static String u(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
