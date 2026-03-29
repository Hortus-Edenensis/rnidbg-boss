package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i {
    private AudioManager aPn;
    private AudioManager.OnAudioFocusChangeListener bdF = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.i.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (i.this.ke == null) {
                return;
            }
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.i.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        i.this.ke.onAudioBeOccupied();
                    } else {
                        i.this.ke.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a ke;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public i(Context context) {
        this.aPn = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest Rv() {
        return defpackage.ak.a(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.bdF).build();
    }

    public final boolean Ru() {
        AudioManager audioManager;
        try {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.bdF;
            if (onAudioFocusChangeListener != null && (audioManager = this.aPn) != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return 1 == audioManager.requestAudioFocus(Rv());
                }
                if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final void c(a aVar) {
        this.ke = aVar;
    }
}
