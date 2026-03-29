package com.bytedance.sdk.openadsdk.core.live.u;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface b {
    void b();

    void b(bc bcVar);

    int b_(bc bcVar);

    long fx();

    boolean iz();

    JSONObject n();

    int nr();

    int nr(Context context, bc bcVar, Map<String, Object> map);

    int pn();

    int u(Context context, bc bcVar, Map<String, Object> map);

    int u(bc bcVar, fx fxVar, String str);

    int u(com.bytedance.sdk.openadsdk.core.live.nr.nr nrVar, boolean z);

    int u(String str);

    void u();

    void u(com.bytedance.sdk.openadsdk.k.b bVar);

    void u(String str, bc bcVar, long j);

    void u(String str, boolean z);

    void u(Function<SparseArray<Object>, Object> function);

    boolean u(bc bcVar);

    boolean u(String str, int i);

    String x();
}
