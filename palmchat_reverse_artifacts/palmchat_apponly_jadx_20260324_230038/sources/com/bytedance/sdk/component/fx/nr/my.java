package com.bytedance.sdk.component.fx.nr;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class my {
    public static final my u = new my() { // from class: com.bytedance.sdk.component.fx.nr.my.1
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        my u(pn pnVar);
    }

    public void u(pn pnVar, IOException iOException) {
    }

    public void u(pn pnVar, InetSocketAddress inetSocketAddress, Proxy proxy, qq qqVar, IOException iOException) {
    }

    public static u u(my myVar) {
        return new u() { // from class: com.bytedance.sdk.component.fx.nr.my.2
            @Override // com.bytedance.sdk.component.fx.nr.my.u
            public my u(pn pnVar) {
                return my.this;
            }
        };
    }
}
