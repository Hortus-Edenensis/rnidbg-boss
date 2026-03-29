package com.oplus.tblplayer.monitor;

import android.opengl.GLException;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.ExoTimeoutException;
import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.audio.AudioSink;
import com.oplus.tbl.exoplayer2.drm.DecryptionException;
import com.oplus.tbl.exoplayer2.drm.KeysExpiredException;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecUtil;
import com.oplus.tbl.exoplayer2.source.BehindLiveWindowException;
import com.oplus.tbl.exoplayer2.source.UnrecognizedInputFormatException;
import com.oplus.tbl.exoplayer2.text.SubtitleDecoderException;
import com.oplus.tbl.exoplayer2.upstream.AssetDataSource;
import com.oplus.tbl.exoplayer2.upstream.ContentDataSource;
import com.oplus.tbl.exoplayer2.upstream.DataSourceException;
import com.oplus.tbl.exoplayer2.upstream.FileDataSource;
import com.oplus.tbl.exoplayer2.upstream.HttpDataSource;
import com.oplus.tbl.exoplayer2.upstream.Loader;
import com.oplus.tbl.exoplayer2.upstream.RawResourceDataSource;
import com.oplus.tbl.exoplayer2.upstream.UdpDataSource;
import com.oplus.tbl.exoplayer2.upstream.cache.Cache;
import com.oplus.tblplayer.ffmpeg.FfmpegDecoderException;
import com.oplus.tblplayer.render.TBLMediaCodecVideoRenderer;
import com.oplus.tblplayer.utils.ReflectUtil;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ErrorCodeProvider implements ErrorCode {
    private static final String BASE_EXOPLAYER_PACKAGE = "com.oplus.tbl.exoplayer2";
    private static final String HLS_PLAYLIST_RESET_EXCEPTION = "com.oplus.tbl.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistResetException";
    private static final String HLS_PLAYLIST_STUCK_EXCEPTION = "com.oplus.tbl.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistStuckException";
    private static final String SS_MISSING_FILED_EXCEPTION = "com.oplus.tbl.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$MissingFieldException";
    private static final String TAG = "ErrorCodeProvider";

    private static int getErrorCode(int i, Throwable th) {
        if (th instanceof Cache.CacheException) {
            return 3000;
        }
        if (th instanceof AssetDataSource.AssetDataSourceException) {
            return 4000;
        }
        if (th instanceof FileDataSource.FileDataSourceException) {
            return 6000;
        }
        if (th instanceof HttpDataSource.HttpDataSourceException) {
            if (th instanceof HttpDataSource.InvalidContentTypeException) {
                return 8997;
            }
            if (th instanceof HttpDataSource.InvalidResponseCodeException) {
                int i2 = ((HttpDataSource.InvalidResponseCodeException) th).responseCode;
                if (i2 < 0 || i2 > 900) {
                    return 8996;
                }
                return i2 + 8000;
            }
            int i3 = ((HttpDataSource.HttpDataSourceException) th).type;
            int i4 = ErrorCode.REASON_DS_HTTP_OPEN;
            if (i3 != 1) {
                if (i3 == 2) {
                    i4 = 9000;
                } else if (i3 == 3) {
                    i4 = 10000;
                }
            }
            return th.getCause() instanceof UnknownHostException ? i4 + 999 : th.getCause() instanceof SocketTimeoutException ? i4 + ErrorCode.DETAIL_HTTP_TIMEOUT : i4;
        }
        if (th instanceof UdpDataSource.UdpDataSourceException) {
            return 11000;
        }
        if (th instanceof RawResourceDataSource.RawResourceDataSourceException) {
            return 15000;
        }
        if (th instanceof ContentDataSource.ContentDataSourceException) {
            return 16000;
        }
        if (th instanceof DataSourceException) {
            return ErrorCode.REASON_DS_OUT_OF_RANGE;
        }
        if (th instanceof BehindLiveWindowException) {
            return ErrorCode.REASON_DS_BEHIND_LIVE_WINDOW;
        }
        if (th instanceof ParserException) {
            if (ReflectUtil.checkIsType(SS_MISSING_FILED_EXCEPTION, th)) {
                return ErrorCode.REASON_SS_MISSING_FIELD;
            }
            if (th instanceof UnrecognizedInputFormatException) {
                return ErrorCode.REASON_EXTRACTOR_UNSUPPORT;
            }
            return 20000;
        }
        if (ReflectUtil.checkIsType(HLS_PLAYLIST_RESET_EXCEPTION, th)) {
            return ErrorCode.REASON_HLS_PLAYLIST_RESET;
        }
        if (ReflectUtil.checkIsType(HLS_PLAYLIST_STUCK_EXCEPTION, th)) {
            return 25000;
        }
        return th instanceof Loader.UnexpectedLoaderException ? ErrorCode.REASON_UNEXPECTED_LOADER : th instanceof AudioSink.WriteException ? ErrorCode.REASON_RD_AUDIO_WRITE : th instanceof AudioSink.ConfigurationException ? ErrorCode.REASON_RD_AUDIO_CONFIG : th instanceof AudioSink.InitializationException ? ErrorCode.REASON_RD_AUDIO_INIT : th instanceof MediaCodecRenderer.DecoderInitializationException ? i == 1 ? ErrorCode.REASON_RD_AUDIO_MC_INIT : i == 2 ? ErrorCode.REASON_RD_VIDEO_MC_INIT : ErrorCode.REASON_OTHERS : th instanceof MediaCodecUtil.DecoderQueryException ? i == 1 ? ErrorCode.REASON_RD_AUDIO_MC_QUERY : i == 2 ? th instanceof TBLMediaCodecVideoRenderer.VideoOverSpecificationException ? ErrorCode.REASON_RD_VIDEO_OVER_SPEC : ErrorCode.REASON_RD_VIDEO_MC_QUERY : ErrorCode.REASON_OTHERS : th instanceof GLException ? ErrorCode.REASON_RD_VIDEO_GL_ERROR : th instanceof SubtitleDecoderException ? ErrorCode.REASON_RD_TEXT_SUBTITLE : th instanceof DecryptionException ? ErrorCode.REASON_DRM_DECRYPTION : th instanceof KeysExpiredException ? ErrorCode.REASON_DRM_KEYS_EXPIRED : th instanceof ExoTimeoutException ? ErrorCode.REASON_TIME_OUT : th instanceof FfmpegDecoderException ? ErrorCode.REASON_RD_VIDEO_FF_DECODER : ErrorCode.REASON_OTHERS;
    }

    public static int parseException(int i, ExoPlaybackException exoPlaybackException) {
        if (exoPlaybackException != null) {
            int i2 = exoPlaybackException.type;
            if (i2 == 0) {
                int errorCode = getErrorCode(7, exoPlaybackException.getCause());
                return errorCode == 999999 ? ErrorCode.REASON_MS_OTHERS : errorCode;
            }
            if (i2 == 1) {
                int errorCode2 = getErrorCode(i, exoPlaybackException.getCause());
                return errorCode2 == 999999 ? toErrorReason(i) : errorCode2;
            }
            if (i2 == 2) {
                return ErrorCode.REASON_OTHERS;
            }
        }
        return 0;
    }

    private static int toErrorReason(int i) {
        if (i == 0) {
            return 100000;
        }
        if (i == 1) {
            return ErrorCode.REASON_RD_AUDIO;
        }
        if (i == 2) {
            return ErrorCode.REASON_RD_VIDEO;
        }
        if (i == 3) {
            return ErrorCode.REASON_RD_TEXT;
        }
        if (i == 5) {
            return ErrorCode.REASON_RD_METADATA;
        }
        if (i != 7) {
            return ErrorCode.REASON_RD_OTHERS;
        }
        return 600000;
    }
}
