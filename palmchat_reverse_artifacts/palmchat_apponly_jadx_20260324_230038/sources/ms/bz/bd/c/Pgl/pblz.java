package ms.bz.bd.c.Pgl;

import android.util.SparseArray;
import com.umeng.analytics.pro.dn;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<pgla> f19343a = new SparseArray<>();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class pgla {
        public Object a(int i, int i2, long j, String str, Object obj) throws Throwable {
            return b(j, str, obj);
        }

        public Object b(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static Object a(int i, int i2, long j, String str, Object obj) {
        pgla pglaVar = f19343a.get(i);
        if (pglaVar == null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bb9260", new byte[]{124, 112, 10, 69, 6, 35, 100, 3, 45, 102, 51, 105, 89, 6, 0, 41, 119, 66, 100, 107, 119}), Integer.valueOf(i)));
        }
        try {
            return pglaVar.a(i, i2, j, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void b(int i, pgla pglaVar) {
        SparseArray<pgla> sparseArray = f19343a;
        pgla pglaVar2 = sparseArray.get(i);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "94e50a", new byte[]{109, 37, 86, 73, dn.l, 114, 122, 23, 49, 96, 38, 118, 4, 68, 8, ByteCompanionObject.MAX_VALUE, 41, 1, 49, 119, 102}), pglaVar2.toString()));
        }
        sparseArray.put(i, pglaVar);
    }
}
