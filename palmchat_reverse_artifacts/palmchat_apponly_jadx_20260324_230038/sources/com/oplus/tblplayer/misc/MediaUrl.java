package com.oplus.tblplayer.misc;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.misc.MediaUrl;
import com.oplus.tblplayer.utils.AssertUtil;
import com.oplus.tblplayer.utils.LogUtil;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MediaUrl implements Parcelable {
    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_DATA = "data";
    private static final String SCHEME_LOCAL = "file";
    private static final String SCHEME_RAW = "rawresource";
    private static final String SCHEME_RTMP = "rtmp";
    private static final String TAG = "MediaUrl";

    @Nullable
    private final List<PlaybackProperties> backupUrlList;
    private int backupUrlListIndex = 0;

    @Nullable
    public final CipherConfiguration cipherConfiguration;
    public final long clipEndPositionMs;
    public final long clipStartPositionMs;
    public final int loopCount;

    @NonNull
    public final String mediaId;

    @NonNull
    public PlaybackProperties playbackProperties;
    public static final CacheKeyFactory DEFAULT_CACHE_KEY_FACTORY = new CacheKeyFactory() { // from class: ym3
        @Override // com.oplus.tblplayer.misc.MediaUrl.CacheKeyFactory
        public final String buildCacheKey(Uri uri) {
            return MediaUrl.lambda$static$0(uri);
        }
    };
    public static final Parcelable.Creator<MediaUrl> CREATOR = new Parcelable.Creator<MediaUrl>() { // from class: com.oplus.tblplayer.misc.MediaUrl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaUrl createFromParcel(Parcel parcel) {
            return new MediaUrl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaUrl[] newArray(int i) {
            return new MediaUrl[i];
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private List<PlaybackProperties> backupUrls;
        private CacheKeyFactory cacheKeyFactory;
        private long clipEndPositionMs;
        private long clipStartPositionMs;
        private byte[] encryptionIv;
        private byte[] encryptionKey;
        private FileDescriptorProperties fdProperties;
        private Map<String, String> headers;
        private int loopCount;

        @Nullable
        private String mediaId;
        private String overrideExtension;
        private String transformation;
        private Uri uri;
        private String userAgent;

        public Builder(@NonNull Uri uri) {
            this(uri, (Map<String, String>) null);
        }

        public Builder addBackupSourceUrl(@NonNull Uri uri) {
            return addBackupSourceUrl(uri, (Map<String, String>) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MediaUrl build() {
            Assertions.checkNotNull(this.uri);
            CipherConfiguration cipherConfiguration = this.transformation != null ? new CipherConfiguration(this.transformation, this.encryptionKey, this.encryptionIv) : null;
            Uri uri = this.uri;
            String str = null;
            String str2 = this.overrideExtension;
            FileDescriptorProperties fileDescriptorProperties = this.fdProperties;
            String str3 = this.userAgent;
            Map<String, String> map = this.headers;
            CacheKeyFactory cacheKeyFactory = this.cacheKeyFactory;
            if (cacheKeyFactory == null) {
                cacheKeyFactory = MediaUrl.DEFAULT_CACHE_KEY_FACTORY;
            }
            PlaybackProperties playbackProperties = new PlaybackProperties(uri, str, str2, fileDescriptorProperties, str3, map, cacheKeyFactory.buildCacheKey(uri));
            String string = this.mediaId;
            if (string == null) {
                string = this.uri.toString();
            }
            this.mediaId = string;
            return new MediaUrl(this.mediaId, playbackProperties, this.backupUrls.size() != 0 ? this.backupUrls : null, this.loopCount, this.clipStartPositionMs, this.clipEndPositionMs, cipherConfiguration);
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.cacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public Builder setCipherConfiguration(String str, String str2, String str3) {
            Assertions.checkArgument(!TextUtils.isEmpty(str));
            Assertions.checkArgument(!TextUtils.isEmpty(str2));
            Assertions.checkArgument(!TextUtils.isEmpty(str3));
            this.transformation = str;
            this.encryptionKey = str2.getBytes();
            this.encryptionIv = str3.getBytes();
            return this;
        }

        public Builder setClipEndPositionMs(long j) {
            this.clipEndPositionMs = j;
            return this;
        }

        public Builder setClipStartPositionMs(long j) {
            this.clipStartPositionMs = j;
            return this;
        }

        public Builder setFileDescriptor(@NonNull ParcelFileDescriptor parcelFileDescriptor, long j, long j2) {
            this.fdProperties = new FileDescriptorProperties((ParcelFileDescriptor) AssertUtil.checkNotNull(parcelFileDescriptor), j, j2);
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public Builder setLoopCount(int i) {
            this.loopCount = i;
            return this;
        }

        public Builder setOverrideExtension(String str) {
            this.overrideExtension = str;
            return this;
        }

        public Builder setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Builder(@NonNull Uri uri, @Nullable Map<String, String> map) {
            this.clipEndPositionMs = Long.MIN_VALUE;
            this.uri = uri;
            this.headers = map;
            this.backupUrls = new ArrayList(5);
        }

        public Builder addBackupSourceUrl(@NonNull Uri uri, @Nullable Map<String, String> map) {
            PlaybackProperties playbackProperties = new PlaybackProperties(uri, null, null, null, null, map, null);
            if (!this.backupUrls.contains(playbackProperties)) {
                this.backupUrls.add(playbackProperties);
            }
            return this;
        }

        public Builder(@NonNull String str) {
            this(Uri.parse(str));
        }

        public Builder addBackupSourceUrl(@NonNull String str) {
            return addBackupSourceUrl(Uri.parse(str));
        }

        public Builder(@NonNull String str, @Nullable Map<String, String> map) {
            this(Uri.parse(str), map);
        }

        public Builder addBackupSourceUrl(@NonNull String str, @Nullable Map<String, String> map) {
            return addBackupSourceUrl(Uri.parse(str), map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CacheKeyFactory {
        String buildCacheKey(Uri uri);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class CipherConfiguration implements Parcelable {
        public static final Parcelable.Creator<CipherConfiguration> CREATOR = new Parcelable.Creator<CipherConfiguration>() { // from class: com.oplus.tblplayer.misc.MediaUrl.CipherConfiguration.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CipherConfiguration createFromParcel(Parcel parcel) {
                return new CipherConfiguration(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CipherConfiguration[] newArray(int i) {
                return new CipherConfiguration[i];
            }
        };
        public final byte[] encryptionIv;
        public final byte[] encryptionKey;
        public final String transformation;

        public CipherConfiguration(Parcel parcel) {
            this.transformation = parcel.readString();
            this.encryptionKey = parcel.createByteArray();
            this.encryptionIv = parcel.createByteArray();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CipherConfiguration)) {
                return false;
            }
            CipherConfiguration cipherConfiguration = (CipherConfiguration) obj;
            return Util.areEqual(this.transformation, cipherConfiguration.transformation) && Arrays.equals(this.encryptionKey, cipherConfiguration.encryptionKey) && Arrays.equals(this.encryptionIv, cipherConfiguration.encryptionIv);
        }

        public int hashCode() {
            return (((Objects.hash(this.transformation) * 31) + Arrays.hashCode(this.encryptionKey)) * 31) + Arrays.hashCode(this.encryptionIv);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.transformation);
            parcel.writeByteArray(this.encryptionKey);
            parcel.writeByteArray(this.encryptionIv);
        }

        private CipherConfiguration(String str, byte[] bArr, byte[] bArr2) {
            this.transformation = str;
            this.encryptionKey = bArr;
            this.encryptionIv = bArr2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class FileDescriptorProperties implements Parcelable {
        public static final Parcelable.Creator<FileDescriptorProperties> CREATOR = new Parcelable.Creator<FileDescriptorProperties>() { // from class: com.oplus.tblplayer.misc.MediaUrl.FileDescriptorProperties.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FileDescriptorProperties createFromParcel(Parcel parcel) {
                return new FileDescriptorProperties(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FileDescriptorProperties[] newArray(int i) {
                return new FileDescriptorProperties[i];
            }
        };
        public long length;
        public long offset;

        @NonNull
        public final ParcelFileDescriptor pfd;

        public FileDescriptorProperties(Parcel parcel) {
            this.pfd = parcel.readFileDescriptor();
            this.offset = parcel.readLong();
            this.length = parcel.readLong();
        }

        private void adjustedOffsetAndLength(long j, long j2) {
            long j3 = j < 0 ? 0L : j;
            this.offset = j3;
            long j4 = j2 < 0 ? 0L : j2;
            this.length = j4;
            if (j4 > Long.MAX_VALUE - j3) {
                this.length = Long.MAX_VALUE - j3;
            }
            long statSize = this.pfd.getStatSize();
            if (statSize != -1) {
                if (this.offset > statSize) {
                    this.offset = statSize;
                    this.length = 0L;
                }
                long j5 = this.offset;
                if (this.length + j5 > statSize) {
                    this.length = statSize - j5;
                }
            }
            if (this.offset == j && this.length == j2) {
                return;
            }
            LogUtil.dfmt(MediaUrl.TAG, "offset/length adjusted from %d/%d to %d/%d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.offset), Long.valueOf(this.length));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileDescriptorProperties)) {
                return false;
            }
            FileDescriptorProperties fileDescriptorProperties = (FileDescriptorProperties) obj;
            return this.pfd.equals(fileDescriptorProperties.pfd) && Util.areEqual(Long.valueOf(this.offset), Long.valueOf(fileDescriptorProperties.offset)) && Util.areEqual(Long.valueOf(this.length), Long.valueOf(fileDescriptorProperties.length));
        }

        public int hashCode() {
            int iHashCode = this.pfd.hashCode() * 31;
            long j = this.offset;
            int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.length;
            return i + ((int) (j2 ^ (j2 >>> 32)));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFileDescriptor(this.pfd.getFileDescriptor());
            parcel.writeLong(this.offset);
            parcel.writeLong(this.length);
        }

        private FileDescriptorProperties(@NonNull ParcelFileDescriptor parcelFileDescriptor, long j, long j2) {
            this.pfd = parcelFileDescriptor;
            adjustedOffsetAndLength(j, j2);
        }
    }

    public MediaUrl(Parcel parcel) {
        this.mediaId = parcel.readString();
        this.playbackProperties = (PlaybackProperties) parcel.readParcelable(PlaybackProperties.class.getClassLoader());
        this.backupUrlList = parcel.readArrayList(PlaybackProperties.class.getClassLoader());
        this.loopCount = parcel.readInt();
        this.clipStartPositionMs = parcel.readLong();
        this.clipEndPositionMs = parcel.readLong();
        this.cipherConfiguration = (CipherConfiguration) parcel.readParcelable(CipherConfiguration.class.getClassLoader());
    }

    public static MediaUrl fromUri(Uri uri) {
        return new Builder(uri).build();
    }

    private int inferContentType2(Uri uri) {
        String path = uri.getPath();
        if (path != null && Util.toLowerInvariant(path).endsWith(Constants.URL_OVERRIDE_EXTENSION_M3U8)) {
            return 2;
        }
        String queryParameter = uri.getQueryParameter("ext");
        return (queryParameter == null || !queryParameter.equals(Constants.URL_OVERRIDE_EXTENSION_M3U8)) ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0(Uri uri) {
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaUrl)) {
            return false;
        }
        MediaUrl mediaUrl = (MediaUrl) obj;
        return Util.areEqual(this.mediaId, mediaUrl.mediaId) && Util.areEqual(this.playbackProperties, mediaUrl.playbackProperties) && this.loopCount == mediaUrl.loopCount && this.clipStartPositionMs == mediaUrl.clipStartPositionMs && this.clipEndPositionMs == mediaUrl.clipEndPositionMs;
    }

    public long getClipEndPositionMs() {
        return this.clipEndPositionMs;
    }

    public long getClipStartPositionMs() {
        return this.clipStartPositionMs;
    }

    @Nullable
    public String getCustomCacheKey() {
        return this.playbackProperties.customCacheKey;
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.playbackProperties.headers;
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public String getOverrideExtension() {
        return this.playbackProperties.overrideExtension;
    }

    @NonNull
    public Uri getUri() {
        return this.playbackProperties.uri;
    }

    public String getUserAgent() {
        return this.playbackProperties.userAgent;
    }

    public synchronized boolean hasNextBackupSource() {
        List<PlaybackProperties> list = this.backupUrlList;
        if (list != null && list.size() != 0) {
            if (this.backupUrlListIndex < this.backupUrlList.size()) {
                if (this.backupUrlList.get(this.backupUrlListIndex) != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.mediaId.hashCode() * 31) + this.playbackProperties.hashCode()) * 31) + this.loopCount) * 31;
        long j = this.clipStartPositionMs;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.clipEndPositionMs;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        CipherConfiguration cipherConfiguration = this.cipherConfiguration;
        return i2 + (cipherConfiguration != null ? cipherConfiguration.hashCode() : 0);
    }

    public int inferContentType() {
        AssertUtil.checkNotNull(this.mediaId);
        AssertUtil.checkNotNull(this.playbackProperties.uri);
        PlaybackProperties playbackProperties = this.playbackProperties;
        int iInferContentType = Util.inferContentType(playbackProperties.uri, playbackProperties.overrideExtension);
        if (iInferContentType == 0) {
            return 0;
        }
        int i = 1;
        if (iInferContentType != 1) {
            i = 2;
            if (iInferContentType != 2) {
                i = 4;
                if (isFileDescriptor()) {
                    return 4;
                }
                if (isHttpLiveFlv()) {
                    return 10;
                }
                int iInferContentType2 = inferContentType2(this.playbackProperties.uri);
                if (iInferContentType2 != 3) {
                    return iInferContentType2;
                }
                String scheme = this.playbackProperties.uri.getScheme();
                if (!TextUtils.isEmpty(scheme) && !SCHEME_LOCAL.equals(scheme)) {
                    if (SCHEME_ASSET.equals(scheme)) {
                        return 6;
                    }
                    if ("content".equals(scheme)) {
                        return 5;
                    }
                    if ("data".equals(scheme)) {
                        return 8;
                    }
                    if ("rawresource".equals(scheme)) {
                        return 7;
                    }
                    return "rtmp".equals(scheme) ? 9 : 3;
                }
            }
        }
        return i;
    }

    public boolean isFileDescriptor() {
        return this.playbackProperties.fdProperties != null;
    }

    public boolean isHttpLiveFlv() {
        String str = ((PlaybackProperties) AssertUtil.checkNotNull(this.playbackProperties)).overrideExtension;
        return str != null && (str.equals(Constants.URL_OVERRIDE_EXTENSION_HTTP_FLV) || str.equals(Constants.URL_OVERRIDE_EXTENSION_HTTP_LIVE_FLV));
    }

    public boolean isHttpRequestHeadersEmpty() {
        Map<String, String> map = ((PlaybackProperties) AssertUtil.checkNotNull(this.playbackProperties)).headers;
        return map == null || map.size() == 0;
    }

    public boolean isLocalFileUri() {
        int iInferContentType = inferContentType();
        return iInferContentType == 4 || iInferContentType == 5 || iInferContentType == 6 || iInferContentType == 7;
    }

    public synchronized PlaybackProperties nextBackupSource() {
        List<PlaybackProperties> list;
        int i;
        AssertUtil.checkState(hasNextBackupSource());
        list = this.backupUrlList;
        i = this.backupUrlListIndex;
        this.backupUrlListIndex = i + 1;
        return list.get(i);
    }

    public String toString() {
        return this.mediaId.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mediaId);
        parcel.writeParcelable(this.playbackProperties, i);
        parcel.writeList(this.backupUrlList);
        parcel.writeInt(this.loopCount);
        parcel.writeLong(this.clipStartPositionMs);
        parcel.writeLong(this.clipEndPositionMs);
        parcel.writeParcelable(this.cipherConfiguration, i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class PlaybackProperties implements Parcelable {
        public static final Parcelable.Creator<PlaybackProperties> CREATOR = new Parcelable.Creator<PlaybackProperties>() { // from class: com.oplus.tblplayer.misc.MediaUrl.PlaybackProperties.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PlaybackProperties createFromParcel(Parcel parcel) {
                return new PlaybackProperties(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PlaybackProperties[] newArray(int i) {
                return new PlaybackProperties[i];
            }
        };

        @Nullable
        public final String customCacheKey;

        @Nullable
        public final FileDescriptorProperties fdProperties;

        @Nullable
        public final Map<String, String> headers;

        @Nullable
        public final String mimeType;

        @Nullable
        public final String overrideExtension;

        @NonNull
        public final Uri uri;

        @Nullable
        public final String userAgent;

        private PlaybackProperties(@NonNull Uri uri, @Nullable String str, @Nullable String str2, @Nullable FileDescriptorProperties fileDescriptorProperties, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4) {
            this.uri = uri;
            this.mimeType = str;
            this.overrideExtension = str2;
            this.fdProperties = fileDescriptorProperties;
            this.userAgent = str3;
            this.headers = map;
            this.customCacheKey = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackProperties)) {
                return false;
            }
            PlaybackProperties playbackProperties = (PlaybackProperties) obj;
            return this.uri.equals(playbackProperties.uri) && Util.areEqual(this.mimeType, playbackProperties.mimeType) && Util.areEqual(this.overrideExtension, playbackProperties.overrideExtension) && Util.areEqual(this.fdProperties, playbackProperties.fdProperties) && Util.areEqual(this.userAgent, playbackProperties.userAgent) && Util.areEqual(this.headers, playbackProperties.headers) && Util.areEqual(this.customCacheKey, playbackProperties.customCacheKey);
        }

        public int hashCode() {
            int iHashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.overrideExtension;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            FileDescriptorProperties fileDescriptorProperties = this.fdProperties;
            int iHashCode4 = (iHashCode3 + (fileDescriptorProperties != null ? fileDescriptorProperties.hashCode() : 0)) * 31;
            String str3 = this.userAgent;
            int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Map<String, String> map = this.headers;
            int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
            String str4 = this.customCacheKey;
            return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.uri, i);
            parcel.writeString(this.mimeType);
            parcel.writeString(this.overrideExtension);
            parcel.writeParcelable(this.fdProperties, i);
            parcel.writeString(this.userAgent);
            parcel.writeMap(this.headers);
            parcel.writeString(this.customCacheKey);
        }

        public PlaybackProperties(Parcel parcel) {
            this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.mimeType = parcel.readString();
            this.overrideExtension = parcel.readString();
            this.fdProperties = (FileDescriptorProperties) parcel.readParcelable(FileDescriptorProperties.class.getClassLoader());
            this.userAgent = parcel.readString();
            this.headers = parcel.readHashMap(String.class.getClassLoader());
            this.customCacheKey = parcel.readString();
        }
    }

    public MediaUrl(@NonNull String str, @NonNull PlaybackProperties playbackProperties, @Nullable List<PlaybackProperties> list, int i, long j, long j2, @Nullable CipherConfiguration cipherConfiguration) {
        this.mediaId = str;
        this.playbackProperties = playbackProperties;
        this.backupUrlList = list;
        this.loopCount = i;
        this.clipStartPositionMs = j;
        this.clipEndPositionMs = j2;
        this.cipherConfiguration = cipherConfiguration;
    }

    public static MediaUrl fromUri(String str) {
        return new Builder(str).build();
    }
}
