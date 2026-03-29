package androidx.media3.transformer;

import android.content.Context;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.GlEffect;
import androidx.media3.effect.ScaleAndRotateTransformation;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import androidx.media3.transformer.Codec;
import com.google.common.collect.ImmutableList;
import com.huawei.openalliance.ad.constant.bh;
import com.huawei.openalliance.ad.constant.bi;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.umeng.analytics.pro.dn;
import defpackage.th;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class TransformerUtil {

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(35)
    public static final class Api35 {
        private Api35() {
        }

        public static void setLogSessionIdToMediaCodecFormat(MediaFormat mediaFormat, LogSessionId logSessionId) {
            if (logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            mediaFormat.setString("log-session-id", logSessionId.getStringId());
        }
    }

    private TransformerUtil() {
    }

    private static boolean containsSlowMotionData(Format format) {
        Metadata metadata = format.metadata;
        if (metadata == null) {
            return false;
        }
        for (int i = 0; i < metadata.length(); i++) {
            if (metadata.get(i) instanceof SlowMotionData) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    private static String getCommonImageMimeTypeFromExtension(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 96870:
                if (str.equals("arw")) {
                    b = 0;
                }
                break;
            case 97669:
                if (str.equals("bmp")) {
                    b = 1;
                }
                break;
            case 98723:
                if (str.equals("cr2")) {
                    b = 2;
                }
                break;
            case 99453:
                if (str.equals("dib")) {
                    b = 3;
                }
                break;
            case 102340:
                if (str.equals(bh.V)) {
                    b = 4;
                }
                break;
            case 104085:
                if (str.equals("ico")) {
                    b = 5;
                }
                break;
            case 104430:
                if (str.equals("k25")) {
                    b = 6;
                }
                break;
            case 105133:
                if (str.equals("jfi")) {
                    b = 7;
                }
                break;
            case 105223:
                if (str.equals("jif")) {
                    b = 8;
                }
                break;
            case 105439:
                if (str.equals("jpe")) {
                    b = 9;
                }
                break;
            case 105441:
                if (str.equals("jpg")) {
                    b = 10;
                }
                break;
            case 111145:
                if (str.equals("png")) {
                    b = 11;
                }
                break;
            case 112680:
                if (str.equals("raw")) {
                    b = 12;
                }
                break;
            case 114276:
                if (str.equals("svg")) {
                    b = dn.k;
                }
                break;
            case 114833:
                if (str.equals("tif")) {
                    b = dn.l;
                }
                break;
            case 3006482:
                if (str.equals("avif")) {
                    b = 15;
                }
                break;
            case 3198679:
                if (str.equals("heic")) {
                    b = 16;
                }
                break;
            case 3198682:
                if (str.equals("heif")) {
                    b = 17;
                }
                break;
            case 3259225:
                if (str.equals("jfif")) {
                    b = 18;
                }
                break;
            case 3268712:
                if (str.equals("jpeg")) {
                    b = 19;
                }
                break;
            case 3542678:
                if (str.equals("svgz")) {
                    b = 20;
                }
                break;
            case 3559925:
                if (str.equals("tiff")) {
                    b = 21;
                }
                break;
            case 3645340:
                if (str.equals("webp")) {
                    b = 22;
                }
                break;
        }
        switch (b) {
            case 0:
            case 2:
            case 6:
            case 12:
                return MimeTypes.IMAGE_RAW;
            case 1:
            case 3:
                return MimeTypes.IMAGE_BMP;
            case 4:
                return bi.B;
            case 5:
                return "image/x-icon";
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 19:
                return "image/jpeg";
            case 11:
                return "image/png";
            case 13:
            case 20:
                return "image/svg+xml";
            case 14:
            case 21:
                return "image/tiff";
            case 15:
                return MimeTypes.IMAGE_AVIF;
            case 16:
                return MimeTypes.IMAGE_HEIC;
            case 17:
                return MimeTypes.IMAGE_HEIF;
            case 22:
                return MimeTypes.IMAGE_WEBP;
            default:
                return null;
        }
    }

    public static ColorInfo getDecoderOutputColor(ColorInfo colorInfo, boolean z) {
        return (z && ColorInfo.isTransferHdr(colorInfo)) ? ColorInfo.SDR_BT709_LIMITED : colorInfo;
    }

    @Nullable
    public static String getImageMimeType(Context context, MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.localConfiguration;
        if (localConfiguration == null) {
            return null;
        }
        String str = localConfiguration.mimeType;
        if (str != null) {
            return str;
        }
        if (Objects.equals(localConfiguration.uri.getScheme(), "content")) {
            return context.getContentResolver().getType(localConfiguration.uri);
        }
        String path = localConfiguration.uri.getPath();
        if (path == null) {
            return null;
        }
        int iLastIndexOf = path.lastIndexOf(".");
        return (iLastIndexOf < 0 || iLastIndexOf >= path.length() + (-1)) ? str : getCommonImageMimeTypeFromExtension(th.e(path.substring(iLastIndexOf + 1)));
    }

    public static int getMediaCodecFlags(int i) {
        int i2 = (i & 1) != 1 ? 0 : 1;
        return (i & 4) == 4 ? i2 | 4 : i2;
    }

    public static Pair<String, Integer> getOutputMimeTypeAndHdrModeAfterFallback(int i, String str, @Nullable ColorInfo colorInfo) {
        if (i == 0 && ColorInfo.isTransferHdr(colorInfo) && EncoderUtil.getSupportedEncodersForHdrEditing(str, colorInfo).isEmpty()) {
            if (EncoderUtil.getSupportedEncodersForHdrEditing("video/hevc", colorInfo).isEmpty()) {
                i = 2;
            } else {
                str = "video/hevc";
            }
        }
        return Pair.create(str, Integer.valueOf(i));
    }

    public static int getProcessedTrackType(@Nullable String str) {
        int trackType = MimeTypes.getTrackType(str);
        if (trackType == 4) {
            return 2;
        }
        return trackType;
    }

    public static ColorInfo getValidColor(@Nullable ColorInfo colorInfo) {
        return (colorInfo == null || !colorInfo.isDataSpaceValid()) ? ColorInfo.SDR_BT709_LIMITED : colorInfo;
    }

    public static boolean isImage(Context context, MediaItem mediaItem) {
        String imageMimeType = getImageMimeType(context, mediaItem);
        return imageMimeType != null && MimeTypes.isImage(imageMimeType);
    }

    private static float maybeCalculateTotalRotationDegreesAppliedInEffects(ImmutableList<Effect> immutableList, Format format) {
        int i = format.rotationDegrees;
        int i2 = i % EffectConstants.ROTATION_DEGREES_180 == 0 ? format.width : format.height;
        int i3 = i % EffectConstants.ROTATION_DEGREES_180 == 0 ? format.height : format.width;
        float f = 0.0f;
        for (int i4 = 0; i4 < immutableList.size(); i4++) {
            Effect effect = immutableList.get(i4);
            if (!(effect instanceof GlEffect)) {
                return -1.0f;
            }
            GlEffect glEffect = (GlEffect) effect;
            if (effect instanceof ScaleAndRotateTransformation) {
                ScaleAndRotateTransformation scaleAndRotateTransformation = (ScaleAndRotateTransformation) effect;
                if (scaleAndRotateTransformation.scaleX != 1.0f || scaleAndRotateTransformation.scaleY != 1.0f) {
                    return -1.0f;
                }
                float f2 = scaleAndRotateTransformation.rotationDegrees;
                if (f2 % 90.0f != 0.0f) {
                    return -1.0f;
                }
                f += f2;
                float f3 = f % 180.0f;
                i2 = f3 == 0.0f ? format.width : format.height;
                i3 = f3 == 0.0f ? format.height : format.width;
            } else if (!glEffect.isNoOp(i2, i3)) {
                return -1.0f;
            }
        }
        float f4 = f % 360.0f;
        if (f4 % 90.0f == 0.0f) {
            return f4;
        }
        return -1.0f;
    }

    public static void maybeSetMuxerWrapperAdditionalRotationDegrees(MuxerWrapper muxerWrapper, ImmutableList<Effect> immutableList, Format format) {
        float fMaybeCalculateTotalRotationDegreesAppliedInEffects = maybeCalculateTotalRotationDegreesAppliedInEffects(immutableList, format);
        if (fMaybeCalculateTotalRotationDegreesAppliedInEffects == 90.0f || fMaybeCalculateTotalRotationDegreesAppliedInEffects == 180.0f || fMaybeCalculateTotalRotationDegreesAppliedInEffects == 270.0f) {
            muxerWrapper.setAdditionalRotationDegrees(360 - Math.round(fMaybeCalculateTotalRotationDegreesAppliedInEffects));
        }
    }

    public static boolean shouldTranscodeAudio(Format format, Composition composition, int i, TransformationRequest transformationRequest, Codec.EncoderFactory encoderFactory, MuxerWrapper muxerWrapper) {
        if (composition.sequences.size() > 1 || composition.sequences.get(i).editedMediaItems.size() > 1) {
            return !composition.transmuxAudio;
        }
        if (composition.hasGaps() || encoderFactory.audioNeedsEncoding()) {
            return true;
        }
        String str = transformationRequest.audioMimeType;
        if (str != null && !str.equals(format.sampleMimeType)) {
            return true;
        }
        if (transformationRequest.audioMimeType == null && !muxerWrapper.supportsSampleMimeType(format.sampleMimeType)) {
            return true;
        }
        EditedMediaItem editedMediaItem = composition.sequences.get(i).editedMediaItems.get(0);
        return ((!editedMediaItem.flattenForSlowMotion || !containsSlowMotionData(format)) && editedMediaItem.effects.audioProcessors.isEmpty() && composition.effects.audioProcessors.isEmpty()) ? false : true;
    }

    public static boolean shouldTranscodeVideo(Format format, Composition composition, int i, TransformationRequest transformationRequest, Codec.EncoderFactory encoderFactory, MuxerWrapper muxerWrapper) {
        if (composition.sequences.size() > 1 || composition.sequences.get(i).editedMediaItems.size() > 1) {
            return !composition.transmuxVideo;
        }
        if (encoderFactory.videoNeedsEncoding() || transformationRequest.hdrMode != 0) {
            return true;
        }
        String str = transformationRequest.videoMimeType;
        if (str != null) {
            if (!(str.equals(format.sampleMimeType) || str.equals(MediaCodecUtil.getAlternativeCodecMimeType(format)))) {
                return true;
            }
        }
        if ((str == null && !muxerWrapper.supportsSampleMimeType(format.sampleMimeType) && !muxerWrapper.supportsSampleMimeType(MediaCodecUtil.getAlternativeCodecMimeType(format))) || format.pixelWidthHeightRatio != 1.0f) {
            return true;
        }
        ImmutableList immutableListE = new ImmutableList.a().l(composition.sequences.get(i).editedMediaItems.get(0).effects.videoEffects).l(composition.effects.videoEffects).e();
        return !immutableListE.isEmpty() && maybeCalculateTotalRotationDegreesAppliedInEffects(immutableListE, format) == -1.0f;
    }
}
