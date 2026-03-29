package androidx.media3.effect;

import android.graphics.Gainmap;
import androidx.media3.common.util.GlUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
interface GainmapShaderProgram extends GlShaderProgram {
    void setGainmap(Gainmap gainmap) throws GlUtil.GlException;
}
