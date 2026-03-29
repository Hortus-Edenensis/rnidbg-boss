package com.tencent.turingfd.sdk.ams.ad;

import android.view.MotionEvent;
import android.view.Window;
import com.tencent.turingfd.sdk.ams.ad.Cthrow;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Olive extends Cif {
    public final String b;
    public final Dew c;

    public Olive(Window.Callback callback, String str, Dew dew) {
        super(callback);
        this.b = str;
        this.c = dew;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.Cif, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Orion orion;
        Dew dew = this.c;
        String str = this.b;
        Cthrow.Cdo cdo = (Cthrow.Cdo) dew;
        if (!cdo.f10777a.get()) {
            synchronized (Orion.i) {
                orion = Orion.k;
                if (orion == null) {
                    orion = new Orion();
                } else {
                    Orion.k = orion.f10730a;
                    Orion.j--;
                    orion.f10730a = null;
                }
            }
            orion.b = str;
            orion.c = motionEvent.getAction();
            orion.d = motionEvent.getDeviceId();
            orion.e = motionEvent.getToolType(0);
            orion.f = motionEvent.getPressure();
            orion.g = motionEvent.getSize();
            orion.h = System.currentTimeMillis();
            cdo.b.obtainMessage(2, orion).sendToTarget();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
