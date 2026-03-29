package com.opos.exoplayer.core.text.d;

import android.text.TextUtils;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.util.k;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.opos.exoplayer.core.text.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8339a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    public a() {
        this(null);
    }

    public static long a(String str) {
        Matcher matcher = f8339a.matcher(str);
        if (matcher.matches()) {
            return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
        }
        return -9223372036854775807L;
    }

    @Override // com.opos.exoplayer.core.text.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        k kVar = new k();
        p pVar = new p(bArr, i);
        if (!this.b) {
            a(pVar);
        }
        a(pVar, arrayList, kVar);
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new b(cueArr, kVar.b());
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list == null || list.isEmpty()) {
            this.b = false;
            return;
        }
        this.b = true;
        String str = new String(list.get(0));
        com.opos.exoplayer.core.util.a.a(str.startsWith("Format: "));
        b(str);
        a(new p(list.get(1)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(8), ",");
        this.c = strArrSplit.length;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        for (int i = 0; i < this.c; i++) {
            String strD = y.d(strArrSplit[i].trim());
            strD.hashCode();
            switch (strD) {
                case "end":
                    this.e = i;
                    break;
                case "text":
                    this.f = i;
                    break;
                case "start":
                    this.d = i;
                    break;
            }
        }
        if (this.d == -1 || this.e == -1 || this.f == -1) {
            this.c = 0;
        }
    }

    private void a(p pVar) {
        String strZ;
        do {
            strZ = pVar.z();
            if (strZ == null) {
                return;
            }
        } while (!strZ.startsWith("[Events]"));
    }

    private void a(p pVar, List<Cue> list, k kVar) {
        while (true) {
            String strZ = pVar.z();
            if (strZ == null) {
                return;
            }
            if (!this.b && strZ.startsWith("Format: ")) {
                b(strZ);
            } else if (strZ.startsWith("Dialogue: ")) {
                a(strZ, list, kVar);
            }
        }
    }

    private void a(String str, List<Cue> list, k kVar) {
        long jA;
        StringBuilder sb;
        String str2;
        if (this.c == 0) {
            sb = new StringBuilder();
            str2 = "Skipping dialogue line before complete format: ";
        } else {
            String[] strArrSplit = str.substring(10).split(",", this.c);
            if (strArrSplit.length == this.c) {
                long jA2 = a(strArrSplit[this.d]);
                if (jA2 != -9223372036854775807L) {
                    String str3 = strArrSplit[this.e];
                    if (str3.trim().isEmpty()) {
                        jA = -9223372036854775807L;
                    } else {
                        jA = a(str3);
                        if (jA == -9223372036854775807L) {
                            sb = new StringBuilder();
                        }
                    }
                    list.add(new Cue(strArrSplit[this.f].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
                    kVar.a(jA2);
                    if (jA != -9223372036854775807L) {
                        list.add(null);
                        kVar.a(jA);
                        return;
                    }
                    return;
                }
                sb = new StringBuilder();
                sb.append("Skipping invalid timing: ");
                sb.append(str);
                com.opos.cmn.an.f.a.c("SsaDecoder", sb.toString());
            }
            sb = new StringBuilder();
            str2 = "Skipping dialogue line with fewer columns than format: ";
        }
        sb.append(str2);
        sb.append(str);
        com.opos.cmn.an.f.a.c("SsaDecoder", sb.toString());
    }
}
