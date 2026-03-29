package defpackage;

import android.content.Intent;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.palmchat.greendao.model.ISupperFeedBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class tt1<T extends ISupperFeedBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f21064a;
    public t64 b;
    public int c;
    public String d;
    public String e;
    public long f;
    public boolean g = false;

    public String a() {
        return this.e;
    }

    public void b(Intent intent) {
        this.c = intent.getIntExtra("key_from", 0);
        this.f21064a = (T) intent.getParcelableExtra("key_feed_bean");
        this.g = intent.getBooleanExtra("key_show_comment", false);
        if (this.c == 11) {
            this.g = true;
        }
        this.f = intent.getLongExtra("key_feed_id", -1L);
        this.d = intent.getStringExtra("key_feed_exid");
        this.e = intent.getStringExtra("key_feed_uid");
        c(this.f21064a);
    }

    public void c(T t) {
        if (t != null) {
            this.f21064a = t;
            t64 t64Var = this.b;
            if (t64Var != null) {
                t64Var.d(t);
            }
        }
    }

    public void d(int i, String str) {
        t64 t64Var = this.b;
        if (t64Var != null) {
            t64Var.b(i, str);
        }
    }

    public void e() {
        t64 t64Var = this.b;
        if (t64Var != null) {
            t64Var.a();
        }
    }

    public void f(BaseNetBean<T> baseNetBean) {
        t64 t64Var = this.b;
        if (t64Var == null || baseNetBean == null) {
            return;
        }
        t64Var.g(baseNetBean.resultCode, baseNetBean.getErrMsg());
    }

    public void g(int i, String str) {
        t64 t64Var = this.b;
        if (t64Var != null) {
            t64Var.e(i, str);
        }
    }

    public void h(t64 t64Var) {
        this.b = t64Var;
    }
}
