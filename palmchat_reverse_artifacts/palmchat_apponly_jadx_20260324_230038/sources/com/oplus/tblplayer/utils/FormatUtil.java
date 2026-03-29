package com.oplus.tblplayer.utils;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.ffmpeg.FfmpegLibrary;
import com.oplus.tblplayer.misc.DeviceModelDetection;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FormatUtil {
    private static final String TAG = "FormatUtil";

    private FormatUtil() {
    }

    public static Format copy(Format format, boolean z) {
        try {
            Constructor declaredConstructor = Format.Builder.class.getDeclaredConstructor(Format.class);
            AssertUtil.checkNotNull(declaredConstructor);
            declaredConstructor.setAccessible(true);
            Format.Builder builder = (Format.Builder) declaredConstructor.newInstance(format);
            if (z) {
                int i = format.encoderDelay;
                if (i == 0) {
                    i = 2048;
                }
                LogUtil.d(TAG, "newEncoderDelay " + i);
                builder.setEncoderDelay(i);
            }
            AssertUtil.checkNotNull(builder);
            return builder.build();
        } catch (Exception e) {
            throw new IllegalStateException("Error in instantiating bcap extension", e);
        }
    }

    public static int getFormatTagForSpecialVideo(Format format) {
        String str;
        if (format == null || (str = format.label) == null) {
            return 0;
        }
        if (str.contains("binaural")) {
            return 1;
        }
        return format.label.contains("bcap2") ? 2 : 0;
    }

    public static String getMimeTypeWithMediaExtractor(@NonNull Uri uri, int i) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            if (!"content".equals(uri.getScheme())) {
                mediaExtractor.setDataSource(uri.getPath());
            } else {
                if (Globals.getApplicationContext() == null) {
                    throw new IOException("The global context is null.");
                }
                mediaExtractor.setDataSource(Globals.getApplicationContext(), uri, (Map<String, String>) null);
            }
            return mediaExtractor.getTrackFormat(i).getString(IMediaFormat.KEY_MIME);
        } catch (IOException e) {
            LogUtil.e(TAG, "Use MediaExtractor parse binaural failed." + e.getMessage());
            return null;
        } finally {
            mediaExtractor.release();
        }
    }

    public static String getMimeTypeWithMediaRetriever(@NonNull Uri uri) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (!"content".equals(uri.getScheme())) {
                    mediaMetadataRetriever.setDataSource(uri.getPath());
                } else {
                    if (Globals.getApplicationContext() == null) {
                        throw new IOException("The global context is null.");
                    }
                    mediaMetadataRetriever.setDataSource(Globals.getApplicationContext(), uri);
                }
                return mediaMetadataRetriever.extractMetadata(7);
            } catch (Exception e) {
                LogUtil.e(TAG, "Use MediaRetriever parse binaural failed." + e.getMessage());
                mediaMetadataRetriever.release();
                return null;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static boolean hasFfmpegCodecParameters(Format format) {
        return isFfmpegExtractor(format) && format.initializationData.size() > 0;
    }

    public static boolean isFfmpegExtraDataEmpty(Format format) {
        return hasFfmpegCodecParameters(format) && format.initializationData.size() == 1;
    }

    public static boolean isFfmpegExtractor(Format format) {
        String str;
        return (format == null || (str = format.label) == null || !str.contains(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL)) ? false : true;
    }

    public static boolean isFfmpegNativeLibraryAvailable() {
        try {
            Boolean bool = Boolean.TRUE;
            int i = FfmpegLibrary.f7685a;
            return bool.equals(FfmpegLibrary.class.getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Exception e) {
            LogUtil.e(TAG, "There is some exception " + e.getMessage());
            return false;
        }
    }

    @UnstableApi
    public static boolean isHDR(ColorInfo colorInfo) {
        int i;
        return colorInfo != null && ((i = colorInfo.colorTransfer) == 6 || i == 7);
    }

    public static boolean isNeedNotifyErrorWithDolbyVideos(Format format) {
        String str;
        return format != null && (str = format.sampleMimeType) != null && str.equals("video/dolby-vision") && DeviceModelDetection.deviceNeedNotifyErrorWithDolbyVideosWorkaround();
    }

    public static boolean isSpecialVideoCodec(Format format) {
        String str;
        return (format == null || (str = format.label) == null || !str.contains("specialVideoCodec")) ? false : true;
    }

    public static boolean isUnSupportBrand(Format format) {
        String str;
        return (format == null || (str = format.label) == null || !str.contains(Constants.UNSUPPORTED_AVC1_BRAND_LABEL)) ? false : true;
    }

    public static boolean isUnsupportedDolbyVisionProfile(Format format) {
        String str;
        return (format == null || (str = format.label) == null || !str.contains(Constants.UNSUPPORTED_DOLBY_VISION_PROFILE_LABEL)) ? false : true;
    }

    public static boolean isVideoPixelFormatHwNotSupported(Format format) {
        String str;
        return (format == null || (str = format.label) == null || !str.contains("VideoPixelFormatHwNotSupported")) ? false : true;
    }

    public static Format maybeRemoveFfmpegCodecParameters(Format format) {
        if (!hasFfmpegCodecParameters(format)) {
            return format;
        }
        ArrayList arrayList = new ArrayList(format.initializationData);
        arrayList.remove(format.initializationData.size() - 1);
        return format.buildUpon().setInitializationData(arrayList).build();
    }
}
