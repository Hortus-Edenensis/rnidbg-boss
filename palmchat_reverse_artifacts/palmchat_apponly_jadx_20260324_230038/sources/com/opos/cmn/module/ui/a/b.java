package com.opos.cmn.module.ui.a;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f8045a;

    public b(int[] iArr) {
        this.f8045a = iArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f8045a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f8045a[0] = (int) motionEvent.getX();
                this.f8045a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f8045a[2] = (int) motionEvent.getX();
                this.f8045a[3] = (int) motionEvent.getY();
            }
        }
        return false;
    }
}
