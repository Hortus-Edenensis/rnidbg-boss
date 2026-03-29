package androidx.media3.common.audio;

import android.util.Pair;
import androidx.annotation.IntRange;
import androidx.media3.common.audio.DefaultGainProvider;
import androidx.media3.common.audio.GainProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.Range;
import com.google.common.collect.w0;
import defpackage.u42;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DefaultGainProvider implements GainProcessor.GainProvider {
    private static final float GAIN_UNSET = -3.4028235E38f;
    private final float defaultGain;
    private final w0<Long, u42<Pair<Long, Integer>, Float>> gainMap;
    public static final FadeProvider FADE_IN_LINEAR = new FadeProvider() { // from class: l51
        @Override // androidx.media3.common.audio.DefaultGainProvider.FadeProvider
        public final float getGainFactorAt(long j, long j2) {
            return DefaultGainProvider.lambda$static$0(j, j2);
        }
    };
    public static final FadeProvider FADE_OUT_LINEAR = new FadeProvider() { // from class: m51
        @Override // androidx.media3.common.audio.DefaultGainProvider.FadeProvider
        public final float getGainFactorAt(long j, long j2) {
            return DefaultGainProvider.lambda$static$1(j, j2);
        }
    };
    public static final FadeProvider FADE_IN_EQUAL_POWER = new FadeProvider() { // from class: n51
        @Override // androidx.media3.common.audio.DefaultGainProvider.FadeProvider
        public final float getGainFactorAt(long j, long j2) {
            return DefaultGainProvider.lambda$static$2(j, j2);
        }
    };
    public static final FadeProvider FADE_OUT_EQUAL_POWER = new FadeProvider() { // from class: o51
        @Override // androidx.media3.common.audio.DefaultGainProvider.FadeProvider
        public final float getGainFactorAt(long j, long j2) {
            return DefaultGainProvider.lambda$static$3(j, j2);
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private final float defaultGain;
        private final w0<Long, u42<Pair<Long, Integer>, Float>> gainMap;

        public Builder(float f) {
            w0<Long, u42<Pair<Long, Integer>, Float>> w0VarB = w0.b();
            this.gainMap = w0VarB;
            this.defaultGain = f;
            w0VarB.e(Range.all(), new u42() { // from class: q51
                @Override // defpackage.u42
                public final Object apply(Object obj) {
                    return DefaultGainProvider.Builder.lambda$new$0((Pair) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Float lambda$addFadeAt$1(long j, FadeProvider fadeProvider, long j2, Pair pair) {
            int iIntValue = ((Integer) pair.second).intValue();
            return Float.valueOf(fadeProvider.getGainFactorAt(((Long) pair.first).longValue() - Util.durationUsToSampleCount(j, iIntValue), Util.durationUsToSampleCount(j2, iIntValue)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Float lambda$new$0(Pair pair) {
            return Float.valueOf(-3.4028235E38f);
        }

        public Builder addFadeAt(@IntRange(from = 0) final long j, @IntRange(from = 1) final long j2, final FadeProvider fadeProvider) {
            Assertions.checkArgument(j >= 0);
            Assertions.checkArgument(j2 > 1);
            this.gainMap.e(Range.closedOpen(Long.valueOf(j), Long.valueOf(j + j2)), new u42() { // from class: p51
                @Override // defpackage.u42
                public final Object apply(Object obj) {
                    return DefaultGainProvider.Builder.lambda$addFadeAt$1(j, fadeProvider, j2, (Pair) obj);
                }
            });
            return this;
        }

        public DefaultGainProvider build() {
            return new DefaultGainProvider(this.gainMap, this.defaultGain);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface FadeProvider {
        float getGainFactorAt(@IntRange(from = 0) long j, @IntRange(from = 1) long j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$0(long j, long j2) {
        return j / j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$1(long j, long j2) {
        return (j2 - j) / j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$2(long j, long j2) {
        return (float) Math.sin((j * 1.5707963267948966d) / j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$static$3(long j, long j2) {
        return (float) Math.cos((j * 1.5707963267948966d) / j2);
    }

    @Override // androidx.media3.common.audio.GainProcessor.GainProvider
    public float getGainFactorAtSamplePosition(@IntRange(from = 0) long j, @IntRange(from = 1) int i) {
        Assertions.checkState(i > 0);
        Assertions.checkArgument(j >= 0);
        float fFloatValue = ((Float) ((u42) Assertions.checkNotNull(this.gainMap.c(Long.valueOf(Util.sampleCountToDurationUs(j, i))))).apply(Pair.create(Long.valueOf(j), Integer.valueOf(i)))).floatValue();
        return fFloatValue == -3.4028235E38f ? this.defaultGain : fFloatValue;
    }

    @Override // androidx.media3.common.audio.GainProcessor.GainProvider
    public long isUnityUntil(@IntRange(from = 0) long j, @IntRange(from = 1) int i) {
        Assertions.checkState(i > 0);
        Assertions.checkArgument(j >= 0);
        Map.Entry entry = (Map.Entry) Assertions.checkNotNull(this.gainMap.d(Long.valueOf(Util.sampleCountToDurationUs(j, i))));
        float fFloatValue = ((Float) ((u42) entry.getValue()).apply(Pair.create(Long.valueOf(j), Integer.valueOf(i)))).floatValue();
        if (fFloatValue == 1.0f) {
            return j + 1;
        }
        if (this.defaultGain != 1.0f || fFloatValue != -3.4028235E38f) {
            return -9223372036854775807L;
        }
        if (((Range) entry.getKey()).hasUpperBound()) {
            return Util.durationUsToSampleCount(((Long) ((Range) entry.getKey()).upperEndpoint()).longValue(), i);
        }
        return Long.MIN_VALUE;
    }

    private DefaultGainProvider(w0<Long, u42<Pair<Long, Integer>, Float>> w0Var, float f) {
        w0<Long, u42<Pair<Long, Integer>, Float>> w0VarB = w0.b();
        this.gainMap = w0VarB;
        w0VarB.f(w0Var);
        this.defaultGain = f;
    }
}
