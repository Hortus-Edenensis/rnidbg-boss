package defpackage;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface jg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jg2 f18401a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jg2 {
        @Override // defpackage.jg2
        public Map<Class<?>, Set<en1>> a(Object obj) {
            return je.b(obj);
        }

        @Override // defpackage.jg2
        public Map<Class<?>, sn1> b(Object obj) {
            return je.a(obj);
        }
    }

    Map<Class<?>, Set<en1>> a(Object obj);

    Map<Class<?>, sn1> b(Object obj);
}
