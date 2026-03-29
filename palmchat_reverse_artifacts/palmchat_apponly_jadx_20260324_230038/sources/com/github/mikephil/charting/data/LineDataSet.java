package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import defpackage.hm2;
import defpackage.k51;
import defpackage.r23;
import defpackage.s86;
import defpackage.ul2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class LineDataSet extends r23<Entry> implements hm2 {
    public Mode G;
    public List<Integer> H;
    public int I;
    public float J;
    public float K;
    public float L;
    public DashPathEffect M;
    public ul2 N;
    public boolean O;
    public boolean P;

    /* JADX INFO: compiled from: SearchBox */
    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.G = Mode.LINEAR;
        this.H = null;
        this.I = -1;
        this.J = 8.0f;
        this.K = 4.0f;
        this.L = 0.2f;
        this.M = null;
        this.N = new k51();
        this.O = true;
        this.P = true;
        if (this.H == null) {
            this.H = new ArrayList();
        }
        this.H.clear();
        this.H.add(Integer.valueOf(Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 234, 255)));
    }

    @Override // defpackage.hm2
    public DashPathEffect D() {
        return this.M;
    }

    @Override // defpackage.hm2
    public int M(int i) {
        return this.H.get(i).intValue();
    }

    @Override // defpackage.hm2
    public boolean N() {
        return this.O;
    }

    @Override // defpackage.hm2
    public boolean O0() {
        return this.P;
    }

    @Override // defpackage.hm2
    public float P() {
        return this.K;
    }

    @Override // defpackage.hm2
    public float Y() {
        return this.L;
    }

    @Override // defpackage.hm2
    public boolean c() {
        return this.M != null;
    }

    @Override // defpackage.hm2
    public int e() {
        return this.I;
    }

    public void i1() {
        if (this.H == null) {
            this.H = new ArrayList();
        }
        this.H.clear();
    }

    public void j1(int i) {
        i1();
        this.H.add(Integer.valueOf(i));
    }

    public void k1(float f) {
        if (f >= 1.0f) {
            this.J = s86.e(f);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 1");
        }
    }

    public void l1(boolean z) {
        this.P = z;
    }

    public void m1(ul2 ul2Var) {
        if (ul2Var == null) {
            this.N = new k51();
        } else {
            this.N = ul2Var;
        }
    }

    @Override // defpackage.hm2
    public float v0() {
        return this.J;
    }

    @Override // defpackage.hm2
    public int w() {
        return this.H.size();
    }

    @Override // defpackage.hm2
    public Mode y0() {
        return this.G;
    }

    @Override // defpackage.hm2
    public ul2 z() {
        return this.N;
    }
}
