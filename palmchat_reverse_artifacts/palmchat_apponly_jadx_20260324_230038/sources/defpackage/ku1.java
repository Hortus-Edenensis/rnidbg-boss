package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import com.umeng.analytics.pro.dn;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ku1 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(@Nullable String str) {
        byte b;
        if (str == null) {
            return -1;
        }
        String strT = fp3.t(str);
        strT.hashCode();
        switch (strT.hashCode()) {
            case -2123537834:
                b = !strT.equals("audio/eac3-joc") ? (byte) -1 : (byte) 0;
                break;
            case -1662384011:
                if (strT.equals("video/mp2p")) {
                    b = 1;
                    break;
                }
                break;
            case -1662384007:
                if (strT.equals("video/mp2t")) {
                    b = 2;
                    break;
                }
                break;
            case -1662095187:
                if (strT.equals("video/webm")) {
                    b = 3;
                    break;
                }
                break;
            case -1606874997:
                if (strT.equals("audio/amr-wb")) {
                    b = 4;
                    break;
                }
                break;
            case -1487394660:
                if (strT.equals("image/jpeg")) {
                    b = 5;
                    break;
                }
                break;
            case -1248337486:
                if (strT.equals("application/mp4")) {
                    b = 6;
                    break;
                }
                break;
            case -1079884372:
                if (strT.equals(MimeTypes.VIDEO_AVI)) {
                    b = 7;
                    break;
                }
                break;
            case -1004728940:
                if (strT.equals("text/vtt")) {
                    b = 8;
                    break;
                }
                break;
            case -387023398:
                if (strT.equals("audio/x-matroska")) {
                    b = 9;
                    break;
                }
                break;
            case -43467528:
                if (strT.equals("application/webm")) {
                    b = 10;
                    break;
                }
                break;
            case 13915911:
                if (strT.equals("video/x-flv")) {
                    b = 11;
                    break;
                }
                break;
            case 187078296:
                if (strT.equals("audio/ac3")) {
                    b = 12;
                    break;
                }
                break;
            case 187078297:
                if (strT.equals("audio/ac4")) {
                    b = dn.k;
                    break;
                }
                break;
            case 187078669:
                if (strT.equals("audio/amr")) {
                    b = dn.l;
                    break;
                }
                break;
            case 187090232:
                if (strT.equals("audio/mp4")) {
                    b = 15;
                    break;
                }
                break;
            case 187091926:
                if (strT.equals("audio/ogg")) {
                    b = 16;
                    break;
                }
                break;
            case 187099443:
                if (strT.equals("audio/wav")) {
                    b = 17;
                    break;
                }
                break;
            case 1331848029:
                if (strT.equals("video/mp4")) {
                    b = 18;
                    break;
                }
                break;
            case 1503095341:
                if (strT.equals("audio/3gpp")) {
                    b = 19;
                    break;
                }
                break;
            case 1504578661:
                if (strT.equals("audio/eac3")) {
                    b = 20;
                    break;
                }
                break;
            case 1504619009:
                if (strT.equals("audio/flac")) {
                    b = 21;
                    break;
                }
                break;
            case 1504824762:
                if (strT.equals(MimeTypes.AUDIO_MIDI)) {
                    b = 22;
                    break;
                }
                break;
            case 1504831518:
                if (strT.equals("audio/mpeg")) {
                    b = 23;
                    break;
                }
                break;
            case 1505118770:
                if (strT.equals("audio/webm")) {
                    b = 24;
                    break;
                }
                break;
            case 2039520277:
                if (strT.equals("video/x-matroska")) {
                    b = 25;
                    break;
                }
                break;
        }
        switch (b) {
        }
        return -1;
    }

    public static int b(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        return lastPathSegment.endsWith(".avi") ? 16 : -1;
    }
}
