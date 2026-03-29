package defpackage;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xo3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String[] f22024a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @Nullable
    public static CommentFrame a(int i, gc4 gc4Var) {
        int iQ = gc4Var.q();
        if (gc4Var.q() == 1684108385) {
            gc4Var.V(8);
            String strC = gc4Var.C(iQ - 16);
            return new CommentFrame("und", strC, strC);
        }
        y53.i("MetadataUtil", "Failed to parse comment attribute: " + vi.a(i));
        return null;
    }

    @Nullable
    public static ApicFrame b(gc4 gc4Var) {
        int iQ = gc4Var.q();
        if (gc4Var.q() != 1684108385) {
            y53.i("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iB = vi.b(gc4Var.q());
        String str = iB == 13 ? "image/jpeg" : iB == 14 ? "image/png" : null;
        if (str == null) {
            y53.i("MetadataUtil", "Unrecognized cover art flags: " + iB);
            return null;
        }
        gc4Var.V(4);
        int i = iQ - 16;
        byte[] bArr = new byte[i];
        gc4Var.l(bArr, 0, i);
        return new ApicFrame(str, null, 3, bArr);
    }

    @Nullable
    public static Metadata.Entry c(gc4 gc4Var) {
        int iF = gc4Var.f() + gc4Var.q();
        int iQ = gc4Var.q();
        int i = (iQ >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & iQ;
                if (i2 == 6516084) {
                    return a(iQ, gc4Var);
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    return h(iQ, "TIT2", gc4Var);
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    return h(iQ, "TCOM", gc4Var);
                }
                if (i2 == 6578553) {
                    return h(iQ, "TDRC", gc4Var);
                }
                if (i2 == 4280916) {
                    return h(iQ, "TPE1", gc4Var);
                }
                if (i2 == 7630703) {
                    return h(iQ, "TSSE", gc4Var);
                }
                if (i2 == 6384738) {
                    return h(iQ, "TALB", gc4Var);
                }
                if (i2 == 7108978) {
                    return h(iQ, "USLT", gc4Var);
                }
                if (i2 == 6776174) {
                    return h(iQ, "TCON", gc4Var);
                }
                if (i2 == 6779504) {
                    return h(iQ, "TIT1", gc4Var);
                }
            } else {
                if (iQ == 1735291493) {
                    return g(gc4Var);
                }
                if (iQ == 1684632427) {
                    return d(iQ, "TPOS", gc4Var);
                }
                if (iQ == 1953655662) {
                    return d(iQ, "TRCK", gc4Var);
                }
                if (iQ == 1953329263) {
                    return i(iQ, "TBPM", gc4Var, true, false);
                }
                if (iQ == 1668311404) {
                    return i(iQ, "TCMP", gc4Var, true, true);
                }
                if (iQ == 1668249202) {
                    return b(gc4Var);
                }
                if (iQ == 1631670868) {
                    return h(iQ, "TPE2", gc4Var);
                }
                if (iQ == 1936682605) {
                    return h(iQ, "TSOT", gc4Var);
                }
                if (iQ == 1936679276) {
                    return h(iQ, "TSO2", gc4Var);
                }
                if (iQ == 1936679282) {
                    return h(iQ, "TSOA", gc4Var);
                }
                if (iQ == 1936679265) {
                    return h(iQ, "TSOP", gc4Var);
                }
                if (iQ == 1936679791) {
                    return h(iQ, "TSOC", gc4Var);
                }
                if (iQ == 1920233063) {
                    return i(iQ, "ITUNESADVISORY", gc4Var, false, false);
                }
                if (iQ == 1885823344) {
                    return i(iQ, "ITUNESGAPLESS", gc4Var, false, true);
                }
                if (iQ == 1936683886) {
                    return h(iQ, "TVSHOWSORT", gc4Var);
                }
                if (iQ == 1953919848) {
                    return h(iQ, "TVSHOW", gc4Var);
                }
                if (iQ == 757935405) {
                    return e(gc4Var, iF);
                }
            }
            y53.b("MetadataUtil", "Skipped unknown metadata entry: " + vi.a(iQ));
            gc4Var.U(iF);
            return null;
        } finally {
            gc4Var.U(iF);
        }
    }

    @Nullable
    public static TextInformationFrame d(int i, String str, gc4 gc4Var) {
        int iQ = gc4Var.q();
        if (gc4Var.q() == 1684108385 && iQ >= 22) {
            gc4Var.V(10);
            int iN = gc4Var.N();
            if (iN > 0) {
                String str2 = "" + iN;
                int iN2 = gc4Var.N();
                if (iN2 > 0) {
                    str2 = str2 + "/" + iN2;
                }
                return new TextInformationFrame(str, (String) null, ImmutableList.of(str2));
            }
        }
        y53.i("MetadataUtil", "Failed to parse index/count attribute: " + vi.a(i));
        return null;
    }

    @Nullable
    public static Id3Frame e(gc4 gc4Var, int i) {
        String strC = null;
        String strC2 = null;
        int i2 = -1;
        int i3 = -1;
        while (gc4Var.f() < i) {
            int iF = gc4Var.f();
            int iQ = gc4Var.q();
            int iQ2 = gc4Var.q();
            gc4Var.V(4);
            if (iQ2 == 1835360622) {
                strC = gc4Var.C(iQ - 12);
            } else if (iQ2 == 1851878757) {
                strC2 = gc4Var.C(iQ - 12);
            } else {
                if (iQ2 == 1684108385) {
                    i2 = iF;
                    i3 = iQ;
                }
                gc4Var.V(iQ - 12);
            }
        }
        if (strC == null || strC2 == null || i2 == -1) {
            return null;
        }
        gc4Var.U(i2);
        gc4Var.V(16);
        return new InternalFrame(strC, strC2, gc4Var.C(i3 - 16));
    }

    @Nullable
    public static MdtaMetadataEntry f(gc4 gc4Var, int i, String str) {
        while (true) {
            int iF = gc4Var.f();
            if (iF >= i) {
                return null;
            }
            int iQ = gc4Var.q();
            if (gc4Var.q() == 1684108385) {
                int iQ2 = gc4Var.q();
                int iQ3 = gc4Var.q();
                int i2 = iQ - 16;
                byte[] bArr = new byte[i2];
                gc4Var.l(bArr, 0, i2);
                return new MdtaMetadataEntry(str, bArr, iQ3, iQ2);
            }
            gc4Var.U(iF + iQ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TextInformationFrame g(gc4 gc4Var) {
        String str;
        int iJ = j(gc4Var);
        if (iJ > 0) {
            String[] strArr = f22024a;
            str = iJ <= strArr.length ? strArr[iJ - 1] : null;
        }
        if (str != null) {
            return new TextInformationFrame("TCON", (String) null, ImmutableList.of(str));
        }
        y53.i("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    @Nullable
    public static TextInformationFrame h(int i, String str, gc4 gc4Var) {
        int iQ = gc4Var.q();
        if (gc4Var.q() == 1684108385) {
            gc4Var.V(8);
            return new TextInformationFrame(str, (String) null, ImmutableList.of(gc4Var.C(iQ - 16)));
        }
        y53.i("MetadataUtil", "Failed to parse text attribute: " + vi.a(i));
        return null;
    }

    @Nullable
    public static Id3Frame i(int i, String str, gc4 gc4Var, boolean z, boolean z2) {
        int iJ = j(gc4Var);
        if (z2) {
            iJ = Math.min(1, iJ);
        }
        if (iJ >= 0) {
            return z ? new TextInformationFrame(str, (String) null, ImmutableList.of(Integer.toString(iJ))) : new CommentFrame("und", str, Integer.toString(iJ));
        }
        y53.i("MetadataUtil", "Failed to parse uint8 attribute: " + vi.a(i));
        return null;
    }

    public static int j(gc4 gc4Var) {
        gc4Var.V(4);
        if (gc4Var.q() == 1684108385) {
            gc4Var.V(8);
            return gc4Var.H();
        }
        y53.i("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i, m52 m52Var, m.b bVar) {
        if (i == 1 && m52Var.a()) {
            bVar.P(m52Var.f19139a).Q(m52Var.b);
        }
    }

    public static void l(int i, @Nullable Metadata metadata, @Nullable Metadata metadata2, m.b bVar, Metadata... metadataArr) {
        Metadata metadata3 = new Metadata(new Metadata.Entry[0]);
        if (i != 1 || metadata == null) {
            metadata = metadata3;
        }
        if (metadata2 != null) {
            for (int i2 = 0; i2 < metadata2.length(); i2++) {
                Metadata.Entry entry = metadata2.get(i2);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if (!mdtaMetadataEntry.key.equals("com.android.capture.fps")) {
                        metadata = metadata.copyWithAppendedEntries(mdtaMetadataEntry);
                    } else if (i == 2) {
                        metadata = metadata.copyWithAppendedEntries(mdtaMetadataEntry);
                    }
                }
            }
        }
        for (Metadata metadata4 : metadataArr) {
            metadata = metadata.copyWithAppendedEntriesFrom(metadata4);
        }
        if (metadata.length() > 0) {
            bVar.Z(metadata);
        }
    }
}
