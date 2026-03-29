package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.lantern.auth.stub.WkSDKFeature;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class tt5 {
    public static volatile tt5 p;
    public static final Object q = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ix3 f21066a;
    public int b;
    public int c;
    public long f;
    public boolean g;
    public Context i;
    public int d = 0;
    public int e = 0;
    public boolean j = false;
    public final AtomicBoolean k = new AtomicBoolean(false);
    public gt5 l = new a();
    public boolean m = false;
    public int n = 0;
    public int o = 0;
    public boolean h = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends gt5 {
        public a() {
        }

        @Override // defpackage.gt5
        public void a(Message message) {
            if (message != null) {
                int i = message.what;
                if (i == 1011) {
                    tt5 tt5Var = tt5.this;
                    tt5Var.r(tt5Var.i, "tcp_a14", null);
                }
                if (i == 1022) {
                    tt5 tt5Var2 = tt5.this;
                    tt5Var2.r(tt5Var2.i, "tcp_a17", null);
                    return;
                }
                if (i == 2000) {
                    e66.b().c(tt5.this.i);
                    return;
                }
                switch (i) {
                    case 1004:
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("force", true);
                        tt5 tt5Var3 = tt5.this;
                        tt5Var3.r(tt5Var3.i, "tcp_a16", bundle);
                        break;
                    case 1005:
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("force", false);
                        tt5 tt5Var4 = tt5.this;
                        tt5Var4.r(tt5Var4.i, "tcp_a16", bundle2);
                        break;
                    case 1006:
                    case 1007:
                        tt5 tt5Var5 = tt5.this;
                        tt5Var5.r(tt5Var5.i, "tcp_a2", null);
                        break;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends xw2 {
        public Context c;
        public String d;
        public Bundle e;

        public b(Context context, String str, Bundle bundle) {
            this.c = context;
            this.d = str;
            this.e = bundle;
            this.f22065a = "TcpManager";
        }

        @Override // defpackage.xw2
        public void a() {
            long j;
            try {
                if (this.d.equals("tcp_a1")) {
                    if (tt5.this.f21066a == null) {
                        tt5.this.L();
                        return;
                    }
                    return;
                }
                if (!this.d.equals("tcp_a3") && !this.d.equals("tcp_a4") && !this.d.equals("tcp_a20")) {
                    if (this.d.equals("tcp_a5")) {
                        Bundle bundle = this.e;
                        if (bundle != null) {
                            byte[] byteArray = bundle.getByteArray("body");
                            int i = this.e.getInt("cmd", -1);
                            int i2 = this.e.getInt("ver", -1);
                            long j2 = this.e.getLong("rid", -1L);
                            String string = this.e.getString("sdk_type");
                            long j3 = this.e.getLong(WkAdConfigModel.TAG_TIMEOUT);
                            k63.a("JCoreTCPManager", "send quest,cmd:" + i + ",ver:" + i2 + ",rid:" + j2 + ",body size:" + byteArray.length);
                            if (i >= 0 && i2 >= 0 && j2 >= 0 && !TextUtils.isEmpty(string)) {
                                wt5.c().i(this.c, j2, i, i2, byteArray, string, j3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (this.d.equals("tcp_a19")) {
                        tt5.this.F();
                        return;
                    }
                    if (this.d.equals("tcp_a11")) {
                        k63.b("JCoreTCPManager", "resgiter success:" + fv2.k(this.c));
                        ad.b(this.c);
                        zd1 zd1VarE = zd1.e();
                        Context context = this.c;
                        zd1VarE.b(context, 0, 0, fv2.k(context));
                        qv2.a(this.c, "on_register", null);
                        return;
                    }
                    if (this.d.equals("tcp_a10")) {
                        tt5.this.I();
                        return;
                    }
                    if (this.d.equals("tcp_a9")) {
                        tt5.this.y(this.c);
                        return;
                    }
                    if (this.d.equals("tcp_a8")) {
                        tt5.this.z(this.c);
                        return;
                    }
                    if (this.d.equals("tcp_a2")) {
                        ng4.c().g(this.c, false);
                        tt5.this.N(this.e);
                        return;
                    }
                    if (this.d.equals("tcp_a13")) {
                        k63.b("JCoreTCPManager", "resgiter failed");
                        Bundle bundle2 = this.e;
                        if (bundle2 != null) {
                            int i3 = bundle2.getInt("resCode", 0);
                            tt5.this.c = i3;
                            jm0.h(this.c, i3);
                            return;
                        }
                        return;
                    }
                    if (this.d.equals("tcp_a12")) {
                        k63.b("JCoreTCPManager", "login failed");
                        Bundle bundle3 = this.e;
                        if (bundle3 != null) {
                            tt5.this.J(bundle3.getInt("resCode", 0));
                            return;
                        }
                        return;
                    }
                    if (this.d.equals("tcp_a14")) {
                        tt5.this.L();
                        return;
                    }
                    if (this.d.equals("tcp_a15")) {
                        tt5.this.E(this.e);
                        return;
                    }
                    if (this.d.equals("tcp_a16")) {
                        tt5.this.O(this.e);
                        return;
                    }
                    if (this.d.equals("tcp_a17")) {
                        tt5.this.H();
                        return;
                    }
                    if (this.d.equals("tcp_a18")) {
                        tt5.this.G();
                        return;
                    }
                    if (this.d.equals("tcp_a6")) {
                        Bundle bundle4 = this.e;
                        if (bundle4 != null) {
                            long j4 = bundle4.getLong("rid", -1L);
                            if (j4 > 0) {
                                wt5.c().f(this.c, j4);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (this.d.equals("tcp_a7")) {
                        Bundle bundle5 = this.e;
                        if (bundle5 != null) {
                            long j5 = bundle5.getLong("rid", -1L);
                            if (j5 > 0) {
                                wt5.c().d(this.c, j5);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (this.d.equals("tcp_a21")) {
                        tt5.this.D();
                        return;
                    }
                    if (this.d.equals("tcp_a22")) {
                        tt5.this.S();
                        return;
                    }
                    if (this.d.equals("tcp_a23")) {
                        tt5.this.A(this.c);
                        return;
                    } else {
                        if (this.d.equals("tcp_a24")) {
                            tt5.this.q();
                            tt5.this.c = 0;
                            tt5.this.b = 0;
                            tt5.this.L();
                            return;
                        }
                        return;
                    }
                }
                if (tt5.this.f21066a == null) {
                    k63.a("JCoreTCPManager", "send data failed:tcp breaked,will restart");
                    tt5.this.L();
                    return;
                }
                if (tt5.this.f21066a.c() != null) {
                    byte[] byteArray2 = this.e.getByteArray("body");
                    int i4 = this.e.getInt("cmd", -1);
                    int i5 = this.e.getInt("ver", -1);
                    long j6 = this.e.getLong("rid", -1L);
                    String string2 = this.e.getString("sdk_type");
                    k63.a("JCoreTCPManager", "send data,cmd:" + i4 + ",ver:" + i5 + ",rid:" + j6 + ",body size:" + byteArray2.length);
                    if (i4 >= 0 && i5 >= 0 && j6 >= 0) {
                        if (this.d.equals("tcp_a3")) {
                            wt5.c().h(this.c, j6, i4, i5, byteArray2, string2);
                            return;
                        }
                        if (this.d.equals("tcp_a20")) {
                            long j7 = this.e.getLong(DeviceInfoUtil.UID_TAG, 0L);
                            if (j7 == 0) {
                                k63.l("JCoreTCPManager", "share response uid is 0");
                                return;
                            }
                            j = j7;
                        } else {
                            j = 0;
                        }
                        tt5.u().w().c().h(cw2.k(this.c, i4, i5, j6, byteArray2, j));
                    }
                }
            } catch (Throwable th) {
                k63.n("JCoreTCPManager", "tcp action failed:" + th.getMessage());
            }
        }
    }

    public static tt5 u() {
        if (p == null) {
            synchronized (q) {
                if (p == null) {
                    p = new tt5();
                }
            }
        }
        return p;
    }

    public final void A(Context context) {
        k63.a("JCoreTCPManager", "handleUnRegister...");
        if (!((Boolean) lg5.c(context, zz2.C())).booleanValue()) {
            k63.b("JCoreTCPManager", "tcp already stoped");
        } else if (!zd1.e().p(0)) {
            k63.a("JCoreTCPManager", "Action: handleUnRegister - can't stop tcp");
        } else {
            lg5.h(context, zz2.C().a0(Boolean.FALSE));
            q();
        }
    }

    public synchronized void B(Context context) {
        if (this.j) {
            return;
        }
        if (context == null) {
            k63.a("JCoreTCPManager", "init context is null");
            return;
        }
        k63.a("JCoreTCPManager", "init tcp manager...");
        this.i = context.getApplicationContext();
        bw2.h("JCoreTCPManager");
        nt5.b().d(this.i);
        ng4.c().g(context, true);
        this.j = true;
    }

    public boolean C() {
        return this.g;
    }

    public final boolean D() {
        if (gv2.a().b(this.i) || e66.b().d(this.i)) {
            return true;
        }
        k63.a("JCoreTCPManager", "not keep tcp");
        this.h = false;
        q();
        return false;
    }

    public void E(Bundle bundle) {
        if (((Boolean) lg5.c(this.i, zz2.k())).booleanValue()) {
            k63.l("JCoreTCPManager", "[netWorkChanged] tcp has close by active");
            return;
        }
        nt5.b().f(1006);
        nt5.b().f(1007);
        if (!bundle.getBoolean(x.bq, false)) {
            k63.a("JCoreTCPManager", "Handle disconnected state.");
            nt5.b().g(1007, 3000L, this.l);
            return;
        }
        k63.a("JCoreTCPManager", "Handle connected state.");
        if (this.f21066a == null) {
            L();
        } else {
            nt5.b().g(1006, 3000L, this.l);
        }
    }

    public final void F() {
        k63.b("JCoreTCPManager", "Action - onDisconnected");
        if (this.g) {
            this.g = false;
            zd1.e().b(this.i, -1, -1, "push connect break");
        }
        if (this.f21066a == null && ((Boolean) lg5.c(this.i, zz2.k())).booleanValue()) {
            k63.a("JCoreTCPManager", "push already stopped!!!");
            return;
        }
        this.e = 0;
        q();
        M();
        this.d++;
    }

    public final void G() {
        k63.b("JCoreTCPManager", "Action - onHeartbeatSucceed");
        zd1.e().b(this.i, 19, 0, "ack success");
    }

    public final void H() {
        this.k.set(false);
        this.e++;
        k63.b("JCoreTCPManager", "Action - onHeartbeatTimeout - timeoutTimes:" + this.e);
        k63.k("JCoreTCPManager", "============================================================");
        if (this.f21066a != null && !this.g) {
            k63.b("JCoreTCPManager", "Is connecting now. Give up to retry.");
            return;
        }
        if (!this.g || this.e > 1) {
            q();
            M();
        } else {
            k63.b("JCoreTCPManager", "Already logged in. Give up to retry.");
            nt5.b().g(1005, 5000L, this.l);
        }
    }

    public final void I() {
        k63.b("JCoreTCPManager", "Action - onLoggedIn");
        if (!this.g) {
            this.g = true;
            zd1.e().b(this.i, 1, 0, "success");
        }
        S();
        this.d = 0;
        this.e = 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean(WkSDKFeature.WHAT_LOGIN, true);
        qv2.a(this.i, "periodtask", bundle);
        if (D()) {
            nt5.b().g(2000, 2000L, this.l);
            o75.m().x(this.i);
            wt5.c().g(this.i);
            ng4.c().g(this.i, true);
        }
    }

    public final void J(int i) {
        this.b = i;
        if (i == 1012) {
            jm0.b(this.i);
        }
        q();
    }

    public void K() {
        this.o = 0;
        ng4.c().f();
    }

    public final synchronized void L() {
        k63.b("JCoreTCPManager", "Action - restartNetworkingClient, pid:" + Process.myPid());
        if (!this.h) {
            k63.h("JCoreTCPManager", "need not keep tcp,next start app will re login");
            return;
        }
        if (!ad.w(this.i.getApplicationContext())) {
            k63.h("JCoreTCPManager", "No network connection. Give up to start connection thread.");
            return;
        }
        if (((Boolean) lg5.c(this.i, zz2.k())).booleanValue()) {
            k63.b("JCoreTCPManager", "[restartNetworkingClient] tcp has close by active");
            return;
        }
        if (!((Boolean) lg5.c(this.i, zz2.C())).booleanValue()) {
            k63.b("JCoreTCPManager", "[restartNetworkingClient] tcp has close by ups.unregister");
            return;
        }
        int i = this.c;
        if (i != 1005 && i != 1006 && i != 1008 && i != 1009) {
            if (this.b == 102) {
                k63.n("JCoreTCPManager", "login failed:102,give up start connection thread.reset from next app start");
                return;
            } else {
                if (this.f21066a != null) {
                    k63.b("JCoreTCPManager", "NetworkingClient is running");
                    return;
                }
                ix3 ix3Var = new ix3(this.i.getApplicationContext());
                this.f21066a = ix3Var;
                ix3Var.j();
                return;
            }
        }
        k63.a("JCoreTCPManager", "[restartNetworkingClient] registerErrCode >0,registerErrCode:" + this.c);
        zd1.e().b(this.i, 2002, this.c, "");
    }

    public final void M() {
        k63.b("JCoreTCPManager", "Action - retryConnect - disconnectedTimes:" + this.d);
        if (!ad.w(this.i.getApplicationContext())) {
            k63.a("JCoreTCPManager", "[retryConnect] network is not connect");
            return;
        }
        if (this.c > 0) {
            k63.a("JCoreTCPManager", "[retryConnect] registerErrCode >0,registerErrCode:" + this.c);
            return;
        }
        int iD = ad.d(this.i.getApplicationContext());
        int iPow = (int) (Math.pow(2.0d, this.d) * 3.0d * 1000.0d);
        int iT = t();
        int i = (iT * 1000) / 2;
        if (iPow > i) {
            iPow = i;
        }
        k63.a("JCoreTCPManager", "[retryConnect] mDisconnectedTimes:" + this.d + ",chargedLever:" + iD + ",heartbeatInterval:" + iT + ",delayTime:" + iPow);
        if (iD != 1 ? this.d >= 5 : this.d >= 30) {
            k63.a("JCoreTCPManager", "Give up to retry connect.");
        } else if (nt5.b().c(1011)) {
            k63.a("JCoreTCPManager", "Already has MSG_RESTART_CONN");
        } else {
            nt5.b().g(1011, iPow, this.l);
        }
    }

    public void N(Bundle bundle) {
        long j;
        if (((Boolean) lg5.c(this.i, zz2.k())).booleanValue()) {
            k63.b("JCoreTCPManager", "[rtc] tcp has close by active");
            return;
        }
        boolean z = true;
        if (bundle != null) {
            z = bundle.getBoolean("force", true);
            j = bundle.getLong("delay_time", 0L);
        } else {
            j = 0;
        }
        if (this.f21066a == null) {
            L();
            return;
        }
        if (j <= 0) {
            O(bundle);
        } else {
            if (z) {
                nt5.b().f(1005);
                nt5.b().f(1004);
            }
            nt5.b().g(z ? 1004 : 1005, j, this.l);
        }
        k63.g("JCoreTCPManager", "send rtc force=" + z + " delay=" + j);
    }

    public final void O(Bundle bundle) {
        if (this.k.get()) {
            k63.a("JCoreTCPManager", "isBeating, skip this time");
            return;
        }
        if (!(bundle != null ? bundle.getBoolean("force", false) : false) && Q()) {
            k63.a("JCoreTCPManager", "No need to rtc, Because it have succeed recently");
            return;
        }
        k63.b("JCoreTCPManager", "Send heart beat");
        nt5.b().f(1005);
        if (this.g) {
            P();
        } else {
            k63.a("JCoreTCPManager", "socket is closed or push isn't login");
        }
    }

    public final void P() {
        this.k.set(true);
        nt5.b().f(1022);
        Long lValueOf = Long.valueOf(jm0.l(this.i));
        long jN = fv2.n(this.i);
        boolean z = bw2.f1842a;
        k63.a("JCoreTCPManager", "heartbeat - juid:" + jN + ", flag:1 ,userType:" + (z ? 1 : 0));
        byte[] bArrC = cw2.c(this.i, cw2.g(lValueOf.longValue(), tv2.l, jN, (short) 1, z ? 1 : 0));
        if (bArrC != null) {
            this.f21066a.c().h(bArrC);
        } else {
            k63.n("JCoreTCPManager", "send hb failed:sendData is null");
        }
        nt5.b().g(1022, 10000L, this.l);
    }

    public final boolean Q() {
        return this.n > 0 ? System.currentTimeMillis() - this.f < ((long) (this.n + (-4))) * 1000 : System.currentTimeMillis() - this.f < 18000;
    }

    public void R() {
        k63.a("JCoreTCPManager", "updateHeartBeatInterval  -- current HeartBeatInterval = " + this.o);
        int i = this.n;
        if (i > 0) {
            int i2 = this.o;
            if (i2 == 0) {
                this.o = i * 2;
                return;
            }
            int i3 = i2 * 2;
            int i4 = tv2.i;
            if (i3 < i4 / 2) {
                this.o = i2 * 2;
            } else {
                this.o = i4;
            }
        }
    }

    public void S() {
        nt5.b().f(1022);
        this.f = System.currentTimeMillis();
        this.e = 0;
        this.k.set(false);
        k63.g("JCoreTCPManager", "update rtc state");
    }

    public final void q() {
        ix3 ix3Var = this.f21066a;
        if (ix3Var == null) {
            k63.a("JCoreTCPManager", "tcp has stopeed");
        } else {
            ix3Var.k();
            this.f21066a = null;
        }
    }

    public void r(Context context, String str, Bundle bundle) {
        B(context);
        bw2.g(new b(context, str, bundle), new int[0]);
    }

    public int s() {
        k63.a("JCoreTCPManager", "getAlarmDelay  -- current HeartBeatInterval = " + this.o);
        int i = this.n;
        if (i <= 0) {
            return tv2.j;
        }
        int i2 = this.o;
        return i2 == 0 ? i + 5 : i2 + 5;
    }

    public int t() {
        k63.a("JCoreTCPManager", "getHeartBeatInterval  -- current HeartBeatInterval = " + this.o);
        int i = this.n;
        if (i <= 0) {
            return tv2.i;
        }
        int i2 = this.o;
        return i2 == 0 ? i : i2;
    }

    public int v() {
        k63.a("JCoreTCPManager", "getNextHbIntervalForLog  -- current HeartBeatInterval = " + this.o);
        int i = this.n;
        if (i <= 0) {
            return tv2.i;
        }
        int i2 = this.o;
        if (i2 == 0) {
            int i3 = i * 2;
            int i4 = tv2.i;
            return i3 < i4 / 2 ? i * 2 : i4;
        }
        int i5 = i2 * 2;
        int i6 = tv2.i;
        return i5 < i6 / 2 ? i2 * 2 : i6;
    }

    public ix3 w() {
        return this.f21066a;
    }

    public void x(byte[] bArr) {
        JSONObject jSONObjectOptJSONObject;
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.getLong();
            byte[] bArr2 = new byte[byteBufferWrap.getShort()];
            byteBufferWrap.get(bArr2);
            String str = new String(bArr2, "UTF-8");
            k63.a("JCoreTCPManager", "handleCtrlHeartBeatCmd cmd content: " + str);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("cmd") != 75 || (jSONObjectOptJSONObject = jSONObject.optJSONObject("content")) == null) {
                return;
            }
            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("use_ssp");
            this.m = zOptBoolean;
            if (zOptBoolean) {
                int iOptInt = jSONObjectOptJSONObject.optInt("hb_interval");
                if (iOptInt <= 0) {
                    k63.l("JCoreTCPManager", "hb_interval is less than 0, will use 15s");
                    this.n = 15;
                } else if (iOptInt >= tv2.i / 2) {
                    k63.l("JCoreTCPManager", "hb_interval is more than " + tv2.i + ", will use " + tv2.i + "s");
                    String str2 = tv2.f21077a;
                    this.n = 0;
                } else {
                    k63.l("JCoreTCPManager", "set ssp heartbeat interval:" + iOptInt);
                    this.n = iOptInt;
                }
                if (this.n > 0) {
                    K();
                }
            }
        } catch (Throwable th) {
            k63.l("JCoreTCPManager", "[TcpManager] handleCtrlHeartBeatCmd error:" + th);
        }
    }

    public final void y(Context context) {
        k63.a("JCoreTCPManager", "handleResume...");
        lg5.h(context, zz2.k().a0(Boolean.FALSE));
        if (this.g) {
            k63.a("JCoreTCPManager", "[handleResume] is loggedin");
        } else if (this.f21066a != null) {
            k63.a("JCoreTCPManager", "[handleResume] tcp is connecting...");
        } else {
            L();
        }
    }

    public final void z(Context context) {
        k63.a("JCoreTCPManager", "handleStop...");
        if (((Boolean) lg5.c(context, zz2.k())).booleanValue()) {
            k63.b("JCoreTCPManager", "tcp already stoped");
        } else if (!zd1.e().p(0)) {
            k63.a("JCoreTCPManager", "Action: handleStopPush - can't stop tcp");
        } else {
            lg5.h(context, zz2.k().a0(Boolean.TRUE));
            q();
        }
    }
}
