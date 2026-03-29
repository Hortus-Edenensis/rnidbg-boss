package com.zenmen.palmchat.framework.httpdns;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DNSNode {
    public String host;
    public boolean ipV6;
    public int port;

    public DNSNode(String str, int i) {
        this.host = str;
        this.port = i;
    }

    public DNSNode() {
    }
}
