package defpackage;

import defpackage.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class qv6 extends g {
    public static final List<g.a> b = new CopyOnWriteArrayList();

    public static void a() {
        Iterator<g.a> it = b.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }
}
