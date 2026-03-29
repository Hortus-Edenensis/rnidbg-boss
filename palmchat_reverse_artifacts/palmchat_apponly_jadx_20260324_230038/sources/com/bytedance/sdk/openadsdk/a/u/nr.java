package com.bytedance.sdk.openadsdk.a.u;

import com.bytedance.sdk.component.u.b;
import com.bytedance.sdk.component.u.o;
import com.bytedance.sdk.openadsdk.core.ja;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class nr extends com.bytedance.sdk.component.u.b<JSONObject, JSONObject> {
    private static WeakReference<u> u;
    private WeakReference<ja> nr;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();

        void u(int i);
    }

    private nr(ja jaVar) {
        this.nr = new WeakReference<>(jaVar);
    }

    public static void u(o oVar, final ja jaVar) {
        oVar.u("onClickBrowseCloseCallback", new b.nr() { // from class: com.bytedance.sdk.openadsdk.a.u.nr.1
            @Override // com.bytedance.sdk.component.u.b.nr
            public com.bytedance.sdk.component.u.b u() {
                return new nr(jaVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.u.b
    public void u(JSONObject jSONObject, com.bytedance.sdk.component.u.iz izVar) throws Exception {
        WeakReference<u> weakReference = u;
        u uVar = weakReference != null ? weakReference.get() : null;
        if (this.nr == null || jSONObject == null) {
            if (uVar != null) {
                uVar.u();
                return;
            }
            return;
        }
        int iOptInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (iOptInt == Integer.MIN_VALUE) {
            if (uVar != null) {
                uVar.u();
            }
        } else if (uVar != null) {
            uVar.u(iOptInt);
        }
    }

    public static void u(u uVar) {
        u = new WeakReference<>(uVar);
    }

    @Override // com.bytedance.sdk.component.u.b
    public void b() {
    }
}
