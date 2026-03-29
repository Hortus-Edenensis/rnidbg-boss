package defpackage;

import android.util.Log;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ib1 extends g13 {
    public static String p = "DetectServerAvailable";
    public static boolean q = true;
    public static ib1 r;
    public DatagramSocket n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18141a = ErrorCode.REASON_RD_VIDEO;
    public int b = 20000;
    public int c = 60000;
    public final int d = 10;
    public int e = 3;
    public int f = 30000;
    public String g = null;
    public int h = -1;
    public String i = null;
    public int j = -1;
    public boolean k = true;
    public Thread l = null;
    public Map<String, List<Integer>> m = new HashMap();
    public boolean o = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = ib1.this.e;
            while (ib1.this.E()) {
                try {
                    if (ib1.this.j <= 0 || ib1.this.i == null) {
                        i = ib1.this.e;
                        if (!ib1.this.w()) {
                            ib1.this.K();
                        }
                        ib1.this.M(2000);
                    } else {
                        boolean z = false;
                        ib1.this.o = false;
                        LogUtil.i(ib1.p, "Server is detecting, try (" + i + '/' + ib1.this.e + ')');
                        ib1.this.z();
                        ib1 ib1Var = ib1.this;
                        ib1Var.L(ib1Var.b, 500);
                        if (ib1.this.E()) {
                            if (ib1.this.o) {
                                Log.i(ib1.p, "Server is available, wait for next detecting");
                                if (!ib1.this.i.equals(ib1.this.g) || ib1.this.j != ib1.this.h) {
                                    ib1 ib1Var2 = ib1.this;
                                    ib1Var2.g = ib1Var2.i;
                                    ib1 ib1Var3 = ib1.this;
                                    ib1Var3.h = ib1Var3.j;
                                    z = true;
                                }
                                if (z) {
                                    yf5.A().G();
                                }
                                i = ib1.this.e;
                                ib1 ib1Var4 = ib1.this;
                                ib1Var4.M(ib1Var4.f18141a);
                            } else {
                                i--;
                                if (i > 0) {
                                    ib1 ib1Var5 = ib1.this;
                                    ib1Var5.M(ib1Var5.f);
                                    if (RTCParameters.k() != "release") {
                                        Log.i(ib1.p, "Server is not available:(" + ib1.this.i + ":" + ib1.this.j + ")");
                                    }
                                } else {
                                    ib1 ib1Var6 = ib1.this;
                                    ib1Var6.M(ib1Var6.c);
                                    Log.i(ib1.p, "Server is not available, change another one");
                                    ib1.this.j = -1;
                                    ib1.this.i = null;
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                    ib1.this.j = -1;
                    ib1.this.i = null;
                }
            }
            ib1.this.B();
            Log.i(ib1.p, "startDetecting thread is stopped");
        }
    }

    public static ib1 D() {
        if (!q) {
            return null;
        }
        if (r == null) {
            synchronized (ib1.class) {
                if (r == null) {
                    r = new ib1();
                }
            }
        }
        return r;
    }

    public final void A(byte[] bArr) {
        H(this.i, this.j, bArr);
    }

    public void B() {
        try {
            DatagramSocket datagramSocket = this.n;
            if (datagramSocket != null) {
                if (!datagramSocket.isClosed()) {
                    this.n.close();
                }
                this.n.disconnect();
                this.n = null;
            }
        } catch (Exception unused) {
        }
    }

    public DatagramSocket C() {
        try {
            if (this.n == null) {
                this.n = new DatagramSocket();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.n;
    }

    public final boolean E() {
        boolean z;
        synchronized (r) {
            z = this.k;
        }
        return z;
    }

    public void F(byte[] bArr) {
        H(this.g, this.h, bArr);
    }

    public byte[] G() {
        if (C() == null) {
            return null;
        }
        DatagramPacket datagramPacket = new DatagramPacket(new byte[2048], 2048);
        try {
            C().setSoTimeout(1000);
            C().receive(datagramPacket);
            if (datagramPacket.getLength() > 0 && datagramPacket.getAddress() != null && datagramPacket.getPort() > 0 && datagramPacket.getData() != null && datagramPacket.getLength() > 0) {
                byte[] bArr = new byte[datagramPacket.getLength()];
                System.arraycopy(datagramPacket.getData(), 0, bArr, 0, datagramPacket.getLength());
                if (!Arrays.equals(bArr, RTCParameters.b())) {
                    return bArr;
                }
                this.o = true;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void H(String str, int i, byte[] bArr) {
        try {
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByName(str), i);
            if (C() != null) {
                C().send(datagramPacket);
            }
        } catch (Exception unused) {
        }
    }

    public final void I(boolean z) {
        synchronized (r) {
            this.k = z;
        }
    }

    public final void J() {
        g13 g13Var = new g13(new a());
        this.l = g13Var;
        g13Var.start();
    }

    public final boolean K() {
        if (com.zenmen.media.common.a.f11946a) {
            Log.i(p, "updateServerInfo");
        }
        this.g = null;
        this.h = -1;
        this.i = null;
        this.j = -1;
        if (this.m == null) {
            this.m = new HashMap();
        }
        this.m.clear();
        Map<String, List<Integer>> mapB = com.zenmen.media.common.a.b();
        if (mapB == null) {
            return false;
        }
        this.m.putAll(mapB);
        return true;
    }

    public final boolean L(int i, int i2) {
        while (E() && !this.o) {
            M(i2);
            i -= i2;
            if (i <= 0) {
                break;
            }
        }
        return this.o;
    }

    public final void M(int i) {
        try {
            synchronized (r) {
                r.wait(i);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        r6.i = r4.getKey();
        r1 = r4.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        if (r1 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if (r1.size() <= 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r2 = (int) (java.lang.Math.random() * ((double) r1.size()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        if (r2 < 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        if (r2 <= r1.size()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        r6.j = r1.get(r2).intValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean w() {
        try {
            if (this.m.size() > 0) {
                this.m.remove(this.i);
            }
            if (this.m.size() == 0) {
                return false;
            }
            int iRandom = (int) (Math.random() * ((double) this.m.size()));
            Iterator<Map.Entry<String, List<Integer>>> it = this.m.entrySet().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, List<Integer>> next = it.next();
                int i2 = i + 1;
                if (i == iRandom) {
                    break;
                }
                i = i2;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void x() {
        if (com.zenmen.media.common.a.f11946a) {
            this.f18141a = 10000;
            this.b = 5000;
            this.f = 5000;
            this.c = 10000;
        }
        J();
    }

    public void y() {
        I(false);
        Thread thread = this.l;
        if (thread != null) {
            thread.interrupt();
        }
        synchronized (r) {
            r.notify();
        }
    }

    public final void z() {
        try {
            byte[] bArrB = RTCParameters.b();
            if (bArrB != null) {
                int i = 10;
                while (i > 0 && E() && !this.o) {
                    if (RTCParameters.k() != "release") {
                        Log.i(p, "detecting(" + i + "): " + this.i + ":" + this.j + " " + C());
                    }
                    A(bArrB);
                    i--;
                    Thread.sleep(200L);
                }
            }
            Thread.sleep(100L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
