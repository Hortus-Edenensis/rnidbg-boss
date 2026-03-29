package defpackage;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class t51 implements zh2 {
    public static final int[] d = {8, 13, 11, 2, 0, 1, 7};
    public final int b;
    public final boolean c;

    public t51() {
        this(0, true);
    }

    public static void b(int i, List<Integer> list) {
        if (ku2.l(d, i) == -1 || list.contains(Integer.valueOf(i))) {
            return;
        }
        list.add(Integer.valueOf(i));
    }

    public static b32 e(jy5 jy5Var, m mVar, @Nullable List<m> list) {
        int i = g(mVar) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new b32(i, jy5Var, null, list);
    }

    public static i26 f(int i, boolean z, m mVar, @Nullable List<m> list, jy5 jy5Var) {
        int i2 = i | 16;
        if (list != null) {
            i2 |= 32;
        } else {
            list = z ? Collections.singletonList(new m.b().g0("application/cea-608").G()) : Collections.emptyList();
        }
        String str = mVar.i;
        if (!TextUtils.isEmpty(str)) {
            if (!fp3.b(str, "audio/mp4a-latm")) {
                i2 |= 2;
            }
            if (!fp3.b(str, "video/avc")) {
                i2 |= 4;
            }
        }
        return new i26(2, jy5Var, new ka1(i2, list));
    }

    public static boolean g(m mVar) {
        Metadata metadata = mVar.j;
        if (metadata == null) {
            return false;
        }
        for (int i = 0; i < metadata.length(); i++) {
            if (metadata.get(i) instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) r2).variantInfos.isEmpty();
            }
        }
        return false;
    }

    public static boolean h(os1 os1Var, ps1 ps1Var) throws IOException {
        try {
            boolean zD = os1Var.d(ps1Var);
            ps1Var.resetPeekPosition();
            return zD;
        } catch (EOFException unused) {
            ps1Var.resetPeekPosition();
            return false;
        } catch (Throwable th) {
            ps1Var.resetPeekPosition();
            throw th;
        }
    }

    @Override // defpackage.zh2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public mv a(Uri uri, m mVar, @Nullable List<m> list, jy5 jy5Var, Map<String, List<String>> map, ps1 ps1Var, bk4 bk4Var) throws IOException {
        int iA = ku1.a(mVar.l);
        int iB = ku1.b(map);
        int iC = ku1.c(uri);
        int[] iArr = d;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(iA, arrayList);
        b(iB, arrayList);
        b(iC, arrayList);
        for (int i : iArr) {
            b(i, arrayList);
        }
        ps1Var.resetPeekPosition();
        os1 os1Var = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int iIntValue = ((Integer) arrayList.get(i2)).intValue();
            os1 os1Var2 = (os1) vh.e(d(iIntValue, mVar, list, jy5Var));
            if (h(os1Var2, ps1Var)) {
                return new mv(os1Var2, mVar, jy5Var);
            }
            if (os1Var == null && (iIntValue == iA || iIntValue == iB || iIntValue == iC || iIntValue == 11)) {
                os1Var = os1Var2;
            }
        }
        return new mv((os1) vh.e(os1Var), mVar, jy5Var);
    }

    @Nullable
    @SuppressLint({"SwitchIntDef"})
    public final os1 d(int i, m mVar, @Nullable List<m> list, jy5 jy5Var) {
        if (i == 0) {
            return new f2();
        }
        if (i == 1) {
            return new l2();
        }
        if (i == 2) {
            return new c8();
        }
        if (i == 7) {
            return new or3(0, 0L);
        }
        if (i == 8) {
            return e(jy5Var, mVar, list);
        }
        if (i == 11) {
            return f(this.b, this.c, mVar, list, jy5Var);
        }
        if (i != 13) {
            return null;
        }
        return new gk6(mVar.c, jy5Var);
    }

    public t51(int i, boolean z) {
        this.b = i;
        this.c = z;
    }
}
