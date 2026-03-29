package com.opos.exoplayer.core.text;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.opos.exoplayer.core.util.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class CaptionStyleCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CaptionStyleCompat f8313a = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final Typeface g;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface EdgeType {
    }

    public CaptionStyleCompat(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = typeface;
    }

    @TargetApi(19)
    public static CaptionStyleCompat a(CaptioningManager.CaptionStyle captionStyle) {
        return y.f8407a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @TargetApi(19)
    private static CaptionStyleCompat b(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static CaptionStyleCompat c(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f8313a.b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f8313a.c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f8313a.d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f8313a.e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f8313a.f, captionStyle.getTypeface());
    }
}
