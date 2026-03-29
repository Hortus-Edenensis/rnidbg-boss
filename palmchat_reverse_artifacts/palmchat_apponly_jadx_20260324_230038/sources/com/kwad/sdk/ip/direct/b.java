package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bw;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    private static Handler aWC = new Handler(Looper.getMainLooper());
    static int aWM = 80;
    static int port = 80;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Thread {
        LinkedList aWO = new LinkedList();
        volatile boolean aWP = false;
        Selector aWN = Selector.open();

        public a() {
            setName("Connector");
        }

        private void OC() {
            synchronized (this.aWO) {
                while (this.aWO.size() > 0) {
                    C0626b c0626b = (C0626b) this.aWO.removeFirst();
                    try {
                        c0626b.aWT.register(this.aWN, 8, c0626b);
                    } catch (Throwable th) {
                        c0626b.aWT.close();
                        c0626b.aWU = th;
                    }
                }
            }
        }

        private void OD() {
            Iterator<SelectionKey> it = this.aWN.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0626b c0626b = (C0626b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0626b.aWY = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bw.c(socketChannel);
                    c0626b.aWU = th;
                }
            }
        }

        public final void a(C0626b c0626b) {
            final SocketChannel socketChannelOpen;
            try {
                socketChannelOpen = SocketChannel.open();
                try {
                    socketChannelOpen.configureBlocking(false);
                    boolean zConnect = socketChannelOpen.connect(c0626b.aWS);
                    c0626b.aWT = socketChannelOpen;
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    c0626b.aWX = jElapsedRealtime;
                    if (zConnect) {
                        c0626b.aWY = jElapsedRealtime;
                        bw.c(socketChannelOpen);
                    } else {
                        synchronized (this.aWO) {
                            this.aWO.add(c0626b);
                        }
                        Selector selector = this.aWN;
                        if (selector != null) {
                            try {
                                selector.wakeup();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        bw.c(socketChannelOpen);
                        c0626b.aWU = th;
                        try {
                            b.aWC.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bw.c(socketChannelOpen);
                                }
                            }, c0626b.aWW);
                        } catch (Throwable unused2) {
                        }
                    } finally {
                        try {
                            b.aWC.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    bw.c(socketChannelOpen);
                                }
                            }, c0626b.aWW);
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                socketChannelOpen = null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aWN.select() > 0) {
                        OD();
                    }
                    OC();
                    if (this.aWP) {
                        Selector selector = this.aWN;
                        if (selector != null) {
                            try {
                                selector.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    continue;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public final void shutdown() {
            this.aWP = true;
            Selector selector = this.aWN;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0626b {
        InetSocketAddress aWS;
        SocketChannel aWT;
        Throwable aWU;
        private float aWV;
        long aWW;
        long aWX;
        long aWY = 0;
        boolean aWZ = false;
        private boolean success;

        public C0626b(String str) {
            try {
                this.aWS = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aWU = th;
            }
        }

        public final void OE() {
            String string;
            if (this.aWY != 0) {
                string = Long.toString(this.aWY - this.aWX) + "ms";
                this.aWV = this.aWY - this.aWX;
                this.success = true;
            } else {
                Throwable th = this.aWU;
                if (th != null) {
                    string = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    string = "Timed out";
                }
            }
            com.kwad.sdk.core.d.c.d("IpDirect_Ping", this.aWS + " : " + string);
            this.aWZ = true;
        }
    }

    public static c f(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.d.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList<C0626b> linkedList = new LinkedList();
            for (int i = 0; i < cVar.OF(); i++) {
                C0626b c0626b = new C0626b(str);
                c0626b.aWW = j + j2;
                linkedList.add(c0626b);
                try {
                    aVar.a(c0626b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    aVar.shutdown();
                    aVar.join();
                    boolean z = true;
                    float f = 0.0f;
                    for (C0626b c0626b2 : linkedList) {
                        c0626b2.OE();
                        z &= c0626b2.success;
                        cVar.bN(z);
                        f += c0626b2.aWV;
                    }
                    com.kwad.sdk.core.d.c.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.o(f / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}
