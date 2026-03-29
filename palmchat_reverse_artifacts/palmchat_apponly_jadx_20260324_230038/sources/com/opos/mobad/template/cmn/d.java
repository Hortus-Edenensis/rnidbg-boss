package com.opos.mobad.template.cmn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum d {
    COLOR_DEF(-1, -1, "#294C66"),
    COLOR_DEF2(-1, -1, "#757575"),
    COLOR_RANGE_0_19(0, 19, "#E57267"),
    COLOR_RANGE_20_39(20, 39, "#E58F50"),
    COLOR_RANGE_40_59(40, 59, "#E5A345"),
    COLOR_RANGE_60_89(60, 89, "#A3BF13"),
    COLOR_RANGE_90_119(90, 119, "#69BF4C"),
    COLOR_RANGE_120_149(120, 149, "#4CBF69"),
    COLOR_RANGE_150_180(150, EffectConstants.ROTATION_DEGREES_180, "#26BF99"),
    COLOR_RANGE_181_209(MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, 209, "#2699BF"),
    COLOR_RANGE_210_239(210, 239, "#5C7FE6"),
    COLOR_RANGE_240_269(240, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, "#7E5CE5"),
    COLOR_RANGE_270_299(270, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_REFRESH_BY_TIME, "#C35CE5"),
    COLOR_RANGE_300_329(300, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION, "#CC52AD"),
    COLOR_RANGE_230_360(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 360, "#E5737C");

    private final int p;
    private final int q;
    private final String r;

    d(int i, int i2, String str) {
        this.p = i;
        this.q = i2;
        this.r = str;
    }

    public String a() {
        return this.r;
    }

    public boolean a(int i) {
        return i >= this.p && i <= this.q;
    }
}
