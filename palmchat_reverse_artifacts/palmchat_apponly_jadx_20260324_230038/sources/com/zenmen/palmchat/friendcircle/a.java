package com.zenmen.palmchat.friendcircle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.friendcircle.base.view.adapter.MomentsBaseAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f13996a;
    public InterfaceC1048a b;
    public View c;

    /* JADX INFO: renamed from: com.zenmen.palmchat.friendcircle.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC1048a {
        void a();

        void g(int i);
    }

    public a(Activity activity, InterfaceC1048a interfaceC1048a) {
        this.f13996a = activity;
        this.b = interfaceC1048a;
    }

    public abstract void a(String str, int i);

    public abstract void b(int i);

    public abstract RecyclerView c();

    public abstract View d(LayoutInflater layoutInflater);

    public abstract void e();

    public abstract void f();

    public abstract void g(boolean z);

    public abstract void h(boolean z, boolean z2);

    public abstract void i(boolean z);

    public abstract void j();

    public abstract void k(MomentsBaseAdapter momentsBaseAdapter);

    public abstract void l(boolean z);

    public abstract void m(boolean z, String str, String str2, String[] strArr);
}
