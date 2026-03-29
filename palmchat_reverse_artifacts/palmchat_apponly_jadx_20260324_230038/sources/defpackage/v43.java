package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.g;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.cn2;
import defpackage.pd5;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class v43 implements cn2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatItem f21353a;
    public final Context b;
    public cn2.a c;
    public boolean d;
    public boolean e;
    public volatile long f;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements pd5.b<rb4> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21354a;

        public b(long j) {
            this.f21354a = j;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(ce5<? super rb4> ce5Var) {
            ce5Var.c(v43.this.l(this.f21354a));
        }
    }

    public v43(Context context, ChatItem chatItem) {
        this.b = context;
        this.f21353a = chatItem;
    }

    public static cn2 g(Context context, ChatItem chatItem) {
        return new v43(context, chatItem);
    }

    @Override // defpackage.cn2
    public void a() {
        if (this.d || this.e) {
            return;
        }
        z53.a("LocalMessageLoader", "loadMore");
        this.d = true;
        i(this.f);
    }

    @Override // defpackage.cn2
    public void b() {
        if (this.d || this.e) {
            return;
        }
        z53.a("LocalMessageLoader", "startLoad");
        this.d = true;
        i(-1L);
    }

    @Override // defpackage.cn2
    public void c(cn2.a aVar) {
        this.c = aVar;
    }

    public final void f(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public final boolean h(MessageVo messageVo) {
        int iN;
        if (messageVo.mimeType != 28 || (iN = g.n(messageVo)) == 1 || iN == 6 || iN == 5) {
            return false;
        }
        return ("88888888".equals(this.f21353a.getChatId()) && iN == 7) ? false : true;
    }

    public final void i(long j) {
        pd5.a(new b(j)).d(b35.c()).b(wc.a()).c(new a(l(j)));
    }

    public final void j(rb4 rb4Var) {
        z53.a("LocalMessageLoader", "onPageLoaded, size=" + rb4Var.f20434a.size() + ", reachEnd=" + rb4Var.b);
        this.e = rb4Var.b;
        this.d = false;
        cn2.a aVar = this.c;
        if (aVar != null) {
            aVar.a(rb4Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Cursor k(long j) {
        String[] strArr;
        String str;
        Cursor cursorQuery;
        Uri uriA = DBUriManager.a(ho3.class, this.f21353a.getBizType());
        if (j < 0) {
            strArr = new String[]{DomainHelper.a(this.f21353a, false)};
            str = "contact_relate=?";
        } else {
            strArr = new String[]{DomainHelper.a(this.f21353a, false), String.valueOf(j)};
            str = "contact_relate=? and _id <= ?";
        }
        try {
            cursorQuery = this.b.getContentResolver().query(uriA, null, str, strArr, "_id");
            if (cursorQuery != null) {
                try {
                    boolean z = cursorQuery.moveToLast() ? false : true;
                    if (!z) {
                        return cursorQuery;
                    }
                } catch (Exception e) {
                    e = e;
                    z53.c("LocalMessageLoader", "query error", e);
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        }
        f(cursorQuery);
        return null;
    }

    public final rb4 l(long j) {
        boolean z;
        z53.a("LocalMessageLoader", "readPage, lastId=" + j);
        Cursor cursorK = k(j);
        if (cursorK == null) {
            return rb4.a();
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            z = true;
            try {
                MessageVo messageVoBuildFromCursor = MessageVo.buildFromCursor(cursorK);
                if (h(messageVoBuildFromCursor)) {
                    linkedList.add(messageVoBuildFromCursor);
                    this.f = messageVoBuildFromCursor._id;
                    if (linkedList.size() == 10) {
                        z = false;
                        break;
                    }
                }
                if (!cursorK.moveToPrevious()) {
                    break;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                f(cursorK);
                throw th;
            }
        }
        f(cursorK);
        return new rb4(linkedList, z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ce5<rb4> {
        public final /* synthetic */ rb4 b;

        public a(rb4 rb4Var) {
            this.b = rb4Var;
        }

        @Override // defpackage.ce5
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(rb4 rb4Var) {
            v43.this.j(this.b);
        }

        @Override // defpackage.ce5
        public void b(Throwable th) {
        }
    }
}
