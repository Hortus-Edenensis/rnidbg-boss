package com.zenmen.palmchat.framework.mediapick;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaItem> CREATOR = new a();
    public Rect cropRect;
    public int degree;
    public String editedImagePath;
    public String extension;
    public ExtractInfo extractInfo;
    public String extype;
    public String fileFullPath;
    public int fileID;
    public String fileMD5;
    public String fileName;
    public long fileSize;
    public int height;
    public boolean isFileExpired;
    public String localPath;
    public String localThumbPath;
    public LocationInfo locationInfo;
    public String mid;
    public int mimeType;
    public long modifyTime;
    public int picSource;
    public long playLength;
    public long selectTime;
    public String text;
    public String thumbnailPath;
    public int width;

    /* JADX INFO: compiled from: SearchBox */
    public static class LocationInfo implements Parcelable {
        public static final Parcelable.Creator<LocationInfo> CREATOR = new a();
        public String area;
        public String city;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Parcelable.Creator<LocationInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LocationInfo createFromParcel(Parcel parcel) {
                return new LocationInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LocationInfo[] newArray(int i) {
                return new LocationInfo[i];
            }
        }

        public LocationInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getShowName() {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.city) && !TextUtils.isEmpty(this.area)) {
                sb.append(this.city);
                sb.append("·");
                sb.append(this.area);
            } else if (!TextUtils.isEmpty(this.city)) {
                sb.append(this.city);
            } else if (!TextUtils.isEmpty(this.area)) {
                sb.append(this.area);
            }
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.area);
            parcel.writeString(this.city);
        }

        public LocationInfo(Parcel parcel) {
            this.area = parcel.readString();
            this.city = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<MediaItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaItem createFromParcel(Parcel parcel) {
            return new MediaItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaItem[] newArray(int i) {
            return new MediaItem[i];
        }
    }

    public MediaItem() {
        this.isFileExpired = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public long getSelectTime() {
        return this.selectTime;
    }

    public boolean isImageMedia() {
        return this.mimeType == 0;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public void setSelectTime(long j) {
        this.selectTime = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fileID);
        parcel.writeString(this.localPath);
        parcel.writeString(this.thumbnailPath);
        parcel.writeString(this.fileFullPath);
        parcel.writeString(this.fileName);
        parcel.writeLong(this.modifyTime);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.mid);
        parcel.writeString(this.extension);
        parcel.writeLong(this.selectTime);
        parcel.writeInt(this.mimeType);
        parcel.writeLong(this.playLength);
        parcel.writeString(this.text);
        parcel.writeString(this.extype);
        parcel.writeString(this.fileMD5);
        parcel.writeInt(this.isFileExpired ? 1 : 0);
        parcel.writeString(this.localThumbPath);
        parcel.writeString(this.editedImagePath);
        parcel.writeParcelable(this.extractInfo, i);
        parcel.writeParcelable(this.locationInfo, i);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.picSource);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ExtractInfo implements Parcelable {
        public String deviceModel;
        public long fileTime;
        public float lat;
        public float lng;
        public long time;
        private static SimpleDateFormat squareMediaFormat = new SimpleDateFormat("yyyy·MM·dd");
        public static final Parcelable.Creator<ExtractInfo> CREATOR = new a();

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Parcelable.Creator<ExtractInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ExtractInfo createFromParcel(Parcel parcel) {
                return new ExtractInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ExtractInfo[] newArray(int i) {
                return new ExtractInfo[i];
            }
        }

        public ExtractInfo() {
            this.lat = -999.0f;
            this.lng = -999.0f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getTimeStr() {
            return this.time > 0 ? squareMediaFormat.format(new Date(this.time)) : this.fileTime > 0 ? squareMediaFormat.format(new Date(this.fileTime)) : "";
        }

        public long getValidTime() {
            long j = this.time;
            return j > 0 ? j : this.fileTime;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.time);
            parcel.writeLong(this.fileTime);
            parcel.writeString(this.deviceModel);
            parcel.writeFloat(this.lat);
            parcel.writeFloat(this.lng);
        }

        public ExtractInfo(Parcel parcel) {
            this.lat = -999.0f;
            this.lng = -999.0f;
            this.time = parcel.readLong();
            this.fileTime = parcel.readLong();
            this.deviceModel = parcel.readString();
            this.lat = parcel.readFloat();
            this.lng = parcel.readFloat();
        }
    }

    public MediaItem(Parcel parcel) {
        this.isFileExpired = false;
        this.fileID = parcel.readInt();
        this.localPath = parcel.readString();
        this.thumbnailPath = parcel.readString();
        this.fileFullPath = parcel.readString();
        this.fileName = parcel.readString();
        this.modifyTime = parcel.readLong();
        this.fileSize = parcel.readLong();
        this.mid = parcel.readString();
        this.extension = parcel.readString();
        this.selectTime = parcel.readLong();
        this.mimeType = parcel.readInt();
        this.playLength = parcel.readLong();
        this.text = parcel.readString();
        this.extype = parcel.readString();
        this.fileMD5 = parcel.readString();
        this.isFileExpired = parcel.readInt() == 1;
        this.localThumbPath = parcel.readString();
        this.editedImagePath = parcel.readString();
        this.extractInfo = (ExtractInfo) parcel.readParcelable(ExtractInfo.class.getClassLoader());
        this.locationInfo = (LocationInfo) parcel.readParcelable(LocationInfo.class.getClassLoader());
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.picSource = parcel.readInt();
    }
}
