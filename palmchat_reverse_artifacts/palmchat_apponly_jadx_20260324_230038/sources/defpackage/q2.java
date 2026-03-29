package defpackage;

import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import defpackage.jy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class q2 extends x1 {
    public q2(hy hyVar) {
        super(hyVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(jy jyVar, jy.a aVar) {
        if (!aVar.b) {
            i86.e(i86.c(R$string.dial_fail_because_biz, "updateState"), false, jyVar);
            return;
        }
        rh6 rh6VarD = this.c.d();
        if (rh6VarD == null) {
            return;
        }
        VoipState voipState = VoipState.ONTHECALL;
        rh6VarD.f20479a = voipState.getValue();
        s(voipState, rh6VarD);
        i86.e(rh6VarD, true, jyVar);
    }

    @Override // defpackage.x1, defpackage.wo2
    public VoipState getStatus() {
        return VoipState.ACCEPTED;
    }

    @Override // defpackage.x1, defpackage.wo2
    public void k(ry4 ry4Var, CallType callType, final jy jyVar) {
        if (this.b.b(ry4Var.c, ry4Var.f20624a, true) == 0) {
            r(ry4Var, VoipState.ONTHECALL, callType, new jy() { // from class: p2
                @Override // defpackage.jy
                public final void a(jy.a aVar) {
                    this.f19922a.u(jyVar, aVar);
                }
            });
        } else {
            i86.e(i86.c(R$string.dial_fail_because_rtc, "joinRoom"), false, jyVar);
        }
    }
}
