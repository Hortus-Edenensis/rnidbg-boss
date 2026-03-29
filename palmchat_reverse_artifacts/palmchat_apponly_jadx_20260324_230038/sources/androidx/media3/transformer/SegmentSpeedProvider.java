package androidx.media3.transformer;

import androidx.media3.common.Metadata;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class SegmentSpeedProvider implements SpeedProvider {
    private static final int INPUT_FRAME_RATE = 30;
    private final float baseSpeedMultiplier;
    private final ImmutableSortedMap<Long, Float> speedsByStartTimeUs;

    public SegmentSpeedProvider(Metadata metadata) {
        float captureFrameRate = getCaptureFrameRate(metadata);
        float f = captureFrameRate == -3.4028235E38f ? 1.0f : captureFrameRate / 30.0f;
        this.baseSpeedMultiplier = f;
        this.speedsByStartTimeUs = buildSpeedByStartTimeUsMap(metadata, f);
    }

    private static ImmutableSortedMap<Long, Float> buildSpeedByStartTimeUsMap(Metadata metadata, float f) {
        ImmutableList<SlowMotionData.Segment> immutableListExtractSlowMotionSegments = extractSlowMotionSegments(metadata);
        if (immutableListExtractSlowMotionSegments.isEmpty()) {
            return ImmutableSortedMap.of();
        }
        TreeMap treeMap = new TreeMap();
        for (int i = 0; i < immutableListExtractSlowMotionSegments.size(); i++) {
            treeMap.put(Long.valueOf(Util.msToUs(immutableListExtractSlowMotionSegments.get(i).startTimeMs)), Float.valueOf(f / r3.speedDivisor));
        }
        for (int i2 = 0; i2 < immutableListExtractSlowMotionSegments.size(); i2++) {
            SlowMotionData.Segment segment = immutableListExtractSlowMotionSegments.get(i2);
            if (!treeMap.containsKey(Long.valueOf(Util.msToUs(segment.endTimeMs)))) {
                treeMap.put(Long.valueOf(Util.msToUs(segment.endTimeMs)), Float.valueOf(f));
            }
        }
        return ImmutableSortedMap.copyOf((Map) treeMap);
    }

    private static ImmutableList<SlowMotionData.Segment> extractSlowMotionSegments(Metadata metadata) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof SlowMotionData) {
                arrayList.addAll(((SlowMotionData) entry).segments);
            }
        }
        return ImmutableList.sortedCopyOf(SlowMotionData.Segment.BY_START_THEN_END_THEN_DIVISOR, arrayList);
    }

    private static float getCaptureFrameRate(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof SmtaMetadataEntry) {
                return ((SmtaMetadataEntry) entry).captureFrameRate;
            }
        }
        return -3.4028235E38f;
    }

    @Override // androidx.media3.common.audio.SpeedProvider
    public long getNextSpeedChangeTimeUs(long j) {
        Assertions.checkArgument(j >= 0);
        Long lHigherKey = this.speedsByStartTimeUs.higherKey(Long.valueOf(j));
        if (lHigherKey != null) {
            return lHigherKey.longValue();
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.common.audio.SpeedProvider
    public float getSpeed(long j) {
        Assertions.checkArgument(j >= 0);
        Map.Entry<Long, Float> entryFloorEntry = this.speedsByStartTimeUs.floorEntry(Long.valueOf(j));
        return entryFloorEntry != null ? entryFloorEntry.getValue().floatValue() : this.baseSpeedMultiplier;
    }
}
