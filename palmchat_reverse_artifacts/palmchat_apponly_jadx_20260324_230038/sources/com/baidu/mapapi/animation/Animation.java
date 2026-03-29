package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RepeatMode f3557a;
    int b;
    public BDAnimation bdAnimation;
    public BmAnimation bmAnimation;
    long c;

    /* JADX INFO: compiled from: SearchBox */
    public interface AnimationListener {
        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationRepeat();

        void onAnimationStart();
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum RepeatMode {
        RESTART,
        REVERSE
    }

    public abstract void cancel();

    public long getDuration() {
        return this.c;
    }

    public int getRepeatCount() {
        return this.b;
    }

    public RepeatMode getRepeatMode() {
        return this.f3557a;
    }

    public abstract void setAnimationListener(AnimationListener animationListener);

    public abstract void setDuration(long j);

    public abstract void setInterpolator(Interpolator interpolator);
}
