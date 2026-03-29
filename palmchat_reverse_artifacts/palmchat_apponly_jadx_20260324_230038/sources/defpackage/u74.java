package defpackage;

import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import defpackage.jy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u74 extends x1 {
    public u74(hy hyVar) {
        super(hyVar);
    }

    public static /* synthetic */ void u(jy jyVar, jy.a aVar) {
        i86.e(aVar.f18531a, aVar.b, jyVar);
    }

    @Override // defpackage.x1, defpackage.wo2
    public void f(ry4 ry4Var, CallType callType, final jy jyVar) {
        VoipState voipState = VoipState.TERMINATED;
        er4.n(voipState, this.c.d());
        q(callType);
        r(ry4Var, voipState, callType, new jy() { // from class: t74
            @Override // defpackage.jy
            public final void a(jy.a aVar) {
                u74.u(jyVar, aVar);
            }
        });
    }

    @Override // defpackage.x1, defpackage.wo2
    public VoipState getStatus() {
        return VoipState.ONTHECALL;
    }

    @Override // defpackage.x1, defpackage.wo2
    public void d(ry4 ry4Var, CallType callType, jy jyVar) {
    }
}
