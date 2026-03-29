package com.zenmen.media.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MagicVideoView extends FrameLayout implements IMagicMediaPlayer {
    private IMagicMediaPlayer mVideoView;

    public MagicVideoView(Context context) {
        super(context);
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        MagicVideoTextureView magicVideoTextureView = new MagicVideoTextureView(context, attributeSet, i);
        this.mVideoView = magicVideoTextureView;
        addView(magicVideoTextureView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public int getPosition() {
        IMagicMediaPlayer iMagicMediaPlayer = this.mVideoView;
        if (iMagicMediaPlayer != null) {
            return iMagicMediaPlayer.getPosition();
        }
        return 0;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public String getVideoPath() {
        return this.mVideoView.getVideoPath();
    }

    public IMagicMediaPlayer getVideoView() {
        return this.mVideoView;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public boolean isPlaying() {
        IMagicMediaPlayer iMagicMediaPlayer = this.mVideoView;
        if (iMagicMediaPlayer != null) {
            return iMagicMediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void mute(boolean z) {
        this.mVideoView.mute(z);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void pause() {
        this.mVideoView.pause();
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void release() {
        this.mVideoView.release();
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void seek(long j) {
        this.mVideoView.seek(j);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setLoop(boolean z) {
        this.mVideoView.setLoop(z);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setResumable(boolean z) {
        this.mVideoView.setResumable(z);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideo(String str) {
        this.mVideoView.setVideo(str);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideoAlpha(float f) {
        this.mVideoView.setVideoAlpha(f);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVideoStateChangeListener(VideoStateChangeListener videoStateChangeListener) {
        this.mVideoView.setVideoStateChangeListener(videoStateChangeListener);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        ((View) this.mVideoView).setVisibility(i);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void setVolume(float f, float f2) {
        this.mVideoView.setVolume(f, f2);
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void start() {
        this.mVideoView.start();
    }

    @Override // com.zenmen.media.player.IMagicMediaPlayer
    public void stop() {
        this.mVideoView.stop();
    }

    public MagicVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public MagicVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }
}
