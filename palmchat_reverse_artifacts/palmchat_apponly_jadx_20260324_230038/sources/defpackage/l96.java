package defpackage;

import android.app.Application;
import com.volcengine.lxvertc.videocall.call.state.VoipState;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class l96 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18943a = um0.a();
    public static final String b = null;
    public static ex c = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends o0 {
        @Override // gy.b
        public void g(VoipState voipState, VoipState voipState2, rh6 rh6Var) {
            if (voipState2 == VoipState.RINGING) {
                return;
            }
            VoipState voipState3 = VoipState.IDLE;
        }
    }

    public static void a(Application application, m96 m96Var) {
        fh.b(application);
        eb3.f(m96Var);
    }

    public static void b(String str) {
        com.volcengine.lxvertc.videocall.call.a aVarT = com.volcengine.lxvertc.videocall.call.a.t();
        aVarT.C(f18943a, str);
        aVarT.o(c);
    }
}
