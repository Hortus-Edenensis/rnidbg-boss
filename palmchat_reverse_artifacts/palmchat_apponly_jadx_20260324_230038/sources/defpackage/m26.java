package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import defpackage.pr0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class m26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f19131a;

    @Nullable
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;

    @Nullable
    public final p26 f;

    @Nullable
    public final String[] g;
    public final String h;

    @Nullable
    public final String i;

    @Nullable
    public final m26 j;
    public final HashMap<String, Integer> k;
    public final HashMap<String, Integer> l;
    public List<m26> m;

    public m26(@Nullable String str, @Nullable String str2, long j, long j2, @Nullable p26 p26Var, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable m26 m26Var) {
        this.f19131a = str;
        this.b = str2;
        this.i = str4;
        this.f = p26Var;
        this.g = strArr;
        this.c = str2 != null;
        this.d = j;
        this.e = j2;
        this.h = (String) vh.e(str3);
        this.j = m26Var;
        this.k = new HashMap<>();
        this.l = new HashMap<>();
    }

    public static m26 c(@Nullable String str, long j, long j2, @Nullable p26 p26Var, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable m26 m26Var) {
        return new m26(str, null, j, j2, p26Var, strArr, str2, str3, m26Var);
    }

    public static m26 d(String str) {
        return new m26(null, o26.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static void e(SpannableStringBuilder spannableStringBuilder) {
        for (wa1 wa1Var : (wa1[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), wa1.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(wa1Var), spannableStringBuilder.getSpanEnd(wa1Var), "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i4 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == '\n') {
                int i6 = i5 + 1;
                if (spannableStringBuilder.charAt(i6) == ' ') {
                    spannableStringBuilder.delete(i6, i5 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i8) == '\n') {
                    spannableStringBuilder.delete(i7, i8);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    public static SpannableStringBuilder k(String str, Map<String, pr0.b> map) {
        if (!map.containsKey(str)) {
            pr0.b bVar = new pr0.b();
            bVar.o(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) vh.e(map.get(str).e());
    }

    public void a(m26 m26Var) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(m26Var);
    }

    public final void b(Map<String, p26> map, pr0.b bVar, int i, int i2, int i3) {
        p26 p26VarF = o26.f(this.f, this.g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (p26VarF != null) {
            o26.a(spannableStringBuilder2, i, i2, p26VarF, this.j, map, i3);
            if ("p".equals(this.f19131a)) {
                if (p26VarF.k() != Float.MAX_VALUE) {
                    bVar.m((p26VarF.k() * (-90.0f)) / 100.0f);
                }
                if (p26VarF.m() != null) {
                    bVar.p(p26VarF.m());
                }
                if (p26VarF.h() != null) {
                    bVar.j(p26VarF.h());
                }
            }
        }
    }

    public m26 f(int i) {
        List<m26> list = this.m;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<m26> list = this.m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<pr0> h(long j, Map<String, p26> map, Map<String, n26> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        n(j, this.h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j, false, this.h, treeMap);
        o(j, map, map2, this.h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                n26 n26Var = (n26) vh.e(map2.get(pair.first));
                arrayList2.add(new pr0.b().f(bitmapDecodeByteArray).k(n26Var.b).l(0).h(n26Var.c, 0).i(n26Var.e).n(n26Var.f).g(n26Var.g).r(n26Var.j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            n26 n26Var2 = (n26) vh.e(map2.get(entry.getKey()));
            pr0.b bVar = (pr0.b) entry.getValue();
            e((SpannableStringBuilder) vh.e(bVar.e()));
            bVar.h(n26Var2.c, n26Var2.d);
            bVar.i(n26Var2.e);
            bVar.k(n26Var2.b);
            bVar.n(n26Var2.f);
            bVar.q(n26Var2.i, n26Var2.h);
            bVar.r(n26Var2.j);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    public final void i(TreeSet<Long> treeSet, boolean z) {
        boolean zEquals = "p".equals(this.f19131a);
        boolean zEquals2 = "div".equals(this.f19131a);
        if (z || zEquals || (zEquals2 && this.i != null)) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.m == null) {
            return;
        }
        for (int i = 0; i < this.m.size(); i++) {
            this.m.get(i).i(treeSet, z || zEquals);
        }
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    @Nullable
    public String[] l() {
        return this.g;
    }

    public boolean m(long j) {
        long j2 = this.d;
        return (j2 == -9223372036854775807L && this.e == -9223372036854775807L) || (j2 <= j && this.e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.e) || (j2 <= j && j < this.e));
    }

    public final void n(long j, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (m(j) && "div".equals(this.f19131a) && this.i != null) {
            list.add(new Pair<>(str, this.i));
            return;
        }
        for (int i = 0; i < g(); i++) {
            f(i).n(j, str, list);
        }
    }

    public final void o(long j, Map<String, p26> map, Map<String, n26> map2, String str, Map<String, pr0.b> map3) {
        int i;
        if (m(j)) {
            String str2 = "".equals(this.h) ? str : this.h;
            Iterator<Map.Entry<String, Integer>> it = this.l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int iIntValue = this.k.containsKey(key) ? this.k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (pr0.b) vh.e(map3.get(key)), iIntValue, iIntValue2, ((n26) vh.e(map2.get(str2))).j);
                }
            }
            for (i = 0; i < g(); i++) {
                f(i).o(j, map, map2, str2, map3);
            }
        }
    }

    public final void p(long j, boolean z, String str, Map<String, pr0.b> map) {
        this.k.clear();
        this.l.clear();
        if ("metadata".equals(this.f19131a)) {
            return;
        }
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (this.c && z) {
            k(str, map).append((CharSequence) vh.e(this.b));
            return;
        }
        if ("br".equals(this.f19131a) && z) {
            k(str, map).append('\n');
            return;
        }
        if (m(j)) {
            for (Map.Entry<String, pr0.b> entry : map.entrySet()) {
                this.k.put(entry.getKey(), Integer.valueOf(((CharSequence) vh.e(entry.getValue().e())).length()));
            }
            boolean zEquals = "p".equals(this.f19131a);
            for (int i = 0; i < g(); i++) {
                f(i).p(j, z || zEquals, str, map);
            }
            if (zEquals) {
                o26.c(k(str, map));
            }
            for (Map.Entry<String, pr0.b> entry2 : map.entrySet()) {
                this.l.put(entry2.getKey(), Integer.valueOf(((CharSequence) vh.e(entry2.getValue().e())).length()));
            }
        }
    }
}
