package com.oplus.tblplayer;

import android.os.Build;
import com.oplus.tbl.exoplayer2.ExoPlayerLibraryInfo;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface Constants {
    public static final String APPLICATION_BCP1 = "application/bcp1";
    public static final String APPLICATION_BCP2 = "application/bcp2";
    public static final String APPLICATION_BINAURAL = "application/binaural";
    public static final int AUDIO_FRAME_SAMPLE_SIZE = 1024;
    public static final int BCP1_FRAME_TYPE = 0;
    public static final int BCP2_FRAME_TYPE = 1;
    public static final String BCP_VIDEO_CONTAINER_MIME = "mov,mp4,m4a,3gp,3g2,mj2";
    public static final int BINAURAL_CAPTURE_FLAG_1_PASS = 1;
    public static final int BINAURAL_CAPTURE_FLAG_2_PASS = 2;
    public static final String BINAURAL_CAPTURE_TAG_1_PASS = "binaural";
    public static final String BINAURAL_CAPTURE_TAG_2_PASS = "bcap2";
    public static final float CODEC_MAX_OUTPUT_FRAME_RATE_120 = 120.0f;
    public static final float CODEC_MAX_OUTPUT_FRAME_RATE_60 = 60.0f;
    public static final int CODEC_PRIORITY_VALUE = 1;
    public static final int COLOR_INFO_MODE_BT2020 = 2;
    public static final int COLOR_INFO_MODE_BT709 = 0;
    public static final int COLOR_INFO_MODE_DISPLAY_P3 = 1;
    public static final String DECODER_INIT_FAILED = "Failed to initialize decoder.";
    public static final int DEFAULT_AAC_ENCODE_LATENCY_FRAMES = 2;
    public static final String DEFAULT_APPLICATION_NAME = "TBLPlayer";
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;
    public static final int DEFAULT_LOAD_CONTROL_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_LOAD_CONTROL_MIN_BUFFER_MS = 50000;
    public static final int DEFAULT_LOAD_CONTROL_PLAYBACK_MS = 500;
    public static final int DEFAULT_LOAD_CONTROL_REBUFFER_MS = 5000;
    public static final String DEFAULT_TAG = "TBLPlayer";
    public static final int DEFAULT_TBL_INCREASED_TS_SEARCH_BYTES = 451200;
    public static final int DEFAULT_TIMESTAMP_SEARCH_BYTES = 112800;
    public static final String DEFAULT_USER_AGENT = "TBLPlayer/1.7.5002PRO (Linux;Android " + Build.VERSION.RELEASE + ") " + ExoPlayerLibraryInfo.VERSION_SLASHY;
    public static final String DISABLE_VIDEO_CODEC_WCG = "disable-wcg";
    public static final String DOLBY_VISION_CODECS_PROFILE_12 = "dvhe.012";
    public static final String DOLBY_VISION_CODECS_PROFILE_20 = "dvhe.020";
    public static final int EQUALIZER_MODE_BLUE = 3;
    public static final int EQUALIZER_MODE_CLASSIC = 4;
    public static final int EQUALIZER_MODE_COUNTRY = 9;
    public static final int EQUALIZER_MODE_DANCE = 2;
    public static final int EQUALIZER_MODE_DEFAULT = 0;
    public static final int EQUALIZER_MODE_ELECTRIC = 7;
    public static final int EQUALIZER_MODE_JAZZ = 5;
    public static final int EQUALIZER_MODE_POP = 1;
    public static final int EQUALIZER_MODE_ROCK = 8;
    public static final int EQUALIZER_MODE_SLOW_SONG = 6;
    public static final String FFMPEG_EXTRACTOR_FORMAT_LABEL = "FfmpegExtractor";
    public static final int FLAG_HANDLE_BINAURAL_CAPTURE = 1;
    public static final int FLAG_HANDLE_DEFAULT = 0;
    public static final float FLOAT_VALUE_UNSET = -1.0f;
    public static final int INDEX_UNSET = -1;
    public static final int INTEGER_VALUE_UNSET = -1;
    public static final String LANGUAGE_UNDETERMINED = "und";
    public static final String LIBRARY_FFMPEG = "ffmpeg";
    public static final String LIBRARY_FFMPEG_JNI = "ffmpegJNI";
    public static final String LIBRARY_PLATFORM_JNI = "PlatformJNI";
    public static final String LIBRARY_PREFIX = "lib";
    public static final String LIBRARY_SUFFIX = ".so";
    public static final int LOADING_COMPLETED = 2;
    public static final int LOADING_IDLE = 0;
    public static final int LOADING_STARTED = 1;
    public static final long LONG_VALUE_UNSET = -1;
    public static final int MSG_CHANGED_LOAD_CONFIG = 10001;
    public static final int MSG_CONFIG_CODEC = 10008;
    public static final int MSG_CUSTOM_BASE = 10000;
    public static final int MSG_ENABLE_MINIVIEW_MODE = 10004;
    public static final int MSG_HW_DECODER_CHANGE_TO_SW_DECODER = 10006;
    public static final int MSG_SET_BCAP_POST_ENHANCE_STATE = 10005;
    public static final int MSG_SET_STREAMING_MODE = 10002;
    public static final int MSG_SET_VIDEO_CODEC_UX = 10007;
    public static final int MSG_SET_VPP_FILTER_MODE = 10003;
    public static final float NEED_TO_CONFIG_FRAME_RATE = 115.0f;
    public static final int NETWORK_TYPE_2G = 3;
    public static final int NETWORK_TYPE_3G = 4;
    public static final int NETWORK_TYPE_4G = 5;
    public static final int NETWORK_TYPE_CELLULAR_UNKNOWN = 6;
    public static final int NETWORK_TYPE_ETHERNET = 7;
    public static final int NETWORK_TYPE_OFFLINE = 1;
    public static final int NETWORK_TYPE_OTHER = 8;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 2;
    public static final int RENDERER_DECODE_MODE_AUTO = 0;
    public static final int RENDERER_DECODE_MODE_HW = 1;
    public static final int RENDERER_DECODE_MODE_SW = 2;
    public static final int RENDER_NONE = 2;
    public static final int RENDER_SURFACE_VIEW = 0;
    public static final int RENDER_TEXTURE_VIEW = 1;
    public static final String SLOW_MOTION_HSR_HEAD = "slow_motion_hsr_";
    public static final int SOURCE_EXTRACTOR_MODE_ALL = 0;
    public static final int SOURCE_EXTRACTOR_MODE_EXO = 1;
    public static final int SOURCE_EXTRACTOR_MODE_FFMPEG = 2;
    public static final int SOURCE_EXTRACTOR_MODE_FFMPEG_PREFER = 3;
    public static final String STRING_VALUE_UNSET = "?";
    public static final long TIME_END_OF_SOURCE = Long.MIN_VALUE;
    public static final long TIME_UNSET = -9223372036854775807L;
    public static final int TS_PACKET_SIZE = 188;
    public static final int TYPE_ASSET = 6;
    public static final int TYPE_CONTENT = 5;
    public static final int TYPE_DASH = 0;
    public static final int TYPE_HLS = 2;
    public static final int TYPE_HTTP_FLV = 10;
    public static final int TYPE_LOCAL = 4;
    public static final int TYPE_OTHER = 3;
    public static final int TYPE_RAW = 7;
    public static final int TYPE_RTMP = 9;
    public static final int TYPE_SCHEME_DATA = 8;
    public static final int TYPE_SS = 1;
    public static final String UNSUPPORTED_AVC1_BRAND_LABEL = "UnsupportedAvc1Brand";
    public static final String UNSUPPORTED_DOLBY_VISION_PROFILE_LABEL = ",UnsupportedDolbyProfile";
    public static final String URL_OVERRIDE_EXTENSION_DASH = "mpd";
    public static final String URL_OVERRIDE_EXTENSION_HTTP_FLV = "http-flv";
    public static final String URL_OVERRIDE_EXTENSION_HTTP_LIVE_FLV = "http-live-flv";
    public static final String URL_OVERRIDE_EXTENSION_M3U8 = "m3u8";
    public static final int VIDEO_SOFT_RENDER_MODE_OPENGL = 1;
    public static final int VIDEO_SOFT_RENDER_MODE_SURFACE = 0;
    public static final int VIDEO_SOFT_RENDER_MODE_SURFACE_LEGACY = 2;
    public static final int VIDEO_WARNING_BITRATE = 24000000;
    public static final int VIDEO_WARNING_FPS_MAX = 481;
    public static final int VIDEO_WARNING_FPS_MIN = 59;
    public static final int VIDEO_WARNING_RESOLUTION = 2088960;
    public static final int VPP_FILTER_FLAG_OSIE = 2;
    public static final int VPP_FILTER_FLAG_SR = 1;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BcapFlags {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BcpFrameType {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorInfoMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContentType {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface EqualizerMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtractorMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FfmpegExtractorFlags {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadingState {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RenderViewType {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RendererMode {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface VPPFilterFlags {
    }

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoSoftRenderMode {
    }
}
