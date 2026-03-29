package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.component.sdk.annotation.Keep;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.core.bc.u.u;
import com.bytedance.sdk.openadsdk.core.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Keep
public class LogAdapter implements com.bytedance.sdk.component.u {
    public static LogAdapter u;
    private u.InterfaceC0238u nr;

    private LogAdapter() {
    }

    @Keep
    public static void zzz(TTILog tTILog) {
        if (d.fx > 5300 && u == null && tTILog != null) {
            u((u.InterfaceC0238u) new u.nr(tTILog), false);
        }
    }

    public void fx(String str, String str2) {
        u.InterfaceC0238u interfaceC0238u = this.nr;
        if (interfaceC0238u != null) {
            interfaceC0238u.nr(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.u
    public void nr(String str, String str2) {
        u.InterfaceC0238u interfaceC0238u = this.nr;
        if (interfaceC0238u != null) {
            interfaceC0238u.b(str, str2);
        }
    }

    public u.InterfaceC0238u u() {
        return this.nr;
    }

    public static void u(u.InterfaceC0238u interfaceC0238u, boolean z) {
        LogAdapter logAdapter = new LogAdapter();
        u = logAdapter;
        if (z) {
            logAdapter.nr = new u(interfaceC0238u);
        } else {
            logAdapter.nr = interfaceC0238u;
        }
    }

    @Override // com.bytedance.sdk.component.u
    public void u(String str, String str2) {
        u.InterfaceC0238u interfaceC0238u = this.nr;
        if (interfaceC0238u != null) {
            interfaceC0238u.fx(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.u
    public void u(String str, String str2, Throwable th) {
        u.InterfaceC0238u interfaceC0238u = this.nr;
        if (interfaceC0238u != null) {
            interfaceC0238u.u(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.u
    public void u(String str, Throwable th) {
        u.InterfaceC0238u interfaceC0238u = this.nr;
        if (interfaceC0238u != null) {
            interfaceC0238u.u(str, th);
        }
    }
}
