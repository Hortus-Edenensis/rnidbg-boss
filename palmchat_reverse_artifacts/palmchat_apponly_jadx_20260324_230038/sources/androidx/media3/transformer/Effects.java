package androidx.media3.transformer;

import android.util.Pair;
import androidx.media3.common.Effect;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SpeedChangingAudioProcessor;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.TimestampConsumer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.TimestampAdjustment;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Effects {
    public static final Effects EMPTY = new Effects(ImmutableList.of(), ImmutableList.of());
    public final ImmutableList<AudioProcessor> audioProcessors;
    public final ImmutableList<Effect> videoEffects;

    public Effects(List<AudioProcessor> list, List<Effect> list2) {
        this.audioProcessors = ImmutableList.copyOf((Collection) list);
        this.videoEffects = ImmutableList.copyOf((Collection) list2);
    }

    public static Pair<AudioProcessor, Effect> createExperimentalSpeedChangingEffect(SpeedProvider speedProvider) {
        final SpeedChangingAudioProcessor speedChangingAudioProcessor = new SpeedChangingAudioProcessor(speedProvider);
        return Pair.create(speedChangingAudioProcessor, new TimestampAdjustment(new TimestampAdjustment.TimestampMap() { // from class: mk1
            @Override // androidx.media3.effect.TimestampAdjustment.TimestampMap
            public final void calculateOutputTimeUs(long j, TimestampConsumer timestampConsumer) {
                speedChangingAudioProcessor.getSpeedAdjustedTimeAsync(j, timestampConsumer);
            }
        }, speedProvider));
    }
}
