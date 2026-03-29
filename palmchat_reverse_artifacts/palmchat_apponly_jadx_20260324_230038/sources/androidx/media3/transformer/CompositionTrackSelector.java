package androidx.media3.transformer;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import defpackage.sv4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class CompositionTrackSelector extends TrackSelector {
    private EditedMediaItem currentEditedMediaItem;
    private EditedMediaItemSequence sequence;
    private final TrackSelectorInternal trackSelectorInternal;

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onVideoTrackSelection(boolean z, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class TrackSelectorInternal extends DefaultTrackSelector {
        private static final String SILENCE_AUDIO_TRACK_GROUP_ID = "1:";
        private boolean disableVideoPlayback;
        private final Listener listener;
        private final int sequenceIndex;

        public TrackSelectorInternal(Context context, Listener listener, int i) {
            super(context);
            this.sequenceIndex = i;
            this.listener = listener;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector
        @Nullable
        public Pair<ExoTrackSelection.Definition, Integer> selectAudioTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, DefaultTrackSelector.Parameters parameters) throws ExoPlaybackException {
            int i = 0;
            while (true) {
                if (i >= mappedTrackInfo.getRendererCount()) {
                    i = -1;
                    break;
                }
                if (mappedTrackInfo.getRendererType(i) == 1) {
                    break;
                }
                i++;
            }
            Assertions.checkState(i != -1);
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
            if (trackGroups.length > 1) {
                if (((EditedMediaItem) Assertions.checkNotNull(CompositionTrackSelector.this.currentEditedMediaItem)).removeAudio) {
                    for (int i2 = 0; i2 < trackGroups.length; i2++) {
                        if (!trackGroups.get(i2).id.startsWith(SILENCE_AUDIO_TRACK_GROUP_ID)) {
                            for (int i3 = 0; i3 < trackGroups.get(i2).length; i3++) {
                                iArr[i][i2][i3] = sv4.c(0);
                            }
                        }
                    }
                } else {
                    int i4 = -1;
                    boolean z = false;
                    for (int i5 = 0; i5 < trackGroups.length; i5++) {
                        if (trackGroups.get(i5).id.startsWith(SILENCE_AUDIO_TRACK_GROUP_ID)) {
                            i4 = i5;
                        } else {
                            for (int i6 = 0; i6 < trackGroups.get(i5).length; i6++) {
                                z |= sv4.k(iArr[i][i5][i6]) == 4;
                            }
                        }
                    }
                    Assertions.checkState(i4 != -1);
                    if (z) {
                        iArr[i][trackGroups.length - 1][0] = sv4.c(0);
                    }
                }
            }
            return super.selectAudioTrack(mappedTrackInfo, iArr, iArr2, parameters);
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector
        @Nullable
        public Pair<ExoTrackSelection.Definition, Integer> selectImageTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, DefaultTrackSelector.Parameters parameters) throws ExoPlaybackException {
            Pair<ExoTrackSelection.Definition, Integer> pairSelectImageTrack = super.selectImageTrack(mappedTrackInfo, iArr, parameters);
            if (this.disableVideoPlayback) {
                pairSelectImageTrack = null;
            }
            this.listener.onVideoTrackSelection(pairSelectImageTrack != null, this.sequenceIndex);
            return pairSelectImageTrack;
        }

        @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector
        @Nullable
        public Pair<ExoTrackSelection.Definition, Integer> selectVideoTrack(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, DefaultTrackSelector.Parameters parameters, @Nullable String str) throws ExoPlaybackException {
            Pair<ExoTrackSelection.Definition, Integer> pairSelectVideoTrack = super.selectVideoTrack(mappedTrackInfo, iArr, iArr2, parameters, str);
            if (this.disableVideoPlayback) {
                pairSelectVideoTrack = null;
            }
            this.listener.onVideoTrackSelection(pairSelectVideoTrack != null, this.sequenceIndex);
            return pairSelectVideoTrack;
        }

        public void setDisableVideoPlayback(boolean z) {
            this.disableVideoPlayback = z;
        }
    }

    public CompositionTrackSelector(Context context, Listener listener, int i) {
        this.trackSelectorInternal = new TrackSelectorInternal(context, listener, i);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public TrackSelectionParameters getParameters() {
        return this.trackSelectorInternal.getParameters();
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public void init(TrackSelector.InvalidationListener invalidationListener, BandwidthMeter bandwidthMeter) {
        super.init(invalidationListener, bandwidthMeter);
        this.trackSelectorInternal.init(invalidationListener, bandwidthMeter);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public boolean isSetParametersSupported() {
        return true;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public void onSelectionActivated(@Nullable Object obj) {
        this.trackSelectorInternal.onSelectionActivated(obj);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        this.currentEditedMediaItem = EditedMediaItemSequence.getEditedMediaItem((EditedMediaItemSequence) Assertions.checkStateNotNull(this.sequence), timeline.getIndexOfPeriod(mediaPeriodId.periodUid));
        return this.trackSelectorInternal.selectTracks(rendererCapabilitiesArr, trackGroupArray, mediaPeriodId, timeline);
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelector
    public void setParameters(TrackSelectionParameters trackSelectionParameters) {
        this.trackSelectorInternal.setParameters(trackSelectionParameters);
    }

    public void setSequence(EditedMediaItemSequence editedMediaItemSequence) {
        this.sequence = editedMediaItemSequence;
        boolean z = false;
        for (int i = 0; i < editedMediaItemSequence.editedMediaItems.size(); i++) {
            z |= editedMediaItemSequence.editedMediaItems.get(i).removeVideo;
        }
        this.trackSelectorInternal.setDisableVideoPlayback(z);
    }
}
