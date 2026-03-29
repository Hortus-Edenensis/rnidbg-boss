package defpackage;

import android.util.Log;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.yf5;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.jivesoftware.smack.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class z36 {
    public static final String b = "z36";
    public static DatagramSocket c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22339a = false;

    public static z36 a() {
        return new z36();
    }

    public static DatagramSocket c() {
        if (ib1.D() != null) {
            return ib1.D().C();
        }
        try {
            if (c == null) {
                c = new DatagramSocket();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public final void b() {
        DatagramSocket datagramSocket;
        if (ib1.D() != null) {
            ib1.D().B();
            return;
        }
        synchronized (c) {
            try {
                datagramSocket = c;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (datagramSocket == null) {
                c = null;
            } else {
                if (!datagramSocket.isClosed()) {
                    c.close();
                }
                c.disconnect();
                c = null;
            }
        }
    }

    public void d(String str) {
        e(yf5.e.c(), yf5.e.d(), str);
    }

    public final String e(String str, int i, String str2) {
        String str3 = b;
        LogUtil.i(str3, "sendServer: " + str2);
        try {
            byte[] bArrDecode = Base64.decode(str2);
            if (ib1.D() != null) {
                ib1.D().F(bArrDecode);
            } else {
                DatagramPacket datagramPacket = new DatagramPacket(bArrDecode, bArrDecode.length, InetAddress.getByName(str), i);
                Log.i(str3, "send data: " + str2);
                c().send(datagramPacket);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            b();
            return "";
        }
    }

    public void f() {
        this.f22339a = true;
        b();
    }
}
