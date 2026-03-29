package androidx.media3.effect;

import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface ConvolutionFunction1D {

    /* JADX INFO: compiled from: SearchBox */
    public interface Provider {
        Size configure(Size size);

        ConvolutionFunction1D getConvolution(long j);
    }

    float domainEnd();

    float domainStart();

    float value(float f);

    float width();
}
