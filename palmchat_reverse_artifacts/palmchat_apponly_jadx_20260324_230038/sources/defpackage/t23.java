package defpackage;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class t23<T extends Entry> extends sp<T> implements jm2<T> {
    public DashPathEffect A;
    public boolean x;
    public boolean y;
    public float z;

    public t23(List<T> list, String str) {
        super(list, str);
        this.x = true;
        this.y = true;
        this.z = 0.5f;
        this.A = null;
        this.z = s86.e(0.5f);
    }

    @Override // defpackage.jm2
    public DashPathEffect D0() {
        return this.A;
    }

    @Override // defpackage.jm2
    public boolean N0() {
        return this.y;
    }

    @Override // defpackage.jm2
    public float q0() {
        return this.z;
    }

    @Override // defpackage.jm2
    public boolean u() {
        return this.x;
    }
}
