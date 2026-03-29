package com.opos.cmn.module.ui.a;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f8048a;
    private final com.opos.cmn.module.ui.b.b.c b;
    private boolean c;
    private int[] d;

    public e(@NonNull Context context) {
        this(context, null);
    }

    public void a(int... iArr) {
        this.d = iArr;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c) {
            this.b.a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f8048a.a(ColorStateList.valueOf(i));
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d dVar = new d();
        this.f8048a = dVar;
        super.setBackground(dVar);
        this.c = true;
        dVar.a(com.opos.cmn.an.h.f.a.a(context, 20.0f));
        this.b = new com.opos.cmn.module.ui.b.b.c(this) { // from class: com.opos.cmn.module.ui.a.e.1
            private final ArgbEvaluator b = new ArgbEvaluator();

            @Override // com.opos.cmn.module.ui.b.b.c
            public void a(float f) {
                ColorStateList colorStateListB;
                int[] iArr = e.this.d;
                if ((iArr == null || iArr.length != 2) && (colorStateListB = e.this.f8048a.b()) != null) {
                    e.this.f8048a.setTint(com.opos.cmn.module.ui.d.a.a(colorStateListB.getDefaultColor(), f));
                }
            }

            @Override // com.opos.cmn.module.ui.b.b.c
            public void a(boolean z, float f) {
                int[] iArr = e.this.d;
                if (iArr == null || iArr.length != 2) {
                    return;
                }
                e.this.f8048a.a(((Integer) this.b.evaluate(f, Integer.valueOf(z ? iArr[0] : iArr[1]), Integer.valueOf(z ? iArr[1] : iArr[0]))).intValue());
            }
        };
    }
}
