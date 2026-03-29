package com.zenmen.palmchat.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AdVideoView extends VideoView {
    private int measureHeight;
    private int measureWith;
    private a playPauseListener;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public AdVideoView(Context context) {
        super(context);
        this.measureWith = 0;
        this.measureHeight = 0;
        init(context);
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        try {
            return super.canPause();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        try {
            return super.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int i4 = this.measureWith;
        if (i4 == 0 || (i3 = this.measureHeight) == 0) {
            return;
        }
        setMeasuredDimension(i4, i3);
    }

    @Override // android.widget.VideoView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        try {
            super.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        try {
            super.seekTo(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMeasure(int i, int i2) {
        this.measureWith = i;
        this.measureHeight = i2;
    }

    @Override // android.widget.VideoView, android.widget.MediaController.MediaPlayerControl
    public void start() {
        try {
            super.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AdVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.measureWith = 0;
        this.measureHeight = 0;
        init(context);
    }

    public AdVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.measureWith = 0;
        this.measureHeight = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public void setPlayPauseListener(a aVar) {
    }
}
