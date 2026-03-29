package com.bytedance.sdk.component.nr.u.u.u;

import com.bytedance.sdk.component.nr.u.mv;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements u {
    private String nr(com.bytedance.sdk.component.nr.u.nr nrVar) throws NullPointerException {
        return nrVar.u().nr().toString();
    }

    @Override // com.bytedance.sdk.component.nr.u.u.u.u
    public void u(com.bytedance.sdk.component.nr.u.nr nrVar, InetSocketAddress inetSocketAddress, Proxy proxy, mv mvVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.b.x) com.bytedance.sdk.openadsdk.ats.fx.u("event")).onExceptionEvent("okhttp_connectFailed", u(nrVar), iOException);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.u.u.u
    public void u(com.bytedance.sdk.component.nr.u.nr nrVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.b.x) com.bytedance.sdk.openadsdk.ats.fx.u("event")).onExceptionEvent("okhttp_callFailed", u(nrVar), iOException);
        } catch (Exception unused) {
        }
    }

    private JSONObject u(com.bytedance.sdk.component.nr.u.nr nrVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", nr(nrVar));
        return jSONObject;
    }
}
