package defpackage;

import com.volcengine.lxvertc.videocall.call.CallCmd;
import com.volcengine.lxvertc.videocall.call.CallType;
import com.volcengine.lxvertc.videocall.call.state.VoipState;
import com.zenmen.palmchat.lxvoip.vertc.R$string;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class oq2 extends x1 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements jo2<hc1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallCmd.a f19809a;
        public final /* synthetic */ jy b;

        public a(CallCmd.a aVar, jy jyVar) {
            this.f19809a = aVar;
            this.b = jyVar;
        }

        @Override // defpackage.jo2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(hc1 hc1Var) {
            rh6 rh6Var = hc1Var.d;
            int iB = oq2.this.b.b(rh6Var.d, rh6Var.c, false);
            if (iB != 0) {
                i86.e(i86.c(R$string.dial_fail_because_rtc, "errorCode:" + iB), false, this.b);
                return;
            }
            oq2.this.b.p();
            if (this.f19809a.f11317a == CallType.VIDEO) {
                oq2.this.b.t();
            }
            oq2.this.b.i();
            oq2.this.s(VoipState.CALLING, rh6Var);
            i86.e(hc1Var, true, this.b);
            y02.b();
        }

        @Override // defpackage.jo2
        public void onError(int i, String str) {
            i86.e(i86.c(R$string.dial_fail_because_biz, "errorCode:" + i + ",message:" + str), false, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements jo2<hc1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallCmd.a f19810a;
        public final /* synthetic */ jy b;

        public b(CallCmd.a aVar, jy jyVar) {
            this.f19810a = aVar;
            this.b = jyVar;
        }

        @Override // defpackage.jo2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(hc1 hc1Var) {
            rh6 rh6Var = hc1Var.d;
            int iB = oq2.this.b.b(rh6Var.d, rh6Var.c, false);
            if (iB != 0) {
                i86.e(i86.c(R$string.dial_fail_because_rtc, "errorCode:" + iB), false, this.b);
                return;
            }
            oq2.this.b.p();
            LogUtil.i("CallEngine", "join params.callType=" + this.f19810a.f11317a);
            CallType callType = this.f19810a.f11317a;
            CallType callType2 = CallType.VIDEO;
            if (callType == callType2) {
                oq2.this.b.t();
            }
            oq2.this.b.v();
            if (CallType.formValue(rh6Var.b) == callType2) {
                oq2.this.b.u();
            }
            oq2.this.b.k(false);
            RoomSDKInfo roomSDKInfo = this.f19810a.e;
            if (roomSDKInfo != null) {
                long j = roomSDKInfo.callSTime;
                if (j > 0) {
                    rh6Var.m = j;
                }
            }
            oq2.this.s(VoipState.ONTHECALL, rh6Var);
            y02.b();
            i86.e(hc1Var, true, this.b);
        }

        @Override // defpackage.jo2
        public void onError(int i, String str) {
            i86.e(i86.c(R$string.dial_fail_because_biz, "errorCode:" + i + ",message:" + str), false, this.b);
        }
    }

    public oq2(hy hyVar) {
        super(hyVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(CallCmd.a aVar, jy jyVar) {
        this.f21853a.a(aVar, new a(aVar, jyVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(CallCmd.a aVar, jy jyVar) {
        this.f21853a.a(aVar, new b(aVar, jyVar));
    }

    @Override // defpackage.x1, defpackage.wo2
    public void b(ry4 ry4Var, CallType callType) {
        this.b.i();
        if (callType == CallType.VIDEO) {
            this.b.t();
        }
        rh6 rh6VarD = this.c.d();
        VoipState voipState = VoipState.RINGING;
        rh6VarD.f20479a = voipState.getValue();
        s(voipState, rh6VarD);
        y02.b();
    }

    @Override // defpackage.x1, defpackage.wo2
    public void c(final CallCmd.a aVar, final jy jyVar) {
        rg.c().execute(new Runnable() { // from class: nq2
            @Override // java.lang.Runnable
            public final void run() {
                this.f19576a.v(aVar, jyVar);
            }
        });
    }

    @Override // defpackage.x1, defpackage.wo2
    public void e(final CallCmd.a aVar, final jy jyVar) {
        rg.c().execute(new Runnable() { // from class: mq2
            @Override // java.lang.Runnable
            public final void run() {
                this.f19292a.w(aVar, jyVar);
            }
        });
    }

    @Override // defpackage.x1, defpackage.wo2
    public VoipState getStatus() {
        return VoipState.IDLE;
    }
}
