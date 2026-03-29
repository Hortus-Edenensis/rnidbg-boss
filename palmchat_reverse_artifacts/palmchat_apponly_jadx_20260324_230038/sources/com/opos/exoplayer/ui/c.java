package com.opos.exoplayer.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.text.CaptionStyleCompat;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.text.h;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c extends View implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<d> f8449a;
    private List<Cue> b;
    private int c;
    private float d;
    private boolean e;
    private boolean f;
    private CaptionStyleCompat g;
    private float h;

    public c(Context context) {
        this(context, null);
    }

    @TargetApi(19)
    private float c() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private CaptionStyleCompat d() {
        return CaptionStyleCompat.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }

    public void a() {
        a(((y.f8407a < 19 || isInEditMode()) ? 1.0f : c()) * 0.0533f);
    }

    public void b() {
        a((y.f8407a < 19 || isInEditMode()) ? CaptionStyleCompat.f8313a : d());
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        List<Cue> list = this.b;
        int i = 0;
        int size = list == null ? 0 : list.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = getPaddingTop() + top;
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom <= paddingTop || right <= left) {
            return;
        }
        int i2 = this.c;
        if (i2 == 2) {
            f = this.d;
        } else {
            f = (i2 == 0 ? paddingBottom - paddingTop : bottom - top) * this.d;
        }
        if (f <= 0.0f) {
            return;
        }
        while (i < size) {
            int i3 = paddingBottom;
            int i4 = right;
            this.f8449a.get(i).a(this.b.get(i), this.e, this.f, this.g, f, this.h, canvas, left, paddingTop, i4, i3);
            i++;
            paddingBottom = i3;
            right = i4;
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8449a = new ArrayList();
        this.c = 0;
        this.d = 0.0533f;
        this.e = true;
        this.f = true;
        this.g = CaptionStyleCompat.f8313a;
        this.h = 0.08f;
    }

    public void a(float f) {
        a(f, false);
    }

    public void b(@Nullable List<Cue> list) {
        if (this.b == list) {
            return;
        }
        this.b = list;
        int size = list == null ? 0 : list.size();
        while (this.f8449a.size() < size) {
            this.f8449a.add(new d(getContext()));
        }
        invalidate();
    }

    public void a(float f, boolean z) {
        a(z ? 1 : 0, f);
    }

    private void a(int i, float f) {
        if (this.c == i && this.d == f) {
            return;
        }
        this.c = i;
        this.d = f;
        invalidate();
    }

    public void a(CaptionStyleCompat captionStyleCompat) {
        if (this.g == captionStyleCompat) {
            return;
        }
        this.g = captionStyleCompat;
        invalidate();
    }

    @Override // com.opos.exoplayer.core.text.h
    public void a(List<Cue> list) {
        b(list);
    }
}
