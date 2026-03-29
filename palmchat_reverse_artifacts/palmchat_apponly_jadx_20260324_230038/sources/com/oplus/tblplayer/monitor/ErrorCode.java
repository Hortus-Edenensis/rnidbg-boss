package com.oplus.tblplayer.monitor;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ErrorCode {
    public static final int DETAIL_HTTP_CODE_OTHER = 996;
    public static final int DETAIL_HTTP_TIMEOUT = 998;
    public static final int DETAIL_NO_NETWORK = 999;
    public static final int REASON_BINDER_DISCONNECTED = 999998;
    public static final int REASON_BIND_FAILED = 999996;
    public static final int REASON_BIND_TIMEOUT = 999997;
    public static final int REASON_CUSTOM_BASE = 900000000;
    public static final int REASON_DRM = 900000;
    public static final int REASON_DRM_DECRYPTION = 801000;
    public static final int REASON_DRM_KEYS_EXPIRED = 802000;
    public static final int REASON_DS = 1000;
    public static final int REASON_DS_AES_128 = 14000;
    public static final int REASON_DS_AES_CIPHER = 5000;
    public static final int REASON_DS_ASSET = 4000;
    public static final int REASON_DS_BEHIND_LIVE_WINDOW = 18000;
    public static final int REASON_DS_CACHE = 3000;
    public static final int REASON_DS_CONTENT = 16000;
    public static final int REASON_DS_FILE = 6000;
    public static final int REASON_DS_HTTP_CLOSE = 10000;
    public static final int REASON_DS_HTTP_ERROR_CODE = 8000;
    public static final int REASON_DS_HTTP_INVALID_CONTENT = 997;
    public static final int REASON_DS_HTTP_OPEN = 19000;
    public static final int REASON_DS_HTTP_READ = 9000;
    public static final int REASON_DS_OUT_OF_RANGE = 17000;
    public static final int REASON_DS_PRIORITY = 7000;
    public static final int REASON_DS_RAW = 15000;
    public static final int REASON_DS_RTMP = 2000;
    public static final int REASON_DS_SCHEME = 13000;
    public static final int REASON_DS_UDP = 11000;
    public static final int REASON_EXTENSION = 1000000;
    public static final int REASON_EXTENSION_DOWNLOAD_FAILED = 1010000;
    public static final int REASON_EXTENSION_INSTALL_FAILED = 1020000;
    public static final int REASON_EXTRACTOR_UNSUPPORT = 21000;
    public static final int REASON_HLS_NO_HEADER = 22000;
    public static final int REASON_HLS_PLAYLIST_RESET = 24000;
    public static final int REASON_HLS_PLAYLIST_STUCK = 25000;
    public static final int REASON_MS_OTHERS = 800000;
    public static final int REASON_NONE = 0;
    public static final int REASON_OTHERS = 999999;
    public static final int REASON_PARSER = 20000;
    public static final int REASON_RD_AUDIO = 200000;
    public static final int REASON_RD_AUDIO_CONFIG = 214000;
    public static final int REASON_RD_AUDIO_DECODER = 212000;
    public static final int REASON_RD_AUDIO_FF_DECODER = 213000;
    public static final int REASON_RD_AUDIO_INIT = 215000;
    public static final int REASON_RD_AUDIO_MC_INIT = 201000;
    public static final int REASON_RD_AUDIO_MC_QUERY = 202000;
    public static final int REASON_RD_AUDIO_WRITE = 211000;
    public static final int REASON_RD_DANMAKU = 402000;
    public static final int REASON_RD_DANMAKU_DECODER = 403000;
    public static final int REASON_RD_DEFAULT = 100000;
    public static final int REASON_RD_METADATA = 500000;
    public static final int REASON_RD_METADATA_DECODER = 501000;
    public static final int REASON_RD_NONE = 600000;
    public static final int REASON_RD_OTHERS = 700000;
    public static final int REASON_RD_TEXT = 400000;
    public static final int REASON_RD_TEXT_SUBTITLE = 401000;
    public static final int REASON_RD_UNHANDLED_FORMAT = 216000;
    public static final int REASON_RD_VIDEO = 300000;
    public static final int REASON_RD_VIDEO_DECODER = 312000;
    public static final int REASON_RD_VIDEO_FF_DECODER = 313000;
    public static final int REASON_RD_VIDEO_GL_ERROR = 314000;
    public static final int REASON_RD_VIDEO_MC_INIT = 301000;
    public static final int REASON_RD_VIDEO_MC_QUERY = 302000;
    public static final int REASON_RD_VIDEO_OVER_SPEC = 315000;
    public static final int REASON_SS_MISSING_FIELD = 23000;
    public static final int REASON_TEE = 12000;
    public static final int REASON_TIME_OUT = 1100000;
    public static final int REASON_UNEXPECTED_LOADER = 26000;
    public static final int REASON_UNSUPPORT_FORMAT = 27000;
    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_TIMEOUT = 5;
    public static final int TYPE_UNEXPECTED = 2;

    /* JADX INFO: compiled from: SearchBox */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }
}
