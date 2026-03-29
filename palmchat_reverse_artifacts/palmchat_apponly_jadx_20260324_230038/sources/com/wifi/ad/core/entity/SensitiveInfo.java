package com.wifi.ad.core.entity;

import com.alipay.sdk.m.x.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.wifi.adsdk.download.LxAdDLManager;
import com.wifi.adsdk.utils.LxAdConst;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b<\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010k\u001a\u00020lJ\b\u0010m\u001a\u00020 H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001e\u0010(\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u00101\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u001a\u00104\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u001a\u00107\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u001a\u0010:\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R\u001a\u0010=\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R\u001a\u0010@\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$R\u001a\u0010C\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R\u001a\u0010F\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\"\"\u0004\bH\u0010$R\u001a\u0010I\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\"\"\u0004\bK\u0010$R\u001a\u0010L\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\"\"\u0004\bN\u0010$R\u001a\u0010O\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\"\"\u0004\bU\u0010$R\u001a\u0010V\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\"\"\u0004\bX\u0010$R\u001a\u0010Y\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\"\"\u0004\b[\u0010$R\u001a\u0010\\\u001a\u00020]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\"\"\u0004\bj\u0010$¨\u0006n"}, d2 = {"Lcom/wifi/ad/core/entity/SensitiveInfo;", "", "()V", "CONTENT_RESOURCE_API", "", "getCONTENT_RESOURCE_API", "()I", "CONTENT_RESOURCE_BAIDU_AD", "getCONTENT_RESOURCE_BAIDU_AD", "CONTENT_RESOURCE_BEIZI_AD", "getCONTENT_RESOURCE_BEIZI_AD", "CONTENT_RESOURCE_FEISUO_AD", "getCONTENT_RESOURCE_FEISUO_AD", "CONTENT_RESOURCE_GDT_AD", "getCONTENT_RESOURCE_GDT_AD", "CONTENT_RESOURCE_HUAWEI_AD", "getCONTENT_RESOURCE_HUAWEI_AD", "CONTENT_RESOURCE_HUOSHAN_DP", "getCONTENT_RESOURCE_HUOSHAN_DP", "CONTENT_RESOURCE_KS_AD", "getCONTENT_RESOURCE_KS_AD", "CONTENT_RESOURCE_LXAD_AD", "getCONTENT_RESOURCE_LXAD_AD", "CONTENT_RESOURCE_OPPO_AD", "getCONTENT_RESOURCE_OPPO_AD", "CONTENT_RESOURCE_QUMENG_AD", "getCONTENT_RESOURCE_QUMENG_AD", "CONTENT_RESOURCE_TT_AD", "getCONTENT_RESOURCE_TT_AD", "DATATYPE_ADVERT", "getDATATYPE_ADVERT", "adCode", "", "getAdCode", "()Ljava/lang/String;", "setAdCode", "(Ljava/lang/String;)V", "adId", "getAdId", "setAdId", "adLevel", "getAdLevel", "()Ljava/lang/Integer;", "setAdLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "apiId", "getApiId", "setApiId", "apiSrcId", "getApiSrcId", "setApiSrcId", WfConstant.EVENT_KEY_APP_NAME, "getAppName", "setAppName", "authorName", "getAuthorName", "setAuthorName", "authorUrl", "getAuthorUrl", "setAuthorUrl", "contentSourceId", "getContentSourceId", "setContentSourceId", "coverUrl", "getCoverUrl", "setCoverUrl", "deepUrl", "getDeepUrl", "setDeepUrl", LxAdDLManager.ITEM_DESC, "getDesc", "setDesc", "downloadUrl", "getDownloadUrl", "setDownloadUrl", "h5Url", "getH5Url", "setH5Url", "interactionType", "getInteractionType", "setInteractionType", "(I)V", "packageName", "getPackageName", "setPackageName", "shenheSdkId", "getShenheSdkId", "setShenheSdkId", "title", "getTitle", d.o, "videoDuration", "", "getVideoDuration", "()D", "setVideoDuration", "(D)V", "videoSize", "", "getVideoSize", "()J", "setVideoSize", "(J)V", "videoUrl", "getVideoUrl", "setVideoUrl", "toJson", "Lorg/json/JSONObject;", "toString", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SensitiveInfo {
    private final int CONTENT_RESOURCE_API;
    private Integer adLevel;
    private int interactionType;
    private double videoDuration;
    private long videoSize;
    private final int DATATYPE_ADVERT = 2;
    private final int CONTENT_RESOURCE_TT_AD = 116;
    private final int CONTENT_RESOURCE_OPPO_AD = 124;
    private final int CONTENT_RESOURCE_HUOSHAN_DP = 127;
    private final int CONTENT_RESOURCE_GDT_AD = 130;
    private final int CONTENT_RESOURCE_KS_AD = 131;
    private final int CONTENT_RESOURCE_BAIDU_AD = MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA;
    private final int CONTENT_RESOURCE_HUAWEI_AD = MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START;
    private final int CONTENT_RESOURCE_BEIZI_AD = 134;
    private final int CONTENT_RESOURCE_QUMENG_AD = 135;
    private final int CONTENT_RESOURCE_FEISUO_AD = 136;
    private final int CONTENT_RESOURCE_LXAD_AD = MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME;
    private String adId = "";
    private String contentSourceId = "";
    private String title = "";
    private String desc = "";
    private String appName = "";
    private String authorName = "";
    private String authorUrl = "";
    private String downloadUrl = "";
    private String packageName = "";
    private String deepUrl = "";
    private String h5Url = "";
    private String coverUrl = "";
    private String videoUrl = "";
    private String adCode = "";
    private String shenheSdkId = "";
    private String apiId = "";
    private String apiSrcId = "";

    public final String getAdCode() {
        return this.adCode;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final Integer getAdLevel() {
        return this.adLevel;
    }

    public final String getApiId() {
        return this.apiId;
    }

    public final String getApiSrcId() {
        return this.apiSrcId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getAuthorUrl() {
        return this.authorUrl;
    }

    public final int getCONTENT_RESOURCE_API() {
        return this.CONTENT_RESOURCE_API;
    }

    public final int getCONTENT_RESOURCE_BAIDU_AD() {
        return this.CONTENT_RESOURCE_BAIDU_AD;
    }

    public final int getCONTENT_RESOURCE_BEIZI_AD() {
        return this.CONTENT_RESOURCE_BEIZI_AD;
    }

    public final int getCONTENT_RESOURCE_FEISUO_AD() {
        return this.CONTENT_RESOURCE_FEISUO_AD;
    }

    public final int getCONTENT_RESOURCE_GDT_AD() {
        return this.CONTENT_RESOURCE_GDT_AD;
    }

    public final int getCONTENT_RESOURCE_HUAWEI_AD() {
        return this.CONTENT_RESOURCE_HUAWEI_AD;
    }

    public final int getCONTENT_RESOURCE_HUOSHAN_DP() {
        return this.CONTENT_RESOURCE_HUOSHAN_DP;
    }

    public final int getCONTENT_RESOURCE_KS_AD() {
        return this.CONTENT_RESOURCE_KS_AD;
    }

    public final int getCONTENT_RESOURCE_LXAD_AD() {
        return this.CONTENT_RESOURCE_LXAD_AD;
    }

    public final int getCONTENT_RESOURCE_OPPO_AD() {
        return this.CONTENT_RESOURCE_OPPO_AD;
    }

    public final int getCONTENT_RESOURCE_QUMENG_AD() {
        return this.CONTENT_RESOURCE_QUMENG_AD;
    }

    public final int getCONTENT_RESOURCE_TT_AD() {
        return this.CONTENT_RESOURCE_TT_AD;
    }

    public final String getContentSourceId() {
        return this.contentSourceId;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final int getDATATYPE_ADVERT() {
        return this.DATATYPE_ADVERT;
    }

    public final String getDeepUrl() {
        return this.deepUrl;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final int getInteractionType() {
        return this.interactionType;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getShenheSdkId() {
        return this.shenheSdkId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final double getVideoDuration() {
        return this.videoDuration;
    }

    public final long getVideoSize() {
        return this.videoSize;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final void setAdCode(String str) {
        this.adCode = str;
    }

    public final void setAdId(String str) {
        this.adId = str;
    }

    public final void setAdLevel(Integer num) {
        this.adLevel = num;
    }

    public final void setApiId(String str) {
        this.apiId = str;
    }

    public final void setApiSrcId(String str) {
        this.apiSrcId = str;
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setAuthorName(String str) {
        this.authorName = str;
    }

    public final void setAuthorUrl(String str) {
        this.authorUrl = str;
    }

    public final void setContentSourceId(String str) {
        this.contentSourceId = str;
    }

    public final void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public final void setDeepUrl(String str) {
        this.deepUrl = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public final void setH5Url(String str) {
        this.h5Url = str;
    }

    public final void setInteractionType(int i) {
        this.interactionType = i;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setShenheSdkId(String str) {
        this.shenheSdkId = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setVideoDuration(double d) {
        this.videoDuration = d;
    }

    public final void setVideoSize(long j) {
        this.videoSize = j;
    }

    public final void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", this.title);
        jSONObject.put(LxAdDLManager.ITEM_DESC, this.desc);
        jSONObject.put("newsId", this.adId);
        jSONObject.put("authorName", this.authorName);
        jSONObject.put("authorAvatar", this.authorUrl);
        jSONObject.put("videoDuration", String.valueOf(this.videoDuration));
        jSONObject.put("videoSize", String.valueOf(this.videoSize));
        jSONObject.put("videoCover", this.coverUrl);
        jSONObject.put("landingURL", this.h5Url);
        String str = this.downloadUrl;
        if (str == null || str.length() == 0) {
            jSONObject.put("downloadURL", this.deepUrl);
        } else {
            jSONObject.put("downloadURL", this.downloadUrl);
        }
        jSONObject.put("videoURL", this.videoUrl);
        jSONObject.put("appname", this.appName);
        jSONObject.put("packageName", this.packageName);
        jSONObject.put("esi", this.contentSourceId);
        jSONObject.put("type", String.valueOf(this.DATATYPE_ADVERT));
        jSONObject.put("addi", this.adCode);
        jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_APIID, this.apiId);
        jSONObject.put(LxAdConst.EventKeyParams.KEY_PARAM_APISRCID, this.apiSrcId);
        Integer num = this.adLevel;
        if (num != null) {
            jSONObject.put("adLevel", String.valueOf(num));
        }
        jSONObject.put("interactionType", String.valueOf(this.interactionType));
        return jSONObject;
    }

    public String toString() {
        return "SensitiveInfo(adId='" + this.adId + "', contentSourceId='" + this.contentSourceId + "', title='" + this.title + "', desc='" + this.desc + "', appName='" + this.appName + "', authorName='" + this.authorName + "', authorUrl='" + this.authorUrl + "', downloadUrl='" + this.downloadUrl + "', packageName='" + this.packageName + "', deepUrl='" + this.deepUrl + "', h5Url='" + this.h5Url + "', coverUrl='" + this.coverUrl + "', videoUrl='" + this.videoUrl + "', videoDuration=" + this.videoDuration + ", videoSize=" + this.videoSize + ", adCode=" + this.adCode + ", adLevel=" + this.adLevel + ')';
    }
}
