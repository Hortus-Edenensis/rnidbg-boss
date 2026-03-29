package defpackage;

import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public abstract class s0 implements Runnable {
    public static final String e = "s0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageVo f20636a;
    public boolean b;
    public jo3 c;
    public zy d;

    public s0(MessageVo messageVo) {
        this.f20636a = messageVo;
    }

    public void a() {
        LogUtil.i(e, "cancel policy=" + this.c + " fileUploader=" + this.d);
        this.b = true;
        jo3 jo3Var = this.c;
        if (jo3Var != null) {
            jo3Var.c();
        }
        zy zyVar = this.d;
        if (zyVar != null) {
            zyVar.cancel();
        }
        c();
    }

    public boolean b() {
        return this.b;
    }

    public abstract void c();

    public abstract void d();

    public void e(zy zyVar) {
        LogUtil.i(e, "setFileUploader isCanceled()" + b());
        this.d = zyVar;
        if (b()) {
            this.d.cancel();
        }
    }

    public void f(jo3 jo3Var) {
        LogUtil.i(e, "setMessagingRetryPolicy isCanceled()" + b());
        this.c = jo3Var;
        if (b()) {
            this.c.c();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (b()) {
            return;
        }
        d();
    }
}
