package com.zenmen.palmchat.widget.byakugallery;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ScaleGestureDetectorCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetectorCompat f16024a;
    public final ScaleGestureDetector b;

    public a(Context context, AbstractGestureDetectorOnGestureListenerC1145a abstractGestureDetectorOnGestureListenerC1145a) {
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, abstractGestureDetectorOnGestureListenerC1145a);
        this.f16024a = gestureDetectorCompat;
        gestureDetectorCompat.setOnDoubleTapListener(abstractGestureDetectorOnGestureListenerC1145a);
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context, abstractGestureDetectorOnGestureListenerC1145a);
        this.b = scaleGestureDetector;
        ScaleGestureDetectorCompat.setQuickScaleEnabled(scaleGestureDetector, false);
    }

    public boolean a(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.b.onTouchEvent(motionEvent);
        return !this.b.isInProgress() ? zOnTouchEvent | this.f16024a.onTouchEvent(motionEvent) : zOnTouchEvent;
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.widget.byakugallery.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractGestureDetectorOnGestureListenerC1145a implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener {
        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }
    }
}
