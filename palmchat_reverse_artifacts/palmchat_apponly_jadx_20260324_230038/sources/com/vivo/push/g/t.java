package com.vivo.push.g;

import com.vivo.push.model.UnvarnishedMessage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class t extends aa {
    public t(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.o oVar = (com.vivo.push.b.o) vVar;
        UnvarnishedMessage unvarnishedMessageE = oVar.e();
        if (unvarnishedMessageE != null && unvarnishedMessageE.isTransMsgArrive()) {
            com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(oVar.g())));
        }
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f11282a), oVar.d(), oVar.j())) {
            super.a(1021);
            return;
        }
        if (unvarnishedMessageE == null) {
            super.a(2807);
            com.vivo.push.util.t.a("OnMessageTask", " message is null");
            return;
        }
        if (unvarnishedMessageE.isTransMsgExpired()) {
            com.vivo.push.util.t.d("OnMessageTask", "tragetType is Expired msg =" + unvarnishedMessageE.getMsgId());
            ((aa) this).b.onTransmissionMessageExpired(unvarnishedMessageE);
            super.a(0);
            return;
        }
        com.vivo.push.util.t.d("OnMessageTask", "tragetType is " + unvarnishedMessageE.getTargetType() + " ; messageId is " + unvarnishedMessageE.getMsgId());
        ((aa) this).b.onTransmissionMessage(this.f11282a, unvarnishedMessageE);
        super.a(0);
    }
}
