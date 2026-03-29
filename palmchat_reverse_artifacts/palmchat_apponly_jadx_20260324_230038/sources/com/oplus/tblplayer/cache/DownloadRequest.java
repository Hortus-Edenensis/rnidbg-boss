package com.oplus.tblplayer.cache;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.misc.MediaUrl;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() { // from class: com.oplus.tblplayer.cache.DownloadRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadRequest[] newArray(int i) {
            return new DownloadRequest[i];
        }
    };

    @NonNull
    public final String id;
    public final long length;

    @NonNull
    public final MediaUrl mediaUrl;
    public final long position;
    public final int priority;

    /* JADX INFO: compiled from: SearchBox */
    public static class UnsupportedRequestException extends IOException {
    }

    public DownloadRequest(Parcel parcel) {
        this.id = parcel.readString();
        this.mediaUrl = (MediaUrl) parcel.readParcelable(MediaUrl.class.getClassLoader());
        this.position = parcel.readLong();
        this.length = parcel.readLong();
        this.priority = parcel.readInt();
    }

    public Builder buildUpon() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.id.equals(downloadRequest.id) && this.mediaUrl.equals(downloadRequest.mediaUrl) && this.position == downloadRequest.position && this.length == downloadRequest.length && this.priority == downloadRequest.priority;
    }

    public final int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31 * 31) + this.mediaUrl.hashCode()) * 31;
        long j = this.position;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.length;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.priority;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeParcelable(this.mediaUrl, i);
        parcel.writeLong(this.position);
        parcel.writeLong(this.length);
        parcel.writeInt(this.priority);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        @NonNull
        private final String id;
        private long length;

        @NonNull
        private final MediaUrl mediaUrl;
        private long position;
        private int priority;

        private Builder(DownloadRequest downloadRequest) {
            this.id = downloadRequest.id;
            this.mediaUrl = downloadRequest.mediaUrl;
            this.position = downloadRequest.position;
            this.length = downloadRequest.length;
            this.priority = downloadRequest.priority;
        }

        public DownloadRequest build() {
            return new DownloadRequest(this.id, this.mediaUrl, this.position, this.length, this.priority);
        }

        public Builder setLength(long j) {
            this.length = j;
            return this;
        }

        public Builder setPosition(long j) {
            this.position = j;
            return this;
        }

        public Builder setPriority(int i) {
            this.priority = i;
            return this;
        }

        public Builder(@NonNull String str, @NonNull MediaUrl mediaUrl) {
            this.id = str;
            this.mediaUrl = mediaUrl;
        }
    }

    private DownloadRequest(@NonNull String str, @NonNull MediaUrl mediaUrl, long j, long j2, int i) {
        this.id = str;
        this.mediaUrl = mediaUrl;
        this.position = j;
        this.length = j2;
        this.priority = Math.min(-1000, i);
    }
}
