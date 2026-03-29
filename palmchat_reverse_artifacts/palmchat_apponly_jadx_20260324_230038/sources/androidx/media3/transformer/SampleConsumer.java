package androidx.media3.transformer;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface SampleConsumer {
    public static final int INPUT_RESULT_END_OF_STREAM = 3;
    public static final int INPUT_RESULT_SUCCESS = 1;
    public static final int INPUT_RESULT_TRY_AGAIN_LATER = 2;

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputResult {
    }

    @Nullable
    DecoderInputBuffer getInputBuffer();

    Surface getInputSurface();

    int getPendingVideoFrameCount();

    int queueInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator);

    boolean queueInputBuffer();

    int queueInputTexture(int i, long j);

    boolean registerVideoFrame(long j);

    void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener);

    void setOnInputSurfaceReadyListener(Runnable runnable);

    void signalEndOfVideoInput();
}
