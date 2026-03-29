package com.baidu.platform.comapi.map;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MapController f4218a;
    private OnLongPressListener b;
    private volatile Set<GestureDetector.SimpleOnGestureListener> c = new CopyOnWriteArraySet();
    private Object d = new Object();

    public void a(MapController mapController) {
        this.f4218a = mapController;
    }

    public void b(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.d) {
            this.c.remove(simpleOnGestureListener);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onDoubleTap(motionEvent);
                }
            }
        }
        MapController mapController = this.f4218a;
        if (mapController == null) {
            return true;
        }
        mapController.handleDoubleDownClick(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        MapController mapController;
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onDoubleTapEvent(motionEvent);
                }
            }
        }
        if (motionEvent.getAction() == 1 && (mapController = this.f4218a) != null) {
            mapController.handleDoubleTouch(motionEvent);
        }
        return super.onDoubleTapEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onDown(motionEvent);
                }
            }
        }
        return super.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onFling(motionEvent, motionEvent2, f, f2);
                }
            }
        }
        MapController mapController = this.f4218a;
        if (mapController == null) {
            return false;
        }
        if (mapController.getMapControlMode() == MapController.MapControlMode.STREET) {
            this.f4218a.handleTouchUp(motionEvent2);
        }
        return this.f4218a.handleFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        OnLongPressListener onLongPressListener;
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    if (simpleOnGestureListener != null) {
                        simpleOnGestureListener.onLongPress(motionEvent);
                    }
                }
            }
        }
        MapController mapController = this.f4218a;
        if (mapController == null || mapController.isEnableDMoveZoom() || this.f4218a.isNaviMode() || (onLongPressListener = this.b) == null) {
            return;
        }
        onLongPressListener.onLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onScroll(motionEvent, motionEvent2, f, f2);
                }
            }
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    if (simpleOnGestureListener != null) {
                        simpleOnGestureListener.onShowPress(motionEvent);
                    }
                }
            }
        }
        super.onShowPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                    if (simpleOnGestureListener != null) {
                        simpleOnGestureListener.onSingleTapConfirmed(motionEvent);
                    }
                }
            }
        }
        MapController mapController = this.f4218a;
        return mapController != null && mapController.handleTouchSingleClick(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        synchronized (this.d) {
            Set<GestureDetector.SimpleOnGestureListener> set = this.c;
            if (set != null) {
                Iterator<GestureDetector.SimpleOnGestureListener> it = set.iterator();
                while (it.hasNext()) {
                    it.next().onSingleTapUp(motionEvent);
                }
            }
        }
        return super.onSingleTapUp(motionEvent);
    }

    public OnLongPressListener a() {
        return this.b;
    }

    public void a(OnLongPressListener onLongPressListener) {
        this.b = onLongPressListener;
    }

    public void a(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        synchronized (this.d) {
            this.c.add(simpleOnGestureListener);
        }
    }
}
