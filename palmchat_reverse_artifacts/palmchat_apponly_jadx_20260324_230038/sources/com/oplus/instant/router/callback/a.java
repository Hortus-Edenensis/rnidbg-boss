package com.oplus.instant.router.callback;

import com.oplus.instant.router.callback.Callback;
import defpackage.aw6;
import defpackage.h87;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends Callback {
    public Callback c;

    public void a(Callback callback) {
        if (callback == null) {
            callback = new b();
        }
        this.c = callback;
    }

    @Override // com.oplus.instant.router.callback.Callback
    public void onResponse(Callback.Response response) {
        if (1 != response.getCode()) {
            HashMap map = new HashMap();
            map.put("failMsg", response.getMsg());
            aw6.a().c().onStat(map);
        }
        h87.e("router_response", response.toString());
        Callback callback = this.c;
        if (callback != null) {
            callback.onResponse(response);
            this.c = null;
        }
    }
}
