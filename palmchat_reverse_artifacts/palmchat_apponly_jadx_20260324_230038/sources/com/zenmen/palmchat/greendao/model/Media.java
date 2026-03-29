package com.zenmen.palmchat.greendao.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class Media implements Parcelable {
    public static final Parcelable.Creator<Media> CREATOR = new Parcelable.Creator<Media>() { // from class: com.zenmen.palmchat.greendao.model.Media.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Media createFromParcel(Parcel parcel) {
            return new Media(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Media[] newArray(int i) {
            return new Media[i];
        }
    };
    public static final int LINK_VIDEO_SUBTYPE_DEF = 0;
    public static final int LINK_VIDEO_SUBTYPE_LOCATION = 4;
    public static final int LINK_VIDEO_SUBTYPE_NAMECARD = 1;
    public static final int LINK_VIDEO_SUBTYPE_RANK = 3;
    public static final int LINK_VIDEO_SUBTYPE_TOPIC = 2;
    public String adCode;
    public String channelId;
    public String channelTitle;
    public String cityCode;
    public String extension;
    private MediaExtension extensionData;
    public List<String> headIconList;
    public String height;
    public double latitude;
    public boolean liveFlag;
    public String localPath;
    public String localThumbPath;
    public String location;
    public double longitude;
    public String midUrl;
    public String openLink;
    public int picSource;
    public String poiId;
    public String sceneId;
    public long shootingTime;
    public String subTitle;
    public int subType;
    public String thumbUrl;
    public String title;
    public int type;
    public String url;
    public long videoDuration;
    public String videoUrl;
    public String wid;
    public String width;
    public String wineFeedId;
    public String wineHead;
    public String wineName;
    public String wineTopicId;

    public Media() {
    }

    public static List<Media> convertToMediaList(String str) {
        return (List) az2.b(str, new TypeToken<List<Media>>() { // from class: com.zenmen.palmchat.greendao.model.Media.2
        }.getType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediaExtension getExtensionData() {
        if (this.extensionData == null && !TextUtils.isEmpty(this.extension)) {
            try {
                new JSONObject(this.extension);
                this.extensionData = (MediaExtension) az2.a(this.extension, MediaExtension.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.extensionData;
    }

    public int getHeight() {
        String str = this.height;
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    public String getSourceIcon() {
        LogUtil.d("extention ", "getSourceIcon extention = " + this.extension);
        if (getExtensionData() != null) {
            return getExtensionData().source.icon;
        }
        return null;
    }

    public String getSourceName() {
        return getExtensionData() != null ? getExtensionData().source.name : "";
    }

    public int getWidth() {
        String str = this.width;
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.height);
        parcel.writeString(this.width);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.localPath);
        parcel.writeString(this.midUrl);
        parcel.writeLong(this.videoDuration);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.localThumbPath);
        parcel.writeInt(this.type);
        parcel.writeInt(this.subType);
        parcel.writeString(this.wid);
        parcel.writeString(this.wineFeedId);
        parcel.writeString(this.wineTopicId);
        parcel.writeString(this.poiId);
        parcel.writeString(this.adCode);
        parcel.writeString(this.cityCode);
        parcel.writeString(this.wineName);
        parcel.writeString(this.wineHead);
        parcel.writeString(this.extension);
        parcel.writeParcelable(this.extensionData, i);
        parcel.writeInt(this.picSource);
        parcel.writeString(this.location);
        parcel.writeLong(this.shootingTime);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeInt(this.liveFlag ? 1 : 0);
        parcel.writeString(this.channelId);
        parcel.writeString(this.sceneId);
        parcel.writeString(this.channelTitle);
        parcel.writeStringList(this.headIconList);
    }

    public Media(Parcel parcel) {
        this.url = parcel.readString();
        this.height = parcel.readString();
        this.width = parcel.readString();
        this.thumbUrl = parcel.readString();
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.localPath = parcel.readString();
        this.midUrl = parcel.readString();
        this.videoDuration = parcel.readLong();
        this.videoUrl = parcel.readString();
        this.localThumbPath = parcel.readString();
        this.type = parcel.readInt();
        this.subType = parcel.readInt();
        this.wid = parcel.readString();
        this.wineFeedId = parcel.readString();
        this.wineTopicId = parcel.readString();
        this.poiId = parcel.readString();
        this.adCode = parcel.readString();
        this.cityCode = parcel.readString();
        this.wineName = parcel.readString();
        this.wineHead = parcel.readString();
        this.extension = parcel.readString();
        this.extensionData = (MediaExtension) parcel.readParcelable(MediaExtension.class.getClassLoader());
        this.picSource = parcel.readInt();
        this.location = parcel.readString();
        this.shootingTime = parcel.readLong();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.liveFlag = parcel.readInt() == 1;
        this.channelId = parcel.readString();
        this.sceneId = parcel.readString();
        this.channelTitle = parcel.readString();
        this.headIconList = parcel.createStringArrayList();
    }
}
