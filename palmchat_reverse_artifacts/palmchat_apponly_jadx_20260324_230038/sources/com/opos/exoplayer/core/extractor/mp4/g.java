package com.opos.exoplayer.core.extractor.mp4;

import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.ApicFrame;
import com.opos.exoplayer.core.metadata.id3.CommentFrame;
import com.opos.exoplayer.core.metadata.id3.Id3Frame;
import com.opos.exoplayer.core.metadata.id3.TextInformationFrame;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8215a = y.f("nam");
    private static final int b = y.f("trk");
    private static final int c = y.f("cmt");
    private static final int d = y.f("day");
    private static final int e = y.f("ART");
    private static final int f = y.f("too");
    private static final int g = y.f("alb");
    private static final int h = y.f("com");
    private static final int i = y.f("wrt");
    private static final int j = y.f("lyr");
    private static final int k = y.f("gen");
    private static final int l = y.f("covr");
    private static final int m = y.f("gnre");
    private static final int n = y.f("grp");
    private static final int o = y.f("disk");
    private static final int p = y.f("trkn");
    private static final int q = y.f("tmpo");
    private static final int r = y.f("cpil");
    private static final int s = y.f("aART");
    private static final int t = y.f("sonm");
    private static final int u = y.f("soal");
    private static final int v = y.f("soar");
    private static final int w = y.f("soaa");
    private static final int x = y.f("soco");
    private static final int y = y.f("rtng");
    private static final int z = y.f("pgap");
    private static final int A = y.f("sosn");
    private static final int B = y.f("tvsh");
    private static final int C = y.f("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static Metadata.Entry a(p pVar) {
        int iD = pVar.d() + pVar.o();
        int iO = pVar.o();
        int i2 = (iO >> 24) & 255;
        try {
            if (i2 == 169 || i2 == 65533) {
                int i3 = 16777215 & iO;
                if (i3 == c) {
                    return a(iO, pVar);
                }
                if (i3 != f8215a && i3 != b) {
                    if (i3 != h && i3 != i) {
                        if (i3 == d) {
                            return a(iO, "TDRC", pVar);
                        }
                        if (i3 == e) {
                            return a(iO, "TPE1", pVar);
                        }
                        if (i3 == f) {
                            return a(iO, "TSSE", pVar);
                        }
                        if (i3 == g) {
                            return a(iO, "TALB", pVar);
                        }
                        if (i3 == j) {
                            return a(iO, "USLT", pVar);
                        }
                        if (i3 == k) {
                            return a(iO, "TCON", pVar);
                        }
                        if (i3 == n) {
                            return a(iO, "TIT1", pVar);
                        }
                    }
                    return a(iO, "TCOM", pVar);
                }
                return a(iO, "TIT2", pVar);
            }
            if (iO == m) {
                return b(pVar);
            }
            if (iO == o) {
                return b(iO, "TPOS", pVar);
            }
            if (iO == p) {
                return b(iO, "TRCK", pVar);
            }
            if (iO == q) {
                return a(iO, "TBPM", pVar, true, false);
            }
            if (iO == r) {
                return a(iO, "TCMP", pVar, true, true);
            }
            if (iO == l) {
                return c(pVar);
            }
            if (iO == s) {
                return a(iO, "TPE2", pVar);
            }
            if (iO == t) {
                return a(iO, "TSOT", pVar);
            }
            if (iO == u) {
                return a(iO, "TSO2", pVar);
            }
            if (iO == v) {
                return a(iO, "TSOA", pVar);
            }
            if (iO == w) {
                return a(iO, "TSOP", pVar);
            }
            if (iO == x) {
                return a(iO, "TSOC", pVar);
            }
            if (iO == y) {
                return a(iO, "ITUNESADVISORY", pVar, false, false);
            }
            if (iO == z) {
                return a(iO, "ITUNESGAPLESS", pVar, false, true);
            }
            if (iO == A) {
                return a(iO, "TVSHOWSORT", pVar);
            }
            if (iO == B) {
                return a(iO, "TVSHOW", pVar);
            }
            if (iO == C) {
                return a(pVar, iD);
            }
            com.opos.cmn.an.f.a.b("MetadataUtil", "Skipped unknown metadata entry: " + d.c(iO));
            pVar.c(iD);
            return null;
        } finally {
            pVar.c(iD);
        }
    }

    private static TextInformationFrame b(int i2, String str, p pVar) {
        int iO = pVar.o();
        if (pVar.o() == d.aE && iO >= 22) {
            pVar.d(10);
            int iH = pVar.h();
            if (iH > 0) {
                String str2 = "" + iH;
                int iH2 = pVar.h();
                if (iH2 > 0) {
                    str2 = str2 + "/" + iH2;
                }
                return new TextInformationFrame(str, null, str2);
            }
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse index/count attribute: " + d.c(i2));
        return null;
    }

    private static ApicFrame c(p pVar) {
        String str;
        int iO = pVar.o();
        if (pVar.o() == d.aE) {
            int iB = d.b(pVar.o());
            String str2 = iB == 13 ? "image/jpeg" : iB == 14 ? "image/png" : null;
            if (str2 != null) {
                pVar.d(4);
                int i2 = iO - 16;
                byte[] bArr = new byte[i2];
                pVar.a(bArr, 0, i2);
                return new ApicFrame(str2, null, 3, bArr);
            }
            str = "Unrecognized cover art flags: " + iB;
        } else {
            str = "Failed to parse cover art attribute";
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", str);
        return null;
    }

    private static int d(p pVar) {
        pVar.d(4);
        if (pVar.o() == d.aE) {
            pVar.d(8);
            return pVar.g();
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static CommentFrame a(int i2, p pVar) {
        int iO = pVar.o();
        if (pVar.o() == d.aE) {
            pVar.d(8);
            String strF = pVar.f(iO - 16);
            return new CommentFrame("und", strF, strF);
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse comment attribute: " + d.c(i2));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TextInformationFrame b(p pVar) {
        String str;
        int iD = d(pVar);
        if (iD > 0) {
            String[] strArr = D;
            str = iD <= strArr.length ? strArr[iD - 1] : null;
        }
        if (str != null) {
            return new TextInformationFrame("TCON", null, str);
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static Id3Frame a(int i2, String str, p pVar, boolean z2, boolean z3) {
        int iD = d(pVar);
        if (z3) {
            iD = Math.min(1, iD);
        }
        if (iD >= 0) {
            return z2 ? new TextInformationFrame(str, null, Integer.toString(iD)) : new CommentFrame("und", str, Integer.toString(iD));
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse uint8 attribute: " + d.c(i2));
        return null;
    }

    private static Id3Frame a(p pVar, int i2) {
        String strF = null;
        String strF2 = null;
        int i3 = -1;
        int i4 = -1;
        while (pVar.d() < i2) {
            int iD = pVar.d();
            int iO = pVar.o();
            int iO2 = pVar.o();
            pVar.d(4);
            if (iO2 == d.aC) {
                strF = pVar.f(iO - 12);
            } else if (iO2 == d.aD) {
                strF2 = pVar.f(iO - 12);
            } else {
                if (iO2 == d.aE) {
                    i3 = iD;
                    i4 = iO;
                }
                pVar.d(iO - 12);
            }
        }
        if (!"com.apple.iTunes".equals(strF) || !"iTunSMPB".equals(strF2) || i3 == -1) {
            return null;
        }
        pVar.c(i3);
        pVar.d(16);
        return new CommentFrame("und", strF2, pVar.f(i4 - 16));
    }

    private static TextInformationFrame a(int i2, String str, p pVar) {
        int iO = pVar.o();
        if (pVar.o() == d.aE) {
            pVar.d(8);
            return new TextInformationFrame(str, null, pVar.f(iO - 16));
        }
        com.opos.cmn.an.f.a.c("MetadataUtil", "Failed to parse text attribute: " + d.c(i2));
        return null;
    }
}
