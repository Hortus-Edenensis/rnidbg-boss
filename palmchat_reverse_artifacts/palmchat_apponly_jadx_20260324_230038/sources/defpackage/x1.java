package defpackage;

import android.util.Log;
import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class x1 implements wo2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sa6 f21853a = com.volcengine.lxvertc.videocall.call.a.t().y();
    public final dr4 b = com.volcengine.lxvertc.videocall.call.a.t().w();
    public hy c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jo2<tr> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jy f21854a;

        public a(jy jyVar) {
            this.f21854a = jyVar;
        }

        @Override // defpackage.jo2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(tr trVar) {
            int i = trVar.f21045a;
            if (i == 0) {
                i86.e(trVar, true, this.f21854a);
            } else {
                x1.this.o(i, trVar.c, this.f21854a);
            }
        }

        @Override // defpackage.jo2
        public void onError(int i, String str) {
            x1.this.o(i, str, this.f21854a);
        }
    }

    public x1(hy hyVar) {
        this.c = hyVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(ry4 ry4Var, CallType callType, VoipState voipState, jy jyVar) {
        this.f21853a.b(ry4Var, callType, voipState, new a(jyVar));
    }

    @Override // defpackage.wo2
    public void a(ry4 ry4Var, CallType callType, jy jyVar) {
        LogUtil.i("RTC", "onRTCStateChanged " + getStatus());
        VoipState status = getStatus();
        VoipState voipState = VoipState.ONTHECALL;
        if (status == voipState) {
            return;
        }
        this.b.x();
        this.b.k(false);
        this.b.v();
        if (callType == CallType.VIDEO) {
            this.b.u();
        }
        rh6 rh6VarD = this.c.d();
        if (rh6VarD == null) {
            return;
        }
        rh6VarD.f20479a = voipState.getValue();
        s(voipState, rh6VarD);
        i86.e(rh6VarD, true, jyVar);
    }

    @Override // defpackage.wo2
    public void b(ry4 ry4Var, CallType callType) {
        p("onReceiveRinging", null);
    }

    @Override // defpackage.wo2
    public void c(CallCmd.a aVar, jy jyVar) {
        p("dial", jyVar);
    }

    @Override // defpackage.wo2
    public void d(ry4 ry4Var, CallType callType, jy jyVar) {
        p("onReceiveAccepted", jyVar);
    }

    @Override // defpackage.wo2
    public void e(CallCmd.a aVar, jy jyVar) {
        p("join", jyVar);
    }

    @Override // defpackage.wo2
    public void f(ry4 ry4Var, CallType callType, jy jyVar) {
        p("hangup", jyVar);
    }

    @Override // defpackage.wo2
    public void g(ry4 ry4Var, CallType callType, jy jyVar) {
        p("cancel", jyVar);
    }

    @Override // defpackage.wo2
    public abstract VoipState getStatus();

    @Override // defpackage.wo2
    public void h(ry4 ry4Var, CallType callType) {
        q(callType);
    }

    @Override // defpackage.wo2
    public void i(ry4 ry4Var, CallType callType, jy jyVar) {
        p("accept", jyVar);
    }

    @Override // defpackage.wo2
    public void j(ry4 ry4Var, CallType callType, jy jyVar) {
        p(WkAdConfigModel.TAG_TIMEOUT, jyVar);
    }

    @Override // defpackage.wo2
    public void k(ry4 ry4Var, CallType callType, jy jyVar) {
        p("joinRTCRoom", jyVar);
    }

    @Override // defpackage.wo2
    public void l(ry4 ry4Var, CallType callType, jy jyVar) {
        p("refuse", jyVar);
    }

    public void o(int i, String str, jy jyVar) {
        String strC = i86.c(R$string.dial_fail_because_biz, "errorCode:" + i + ",message:" + str);
        StringBuilder sb = new StringBuilder();
        sb.append("AbstractState notifyExecFailed msg");
        sb.append(strC);
        Log.d("AbstractState", sb.toString());
        i86.e(strC, false, jyVar);
    }

    public final void p(String str, jy jyVar) {
        Log.d("AbstractState", i86.c(R$string.exec_fail_because_status, getStatus().getName(), str));
    }

    public void q(CallType callType) {
        this.b.x();
        this.b.D();
        this.b.w();
        this.b.A();
        if (callType == CallType.VIDEO) {
            this.b.y();
            this.b.z();
        }
        s(VoipState.IDLE, null);
        y02.a();
    }

    public void r(final ry4 ry4Var, final VoipState voipState, final CallType callType, final jy jyVar) {
        rg.c().execute(new Runnable() { // from class: w1
            @Override // java.lang.Runnable
            public final void run() {
                this.f21581a.n(ry4Var, callType, voipState, jyVar);
            }
        });
    }

    public void s(VoipState voipState, rh6 rh6Var) {
        wo2 wo2VarA;
        LogUtil.i("RTC", "updateState " + voipState + " voipInfo=" + rh6Var);
        hy hyVar = this.c;
        if (hyVar == null || (wo2VarA = hyVar.a(voipState)) == null) {
            return;
        }
        this.c.c(wo2VarA, rh6Var);
    }
}
