package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.k;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class EasyPlayableContainer extends FrameLayout {
    private final bc fx;
    private final k nr;
    private final iz u;

    public EasyPlayableContainer(@NonNull Context context, iz izVar, k kVar, bc bcVar) {
        super(context);
        this.u = izVar;
        this.nr = kVar;
        this.fx = bcVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iz izVar = this.u;
        if (izVar != null) {
            izVar.nr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iz izVar = this.u;
        if (izVar != null) {
            izVar.fx();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.nr == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        float fB = y.b(getContext(), motionEvent.getX());
        float fB2 = y.b(getContext(), motionEvent.getY());
        if (this.nr.u(fB, fB2)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            com.bytedance.sdk.openadsdk.core.z.u.u(this.fx, fB, fB2, 1);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nr == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.nr.u(y.b(getContext(), motionEvent.getX()), y.b(getContext(), motionEvent.getY()))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
