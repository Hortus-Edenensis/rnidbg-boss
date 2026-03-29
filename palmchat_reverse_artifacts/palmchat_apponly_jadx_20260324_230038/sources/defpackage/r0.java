package defpackage;

import com.zenmen.palmchat.paidservices.voicematch.VoiceMatchState;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class r0 implements xm2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20368a = false;
    public boolean b = false;

    @Override // defpackage.xm2
    public abstract void a(VoiceMatchState voiceMatchState);

    public void c() {
        if (this.b) {
            this.b = false;
            b().setVisibility(8);
        }
    }

    public void d() {
        this.f20368a = true;
    }

    public void e() {
        if (this.b) {
            return;
        }
        this.b = true;
        if (!this.f20368a) {
            d();
        }
        b().setVisibility(0);
        a(lh6.V().b0());
    }

    @Override // defpackage.xm2
    public void onPause() {
    }

    @Override // defpackage.xm2
    public void onResume() {
    }
}
