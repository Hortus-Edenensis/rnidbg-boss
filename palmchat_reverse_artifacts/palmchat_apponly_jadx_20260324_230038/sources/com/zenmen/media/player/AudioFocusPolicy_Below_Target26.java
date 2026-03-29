package com.zenmen.media.player;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
class AudioFocusPolicy_Below_Target26 extends ZMAudioFocusPolicy {
    public AudioFocusPolicy_Below_Target26(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i, int i2) {
        super(context, onAudioFocusChangeListener, i, i2);
    }

    @Override // com.zenmen.media.player.ZMAudioFocusPolicy
    public int abandonAudioFocus() {
        try {
            AudioManager audioManager = this.mAudioMgr;
            if (audioManager == null) {
                return 0;
            }
            audioManager.abandonAudioFocus(this.mListener);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.zenmen.media.player.ZMAudioFocusPolicy
    public int requestAudioFocuse() {
        try {
            AudioManager audioManager = this.mAudioMgr;
            if (audioManager == null) {
                return 0;
            }
            audioManager.requestAudioFocus(this.mListener, this.mStreamType, this.mDurationHint);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
