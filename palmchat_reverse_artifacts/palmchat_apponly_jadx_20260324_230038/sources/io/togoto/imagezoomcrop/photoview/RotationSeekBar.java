package io.togoto.imagezoomcrop.photoview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RotationSeekBar extends SeekBar {
    private static final int DEFAULT_MAX = 3600;
    private static final int DEFAULT_PROGRESS = 1800;
    private OnRotationSeekBarChangeListener mRotationListener;

    public RotationSeekBar(Context context) {
        super(context);
        init();
    }

    private static int fromDegreesToProgress(float f) {
        return (int) ((f + 180.0f) * 10.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float fromProgressToDegrees(int i) {
        return (i - 1800) / 10.0f;
    }

    private void init() {
        setMax(3600);
        setProgress(1800);
    }

    public float getRotationProgress() {
        return fromProgressToDegrees(getProgress());
    }

    public void reset() {
        init();
        this.mRotationListener.resetPreviousProgress();
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        if (onSeekBarChangeListener != null && !(onSeekBarChangeListener instanceof OnRotationSeekBarChangeListener)) {
            throw new IllegalArgumentException("Use OnRotationSeekBarChangeListener");
        }
        this.mRotationListener = (OnRotationSeekBarChangeListener) onSeekBarChangeListener;
        super.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    public void setRotationProgress(float f) {
        if (f < -180.0f || f > 180.0f) {
            throw new IllegalArgumentException("Invalid rotation value");
        }
        if (f == 0.0f) {
            reset();
        } else {
            setProgress(fromDegreesToProgress(f));
        }
    }

    public RotationSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RotationSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public RotationSeekBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class OnRotationSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        private float mPreviousProgress;

        public OnRotationSeekBarChangeListener(@NonNull RotationSeekBar rotationSeekBar) {
            this.mPreviousProgress = rotationSeekBar.getProgress();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            float fFromProgressToDegrees = RotationSeekBar.fromProgressToDegrees(i);
            float f = i;
            onRotationProgressChanged((RotationSeekBar) seekBar, fFromProgressToDegrees, (f - this.mPreviousProgress) / 10.0f, z);
            this.mPreviousProgress = f;
        }

        public abstract void onRotationProgressChanged(@NonNull RotationSeekBar rotationSeekBar, float f, float f2, boolean z);

        public void resetPreviousProgress() {
            this.mPreviousProgress = 1800.0f;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
