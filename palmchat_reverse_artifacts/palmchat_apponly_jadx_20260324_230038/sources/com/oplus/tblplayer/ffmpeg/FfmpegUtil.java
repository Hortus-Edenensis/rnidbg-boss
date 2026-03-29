package com.oplus.tblplayer.ffmpeg;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.platform.comapi.map.MapController;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecUtil;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.logger.Logger;
import com.oplus.tblplayer.utils.ByteUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FfmpegUtil {
    private static final int AV_SAMPLE_FMT_FLT = 3;
    private static final int AV_SAMPLE_FMT_NONE = -1;
    private static final int AV_SAMPLE_FMT_S16 = 1;
    private static final int AV_SAMPLE_FMT_U8 = 0;
    public static final boolean DEBUG = false;
    public static final String PCM_24BIT = "pcm_s24le";
    public static final String PCM_32BIT = "pcm_s32le";
    private static final String TAG = "FfmpegUtil";

    public static Format convertDolbyVisionFormat(Format format) {
        Pair<Integer, Integer> codecProfileAndLevel;
        Format.Builder builderBuildUpon;
        String str;
        if (format == null || !"video/dolby-vision".equals(format.sampleMimeType) || (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) == null) {
            return format;
        }
        int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
        if (iIntValue == 4 || iIntValue == 8 || iIntValue == 16 || iIntValue == 32 || iIntValue == 64 || iIntValue == 128 || iIntValue == 256) {
            builderBuildUpon = format.buildUpon();
            str = "video/hevc";
        } else {
            if (iIntValue != 1 && iIntValue != 2 && iIntValue != 512) {
                return format;
            }
            builderBuildUpon = format.buildUpon();
            str = "video/avc";
        }
        return builderBuildUpon.setSampleMimeType(str).setCodecs(null).build();
    }

    public static void d(@NonNull String str, String str2) {
    }

    public static void e(@NonNull String str, String str2) {
        Logger.e(str, str2);
    }

    public static byte[] getFfmpegCodecParametersData(Format format) {
        if (!isFfmpegExtractor(format) || !hasFfmpegCodecParameters(format)) {
            return null;
        }
        return format.initializationData.get(r1.size() - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
    
        if (r7.sampleMimeType.equals("audio/opus") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] getFfmpegExtraData(Format format) {
        if (format != null && !format.initializationData.isEmpty()) {
            int size = format.initializationData.size();
            if (isFfmpegExtractor(format)) {
                if (isFfmpegExtraDataEmpty(format)) {
                    return null;
                }
                size--;
            }
            if (size != 1) {
                if (size == 2) {
                    byte[] bArr = format.initializationData.get(0);
                    byte[] bArr2 = format.initializationData.get(1);
                    byte[] bArr3 = new byte[bArr.length + bArr2.length + 6];
                    bArr3[0] = (byte) (bArr.length >> 8);
                    bArr3[1] = (byte) (bArr.length & 255);
                    System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
                    bArr3[bArr.length + 2] = 0;
                    bArr3[bArr.length + 3] = 0;
                    bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
                    bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
                    System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
                    return bArr3;
                }
                if (size == 3) {
                }
            }
            return format.initializationData.get(0);
        }
        return null;
    }

    public static String getSeekWhenceString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 65536 ? "unknown whence" : "AVSEEK_SIZE" : "SEEK_END" : "SEEK_CUR" : "SEEK_SET";
    }

    public static String getTrackTypeString(int i) {
        if (i == 0) {
            return MapController.DEFAULT_LAYER_TAG;
        }
        if (i == 1) {
            return "audio";
        }
        if (i == 2) {
            return "video";
        }
        if (i == 3) {
            return "text";
        }
        if (i == 5) {
            return "metadata";
        }
        if (i == 6) {
            return "camera motion";
        }
        if (i == 7) {
            return "none";
        }
        if (i < 10000) {
            return Constants.STRING_VALUE_UNSET;
        }
        return "custom (" + i + ")";
    }

    public static Object getVideoOutPutModeString(int i) {
        return i != -1 ? i != 0 ? i != 1 ? Constants.STRING_VALUE_UNSET : "SURFACE_YUV" : "YUV" : "NONE";
    }

    public static String getVideoSoftRenderModeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? Constants.STRING_VALUE_UNSET : "SURFACE_LEGACY" : "OPENGL" : "SURFACE";
    }

    public static boolean hasFfmpegCodecParameters(Format format) {
        List<byte[]> list;
        return isFfmpegExtractor(format) && (list = format.initializationData) != null && list.size() > 0;
    }

    public static void i(String str, String str2) {
        Logger.i(str, str2);
    }

    public static void ifmt(@NonNull String str, String str2, Object... objArr) {
        Logger.i(str, String.format(str2, objArr));
    }

    public static boolean isFfmpegExtraDataEmpty(Format format) {
        return hasFfmpegCodecParameters(format) && format.initializationData.size() == 1;
    }

    public static boolean isFfmpegExtractor(Format format) {
        String str;
        return (format == null || (str = format.label) == null || !str.contains(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL)) ? false : true;
    }

    public static boolean isVideoPixelFormatHwNotSupported(Format format) {
        String str;
        return (format == null || (str = format.label) == null || !str.contains("VideoPixelFormatHwNotSupported")) ? false : true;
    }

    public static boolean isVorbisTrack(Track track) {
        return track != null && track.getType() == 1 && track.getMimeType().equals("audio/vorbis");
    }

    public static Format maybeRemoveFfmpegCodecParameters(Format format) {
        if (!isFfmpegExtractor(format) || !hasFfmpegCodecParameters(format)) {
            return format;
        }
        ArrayList arrayList = new ArrayList(format.initializationData);
        arrayList.remove(format.initializationData.size() - 1);
        return format.buildUpon().setInitializationData(arrayList).build();
    }

    public static List<byte[]> parseVorbisConfiguration(byte[] bArr) throws ParserException {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            int i3 = 1;
            int i4 = 0;
            while (true) {
                i = bArr[i3];
                if (i != -1) {
                    break;
                }
                i4 += 255;
                i3++;
            }
            int i5 = i3 + 1;
            int i6 = i4 + i;
            int i7 = 0;
            while (true) {
                i2 = bArr[i5];
                if (i2 != -1) {
                    break;
                }
                i7 += 255;
                i5++;
            }
            int i8 = i5 + 1;
            int i9 = i7 + i2;
            if (bArr[i8] != 1) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i8, bArr2, 0, i6);
            int i10 = i8 + i6;
            if (bArr[i10] != 3) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw new ParserException("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i11];
            System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ParserException("Error parsing vorbis codec private");
        }
    }

    public static final int pcmEncodingToAVSampleFormat(int i) {
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? -1 : 3;
        }
        return 0;
    }

    public static void printExtraData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        i(TAG, ByteUtil.toHexArrayString(bArr, 0, bArr.length));
    }

    public static boolean shouldRequireConvert2AnnexB(Track track) {
        int i;
        return track != null && track.getType() == 2 && (track.getMimeType().equals("video/hevc") || track.getMimeType().equals("video/avc")) && ((i = track.nalUnitLengthFieldLength) == 3 || i == 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean shouldRequireParseConfiguration(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z;
        try {
            if (parsableByteArray.limit() > 0) {
                z = true;
                if (parsableByteArray.readUnsignedByte() != 1 && parsableByteArray.readUnsignedByte() != 1) {
                    z = false;
                }
            }
            parsableByteArray.setPosition(0);
            return z;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error reading form bytes.", e);
        }
    }

    public static void d(@NonNull String str, String str2, Throwable th) {
    }

    public static void e(@NonNull String str, String str2, Throwable th) {
        Logger.e(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        Logger.i(str, str2, th);
    }

    public static void dfmt(@NonNull String str, String str2, Object... objArr) {
    }
}
