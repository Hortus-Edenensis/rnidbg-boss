package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.C;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Size;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y0 {
    public static Size a(GlMatrixTransformation glMatrixTransformation, int i, int i2) {
        return new Size(i, i2);
    }

    public static int b(GlMatrixTransformation glMatrixTransformation) {
        return C.TEXTURE_MIN_FILTER_LINEAR;
    }

    public static BaseGlShaderProgram c(GlMatrixTransformation glMatrixTransformation, Context context, boolean z) throws VideoFrameProcessingException {
        return DefaultShaderProgram.create(context, ImmutableList.of(glMatrixTransformation), ImmutableList.of(), z);
    }
}
