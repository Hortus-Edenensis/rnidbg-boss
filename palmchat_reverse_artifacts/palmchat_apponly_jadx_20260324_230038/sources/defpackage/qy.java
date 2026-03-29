package defpackage;

import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import defpackage.jy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class qy extends x1 {
    public qy(hy hyVar) {
        super(hyVar);
    }

    public static /* synthetic */ void v(jy jyVar, jy.a aVar) {
        i86.e(aVar.f18531a, aVar.b, jyVar);
    }

    public static /* synthetic */ void w(jy jyVar, jy.a aVar) {
        i86.e(aVar.f18531a, aVar.b, jyVar);
    }

    @Override // defpackage.x1, defpackage.wo2
    public void d(ry4 ry4Var, CallType callType, jy jyVar) {
        this.b.x();
        this.b.v();
        if (callType == CallType.VIDEO) {
            this.b.u();
        }
        this.b.k(false);
        rh6 rh6VarD = this.c.d();
        VoipState voipState = VoipState.ONTHECALL;
        rh6VarD.f20479a = voipState.getValue();
        s(voipState, rh6VarD);
    }

    @Override // defpackage.x1, defpackage.wo2
    public void g(ry4 ry4Var, CallType callType, final jy jyVar) {
        VoipState voipState = VoipState.CANCELLED;
        er4.n(voipState, this.c.d());
        q(callType);
        r(ry4Var, voipState, callType, new jy() { // from class: py
            @Override // defpackage.jy
            public final void a(jy.a aVar) {
                qy.v(jyVar, aVar);
            }
        });
    }

    @Override // defpackage.x1, defpackage.wo2
    public VoipState getStatus() {
        return VoipState.CALLING;
    }

    @Override // defpackage.x1, defpackage.wo2
    public void j(ry4 ry4Var, CallType callType, final jy jyVar) {
        VoipState voipState = VoipState.UNAVAILABLE;
        er4.n(voipState, this.c.d());
        q(callType);
        r(ry4Var, voipState, callType, new jy() { // from class: oy
            @Override // defpackage.jy
            public final void a(jy.a aVar) {
                qy.w(jyVar, aVar);
            }
        });
    }
}
