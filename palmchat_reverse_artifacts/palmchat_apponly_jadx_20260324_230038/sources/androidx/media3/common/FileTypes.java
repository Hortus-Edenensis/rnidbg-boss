package androidx.media3.common;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.UnstableApi;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    public static final int AVI = 16;
    public static final int AVIF = 21;
    public static final int BMP = 19;
    private static final String EXTENSION_AAC = ".aac";
    private static final String EXTENSION_AC3 = ".ac3";
    private static final String EXTENSION_AC4 = ".ac4";
    private static final String EXTENSION_ADTS = ".adts";
    private static final String EXTENSION_AMR = ".amr";
    private static final String EXTENSION_AVI = ".avi";
    private static final String EXTENSION_AVIF = ".avif";
    private static final String EXTENSION_BMP = ".bmp";
    private static final String EXTENSION_DIB = ".dib";
    private static final String EXTENSION_EC3 = ".ec3";
    private static final String EXTENSION_FLAC = ".flac";
    private static final String EXTENSION_FLV = ".flv";
    private static final String EXTENSION_HEIC = ".heic";
    private static final String EXTENSION_HEIF = ".heif";
    private static final String EXTENSION_JPEG = ".jpeg";
    private static final String EXTENSION_JPG = ".jpg";
    private static final String EXTENSION_M2P = ".m2p";
    private static final String EXTENSION_MID = ".mid";
    private static final String EXTENSION_MIDI = ".midi";
    private static final String EXTENSION_MP3 = ".mp3";
    private static final String EXTENSION_MP4 = ".mp4";
    private static final String EXTENSION_MPEG = ".mpeg";
    private static final String EXTENSION_MPG = ".mpg";
    private static final String EXTENSION_OPUS = ".opus";
    private static final String EXTENSION_PNG = ".png";
    private static final String EXTENSION_PREFIX_CMF = ".cmf";
    private static final String EXTENSION_PREFIX_M4 = ".m4";
    private static final String EXTENSION_PREFIX_MK = ".mk";
    private static final String EXTENSION_PREFIX_MP4 = ".mp4";
    private static final String EXTENSION_PREFIX_OG = ".og";
    private static final String EXTENSION_PREFIX_TS = ".ts";
    private static final String EXTENSION_PS = ".ps";
    private static final String EXTENSION_SMF = ".smf";
    private static final String EXTENSION_TS = ".ts";
    private static final String EXTENSION_VTT = ".vtt";
    private static final String EXTENSION_WAV = ".wav";
    private static final String EXTENSION_WAVE = ".wave";
    private static final String EXTENSION_WEBM = ".webm";
    private static final String EXTENSION_WEBP = ".webp";
    private static final String EXTENSION_WEBVTT = ".webvtt";
    public static final int FLAC = 4;
    public static final int FLV = 5;

    @VisibleForTesting
    static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final int HEIF = 20;
    public static final int JPEG = 14;
    public static final int MATROSKA = 6;
    public static final int MIDI = 15;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;
    public static final int PNG = 17;
    public static final int PS = 10;
    public static final int TS = 11;
    public static final int UNKNOWN = -1;
    public static final int WAV = 12;
    public static final int WEBP = 18;
    public static final int WEBVTT = 13;

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private FileTypes() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int inferFileTypeFromMimeType(@Nullable String str) {
        byte b;
        if (str == null) {
            return -1;
        }
        String strNormalizeMimeType = MimeTypes.normalizeMimeType(str);
        strNormalizeMimeType.hashCode();
        switch (strNormalizeMimeType.hashCode()) {
            case -2123537834:
                b = !strNormalizeMimeType.equals("audio/eac3-joc") ? (byte) -1 : (byte) 0;
                break;
            case -1662384011:
                if (strNormalizeMimeType.equals("video/mp2p")) {
                    b = 1;
                    break;
                }
                break;
            case -1662384007:
                if (strNormalizeMimeType.equals("video/mp2t")) {
                    b = 2;
                    break;
                }
                break;
            case -1662095187:
                if (strNormalizeMimeType.equals("video/webm")) {
                    b = 3;
                    break;
                }
                break;
            case -1606874997:
                if (strNormalizeMimeType.equals("audio/amr-wb")) {
                    b = 4;
                    break;
                }
                break;
            case -1487656890:
                if (strNormalizeMimeType.equals(MimeTypes.IMAGE_AVIF)) {
                    b = 5;
                    break;
                }
                break;
            case -1487464693:
                if (strNormalizeMimeType.equals(MimeTypes.IMAGE_HEIC)) {
                    b = 6;
                    break;
                }
                break;
            case -1487464690:
                if (strNormalizeMimeType.equals(MimeTypes.IMAGE_HEIF)) {
                    b = 7;
                    break;
                }
                break;
            case -1487394660:
                if (strNormalizeMimeType.equals("image/jpeg")) {
                    b = 8;
                    break;
                }
                break;
            case -1487018032:
                if (strNormalizeMimeType.equals(MimeTypes.IMAGE_WEBP)) {
                    b = 9;
                    break;
                }
                break;
            case -1248337486:
                if (strNormalizeMimeType.equals("application/mp4")) {
                    b = 10;
                    break;
                }
                break;
            case -1079884372:
                if (strNormalizeMimeType.equals(MimeTypes.VIDEO_AVI)) {
                    b = 11;
                    break;
                }
                break;
            case -1004728940:
                if (strNormalizeMimeType.equals("text/vtt")) {
                    b = 12;
                    break;
                }
                break;
            case -879272239:
                if (strNormalizeMimeType.equals(MimeTypes.IMAGE_BMP)) {
                    b = dn.k;
                    break;
                }
                break;
            case -879258763:
                if (strNormalizeMimeType.equals("image/png")) {
                    b = dn.l;
                    break;
                }
                break;
            case -387023398:
                if (strNormalizeMimeType.equals("audio/x-matroska")) {
                    b = 15;
                    break;
                }
                break;
            case -43467528:
                if (strNormalizeMimeType.equals("application/webm")) {
                    b = 16;
                    break;
                }
                break;
            case 13915911:
                if (strNormalizeMimeType.equals("video/x-flv")) {
                    b = 17;
                    break;
                }
                break;
            case 187078296:
                if (strNormalizeMimeType.equals("audio/ac3")) {
                    b = 18;
                    break;
                }
                break;
            case 187078297:
                if (strNormalizeMimeType.equals("audio/ac4")) {
                    b = 19;
                    break;
                }
                break;
            case 187078669:
                if (strNormalizeMimeType.equals("audio/amr")) {
                    b = 20;
                    break;
                }
                break;
            case 187090232:
                if (strNormalizeMimeType.equals("audio/mp4")) {
                    b = 21;
                    break;
                }
                break;
            case 187091926:
                if (strNormalizeMimeType.equals("audio/ogg")) {
                    b = 22;
                    break;
                }
                break;
            case 187099443:
                if (strNormalizeMimeType.equals("audio/wav")) {
                    b = 23;
                    break;
                }
                break;
            case 1331848029:
                if (strNormalizeMimeType.equals("video/mp4")) {
                    b = 24;
                    break;
                }
                break;
            case 1503095341:
                if (strNormalizeMimeType.equals("audio/3gpp")) {
                    b = 25;
                    break;
                }
                break;
            case 1504578661:
                if (strNormalizeMimeType.equals("audio/eac3")) {
                    b = 26;
                    break;
                }
                break;
            case 1504619009:
                if (strNormalizeMimeType.equals("audio/flac")) {
                    b = 27;
                    break;
                }
                break;
            case 1504824762:
                if (strNormalizeMimeType.equals(MimeTypes.AUDIO_MIDI)) {
                    b = 28;
                    break;
                }
                break;
            case 1504831518:
                if (strNormalizeMimeType.equals("audio/mpeg")) {
                    b = 29;
                    break;
                }
                break;
            case 1505118770:
                if (strNormalizeMimeType.equals("audio/webm")) {
                    b = 30;
                    break;
                }
                break;
            case 2039520277:
                if (strNormalizeMimeType.equals("video/x-matroska")) {
                    b = TELogUtils.DEBUG_LEVEL_V;
                    break;
                }
                break;
        }
        switch (b) {
        }
        return -1;
    }

    public static int inferFileTypeFromResponseHeaders(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return inferFileTypeFromMimeType((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int inferFileTypeFromUri(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC3) || lastPathSegment.endsWith(EXTENSION_EC3)) {
            return 0;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC4)) {
            return 1;
        }
        if (lastPathSegment.endsWith(EXTENSION_ADTS) || lastPathSegment.endsWith(EXTENSION_AAC)) {
            return 2;
        }
        if (lastPathSegment.endsWith(EXTENSION_AMR)) {
            return 3;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLAC)) {
            return 4;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLV)) {
            return 5;
        }
        if (lastPathSegment.endsWith(EXTENSION_MID) || lastPathSegment.endsWith(EXTENSION_MIDI) || lastPathSegment.endsWith(EXTENSION_SMF)) {
            return 15;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_MK, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_WEBM)) {
            return 6;
        }
        if (lastPathSegment.endsWith(EXTENSION_MP3)) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(EXTENSION_PREFIX_M4, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(EXTENSION_PREFIX_CMF, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_OG, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_OPUS)) {
            return 9;
        }
        if (lastPathSegment.endsWith(EXTENSION_PS) || lastPathSegment.endsWith(EXTENSION_MPEG) || lastPathSegment.endsWith(EXTENSION_MPG) || lastPathSegment.endsWith(EXTENSION_M2P)) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(EXTENSION_WAV) || lastPathSegment.endsWith(EXTENSION_WAVE)) {
            return 12;
        }
        if (lastPathSegment.endsWith(EXTENSION_VTT) || lastPathSegment.endsWith(EXTENSION_WEBVTT)) {
            return 13;
        }
        if (lastPathSegment.endsWith(EXTENSION_JPG) || lastPathSegment.endsWith(EXTENSION_JPEG)) {
            return 14;
        }
        if (lastPathSegment.endsWith(EXTENSION_AVI)) {
            return 16;
        }
        if (lastPathSegment.endsWith(EXTENSION_PNG)) {
            return 17;
        }
        if (lastPathSegment.endsWith(EXTENSION_WEBP)) {
            return 18;
        }
        if (lastPathSegment.endsWith(EXTENSION_BMP) || lastPathSegment.endsWith(EXTENSION_DIB)) {
            return 19;
        }
        if (lastPathSegment.endsWith(EXTENSION_HEIC) || lastPathSegment.endsWith(EXTENSION_HEIF)) {
            return 20;
        }
        return lastPathSegment.endsWith(EXTENSION_AVIF) ? 21 : -1;
    }
}
