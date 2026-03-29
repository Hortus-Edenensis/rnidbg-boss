package defpackage;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class e41 implements lp0 {
    public static final e41 c = new e41(Collections.emptyMap());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17210a;
    public final Map<String, byte[]> b;

    public e41() {
        this(Collections.emptyMap());
    }

    public static void a(HashMap<String, byte[]> map, Map<String, Object> map2) {
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            map.put(entry.getKey(), e(entry.getValue()));
        }
    }

    public static Map<String, byte[]> b(Map<String, byte[]> map, mp0 mp0Var) {
        HashMap map2 = new HashMap(map);
        g(map2, mp0Var.c());
        a(map2, mp0Var.b());
        return map2;
    }

    public static byte[] e(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(f10.c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public static boolean f(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void g(HashMap<String, byte[]> map, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i));
        }
    }

    public e41 c(mp0 mp0Var) {
        Map<String, byte[]> mapB = b(this.b, mp0Var);
        return f(this.b, mapB) ? this : new e41(mapB);
    }

    public Set<Map.Entry<String, byte[]>> d() {
        return this.b.entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e41.class != obj.getClass()) {
            return false;
        }
        return f(this.b, ((e41) obj).b);
    }

    @Override // defpackage.lp0
    @Nullable
    public final String get(String str, @Nullable String str2) {
        byte[] bArr = this.b.get(str);
        return bArr != null ? new String(bArr, f10.c) : str2;
    }

    public int hashCode() {
        if (this.f17210a == 0) {
            int iHashCode = 0;
            for (Map.Entry<String, byte[]> entry : this.b.entrySet()) {
                iHashCode += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f17210a = iHashCode;
        }
        return this.f17210a;
    }

    public e41(Map<String, byte[]> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    @Override // defpackage.lp0
    public final long get(String str, long j) {
        byte[] bArr = this.b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j;
    }
}
