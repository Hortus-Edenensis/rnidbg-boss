package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.HbConfig;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.t5;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class j36 {
    public static j36 e;
    public static long f;
    public static ByteBuffer g = ByteBuffer.allocate(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f18323a;
    public Handler b;
    public DatagramSocket c;
    public boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                j36.this.k();
                boolean zD = HbConfig.a().d();
                long jB = HbConfig.a().b();
                if (!zD || jB <= 0) {
                    return;
                }
                j36.this.b.sendEmptyMessageDelayed(0, jB);
            }
        }
    }

    public j36() {
        boolean zG = nl0.g();
        this.d = zG;
        if (zG) {
            g();
        }
    }

    public static j36 e() {
        if (e == null) {
            synchronized (j36.class) {
                if (e == null) {
                    e = new j36();
                }
            }
        }
        return e;
    }

    public static byte[] h(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] i(long j) {
        g.putLong(0, j);
        return g.array();
    }

    public final byte[] c(long j, int i, String str) {
        byte[] bytes;
        int length;
        byte[] bArrI = i(j);
        byte[] bArrH = h(i);
        if (str != null) {
            length = str.getBytes().length;
            bytes = str.getBytes();
        } else {
            bytes = null;
            length = 0;
        }
        byte[] bArr = new byte[bArrI.length + bArrH.length + length];
        System.arraycopy(bArrI, 0, bArr, 0, bArrI.length);
        System.arraycopy(bArrH, 0, bArr, bArrI.length, bArrH.length);
        if (bytes != null) {
            System.arraycopy(bytes, 0, bArr, bArrI.length + bArrH.length, length);
        }
        return bArr;
    }

    public final DatagramSocket d() {
        if (this.c == null) {
            try {
                this.c = new DatagramSocket();
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
        }
        return this.c;
    }

    public final long f() {
        String strP = AccountUtils.p(AppContext.getContext());
        if (!TextUtils.isEmpty(strP)) {
            try {
                return Long.parseLong(strP);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1L;
    }

    public final void g() {
        HandlerThread handlerThreadA = lg2.a("UDPSender_working_thread");
        this.f18323a = handlerThreadA;
        handlerThreadA.start();
        this.b = new a(this.f18323a.getLooper());
    }

    public final boolean j() {
        t5.b bVarK = t5.k();
        boolean z = false;
        if (bVarK != null) {
            String name = bVarK.e().getName();
            int iF = bVarK.f();
            if ("com.zenmen.palmchat.chat.CustomDialogActivity".equals(name) && !jo6.a("LX-45317", false)) {
                z = true;
            }
            LogUtil.i("UDPSender", "needIgnore" + name + iF);
        }
        return z;
    }

    public final void k() {
        long jB = ir5.b();
        if (Math.abs(f - jB) < HbConfig.a().b() || !HbConfig.a().d() || AppContext.getContext().isBackground() || TextUtils.isEmpty(AccountUtils.p(AppContext.getContext())) || j()) {
            return;
        }
        f = jB;
        DNSNode[] dNSNodeArrI = it0.k().i(new te1(nl0.i.substring(7)).f20971a);
        if (dNSNodeArrI != null) {
            List listAsList = Arrays.asList(dNSNodeArrI);
            Collections.shuffle(listAsList);
            Iterator it = listAsList.iterator();
            while (it.hasNext()) {
                try {
                    l((DNSNode) it.next());
                    return;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    LogUtil.i("UDPSender", "IOException" + e2);
                }
            }
        }
    }

    public final void l(DNSNode dNSNode) throws IOException {
        LogUtil.i("UDPSender", LogUtil.VALUE_SEND + dNSNode.host + dNSNode.port);
        long jF = f();
        int iH = t5.h();
        String strE = t5.e();
        byte[] bArrC = c(jF, iH, strE);
        DatagramPacket datagramPacket = new DatagramPacket(bArrC, bArrC.length, InetAddress.getByName(dNSNode.host), dNSNode.port);
        DatagramSocket datagramSocketD = d();
        if (datagramSocketD != null) {
            datagramSocketD.send(datagramPacket);
            LogUtil.i("UDPSender", "send success  index = " + iH + " extra =" + strE);
        }
    }

    public void m() {
        if (this.d) {
            LogUtil.i("UDPSender", "startNotify");
            this.b.sendEmptyMessageDelayed(0, 1000L);
        }
    }

    public void n() {
        if (this.d) {
            LogUtil.i("UDPSender", "stopNotify");
            this.b.removeMessages(0);
        }
    }
}
