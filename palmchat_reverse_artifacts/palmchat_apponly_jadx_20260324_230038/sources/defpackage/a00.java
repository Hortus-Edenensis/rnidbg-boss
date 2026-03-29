package defpackage;

import com.zenmen.palmchat.maintab.config.CellItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1127a = 0;
    public String b = "";
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;

    public static a00 a(CellItem cellItem) {
        a00 a00Var = new a00();
        a00Var.c = cellItem.getNameForShow();
        a00Var.d = cellItem.icon;
        a00Var.f = cellItem.noticeType;
        return a00Var;
    }
}
