package defpackage;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vp5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f21503a;
    public SwipeBackLayout b;

    public vp5(Activity activity) {
        this.f21503a = activity;
    }

    public View b(int i) {
        SwipeBackLayout swipeBackLayout = this.b;
        if (swipeBackLayout != null) {
            return swipeBackLayout.findViewById(i);
        }
        return null;
    }

    public SwipeBackLayout c() {
        return this.b;
    }

    public void d() {
        this.f21503a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f21503a.getWindow().getDecorView().setBackgroundDrawable(null);
        SwipeBackLayout swipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this.f21503a).inflate(R.layout.lx_swipeback_layout, (ViewGroup) null);
        this.b = swipeBackLayout;
        swipeBackLayout.addSwipeListener(new a());
    }

    public void e() {
        this.b.attachToActivity(this.f21503a);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SwipeBackLayout.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout.a
        public void c(int i) {
            y86.a(vp5.this.f21503a);
        }

        @Override // com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout.a
        public void a() {
        }

        @Override // com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout.a
        public void b(int i, float f) {
        }
    }
}
