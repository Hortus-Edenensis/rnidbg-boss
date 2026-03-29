package androidx.media3.transformer;

import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableMap;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface AssetLoader {
    public static final int SUPPORTED_OUTPUT_TYPE_DECODED = 2;
    public static final int SUPPORTED_OUTPUT_TYPE_ENCODED = 1;

    /* JADX INFO: compiled from: SearchBox */
    public static class CompositionSettings {
        public final int hdrMode;
        public final boolean retainHdrFromUltraHdrImage;

        public CompositionSettings(int i, boolean z) {
            this.hdrMode = i;
            this.retainHdrFromUltraHdrImage = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Factory {
        AssetLoader createAssetLoader(EditedMediaItem editedMediaItem, Looper looper, Listener listener, CompositionSettings compositionSettings);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onDurationUs(long j);

        void onError(ExportException exportException);

        @Nullable
        SampleConsumer onOutputFormat(Format format) throws ExportException;

        boolean onTrackAdded(Format format, int i);

        void onTrackCount(@IntRange(from = 1) int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedOutputTypes {
    }

    ImmutableMap<Integer, String> getDecoderNames();

    int getProgress(ProgressHolder progressHolder);

    void release();

    void start();
}
