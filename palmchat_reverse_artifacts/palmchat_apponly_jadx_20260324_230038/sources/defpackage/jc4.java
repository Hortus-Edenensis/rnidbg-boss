package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class jc4 extends ArrayList<ic4> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18381a;

    public jc4(int i, int i2) {
        super(i);
        this.f18381a = i2;
    }

    public static jc4 p() {
        return new jc4(0, 0);
    }

    public boolean o() {
        return size() < this.f18381a;
    }
}
