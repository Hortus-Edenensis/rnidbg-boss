package defpackage;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class go3 {
    public static volatile go3 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f17761a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap<String, eo3> f17762a;

        public void a(String str, eo3 eo3Var) {
            this.f17762a.put(str, eo3Var);
            LogUtil.i("MessageSendTaskManager", "addTask" + this.f17762a.size());
        }

        public eo3 b(String str) {
            return this.f17762a.get(str);
        }

        public void c() {
            this.f17762a.clear();
        }

        public void d(String str) {
            this.f17762a.remove(str);
            LogUtil.i("MessageSendTaskManager", "removeTask" + this.f17762a.size());
        }

        public a() {
            this.f17762a = new HashMap<>();
        }
    }

    public static go3 b() {
        if (b == null) {
            synchronized (go3.class) {
                if (b == null) {
                    b = new go3();
                }
            }
        }
        return b;
    }

    public void a(String str, eo3 eo3Var) {
        this.f17761a.a(str, eo3Var);
    }

    public eo3 c(String str) {
        return this.f17761a.b(str);
    }

    public void d() {
        this.f17761a.c();
    }

    public void e(String str) {
        this.f17761a.d(str);
    }
}
