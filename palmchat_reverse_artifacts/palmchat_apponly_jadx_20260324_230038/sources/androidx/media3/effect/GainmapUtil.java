package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Gainmap;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
class GainmapUtil {
    private GainmapUtil() {
    }

    private static String addIndex(String str, int i) {
        if (i == -1) {
            return str;
        }
        return str + i;
    }

    private static boolean areAllChannelsEqual(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        return f == f2 && f2 == fArr[2];
    }

    @RequiresApi(34)
    public static boolean equals(Gainmap gainmap, Gainmap gainmap2) {
        return gainmap.getGamma() == gainmap2.getGamma() && gainmap.getRatioMax() == gainmap2.getRatioMax() && gainmap.getRatioMin() == gainmap2.getRatioMin() && gainmap.getEpsilonHdr() == gainmap2.getEpsilonHdr() && gainmap.getEpsilonSdr() == gainmap2.getEpsilonSdr() && gainmap.getDisplayRatioForFullHdr() == gainmap2.getDisplayRatioForFullHdr() && gainmap.getMinDisplayRatioForHdrTransition() == gainmap2.getMinDisplayRatioForHdrTransition() && gainmap.getGainmapContents() == gainmap2.getGainmapContents() && gainmap.getGainmapContents().getGenerationId() == gainmap2.getGainmapContents().getGenerationId();
    }

    private static float[] logRgb(float[] fArr) {
        return new float[]{(float) Math.log(fArr[0]), (float) Math.log(fArr[1]), (float) Math.log(fArr[2])};
    }

    @RequiresApi(34)
    public static void setGainmapUniforms(GlProgram glProgram, Gainmap gainmap, int i) throws GlUtil.GlException {
        int i2 = gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8 ? 1 : 0;
        float[] gamma = gainmap.getGamma();
        int i3 = (gamma[0] == 1.0f && gamma[1] == 1.0f && gamma[2] == 1.0f) ? 1 : 0;
        int i4 = (areAllChannelsEqual(gamma) && areAllChannelsEqual(gainmap.getRatioMax()) && areAllChannelsEqual(gainmap.getRatioMin())) ? 1 : 0;
        glProgram.setIntUniform(addIndex("uGainmapIsAlpha", i), i2);
        glProgram.setIntUniform(addIndex("uNoGamma", i), i3);
        glProgram.setIntUniform(addIndex("uSingleChannel", i), i4);
        glProgram.setFloatsUniform(addIndex("uLogRatioMin", i), logRgb(gainmap.getRatioMin()));
        glProgram.setFloatsUniform(addIndex("uLogRatioMax", i), logRgb(gainmap.getRatioMax()));
        glProgram.setFloatsUniform(addIndex("uEpsilonSdr", i), gainmap.getEpsilonSdr());
        glProgram.setFloatsUniform(addIndex("uEpsilonHdr", i), gainmap.getEpsilonHdr());
        glProgram.setFloatsUniform(addIndex("uGainmapGamma", i), gamma);
        glProgram.setFloatUniform(addIndex("uDisplayRatioHdr", i), gainmap.getDisplayRatioForFullHdr());
        glProgram.setFloatUniform(addIndex("uDisplayRatioSdr", i), gainmap.getMinDisplayRatioForHdrTransition());
        GlUtil.checkGlError();
    }
}
