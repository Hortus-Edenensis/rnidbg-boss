package defpackage;

import androidx.annotation.NonNull;
import com.zenmen.square.R$drawable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class qs5 implements Comparable<qs5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20313a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean g;
    public int h;
    public int f = R$drawable.bg_text_dot_red;
    public int i = 24;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull qs5 qs5Var) {
        return this.f20313a > qs5Var.f20313a ? 1 : -1;
    }

    public long b() {
        return ((long) (this.i * 3600)) * 1000;
    }
}
