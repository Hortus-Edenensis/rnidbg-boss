package com.oplus.tblplayer.config;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.cache.Cache;
import com.oplus.tbl.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.oplus.tbl.exoplayer2.upstream.cache.SimpleCache;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.PriorityTaskManager;
import com.oplus.tblplayer.config.GlobalsConfig;
import com.oplus.tblplayer.logger.DefaultLoggerAdapter;
import com.oplus.tblplayer.logger.ILoggerAdapter;
import com.oplus.tblplayer.logger.Logger;
import com.oplus.tblplayer.utils.FileUtil;
import com.oplus.tblplayer.utils.LogUtil;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.CacheControl;
import okhttp3.Call;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Globals {
    public static boolean DEBUG = false;
    public static boolean DEBUG_ASSERTIONS_ENABLED = true;
    private static final String TAG = "Globals";
    public static boolean VERIFYTHREAD = false;
    private static GlobalsConfig gGlobalsConfig;
    private static Cache sPreCache;
    private static AtomicBoolean initState = new AtomicBoolean(false);
    private static HashSet<String> verifyThreadIgnoreSet = new HashSet<>();

    private static Cache createPreCache(Context context, @NonNull String str, long j) {
        File directoryByPath = FileUtil.getDirectoryByPath(str);
        if (directoryByPath == null) {
            directoryByPath = FileUtil.getDirectoryByName(context, PreCacheConfig.DEFAULT_PRECACHE_CONTENT_DIRECTORY);
        }
        LogUtil.d(TAG, "createPreCache: " + directoryByPath);
        if (directoryByPath == null) {
            return null;
        }
        if (!SimpleCache.isCacheFolderLocked(directoryByPath)) {
            return new SimpleCache(directoryByPath, new LeastRecentlyUsedCacheEvictor(j));
        }
        LogUtil.e(TAG, "Cache folder is locked. " + directoryByPath);
        return null;
    }

    public static Context getApplicationContext() {
        return getGlobalsConfig().appContext;
    }

    public static String getDynamicLibrariesPath() {
        return getGlobalsConfig().dynamicLibrariesPath;
    }

    public static Cache getGlobalPreCache() {
        if (isPreCacheEnable() && sPreCache == null) {
            synchronized (Globals.class) {
                if (sPreCache == null) {
                    sPreCache = createPreCache(getApplicationContext(), getPreCacheDirPath(), getMaxCacheDirSize());
                }
            }
        }
        return sPreCache;
    }

    public static GlobalsConfig getGlobalsConfig() {
        Assertions.checkState(isInitialized());
        return gGlobalsConfig;
    }

    public static int getMaxBufferMs() {
        return getGlobalsConfig().loadControlConfig.maxBufferMs;
    }

    public static long getMaxCacheDirSize() {
        return getGlobalsConfig().preCacheConfig.maxCacheDirSize;
    }

    public static long getMaxCacheFileSize() {
        return getGlobalsConfig().preCacheConfig.maxCacheFileSize;
    }

    public static int getMinBufferMs() {
        return getGlobalsConfig().loadControlConfig.minBufferMs;
    }

    public static CacheControl getOkhttpCacheControl() {
        return getGlobalsConfig().httpConfig.okhttpCacheControl;
    }

    public static Call.Factory getOkhttpCallFactory() {
        return getGlobalsConfig().httpConfig.okhttpCallFactory;
    }

    public static String getPreCacheDirPath() {
        return getGlobalsConfig().preCacheConfig.preCacheDirPath;
    }

    public static PriorityTaskManager getPriorityTaskManager() {
        return getGlobalsConfig().preCacheConfig.priorityTaskManager;
    }

    public static String getUserAgent() {
        return getGlobalsConfig().httpConfig.userAgent;
    }

    public static boolean isBinauralCaptureVideoEnabled() {
        return getGlobalsConfig().binauralCaptureVideoEnable;
    }

    public static boolean isCustomLoadControlConfigEnable() {
        return getGlobalsConfig().loadControlConfig.loadControlEnable;
    }

    public static boolean isDetectCodecsCopyrightEnabled() {
        return getGlobalsConfig().detectCodecsCopyrightEnable;
    }

    public static boolean isEnableVerifyThread() {
        return getGlobalsConfig().enableVerifyThread;
    }

    public static synchronized boolean isInitialized() {
        return initState.get();
    }

    public static boolean isOkhttpEnable() {
        return getGlobalsConfig().httpConfig.okhttpEnable;
    }

    public static boolean isPreCacheEnable() {
        return getGlobalsConfig().preCacheConfig.preCacheEnable;
    }

    public static boolean isPreferRedirectAddress() {
        return getGlobalsConfig().httpConfig.preferRedirectAddress;
    }

    public static boolean isPreferSubrangeRequest() {
        return getGlobalsConfig().httpConfig.preferSubrangeRequest;
    }

    public static boolean isSdkNormalEnabled() {
        return getGlobalsConfig().sdkReportConfig.normalEnabled;
    }

    public static boolean isSdkStuckEnabled() {
        return getGlobalsConfig().sdkReportConfig.stuckEnabled;
    }

    public static synchronized void maybeInitialize(@NonNull Context context, @Nullable GlobalsConfig globalsConfig) {
        if (initState.get()) {
            return;
        }
        if (gGlobalsConfig == null) {
            if (globalsConfig == null) {
                globalsConfig = new GlobalsConfig.Builder(context).build();
            }
            gGlobalsConfig = globalsConfig;
            DEBUG = globalsConfig.debug;
            DEBUG_ASSERTIONS_ENABLED = globalsConfig.enableAssertions;
            maybeInitializeLogger(globalsConfig);
            printVerifyThreadIgnoreSet();
            initState.set(true);
        }
    }

    private static void maybeInitializeLogger(@NonNull GlobalsConfig globalsConfig) {
        Logger.clearLoggerAdapters();
        List<ILoggerAdapter> list = globalsConfig.logAdapters;
        if (list == null || list.isEmpty()) {
            Logger.addLoggerAdapter(new DefaultLoggerAdapter(globalsConfig.debug ? Integer.MIN_VALUE : 4));
        } else {
            Logger.addLoggerAdapters(globalsConfig.logAdapters);
        }
    }

    private static void printVerifyThreadIgnoreSet() {
        GlobalsConfig globalsConfig = gGlobalsConfig;
        if (globalsConfig == null) {
            return;
        }
        Iterator<String> it = globalsConfig.verifyThreadIgnoreSet.iterator();
        StringBuilder sb = new StringBuilder();
        String str = "verifyThreadIgnoreSet: ";
        while (true) {
            sb.append(str);
            if (!it.hasNext()) {
                LogUtil.d(TAG, sb.toString());
                return;
            } else {
                sb.append(it.next());
                str = ",";
            }
        }
    }

    public static boolean shouldIgnoreVerifyThread(String str) {
        return getGlobalsConfig().verifyThreadIgnoreSet.contains(str);
    }

    public void finalize() throws Throwable {
        super.finalize();
    }
}
