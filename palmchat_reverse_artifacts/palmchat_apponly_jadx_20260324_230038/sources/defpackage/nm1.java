package defpackage;

import android.media.MediaCodecInfo;
import androidx.media3.transformer.EncoderSelector;
import androidx.media3.transformer.EncoderUtil;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nm1 {
    static {
        EncoderSelector encoderSelector = EncoderSelector.DEFAULT;
    }

    public static /* synthetic */ ImmutableList b(final String str) {
        ImmutableList<MediaCodecInfo> supportedEncoders = EncoderUtil.getSupportedEncoders(str);
        ImmutableList immutableListCopyOf = ImmutableList.copyOf(bv2.e(supportedEncoders, new em4() { // from class: mm1
            @Override // defpackage.em4
            public final boolean apply(Object obj) {
                return EncoderUtil.isHardwareAccelerated((MediaCodecInfo) obj, str);
            }
        }));
        return immutableListCopyOf.isEmpty() ? supportedEncoders : immutableListCopyOf;
    }
}
