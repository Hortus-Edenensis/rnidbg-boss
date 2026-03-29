package defpackage;

import com.zenmen.square.comment.struct.CommentReplyItem;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class cw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<CommentReplyItem> f16938a;
    public long b;
    public long c;
    public boolean d;

    public List<CommentReplyItem> a() {
        return this.f16938a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public void e(boolean z) {
        this.d = z;
    }

    public void f(List<CommentReplyItem> list) {
        this.f16938a = list;
    }

    public String toString() {
        return "ReplyResultModel{replies=" + this.f16938a + ", sequence=" + this.b + '}';
    }
}
