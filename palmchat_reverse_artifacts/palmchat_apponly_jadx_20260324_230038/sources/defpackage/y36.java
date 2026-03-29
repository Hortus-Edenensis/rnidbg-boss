package defpackage;

import android.util.Log;
import com.lantern.auth.app.FunDC;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.yf5;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.jivesoftware.smack.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class y36 {
    public static final String c = "y36";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DatagramSocket f22115a;
    public boolean b = false;

    public static y36 a() {
        return new y36();
    }

    public boolean b() {
        return c(yf5.e.c(), 0);
    }

    public final boolean c(String str, int i) {
        String str2 = c;
        LogUtil.i(str2, "readService");
        this.b = false;
        if (ib1.D() != null) {
            try {
                byte[] bArrG = ib1.D().G();
                if (bArrG != null) {
                    LogUtil.i(str2, "receive data:" + bArrG.toString());
                    yf5.A().B(FunDC.ID_AUTH_1042, Base64.encodeBytes(bArrG, 0, bArrG.length).replace("\n", ""));
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[2048], 2048);
                DatagramSocket datagramSocketC = z36.c();
                this.f22115a = datagramSocketC;
                if (datagramSocketC == null) {
                    return false;
                }
                try {
                    datagramSocketC.setSoTimeout(1000);
                    this.f22115a.receive(datagramPacket);
                    if (datagramPacket.getLength() <= 0) {
                        return false;
                    }
                    String strReplace = Base64.encodeBytes(datagramPacket.getData(), 0, datagramPacket.getLength()).replace("\n", "");
                    InetAddress address = datagramPacket.getAddress();
                    Log.i(str2, "receive data:" + strReplace + " " + address.getHostAddress() + " " + datagramPacket.getPort());
                    if (!address.getHostAddress().endsWith(str)) {
                        return false;
                    }
                    try {
                        yf5.A().B(FunDC.ID_AUTH_1042, strReplace);
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception unused) {
                    return false;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    public void d() {
        this.b = true;
    }
}
