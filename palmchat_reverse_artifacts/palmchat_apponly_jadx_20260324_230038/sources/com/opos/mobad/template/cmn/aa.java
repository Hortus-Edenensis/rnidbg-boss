package com.opos.mobad.template.cmn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class aa extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9350a;
    private float b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9351a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final float f;

        public a(int i, int i2, float f) {
            this(i, i2, i, f);
        }

        public int a(int i) {
            int i2 = this.d;
            if (i <= i2) {
                return i2;
            }
            int i3 = this.b;
            return i >= i3 ? i3 : i;
        }

        public int b(int i) {
            int i2 = this.c;
            if (i <= i2) {
                return i2;
            }
            int i3 = this.f9351a;
            return i >= i3 ? i3 : i;
        }

        public String toString() {
            return "maxH = " + this.f9351a + ",maxW = " + this.b + ",minH = " + this.c + ",minW = " + this.d;
        }

        public a(int i, int i2, int i3, float f) {
            f = f <= 0.0f ? 6.315f : f;
            this.f = f;
            int i4 = i > 0 ? i : MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE;
            this.b = i4;
            this.f9351a = (int) (i4 / f);
            if (i2 <= i4 && i2 > 0) {
                i = i2;
            }
            this.d = i;
            this.c = (int) (i / f);
            this.e = a(i3);
        }
    }

    public aa(Context context, AttributeSet attributeSet, int i, a aVar) {
        super(context, attributeSet, i);
        this.b = 1.0f;
        this.f9350a = aVar;
    }

    private void a(View view, float f) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = layoutParams.width;
        if (i != -2 && i != -1) {
            layoutParams.width = (int) (i * f);
        }
        int i2 = layoutParams.height;
        if (i2 != -2 && i2 != -1) {
            layoutParams.height = (int) (i2 * f);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = marginLayoutParams.bottomMargin;
            if (i3 != 0) {
                marginLayoutParams.bottomMargin = (int) (i3 * f);
            }
            int i4 = marginLayoutParams.topMargin;
            if (i4 != 0) {
                marginLayoutParams.topMargin = (int) (i4 * f);
            }
            int i5 = marginLayoutParams.leftMargin;
            if (i5 != 0) {
                marginLayoutParams.leftMargin = (int) (i5 * f);
            }
            int i6 = marginLayoutParams.rightMargin;
            if (i6 != 0) {
                marginLayoutParams.rightMargin = (int) (i6 * f);
            }
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextSize(0, textView.getTextSize() * f);
            float lineSpacingExtra = textView.getLineSpacingExtra();
            if (0.0f != lineSpacingExtra) {
                lineSpacingExtra *= f;
            }
            textView.setLineSpacing(lineSpacingExtra, textView.getLineSpacingMultiplier());
            textView.setPadding((int) (textView.getPaddingLeft() * f), (int) (textView.getPaddingTop() * f), (int) (textView.getPaddingRight() * f), (int) (textView.getPaddingBottom() * f));
            if (textView.getMaxWidth() > 0) {
                textView.setMaxWidth((int) (textView.getMaxWidth() * f));
            }
        }
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                a(viewGroup.getChildAt(i7), f);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0036  */
    @Override // android.widget.RelativeLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int iB = this.f9350a.b(size);
        int iA = this.f9350a.a(size2);
        a aVar = this.f9350a;
        int iA2 = aVar.a(aVar.e);
        float f = this.f9350a.f;
        int i3 = (int) (iA2 / f);
        int i4 = (int) (iA / f);
        int i5 = (int) (iB * f);
        if (mode2 != 1073741824) {
            if (mode == 1073741824) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iB, 1073741824);
            } else if (mode2 == Integer.MIN_VALUE && mode == Integer.MIN_VALUE) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iA2, 1073741824);
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iA, 1073741824);
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            }
        }
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    public aa(Context context, AttributeSet attributeSet, a aVar) {
        this(context, attributeSet, 0, aVar);
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            float width = viewGroup.getWidth() / this.f9350a.e;
            float f = this.b;
            if (f == width) {
                return;
            }
            this.b = width;
            com.opos.cmn.an.f.a.b("ScaleViewGroup", "scale view = " + viewGroup + ",scale = " + width);
            float f2 = width / f;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), f2);
            }
        }
    }

    public aa(Context context, a aVar) {
        this(context, null, aVar);
    }
}
