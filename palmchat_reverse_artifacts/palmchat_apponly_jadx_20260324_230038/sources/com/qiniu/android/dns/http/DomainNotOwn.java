package com.qiniu.android.dns.http;

import com.qiniu.android.dns.DnsException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DomainNotOwn extends DnsException {
    public DomainNotOwn(String str) {
        super(str, "dns not own");
    }
}
