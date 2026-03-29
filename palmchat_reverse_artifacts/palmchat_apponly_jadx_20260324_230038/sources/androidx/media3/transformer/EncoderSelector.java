package androidx.media3.transformer;

import android.media.MediaCodecInfo;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface EncoderSelector {
    public static final EncoderSelector DEFAULT = new EncoderSelector() { // from class: lm1
        @Override // androidx.media3.transformer.EncoderSelector
        public final ImmutableList selectEncoderInfos(String str) {
            return nm1.b(str);
        }
    };

    ImmutableList<MediaCodecInfo> selectEncoderInfos(String str);
}
