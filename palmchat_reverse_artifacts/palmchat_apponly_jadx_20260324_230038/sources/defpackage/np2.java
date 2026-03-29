package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchConfig;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchEndCheckVo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchFeedbackVo;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchInfo;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface np2 {
    void A(io2<LXBaseNetBean<VoiceMatchFeedbackVo>> io2Var);

    boolean B();

    void C();

    void D(Runnable runnable);

    void E(boolean z, Runnable runnable);

    void F();

    void G(List<Integer> list, Runnable runnable);

    void a();

    void b(String str, HashMap<String, String> map);

    void c(Runnable runnable);

    boolean d();

    boolean e();

    void f(VoiceMatchEndCheckVo voiceMatchEndCheckVo);

    void g(Runnable runnable);

    boolean h();

    VoiceMatchConfig i();

    void j(VoiceMatchInfo voiceMatchInfo);

    void k(Runnable runnable);

    void l(boolean z);

    void m(Activity activity, int i, boolean z);

    void n(boolean z, long j, io2<LXBaseNetBean<VoiceMatchEndCheckVo>> io2Var);

    void o(Runnable runnable);

    void onEvent(String str);

    void p(Runnable runnable);

    void q(Runnable runnable);

    boolean r();

    void report();

    void s();

    boolean t();

    void u(Activity activity, int i, boolean z);

    List<String> v();

    void w(Runnable runnable);

    VoiceMatchInfo x();

    boolean y();

    void z(boolean z, Runnable runnable);
}
