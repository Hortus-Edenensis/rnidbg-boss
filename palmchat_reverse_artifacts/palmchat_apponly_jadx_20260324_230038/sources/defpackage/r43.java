package defpackage;

import com.kuaishou.weapon.p0.t;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lr43;", "", "", t.l, "", "", "Lqm2;", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "loaders", "<init>", "()V", "zx-compat_release"}, k = 1, mv = {1, 4, 0})
public final class r43 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<Integer, qm2> loaders = new LinkedHashMap();

    public final Map<Integer, qm2> a() {
        return this.loaders;
    }

    public final void b() {
        Iterator<Map.Entry<Integer, qm2>> it = this.loaders.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(true);
        }
    }
}
