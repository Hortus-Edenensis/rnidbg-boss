package com.zenmen.media.player;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
abstract class ZMAudioFocusPolicy {
    protected AudioManager mAudioMgr;
    protected Context mContext;
    protected int mDurationHint;
    final Object mFocusLock = new Object();
    protected AudioManager.OnAudioFocusChangeListener mListener;
    protected int mStreamType;

    public ZMAudioFocusPolicy(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i, int i2) {
        this.mAudioMgr = null;
        this.mContext = context;
        this.mStreamType = i;
        this.mDurationHint = i2;
        this.mListener = onAudioFocusChangeListener;
        try {
            this.mAudioMgr = (AudioManager) context.getSystemService("audio");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int abandonAudioFocus() {
        return 0;
    }

    public int requestAudioFocuse() {
        return 0;
    }
}
