package androidx.media3.exoplayer;

import android.media.AudioManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements AudioManager.OnAudioFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioFocusManager f1377a;

    public /* synthetic */ d(AudioFocusManager audioFocusManager) {
        this.f1377a = audioFocusManager;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.f1377a.handlePlatformAudioFocusChange(i);
    }
}
