package defpackage;

import com.zenmen.palmchat.friendcircle.bean.SquareSimpleComment;
import com.zenmen.square.comment.struct.CommentItem;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class mi0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<CommentItem> f19221a;
    public List<SquareSimpleComment> b;
    public long c;
    public int d;
    public long e;
    public String f = "";
    public double g = -1.0d;
    public boolean h;

    public List<CommentItem> a() {
        return this.f19221a;
    }

    public long b() {
        return this.e;
    }

    public double c() {
        return this.g;
    }

    public long d() {
        return this.c;
    }

    public List<SquareSimpleComment> e() {
        return this.b;
    }

    public int f() {
        return this.d;
    }

    public boolean g() {
        return this.h;
    }

    public void h(List<CommentItem> list) {
        this.f19221a = list;
    }

    public void i(boolean z) {
        this.h = z;
    }

    public void j(List<SquareSimpleComment> list) {
        this.b = list;
    }

    public String toString() {
        return "CommentResultModel{comments=" + this.f19221a + ", sequence=" + this.c + ", weight=" + this.d + ", queryTime=" + this.e + ", topCmtId=" + this.f + '}';
    }
}
