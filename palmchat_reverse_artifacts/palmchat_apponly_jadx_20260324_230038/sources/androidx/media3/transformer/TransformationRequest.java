package androidx.media3.transformer;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class TransformationRequest {

    @Nullable
    public final String audioMimeType;
    public final int hdrMode;
    public final int outputHeight;

    @Nullable
    public final String videoMimeType;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {

        @Nullable
        private String audioMimeType;
        private int hdrMode;
        private int outputHeight;

        @Nullable
        private String videoMimeType;

        public TransformationRequest build() {
            return new TransformationRequest(this.outputHeight, this.audioMimeType, this.videoMimeType, this.hdrMode);
        }

        public Builder setAudioMimeType(@Nullable String str) {
            String strNormalizeMimeType = MimeTypes.normalizeMimeType(str);
            Assertions.checkArgument(strNormalizeMimeType == null || MimeTypes.isAudio(strNormalizeMimeType), "Not an audio MIME type: " + strNormalizeMimeType);
            this.audioMimeType = strNormalizeMimeType;
            return this;
        }

        public Builder setHdrMode(int i) {
            this.hdrMode = i;
            return this;
        }

        public Builder setResolution(int i) {
            this.outputHeight = i;
            return this;
        }

        public Builder setVideoMimeType(@Nullable String str) {
            String strNormalizeMimeType = MimeTypes.normalizeMimeType(str);
            Assertions.checkArgument(strNormalizeMimeType == null || MimeTypes.isVideo(strNormalizeMimeType), "Not a video MIME type: " + strNormalizeMimeType);
            this.videoMimeType = strNormalizeMimeType;
            return this;
        }

        public Builder() {
            this.outputHeight = -1;
        }

        private Builder(TransformationRequest transformationRequest) {
            this.outputHeight = transformationRequest.outputHeight;
            this.audioMimeType = transformationRequest.audioMimeType;
            this.videoMimeType = transformationRequest.videoMimeType;
            this.hdrMode = transformationRequest.hdrMode;
        }
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransformationRequest)) {
            return false;
        }
        TransformationRequest transformationRequest = (TransformationRequest) obj;
        return this.outputHeight == transformationRequest.outputHeight && Objects.equals(this.audioMimeType, transformationRequest.audioMimeType) && Objects.equals(this.videoMimeType, transformationRequest.videoMimeType) && this.hdrMode == transformationRequest.hdrMode;
    }

    public int hashCode() {
        int i = this.outputHeight * 31;
        String str = this.audioMimeType;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.videoMimeType;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.hdrMode;
    }

    public String toString() {
        return "TransformationRequest{outputHeight=" + this.outputHeight + ", audioMimeType='" + this.audioMimeType + "', videoMimeType='" + this.videoMimeType + "', hdrMode=" + this.hdrMode + '}';
    }

    private TransformationRequest(int i, @Nullable String str, @Nullable String str2, int i2) {
        this.outputHeight = i;
        this.audioMimeType = str;
        this.videoMimeType = str2;
        this.hdrMode = i2;
    }
}
