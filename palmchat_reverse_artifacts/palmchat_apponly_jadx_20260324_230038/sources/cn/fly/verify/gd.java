package cn.fly.verify;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2386a;

    public gd(Context context) {
        this.f2386a = context;
    }

    private boolean b() {
        try {
            Object objA = fy.a(fy.a(bq.a("027ef edekfeejedgefegigefkelgiCjgGeghmekfe)kgHek;j2ejEg?gi"), (String) null), bq.a("003:ff4gj"), "", "ro.build.tags");
            String strValueOf = objA != null ? String.valueOf(objA) : null;
            if (!(strValueOf != null && strValueOf.contains(bq.a("009jgEgiEjLilem<gIelgi")))) {
                if (!g()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean c() {
        return "0".equals(eq.a(this.f2386a).a(bq.a("020,ekfegegffefe]j-gefg$he'giJiEgeQh6fe%d2emTgVed")));
    }

    private boolean d() {
        String strA = eq.a(this.f2386a).a(bq.a("025Dekfegegffefe3jCgeeeEg0ekejfgejKgVedgffefe8jQgi?jejg"));
        if (strA != null) {
            return TextUtils.equals(strA.toLowerCase(), "orange") || TextUtils.equals(strA.toLowerCase(), "red");
        }
        return false;
    }

    private boolean e() {
        String strA = eq.a(this.f2386a).a(bq.a("027Bekfegegffefe]jKgeeegfegYgje geedRgVeeej(dgPeigiDjejg"));
        return strA != null && TextUtils.equals(bq.a("008_eh1fh^fe0d2em=gTed"), strA.toLowerCase());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f() {
        Object objC;
        InputStream inputStream;
        ?? bufferedReader;
        int iMyPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        try {
            objC = eg.c(bq.a("010dejMjgRmk5ekfe@dm") + (iMyPid + bq.a("007m.egfeehTfj?gi")));
            try {
                inputStream = (InputStream) fy.a(objC, bq.a("014>ff>gjJfj8fk>ehUj-fk)j7ek]geHeg"), (Object) null, new Object[0]);
                if (inputStream != null) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                                sb.append("\n");
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    en.a().a(th);
                                    eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                                    if (objC != null) {
                                    }
                                } catch (Throwable th2) {
                                    eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                                    if (objC != null) {
                                        fy.a(objC, bq.a("007'edOg6gi-j[ekfeel"), (Object) null, new Object[0]);
                                    }
                                    throw th2;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = 0;
                    }
                } else {
                    bufferedReader = 0;
                }
                eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                if (objC != null) {
                    fy.a(objC, bq.a("007'edOg6gi-j[ekfeel"), (Object) null, new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedReader = inputStream;
                en.a().a(th);
                eg.a((Closeable[]) new Closeable[]{bufferedReader, inputStream});
                if (objC != null) {
                    fy.a(objC, bq.a("007'edOg6gi-j[ekfeel"), (Object) null, new Object[0]);
                }
                return sb.toString().contains(bq.a("006Eeg^e=ffejgiem"));
            }
        } catch (Throwable th5) {
            th = th5;
            objC = null;
            inputStream = null;
        }
        return sb.toString().contains(bq.a("006Eeg^e=ffejgiem"));
    }

    private boolean g() {
        try {
            if (new File(bq.a("025m[gielgi5jg%eg(mekkm0fkeh<kgPekehgiGg8ekgeAek.em")).exists()) {
                return true;
            }
            String[] strArr = {bq.a("012m!edKejemh feTdehm"), bq.a("016m3ed?ejemhYfe-dehm(gfej:fm"), bq.a("017mWedUejemh9fe8dehm:fdgfejDfm"), bq.a("006m4gigfej[fm"), bq.a("008m giehGmEgfejOfm"), bq.a("012mVgielgi(jgTegYm>gfej4fm"), bq.a("017mQgielgi_jg8eg^m'gfejZfmKge4gSfd!jm"), bq.a("021mLgielgi5jgBeg6m)gfej<fmXfgQe5ejOh]gi-e(fgNgm"), bq.a("016mIgielgi$jg+eg)mTgied6m>fdgfejXfm"), bq.a("025mWgielgi-jg!eg=m_ehgiekPm8gg9g1ilIfgg0edilekfefe]jm"), bq.a("013m@gielgiZjg5egNm)fdgfej7fm"), bq.a("013mSgielgi5jg+egFm1gigfejUfm"), bq.a("012m@eeZgfNedfeekDmMgfej_fm"), bq.a("006mdedig"), bq.a("005m:ed4eje"), bq.a("004m>edOg)ee")};
            for (int i = 0; i < 16; i++) {
                if (new File(strArr[i], bq.a("002Jgieh")).exists()) {
                    return true;
                }
            }
            for (int i2 = 0; i2 < 16; i2++) {
                if (new File(strArr[i2], bq.a("007:gfehgielgffefd")).exists()) {
                    return true;
                }
            }
            for (int i3 = 0; i3 < 16; i3++) {
                if (new File(strArr[i3], bq.a("006JegAeDffejgiem")).exists()) {
                    return true;
                }
            }
        } catch (Throwable th) {
            en.a().b(th);
        }
        return false;
    }

    public String a() {
        StringBuilder sb = new StringBuilder("");
        try {
            if (d()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (e()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (c()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (b()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if (f()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
