package com.oplus.tblplayer.config;

import android.content.Context;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.config.HttpConfig;
import com.oplus.tblplayer.config.LoadControlConfig;
import com.oplus.tblplayer.config.PreCacheConfig;
import com.oplus.tblplayer.config.SDKReportConfig;
import com.oplus.tblplayer.logger.ILoggerAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class GlobalsConfig {
    public final Context appContext;
    public final boolean binauralCaptureVideoEnable;
    public final boolean debug;
    public final boolean detectCodecsCopyrightEnable;
    public final String dynamicLibrariesPath;
    public final boolean enableAssertions;
    public final boolean enableVerifyThread;
    public final HttpConfig httpConfig;
    public final LoadControlConfig loadControlConfig;
    public final List<ILoggerAdapter> logAdapters;
    public final PreCacheConfig preCacheConfig;
    public final boolean remoteEnable;
    public final SDKReportConfig sdkReportConfig;
    public final HashSet<String> verifyThreadIgnoreSet;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private Context context;
        private HashSet<String> verifyThreadIgnoreSet;
        private boolean debug = Globals.DEBUG;
        private boolean enableVerifyThread = Globals.VERIFYTHREAD;
        private boolean remoteEnable = false;
        private boolean detectCodecsCopyrightEnable = true;
        private boolean binauralCaptureVideoEnable = true;
        private boolean enableAssertions = Globals.DEBUG_ASSERTIONS_ENABLED;
        private String mDynamicLibrariesPath = null;
        private List<ILoggerAdapter> logAdapters = new ArrayList();
        private HttpConfig.Builder httpConfigBuilder = new HttpConfig.Builder();
        private PreCacheConfig.Builder preCacheConfigBuilder = new PreCacheConfig.Builder();
        private SDKReportConfig.Builder sdkReportConfigBuilder = new SDKReportConfig.Builder();
        private LoadControlConfig.Builder loadControlConfigBuilder = new LoadControlConfig.Builder();

        public Builder(@NonNull Context context) {
            this.context = context.getApplicationContext();
        }

        public Builder addLoggerAdapter(ILoggerAdapter iLoggerAdapter) {
            this.logAdapters.add(iLoggerAdapter);
            return this;
        }

        public GlobalsConfig build() {
            Assertions.checkNotNull(this.preCacheConfigBuilder);
            Assertions.checkNotNull(this.httpConfigBuilder);
            return new GlobalsConfig(this.context, this.debug, this.logAdapters, this.remoteEnable, this.httpConfigBuilder.build(), this.preCacheConfigBuilder.build(), this.sdkReportConfigBuilder.build(), this.detectCodecsCopyrightEnable, this.binauralCaptureVideoEnable, this.enableVerifyThread, this.verifyThreadIgnoreSet, this.enableAssertions, this.loadControlConfigBuilder.build(), this.mDynamicLibrariesPath);
        }

        public Builder setBinauralCaptureVideoEnable(boolean z) {
            this.binauralCaptureVideoEnable = z;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setDetectCodecsCopyrightEnable(boolean z) {
            this.detectCodecsCopyrightEnable = z;
            return this;
        }

        public Builder setDynamicSoLoadPath(String str) {
            this.mDynamicLibrariesPath = str;
            return this;
        }

        public Builder setEnableAssertions(boolean z) {
            this.enableAssertions = z;
            return this;
        }

        public Builder setEnableVerifyThread(boolean z) {
            this.enableVerifyThread = z;
            return this;
        }

        public Builder setLoadControlEnable(boolean z) {
            this.loadControlConfigBuilder.setLoadControlEnable(z);
            return this;
        }

        public Builder setMaxBufferMs(int i) {
            this.loadControlConfigBuilder.setMaxBufferMs(i);
            return this;
        }

        public Builder setMaxCacheDirSize(long j) {
            this.preCacheConfigBuilder.setMaxCacheDirSize(j);
            return this;
        }

        public Builder setMaxCacheFileSize(long j) {
            this.preCacheConfigBuilder.setMaxCacheFileSize(j);
            return this;
        }

        public Builder setMinBufferMs(int i) {
            this.loadControlConfigBuilder.setMinBufferMs(i);
            return this;
        }

        public Builder setNormalEnabled(boolean z) {
            this.sdkReportConfigBuilder.setNormalEnabled(z);
            return this;
        }

        public Builder setOkhttpCacheControl(CacheControl cacheControl) {
            this.httpConfigBuilder.setOkhttpCacheControl(cacheControl);
            return this;
        }

        public Builder setOkhttpCallFactory(Call.Factory factory) {
            this.httpConfigBuilder.setOkhttpCallFactory(factory);
            return this;
        }

        public Builder setOkhttpClientBuilder(OkHttpClient.Builder builder) {
            this.httpConfigBuilder.setOkhttpClientBuilder(builder);
            return this;
        }

        public Builder setOkhttpEnable(boolean z) {
            this.httpConfigBuilder.setOkhttpEnable(z);
            return this;
        }

        public Builder setPreCacheDir(String str) {
            this.preCacheConfigBuilder.setPreCacheDir(str);
            return this;
        }

        public Builder setPreCacheEnable(boolean z) {
            this.preCacheConfigBuilder.setPreCacheEnable(z);
            return this;
        }

        public Builder setPreferRedirectAddress(boolean z) {
            this.httpConfigBuilder.setPreferRedirectAddress(z);
            return this;
        }

        public Builder setPreferSubrangeRequest(boolean z) {
            this.httpConfigBuilder.setPreferSubrangeRequest(z);
            return this;
        }

        public Builder setRemoteEnable(boolean z) {
            this.remoteEnable = z;
            return this;
        }

        public Builder setStuckEnabled(boolean z) {
            this.sdkReportConfigBuilder.setStuckEnabled(z);
            return this;
        }

        public Builder setUserAgent(String str) {
            this.httpConfigBuilder.setUserAgent(str);
            return this;
        }

        public Builder setVerifyThreadIgnoreSet(HashSet<String> hashSet) {
            this.verifyThreadIgnoreSet = hashSet;
            return this;
        }
    }

    private GlobalsConfig(Context context, boolean z, List<ILoggerAdapter> list, boolean z2, HttpConfig httpConfig, PreCacheConfig preCacheConfig, SDKReportConfig sDKReportConfig, boolean z3, boolean z4, boolean z5, HashSet<String> hashSet, boolean z6, LoadControlConfig loadControlConfig, String str) {
        HashSet<String> hashSet2 = new HashSet<>();
        this.verifyThreadIgnoreSet = hashSet2;
        this.appContext = context;
        this.debug = z;
        this.logAdapters = list;
        this.remoteEnable = z2;
        this.httpConfig = httpConfig;
        this.preCacheConfig = preCacheConfig;
        this.loadControlConfig = loadControlConfig;
        this.sdkReportConfig = sDKReportConfig;
        this.detectCodecsCopyrightEnable = z3;
        this.binauralCaptureVideoEnable = z4;
        this.enableVerifyThread = z5;
        if (hashSet != null) {
            hashSet2.addAll(hashSet);
        }
        this.enableAssertions = z6;
        this.dynamicLibrariesPath = str;
    }
}
