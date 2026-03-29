package com.oplus.tbl.exoplayer2.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.DebugViewProvider;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.PreviewingVideoGraph;
import com.oplus.tbl.exoplayer2.SurfaceInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.VideoFrameProcessor;
import com.oplus.tbl.exoplayer2.VideoGraph;
import com.oplus.tbl.exoplayer2.effect.Crop;
import com.oplus.tbl.exoplayer2.effect.DefaultVideoFrameProcessor;
import com.oplus.tbl.exoplayer2.effect.PreviewingSingleInputVideoGraph;
import com.oplus.tbl.exoplayer2.effect.ScaleAndRotateTransformation;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.HandlerWrapper;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.TimestampIterator;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tbl.exoplayer2.util.VideoSize;
import com.oplus.tbl.exoplayer2.video.CompositingVideoSinkProvider;
import com.oplus.tbl.exoplayer2.video.VideoFrameRenderControl;
import com.oplus.tbl.exoplayer2.video.VideoSink;
import defpackage.qo5;
import defpackage.ro5;
import j$.util.Objects;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@UnstableApi
public final class CompositingVideoSinkProvider implements VideoGraph.Listener, VideoFrameRenderControl.FrameRenderer, VideoSinkProvider {
    private static final long CONSTANT_SECONDS_IN_NANOS = 1000000;
    private static final Executor NO_OP_EXECUTOR = new Executor() { // from class: jk0
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            CompositingVideoSinkProvider.lambda$static$0(runnable);
        }
    };
    private static final int STATE_CREATED = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_RELEASED = 2;
    private static final String TAG = "VideoSinkProvider";
    private static final long TOLERANCE_OFFSET_US = 5000;
    private Clock clock;
    private final Context context;

    @Nullable
    private Pair<Surface, Size> currentSurfaceAndSize;
    private HandlerWrapper handler;
    private VideoSink.Listener listener;
    private Executor listenerExecutor;
    private boolean mDisabledOriginalColorInfo;
    private long mExpectedEndBufferPresentationTimeUs;
    private boolean mIsReachEndPresentationTimeUs;
    private Format outputFormat;
    private int pendingFlushCount;
    private final PreviewingVideoGraph.Factory previewingVideoGraphFactory;
    private int state;
    private List<Effect> videoEffects;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private VideoFrameReleaseControl videoFrameReleaseControl;
    private VideoFrameRenderControl videoFrameRenderControl;
    private PreviewingVideoGraph videoGraph;
    private VideoSinkImpl videoSinkImpl;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private boolean built;
        private final Context context;
        private boolean forceDisableDisplayP3;
        private PreviewingVideoGraph.Factory previewingVideoGraphFactory;
        private VideoFrameProcessor.Factory videoFrameProcessorFactory;

        public Builder(Context context) {
            this.context = context;
        }

        public CompositingVideoSinkProvider build() {
            Assertions.checkState(!this.built);
            if (this.previewingVideoGraphFactory == null) {
                if (this.videoFrameProcessorFactory == null) {
                    this.videoFrameProcessorFactory = new ReflectiveDefaultVideoFrameProcessorFactory();
                }
                this.previewingVideoGraphFactory = new ReflectivePreviewingSingleInputVideoGraphFactory(this.videoFrameProcessorFactory);
            }
            CompositingVideoSinkProvider compositingVideoSinkProvider = new CompositingVideoSinkProvider(this);
            this.built = true;
            return compositingVideoSinkProvider;
        }

        public Builder setForceDisablDisplayP3(boolean z) {
            this.forceDisableDisplayP3 = z;
            return this;
        }

        public Builder setPreviewingVideoGraphFactory(PreviewingVideoGraph.Factory factory) {
            this.previewingVideoGraphFactory = factory;
            return this;
        }

        public Builder setVideoFrameProcessorFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ReflectiveDefaultVideoFrameProcessorFactory implements VideoFrameProcessor.Factory {
        private static final qo5<VideoFrameProcessor.Factory> VIDEO_FRAME_PROCESSOR_FACTORY_SUPPLIER = ro5.a(new qo5() { // from class: com.oplus.tbl.exoplayer2.video.c
            @Override // defpackage.qo5
            /* JADX INFO: renamed from: get */
            public final Object get2() {
                return CompositingVideoSinkProvider.ReflectiveDefaultVideoFrameProcessorFactory.lambda$static$0();
            }
        });

        private ReflectiveDefaultVideoFrameProcessorFactory() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ VideoFrameProcessor.Factory lambda$static$0() {
            try {
                return (VideoFrameProcessor.Factory) Assertions.checkNotNull(DefaultVideoFrameProcessor.Factory.Builder.class.getMethod("build", new Class[0]).invoke(DefaultVideoFrameProcessor.Factory.Builder.class.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]));
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.VideoFrameProcessor.Factory
        public VideoFrameProcessor create(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z, Executor executor, VideoFrameProcessor.Listener listener) throws VideoFrameProcessingException {
            return VIDEO_FRAME_PROCESSOR_FACTORY_SUPPLIER.get2().create(context, debugViewProvider, colorInfo, z, executor, listener);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ReflectivePreviewingSingleInputVideoGraphFactory implements PreviewingVideoGraph.Factory {
        private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

        public ReflectivePreviewingSingleInputVideoGraphFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
        }

        @Override // com.oplus.tbl.exoplayer2.PreviewingVideoGraph.Factory
        public PreviewingVideoGraph create(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, List<Effect> list, long j) throws VideoFrameProcessingException {
            try {
                Constructor constructor = PreviewingSingleInputVideoGraph.Factory.class.getConstructor(VideoFrameProcessor.Factory.class);
                Object[] objArr = new Object[1];
                try {
                    objArr[0] = this.videoFrameProcessorFactory;
                    return ((PreviewingVideoGraph.Factory) constructor.newInstance(objArr)).create(context, colorInfo, colorInfo2, debugViewProvider, listener, executor, list, j);
                } catch (Exception e) {
                    e = e;
                    throw VideoFrameProcessingException.from(e);
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class VideoSinkImpl implements VideoSink {
        private final CompositingVideoSinkProvider compositingVideoSinkProvider;
        private final Context context;

        @Nullable
        private Effect cropEffect;
        private boolean hasRegisteredFirstInputStream;

        @Nullable
        private Format inputFormat;
        private long inputStreamOffsetUs;
        private int inputType;
        private long pendingInputStreamBufferPresentationTimeUs;
        private boolean pendingInputStreamOffsetChange;

        @Nullable
        private Effect rotationEffect;
        private final VideoFrameProcessor videoFrameProcessor;
        private final int videoFrameProcessorMaxPendingFrameCount;
        private final ArrayList<Effect> videoEffects = new ArrayList<>();
        private long finalBufferPresentationTimeUs = -9223372036854775807L;
        private long lastBufferPresentationTimeUs = -9223372036854775807L;

        /* JADX INFO: compiled from: SearchBox */
        public static final class CropTransformationAccessor {
            private CropTransformationAccessor() {
            }

            public static Effect createCropEffect(float f, float f2, float f3, float f4) {
                try {
                    Class cls = Float.TYPE;
                    return (Effect) Assertions.checkNotNull(Crop.class.getConstructor(cls, cls, cls, cls).newInstance(Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class ScaleAndRotateAccessor {
            private static Method buildScaleAndRotateTransformationMethod;
            private static Constructor<?> scaleAndRotateTransformationBuilderConstructor;
            private static Method setRotationMethod;

            private ScaleAndRotateAccessor() {
            }

            public static Effect createRotationEffect(float f) {
                try {
                    prepare();
                    Object objNewInstance = scaleAndRotateTransformationBuilderConstructor.newInstance(new Object[0]);
                    setRotationMethod.invoke(objNewInstance, Float.valueOf(f));
                    return (Effect) Assertions.checkNotNull(buildScaleAndRotateTransformationMethod.invoke(objNewInstance, new Object[0]));
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }

            private static void prepare() throws NoSuchMethodException, ClassNotFoundException {
                if (scaleAndRotateTransformationBuilderConstructor == null || setRotationMethod == null || buildScaleAndRotateTransformationMethod == null) {
                    scaleAndRotateTransformationBuilderConstructor = ScaleAndRotateTransformation.Builder.class.getConstructor(new Class[0]);
                    setRotationMethod = ScaleAndRotateTransformation.Builder.class.getMethod("setRotationDegrees", Float.TYPE);
                    buildScaleAndRotateTransformationMethod = ScaleAndRotateTransformation.Builder.class.getMethod("build", new Class[0]);
                }
            }
        }

        public VideoSinkImpl(Context context, CompositingVideoSinkProvider compositingVideoSinkProvider, PreviewingVideoGraph previewingVideoGraph) throws VideoFrameProcessingException {
            this.context = context;
            this.compositingVideoSinkProvider = compositingVideoSinkProvider;
            this.videoFrameProcessorMaxPendingFrameCount = Util.getMaxPendingFramesCountForMediaCodecDecoders(context);
            this.videoFrameProcessor = previewingVideoGraph.getProcessor(previewingVideoGraph.registerInput());
        }

        @Nullable
        private Effect maybeApplyCropEffect(int i, Format format) {
            int i2;
            int i3;
            int i4 = format.width;
            boolean z = false;
            Assertions.checkArgument((i4 == -1 || i4 == 0) ? false : true);
            int i5 = format.height;
            if (i5 != -1 && i5 != 0) {
                z = true;
            }
            Assertions.checkArgument(z);
            if (i != 1 || (i2 = format.displayWidth) == -1 || i2 == 0 || (i3 = format.displayHeight) == -1 || i3 == 0) {
                return null;
            }
            int i6 = format.width;
            float f = (i6 - i2) / 2.0f;
            int i7 = format.height;
            float f2 = (i7 - i3) / 2.0f;
            return CropTransformationAccessor.createCropEffect(((f / i6) * 2.0f) - 1.0f, (((i2 + f) / i6) * 2.0f) - 1.0f, ((f2 / i7) * 2.0f) - 1.0f, (((i3 + f2) / i7) * 2.0f) - 1.0f);
        }

        @SuppressLint({"WrongConstant"})
        private void maybeRegisterInputStream() {
            if (this.inputFormat == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Effect effect = this.rotationEffect;
            if (effect != null) {
                arrayList.add(effect);
            }
            Effect effect2 = this.cropEffect;
            if (effect2 != null) {
                arrayList.add(effect2);
            }
            arrayList.addAll(this.videoEffects);
            Format format = (Format) Assertions.checkNotNull(this.inputFormat);
            this.videoFrameProcessor.registerInputStream(this.inputType, arrayList, new FrameInfo.Builder(CompositingVideoSinkProvider.getAdjustedInputColorInfo(format.colorInfo), format.width, format.height).setPixelWidthHeightRatio(format.pixelWidthHeightRatio).build());
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public void flush() {
            this.videoFrameProcessor.flush();
            this.hasRegisteredFirstInputStream = false;
            this.finalBufferPresentationTimeUs = -9223372036854775807L;
            this.lastBufferPresentationTimeUs = -9223372036854775807L;
            this.compositingVideoSinkProvider.flush();
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public Surface getInputSurface() {
            return this.videoFrameProcessor.getInputSurface();
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public boolean isEnded() {
            long j = this.finalBufferPresentationTimeUs;
            return j != -9223372036854775807L && this.compositingVideoSinkProvider.hasReleasedFrame(j);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public boolean isFrameDropAllowedOnInput() {
            return Util.isFrameDropAllowedOnSurfaceInput(this.context);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public boolean isReady() {
            return this.compositingVideoSinkProvider.isReady();
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public boolean queueBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
            return ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).queueInputBitmap(bitmap, timestampIterator);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public long registerInputFrame(long j, boolean z) {
            Assertions.checkState(this.videoFrameProcessorMaxPendingFrameCount != -1);
            long j2 = this.pendingInputStreamBufferPresentationTimeUs;
            if (j2 != -9223372036854775807L) {
                if (!this.compositingVideoSinkProvider.hasReleasedFrame(j2)) {
                    return -9223372036854775807L;
                }
                maybeRegisterInputStream();
                this.pendingInputStreamBufferPresentationTimeUs = -9223372036854775807L;
            }
            if (this.videoFrameProcessor.getPendingInputFrameCount() >= this.videoFrameProcessorMaxPendingFrameCount || !this.videoFrameProcessor.registerInputFrame()) {
                return -9223372036854775807L;
            }
            long j3 = this.inputStreamOffsetUs;
            long j4 = j + j3;
            if (this.pendingInputStreamOffsetChange) {
                this.compositingVideoSinkProvider.onStreamOffsetChange(j4, j3);
                this.pendingInputStreamOffsetChange = false;
            }
            this.lastBufferPresentationTimeUs = j4;
            if (z) {
                this.finalBufferPresentationTimeUs = j4;
            }
            return j4 * 1000;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void registerInputStream(int i, Format format) {
            Effect effectCreateRotationEffect;
            int i2;
            Format format2;
            if (i != 1 && i != 2) {
                throw new UnsupportedOperationException("Unsupported input type " + i);
            }
            if (i == 1 && Util.SDK_INT < 21 && (i2 = format.rotationDegrees) != -1 && i2 != 0) {
                effectCreateRotationEffect = (this.rotationEffect == null || (format2 = this.inputFormat) == null || format2.rotationDegrees != i2) ? ScaleAndRotateAccessor.createRotationEffect(i2) : null;
                this.cropEffect = maybeApplyCropEffect(i, format);
                this.inputType = i;
                this.inputFormat = format;
                if (!this.hasRegisteredFirstInputStream) {
                    Assertions.checkState(this.lastBufferPresentationTimeUs != -9223372036854775807L);
                    this.pendingInputStreamBufferPresentationTimeUs = this.lastBufferPresentationTimeUs;
                    return;
                } else {
                    maybeRegisterInputStream();
                    this.hasRegisteredFirstInputStream = true;
                    this.pendingInputStreamBufferPresentationTimeUs = -9223372036854775807L;
                    return;
                }
            }
            this.rotationEffect = effectCreateRotationEffect;
            this.cropEffect = maybeApplyCropEffect(i, format);
            this.inputType = i;
            this.inputFormat = format;
            if (!this.hasRegisteredFirstInputStream) {
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public void render(long j, long j2) throws VideoSink.VideoSinkException {
            try {
                this.compositingVideoSinkProvider.render(j, j2);
            } catch (ExoPlaybackException e) {
                Format formatBuild = this.inputFormat;
                if (formatBuild == null) {
                    formatBuild = new Format.Builder().build();
                }
                throw new VideoSink.VideoSinkException(e, formatBuild);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public void setListener(VideoSink.Listener listener, Executor executor) {
            this.compositingVideoSinkProvider.setListener(listener, executor);
        }

        public void setPendingVideoEffects(List<Effect> list) {
            this.videoEffects.clear();
            this.videoEffects.addAll(list);
        }

        @Override // com.oplus.tbl.exoplayer2.video.VideoSink
        public void setPlaybackSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
            this.compositingVideoSinkProvider.setPlaybackSpeed(f);
        }

        public void setStreamOffsetUs(long j) {
            this.pendingInputStreamOffsetChange = this.inputStreamOffsetUs != j;
            this.inputStreamOffsetUs = j;
        }

        public void setVideoEffects(List<Effect> list) {
            setPendingVideoEffects(list);
            maybeRegisterInputStream();
        }
    }

    private CompositingVideoSinkProvider(Builder builder) {
        this.context = builder.context;
        this.previewingVideoGraphFactory = (PreviewingVideoGraph.Factory) Assertions.checkStateNotNull(builder.previewingVideoGraphFactory);
        this.clock = Clock.DEFAULT;
        this.listener = VideoSink.Listener.NO_OP;
        this.listenerExecutor = NO_OP_EXECUTOR;
        this.state = 0;
        this.mIsReachEndPresentationTimeUs = false;
        this.mExpectedEndBufferPresentationTimeUs = -9223372036854775807L;
        this.mDisabledOriginalColorInfo = false;
    }

    private static ColorInfo convertOutputColorInfo(ColorInfo colorInfo, boolean z) {
        String str;
        String eGLExtensionSupported = GlUtil.getEGLExtensionSupported();
        if (TextUtils.isEmpty(eGLExtensionSupported)) {
            return colorInfo;
        }
        boolean zContains = eGLExtensionSupported.contains("EGL_EXT_gl_colorspace_bt2020_hlg");
        boolean zContains2 = eGLExtensionSupported.contains("EGL_EXT_gl_colorspace_bt2020_pq");
        boolean zContains3 = eGLExtensionSupported.contains("EXT_gl_colorspace_display_p3_passthrough");
        boolean zContains4 = eGLExtensionSupported.contains("EGL_EXT_gl_colorspace_display_p3");
        Log.d(TAG, String.format("EGL extension supported: BT2020 HLG [%b], BT2020 PQ [%b], Display P3 passthrough [%b], Display P3 [%b]", Boolean.valueOf(zContains), Boolean.valueOf(zContains2), Boolean.valueOf(zContains3), Boolean.valueOf(zContains4)));
        int i = colorInfo.colorTransfer;
        if (i == 7) {
            if (zContains) {
                return colorInfo;
            }
            str = "The device does not support HLG output and fallback to SDR output.";
        } else if (i == 6) {
            if (zContains2) {
                return colorInfo;
            }
            str = "The device does not support PQ output and fallback to SDR output.";
        } else {
            if (colorInfo.colorSpace != 10) {
                return colorInfo;
            }
            if (zContains3 && zContains4 && !z) {
                return colorInfo.buildUpon().setColorTransfer(3).build();
            }
            str = "The device does not support P3 or force SDR output, fallback to SDR output.";
        }
        Log.w(TAG, str);
        return ColorInfo.SDR_BT709_LIMITED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flush() {
        this.pendingFlushCount++;
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).flush();
        ((HandlerWrapper) Assertions.checkStateNotNull(this.handler)).post(new Runnable() { // from class: lk0
            @Override // java.lang.Runnable
            public final void run() {
                this.f19019a.flushInternal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushInternal() {
        int i = this.pendingFlushCount - 1;
        this.pendingFlushCount = i;
        if (i > 0) {
            return;
        }
        if (i < 0) {
            throw new IllegalStateException(String.valueOf(this.pendingFlushCount));
        }
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ColorInfo getAdjustedInputColorInfo(@Nullable ColorInfo colorInfo) {
        return (colorInfo == null || !colorInfo.isDataSpaceValid()) ? ColorInfo.SDR_BT709_LIMITED : colorInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasReleasedFrame(long j) {
        return this.pendingFlushCount == 0 && ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).hasReleasedFrame(j);
    }

    private boolean isOriginalPresentationTimeUs(long j, float f) {
        long j2 = (long) (1000000.0f / f);
        long j3 = j / j2;
        return j <= (j3 * j2) + 5000 || j >= ((j3 + 1) * j2) - 5000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReady() {
        return this.pendingFlushCount == 0 && ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).isReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dropFrame$4(VideoSink.Listener listener) {
        listener.onFrameDropped((VideoSink) Assertions.checkStateNotNull(this.videoSinkImpl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$1(VideoSink.Listener listener, VideoFrameProcessingException videoFrameProcessingException) {
        VideoSinkImpl videoSinkImpl = (VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl);
        listener.onError(videoSinkImpl, new VideoSink.VideoSinkException(videoFrameProcessingException, (Format) Assertions.checkStateNotNull(videoSinkImpl.inputFormat)));
    }

    private void maybeSetOutputSurfaceInfo(@Nullable Surface surface, int i, int i2) {
        if (this.videoGraph != null) {
            this.videoGraph.setOutputSurfaceInfo(surface != null ? new SurfaceInfo(surface, i, i2) : null);
            ((VideoFrameReleaseControl) Assertions.checkNotNull(this.videoFrameReleaseControl)).setOutputSurface(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStreamOffsetChange(long j, long j2) {
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).onStreamOffsetChange(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListener(VideoSink.Listener listener, Executor executor) {
        if (Objects.equals(listener, this.listener)) {
            Assertions.checkState(Objects.equals(executor, this.listenerExecutor));
        } else {
            this.listener = listener;
            this.listenerExecutor = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f) {
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).setPlaybackSpeed(f);
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void clearOutputSurfaceInfo() {
        Size size = Size.UNKNOWN;
        maybeSetOutputSurfaceInfo(null, size.getWidth(), size.getHeight());
        this.currentSurfaceAndSize = null;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoFrameRenderControl.FrameRenderer
    public void dropFrame() {
        final VideoSink.Listener listener = this.listener;
        this.listenerExecutor.execute(new Runnable() { // from class: mk0
            @Override // java.lang.Runnable
            public final void run() {
                this.f19256a.lambda$dropFrame$4(listener);
            }
        });
        ((PreviewingVideoGraph) Assertions.checkStateNotNull(this.videoGraph)).renderOutputFrame(-2L);
    }

    @Nullable
    public Surface getOutputSurface() {
        Pair<Surface, Size> pair = this.currentSurfaceAndSize;
        if (pair != null) {
            return (Surface) pair.first;
        }
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public VideoSink getSink() {
        return (VideoSink) Assertions.checkStateNotNull(this.videoSinkImpl);
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    @Nullable
    public VideoFrameReleaseControl getVideoFrameReleaseControl() {
        return this.videoFrameReleaseControl;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void initialize(Format format) throws VideoSink.VideoSinkException {
        boolean z = false;
        Assertions.checkState(this.state == 0);
        Assertions.checkStateNotNull(this.videoEffects);
        if (this.videoFrameRenderControl != null && this.videoFrameReleaseControl != null) {
            z = true;
        }
        Assertions.checkState(z);
        this.handler = this.clock.createHandler((Looper) Assertions.checkStateNotNull(Looper.myLooper()), null);
        ColorInfo adjustedInputColorInfo = getAdjustedInputColorInfo(format.colorInfo);
        ColorInfo colorInfoConvertOutputColorInfo = convertOutputColorInfo(adjustedInputColorInfo, this.mDisabledOriginalColorInfo);
        try {
            PreviewingVideoGraph.Factory factory = this.previewingVideoGraphFactory;
            Context context = this.context;
            DebugViewProvider debugViewProvider = DebugViewProvider.NONE;
            final HandlerWrapper handlerWrapper = this.handler;
            Objects.requireNonNull(handlerWrapper);
            this.videoGraph = factory.create(context, adjustedInputColorInfo, colorInfoConvertOutputColorInfo, debugViewProvider, this, new Executor() { // from class: kk0
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handlerWrapper.post(runnable);
                }
            }, ImmutableList.of(), 0L);
            Pair<Surface, Size> pair = this.currentSurfaceAndSize;
            if (pair != null) {
                Surface surface = (Surface) pair.first;
                Size size = (Size) pair.second;
                maybeSetOutputSurfaceInfo(surface, size.getWidth(), size.getHeight());
            }
            VideoSinkImpl videoSinkImpl = new VideoSinkImpl(this.context, this, this.videoGraph);
            this.videoSinkImpl = videoSinkImpl;
            videoSinkImpl.setVideoEffects((List) Assertions.checkNotNull(this.videoEffects));
            this.state = 1;
        } catch (VideoFrameProcessingException e) {
            throw new VideoSink.VideoSinkException(e, format);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public boolean isInitialized() {
        return this.state == 1;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public boolean isReachedEndPosition() {
        return hasReleasedFrame(this.mExpectedEndBufferPresentationTimeUs - 5000) && this.mIsReachEndPresentationTimeUs;
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph.Listener
    public void onEnded(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph.Listener
    public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
        final VideoSink.Listener listener = this.listener;
        this.listenerExecutor.execute(new Runnable() { // from class: ik0
            @Override // java.lang.Runnable
            public final void run() {
                this.f18185a.lambda$onError$1(listener, videoFrameProcessingException);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph.Listener
    public void onOutputFrameAvailableForRendering(long j) {
        if (this.pendingFlushCount > 0) {
            return;
        }
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).onOutputFrameAvailableForRendering(j);
    }

    @Override // com.oplus.tbl.exoplayer2.VideoGraph.Listener
    public void onOutputSizeChanged(int i, int i2) {
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).onOutputSizeChanged(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoFrameRenderControl.FrameRenderer
    public void onVideoSizeChanged(final VideoSize videoSize) {
        this.outputFormat = new Format.Builder().setWidth(videoSize.width).setHeight(videoSize.height).setSampleMimeType("video/raw").build();
        final VideoSinkImpl videoSinkImpl = (VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl);
        final VideoSink.Listener listener = this.listener;
        this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.video.a
            @Override // java.lang.Runnable
            public final void run() {
                listener.onVideoSizeChanged(videoSinkImpl, videoSize);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void release() {
        if (this.state == 2) {
            return;
        }
        HandlerWrapper handlerWrapper = this.handler;
        if (handlerWrapper != null) {
            handlerWrapper.removeCallbacksAndMessages(null);
        }
        PreviewingVideoGraph previewingVideoGraph = this.videoGraph;
        if (previewingVideoGraph != null) {
            previewingVideoGraph.release();
        }
        this.currentSurfaceAndSize = null;
        this.state = 2;
        this.mExpectedEndBufferPresentationTimeUs = -9223372036854775807L;
        this.mIsReachEndPresentationTimeUs = false;
        this.mDisabledOriginalColorInfo = false;
    }

    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.pendingFlushCount != 0 || this.currentSurfaceAndSize == null) {
            return;
        }
        ((VideoFrameRenderControl) Assertions.checkStateNotNull(this.videoFrameRenderControl)).render(j, j2);
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoFrameRenderControl.FrameRenderer
    public void renderFrame(long j, long j2, long j3, boolean z) {
        if (this.mIsReachEndPresentationTimeUs) {
            return;
        }
        if (z && this.listenerExecutor != NO_OP_EXECUTOR) {
            final VideoSinkImpl videoSinkImpl = (VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl);
            final VideoSink.Listener listener = this.listener;
            this.listenerExecutor.execute(new Runnable() { // from class: com.oplus.tbl.exoplayer2.video.b
                @Override // java.lang.Runnable
                public final void run() {
                    listener.onFirstFrameRendered(videoSinkImpl);
                }
            });
        }
        if (this.videoFrameMetadataListener != null) {
            Format formatBuild = this.outputFormat;
            if (formatBuild == null) {
                formatBuild = new Format.Builder().build();
            }
            this.videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j2 - j3, this.clock.nanoTime(), formatBuild, null);
        }
        ((PreviewingVideoGraph) Assertions.checkStateNotNull(this.videoGraph)).renderOutputFrame(j);
        long j4 = this.mExpectedEndBufferPresentationTimeUs;
        if (j4 == -9223372036854775807L || !hasReleasedFrame(j4 - 5000)) {
            return;
        }
        boolean zIsOriginalPresentationTimeUs = isOriginalPresentationTimeUs(j2, ((Format) Assertions.checkStateNotNull(((VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl)).inputFormat)).frameRate);
        this.mIsReachEndPresentationTimeUs = zIsOriginalPresentationTimeUs;
        if (zIsOriginalPresentationTimeUs) {
            Log.d(TAG, "real end frame rendered is " + j2);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setClock(Clock clock) {
        Assertions.checkState(!isInitialized());
        this.clock = clock;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setExpectedEndPresentationTimeUs(long j) {
        this.mExpectedEndBufferPresentationTimeUs = j;
        if (j == -9223372036854775807L) {
            this.mIsReachEndPresentationTimeUs = false;
            Log.d(TAG, "reset flag of end position");
        }
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setOutputColorInfo(boolean z, int i) {
        this.mDisabledOriginalColorInfo = z;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setOutputSurfaceInfo(Surface surface, Size size) {
        Pair<Surface, Size> pair = this.currentSurfaceAndSize;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((Size) this.currentSurfaceAndSize.second).equals(size)) {
            return;
        }
        this.currentSurfaceAndSize = Pair.create(surface, size);
        maybeSetOutputSurfaceInfo(surface, size.getWidth(), size.getHeight());
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setPendingVideoEffects(List<Effect> list) {
        this.videoEffects = list;
        if (isInitialized()) {
            ((VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl)).setPendingVideoEffects(list);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setStreamOffsetUs(long j) {
        ((VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl)).setStreamOffsetUs(j);
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setVideoEffects(List<Effect> list) {
        this.videoEffects = list;
        if (isInitialized()) {
            ((VideoSinkImpl) Assertions.checkStateNotNull(this.videoSinkImpl)).setVideoEffects(list);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.videoFrameMetadataListener = videoFrameMetadataListener;
    }

    @Override // com.oplus.tbl.exoplayer2.video.VideoSinkProvider
    public void setVideoFrameReleaseControl(VideoFrameReleaseControl videoFrameReleaseControl) {
        Assertions.checkState(!isInitialized());
        this.videoFrameReleaseControl = videoFrameReleaseControl;
        this.videoFrameRenderControl = new VideoFrameRenderControl(this, videoFrameReleaseControl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Runnable runnable) {
    }
}
