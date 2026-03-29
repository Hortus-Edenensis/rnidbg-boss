package defpackage;

import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface wo2 {
    void a(ry4 ry4Var, CallType callType, jy jyVar);

    void b(ry4 ry4Var, CallType callType);

    void c(CallCmd.a aVar, jy jyVar);

    void d(ry4 ry4Var, CallType callType, jy jyVar);

    void e(CallCmd.a aVar, jy jyVar);

    void f(ry4 ry4Var, CallType callType, jy jyVar);

    void g(ry4 ry4Var, CallType callType, jy jyVar);

    VoipState getStatus();

    void h(ry4 ry4Var, CallType callType);

    void i(ry4 ry4Var, CallType callType, jy jyVar);

    void j(ry4 ry4Var, CallType callType, jy jyVar);

    void k(ry4 ry4Var, CallType callType, jy jyVar);

    void l(ry4 ry4Var, CallType callType, jy jyVar);
}
