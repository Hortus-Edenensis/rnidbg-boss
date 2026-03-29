package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zo extends ps2 {
    public float[] h = {1.0f, 1.0f, 1.0f};

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22462a;

        public a(int i) {
            this.f22462a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            zo.this.h[this.f22462a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            zo.this.h();
        }
    }

    @Override // defpackage.ps2
    public void b(Canvas canvas, Paint paint) {
        float fMin = (Math.min(e(), d()) - 8.0f) / 6.0f;
        float f = 2.0f * fMin;
        float fE = (e() / 2) - (f + 4.0f);
        float fD = d() / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f2 = i;
            canvas.translate((f * f2) + fE + (f2 * 4.0f), fD);
            float f3 = this.h[i];
            canvas.scale(f3, f3);
            canvas.drawCircle(0.0f, 0.0f, fMin, paint);
            canvas.restore();
        }
    }

    @Override // defpackage.ps2
    public ArrayList<ValueAnimator> g() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (int i = 0; i < 3; i++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            valueAnimatorOfFloat.setDuration(750L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setStartDelay(iArr[i]);
            a(valueAnimatorOfFloat, new a(i));
            arrayList.add(valueAnimatorOfFloat);
        }
        return arrayList;
    }
}
