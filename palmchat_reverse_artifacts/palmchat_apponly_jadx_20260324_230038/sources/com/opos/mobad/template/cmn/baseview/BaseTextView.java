package com.opos.mobad.template.cmn.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class BaseTextView extends TextView implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f9368a;
    private f b;

    public BaseTextView(Context context) {
        super(context);
        this.f9368a = new h(this);
    }

    @Override // com.opos.mobad.template.cmn.baseview.e
    public void a(f fVar) {
        this.b = fVar;
    }

    @Override // android.view.View
    public boolean callOnClick() {
        return g.a(this, this.f9368a, this.b) && super.callOnClick();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (g.a(this, this.f9368a, motionEvent, this.b)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return g.b(this, this.f9368a, this.b) && super.performClick();
    }

    public BaseTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9368a = new h(this);
    }

    public BaseTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9368a = new h(this);
    }

    public BaseTextView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f9368a = new h(this);
    }
}
