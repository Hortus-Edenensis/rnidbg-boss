package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ji0 {
    public static String b = "CommentDraftCache";
    public static volatile ji0 c = null;
    public static int d = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<ii0> f18417a = new CopyOnWriteArrayList<>();

    public static ji0 d() {
        if (c == null) {
            synchronized (ji0.class) {
                if (c == null) {
                    c = new ji0();
                }
            }
        }
        return c;
    }

    public void a(ii0 ii0Var) {
        LogUtil.i(b, "addCommentDraft : " + ii0Var.f18171a);
        Iterator<ii0> it = this.f18417a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ii0 next = it.next();
            if (next.c.equals(ii0Var.c) && next.b.equals(ii0Var.b)) {
                if (next.f18171a.equals(ii0Var.f18171a)) {
                    return;
                } else {
                    this.f18417a.remove(next);
                }
            }
        }
        this.f18417a.add(ii0Var);
        if (this.f18417a.size() > d) {
            this.f18417a.remove(0);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addCommentDraft commentDrafts: ");
        for (int i = 0; i < this.f18417a.size(); i++) {
            sb.append(i + "-->");
            sb.append(this.f18417a.get(i).f18171a);
            sb.append(", ");
        }
        LogUtil.i(b, sb.toString());
    }

    public void b(ii0 ii0Var) {
        LogUtil.i(b, "deleteCommentDraft : " + ii0Var.f18171a);
        CopyOnWriteArrayList<ii0> copyOnWriteArrayList = this.f18417a;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        Iterator<ii0> it = this.f18417a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ii0 next = it.next();
            if (next.c.equals(ii0Var.c) && next.b.equals(ii0Var.b)) {
                this.f18417a.remove(next);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("deleteCommentDraft commentDrafts: ");
        for (int i = 0; i < this.f18417a.size(); i++) {
            sb.append(i + "-->");
            sb.append(this.f18417a.get(i).f18171a);
            sb.append(", ");
        }
        LogUtil.i(b, sb.toString());
    }

    public String c(Long l, Long l2) {
        CopyOnWriteArrayList<ii0> copyOnWriteArrayList = this.f18417a;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            for (ii0 ii0Var : this.f18417a) {
                if (ii0Var.c.equals(l) && ii0Var.b.equals(l2)) {
                    return ii0Var.f18171a;
                }
            }
        }
        return null;
    }
}
