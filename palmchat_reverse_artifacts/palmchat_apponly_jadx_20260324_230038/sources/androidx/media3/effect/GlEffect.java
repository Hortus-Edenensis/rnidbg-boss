package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.Effect;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface GlEffect extends Effect {
    boolean isNoOp(int i, int i2);

    GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;
}
