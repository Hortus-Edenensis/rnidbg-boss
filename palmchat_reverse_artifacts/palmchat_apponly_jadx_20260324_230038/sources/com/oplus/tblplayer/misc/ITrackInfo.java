package com.oplus.tblplayer.misc;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ITrackInfo {
    public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int MEDIA_TRACK_TYPE_METADATA = 5;
    public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
    public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
    public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
    public static final int MEDIA_TRACK_TYPE_VIDEO = 1;

    /* JADX INFO: compiled from: SearchBox */
    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() { // from class: com.oplus.tblplayer.misc.ITrackInfo.SelectionOverride.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SelectionOverride[] newArray(int i) {
                return new SelectionOverride[i];
            }
        };
        public final int groupIndex;
        public final int length;
        public final int[] tracks;

        public SelectionOverride(int i, int... iArr) {
            this.groupIndex = i;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = iArrCopyOf;
            this.length = iArr.length;
            Arrays.sort(iArrCopyOf);
        }

        public boolean containsTrack(int i) {
            for (int i2 : this.tracks) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            return this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks);
        }

        public int hashCode() {
            return (this.groupIndex * 31) + Arrays.hashCode(this.tracks);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
        }

        public SelectionOverride(Parcel parcel) {
            this.groupIndex = parcel.readInt();
            int i = parcel.readByte();
            this.length = i;
            int[] iArr = new int[i];
            this.tracks = iArr;
            parcel.readIntArray(iArr);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class TrackInfoGroup {
        private final boolean adaptiveSupport;
        private final IMediaFormat[] formats;
        private int hashCode;
        public final int length;

        public TrackInfoGroup(boolean z, IMediaFormat... iMediaFormatArr) {
            Assertions.checkState(iMediaFormatArr.length > 0);
            this.adaptiveSupport = z;
            this.formats = iMediaFormatArr;
            this.length = iMediaFormatArr.length;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackInfoGroup.class != obj.getClass()) {
                return false;
            }
            TrackInfoGroup trackInfoGroup = (TrackInfoGroup) obj;
            return this.length == trackInfoGroup.length && Arrays.equals(this.formats, trackInfoGroup.formats);
        }

        public IMediaFormat getFormat(int i) {
            return this.formats[i];
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                this.hashCode = 527 + Arrays.hashCode(this.formats);
            }
            return this.hashCode;
        }

        public int indexOf(IMediaFormat iMediaFormat) {
            int i = 0;
            while (true) {
                IMediaFormat[] iMediaFormatArr = this.formats;
                if (i >= iMediaFormatArr.length) {
                    return -1;
                }
                if (iMediaFormat == iMediaFormatArr[i]) {
                    return i;
                }
                i++;
            }
        }

        public boolean isAdaptiveSupport() {
            return this.adaptiveSupport;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TrackType {
    }

    IMediaFormat getFormat();

    String getLanguage();

    SelectionOverride getSelectionOverride();

    TrackInfoGroup getTrackInfoGroup(int i);

    int getTrackType();

    boolean isAutoSelected();

    boolean isDisabled();

    int size();

    String toLineString();
}
