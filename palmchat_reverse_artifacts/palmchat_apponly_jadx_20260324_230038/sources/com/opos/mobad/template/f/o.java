package com.opos.mobad.template.f;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.opos.mobad.template.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class o extends com.opos.mobad.template.cmn.baseview.c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a.InterfaceC0778a f9574a;
    private AnimatorSet b;
    private com.opos.mobad.template.d.b c;

    public o(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.1f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, "scaleX", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.b = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        this.b.setDuration(250L);
        this.b.start();
    }

    @Override // com.opos.mobad.template.f.e
    public ViewGroup a() {
        return this;
    }

    @Override // com.opos.mobad.template.f.e
    public void b() {
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.end();
        }
        this.c = null;
    }

    @Override // com.opos.mobad.template.f.e
    public void a(View view) {
        addView(view);
    }

    @Override // com.opos.mobad.template.f.e
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.f9574a = interfaceC0778a;
    }

    @Override // com.opos.mobad.template.f.e
    public void a(com.opos.mobad.template.d.f fVar) {
        com.opos.mobad.template.d.b bVarA = fVar.a();
        if (bVarA != null) {
            if (this.c == null) {
                c();
            }
            this.c = bVarA;
        } else {
            com.opos.cmn.an.f.a.d("InterstitialFullScreenViewFrame", "render with data null");
            a.InterfaceC0778a interfaceC0778a = this.f9574a;
            if (interfaceC0778a != null) {
                interfaceC0778a.a(1);
            }
        }
    }
}
