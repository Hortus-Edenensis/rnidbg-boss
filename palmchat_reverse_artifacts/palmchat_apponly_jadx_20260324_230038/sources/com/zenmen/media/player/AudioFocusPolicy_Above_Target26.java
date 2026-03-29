package com.zenmen.media.player;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import androidx.annotation.RequiresApi;
import defpackage.ak;
import defpackage.tj;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
class AudioFocusPolicy_Above_Target26 extends ZMAudioFocusPolicy {
    AudioFocusRequest mFocusRequest;

    @RequiresApi(api = 26)
    public AudioFocusPolicy_Above_Target26(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i, int i2) {
        super(context, onAudioFocusChangeListener, i, i2);
        this.mFocusRequest = null;
        try {
            AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(i).build();
            tj.a();
            this.mFocusRequest = ak.a(this.mDurationHint).setAudioAttributes(audioAttributesBuild).setOnAudioFocusChangeListener(this.mListener).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.media.player.ZMAudioFocusPolicy
    @RequiresApi(api = 26)
    public int abandonAudioFocus() {
        try {
            AudioManager audioManager = this.mAudioMgr;
            if (audioManager == null) {
                return 0;
            }
            audioManager.abandonAudioFocusRequest(this.mFocusRequest);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.zenmen.media.player.ZMAudioFocusPolicy
    @RequiresApi(api = 26)
    public int requestAudioFocuse() {
        AudioManager audioManager;
        try {
            audioManager = this.mAudioMgr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        int iRequestAudioFocus = audioManager != null ? audioManager.requestAudioFocus(this.mFocusRequest) : 0;
        synchronized (this.mFocusLock) {
            try {
                if (iRequestAudioFocus == 0) {
                    return -1;
                }
                if (iRequestAudioFocus == 1) {
                    return 0;
                }
                return iRequestAudioFocus == 2 ? -1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
