package com.yuyakaido.android.cardstackview.internal;

import com.yuyakaido.android.cardstackview.Direction;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CardStackState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Status f11803a = Status.Idle;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = -1;
    public float h = 0.0f;
    public boolean i = false;

    /* JADX INFO: compiled from: SearchBox */
    public enum Status {
        Idle,
        Dragging,
        RewindAnimating,
        AutomaticSwipeAnimating,
        AutomaticSwipeAnimated,
        ManualSwipeAnimating,
        ManualSwipeAnimated;

        public boolean isAutomatic() {
            return this == AutomaticSwipeAnimating;
        }

        public boolean isBusy() {
            return this != Idle;
        }

        public boolean isDragging() {
            return this == Dragging;
        }

        public boolean isSwipeAnimating() {
            return this == ManualSwipeAnimating || this == AutomaticSwipeAnimating;
        }

        public Status toAnimatedStatus() {
            int i = a.f11804a[ordinal()];
            return i != 1 ? i != 2 ? Idle : AutomaticSwipeAnimated : ManualSwipeAnimated;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11804a;

        static {
            int[] iArr = new int[Status.values().length];
            f11804a = iArr;
            try {
                iArr[Status.ManualSwipeAnimating.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11804a[Status.AutomaticSwipeAnimating.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public boolean a(int i, int i2) {
        return i != this.f && i >= 0 && i2 >= i && !this.f11803a.isBusy();
    }

    public Direction b() {
        int i = this.d;
        return (i != 0 || this.e >= 0) ? ((float) i) < 0.0f ? Direction.Left : Direction.Right : Direction.Top;
    }

    public float c() {
        return Math.min(Math.abs(this.d) / (this.b / 2.0f), 1.0f);
    }

    public boolean d() {
        return this.f11803a.isAutomatic();
    }

    public boolean e() {
        if (!this.f11803a.isSwipeAnimating() || this.f >= this.g) {
            return false;
        }
        return this.b < Math.abs(this.d) || this.c < Math.abs(this.e);
    }

    public void f(Status status) {
        this.f11803a = status;
    }
}
