package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.greendao.model.Feed;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class nq3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f19577a;
    public d b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Activity activity, Feed feed, int i, int i2, b bVar);

        void b(Context context, Feed feed, int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i, Object obj, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(Context context);

        Intent b(Context context, Feed feed, Long l, String str, String str2, int i, ContactInfoItem contactInfoItem);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static nq3 f19578a = new nq3();
    }

    public static nq3 a() {
        return e.f19578a;
    }

    public Intent b(Context context, Feed feed, Long l, String str, String str2, int i, ContactInfoItem contactInfoItem) {
        d dVar = this.b;
        if (dVar != null) {
            return dVar.b(context, feed, l, str, str2, i, contactInfoItem);
        }
        return null;
    }

    public void c(Context context) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(context);
        }
    }

    public void d(a aVar) {
        this.f19577a = aVar;
    }

    public void e(d dVar) {
        this.b = dVar;
    }

    public void f(Context context, Feed feed, int i, int i2) {
        a aVar = this.f19577a;
        if (aVar != null) {
            aVar.b(context, feed, i, i2);
        }
    }

    public void g(Activity activity, Feed feed, int i, int i2, b bVar) {
        a aVar = this.f19577a;
        if (aVar != null) {
            aVar.a(activity, feed, i, i2, bVar);
        }
    }
}
