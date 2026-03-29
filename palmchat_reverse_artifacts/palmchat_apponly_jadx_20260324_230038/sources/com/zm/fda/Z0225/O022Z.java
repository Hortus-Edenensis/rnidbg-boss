package com.zm.fda.Z0225;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.zm.fda.O52OZ.O2O5Z;
import com.zm.fda.O52OZ.O52OZ;
import com.zm.fda.Z0225.O022Z;
import com.zm.fda.Z0O00.Z0O00.OO22Z;
import com.zm.fda.Z0O00.Z0O00.Z25O0;
import com.zm.fda.Z0O00.Z0O00.ZZ00Z;
import com.zm.fda.Z200O.ZZ00Z;
import com.zm.fda.busi.IPubParams;
import com.zm.fda.utils.EventLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O022Z {
    public static final String d = "fob_fda";
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 4;
    public static final int j = 5;
    public static final int k = 6;
    public static final int l = 120;
    public static final int m = 0;
    public static final int n = 1;
    public static O022Z o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ZZ00Z f16650a;
    public final List<String> b = new CopyOnWriteArrayList();
    public volatile boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public class OO22Z extends ArrayList<com.zm.fda.Z0O00.Z0O00.OO22Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.zm.fda.Z0O00.Z0O00.OO22Z f16651a;

        public OO22Z(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
            this.f16651a = oo22z;
            add(oo22z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class ZZ00Z extends Handler {

        /* JADX INFO: compiled from: SearchBox */
        public class OO22Z extends ArrayList<com.zm.fda.Z0O00.Z0O00.OO22Z> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.zm.fda.Z0O00.Z0O00.OO22Z f16653a;

            public OO22Z(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
                this.f16653a = oo22z;
                add(oo22z);
            }
        }

        public ZZ00Z(Looper looper) {
            super(looper);
        }

        private void b(Message message) {
            int i = message.arg1;
            int i2 = message.arg2;
            if (i2 == 0) {
                O022Z.this.c = false;
            }
            Object obj = message.obj;
            if (obj instanceof List) {
                List<com.zm.fda.Z0O00.Z0O00.OO22Z> list = (List) obj;
                if (i == 1) {
                    EventLog.d("fob_fda", "send success, events size :", Integer.valueOf(list.size()), ", prepare to delete.");
                    boolean zA = com.zm.fda.Z0O00.OO22Z.b().a(list);
                    EventLog.d("fob_fda", "delete success,event num:", Integer.valueOf(list.size()));
                    if (zA && i2 == 0) {
                        O022Z.this.c();
                    }
                } else {
                    EventLog.d("fob_fda", "send failed, events:", list);
                }
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (list.get(i3) != null) {
                        O022Z.this.c(list.get(i3).i());
                    }
                }
            }
        }

        private void c(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
            EventLog.d("fob_fda", "sendImmediatelyWithBackup, event:", oo22z);
            O022Z.this.a(oo22z, O022Z.this.b(oo22z.f()), false);
        }

        private void d(Message message) {
            if (message == null) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof com.zm.fda.Z0O00.Z0O00.OO22Z) {
                final com.zm.fda.Z0O00.Z0O00.OO22Z oo22z = (com.zm.fda.Z0O00.Z0O00.OO22Z) obj;
                com.zm.fda.OOZ20.O022Z.a().b(O022Z.this.b(oo22z.f()), new Z25O0.ZZ00Z().a(oo22z.g()).a(new OO22Z(oo22z)).a(), new com.zm.fda.OOZ20.Z0225.OO22Z() { // from class: j44
                    @Override // com.zm.fda.OOZ20.Z0225.OO22Z
                    public final void a(int i, String str, Object obj2) {
                        O022Z.ZZ00Z.a(oo22z, i, str, obj2);
                    }
                });
            }
        }

        public void a(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c(message);
                return;
            }
            if (i == 2) {
                a();
                return;
            }
            if (i == 3) {
                d(message);
                return;
            }
            if (i == 4) {
                b(message);
            } else if (i == 5) {
                O022Z.this.b(message);
            } else {
                if (i != 6) {
                    return;
                }
                O022Z.this.a(message);
            }
        }

        public static /* synthetic */ void a(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z, int i, String str, Object obj) {
            if (i == 1) {
                com.zm.fda.ZZ0O5.OO22Z.c("fob_fda", "event = " + oo22z + " send immediately success.");
                return;
            }
            com.zm.fda.ZZ0O5.OO22Z.c("fob_fda", "event = " + oo22z + " send immediately fail.");
        }

        private void a() {
            if (O022Z.this.c) {
                EventLog.d("fob_fda", "sendEvent, mIsSending is true, 有补发流程正在发送，该补发流程停止.");
                return;
            }
            int iD = O52OZ.d(com.zm.fda.ZZ00Z.b());
            if (iD == -1) {
                return;
            }
            String strB = O022Z.this.b("");
            com.zm.fda.ZZ0O5.OO22Z.c("fob_fda", "Url = " + strB + ", prepare to send.");
            Iterator<Integer> it = com.zm.fda.Z0O00.Z0O00.O022Z.g.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (iIntValue == 1 || iD == 1) {
                    List<com.zm.fda.Z0O00.Z0O00.OO22Z> listA = com.zm.fda.Z0O00.OO22Z.b().a(iIntValue, 20);
                    if (listA != null && !listA.isEmpty()) {
                        EventLog.d("fob_fda", "mIsSending: ", Boolean.valueOf(O022Z.this.c), " 补发");
                        O022Z.this.a(listA, strB);
                    }
                }
            }
        }

        private void c(Message message) {
            com.zm.fda.ZZ0O5.OO22Z.b("fob_fda", "receive MESSAGE_SAVE_EVENT");
            Object obj = message.obj;
            if (obj instanceof Z25O0) {
                Z25O0 z25o0 = (Z25O0) obj;
                EventLog.d("fob_fda", "event = ", z25o0.b(), ", change info to DBData");
                com.zm.fda.Z0O00.Z0O00.OO22Z oo22zC = O022Z.this.c(z25o0);
                if (oo22zC != null) {
                    EventLog.d("fob_fda", " generate FdaEventBean = ", oo22zC, ", prepare to save");
                    if (oo22zC.g() == 4) {
                        d(message);
                        return;
                    }
                    long jA = com.zm.fda.Z0O00.OO22Z.b().a(oo22zC);
                    EventLog.d("fob_fda", "save event to db = ", oo22zC.d(), ", saveResult = ", Long.valueOf(jA));
                    if (jA >= 0) {
                        b(oo22zC);
                    } else if (oo22zC.g() == 1) {
                        c(oo22zC);
                    } else {
                        a(oo22zC);
                    }
                }
            }
        }

        private void a(Message message) {
            Object obj = message.obj;
            if (EventLog.isDebugEnable()) {
                EventLog.d("fob_fda", "onDbError");
            }
            if (obj instanceof Z25O0) {
                com.zm.fda.Z0O00.OO22Z.b().b(O022Z.this.c((Z25O0) obj));
            }
        }

        private void b(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
            if (oo22z.g() == 1 || oo22z.g() == 2) {
                EventLog.d("fob_fda", "收到事件[event：", oo22z.d(), "，level：", Integer.valueOf(oo22z.g()), "]触发上报");
                if (O52OZ.d(com.zm.fda.ZZ00Z.b()) == -1) {
                    return;
                }
                String strB = O022Z.this.b("");
                EventLog.d("fob_fda", " 立即发送: event:", oo22z.d());
                O022Z.this.a(oo22z, strB, true);
            }
        }
    }

    public O022Z() {
        HandlerThread handlerThread = new HandlerThread(O022Z.class.getName(), -1);
        handlerThread.start();
        this.f16650a = new ZZ00Z(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            this.b.remove(str);
        } catch (Throwable th) {
            EventLog.e("fob_fda", th.getMessage());
        }
    }

    public void c() {
        if (this.c || this.f16650a.hasMessages(2)) {
            return;
        }
        Message messageObtainMessage = this.f16650a.obtainMessage();
        messageObtainMessage.what = 2;
        this.f16650a.sendMessage(messageObtainMessage);
    }

    public void b(Z25O0 z25o0) {
        Message messageObtainMessage = this.f16650a.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = z25o0;
        this.f16650a.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        EventLog.d("fob_fda", "receive MESSAGE_SAVE_UNSEND_EVENT");
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof com.zm.fda.Z0O00.Z0O00.OO22Z) {
                com.zm.fda.Z0O00.Z0O00.OO22Z oo22z = (com.zm.fda.Z0O00.Z0O00.OO22Z) obj;
                EventLog.d("fob_fda", "onSaveUnSendEvent:", oo22z);
                com.zm.fda.Z0O00.OO22Z.b().a(oo22z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.zm.fda.Z0O00.Z0O00.OO22Z c(Z25O0 z25o0) {
        if (z25o0 != null) {
            return new OO22Z.ZZ00Z().a(z25o0.b()).c(z25o0.d()).a(a(z25o0.a(), z25o0.e(), z25o0.f())).b(z25o0.c()).a(1).a();
        }
        return null;
    }

    public static O022Z a() {
        if (o == null) {
            synchronized (O022Z.class) {
                if (o == null) {
                    o = new O022Z();
                }
            }
        }
        return o;
    }

    private void b() {
        if (this.b.size() > 120) {
            try {
                this.b.remove(0);
            } catch (Throwable th) {
                EventLog.e("fob_fda", th.getMessage());
            }
        }
    }

    public void a(Z25O0 z25o0) {
        Message messageObtainMessage = this.f16650a.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = z25o0;
        this.f16650a.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        return !TextUtils.isEmpty(str) ? str : ZZ00Z.C1170ZZ00Z.b();
    }

    private void a(com.zm.fda.Z0O00.Z0O00.OO22Z oo22z) {
        Message messageObtainMessage = this.f16650a.obtainMessage();
        messageObtainMessage.what = 5;
        messageObtainMessage.obj = oo22z;
        this.f16650a.sendMessage(messageObtainMessage);
    }

    private void a(String str) {
        Message messageObtainMessage = this.f16650a.obtainMessage();
        messageObtainMessage.what = 6;
        messageObtainMessage.obj = str;
        this.f16650a.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        EventLog.d("fob_fda", "receive MESSAGE_DELETE_SENDING_EVENT");
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof String) {
                String str = (String) obj;
                EventLog.d("fob_fda", "onDeleteSendingEvent id:", str);
                c(str);
            }
        }
    }

    private void a(int i2, List<com.zm.fda.Z0O00.Z0O00.OO22Z> list, boolean z) {
        Message messageObtainMessage = this.f16650a.obtainMessage();
        messageObtainMessage.what = 4;
        messageObtainMessage.obj = list;
        messageObtainMessage.arg1 = i2;
        messageObtainMessage.arg2 = z ? 1 : 0;
        this.f16650a.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.zm.fda.Z0O00.Z0O00.OO22Z oo22z, String str, final boolean z) {
        if (oo22z == null || !oo22z.k()) {
            return;
        }
        final OO22Z oo22z2 = new OO22Z(oo22z);
        com.zm.fda.Z0O00.Z0O00.Z25O0 z25o0A = new Z25O0.ZZ00Z().a(oo22z2).a(oo22z.g()).a();
        b();
        this.b.add(oo22z.i());
        com.zm.fda.OOZ20.O022Z.a().b(str, z25o0A, new com.zm.fda.OOZ20.Z0225.OO22Z() { // from class: i44
            @Override // com.zm.fda.OOZ20.Z0225.OO22Z
            public final void a(int i2, String str2, Object obj) {
                this.n.a(z, oo22z2, oo22z, i2, str2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, List list, com.zm.fda.Z0O00.Z0O00.OO22Z oo22z, int i2, String str, Object obj) {
        if (i2 == 1) {
            if (z) {
                a(i2, (List<com.zm.fda.Z0O00.Z0O00.OO22Z>) list, true);
            } else {
                a(oo22z.i());
            }
            EventLog.d("fob_fda", "event = ", oo22z, " send immediately success.");
            return;
        }
        if (!z) {
            a(oo22z);
        }
        a(oo22z.i());
        EventLog.d("fob_fda", "event = ", oo22z, "send immediately fail.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<com.zm.fda.Z0O00.Z0O00.OO22Z> list, String str) {
        this.c = true;
        Iterator<com.zm.fda.Z0O00.Z0O00.OO22Z> it = list.iterator();
        while (it.hasNext()) {
            com.zm.fda.Z0O00.Z0O00.OO22Z next = it.next();
            if (next != null) {
                if (this.b.contains(next.i())) {
                    it.remove();
                } else {
                    b();
                    this.b.add(next.i());
                    EventLog.d("fob_fda", "prepare to send event- > ", next.d());
                }
            }
        }
        if (list.isEmpty()) {
            this.c = false;
        } else {
            com.zm.fda.OOZ20.O022Z.a().c(str, new Z25O0.ZZ00Z().a(list).a(list.get(0) != null ? list.get(0).g() : 1).a(), new com.zm.fda.OOZ20.Z0225.OO22Z() { // from class: f44
                @Override // com.zm.fda.OOZ20.Z0225.OO22Z
                public final void a(int i2, String str2, Object obj) {
                    this.n.a(list, i2, str2, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, int i2, String str, Object obj) {
        a(i2, (List<com.zm.fda.Z0O00.Z0O00.OO22Z>) list, false);
    }

    private com.zm.fda.Z0O00.Z0O00.ZZ00Z a(long j2, IPubParams iPubParams, Z200O z200o) {
        if (iPubParams != null && z200o != null) {
            try {
                String lati = "";
                ZZ00Z.C1167ZZ00Z c1167zz00zM = new ZZ00Z.C1167ZZ00Z().g(O2O5Z.a(iPubParams.getDHID() == null ? "" : iPubParams.getDHID())).A(O2O5Z.a(z200o.m())).q(O2O5Z.a(com.zm.fda.Z25O0.a(iPubParams))).k(O2O5Z.a(z200o.d())).c(O2O5Z.a(iPubParams.getAppId() == null ? "" : iPubParams.getAppId())).n(O2O5Z.a(iPubParams.getMac() == null ? "" : iPubParams.getMac())).B(String.valueOf(z200o.o())).C(O2O5Z.a(z200o.p())).a(j2).f(O2O5Z.a(iPubParams.getChanId() == null ? "" : iPubParams.getChanId())).j(O2O5Z.a(iPubParams.getIMEI() == null ? "" : iPubParams.getIMEI())).b(O2O5Z.a(iPubParams.getAndroidId() == null ? "" : iPubParams.getAndroidId())).p(O2O5Z.a(z200o.f())).m(O2O5Z.a(iPubParams.getLongi() == null ? "" : iPubParams.getLongi()));
                if (iPubParams.getLati() != null) {
                    lati = iPubParams.getLati();
                }
                ZZ00Z.C1167ZZ00Z c1167zz00zU = c1167zz00zM.l(O2O5Z.a(lati)).r(com.zm.fda.Z200O.ZZ00Z.x).t(O2O5Z.a(z200o.h())).s(z200o.g()).z(z200o.l()).y(z200o.k()).x(O2O5Z.a(iPubParams.getProjectVerName())).v(O2O5Z.a(iPubParams.getProjectId())).w(String.valueOf(iPubParams.getProjectVerCode())).d(z200o.a()).e(O2O5Z.a(iPubParams.getCarrier())).o(z200o.e()).h(z200o.c()).i(z200o.b()).u(z200o.j());
                if (c1167zz00zU != null) {
                    return c1167zz00zU.a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return new ZZ00Z.C1167ZZ00Z().a();
        }
        return new ZZ00Z.C1167ZZ00Z().a();
    }
}
