package com.amap.api.col.p0002sl;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class bk {
    static float j = 1.0f;
    private static Method p = null;
    private static Method q = null;
    private static boolean r = false;
    private static boolean s = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f2649a;
    int b = 0;
    Matrix c = new Matrix();
    Matrix d = new Matrix();
    PointF e = new PointF();
    PointF f = new PointF();
    PointF g = new PointF();
    float h = 1.0f;
    float i = 1.0f;
    boolean k = false;
    boolean l = false;
    boolean m = false;
    public int n = 0;
    public long o = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        boolean a(float f, float f2);

        boolean c(float f);

        boolean k();

        boolean l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(MotionEvent motionEvent) {
        if (s) {
            return;
        }
        s = true;
        try {
            Class<?> cls = motionEvent.getClass();
            Class<?> cls2 = Integer.TYPE;
            p = cls.getMethod("getX", cls2);
            Method method = motionEvent.getClass().getMethod("getY", cls2);
            q = method;
            if (p == null || method == null) {
                return;
            }
            r = true;
        } catch (Exception e) {
            ct.a(e, "MutiTouchGestureDetector", "checkSDKForMuti");
        }
    }

    public static a a(b bVar) {
        a aVar = new a();
        aVar.f2649a = bVar;
        return aVar;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends bk {
        float p;
        float q;
        float r;
        float s;
        long t = 0;
        int u = 0;
        int v = 0;
        private long w = 0;

        private static float b(MotionEvent motionEvent) {
            float fFloatValue;
            float fFloatValue2 = 0.0f;
            try {
                fFloatValue = ((Float) bk.p.invoke(motionEvent, 0)).floatValue() - ((Float) bk.p.invoke(motionEvent, 1)).floatValue();
            } catch (IllegalAccessException e) {
                ct.a(e, "MutiTouchGestureDetector", "distance");
                fFloatValue = 0.0f;
            } catch (IllegalArgumentException e2) {
                ct.a(e2, "MutiTouchGestureDetector", "distance");
                fFloatValue = 0.0f;
            } catch (InvocationTargetException e3) {
                ct.a(e3, "MutiTouchGestureDetector", "distance");
                fFloatValue = 0.0f;
            }
            try {
                fFloatValue2 = ((Float) bk.q.invoke(motionEvent, 0)).floatValue() - ((Float) bk.q.invoke(motionEvent, 1)).floatValue();
            } catch (IllegalAccessException e4) {
                ct.a(e4, "MutiTouchGestureDetector", "distance");
            } catch (IllegalArgumentException e5) {
                ct.a(e5, "MutiTouchGestureDetector", "distance");
            } catch (InvocationTargetException e6) {
                ct.a(e6, "MutiTouchGestureDetector", "distance");
            }
            return (float) Math.sqrt((fFloatValue * fFloatValue) + (fFloatValue2 * fFloatValue2));
        }

        public final boolean a(MotionEvent motionEvent, int i, int i2) {
            this.u = i;
            this.v = i2;
            bk.b(motionEvent);
            if (!bk.r) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.t = motionEvent.getEventTime();
                this.p = motionEvent.getX();
                this.q = motionEvent.getY();
                this.d.set(this.c);
                this.e.set(this.p, this.q);
                this.b = 1;
                return false;
            }
            if (action == 1) {
                this.o = motionEvent.getEventTime();
                this.k = false;
                this.b = 0;
                return false;
            }
            if (action == 2) {
                int i3 = this.b;
                if (i3 == 1) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.c.set(this.d);
                    this.c.postTranslate(motionEvent.getX() - this.e.x, motionEvent.getY() - this.e.y);
                    boolean zA = this.f2649a.a(x - this.p, y - this.q) | false;
                    this.p = x;
                    this.q = y;
                    boolean z = zA | false;
                    if (motionEvent.getEventTime() - this.t < 30) {
                        return true;
                    }
                    return z;
                }
                if (i3 != 2) {
                    return false;
                }
                float fB = b(motionEvent);
                this.i = 1.0f;
                long eventTime = motionEvent.getEventTime();
                if (fB <= 10.0f || Math.abs(fB - this.h) <= 5.0f || eventTime - this.w <= 10) {
                    return false;
                }
                this.w = eventTime;
                this.i = fB / this.h;
                bk.j = 1.0f;
                this.h = fB;
                a(this.g, motionEvent);
                b bVar = this.f2649a;
                PointF pointF = this.g;
                boolean zA2 = bVar.a(pointF.x - this.r, pointF.y - this.s) | false;
                PointF pointF2 = this.g;
                this.r = pointF2.x;
                this.s = pointF2.y;
                boolean zC = zA2 | this.f2649a.c(this.i);
                this.l = true;
                return zC;
            }
            if (action != 3) {
                if (action == 5) {
                    int i4 = this.n + 1;
                    this.n = i4;
                    if (i4 != 1) {
                        return false;
                    }
                    this.m = true;
                    bk.j = 1.0f;
                    float fB2 = b(motionEvent);
                    this.h = fB2;
                    if (fB2 <= 10.0f) {
                        return false;
                    }
                    this.c.reset();
                    this.d.reset();
                    this.d.set(this.c);
                    a(this.f, motionEvent);
                    this.b = 2;
                    this.k = true;
                    boolean zL = false | this.f2649a.l();
                    PointF pointF3 = this.f;
                    this.r = pointF3.x;
                    this.s = pointF3.y;
                    return zL;
                }
                if (action != 6) {
                    return false;
                }
            }
            int i5 = this.n - 1;
            this.n = i5;
            if (i5 < 0) {
                this.n = 0;
            }
            int i6 = this.n;
            if (i6 == 1) {
                this.m = true;
                this.b = 2;
            }
            if (i6 != 0) {
                return false;
            }
            a(this.f, motionEvent);
            this.l = false;
            this.m = false;
            if (!this.k) {
                return false;
            }
            boolean zK = this.f2649a.k() | false;
            this.b = 0;
            return zK;
        }

        private void a(PointF pointF, MotionEvent motionEvent) {
            float fFloatValue;
            int i;
            float fFloatValue2 = 0.0f;
            try {
                fFloatValue = ((Float) bk.p.invoke(motionEvent, 0)).floatValue() + ((Float) bk.p.invoke(motionEvent, 1)).floatValue();
            } catch (IllegalAccessException e) {
                ct.a(e, "MutiTouchGestureDetector", "midPoint");
                fFloatValue = 0.0f;
            } catch (IllegalArgumentException e2) {
                ct.a(e2, "MutiTouchGestureDetector", "midPoint");
                fFloatValue = 0.0f;
            } catch (InvocationTargetException e3) {
                ct.a(e3, "MutiTouchGestureDetector", "midPoint");
                fFloatValue = 0.0f;
            }
            try {
                fFloatValue2 = ((Float) bk.q.invoke(motionEvent, 0)).floatValue() + ((Float) bk.q.invoke(motionEvent, 1)).floatValue();
            } catch (Throwable th) {
                ct.a(th, "MutiTouchGestureDetector", "midPoint");
            }
            int i2 = this.u;
            if (i2 != 0 && (i = this.v) != 0) {
                fFloatValue = i2;
                fFloatValue2 = i;
            }
            pointF.set(fFloatValue / 2.0f, fFloatValue2 / 2.0f);
        }
    }
}
