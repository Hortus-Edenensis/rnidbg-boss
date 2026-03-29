package com.baidu.platform.comapi.bmsdk.animation;

import com.baidu.mapapi.animation.Animation;
import com.baidu.platform.comapi.bmsdk.BmObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BmAnimation extends BmObject {
    private static final int ABSOLUTE = 0;
    private static final int END = 2;
    public static final int FILL_AFTER = 2;
    public static final int FILL_BEFORE = 0;
    public static final int FILL_FIRST = 1;
    public static final int INFINITE = -1;
    private static final int RELATIVE_TO_SELF = 1;
    private static final int REPEAT = 3;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final int START = 1;
    private static final int START_ON_FIRST_FRAME = -1;
    private static Object sync = new Object();
    private static List<WeakReference<BmAnimation>> wkListenerAnimations = new ArrayList();
    public Animation.AnimationListener animationListener;
    long mDuration;
    private String mExtParam;
    int mFillMode;
    private com.baidu.platform.comapi.bmsdk.animation.a mInterpolator;
    private a mListener;
    int mRepeatCount;
    long mRepeatDelay;
    int mRepeatMode;
    long mStartDelay;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(BmAnimation bmAnimation);

        void b(BmAnimation bmAnimation);

        void c(BmAnimation bmAnimation);
    }

    private BmAnimation() {
        super(80, 0L);
        this.mFillMode = 0;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.mExtParam = "";
    }

    private static void addAnimation(BmAnimation bmAnimation) {
        if (bmAnimation == null) {
            return;
        }
        synchronized (sync) {
            boolean z = true;
            int size = wkListenerAnimations.size() - 1;
            while (true) {
                if (size >= 0) {
                    BmAnimation bmAnimation2 = wkListenerAnimations.get(size).get();
                    if (bmAnimation2 != null && bmAnimation2 == bmAnimation) {
                        break;
                    } else {
                        size--;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                wkListenerAnimations.add(new WeakReference<>(bmAnimation));
            }
        }
    }

    public static boolean dispatchAnimationListener(long j, int i) {
        a aVar;
        synchronized (sync) {
            for (int size = wkListenerAnimations.size() - 1; size >= 0; size--) {
                BmAnimation bmAnimation = wkListenerAnimations.get(size).get();
                if (bmAnimation == null) {
                    wkListenerAnimations.remove(size);
                } else if (bmAnimation.nativeInstance == j && (aVar = bmAnimation.mListener) != null) {
                    if (i == 1) {
                        aVar.a(bmAnimation);
                    } else if (i == 2) {
                        aVar.b(bmAnimation);
                    } else if (i == 3) {
                        aVar.c(bmAnimation);
                    }
                }
            }
        }
        return true;
    }

    private static native boolean nativeCancel(long j);

    private static native boolean nativePause(long j);

    private static native boolean nativeReset(long j);

    private static native boolean nativeResume(long j);

    private static native boolean nativeSetDuration(long j, long j2);

    private static native boolean nativeSetFillMode(long j, int i);

    private static native boolean nativeSetInterpolator(long j, long j2);

    private static native boolean nativeSetListener(long j, boolean z);

    private static native boolean nativeSetRepeatCount(long j, int i);

    private static native boolean nativeSetRepeatDelay(long j, long j2);

    private static native boolean nativeSetRepeatMode(long j, int i);

    private static native boolean nativeSetStartDelay(long j, long j2);

    private static native boolean nativeSetStartTime(long j, long j2);

    public boolean cancel() {
        return nativeCancel(this.nativeInstance);
    }

    public String getExtParam() {
        return this.mExtParam;
    }

    public boolean pause() {
        return nativePause(this.nativeInstance);
    }

    public boolean reset() {
        return nativeReset(this.nativeInstance);
    }

    public boolean resume() {
        return nativeResume(this.nativeInstance);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.animationListener = animationListener;
    }

    public boolean setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative");
        }
        this.mDuration = j;
        return nativeSetDuration(this.nativeInstance, j);
    }

    public void setExtParam(String str) {
        this.mExtParam = str;
    }

    public boolean setFillMode(int i) {
        this.mFillMode = i;
        return nativeSetFillMode(this.nativeInstance, i);
    }

    public boolean setInterpolator(com.baidu.platform.comapi.bmsdk.animation.a aVar) {
        this.mInterpolator = aVar;
        return nativeSetInterpolator(this.nativeInstance, aVar == null ? 0L : aVar.getNativeInstance());
    }

    public boolean setRepeatCount(int i) {
        if (i < 0) {
            i = -1;
        }
        this.mRepeatCount = i;
        return nativeSetRepeatCount(this.nativeInstance, i);
    }

    public boolean setRepeatDelay(long j) {
        this.mRepeatDelay = j;
        return nativeSetRepeatDelay(this.nativeInstance, j);
    }

    public boolean setRepeatMode(int i) {
        this.mRepeatMode = i;
        return nativeSetRepeatMode(this.nativeInstance, i);
    }

    public boolean setStartDelay(long j) {
        this.mStartDelay = j;
        return nativeSetStartDelay(this.nativeInstance, j);
    }

    public boolean setStartTime(long j) {
        return nativeSetStartTime(this.nativeInstance, j);
    }

    public boolean start() {
        return setStartTime(-1L);
    }

    public boolean setAnimationListener(a aVar) {
        this.mListener = aVar;
        if (aVar != null) {
            addAnimation(this);
        } else {
            removeAnimation(this);
        }
        return nativeSetListener(this.nativeInstance, aVar != null);
    }

    public BmAnimation(int i, long j) {
        super(i, j);
        this.mFillMode = 0;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.mExtParam = "";
    }

    private static void removeAnimation(BmAnimation bmAnimation) {
    }
}
