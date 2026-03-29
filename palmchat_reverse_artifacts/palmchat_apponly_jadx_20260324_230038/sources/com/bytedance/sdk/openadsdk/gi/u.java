package com.bytedance.sdk.openadsdk.gi;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.sdk.openadsdk.core.dw;
import defpackage.ak;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private AudioManager.OnAudioFocusChangeListener b;
    private AudioManager fx;
    private AudioFocusRequest nr;
    private boolean pn;
    private AudioAttributes u;

    public u() {
        this.pn = false;
        boolean zM = dw.nr().m();
        this.pn = zM;
        if (zM) {
            this.b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.gi.u.1
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public void onAudioFocusChange(int i) {
                }
            };
            this.fx = (AudioManager) dw.getContext().getSystemService("audio");
        }
    }

    public void nr() {
        if (this.pn) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioManager audioManager = this.fx;
                if (audioManager != null) {
                    audioManager.abandonAudioFocusRequest(this.nr);
                    return;
                }
                return;
            }
            AudioManager audioManager2 = this.fx;
            if (audioManager2 != null) {
                audioManager2.abandonAudioFocus(this.b);
            }
        }
    }

    public int u() {
        if (!this.pn) {
            return -1;
        }
        int i = Build.VERSION.SDK_INT;
        this.u = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        if (i < 26) {
            AudioManager audioManager = this.fx;
            if (audioManager != null) {
                return audioManager.requestAudioFocus(this.b, 3, 2);
            }
            return -1;
        }
        AudioFocusRequest audioFocusRequestBuild = ak.a(2).setWillPauseWhenDucked(true).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.b).setAudioAttributes(this.u).build();
        this.nr = audioFocusRequestBuild;
        AudioManager audioManager2 = this.fx;
        if (audioManager2 != null) {
            return audioManager2.requestAudioFocus(audioFocusRequestBuild);
        }
        return -1;
    }
}
