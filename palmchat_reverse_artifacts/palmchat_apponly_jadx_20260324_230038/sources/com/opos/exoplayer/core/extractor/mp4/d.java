package com.opos.exoplayer.core.extractor.mp4;

import com.huawei.hms.ads.jsb.constant.Constant;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
abstract class d {
    public static final int aA;
    public static final int aB;
    public static final int aC;
    public static final int aD;
    public static final int aE;
    public static final int aF;
    public static final int aG;
    public static final int aH;
    public static final int aI;
    public static final int aJ;
    public static final int aK;
    public static final int aL;
    public static final int aM;
    public static final int aN;
    public static final int ak;
    public static final int al;
    public static final int am;
    public static final int an;
    public static final int ao;
    public static final int ap;
    public static final int aq;
    public static final int ar;
    public static final int as;
    public static final int at;
    public static final int au;
    public static final int av;
    public static final int aw;
    public static final int ax;
    public static final int ay;
    public static final int az;
    public final int aO;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8207a = y.f("ftyp");
    public static final int b = y.f("avc1");
    public static final int c = y.f("avc3");
    public static final int d = y.f("hvc1");
    public static final int e = y.f("hev1");
    public static final int f = y.f("s263");
    public static final int g = y.f("d263");
    public static final int h = y.f("mdat");
    public static final int i = y.f("mp4a");
    public static final int j = y.f(".mp3");
    public static final int k = y.f("wave");
    public static final int l = y.f("lpcm");
    public static final int m = y.f("sowt");
    public static final int n = y.f("ac-3");
    public static final int o = y.f("dac3");
    public static final int p = y.f("ec-3");
    public static final int q = y.f("dec3");
    public static final int r = y.f("dtsc");
    public static final int s = y.f("dtsh");
    public static final int t = y.f("dtsl");
    public static final int u = y.f("dtse");
    public static final int v = y.f("ddts");
    public static final int w = y.f("tfdt");
    public static final int x = y.f("tfhd");
    public static final int y = y.f("trex");
    public static final int z = y.f("trun");
    public static final int A = y.f("sidx");
    public static final int B = y.f("moov");
    public static final int C = y.f("mvhd");
    public static final int D = y.f("trak");
    public static final int E = y.f("mdia");
    public static final int F = y.f("minf");
    public static final int G = y.f("stbl");
    public static final int H = y.f("avcC");
    public static final int I = y.f("hvcC");
    public static final int J = y.f("esds");
    public static final int K = y.f("moof");
    public static final int L = y.f("traf");
    public static final int M = y.f("mvex");
    public static final int N = y.f("mehd");
    public static final int O = y.f("tkhd");
    public static final int P = y.f("edts");
    public static final int Q = y.f("elst");
    public static final int R = y.f("mdhd");
    public static final int S = y.f("hdlr");
    public static final int T = y.f("stsd");
    public static final int U = y.f("pssh");
    public static final int V = y.f("sinf");
    public static final int W = y.f("schm");
    public static final int X = y.f("schi");
    public static final int Y = y.f("tenc");
    public static final int Z = y.f("encv");
    public static final int aa = y.f("enca");
    public static final int ab = y.f("frma");
    public static final int ac = y.f("saiz");
    public static final int ad = y.f("saio");
    public static final int ae = y.f("sbgp");
    public static final int af = y.f("sgpd");
    public static final int ag = y.f(Constant.MAP_KEY_UUID);
    public static final int ah = y.f("senc");
    public static final int ai = y.f("pasp");
    public static final int aj = y.f("TTML");

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends d {
        public final long aP;
        public final List<b> aQ;
        public final List<a> aR;

        public a(int i, long j) {
            super(i);
            this.aP = j;
            this.aQ = new ArrayList();
            this.aR = new ArrayList();
        }

        public void a(a aVar) {
            this.aR.add(aVar);
        }

        public b d(int i) {
            int size = this.aQ.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.aQ.get(i2);
                if (bVar.aO == i) {
                    return bVar;
                }
            }
            return null;
        }

        public a e(int i) {
            int size = this.aR.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.aR.get(i2);
                if (aVar.aO == i) {
                    return aVar;
                }
            }
            return null;
        }

        @Override // com.opos.exoplayer.core.extractor.mp4.d
        public String toString() {
            return d.c(this.aO) + " leaves: " + Arrays.toString(this.aQ.toArray()) + " containers: " + Arrays.toString(this.aR.toArray());
        }

        public void a(b bVar) {
            this.aQ.add(bVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends d {
        public final p aP;

        public b(int i, p pVar) {
            super(i);
            this.aP = pVar;
        }
    }

    static {
        y.f("vmhd");
        ak = y.f("mp4v");
        al = y.f("stts");
        am = y.f("stss");
        an = y.f("ctts");
        ao = y.f("stsc");
        ap = y.f("stsz");
        aq = y.f("stz2");
        ar = y.f("stco");
        as = y.f("co64");
        at = y.f("tx3g");
        au = y.f("wvtt");
        av = y.f("stpp");
        aw = y.f("c608");
        ax = y.f("samr");
        ay = y.f("sawb");
        az = y.f("udta");
        aA = y.f("meta");
        aB = y.f("ilst");
        aC = y.f("mean");
        aD = y.f("name");
        aE = y.f("data");
        aF = y.f("emsg");
        aG = y.f("st3d");
        aH = y.f("sv3d");
        aI = y.f("proj");
        aJ = y.f("vp08");
        aK = y.f("vp09");
        aL = y.f("vpcC");
        aM = y.f("camm");
        aN = y.f("alac");
    }

    public d(int i2) {
        this.aO = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public static String c(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public String toString() {
        return c(this.aO);
    }
}
