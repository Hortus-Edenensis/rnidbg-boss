package com.opos.mobad.template.cmn.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends RelativeLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f9371a;
    protected f k;

    public c(@NonNull Context context) {
        super(context);
        this.f9371a = new h(this);
    }

    @Override // com.opos.mobad.template.cmn.baseview.e
    public void a(f fVar) {
        this.k = fVar;
    }

    @Override // android.view.View
    public boolean callOnClick() {
        return g.a(this, this.f9371a, this.k) && super.callOnClick();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (g.a(this, this.f9371a, motionEvent, this.k)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return g.b(this, this.f9371a, this.k) && super.performClick();
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9371a = new h(this);
    }
}
