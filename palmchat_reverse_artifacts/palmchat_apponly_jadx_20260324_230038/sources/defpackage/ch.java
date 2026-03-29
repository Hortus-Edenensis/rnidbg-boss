package defpackage;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.igexin.sdk.PushConsts;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.palmchat.messaging.NetworkStateReceiver;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.EncryptedJsonRequest;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.support.SquareSingleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ch {
    public static ch s;
    public static long t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f1976a;
    public Handler b;
    public q46 f;
    public q46 g;
    public final nv c = new nv(ow5.f19890a);
    public int d = -1;
    public String e = null;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public lo3 l = new lo3(AppContext.getContext(), new a());
    public BroadcastReceiver m = new f();
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: ch$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0031a extends HashMap<String, Object> {
            public C0031a() {
                put("action", "bind_service");
                put("status", "onServiceConnected_status");
                put("detail", "bindCount=" + ch.this.l.d());
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("action", "bind_service");
                put("status", "onServiceDisconnected_status");
                put("detail", "bindCount=" + ch.this.l.d());
            }
        }

        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtil.i("AppStatusManager", 3, new C0031a(), (Throwable) null);
            ch.this.c.i(ch.this.l0(10, 0));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtil.i("AppStatusManager", 3, new b(), (Throwable) null);
            ch.this.l.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements r46 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r46 f1980a;
        public final /* synthetic */ boolean b;

        public b(r46 r46Var, boolean z) {
            this.f1980a = r46Var;
            this.b = z;
        }

        @Override // defpackage.r46
        public void a(q46 q46Var) {
            ch.this.f = q46Var;
            ch.this.d = q46Var.a();
            SquareSingleton.getInstance().setFriendUnReadMsgInfo(q46Var);
            r46 r46Var = this.f1980a;
            if (r46Var != null) {
                r46Var.a(q46Var);
            }
            if (this.b) {
                nv nvVar = ch.this.c;
                ch chVar = ch.this;
                nvVar.i(chVar.l0(17, chVar.d));
                ch.this.t0();
            }
            ch.this.p = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements u46 {
        public c() {
        }

        @Override // defpackage.u46
        public void a(List<Feed> list) {
            StringBuilder sb = new StringBuilder();
            sb.append("onGetUnsendFeeds  size = ");
            sb.append(list == null ? 0 : list.size());
            LogUtil.i("AppStatusManager", sb.toString());
            if (list == null || list.size() <= 0) {
                ch.this.h = 0;
                ch.this.c.i(ch.this.l0(19, 0));
            } else {
                ch.this.h = list.size();
                ch.this.c.i(ch.this.l0(19, 0));
                LogUtil.i("AppStatusManager", "updateMomentUnsend  mMomentUnSendCount = " + ch.this.h);
            }
            ch.this.t0();
            ch.this.r = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {
        public d() {
            put("action", "getSK");
            put("status", "ensureBindService");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                removeMessages(0);
                uq0.a();
                ch.this.b.sendEmptyMessageDelayed(0, 60000L);
                return;
            }
            if (i == 1) {
                removeMessages(1);
                ch.this.c.i(ch.this.l0(6, 0));
                return;
            }
            if (i == 2) {
                removeMessages(2);
                LogUtil.i("AppStatusManager_lag", "createThreadsObserver onChange Imp");
                ch.this.J0(true);
            } else if (i == 3) {
                removeMessages(3);
                LogUtil.i("AppStatusManager_lag", "createContactObserver onChange Imp");
                tn0.i().B(true);
                tn0.i().x();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            (intent != null ? intent.getAction() : "").equals(FrameworkBaseActivity.INTENT_ACTION_KICKOUT);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends ContentObserver {
        public g(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            LogUtil.i("AppStatusManager_lag", "createContactRequestObserver onChange ");
            ch.this.b.sendEmptyMessage(3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends ContentObserver {
        public h(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            LogUtil.i("AppStatusManager_lag", "createThreadsObserver onChange ");
            ch.this.b.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ch.this.J0(true);
            tn0.i().B(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1988a;

        public j(boolean z) {
            this.f1988a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            tn0.i().B(true);
            if (this.f1988a) {
                tn0.i().x();
                ch.this.J0(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements r46 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r46 f1989a;
        public final /* synthetic */ boolean b;

        public k(r46 r46Var, boolean z) {
            this.f1989a = r46Var;
            this.b = z;
        }

        @Override // defpackage.r46
        public void a(q46 q46Var) {
            ch.this.g = q46Var;
            ContactInfoItem contactInfoItemA = dn0.a(q46Var.c());
            if (contactInfoItemA != null) {
                ch.this.e = contactInfoItemA.getIconURL() != null ? contactInfoItemA.getIconURL() : "";
            } else {
                ch.this.e = "";
            }
            r46 r46Var = this.f1989a;
            if (r46Var != null) {
                r46Var.a(q46Var);
            }
            if (this.b) {
                ch.this.c.i(ch.this.l0(18, 0));
            }
            ch.this.q = false;
        }
    }

    public ch() {
        D();
    }

    public static ch s() {
        if (s == null) {
            synchronized (ch.class) {
                if (s == null) {
                    s = new ch();
                }
            }
        }
        return s;
    }

    public int A() {
        if (cx5.b().e() == -1) {
            J0(false);
        }
        return cx5.b().e();
    }

    public void A0(boolean z, boolean z2) {
        this.n = z2;
        int iT = t();
        this.j = iT;
        if (iT == 1) {
            this.o = false;
        }
        if (z) {
            this.c.i(l0(5, iT));
        }
    }

    public int B() {
        int iE = cx5.b().e();
        if (iE == -1) {
            return 0;
        }
        return iE;
    }

    public void B0() {
        this.c.i(l0(8, 0));
    }

    public int C() {
        if (cx5.b().f() == -1) {
            J0(false);
        }
        return cx5.b().f();
    }

    public void C0() {
        if (this.r) {
            return;
        }
        this.r = true;
        sq3.o().w(new c());
    }

    public final void D() {
        HandlerThread handlerThreadA = lg2.a("working_thread_AppStatusManager");
        this.f1976a = handlerThreadA;
        handlerThreadA.start();
        this.b = new e(this.f1976a.getLooper());
        n();
        o0();
        z0(true);
        this.l.c();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(AppContext.getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(mo3.f19280a);
        intentFilter.addAction(mo3.b);
        intentFilter.addAction(mo3.c);
        intentFilter.addAction(mo3.d);
        intentFilter.addAction(mo3.e);
        intentFilter.addAction(mo3.f);
        intentFilter.addAction(mo3.g);
        intentFilter.addAction(EncryptedJsonRequest.JSON_PARSE_ERROR);
        intentFilter.addAction(mo3.h);
        intentFilter.addAction(mo3.i);
        intentFilter.addAction(mo3.j);
        intentFilter.addAction(tq3.i);
        intentFilter.addAction(tq3.j);
        intentFilter.addAction(tq3.k);
        intentFilter.addAction(mo3.k);
        intentFilter.addAction(mo3.n);
        intentFilter.addAction(FrameworkBaseActivity.ACTION_NOTIFY_DIALOG_MESSAGE_RECEIVED);
        intentFilter.addAction(mo3.l);
        intentFilter.addAction(mo3.m);
        localBroadcastManager.registerReceiver(new mo3(), intentFilter);
        try {
            localBroadcastManager.registerReceiver(this.m, new IntentFilter(FrameworkBaseActivity.INTENT_ACTION_KICKOUT));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AppContext.getContext().registerReceiver(new NetworkStateReceiver(), new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }

    public void D0(String str) {
        F0(str, false, null, true);
    }

    public boolean E() {
        return this.n;
    }

    public void E0(String str, boolean z) {
        F0(str, z, null, true);
    }

    public boolean F() {
        return this.o;
    }

    public void F0(String str, boolean z, r46 r46Var, boolean z2) {
        LogUtil.i("Moments", "[updateMomentsNotify] action = " + str);
        if (!str.equals(tq3.j)) {
            if (!str.equals(tq3.i) || this.p) {
                return;
            }
            this.p = true;
            sq3.o().s(new b(r46Var, z2));
            return;
        }
        if (this.q) {
            return;
        }
        this.q = true;
        if (!z) {
            sq3.o().v(new k(r46Var, z2));
            br3.e();
            return;
        }
        q46 q46Var = new q46();
        this.g = q46Var;
        this.e = "";
        if (r46Var != null) {
            r46Var.a(q46Var);
        }
        if (z2) {
            this.c.i(l0(18, 0));
        }
        this.q = false;
    }

    public void G() {
        this.c.i(l0(24, 0));
    }

    public void G0() {
        this.c.i(l0(52, 0));
    }

    public void H() {
        this.c.i(l0(54, 0));
    }

    public void H0() {
        this.c.i(l0(33, 0));
    }

    public void I() {
        this.c.i(l0(27, 0));
    }

    public void I0(int i2, boolean z) {
        this.i = i2;
        if (z) {
            this.c.i(l0(2, i2));
        }
    }

    public void J() {
        this.c.i(l0(30, 0));
    }

    public void J0(boolean z) {
        LogUtil.i("AppStatusManager_lag", "updateThreadsCount start");
        cx5.b().i();
        int iE = cx5.b().e();
        if (z) {
            this.c.i(l0(1, iE));
        }
        t0();
        LogUtil.i("AppStatusManager_lag", "updateThreadsCount end");
    }

    public void K(int i2, ArrayList<ContactInfoItem> arrayList) {
        this.c.i(m0(0, i2, arrayList));
    }

    public void K0(int i2, boolean z) {
        this.k = i2;
        if (z) {
            AppContext.getContext().sendLocalBroadcast(new Intent(FrameworkBaseActivity.INTENT_ACTION_UPDATE_CHECKED));
        }
    }

    public void L() {
        this.c.i(l0(25, 0));
    }

    public void M() {
        this.c.i(l0(35, 0));
    }

    public void N() {
        this.c.i(l0(45, 0));
    }

    public void O() {
        this.c.i(l0(39, 0));
    }

    public void P() {
        LogUtil.i("UnReadStatusSyncManager", "notifyMainTabContactRequestChanged");
        this.c.i(m0(0, tn0.i().e(), tn0.i().f()));
    }

    public void Q(String str) {
        this.c.i(n0(51, str, 0));
    }

    public void R(int i2) {
        this.c.i(l0(28, i2));
    }

    public void S(String str, int i2) {
        this.c.i(n0(21, str, i2));
    }

    public void T(ArrayList<String> arrayList) {
        this.c.i(m0(7, 0, arrayList));
    }

    public void U() {
        this.c.i(l0(47, 0));
    }

    public void V(int i2) {
        this.c.i(l0(49, i2));
    }

    public void W(int i2) {
        this.c.i(l0(11, i2));
    }

    public void X(int i2) {
        this.c.i(l0(34, i2));
    }

    public void Y() {
        this.c.i(l0(47, 0));
    }

    public void Z() {
        this.c.i(l0(26, 0));
    }

    public void a0(String str) {
        this.c.i(n0(55, str, 0));
    }

    public void b0(String str) {
        LogUtil.i("TYPE_DIALOG_PROCESS_MSG_RECEIVED", "notifyReceiveDialogMsg pageIndex = " + str);
        this.c.i(n0(22, str, 0));
        ad1.h().l(str);
    }

    public void c0() {
        LogUtil.i("ACTION_NOTIFY_RECIEVE_AD", "notifyRecieveAd");
        this.c.i(l0(32, 0));
    }

    public void d0() {
        LogUtil.i("ACTION_NOTIFY_RECIEVE_MOMENTS_AD", "notifyRecieveMomentsAd");
        this.c.i(l0(34, 0));
    }

    public void e0() {
        LogUtil.i("ACTION_NOTIFY_RECIEVE_TOKEN", "notifyRecieveToken");
        this.c.i(l0(20, 0));
    }

    public void f0(int i2) {
        this.c.i(l0(23, i2));
    }

    public void g0(int i2) {
        this.c.i(l0(50, i2));
    }

    public void h0() {
        this.c.i(l0(38, 0));
    }

    public void i0(int i2) {
        int i3;
        switch (i2) {
            case 60:
                i3 = 41;
                break;
            case 61:
                i3 = 42;
                break;
            case 62:
                i3 = 43;
                break;
            case 63:
                i3 = 44;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            this.c.i(l0(i3, 0));
        }
    }

    public void j0() {
        this.c.i(l0(4, 0));
    }

    public void k0(boolean z) {
        this.c.i(l0(37, z ? 1 : 0));
    }

    public uk5 l0(int i2, int i3) {
        return new uk5(i2, i3);
    }

    public uk5 m0(int i2, int i3, ArrayList<?> arrayList) {
        return new uk5(i2, i3, arrayList);
    }

    public uk5 n0(int i2, String str, int i3) {
        return new uk5(i2, str, i3);
    }

    public final ContentObserver o() {
        return new g(null);
    }

    public final void o0() {
        AppContext.getContext().getContentResolver().registerContentObserver(vn0.f21483a, true, o());
        AppContext.getContext().getContentResolver().registerContentObserver(dx5.f17178a, true, p());
    }

    public final ContentObserver p() {
        return new h(null);
    }

    public void p0() {
        cx5.b().g();
        tn0.i().y();
        this.i = -1;
        this.k = -1;
        this.j = -1;
        this.d = -1;
        this.e = null;
        this.h = -1;
        this.f = null;
        this.g = null;
    }

    public void q() {
        if (this.l.e() != null || Math.abs(t - ir5.b()) <= 5000) {
            return;
        }
        t = ir5.b();
        this.l.c();
        LogUtil.i("AppStatusManager", 3, new d(), (Throwable) null);
    }

    public void q0(Runnable runnable, long j2) {
        this.b.postDelayed(runnable, j2);
    }

    public nv r() {
        return this.c;
    }

    public void r0() {
        this.o = true;
    }

    public void s0() {
        this.c.i(l0(31, 0));
    }

    public int t() {
        if (u() != null) {
            try {
                this.j = u().isConnected() ? 1 : 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            this.j = 0;
        }
        return this.j;
    }

    public void t0() {
        int iA = br3.a();
        int iE = cx5.b().e();
        if (iE != -1) {
            com.zenmen.palmchat.utils.a.E().F0(AppContext.getContext(), null, iE + w() + v() + tn0.i().s() + iA);
        }
    }

    public fn2 u() {
        return this.l.e();
    }

    public void u0(String str) {
        this.c.i(n0(40, str, 0));
    }

    public int v() {
        int i2 = this.h;
        if (i2 != -1) {
            return i2;
        }
        C0();
        return 0;
    }

    public void v0(boolean z) {
        this.b.post(new j(z));
    }

    public int w() {
        int i2 = this.d;
        if (i2 == -1) {
            D0(tq3.i);
            return 0;
        }
        if (i2 > 999) {
            return 999;
        }
        return i2;
    }

    public void w0(HashMap<String, Boolean> map) {
        if (!MainTabsActivity.y2().equals("tab_mine") && hu.a() && !map.get(DynamicConfig.Type.BONUSTASK.value).booleanValue()) {
            nx3.f("key_tab_mine", true);
        }
        this.c.i(l0(16, 0));
        this.b.post(new i());
    }

    public String x() {
        if (this.e == null) {
            D0(tq3.j);
        }
        return this.e;
    }

    public void x0() {
        this.c.i(l0(9, 0));
    }

    public int y() {
        boolean zM = hx3.m(AppContext.getContext());
        this.i = zM ? 1 : 0;
        return zM ? 1 : 0;
    }

    public void y0(long j2, boolean z) {
        r75.q(AppContext.getContext(), k86.a("last_get_nearby_time"), j2);
        if (z) {
            this.c.i(l0(6, 0));
            this.b.sendEmptyMessageDelayed(1, 21600000L);
        }
    }

    public int z() {
        if (cx5.b().d() == -1) {
            J0(false);
        }
        return cx5.b().d();
    }

    public void z0(boolean z) {
        long jH = r75.h(AppContext.getContext(), k86.a("last_get_nearby_time"));
        if (z) {
            this.b.removeMessages(1);
            this.b.sendEmptyMessageDelayed(1, System.currentTimeMillis() - jH);
        }
    }

    public void n() {
    }
}
