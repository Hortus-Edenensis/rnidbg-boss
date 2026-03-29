package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.NestTopicFeedsActivity;
import com.zenmen.square.R$string;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.SquareTagBean;
import defpackage.ro2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xu3 implements rl2, t64<SquareFeed> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ki5 f22055a;
    public lo0 b;
    public boolean c;
    public c d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ro2.b {
        public a() {
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            xu3.this.b.j();
            xu3.this.f22055a.p(contactInfoItem);
            xu3.this.b.n(contactInfoItem);
        }

        @Override // ro2.b
        public void onError(String str) {
            xu3.this.b.j();
            lo0 lo0Var = xu3.this.b;
            lo0Var.w(lo0Var.h().getString(R$string.get_user_info_failed));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareTagBean f22057a;

        public b(SquareTagBean squareTagBean) {
            this.f22057a = squareTagBean;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            xu3.this.f22055a.p(contactInfoItem);
            xu3.this.b.m(this.f22057a, contactInfoItem);
        }

        @Override // ro2.b
        public void onError(String str) {
            xu3 xu3Var = xu3.this;
            if (xu3Var.c) {
                return;
            }
            xu3Var.b.j();
            lo0 lo0Var = xu3.this.b;
            lo0Var.w(lo0Var.h().getString(R$string.get_user_info_failed));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();
    }

    public xu3(ki5 ki5Var, lo0 lo0Var, c cVar) {
        this.f22055a = ki5Var;
        ki5Var.h(this);
        this.b = lo0Var;
        this.d = cVar;
    }

    @Override // defpackage.t64
    public void a() {
        this.b.j();
        this.b.f();
    }

    @Override // defpackage.t64
    public void b(int i, String str) {
        this.b.j();
        this.b.w(str);
    }

    @Override // defpackage.rl2
    public void c() {
        this.f22055a.o();
    }

    @Override // defpackage.t64
    public void e(int i, String str) {
        this.b.w(str);
    }

    @Override // defpackage.rl2
    public void f() {
        this.b.v();
        this.f22055a.i();
    }

    @Override // defpackage.t64
    public void g(int i, String str) {
        this.b.w(str);
        this.b.j();
        if (i == -1003) {
            this.d.a();
        } else if (this.f22055a.k() == null || this.f22055a.k().isEmptyFeed()) {
            this.b.g();
        }
    }

    @Override // defpackage.rl2
    public void h() {
        String strA = this.f22055a.k().uid;
        if (TextUtils.isEmpty(this.f22055a.k().uid)) {
            strA = this.f22055a.a();
        }
        z66.c(4, this.f22055a.k().id, strA, this.f22055a.k().exid, this.f22055a.k(), this.b.h());
    }

    @Override // defpackage.rl2
    public void i() {
        this.f22055a.m();
    }

    @Override // defpackage.rl2
    public void j() {
        if (this.f22055a.k() == null) {
            return;
        }
        if (this.f22055a.j() == null) {
            ki5 ki5Var = this.f22055a;
            ki5Var.p(dn0.b(ki5Var.k().exid));
        }
        if (this.f22055a.j() != null) {
            this.b.n(this.f22055a.j());
        } else {
            this.b.v();
            bj5.b().a().q(this.f22055a.k().exid, new a());
        }
    }

    public void k() {
        ContactInfoItem contactInfoItemJ = this.f22055a.j();
        SquareTagBean squareTagBeanN = ai5.k().n(this.f22055a.k().tagId);
        if (contactInfoItemJ != null) {
            this.b.m(squareTagBeanN, contactInfoItemJ);
        } else {
            this.b.v();
            bj5.b().a().q(this.f22055a.k().exid, new b(squareTagBeanN));
        }
    }

    public void l(SquareFeed squareFeed) {
        NestTopicFeedsActivity.G1(this.b.h(), squareFeed.topicId, this.f22055a.l());
    }

    @Override // defpackage.t64
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void d(SquareFeed squareFeed) {
        if (squareFeed != null) {
            this.b.p(squareFeed);
        }
    }

    @Override // defpackage.rl2
    public void onCreate() {
        this.b.l(this.f22055a.k());
    }

    @Override // defpackage.rl2
    public void onDestroy() {
        this.c = true;
        this.b.q();
    }
}
