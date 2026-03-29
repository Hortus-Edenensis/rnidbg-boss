package defpackage;

import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import defpackage.jy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class jy4 extends x1 {
    public jy4(hy hyVar) {
        super(hyVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(ry4 ry4Var, CallType callType, jy jyVar, jy.a aVar) {
        if (!aVar.b) {
            i86.e(i86.c(R$string.dial_fail_because_biz, "accept"), false, jyVar);
            return;
        }
        this.b.x();
        this.b.p();
        this.b.k(false);
        rh6 rh6VarD = this.c.d();
        if (rh6VarD == null) {
            return;
        }
        VoipState voipState = VoipState.ACCEPTED;
        rh6VarD.f20479a = voipState.getValue();
        s(voipState, rh6VarD);
        this.c.b().k(ry4Var, callType, jyVar);
    }

    public static /* synthetic */ void x(jy jyVar, jy.a aVar) {
        i86.e(aVar.f18531a, aVar.b, jyVar);
    }

    public static /* synthetic */ void y(jy jyVar, jy.a aVar) {
        i86.e(aVar.f18531a, true, jyVar);
    }

    @Override // defpackage.x1, defpackage.wo2
    public VoipState getStatus() {
        return VoipState.RINGING;
    }

    @Override // defpackage.x1, defpackage.wo2
    public void i(final ry4 ry4Var, final CallType callType, final jy jyVar) {
        r(ry4Var, VoipState.ACCEPTED, callType, new jy() { // from class: iy4
            @Override // defpackage.jy
            public final void a(jy.a aVar) {
                this.f18291a.w(ry4Var, callType, jyVar, aVar);
            }
        });
    }

    @Override // defpackage.x1, defpackage.wo2
    public void j(ry4 ry4Var, CallType callType, final jy jyVar) {
        VoipState voipState = VoipState.UNAVAILABLE;
        er4.n(voipState, this.c.d());
        q(callType);
        r(ry4Var, voipState, callType, new jy() { // from class: hy4
            @Override // defpackage.jy
            public final void a(jy.a aVar) {
                jy4.y(jyVar, aVar);
            }
        });
    }

    @Override // defpackage.x1, defpackage.wo2
    public void l(ry4 ry4Var, CallType callType, final jy jyVar) {
        VoipState voipState = VoipState.REFUSED;
        er4.n(voipState, this.c.d());
        q(callType);
        r(ry4Var, voipState, callType, new jy() { // from class: gy4
            @Override // defpackage.jy
            public final void a(jy.a aVar) {
                jy4.x(jyVar, aVar);
            }
        });
    }
}
