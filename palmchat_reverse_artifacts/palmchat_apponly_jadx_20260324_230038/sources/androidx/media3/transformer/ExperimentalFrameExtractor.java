package androidx.media3.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.effect.BaseGlShaderProgram;
import androidx.media3.effect.GlEffect;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.MatrixTransformation;
import androidx.media3.effect.PassthroughShaderProgram;
import androidx.media3.effect.ScaleAndRotateTransformation;
import androidx.media3.effect.y0;
import androidx.media3.effect.z0;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.transformer.ExperimentalFrameExtractor;
import com.google.common.collect.ImmutableList;
import defpackage.bl0;
import defpackage.er3;
import defpackage.g23;
import defpackage.ik1;
import defpackage.nc;
import defpackage.o65;
import defpackage.r33;
import defpackage.x42;
import defpackage.z42;
import defpackage.zb2;
import j$.util.Objects;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ExperimentalFrameExtractor {
    private final Configuration configuration;
    private final AtomicBoolean extractedFrameNeedsRendering;
    private final AtomicReference<CallbackToFutureAdapter.Completer<Frame>> frameBeingExtractedCompleterAtomicReference;

    @Nullable
    private Frame lastExtractedFrame;
    private r33<Frame> lastRequestedFrameFuture;
    private final ExoPlayer player;
    private final Handler playerApplicationThreadHandler;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Configuration {
        public final boolean extractHdrFrames;
        public final MediaCodecSelector mediaCodecSelector;
        public final SeekParameters seekParameters;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Builder {
            private SeekParameters seekParameters = SeekParameters.DEFAULT;
            private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.PREFER_SOFTWARE;
            private boolean extractHdrFrames = false;

            public Configuration build() {
                return new Configuration(this.seekParameters, this.mediaCodecSelector, this.extractHdrFrames);
            }

            @RequiresApi(34)
            public Builder setExtractHdrFrames(boolean z) {
                this.extractHdrFrames = z;
                return this;
            }

            public Builder setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
                this.mediaCodecSelector = mediaCodecSelector;
                return this;
            }

            public Builder setSeekParameters(SeekParameters seekParameters) {
                this.seekParameters = seekParameters;
                return this;
            }
        }

        private Configuration(SeekParameters seekParameters, MediaCodecSelector mediaCodecSelector, boolean z) {
            this.seekParameters = seekParameters;
            this.mediaCodecSelector = mediaCodecSelector;
            this.extractHdrFrames = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Frame {
        public final Bitmap bitmap;
        public final long presentationTimeMs;

        private Frame(long j, Bitmap bitmap) {
            this.presentationTimeMs = j;
            this.bitmap = bitmap;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class FrameExtractorRenderer extends MediaCodecVideoRenderer {
        private List<Effect> effectsFromPlayer;
        private boolean frameRenderedSinceLastPositionReset;

        @Nullable
        private Effect rotation;
        private final boolean toneMapHdrToSdr;

        public FrameExtractorRenderer(Context context, MediaCodecSelector mediaCodecSelector, VideoRendererEventListener videoRendererEventListener, boolean z) {
            super(new MediaCodecVideoRenderer.Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(0L).setEventHandler(Util.createHandlerForCurrentOrMainLooper()).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(0));
            this.toneMapHdrToSdr = z;
            this.effectsFromPlayer = ImmutableList.of();
        }

        private void setEffectsWithRotation() {
            ImmutableList.a aVar = new ImmutableList.a();
            Effect effect = this.rotation;
            if (effect != null) {
                aVar.a(effect);
            }
            aVar.l(this.effectsFromPlayer);
            super.setVideoEffects(aVar.e());
        }

        private void setRotation(@Nullable Effect effect) {
            this.rotation = effect;
            setEffectsWithRotation();
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
        public boolean isReady() {
            return this.frameRenderedSinceLastPositionReset;
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        @CallSuper
        public boolean maybeInitializeProcessingPipeline(Format format) throws ExoPlaybackException {
            if (ColorInfo.isTransferHdr(format.colorInfo) && this.toneMapHdrToSdr) {
                format = format.buildUpon().setColorInfo(ColorInfo.SDR_BT709_LIMITED).build();
            }
            return super.maybeInitializeProcessingPipeline(format);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        @Nullable
        public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
            Format format = formatHolder.format;
            if (format != null && format.rotationDegrees != 0) {
                setRotation(new ScaleAndRotateTransformation.Builder().setRotationDegrees(360 - format.rotationDegrees).build());
                formatHolder.format = format.buildUpon().setRotationDegrees(0).build();
            }
            return super.onInputFormatChanged(formatHolder);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
            this.frameRenderedSinceLastPositionReset = false;
            ExperimentalFrameExtractor.this.extractedFrameNeedsRendering.set(true);
            super.onPositionReset(j, z);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
        public void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
            super.onStreamChanged(formatArr, j, j2, mediaPeriodId);
            this.frameRenderedSinceLastPositionReset = false;
            setRotation(null);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
        public boolean processOutputBuffer(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
            if (this.frameRenderedSinceLastPositionReset) {
                return false;
            }
            return super.processOutputBuffer(j, j2, mediaCodecAdapter, byteBuffer, i, i2, i3, j3, z, z2, format);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
        public void render(long j, long j2) throws ExoPlaybackException {
            if (this.frameRenderedSinceLastPositionReset) {
                return;
            }
            super.render(j, j2);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
            if (this.frameRenderedSinceLastPositionReset) {
                return;
            }
            this.frameRenderedSinceLastPositionReset = true;
            super.renderOutputBufferV21(mediaCodecAdapter, i, j, j2);
        }

        @Override // androidx.media3.exoplayer.video.MediaCodecVideoRenderer
        public void setVideoEffects(List<Effect> list) {
            this.effectsFromPlayer = list;
            setEffectsWithRotation();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class FrameReader implements GlEffect {
        private FrameReader() {
        }

        @Override // androidx.media3.common.Effect
        public /* synthetic */ long getDurationAfterEffectApplied(long j) {
            return ik1.a(this, j);
        }

        @Override // androidx.media3.effect.GlEffect
        public /* synthetic */ boolean isNoOp(int i, int i2) {
            return zb2.a(this, i, i2);
        }

        @Override // androidx.media3.effect.GlEffect
        public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
            return ExperimentalFrameExtractor.this.new FrameReadingGlShaderProgram(context, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class FrameReadingGlShaderProgram extends PassthroughShaderProgram {
        private static final int BYTES_PER_PIXEL = 4;
        private ByteBuffer byteBuffer;
        private GlProgram glProgram;
        private GlTextureInfo hlgTextureInfo;
        private final boolean useHdr;
        private final ImmutableList<float[]> visiblePolygon;

        public FrameReadingGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
            ImmutableList<float[]> immutableListOf = ImmutableList.of(new float[]{-1.0f, -1.0f, 0.0f, 1.0f}, new float[]{-1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, -1.0f, 0.0f, 1.0f});
            this.visiblePolygon = immutableListOf;
            this.byteBuffer = ByteBuffer.allocateDirect(0);
            this.useHdr = z;
            if (z) {
                Assertions.checkState(Build.VERSION.SDK_INT >= 34);
                try {
                    GlProgram glProgram = new GlProgram(context, "shaders/vertex_shader_transformation_es3.glsl", "shaders/fragment_shader_oetf_es3.glsl");
                    this.glProgram = glProgram;
                    glProgram.setFloatsUniform("uTexTransformationMatrix", GlUtil.create4x4IdentityMatrix());
                    this.glProgram.setFloatsUniform("uTransformationMatrix", GlUtil.create4x4IdentityMatrix());
                    this.glProgram.setFloatsUniform("uRgbMatrix", GlUtil.create4x4IdentityMatrix());
                    this.glProgram.setIntUniform("uOutputColorTransfer", 7);
                    this.glProgram.setBufferAttribute("aFramePosition", GlUtil.createVertexBuffer(immutableListOf), 4);
                } catch (GlUtil.GlException | IOException e) {
                    throw new VideoFrameProcessingException(e);
                }
            }
        }

        private void ensureConfigured(GlObjectsProvider glObjectsProvider, int i, int i2) {
            int i3 = i * i2 * 4;
            if (this.byteBuffer.capacity() != i3) {
                this.byteBuffer = ByteBuffer.allocateDirect(i3);
            }
            this.byteBuffer.clear();
            if (this.useHdr) {
                GlTextureInfo glTextureInfo = this.hlgTextureInfo;
                if (glTextureInfo != null && glTextureInfo.width == i && glTextureInfo.height == i2) {
                    return;
                }
                if (glTextureInfo != null) {
                    try {
                        glTextureInfo.release();
                    } catch (GlUtil.GlException e) {
                        onError(e);
                        return;
                    }
                }
                this.hlgTextureInfo = glObjectsProvider.createBuffersForTexture(GlUtil.createRgb10A2Texture(i, i2), i, i2);
            }
        }

        @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
        public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
            Bitmap bitmapCreateBitmap;
            GlTextureInfo glTextureInfo2;
            ensureConfigured(glObjectsProvider, glTextureInfo.width, glTextureInfo.height);
            if (!this.useHdr) {
                try {
                    GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
                    GlUtil.checkGlError();
                    GLES20.glReadPixels(0, 0, glTextureInfo.width, glTextureInfo.height, 6408, 5121, this.byteBuffer);
                    GlUtil.checkGlError();
                    bitmapCreateBitmap = Bitmap.createBitmap(glTextureInfo.width, glTextureInfo.height, Bitmap.Config.ARGB_8888);
                } catch (GlUtil.GlException e) {
                    onError(e);
                    return;
                }
            } else {
                if (Build.VERSION.SDK_INT < 34 || (glTextureInfo2 = this.hlgTextureInfo) == null) {
                    onError(ExoPlaybackException.createForUnexpected(new IllegalArgumentException(), -2));
                    return;
                }
                try {
                    GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo2.fboId, glTextureInfo2.width, glTextureInfo2.height);
                    GlUtil.checkGlError();
                    ((GlProgram) Assertions.checkNotNull(this.glProgram)).use();
                    this.glProgram.setSamplerTexIdUniform("uTexSampler", glTextureInfo.texId, 0);
                    this.glProgram.bindAttributesAndUniforms();
                    GLES20.glDrawArrays(6, 0, this.visiblePolygon.size());
                    GlUtil.checkGlError();
                    GlTextureInfo glTextureInfo3 = this.hlgTextureInfo;
                    GLES20.glReadPixels(0, 0, glTextureInfo3.width, glTextureInfo3.height, 6408, 33640, this.byteBuffer);
                    GlUtil.checkGlError();
                    GlTextureInfo glTextureInfo4 = this.hlgTextureInfo;
                    bitmapCreateBitmap = Bitmap.createBitmap((DisplayMetrics) null, glTextureInfo4.width, glTextureInfo4.height, Bitmap.Config.RGBA_1010102, false, ColorSpace.get(ColorSpace.Named.BT2020_HLG));
                } catch (GlUtil.GlException e2) {
                    onError(e2);
                    return;
                }
            }
            bitmapCreateBitmap.copyPixelsFromBuffer(this.byteBuffer);
            ((CallbackToFutureAdapter.Completer) Assertions.checkNotNull((CallbackToFutureAdapter.Completer) ExperimentalFrameExtractor.this.frameBeingExtractedCompleterAtomicReference.getAndSet(null))).set(new Frame(Util.usToMs(j), bitmapCreateBitmap));
            getInputListener().onInputFrameProcessed(glTextureInfo);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class PlayerListener implements AnalyticsListener {
        private PlayerListener() {
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
            nc.a(this, eventTime, audioAttributes);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
            nc.b(this, eventTime, exc);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
            nc.c(this, eventTime, str, j);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
            nc.e(this, eventTime, str);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            nc.f(this, eventTime, decoderCounters);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            nc.g(this, eventTime, decoderCounters);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            nc.h(this, eventTime, format, decoderReuseEvaluation);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j) {
            nc.i(this, eventTime, j);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i) {
            nc.j(this, eventTime, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
            nc.k(this, eventTime, exc);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioTrackInitialized(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
            nc.l(this, eventTime, audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioTrackReleased(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
            nc.m(this, eventTime, audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
            nc.n(this, eventTime, i, j, j2);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAvailableCommandsChanged(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
            nc.o(this, eventTime, commands);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
            nc.p(this, eventTime, i, j, j2);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onCues(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
            nc.q(this, eventTime, cueGroup);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDeviceInfoChanged(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
            nc.s(this, eventTime, deviceInfo);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDeviceVolumeChanged(AnalyticsListener.EventTime eventTime, int i, boolean z) {
            nc.t(this, eventTime, i, z);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            nc.u(this, eventTime, mediaLoadData);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
            nc.v(this, eventTime);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
            nc.w(this, eventTime);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
            nc.x(this, eventTime);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
            nc.y(this, eventTime);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
            nc.A(this, eventTime, exc);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
            nc.B(this, eventTime);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
            nc.C(this, eventTime, i, j);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onEvents(Player player, AnalyticsListener.Events events) {
            nc.D(this, player, events);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            nc.E(this, eventTime, z);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            nc.F(this, eventTime, z);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            nc.G(this, eventTime, loadEventInfo, mediaLoadData);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            nc.H(this, eventTime, loadEventInfo, mediaLoadData);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            nc.I(this, eventTime, loadEventInfo, mediaLoadData, iOException, z);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            nc.J(this, eventTime, loadEventInfo, mediaLoadData);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            nc.L(this, eventTime, z);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(AnalyticsListener.EventTime eventTime, long j) {
            nc.M(this, eventTime, j);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
            nc.N(this, eventTime, mediaItem, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
            nc.O(this, eventTime, mediaMetadata);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
            nc.P(this, eventTime, metadata);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
            nc.Q(this, eventTime, z, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
            nc.R(this, eventTime, playbackParameters);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
            if (i != 3 || ExperimentalFrameExtractor.this.extractedFrameNeedsRendering.get()) {
                return;
            }
            ((CallbackToFutureAdapter.Completer) Assertions.checkNotNull((CallbackToFutureAdapter.Completer) ExperimentalFrameExtractor.this.frameBeingExtractedCompleterAtomicReference.getAndSet(null))).set((Frame) Assertions.checkNotNull(ExperimentalFrameExtractor.this.lastExtractedFrame));
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
            nc.T(this, eventTime, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) ExperimentalFrameExtractor.this.frameBeingExtractedCompleterAtomicReference.getAndSet(null);
            if (completer != null) {
                completer.setException(playbackException);
            }
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPlayerErrorChanged(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
            nc.V(this, eventTime, playbackException);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPlayerReleased(AnalyticsListener.EventTime eventTime) {
            nc.W(this, eventTime);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
            nc.X(this, eventTime, z, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPlaylistMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
            nc.Y(this, eventTime, mediaMetadata);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
            nc.Z(this, eventTime, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j) {
            nc.b0(this, eventTime, obj, j);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onRendererReadyChanged(AnalyticsListener.EventTime eventTime, int i, int i2, boolean z) {
            nc.c0(this, eventTime, i, i2, z);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
            nc.d0(this, eventTime, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onSeekBackIncrementChanged(AnalyticsListener.EventTime eventTime, long j) {
            nc.e0(this, eventTime, j);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onSeekForwardIncrementChanged(AnalyticsListener.EventTime eventTime, long j) {
            nc.f0(this, eventTime, j);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            nc.g0(this, eventTime);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            nc.h0(this, eventTime, z);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            nc.i0(this, eventTime, z);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
            nc.j0(this, eventTime, i, i2);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
            nc.k0(this, eventTime, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onTrackSelectionParametersChanged(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
            nc.l0(this, eventTime, trackSelectionParameters);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onTracksChanged(AnalyticsListener.EventTime eventTime, Tracks tracks) {
            nc.m0(this, eventTime, tracks);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            nc.n0(this, eventTime, mediaLoadData);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
            nc.o0(this, eventTime, exc);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
            nc.p0(this, eventTime, str, j);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
            nc.r0(this, eventTime, str);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            nc.s0(this, eventTime, decoderCounters);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            nc.t0(this, eventTime, decoderCounters);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i) {
            nc.u0(this, eventTime, j, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            nc.v0(this, eventTime, format, decoderReuseEvaluation);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
            nc.w0(this, eventTime, i, i2, i3, f);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
            nc.y0(this, eventTime, f);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
            nc.d(this, eventTime, str, j, j2);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onCues(AnalyticsListener.EventTime eventTime, List list) {
            nc.r(this, eventTime, list);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i) {
            nc.z(this, eventTime, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i) {
            nc.K(this, eventTime, loadEventInfo, mediaLoadData, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            nc.a0(this, eventTime, positionInfo, positionInfo2, i);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
            nc.q0(this, eventTime, str, j, j2);
        }

        @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
        public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
            nc.x0(this, eventTime, videoSize);
        }
    }

    public ExperimentalFrameExtractor(final Context context, final Configuration configuration) {
        this.configuration = configuration;
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(context, new RenderersFactory() { // from class: yr1
            @Override // androidx.media3.exoplayer.RenderersFactory
            public final Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
                return this.f22254a.lambda$new$0(context, configuration, handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput);
            }

            @Override // androidx.media3.exoplayer.RenderersFactory
            public /* synthetic */ Renderer createSecondaryRenderer(Renderer renderer, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
                return uv4.a(this, renderer, handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput);
            }
        }, new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory()).experimentalSetCodecsToParseWithinGopSampleDependencies(3)).setSeekParameters(configuration.seekParameters).build();
        this.player = exoPlayerBuild;
        exoPlayerBuild.addAnalyticsListener(new PlayerListener());
        this.playerApplicationThreadHandler = new Handler(exoPlayerBuild.getApplicationLooper());
        this.extractedFrameNeedsRendering = new AtomicBoolean();
        this.frameBeingExtractedCompleterAtomicReference = new AtomicReference<>(null);
        this.lastRequestedFrameFuture = z42.d();
    }

    private ImmutableList<Effect> buildVideoEffects(List<Effect> list) {
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.l(list);
        aVar.a(new MatrixTransformation() { // from class: vr1
            @Override // androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ Size configure(int i, int i2) {
                return y0.a(this, i, i2);
            }

            @Override // androidx.media3.common.Effect
            public /* synthetic */ long getDurationAfterEffectApplied(long j) {
                return ik1.a(this, j);
            }

            @Override // androidx.media3.effect.MatrixTransformation, androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ float[] getGlMatrixArray(long j) {
                return z0.a(this, j);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation
            public /* synthetic */ int getGlTextureMinFilter() {
                return y0.b(this);
            }

            @Override // androidx.media3.effect.MatrixTransformation
            public final Matrix getMatrix(long j) {
                return ExperimentalFrameExtractor.lambda$buildVideoEffects$8(j);
            }

            @Override // androidx.media3.effect.GlEffect
            public /* synthetic */ boolean isNoOp(int i, int i2) {
                return zb2.a(this, i, i2);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
            public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) {
                return y0.c(this, context, z);
            }

            @Override // androidx.media3.effect.GlMatrixTransformation, androidx.media3.effect.GlEffect
            public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) {
                return toGlShaderProgram(context, z);
            }
        });
        aVar.a(new FrameReader());
        return aVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Matrix lambda$buildVideoEffects$8(long j) {
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        return matrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDecoderCounters$7(o65 o65Var) {
        o65Var.A(this.player.getVideoDecoderCounters());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getFrame$3(r33 r33Var, final long j, final SeekParameters seekParameters, final CallbackToFutureAdapter.Completer completer) throws Exception {
        x42<Frame> x42Var = new x42<Frame>() { // from class: androidx.media3.transformer.ExperimentalFrameExtractor.1
            @Override // defpackage.x42
            public void onFailure(Throwable th) {
                ExperimentalFrameExtractor.this.processNext(j, seekParameters, completer);
            }

            @Override // defpackage.x42
            public void onSuccess(Frame frame) {
                ExperimentalFrameExtractor.this.lastExtractedFrame = frame;
                ExperimentalFrameExtractor.this.processNext(j, seekParameters, completer);
            }
        };
        Handler handler = this.playerApplicationThreadHandler;
        Objects.requireNonNull(handler);
        z42.a(r33Var, x42Var, new bl0(handler));
        return "ExperimentalFrameExtractor.getFrame";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Frame lambda$getFrame$4(r33 r33Var) throws Exception {
        return (Frame) z42.c(r33Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Renderer[] lambda$new$0(Context context, Configuration configuration, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        return new Renderer[]{new FrameExtractorRenderer(context, configuration.mediaCodecSelector, videoRendererEventListener, !configuration.extractHdrFrames)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$6(ConditionVariable conditionVariable) {
        this.player.release();
        conditionVariable.open();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaItem$1(CallbackToFutureAdapter.Completer completer, List list, MediaItem mediaItem) {
        this.frameBeingExtractedCompleterAtomicReference.set(completer);
        this.lastExtractedFrame = null;
        this.player.setVideoEffects(buildVideoEffects(list));
        this.player.setMediaItem(mediaItem);
        this.player.setPlayWhenReady(false);
        this.player.prepare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setMediaItem$2(r33 r33Var, final List list, final MediaItem mediaItem, final CallbackToFutureAdapter.Completer completer) throws Exception {
        Runnable runnable = new Runnable() { // from class: xr1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22037a.lambda$setMediaItem$1(completer, list, mediaItem);
            }
        };
        Handler handler = this.playerApplicationThreadHandler;
        Objects.requireNonNull(handler);
        r33Var.addListener(runnable, new bl0(handler));
        return "ExperimentalFrameExtractor.setMediaItem";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNext(long j, SeekParameters seekParameters, CallbackToFutureAdapter.Completer<Frame> completer) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new Runnable() { // from class: tr1
            @Override // java.lang.Runnable
            public final void run() {
                atomicBoolean.set(true);
            }
        }, er3.a());
        if (atomicBoolean.get()) {
            return;
        }
        Throwable playbackException = this.player.isReleased() ? new PlaybackException("The player is already released", null, 1004) : this.player.getPlayerError();
        if (playbackException != null) {
            completer.setException(playbackException);
            return;
        }
        if (this.player.getCurrentMediaItem() == null) {
            completer.setException(new PlaybackException("Player has no current item. Call setMediaItem before getFrame.", null, -108));
            return;
        }
        Assertions.checkState(g23.a(this.frameBeingExtractedCompleterAtomicReference, null, completer));
        this.extractedFrameNeedsRendering.set(false);
        this.player.setSeekParameters(seekParameters);
        this.player.seekTo(j);
    }

    @VisibleForTesting
    public r33<DecoderCounters> getDecoderCounters() {
        final o65 o65VarE = o65.E();
        this.playerApplicationThreadHandler.post(new Runnable() { // from class: wr1
            @Override // java.lang.Runnable
            public final void run() {
                this.f21784a.lambda$getDecoderCounters$7(o65VarE);
            }
        });
        return o65VarE;
    }

    public r33<Frame> getFrame(long j) {
        return getFrame(j, this.configuration.seekParameters);
    }

    public void release() {
        if (this.player.getApplicationLooper() == Looper.myLooper()) {
            this.player.release();
            return;
        }
        final ConditionVariable conditionVariable = new ConditionVariable();
        this.playerApplicationThreadHandler.removeCallbacksAndMessages(null);
        this.playerApplicationThreadHandler.post(new Runnable() { // from class: zr1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22498a.lambda$release$6(conditionVariable);
            }
        });
        conditionVariable.blockUninterruptible();
    }

    public void setMediaItem(final MediaItem mediaItem, final List<Effect> list) {
        final r33<Frame> r33Var = this.lastRequestedFrameFuture;
        this.lastRequestedFrameFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: ur1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f21275a.lambda$setMediaItem$2(r33Var, list, mediaItem, completer);
            }
        });
    }

    public r33<Frame> getFrame(final long j, final SeekParameters seekParameters) {
        final r33<Frame> r33Var = this.lastRequestedFrameFuture;
        final r33<Frame> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: as1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f1563a.lambda$getFrame$3(r33Var, j, seekParameters, completer);
            }
        });
        this.lastRequestedFrameFuture = z42.h(this.lastRequestedFrameFuture, future).a(new Callable() { // from class: bs1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ExperimentalFrameExtractor.lambda$getFrame$4(future);
            }
        }, er3.a());
        return future;
    }
}
