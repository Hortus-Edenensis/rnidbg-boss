package com.opos.exoplayer.core.text.e;

import android.text.Html;
import android.text.TextUtils;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.util.k;
import com.opos.exoplayer.core.util.p;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.opos.exoplayer.core.text.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8342a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private final StringBuilder b;

    public a() {
        super("SubripDecoder");
        this.b = new StringBuilder();
    }

    private static long a(Matcher matcher, int i) {
        return ((Long.parseLong(matcher.group(i + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i + 3)) * 1000) + Long.parseLong(matcher.group(i + 4))) * 1000;
    }

    @Override // com.opos.exoplayer.core.text.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(byte[] bArr, int i, boolean z) {
        StringBuilder sb;
        String str;
        ArrayList arrayList = new ArrayList();
        k kVar = new k();
        p pVar = new p(bArr, i);
        while (true) {
            String strZ = pVar.z();
            if (strZ == null) {
                break;
            }
            if (strZ.length() != 0) {
                try {
                    Integer.parseInt(strZ);
                    strZ = pVar.z();
                } catch (NumberFormatException unused) {
                    sb = new StringBuilder();
                    str = "Skipping invalid index: ";
                }
                if (strZ == null) {
                    com.opos.cmn.an.f.a.c("SubripDecoder", "Unexpected end");
                    break;
                }
                Matcher matcher = f8342a.matcher(strZ);
                if (matcher.matches()) {
                    boolean z2 = true;
                    kVar.a(a(matcher, 1));
                    if (TextUtils.isEmpty(matcher.group(6))) {
                        z2 = false;
                    } else {
                        kVar.a(a(matcher, 6));
                    }
                    this.b.setLength(0);
                    while (true) {
                        String strZ2 = pVar.z();
                        if (TextUtils.isEmpty(strZ2)) {
                            break;
                        }
                        if (this.b.length() > 0) {
                            this.b.append("<br>");
                        }
                        this.b.append(strZ2.trim());
                    }
                    arrayList.add(new Cue(Html.fromHtml(this.b.toString())));
                    if (z2) {
                        arrayList.add(null);
                    }
                } else {
                    sb = new StringBuilder();
                    str = "Skipping invalid timing: ";
                    sb.append(str);
                    sb.append(strZ);
                    com.opos.cmn.an.f.a.c("SubripDecoder", sb.toString());
                }
            }
        }
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new b(cueArr, kVar.b());
    }
}
