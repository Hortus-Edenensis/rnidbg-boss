package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.zenmen.palmchat.greendao.model.ISupperFeedBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class no0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout f19564a;
    public fa3 b;

    public no0(ConstraintLayout constraintLayout) {
        this.f19564a = constraintLayout;
        LayoutInflater.from(constraintLayout.getContext()).inflate(b(), (ViewGroup) this.f19564a, true);
        c();
    }

    public abstract void a(ISupperFeedBean iSupperFeedBean);

    public abstract int b();

    public abstract void c();

    public void d(fa3 fa3Var) {
        this.b = fa3Var;
    }
}
