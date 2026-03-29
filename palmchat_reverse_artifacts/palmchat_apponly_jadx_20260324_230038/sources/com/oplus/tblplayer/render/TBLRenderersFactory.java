package com.oplus.tblplayer.render;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.DefaultRenderersFactory;
import com.oplus.tbl.exoplayer2.Renderer;
import com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener;
import com.oplus.tbl.exoplayer2.audio.AudioSink;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecSelector;
import com.oplus.tbl.exoplayer2.metadata.MetadataOutput;
import com.oplus.tbl.exoplayer2.text.TextOutput;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;
import com.oplus.tblplayer.ffmpeg.FfmpegAudioRenderer;
import com.oplus.tblplayer.ffmpeg.FfmpegVideoRenderer;
import com.oplus.tblplayer.render.bcap.Bcp1MetadataDecoder;
import com.oplus.tblplayer.render.bcap.Bcp2MetadataDecoder;
import com.oplus.tblplayer.utils.LogUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLRenderersFactory extends DefaultRenderersFactory {
    private static final String TAG = "TBLRenderersFactory";
    private IMetadataOutput audioRenderer;
    private boolean enableCodecVPPFilter;
    private boolean enableVideoEffectMode;
    private int rendererMode;
    protected int videoSoftRenderMode;

    public TBLRenderersFactory(Context context) {
        this(context, 0);
    }

    @Override // com.oplus.tbl.exoplayer2.DefaultRenderersFactory
    public void buildAudioRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, AudioSink audioSink, Handler handler, AudioRendererEventListener audioRendererEventListener, ArrayList<Renderer> arrayList) {
        if (this.rendererMode != 2) {
            TBLMediaCodecAudioRenderer tBLMediaCodecAudioRenderer = new TBLMediaCodecAudioRenderer(context, mediaCodecSelector, z, handler, audioRendererEventListener, audioSink);
            this.audioRenderer = tBLMediaCodecAudioRenderer;
            arrayList.add(tBLMediaCodecAudioRenderer);
        }
        if (this.rendererMode != 1) {
            try {
                arrayList.add((Renderer) FfmpegAudioRenderer.class.getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                LogUtil.d(TAG, "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException unused) {
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e);
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.DefaultRenderersFactory
    public void buildMetadataRenderers(@NonNull Context context, @NonNull MetadataOutput metadataOutput, @NonNull Looper looper, int i, @NonNull ArrayList<Renderer> arrayList) {
        if (this.rendererMode != 2) {
            super.buildMetadataRenderers(context, metadataOutput, looper, i, arrayList);
            arrayList.add(0, new TBLMetadataRenderer(this.audioRenderer, null, Bcp1MetadataDecoder.factory, "Bcp1Renderer"));
            arrayList.add(0, new TBLMetadataRenderer(this.audioRenderer, null, Bcp2MetadataDecoder.factory, "Bcp2Renderer"));
        }
    }

    @Override // com.oplus.tbl.exoplayer2.DefaultRenderersFactory
    public void buildVideoRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        if (this.rendererMode != 2) {
            arrayList.add(new TBLMediaCodecVideoRenderer(context, mediaCodecSelector, j, z, handler, videoRendererEventListener, 50, this.enableCodecVPPFilter, this.enableVideoEffectMode));
        }
        if (this.rendererMode != 1) {
            try {
                arrayList.add((Renderer) Class.forName("com.oplus.tbl.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
            } catch (ClassNotFoundException unused) {
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating av1 extension", e);
            }
            try {
                int i2 = FfmpegVideoRenderer.f7686a;
                Class cls = Integer.TYPE;
                arrayList.add((Renderer) FfmpegVideoRenderer.class.getConstructor(Context.class, Long.TYPE, Handler.class, VideoRendererEventListener.class, cls, cls).newInstance(context, Long.valueOf(j), handler, videoRendererEventListener, 50, Integer.valueOf(this.videoSoftRenderMode)));
                LogUtil.d(TAG, "Loaded FfmpegVideoRenderer.");
            } catch (ClassNotFoundException unused2) {
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e2);
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.DefaultRenderersFactory, com.oplus.tbl.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        LogUtil.d(TAG, "createRenderers: renderer mode is " + LogUtil.getRendererTypeString(this.rendererMode));
        return super.createRenderers(handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput);
    }

    public TBLRenderersFactory(Context context, int i) {
        this(context, i, false, 0);
    }

    public TBLRenderersFactory(Context context, int i, boolean z, int i2) {
        this(context, i, z, false, 0);
    }

    public TBLRenderersFactory(Context context, int i, boolean z, boolean z2, int i2) {
        super(context);
        this.rendererMode = i;
        this.enableCodecVPPFilter = z;
        this.enableVideoEffectMode = z2;
        this.audioRenderer = null;
        this.videoSoftRenderMode = i2;
    }
}
