package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class x84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21903a = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f21904a;

        public a(b bVar) {
            this.f21904a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x84.this.f21903a) {
                return;
            }
            this.f21904a.a();
            x84.this.f21903a = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void b(View view);

        void onError(String str);
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            return;
        }
        try {
            int iF = w84.f();
            String strG = w84.g();
            if (iF > 0 && !TextUtils.isEmpty(strG)) {
                View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_open_sreen, (ViewGroup) null, false);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_open_screen);
                bVar.b(viewInflate);
                hc2.a(context).load(strG).into(imageView);
                viewInflate.postDelayed(new a(bVar), iF);
                return;
            }
            this.f21903a = true;
            bVar.onError("");
        } catch (Exception e) {
            e.printStackTrace();
            if (this.f21903a) {
                return;
            }
            bVar.onError("");
            this.f21903a = true;
        }
    }
}
