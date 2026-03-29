package com.bytedance.sdk.openadsdk.ats;

import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.sdk.component.b.t;
import j$.util.function.Function$CC;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n implements t, Function {
    private static HashMap<String, u> u = new HashMap<>();
    private t nr = new com.bytedance.sdk.openadsdk.ats.u.fx();

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        boolean b;
        long fx;
        int nr;
        String u;

        private u() {
        }
    }

    private Pair<u, Boolean> u(String str) {
        u uVar = u.get(str);
        if (uVar != null) {
            return new Pair<>(uVar, Boolean.FALSE);
        }
        u uVar2 = new u();
        u.put(str, uVar2);
        return new Pair<>(uVar2, Boolean.TRUE);
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            return get((String) sparseArray.get(1));
        }
        if (iIntValue == 2) {
            return Integer.valueOf(getInt((String) sparseArray.get(1)));
        }
        if (iIntValue == 3) {
            return Long.valueOf(getLong((String) sparseArray.get(1)));
        }
        if (iIntValue == 4) {
            return Boolean.valueOf(getBoolean((String) sparseArray.get(1)));
        }
        if (iIntValue != 5) {
            return null;
        }
        set((String) sparseArray.get(1), (String) sparseArray.get(2));
        return null;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // com.bytedance.sdk.component.b.t
    public String get(String str) {
        Pair<u, Boolean> pairU = u(str);
        if (((Boolean) pairU.second).booleanValue()) {
            ((u) pairU.first).u = this.nr.get(str);
        }
        return ((u) pairU.first).u;
    }

    @Override // com.bytedance.sdk.component.b.t
    public boolean getBoolean(String str) {
        Pair<u, Boolean> pairU = u(str);
        if (((Boolean) pairU.second).booleanValue()) {
            ((u) pairU.first).b = this.nr.getBoolean(str);
        }
        return ((u) pairU.first).b;
    }

    @Override // com.bytedance.sdk.component.b.t
    public int getInt(String str) {
        Pair<u, Boolean> pairU = u(str);
        if (((Boolean) pairU.second).booleanValue()) {
            ((u) pairU.first).nr = this.nr.getInt(str);
        }
        return ((u) pairU.first).nr;
    }

    @Override // com.bytedance.sdk.component.b.t
    public long getLong(String str) {
        Pair<u, Boolean> pairU = u(str);
        if (((Boolean) pairU.second).booleanValue()) {
            ((u) pairU.first).fx = this.nr.getLong(str);
        }
        return ((u) pairU.first).fx;
    }

    @Override // com.bytedance.sdk.component.b.t
    public void set(String str, String str2) {
        this.nr.set(str, str2);
    }
}
