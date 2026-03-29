package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.sdk.openadsdk.core.kj.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private Context nr;
    private final Vibrator pn;
    private List<nr> u;
    private final List<Long> fx = new ArrayList();
    private final List<Integer> b = new ArrayList();
    private long iz = 0;
    private long x = 0;

    public u(Context context, h hVar) {
        this.nr = context;
        this.pn = fx.fx(context);
        this.u = hVar.nr();
        u();
    }

    private static float u(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public void fx() {
        this.fx.clear();
        this.b.clear();
        this.iz = 0L;
        this.x = 0L;
    }

    public void nr() {
        if (!fx.u(this.nr) || this.fx.isEmpty() || this.b.isEmpty()) {
            return;
        }
        long[] jArrU = u(this.fx);
        int[] iArrNr = nr(this.b);
        if (Build.VERSION.SDK_INT < 26) {
            this.pn.vibrate(100L);
        } else {
            this.pn.vibrate(VibrationEffect.createWaveform(jArrU, iArrNr, -1));
        }
    }

    public void u() {
        fx();
        List<nr> list = this.u;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.u, new Comparator<nr>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u.u.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int compare(nr nrVar, nr nrVar2) {
                return Long.compare(nrVar.u(), nrVar2.u());
            }
        });
        for (nr nrVar : this.u) {
            long jU = ((long) nrVar.u()) + nrVar.nr();
            if (jU > this.x) {
                this.x = jU;
            }
        }
        for (nr nrVar2 : this.u) {
            if (this.iz < nrVar2.u()) {
                u(((long) nrVar2.u()) - this.iz);
            }
            u(nrVar2.nr(), nrVar2.fx(), nrVar2.b());
        }
        long j = this.iz;
        long j2 = this.x;
        if (j < j2) {
            u(j2 - j);
        }
    }

    private int[] nr(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    private void u(long j) {
        if (j > 0) {
            this.fx.add(Long.valueOf(j));
            this.b.add(0);
            this.iz += j;
        }
    }

    private void u(long j, float f, float f2) {
        float fU = u(f, 0.0f, 1.0f);
        float fU2 = u(f2, 0.0f, 1.0f);
        int iPow = (int) (((float) Math.pow(fU, 1.5d)) * 255.0f);
        int iMax = Math.max(1, (int) (fU2 * ((int) (j / 22))));
        long j2 = j - (((long) iMax) * 20);
        for (int i = 0; i < iMax; i++) {
            this.fx.add(20L);
            this.b.add(Integer.valueOf(iPow));
            int i2 = iMax - 1;
            if (i < i2) {
                this.fx.add(Long.valueOf(Math.max(2L, j2 / ((long) i2))));
                this.b.add(0);
            }
        }
        this.iz += j;
    }

    private long[] u(List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }
}
