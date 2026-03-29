package com.opos.cmn.module.ui;

import android.view.MotionEvent;
import android.view.View;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f8043a = {SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT};

    public abstract void a(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a(view, this.f8043a);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f8043a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f8043a[0] = (int) motionEvent.getX();
                this.f8043a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f8043a[2] = (int) motionEvent.getX();
                this.f8043a[3] = (int) motionEvent.getY();
            } else if (2 == motionEvent.getAction()) {
                int[] iArr2 = this.f8043a;
                if (iArr2[0] == -999 && iArr2[1] == -999) {
                    iArr2[0] = (int) motionEvent.getX();
                    this.f8043a[1] = (int) motionEvent.getY();
                } else {
                    iArr2[2] = (int) motionEvent.getX();
                    this.f8043a[3] = (int) motionEvent.getY();
                }
            }
        }
        return false;
    }
}
