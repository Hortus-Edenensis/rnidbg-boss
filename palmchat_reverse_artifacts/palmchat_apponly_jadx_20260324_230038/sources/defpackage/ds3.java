package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class ds3 {
    public static String b = "MsgReceiverManager";
    public static volatile ds3 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ln2> f17131a = new ArrayList();

    public ds3() {
        f();
    }

    public static ds3 c() {
        if (c == null) {
            synchronized (ds3.class) {
                if (c == null) {
                    c = new ds3();
                }
            }
        }
        return c;
    }

    public cs3 a(MessageProto.Message message) {
        if (message != null) {
            for (ln2 ln2Var : this.f17131a) {
                if ((ln2Var instanceof cs3) && ln2Var.a(message)) {
                    cs3 cs3Var = (cs3) ln2Var;
                    LogUtil.i(b, "findDbConverterProcessor " + message);
                    return cs3Var;
                }
            }
        }
        return null;
    }

    public ln2 b(MessageProto.Message message) {
        if (message != null) {
            for (ln2 ln2Var : this.f17131a) {
                if (ln2Var.a(message)) {
                    LogUtil.i(b, "findProcessor " + message);
                    return ln2Var;
                }
            }
        }
        return null;
    }

    public boolean d(MessageProto.Message message) {
        ln2 ln2VarB = b(message);
        if (ln2VarB != null) {
            ln2VarB.d(message);
        }
        return ln2VarB != null;
    }

    public void e(ArrayList<MessageProto.Message> arrayList) {
        if (arrayList.size() > 0) {
            HashMap map = new HashMap();
            for (MessageProto.Message message : arrayList) {
                ln2 ln2VarB = b(message);
                if (ln2VarB != null) {
                    ArrayList arrayList2 = (ArrayList) map.get(ln2VarB);
                    if (arrayList2 == null) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(message);
                        map.put(ln2VarB, arrayList3);
                    } else {
                        arrayList2.add(message);
                    }
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                ln2 ln2Var = (ln2) entry.getKey();
                ArrayList<MessageProto.Message> arrayList4 = (ArrayList) entry.getValue();
                if (ln2Var != null && arrayList4 != null && arrayList4.size() > 0) {
                    ln2Var.e(arrayList4);
                }
            }
        }
    }

    public final void f() {
        this.f17131a.add(new gb2());
        this.f17131a.add(new li5());
        this.f17131a.add(new s8());
        this.f17131a.add(new rj5());
        this.f17131a.add(new p96());
        this.f17131a.add(new n7());
        this.f17131a.add(new cn4());
        this.f17131a.add(new m20());
        this.f17131a.add(new u30());
        this.f17131a.add(new rd0());
        this.f17131a.add(new ip());
        this.f17131a.add(new pu());
    }
}
