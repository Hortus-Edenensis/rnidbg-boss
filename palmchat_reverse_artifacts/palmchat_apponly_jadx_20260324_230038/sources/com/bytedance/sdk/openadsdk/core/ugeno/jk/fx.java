package com.bytedance.sdk.openadsdk.core.ugeno.jk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements View.OnTouchListener {
    private u b;
    private boolean fx;
    private Context iz;
    private float nr;
    private int pn;
    private float u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr();

        void u();
    }

    public fx(Context context, u uVar, int i) {
        this.iz = context;
        this.pn = i;
        this.b = uVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.nr = y;
                if (Math.abs(y - this.u) > 10.0f) {
                    this.fx = true;
                }
            }
        } else {
            if (!this.fx) {
                u uVar = this.b;
                if (uVar != null) {
                    uVar.nr();
                }
                return true;
            }
            int iB = y.b(this.iz, Math.abs(this.nr - this.u));
            if (this.nr - this.u >= 0.0f || iB <= this.pn) {
                u uVar2 = this.b;
                if (uVar2 != null) {
                    uVar2.nr();
                }
            } else {
                u uVar3 = this.b;
                if (uVar3 != null) {
                    uVar3.u();
                }
            }
        }
        return true;
    }
}
