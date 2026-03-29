package com.lantern.core.business;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lantern.core.protobuf.ProtobufRequestBeanOuterClass;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class Event implements Parcelable {
    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() { // from class: com.lantern.core.business.Event.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Event[] newArray(int i) {
            return new Event[i];
        }
    };
    private String eventId;
    private String extra;
    private int level;
    private byte[] pubParams;
    private long saveDateTime;
    private int saveSrc;
    private String source;
    private int state;
    private byte[] taichi;

    public Event() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getLevel() {
        return Math.max(this.level, 1);
    }

    public byte[] getPubParams() {
        return this.pubParams;
    }

    public long getSaveDateTime() {
        return this.saveDateTime;
    }

    public int getSaveSrc() {
        return this.saveSrc;
    }

    public String getSource() {
        return this.source;
    }

    public int getState() {
        return this.state;
    }

    public byte[] getTaiChi() {
        return this.taichi;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setPubParams(byte[] bArr) {
        this.pubParams = bArr;
    }

    public void setSaveDateTime(long j) {
        this.saveDateTime = j;
    }

    public void setSaveSrc(int i) {
        this.saveSrc = i;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setTaiChi(byte[] bArr) {
        this.taichi = bArr;
    }

    public String toString() {
        ProtobufRequestBeanOuterClass.ProtobufRequestBean protobufRequestBeanBuild = ProtobufRequestBeanOuterClass.ProtobufRequestBean.newBuilder().build();
        try {
            protobufRequestBeanBuild = ProtobufRequestBeanOuterClass.ProtobufRequestBean.parseFrom(this.pubParams);
        } catch (InvalidProtocolBufferException e) {
            Log.e("CX_EVENT", "Event to string ex:" + e.getMessage());
        } catch (Exception e2) {
            Log.e("CX_EVENT", "Event to string ex:" + e2.getMessage());
        }
        return "Event{eventId='" + this.eventId + "', level=" + this.level + ", saveDateTime=" + this.saveDateTime + ", extra='" + this.extra + "', source='" + this.source + "', state='" + this.state + "', pubParams=" + protobufRequestBeanBuild.toString() + ", taichi=" + Arrays.toString(this.taichi) + ", saveSrc=" + this.saveSrc + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.eventId);
        parcel.writeInt(this.level);
        parcel.writeLong(this.saveDateTime);
        parcel.writeString(this.extra);
        parcel.writeString(this.source);
        parcel.writeByteArray(this.pubParams);
        parcel.writeByteArray(this.taichi);
        parcel.writeInt(this.saveSrc);
    }

    public Event(Parcel parcel) {
        this.eventId = parcel.readString();
        this.level = parcel.readInt();
        this.saveDateTime = parcel.readLong();
        this.extra = parcel.readString();
        this.source = parcel.readString();
        this.pubParams = parcel.createByteArray();
        this.taichi = parcel.createByteArray();
        this.saveSrc = parcel.readInt();
    }
}
