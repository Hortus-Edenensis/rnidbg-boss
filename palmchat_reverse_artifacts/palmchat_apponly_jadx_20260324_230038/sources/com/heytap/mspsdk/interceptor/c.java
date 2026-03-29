package com.heytap.mspsdk.interceptor;

import com.heytap.mspsdk.log.MspLog;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c<REQUEST, RESPONSE> implements a<REQUEST, RESPONSE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<b<REQUEST, RESPONSE>> f6402a;
    int b;
    private final REQUEST c;

    public c(List<b<REQUEST, RESPONSE>> list, int i, REQUEST request) {
        this.f6402a = list;
        this.b = i;
        this.c = request;
    }

    @Override // com.heytap.mspsdk.interceptor.a
    public REQUEST a() {
        return this.c;
    }

    @Override // com.heytap.mspsdk.interceptor.a
    public RESPONSE a(REQUEST request) {
        int i = this.b;
        if (i < 0 || i >= this.f6402a.size()) {
            throw new IndexOutOfBoundsException("interceptors out bounds");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        b<REQUEST, RESPONSE> bVar = this.f6402a.get(this.b);
        RESPONSE responseA = bVar.a(new c(this.f6402a, this.b + 1, request));
        MspLog.iIgnore("StandardListChain", bVar.getClass().getSimpleName() + ", " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        return responseA;
    }
}
