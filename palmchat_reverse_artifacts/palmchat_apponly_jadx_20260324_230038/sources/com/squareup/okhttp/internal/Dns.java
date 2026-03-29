package com.squareup.okhttp.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface Dns {
    public static final Dns DEFAULT = new Dns() { // from class: com.squareup.okhttp.internal.Dns.1
        @Override // com.squareup.okhttp.internal.Dns
        public InetAddress[] getAllByName(String str) throws UnknownHostException {
            return InetAddress.getAllByName(str);
        }
    };

    InetAddress[] getAllByName(String str) throws UnknownHostException;
}
