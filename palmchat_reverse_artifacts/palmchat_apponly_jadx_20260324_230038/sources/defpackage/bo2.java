package defpackage;

import com.zenmen.palmchat.framework.FrameworkBaseActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class bo2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1790a;
    public FrameworkBaseActivity b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onFinish(boolean z);
    }

    public bo2(FrameworkBaseActivity frameworkBaseActivity, a aVar) {
        this.b = frameworkBaseActivity;
        this.f1790a = aVar;
    }

    public abstract void a(String str);
}
