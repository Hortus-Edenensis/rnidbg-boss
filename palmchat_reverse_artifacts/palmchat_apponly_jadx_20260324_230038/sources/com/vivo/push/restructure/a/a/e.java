package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class e extends a<com.vivo.push.restructure.a.a> {
    public e(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("ClientDispatchNode", aVar, iVar);
    }

    private static PushMessageCallback b(com.vivo.push.restructure.a.a aVar) {
        try {
            return (PushMessageCallback) Class.forName(com.vivo.push.restructure.a.a().e().a(com.vivo.push.restructure.a.a().b(), aVar.b().getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            t.b("DispatchNode", "reflect e: ", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.restructure.a.a.a
    public int a(com.vivo.push.restructure.a.a aVar) {
        PushMessageCallback pushMessageCallbackB = b(aVar);
        if (pushMessageCallbackB == null) {
            return 2804;
        }
        int i = 0;
        if (aVar != null && aVar.g()) {
            com.vivo.push.restructure.request.d.a().a(aVar);
            return 0;
        }
        if (aVar != null) {
            int iL = aVar.l();
            String strM = aVar.m();
            if (iL == 3) {
                String strI = com.vivo.push.m.a().i();
                if (TextUtils.isEmpty(strI) || !TextUtils.equals(strI, strM)) {
                    i = 2810;
                }
            } else if (iL == 4) {
                com.vivo.push.m.a();
                if (!com.vivo.push.m.c().contains(strM)) {
                    i = 2811;
                }
            }
            if (i != 0) {
                com.vivo.push.util.g.a().execute(new f(this, iL, strM));
                return i;
            }
        }
        try {
            return com.vivo.push.m.a().a(aVar.b(), pushMessageCallbackB);
        } catch (Exception unused) {
            return 2808;
        }
    }
}
