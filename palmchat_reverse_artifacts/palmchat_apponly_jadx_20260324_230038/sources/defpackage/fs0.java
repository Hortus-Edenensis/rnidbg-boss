package defpackage;

import android.content.Context;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class fs0 {
    public static String d = "MsgSenderManager";
    public static volatile fs0 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<mn2> f17588a = new ArrayList();
    public Context b;
    public ExecutorService c;

    public fs0() {
        f();
    }

    public static fs0 d() {
        if (e == null) {
            synchronized (fs0.class) {
                if (e == null) {
                    e = new fs0();
                }
            }
        }
        return e;
    }

    public eo3 a(MessageVo messageVo) {
        mn2 mn2VarC = c(messageVo);
        if (mn2VarC != null) {
            return mn2VarC.b(messageVo);
        }
        return null;
    }

    public boolean b(MessageVo messageVo) {
        return c(messageVo) != null;
    }

    public final mn2 c(MessageVo messageVo) {
        if (messageVo != null) {
            for (mn2 mn2Var : this.f17588a) {
                if (mn2Var.c(messageVo)) {
                    LogUtil.i(d, "findProcessor " + messageVo);
                    return mn2Var;
                }
            }
        }
        return null;
    }

    public Context e() {
        return this.b;
    }

    public final void f() {
        this.f17588a.add(new mi5());
        this.f17588a.add(new sj5());
        this.f17588a.add(new q96());
        this.f17588a.add(new v30());
    }

    public void g(Context context, ExecutorService executorService) {
        this.b = context;
        this.c = executorService;
    }
}
