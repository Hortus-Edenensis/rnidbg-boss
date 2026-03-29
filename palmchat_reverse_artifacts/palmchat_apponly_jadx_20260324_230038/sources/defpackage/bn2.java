package defpackage;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface bn2 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<MediaItem> f1773a = new ArrayList<>();
        public List<c> b = new ArrayList();
        public HashMap<String, ArrayList<MediaItem>> c = new HashMap<>();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1774a = 7;
        public a b = new a();
        public a c = new a();
        public a d = new a();
        public boolean e = false;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1775a;
        public long b;
        public String c;
        public String d;
        public int e = 0;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(int i);

        void b(boolean z, int i, String str);
    }

    void a(Activity activity, int i, int i2);

    Intent b(Activity activity);

    void c(Fragment fragment, int i, int i2, int i3);

    void d(FrameworkBaseActivity frameworkBaseActivity, String str, int i, int i2);

    void e(String str, d dVar);

    void f(Activity activity, int i);

    void g(Activity activity, int i, int i2, int i3, int i4);

    void h(Activity activity, MediaItem mediaItem, int i);

    void i(Activity activity, int i, int i2);

    void j(Activity activity, int i, int i2, int i3);
}
