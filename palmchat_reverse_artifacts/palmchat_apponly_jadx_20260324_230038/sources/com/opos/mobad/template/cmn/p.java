package com.opos.mobad.template.cmn;

import android.view.MotionEvent;
import android.view.View;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class p implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f9401a = {SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT, SkuConfig.INFINITE_COUNT};

    public static void a(View view, p pVar) {
        if (view != null) {
            view.setOnClickListener(pVar);
            view.setOnTouchListener(pVar);
        }
    }

    public abstract void b(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b(view, this.f9401a);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f9401a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f9401a[0] = (int) motionEvent.getX();
                this.f9401a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f9401a[2] = (int) motionEvent.getX();
                this.f9401a[3] = (int) motionEvent.getY();
            }
        }
        return false;
    }
}
