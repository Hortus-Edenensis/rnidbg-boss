package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.zenmen.palmchat.Vo.SyncKeys;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class iq5 {
    public static final String d = "iq5";
    public static volatile iq5 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f18237a;
    public Handler b;
    public long c = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = (b) message.obj;
            int i = message.what;
            if (i == 0) {
                LogUtil.i(iq5.d, "HANDLER_MESSAGE_START start");
                String[] strArr = bVar.f18239a;
                if (strArr == null || strArr.length == 0) {
                    removeMessages(0);
                    removeMessages(1);
                }
                eq5.r(bVar.b, bVar.f18239a);
                LogUtil.i(iq5.d, "HANDLER_MESSAGE_START end");
                return;
            }
            if (i != 1) {
                return;
            }
            LogUtil.i(iq5.d, "HANDLER_MESSAGE_MESSAGE_CONTINUE start");
            removeMessages(1);
            iq5.this.c = -1L;
            long jLongValue = ((Long) eq5.r(bVar.b, bVar.f18239a).second).longValue();
            LogUtil.i(iq5.d, "HANDLER_MESSAGE_MESSAGE_CONTINUE end syncMsgVersion =" + jLongValue + " currentContinuousSyncVersion=" + iq5.this.c);
            if (jLongValue >= iq5.this.c) {
                removeMessages(1);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f18239a;
        public boolean b;

        public b(String[] strArr, boolean z) {
            this.f18239a = strArr;
            this.b = z;
        }
    }

    public iq5() {
        e();
    }

    public static iq5 d() {
        if (e == null) {
            synchronized (iq5.class) {
                if (e == null) {
                    e = new iq5();
                }
            }
        }
        return e;
    }

    public static boolean i(boolean z, boolean z2, String... strArr) {
        fn2 fn2VarU = ch.s().u();
        SyncKeys syncKeys = null;
        if (fn2VarU == null) {
            ch.s().q();
            LogUtil.log4ClientError("syncOnMainProcess_UNBIND", null);
            d().h(z, z2, -1L, strArr);
            return false;
        }
        if (strArr != null) {
            syncKeys = new SyncKeys();
            syncKeys.keys = strArr;
        }
        try {
            return fn2VarU.k(z, z2, syncKeys);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean j(boolean z, String... strArr) {
        return i(true, z, strArr);
    }

    public final void e() {
        HandlerThread handlerThreadA = lg2.a("SyncOperator_working_thread");
        this.f18237a = handlerThreadA;
        handlerThreadA.start();
        this.b = new a(this.f18237a.getLooper());
    }

    public void f(boolean z, boolean z2, String... strArr) {
        h(z, z2, -1L, strArr);
    }

    public void g(boolean z, String... strArr) {
        f(true, z, strArr);
    }

    public boolean h(boolean z, boolean z2, long j, String... strArr) {
        LogUtil.i(d, "startOperation isContinuous=" + z + " msgVersion=" + j);
        if (z2) {
            return ((Boolean) eq5.r(z, strArr).first).booleanValue();
        }
        if (z) {
            Handler handler = this.b;
            handler.sendMessage(handler.obtainMessage(0, new b(strArr, z)));
        } else {
            this.c = j;
            Handler handler2 = this.b;
            handler2.sendMessage(handler2.obtainMessage(1, new b(strArr, z)));
        }
        return true;
    }
}
