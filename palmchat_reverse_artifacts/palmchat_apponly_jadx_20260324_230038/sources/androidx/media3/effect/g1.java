package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g1 {
    public static BaseGlShaderProgram a(RgbMatrix rgbMatrix, Context context, boolean z) throws VideoFrameProcessingException {
        return DefaultShaderProgram.create(context, ImmutableList.of(), ImmutableList.of(rgbMatrix), z);
    }
}
