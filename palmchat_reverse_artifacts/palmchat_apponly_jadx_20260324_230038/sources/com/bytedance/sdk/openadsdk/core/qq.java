package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.kj;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface qq<T> {

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void u(int i, String str);

        void u(kj.fx fxVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface fx<T> {
        void u(int i, String str);

        void u(T t);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar);

        void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface pn {
        void u(int i, String str);

        void u(kj.b bVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(boolean z, long j, long j2);
    }

    void fx(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, nr nrVar2);

    void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, nr nrVar2);

    com.bytedance.sdk.component.adexpress.u.fx.u u(int i);

    com.bytedance.sdk.openadsdk.core.kj.b u(bc bcVar, String str);

    String u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar);

    String u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, boolean z, int i);

    void u(com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar, List<com.bytedance.sdk.openadsdk.my.fx.nr.iz> list);

    void u(jw jwVar, String str, String str2, fx fxVar, int i, long j);

    void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, int i, nr nrVar2);

    void u(String str);

    void u(String str, String str2, u uVar);

    void u(Map<String, Object> map, Function<SparseArray<Object>, Object> function);

    void u(Function<SparseArray<Object>, Object> function);

    void u(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.pn.nr.nr nrVar);

    void u(JSONObject jSONObject, b bVar);

    void u(JSONObject jSONObject, fx<com.bytedance.sdk.component.a.nr> fxVar);

    void u(JSONObject jSONObject, pn pnVar);
}
