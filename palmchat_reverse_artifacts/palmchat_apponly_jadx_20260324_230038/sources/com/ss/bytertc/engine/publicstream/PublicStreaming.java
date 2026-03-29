package com.ss.bytertc.engine.publicstream;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.bytertc.engine.utils.LogUtil;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PublicStreaming {
    public static final String ACTION_CHANGED = "layoutChanged";
    public static final String ACTION_START = "started";
    public static final String ACTION_STOPPED = "stopped";
    private static final String TAG = "PublicStreaming";
    private String action = "";
    private AudioConfig audio;
    private Layout layout;
    private String roomId;
    private VideoConfig video;

    /* JADX INFO: compiled from: SearchBox */
    public static class AudioConfig {
        private int bitRate = 16000;
        private int sampleRate = 44100;
        private int channels = 1;

        public AudioConfig setChannels(int i) {
            this.channels = i;
            return this;
        }

        public AudioConfig setKBitRate(int i) {
            this.bitRate = i * 1000;
            return this;
        }

        public AudioConfig setSampleRate(int i) {
            this.sampleRate = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Layout {
        private String backgroundColor;
        private String backgroundImage;
        private int interpolationMode;
        private int layoutMode;
        private Region[] regions;

        /* JADX INFO: compiled from: SearchBox */
        public static class Builder {
            private ArrayList<Region> regions;
            private int interpolationMode = 0;
            private int layoutMode = 2;
            private String backgroundImage = "";
            private String backgroundColor = "#000000";

            public Builder addRegoin(Region region) {
                if (this.regions == null) {
                    this.regions = new ArrayList<>();
                }
                this.regions.add(region);
                return this;
            }

            public Builder backgroundColor(String str) {
                this.backgroundColor = str;
                return this;
            }

            public Builder backgroundImage(String str) {
                this.backgroundImage = str;
                return this;
            }

            public Layout build() {
                Layout layout = new Layout();
                ArrayList<Region> arrayList = this.regions;
                if (arrayList != null) {
                    layout.regions = (Region[]) arrayList.toArray(new Region[arrayList.size()]);
                }
                layout.interpolationMode = this.interpolationMode;
                layout.layoutMode = this.layoutMode;
                layout.backgroundImage = this.backgroundImage;
                layout.backgroundColor = this.backgroundColor;
                return layout;
            }

            public Builder interpolationMode(int i) {
                this.interpolationMode = i;
                return this;
            }

            public Builder layoutMode(int i) {
                this.layoutMode = i;
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class Region {
            private double alpha;
            private String alternateImage;
            private double h;
            private int mediaType;
            private int renderMode;
            private String roomId;
            private SourceCrop sourceCrop = new SourceCrop();
            private int streamType;
            private String userId;
            private double w;
            private double x;
            private double y;
            private int zorder;

            public Region alpha(double d) {
                this.alpha = d;
                return this;
            }

            public Region mediaType(int i) {
                this.mediaType = i;
                return this;
            }

            public Region position(double d, double d2) {
                this.x = d;
                this.y = d2;
                return this;
            }

            public Region renderMode(int i) {
                this.renderMode = i;
                return this;
            }

            public Region roomId(String str) {
                this.roomId = str;
                return this;
            }

            public Region size(double d, double d2) {
                this.w = d;
                this.h = d2;
                return this;
            }

            public Region sourceCropPosition(double d, double d2) {
                this.sourceCrop.locationX = d;
                this.sourceCrop.locationY = d2;
                return this;
            }

            public Region sourceCropSize(double d, double d2) {
                this.sourceCrop.widthProportion = d;
                this.sourceCrop.heightProportion = d2;
                return this;
            }

            public Region streamType(int i) {
                this.streamType = i;
                return this;
            }

            public Region userId(String str) {
                this.userId = str;
                return this;
            }

            public Region zorder(int i) {
                this.zorder = i;
                return this;
            }
        }

        public String getBackgroundColor() {
            return this.backgroundColor;
        }

        public String getBackgroundImage() {
            return this.backgroundImage;
        }

        public int getInterpolationMode() {
            return this.interpolationMode;
        }

        public int getLayoutMode() {
            return this.layoutMode;
        }

        public Region[] getRegions() {
            return this.regions;
        }

        public void setBackgroundColor(String str) {
            this.backgroundColor = str;
        }

        public void setBackgroundImage(String str) {
            this.backgroundImage = str;
        }

        public void setInterpolationMode(int i) {
            this.interpolationMode = i;
        }

        public void setLayoutMode(int i) {
            this.layoutMode = i;
        }

        public void setRegions(Region[] regionArr) {
            this.regions = regionArr;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                Region[] regionArr = this.regions;
                if (regionArr != null) {
                    int i = 0;
                    for (int length = regionArr.length; i < length; length = length) {
                        Region region = regionArr[i];
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject3.put("userId", region.userId);
                        jSONObject3.put("roomId", region.roomId);
                        jSONObject3.put("alternateImage", region.alternateImage);
                        jSONObject3.put("x", region.x);
                        jSONObject3.put("y", region.y);
                        jSONObject3.put(RXScreenCaptureService.KEY_WIDTH, region.w);
                        jSONObject3.put("h", region.h);
                        jSONObject3.put("zorder", region.zorder);
                        jSONObject3.put("alpha", region.alpha);
                        jSONObject3.put("streamType", region.streamType);
                        jSONObject3.put("mediaType", region.mediaType);
                        jSONObject3.put("renderMode", region.renderMode);
                        jSONObject4.put("x", region.sourceCrop.locationX);
                        jSONObject4.put("y", region.sourceCrop.locationY);
                        jSONObject4.put(RXScreenCaptureService.KEY_WIDTH, region.sourceCrop.widthProportion);
                        jSONObject4.put("h", region.sourceCrop.heightProportion);
                        jSONObject3.put("sourceCrop", jSONObject4);
                        jSONArray.put(jSONObject3);
                        i++;
                        regionArr = regionArr;
                    }
                }
                jSONObject.put("regions", jSONArray);
                jSONObject2.put("bgColor", this.backgroundColor);
                jSONObject2.put("bgImage", this.backgroundImage);
                jSONObject.put("canvas", jSONObject2);
                jSONObject.put("layoutMode", this.layoutMode);
                return jSONObject.toString();
            } catch (JSONException e) {
                LogUtil.w(PublicStreaming.TAG, "create layout json message happens exception", e);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SourceCrop {
        private double heightProportion;
        private double locationX;
        private double locationY;
        private double widthProportion;

        public SourceCrop setHeightProportion(double d) {
            this.heightProportion = d;
            return this;
        }

        public SourceCrop setLocationX(double d) {
            this.locationX = d;
            return this;
        }

        public SourceCrop setLocationY(double d) {
            this.locationY = d;
            return this;
        }

        public SourceCrop setWidthProportion(double d) {
            this.widthProportion = d;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class VideoConfig {
        private int fps = 30;
        private int bitRate = ErrorCode.REASON_RD_METADATA;
        private int width = 360;
        private int height = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;

        public VideoConfig setFps(int i) {
            this.fps = i;
            return this;
        }

        public VideoConfig setHeight(int i) {
            this.height = i;
            return this;
        }

        public VideoConfig setKBitRate(int i) {
            this.bitRate = i * 1000;
            return this;
        }

        public VideoConfig setWidth(int i) {
            this.width = i;
            return this;
        }
    }

    public static PublicStreaming getDefualtPublicStreaming() {
        VideoConfig videoConfig = new VideoConfig();
        videoConfig.setFps(30).setKBitRate(500).setHeight(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).setWidth(360);
        AudioConfig audioConfig = new AudioConfig();
        audioConfig.setSampleRate(44100).setChannels(1).setKBitRate(16);
        Layout.Builder builder = new Layout.Builder();
        builder.backgroundColor("#000000").backgroundImage("");
        PublicStreaming publicStreaming = new PublicStreaming();
        publicStreaming.setAudio(audioConfig);
        publicStreaming.setVideo(videoConfig);
        publicStreaming.setLayout(builder.build());
        return publicStreaming;
    }

    public AudioConfig getAudio() {
        return this.audio;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public JSONObject getPublicStreamMessage() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject.put(SharePluginInfo.ISSUE_FPS, this.video.fps);
            jSONObject.put("bitrate", this.video.bitRate);
            jSONObject.put("width", this.video.width);
            jSONObject.put("height", this.video.height);
            jSONObject2.put("bitrate", this.audio.bitRate);
            jSONObject2.put("sampleRate", this.audio.sampleRate);
            jSONObject2.put("channels", this.audio.channels);
            jSONObject4.put("bgColor", this.layout.backgroundColor);
            jSONObject4.put("bgImage", this.layout.backgroundImage);
            String str = "roomId";
            if (this.layout.regions != null) {
                Layout.Region[] regionArr = this.layout.regions;
                int length = regionArr.length;
                int i = 0;
                while (i < length) {
                    Layout.Region region = regionArr[i];
                    Layout.Region[] regionArr2 = regionArr;
                    JSONObject jSONObject7 = new JSONObject();
                    int i2 = length;
                    JSONObject jSONObject8 = new JSONObject();
                    JSONObject jSONObject9 = jSONObject2;
                    jSONObject7.put("userId", region.userId);
                    jSONObject7.put(str, region.roomId);
                    jSONObject7.put("alternateImage", region.alternateImage);
                    String str2 = str;
                    jSONObject7.put("x", region.x);
                    jSONObject7.put("y", region.y);
                    jSONObject7.put(RXScreenCaptureService.KEY_WIDTH, region.w);
                    jSONObject7.put("h", region.h);
                    jSONObject7.put("zorder", region.zorder);
                    jSONObject7.put("alpha", region.alpha);
                    jSONObject7.put("streamType", region.streamType);
                    jSONObject7.put("mediaType", region.mediaType);
                    jSONObject7.put("renderMode", region.renderMode);
                    jSONObject8.put("x", region.sourceCrop.locationX);
                    jSONObject8.put("y", region.sourceCrop.locationY);
                    jSONObject8.put(RXScreenCaptureService.KEY_WIDTH, region.sourceCrop.widthProportion);
                    jSONObject8.put("h", region.sourceCrop.heightProportion);
                    jSONObject7.put("sourceCrop", jSONObject8);
                    jSONArray.put(jSONObject7);
                    i++;
                    jSONObject = jSONObject;
                    regionArr = regionArr2;
                    length = i2;
                    jSONObject6 = jSONObject6;
                    jSONObject2 = jSONObject9;
                    str = str2;
                }
            }
            JSONObject jSONObject10 = jSONObject6;
            jSONObject3.put("canvas", jSONObject4);
            jSONObject3.put("regions", jSONArray);
            jSONObject3.put("layoutMode", this.layout.layoutMode);
            jSONObject3.put("interpolationMode", this.layout.interpolationMode);
            jSONObject5.put("video", jSONObject);
            jSONObject5.put("audio", jSONObject2);
            jSONObject5.put("layout", jSONObject3);
            jSONObject10.put("type", "publicstream");
            jSONObject10.put(str, this.roomId);
            jSONObject10.put("action", this.action);
            jSONObject10.put("publicStreamMeta", jSONObject5);
            return jSONObject10;
        } catch (JSONException e) {
            LogUtil.w(TAG, "get json message happen exception", e);
            return null;
        }
    }

    public VideoConfig getVideo() {
        return this.video;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setAudio(AudioConfig audioConfig) {
        this.audio = audioConfig;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setVideo(VideoConfig videoConfig) {
        this.video = videoConfig;
    }
}
