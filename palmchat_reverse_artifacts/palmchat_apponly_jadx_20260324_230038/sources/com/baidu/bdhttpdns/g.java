package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.f;
import com.baidu.bdhttpdns.h;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BDHttpDns.CompletionHandler f3356a;
    private final BDHttpDns b;
    private final h c;

    public g(Context context, BDHttpDns.CompletionHandler completionHandler) {
        this.f3356a = completionHandler;
        BDHttpDns service = BDHttpDns.getService(context);
        this.b = service;
        this.c = service.b();
    }

    @Override // com.baidu.bdhttpdns.f.a
    public void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str) {
        if (i == -1) {
            l.a("Async resolve failed, host(%s), dns resolve failed", str);
            BDHttpDns.CompletionHandler completionHandler = this.f3356a;
            if (completionHandler != null) {
                completionHandler.completionHandler(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONE, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve, arrayList, arrayList2));
                return;
            }
            return;
        }
        if (i != 0) {
            l.a("Internal error: async dns resolve completion get error ret(%d)", Integer.valueOf(i));
            return;
        }
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = arrayList != null ? arrayList.toString() : null;
        objArr[2] = arrayList2 != null ? arrayList2.toString() : null;
        BDHttpDnsResult.ResolveType resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS;
        objArr[3] = resolveType.toString();
        l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
        h.a aVar = new h.a();
        aVar.a(60L);
        aVar.b(System.currentTimeMillis() / 1000);
        aVar.a(arrayList);
        aVar.b(arrayList2);
        this.c.a(str, aVar);
        BDHttpDns.CompletionHandler completionHandler2 = this.f3356a;
        if (completionHandler2 != null) {
            completionHandler2.completionHandler(new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2));
        }
    }
}
