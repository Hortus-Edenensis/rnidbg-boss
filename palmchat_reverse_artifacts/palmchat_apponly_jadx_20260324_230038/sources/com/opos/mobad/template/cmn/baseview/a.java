package com.opos.mobad.template.cmn.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f9369a;
    private f b;

    public a(@NonNull Context context) {
        super(context);
        this.f9369a = new h(this);
    }

    public void a(f fVar) {
        this.b = fVar;
    }

    @Override // android.view.View
    public boolean callOnClick() {
        return g.a(this, this.f9369a, this.b) && super.callOnClick();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (g.a(this, this.f9369a, motionEvent, this.b)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return g.b(this, this.f9369a, this.b) && super.performClick();
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9369a = new h(this);
    }
}
