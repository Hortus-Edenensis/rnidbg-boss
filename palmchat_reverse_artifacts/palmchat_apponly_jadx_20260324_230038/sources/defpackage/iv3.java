package defpackage;

import android.view.ViewGroup;
import com.wifi.ad.core.data.NestAdData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class iv3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18268a;
    public int b;
    public NestAdData c;
    public bv3 d;
    public ViewGroup e;

    public iv3(int i, NestAdData nestAdData, bv3 bv3Var) {
        this.b = i;
        this.c = nestAdData;
        this.d = bv3Var;
    }

    public NestAdData a() {
        return this.c;
    }

    public bv3 b() {
        return this.d;
    }

    public ViewGroup c() {
        return this.e;
    }

    public int d() {
        return this.b;
    }

    public boolean e() {
        return this.f18268a;
    }

    public void f(NestAdData nestAdData) {
        this.c = nestAdData;
    }

    public void g(ViewGroup viewGroup) {
        this.e = viewGroup;
    }

    public void h(boolean z) {
        this.f18268a = z;
    }
}
