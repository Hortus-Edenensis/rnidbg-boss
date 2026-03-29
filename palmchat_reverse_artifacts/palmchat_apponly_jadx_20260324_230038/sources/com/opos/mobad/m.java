package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.cmn.func.adhandler.UnlockHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class m extends n {
    public m(Context context, int i) {
        super(new q(), new g(), new com.opos.mobad.activity.webview.a() { // from class: com.opos.mobad.m.1
            @Override // com.opos.mobad.activity.webview.a
            public com.opos.mobad.activity.webview.a.b a(Activity activity, com.opos.cmn.biz.web.c.b.c cVar, com.opos.mobad.activity.webview.b.b bVar) {
                return new com.opos.mobad.activity.webview.a.b(activity, cVar, bVar);
            }
        }, new o(), new UnlockHandler(context));
    }
}
