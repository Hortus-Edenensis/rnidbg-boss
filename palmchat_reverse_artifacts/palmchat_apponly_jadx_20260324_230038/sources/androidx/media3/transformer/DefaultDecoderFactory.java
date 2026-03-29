package androidx.media3.transformer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.DefaultDecoderFactory;
import androidx.media3.transformer.ExportException;
import androidx.media3.transformer.TransformerUtil;
import com.google.common.collect.ImmutableList;
import com.oplus.tblplayer.misc.IMediaFormat;
import defpackage.th;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DefaultDecoderFactory implements Codec.DecoderFactory {
    private static final String TAG = "DefaultDecoderFactory";
    private final int codecPriority;
    private final Context context;
    private final boolean dynamicSchedulingEnabled;
    private final boolean enableDecoderFallback;
    private final Listener listener;
    private final MediaCodecSelector mediaCodecSelector;
    private final boolean shouldConfigureOperatingRate;

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onCodecInitialized(String str, List<ExportException> list);
    }

    private static void configureOperatingRate(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT < 25) {
            return;
        }
        if (deviceNeedsPriorityWorkaround()) {
            mediaFormat.setInteger("priority", 1);
        }
        mediaFormat.setInteger(IMediaFormat.KEY_OPERATING_RATE, 10000);
    }

    private DefaultCodec createCodecForMediaFormat(MediaFormat mediaFormat, Format format, @Nullable Surface surface, boolean z, @Nullable LogSessionId logSessionId) throws ExportException {
        ImmutableList.of();
        Assertions.checkNotNull(format.sampleMimeType);
        try {
            List<MediaCodecInfo> decoderInfosSortedByFullFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFullFormatSupport(MediaCodecUtil.getDecoderInfosSoftMatch(this.mediaCodecSelector, format, false, false), format);
            if (decoderInfosSortedByFullFormatSupport.isEmpty()) {
                throw createExportException(format, "No decoders for format");
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < decoderInfosSortedByFullFormatSupport.size(); i++) {
                    MediaCodecInfo mediaCodecInfo = decoderInfosSortedByFullFormatSupport.get(i);
                    if (!mediaCodecInfo.hardwareAccelerated) {
                        arrayList.add(mediaCodecInfo);
                    }
                }
                if (!arrayList.isEmpty()) {
                    decoderInfosSortedByFullFormatSupport = arrayList;
                }
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 31 && decoderInfosSortedByFullFormatSupport.get(0).codecMimeType.equals("video/dolby-vision")) {
                mediaFormat.setInteger("color-transfer-request", 7);
            }
            if (i2 >= 35 && logSessionId != null) {
                TransformerUtil.Api35.setLogSessionIdToMediaCodecFormat(mediaFormat, logSessionId);
            }
            ArrayList arrayList2 = new ArrayList();
            Context context = this.context;
            if (!this.enableDecoderFallback) {
                decoderInfosSortedByFullFormatSupport = decoderInfosSortedByFullFormatSupport.subList(0, 1);
            }
            DefaultCodec defaultCodecCreateCodecFromDecoderInfos = createCodecFromDecoderInfos(context, decoderInfosSortedByFullFormatSupport, format, mediaFormat, surface, arrayList2);
            this.listener.onCodecInitialized(defaultCodecCreateCodecFromDecoderInfos.getName(), arrayList2);
            return defaultCodecCreateCodecFromDecoderInfos;
        } catch (MediaCodecUtil.DecoderQueryException e) {
            Log.e(TAG, "Error querying decoders", e);
            throw createExportException(format, "Querying codecs failed");
        }
    }

    private static DefaultCodec createCodecFromDecoderInfos(Context context, List<MediaCodecInfo> list, Format format, MediaFormat mediaFormat, @Nullable Surface surface, List<ExportException> list2) throws ExportException {
        for (MediaCodecInfo mediaCodecInfo : list) {
            mediaFormat.setString(IMediaFormat.KEY_MIME, mediaCodecInfo.codecMimeType);
            try {
                return new DefaultCodec(context, format, mediaFormat, mediaCodecInfo.name, true, surface);
            } catch (ExportException e) {
                list2.add(e);
            }
        }
        throw list2.get(0);
    }

    private static ExportException createExportException(Format format, String str) {
        return ExportException.createForCodec(new IllegalArgumentException(str), 3003, new ExportException.CodecInfo(format.toString(), MimeTypes.isVideo((String) Assertions.checkNotNull(format.sampleMimeType)), true, null));
    }

    private static boolean decoderSupportsKeyAllowFrameDrop(Context context) {
        return Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29;
    }

    private static boolean deviceNeedsDisable8kWorkaround(Format format) {
        String str;
        if (Build.VERSION.SDK_INT < 31 && format.width >= 7680 && format.height >= 4320 && (str = format.sampleMimeType) != null && str.equals("video/hevc")) {
            String str2 = Build.MODEL;
            if (str2.equals("SM-F711U1") || str2.equals("SM-F926U1")) {
                return true;
            }
        }
        return false;
    }

    private static boolean deviceNeedsDisableToneMappingWorkaround(int i) {
        if (Build.MANUFACTURER.equals("Google") && Build.ID.startsWith("TP1A")) {
            return true;
        }
        if (i == 7) {
            String str = Build.MODEL;
            if (str.startsWith("SM-F936") || str.startsWith("SM-F916") || str.startsWith("SM-F721") || str.equals("SM-X900")) {
                return true;
            }
        }
        return Build.VERSION.SDK_INT < 34 && i == 6 && Build.MODEL.startsWith("SM-F936");
    }

    private static boolean deviceNeedsNoFrameRateWorkaround() {
        return Build.VERSION.SDK_INT < 30 && Build.DEVICE.equals("joyeuse");
    }

    private static boolean deviceNeedsPriorityWorkaround() {
        return Build.VERSION.SDK_INT >= 31 && (Build.SOC_MODEL.equals("s5e8835") || Build.SOC_MODEL.equals("SA8155P"));
    }

    private static boolean devicePrefersSoftwareDecoder(Format format) {
        if (format.width * format.height >= 2073600) {
            String str = Build.MODEL;
            if (th.a(str, "vivo 1906") || th.a(str, "redmi 7a") || th.a(str, "redmi 8")) {
                return true;
            }
        }
        return false;
    }

    public boolean isDynamicSchedulingEnabled() {
        return this.dynamicSchedulingEnabled;
    }

    @Deprecated
    public DefaultDecoderFactory(Context context) {
        this(new Builder(context));
    }

    @Override // androidx.media3.transformer.Codec.DecoderFactory
    public DefaultCodec createForAudioDecoding(Format format, @Nullable LogSessionId logSessionId) throws ExportException {
        return createCodecForMediaFormat(MediaFormatUtil.createMediaFormatFromFormat(format), format, null, false, logSessionId);
    }

    @Override // androidx.media3.transformer.Codec.DecoderFactory
    @SuppressLint({"InlinedApi"})
    public DefaultCodec createForVideoDecoding(Format format, Surface surface, boolean z, @Nullable LogSessionId logSessionId) throws ExportException {
        if (ColorInfo.isTransferHdr(format.colorInfo)) {
            if (z && (Build.VERSION.SDK_INT < 31 || deviceNeedsDisableToneMappingWorkaround(((ColorInfo) Assertions.checkNotNull(format.colorInfo)).colorTransfer))) {
                throw createExportException(format, "Tone-mapping HDR is not supported on this device.");
            }
            if (Build.VERSION.SDK_INT < 29) {
                throw createExportException(format, "Decoding HDR is not supported on this device.");
            }
        }
        if (deviceNeedsDisable8kWorkaround(format)) {
            throw createExportException(format, "Decoding 8k is not supported on this device.");
        }
        if (deviceNeedsNoFrameRateWorkaround()) {
            format = format.buildUpon().setFrameRate(-1.0f).build();
        }
        Format format2 = format;
        MediaFormat mediaFormatCreateMediaFormatFromFormat = MediaFormatUtil.createMediaFormatFromFormat(format2);
        if (decoderSupportsKeyAllowFrameDrop(this.context)) {
            mediaFormatCreateMediaFormatFromFormat.setInteger("allow-frame-drop", 0);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 31 && z) {
            mediaFormatCreateMediaFormatFromFormat.setInteger("color-transfer-request", 3);
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format2);
        if (codecProfileAndLevel != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormatCreateMediaFormatFromFormat, IMediaFormat.KEY_PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
            MediaFormatUtil.maybeSetInteger(mediaFormatCreateMediaFormatFromFormat, "level", ((Integer) codecProfileAndLevel.second).intValue());
        }
        if (i >= 35) {
            mediaFormatCreateMediaFormatFromFormat.setInteger("importance", Math.max(0, -this.codecPriority));
        }
        if (this.shouldConfigureOperatingRate) {
            configureOperatingRate(mediaFormatCreateMediaFormatFromFormat);
        }
        return createCodecForMediaFormat(mediaFormatCreateMediaFormatFromFormat, format2, surface, devicePrefersSoftwareDecoder(format2), logSessionId);
    }

    @Deprecated
    public DefaultDecoderFactory(Context context, boolean z, Listener listener) {
        this(new Builder(context).setEnableDecoderFallback(z).setListener(listener));
    }

    private DefaultDecoderFactory(Builder builder) {
        this.context = builder.context;
        this.enableDecoderFallback = builder.enableDecoderFallback;
        this.listener = builder.listener;
        this.codecPriority = builder.codecPriority;
        this.shouldConfigureOperatingRate = builder.shouldConfigureOperatingRate;
        this.mediaCodecSelector = builder.mediaCodecSelector;
        this.dynamicSchedulingEnabled = builder.dynamicSchedulingEnabled;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private final Context context;
        private boolean dynamicSchedulingEnabled;
        private boolean enableDecoderFallback;
        private Listener listener = new Listener() { // from class: j41
            @Override // androidx.media3.transformer.DefaultDecoderFactory.Listener
            public final void onCodecInitialized(String str, List list) {
                DefaultDecoderFactory.Builder.lambda$new$0(str, list);
            }
        };
        private int codecPriority = -2000;
        private boolean shouldConfigureOperatingRate = false;
        private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        public DefaultDecoderFactory build() {
            return new DefaultDecoderFactory(this);
        }

        public Builder experimentalSetDynamicSchedulingEnabled(boolean z) {
            this.dynamicSchedulingEnabled = z;
            return this;
        }

        public Builder setCodecPriority(@IntRange(to = 0) int i) {
            this.codecPriority = i;
            return this;
        }

        public Builder setEnableDecoderFallback(boolean z) {
            this.enableDecoderFallback = z;
            return this;
        }

        public Builder setListener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
            this.mediaCodecSelector = mediaCodecSelector;
            return this;
        }

        public Builder setShouldConfigureOperatingRate(boolean z) {
            this.shouldConfigureOperatingRate = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$new$0(String str, List list) {
        }
    }
}
