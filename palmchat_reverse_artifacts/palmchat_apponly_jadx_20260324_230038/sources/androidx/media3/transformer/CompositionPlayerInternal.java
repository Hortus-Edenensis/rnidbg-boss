package androidx.media3.transformer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class CompositionPlayerInternal implements Handler.Callback {
    private static final int MSG_CLEAR_OUTPUT_SURFACE = 5;
    private static final int MSG_END_SEEK = 7;
    private static final int MSG_RELEASE = 8;
    private static final int MSG_SET_COMPOSITION = 0;
    private static final int MSG_SET_OUTPUT_SURFACE_INFO = 4;
    private static final int MSG_SET_VOLUME = 3;
    private static final int MSG_START_RENDERING = 1;
    private static final int MSG_START_SEEK = 6;
    private static final int MSG_STOP_RENDERING = 2;
    private static final String TAG = "CompPlayerInternal";
    private final Clock clock;
    private final HandlerWrapper handler;
    private boolean hasSetComposition;
    private final Listener listener;
    private final HandlerWrapper listenerHandler;
    private final PlaybackAudioGraphWrapper playbackAudioGraphWrapper;
    private final PlaybackVideoGraphWrapper playbackVideoGraphWrapper;
    private boolean released;

    /* JADX INFO: compiled from: SearchBox */
    public interface Listener {
        void onError(String str, Exception exc, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class OutputSurfaceInfo {
        public final Size size;
        public final Surface surface;

        public OutputSurfaceInfo(Surface surface, Size size) {
            this.surface = surface;
            this.size = size;
        }
    }

    public CompositionPlayerInternal(Looper looper, Clock clock, PlaybackAudioGraphWrapper playbackAudioGraphWrapper, PlaybackVideoGraphWrapper playbackVideoGraphWrapper, Listener listener, HandlerWrapper handlerWrapper) {
        this.clock = clock;
        this.handler = clock.createHandler(looper, this);
        this.playbackAudioGraphWrapper = playbackAudioGraphWrapper;
        this.playbackVideoGraphWrapper = playbackVideoGraphWrapper;
        this.listener = listener;
        this.listenerHandler = handlerWrapper;
    }

    private void clearOutputSurfaceInternal() {
        try {
            this.playbackVideoGraphWrapper.clearOutputSurfaceInfo();
        } catch (RuntimeException e) {
            maybeRaiseError("error clearing video output", e, 7001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$maybeRaiseError$0(String str, Exception exc, int i) {
        if (this.released) {
            return;
        }
        this.listener.onError(str, exc, i);
    }

    private void maybeRaiseError(final String str, final Exception exc, final int i) {
        try {
            this.listenerHandler.post(new Runnable() { // from class: androidx.media3.transformer.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1527a.lambda$maybeRaiseError$0(str, exc, i);
                }
            });
        } catch (RuntimeException e) {
            Log.e(TAG, "error", e);
        }
    }

    private void releaseInternal(ConditionVariable conditionVariable) {
        try {
            try {
                this.playbackAudioGraphWrapper.release();
                this.playbackVideoGraphWrapper.clearOutputSurfaceInfo();
                this.playbackVideoGraphWrapper.release();
            } catch (RuntimeException e) {
                Log.e(TAG, "error while releasing the player", e);
            }
        } finally {
            conditionVariable.open();
        }
    }

    private void setCompositionInternal(Composition composition) {
        if (!this.hasSetComposition) {
            this.playbackAudioGraphWrapper.setAudioProcessors(composition.effects.audioProcessors);
            this.hasSetComposition = true;
        }
        this.playbackAudioGraphWrapper.startSeek(-9223372036854775807L);
        this.playbackAudioGraphWrapper.endSeek();
        this.playbackVideoGraphWrapper.setCompositionEffects(composition.effects.videoEffects);
        this.playbackVideoGraphWrapper.setCompositorSettings(composition.videoCompositorSettings);
        this.playbackVideoGraphWrapper.setRequestOpenGlToneMapping(composition.hdrMode == 2);
        this.playbackVideoGraphWrapper.setIsInputSdrToneMapped(composition.hdrMode == 1);
    }

    private void setOutputSurfaceInfoOnInternalThread(OutputSurfaceInfo outputSurfaceInfo) {
        try {
            this.playbackVideoGraphWrapper.setOutputSurfaceInfo(outputSurfaceInfo.surface, outputSurfaceInfo.size);
        } catch (RuntimeException e) {
            maybeRaiseError("error setting surface view", e, 7001);
        }
    }

    public void clearOutputSurface() {
        this.handler.sendEmptyMessage(5);
    }

    public void endSeek() {
        this.handler.sendEmptyMessage(7);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    setCompositionInternal((Composition) message.obj);
                    break;
                case 1:
                    startRenderingInternal();
                    break;
                case 2:
                    stopRenderingInternal();
                    break;
                case 3:
                    this.playbackAudioGraphWrapper.setVolume(((Float) message.obj).floatValue());
                    break;
                case 4:
                    setOutputSurfaceInfoOnInternalThread((OutputSurfaceInfo) message.obj);
                    break;
                case 5:
                    clearOutputSurfaceInternal();
                    break;
                case 6:
                    this.playbackAudioGraphWrapper.startSeek(Util.msToUs(((Long) message.obj).longValue()));
                    break;
                case 7:
                    this.playbackAudioGraphWrapper.endSeek();
                    break;
                case 8:
                    releaseInternal((ConditionVariable) message.obj);
                    break;
                default:
                    maybeRaiseError("Unknown message", new IllegalStateException(String.valueOf(message.what)), 1000);
                    break;
            }
            return true;
        } catch (RuntimeException e) {
            maybeRaiseError("Unknown error", e, 1000);
            return true;
        }
    }

    public void release() {
        Assertions.checkState(!this.released);
        this.released = true;
        ConditionVariable conditionVariable = new ConditionVariable();
        this.handler.obtainMessage(8, conditionVariable).sendToTarget();
        this.clock.onThreadBlocked();
        try {
            conditionVariable.block();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }

    public void setComposition(Composition composition) {
        this.handler.obtainMessage(0, composition).sendToTarget();
    }

    public void setOutputSurfaceInfo(Surface surface, Size size) {
        this.handler.obtainMessage(4, new OutputSurfaceInfo(surface, size)).sendToTarget();
    }

    public void setVolume(float f) {
        this.handler.obtainMessage(3, Float.valueOf(f)).sendToTarget();
    }

    public void startRendering() {
        this.handler.sendEmptyMessage(1);
    }

    public void startRenderingInternal() {
        this.playbackAudioGraphWrapper.startRendering();
        this.playbackVideoGraphWrapper.startRendering();
    }

    public void startSeek(long j) {
        this.handler.obtainMessage(6, Long.valueOf(j)).sendToTarget();
    }

    public void stopRendering() {
        this.handler.sendEmptyMessage(2);
    }

    public void stopRenderingInternal() {
        this.playbackAudioGraphWrapper.stopRendering();
        this.playbackVideoGraphWrapper.stopRendering();
    }
}
