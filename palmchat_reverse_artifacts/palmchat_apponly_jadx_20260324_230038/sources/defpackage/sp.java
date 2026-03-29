package defpackage;

import android.graphics.Color;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class sp<T extends Entry> extends DataSet<T> implements mk2<T> {
    public int w;

    public sp(List<T> list, String str) {
        super(list, str);
        this.w = Color.rgb(255, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME, 115);
    }

    @Override // defpackage.mk2
    public int J0() {
        return this.w;
    }
}
