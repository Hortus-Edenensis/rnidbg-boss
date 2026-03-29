package defpackage;

import android.graphics.drawable.AnimationDrawable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class bs0 extends AnimationDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1809a = false;
    public a b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    public bs0(AnimationDrawable animationDrawable) {
        for (int i = 0; i < animationDrawable.getNumberOfFrames(); i++) {
            addFrame(animationDrawable.getFrame(i), animationDrawable.getDuration(i));
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // android.graphics.drawable.DrawableContainer
    public boolean selectDrawable(int i) {
        boolean zSelectDrawable = super.selectDrawable(i);
        if (i != 0 && i == getNumberOfFrames() - 1 && !this.f1809a) {
            this.f1809a = true;
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }
        return zSelectDrawable;
    }
}
