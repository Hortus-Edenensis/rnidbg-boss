package com.zenmen.palmchat.widget.photoview;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f16042a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends b {
        public float b;
        public float c;
        public final float d;
        public final float e;
        public VelocityTracker f;
        public boolean g;

        public a(Context context) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.e = viewConfiguration.getScaledMinimumFlingVelocity();
            this.d = viewConfiguration.getScaledTouchSlop();
        }

        @Override // com.zenmen.palmchat.widget.photoview.b
        public boolean c(MotionEvent motionEvent) {
            VelocityTracker velocityTracker;
            int action = motionEvent.getAction();
            if (action == 0) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.f = velocityTrackerObtain;
                velocityTrackerObtain.addMovement(motionEvent);
                this.b = d(motionEvent);
                this.c = e(motionEvent);
                this.g = false;
            } else if (action == 1) {
                if (this.g && this.f != null) {
                    this.b = d(motionEvent);
                    this.c = e(motionEvent);
                    this.f.addMovement(motionEvent);
                    this.f.computeCurrentVelocity(1000);
                    float xVelocity = this.f.getXVelocity();
                    float yVelocity = this.f.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.e) {
                        this.f16042a.onFling(this.b, this.c, -xVelocity, -yVelocity);
                    }
                }
                VelocityTracker velocityTracker2 = this.f;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f = null;
                }
            } else if (action == 2) {
                float fD = d(motionEvent);
                float fE = e(motionEvent);
                float f = fD - this.b;
                float f2 = fE - this.c;
                if (!this.g) {
                    this.g = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.d);
                }
                if (this.g) {
                    this.f16042a.onDrag(f, f2);
                    this.b = fD;
                    this.c = fE;
                    VelocityTracker velocityTracker3 = this.f;
                    if (velocityTracker3 != null) {
                        velocityTracker3.addMovement(motionEvent);
                    }
                }
            } else if (action == 3 && (velocityTracker = this.f) != null) {
                velocityTracker.recycle();
                this.f = null;
            }
            return true;
        }

        public float d(MotionEvent motionEvent) {
            throw null;
        }

        public float e(MotionEvent motionEvent) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.widget.photoview.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(5)
    public static class C1148b extends a {
        public int h;
        public int i;

        public C1148b(Context context) {
            super(context);
            this.h = -1;
            this.i = 0;
        }

        @Override // com.zenmen.palmchat.widget.photoview.b.a, com.zenmen.palmchat.widget.photoview.b
        public boolean c(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1 || action == 3) {
                    this.h = -1;
                } else if (action == 6) {
                    int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    if (motionEvent.getPointerId(action2) == this.h) {
                        int i = action2 != 0 ? 0 : 1;
                        this.h = motionEvent.getPointerId(i);
                        this.b = motionEvent.getX(i);
                        this.c = motionEvent.getY(i);
                    }
                }
            } else {
                this.h = motionEvent.getPointerId(0);
            }
            int i2 = this.h;
            this.i = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
            return super.c(motionEvent);
        }

        @Override // com.zenmen.palmchat.widget.photoview.b.a
        public float d(MotionEvent motionEvent) {
            try {
                return motionEvent.getX(this.i);
            } catch (Exception unused) {
                return motionEvent.getX();
            }
        }

        @Override // com.zenmen.palmchat.widget.photoview.b.a
        public float e(MotionEvent motionEvent) {
            try {
                return motionEvent.getY(this.i);
            } catch (Exception unused) {
                return motionEvent.getY();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void onDrag(float f, float f2);

        void onFling(float f, float f2, float f3, float f4);

        void onScale(float f, float f2, float f3);
    }

    public static b b(Context context, d dVar) {
        c cVar = new c(context);
        cVar.f16042a = dVar;
        return cVar;
    }

    public abstract boolean a();

    public abstract boolean c(MotionEvent motionEvent);

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(8)
    public static class c extends C1148b {
        public final ScaleGestureDetector j;
        public final ScaleGestureDetector.OnScaleGestureListener k;

        public c(Context context) {
            super(context);
            a aVar = new a();
            this.k = aVar;
            this.j = new ScaleGestureDetector(context, aVar);
        }

        @Override // com.zenmen.palmchat.widget.photoview.b
        public boolean a() {
            return this.j.isInProgress();
        }

        @Override // com.zenmen.palmchat.widget.photoview.b.C1148b, com.zenmen.palmchat.widget.photoview.b.a, com.zenmen.palmchat.widget.photoview.b
        public boolean c(MotionEvent motionEvent) {
            this.j.onTouchEvent(motionEvent);
            return super.c(motionEvent);
        }

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ScaleGestureDetector.OnScaleGestureListener {
            public a() {
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                c.this.f16042a.onScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        }
    }
}
