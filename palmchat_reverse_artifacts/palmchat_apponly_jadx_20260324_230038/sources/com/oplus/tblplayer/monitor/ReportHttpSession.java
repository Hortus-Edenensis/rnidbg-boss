package com.oplus.tblplayer.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ReportHttpSession {

    /* JADX INFO: compiled from: SearchBox */
    public static class SessionRequest implements Parcelable {
        public static final Parcelable.Creator<SessionRequest> CREATOR = new Parcelable.Creator<SessionRequest>() { // from class: com.oplus.tblplayer.monitor.ReportHttpSession.SessionRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionRequest createFromParcel(Parcel parcel) {
                return new SessionRequest(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionRequest[] newArray(int i) {
                return new SessionRequest[i];
            }
        };
        private String hostAddress;
        private String hostName;
        private String method;
        private Map<String, String> requestHeaders;
        private long timestamp;
        private String url;

        public SessionRequest() {
        }

        public SessionRequest(Parcel parcel) {
            this.timestamp = parcel.readLong();
            this.url = parcel.readString();
            this.hostAddress = parcel.readString();
            this.method = parcel.readString();
            this.requestHeaders = parcel.readHashMap(String.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getHostAddress() {
            return this.hostAddress;
        }

        public String getHostName() {
            return this.hostName;
        }

        public String getMethod() {
            return this.method;
        }

        public Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public String getUrl() {
            return this.url;
        }

        public void setHostAddress(String str) {
            this.hostAddress = str;
        }

        public void setHostName(String str) {
            this.hostName = str;
        }

        public void setMethod(String str) {
            this.method = str;
        }

        public void setRequestHeaders(Map<String, String> map) {
            this.requestHeaders = map;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.timestamp);
            parcel.writeString(this.url);
            parcel.writeString(this.hostAddress);
            parcel.writeString(this.method);
            parcel.writeMap(this.requestHeaders);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SessionResponse implements Parcelable {
        public static final Parcelable.Creator<SessionResponse> CREATOR = new Parcelable.Creator<SessionResponse>() { // from class: com.oplus.tblplayer.monitor.ReportHttpSession.SessionResponse.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionResponse createFromParcel(Parcel parcel) {
                return new SessionResponse(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionResponse[] newArray(int i) {
                return new SessionResponse[i];
            }
        };
        private byte[] body;
        private int code;
        private String message;
        private String protocol;
        private Map<String, String> responseHeaders;
        private long timestamp;

        public SessionResponse() {
        }

        public SessionResponse(Parcel parcel) {
            this.timestamp = parcel.readLong();
            this.responseHeaders = parcel.readHashMap(String.class.getClassLoader());
            this.protocol = parcel.readString();
            this.code = parcel.readInt();
            this.message = parcel.readString();
            int i = parcel.readInt();
            if (i > 0) {
                byte[] bArr = new byte[i];
                this.body = bArr;
                parcel.readByteArray(bArr);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public byte[] getBody() {
            return this.body;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public String getProtocol() {
            return this.protocol;
        }

        public Map<String, String> getResponseHeaders() {
            return this.responseHeaders;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setBody(byte[] bArr) {
            this.body = bArr;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setProtocol(String str) {
            this.protocol = str;
        }

        public void setResponseHeader(Map<String, String> map) {
            this.responseHeaders = map;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.timestamp);
            parcel.writeMap(this.responseHeaders);
            parcel.writeString(this.protocol);
            parcel.writeInt(this.code);
            parcel.writeString(this.message);
            byte[] bArr = this.body;
            if (bArr == null || bArr.length <= 0) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.body);
            }
        }
    }
}
