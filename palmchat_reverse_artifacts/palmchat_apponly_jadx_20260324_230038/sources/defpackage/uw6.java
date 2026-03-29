package defpackage;

import android.content.Context;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class uw6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, b> f21308a;
    public int b;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21309a;
        public final String b;
        public final String c;
        public int d;

        public b(String str, String str2, String str3) {
            this.f21309a = str;
            this.b = str2;
            this.c = str3;
        }

        public int a() {
            int i = this.d;
            this.d = i + 1;
            return i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final uw6 f21310a = new uw6();
    }

    public uw6() {
        this.f21308a = new ArrayMap();
    }

    public static uw6 d() {
        return c.f21310a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Context context, pw6 pw6Var) {
        h(context, pw6Var.i(), pw6Var.m(), pw6Var.b());
    }

    public static /* synthetic */ String i() {
        return "context is empty.";
    }

    public void e(@NonNull final pw6 pw6Var) {
        final Context applicationContext = pw6Var.j().getApplicationContext();
        if (applicationContext == null) {
            n87.a("ChattyEventTracker", new la7() { // from class: lt6
                @Override // defpackage.la7
                public final Object get() {
                    return uw6.i();
                }
            });
        } else {
            po6.d(new Runnable() { // from class: nt6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19601a.g(applicationContext, pw6Var);
                }
            });
        }
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void j(Context context) {
        for (b bVar : this.f21308a.values()) {
            pw6 pw6Var = new pw6(context, "21000", PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY, "chatty_event");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("app_id", String.valueOf(bVar.f21309a));
            arrayMap.put("log_tag", bVar.b);
            arrayMap.put("event_id", bVar.c);
            arrayMap.put("times", String.valueOf(bVar.d));
            pw6Var.l(arrayMap);
            j47.a(context, pw6Var);
        }
        this.b = 0;
        this.f21308a.clear();
        po6.b().g(1);
    }

    public final void h(final Context context, String str, String str2, String str3) {
        String str4 = str + str2 + str3;
        b bVar = this.f21308a.get(str4);
        if (bVar == null) {
            b bVar2 = new b(str, str2, str3);
            bVar2.a();
            this.f21308a.put(str4, bVar2);
        } else {
            bVar.a();
        }
        int i = this.b + 1;
        this.b = i;
        if (i >= 100) {
            j(context);
        } else {
            if (i != 1 || po6.b().e(1)) {
                return;
            }
            po6.b().c(1, new Runnable() { // from class: ot6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19874a.j(context);
                }
            }, 300000L);
        }
    }
}
