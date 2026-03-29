package defpackage;

import android.app.Activity;
import android.content.DialogInterface;
import com.zenmen.square.comment.model.CommentViewModel;
import com.zenmen.square.comment.model.ResultBean;
import com.zenmen.square.comment.model.UserInfoItem;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.nq3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class et2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.zenmen.square.comment.ui.b f17355a;
    public Activity b;
    public ro6 c;
    public UserInfoItem d;
    public yk2 e;
    public nq3.b f;
    public List<c> g = new ArrayList();
    public final Object h = new Object();
    public ResultBean i;
    public SquareFeed j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DialogInterface.OnShowListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            et2 et2Var = et2.this;
            if (et2Var.g != null) {
                synchronized (et2Var.h) {
                    for (c cVar : et2.this.g) {
                        if (cVar != null) {
                            cVar.onShow();
                        }
                    }
                }
                et2.this.c.x();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            et2 et2Var = et2.this;
            if (et2Var.g != null) {
                synchronized (et2Var.h) {
                    for (c cVar : et2.this.g) {
                        if (cVar != null) {
                            cVar.onDismiss();
                        }
                    }
                }
            }
            et2.this.c.n();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void onDismiss();

        void onShow();
    }

    public et2(Activity activity, com.zenmen.square.comment.ui.b bVar, UserInfoItem userInfoItem, SquareFeed squareFeed) {
        this.b = activity;
        this.f17355a = bVar;
        this.d = userInfoItem;
        this.j = squareFeed;
    }

    public void c(c cVar) {
        synchronized (this.h) {
            if (cVar != null) {
                this.g.add(cVar);
            }
        }
    }

    public final boolean d(ResultBean resultBean, ResultBean resultBean2) {
        return resultBean != null && resultBean == resultBean2;
    }

    public void e(ResultBean resultBean, String str, CommentViewModel commentViewModel, int i, int i2, boolean z, int i3) throws Throwable {
        ro6 ro6Var = this.c;
        if (ro6Var != null && ro6Var.isShowing()) {
            this.c.dismiss();
        }
        ro6 ro6Var2 = new ro6(this.b, resultBean, this.d, this.j, this.f17355a, z);
        this.c = ro6Var2;
        ro6Var2.w(this.f);
        this.c.t(this.e);
        this.c.y(resultBean, str, commentViewModel, i, i2, i3);
        this.c.F(str);
    }

    public void f(yk2 yk2Var) {
        this.e = yk2Var;
    }

    public void g(SquareFeed squareFeed) {
        this.j = squareFeed;
        ro6 ro6Var = this.c;
        if (ro6Var != null) {
            ro6Var.u(squareFeed);
        }
    }

    public void h(nq3.b bVar) {
        this.f = bVar;
    }

    public void i(ResultBean resultBean, String str, CommentViewModel commentViewModel, int i, int i2, boolean z, int i3) throws Throwable {
        b05.d("showCommentInput()");
        if (d(this.i, resultBean)) {
            this.c.y(resultBean, str, commentViewModel, i, i2, i3);
            this.c.F(str);
            this.c.show();
            this.c.z(null);
            return;
        }
        e(resultBean, str, commentViewModel, i, i2, z, i3);
        this.i = resultBean;
        this.c.setOnShowListener(new a());
        this.c.show();
        this.c.z(null);
        this.c.setOnDismissListener(new b());
    }
}
