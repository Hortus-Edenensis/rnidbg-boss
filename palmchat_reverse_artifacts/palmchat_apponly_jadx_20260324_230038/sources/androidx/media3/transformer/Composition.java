package androidx.media3.transformer;

import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Composition {
    public static final int HDR_MODE_EXPERIMENTAL_FORCE_INTERPRET_HDR_AS_SDR = 3;
    public static final int HDR_MODE_KEEP_HDR = 0;
    public static final int HDR_MODE_TONE_MAP_HDR_TO_SDR_USING_MEDIACODEC = 1;
    public static final int HDR_MODE_TONE_MAP_HDR_TO_SDR_USING_OPEN_GL = 2;
    public final Effects effects;

    @Deprecated
    public final boolean forceAudioTrack;
    public final int hdrMode;
    public final boolean retainHdrFromUltraHdrImage;
    public final ImmutableList<EditedMediaItemSequence> sequences;
    public final boolean transmuxAudio;
    public final boolean transmuxVideo;
    public final VideoCompositorSettings videoCompositorSettings;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private Effects effects;
        private boolean forceAudioTrack;
        private int hdrMode;
        private boolean retainHdrFromUltraHdrImage;
        private ImmutableList<EditedMediaItemSequence> sequences;
        private boolean transmuxAudio;
        private boolean transmuxVideo;
        private VideoCompositorSettings videoCompositorSettings;

        public Composition build() {
            ImmutableList<EditedMediaItemSequence> immutableListE;
            if (this.forceAudioTrack) {
                ImmutableList.a aVar = new ImmutableList.a();
                for (int i = 0; i < this.sequences.size(); i++) {
                    aVar.a(this.sequences.get(i).buildUpon().experimentalSetForceAudioTrack(this.forceAudioTrack).build());
                }
                immutableListE = aVar.e();
            } else {
                immutableListE = this.sequences;
            }
            ImmutableList<EditedMediaItemSequence> immutableList = immutableListE;
            VideoCompositorSettings videoCompositorSettings = this.videoCompositorSettings;
            Effects effects = this.effects;
            boolean z = this.forceAudioTrack;
            boolean z2 = this.transmuxAudio;
            boolean z3 = this.transmuxVideo;
            int i2 = this.hdrMode;
            return new Composition(immutableList, videoCompositorSettings, effects, z, z2, z3, i2, this.retainHdrFromUltraHdrImage && i2 == 0);
        }

        @Deprecated
        public Builder experimentalSetForceAudioTrack(boolean z) {
            this.forceAudioTrack = z;
            return this;
        }

        public Builder experimentalSetRetainHdrFromUltraHdrImage(boolean z) {
            this.retainHdrFromUltraHdrImage = z;
            return this;
        }

        public Builder setEffects(Effects effects) {
            this.effects = effects;
            return this;
        }

        public Builder setHdrMode(int i) {
            this.hdrMode = i;
            return this;
        }

        public Builder setSequences(List<EditedMediaItemSequence> list) {
            Assertions.checkArgument(!list.isEmpty(), "The composition must contain at least one EditedMediaItemSequence.");
            this.sequences = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public Builder setTransmuxAudio(boolean z) {
            this.transmuxAudio = z;
            return this;
        }

        public Builder setTransmuxVideo(boolean z) {
            this.transmuxVideo = z;
            return this;
        }

        public Builder setVideoCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
            this.videoCompositorSettings = videoCompositorSettings;
            return this;
        }

        public Builder(EditedMediaItemSequence editedMediaItemSequence, EditedMediaItemSequence... editedMediaItemSequenceArr) {
            this(new ImmutableList.a().a(editedMediaItemSequence).k(editedMediaItemSequenceArr).e());
        }

        public Builder(List<EditedMediaItemSequence> list) {
            Assertions.checkArgument(!list.isEmpty(), "The composition must contain at least one EditedMediaItemSequence.");
            this.sequences = ImmutableList.copyOf((Collection) list);
            this.videoCompositorSettings = VideoCompositorSettings.DEFAULT;
            this.effects = Effects.EMPTY;
        }

        private Builder(Composition composition) {
            this.sequences = composition.sequences;
            this.videoCompositorSettings = composition.videoCompositorSettings;
            this.effects = composition.effects;
            this.forceAudioTrack = composition.forceAudioTrack;
            this.transmuxAudio = composition.transmuxAudio;
            this.transmuxVideo = composition.transmuxVideo;
            this.hdrMode = composition.hdrMode;
            this.retainHdrFromUltraHdrImage = composition.retainHdrFromUltraHdrImage;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HdrMode {
    }

    private static boolean hasNonLoopingSequence(List<EditedMediaItemSequence> list) {
        Iterator<EditedMediaItemSequence> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isLooping) {
                return true;
            }
        }
        return false;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean hasGaps() {
        for (int i = 0; i < this.sequences.size(); i++) {
            if (this.sequences.get(i).hasGaps()) {
                return true;
            }
        }
        return false;
    }

    private Composition(List<EditedMediaItemSequence> list, VideoCompositorSettings videoCompositorSettings, Effects effects, boolean z, boolean z2, boolean z3, int i, boolean z4) {
        Assertions.checkArgument((z2 && z) ? false : true, "Audio transmuxing and audio track forcing are not allowed together.");
        Assertions.checkArgument(hasNonLoopingSequence(list), "Composition must have at least one non-looping sequence.");
        this.sequences = ImmutableList.copyOf((Collection) list);
        this.videoCompositorSettings = videoCompositorSettings;
        this.effects = effects;
        this.transmuxAudio = z2;
        this.transmuxVideo = z3;
        this.forceAudioTrack = z;
        this.hdrMode = i;
        this.retainHdrFromUltraHdrImage = z4;
    }
}
