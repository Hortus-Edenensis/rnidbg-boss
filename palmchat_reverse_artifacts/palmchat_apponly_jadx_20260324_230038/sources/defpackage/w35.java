package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class w35 extends TagPayloadReader {
    public long b;
    public long[] c;
    public long[] d;

    public w35() {
        super(new pi1());
        this.b = -9223372036854775807L;
        this.c = new long[0];
        this.d = new long[0];
    }

    public static Boolean g(gc4 gc4Var) {
        return Boolean.valueOf(gc4Var.H() == 1);
    }

    @Nullable
    public static Object h(gc4 gc4Var, int i) {
        if (i == 0) {
            return j(gc4Var);
        }
        if (i == 1) {
            return g(gc4Var);
        }
        if (i == 2) {
            return n(gc4Var);
        }
        if (i == 3) {
            return l(gc4Var);
        }
        if (i == 8) {
            return k(gc4Var);
        }
        if (i == 10) {
            return m(gc4Var);
        }
        if (i != 11) {
            return null;
        }
        return i(gc4Var);
    }

    public static Date i(gc4 gc4Var) {
        Date date = new Date((long) j(gc4Var).doubleValue());
        gc4Var.V(2);
        return date;
    }

    public static Double j(gc4 gc4Var) {
        return Double.valueOf(Double.longBitsToDouble(gc4Var.A()));
    }

    public static HashMap<String, Object> k(gc4 gc4Var) {
        int iL = gc4Var.L();
        HashMap<String, Object> map = new HashMap<>(iL);
        for (int i = 0; i < iL; i++) {
            String strN = n(gc4Var);
            Object objH = h(gc4Var, o(gc4Var));
            if (objH != null) {
                map.put(strN, objH);
            }
        }
        return map;
    }

    public static HashMap<String, Object> l(gc4 gc4Var) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strN = n(gc4Var);
            int iO = o(gc4Var);
            if (iO == 9) {
                return map;
            }
            Object objH = h(gc4Var, iO);
            if (objH != null) {
                map.put(strN, objH);
            }
        }
    }

    public static ArrayList<Object> m(gc4 gc4Var) {
        int iL = gc4Var.L();
        ArrayList<Object> arrayList = new ArrayList<>(iL);
        for (int i = 0; i < iL; i++) {
            Object objH = h(gc4Var, o(gc4Var));
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        return arrayList;
    }

    public static String n(gc4 gc4Var) {
        int iN = gc4Var.N();
        int iF = gc4Var.f();
        gc4Var.V(iN);
        return new String(gc4Var.e(), iF, iN);
    }

    public static int o(gc4 gc4Var) {
        return gc4Var.H();
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(gc4 gc4Var) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(gc4 gc4Var, long j) {
        if (o(gc4Var) != 2 || !"onMetaData".equals(n(gc4Var)) || gc4Var.a() == 0 || o(gc4Var) != 8) {
            return false;
        }
        HashMap<String, Object> mapK = k(gc4Var);
        Object obj = mapK.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapK.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.c = new long[size];
                this.d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.c = new long[0];
                        this.d = new long[0];
                        break;
                    }
                    this.c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.d[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.b;
    }

    public long[] e() {
        return this.d;
    }

    public long[] f() {
        return this.c;
    }
}
