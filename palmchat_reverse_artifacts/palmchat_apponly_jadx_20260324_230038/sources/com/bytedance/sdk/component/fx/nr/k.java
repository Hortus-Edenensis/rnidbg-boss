package com.bytedance.sdk.component.fx.nr;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface k {
    public static final k u = new k() { // from class: com.bytedance.sdk.component.fx.nr.k.1
        @Override // com.bytedance.sdk.component.fx.nr.k
        public List<InetAddress> u(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }
    };

    List<InetAddress> u(String str) throws UnknownHostException;
}
