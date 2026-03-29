package defpackage;

import android.view.MotionEvent;
import android.view.View;
import defpackage.ja4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class w96 extends ja4 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends ja4.a {
        public a() {
            this.f18358a = View.TRANSLATION_Y;
        }

        @Override // ja4.a
        public void a(View view) {
            this.b = view.getTranslationY();
            this.c = view.getHeight();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends ja4.e {
        @Override // ja4.e
        public boolean a(View view, MotionEvent motionEvent) {
            if (motionEvent.getHistorySize() == 0) {
                return false;
            }
            float y = motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0);
            if (Math.abs(motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0)) > Math.abs(y)) {
                return false;
            }
            this.f18361a = view.getTranslationY();
            this.b = y;
            this.c = y > 0.0f;
            return true;
        }
    }

    public w96(vn2 vn2Var, float f, float f2, float f3) {
        super(vn2Var, f3, f, f2);
    }

    @Override // defpackage.ja4
    public ja4.a d() {
        return new a();
    }

    @Override // defpackage.ja4
    public ja4.e e() {
        return new b();
    }

    @Override // defpackage.ja4
    public void h(View view, float f) {
        view.setTranslationY(f);
    }

    @Override // defpackage.ja4
    public void i(View view, float f, MotionEvent motionEvent) {
        view.setTranslationY(f);
        motionEvent.offsetLocation(f - motionEvent.getY(0), 0.0f);
    }
}
