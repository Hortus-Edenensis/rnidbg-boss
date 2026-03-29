package com.ss.bytertc.engine.live;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.realx.base.CalledByNative;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.bytertc.engine.data.HumanOrientation;
import com.ss.bytertc.engine.data.Position;
import com.ss.bytertc.engine.utils.LogUtil;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.wifi.ad.core.config.DeviceInfoUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LiveTranscoding {
    public static final String ACTION_CHANGED = "layoutChanged";
    public static final String ACTION_START = "started";
    public static final String ACTION_STOPPED = "stopped";
    private static final String TAG = "LiveTranscoding";
    private JSONObject advancedConfig;
    private AudioConfig audio;
    private JSONObject authInfo;
    private ClientMixParam clientMixParam;
    private Layout layout;
    private String roomId;
    private SpatialConfig spatialConfig;
    private SyncControlParam syncControlParam;
    private String url;
    private String userId;
    private VideoConfig video;
    private String action = "";
    private ByteRTCStreamMixingType mixType = ByteRTCStreamMixingType.STREAM_MIXING_BY_SERVER;

    /* JADX INFO: compiled from: SearchBox */
    public enum AACProfile {
        AAC_PROFILE_LC("LC"),
        AAC_PROFILE_HEV1("HEv1"),
        AAC_PROFILE_HEV2("HEv2");

        private String AacProfile;

        AACProfile(String str) {
            this.AacProfile = str;
        }

        public String getValue() {
            return this.AacProfile;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class AudioConfig {
        private String codec = "AAC";
        private int bitRate = 64000;
        private int sampleRate = 48000;
        private int channels = 2;
        private String aacProfile = AACProfile.AAC_PROFILE_LC.getValue();

        /* JADX INFO: compiled from: SearchBox */
        public enum AudioCodecType {
            AUDIO_CODEC_TYPE_AAC("AAC");

            private String audioCodecType;

            AudioCodecType(String str) {
                this.audioCodecType = str;
            }

            public String getValue() {
                return this.audioCodecType;
            }
        }

        public AudioConfig setAacProfile(AACProfile aACProfile) {
            this.aacProfile = aACProfile.getValue();
            return this;
        }

        public AudioConfig setChannels(int i) {
            this.channels = i;
            return this;
        }

        public AudioConfig setCodec(AudioCodecType audioCodecType) {
            this.codec = audioCodecType.getValue();
            return this;
        }

        public AudioConfig setKBitRate(int i) {
            if (i <= 0) {
                i = 0;
            }
            if (i > 2097152) {
                i = 2097152;
            }
            this.bitRate = i * 1000;
            return this;
        }

        public AudioConfig setSampleRate(int i) {
            this.sampleRate = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ClientMixParam {
        private boolean clientMixUseAudioMixer = true;
        private boolean clientMixUseOriginalFrame = false;
        private TranscoderClientMixVideoFormat clientMixVideoFormat = TranscoderClientMixVideoFormat.YUV_I420;

        public Boolean clientMixUseAudioMixer() {
            return Boolean.valueOf(this.clientMixUseAudioMixer);
        }

        public Boolean clientMixUseOriginalFrame() {
            return Boolean.valueOf(this.clientMixUseOriginalFrame);
        }

        public TranscoderClientMixVideoFormat getClientMixVideoFormat() {
            return this.clientMixVideoFormat;
        }

        public ClientMixParam setClientMixUseAudioMixer(Boolean bool) {
            this.clientMixUseAudioMixer = bool.booleanValue();
            return this;
        }

        public ClientMixParam setClientMixUseOriginalFrame(Boolean bool) {
            this.clientMixUseOriginalFrame = bool.booleanValue();
            return this;
        }

        public void setClientMixVideoFormat(TranscoderClientMixVideoFormat transcoderClientMixVideoFormat) {
            this.clientMixVideoFormat = transcoderClientMixVideoFormat;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Layout {
        private String appData;
        private String backgroundColor;
        private Region[] regions;

        /* JADX INFO: compiled from: SearchBox */
        public static class Builder {
            private String appData = "";
            private String backgroundColor = "#000000";
            private ArrayList<Region> regions;

            public Builder addRegion(Region region) {
                if (this.regions == null) {
                    this.regions = new ArrayList<>();
                }
                this.regions.add(region);
                return this;
            }

            public Builder appData(String str) {
                this.appData = str;
                return this;
            }

            public Builder backgroundColor(String str) {
                this.backgroundColor = str;
                return this;
            }

            public Layout builder() {
                Layout layout = new Layout();
                ArrayList<Region> arrayList = this.regions;
                if (arrayList != null) {
                    layout.regions = (Region[]) arrayList.toArray(new Region[arrayList.size()]);
                }
                layout.appData = this.appData;
                layout.backgroundColor = this.backgroundColor;
                return layout;
            }
        }

        public String getAppData() {
            return this.appData;
        }

        public String getBackgroundColor() {
            return this.backgroundColor;
        }

        public Region[] getRegions() {
            return this.regions;
        }

        public void setAppData(String str) {
            this.appData = str;
        }

        public void setBackgroundColor(String str) {
            this.backgroundColor = str;
        }

        public void setRegions(Region[] regionArr) {
            this.regions = regionArr;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Object jSONObject2 = new JSONObject();
            try {
                Region[] regionArr = this.regions;
                if (regionArr != null) {
                    for (Region region : regionArr) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(DeviceInfoUtil.UID_TAG, region.uid);
                        jSONObject3.put("roomID", region.roomId);
                        jSONObject3.put("x", region.x);
                        jSONObject3.put("y", region.y);
                        jSONObject3.put(RXScreenCaptureService.KEY_WIDTH, region.w);
                        jSONObject3.put("h", region.h);
                        jSONObject3.put("zorder", region.zorder);
                        jSONObject3.put("alpha", region.alpha);
                        jSONObject3.put("cornerRadius", region.cornerRadius);
                        jSONObject3.put("contentControl", region.contentControl);
                        jSONObject3.put("renderMode", region.renderMode);
                        jSONObject3.put("screen", region.screenStream);
                        jSONArray.put(jSONObject3);
                    }
                }
                jSONObject.put("canvas", jSONObject2);
                jSONObject.put("regions", jSONArray);
                jSONObject.put("app_data", this.appData);
                return jSONObject.toString();
            } catch (JSONException e) {
                LogUtil.w(LiveTranscoding.TAG, "create layout json message happen exception", e);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Region {
        private String uid = "";
        private String roomId = "";
        private double x = 0.0d;
        private double y = 0.0d;
        private double w = 1.0d;
        private double h = 1.0d;
        private int zorder = 0;
        private double alpha = 1.0d;
        private double cornerRadius = 0.0d;
        private TranscoderContentControlType contentControl = TranscoderContentControlType.HAS_AUDIO_AND_VIDEO;
        private TranscoderRenderMode renderMode = TranscoderRenderMode.RENDER_HIDDEN;
        private boolean localUser = false;
        private boolean screenStream = false;
        private TranscoderLayoutRegionType type = TranscoderLayoutRegionType.LAYOUT_REGION_TYPE_VIDEO_STREAM;
        private byte[] data = null;
        private DataParam dataParam = new DataParam();
        private Position spatialPosition = new Position();
        private boolean applySpatialAudio = true;

        /* JADX INFO: compiled from: SearchBox */
        public static class DataParam {
            private int imageWidth = 0;
            private int imageHeight = 0;

            public DataParam setImageHeight(int i) {
                this.imageHeight = i;
                return this;
            }

            public DataParam setImageWidth(int i) {
                this.imageWidth = i;
                return this;
            }
        }

        public Region alpha(double d) {
            this.alpha = d;
            return this;
        }

        public Region applySpatialAudio(boolean z) {
            this.applySpatialAudio = z;
            return this;
        }

        public Region contentControl(TranscoderContentControlType transcoderContentControlType) {
            this.contentControl = transcoderContentControlType;
            return this;
        }

        public Region data(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public Region dataParam(DataParam dataParam) {
            this.dataParam = dataParam;
            return this;
        }

        public boolean isLocalUser() {
            return this.localUser;
        }

        public boolean isScreenStream() {
            return this.screenStream;
        }

        public Region position(double d, double d2) {
            this.x = d;
            this.y = d2;
            return this;
        }

        public Region renderMode(TranscoderRenderMode transcoderRenderMode) {
            this.renderMode = transcoderRenderMode;
            return this;
        }

        public Region roomId(String str) {
            this.roomId = str;
            return this;
        }

        public Region setCornerRadius(double d) {
            this.cornerRadius = d;
            return this;
        }

        public Region setLocalUser(boolean z) {
            this.localUser = z;
            return this;
        }

        public Region setScreenStream(boolean z) {
            this.screenStream = z;
            return this;
        }

        public Region size(double d, double d2) {
            this.w = d;
            this.h = d2;
            return this;
        }

        public Region spatialPosition(float f, float f2, float f3) {
            Position position = this.spatialPosition;
            position.x = f;
            position.y = f2;
            position.z = f3;
            return this;
        }

        public Region type(TranscoderLayoutRegionType transcoderLayoutRegionType) {
            this.type = transcoderLayoutRegionType;
            return this;
        }

        public Region uid(String str) {
            this.uid = str;
            return this;
        }

        public Region zorder(int i) {
            this.zorder = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SyncControlParam {
        private Boolean syncStream = Boolean.FALSE;
        private int syncQueueLengthMs = 0;
        private boolean syncOnlySendPts = false;
        private boolean syncClientVideoNeedMix = false;
        private String syncBaseUser = "";

        public SyncControlParam setSyncBaseUser(String str) {
            this.syncBaseUser = str;
            return this;
        }

        public SyncControlParam setSyncClientVideoNeedMix(Boolean bool) {
            this.syncClientVideoNeedMix = bool.booleanValue();
            return this;
        }

        public SyncControlParam setSyncOnlySendPts(boolean z) {
            this.syncOnlySendPts = z;
            return this;
        }

        public SyncControlParam setSyncQueueLengthMs(int i) {
            this.syncQueueLengthMs = i;
            return this;
        }

        public SyncControlParam setSyncStream(Boolean bool) {
            this.syncStream = bool;
            return this;
        }

        public String syncBaseUser() {
            return this.syncBaseUser;
        }

        public Boolean syncClientVideoNeedMix() {
            return Boolean.valueOf(this.syncClientVideoNeedMix);
        }

        public boolean syncOnlySendPts() {
            return this.syncOnlySendPts;
        }

        public int syncQueueLengthMs() {
            return this.syncQueueLengthMs;
        }

        public Boolean syncStream() {
            return this.syncStream;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum TranscoderClientMixVideoFormat {
        YUV_I420(0),
        TEXTURE_2D(1),
        CVPIXEL_BUFFER_BGRA(2),
        YUV_NV12(3);

        private int videoFormat;

        TranscoderClientMixVideoFormat(int i) {
            this.videoFormat = i;
        }

        public int getValue() {
            return this.videoFormat;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum TranscoderContentControlType {
        HAS_AUDIO_AND_VIDEO(0),
        HAS_AUDIO_ONLY(1),
        HAS_VIDEO_ONLY(2);

        private int contentControlType;

        TranscoderContentControlType(int i) {
            this.contentControlType = i;
        }

        public int getValue() {
            return this.contentControlType;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum TranscoderLayoutRegionType {
        LAYOUT_REGION_TYPE_VIDEO_STREAM(0),
        LAYOUT_REGION_TYPE_IMAGE(1);

        private int regionType;

        TranscoderLayoutRegionType(int i) {
            this.regionType = i;
        }

        public int getValue() {
            return this.regionType;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum TranscoderRenderMode {
        RENDER_UNKNOWN(0),
        RENDER_HIDDEN(1),
        RENDER_FIT(2),
        RENDER_ADAPTIVE(3);

        private int renderMode;

        TranscoderRenderMode(int i) {
            this.renderMode = i;
        }

        public int getValue() {
            return this.renderMode;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class VideoConfig {
        private String codec = "H264";
        private int fps = 30;
        private int gop = 2;
        private int bitRate = ErrorCode.REASON_RD_METADATA;
        private int width = 360;
        private int height = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private boolean bFrame = false;

        /* JADX INFO: compiled from: SearchBox */
        public enum VideoCodecType {
            VIDEO_CODEC_TYPE_H264("H264"),
            VIDEO_CODEC_TYPE_BYTEVC1("ByteVC1");

            private String videoCodecType;

            VideoCodecType(String str) {
                this.videoCodecType = str;
            }

            public String getValue() {
                return this.videoCodecType;
            }
        }

        public VideoConfig setBFrame(boolean z) {
            this.bFrame = z;
            return this;
        }

        public VideoConfig setCodec(VideoCodecType videoCodecType) {
            this.codec = videoCodecType.getValue();
            return this;
        }

        public VideoConfig setFps(int i) {
            this.fps = i;
            return this;
        }

        public VideoConfig setGop(int i) {
            this.gop = i;
            return this;
        }

        public VideoConfig setHeight(int i) {
            this.height = i;
            return this;
        }

        public VideoConfig setKBitRate(int i) {
            if (i <= 0) {
                i = 0;
            }
            if (i > 2097152) {
                i = 2097152;
            }
            this.bitRate = i * 1000;
            return this;
        }

        public VideoConfig setWidth(int i) {
            this.width = i;
            return this;
        }
    }

    public static LiveTranscoding getDefualtLiveTranscode() {
        VideoConfig videoConfig = new VideoConfig();
        videoConfig.setCodec(VideoConfig.VideoCodecType.VIDEO_CODEC_TYPE_H264).setFps(15).setGop(2).setKBitRate(500).setHeight(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).setWidth(360).setBFrame(false);
        AudioConfig audioConfig = new AudioConfig();
        audioConfig.setCodec(AudioConfig.AudioCodecType.AUDIO_CODEC_TYPE_AAC).setSampleRate(48000).setChannels(2).setKBitRate(64).setAacProfile(AACProfile.AAC_PROFILE_LC);
        SyncControlParam syncControlParam = new SyncControlParam();
        Boolean bool = Boolean.FALSE;
        syncControlParam.setSyncStream(bool).setSyncBaseUser("").setSyncOnlySendPts(false).setSyncClientVideoNeedMix(bool).setSyncQueueLengthMs(0);
        ClientMixParam clientMixParam = new ClientMixParam();
        clientMixParam.setClientMixUseAudioMixer(Boolean.TRUE).setClientMixUseOriginalFrame(bool).setClientMixVideoFormat(TranscoderClientMixVideoFormat.YUV_I420);
        SpatialConfig spatialConfig = new SpatialConfig();
        spatialConfig.setAudienceSpatialPosition(0.0f, 0.0f, 0.0f).setEnableSpatialRender(false);
        Layout.Builder builder = new Layout.Builder();
        builder.backgroundColor("#000000").appData("");
        LiveTranscoding liveTranscoding = new LiveTranscoding();
        liveTranscoding.setAudio(audioConfig);
        liveTranscoding.setVideo(videoConfig);
        liveTranscoding.setSyncControlParam(syncControlParam);
        liveTranscoding.setClientMixParam(clientMixParam);
        liveTranscoding.setSpatialConfig(spatialConfig);
        liveTranscoding.setLayout(builder.builder());
        liveTranscoding.setUrl(null);
        return liveTranscoding;
    }

    public AudioConfig getAudio() {
        return this.audio;
    }

    public ClientMixParam getClientMixParam() {
        return this.clientMixParam;
    }

    @CalledByNative
    public String getFieldAction() {
        String str = this.action;
        return str == null ? "" : str;
    }

    @CalledByNative
    public String getFieldAdvancedConfig() {
        JSONObject jSONObject = this.advancedConfig;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    @CalledByNative
    public String getFieldAudioConfigAacProfile() {
        AudioConfig audioConfig = this.audio;
        return (audioConfig == null || audioConfig.aacProfile == null) ? "" : this.audio.aacProfile;
    }

    @CalledByNative
    public int getFieldAudioConfigBitrate() {
        AudioConfig audioConfig = this.audio;
        if (audioConfig == null) {
            return 0;
        }
        return audioConfig.bitRate;
    }

    @CalledByNative
    public int getFieldAudioConfigChannels() {
        AudioConfig audioConfig = this.audio;
        if (audioConfig == null) {
            return 0;
        }
        return audioConfig.channels;
    }

    @CalledByNative
    public String getFieldAudioConfigCodec() {
        AudioConfig audioConfig = this.audio;
        return (audioConfig == null || audioConfig.codec == null) ? "" : this.audio.codec;
    }

    @CalledByNative
    public int getFieldAudioConfigSampleRate() {
        AudioConfig audioConfig = this.audio;
        if (audioConfig == null) {
            return 0;
        }
        return audioConfig.sampleRate;
    }

    @CalledByNative
    public String getFieldAuthInfo() {
        JSONObject jSONObject = this.authInfo;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    @CalledByNative
    public boolean getFieldClientMixParamClientMixUseAudioMixer() {
        ClientMixParam clientMixParam = this.clientMixParam;
        if (clientMixParam == null) {
            return true;
        }
        return clientMixParam.clientMixUseAudioMixer;
    }

    @CalledByNative
    public boolean getFieldClientMixParamClientMixUseOriginalFrame() {
        ClientMixParam clientMixParam = this.clientMixParam;
        if (clientMixParam == null) {
            return false;
        }
        return clientMixParam.clientMixUseOriginalFrame;
    }

    @CalledByNative
    public int getFieldClientMixParamClientMixVideoFormat() {
        ClientMixParam clientMixParam = this.clientMixParam;
        return (clientMixParam == null ? TranscoderClientMixVideoFormat.YUV_I420 : clientMixParam.clientMixVideoFormat).getValue();
    }

    @CalledByNative
    public String getFieldLayoutAppData() {
        Layout layout = this.layout;
        return (layout == null || layout.appData == null) ? "" : this.layout.appData;
    }

    @CalledByNative
    public String getFieldLayoutBackgroundColor() {
        Layout layout = this.layout;
        return (layout == null || layout.backgroundColor == null) ? "" : this.layout.backgroundColor;
    }

    @CalledByNative
    public double getFieldLayoutRegionAlpha(Region region) {
        if (region == null) {
            return 0.0d;
        }
        return region.alpha;
    }

    @CalledByNative
    public boolean getFieldLayoutRegionApplySpatialAudio(Region region) {
        if (region == null) {
            return true;
        }
        return region.applySpatialAudio;
    }

    @CalledByNative
    public int getFieldLayoutRegionContentControl(Region region) {
        if (region == null) {
            return 0;
        }
        return region.contentControl.getValue();
    }

    @CalledByNative
    public double getFieldLayoutRegionCornerRadius(Region region) {
        if (region == null) {
            return 0.0d;
        }
        return region.cornerRadius;
    }

    @CalledByNative
    public byte[] getFieldLayoutRegionData(Region region) {
        if (region == null) {
            return null;
        }
        return region.data;
    }

    @CalledByNative
    public int getFieldLayoutRegionDataParamImageHeight(Region region) {
        if (region == null) {
            return 0;
        }
        return region.dataParam.imageHeight;
    }

    @CalledByNative
    public int getFieldLayoutRegionDataParamImageWidth(Region region) {
        if (region == null) {
            return 0;
        }
        return region.dataParam.imageWidth;
    }

    @CalledByNative
    public double getFieldLayoutRegionH(Region region) {
        if (region == null) {
            return 0.0d;
        }
        return region.h;
    }

    @CalledByNative
    public boolean getFieldLayoutRegionLocalUser(Region region) {
        if (region == null) {
            return false;
        }
        return region.localUser;
    }

    @CalledByNative
    public int getFieldLayoutRegionRenderMode(Region region) {
        if (region == null) {
            return 0;
        }
        return region.renderMode.getValue();
    }

    @CalledByNative
    public String getFieldLayoutRegionRoomId(Region region) {
        return (region == null || region.roomId == null) ? "" : region.roomId;
    }

    @CalledByNative
    public boolean getFieldLayoutRegionScreenStream(Region region) {
        if (region == null) {
            return false;
        }
        return region.screenStream;
    }

    @CalledByNative
    public float getFieldLayoutRegionSpatialPositionX(Region region) {
        if (region == null) {
            return 0.0f;
        }
        return region.spatialPosition.x;
    }

    @CalledByNative
    public float getFieldLayoutRegionSpatialPositionY(Region region) {
        if (region == null) {
            return 0.0f;
        }
        return region.spatialPosition.y;
    }

    @CalledByNative
    public float getFieldLayoutRegionSpatialPositionZ(Region region) {
        if (region == null) {
            return 0.0f;
        }
        return region.spatialPosition.z;
    }

    @CalledByNative
    public int getFieldLayoutRegionType(Region region) {
        if (region == null) {
            return 0;
        }
        return region.type.getValue();
    }

    @CalledByNative
    public String getFieldLayoutRegionUid(Region region) {
        return (region == null || region.uid == null) ? "" : region.uid;
    }

    @CalledByNative
    public double getFieldLayoutRegionW(Region region) {
        if (region == null) {
            return 0.0d;
        }
        return region.w;
    }

    @CalledByNative
    public double getFieldLayoutRegionX(Region region) {
        if (region == null) {
            return 0.0d;
        }
        return region.x;
    }

    @CalledByNative
    public double getFieldLayoutRegionY(Region region) {
        if (region == null) {
            return 0.0d;
        }
        return region.y;
    }

    @CalledByNative
    public int getFieldLayoutRegionZorder(Region region) {
        if (region == null) {
            return 0;
        }
        return region.zorder;
    }

    @CalledByNative
    public Region[] getFieldLayoutRegions() {
        Layout layout = this.layout;
        if (layout == null) {
            return null;
        }
        return layout.regions;
    }

    @CalledByNative
    public int getFieldMixType() {
        return this.mixType.value();
    }

    @CalledByNative
    public String getFieldRoomId() {
        String str = this.roomId;
        return str == null ? "" : str;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationForwardX() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.forward.x;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationForwardY() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.forward.y;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationForwardZ() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.forward.z;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationRightX() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.right.x;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationRightY() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.right.y;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationRightZ() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.right.z;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationUpX() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.up.x;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationUpY() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.up.y;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialOrientationUpZ() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialOrientation.up.z;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialPositionX() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialPosition.x;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialPositionY() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialPosition.y;
    }

    @CalledByNative
    public float getFieldSpatialConfigAudienceSpatialPositionZ() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return 0.0f;
        }
        return spatialConfig.audienceSpatialPosition.z;
    }

    @CalledByNative
    public boolean getFieldSpatialConfigEnableSpatialRender() {
        SpatialConfig spatialConfig = this.spatialConfig;
        if (spatialConfig == null) {
            return false;
        }
        return spatialConfig.enableSpatialRender;
    }

    @CalledByNative
    public String getFieldSyncControlParamSyncBaseUser() {
        SyncControlParam syncControlParam = this.syncControlParam;
        return syncControlParam == null ? "" : syncControlParam.syncBaseUser;
    }

    @CalledByNative
    public boolean getFieldSyncControlParamSyncClientVideoNeedMix() {
        SyncControlParam syncControlParam = this.syncControlParam;
        if (syncControlParam == null) {
            return false;
        }
        return syncControlParam.syncClientVideoNeedMix;
    }

    @CalledByNative
    public boolean getFieldSyncControlParamSyncOnlySendPts() {
        SyncControlParam syncControlParam = this.syncControlParam;
        if (syncControlParam == null) {
            return false;
        }
        return syncControlParam.syncOnlySendPts;
    }

    @CalledByNative
    public int getFieldSyncControlParamSyncQueueLengthMs() {
        SyncControlParam syncControlParam = this.syncControlParam;
        if (syncControlParam == null) {
            return 0;
        }
        return syncControlParam.syncQueueLengthMs;
    }

    @CalledByNative
    public boolean getFieldSyncControlParamSyncStream() {
        SyncControlParam syncControlParam = this.syncControlParam;
        if (syncControlParam == null) {
            return false;
        }
        return syncControlParam.syncStream.booleanValue();
    }

    @CalledByNative
    public String getFieldUrl() {
        String str = this.url;
        return str == null ? "" : str;
    }

    @CalledByNative
    public String getFieldUserId() {
        String str = this.userId;
        return str == null ? "" : str;
    }

    @CalledByNative
    public boolean getFieldVideoConfigBFrame() {
        VideoConfig videoConfig = this.video;
        if (videoConfig == null) {
            return false;
        }
        return videoConfig.bFrame;
    }

    @CalledByNative
    public int getFieldVideoConfigBitrate() {
        VideoConfig videoConfig = this.video;
        if (videoConfig == null) {
            return 0;
        }
        return videoConfig.bitRate;
    }

    @CalledByNative
    public String getFieldVideoConfigCodec() {
        VideoConfig videoConfig = this.video;
        return (videoConfig == null || videoConfig.codec == null) ? "" : this.video.codec;
    }

    @CalledByNative
    public int getFieldVideoConfigFps() {
        VideoConfig videoConfig = this.video;
        if (videoConfig == null) {
            return 0;
        }
        return videoConfig.fps;
    }

    @CalledByNative
    public int getFieldVideoConfigGop() {
        VideoConfig videoConfig = this.video;
        if (videoConfig == null) {
            return 0;
        }
        return videoConfig.gop;
    }

    @CalledByNative
    public int getFieldVideoConfigHeight() {
        VideoConfig videoConfig = this.video;
        if (videoConfig == null) {
            return 0;
        }
        return videoConfig.height;
    }

    @CalledByNative
    public int getFieldVideoConfigWidth() {
        VideoConfig videoConfig = this.video;
        if (videoConfig == null) {
            return 0;
        }
        return videoConfig.width;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public ByteRTCStreamMixingType getMixType() {
        return this.mixType;
    }

    public SpatialConfig getSpatialConfig() {
        return this.spatialConfig;
    }

    public SyncControlParam getSyncControlParam() {
        return this.syncControlParam;
    }

    public JSONObject getTranscodeMessage() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject7 = new JSONObject();
        JSONObject jSONObject8 = new JSONObject();
        JSONObject jSONObject9 = new JSONObject();
        try {
            jSONObject.put("codec", this.video.codec);
            jSONObject.put(SharePluginInfo.ISSUE_FPS, this.video.fps);
            jSONObject.put("gop", this.video.gop);
            jSONObject.put("bitRate", this.video.bitRate);
            jSONObject.put("width", this.video.width);
            jSONObject.put("height", this.video.height);
            jSONObject.put("bFrame", this.video.bFrame);
            jSONObject2.put("codec", this.audio.codec);
            jSONObject2.put("bitRate", this.audio.bitRate);
            jSONObject2.put("sampleRate", this.audio.sampleRate);
            jSONObject2.put("channels", this.audio.channels);
            jSONObject2.put(IMediaFormat.KEY_PROFILE, this.audio.aacProfile);
            jSONObject3.put("clientMixUseOriginalFrame", this.clientMixParam.clientMixUseOriginalFrame);
            jSONObject3.put("clientMixUseAudioMixer", this.clientMixParam.clientMixUseAudioMixer);
            jSONObject3.put("clientMixVideoFormat", this.clientMixParam.clientMixVideoFormat.getValue());
            jSONObject4.put("syncStream", this.syncControlParam.syncStream);
            jSONObject4.put("syncQueueLengthMs", this.syncControlParam.syncQueueLengthMs);
            jSONObject4.put("syncOnlySendPts", this.syncControlParam.syncOnlySendPts);
            jSONObject4.put("syncClientVideoNeedMix", this.syncControlParam.syncClientVideoNeedMix);
            jSONObject4.put("syncBaseUser", this.syncControlParam.syncBaseUser);
            jSONObject6.put("bgnd", this.layout.backgroundColor);
            if (this.layout.regions != null) {
                Region[] regionArr = this.layout.regions;
                int length = regionArr.length;
                int i = 0;
                while (i < length) {
                    Region region = regionArr[i];
                    Region[] regionArr2 = regionArr;
                    JSONObject jSONObject10 = new JSONObject();
                    JSONObject jSONObject11 = jSONObject9;
                    jSONObject10.put(DeviceInfoUtil.UID_TAG, region.uid);
                    jSONObject10.put("roomID", region.roomId);
                    jSONObject10.put("x", region.x);
                    jSONObject10.put("y", region.y);
                    jSONObject10.put(RXScreenCaptureService.KEY_WIDTH, region.w);
                    jSONObject10.put("h", region.h);
                    jSONObject10.put("zorder", region.zorder);
                    jSONObject10.put("alpha", region.alpha);
                    jSONObject10.put("cornerRadius", region.cornerRadius);
                    jSONObject10.put("contentControl", region.contentControl);
                    jSONObject10.put("renderMode", region.renderMode);
                    jSONObject10.put("local_user", region.localUser);
                    jSONObject10.put("screen", region.screenStream);
                    jSONArray.put(jSONObject10);
                    i++;
                    jSONObject3 = jSONObject3;
                    regionArr = regionArr2;
                    length = length;
                    jSONObject9 = jSONObject11;
                    jSONObject4 = jSONObject4;
                }
            }
            JSONObject jSONObject12 = jSONObject9;
            jSONObject5.put("canvas", jSONObject6);
            jSONObject5.put("regions", jSONArray);
            jSONObject5.put("app_data", this.layout.appData);
            jSONObject7.put("url", this.url);
            jSONObject8.put("transcode", jSONObject7);
            jSONObject8.put("video", jSONObject);
            jSONObject8.put("audio", jSONObject2);
            jSONObject8.put("clientMix", jSONObject3);
            jSONObject8.put("syncControl", jSONObject4);
            jSONObject8.put("layout", jSONObject5);
            jSONObject8.put("advancedConfig", this.advancedConfig);
            Object obj = this.authInfo;
            if (obj != null) {
                jSONObject8.put("authInfo", obj);
            }
            jSONObject12.put("mixingType", this.mixType);
            jSONObject12.put("type", "transcode");
            jSONObject12.put("roomId", this.roomId);
            jSONObject12.put("userId", this.userId);
            jSONObject12.put("action", this.action);
            jSONObject12.put("transcodeMeta", jSONObject8);
            return jSONObject12;
        } catch (JSONException e) {
            LogUtil.w(TAG, "get json message happen exception", e);
            return null;
        }
    }

    public String getUrl() {
        return this.url;
    }

    public VideoConfig getVideo() {
        return this.video;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setAdvancedConfig(JSONObject jSONObject) {
        this.advancedConfig = jSONObject;
    }

    public void setAudio(AudioConfig audioConfig) {
        this.audio = audioConfig;
    }

    public void setAuthInfo(JSONObject jSONObject) {
        this.authInfo = jSONObject;
    }

    public void setClientMixParam(ClientMixParam clientMixParam) {
        this.clientMixParam = clientMixParam;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void setMixType(ByteRTCStreamMixingType byteRTCStreamMixingType) {
        this.mixType = byteRTCStreamMixingType;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSpatialConfig(SpatialConfig spatialConfig) {
        this.spatialConfig = spatialConfig;
    }

    public void setSyncControlParam(SyncControlParam syncControlParam) {
        this.syncControlParam = syncControlParam;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVideo(VideoConfig videoConfig) {
        this.video = videoConfig;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SpatialConfig {
        private boolean enableSpatialRender;
        private Position audienceSpatialPosition = new Position();
        private HumanOrientation audienceSpatialOrientation = new HumanOrientation();

        public SpatialConfig setAudienceSpatialOrientation(HumanOrientation humanOrientation) {
            this.audienceSpatialOrientation = humanOrientation;
            return this;
        }

        public SpatialConfig setAudienceSpatialPosition(float f, float f2, float f3) {
            Position position = this.audienceSpatialPosition;
            position.x = f;
            position.y = f2;
            position.z = f3;
            return this;
        }

        public SpatialConfig setEnableSpatialRender(boolean z) {
            this.enableSpatialRender = z;
            return this;
        }

        public SpatialConfig setAudienceSpatialPosition(Position position) {
            this.audienceSpatialPosition = position;
            return this;
        }
    }
}
