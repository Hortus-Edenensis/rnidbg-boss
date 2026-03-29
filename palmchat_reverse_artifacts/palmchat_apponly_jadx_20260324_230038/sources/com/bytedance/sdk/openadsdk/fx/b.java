package com.bytedance.sdk.openadsdk.fx;

import android.app.Application;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.fx.u;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Function<SparseArray<Object>, Object> {
    private static volatile b u;
    private final u fx = new u();
    private fx nr;

    private b() {
    }

    public static b u() {
        if (u == null) {
            synchronized (b.class) {
                if (u == null) {
                    u = new b();
                }
            }
        }
        return u;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public Application.ActivityLifecycleCallbacks nr() {
        return this.fx;
    }

    public void u(fx fxVar) {
        this.nr = fxVar;
    }

    private Function<SparseArray<Object>, Object> u(int i) {
        if (i == 2) {
            return com.bytedance.sdk.openadsdk.live.fx.u();
        }
        if (i == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.fx.u(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.u.u.u();
    }

    private void u(final nr nrVar) {
        this.fx.u(new u.InterfaceC0308u() { // from class: com.bytedance.sdk.openadsdk.fx.b.1
            @Override // com.bytedance.sdk.openadsdk.fx.u.InterfaceC0308u
            public void nr() {
                nrVar.nr();
            }

            @Override // com.bytedance.sdk.openadsdk.fx.u.InterfaceC0308u
            public void u() {
                nrVar.u();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> functionU;
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (iIntValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 5);
            return sparseArray2;
        }
        if (iIntValue != 14) {
            switch (iIntValue) {
                case 2:
                    return this.fx.u();
                case 3:
                    return TTAppContextHolder.getContext();
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    fx fxVar = this.nr;
                    if (fxVar != null && (functionU = fxVar.u(4)) != null) {
                        return functionU.apply(sparseArray);
                    }
                    return null;
                case 9:
                    Object obj = sparseArray.get(0);
                    if (obj instanceof Function) {
                        u(new nr((Function) obj));
                    }
                    return null;
                case 10:
                    fx fxVar2 = this.nr;
                    return fxVar2 == null ? u(((Integer) sparseArray.get(0)).intValue()) : fxVar2.u(((Integer) sparseArray.get(0)).intValue());
                default:
                    return null;
            }
        }
        return this.fx.nr();
    }
}
