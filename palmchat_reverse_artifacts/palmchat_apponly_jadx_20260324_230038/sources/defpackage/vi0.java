package defpackage;

import com.zenmen.palmchat.messaging.cmdProcessor.CmdMsgEvent;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ce2;
import defpackage.f40;
import defpackage.sc0;
import defpackage.t84;
import defpackage.te2;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class vi0 {
    public static volatile vi0 b;
    public static Set<String> c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<wk2> f21449a = new ArrayList();

    public vi0() {
        g();
    }

    public static vi0 d() {
        if (b == null) {
            synchronized (vi0.class) {
                if (b == null) {
                    b = new vi0();
                }
            }
        }
        return b;
    }

    public final boolean a(String str) {
        boolean zContains = c.contains(str);
        if (!zContains) {
            c.add(str);
        }
        return zContains;
    }

    public boolean b(MessageProto.Message message) {
        return c(message) != null;
    }

    public final wk2 c(MessageProto.Message message) {
        if (message != null) {
            for (wk2 wk2Var : this.f21449a) {
                if (wk2Var.a(message)) {
                    LogUtil.i("CommonCMDMsgProcessManager", "findProcessor " + message);
                    return wk2Var;
                }
            }
        }
        return null;
    }

    public boolean e(MessageProto.Message message) {
        wk2 wk2VarC = c(message);
        if (wk2VarC != null && !a(message.getMid())) {
            wk2VarC.d(message);
            if (wk2VarC.b()) {
                ds0.a().b(CmdMsgEvent.produceEvent(message));
            }
        }
        return wk2VarC != null;
    }

    public void f(ArrayList<MessageProto.Message> arrayList) {
        wk2 wk2VarC;
        if (arrayList.size() > 0) {
            HashMap map = new HashMap();
            for (MessageProto.Message message : arrayList) {
                if (!a(message.getMid()) && (wk2VarC = c(message)) != null) {
                    ArrayList arrayList2 = (ArrayList) map.get(wk2VarC);
                    if (arrayList2 == null) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(message);
                        map.put(wk2VarC, arrayList3);
                    } else {
                        arrayList2.add(message);
                    }
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                wk2 wk2Var = (wk2) entry.getKey();
                ArrayList<MessageProto.Message> arrayList4 = (ArrayList) entry.getValue();
                if (wk2Var != null && arrayList4 != null && arrayList4.size() > 0) {
                    wk2Var.e(arrayList4);
                    if (wk2Var.b()) {
                        ds0.a().b(CmdMsgEvent.produceEvent(arrayList4.get(0)));
                    }
                }
            }
        }
    }

    public final void g() {
        this.f21449a.add(new f40.a());
        this.f21449a.add(new g40());
        this.f21449a.add(new te2.a());
        this.f21449a.add(new t84.a());
        this.f21449a.add(new pj5());
        this.f21449a.add(new ps5());
        this.f21449a.add(new ce2.a());
        this.f21449a.add(new sc0.a());
        this.f21449a.add(new eu2());
        this.f21449a.add(new ih6());
        this.f21449a.add(new qh6());
        this.f21449a.add(new l30());
        this.f21449a.add(new zc3());
        this.f21449a.add(new jt4());
    }
}
