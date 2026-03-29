package com.oplus.tbl.exoplayer2;

import android.os.Handler;
import com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener;
import com.oplus.tbl.exoplayer2.metadata.MetadataOutput;
import com.oplus.tbl.exoplayer2.text.TextOutput;
import com.oplus.tbl.exoplayer2.video.VideoRendererEventListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface RenderersFactory {
    Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput);
}
