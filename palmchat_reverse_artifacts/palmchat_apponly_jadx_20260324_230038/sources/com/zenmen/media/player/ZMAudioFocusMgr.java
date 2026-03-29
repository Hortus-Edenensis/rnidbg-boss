package com.zenmen.media.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ZMAudioFocusMgr {
    private ZMAudioFocusPolicy mAudioPolicy;
    private boolean mRequested;

    public ZMAudioFocusMgr(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            this.mAudioPolicy = new AudioFocusPolicy_Below_Target26(context, onAudioFocusChangeListener, i, i2);
        } else {
            this.mAudioPolicy = new AudioFocusPolicy_Above_Target26(context, onAudioFocusChangeListener, i, i2);
        }
        this.mRequested = false;
    }

    public int abandonAudioFocus() {
        ZMAudioFocusPolicy zMAudioFocusPolicy = this.mAudioPolicy;
        if (zMAudioFocusPolicy == null) {
            return -1;
        }
        if (!this.mRequested) {
            return 0;
        }
        this.mRequested = false;
        return zMAudioFocusPolicy.abandonAudioFocus();
    }

    public int requestAudioFocuse() {
        ZMAudioFocusPolicy zMAudioFocusPolicy = this.mAudioPolicy;
        if (zMAudioFocusPolicy == null) {
            return -1;
        }
        if (this.mRequested) {
            return 0;
        }
        if (zMAudioFocusPolicy.requestAudioFocuse() != 0) {
            return -1;
        }
        this.mRequested = true;
        return 0;
    }
}
