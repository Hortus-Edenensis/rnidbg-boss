package defpackage;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.ui.R$string;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class b91 implements yz5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f1670a;

    public b91(Resources resources) {
        this.f1670a = (Resources) vh.e(resources);
    }

    public static int i(m mVar) {
        int iK = fp3.k(mVar.l);
        if (iK != -1) {
            return iK;
        }
        if (fp3.n(mVar.i) != null) {
            return 2;
        }
        if (fp3.c(mVar.i) != null) {
            return 1;
        }
        if (mVar.q == -1 && mVar.r == -1) {
            return (mVar.y == -1 && mVar.z == -1) ? -1 : 1;
        }
        return 2;
    }

    @Override // defpackage.yz5
    public String a(m mVar) {
        int i = i(mVar);
        String strJ = i == 2 ? j(h(mVar), g(mVar), c(mVar)) : i == 1 ? j(e(mVar), b(mVar), c(mVar)) : e(mVar);
        return strJ.length() == 0 ? this.f1670a.getString(R$string.exo_track_unknown) : strJ;
    }

    public final String b(m mVar) {
        int i = mVar.y;
        return (i == -1 || i < 1) ? "" : i != 1 ? i != 2 ? (i == 6 || i == 7) ? this.f1670a.getString(R$string.exo_track_surround_5_point_1) : i != 8 ? this.f1670a.getString(R$string.exo_track_surround) : this.f1670a.getString(R$string.exo_track_surround_7_point_1) : this.f1670a.getString(R$string.exo_track_stereo) : this.f1670a.getString(R$string.exo_track_mono);
    }

    public final String c(m mVar) {
        int i = mVar.h;
        return i == -1 ? "" : this.f1670a.getString(R$string.exo_track_bitrate, Float.valueOf(i / 1000000.0f));
    }

    public final String d(m mVar) {
        return TextUtils.isEmpty(mVar.b) ? "" : mVar.b;
    }

    public final String e(m mVar) {
        String strJ = j(f(mVar), h(mVar));
        return TextUtils.isEmpty(strJ) ? d(mVar) : strJ;
    }

    public final String f(m mVar) {
        String str = mVar.c;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        Locale localeForLanguageTag = g86.f17680a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale localeQ = g86.Q();
        String displayName = localeForLanguageTag.getDisplayName(localeQ);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int iOffsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, iOffsetByCodePoints).toUpperCase(localeQ) + displayName.substring(iOffsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    public final String g(m mVar) {
        int i = mVar.q;
        int i2 = mVar.r;
        return (i == -1 || i2 == -1) ? "" : this.f1670a.getString(R$string.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final String h(m mVar) {
        String string = (mVar.e & 2) != 0 ? this.f1670a.getString(R$string.exo_track_role_alternate) : "";
        if ((mVar.e & 4) != 0) {
            string = j(string, this.f1670a.getString(R$string.exo_track_role_supplementary));
        }
        if ((mVar.e & 8) != 0) {
            string = j(string, this.f1670a.getString(R$string.exo_track_role_commentary));
        }
        return (mVar.e & 1088) != 0 ? j(string, this.f1670a.getString(R$string.exo_track_role_closed_captions)) : string;
    }

    public final String j(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.f1670a.getString(R$string.exo_item_list, string, str);
            }
        }
        return string;
    }
}
