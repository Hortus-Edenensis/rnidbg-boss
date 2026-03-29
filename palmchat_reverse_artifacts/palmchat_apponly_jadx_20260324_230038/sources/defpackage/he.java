package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.media.AudioController;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class he {
    public ValueAnimator c;
    public long d = 1000;
    public long e = 0;
    public List<SoftReference<View>> b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<SoftReference<u10>> f17936a = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            he.this.f(fFloatValue);
            he.this.h(fFloatValue);
        }
    }

    public void c(u10 u10Var) {
        this.f17936a.add(new SoftReference<>(u10Var));
    }

    public void d(View view) {
        this.b.add(new SoftReference<>(view));
    }

    public void e() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.c = null;
        }
    }

    public final void f(float f) {
        Iterator<SoftReference<View>> it = this.b.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null && view.getVisibility() == 0) {
                view.setRotation(f);
            }
        }
    }

    public void g() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.c = valueAnimator2;
            valueAnimator2.setInterpolator(new LinearInterpolator());
            this.c.setFloatValues(0.0f, 359.0f);
            this.c.setDuration(this.d);
            this.c.setRepeatCount(-1);
            this.c.addUpdateListener(new a());
            this.c.start();
        }
    }

    public final void h(float f) {
        MessageVo messageVo;
        ImageView imageViewD;
        if (Math.abs(ir5.b() - this.e) < 30) {
            return;
        }
        this.e = ir5.b();
        Iterator<SoftReference<u10>> it = this.f17936a.iterator();
        while (it.hasNext()) {
            u10 u10Var = it.next().get();
            SeekBar seekBarE = u10Var != null ? u10Var.e() : null;
            if (seekBarE != null && seekBarE.getVisibility() == 0 && (messageVo = (MessageVo) seekBarE.getTag()) != null) {
                int iC0 = AudioController.b0().c0(messageVo.mid);
                if (iC0 < 0) {
                    iC0 = AudioController.b0().j0(messageVo.mid, -1);
                }
                if (iC0 >= 0 && seekBarE.getProgress() != iC0) {
                    seekBarE.setProgress(iC0);
                    if (iC0 == 0 && (imageViewD = u10Var.d()) != null) {
                        if (messageVo.isSend) {
                            imageViewD.setImageResource(R.drawable.ic_audio_bg_play_press);
                        } else {
                            imageViewD.setImageResource(R.drawable.ic_audio_bg_play_normal);
                        }
                    }
                }
            }
        }
    }
}
