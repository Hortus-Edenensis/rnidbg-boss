package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.util.UnstableApi;
import defpackage.ik1;
import defpackage.zb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DebugViewEffect implements GlEffect {
    private final DebugViewProvider debugViewProvider;
    private final ColorInfo outputColorInfo;

    public DebugViewEffect(DebugViewProvider debugViewProvider, ColorInfo colorInfo) {
        this.debugViewProvider = debugViewProvider;
        this.outputColorInfo = colorInfo;
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return zb2.a(this, i, i2);
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return new DebugViewShaderProgram(context, this.debugViewProvider, this.outputColorInfo);
    }
}
