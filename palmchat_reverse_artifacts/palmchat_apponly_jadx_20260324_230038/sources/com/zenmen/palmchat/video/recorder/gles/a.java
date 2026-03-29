package com.zenmen.palmchat.video.recorder.gles;

import android.opengl.Matrix;
import com.zenmen.palmchat.video.recorder.gles.Drawable2d;
import defpackage.gc2;
import defpackage.o25;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o25 f15813a;
    public Texture2dProgram b;
    public float[] c = new float[16];

    public a(Texture2dProgram texture2dProgram, Drawable2d.Prefab prefab) {
        this.b = texture2dProgram;
        this.f15813a = new o25(prefab);
    }

    public void a(int i, float[] fArr, float[] fArr2) {
        Matrix.multiplyMM(this.c, 0, fArr, 0, fArr2, 0);
        this.b.b(this.c, this.f15813a.d(), 0, this.f15813a.e(), this.f15813a.a(), this.f15813a.f(), gc2.f17699a, this.f15813a.b(), i, this.f15813a.c());
    }

    public void b(boolean z) {
        Texture2dProgram texture2dProgram = this.b;
        if (texture2dProgram != null) {
            if (z) {
                texture2dProgram.d();
            }
            this.b = null;
        }
    }

    public void c(float f) {
        if (f <= 0.0f || f > 1.0f) {
            return;
        }
        this.f15813a.g(f);
    }
}
