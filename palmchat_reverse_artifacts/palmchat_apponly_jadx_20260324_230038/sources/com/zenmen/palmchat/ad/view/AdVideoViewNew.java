package com.zenmen.palmchat.ad.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.MediaController;
import com.zenmen.media.player.MagicTextureMediaPlayer;
import defpackage.z6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdVideoViewNew extends MagicTextureMediaPlayer implements MediaController.MediaPlayerControl {
    private String cachePath;
    private a playPauseListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public AdVideoViewNew(Context context) {
        super(context);
        this.cachePath = null;
        init(context);
    }

    private void init(Context context) {
        setVieOrientation(2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    public String getCachePath() {
        return this.cachePath;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return getPosition();
    }

    @Override // com.zenmen.media.player.MagicTextureMediaPlayer, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        try {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            setLayoutParams(layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.zenmen.media.player.MagicTextureMediaPlayer, com.zenmen.media.player.IMagicMediaPlayer
    public void pause() {
        try {
            super.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        seek(i);
    }

    @Override // com.zenmen.media.player.MagicTextureMediaPlayer
    public void setCachePath(String str) {
        super.setCachePath(str);
        this.cachePath = str;
    }

    public void setVideoPath(String str) {
        setVideoPath(str, z6.d().f());
    }

    @Override // com.zenmen.media.player.MagicTextureMediaPlayer, com.zenmen.media.player.IMagicMediaPlayer
    public void start() {
        try {
            super.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVideoPath(String str, String str2) {
        if (str2 != null) {
            setCachePath(str2);
        }
        setVideo(str);
    }

    public AdVideoViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cachePath = null;
        init(context);
    }

    public AdVideoViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cachePath = null;
        init(context);
    }

    public void setPlayPauseListener(a aVar) {
    }
}
