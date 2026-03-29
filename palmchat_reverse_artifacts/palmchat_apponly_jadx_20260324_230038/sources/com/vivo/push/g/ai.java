package com.vivo.push.g;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class ai extends com.vivo.push.s {
    public ai(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        Context context = this.f11282a;
        if (context == null) {
            com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask " + vVar + " ; mContext is Null");
            return;
        }
        if (vVar == null) {
            com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        com.vivo.push.model.a aVarA = com.vivo.push.util.z.a(context, com.vivo.push.restructure.a.a().f());
        int iB = vVar.b();
        if (iB != 2009) {
            if (iB != 2011) {
                switch (iB) {
                    case 2002:
                    case 2003:
                    case 2004:
                    case 2005:
                        if (aVarA == null || aVarA.c()) {
                            com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).f(), 1005);
                        } else {
                            com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
                            int iA = com.vivo.push.util.x.a(cVar);
                            if (iA != 0) {
                                com.vivo.push.m.a().a(cVar.f(), iA);
                                return;
                            }
                        }
                        break;
                }
            } else {
                com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask pushCommand is " + ((com.vivo.push.b.w) vVar).d());
            }
        } else if (com.vivo.push.util.t.b()) {
            com.vivo.push.m.a();
            com.vivo.push.restructure.a.a().e().e();
            com.vivo.push.util.c cVar2 = new com.vivo.push.util.c();
            cVar2.a(this.f11282a, "com.vivo.push_preferences.hybridapptoken_v1");
            cVar2.b();
            new com.vivo.push.util.y(this.f11282a).b();
        }
        if (aVarA == null) {
            com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask " + vVar + " ; pushPkgInfo is Null");
            return;
        }
        String strA = aVarA.a();
        if (aVarA.c()) {
            try {
                com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).f(), 1004);
            } catch (Exception e) {
                e.printStackTrace();
            }
            vVar = new com.vivo.push.b.e();
            com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask " + vVar + " ; pkgName is InBlackList ");
        }
        com.vivo.push.a.a.a(this.f11282a, strA, vVar);
    }
}
