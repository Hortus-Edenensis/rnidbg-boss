package defpackage;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class lg4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18973a = false;
    public final Set<b> b = new ArraySet();
    public final Map<String, le3> c = new HashMap();
    public final Comparator<Pair<String, Float>> d = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<Pair<String, Float>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = pair.second.floatValue();
            float fFloatValue2 = pair2.second.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(float f);
    }

    public void a(String str, float f) {
        if (this.f18973a) {
            le3 le3Var = this.c.get(str);
            if (le3Var == null) {
                le3Var = new le3();
                this.c.put(str, le3Var);
            }
            le3Var.a(f);
            if (str.equals("__container")) {
                Iterator<b> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().a(f);
                }
            }
        }
    }

    public void b(boolean z) {
        this.f18973a = z;
    }
}
