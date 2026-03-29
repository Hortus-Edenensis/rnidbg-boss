package com.oplus.tblplayer.ffmpeg;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import com.oplus.tbl.exoplayer2.ExoPlayerLibraryInfo;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.util.LibraryLoader;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.utils.LibraryLoaderDynamic;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FfmpegLibrary {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String AUDIO_APE = "audio/ape";
    static final String AUDIO_ATRAC3 = "audio/atrac3";
    static final String AUDIO_COOK = "audio/cook";
    static final String AUDIO_WMA1 = "audio/wmav1";
    static final String AUDIO_WMA2 = "audio/wmav2";
    static final String AUDIO_WMALOSSLESS = "audio/wmalossless";
    static final String AUDIO_WMAPRO = "audio/wmapro";
    private static final LibraryLoader LOADER;
    private static final String MIME_TYPE_PREFIX_APPLICATION = "application/";
    private static final String MIME_TYPE_PREFIX_AUDIO = "audio/";
    private static final String MIME_TYPE_PREFIX_TEXT = "text/";
    private static final String MIME_TYPE_PREFIX_VIDEO = "video/";
    private static final String TAG = "FfmpegLibrary";
    private static final String VIDEO_FLV = "video/flv";
    private static final String VIDEO_MSMPEG4 = "video/msmpeg4";
    private static final String VIDEO_WMV1 = "video/wmv1";
    private static final String VIDEO_WMV2 = "video/wmv2";
    private static final String VIDEO_WMV3 = "video/wmv3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7685a = 0;
    private static final String[] containerWhiteList;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ffmpeg.tbl");
        LOADER = new LibraryLoader(Constants.LIBRARY_FFMPEG, Constants.LIBRARY_FFMPEG_JNI);
        containerWhiteList = new String[]{"aac", "aiff", "amr", "ape", "asf", "flac", "loas", Constants.BCP_VIDEO_CONTAINER_MIME, "mp3", "ogg", t.w, "wav"};
    }

    private FfmpegLibrary() {
    }

    private static boolean containerInWhiteList(String str) {
        if (str == null) {
            return true;
        }
        for (String str2 : containerWhiteList) {
            if (str2.compareTo(str) == 0) {
                return true;
            }
        }
        return false;
    }

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String getCodecName(String str) {
        if (str == null || str.equals("audio/x-unknown") || str.equals("video/x-unknown")) {
            return null;
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    b = 0;
                }
                break;
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    b = 1;
                }
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    b = 2;
                }
                break;
            case -1662382439:
                if (str.equals("video/mpeg")) {
                    b = 3;
                }
                break;
            case -1662095187:
                if (str.equals("video/webm")) {
                    b = 4;
                }
                break;
            case -1662086939:
                if (str.equals(VIDEO_WMV1)) {
                    b = 5;
                }
                break;
            case -1662086938:
                if (str.equals(VIDEO_WMV2)) {
                    b = 6;
                }
                break;
            case -1662086937:
                if (str.equals(VIDEO_WMV3)) {
                    b = 7;
                }
                break;
            case -1662078879:
                if (str.equals("video/wvc1")) {
                    b = 8;
                }
                break;
            case -1606874997:
                if (str.equals("audio/amr-wb")) {
                    b = 9;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    b = 10;
                }
                break;
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    b = 11;
                }
                break;
            case -585720690:
                if (str.equals(AUDIO_WMA2)) {
                    b = 12;
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    b = dn.k;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    b = dn.l;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    b = 15;
                }
                break;
            case 5751993:
                if (str.equals("video/mpeg2")) {
                    b = 16;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    b = 17;
                }
                break;
            case 187078749:
                if (str.equals(AUDIO_APE)) {
                    b = 18;
                }
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    b = 19;
                }
                break;
            case 1326293973:
                if (str.equals(VIDEO_MSMPEG4)) {
                    b = 20;
                }
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    b = 21;
                }
                break;
            case 1331841244:
                if (str.equals(VIDEO_FLV)) {
                    b = 22;
                }
                break;
            case 1331848029:
                if (str.equals("video/mp4")) {
                    b = 23;
                }
                break;
            case 1503095341:
                if (str.equals("audio/3gpp")) {
                    b = 24;
                }
                break;
            case 1504470054:
                if (str.equals("audio/alac")) {
                    b = 25;
                }
                break;
            case 1504532961:
                if (str.equals(AUDIO_COOK)) {
                    b = 26;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    b = 27;
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    b = 28;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    b = 29;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    b = 30;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    b = TELogUtils.DEBUG_LEVEL_V;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    b = 32;
                }
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    b = 33;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    b = 34;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    b = 35;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    b = 36;
                }
                break;
        }
        switch (b) {
            case 0:
            case 27:
                return "eac3";
            case 1:
                return "h263";
            case 2:
                return "hevc";
            case 3:
                return "mpegvideo";
            case 4:
            case 33:
                return "vp8";
            case 5:
                return "wmv1";
            case 6:
                return "wmv2";
            case 7:
                return "wmv3";
            case 8:
                return "vc1";
            case 9:
                return "amrwb";
            case 10:
            case 31:
                return "dca";
            case 11:
                return "vorbis";
            case 12:
                return "wmav2";
            case 13:
            case 29:
                return "mp3";
            case 14:
                return "mp2";
            case 15:
                return "aac";
            case 16:
                return "mpeg2video";
            case 17:
                return "ac3";
            case 18:
                return "ape";
            case 19:
                return "mpeg4";
            case 20:
                return "msmpeg4";
            case 21:
                return "h264";
            case 22:
                return LiveConfigKey.FLV;
            case 23:
                return "h264";
            case 24:
                return "amrnb";
            case 25:
                return "alac";
            case 26:
                return "cook";
            case 28:
                return "flac";
            case 30:
                return "opus";
            case 32:
                return "truehd";
            case 34:
                return "vp9";
            case 35:
                return "pcm_alaw";
            case 36:
                return "pcm_mulaw";
            default:
                return parseFfmpegCodecName(str);
        }
    }

    public static String getVersion() {
        if (isAvailable()) {
            return ffmpegGetVersion();
        }
        return null;
    }

    public static boolean isAvailable() {
        LibraryLoader libraryLoader = LOADER;
        libraryLoader.setLibraryLoadListener(LibraryLoaderDynamic.getLibraryLoaderListener());
        return (LibraryLoaderDynamic.isLibraryFfmpegLoaded() && LibraryLoaderDynamic.isLibraryFfmpegJNILoaded()) || libraryLoader.isAvailable();
    }

    private static String parseFfmpegCodecName(String str) {
        if (str.startsWith(MIME_TYPE_PREFIX_AUDIO)) {
            return str.substring(6);
        }
        if (str.startsWith(MIME_TYPE_PREFIX_VIDEO)) {
            return str.substring(6);
        }
        if (str.startsWith(MIME_TYPE_PREFIX_TEXT)) {
            return str.substring(5);
        }
        return null;
    }

    public static void setLibraries(String... strArr) {
        LOADER.setLibraries(strArr);
    }

    public static boolean supportsFormat(Format format) {
        String codecName;
        return isAvailable() && (codecName = getCodecName(format.sampleMimeType)) != null && ffmpegHasDecoder(codecName);
    }
}
