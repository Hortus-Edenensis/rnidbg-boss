package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.SubtitleView;
import defpackage.kn5;
import defpackage.on5;
import defpackage.oz;
import defpackage.pr0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
final class CanvasSubtitleOutput extends View implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<kn5> f5991a;
    public List<pr0> b;
    public int c;
    public float d;
    public oz e;
    public float f;

    public CanvasSubtitleOutput(Context context) {
        this(context, null);
    }

    public static pr0 b(pr0 pr0Var) {
        pr0.b bVarP = pr0Var.b().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (pr0Var.f == 0) {
            bVarP.h(1.0f - pr0Var.e, 0);
        } else {
            bVarP.h((-pr0Var.e) - 1.0f, 1);
        }
        int i = pr0Var.g;
        if (i == 0) {
            bVarP.i(2);
        } else if (i == 2) {
            bVarP.i(0);
        }
        return bVarP.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<pr0> list, oz ozVar, float f, int i, float f2) {
        this.b = list;
        this.e = ozVar;
        this.d = f;
        this.c = i;
        this.f = f2;
        while (this.f5991a.size() < list.size()) {
            this.f5991a.add(new kn5(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<pr0> list = this.b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i = paddingBottom - paddingTop;
        float fH = on5.h(this.c, this.d, height, i);
        if (fH <= 0.0f) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            pr0 pr0VarB = list.get(i2);
            if (pr0VarB.p != Integer.MIN_VALUE) {
                pr0VarB = b(pr0VarB);
            }
            pr0 pr0Var = pr0VarB;
            int i3 = paddingBottom;
            this.f5991a.get(i2).b(pr0Var, this.e, fH, on5.h(pr0Var.n, pr0Var.o, height, i), this.f, canvas, paddingLeft, paddingTop, width, i3);
            i2++;
            size = size;
            i = i;
            paddingBottom = i3;
            width = width;
        }
    }

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5991a = new ArrayList();
        this.b = Collections.emptyList();
        this.c = 0;
        this.d = 0.0533f;
        this.e = oz.g;
        this.f = 0.08f;
    }
}
