package defpackage;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class oz {
    public static final oz g = new oz(-1, -16777216, 0, 0, -1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19903a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    @Nullable
    public final Typeface f;

    public oz(int i, int i2, int i3, int i4, int i5, @Nullable Typeface typeface) {
        this.f19903a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = typeface;
    }

    @RequiresApi(19)
    public static oz a(CaptioningManager.CaptionStyle captionStyle) {
        return g86.f17680a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @RequiresApi(19)
    public static oz b(CaptioningManager.CaptionStyle captionStyle) {
        return new oz(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @RequiresApi(21)
    public static oz c(CaptioningManager.CaptionStyle captionStyle) {
        return new oz(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : g.f19903a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : g.b, captionStyle.hasWindowColor() ? captionStyle.windowColor : g.c, captionStyle.hasEdgeType() ? captionStyle.edgeType : g.d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : g.e, captionStyle.getTypeface());
    }
}
