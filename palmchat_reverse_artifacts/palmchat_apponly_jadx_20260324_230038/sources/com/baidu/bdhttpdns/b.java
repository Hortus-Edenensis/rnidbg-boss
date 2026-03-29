package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BDHttpDns.CompletionHandler f3350a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ BDHttpDns c;

    public b(BDHttpDns bDHttpDns, BDHttpDns.CompletionHandler completionHandler, ArrayList arrayList) {
        this.c = bDHttpDns;
        this.f3350a = completionHandler;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3350a.completionHandler(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.b));
    }
}
