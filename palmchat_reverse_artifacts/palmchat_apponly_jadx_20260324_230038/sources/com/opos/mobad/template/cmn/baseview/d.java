package com.opos.mobad.template.cmn.baseview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d extends View implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f9372a;
    private f b;

    public d(Context context) {
        super(context);
        this.f9372a = new h(this);
    }

    @Override // com.opos.mobad.template.cmn.baseview.e
    public void a(f fVar) {
        this.b = fVar;
    }

    @Override // android.view.View
    public boolean callOnClick() {
        return g.a(this, this.f9372a, this.b) && super.callOnClick();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (g.a(this, this.f9372a, motionEvent, this.b)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return g.b(this, this.f9372a, this.b) && super.performClick();
    }
}
