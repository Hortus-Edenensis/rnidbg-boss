package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class PlayableEndcardFrameLayout extends FrameLayout {
    private int nr;
    private u u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.nr = y;
        } else if (action == 2 && Math.abs(this.nr - y) > 100) {
            u();
            this.nr = y;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void u(u uVar) {
        this.u = uVar;
    }

    private void u() {
        u uVar = this.u;
        if (uVar != null) {
            uVar.u();
        }
    }
}
