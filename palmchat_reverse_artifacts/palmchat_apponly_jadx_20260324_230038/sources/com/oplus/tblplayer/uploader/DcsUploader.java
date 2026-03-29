package com.oplus.tblplayer.uploader;

import android.content.Context;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.monitor.sdk.NormalReport;
import com.oplus.tblplayer.monitor.sdk.StuckReport;
import com.oplus.tblplayer.utils.LogUtil;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.wifi.ad.core.config.EventParams;
import defpackage.e54;
import defpackage.s17;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DcsUploader {
    private static final String TAG = "DcsUploader";

    public static void report(Context context, NormalReport normalReport) {
        if (Globals.isSdkNormalEnabled()) {
            Assertions.checkArgument((context == null || normalReport == null) ? false : true);
            s17.g(context, new e54.b().c());
            HashMap map = new HashMap();
            LogUtil.d(TAG, "normalReport:" + normalReport);
            map.put("mediaUrl", normalReport.srcInfo.mediaUrl);
            map.put("containerMimeType", normalReport.srcInfo.containerMimeType);
            map.put("bitrate", String.valueOf(normalReport.srcInfo.bitrate));
            map.put("mediaDuration", String.valueOf(normalReport.srcInfo.mediaDuration));
            map.put("width", String.valueOf(normalReport.srcInfo.width));
            map.put("height", String.valueOf(normalReport.srcInfo.height));
            map.put(SharePluginInfo.ISSUE_FPS, String.valueOf(normalReport.srcInfo.fps));
            map.put("videoBitrate", String.valueOf(normalReport.srcInfo.videoBitrate));
            map.put("videoMimeType", normalReport.srcInfo.videoMimeType);
            map.put("sampleRate", String.valueOf(normalReport.srcInfo.sampleRate));
            map.put("audioBitrate", String.valueOf(normalReport.srcInfo.audioBitrate));
            map.put("audioMimeType", normalReport.srcInfo.audioMimeType);
            map.put("contentType", String.valueOf(normalReport.srcInfo.contentType));
            map.put("isLive", String.valueOf(normalReport.srcInfo.isLive));
            map.put("errorCode", String.valueOf(normalReport.performanceInfo.errorCode));
            map.put("loadTimeMs", String.valueOf(normalReport.performanceInfo.loadTimeMs));
            map.put("aliveDurationMs", String.valueOf(normalReport.performanceInfo.aliveDurationMs));
            map.put("curPositionMs", String.valueOf(normalReport.performanceInfo.curPositionMs));
            map.put("reBufferingCount", String.valueOf(normalReport.performanceInfo.reBufferingCount));
            map.put("reBufferingTimeMs", String.valueOf(normalReport.performanceInfo.reBufferingTimeMs));
            map.put("videoFLR", String.valueOf(normalReport.performanceInfo.videoFLR));
            map.put("decoderMode", String.valueOf(normalReport.performanceInfo.decoderMode));
            map.put(EventParams.KEY_PARAM_NETTYPE, normalReport.netInfo.netType);
            map.put("downloadSpeed", String.valueOf(normalReport.netInfo.downloadSpeed));
            map.put("wifiRssi", String.valueOf(normalReport.netInfo.wifiRssi));
            map.put("lteSignal", String.valueOf(normalReport.netInfo.lteSignal));
            map.put("supportPreCache", String.valueOf(normalReport.netInfo.supportPreCache));
            map.put("maxCacheFileSize", String.valueOf(normalReport.netInfo.maxCacheFileSize));
            map.put("maxCacheDirSize", String.valueOf(normalReport.netInfo.maxCacheDirSize));
            map.put("alreadyPreCachedBytes", String.valueOf(normalReport.netInfo.alreadyPreCachedBytes));
            map.put("totalCachedBytes", String.valueOf(normalReport.netInfo.totalCachedBytes));
            map.put("totalBytesTransferred", String.valueOf(normalReport.netInfo.totalBytesTransferred));
            map.put("totalBufferedDurationMs", String.valueOf(normalReport.netInfo.totalBufferedDurationMs));
            s17.j(context, "106000", "tblplayer_sdk", "normal_report", map);
        }
    }

    public static void report(Context context, StuckReport stuckReport) {
        if (Globals.isSdkStuckEnabled()) {
            Assertions.checkArgument((context == null || stuckReport == null) ? false : true);
            s17.g(context, new e54.b().c());
            HashMap map = new HashMap();
            LogUtil.d(TAG, "stuckReport:" + stuckReport);
            map.put("mediaUrl", stuckReport.srcInfo.mediaUrl);
            map.put("containerMimeType", stuckReport.srcInfo.containerMimeType);
            map.put("bitrate", String.valueOf(stuckReport.srcInfo.bitrate));
            map.put("mediaDuration", String.valueOf(stuckReport.srcInfo.mediaDuration));
            map.put("width", String.valueOf(stuckReport.srcInfo.width));
            map.put("height", String.valueOf(stuckReport.srcInfo.height));
            map.put(SharePluginInfo.ISSUE_FPS, String.valueOf(stuckReport.srcInfo.fps));
            map.put("videoBitrate", String.valueOf(stuckReport.srcInfo.videoBitrate));
            map.put("videoMimeType", stuckReport.srcInfo.videoMimeType);
            map.put("sampleRate", String.valueOf(stuckReport.srcInfo.sampleRate));
            map.put("audioBitrate", String.valueOf(stuckReport.srcInfo.audioBitrate));
            map.put("audioMimeType", stuckReport.srcInfo.audioMimeType);
            map.put("contentType", String.valueOf(stuckReport.srcInfo.contentType));
            map.put("isLive", String.valueOf(stuckReport.srcInfo.isLive));
            map.put(EventParams.KEY_PARAM_NETTYPE, stuckReport.netInfo.netType);
            map.put("downloadSpeed", String.valueOf(stuckReport.netInfo.downloadSpeed));
            map.put("wifiRssi", String.valueOf(stuckReport.netInfo.wifiRssi));
            map.put("lteSignal", String.valueOf(stuckReport.netInfo.lteSignal));
            map.put("supportPreCache", String.valueOf(stuckReport.netInfo.supportPreCache));
            map.put("maxCacheFileSize", String.valueOf(stuckReport.netInfo.maxCacheFileSize));
            map.put("maxCacheDirSize", String.valueOf(stuckReport.netInfo.maxCacheDirSize));
            map.put("alreadyPreCachedBytes", String.valueOf(stuckReport.netInfo.alreadyPreCachedBytes));
            map.put("totalCachedBytes", String.valueOf(stuckReport.netInfo.totalCachedBytes));
            map.put("totalBufferedDurationMs", String.valueOf(stuckReport.netInfo.totalBufferedDurationMs));
            map.put("totalBytesTransferred", String.valueOf(stuckReport.netInfo.totalBytesTransferred));
            map.put("reBufferCount", String.valueOf(stuckReport.netInfo.reBufferCount));
            map.put("reBufferTimeMs", String.valueOf(stuckReport.netInfo.reBufferTimeMs));
            map.put("videoInputFps", String.valueOf(stuckReport.baseInfo.videoInputFps));
            map.put("videoOutputFps", String.valueOf(stuckReport.baseInfo.videoOutputFps));
            map.put("videoRenderFps", String.valueOf(stuckReport.baseInfo.videoRenderFps));
            map.put("appCpuRatio", String.valueOf(stuckReport.baseInfo.appCpuRatio));
            map.put("totalCpuRatio", String.valueOf(stuckReport.baseInfo.totalCpuRatio));
            map.put("temperature", String.valueOf(stuckReport.baseInfo.temperature));
            map.put("memoryUsage", String.valueOf(stuckReport.baseInfo.memoryUsage));
            map.put("decoderMode", String.valueOf(stuckReport.baseInfo.decoderMode));
            map.put("stuckType", String.valueOf(stuckReport.baseInfo.stuckType));
            map.put("stuckCode", String.valueOf(stuckReport.baseInfo.stuckCode));
            map.put("stuckTimeMs", String.valueOf(stuckReport.baseInfo.stuckTimeMs));
            map.put("stuckDurationMs", String.valueOf(stuckReport.baseInfo.stuckDurationMs));
            s17.j(context, "106000", "tblplayer_sdk", "stuck_report", map);
        }
    }
}
