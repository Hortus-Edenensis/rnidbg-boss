package com.zenmen.palmchat.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AudioObject implements Parcelable {
    public static final Parcelable.Creator<AudioObject> CREATOR = new a();
    public static final String OGG_MIMETYPE = "audio/ogg";
    private long date;
    private int duration;
    private String messageId;
    private String mimeType;
    private String path;
    private int size;
    private String target;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<AudioObject> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AudioObject createFromParcel(Parcel parcel) {
            AudioObject audioObject = new AudioObject();
            audioObject.setDate(parcel.readLong());
            audioObject.setDuration(parcel.readInt());
            audioObject.setMimeType(parcel.readString());
            audioObject.setSize(parcel.readInt());
            audioObject.setTarget(parcel.readString());
            audioObject.setPath(parcel.readString());
            audioObject.setMessageId(parcel.readString());
            return audioObject;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AudioObject[] newArray(int i) {
            return new AudioObject[0];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDate() {
        return this.date;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getPath() {
        return this.path;
    }

    public int getSize() {
        return this.size;
    }

    public String getTarget() {
        return this.target;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.date);
        parcel.writeInt(this.duration);
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.size);
        parcel.writeString(this.target);
        parcel.writeString(this.path);
        parcel.writeString(this.messageId);
    }
}
