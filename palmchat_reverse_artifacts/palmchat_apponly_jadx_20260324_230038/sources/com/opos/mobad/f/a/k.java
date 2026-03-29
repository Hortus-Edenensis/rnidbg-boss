package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.widget.ViewSwitcher;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class k extends ViewSwitcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile a f8874a;
    private final b b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8875a;
        public final int b;
        public final int c;
        public final int d;
        public final float e;

        public b(int i, int i2, float f) {
            f = f <= 0.0f ? 6.315f : f;
            this.e = f;
            int i3 = i > 0 ? i : MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE;
            this.b = i3;
            this.f8875a = (int) (i3 / f);
            if (i2 <= i3 && i2 > 0) {
                i = i2;
            }
            this.d = i;
            this.c = (int) (i / f);
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
            int i3 = this.f8875a;
            return i >= i3 ? i3 : i;
        }

        public String toString() {
            return "maxH = " + this.f8875a + ",maxW = " + this.b + ",minH = " + this.c + ",minW = " + this.d;
        }
    }

    public k(Context context, b bVar) {
        super(context);
        this.b = bVar;
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i == i3 && i2 == i4) {
            return;
        }
        if (this.f8874a != null) {
            this.f8874a.a(i, i2);
        }
        com.opos.cmn.an.f.a.b("switcher", "w = " + i + ",h = " + i2 + ",oldw = " + i3 + ",oldh = " + i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int iB = this.b.b(size);
        int iA = this.b.a(size2);
        float f = this.b.e;
        int i3 = (int) (iA / f);
        int i4 = (int) (iB * f);
        if (mode2 != 1073741824 && mode == 1073741824) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iB, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iA, 1073741824);
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.opos.cmn.an.f.a.b("switcher", "onSizeChanged w = " + i + ",h = " + i2 + ",oldw = " + i3 + ",oldh = " + i4);
        a(i, i2, i3, i4);
    }

    public void a(a aVar) {
        this.f8874a = aVar;
    }
}
