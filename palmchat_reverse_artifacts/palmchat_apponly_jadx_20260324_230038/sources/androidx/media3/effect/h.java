package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h {
    public static GlShaderProgram a(ColorLut colorLut, Context context, boolean z) throws VideoFrameProcessingException {
        return new ColorLutShaderProgram(context, colorLut, z);
    }
}
