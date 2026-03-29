package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BDHttpDns.CompletionHandler f3352a;
    final /* synthetic */ BDHttpDnsResult.ResolveType b;
    final /* synthetic */ h.a c;
    final /* synthetic */ BDHttpDns d;

    public d(BDHttpDns bDHttpDns, BDHttpDns.CompletionHandler completionHandler, BDHttpDnsResult.ResolveType resolveType, h.a aVar) {
        this.d = bDHttpDns;
        this.f3352a = completionHandler;
        this.b = resolveType;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3352a.completionHandler(new BDHttpDnsResult(this.b, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.c.b(), this.c.c()));
    }
}
