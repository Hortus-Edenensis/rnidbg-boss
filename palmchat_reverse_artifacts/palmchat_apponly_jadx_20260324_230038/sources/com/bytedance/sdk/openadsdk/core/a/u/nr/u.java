package com.bytedance.sdk.openadsdk.core.a.u.nr;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@com.bytedance.sdk.component.t.nr.nr
public class u implements com.bytedance.sdk.component.t.u.u.fx {

    @com.bytedance.sdk.component.t.nr.u(u = "context")
    private Context fx;

    @com.bytedance.sdk.component.t.nr.u(u = "title")
    private String nr;

    @com.bytedance.sdk.component.t.nr.u(u = "url")
    private String u;

    @Override // com.bytedance.sdk.component.t.u.u.fx
    public boolean u(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.t.u.u uVar) {
        TTDelegateActivity.b(this.fx, this.u, this.nr);
        uVar.u(map2);
        return true;
    }
}
