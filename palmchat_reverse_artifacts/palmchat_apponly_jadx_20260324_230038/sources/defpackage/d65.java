package defpackage;

import androidx.annotation.Nullable;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d65 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f16986a;

        public a(c cVar) {
            this.f16986a = cVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject.optInt("resultCode") == 0) {
                iq5.j(false, new String[0]);
            }
            c cVar = this.f16986a;
            if (cVar != null) {
                cVar.onSuccess();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f16987a;

        public b(c cVar) {
            this.f16987a = cVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            c cVar = this.f16987a;
            if (cVar != null) {
                cVar.onError();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void onError();

        void onSuccess();
    }

    public static void a(ContactInfoItem contactInfoItem, int i, int i2, @Nullable c cVar) {
        try {
            new k00(new a(cVar), new b(cVar)).n(contactInfoItem.getChatId(), AccountUtils.p(AppContext.getContext()), i, i2);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static boolean b() {
        return true;
    }

    public static boolean c(ContactInfoItem contactInfoItem) {
        return !jw5.e(contactInfoItem.getSessionConfig());
    }

    public static boolean d(ContactInfoItem contactInfoItem) {
        return jw5.e(contactInfoItem.getSupportConfig());
    }

    public static boolean e(ContactInfoItem contactInfoItem) {
        return jw5.g(contactInfoItem.getSessionConfig());
    }

    public static boolean f(ContactInfoItem contactInfoItem) {
        return c(contactInfoItem) && jw5.g(contactInfoItem.getSupportConfig());
    }

    public static boolean g(ContactInfoItem contactInfoItem) {
        return jw5.h(contactInfoItem.getSessionConfig());
    }

    public static boolean h(ContactInfoItem contactInfoItem) {
        return c(contactInfoItem) && jw5.f(contactInfoItem.getSupportConfig(), 128);
    }

    public static boolean i(ContactInfoItem contactInfoItem) {
        return jw5.j(contactInfoItem.getSessionConfig());
    }

    public static boolean j(ContactInfoItem contactInfoItem) {
        return c(contactInfoItem) && jw5.j(contactInfoItem.getSupportConfig());
    }

    public static void k(ContactInfoItem contactInfoItem, boolean z, @Nullable c cVar) {
        a(contactInfoItem, 3, !z ? 1 : 0, null);
    }

    public static void l(ContactInfoItem contactInfoItem, boolean z) {
        a(contactInfoItem, 1, z ? 1 : 0, null);
    }

    public static void m(ContactInfoItem contactInfoItem, boolean z) {
        a(contactInfoItem, 7, !z ? 1 : 0, null);
    }

    public static void n(ContactInfoItem contactInfoItem, boolean z) {
        a(contactInfoItem, 0, z ? 1 : 0, null);
    }
}
