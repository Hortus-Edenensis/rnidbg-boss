package defpackage;

import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wf1 extends ed5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<gl2> f21690a;
    public String b;
    public int c;
    public String d;
    public int e;

    public wf1(WeakReference<gl2> weakReference, String str, int i, String str2, int i2) {
        this.f21690a = weakReference;
        this.b = str;
        this.c = i;
        this.d = str2;
        this.e = i2;
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onError(int i, String str) {
        if (i == 101 || this.f21690a.get() == null) {
            return;
        }
        this.f21690a.get().G0(this.c, i, this.d);
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onFinish(File file) {
        if (this.f21690a.get() != null) {
            this.f21690a.get().L(file, this.c, this.d, this.e);
        }
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onProgress(int i) {
        if (this.f21690a.get() != null) {
            this.f21690a.get().E(i, this.c, this.d, this.e);
        }
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onStart(String str, String str2, int i) {
        if (this.f21690a.get() != null) {
            this.f21690a.get().T(this.c, this.d);
        }
    }

    @Override // defpackage.ed5, defpackage.il2
    public void onStop(int i) {
        if (this.f21690a.get() != null) {
            this.f21690a.get().h0(this.c, this.d, this.e);
        }
    }
}
