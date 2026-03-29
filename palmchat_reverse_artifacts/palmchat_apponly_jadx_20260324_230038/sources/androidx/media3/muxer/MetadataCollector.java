package androidx.media3.muxer;

import androidx.media3.common.Metadata;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4OrientationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.XmpData;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class MetadataCollector {
    public Mp4LocationData locationData;
    public Mp4TimestampData timestampData;
    public XmpData xmpData;
    public Mp4OrientationData orientationData = new Mp4OrientationData(0);
    public Set<MdtaMetadataEntry> metadataEntries = new HashSet();

    public MetadataCollector() {
        long jUnixTimeToMp4TimeSeconds = Mp4TimestampData.unixTimeToMp4TimeSeconds(System.currentTimeMillis());
        this.timestampData = new Mp4TimestampData(jUnixTimeToMp4TimeSeconds, jUnixTimeToMp4TimeSeconds);
    }

    public void addMetadata(Metadata.Entry entry) {
        if (entry instanceof Mp4OrientationData) {
            this.orientationData = (Mp4OrientationData) entry;
            return;
        }
        if (entry instanceof Mp4LocationData) {
            this.locationData = (Mp4LocationData) entry;
            return;
        }
        if (entry instanceof Mp4TimestampData) {
            this.timestampData = (Mp4TimestampData) entry;
        } else if (entry instanceof MdtaMetadataEntry) {
            this.metadataEntries.add((MdtaMetadataEntry) entry);
        } else {
            if (!(entry instanceof XmpData)) {
                throw new IllegalArgumentException("Unsupported metadata");
            }
            this.xmpData = (XmpData) entry;
        }
    }

    public void removeMdtaMetadataEntry(MdtaMetadataEntry mdtaMetadataEntry) {
        this.metadataEntries.remove(mdtaMetadataEntry);
    }
}
