package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mapapi.http.HttpClient;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.log.LiveLoggerService;
import com.bykv.vk.component.ttvideo.log.LogBundle;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener;
import com.bykv.vk.component.ttvideo.medialoader.MediaLoaderWrapper;
import com.bykv.vk.component.ttvideo.model.LiveInfoSource;
import com.bykv.vk.component.ttvideo.model.LiveStreamInfo;
import com.bykv.vk.component.ttvideo.model.LiveURL;
import com.bykv.vk.component.ttvideo.network.DnsHelper;
import com.bykv.vk.component.ttvideo.network.LiveDataFetcher;
import com.bykv.vk.component.ttvideo.player.Keep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.TTPlayerConfiger;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.playerwrapper.PlayerSetting;
import com.bykv.vk.component.ttvideo.retry.RetryProcessor;
import com.bykv.vk.component.ttvideo.utils.LiveThreadPool;
import com.bykv.vk.component.ttvideo.utils.LiveUtils;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.jk.b.fx;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.api.plugin.nr;
import com.bytedance.sdk.openadsdk.gi.iz;
import com.google.android.material.timepicker.TimeModel;
import com.huawei.hms.ads.ex;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.x;
import com.lantern.auth.app.FunDC;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ttvecamera.TECameraUtils;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Keep
public final class VideoLiveManager implements ILivePlayer {
    private static final int AUDIOSTREAM = 1;
    private static final int AV_NO_SYNC_THRESHOLD = 10000;
    private static final int BITRATE_ABNORNAL = 1;
    private static final int BITRATE_NORMAL = 0;
    private static final int BOTHSTREAM = 2;
    private static final int CHECK_SEI_INTERVAL = 3000;
    private static final int DEFAULT_RTC_FALLBACK_THRESHOLD = 5000;
    private static final int DEFAULT_RTC_MIN_JITTER_BUFFER = 300;
    private static final String HTTP_FLV_ABR_PREFIX = "mem://llash/";
    private static final int INIT_MTU = 1200;
    public static final int KeyIsGetSeiDelay = 100;
    public static final int KeyIsGetStreamMaxBitrate = 0;
    private static final int LIVE_ABR_CHECK_DEFAULT_INTERVAL = 1000;
    private static final int MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE = 501;
    private static final int MSG_SEI_CHECK = 110;
    private static final int NOTIFY_ALL_SEI_THRESHOLD = 1000;
    private static final String RTC_LOG_PREFIX = "rtc_log_level";
    private static final int RTC_VENDER_TYPE_ALIBABA = 1;
    private static final int RTC_VENDER_TYPE_BYTE = 0;
    private static final int RTC_VENDER_TYPE_OTHERS = 3;
    private static final int RTC_VENDER_TYPE_TECENT = 2;
    private static final String SEI_PREFIX = "JSON";
    private static final int STALL_RECOVER_FROM_BUFFERINGEND = 1;
    private static final int STALL_RECOVER_FROM_RETRY = 2;
    private static final int STALl_NO_RECOVER = 0;
    private static final String TAG = "VideoLiveManager";
    public static final int TEX_LIVE = 1;
    public static final int TEX_VOD = 0;
    private static final int VIDEOSTREAM = 0;
    private static int mAudioRenderStallThreshold = 200;
    private static int mDecoderStallThreshold = 600;
    private static int mDemuxerStallThreshold = 900;
    private static int mFastOpenDuration = -1;
    private static boolean mIsSettingsUpdate = false;
    private static JSONObject mSettingsInfo = null;
    private static int mVideoRenderStallThreshold = 500;
    private int mABRBufferThreshold;
    private int mABRDisableAlgorithm;
    private int mABRMethod;
    private long mALogWriteAddr;
    private int mAVNoSyncThreshold;
    private int mAVPHAudioMaxDuration;
    private int mAVPHAudioProbesize;
    private int mAVPHAutoExit;
    private int mAVPHDnsParseEnable;
    private int mAVPHDnsTimeout;
    private int mAVPHEnableAutoReopen;
    private int mAVPHMaxAVDiff;
    private int mAVPHOpenVideoFirst;
    private int mAVPHReadErrorExit;
    private int mAVPHReadRetryCount;
    private int mAVPHVideoDiffThreshold;
    private int mAVPHVideoMaxDuration;
    private int mAVPHVideoProbesize;
    private String mAbrStrategy;
    private long mAudioLastRenderTime;
    private String mAudioOnly;
    private int mAudioTimescaleEnable;
    private float mAudioVolumeBalancePredelay;
    private float mAudioVolumeBalancePregain;
    private float mAudioVolumeBalanceRatio;
    private float mAudioVolumeBalanceThreshold;
    private int mBufferDataSeconds;
    private int mBufferTimeout;
    private int mByteVC1DecoderType;
    private int mCacheFileEnable;
    private String mCacheFileKey;
    private String mCacheFilePath;
    private boolean mCancelSDKDNSFailRetry;
    private float mCatchSpeed;
    private String mCdnAbrResolution;
    private String mCdnSessionPath;
    private int mCheckBufferingEndAdvanceEnable;
    private int mCheckBufferingEndIgnoreVideo;
    public boolean mCheckSupportSR;
    private boolean mCmafEnable;
    private final Context mContext;
    private String mCurrentIP;
    private String mCurrentPlayURL;
    private int mCurrentRetryCount;
    private int mDefaultCodecId;
    private int mDefaultResBitrate;
    private final DnsHelper mDnsParser;
    private int mEnableAbrStallDegradeImmediately;
    private int mEnableAudioVolumeBalance;
    private String mEnableAvLines;
    private int mEnableByteVC1HardwareDecode;
    private int mEnableCacheSei;
    private int mEnableCheckDropAudio;
    private int mEnableCheckFrame;
    private int mEnableCheckPacketCorrupt;
    private int mEnableCheckSEI;
    private int mEnableClosePlayRetry;
    private int mEnableCmafFastMode;
    private int mEnableCmafOptimizeRetry;
    private int mEnableDTSCheck;
    private int mEnableDecodeMultiSei;
    private int mEnableDecodeSeiOnce;
    private int mEnableDecoderStall;
    private int mEnableDemuxerStall;
    private boolean mEnableDns;
    private boolean mEnableDnsOptimizer;
    private int mEnableDroppingDTSRollFrame;
    private int mEnableFastOpenStream;
    private int mEnableFlvABR;
    private int mEnableFreeFlow;
    private int mEnableH264HardwareDecode;
    private int mEnableHttpPrepare;
    private int mEnableHttpkDegrade;
    private int mEnableHurryFlag;
    private int mEnableLLASHFastOpen;
    private int mEnableLiveAbrCheckEnhance;
    private int mEnableLiveIOP2P;
    private int mEnableLiveIOPlay;
    private int mEnableLowLatencyFLV;
    private int mEnableMediaCodecASYNCInit;
    private int mEnableNTP;
    private int mEnableNTPTask;
    private int mEnableNotifySeiImmediatelyBeforeFirstFrame;
    private int mEnableOpenLiveIO;
    private int mEnableOpenMDL;
    private int mEnableOptimizeBackup;
    private boolean mEnableOriginResolution;
    private int mEnableP2pUp;
    private int mEnablePreventDTSBack;
    private boolean mEnableQuicCertVerify;
    private int mEnableQuicDegrade;
    private int mEnableQuicMTUDiscovery;
    public int mEnableRadioLiveDisableRender;
    private int mEnableRenderStall;
    private int mEnableReportSessionStop;
    private boolean mEnableResolutionAutoDegrade;
    private int mEnableRtcPlay;
    private boolean mEnableSaveSCFG;
    private boolean mEnableSeiCheck;
    private int mEnableSharp;
    public int mEnableSharpen;
    private int mEnableSkipFindUnnecessaryStream;
    private int mEnableSkipFlvNullTag;
    private int mEnableSplitStream;
    private int mEnableStallCounter;
    private int mEnableStallRetryInstantly;
    private boolean mEnableSwitchMainAndBackupUrl;
    private int mEnableTcpFastOpen;
    private int mEnableTextureRender;
    private int mEnableTextureSR;
    private int mEnableUploadSei;
    private boolean mEnableUploadSessionSeries;
    private int mEnableUseLiveThreadPool;
    private int mEnableVideoMpdRefresh;
    private int mEnhancementType;
    private boolean mEnterStallRetryInstantly;
    private ExecutorService mExecutor;
    private LiveDataFetcher mFetcher;
    private int mForceDecodeMsGaps;
    private int mForceDecodeSwitch;
    private boolean mForceHttpDns;
    private int mForceRenderMsGaps;
    private long mFrameDroppingDTSMaxDiff;
    private Object mFrameMetaDataListener;
    private long mFrameTerminatedDTS;
    private int mFramesDrop;
    private long mGetSeiCurrentTime;
    private int mGopDuration;
    private int mHardwareDecodeEnable;
    private int mHardwareRTCDecodeEnable;
    private boolean mHasAbrInfo;
    private boolean mHasRetry;
    private boolean mHasSeiInfo;
    private int mHlsLiveStartIndex;
    private String mHttpDNSServerHost;
    private int mHurryTime;
    private int mHurryType;
    private MyInvocationHandler mInvocationHandler;
    private int mIsAlwaysDoAVSync;
    private boolean mIsCacheHasComplete;
    private int mIsInMainLooper;
    private boolean mIsLiveIOProtoRegister;
    private boolean mIsLocalURL;
    private boolean mIsMdlProtoRegister;
    private boolean mIsPlayWithLiveIO;
    private boolean mIsPlayWithMdl;
    private boolean mIsRequestCanceled;
    private boolean mIsRetrying;
    private boolean mIsStalling;
    private long mLatestAudioPacketDTS;
    private int mLayoutType;
    private String mLevel;
    private final ILiveListener mListener;
    private int mLiveABRCheckInterval;
    private int mLiveIOABGroupID;
    private LivePlayerState mLivePlayerState;
    private String mLocalURL;
    private LiveLoggerService mLogService;
    private boolean mLooping;
    private JSONObject mLowLatencyFLVStrategy;
    private int mMaxCacheSeconds;
    private int mMaxFileCacheSize;
    private int mMaxTextureHeight;
    private int mMaxTextureWidth;
    public boolean mMediaSupportSR;
    private boolean mMediaSupportSharpen;
    private String mMoudleIDToB;
    private final Handler mMyHandler;
    private final INetworkClient mNetworkClient;
    private int mNetworkTimeout;
    private int mNoSyncReportMinDuration;
    private int mNoSyncReportReportThres;
    private List<String> mNodeOptimizeResults;
    private int mOpenCheckSideData;
    private MediaPlayer mPlayer;
    private int mPlayerCache;
    private int mPlayerDegradeMode;
    private final PlayerSetting mPlayerSetting;
    private final int mPlayerType;
    private PlayerState mPrepareState;
    private int mQuicConfigOptimize;
    private boolean mQuicEnable;
    private int mQuicFixProcessTimer;
    private int mQuicFixStreamFinAndRst;
    private int mQuicFixWillingAndAbleToWrite;
    private int mQuicInitMTU;
    private int mQuicInitRtt;
    private int mQuicMaxAckDelay;
    private int mQuicMaxCryptoRetransmissionTimeMs;
    private int mQuicMaxCryptoRetransmissions;
    private int mQuicMaxRetransmissionTimeMs;
    private int mQuicMaxRetransmissions;
    private int mQuicMinReceivedBeforeAckDecimation;
    private int mQuicPadHello;
    private boolean mQuicPull;
    private int mQuicReadBlockMode;
    private int mQuicReadBlockTimeout;
    private int mQuicTimerVersion;
    private int mQuicVersion;
    private boolean mRedoDns;
    private String mReliable;
    public boolean mRenderStartEntered;
    public long mRenderStartNotifyTimeStamp;
    private int mRenderType;
    private String mResolution;
    private boolean mResolutionDisableSR;
    private int mResolutionIndex;
    private final RetryProcessor mRetryProcessor;
    private long mRetryStartTime;
    private int mRtcEarlyInitRender;
    private int mRtcEnableDtls;
    private int mRtcEnableRtcUninitLockFree;
    private int mRtcEnableSDKDns;
    private int mRtcFallbackThreshold;
    private int mRtcMaxJitterBuffer;
    private int mRtcMaxRetryCount;
    private int mRtcMinJitterBuffer;
    private int mRtcPlayFallBack;
    private int mRtcPlayLogInterval;
    private int mRtcSupportMiniSdp;
    private int mScaleType;
    private long mSeiDiffThres;
    private String mSessionId;
    private int mSessionNum;
    private int mSessionReceiveWindow;
    private long mSessionRenderStartTime;
    private long mSessionStartTime;
    private final ILiveSettingBundle mSettingsBundle;
    private float mSharpenAmount;
    private float mSharpenEdgeWeightGamma;
    private int mSharpenMaxHeight;
    private int mSharpenMaxWidth;
    private int mSharpenMode;
    private float mSharpenOverRatio;
    private int mSharpenPowerLevel;
    private int mSharpenSceneMode;
    private JSONObject mSharpenSdkParams;
    private boolean mShowedFirstFrame;
    private float mSlowPlaySpeed;
    private int mSlowPlayTime;
    private int mStallCount;
    private int mStallCountThresOfResolutionDegrade;
    private Handler mStallCounterHandler;
    private int mStallCounterInterval;
    private volatile boolean mStallCounterIsRunning;
    private final Object mStallCounterLock;
    private HandlerThread mStallCounterThread;
    public long mStallRetryTimeIntervalManager;
    private long mStallStartTime;
    private long mStallTotalTime;
    private int mStartDirectAfterPrepared;
    private long mStartPlayBufferThres;
    private String mStreamFormat;
    private int mStreamReceiveWindow;
    private String mSuggestProtocol;
    private boolean mSupportBackupIp;
    public int mSupportSRScene;
    private int mSupportSharpenScene;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private int mSwitchToB;
    private long mTargetOriginBitRate;
    private int mTestAction;
    private String mTextureRenderErrorMsg;
    private boolean mTextureRenderFirstFrame;
    private String mTextureSRBinPath;
    private String mTextureSRDspModuleName;
    public int mTextureSRMode;
    private String mTextureSROclModuleName;
    private String mTransportProtocol;
    private int mTslMinTimeShit;
    private int mTslTimeShift;
    private int mURLAbility;
    private String mURLHost;
    private String mURLProtocol;
    private final LiveInfoSource mURLSource;
    private int mUrlSettingMethod;
    private int mUseExternalDir;
    private boolean mUsePlayerRenderStart;
    private boolean mUserSwitchResoultion;
    private String mUuid;
    private long mVideoLastRenderTime;
    private String mVideoOnly;
    private final VideoStallCountTask mVideoStallCountTask;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static final class Builder {
        final Context mContext;
        boolean mEnableResolutionAutoDegrade;
        boolean mEnableSwitchMainAndBackupUrl;
        boolean mForceHttpDns;
        boolean mForceTTNetHttpDns;
        ILiveListener mListener;
        public ExecutorService mLiveThreadPool;
        INetworkClient mNetworkClient;
        int mPlayerType;
        String mProjectKey;
        public long mRTCUploadLogInterval;
        String mResolution;
        int mRetryTimeout;
        public long mSeiCheckTimeOut;
        ILiveSettingBundle mSettingsBundle;
        public long mStallRetryTimeInterval;
        public long mUploadLogInterval;
        String mVideoFormat;

        public VideoLiveManager build() {
            if (this.mContext == null) {
                throw new IllegalArgumentException("mContext should not be null");
            }
            if (this.mListener == null) {
                throw new IllegalArgumentException("mListener should not be null");
            }
            if (this.mNetworkClient != null) {
                return new VideoLiveManager(this);
            }
            throw new IllegalArgumentException("mNetworkClient should not be null");
        }

        public Builder setCustomThreadPool(ExecutorService executorService) {
            this.mLiveThreadPool = executorService;
            return this;
        }

        public Builder setEnableResolutionAutoDegrade(boolean z) {
            this.mEnableResolutionAutoDegrade = z;
            return this;
        }

        public Builder setEnableSwitchMainAndBackUpURL(boolean z) {
            this.mEnableSwitchMainAndBackupUrl = z;
            return this;
        }

        public Builder setForceHttpDns(boolean z) {
            this.mForceHttpDns = z;
            return this;
        }

        public Builder setForceTTNetHttpDns(boolean z) {
            this.mForceTTNetHttpDns = z;
            return this;
        }

        public Builder setListener(ILiveListener iLiveListener) {
            this.mListener = iLiveListener;
            return this;
        }

        public Builder setNetworkClient(INetworkClient iNetworkClient) {
            this.mNetworkClient = iNetworkClient;
            return this;
        }

        public Builder setPlayerType(int i) {
            this.mPlayerType = i;
            return this;
        }

        public Builder setProjectKey(String str) {
            this.mProjectKey = str;
            return this;
        }

        public Builder setResolution(String str) {
            this.mResolution = str;
            return this;
        }

        public Builder setRetryTimeout(int i) {
            this.mRetryTimeout = i;
            return this;
        }

        public Builder setSeiCheckTimeOut(long j) {
            this.mSeiCheckTimeOut = j;
            return this;
        }

        public Builder setSettingsBundle(ILiveSettingBundle iLiveSettingBundle) {
            this.mSettingsBundle = iLiveSettingBundle;
            return this;
        }

        public Builder setStallRetryInterval(long j) {
            this.mStallRetryTimeInterval = j;
            return this;
        }

        public Builder setVideoFormat(String str) {
            this.mVideoFormat = str;
            return this;
        }

        private Builder(Context context) {
            this.mForceHttpDns = false;
            this.mForceTTNetHttpDns = false;
            this.mRetryTimeout = 60000;
            this.mPlayerType = 1;
            this.mResolution = "origin";
            this.mVideoFormat = LiveConfigKey.FLV;
            this.mEnableResolutionAutoDegrade = false;
            this.mEnableSwitchMainAndBackupUrl = true;
            this.mStallRetryTimeInterval = 10000L;
            this.mUploadLogInterval = 60000L;
            this.mRTCUploadLogInterval = 5000L;
            this.mSeiCheckTimeOut = 8000L;
            this.mLiveThreadPool = null;
            this.mContext = context;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LivePlayerState {
        IDLE,
        PLAYED,
        PAUSED,
        STOPPED
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MyCompletionListener implements MediaPlayer.OnCompletionListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyCompletionListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mListener.onCompletion();
            videoLiveManager.mLogService.onPrepare(LiveError.STREAM_DRYUP);
            videoLiveManager.mSupportBackupIp = false;
            if (videoLiveManager.mIsLocalURL) {
                return;
            }
            if (videoLiveManager.mEnableSwitchMainAndBackupUrl && videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.switchMainAndBackupUrl(LiveError.STREAM_DRYUP)) {
                return;
            }
            if (videoLiveManager.mURLSource.getSourceType() == 1 && videoLiveManager.bytevc1DegradeH264(LiveError.STREAM_DRYUP)) {
                return;
            }
            if (videoLiveManager.mCacheFileEnable != 1) {
                videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.STREAM_DRYUP, "live stream dry up, push stream may occur error", new HashMap()), videoLiveManager.mShowedFirstFrame);
                return;
            }
            videoLiveManager.mListener.onCacheFileCompletion();
            videoLiveManager.mIsCacheHasComplete = true;
            if (!videoLiveManager.mLooping || TextUtils.isEmpty(videoLiveManager.mCacheFilePath)) {
                return;
            }
            videoLiveManager.setLocalURL(videoLiveManager.mCacheFilePath);
            videoLiveManager.setLooping(true);
            videoLiveManager.parsePlayDNS(videoLiveManager.mCacheFilePath);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MyErrorListener implements MediaPlayer.OnErrorListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyErrorListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            MyLog.e(VideoLiveManager.TAG, "onError ".concat(String.valueOf(i)));
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager != null && videoLiveManager.mPlayer != null) {
                if (i != 0) {
                    videoLiveManager.mLogService.onPrepare(i);
                }
                videoLiveManager.mListener.onError(new LiveError(i, "player on error", null));
                if (videoLiveManager.mIsLocalURL) {
                    return true;
                }
                if (videoLiveManager.mEnableQuicDegrade == 1 && videoLiveManager.QuicDegrade(i)) {
                    return true;
                }
                if (videoLiveManager.mEnableHttpkDegrade == 1 && videoLiveManager.HttpKDegradeHttp(i)) {
                    return true;
                }
                if (!(videoLiveManager.mEnableRtcPlay == 1 && videoLiveManager.mRtcPlayFallBack == 0) && videoLiveManager.mEnableSwitchMainAndBackupUrl && videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.switchMainAndBackupUrl(i)) {
                    return true;
                }
                if (videoLiveManager.mURLSource.getSourceType() == 1 && videoLiveManager.bytevc1DegradeH264(i)) {
                    return true;
                }
                HashMap map = new HashMap();
                map.put("internalCode", Integer.valueOf(i));
                map.put("internalExtra", Integer.valueOf(i2));
                map.put("playerType", Integer.valueOf(mediaPlayer.getPlayerType()));
                videoLiveManager.mRetryProcessor.onError(new LiveError(-100003, "player on error", map), videoLiveManager.mShowedFirstFrame);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MyFetcherCompletionListener implements LiveDataFetcher.OnCompletionListener {
        private final String mLiveInfoAPI;
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyFetcherCompletionListener(VideoLiveManager videoLiveManager, String str) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
            this.mLiveInfoAPI = str;
        }

        @Override // com.bykv.vk.component.ttvideo.network.LiveDataFetcher.OnCompletionListener
        public void onCompletion(final LiveStreamInfo liveStreamInfo) {
            final VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.MyFetcherCompletionListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (videoLiveManager.mPlayer == null || videoLiveManager.mRetryProcessor == null) {
                        return;
                    }
                    if (liveStreamInfo == null) {
                        HashMap map = new HashMap();
                        map.put("liveAPI", MyFetcherCompletionListener.this.mLiveInfoAPI);
                        videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.LIVE_DATA_EMPTY, "live data is null", map), videoLiveManager.mShowedFirstFrame);
                        return;
                    }
                    videoLiveManager.mURLSource.setStreamInfo(liveStreamInfo);
                    String playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
                    if (playURLForResolution != null) {
                        videoLiveManager.parsePlayDNS(playURLForResolution);
                        return;
                    }
                    HashMap map2 = new HashMap();
                    map2.put("liveAPI", MyFetcherCompletionListener.this.mLiveInfoAPI);
                    videoLiveManager.mRetryProcessor.onError(new LiveError(LiveError.LIVE_DATA_EMPTY, "play url is null", map2), videoLiveManager.mShowedFirstFrame);
                }
            });
        }

        @Override // com.bykv.vk.component.ttvideo.network.LiveDataFetcher.OnCompletionListener
        public void onError(final LiveError liveError) {
            final VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.MyFetcherCompletionListener.2
                @Override // java.lang.Runnable
                public void run() {
                    if (videoLiveManager.mPlayer == null || videoLiveManager.mRetryProcessor == null) {
                        return;
                    }
                    videoLiveManager.mRetryProcessor.onError(liveError, videoLiveManager.mShowedFirstFrame);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MyInfoListener implements MediaPlayer.OnInfoListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyInfoListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        
            if (r3.mPlayer.getIntOption(62, -1) == 0) goto L120;
         */
        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnInfoListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            boolean z;
            String string;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return false;
            }
            if (i == -268435437) {
                videoLiveManager.mLogService.onPtsBack(i2, false);
                return false;
            }
            if (i != 3) {
                if (i == 251658247) {
                    videoLiveManager.mLogService.mSpeedSwitchCount++;
                    StringBuilder sb = new StringBuilder();
                    LiveLoggerService liveLoggerService = videoLiveManager.mLogService;
                    sb.append(liveLoggerService.mSpeedSwitchInfo);
                    sb.append(",");
                    sb.append(((double) i2) / 1000.0d);
                    sb.append(":");
                    sb.append(System.currentTimeMillis());
                    liveLoggerService.mSpeedSwitchInfo = sb.toString();
                } else if (i == 701) {
                    VideoLiveManager.access$4408(videoLiveManager);
                    videoLiveManager.getLastRenderTime();
                    videoLiveManager.mIsStalling = true;
                    videoLiveManager.mListener.onStallStart();
                    if (videoLiveManager.mShowedFirstFrame) {
                        videoLiveManager.mLogService.onStallStart(i2, true);
                        if (videoLiveManager.mIsPlayWithMdl) {
                            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(AVMDLDataLoader.KeyIsPlayInfoBufferingStart, videoLiveManager.mLogService.mSessionId, i2);
                        }
                    } else {
                        videoLiveManager.mStallStartTime = System.currentTimeMillis();
                        videoLiveManager.mLogService.onStallStart(i2, false);
                    }
                    if ((!videoLiveManager.mEnableResolutionAutoDegrade || videoLiveManager.mURLSource.getSourceType() != 2 || (!videoLiveManager.mAbrStrategy.equals(LiveConfigKey.RAD) || videoLiveManager.mStallCount < videoLiveManager.mStallCountThresOfResolutionDegrade ? !videoLiveManager.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || !videoLiveManager.mResolution.equals("auto") || videoLiveManager.mEnableAbrStallDegradeImmediately != 1 || !videoLiveManager.abrDegradeResolution() : !videoLiveManager.degradeResolution())) && !videoLiveManager.mIsLocalURL) {
                        if (videoLiveManager.mEnableStallRetryInstantly == 1 && videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, -1L) == 0 && videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, -1L) == 0) {
                            videoLiveManager.mEnterStallRetryInstantly = true;
                        }
                        videoLiveManager.mRetryProcessor.onStall(true, videoLiveManager.mEnterStallRetryInstantly);
                    }
                } else {
                    if (i != 702) {
                        switch (i) {
                            case MediaPlayer.MEDIA_INFO_VIDEO_DEMUX_STALL /* -268435442 */:
                                videoLiveManager.mLogService.onDemuxerStall(i2, VideoLiveManager.mDemuxerStallThreshold, true);
                                break;
                            case MediaPlayer.MEDIA_INFO_AUDIO_DEMUX_STALL /* -268435441 */:
                                videoLiveManager.mLogService.onDemuxerStall(i2, VideoLiveManager.mDemuxerStallThreshold, false);
                                break;
                            case MediaPlayer.MEDIA_INFO_VIDEO_DECODE_STALL /* -268435440 */:
                                videoLiveManager.mLogService.onDecoderStall(i2, VideoLiveManager.mDecoderStallThreshold, true);
                                break;
                            case MediaPlayer.MEDIA_INFO_AUDIO_DECODE_STALL /* -268435439 */:
                                videoLiveManager.mLogService.onDecoderStall(i2, VideoLiveManager.mDecoderStallThreshold, false);
                                break;
                            default:
                                switch (i) {
                                    case MediaPlayer.MEDIA_INFO_RTC_VIDEO_DECODE_STALL /* -268435424 */:
                                        videoLiveManager.mLogService.onRtcDecoderStall(i2, true);
                                        break;
                                    case MediaPlayer.MEDIA_INFO_RTC_AUDIO_DECODE_STALL /* -268435423 */:
                                        videoLiveManager.mLogService.onRtcDecoderStall(i2, false);
                                        break;
                                    default:
                                        switch (i) {
                                            case MediaPlayer.MEDIA_INFO_AVOUTSYNC_START /* -268435407 */:
                                                System.currentTimeMillis();
                                                videoLiveManager.mLogService.mNoSyncStartTime = System.currentTimeMillis();
                                                videoLiveManager.mLogService.mNoSyncStartPts = i2;
                                                break;
                                            case MediaPlayer.MEDIA_INFO_AVOUTSYNC_END /* -268435406 */:
                                                System.currentTimeMillis();
                                                long jCurrentTimeMillis = System.currentTimeMillis();
                                                long j = ((long) i2) - videoLiveManager.mLogService.mNoSyncStartPts;
                                                long j2 = jCurrentTimeMillis - videoLiveManager.mLogService.mNoSyncStartTime;
                                                if (j > videoLiveManager.mNoSyncReportMinDuration) {
                                                    videoLiveManager.mLogService.mNoSyncCount++;
                                                    videoLiveManager.mLogService.mNoSyncPlayingCount++;
                                                    videoLiveManager.mLogService.mNoSyncTimeDuration += j2;
                                                    videoLiveManager.mLogService.mNoSyncPlayingTimeDuration += j2;
                                                    videoLiveManager.mLogService.mNoSyncPtsDuration += j;
                                                    videoLiveManager.mLogService.mNoSyncPlayingPtsDuration += j;
                                                    try {
                                                        string = new JSONObject().put(f.p, videoLiveManager.mLogService.mNoSyncStartTime).put(f.q, jCurrentTimeMillis).put("start_pts", videoLiveManager.mLogService.mNoSyncStartPts).put("end_pts", i2).put("info", videoLiveManager.mPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVPTS_DIFF_LIST)).toString();
                                                    } catch (JSONException unused) {
                                                        string = null;
                                                    }
                                                    if (videoLiveManager.mLogService.mNoSyncPlayingInfoStr.length() + string.length() < videoLiveManager.mLogService.mNoSyncPlayingInfoLen) {
                                                        videoLiveManager.mLogService.mNoSyncPlayingInfoStr = videoLiveManager.mLogService.mNoSyncPlayingInfoStr + string;
                                                    }
                                                    if (videoLiveManager.mLogService.mNoSyncInfoStr.length() + string.length() < videoLiveManager.mLogService.mNoSyncInfoLen) {
                                                        videoLiveManager.mLogService.mNoSyncInfoStr = videoLiveManager.mLogService.mNoSyncInfoStr + string;
                                                    }
                                                }
                                                break;
                                            default:
                                                switch (i) {
                                                    case MediaPlayer.MEDIA_INFO_VIDEO_STREAM_BITRATE_CHANGED /* 251658249 */:
                                                        int i3 = i2 / 1000;
                                                        if (videoLiveManager.mEnableResolutionAutoDegrade && videoLiveManager.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && videoLiveManager.mURLSource.getSourceType() == 2) {
                                                            long j3 = i3;
                                                            String labelfromBitrate = videoLiveManager.mURLSource.getLabelfromBitrate(j3, videoLiveManager.mLevel);
                                                            if (TextUtils.isEmpty(labelfromBitrate) && videoLiveManager.mLogService.mBitRateAbnormalType == 1 && j3 == videoLiveManager.mTargetOriginBitRate / 1000) {
                                                                labelfromBitrate = "origin";
                                                            }
                                                            String defaultResolution = videoLiveManager.mURLSource.getDefaultResolution();
                                                            if (defaultResolution != null && !defaultResolution.equals(labelfromBitrate)) {
                                                                if (labelfromBitrate != null) {
                                                                    videoLiveManager.mLogService.mAbrSwitchInfo = "abr_" + videoLiveManager.mURLSource.getDefaultResolution() + "_to_" + labelfromBitrate;
                                                                    videoLiveManager.mURLSource.setDefaultResolution(labelfromBitrate);
                                                                    videoLiveManager.mLogService.mAutoUsingResolution = labelfromBitrate;
                                                                } else {
                                                                    videoLiveManager.mLogService.mAbrSwitchInfo = "none";
                                                                }
                                                                videoLiveManager.mLogService.mAbrSwitchCount++;
                                                                StringBuilder sb2 = new StringBuilder();
                                                                LiveLoggerService liveLoggerService2 = videoLiveManager.mLogService;
                                                                sb2.append(liveLoggerService2.mAbrSwitchCountInfo);
                                                                sb2.append(",");
                                                                sb2.append(i3);
                                                                sb2.append(":");
                                                                sb2.append(System.currentTimeMillis());
                                                                liveLoggerService2.mAbrSwitchCountInfo = sb2.toString();
                                                                videoLiveManager.mLogService.mCurDownloadSpeed = (videoLiveManager.mPlayer.getLongOption(63, 0L) * 8) / 1000;
                                                                videoLiveManager.mLogService.mCurAudioBufferTime = videoLiveManager.mPlayer.getLongOption(73, 0L);
                                                                videoLiveManager.mLogService.mCurVideoBufferTime = videoLiveManager.mPlayer.getLongOption(72, 0L);
                                                                videoLiveManager.mLogService.mAbrSwitchCost = videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, -1L);
                                                                videoLiveManager.mListener.onAbrSwitch(labelfromBitrate);
                                                                videoLiveManager.mLogService.onAbrSwitch(j3, labelfromBitrate, true);
                                                            }
                                                        }
                                                        break;
                                                    case MediaPlayer.MEDIA_INFO_AUDIO_RENDER_STALL /* 251658250 */:
                                                        videoLiveManager.mListener.onAudioRenderStall(i2);
                                                        videoLiveManager.mLogService.onRenderStall(i2, VideoLiveManager.mAudioRenderStallThreshold, false, true);
                                                        break;
                                                    case MediaPlayer.MEDIA_INFO_VIDEO_RENDER_STALL /* 251658251 */:
                                                        videoLiveManager.mListener.onVideoRenderStall(i2);
                                                        videoLiveManager.mLogService.onRenderStall(i2, VideoLiveManager.mVideoRenderStallThreshold, true, true);
                                                        break;
                                                    case MediaPlayer.MEDIA_INFO_AUDIO_RENDER_START /* 251658252 */:
                                                        if (videoLiveManager.mPlayer != null) {
                                                            videoLiveManager.mLogService.onAudioRenderStart(videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, -1L));
                                                            break;
                                                        }
                                                        break;
                                                    case MediaPlayer.MEDIA_INFO_SILENCE_DETECTED /* 251658253 */:
                                                        videoLiveManager.mLogService.mSilenceDetectedCount++;
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        return false;
                    }
                    videoLiveManager.mIsStalling = false;
                    videoLiveManager.mListener.onStallEnd();
                    videoLiveManager.mRetryProcessor.onStall(false, videoLiveManager.mEnterStallRetryInstantly);
                    if (videoLiveManager.mShowedFirstFrame && videoLiveManager.mLogService.isStalling()) {
                        videoLiveManager.mLogService.onStallEnd(1);
                    } else if (!videoLiveManager.mShowedFirstFrame && videoLiveManager.mStallStartTime != 0) {
                        videoLiveManager.mStallTotalTime = System.currentTimeMillis() - videoLiveManager.mStallStartTime;
                    }
                    if (videoLiveManager.mIsPlayWithMdl) {
                        MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(AVMDLDataLoader.KeyIsPlayInfoBufferingEnd, videoLiveManager.mLogService.mSessionId, i2);
                    }
                }
                return false;
            }
            if (videoLiveManager.mEnableRtcPlay == 1 && videoLiveManager.mRtcPlayFallBack == 0 && videoLiveManager.mCurrentRetryCount > 0) {
                z = false;
                videoLiveManager.mCurrentRetryCount = 0;
            } else {
                z = false;
            }
            if (videoLiveManager.mPlayer == null) {
                return z;
            }
            if (videoLiveManager.mPlayer != null) {
                videoLiveManager.mLogService.onUpdateMetaData(videoLiveManager.mPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO));
            }
            if (videoLiveManager.mPlayer != null) {
                int intOption = videoLiveManager.mPlayer.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, -1);
                if (intOption == 0) {
                    videoLiveManager.mLogService.setCodecType("h264");
                } else if (intOption == 1) {
                    videoLiveManager.mLogService.setCodecType("bytevc1");
                }
            }
            if (videoLiveManager.mPlayer != null) {
                videoLiveManager.mLogService.mCodecName = videoLiveManager.convertCodecName(videoLiveManager.mPlayer.getIntOption(157, -1));
            }
            videoLiveManager.mLogService.onPrepare(0);
            videoLiveManager.mIsStalling = false;
            if (videoLiveManager.mPlayer != null) {
                String stringOption = videoLiveManager.mPlayer.getStringOption(71);
                if (videoLiveManager.mCurrentIP != null && videoLiveManager.mCurrentIP.startsWith("[") && stringOption != null && !stringOption.startsWith("[")) {
                    stringOption = String.format("[%s]", stringOption);
                }
                if (stringOption != null && !stringOption.equals(videoLiveManager.mCurrentIP)) {
                    videoLiveManager.mLogService.setCdnIp(stringOption, true);
                    videoLiveManager.mCurrentIP = stringOption;
                }
            }
            if (videoLiveManager.mEnableReportSessionStop == 1) {
                videoLiveManager.mLogService.mSessionHasFirstFrame = true;
                videoLiveManager.mLogService.mSessionVideoRenderStartTime = System.currentTimeMillis();
                videoLiveManager.updateSessionFirstFrameInfo();
            }
            if (!videoLiveManager.mShowedFirstFrame) {
                if (videoLiveManager.mEnableTextureRender != 1 || videoLiveManager.mUsePlayerRenderStart) {
                    videoLiveManager.mLogService.onFirstFrame(0L, videoLiveManager.mStallTotalTime);
                    videoLiveManager.mLogService.start();
                    videoLiveManager.mShowedFirstFrame = true;
                    videoLiveManager.mListener.onFirstFrame(true);
                    videoLiveManager.setIntOption(75, 1);
                }
                if (videoLiveManager.mIsPlayWithMdl) {
                    MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(8015, videoLiveManager.mLogService.mSessionId, -1);
                }
                if (videoLiveManager.mLogService.isPreview() && videoLiveManager.mIsPlayWithMdl) {
                    MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(8016, videoLiveManager.mLogService.mSessionId, -1);
                }
            } else if (videoLiveManager.mRenderStartEntered && videoLiveManager.mIsRetrying) {
                videoLiveManager.mListener.onFirstFrame(false);
                if (videoLiveManager.mUserSwitchResoultion) {
                    videoLiveManager.mUserSwitchResoultion = false;
                } else {
                    videoLiveManager.mLogService.onRetry(0);
                    if (videoLiveManager.mLogService.isStalling()) {
                        videoLiveManager.mListener.onStallEnd();
                        videoLiveManager.mLogService.onStallEnd(2);
                    }
                }
                if (videoLiveManager.mLogService.isInErrorRecovering()) {
                    videoLiveManager.mLogService.onErrorRecovered();
                }
                videoLiveManager.onRenderStallForRetryStop();
            }
            videoLiveManager.mRenderStartEntered = true;
            videoLiveManager.mIsRetrying = false;
            videoLiveManager.mRetryProcessor.reset();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class MyOnVideoSizeChangedListener implements MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyOnVideoSizeChangedListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null || videoLiveManager.mListener == null) {
                return;
            }
            videoLiveManager.mListener.onVideoSizeChanged(i, i2);
            videoLiveManager.mLogService.onVideoSizeChanged(i, i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MyPreparedListener implements MediaPlayer.OnPreparedListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyPreparedListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPrepareState != PlayerState.PREPARING || videoLiveManager.mPlayer == null) {
                return;
            }
            PlayerState unused = videoLiveManager.mPrepareState;
            videoLiveManager.mLogService.onPrepareEnd();
            videoLiveManager.mPrepareState = PlayerState.PREPARED;
            if (videoLiveManager.mStartDirectAfterPrepared == 0) {
                videoLiveManager.mPlayer.start();
            }
            videoLiveManager.mListener.onPrepared();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class MyReleaseRunnable implements Runnable {
        private MediaPlayer mPlayer;

        public MyReleaseRunnable(MediaPlayer mediaPlayer) {
            this.mPlayer = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.release();
                    this.mPlayer = null;
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MyRetryListener implements RetryProcessor.RetryListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyRetryListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRTCFallBack() {
            String playURLForResolution;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mIsRetrying = true;
            videoLiveManager._stopPlayer();
            if (videoLiveManager.mCurrentRetryCount < videoLiveManager.mRtcMaxRetryCount) {
                videoLiveManager.mCurrentRetryCount++;
            } else {
                videoLiveManager.mRtcPlayFallBack = 1;
                videoLiveManager.mLogService.mRtcPlayFallBack = 1;
                videoLiveManager.mURLSource.setRtcFallback(1);
                if (videoLiveManager.mShowedFirstFrame) {
                    videoLiveManager.mLogService.mFallbackType = 2;
                } else {
                    if (videoLiveManager.mRtcSupportMiniSdp == 1) {
                        videoLiveManager.mRtcSupportMiniSdp = 0;
                        videoLiveManager.mLogService.mEnableMiniSdp = 0;
                    }
                    videoLiveManager.mLogService.mFallbackType = 1;
                }
            }
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                playURLForResolution = videoLiveManager.mURLSource.getNextURL();
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            } else {
                playURLForResolution = null;
            }
            int unused = videoLiveManager.mCurrentRetryCount;
            videoLiveManager.mLogService.onSwitchURL(playURLForResolution);
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                videoLiveManager.parsePlayDNS(playURLForResolution);
            } else {
                videoLiveManager._resetPlayer();
                videoLiveManager.parsePlayDNS(playURLForResolution);
            }
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onReportOutToApplication(LiveError liveError) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mListener.onError(liveError);
            videoLiveManager.mFetcher.cancel();
            videoLiveManager.mRetryProcessor.reset();
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRetryNextPlayURL() {
            String playURLForResolution;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.updateDownloadSizeStat();
            videoLiveManager.mLogService.onSessionStop();
            videoLiveManager.mIsRetrying = true;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                playURLForResolution = videoLiveManager.mURLSource.getNextURL();
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            } else {
                playURLForResolution = null;
            }
            videoLiveManager.mLogService.onSwitchURL(playURLForResolution);
            if (!videoLiveManager.mHasRetry) {
                videoLiveManager.mHasRetry = true;
                videoLiveManager.mLogService.setWaitTime(videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 0L));
            }
            videoLiveManager._stopPlayer();
            videoLiveManager.mLogService.mSessionStartTime = System.currentTimeMillis();
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                videoLiveManager.parsePlayDNS(playURLForResolution);
            } else {
                videoLiveManager._resetPlayer();
                videoLiveManager.parsePlayDNS(playURLForResolution);
            }
        }

        @Override // com.bykv.vk.component.ttvideo.retry.RetryProcessor.RetryListener
        public void onRetryResetPlayer(boolean z) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.updateDownloadSizeStat();
            videoLiveManager.mLogService.onSessionStop();
            videoLiveManager.getLastRenderTime();
            videoLiveManager.mIsRetrying = true;
            if (!videoLiveManager.mHasRetry) {
                videoLiveManager.mHasRetry = true;
                videoLiveManager.mLogService.setWaitTime(videoLiveManager.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 0L));
            }
            videoLiveManager._stopPlayer();
            String playURLForResolution = null;
            if (videoLiveManager.mURLSource.getSourceType() == 1) {
                if (videoLiveManager.mURLSource.getPlayLiveURL() != null) {
                    playURLForResolution = videoLiveManager.mURLSource.getPlayLiveURL().mainURL;
                }
            } else if (videoLiveManager.mURLSource.getSourceType() == 2) {
                playURLForResolution = videoLiveManager.mURLSource.getPlayURLForResolution(videoLiveManager.mResolution.equals("auto") ? videoLiveManager.mURLSource.getDefaultResolution() : videoLiveManager.mResolution, videoLiveManager.mStreamFormat, videoLiveManager.mLevel);
            }
            videoLiveManager.mLogService.onSwitchURL(playURLForResolution);
            boolean z2 = videoLiveManager.mURLSource.getSourceType() == 2 && videoLiveManager.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && videoLiveManager.mResolution.equals("auto");
            videoLiveManager.mRetryStartTime = System.currentTimeMillis();
            videoLiveManager.mLogService.mSessionStartTime = System.currentTimeMillis();
            if (videoLiveManager.mPrepareState == PlayerState.PREPARED) {
                if (videoLiveManager.mEnableAbrStallDegradeImmediately == 1 || !z2 || (z2 && !videoLiveManager.abrDegradeResolution())) {
                    videoLiveManager.parsePlayDNS(playURLForResolution);
                    return;
                }
                return;
            }
            videoLiveManager._resetPlayer();
            if (videoLiveManager.mEnableAbrStallDegradeImmediately == 1 || !z2 || (z2 && !videoLiveManager.abrDegradeResolution())) {
                videoLiveManager.parsePlayDNS(playURLForResolution);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NamedThreadFactory implements ThreadFactory {
        private NamedThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            fx fxVar = new fx(runnable, VideoLiveManager.TAG);
            fxVar.setPriority(10);
            return fxVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class PlayCacheSyncRunner implements Runnable {
        static final long CacheThreadshold = 5000;
        static final long LongDelay = 500;
        static final long ShortDelay = 300;
        boolean mIsLiveIO;
        String mMdlTaskSessionId;
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public PlayCacheSyncRunner(VideoLiveManager videoLiveManager, String str, boolean z) {
            this.mIsLiveIO = false;
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
            this.mMdlTaskSessionId = str;
            this.mIsLiveIO = z;
        }

        private long getPlayCache() {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return -1L;
            }
            long longOption = videoLiveManager.mPlayer.getLongOption(73, -1L);
            long longOption2 = videoLiveManager.mPlayer.getLongOption(72, -1L);
            if (longOption >= 0 && longOption2 >= 0) {
                return Math.min(longOption, longOption2);
            }
            if (longOption >= 0) {
                return longOption;
            }
            if (longOption2 >= 0) {
                return longOption2;
            }
            return -1L;
        }

        private void nextround(long j) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null) {
                return;
            }
            videoLiveManager.runOnCurrentThreadDelay(VideoLiveManager.this.new PlayCacheSyncRunner(videoLiveManager, this.mMdlTaskSessionId, this.mIsLiveIO), j);
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || (str = this.mMdlTaskSessionId) == null || !str.equals(videoLiveManager.mSessionId) || this.mMdlTaskSessionId.isEmpty()) {
                return;
            }
            if (videoLiveManager.mLivePlayerState != LivePlayerState.PLAYED) {
                nextround(500L);
                return;
            }
            long playCache = getPlayCache();
            if (playCache == -1) {
                nextround(500L);
                return;
            }
            if (!this.mIsLiveIO) {
                MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(AVMDLDataLoader.KeyIsPlayInfoCurrentBuffer, videoLiveManager.mSessionId, (int) playCache);
            }
            String unused = videoLiveManager.mSessionId;
            if (playCache > 5000) {
                nextround(500L);
            } else {
                nextround(300L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum PlayerState {
        IDLE,
        INITIALIZED,
        PREPARING,
        PREPARED
    }

    /* JADX INFO: compiled from: SearchBox */
    public class VideoStallCountTask implements Runnable {
        private VideoStallCountTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (VideoLiveManager.this.mStallCounterLock) {
                if (VideoLiveManager.this.mStallCounterIsRunning && VideoLiveManager.this.mPlayer != null) {
                    long jUptimeMillis = SystemClock.uptimeMillis() + ((long) VideoLiveManager.this.mStallCounterInterval);
                    long longOption = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200, 0L);
                    long longOption2 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 0L);
                    long longOption3 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 0L);
                    long longOption4 = VideoLiveManager.this.mPlayer.getLongOption(384, 0L);
                    long longOption5 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500, 0L);
                    long longOption6 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500, 0L);
                    long longOption7 = VideoLiveManager.this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500, 0L);
                    if ((longOption != 0 || longOption2 != 0 || longOption3 != 0 || longOption4 != 0 || longOption5 != 0 || longOption6 != 0 || longOption7 != 0) && VideoLiveManager.this.mLogService != null) {
                        VideoLiveManager.this.mLogService.onVideoStallCounter(longOption, longOption2, longOption3, longOption4, longOption5, longOption6, longOption7);
                    }
                    if (VideoLiveManager.this.mStallCounterHandler != null) {
                        VideoLiveManager.this.mStallCounterHandler.postAtTime(this, jUptimeMillis);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HttpKDegradeHttp(int i) {
        String strReplaceAll;
        String str = this.mCurrentPlayURL;
        if (str == null || !str.startsWith("httpk") || (strReplaceAll = this.mCurrentPlayURL.replaceAll("httpk", HttpHost.DEFAULT_SCHEME_NAME).replaceAll(":(\\d+)/", "/")) == null) {
            return false;
        }
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        this.mLogService.onSwitchURL(strReplaceAll);
        this.mLogService.onSwitch(this.mCurrentPlayURL, strReplaceAll, "httpk_to_http", i);
        this.mCurrentPlayURL = strReplaceAll;
        _stopPlayer();
        _resetPlayer();
        this.mSessionStartTime = System.currentTimeMillis();
        parsePlayDNS(this.mCurrentPlayURL);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean QuicDegrade(int i) {
        String strReplaceAll;
        if (this.mCurrentPlayURL == null) {
            return false;
        }
        if ((!TextUtils.equals(this.mTransportProtocol, LiveConfigKey.QUIC) && !TextUtils.equals(this.mTransportProtocol, LiveConfigKey.QUICU)) || i != -499499) {
            return false;
        }
        if (this.mURLProtocol.equals(LiveConfigKey.TLS)) {
            this.mTransportProtocol = LiveConfigKey.TLS;
            strReplaceAll = this.mCurrentPlayURL.replaceAll("httpq", BaseConstants.SCHEME_HTTPS);
        } else if (this.mURLProtocol.equals(LiveConfigKey.KCP)) {
            this.mTransportProtocol = LiveConfigKey.KCP;
            strReplaceAll = this.mCurrentPlayURL.replaceAll("httpq", "httpk");
        } else {
            this.mTransportProtocol = LiveConfigKey.TCP;
            strReplaceAll = this.mCurrentPlayURL.replaceAll("httpq", HttpHost.DEFAULT_SCHEME_NAME);
        }
        String strReplaceAll2 = strReplaceAll.replaceAll(":(\\d+)/", "/");
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        if (strReplaceAll2 != null) {
            this.mLogService.onSwitchURL(strReplaceAll2);
            this.mLogService.onSwitch(this.mCurrentPlayURL, strReplaceAll2, "quic_library_load_error", i);
            this.mCurrentPlayURL = strReplaceAll2;
            _stopPlayer();
            _resetPlayer();
            this.mSessionStartTime = System.currentTimeMillis();
            parsePlayDNS(this.mCurrentPlayURL);
        }
        return true;
    }

    private String _addParamToURL(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str4 = str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
        int iIndexOf = str.indexOf(Constants.STRING_VALUE_UNSET);
        if (iIndexOf == -1) {
            str4 = Constants.STRING_VALUE_UNSET + str4;
        } else if (iIndexOf != str.length() - 1) {
            str4 = ContainerUtils.FIELD_DELIMITER + str4;
        }
        return str + str4;
    }

    private void _checkStreamData() {
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            return;
        }
        liveInfoSource.setEnableOriginResolution(this.mEnableOriginResolution);
        if (this.mEnableResolutionAutoDegrade && this.mURLSource.getSourceType() == 2 && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE)) {
            String defaultResolution = this.mURLSource.getDefaultResolution();
            if (!TextUtils.isEmpty(defaultResolution)) {
                if (this.mEnableOriginResolution || !defaultResolution.equals("origin")) {
                    _smartResolveDefaultResolution(defaultResolution);
                } else {
                    _smartResolveDefaultResolution(LiveConfigKey.UHD);
                }
            }
            if (this.mURLSource.isABRListMatch() && this.mURLSource.isCodecSame(this.mLevel)) {
                return;
            }
            this.mResolution = this.mURLSource.getDefaultResolution();
            this.mAbrStrategy = LiveConfigKey.RAD;
            this.mEnableResolutionAutoDegrade = false;
            if (!this.mURLSource.isABRListMatch()) {
                this.mLogService.mABRListMatch = 0;
            }
            if (this.mURLSource.isCodecSame(this.mLevel)) {
                return;
            }
            this.mLogService.mCodecNotSame = 1;
        }
    }

    private void _checkValidAbrResolution() {
        if (!this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || !this.mEnableResolutionAutoDegrade || this.mURLSource.isEnableAdaptive(this.mResolution)) {
            return;
        }
        int i = 0;
        while (true) {
            String[] strArr = LiveConfigKey.resolution;
            if (i >= strArr.length) {
                return;
            }
            if (this.mURLSource.isEnableAdaptive(strArr[i])) {
                this.mResolution = strArr[i];
                return;
            }
            i++;
        }
    }

    private void _configAbrInfo() {
        JSONObject abrInfo = this.mURLSource.getAbrInfo();
        if (abrInfo == null) {
            this.mHasAbrInfo = false;
            this.mEnableResolutionAutoDegrade = false;
            this.mEnableOriginResolution = false;
            this.mAbrStrategy = LiveConfigKey.RAD;
            this.mStallCountThresOfResolutionDegrade = 4;
            return;
        }
        boolean z = true;
        this.mHasAbrInfo = true;
        try {
            if (abrInfo.has("enable")) {
                this.mEnableResolutionAutoDegrade = abrInfo.optInt("enable") == 1;
            }
            if (abrInfo.has(WkAdConfigModel.TAG_STRATEGY)) {
                this.mAbrStrategy = abrInfo.getString(WkAdConfigModel.TAG_STRATEGY);
            }
            if (abrInfo.has("enable_origin_resolution")) {
                if (abrInfo.optInt("enable_origin_resolution") != 1) {
                    z = false;
                }
                this.mEnableOriginResolution = z;
            }
            if (abrInfo.has("disable_algorithm")) {
                this.mABRDisableAlgorithm = abrInfo.optInt("disable_algorithm");
            }
        } catch (JSONException unused) {
            this.mHasAbrInfo = false;
            this.mEnableResolutionAutoDegrade = false;
            this.mAbrStrategy = LiveConfigKey.RAD;
            this.mEnableOriginResolution = false;
            this.mStallCountThresOfResolutionDegrade = 4;
        }
    }

    private void _configAvphNeqStrategy() {
        JSONObject jSONObject;
        String str = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_low_latency_flv_default_strategy_map", "");
        if (str.length() > 0) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null && jSONObject.has("net_effective_connection_type_strategy")) {
            try {
                jSONObject.getJSONObject("net_effective_connection_type_strategy");
            } catch (JSONException unused2) {
            }
        }
    }

    private void _configFlvLowLatencyWithSDKParam() {
        String sDKParams = this.mURLSource.getSDKParams(this.mResolution, this.mLevel);
        if (sDKParams != null) {
            try {
                JSONObject jSONObject = new JSONObject(sDKParams);
                if (jSONObject.has("NetworkAdapt")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NetworkAdapt"));
                    if (jSONObject2.has("Enabled")) {
                        int iOptInt = jSONObject2.optInt("Enabled");
                        this.mEnableHurryFlag = iOptInt;
                        if (iOptInt == 1) {
                            this.mHurryType = 0;
                        }
                        if (jSONObject2.has("HurryTime")) {
                            int iOptInt2 = jSONObject2.optInt("HurryTime");
                            this.mHurryTime = iOptInt2;
                            this.mPlayer.setIntOption(15, iOptInt2);
                            this.mLogService.mHurryTime = this.mHurryTime;
                        }
                        if (jSONObject2.has("HurryMillisecond")) {
                            int iOptInt3 = jSONObject2.optInt("HurryMillisecond");
                            this.mHurryTime = iOptInt3;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, iOptInt3);
                            this.mLogService.mHurryTime = this.mHurryTime;
                        }
                        if (jSONObject2.has("HurrySpeed")) {
                            float f = Float.parseFloat(jSONObject2.optString("HurrySpeed"));
                            this.mCatchSpeed = f;
                            this.mPlayer.setFloatOption(80, f);
                            this.mLogService.mCatchSpeed = this.mCatchSpeed;
                        }
                        if (jSONObject2.has("SlowTime")) {
                            int iOptInt4 = jSONObject2.optInt("SlowTime");
                            this.mSlowPlayTime = iOptInt4;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, iOptInt4);
                            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
                        }
                        if (jSONObject2.has("SlowMillisecond")) {
                            int iOptInt5 = jSONObject2.optInt("SlowMillisecond");
                            this.mSlowPlayTime = iOptInt5;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, iOptInt5);
                            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
                        }
                        if (jSONObject2.has("SlowSpeed")) {
                            float f2 = Float.parseFloat(jSONObject2.optString("SlowSpeed"));
                            this.mSlowPlaySpeed = f2;
                            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, f2);
                            this.mLogService.mSlowSpeed = this.mSlowPlaySpeed;
                        }
                    }
                }
                if (jSONObject.has("FastOpenDuration")) {
                    mFastOpenDuration = jSONObject.optInt("FastOpenDuration");
                }
                if (jSONObject.has("EnableLowLatencyFLV")) {
                    this.mEnableLowLatencyFLV = jSONObject.optInt("EnableLowLatencyFLV");
                    this.mLogService.getStallTotalCount();
                    this.mLogService.getRetryTotalCount();
                }
            } catch (JSONException unused) {
            }
        }
    }

    private void _configLiveSettingBundle() {
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle == null) {
            return;
        }
        this.mEnableCheckDropAudio = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_enable_check_drop_audio", 0)).intValue();
        this.mRenderType = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_option_render_type", 3)).intValue();
        this.mEnableCmafFastMode = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_cmaf_fast_mode", 0)).intValue();
        this.mStartPlayBufferThres = ((Long) this.mSettingsBundle.getSettingsValueForKey("live_start_play_buffer_thres", 0L)).longValue();
        this.mCheckBufferingEndIgnoreVideo = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_check_buffering_end_ignore_video", 0)).intValue();
        this.mStartDirectAfterPrepared = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_direct_start_after_prepared", 0)).intValue();
        this.mCheckBufferingEndAdvanceEnable = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_check_buffering_end_advance", 0)).intValue();
        if (!this.mHasAbrInfo) {
            this.mEnableResolutionAutoDegrade = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_enable_resolution_degrade", Boolean.FALSE)).booleanValue();
            this.mStallCountThresOfResolutionDegrade = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_stall_count_thres_for_degrade", 4)).intValue();
        }
        this.mEnableOpenMDL = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_open_mdl_enable", 0)).intValue();
        this.mEnableTcpFastOpen = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_tcp_fast_open", 0)).intValue();
        this.mEnableCheckPacketCorrupt = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_check_packet_corrupt", 0)).intValue();
        this.mEnableFlvABR = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_flv_abr", 0)).intValue();
        ILiveSettingBundle iLiveSettingBundle2 = this.mSettingsBundle;
        Boolean bool = Boolean.FALSE;
        this.mForceHttpDns = ((Boolean) iLiveSettingBundle2.getSettingsValueForKey("live_sdk_http_dns_enabled", bool)).booleanValue();
        this.mHttpDNSServerHost = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_http_dns_server_host", com.igexin.push.core.b.m);
        LiveLoggerService liveLoggerService = this.mLogService;
        liveLoggerService.mEnableHttpDns = this.mForceHttpDns;
        liveLoggerService.mHostNTPUrl = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_ntp_server_name", com.igexin.push.core.b.m);
        this.mCancelSDKDNSFailRetry = ((Boolean) this.mSettingsBundle.getSettingsValueForKey("live_sdk_cancel_sdk_dns_fail_retry", bool)).booleanValue();
        this.mEnableClosePlayRetry = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_enable_close_play_retry", 0)).intValue();
        this.mEnableOptimizeBackup = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_optimize_backup_enabled", 0)).intValue();
        this.mEnableStallRetryInstantly = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_stall_retry_instantly_enabled", 1)).intValue();
        this.mEnableAudioVolumeBalance = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_enable", 0)).intValue();
        this.mAudioVolumeBalancePregain = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_pregain", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalanceThreshold = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_threshold", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalanceRatio = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_ratio", Float.valueOf(-1.0f))).floatValue();
        this.mAudioVolumeBalancePredelay = ((Float) this.mSettingsBundle.getSettingsValueForKey("live_sdk_audio_volume_balance_predelay", Float.valueOf(-1.0f))).floatValue();
        this.mEnableCacheSei = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_sei_pts_synced", 0)).intValue();
        this.mStallRetryTimeIntervalManager = ((Long) this.mSettingsBundle.getSettingsValueForKey("stall_retry_time_interval_manager", 10000L)).longValue();
        this.mEnableDecodeMultiSei = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_decode_multi_sei", 0)).intValue();
        this.mEnableRadioLiveDisableRender = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_radiolive_disable_render", 0)).intValue();
        this.mEnableOpenLiveIO = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_liveio", 0)).intValue();
        this.mEnableDecodeSeiOnce = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_enable_decode_sei_once", 0)).intValue();
        ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_notify_sei_immediately_before_first_frame_enabled", 0)).intValue();
        this.mEnableNotifySeiImmediatelyBeforeFirstFrame = 1;
        this.mEnableDroppingDTSRollFrame = ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_dropping_dts_rollback_frame_enabled", 0)).intValue();
        String str = (String) this.mSettingsBundle.getSettingsValueForKey("live_sdk_low_latency_flv_default_strategy_map", "");
        if (str.length() > 0) {
            try {
                this.mLowLatencyFLVStrategy = new JSONObject(str);
            } catch (JSONException unused) {
                this.mLowLatencyFLVStrategy = null;
                MyLog.e(TAG, "strategy settings invalid");
            }
        }
    }

    private void _configWithLowLatencyFLVStrategy(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("net_effective_connection_type_strategy")) {
            try {
                jSONObject.getJSONObject("net_effective_connection_type_strategy");
            } catch (JSONException unused) {
            }
        }
    }

    private void _configWithSDKParams() {
        ILiveSettingBundle iLiveSettingBundle;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String sDKParams = this.mURLSource.getSDKParams(this.mResolution, this.mLevel);
        if (sDKParams != null) {
            try {
                JSONObject jSONObject4 = new JSONObject(sDKParams);
                if (!this.mHasAbrInfo && jSONObject4.has("Auto") && (jSONObject2 = jSONObject4.getJSONObject("Auto")) != null) {
                    if (jSONObject2.has("Enable")) {
                        this.mEnableResolutionAutoDegrade = jSONObject2.optInt("Enable") == 1;
                    }
                    if (jSONObject2.has("Demotion") && (jSONObject3 = jSONObject2.getJSONObject("Demotion")) != null && jSONObject3.has("StallCount")) {
                        this.mStallCountThresOfResolutionDegrade = jSONObject3.getInt("StallCount");
                    }
                }
                if (jSONObject4.has("vbitrate")) {
                    this.mDefaultResBitrate = jSONObject4.optInt("vbitrate");
                }
                if (jSONObject4.has("FramesDrop")) {
                    this.mFramesDrop = jSONObject4.optInt("FramesDrop");
                }
                if (jSONObject4.has("AVPHDnsParseEnable")) {
                    this.mAVPHDnsParseEnable = jSONObject4.optInt("AVPHDnsParseEnable");
                }
                if (jSONObject4.has("AVPHDnsTimeout")) {
                    this.mAVPHDnsTimeout = jSONObject4.optInt("AVPHDnsTimeout");
                }
                if (jSONObject4.has("AVPHVideoProbesize")) {
                    this.mAVPHVideoProbesize = jSONObject4.optInt("AVPHVideoProbesize");
                }
                if (jSONObject4.has("AVPHVideoMaxDuration")) {
                    this.mAVPHVideoMaxDuration = jSONObject4.optInt("AVPHVideoMaxDuration");
                }
                if (jSONObject4.has("AVPHAudioProbesize")) {
                    this.mAVPHAudioProbesize = jSONObject4.optInt("AVPHAudioProbesize");
                }
                if (jSONObject4.has("AVPHAudioMaxDuration")) {
                    this.mAVPHAudioMaxDuration = jSONObject4.optInt("AVPHAudioMaxDuration");
                }
                if (jSONObject4.has("AVPHOpenVideoFirst")) {
                    this.mAVPHOpenVideoFirst = jSONObject4.optInt("AVPHOpenVideoFirst");
                }
                if (jSONObject4.has("AVPHMaxAVDiff")) {
                    this.mAVPHMaxAVDiff = jSONObject4.optInt("AVPHMaxAVDiff");
                }
                if (jSONObject4.has("AVPHAutoExit")) {
                    this.mAVPHAutoExit = jSONObject4.optInt("AVPHAutoExit");
                }
                if (jSONObject4.has("AVPHAutoReopen")) {
                    this.mAVPHEnableAutoReopen = jSONObject4.optInt("AVPHAutoReopen");
                }
                if (jSONObject4.has("AVPHVideoDiffThreshold")) {
                    this.mAVPHVideoDiffThreshold = jSONObject4.optInt("AVPHVideoDiffThreshold");
                }
                if (jSONObject4.has("AVPHReadRetryCount")) {
                    this.mAVPHReadRetryCount = jSONObject4.optInt("AVPHReadRetryCount");
                }
                if (jSONObject4.has("AVPHReadErrorExit")) {
                    this.mAVPHReadErrorExit = jSONObject4.optInt("AVPHReadErrorExit");
                }
                if (jSONObject4.has("EnableSkipFindUnnecessaryStream")) {
                    this.mEnableSkipFindUnnecessaryStream = jSONObject4.optInt("EnableSkipFindUnnecessaryStream");
                }
                if (jSONObject4.has("EnableRenderStall")) {
                    this.mEnableRenderStall = jSONObject4.optInt("EnableRenderStall");
                }
                if (jSONObject4.has("VideoRenderStallThreshold")) {
                    mVideoRenderStallThreshold = jSONObject4.optInt("VideoRenderStallThreshold");
                }
                if (jSONObject4.has("AudioRenderStallThreshold")) {
                    mAudioRenderStallThreshold = jSONObject4.optInt("AudioRenderStallThreshold");
                }
                if (jSONObject4.has("EnableDemuxerStall")) {
                    this.mEnableDemuxerStall = jSONObject4.optInt("EnableDemuxerStall");
                }
                if (jSONObject4.has("EnableDecoderStall")) {
                    this.mEnableDecoderStall = jSONObject4.optInt("EnableDecoderStall");
                }
                if (jSONObject4.has("DemuxerStallThreshold")) {
                    mDemuxerStallThreshold = jSONObject4.optInt("DemuxerStallThreshold");
                }
                if (jSONObject4.has("DecoderStallThreshold")) {
                    mDecoderStallThreshold = jSONObject4.optInt("DecoderStallThreshold");
                }
                if (jSONObject4.has("StallCounter") && (jSONObject = jSONObject4.getJSONObject("StallCounter")) != null) {
                    if (jSONObject.has("Enable")) {
                        this.mEnableStallCounter = jSONObject.optInt("Enable");
                    }
                    if (jSONObject.has("TimeInterval")) {
                        this.mStallCounterInterval = jSONObject.optInt("TimeInterval");
                    }
                }
                if (jSONObject4.has("DTSCheckEnabled")) {
                    this.mEnableDTSCheck = jSONObject4.optInt("DTSCheckEnabled");
                }
                if (jSONObject4.has("DroppingRepeatingDataEnabled")) {
                    this.mEnablePreventDTSBack = jSONObject4.optInt("DroppingRepeatingDataEnabled");
                }
                if (jSONObject4.has("DroppingRepeatingDataDTSMaxDiff")) {
                    this.mFrameDroppingDTSMaxDiff = jSONObject4.optLong("DroppingRepeatingDataDTSMaxDiff");
                }
                if (jSONObject4.has("EnableSaveSCFG")) {
                    this.mEnableSaveSCFG = jSONObject4.optInt("EnableSaveSCFG") == 1;
                }
                if (jSONObject4.has("EnableVideoMpdRefresh")) {
                    this.mEnableVideoMpdRefresh = jSONObject4.optInt("EnableVideoMpdRefresh");
                }
                if (jSONObject4.has("TransInfoCheck")) {
                    JSONObject jSONObjectOptJSONObject3 = jSONObject4.optJSONObject("TransInfoCheck");
                    if (jSONObjectOptJSONObject3.has("Enabled")) {
                        this.mEnableCheckFrame = jSONObjectOptJSONObject3.optInt("Enabled");
                    }
                }
                if (jSONObject4.has("SEICheck")) {
                    JSONObject jSONObjectOptJSONObject4 = jSONObject4.optJSONObject("SEICheck");
                    if (jSONObjectOptJSONObject4.has("Enabled")) {
                        this.mEnableCheckSEI = jSONObjectOptJSONObject4.optInt("Enabled");
                        if (jSONObjectOptJSONObject4.optInt("Enabled") == 1 || this.mLogService != null) {
                            this.mLogService.enableCheckSei();
                        }
                    }
                }
                if (jSONObject4.has("EnableCacheSei")) {
                    this.mEnableCacheSei = jSONObject4.optInt("EnableCacheSei");
                }
                if (jSONObject4.has("gop")) {
                    this.mGopDuration = jSONObject4.optInt("gop");
                }
                if (jSONObject4.has("EnableLLASHFastOpen")) {
                    this.mEnableLLASHFastOpen = jSONObject4.optInt("EnableLLASHFastOpen");
                }
                if (jSONObject4.has("EnableABRCheckEnhance")) {
                    this.mEnableLiveAbrCheckEnhance = jSONObject4.optInt("EnableABRCheckEnhance");
                }
                if (jSONObject4.has("ABRCheckInterval")) {
                    this.mLiveABRCheckInterval = jSONObject4.optInt("ABRCheckInterval");
                }
                if (jSONObject4.has("ABRMethod")) {
                    this.mABRMethod = jSONObject4.optInt("ABRMethod");
                }
                if (jSONObject4.has("ABRBufferThreshold")) {
                    this.mABRBufferThreshold = jSONObject4.optInt("ABRBufferThreshold");
                }
                if (jSONObject4.has("MaxCacheSeconds")) {
                    this.mMaxCacheSeconds = jSONObject4.optInt("MaxCacheSeconds");
                }
                if (jSONObject4.has("MainBackupSwitch")) {
                    JSONObject jSONObjectOptJSONObject5 = jSONObject4.optJSONObject("MainBackupSwitch");
                    if (jSONObjectOptJSONObject5.has("Enabled")) {
                        if (jSONObjectOptJSONObject5.optInt("Enabled") == 0) {
                            this.mEnableSwitchMainAndBackupUrl = false;
                        } else {
                            this.mEnableSwitchMainAndBackupUrl = true;
                        }
                    }
                }
                if (jSONObject4.has("MinTimeShift")) {
                    this.mTslMinTimeShit = jSONObject4.optInt("MinTimeShift");
                }
                if (jSONObject4.has("TargetOriginBitRate")) {
                    this.mTargetOriginBitRate = jSONObject4.optInt("TargetOriginBitRate");
                }
                if (jSONObject4.has("AbrStallDegradeImmediately")) {
                    this.mEnableAbrStallDegradeImmediately = jSONObject4.optInt("AbrStallDegradeImmediately");
                }
                if (jSONObject4.has("HASSessionPath")) {
                    this.mCdnSessionPath = jSONObject4.optString("HASSessionPath");
                }
                if (jSONObject4.has("DecodeSEIEnabled")) {
                    this.mEnableUploadSei = jSONObject4.optInt("DecodeSEIEnabled");
                }
                if (jSONObject4.has("NetworkAdapt")) {
                    JSONObject jSONObject5 = new JSONObject(jSONObject4.optString("NetworkAdapt"));
                    if (jSONObject5.has("Enabled")) {
                        int iOptInt = jSONObject5.optInt("Enabled");
                        this.mEnableHurryFlag = iOptInt;
                        if (iOptInt == 1) {
                            this.mHurryType = 0;
                        }
                        if (jSONObject5.has("HurryTime")) {
                            int iOptInt2 = jSONObject5.optInt("HurryTime");
                            this.mHurryTime = iOptInt2;
                            this.mPlayer.setIntOption(15, iOptInt2);
                        }
                        if (jSONObject5.has("HurryMillisecond")) {
                            int iOptInt3 = jSONObject5.optInt("HurryMillisecond");
                            this.mHurryTime = iOptInt3;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, iOptInt3);
                        }
                        if (jSONObject5.has("HurrySpeed")) {
                            this.mCatchSpeed = Float.parseFloat(jSONObject5.optString("HurrySpeed"));
                        }
                        if (jSONObject5.has("SlowTime")) {
                            int iOptInt4 = jSONObject5.optInt("SlowTime");
                            this.mSlowPlayTime = iOptInt4;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, iOptInt4);
                        }
                        if (jSONObject5.has("SlowMillisecond")) {
                            int iOptInt5 = jSONObject5.optInt("SlowMillisecond");
                            this.mSlowPlayTime = iOptInt5;
                            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, iOptInt5);
                        }
                        if (jSONObject5.has("SlowSpeed")) {
                            this.mSlowPlaySpeed = Float.parseFloat(jSONObject5.optString("SlowSpeed"));
                        }
                    }
                }
                if (jSONObject4.has("StartPlayAudioBufferThreshold")) {
                    this.mStartPlayBufferThres = jSONObject4.optInt("StartPlayAudioBufferThreshold");
                }
                if (jSONObject4.has("EnableCertVerify")) {
                    this.mEnableQuicCertVerify = jSONObject4.optInt("EnableCertVerify") == 1;
                }
                if (jSONObject4.has("EnableClosePlayRetry")) {
                    this.mEnableClosePlayRetry = jSONObject4.optInt("EnableClosePlayRetry");
                }
                if (jSONObject4.has("EnableDnsOptimizer")) {
                    boolean z = jSONObject4.optInt("EnableDnsOptimizer") == 1;
                    this.mEnableDnsOptimizer = z;
                    this.mLogService.openNodeOptimizer(z);
                }
                if (jSONObject4.has("EnableMTUDiscovery")) {
                    this.mEnableQuicMTUDiscovery = jSONObject4.optInt("EnableMTUDiscovery");
                }
                if (jSONObject4.has("InitMTU")) {
                    this.mQuicInitMTU = jSONObject4.optInt("InitMTU");
                }
                if (jSONObject4.has("InitRtt")) {
                    this.mQuicInitRtt = jSONObject4.optInt("InitRtt");
                }
                if (jSONObject4.has("MaxCryptoRetransmissions")) {
                    this.mQuicMaxCryptoRetransmissions = jSONObject4.optInt("MaxCryptoRetransmissions");
                }
                if (jSONObject4.has("MaxCryptoRetransmissionTimeMs")) {
                    this.mQuicMaxCryptoRetransmissionTimeMs = jSONObject4.optInt("MaxCryptoRetransmissionTimeMs");
                }
                if (jSONObject4.has("MaxRetransmissions")) {
                    this.mQuicMaxRetransmissions = jSONObject4.optInt("MaxRetransmissions");
                }
                if (jSONObject4.has("MaxRetransmissionTimeMs")) {
                    this.mQuicMaxRetransmissionTimeMs = jSONObject4.optInt("MaxRetransmissionTimeMs");
                }
                if (jSONObject4.has("MaxAckDelay")) {
                    this.mQuicMaxAckDelay = jSONObject4.optInt("MaxAckDelay");
                }
                if (jSONObject4.has("MinReceivedBeforeAckDecimation")) {
                    this.mQuicMinReceivedBeforeAckDecimation = jSONObject4.optInt("MinReceivedBeforeAckDecimation");
                }
                if (jSONObject4.has("QuicVersion")) {
                    this.mQuicVersion = jSONObject4.optInt("QuicVersion", 39);
                }
                if (jSONObject4.has("PadHello")) {
                    this.mQuicPadHello = jSONObject4.optInt("PadHello", 1);
                }
                if (jSONObject4.has("FixWillingAndAbleToWrite")) {
                    this.mQuicFixWillingAndAbleToWrite = jSONObject4.optInt("FixWillingAndAbleToWrite", 1);
                }
                if (jSONObject4.has("FixProcessTimer")) {
                    this.mQuicFixProcessTimer = jSONObject4.optInt("FixProcessTimer", 1);
                }
                if (jSONObject4.has("QuicReadBlockTimeout")) {
                    this.mQuicReadBlockTimeout = jSONObject4.optInt("QuicReadBlockTimeout", 100);
                }
                if (jSONObject4.has("QuicReadBlockMode")) {
                    this.mQuicReadBlockMode = jSONObject4.optInt("QuicReadBlockMode", 0);
                }
                if (jSONObject4.has("FixStreamFinAndRst")) {
                    this.mQuicFixStreamFinAndRst = jSONObject4.optInt("FixStreamFinAndRst", 0);
                }
                if (jSONObject4.has("QuicTimerVersion")) {
                    this.mQuicTimerVersion = jSONObject4.optInt("QuicTimerVersion", 1);
                }
                if (jSONObject4.has("QuicConfigOptimize")) {
                    this.mQuicConfigOptimize = jSONObject4.optInt("QuicConfigOptimize", 0);
                }
                if (jSONObject4.has("QuicSessionReceiveWindow")) {
                    this.mSessionReceiveWindow = jSONObject4.optInt("QuicSessionReceiveWindow", 1);
                }
                if (jSONObject4.has("QuicStreamReceiveWindow")) {
                    this.mStreamReceiveWindow = jSONObject4.optInt("QuicStreamReceiveWindow", 1);
                }
                if (jSONObject4.has("EnableCheckDropAudio")) {
                    this.mEnableCheckDropAudio = jSONObject4.optInt("EnableCheckDropAudio");
                }
                if (jSONObject4.has("AVNoSyncThreshold")) {
                    this.mAVNoSyncThreshold = jSONObject4.optInt("AVNoSyncThreshold");
                }
                if (jSONObject4.has("AlwaysDoAVSync")) {
                    this.mIsAlwaysDoAVSync = jSONObject4.optInt("AlwaysDoAVSync");
                }
                if (jSONObject4.has("StallRetryTimeIntervalManager")) {
                    this.mStallRetryTimeIntervalManager = jSONObject4.optLong("StallRetryTimeIntervalManager");
                }
                if (jSONObject4.has("FastOpenDuration")) {
                    mFastOpenDuration = jSONObject4.optInt("FastOpenDuration");
                }
                if (jSONObject4.has("LLSConfig") && (jSONObjectOptJSONObject2 = jSONObject4.optJSONObject("LLSConfig")) != null) {
                    if (jSONObjectOptJSONObject2.has("FallbackThreshold")) {
                        this.mRtcFallbackThreshold = jSONObjectOptJSONObject2.optInt("FallbackThreshold");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableDtls")) {
                        this.mRtcEnableDtls = jSONObjectOptJSONObject2.optInt("EnableDtls");
                    }
                    if (jSONObjectOptJSONObject2.has("MinJitterBuffer")) {
                        this.mRtcMinJitterBuffer = jSONObjectOptJSONObject2.optInt("MinJitterBuffer");
                    }
                    if (jSONObjectOptJSONObject2.has("MaxJitterBuffer")) {
                        this.mRtcMaxJitterBuffer = jSONObjectOptJSONObject2.optInt("MaxJitterBuffer");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableSDKDns")) {
                        this.mRtcEnableSDKDns = jSONObjectOptJSONObject2.optInt("EnableSDKDns");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableEarlyInitRender")) {
                        this.mRtcEarlyInitRender = jSONObjectOptJSONObject2.optInt("EnableEarlyInitRender");
                    }
                    if (jSONObjectOptJSONObject2.has("MaxRetryCount")) {
                        this.mRtcMaxRetryCount = jSONObjectOptJSONObject2.optInt("MaxRetryCount");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableRTCHWDecode")) {
                        this.mHardwareRTCDecodeEnable = jSONObjectOptJSONObject2.optInt("EnableRTCHWDecode");
                    }
                    if (jSONObjectOptJSONObject2.has("EnableMiniSdp")) {
                        this.mRtcSupportMiniSdp = jSONObjectOptJSONObject2.optInt("EnableMiniSdp");
                    }
                    if (jSONObjectOptJSONObject2.has("PlayingLogInterval")) {
                        int iOptInt6 = jSONObjectOptJSONObject2.optInt("PlayingLogInterval");
                        this.mRtcPlayLogInterval = iOptInt6;
                        LiveLoggerService liveLoggerService = this.mLogService;
                        if (liveLoggerService != null) {
                            liveLoggerService.setRtcPlayLogInterval(iOptInt6);
                        }
                    }
                    if (jSONObjectOptJSONObject2.has("EnableRTSFixDeadlock")) {
                        this.mRtcEnableRtcUninitLockFree = jSONObjectOptJSONObject2.optInt("EnableRTSFixDeadlock");
                    }
                }
                if (jSONObject4.has("NetWorkTimeoutMs")) {
                    this.mNetworkTimeout = jSONObject4.optInt("NetWorkTimeoutMs");
                }
                if (jSONObject4.has("EnableCheckPacketCorrupt")) {
                    this.mEnableCheckPacketCorrupt = jSONObject4.optInt("EnableCheckPacketCorrupt");
                }
                if (jSONObject4.has("AudioTimescaleEnable")) {
                    this.mAudioTimescaleEnable = jSONObject4.optInt("AudioTimescaleEnable");
                }
                if (jSONObject4.has("EnableTcpFastOpen")) {
                    this.mEnableTcpFastOpen = jSONObject4.optInt("EnableTcpFastOpen");
                }
                if (jSONObject4.has("HlsLiveStartIndex")) {
                    this.mHlsLiveStartIndex = jSONObject4.optInt("HlsLiveStartIndex");
                }
                if (jSONObject4.has("CmafOptimizeRetry")) {
                    this.mEnableCmafOptimizeRetry = jSONObject4.optInt("CmafOptimizeRetry");
                }
                if (jSONObject4.has("EnableFastOpen")) {
                    this.mEnableFastOpenStream = jSONObject4.optInt("EnableFastOpen");
                }
                if (jSONObject4.has("EnableLowLatencyFLV")) {
                    this.mEnableLowLatencyFLV = jSONObject4.optInt("EnableLowLatencyFLV");
                }
                if (jSONObject4.has("EnableSkipFlvNullTag")) {
                    this.mEnableSkipFlvNullTag = jSONObject4.optInt("EnableSkipFlvNullTag");
                }
                if (jSONObject4.has("LiveIOConfig") && (jSONObjectOptJSONObject = jSONObject4.optJSONObject("LiveIOConfig")) != null) {
                    if (jSONObjectOptJSONObject.has("EnableLiveIO")) {
                        this.mEnableLiveIOPlay = jSONObjectOptJSONObject.optInt("EnableLiveIO");
                    }
                    if (jSONObjectOptJSONObject.has("EnableP2P")) {
                        this.mEnableLiveIOP2P = jSONObjectOptJSONObject.optInt("EnableP2P");
                    }
                    if (jSONObjectOptJSONObject.has("EnableHttpPrepare")) {
                        this.mEnableHttpPrepare = jSONObjectOptJSONObject.optInt("EnableHttpPrepare");
                    }
                    if (jSONObjectOptJSONObject.has("EnableP2pUp")) {
                        this.mEnableP2pUp = jSONObjectOptJSONObject.optInt("EnableP2pUp");
                    }
                    if (jSONObjectOptJSONObject.has("LiveIOABGroupID")) {
                        this.mLiveIOABGroupID = jSONObjectOptJSONObject.optInt("LiveIOABGroupID");
                    }
                }
                if (jSONObject4.has("EnableNTPByApp")) {
                    int iOptInt7 = jSONObject4.optInt("EnableNTPByApp");
                    this.mEnableNTP = iOptInt7;
                    LiveLoggerService liveLoggerService2 = this.mLogService;
                    liveLoggerService2.mEnableNTP = iOptInt7;
                    if (iOptInt7 == 1 && (iLiveSettingBundle = this.mSettingsBundle) != null) {
                        liveLoggerService2.mTimeDiff = ((Long) iLiveSettingBundle.getSettingsValueForKey("time_diff_server_and_client", 0L)).longValue();
                    }
                }
                if (jSONObject4.has("NoSyncReportMinDuration")) {
                    this.mNoSyncReportMinDuration = jSONObject4.optInt("NoSyncReportMinDuration");
                }
                if (jSONObject4.has("NoSyncReportReportThres")) {
                    this.mNoSyncReportReportThres = jSONObject4.optInt("NoSyncReportReportThres");
                }
            } catch (JSONException unused) {
            }
        }
        this.mLogService.mDefaultResBitrate = this.mDefaultResBitrate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _doRequestSwitchUrlFromServer() {
        MediaPlayer mediaPlayer;
        String stringOption;
        if (TextUtils.isEmpty(this.mCdnSessionPath) || TextUtils.isEmpty(this.mCdnAbrResolution) || this.mCdnAbrResolution.equals(this.mResolution) || (mediaPlayer = this.mPlayer) == null || (stringOption = mediaPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS)) == null) {
            return;
        }
        String str = null;
        for (String str2 : stringOption.split(HttpClient.NEWLINE)) {
            if (str2.startsWith("X-Has-Token: ")) {
                str = str2.split(": ", 2)[1];
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.mLogService.mSessionId)) {
                jSONObject.put("live_stream_session_id", this.mLogService.mSessionId);
            }
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mCdnAbrResolution, LiveConfigKey.FLV, this.mLevel);
            if (TextUtils.isEmpty(playURLForResolution)) {
                return;
            }
            jSONObject.put("play_url", playURLForResolution);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("token", str);
            }
            String strSubstring = playURLForResolution.substring(playURLForResolution.indexOf("//") + 2);
            String strSubstring2 = strSubstring.substring(strSubstring.indexOf("/"));
            if (!this.mCdnSessionPath.startsWith("/")) {
                this.mCdnSessionPath = "/" + this.mCdnSessionPath;
            }
            INetworkClient.Result resultDoPost = this.mNetworkClient.doPost(playURLForResolution.substring(0, playURLForResolution.indexOf(strSubstring2)) + this.mCdnSessionPath, jSONObject.toString());
            if (resultDoPost != null) {
                LiveLoggerService liveLoggerService = this.mLogService;
                int i = resultDoPost.code;
                liveLoggerService.mCdnAbrSwitchCode = i;
                if (i == 200 && resultDoPost.response.has("code")) {
                    this.mLogService.mCdnAbrSwitchCode = resultDoPost.response.optInt("code");
                    if (this.mLogService.mCdnAbrSwitchCode == 0) {
                        this.mResolution = this.mCdnAbrResolution;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void _play(String str) {
        PlayerState playerState = this.mPrepareState;
        if (playerState == PlayerState.PREPARED && this.mPlayer != null) {
            String str2 = this.mCurrentIP;
            if (str2 != null) {
                this.mLogService.setCdnIp(str2, false);
            }
            this.mPlayer.start();
        } else if (playerState == PlayerState.IDLE || this.mPlayer == null) {
            open();
            this.mPrepareState = PlayerState.INITIALIZED;
            if (!this.mIsLocalURL || TextUtils.isEmpty(this.mLocalURL)) {
                parsePlayDNS(str);
            } else {
                this.mLogService.onCallPrepare();
                prepareToPlay(this.mLocalURL, null, null, null);
            }
        } else {
            configPlayerGlobalOption();
            if (!this.mIsLocalURL || TextUtils.isEmpty(this.mLocalURL)) {
                parsePlayDNS(str);
            } else {
                prepareToPlay(this.mLocalURL, null, null, null);
            }
        }
        this.mIsRequestCanceled = false;
    }

    private void _requestSwitchUrlFromServer() {
        this.mLogService.mIsCdnAbrSwitch = true;
        if ((this.mURLSource.getSourceType() != 2 || this.mURLSource.isCodecSame(this.mLevel)) && !this.mExecutor.isShutdown()) {
            this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.2
                @Override // java.lang.Runnable
                public void run() {
                    VideoLiveManager.this._doRequestSwitchUrlFromServer();
                }
            });
        }
    }

    private void _reset(String str) {
        _stopPlayer();
        _resetPlayer();
        _stopLiveManager(str);
        this.mResolutionIndex = -1;
        this.mLivePlayerState = LivePlayerState.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _resetPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        this.mPrepareState = PlayerState.INITIALIZED;
    }

    private void _setLooseSync() {
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            return;
        }
        String sDKParams = liveInfoSource.getSDKParams(this.mResolution, this.mLevel);
        if (TextUtils.isEmpty(sDKParams)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(sDKParams);
            if (jSONObject.has("ForceDecodeSwitch")) {
                this.mForceDecodeSwitch = jSONObject.optInt("ForceDecodeSwitch");
            }
            if (jSONObject.has("ForceDecodeMsGaps")) {
                this.mForceDecodeMsGaps = jSONObject.optInt("ForceDecodeMsGaps");
            }
            if (jSONObject.has("ForceRenderMsGaps")) {
                this.mForceRenderMsGaps = jSONObject.optInt("ForceRenderMsGaps");
            }
        } catch (JSONException unused) {
        }
    }

    private void _setProtocol() {
        String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
        if (playURLForResolution != null) {
            this.mLogService.setOriginUrl(playURLForResolution);
            if (playURLForResolution.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mTransportProtocol = LiveConfigKey.TCP;
            }
            if (playURLForResolution.startsWith("httpk")) {
                this.mTransportProtocol = LiveConfigKey.KCP;
            }
            if (playURLForResolution.startsWith(BaseConstants.SCHEME_HTTPS)) {
                this.mTransportProtocol = LiveConfigKey.TLS;
            }
            this.mURLProtocol = this.mTransportProtocol;
        }
        String suggestProtocol = this.mURLSource.getSuggestProtocol(this.mResolution, this.mLevel);
        this.mSuggestProtocol = suggestProtocol;
        if (suggestProtocol == null) {
            this.mSuggestProtocol = "none";
            return;
        }
        if ((suggestProtocol.equals(LiveConfigKey.QUIC) || this.mSuggestProtocol.equals(LiveConfigKey.QUICU)) && !this.mQuicEnable) {
            try {
                LibraryLoader.loadLibrary("ttquic");
                this.mQuicEnable = true;
                this.mLogService.setQuicLibLoader(1);
            } catch (Throwable unused) {
                suggestProtocol = this.mTransportProtocol;
                this.mQuicEnable = false;
                this.mLogService.setQuicLibLoader(0);
            }
        }
        this.mTransportProtocol = suggestProtocol;
    }

    private void _setStreamFormat() {
        String str;
        String suggestFormat = this.mURLSource.getSuggestFormat(this.mResolution, this.mLevel);
        if (suggestFormat == null) {
            this.mStreamFormat = LiveConfigKey.FLV;
            this.mLogService.setFormatInfo("none", LiveConfigKey.FLV);
        } else if (suggestFormat.equals(LiveConfigKey.CMAF) && !this.mCmafEnable) {
            try {
                LibraryLoader.loadLibrary("ttmcmaf");
                this.mCmafEnable = true;
                str = suggestFormat;
            } catch (Throwable unused) {
                this.mURLSource.setStreamInfoFlag(1);
                str = this.mStreamFormat;
                this.mCmafEnable = false;
            }
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(suggestFormat, str);
        } else if (suggestFormat.equals("lls")) {
            this.mEnableRtcPlay = 1;
            this.mLogService.mEnableRtcPlay = 1;
            try {
                iz.u("byteaudio");
                iz.u("bytenn");
                iz.u("bytertc");
                str = suggestFormat;
            } catch (Throwable unused2) {
                this.mURLSource.setStreamInfoFlag(2);
                str = this.mStreamFormat;
                this.mEnableRtcPlay = 0;
                this.mLogService.mEnableRtcPlay = 0;
            }
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(suggestFormat, str);
        } else {
            str = suggestFormat;
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(suggestFormat, str);
        }
        if (!TextUtils.isEmpty(this.mStreamFormat) && this.mStreamFormat.equals(LiveConfigKey.FLV)) {
            _setAvLines();
            if (!this.mEnableAvLines.isEmpty() && !this.mVideoOnly.isEmpty() && !this.mAudioOnly.isEmpty() && this.mEnableAvLines.equals(ex.Code) && this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO) && this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
                this.mStreamFormat = LiveConfigKey.AVPH;
                this.mLogService.setFormatInfo(LiveConfigKey.AVPH, LiveConfigKey.AVPH);
            }
        }
        if (TextUtils.isEmpty(this.mStreamFormat) || !this.mStreamFormat.equals(LiveConfigKey.AVPH)) {
            return;
        }
        _configAvphNeqStrategy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void _smartResolveDefaultResolution(String str) {
        byte b;
        byte b2;
        if (this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && this.mEnableResolutionAutoDegrade && !TextUtils.isEmpty(str)) {
            String str2 = str;
            if (str2.equals(LiveConfigKey.LOW)) {
                while (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(this.mURLSource.getPlayURLForResolution(str2, this.mStreamFormat, this.mLevel))) {
                        this.mURLSource.setDefaultResolution(str2);
                        this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                        return;
                    }
                    str2.hashCode();
                    switch (str2.hashCode()) {
                        case -1008619738:
                            b2 = !str2.equals("origin") ? (byte) -1 : (byte) 0;
                            break;
                        case 3324:
                            if (str2.equals(LiveConfigKey.HIGH)) {
                                b2 = 1;
                                break;
                            }
                            break;
                        case 3448:
                            if (str2.equals(LiveConfigKey.LOW)) {
                                b2 = 2;
                                break;
                            }
                            break;
                        case 3665:
                            if (str2.equals(LiveConfigKey.STANDARD)) {
                                b2 = 3;
                                break;
                            }
                            break;
                        case 115761:
                            if (str2.equals(LiveConfigKey.UHD)) {
                                b2 = 4;
                                break;
                            }
                            break;
                    }
                    switch (b2) {
                        case 0:
                        default:
                            str2 = null;
                            break;
                        case 1:
                            str2 = LiveConfigKey.UHD;
                            break;
                        case 2:
                            str2 = LiveConfigKey.STANDARD;
                            break;
                        case 3:
                            str2 = LiveConfigKey.HIGH;
                            break;
                        case 4:
                            str2 = "origin";
                            break;
                    }
                }
                return;
            }
            while (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(this.mURLSource.getPlayURLForResolution(str2, this.mStreamFormat, this.mLevel))) {
                    this.mURLSource.setDefaultResolution(str2);
                    this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                    return;
                }
                str2.hashCode();
                switch (str2.hashCode()) {
                    case -1008619738:
                        b = !str2.equals("origin") ? (byte) -1 : (byte) 0;
                        break;
                    case 3324:
                        if (str2.equals(LiveConfigKey.HIGH)) {
                            b = 1;
                            break;
                        }
                        break;
                    case 3448:
                        if (str2.equals(LiveConfigKey.LOW)) {
                            b = 2;
                            break;
                        }
                        break;
                    case 3665:
                        if (str2.equals(LiveConfigKey.STANDARD)) {
                            b = 3;
                            break;
                        }
                        break;
                    case 115761:
                        if (str2.equals(LiveConfigKey.UHD)) {
                            b = 4;
                            break;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        str2 = LiveConfigKey.UHD;
                        break;
                    case 1:
                        str2 = LiveConfigKey.STANDARD;
                        break;
                    case 2:
                    default:
                        str2 = null;
                        break;
                    case 3:
                        str2 = LiveConfigKey.LOW;
                        break;
                    case 4:
                        str2 = LiveConfigKey.HIGH;
                        break;
                }
            }
            TextUtils.isEmpty(str2);
        }
    }

    private void _stop(boolean z, String str) {
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState != LivePlayerState.PLAYED && livePlayerState != LivePlayerState.PAUSED) {
            this.mLogService.onIllegalAPICall(str);
            this.mListener.onReportALog(6, "illegal call: " + str + " -- " + hashCode());
            return;
        }
        if (z) {
            _stopPlayer();
        } else {
            this.mPrepareState = PlayerState.INITIALIZED;
        }
        _stopLiveManager(str);
        this.mLivePlayerState = LivePlayerState.STOPPED;
        this.mSupportSRScene = 0;
        this.mTextureSRMode = 0;
        this.mEnableReportSessionStop = 0;
        LiveLoggerService liveLoggerService = this.mLogService;
        liveLoggerService.mMuteAudio = -1;
        liveLoggerService.mVolumeSetting = -1.0f;
        liveLoggerService.mPlayerVolumeSetting = -1.0f;
    }

    private void _stopLiveManager(String str) {
        LiveDataFetcher liveDataFetcher = this.mFetcher;
        if (liveDataFetcher != null) {
            liveDataFetcher.cancel();
        }
        DnsHelper dnsHelper = this.mDnsParser;
        if (dnsHelper != null) {
            dnsHelper.cancel();
        }
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            onRenderStallForRetryStop();
            if (this.mIsStalling) {
                this.mLogService.onStallEnd(0);
            }
            this.mLogService.close(str);
        }
        setIntOption(75, 0);
        this.mLogService.reset();
        this.mRetryProcessor.reset();
        if (str.equals("reset")) {
            this.mURLSource.reset();
        }
        this.mShowedFirstFrame = false;
        this.mRenderStartEntered = false;
        this.mResolutionDisableSR = true;
        this.mMediaSupportSR = false;
        this.mStallStartTime = 0L;
        this.mStallTotalTime = 0L;
        this.mStallCount = 0;
        this.mIsRequestCanceled = true;
        this.mLivePlayerState = LivePlayerState.STOPPED;
        this.mHasSeiInfo = false;
        this.mGetSeiCurrentTime = 0L;
        this.mIsStalling = false;
        this.mIsRetrying = false;
        this.mHasRetry = false;
        this.mSupportBackupIp = true;
        this.mUrlSettingMethod = -1;
        this.mEnableDTSCheck = 0;
        this.mEnablePreventDTSBack = 0;
        this.mEnableCheckFrame = 0;
        this.mEnterStallRetryInstantly = false;
        this.mEnableAvLines = "";
        this.mEnableSaveSCFG = false;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mSuggestProtocol = "none";
        this.mEnableVideoMpdRefresh = 1;
        this.mEnableQuicCertVerify = false;
        this.mTextureSRMode = 0;
        this.mSupportSRScene = 0;
        this.mEnableTextureSR = 0;
        this.mEnableTextureRender = 0;
        this.mQuicVersion = 39;
        this.mQuicInitMTU = 1200;
        this.mEnableQuicMTUDiscovery = 0;
        this.mQuicInitRtt = 0;
        this.mQuicMaxCryptoRetransmissions = 0;
        this.mQuicMaxCryptoRetransmissionTimeMs = 0;
        this.mQuicMaxRetransmissions = 0;
        this.mQuicMaxRetransmissionTimeMs = 0;
        this.mQuicMaxAckDelay = 0;
        this.mQuicMinReceivedBeforeAckDecimation = 0;
        this.mQuicPadHello = 1;
        this.mQuicFixWillingAndAbleToWrite = 1;
        this.mQuicFixProcessTimer = 1;
        this.mQuicReadBlockTimeout = 100;
        this.mQuicReadBlockMode = 0;
        this.mQuicFixStreamFinAndRst = 0;
        this.mQuicConfigOptimize = 0;
        this.mEnableCheckDropAudio = 0;
        this.mIsPlayWithMdl = false;
        this.mAVNoSyncThreshold = 10000;
        this.mIsAlwaysDoAVSync = 0;
        this.mRedoDns = false;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mLiveABRCheckInterval = 1000;
        this.mABRMethod = -1;
        this.mRtcEnableDtls = 0;
        this.mRtcFallbackThreshold = 5000;
        this.mRtcMinJitterBuffer = 300;
        this.mRtcPlayFallBack = 0;
        this.mEnableRtcPlay = 0;
        this.mRtcEnableSDKDns = 0;
        this.mRtcEarlyInitRender = 0;
        this.mEnableFreeFlow = 0;
        this.mABRDisableAlgorithm = 0;
        this.mTextureRenderFirstFrame = false;
        this.mUsePlayerRenderStart = false;
        mFastOpenDuration = -1;
        this.mMyHandler.removeCallbacksAndMessages(null);
        if (this.mEnableStallCounter == 1) {
            stopStallCounter();
        }
        this.mNoSyncReportMinDuration = 5000;
        this.mNoSyncReportReportThres = 200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _stopPlayer() {
        PlayerState playerState;
        if (this.mPlayer != null && ((playerState = this.mPrepareState) == PlayerState.PREPARED || playerState == PlayerState.PREPARING)) {
            LiveLoggerService liveLoggerService = this.mLogService;
            if (liveLoggerService != null) {
                liveLoggerService.getABRStreamInfo();
                this.mLogService.getAVPHStreamInfo();
                if (this.mEnableCheckFrame == 1 || this.mEnableCheckSEI == 1) {
                    this.mLogService.resetStreamCheckParams();
                }
            }
            if (this.mLivePlayerState != LivePlayerState.PAUSED) {
                this.mPlayer.stop();
            } else {
                this.mPlayer.reset();
            }
        }
        if (this.mIsPlayWithMdl && this.mSessionId != null) {
            MediaLoaderWrapper.getDataLoader().setInt64ValueByStrKey(8018, this.mSessionId, 0);
        }
        this.mPrepareState = PlayerState.INITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abrDegradeResolution() {
        String playURLForResolution;
        int length = LiveConfigKey.resolution.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            }
            if (this.mURLSource.isSupportResolution(LiveConfigKey.resolution[length])) {
                break;
            }
            length--;
        }
        if (length == -1) {
            return false;
        }
        String str = LiveConfigKey.NONE;
        this.mURLSource.getDefaultResolution();
        String defaultResolution = this.mURLSource.getDefaultResolution();
        String[] strArr = LiveConfigKey.resolution;
        if (defaultResolution.equals(strArr[length]) || (playURLForResolution = this.mURLSource.getPlayURLForResolution(strArr[length], this.mStreamFormat, "main")) == null) {
            return false;
        }
        String str2 = this.mCurrentPlayURL;
        this.mCurrentPlayURL = playURLForResolution;
        this.mResolutionIndex = length;
        this.mURLSource.setDefaultResolution(strArr[length]);
        this.mLogService.mAutoUsingResolution = strArr[length];
        saveCurrentResolution();
        this.mLogService.onSwitch(str2, this.mCurrentPlayURL, "auto_" + this.mLogService.mLastResolution + "_to_" + this.mResolution, LiveError.PLAYER_STALL);
        this.mLogService.onSwitchURL(this.mCurrentPlayURL);
        this.mLevel = "main";
        this.mStallCount = 0;
        parsePlayDNS(playURLForResolution);
        return true;
    }

    public static /* synthetic */ int access$4408(VideoLiveManager videoLiveManager) {
        int i = videoLiveManager.mStallCount;
        videoLiveManager.mStallCount = i + 1;
        return i;
    }

    private void addRtcCodecInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.mLogService.mCodecName) || "none_codec".equals(this.mLogService.mCodecName)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("video_codec_impl_name")) {
                    String strOptString = jSONObject.optString("video_codec_impl_name");
                    if (!TextUtils.isEmpty(strOptString)) {
                        if ("MediaCodec".equals(strOptString)) {
                            LiveLoggerService liveLoggerService = this.mLogService;
                            liveLoggerService.mCodecName = "hardware_codec";
                            liveLoggerService.mHardDecodeEnable = true;
                        } else {
                            LiveLoggerService liveLoggerService2 = this.mLogService;
                            liveLoggerService2.mCodecName = "software_codec";
                            liveLoggerService2.mHardDecodeEnable = false;
                        }
                    }
                }
                if (jSONObject.has("video_codec_name")) {
                    String strOptString2 = jSONObject.optString("video_codec_name");
                    if (TextUtils.isEmpty(strOptString2)) {
                        return;
                    }
                    if ("ByteVC1".equalsIgnoreCase(strOptString2)) {
                        this.mLogService.mCodecType = "bytevc1";
                    } else {
                        this.mLogService.mCodecType = "h264";
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String addSessionIdToURL(String str, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mUuid)) {
            return null;
        }
        String str2 = this.mUuid + "." + j;
        this.mLogService.mSessionId = str2;
        return !str.contains("_session_id") ? _addParamToURL(str, "_session_id", str2) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bytevc1DegradeH264(int i) {
        String str;
        if (this.mURLAbility != 2 || (str = this.mURLSource.getPlayURLByCodec("h264").mainURL) == null) {
            return false;
        }
        updateDownloadSizeStat();
        this.mLogService.onSessionStop();
        this.mIsRetrying = true;
        this.mLogService.onSwitchURL(str);
        this.mLogService.onSwitch(this.mCurrentPlayURL, str, "bytevc1_to_h264", i);
        this.mCurrentPlayURL = str;
        this.mURLAbility = 1;
        this.mLogService.mUrlAbility = "h264";
        if (this.mHardwareDecodeEnable != 1 && this.mEnableH264HardwareDecode == 1) {
            this.mHardwareDecodeEnable = 1;
            this.mDefaultCodecId = 0;
            this.mPlayer.setIntOption(59, 1);
            this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
        }
        _resetPlayer();
        this.mSessionStartTime = System.currentTimeMillis();
        parsePlayDNS(str);
        return true;
    }

    private void checkMainLooper(String str) {
        LiveLoggerService liveLoggerService;
        if (this.mIsInMainLooper != 1 || Looper.myLooper() == Looper.getMainLooper() || (liveLoggerService = this.mLogService) == null) {
            return;
        }
        liveLoggerService.onCallNotInMainThread(str);
    }

    public static void closeDataLoader() {
        MediaLoaderWrapper.getDataLoader().close();
    }

    private void configPlayerEventHandler() {
        this.mPlayer.setOnPreparedListener(new MyPreparedListener(this));
        this.mPlayer.setOnErrorListener(new MyErrorListener(this));
        this.mPlayer.setOnInfoListener(new MyInfoListener(this));
        this.mPlayer.setOnCompletionListener(new MyCompletionListener(this));
        this.mPlayer.setOnVideoSizeChangedListener(new MyOnVideoSizeChangedListener(this));
    }

    private void configPlayerGlobalOption() {
        LiveURL playLiveURL;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        boolean z;
        int i;
        this.mPlayer.setIntOption(9, this.mNetworkTimeout * 1000000);
        this.mPlayer.setIntOption(83, this.mTestAction);
        this.mPlayer.setIntOption(37, this.mEnhancementType);
        this.mPlayer.setIntOption(38, this.mScaleType);
        StringBuilder sb = new StringBuilder();
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_PLAY_TYPE, 0);
        this.mPlayer.setIntOption(36, this.mLayoutType);
        this.mPlayer.setIntOption(110, 5000);
        this.mPlayer.setIntOption(64, 0);
        this.mPlayer.setIntOption(94, 1);
        this.mPlayer.setIntOption(56, this.mRenderType);
        _configLiveSettingBundle();
        _configWithSDKParams();
        configToBParams();
        LiveLoggerService liveLoggerService = this.mLogService;
        int i2 = this.mEnableFastOpenStream;
        liveLoggerService.mEnableFastOpenStream = i2;
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, i2);
        this.mPlayer.setIntOption(56, this.mRenderType);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO, this.mEnableCheckDropAudio);
        this.mPlayer.setIntOption(52, this.mEnableUploadSei);
        if (this.mEnableDTSCheck == 1 || this.mEnableCheckFrame == 1 || this.mEnableCheckSEI == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 1);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, 1);
        if (this.mEnableClosePlayRetry == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 0);
            this.mPlayer.setIntOption(82, 0);
        }
        LiveLoggerService liveLoggerService2 = this.mLogService;
        liveLoggerService2.mHasAbrInfo = this.mHasAbrInfo;
        liveLoggerService2.mAbrStrategy = this.mAbrStrategy;
        liveLoggerService2.mEnableResolutionAutoDegrade = this.mEnableResolutionAutoDegrade;
        liveLoggerService2.mStallCountThresOfResolutionDegrade = this.mStallCountThresOfResolutionDegrade;
        long j = this.mStallRetryTimeIntervalManager;
        liveLoggerService2.mStallRetryTimeInterval = j;
        this.mRetryProcessor.setStallRetryTimeInterval(j);
        int i3 = this.mEnableSharp;
        if (i3 == 1) {
            this.mPlayer.setIntOption(189, i3);
            LiveLoggerService liveLoggerService3 = this.mLogService;
            if (liveLoggerService3 != null) {
                liveLoggerService3.enableSharp();
            }
        }
        String vCodec = this.mURLSource.getSourceType() == 2 ? this.mURLSource.getVCodec(this.mResolution, this.mLevel) : (this.mURLSource.getSourceType() != 1 || (playLiveURL = this.mURLSource.getPlayLiveURL()) == null) ? null : playLiveURL.getVCodec();
        if (vCodec != null) {
            if (vCodec.equals("h264")) {
                this.mHardwareDecodeEnable = this.mEnableH264HardwareDecode;
                this.mDefaultCodecId = 0;
            } else if (vCodec.equals("bytevc1")) {
                this.mHardwareDecodeEnable = this.mEnableByteVC1HardwareDecode;
                this.mDefaultCodecId = 1;
            } else {
                this.mHardwareDecodeEnable = 0;
            }
            this.mLogService.mUrlAbility = vCodec;
        } else {
            this.mHardwareDecodeEnable = 0;
        }
        this.mHardwareDecodeEnable = 1;
        this.mEnableMediaCodecASYNCInit = 1;
        this.mPlayer.setIntOption(800, this.mEnableRtcPlay);
        if (this.mEnableRtcPlay == 1) {
            this.mPlayer.setIntOption(59, 0);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, 0);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, (this.mHardwareRTCDecodeEnable == 1 && this.mHardwareDecodeEnable == 1) ? 1 : 0);
        } else {
            this.mPlayer.setIntOption(59, this.mHardwareDecodeEnable);
            this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
            if (this.mHardwareDecodeEnable == 1 && this.mDefaultCodecId != -1) {
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, this.mEnableMediaCodecASYNCInit);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, this.mDefaultCodecId);
                LiveLoggerService liveLoggerService4 = this.mLogService;
                liveLoggerService4.mMediaCodecAsyncInit = this.mEnableMediaCodecASYNCInit;
                liveLoggerService4.mDefaultCodecID = this.mDefaultCodecId;
            }
            this.mPlayer.setIntOption(97, this.mHardwareDecodeEnable);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_SIZE, ErrorCode.REASON_RD_METADATA);
        }
        int i4 = this.mByteVC1DecoderType;
        if (i4 != -1 && this.mEnableByteVC1HardwareDecode != 1) {
            this.mPlayer.setIntOption(67, i4);
        }
        int i5 = this.mBufferTimeout;
        if (i5 != -1) {
            this.mPlayer.setIntOption(81, i5);
        }
        float f = this.mCatchSpeed;
        if (f > 0.0f) {
            this.mPlayer.setFloatOption(80, f);
            this.mLogService.mCatchSpeed = this.mCatchSpeed;
        }
        if (this.mCacheFileEnable == -1 && this.mCacheFilePath != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            String string = sb2.toString();
            this.mCacheFileKey = string;
            this.mPlayer.setStringOption(17, string);
            this.mPlayer.setIntOption(14, 1);
            this.mPlayer.setCacheFile(this.mCacheFilePath, 1);
        }
        int i6 = this.mHurryType;
        if (i6 != -1) {
            this.mPlayer.setIntOption(84, i6);
            this.mLogService.mEnableHurry = true;
        }
        if (this.mHurryType == 0 && (i = this.mHurryTime) != 0) {
            this.mPlayer.setIntOption(15, i);
            this.mLogService.mHurryTime = this.mHurryTime;
        }
        if (this.mIsLocalURL && !TextUtils.isEmpty(this.mLocalURL) && (z = this.mLooping)) {
            this.mPlayer.setLooping(z);
        }
        int i7 = this.mBufferDataSeconds;
        if (i7 != -1) {
            this.mPlayer.setIntOption(86, i7);
        }
        int i8 = this.mSlowPlayTime;
        if (i8 != -1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, i8);
            this.mLogService.mSlowPlayTime = this.mSlowPlayTime;
        }
        float f2 = this.mSlowPlaySpeed;
        if (f2 > 0.0f) {
            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, f2);
            this.mLogService.mSlowSpeed = this.mSlowPlaySpeed;
        }
        int i9 = this.mMaxCacheSeconds;
        if (i9 != -1) {
            this.mPlayer.setIntOption(24, i9);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, this.mMaxCacheSeconds);
            this.mLogService.mMaxCacheSeconds = this.mMaxCacheSeconds;
        }
        int i10 = this.mEnableSplitStream;
        if (i10 != 0) {
            this.mPlayer.setIntOption(87, i10);
            this.mLogService.mEnableSplitStream = this.mEnableSplitStream;
        }
        long j2 = this.mStartPlayBufferThres;
        if (j2 > 0) {
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, j2);
            this.mLogService.mStartPlayBufferThres = this.mStartPlayBufferThres;
        }
        int i11 = this.mCheckBufferingEndIgnoreVideo;
        if (i11 == 1) {
            this.mPlayer.setIntOption(310, i11);
            this.mLogService.mCheckBufferingEndIgnoreVideo = this.mCheckBufferingEndIgnoreVideo;
        }
        int i12 = this.mStartDirectAfterPrepared;
        if (i12 == 1) {
            this.mPlayer.setIntOption(311, i12);
            this.mLogService.mStartDirectAfterPrepared = this.mStartDirectAfterPrepared;
        }
        int i13 = this.mCheckBufferingEndAdvanceEnable;
        if (i13 == 1) {
            this.mPlayer.setIntOption(313, i13);
            this.mLogService.mCheckBufferingEndAdvanceEnable = this.mCheckBufferingEndAdvanceEnable;
        }
        int i14 = this.mOpenCheckSideData;
        if (i14 == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, i14);
        }
        int i15 = this.mAudioTimescaleEnable;
        if (i15 != -1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE, i15);
            this.mLogService.mAudioTimescaleEnable = this.mAudioTimescaleEnable;
        }
        LiveLoggerService liveLoggerService5 = this.mLogService;
        liveLoggerService5.mEnableUploadSessionSeries = this.mEnableUploadSessionSeries;
        if (this.mEnableNTPTask == 1) {
            liveLoggerService5.openNTP();
        }
        if (this.mEnableOpenMDL == 1) {
            this.mLogService.mEnableOpenMDL = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8100);
            this.mLogService.mEnableP2P = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable);
            this.mLogService.mMDLVersion = MediaLoaderWrapper.getDataLoader().getStringValueFromLoader(11);
            this.mLogService.mEnableMdlProto = (int) MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8102);
            MediaLoaderWrapper.getDataLoader().setListener(new MyMediaLoaderListener(this));
            if (!this.mIsMdlProtoRegister && MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8102) == 1) {
                long longValueFromLoader = MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);
                if (longValueFromLoader != -1) {
                    this.mIsMdlProtoRegister = this.mPlayer.setLongOption(500, longValueFromLoader) == 0;
                }
            }
        }
        this.mEnableOpenLiveIO = 0;
        this.mEnableLiveIOPlay = 0;
        this.mEnableRtcPlay = 0;
        long j3 = this.mALogWriteAddr;
        if (j3 != -1) {
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, j3);
            this.mPlayer.setIntOption(223, 1);
        }
        String str = this.mStreamFormat;
        if (str != null) {
            this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str);
        }
        String str2 = this.mStreamFormat;
        if (str2 != null && str2.equals(LiveConfigKey.AVPH)) {
            prepareAvphPlay();
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD, this.mAVNoSyncThreshold);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, this.mIsAlwaysDoAVSync);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, this.mEnableRenderStall);
        if (this.mEnableRenderStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, mAudioRenderStallThreshold);
            this.mPlayer.setIntOption(322, mVideoRenderStallThreshold);
        }
        this.mPlayer.setIntOption(360, this.mEnableDemuxerStall);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES, this.mNoSyncReportReportThres);
        if (this.mEnableDemuxerStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD, mDemuxerStallThreshold);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, -1L);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME, -1L);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL, this.mEnableDecoderStall);
        if (this.mEnableDecoderStall == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, mDecoderStallThreshold);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME, -1L);
            this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME, -1L);
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, this.mEnableStallCounter);
        int i16 = this.mEnableTcpFastOpen;
        if (i16 == 1 && (mediaPlayer2 = this.mPlayer) != null) {
            this.mLogService.mEnableTcpFastOpen = i16;
            mediaPlayer2.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, i16);
            sb.append("live_enable_tcp_fast_open:1,");
        }
        MediaPlayer mediaPlayer3 = this.mPlayer;
        if (mediaPlayer3 != null) {
            int i17 = this.mEnableCmafFastMode;
            if (i17 == 1) {
                mediaPlayer3.setIntOption(611, i17);
                sb.append("live_enable_cmaf_fast_mode:1 ");
            }
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, this.mEnableCmafOptimizeRetry);
        }
        MediaPlayer mediaPlayer4 = this.mPlayer;
        if (mediaPlayer4 != null) {
            mediaPlayer4.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, this.mEnableVideoMpdRefresh);
        }
        int i18 = this.mEnableCheckPacketCorrupt;
        if (i18 == 1 && (mediaPlayer = this.mPlayer) != null) {
            mediaPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, i18);
            sb.append("live_enable_check_packet_corrupt:1,");
        }
        if (this.mEnableResolutionAutoDegrade && this.mURLSource.getSourceType() == 2 && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && this.mABRDisableAlgorithm == 1) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 1);
        }
        if (this.mEnableFlvABR == 1) {
            sb.append("live_enable_flv_abr:1,");
        }
        if (this.mEnableOptimizeBackup == 1) {
            sb.append("live_enable_optimize_backup:1,");
        }
        if (this.mEnableStallRetryInstantly == 1) {
            sb.append("live_enable_stall_retry_instantly:1 ");
        } else {
            sb.append("live_enable_stall_retry_instantly:0 ");
        }
        if (this.mEnableCacheSei == 1) {
            sb.append("live_enable_sei_pts_sync:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, 1);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 1000);
        }
        if (this.mEnableDecodeMultiSei == 1) {
            sb.append("live_enable_decode_multi_sei:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, 1);
        }
        if (this.mEnableDecodeSeiOnce == 1) {
            sb.append("live_enable_decode_sei_once:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 1);
        }
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            if (((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_super_resolution_enable", 0)).intValue() == 1) {
                sb.append("live_sdk_super_resolution_enable:1 ");
            } else {
                sb.append("live_sdk_super_resolution_enable:0 ");
            }
        }
        if (this.mEnableTextureRender == 1) {
            sb.append("live_sdk_texture_render_enable:1 ");
        } else {
            sb.append("live_sdk_texture_render_enable:0 ");
        }
        ILiveSettingBundle iLiveSettingBundle2 = this.mSettingsBundle;
        if (iLiveSettingBundle2 != null) {
            if (((Integer) iLiveSettingBundle2.getSettingsValueForKey("live_sdk_sharpen_enable", 0)).intValue() == 1) {
                sb.append("live_sdk_sharpen_enable:1 ");
            } else {
                sb.append("live_sdk_sharpen_enable:0 ");
            }
        }
        if (this.mEnableOpenLiveIO == 1) {
            sb.append("live_sdk_enable_liveio:1 ");
        }
        if (this.mEnableAudioVolumeBalance == 1) {
            sb.append("live_sdk_audio_volume_balance_enable:1 ");
            if (this.mAudioVolumeBalancePregain != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_pregain:" + this.mAudioVolumeBalancePregain + " ");
            }
            if (this.mAudioVolumeBalanceThreshold != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_threshold:" + this.mAudioVolumeBalanceThreshold + " ");
            }
            if (this.mAudioVolumeBalanceRatio != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_ratio:" + this.mAudioVolumeBalanceRatio + " ");
            }
            if (this.mAudioVolumeBalancePredelay != -1.0f) {
                sb.append("live_sdk_audio_volume_balance_predelay:" + this.mAudioVolumeBalancePredelay + " ");
            }
        }
        if (this.mEnableNotifySeiImmediatelyBeforeFirstFrame == 1) {
            sb.append("live_sdk_notifysei_immediately_before_firstframe:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 1);
        }
        if (this.mEnableRadioLiveDisableRender == 1) {
            sb.append("live_sdk_enable_radiolive_disable_render:1 ");
        }
        if (this.mLogService.mHostNTPUrl != null) {
            sb.append("live_sdk_ntp_server_name:" + this.mLogService.mHostNTPUrl + " ");
        }
        if (this.mEnableReportSessionStop == 1) {
            sb.append("live_sdk_should_report_session_stop:1 ");
            this.mLogService.mEnableReportSessionStop = 1;
        }
        if (this.mUsePlayerRenderStart) {
            sb.append("live_sdk_texturerender_use_player_renderstart:1 ");
        }
        if (this.mEnableFreeFlow == 1) {
            sb.append("live_sdk_isfreeflow:1 ");
        }
        if (this.mEnableDroppingDTSRollFrame == 1) {
            sb.append("live_sdk_dropping_dts_rollback_frame_enabled:1 ");
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK, this.mEnableDroppingDTSRollFrame);
        }
        if (this.mEnableUseLiveThreadPool == 1) {
            sb.append("live_sdk_enable_use_live_threadpool:1 ");
        }
        LiveLoggerService liveLoggerService6 = this.mLogService;
        liveLoggerService6.mIsInMainLooper = this.mIsInMainLooper;
        liveLoggerService6.mSettingsInfo = sb.length() == 0 ? "none" : sb.deleteCharAt(sb.length() - 1).toString();
        if (!TextUtils.isEmpty(this.mStreamFormat) && (this.mStreamFormat.equals(LiveConfigKey.HLS) || this.mStreamFormat.equals(LiveConfigKey.TSL))) {
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, this.mHlsLiveStartIndex);
        }
        LiveLoggerService liveLoggerService7 = this.mLogService;
        liveLoggerService7.mEnableLowLatencyFLV = this.mEnableLowLatencyFLV;
        liveLoggerService7.mFastOpenDuration = mFastOpenDuration;
    }

    private void configPlayerInstanceOption() {
        String str;
        this.mLogService.setProtocolInfo(this.mSuggestProtocol, this.mTransportProtocol);
        this.mLogService.setSdkParams(this.mURLSource.getSDKParams(this.mResolution, this.mLevel));
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null && (str = this.mStreamFormat) != null) {
            mediaPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str);
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        if (mediaPlayer2 == null || this.mEnableAudioVolumeBalance != 1) {
            return;
        }
        mediaPlayer2.setIntOption(302, 1);
        float f = this.mAudioVolumeBalancePregain;
        if (f != -1.0f) {
            this.mPlayer.setFloatOption(303, f);
        }
        float f2 = this.mAudioVolumeBalanceThreshold;
        if (f2 != -1.0f) {
            this.mPlayer.setFloatOption(304, f2);
        }
        float f3 = this.mAudioVolumeBalanceRatio;
        if (f3 != -1.0f) {
            this.mPlayer.setFloatOption(305, f3);
        }
        float f4 = this.mAudioVolumeBalancePredelay;
        if (f4 != -1.0f) {
            this.mPlayer.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY, f4);
        }
    }

    private void configToBParams() {
        MediaPlayer mediaPlayer;
        if (this.mSwitchToB != 1 || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        mediaPlayer.setStringOption(509, this.mMoudleIDToB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String convertCodecName(int i) {
        switch (i) {
            case 1:
                return "IOSHWCodec";
            case 2:
                return "hardware_codec";
            case 3:
                return "ff_H264_codec";
            case 4:
                return "ff_ByteVC1_codec";
            case 5:
                return "KS_ByteVC1_codec";
            case 6:
                return "JX_ByteVC1_codec";
            default:
                return "none_codec";
        }
    }

    public static boolean dataLoaderIsRunning() {
        return MediaLoaderWrapper.getDataLoader().isRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean degradeResolution() {
        String[] strArr;
        String playURLForResolution;
        if (this.mResolution == LiveConfigKey.LOW) {
            return false;
        }
        if (this.mResolutionIndex == -1) {
            int i = 0;
            while (true) {
                String[] strArr2 = LiveConfigKey.resolution;
                if (i >= strArr2.length) {
                    break;
                }
                if (strArr2[i].equals(this.mResolution)) {
                    this.mResolutionIndex = i;
                    break;
                }
                i++;
            }
        }
        int i2 = this.mResolutionIndex + 1;
        while (true) {
            strArr = LiveConfigKey.resolution;
            if (i2 >= strArr.length || this.mURLSource.isSupportResolution(strArr[i2])) {
                break;
            }
            i2++;
        }
        if (i2 >= strArr.length || (playURLForResolution = this.mURLSource.getPlayURLForResolution(strArr[i2], this.mStreamFormat, this.mLevel)) == null) {
            return false;
        }
        String str = this.mCurrentPlayURL;
        this.mCurrentPlayURL = playURLForResolution;
        this.mResolutionIndex = i2;
        saveCurrentResolution();
        LiveLoggerService liveLoggerService = this.mLogService;
        String str2 = strArr[i2];
        this.mResolution = str2;
        liveLoggerService.mResolution = str2;
        liveLoggerService.onSwitch(str, this.mCurrentPlayURL, "auto_" + this.mLogService.mLastResolution + "_to_" + this.mResolution, LiveError.PLAYER_STALL);
        ILiveListener iLiveListener = this.mListener;
        if (iLiveListener != null) {
            iLiveListener.onResolutionDegrade(this.mResolution);
        }
        this.mLogService.onSwitchURL(this.mCurrentPlayURL);
        this.mStallCount = 0;
        parsePlayDNS(playURLForResolution);
        return true;
    }

    public static void enableLoadLibrary() {
        MediaLoaderWrapper.getDataLoader().enableLoadLibrary();
    }

    private JSONObject extractAvphStreamInfo(String str) {
        String[] strArr;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9 = "audio_find_stream_info_cost";
        String str10 = "audio_open_input_cost";
        String str11 = "av_dts_diff";
        String str12 = "audio_cur_dts";
        String str13 = "video_last_dts";
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str14 = "video_find_stream_info_cost";
            String[] strArrSplit = str.split(",");
            int length = strArrSplit.length;
            String str15 = "video_open_input_cost";
            int i = 0;
            while (i < length) {
                int i2 = length;
                String str16 = strArrSplit[i];
                if (str16.startsWith("video_key")) {
                    strArr = strArrSplit;
                    jSONObject.put("video_key", Integer.parseInt(str16.substring(10)));
                } else {
                    strArr = strArrSplit;
                    if (str16.startsWith(str13)) {
                        jSONObject.put(str13, Integer.parseInt(str16.substring(15)));
                    } else {
                        str2 = str13;
                        if (str16.startsWith("video_cur_dts")) {
                            jSONObject.put("video_cur_dts", Integer.parseInt(str16.substring(14)));
                        } else if (str16.startsWith("vv_dts_diff")) {
                            jSONObject.put("vv_dts_diff", Integer.parseInt(str16.substring(12)));
                        } else if (str16.startsWith(str12)) {
                            jSONObject.put(str12, Integer.parseInt(str16.substring(14)));
                        } else if (str16.startsWith(str11)) {
                            jSONObject.put(str11, Integer.parseInt(str16.substring(12)));
                        } else {
                            if (str16.startsWith("audio_first_pkt_ts")) {
                                str3 = str11;
                                str4 = str12;
                                jSONObject.put("audio_first_pkt_ts", Long.parseLong(str16.substring(19)));
                            } else {
                                str3 = str11;
                                str4 = str12;
                                if (str16.startsWith("audio_first_pkt_dts")) {
                                    jSONObject.put("audio_first_pkt_dts", Long.parseLong(str16.substring(20)));
                                } else if (str16.startsWith("video_first_pkt_ts")) {
                                    jSONObject.put("video_first_pkt_ts", Long.parseLong(str16.substring(19)));
                                } else if (str16.startsWith("video_first_pkt_dts")) {
                                    jSONObject.put("video_first_pkt_dts", Long.parseLong(str16.substring(20)));
                                } else if (str16.startsWith(str10)) {
                                    jSONObject.put(str10, Long.parseLong(str16.substring(22)));
                                } else if (str16.startsWith(str9)) {
                                    jSONObject.put(str9, Long.parseLong(str16.substring(28)));
                                } else {
                                    str5 = str15;
                                    if (str16.startsWith(str5)) {
                                        jSONObject.put(str5, Long.parseLong(str16.substring(22)));
                                        str7 = str9;
                                        str8 = str10;
                                        str6 = str14;
                                    } else {
                                        str6 = str14;
                                        if (str16.startsWith(str6)) {
                                            String strSubstring = str16.substring(28);
                                            str7 = str9;
                                            str8 = str10;
                                            jSONObject.put(str6, Long.parseLong(strSubstring));
                                        } else {
                                            str7 = str9;
                                            str8 = str10;
                                        }
                                    }
                                    i++;
                                    str15 = str5;
                                    str14 = str6;
                                    str9 = str7;
                                    str10 = str8;
                                    length = i2;
                                    str13 = str2;
                                    str11 = str3;
                                    str12 = str4;
                                    strArrSplit = strArr;
                                }
                            }
                            str7 = str9;
                            str8 = str10;
                            str6 = str14;
                            str5 = str15;
                            i++;
                            str15 = str5;
                            str14 = str6;
                            str9 = str7;
                            str10 = str8;
                            length = i2;
                            str13 = str2;
                            str11 = str3;
                            str12 = str4;
                            strArrSplit = strArr;
                        }
                        str7 = str9;
                        str8 = str10;
                        str3 = str11;
                        str4 = str12;
                        str6 = str14;
                        str5 = str15;
                        i++;
                        str15 = str5;
                        str14 = str6;
                        str9 = str7;
                        str10 = str8;
                        length = i2;
                        str13 = str2;
                        str11 = str3;
                        str12 = str4;
                        strArrSplit = strArr;
                    }
                }
                str8 = str10;
                str3 = str11;
                str4 = str12;
                str2 = str13;
                str6 = str14;
                str5 = str15;
                str7 = str9;
                i++;
                str15 = str5;
                str14 = str6;
                str9 = str7;
                str10 = str8;
                length = i2;
                str13 = str2;
                str11 = str3;
                str12 = str4;
                strArrSplit = strArr;
            }
            return jSONObject;
        } catch (JSONException | Exception unused) {
            return null;
        }
    }

    private JSONArray formatABRStreamInfoToJSONArray(String str) {
        if (str == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                JSONObject jSONObject = new JSONObject();
                int iIndexOf = str.indexOf("index:");
                int iIndexOf2 = str.indexOf(",pts_diff:");
                if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf < iIndexOf2) {
                    jSONObject.put("index", Integer.parseInt(str.substring(iIndexOf + 6, iIndexOf2)));
                    String strSubstring = str.substring(iIndexOf2);
                    int iIndexOf3 = strSubstring.indexOf(",drop_dur:");
                    if (iIndexOf3 >= 0 && 10 < iIndexOf3) {
                        jSONObject.put("pts_diff", Long.parseLong(strSubstring.substring(10, iIndexOf3)));
                        String strSubstring2 = strSubstring.substring(iIndexOf3);
                        int iIndexOf4 = strSubstring2.indexOf(",key:");
                        if (iIndexOf4 >= 0 && 10 < iIndexOf4) {
                            jSONObject.put("drop_dur", Long.parseLong(strSubstring2.substring(10, iIndexOf4)));
                            String strSubstring3 = strSubstring2.substring(iIndexOf4);
                            int iIndexOf5 = strSubstring3.indexOf(",index:");
                            if (iIndexOf5 != -1) {
                                if (5 >= iIndexOf5) {
                                    break;
                                }
                                jSONObject.put("key_frame", Integer.parseInt(strSubstring3.substring(5, iIndexOf5)));
                                arrayList.add(jSONObject);
                                str = strSubstring3.substring(iIndexOf5 + 1);
                            } else if (strSubstring3.length() != 0) {
                                jSONObject.put("key_frame", Integer.parseInt(strSubstring3.substring(5)));
                                arrayList.add(jSONObject);
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            return new JSONArray((Collection) arrayList);
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONArray formatAVPHStreamInfoToJSONArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str.contains(x.aQ)) {
            for (String str2 : str.split(x.aQ)) {
                JSONObject jSONObjectExtractAvphStreamInfo = extractAvphStreamInfo(str2);
                if (jSONObjectExtractAvphStreamInfo != null) {
                    arrayList.add(jSONObjectExtractAvphStreamInfo);
                }
            }
        } else {
            JSONObject jSONObjectExtractAvphStreamInfo2 = extractAvphStreamInfo(str);
            if (jSONObjectExtractAvphStreamInfo2 != null) {
                arrayList.add(jSONObjectExtractAvphStreamInfo2);
            }
        }
        return new JSONArray((Collection) arrayList);
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    private void open() {
        TTPlayerConfiger.setValue(1, this.mPlayerType != 0);
        TTPlayerConfiger.setValue(2, this.mPlayerType == 2);
        TTPlayerConfiger.setValue(6, false);
        TTPlayerConfiger.setValue(11, true);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isOSPlayer() ^ (this.mPlayerType == 0)) {
                this.mPlayer.releaseAsync();
                this.mPlayer = null;
            }
        }
        if (this.mPlayer == null) {
            this.mPlayer = MediaPlayerWrapper.create(this.mContext, this.mPlayerDegradeMode);
            MediaLoaderWrapper.getDataLoader().setMediaPlayer(this.mPlayer);
            if (this.mPlayer.getPlayerType() != 1 && this.mPlayer.getPlayerType() != 2) {
                this.mHardwareDecodeEnable = 0;
                this.mEnableH264HardwareDecode = 0;
                this.mEnableByteVC1HardwareDecode = 0;
            }
            configPlayerGlobalOption();
            configPlayerEventHandler();
        }
        if (this.mPlayer.isOSPlayer()) {
            this.mLogService.setPlayerSdkVersion("-1");
        } else {
            this.mLogService.setPlayerSdkVersion(TTPlayerConfiger.getValue(14, "0"));
        }
        this.mDnsParser.configure(this.mForceHttpDns, this.mHttpDNSServerHost);
        if (this.mFetcher == null) {
            this.mFetcher = new LiveDataFetcher(this.mExecutor, this.mNetworkClient);
        }
        this.mPlayerSetting.setPlayer(this.mPlayer);
    }

    private String packAvphHeader(String str, String str2, String str3) {
        if (!str.equals("")) {
            str = str + ContainerUtils.FIELD_DELIMITER;
        }
        return ((str + str2) + ContainerUtils.KEY_VALUE_DELIMITER) + str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parsePlayDNS(final String str) {
        if (str == null || str.length() == 0) {
            if (this.mURLSource.getSourceType() == 1 && bytevc1DegradeH264(LiveError.BYTEVC1_URL_IS_NULL)) {
                return;
            }
            if (this.mEnableSwitchMainAndBackupUrl && this.mURLSource.getSourceType() == 2 && switchMainAndBackupUrl(-100002)) {
                return;
            }
            HashMap map = new HashMap();
            map.put("url", "try out all urls");
            this.mRetryProcessor.onError(new LiveError(-100002, "try out all urls", map), this.mShowedFirstFrame);
            return;
        }
        String portNum = this.mURLSource.getPortNum(this.mStreamFormat, this.mLevel, this.mTransportProtocol);
        if (!str.startsWith(LiveConfigKey.RTMP) && portNum == null) {
            String str2 = this.mTransportProtocol;
            str2.hashCode();
            switch (str2) {
                case "kcp":
                    portNum = LiveConfigKey.DEFAULT_KCP_PORT;
                    break;
                case "tcp":
                case "quic":
                case "quicu":
                    portNum = "80";
                    break;
                case "tls":
                    portNum = LiveConfigKey.DEFAULT_TLS_PORT;
                    break;
            }
        }
        if (this.mEnableRtcPlay == 0 || this.mRtcPlayFallBack == 1) {
            str = set_url_port_scheme(str, portNum);
            this.mURLSource.setTransportProtocol(this.mTransportProtocol, portNum);
        }
        String str3 = this.mStreamFormat;
        if (str3 != null && str3.equals(LiveConfigKey.AVPH)) {
            prepareAvphPlay();
        } else if (this.mEnableAvLines.equals(ex.Code) && this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO) && !this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
            str = _addParamToURL(str, "only_video", "1");
        } else if (this.mEnableAvLines.equals(ex.Code) && !this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO) && this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
            str = _addParamToURL(str, "only_audio", "1");
        }
        this.mLogService.setCdnIp("none", false);
        this.mCurrentPlayURL = str;
        final String urlHost = DnsHelper.getUrlHost(str);
        if (!DnsHelper.isIP(urlHost) && this.mEnableDns && urlHost != null) {
            this.mRetryProcessor.setHost(urlHost);
            this.mDnsParser.parseDns(urlHost, new DnsHelper.OnParseCompletionListener() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.3
                @Override // com.bykv.vk.component.ttvideo.network.DnsHelper.OnParseCompletionListener
                public void onParseComplete(String str4, final String str5, final LiveError liveError, boolean z) {
                    String str6 = urlHost;
                    if (str6 == null || str4 == null || !str6.equals(str4)) {
                        return;
                    }
                    VideoLiveManager.this.mLogService.onSDKDNSComplete(!z, false);
                    if (z) {
                        VideoLiveManager.this.runOnFrontCurrentThread(new Runnable() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (liveError != null) {
                                    if (!VideoLiveManager.this.mCancelSDKDNSFailRetry) {
                                        VideoLiveManager.this.mRetryProcessor.onError(liveError, VideoLiveManager.this.mShowedFirstFrame);
                                        return;
                                    }
                                    VideoLiveManager.this.mLogService.onSDKDNSError(liveError);
                                }
                                if (VideoLiveManager.this.mIsRequestCanceled) {
                                    return;
                                }
                                String str7 = str5;
                                String strHostToIPUrl = str;
                                if (str7 == null || str7.length() == 0) {
                                    str7 = "none";
                                } else {
                                    DnsHelper unused = VideoLiveManager.this.mDnsParser;
                                    strHostToIPUrl = DnsHelper.hostToIPUrl(str, str7);
                                }
                                VideoLiveManager.this.mLogService.onCallPrepare();
                                VideoLiveManager.this.mLogService.setCdnIp(str7, false);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                VideoLiveManager.this.prepareToPlay(strHostToIPUrl, str, str7, urlHost);
                                VideoLiveManager.this.mCurrentIP = str7;
                            }
                        });
                        return;
                    }
                    String strHostToIPUrl = str;
                    if (str5 == null || str5.length() == 0) {
                        str5 = "none";
                    } else {
                        DnsHelper unused = VideoLiveManager.this.mDnsParser;
                        strHostToIPUrl = DnsHelper.hostToIPUrl(str, str5);
                    }
                    VideoLiveManager.this.mLogService.onCallPrepare();
                    VideoLiveManager.this.mLogService.setCdnIp(str5, false);
                    VideoLiveManager.this.prepareToPlay(strHostToIPUrl, str, str5, urlHost);
                    VideoLiveManager.this.mCurrentIP = str5;
                }
            });
            return;
        }
        this.mLogService.onSDKDNSComplete(false, false);
        this.mLogService.onCallPrepare();
        this.mLogService.setCdnIp(urlHost, false);
        if (TextUtils.isEmpty(this.mURLHost) || !DnsHelper.isIP(urlHost)) {
            prepareToPlay(str, str, null, null);
        } else {
            prepareToPlay(str, str, null, this.mURLHost);
        }
        this.mCurrentIP = urlHost;
    }

    private void parseResponseHeaders(LogBundle logBundle) {
        String stringOption = this.mPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS);
        if (stringOption == null) {
            return;
        }
        for (String str : stringOption.split(HttpClient.NEWLINE)) {
            if (str.startsWith("X-Server-Ip: ")) {
                logBundle.headerXServerIP = str.split(": ", 2)[1];
            } else if (str.startsWith("Via: ")) {
                logBundle.headerVia = str.split(": ", 2)[1];
            }
        }
    }

    private void prepareAvphPlay() {
        this.mPlayer.setIntOption(159, this.mFramesDrop);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, this.mEnableSkipFindUnnecessaryStream);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, this.mAVPHDnsParseEnable);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, this.mAVPHDnsTimeout);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, this.mAVPHVideoProbesize);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION, this.mAVPHVideoMaxDuration);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, this.mAVPHAudioProbesize);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION, this.mAVPHAudioMaxDuration);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, this.mAVPHOpenVideoFirst);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_MAX_AV_DIFF, this.mAVPHMaxAVDiff);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, this.mAVPHEnableAutoReopen);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT, this.mAVPHAutoExit);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD, this.mAVPHVideoDiffThreshold);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, this.mAVPHReadRetryCount);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT, this.mAVPHReadErrorExit);
        String str = new String();
        String str2 = new String();
        if (this.mAudioOnly.equals(LiveConfigKey.ONLYAUDIO)) {
            str = packAvphHeader(str, "only_audio", "1");
        }
        if (this.mVideoOnly.equals(LiveConfigKey.ONLYVIDEO)) {
            str2 = packAvphHeader(str2, "only_video", "1");
        }
        this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY, str);
        this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, str2);
    }

    private String prepareProxyURL(String str, String str2, String str3, Map<String, String> map) {
        if (!this.mTransportProtocol.equals(LiveConfigKey.TCP) || !this.mStreamFormat.equals(LiveConfigKey.FLV) || this.mEnableResolutionAutoDegrade || TextUtils.isEmpty(this.mSessionId)) {
            this.mLogService.mLiveIOErrorMsg = "proxy not support format: " + this.mStreamFormat + ", proto: " + this.mTransportProtocol + ", abr: " + this.mEnableResolutionAutoDegrade + ", sessio id invalid: " + TextUtils.isEmpty(this.mSessionId);
            return null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                URL url = new URL(str);
                String string = new URL(url.getProtocol(), str3, url.getPort() == -1 ? url.getDefaultPort() : url.getPort(), url.getFile()).toString();
                MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8100);
                MediaLoaderWrapper.getDataLoader().isRunning();
                if (this.mEnableOpenMDL == 1 && MediaLoaderWrapper.getDataLoader().getLongValueFromLoader(8100) == 1 && MediaLoaderWrapper.getDataLoader().isRunning()) {
                    if (this.mALogWriteAddr != -1) {
                        MediaLoaderWrapper.getDataLoader().setLongValue(59, this.mALogWriteAddr);
                    }
                    this.mIsPlayWithMdl = true;
                    runOnCurrentThread(new PlayCacheSyncRunner(this, this.mSessionId, false));
                    String proxyUrl = MediaLoaderWrapper.getDataLoader().getProxyUrl(string, Boolean.valueOf(this.mIsMdlProtoRegister));
                    if (proxyUrl != null && !proxyUrl.isEmpty()) {
                        map.put("Stream-Type", ILivePush.ClickType.LIVE);
                        String str4 = this.mSessionId;
                        if (str4 != null) {
                            map.put("X-Tt-Traceid", str4);
                        }
                        if (str2 != null && !str2.equals("none")) {
                            if (str2.startsWith("[")) {
                                str2 = str2.substring(1, str2.length() - 1);
                            }
                            map.put("X-Given-IPs", str2);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("url", proxyUrl);
                            if (str2 != null) {
                                jSONObject.put("ip", str2);
                            }
                            String str5 = this.mSessionId;
                            if (str5 != null) {
                                jSONObject.put("traceId", str5);
                            }
                            MediaLoaderWrapper.getDataLoader().setStringValue(8017, jSONObject.toString());
                        } catch (Exception unused) {
                        }
                        return proxyUrl;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareToPlay(String str, String str2, String str3, String str4) {
        int i;
        int i2;
        MediaPlayer mediaPlayer;
        String str_addParamToURL = str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mLogService.mLastPrepareTime = jCurrentTimeMillis;
        if (this.mUuid != null) {
            this.mSessionId = this.mUuid + "." + jCurrentTimeMillis;
        }
        if (str_addParamToURL == null || this.mPlayer == null) {
            return;
        }
        HashMap map = new HashMap();
        if (str4 != null) {
            map.put("Host", String.format(" %s", str4));
        }
        Map<String, String> hTTPHeaders = this.mURLSource.getHTTPHeaders();
        if (hTTPHeaders != null) {
            map.putAll(hTTPHeaders);
        }
        if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
            map.put("suggest_protocol", LiveConfigKey.QUIC);
            if (this.mEnableSaveSCFG) {
                this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS, nr.u(this.mContext).getAbsolutePath() + "/pullstream.scfg");
            }
            if (this.mEnableQuicCertVerify) {
                try {
                    Method method = Class.forName("com.ss.avframework.transport.ContextUtils").getMethod("initApplicationContext", Context.class);
                    method.setAccessible(true);
                    method.invoke(null, this.mContext.getApplicationContext());
                    Method method2 = Class.forName("com.ss.avframework.transport.JNIUtils").getMethod("setClassLoader", ClassLoader.class);
                    method2.setAccessible(true);
                    method2.invoke(null, this.mContext.getClassLoader());
                } catch (Throwable th) {
                    this.mEnableQuicCertVerify = false;
                    k.nr(TAG, "disable quic cert verify, " + th.toString());
                }
            }
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, this.mQuicVersion);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY, this.mEnableQuicCertVerify ? 1 : 0);
            this.mPlayer.setIntOption(357, this.mEnableQuicMTUDiscovery);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU, this.mQuicInitMTU);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, this.mQuicInitRtt);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, this.mQuicMaxCryptoRetransmissions);
            this.mPlayer.setIntOption(390, this.mQuicMaxCryptoRetransmissionTimeMs);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS, this.mQuicMaxRetransmissions);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS, this.mQuicMaxRetransmissionTimeMs);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY, this.mQuicMaxAckDelay);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, this.mQuicMinReceivedBeforeAckDecimation);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, this.mQuicPadHello);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE, this.mQuicFixWillingAndAbleToWrite);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, this.mQuicFixProcessTimer);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT, this.mQuicReadBlockTimeout);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, this.mQuicReadBlockMode);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST, this.mQuicFixStreamFinAndRst);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION, this.mQuicTimerVersion);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, this.mQuicConfigOptimize);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, this.mEnableSkipFlvNullTag);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE, this.mTransportProtocol.equals(LiveConfigKey.QUICU) ? 1 : 0);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, this.mSessionReceiveWindow);
            this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW, this.mStreamReceiveWindow);
            LiveLoggerService liveLoggerService = this.mLogService;
            liveLoggerService.mQuicMtu = this.mQuicInitMTU;
            liveLoggerService.mQuicScfgConfig = this.mEnableSaveSCFG ? 1 : 0;
            liveLoggerService.mQuicPadHello = this.mQuicPadHello;
            liveLoggerService.mQuicTimerVersion = this.mQuicTimerVersion;
        }
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, this.mEnableDecodeMultiSei);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, this.mEnableDecodeSeiOnce);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS, this.mForceDecodeMsGaps);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_SWITCH, this.mForceDecodeSwitch);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, this.mForceRenderMsGaps);
        _configFlvLowLatencyWithSDKParam();
        this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, this.mStartPlayBufferThres);
        this.mLogService.mStartPlayBufferThres = this.mStartPlayBufferThres;
        configPlayerInstanceOption();
        if (this.mPrepareState == PlayerState.PREPARED) {
            this.mPrepareState = PlayerState.INITIALIZED;
            this.mPlayer.reset();
            if (this.mCacheFileEnable == 1 && !TextUtils.isEmpty(this.mCacheFilePath) && !TextUtils.isEmpty(this.mCacheFileKey) && !this.mIsCacheHasComplete) {
                this.mPlayer.setStringOption(17, this.mCacheFileKey);
                this.mPlayer.setIntOption(14, 1);
                this.mPlayer.setCacheFile(this.mCacheFilePath, 1);
            }
        }
        int checkSilenceInterval = this.mURLSource.getCheckSilenceInterval(this.mResolution, this.mLevel);
        this.mLogService.setCheckSilenceInterval(checkSilenceInterval);
        this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, checkSilenceInterval);
        if (this.mResolution.equals("auto")) {
            this.mURLSource.getDefaultResolution();
        }
        LiveLoggerService liveLoggerService2 = this.mLogService;
        liveLoggerService2.mFirstAudioPacketDTS = -1L;
        long j = this.mLatestAudioPacketDTS;
        if (j > 0) {
            liveLoggerService2.mPreviousAudioPacketDTS = j;
        }
        String str5 = this.mResolution;
        liveLoggerService2.mResolution = str5;
        liveLoggerService2.mResBitrate = this.mURLSource.getBitrate(str5.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mLevel);
        if (this.mEnablePreventDTSBack == 1) {
            long j2 = this.mFrameTerminatedDTS;
            if (j2 != -1 && (mediaPlayer = this.mPlayer) != null) {
                mediaPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, j2);
                this.mPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF, this.mFrameDroppingDTSMaxDiff);
            }
        }
        try {
            if (!this.mIsLocalURL) {
                str_addParamToURL = addSessionIdToURL(str_addParamToURL, jCurrentTimeMillis);
            }
            if (this.mStreamFormat.equals(LiveConfigKey.FLV) && (i2 = mFastOpenDuration) != -1) {
                str_addParamToURL = _addParamToURL(str_addParamToURL, "abr_pts", String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2)));
            }
            if (this.mStreamFormat.equals(LiveConfigKey.CMAF)) {
                str_addParamToURL = _addParamToURL(str_addParamToURL, "play_start", "1");
            }
            if (this.mStreamFormat.equals(LiveConfigKey.TSL)) {
                String strSubstring = this.mCurrentPlayURL.substring(this.mCurrentPlayURL.indexOf("TimeShiftFormat=") + 16);
                if (strSubstring.indexOf(ContainerUtils.FIELD_DELIMITER) > 0) {
                    strSubstring = strSubstring.substring(0, strSubstring.indexOf(ContainerUtils.FIELD_DELIMITER));
                }
                int i3 = this.mTslTimeShift;
                if (i3 > 0) {
                    str_addParamToURL = _addParamToURL(str_addParamToURL, strSubstring, String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i3)));
                }
            }
            if (this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                str_addParamToURL = _addParamToURL(str_addParamToURL, "unreliable", "1");
            }
            if (this.mResolution.equals("auto") && this.mEnableResolutionAutoDegrade && this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) && this.mURLSource.getSourceType() == 2 && this.mStreamFormat.equals(LiveConfigKey.FLV)) {
                this.mLogService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
                long j3 = this.mTargetOriginBitRate;
                if (j3 > 0 && this.mURLSource.adjustOriginBitRate(this.mStreamFormat, this.mLevel, j3)) {
                    this.mLogService.mBitRateAbnormalType = 1;
                }
                this.mURLSource.setRequestParamsWithDNSIp("_session_id=" + this.mLogService.mSessionId, str3, str4);
                String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution, this.mStreamFormat, this.mLevel);
                if (playURLForResolution != null) {
                    str_addParamToURL = HTTP_FLV_ABR_PREFIX + playURLForResolution;
                }
                if (playURLForResolution != null) {
                    this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, "llash");
                }
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 1);
                if (this.mShowedFirstFrame && (i = this.mEnableLLASHFastOpen) == 1) {
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN, i);
                }
                int i4 = this.mEnableLiveAbrCheckEnhance;
                if (i4 == 1) {
                    this.mLogService.mEnableLiveAbrCheckEnhance = 1;
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE, i4);
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_INTERVAL, this.mLiveABRCheckInterval);
                }
                int i5 = this.mABRMethod;
                if (i5 >= 0) {
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD, i5);
                }
                int i6 = this.mABRBufferThreshold;
                if (i6 > 0) {
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD, i6);
                }
            }
            String strPrepareProxyURL = prepareProxyURL(str_addParamToURL, str3, str4, map);
            if (strPrepareProxyURL != null) {
                str_addParamToURL = strPrepareProxyURL;
            }
            if (isRtcPlayAvailable()) {
                this.mLogService.mEnableRtcPlay = 1;
                this.mPlayer.setIntOption(801, 1);
                this.mPlayer.setIntOption(802, 1);
                this.mPlayer.setIntOption(803, 3);
                this.mPlayer.setIntOption(804, 1000);
                this.mPlayer.setIntOption(805, 3000);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, this.mRtcFallbackThreshold);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, this.mRtcEnableDtls);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER, this.mRtcMinJitterBuffer);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY, this.mRtcMaxJitterBuffer);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, this.mRtcEarlyInitRender);
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, this.mRtcEnableRtcUninitLockFree);
                if (!this.mLogService.mSessionId.equals("none")) {
                    this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, this.mLogService.mSessionId);
                    LiveLoggerService liveLoggerService3 = this.mLogService;
                    liveLoggerService3.mRtcSessionId = liveLoggerService3.mSessionId;
                }
                if (this.mRtcEnableSDKDns == 1) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("s_expect_ip", str3);
                    this.mLogService.mDnsIp = str3;
                    this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, String.valueOf(jSONObject));
                }
                LiveLoggerService liveLoggerService4 = this.mLogService;
                liveLoggerService4.mCodecName = "";
                liveLoggerService4.mCodecType = "";
                liveLoggerService4.mHardDecodeEnable = false;
                if (this.mRtcSupportMiniSdp != 1) {
                    this.mPlayer.setDataSource(this.mContext, Uri.parse(str2), (Map<String, String>) null);
                    LiveLoggerService liveLoggerService5 = this.mLogService;
                    liveLoggerService5.mRequestUrl = str2;
                    liveLoggerService5.mEnableMiniSdp = 0;
                } else if (str2 != null && str2.startsWith("http://")) {
                    String strReplace = str2.replace("http://", "webrtc://");
                    this.mPlayer.setDataSource(this.mContext, Uri.parse(strReplace), (Map<String, String>) null);
                    LiveLoggerService liveLoggerService6 = this.mLogService;
                    liveLoggerService6.mRequestUrl = strReplace;
                    liveLoggerService6.mEnableMiniSdp = 1;
                }
                this.mLogService.mRequestHeaders = null;
            } else {
                this.mPlayer.setIntOption(800, 0);
                this.mPlayer.setDataSource(this.mContext, Uri.parse(str_addParamToURL), map);
                LiveLoggerService liveLoggerService7 = this.mLogService;
                liveLoggerService7.mRequestUrl = str_addParamToURL;
                liveLoggerService7.mRequestHeaders = map;
            }
            if (this.mEnableRtcPlay == 1 && this.mRtcPlayFallBack == 1) {
                this.mPlayer.setIntOption(59, this.mHardwareDecodeEnable);
                this.mLogService.enableHardDecode(this.mHardwareDecodeEnable == 1);
                if (this.mHardwareDecodeEnable == 1 && this.mDefaultCodecId != -1) {
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, this.mEnableMediaCodecASYNCInit);
                    this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, this.mDefaultCodecId);
                    LiveLoggerService liveLoggerService8 = this.mLogService;
                    liveLoggerService8.mMediaCodecAsyncInit = this.mEnableMediaCodecASYNCInit;
                    liveLoggerService8.mDefaultCodecID = this.mDefaultCodecId;
                }
            }
            int i7 = this.mNetworkTimeout;
            if (i7 != -1 && i7 >= 1000) {
                this.mPlayer.setIntOption(9, i7 * 1000);
                this.mLogService.mNetworkTimeoutMs = this.mNetworkTimeout;
            } else if (i7 != -1) {
                MyLog.e(TAG, "networktimeout so small: " + this.mNetworkTimeout + " microsecond");
                this.mLogService.mNetworkTimeoutMs = 5000;
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                setSurfaceHolder(surfaceHolder);
            } else {
                Surface surface = this.mSurface;
                if (surface != null) {
                    setSurface(surface);
                }
            }
            MediaPlayer mediaPlayer2 = this.mPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setScreenOnWhilePlaying(true);
            }
            if (this.mPrepareState != PlayerState.INITIALIZED) {
                return;
            }
            try {
                this.mPlayer.prepareAsync();
                this.mPrepareState = PlayerState.PREPARING;
            } catch (Exception e) {
                HashMap map2 = new HashMap();
                map2.put("url", str_addParamToURL);
                LiveError liveError = new LiveError(-100001, e.getMessage(), map2);
                if (this.mIsLocalURL) {
                    this.mListener.onError(liveError);
                } else {
                    this.mRetryProcessor.onError(liveError, this.mShowedFirstFrame);
                }
            }
        } catch (Exception e2) {
            HashMap map3 = new HashMap();
            map3.put("url", str_addParamToURL);
            LiveError liveError2 = new LiveError(-100002, e2.getMessage(), map3);
            if (this.mIsLocalURL) {
                this.mListener.onError(liveError2);
            } else {
                this.mRetryProcessor.onError(liveError2, this.mShowedFirstFrame);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnCurrentThread(Runnable runnable) {
        this.mMyHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnCurrentThreadDelay(Runnable runnable, long j) {
        this.mMyHandler.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnFrontCurrentThread(Runnable runnable) {
        this.mMyHandler.postAtFrontOfQueue(runnable);
    }

    private void saveCurrentResolution() {
        LiveLoggerService liveLoggerService;
        if (this.mLivePlayerState == LivePlayerState.IDLE || (liveLoggerService = this.mLogService) == null) {
            return;
        }
        liveLoggerService.mLastResolution = this.mResolution.equals("auto") ? this.mLogService.mAutoUsingResolution : this.mResolution;
    }

    public static void setAppInfo(Context context, Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        AppInfo.mContext = context;
        AppInfo.mAppName = (String) map.get("app_name");
        Object obj = map.get("app_id");
        if (obj != null) {
            AppInfo.mAppID = ((Integer) obj).intValue();
        }
        AppInfo.mAppChannel = (String) map.get("app_channel");
        AppInfo.mAppVersion = (String) map.get("app_version");
        AppInfo.mDeviceId = (String) map.get("device_id");
    }

    public static void setDataLoaderListener(MediaLoaderListener mediaLoaderListener) {
        MediaLoaderWrapper.getDataLoader().setListener(mediaLoaderListener);
    }

    public static void setIntValue(int i, int i2) {
        MediaLoaderWrapper.getDataLoader().setIntValue(i, i2);
    }

    public static void setSettingsParam(Context context, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap map2 = (HashMap) map;
        map2.put("live_pull_sdk_version", Integer.valueOf(LiveUtils.versionStringToInt("1.4.6.31-lite")));
        map2.put("ttm_version", Integer.valueOf(LiveUtils.versionStringToInt(TTPlayerConfiger.getValue(14, ""))));
    }

    public static void startDataLoader(Context context) throws Exception {
        MediaLoaderWrapper.getDataLoader().start();
    }

    private void startStallCounter() {
        synchronized (this.mStallCounterLock) {
            if (this.mStallCounterIsRunning) {
                return;
            }
            if (this.mStallCounterThread == null) {
                HandlerThread handlerThread = new HandlerThread("stallCounter");
                this.mStallCounterThread = handlerThread;
                handlerThread.start();
            }
            if (this.mStallCounterHandler == null) {
                this.mStallCounterHandler = new Handler(this.mStallCounterThread.getLooper());
            }
            this.mStallCounterHandler.post(this.mVideoStallCountTask);
            this.mStallCounterIsRunning = true;
        }
    }

    private void stopStallCounter() {
        synchronized (this.mStallCounterLock) {
            Handler handler = this.mStallCounterHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.mStallCounterIsRunning = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean switchMainAndBackupUrl(int i) {
        if (this.mLevel.equals("main")) {
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, LiveConfigKey.FLV, LiveConfigKey.BACKUP);
            if (playURLForResolution != null) {
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                this.mLogService.onSwitch(this.mCurrentPlayURL, playURLForResolution, "main_to_backup", i);
                this.mLogService.onSwitchURL(playURLForResolution);
                this.mCurrentPlayURL = playURLForResolution;
                this.mLevel = LiveConfigKey.BACKUP;
                _setStreamFormat();
                this.mRetryProcessor.reset();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                this.mRedoDns = true;
                parsePlayDNS(playURLForResolution);
                this.mStallCount = 0;
                return true;
            }
        } else if (this.mLevel.equals(LiveConfigKey.BACKUP)) {
            String playURLForResolution2 = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, LiveConfigKey.FLV, "main");
            if (playURLForResolution2 != null) {
                updateDownloadSizeStat();
                this.mLogService.onSessionStop();
                this.mIsRetrying = true;
                this.mLogService.onSwitch(this.mCurrentPlayURL, playURLForResolution2, "backup_to_main", i);
                this.mLogService.onSwitchURL(playURLForResolution2);
                this.mCurrentPlayURL = playURLForResolution2;
                this.mLevel = "main";
                _setStreamFormat();
                this.mRetryProcessor.reset();
                _resetPlayer();
                this.mSessionStartTime = System.currentTimeMillis();
                this.mRedoDns = true;
                parsePlayDNS(playURLForResolution2);
                this.mStallCount = 0;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadSizeStat() {
        long longOption = this.mPlayer.getLongOption(45, 0L);
        LiveLoggerService liveLoggerService = this.mLogService;
        liveLoggerService.mLastTotalDownloadSize += longOption;
        long j = liveLoggerService.mLastDownloadSizeDelta;
        if (liveLoggerService.mHaveResetPlayer) {
            liveLoggerService.mLastDownloadSizeDelta = longOption + j;
        } else {
            liveLoggerService.mLastDownloadSizeDelta = longOption - liveLoggerService.getPlayingDownloadSize();
            this.mLogService.mHaveResetPlayer = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSessionFirstFrameInfo() {
        MediaPlayer mediaPlayer;
        LogBundle logBundle = this.mLogService.mSessionLogBundle;
        if (logBundle == null || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        logBundle.downloadSpeedOnFirstFrame = (mediaPlayer.getLongOption(63, 0L) * 8) / 1000;
        this.mLogService.mSessionLogBundle.videoBufferTimeOnFirstFrame = this.mPlayer.getLongOption(72, 0L);
        this.mLogService.mSessionLogBundle.audioBufferTimeOnFirstFrame = this.mPlayer.getLongOption(73, 0L);
    }

    public void _setAvLines() {
        String strOptString;
        String strOptString2;
        String avLinesParams = this.mURLSource.getAvLinesParams(this.mResolution, this.mLevel);
        if (avLinesParams == null) {
            return;
        }
        String strOptString3 = null;
        try {
            JSONObject jSONObject = new JSONObject(avLinesParams);
            strOptString2 = jSONObject.has("IsEnable") ? jSONObject.optString("IsEnable") : null;
            try {
                strOptString = jSONObject.has("VideoOnly") ? jSONObject.optString("VideoOnly") : null;
                try {
                    if (jSONObject.has("AudioOnly")) {
                        strOptString3 = jSONObject.optString("AudioOnly");
                    }
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                strOptString = null;
            }
        } catch (JSONException unused3) {
            strOptString = null;
            strOptString2 = null;
        }
        if (strOptString2 != null) {
            this.mEnableAvLines = strOptString2;
        }
        if (strOptString != null) {
            this.mVideoOnly = strOptString;
        }
        if (strOptString3 != null) {
            this.mAudioOnly = strOptString3;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void closeDNS() {
        this.mEnableDns = false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void closeSeiCheck() {
        this.mEnableSeiCheck = false;
        this.mLogService.mEnableSeiCheck = false;
    }

    public boolean disableSR(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            arrayList = (ArrayList) iLiveSettingBundle.getSettingsValueForKey("live_sdk_sr_resolution_block_list", new ArrayList());
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = ((String) it.next()).split("x");
                if (strArrSplit.length < 2) {
                    return false;
                }
                int i3 = Integer.parseInt(strArrSplit[0]);
                int i4 = Integer.parseInt(strArrSplit[1]);
                if (i == i3 && i2 == i4) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void enableSeiCheck() {
        this.mEnableSeiCheck = true;
        this.mLogService.mEnableSeiCheck = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void enableUploadSessionSeries() {
        this.mEnableUploadSessionSeries = true;
        this.mLogService.mEnableUploadSessionSeries = true;
    }

    public void frameDTSNotify(int i, long j, long j2) {
        if (this.mEnableCheckFrame == 1 && i == 0 && this.mResolution.equals("origin")) {
            this.mLogService.feedVideoDTS(j);
        }
        if (i == 1 && this.mEnableDTSCheck == 1) {
            LiveLoggerService liveLoggerService = this.mLogService;
            if (liveLoggerService.mFirstAudioPacketDTS < 0) {
                liveLoggerService.mFirstAudioPacketDTS = j;
            } else {
                long j3 = this.mLatestAudioPacketDTS;
                if (j < j3) {
                    liveLoggerService.onAudioDTSRollback(j3, j);
                }
            }
            this.mLatestAudioPacketDTS = j;
        }
    }

    public int getEnableSR() {
        return this.mEnableTextureSR;
    }

    public int getEnableTexturerender() {
        return this.mEnableTextureRender;
    }

    public long getIntOption(int i, long j) {
        if (i == 0) {
            MediaPlayer mediaPlayer = this.mPlayer;
            return mediaPlayer != null ? (mediaPlayer.getLongOption(63, 0L) * 8) / 1000 : j;
        }
        if (i == 68) {
            MediaPlayer mediaPlayer2 = this.mPlayer;
            return mediaPlayer2 != null ? (mediaPlayer2.getLongOption(63, 0L) * 8) / 1000 : j;
        }
        if (i != 78) {
            return i != 79 ? j : this.mTslMinTimeShit;
        }
        return this.mPlayer != null ? r9.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, 0) : j;
    }

    public void getLastRenderTime() {
        if (this.mIsRetrying || this.mIsStalling) {
            return;
        }
        this.mVideoLastRenderTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, -1L);
        this.mAudioLastRenderTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0402  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getLogInfo(LogBundle logBundle, int i) {
        MediaPlayer mediaPlayer;
        int i2;
        int i3;
        int i4;
        if (logBundle == null || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        logBundle.quicOpenResult = mediaPlayer.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, -1);
        logBundle.quicConfigCached = this.mPlayer.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED, -1);
        logBundle.isTooLargeAVDiff = this.mPlayer.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 0);
        if (i == 0 || i == 2) {
            logBundle.playerDNSTimestamp = this.mPlayer.getLongOption(68, -1L);
            logBundle.tfoFallBackTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, -1L);
            logBundle.dropAudioPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, -1L);
            logBundle.dropAudioCostTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, -1L);
            logBundle.downloadSize = this.mPlayer.getLongOption(45, 0L);
            String str = this.mStreamFormat;
            if (str != null && (str.equals(LiveConfigKey.CMAF) || this.mStreamFormat.equals(LiveConfigKey.AVPH))) {
                logBundle.videoDNSTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, -1L);
                logBundle.audioDNSTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, -1L);
                logBundle.videoTcpConnectTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, -1L);
                logBundle.audioTcpConnectTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, -1L);
                logBundle.audioTcpFirstPacketTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, -1L);
                logBundle.videoTcpFirstPacketTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, -1L);
                logBundle.videoHttpReqFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, -1L);
                logBundle.audioHttpReqFinishTimestamp = this.mPlayer.getLongOption(273, -1L);
                logBundle.videoHttpResFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME, -1L);
                logBundle.audioHttpResFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, -1L);
                if (this.mStreamFormat.equals(LiveConfigKey.CMAF)) {
                    logBundle.cmafMpdDNSTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME, -1L);
                    logBundle.cmafMpdTcpConntectTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, -1L);
                    logBundle.cmafMdpTcpFirstPacketTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, -1L);
                    logBundle.cmafMpdConntectTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME, -1L);
                    logBundle.cmafMdpHttpResFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, -1L);
                    logBundle.cmafAudioFirstSegConntectTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, -1L);
                    logBundle.cmafVideoFirstSegConntectTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, -1L);
                    logBundle.cmafMdpHttpReqFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME, -1L);
                }
            }
            if (isRtcPlayAvailable()) {
                logBundle.rtcInitedTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_INITED_TIME, -1L);
                logBundle.rtcOfferSendTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, -1L);
                logBundle.rtcAnswerRecvTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, -1L);
                logBundle.rtcStartTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, -1L);
            }
            logBundle.tcpConnectTimestamp = this.mPlayer.getLongOption(69, -1L);
            logBundle.tcpFirstPacketTimestamp = this.mPlayer.getLongOption(70, -1L);
            logBundle.videoPacketTimestamp = this.mPlayer.getLongOption(75, -1L);
            logBundle.audioPacketTimestamp = this.mPlayer.getLongOption(76, -1L);
            logBundle.videoDecodeTimestamp = this.mPlayer.getLongOption(77, -1L);
            logBundle.audioDecodeTimestamp = this.mPlayer.getLongOption(78, -1L);
            logBundle.videoDeviceOpenTime = this.mPlayer.getLongOption(155, -1L);
            logBundle.videoDeviceOpenedTime = this.mPlayer.getLongOption(162, -1L);
            logBundle.audioDeviceOpenTime = this.mPlayer.getLongOption(156, -1L);
            logBundle.audioDeviceOpenedTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, -1L);
            logBundle.downloadSpeed = (this.mPlayer.getLongOption(63, 0L) * 8) / 1000;
            logBundle.audioBufferTime = this.mPlayer.getLongOption(73, 0L);
            logBundle.videoBufferTime = this.mPlayer.getLongOption(72, 0L);
            logBundle.resolution = this.mResolution;
            logBundle.videoParamSendOutletTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, 0L);
            logBundle.firstVideoFrameSendOutletTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 0L);
            logBundle.renderType = this.mPlayer.getVideoType();
            logBundle.streamInfoFindTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 0L);
            logBundle.streamInfoFoundTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME, 0L);
            logBundle.videoDeviceWaitStartTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 0L);
            logBundle.videoDeviceWaitEndTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 0L);
            logBundle.videoFirstPacketPos = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, -1L);
            logBundle.videoFirstPacketPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, -1L);
            logBundle.audioFirstPacketPos = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS, -1L);
            logBundle.audioFirstPacketPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, -1L);
            logBundle.httpReqFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 0L);
            logBundle.httpResFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME, 0L);
            if (i == 0) {
                logBundle.tfoSuccess = this.mPlayer.getIntOption(518, -1);
                logBundle.downloadSpeedOnFirstFrame = logBundle.downloadSpeed;
                logBundle.videoBufferTimeOnFirstFrame = logBundle.videoBufferTime;
                logBundle.audioBufferTimeOnFirstFrame = logBundle.audioBufferTime;
                logBundle.dnsIP = this.mDnsParser.getDNSServerIP();
                logBundle.videoRenderTimeForPlayerCore = this.mPlayer.getLongOption(210, -1L);
                logBundle.videoRenderTimestamp = System.currentTimeMillis();
                parseResponseHeaders(logBundle);
            }
            if (!this.mHasRetry && i == 2) {
                logBundle.waitingTimeAfterFirstFrame = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 0L);
            }
            if (i == 0) {
                MediaPlayer mediaPlayer2 = this.mPlayer;
                i2 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT;
                i3 = -1;
                logBundle.quicFirstFrameCHLOCount = mediaPlayer2.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT, -1);
            }
            i4 = logBundle.quicFirstFrameCHLOCount;
            if (i4 == i3) {
                logBundle.quicCHLOCount = i4;
                return;
            } else {
                logBundle.quicCHLOCount = this.mPlayer.getIntOption(i2, i3);
                return;
            }
        }
        if (i == 1) {
            logBundle.downloadSize = this.mPlayer.getLongOption(45, 0L);
            logBundle.playedSize = this.mPlayer.getLongOption(46, 0L);
            logBundle.fps = this.mPlayer.getFloatOption(150, 0.0f);
            logBundle.downloadSpeed = (this.mPlayer.getLongOption(63, 0L) * 8) / 1000;
            logBundle.audioBufferTime = this.mPlayer.getLongOption(73, 0L);
            logBundle.videoBufferTime = this.mPlayer.getLongOption(72, 0L);
            logBundle.currentPosition = this.mPlayer.getCurrentPosition();
            logBundle.playTime = System.currentTimeMillis();
            logBundle.dnsIP = this.mDnsParser.getDNSServerIP();
            logBundle.resolution = this.mResolution;
            if (isRtcPlayAvailable()) {
                String stringOption = this.mPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STAT_INFO);
                logBundle.rtcStatInfo = stringOption;
                addRtcCodecInfo(stringOption);
            }
        } else if (i == 3) {
            logBundle.fps = this.mPlayer.getFloatOption(150, 0.0f);
            logBundle.downloadSpeed = (this.mPlayer.getLongOption(63, 0L) * 8) / 1000;
            logBundle.audioBufferTime = this.mPlayer.getLongOption(73, 0L);
            logBundle.resolution = this.mResolution;
        } else if (i == 4) {
            logBundle.audioBufferTime = this.mPlayer.getLongOption(73, 0L);
            logBundle.videoBufferTime = this.mPlayer.getLongOption(72, 0L);
        } else if (i == 5) {
            logBundle.audioBufferTimeOnStallStart = this.mPlayer.getLongOption(73, -1L);
            logBundle.videoBufferTimeOnStallStart = this.mPlayer.getLongOption(72, -1L);
        } else if (i == 6) {
            logBundle.audioBufferTimeOnStallEnd = this.mPlayer.getLongOption(73, -1L);
            logBundle.videoBufferTimeOnStallEnd = this.mPlayer.getLongOption(72, -1L);
        } else if (i == 7) {
            int intOption = this.mPlayer.getIntOption(61, -1);
            int intOption2 = this.mPlayer.getIntOption(62, -1);
            if (intOption == 1) {
                if (intOption2 == 1) {
                    logBundle.mStreamType = 2;
                } else {
                    logBundle.mStreamType = 1;
                }
            } else if (intOption2 == 1) {
                logBundle.mStreamType = 0;
            }
        } else if (i == 8) {
            String stringOption2 = this.mPlayer.getStringOption(147);
            if (stringOption2 != null) {
                logBundle.mABRStreamInfo = formatABRStreamInfoToJSONArray(stringOption2);
            }
        } else if (i == 9) {
            String stringOption3 = this.mPlayer.getStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO);
            if (!TextUtils.isEmpty(stringOption3)) {
                logBundle.avphStreamInfo = formatAVPHStreamInfoToJSONArray(stringOption3);
            }
        }
        i2 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT;
        i3 = -1;
        i4 = logBundle.quicFirstFrameCHLOCount;
        if (i4 == i3) {
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getMaxVolume() {
        return this.mPlayerSetting.getMaxVolume();
    }

    public long getNtpTimeDiff() {
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            return ((Long) iLiveSettingBundle.getSettingsValueForKey("time_diff_server_and_client", 0L)).longValue();
        }
        return 0L;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getPlayerErrorInfo() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null ? mediaPlayer.getStringOption(5002) : "none";
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getPlayerVolume() {
        return this.mPlayerSetting.getPlayerVolume();
    }

    public boolean getSRState() {
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public long getSeiDelay() {
        return this.mLogService.getInt64Value(100, 0L);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getServerIP() {
        return this.mCurrentIP;
    }

    public void getSessionlogInfo(LogBundle logBundle) {
        MediaPlayer mediaPlayer;
        if (logBundle == null || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        logBundle.playerDNSTimestamp = mediaPlayer.getLongOption(68, -1L);
        logBundle.tfoFallBackTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME, -1L);
        logBundle.dropAudioPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, -1L);
        logBundle.dropAudioCostTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, -1L);
        logBundle.tcpConnectTimestamp = this.mPlayer.getLongOption(69, -1L);
        logBundle.tcpFirstPacketTimestamp = this.mPlayer.getLongOption(70, -1L);
        logBundle.videoPacketTimestamp = this.mPlayer.getLongOption(75, -1L);
        logBundle.audioPacketTimestamp = this.mPlayer.getLongOption(76, -1L);
        logBundle.videoDecodeTimestamp = this.mPlayer.getLongOption(77, -1L);
        logBundle.audioDecodeTimestamp = this.mPlayer.getLongOption(78, -1L);
        logBundle.videoDeviceOpenTime = this.mPlayer.getLongOption(155, -1L);
        logBundle.videoDeviceOpenedTime = this.mPlayer.getLongOption(162, -1L);
        logBundle.audioDeviceOpenTime = this.mPlayer.getLongOption(156, -1L);
        logBundle.audioDeviceOpenedTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, -1L);
        logBundle.downloadSpeed = (this.mPlayer.getLongOption(63, 0L) * 8) / 1000;
        logBundle.audioBufferTime = this.mPlayer.getLongOption(73, 0L);
        logBundle.videoBufferTime = this.mPlayer.getLongOption(72, 0L);
        logBundle.resolution = this.mResolution;
        logBundle.videoParamSendOutletTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME, 0L);
        logBundle.firstVideoFrameSendOutletTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 0L);
        logBundle.renderType = this.mPlayer.getVideoType();
        logBundle.streamInfoFindTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 0L);
        logBundle.streamInfoFoundTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME, 0L);
        logBundle.videoDeviceWaitStartTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 0L);
        logBundle.videoDeviceWaitEndTime = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 0L);
        logBundle.videoFirstPacketPos = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, -1L);
        logBundle.videoFirstPacketPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, -1L);
        logBundle.audioFirstPacketPos = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS, -1L);
        logBundle.audioFirstPacketPts = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, -1L);
        logBundle.httpReqFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 0L);
        logBundle.httpResFinishTimestamp = this.mPlayer.getLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME, 0L);
        logBundle.downloadSize = this.mPlayer.getLongOption(45, 0L);
    }

    public boolean getSharpenState() {
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public JSONObject getStaticLog() {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService == null) {
            return null;
        }
        return liveLoggerService.getStaticLog();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public String getStringOption(int i, String str) {
        return i != 57 ? i != 58 ? i != 60 ? i != 65 ? str : this.mAbrStrategy : this.mStreamFormat : this.mResolution : this.mCurrentPlayURL;
    }

    public int getUrlSettingMethod() {
        return this.mUrlSettingMethod;
    }

    public void getVideoCodecType() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || this.mLogService == null) {
            return;
        }
        int intOption = mediaPlayer.getIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, -1);
        if (intOption == 0) {
            this.mLogService.setCodecType("h264");
        } else if (intOption == 1) {
            this.mLogService.setCodecType("bytevc1");
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public float getVolume() {
        return this.mPlayerSetting.getVolume();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isIPPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.getPlayerType() == 2;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isOsPlayer() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isOSPlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public boolean isRtcPlayAvailable() {
        return this.mEnableRtcPlay == 1 && this.mRtcPlayFallBack == 0;
    }

    public boolean isUsedSR() {
        return false;
    }

    public boolean isUsedSharpen() {
        return false;
    }

    public JSONObject liveInfoItems() {
        try {
            JSONObject liveInfoItems = this.mLogService.getLiveInfoItems();
            liveInfoItems.put("get_live_info_iterms", "OK");
            return liveInfoItems;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void onRenderStallForRetryStop() {
        if ((this.mIsStalling || this.mIsRetrying) && this.mEnableRenderStall == 1) {
            if (this.mAudioLastRenderTime != -1) {
                this.mLogService.onRenderStall((int) (System.currentTimeMillis() - this.mAudioLastRenderTime), 0, false, false);
            }
            if (this.mVideoLastRenderTime != -1) {
                this.mLogService.onRenderStall((int) (System.currentTimeMillis() - this.mVideoLastRenderTime), 0, true, false);
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void openNTP() {
        this.mEnableNTPTask = 1;
        this.mLogService.openNTP();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void pause() {
        checkMainLooper("pause");
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mLivePlayerState = LivePlayerState.PAUSED;
        this.mPlayer.pause();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0174  */
    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void play() {
        String playURLForResolution;
        String str;
        this.mListener.onReportALog(4, "play start -- " + hashCode());
        checkMainLooper("play");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        LivePlayerState livePlayerState2 = LivePlayerState.PLAYED;
        if (livePlayerState == livePlayerState2) {
            this.mLogService.onIllegalAPICall("play");
            this.mListener.onReportALog(6, "illegal call: play -- " + hashCode());
            return;
        }
        if (livePlayerState == LivePlayerState.PAUSED) {
            this.mLivePlayerState = livePlayerState2;
            MediaPlayer mediaPlayer = this.mPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                return;
            }
            return;
        }
        if (this.mURLSource.getSourceType() == 2) {
            _configAbrInfo();
            _setStreamFormat();
            _setProtocol();
            _checkStreamData();
        }
        ILiveSettingBundle iLiveSettingBundle = this.mSettingsBundle;
        if (iLiveSettingBundle != null) {
            this.mURLSource.setEnableSR(((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_super_resolution_enable", 0)).intValue());
            setIntOption(69, ((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_texture_render_enable", 0)).intValue());
            if (((Integer) this.mSettingsBundle.getSettingsValueForKey("live_sdk_sharpen_enable", 0)).intValue() == 1) {
                JSONObject sharpenParams = this.mURLSource.getSharpenParams(this.mResolution, this.mLevel);
                this.mSharpenSdkParams = sharpenParams;
                if (sharpenParams != null) {
                    this.mEnableSharpen = sharpenParams.optInt("Enabled");
                }
            }
        }
        setIntOption(70, this.mURLSource.getSREnabled(this.mResolution, this.mLevel) ? 1 : 0);
        this.mLivePlayerState = livePlayerState2;
        this.mFrameTerminatedDTS = -1L;
        this.mLatestAudioPacketDTS = -1L;
        LiveInfoSource liveInfoSource = this.mURLSource;
        if (liveInfoSource == null) {
            playURLForResolution = null;
        } else if (liveInfoSource.getSourceType() == 1 && this.mURLSource.getPlayLiveURL() != null) {
            playURLForResolution = this.mURLSource.getPlayLiveURL().mainURL;
            String str2 = this.mIsLocalURL ? this.mLocalURL : playURLForResolution;
            if (str2 != null) {
                if (str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.mTransportProtocol = LiveConfigKey.TCP;
                }
                if (str2.startsWith(BaseConstants.SCHEME_HTTPS)) {
                    this.mTransportProtocol = LiveConfigKey.TLS;
                }
                if (str2.startsWith("httpk")) {
                    this.mTransportProtocol = LiveConfigKey.KCP;
                }
                this.mURLProtocol = this.mTransportProtocol;
            }
            if (this.mQuicPull) {
                try {
                    LibraryLoader.loadLibrary("ttquic");
                    this.mQuicEnable = true;
                    this.mLogService.setQuicLibLoader(1);
                    str = LiveConfigKey.QUIC;
                } catch (Throwable unused) {
                    str = this.mTransportProtocol;
                    this.mQuicEnable = false;
                    this.mLogService.setQuicLibLoader(0);
                }
            } else {
                str = "";
            }
            if (str.isEmpty()) {
                str = this.mTransportProtocol;
            }
            this.mTransportProtocol = str;
        } else if (this.mURLSource.getSourceType() == 2) {
            playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
        }
        if (this.mIsLocalURL) {
            playURLForResolution = this.mLocalURL;
        }
        if (playURLForResolution != null) {
            String sessionID = this.mURLSource.getSessionID();
            this.mUuid = sessionID;
            if (TextUtils.isEmpty(sessionID)) {
                this.mUuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            }
            this.mLogService.setProtocolInfo(this.mSuggestProtocol, this.mTransportProtocol);
            this.mLogService.reset();
            this.mLogService.mSessionId = this.mUuid + "." + System.currentTimeMillis();
            this.mLogService.mRuleIds = this.mURLSource.getRuleIds();
            LiveLoggerService liveLoggerService = this.mLogService;
            liveLoggerService.mResolution = this.mResolution;
            liveLoggerService.mAutoUsingResolution = this.mURLSource.getDefaultResolution();
            this.mLogService.onPlay(this.mIsLocalURL ? this.mLocalURL : playURLForResolution, this.mDnsParser.getDNSServerIP());
            _play(playURLForResolution);
            this.mRetryProcessor.start();
        } else {
            HashMap map = new HashMap();
            map.put("url", "no playurl found while play");
            this.mRetryProcessor.onError(new LiveError(-100002, "playURL is null", map), this.mShowedFirstFrame);
        }
        if (this.mEnableStallCounter == 1) {
            startStallCounter();
        }
        this.mListener.onReportALog(4, "play end -- " + hashCode());
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public boolean playResolution(String str) {
        checkMainLooper("playResolution");
        if (this.mURLSource.getSourceType() != 2 || this.mPrepareState != PlayerState.PREPARED) {
            return false;
        }
        if (this.mResolution.equals(str)) {
            return true;
        }
        this.mRetryProcessor.reset();
        this.mResolutionIndex = -1;
        this.mStallCount = 0;
        this.mLogService.onSwitch(this.mCurrentPlayURL, "none", "setting_" + this.mResolution + "_to_" + str, 0);
        this.mLogService.mAbrSwitchInfo = "manual_abr_" + this.mResolution + "_to_" + str;
        saveCurrentResolution();
        this.mResolution = str;
        if (this.mAbrStrategy.equals(LiveConfigKey.ABR_BB_4LIVE) || (this.mAbrStrategy.equals(LiveConfigKey.RAD) && !str.equals("auto"))) {
            String playURLForResolution = this.mURLSource.getPlayURLForResolution(this.mResolution.equals("auto") ? this.mURLSource.getDefaultResolution() : this.mResolution, this.mStreamFormat, this.mLevel);
            if (TextUtils.isEmpty(playURLForResolution)) {
                return false;
            }
            updateDownloadSizeStat();
            this.mLogService.onSessionStop();
            this.mIsRetrying = true;
            _stopPlayer();
            _resetPlayer();
            this.mLogService.onSwitchURL(playURLForResolution);
            this.mUserSwitchResoultion = true;
            this.mLogService.mSessionStartTime = System.currentTimeMillis();
            parsePlayDNS(playURLForResolution);
        }
        return true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void release() {
        this.mListener.onReportALog(4, "release start -- " + hashCode());
        checkMainLooper("release");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            _stop(true, "release");
        }
        releaseTextureRenderRef();
        this.mExecutor.shutdown();
        this.mMyHandler.removeCallbacksAndMessages(null);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.release();
        this.mPlayer = null;
        this.mLogService.reset();
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        this.mListener.onReportALog(4, "release end -- " + hashCode());
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void releaseAsync() {
        this.mListener.onReportALog(4, "releaseAsync start -- " + hashCode());
        checkMainLooper("releaseAsync");
        LivePlayerState livePlayerState = this.mLivePlayerState;
        if (livePlayerState == LivePlayerState.PLAYED || livePlayerState == LivePlayerState.PAUSED) {
            _stop(false, "releaseAsync");
        }
        this.mExecutor.shutdown();
        this.mMyHandler.removeCallbacksAndMessages(null);
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (this.mSurfaceHolder != null) {
            mediaPlayer.setDisplay(null);
        }
        releaseTextureRenderRef();
        MediaPlayer mediaPlayer2 = this.mPlayer;
        this.mPlayer = null;
        this.mLogService.reset();
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        LiveThreadPool.addExecuteTask(new MyReleaseRunnable(mediaPlayer2));
        this.mListener.onReportALog(4, "releaseAsync end -- " + hashCode());
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void reset() {
        checkMainLooper("reset");
        if (this.mPlayer == null) {
            return;
        }
        _reset("reset");
        this.mLogService.reset();
        this.mCacheFileKey = null;
        this.mCacheFilePath = null;
        this.mEnableResolutionAutoDegrade = false;
        this.mEnableOriginResolution = false;
        this.mEnableSwitchMainAndBackupUrl = true;
        this.mEnableTextureSR = 0;
        this.mEnableTextureRender = 0;
        this.mTextureSRMode = 0;
        this.mResolution = "origin";
        this.mResolutionIndex = -1;
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mSuggestProtocol = "none";
        this.mLevel = "main";
        this.mLocalURL = null;
        this.mIsLocalURL = false;
        this.mEnableHurryFlag = 0;
        this.mHurryType = -1;
        this.mEnableAvLines = "";
        this.mEnableSaveSCFG = false;
        this.mShowedFirstFrame = false;
        this.mEnableLLASHFastOpen = 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setAsyncInit(int i) {
        String.format("setAsyncInit enable:%b", Integer.valueOf(i));
        this.mEnableMediaCodecASYNCInit = i;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setCommonFlag(String str) {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService != null) {
            liveLoggerService.setCommonFlag(str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setDisableVideoRender(Boolean bool) {
        MediaPlayer mediaPlayer;
        this.mLogService.mDisableVideoRender = bool.booleanValue() ? 1 : 0;
        if (this.mEnableRadioLiveDisableRender != 1 || (mediaPlayer = this.mPlayer) == null) {
            return;
        }
        mediaPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, bool.booleanValue() ? 1 : 0);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setFloatOption(int i, float f) {
        if (i == 19) {
            if (this.mEnableLowLatencyFLV != 1) {
                this.mCatchSpeed = f;
                MediaPlayer mediaPlayer = this.mPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.setFloatOption(80, f);
                    this.mLogService.mCatchSpeed = f;
                    return;
                }
                return;
            }
            return;
        }
        if (i == 20 && this.mEnableLowLatencyFLV != 1) {
            this.mSlowPlaySpeed = f;
            MediaPlayer mediaPlayer2 = this.mPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setFloatOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, f);
                this.mLogService.mSlowSpeed = f;
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setIntOption(int i, int i2) {
        switch (i) {
            case 1:
                this.mEnhancementType = i2;
                MediaPlayer mediaPlayer = this.mPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.setIntOption(37, i2);
                }
                break;
            case 2:
                this.mScaleType = i2;
                MediaPlayer mediaPlayer2 = this.mPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.setIntOption(38, i2);
                }
                break;
            case 3:
                TTPlayerConfiger.setValue(11, i2);
                break;
            case 4:
                this.mLayoutType = i2;
                MediaPlayer mediaPlayer3 = this.mPlayer;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.setIntOption(36, i2);
                }
                break;
            case 5:
                this.mRenderType = i2;
                MediaPlayer mediaPlayer4 = this.mPlayer;
                if (mediaPlayer4 != null) {
                    mediaPlayer4.setIntOption(56, i2);
                }
                break;
            case 7:
                this.mHardwareDecodeEnable = i2;
                MediaPlayer mediaPlayer5 = this.mPlayer;
                if (mediaPlayer5 != null) {
                    mediaPlayer5.setIntOption(59, i2);
                }
                break;
            case 8:
                this.mCacheFileEnable = i2;
                MediaPlayer mediaPlayer6 = this.mPlayer;
                if (mediaPlayer6 != null) {
                    mediaPlayer6.setIntOption(14, 1);
                }
                break;
            case 9:
                this.mByteVC1DecoderType = i2;
                MediaPlayer mediaPlayer7 = this.mPlayer;
                if (mediaPlayer7 != null) {
                    mediaPlayer7.setIntOption(67, i2);
                }
                break;
            case 10:
                this.mBufferDataSeconds = i2;
                MediaPlayer mediaPlayer8 = this.mPlayer;
                if (mediaPlayer8 != null) {
                    mediaPlayer8.setIntOption(86, i2);
                }
                break;
            case 11:
                this.mBufferTimeout = i2;
                MediaPlayer mediaPlayer9 = this.mPlayer;
                if (mediaPlayer9 != null) {
                    mediaPlayer9.setIntOption(81, i2);
                }
                break;
            case 12:
                this.mNetworkTimeout = i2;
                MediaPlayer mediaPlayer10 = this.mPlayer;
                if (mediaPlayer10 != null) {
                    mediaPlayer10.setIntOption(9, i2 * 1000000);
                }
                break;
            case 15:
                this.mUseExternalDir = i2;
                break;
            case 16:
                this.mTestAction = i2;
                MediaPlayer mediaPlayer11 = this.mPlayer;
                if (mediaPlayer11 != null) {
                    mediaPlayer11.setIntOption(83, i2);
                }
                break;
            case 17:
                if (this.mEnableLowLatencyFLV != 1) {
                    this.mHurryTime = i2;
                    MediaPlayer mediaPlayer12 = this.mPlayer;
                    if (mediaPlayer12 != null) {
                        mediaPlayer12.setIntOption(15, i2);
                        this.mLogService.mHurryTime = i2;
                    }
                }
                break;
            case 18:
                this.mHurryType = i2;
                MediaPlayer mediaPlayer13 = this.mPlayer;
                if (mediaPlayer13 != null) {
                    mediaPlayer13.setIntOption(84, i2);
                }
                break;
            case 21:
                if (this.mEnableLowLatencyFLV != 1) {
                    this.mSlowPlayTime = i2;
                    MediaPlayer mediaPlayer14 = this.mPlayer;
                    if (mediaPlayer14 != null) {
                        mediaPlayer14.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, i2);
                        this.mLogService.mSlowPlayTime = i2;
                    }
                }
                break;
            case 22:
                this.mOpenCheckSideData = i2;
                MediaPlayer mediaPlayer15 = this.mPlayer;
                if (mediaPlayer15 != null) {
                    mediaPlayer15.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, i2);
                }
                break;
            case 25:
                this.mPlayerDegradeMode = i2;
                break;
            case 31:
                this.mURLAbility = i2;
                if (i2 == 1) {
                    this.mLogService.mUrlAbility = "h264";
                } else if (i2 == 2) {
                    this.mLogService.mUrlAbility = "bytevc1";
                }
                break;
            case 32:
                this.mEnableSharp = i2;
                break;
            case 33:
                this.mEnableMediaCodecASYNCInit = i2;
                MediaPlayer mediaPlayer16 = this.mPlayer;
                if (mediaPlayer16 != null && this.mHardwareDecodeEnable == 1) {
                    mediaPlayer16.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, i2);
                    this.mLogService.mMediaCodecAsyncInit = i2;
                    break;
                }
                break;
            case 34:
                this.mDefaultCodecId = i2;
                MediaPlayer mediaPlayer17 = this.mPlayer;
                if (mediaPlayer17 != null) {
                    mediaPlayer17.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, i2);
                    this.mLogService.mDefaultCodecID = i2;
                }
                break;
            case 35:
                this.mEnableH264HardwareDecode = i2;
                break;
            case 36:
                this.mEnableByteVC1HardwareDecode = i2;
                break;
            case 37:
                this.mMaxCacheSeconds = i2;
                MediaPlayer mediaPlayer18 = this.mPlayer;
                if (mediaPlayer18 != null) {
                    mediaPlayer18.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, i2);
                    this.mLogService.mMaxCacheSeconds = i2;
                }
                break;
            case 38:
                this.mEnableSplitStream = i2;
                MediaPlayer mediaPlayer19 = this.mPlayer;
                if (mediaPlayer19 != null) {
                    mediaPlayer19.setIntOption(87, i2);
                    this.mLogService.mEnableSplitStream = i2;
                }
                break;
            case 39:
                this.mEnableHttpkDegrade = i2;
                break;
            case 40:
                this.mEnableFastOpenStream = i2;
                break;
            case 41:
                this.mEnableUploadSei = i2;
                break;
            case 42:
                this.mEnableNTPTask = i2;
                break;
            case 44:
                this.mIsInMainLooper = i2;
                break;
            case 46:
                this.mCheckBufferingEndIgnoreVideo = i2;
                MediaPlayer mediaPlayer20 = this.mPlayer;
                if (mediaPlayer20 != null) {
                    mediaPlayer20.setIntOption(310, i2);
                    this.mLogService.mCheckBufferingEndIgnoreVideo = i2;
                }
                break;
            case 47:
                this.mStartDirectAfterPrepared = i2;
                MediaPlayer mediaPlayer21 = this.mPlayer;
                if (mediaPlayer21 != null) {
                    mediaPlayer21.setIntOption(311, i2);
                    this.mLogService.mStartDirectAfterPrepared = i2;
                }
                break;
            case 48:
                this.mEnableOpenMDL = i2;
                break;
            case 54:
                this.mCheckBufferingEndAdvanceEnable = i2;
                MediaPlayer mediaPlayer22 = this.mPlayer;
                if (mediaPlayer22 != null) {
                    mediaPlayer22.setIntOption(313, i2);
                    this.mLogService.mCheckBufferingEndAdvanceEnable = i2;
                }
                break;
            case 55:
                this.mStallCountThresOfResolutionDegrade = i2;
                break;
            case 56:
                this.mEnableResolutionAutoDegrade = i2 == 1;
                break;
            case 61:
                this.mEnableTcpFastOpen = i2;
                MediaPlayer mediaPlayer23 = this.mPlayer;
                if (mediaPlayer23 != null) {
                    mediaPlayer23.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, i2);
                }
                break;
            case 62:
                this.mEnableCheckPacketCorrupt = i2;
                MediaPlayer mediaPlayer24 = this.mPlayer;
                if (mediaPlayer24 != null) {
                    mediaPlayer24.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, i2);
                }
                break;
            case 67:
                this.mEnableFlvABR = i2;
                break;
            case 69:
                this.mEnableTextureRender = i2;
                break;
            case 70:
                this.mEnableTextureSR = i2;
                break;
            case 77:
                this.mTslTimeShift = i2;
                this.mLogService.mTslTimeShift = i2;
                break;
            case 80:
                this.mSwitchToB = i2;
                break;
            case 82:
                this.mEnableDecodeMultiSei = i2;
                break;
            case 83:
                this.mHurryTime = i2;
                MediaPlayer mediaPlayer25 = this.mPlayer;
                if (mediaPlayer25 != null) {
                    mediaPlayer25.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, i2);
                    this.mLogService.mHurryTime = i2;
                }
                break;
            case 84:
                this.mSlowPlayTime = i2;
                MediaPlayer mediaPlayer26 = this.mPlayer;
                if (mediaPlayer26 != null) {
                    mediaPlayer26.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, i2);
                    this.mLogService.mSlowPlayTime = i2;
                }
                break;
            case 85:
                this.mEnableFreeFlow = i2;
                break;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLocalURL(String str) {
        checkMainLooper("setLocalURL");
        if (str != null && !str.equals(this.mLocalURL) && this.mLocalURL != null) {
            reset();
        }
        this.mLocalURL = str;
        this.mIsLocalURL = true;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLongOption(int i, long j) {
        if (i != 45) {
            if (i != 59) {
                return;
            }
            this.mALogWriteAddr = j;
            return;
        }
        this.mStartPlayBufferThres = j;
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null || j <= 0) {
            return;
        }
        mediaPlayer.setLongOption(MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES, j);
        this.mLogService.mStartPlayBufferThres = j;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setLooping(boolean z) {
        this.mLooping = z;
        if (this.mPlayer == null || !this.mIsLocalURL || TextUtils.isEmpty(this.mLocalURL)) {
            return;
        }
        this.mPlayer.setLooping(this.mLooping);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setMute(Boolean bool) {
        this.mPlayerSetting.setMute(bool.booleanValue());
        this.mLogService.mMuteAudio = bool.booleanValue() ? 1 : 0;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPlayURLs(LiveURL[] liveURLArr) {
        checkMainLooper("setPlayURLS");
        this.mURLSource.setPlayURLs(liveURLArr);
        this.mUrlSettingMethod = 0;
        if (this.mCurrentPlayURL == null || this.mURLSource.getPlayLiveURL().mainURL == this.mCurrentPlayURL) {
            return;
        }
        _reset("setPlayURLs");
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPlayerVolume(float f) {
        this.mPlayerSetting.setPlayerVolume(f);
        this.mLogService.mPlayerVolumeSetting = f;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setPreviewFlag(boolean z) {
        LiveLoggerService liveLoggerService = this.mLogService;
        if (liveLoggerService != null) {
            liveLoggerService.setPreviewFlag(z);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setProjectKey(String str) {
        this.mLogService.setProjectKey(str);
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setStreamInfo(String str) {
        JSONObject jSONObject;
        this.mLogService.mStreamData = str;
        checkMainLooper("setStreamInfo");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        _reset("setStreamInfo");
        this.mURLSource.setStreamInfo(new LiveStreamInfo(jSONObject));
        this.mUrlSettingMethod = 1;
        _setLooseSync();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setStringOption(int i, String str) {
        LiveInfoSource liveInfoSource;
        if (i == 26) {
            this.mCacheFilePath = str;
            if (this.mPlayer != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                String string = sb.toString();
                this.mCacheFileKey = string;
                this.mPlayer.setStringOption(17, string);
                this.mPlayer.setIntOption(14, 1);
                this.mPlayer.setCacheFile(str, 1);
                return;
            }
            return;
        }
        if (i == 43) {
            saveCurrentResolution();
            this.mResolution = str;
            if (this.mPlayer == null || (liveInfoSource = this.mURLSource) == null || liveInfoSource.getSourceType() != 2) {
                return;
            }
            long bitrate = this.mURLSource.getBitrate(this.mResolution, this.mLevel);
            if (bitrate > 0) {
                this.mPlayer.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, (int) bitrate);
                this.mLogService.mUseExpectBitrate = 1;
                return;
            }
            return;
        }
        if (i == 60) {
            this.mStreamFormat = str;
            this.mLogService.setFormatInfo(str, str);
            if (this.mPlayer != null) {
                if (this.mStreamFormat.equals(LiveConfigKey.AVPH) || this.mStreamFormat.equals(LiveConfigKey.CMAF)) {
                    this.mPlayer.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, str);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 81) {
            this.mMoudleIDToB = str;
            return;
        }
        if (i == 86) {
            this.mCdnAbrResolution = str;
            _requestSwitchUrlFromServer();
            return;
        }
        if (i == 89) {
            this.mURLHost = str;
            return;
        }
        switch (i) {
            case 63:
                this.mLogService.mEnterMethod = str;
                break;
            case 64:
                this.mLogService.mEnterAction = str;
                break;
            case 65:
                this.mAbrStrategy = str;
                break;
            case 66:
                if (str.equals(LiveConfigKey.TCP) || str.equals(LiveConfigKey.QUIC)) {
                    this.mTransportProtocol = str;
                }
                this.mQuicPull = true;
                break;
            default:
                switch (i) {
                    case 72:
                        this.mTextureSRBinPath = str;
                        break;
                    case 73:
                        this.mTextureSROclModuleName = str;
                        break;
                    case 74:
                        this.mTextureSRDspModuleName = str;
                        break;
                }
                break;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setSurface(Surface surface) {
        checkMainLooper("setSurface");
        this.mSurface = surface;
        if (this.mPlayer != null) {
            this.mLogService.mSetSurfaceTime = System.currentTimeMillis();
            this.mPlayer.setSurface(surface);
            this.mLogService.mSetSurfaceCost = System.currentTimeMillis() - this.mLogService.mSetSurfaceTime;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        checkMainLooper("setSurfaceHolder");
        this.mSurfaceHolder = surfaceHolder;
        if (this.mPlayer != null) {
            this.mLogService.mSetSurfaceTime = System.currentTimeMillis();
            this.mPlayer.setDisplay(surfaceHolder);
            this.mLogService.mSetSurfaceCost = System.currentTimeMillis() - this.mLogService.mSetSurfaceTime;
        }
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setVideoFormat(String str) {
        this.mStreamFormat = str;
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void setVolume(float f) {
        this.mPlayerSetting.setVolume(f);
        this.mLogService.mVolumeSetting = f;
    }

    public String set_url_port_scheme(String str, String str2) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf(".com");
        int iIndexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            if (iIndexOf3 != -1) {
                int i = iIndexOf3 + 5;
                int i2 = i + 1;
                while (i2 < sb.length() && sb.charAt(i2) - '0' >= 0 && sb.charAt(i2) - '0' <= 9) {
                    i2++;
                }
                sb.replace(i, i2, str2);
            } else if (iIndexOf2 != -1 && ((iIndexOf = str.indexOf("vhost")) == -1 || iIndexOf > iIndexOf2)) {
                sb.insert(iIndexOf2 + 4, ":" + str2);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int iIndexOf4 = sb2.indexOf("://");
        if (this.mURLSource.getSourceType() == 2) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, BaseConstants.SCHEME_HTTPS);
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && iIndexOf4 != -1) {
                sb2.replace(0, iIndexOf4, HttpHost.DEFAULT_SCHEME_NAME);
            }
        }
        return sb2.toString();
    }

    @Override // com.bykv.vk.component.ttvideo.ILivePlayer
    public void stop() {
        this.mListener.onReportALog(4, "stop start -- " + hashCode());
        checkMainLooper("stop");
        _stop(true, "stop");
        this.mRetryProcessor.stop();
        this.mListener.onReportALog(4, "stop end-- " + hashCode());
    }

    public void updateFrameTerminatedDTS(int i, long j, long j2) {
        this.mFrameTerminatedDTS = j;
    }

    private VideoLiveManager(Builder builder) {
        ExecutorService executorService;
        this.mMyHandler = new Handler(Looper.myLooper());
        this.mURLSource = new LiveInfoSource();
        this.mEnableTextureRender = 0;
        this.mEnableTextureSR = 0;
        this.mResolutionDisableSR = true;
        this.mTextureSRBinPath = "none";
        this.mTextureSROclModuleName = "test";
        this.mTextureSRDspModuleName = "test";
        this.mTextureRenderErrorMsg = null;
        this.mEnableOpenMDL = 0;
        this.mIsMdlProtoRegister = false;
        this.mIsPlayWithMdl = false;
        this.mPrepareState = PlayerState.IDLE;
        this.mLivePlayerState = LivePlayerState.IDLE;
        this.mIsRequestCanceled = false;
        this.mShowedFirstFrame = false;
        this.mHasRetry = false;
        this.mLooping = false;
        this.mPlayerCache = 0;
        this.mEnhancementType = 0;
        this.mScaleType = 0;
        this.mLayoutType = 0;
        this.mRenderType = 3;
        this.mHardwareDecodeEnable = 0;
        this.mHardwareRTCDecodeEnable = 0;
        this.mCacheFileEnable = -1;
        this.mTestAction = -1;
        this.mUseExternalDir = -1;
        this.mMaxFileCacheSize = -1;
        this.mByteVC1DecoderType = 1;
        this.mBufferDataSeconds = -1;
        this.mBufferTimeout = -1;
        this.mNetworkTimeout = -1;
        this.mPlayerDegradeMode = 0;
        this.mEnableSharp = 0;
        this.mDefaultCodecId = -1;
        this.mEnableMediaCodecASYNCInit = 0;
        this.mHurryType = -1;
        this.mHurryTime = 0;
        this.mCatchSpeed = -1.0f;
        this.mSlowPlayTime = -1;
        this.mSlowPlaySpeed = -1.0f;
        this.mEnableHurryFlag = -1;
        this.mCacheFilePath = null;
        this.mCacheFileKey = null;
        this.mIsCacheHasComplete = false;
        this.mCurrentPlayURL = null;
        this.mCurrentIP = null;
        this.mStallCount = 0;
        this.mIsStalling = false;
        this.mEnableResolutionAutoDegrade = false;
        this.mAbrStrategy = LiveConfigKey.RAD;
        this.mHasAbrInfo = false;
        this.mDefaultResBitrate = -1;
        this.mStallCountThresOfResolutionDegrade = 4;
        this.mEnableSwitchMainAndBackupUrl = true;
        this.mEnableVideoMpdRefresh = 1;
        this.mEnableCmafFastMode = 0;
        this.mEnableCmafOptimizeRetry = 0;
        this.mEnableDTSCheck = 0;
        this.mEnablePreventDTSBack = 0;
        this.mFrameDroppingDTSMaxDiff = 10000L;
        this.mFrameTerminatedDTS = -1L;
        this.mLatestAudioPacketDTS = -1L;
        this.mSessionId = null;
        this.mEnableCheckFrame = 0;
        this.mEnableCheckSEI = 0;
        this.mGopDuration = 4;
        this.mFrameMetaDataListener = null;
        this.mInvocationHandler = null;
        this.mLocalURL = null;
        this.mIsLocalURL = false;
        this.mALogWriteAddr = -1L;
        this.mResolution = "origin";
        this.mResolutionIndex = -1;
        this.mLevel = "main";
        this.mStreamFormat = LiveConfigKey.FLV;
        this.mSuggestProtocol = "none";
        this.mTransportProtocol = LiveConfigKey.TCP;
        this.mURLProtocol = "none";
        this.mEnableAvLines = "";
        this.mVideoOnly = "";
        this.mAudioOnly = "";
        this.mReliable = "";
        this.mForceDecodeSwitch = 0;
        this.mForceDecodeMsGaps = 0;
        this.mForceRenderMsGaps = 0;
        this.mFramesDrop = 15;
        this.mAVPHDnsParseEnable = 0;
        this.mAVPHDnsTimeout = 2000000;
        this.mAVPHVideoProbesize = 4096;
        this.mAVPHVideoMaxDuration = 100000;
        this.mAVPHAudioProbesize = 4096;
        this.mAVPHAudioMaxDuration = 100000;
        this.mAVPHOpenVideoFirst = 1;
        this.mAVPHMaxAVDiff = 10000;
        this.mAVPHAutoExit = 1;
        this.mAVPHEnableAutoReopen = 0;
        this.mAVPHVideoDiffThreshold = 15000;
        this.mAVPHReadRetryCount = 100;
        this.mAVPHReadErrorExit = 1;
        this.mEnableSkipFindUnnecessaryStream = 0;
        this.mEnableRenderStall = 1;
        this.mAudioLastRenderTime = -1L;
        this.mVideoLastRenderTime = -1L;
        this.mIsRetrying = false;
        this.mEnableDemuxerStall = 1;
        this.mEnableDecoderStall = 1;
        this.mEnableStallCounter = 0;
        this.mStallCounterInterval = 2000;
        this.mEnableClosePlayRetry = 0;
        this.mEnableCheckDropAudio = 0;
        this.mURLAbility = 1;
        this.mStallStartTime = 0L;
        this.mStallTotalTime = 0L;
        this.mRetryStartTime = 0L;
        this.mEnableNTP = 0;
        this.mEnableNTPTask = 0;
        this.mEnableDns = true;
        this.mEnableDnsOptimizer = false;
        this.mEnableUploadSessionSeries = false;
        this.mEnableH264HardwareDecode = 0;
        this.mEnableByteVC1HardwareDecode = 0;
        this.mMaxCacheSeconds = -1;
        this.mEnableSplitStream = 0;
        this.mOpenCheckSideData = 1;
        this.mEnableHttpkDegrade = 0;
        this.mEnableQuicDegrade = 1;
        this.mEnableFastOpenStream = 1;
        this.mEnableUploadSei = 1;
        this.mSeiDiffThres = 8000L;
        this.mEnableSeiCheck = false;
        this.mHasSeiInfo = false;
        this.mGetSeiCurrentTime = 0L;
        this.mStartPlayBufferThres = 0L;
        this.mCheckBufferingEndIgnoreVideo = 0;
        this.mStartDirectAfterPrepared = 0;
        this.mCheckBufferingEndAdvanceEnable = 0;
        this.mEnableTcpFastOpen = 0;
        this.mEnableCheckPacketCorrupt = 0;
        this.mEnableLowLatencyFLV = 0;
        this.mLowLatencyFLVStrategy = null;
        this.mEnableDroppingDTSRollFrame = 0;
        this.mIsInMainLooper = 1;
        this.mCmafEnable = false;
        this.mQuicEnable = false;
        this.mQuicVersion = 39;
        this.mEnableSaveSCFG = false;
        this.mEnableQuicCertVerify = false;
        this.mQuicInitMTU = 1200;
        this.mEnableQuicMTUDiscovery = 0;
        this.mQuicPadHello = 1;
        this.mQuicFixWillingAndAbleToWrite = 1;
        this.mQuicFixProcessTimer = 1;
        this.mQuicReadBlockTimeout = 100;
        this.mQuicReadBlockMode = 0;
        this.mQuicFixStreamFinAndRst = 0;
        this.mQuicConfigOptimize = 0;
        this.mQuicTimerVersion = 1;
        this.mQuicPull = false;
        this.mQuicInitRtt = 0;
        this.mQuicMaxCryptoRetransmissions = 0;
        this.mQuicMaxCryptoRetransmissionTimeMs = 0;
        this.mQuicMaxRetransmissions = 0;
        this.mQuicMaxRetransmissionTimeMs = 0;
        this.mQuicMaxAckDelay = 0;
        this.mQuicMinReceivedBeforeAckDecimation = 0;
        this.mSessionReceiveWindow = -1;
        this.mStreamReceiveWindow = -1;
        this.mAVNoSyncThreshold = 10000;
        this.mIsAlwaysDoAVSync = 0;
        this.mEnableFlvABR = 0;
        this.mEnableLLASHFastOpen = 0;
        this.mForceHttpDns = false;
        this.mHttpDNSServerHost = null;
        this.mCancelSDKDNSFailRetry = false;
        this.mUrlSettingMethod = -1;
        this.mUserSwitchResoultion = false;
        this.mEnterStallRetryInstantly = false;
        this.mEnableStallRetryInstantly = 1;
        this.mNodeOptimizeResults = null;
        this.mRedoDns = false;
        this.mEnableOptimizeBackup = 0;
        this.mSupportBackupIp = true;
        this.mTextureSRMode = 0;
        this.mRenderStartNotifyTimeStamp = 0L;
        this.mRenderStartEntered = false;
        this.mEnableAudioVolumeBalance = 0;
        this.mAudioVolumeBalancePregain = -1.0f;
        this.mAudioVolumeBalanceThreshold = -1.0f;
        this.mAudioVolumeBalanceRatio = -1.0f;
        this.mAudioVolumeBalancePredelay = -1.0f;
        this.mEnableCacheSei = 0;
        this.mEnableDecodeMultiSei = 0;
        this.mEnableDecodeSeiOnce = 0;
        this.mEnableSkipFlvNullTag = 0;
        this.mEnableNotifySeiImmediatelyBeforeFirstFrame = 1;
        this.mEnableLiveAbrCheckEnhance = 0;
        this.mLiveABRCheckInterval = 1000;
        this.mABRMethod = -1;
        this.mABRBufferThreshold = -1;
        this.mTslTimeShift = -1;
        this.mTslMinTimeShit = 60;
        this.mEnableOriginResolution = false;
        this.mTargetOriginBitRate = -1L;
        this.mEnableAbrStallDegradeImmediately = 1;
        this.mHlsLiveStartIndex = -3;
        this.mCdnSessionPath = null;
        this.mCdnAbrResolution = null;
        this.mAudioTimescaleEnable = -1;
        this.mStallRetryTimeIntervalManager = 10000L;
        this.mMediaSupportSR = false;
        this.mSupportSRScene = 0;
        this.mCheckSupportSR = false;
        this.mStallCounterThread = null;
        this.mStallCounterHandler = null;
        this.mVideoStallCountTask = new VideoStallCountTask();
        this.mStallCounterLock = new Object();
        this.mStallCounterIsRunning = false;
        this.mEnableRtcPlay = 0;
        this.mRtcPlayFallBack = 0;
        this.mRtcFallbackThreshold = 5000;
        this.mRtcEnableDtls = 1;
        this.mRtcMinJitterBuffer = 300;
        this.mRtcMaxJitterBuffer = 2000;
        this.mRtcEnableSDKDns = 0;
        this.mRtcEarlyInitRender = 0;
        this.mRtcMaxRetryCount = 0;
        this.mRtcSupportMiniSdp = 0;
        this.mCurrentRetryCount = 0;
        this.mRtcPlayLogInterval = 5000;
        this.mRtcEnableRtcUninitLockFree = 0;
        this.mEnableRadioLiveDisableRender = 0;
        this.mSwitchToB = 0;
        this.mMoudleIDToB = "";
        this.mURLHost = "";
        this.mABRDisableAlgorithm = 0;
        this.mTextureRenderFirstFrame = false;
        this.mUsePlayerRenderStart = false;
        this.mMaxTextureWidth = 0;
        this.mMaxTextureHeight = 0;
        this.mEnableReportSessionStop = 0;
        this.mSessionNum = 0;
        this.mSessionStartTime = 0L;
        this.mSessionRenderStartTime = 0L;
        this.mIsLiveIOProtoRegister = false;
        this.mEnableOpenLiveIO = 0;
        this.mIsPlayWithLiveIO = false;
        this.mEnableLiveIOPlay = 0;
        this.mEnableLiveIOP2P = 0;
        this.mEnableHttpPrepare = 0;
        this.mEnableFreeFlow = 0;
        this.mEnableP2pUp = 0;
        this.mLiveIOABGroupID = 0;
        this.mNoSyncReportMinDuration = 5000;
        this.mNoSyncReportReportThres = 2000;
        this.mEnableUseLiveThreadPool = 0;
        this.mExecutor = null;
        this.mEnableSharpen = 0;
        this.mSharpenMode = 0;
        this.mMediaSupportSharpen = false;
        this.mSupportSharpenScene = -1;
        this.mSharpenMaxWidth = TECameraUtils.CAPTURE_NORMAL;
        this.mSharpenMaxHeight = FunDC.ID_AUTH_1080;
        this.mSharpenPowerLevel = 0;
        this.mSharpenAmount = -1.0f;
        this.mSharpenOverRatio = -1.0f;
        this.mSharpenEdgeWeightGamma = 6.0f;
        this.mSharpenSceneMode = 1;
        this.mSharpenSdkParams = null;
        Context context = builder.mContext;
        this.mContext = context;
        ILiveListener iLiveListener = builder.mListener;
        this.mListener = iLiveListener;
        ILiveSettingBundle iLiveSettingBundle = builder.mSettingsBundle;
        this.mSettingsBundle = iLiveSettingBundle;
        builder.setStallRetryInterval(this.mStallRetryTimeIntervalManager);
        if (iLiveSettingBundle != null) {
            this.mEnableReportSessionStop = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_should_report_session_stop", 0)).intValue();
            this.mEnableUseLiveThreadPool = ((Integer) iLiveSettingBundle.getSettingsValueForKey("live_sdk_enable_use_live_threadpool", 0)).intValue();
        }
        if (this.mEnableUseLiveThreadPool != 1 || (executorService = builder.mLiveThreadPool) == null) {
            this.mExecutor = new com.bytedance.sdk.component.jk.b.b(1, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new NamedThreadFactory() { // from class: com.bykv.vk.component.ttvideo.VideoLiveManager.1
            });
        } else {
            this.mExecutor = executorService;
            this.mLogService.mUseLiveThreadPool = 1;
        }
        LiveLoggerService liveLoggerService = new LiveLoggerService(this, iLiveListener, builder.mUploadLogInterval, builder.mStallRetryTimeInterval, context, this.mEnableReportSessionStop);
        this.mLogService = liveLoggerService;
        liveLoggerService.setProjectKey(builder.mProjectKey);
        MediaLoaderWrapper.getDataLoader().setLogService(this.mLogService);
        this.mRetryProcessor = new RetryProcessor(new MyRetryListener(this), builder.mRetryTimeout, builder.mStallRetryTimeInterval, this.mLogService);
        this.mPlayerSetting = new PlayerSetting(context, null);
        boolean z = builder.mForceHttpDns;
        this.mForceHttpDns = z;
        this.mLogService.mEnableHttpDns = z;
        INetworkClient iNetworkClient = builder.mNetworkClient;
        this.mNetworkClient = iNetworkClient;
        DnsHelper dnsHelper = new DnsHelper(context, this.mExecutor, iNetworkClient);
        this.mDnsParser = dnsHelper;
        dnsHelper.updateDNSServerIP();
        this.mPlayerType = builder.mPlayerType;
        this.mStreamFormat = builder.mVideoFormat;
        this.mResolution = builder.mResolution;
        this.mStallCount = 0;
        this.mEnableResolutionAutoDegrade = builder.mEnableResolutionAutoDegrade;
        this.mEnableSwitchMainAndBackupUrl = builder.mEnableSwitchMainAndBackupUrl;
        this.mSeiDiffThres = builder.mSeiCheckTimeOut;
    }

    public void releaseTextureRenderRef() {
    }

    public void setTextureRenderLogListener() {
    }

    public void setupTextureRender() {
    }

    public void doResolutionChange(String str) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class MyMediaLoaderListener implements MediaLoaderListener {
        private final WeakReference<VideoLiveManager> mVideoLiveManagerRef;

        public MyMediaLoaderListener(VideoLiveManager videoLiveManager) {
            this.mVideoLiveManagerRef = new WeakReference<>(videoLiveManager);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public long getInt64Value(int i, long j) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            return (videoLiveManager == null || videoLiveManager.mPlayer == null || i != 0) ? j : videoLiveManager.mLogService.getInt64Value(i, j);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onDataLoaderError(int i, String str) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mLogService.onLoaderError(i, str);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onSwitchLoaderType(int i, String str) {
            VideoLiveManager videoLiveManager = this.mVideoLiveManagerRef.get();
            if (videoLiveManager == null || videoLiveManager.mPlayer == null) {
                return;
            }
            videoLiveManager.mLogService.onLoaderSwitch(i, str);
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onLogInfo(int i, String str, JSONObject jSONObject) {
        }

        @Override // com.bykv.vk.component.ttvideo.medialoader.MediaLoaderListener
        public void onNotify(int i, long j, long j2, String str) {
        }
    }

    private String prepareLiveIOURL(String str, String str2, Map<String, String> map) {
        return str;
    }
}
