package defpackage;

import com.kuaishou.weapon.p0.t;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lbc3;", "", "Lzb3;", "a", "", t.l, "Z", "FAST_SERVICE_LOADER_ENABLED", "c", "Lzb3;", "dispatcher", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class bc3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bc3 f1684a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final boolean FAST_SERVICE_LOADER_ENABLED = false;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @JvmField
    public static final zb3 dispatcher;

    static {
        bc3 bc3Var = new bc3();
        f1684a = bc3Var;
        fr5.e("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = bc3Var.a();
    }

    public final zb3 a() {
        Object next;
        zb3 zb3VarE;
        try {
            List<ac3> listC = FAST_SERVICE_LOADER_ENABLED ? it1.f18257a.c() : SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(ServiceLoader.load(ac3.class, ac3.class.getClassLoader()).iterator()));
            Iterator<T> it = listC.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iA = ((ac3) next).a();
                    do {
                        Object next2 = it.next();
                        int iA2 = ((ac3) next2).a();
                        if (iA < iA2) {
                            next = next2;
                            iA = iA2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            ac3 ac3Var = (ac3) next;
            return (ac3Var == null || (zb3VarE = cc3.e(ac3Var, listC)) == null) ? cc3.b(null, null, 3, null) : zb3VarE;
        } catch (Throwable th) {
            return cc3.b(th, null, 2, null);
        }
    }
}
