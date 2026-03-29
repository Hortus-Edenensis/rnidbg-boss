package defpackage;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.chat.chatprofile.bean.ChatProfileInfo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import defpackage.c40;
import defpackage.ro2;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class i55 {

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ro2.b f18107a;

        public c(ro2.b bVar) {
            this.f18107a = bVar;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject.optInt("resultCode") != 0) {
                this.f18107a.onError("");
                return;
            }
            try {
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP == null) {
                    this.f18107a.onError("");
                    return;
                }
                ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemP.getUid());
                if (contactInfoItemL == null || contactInfoItemL.getIsStranger()) {
                    if (contactInfoItemL != null) {
                        contactInfoItemP.setRemarkName(contactInfoItemL.getRemarkName());
                        contactInfoItemP.setDescription(contactInfoItemL.getDescription());
                    }
                    AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.a(contactInfoItemP));
                }
                this.f18107a.a(contactInfoItemP);
            } catch (Exception e) {
                this.f18107a.onError("");
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ro2.b f18108a;

        public d(ro2.b bVar) {
            this.f18108a = bVar;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f18108a.onError("");
        }
    }

    public static void a(ContactRequestArgs contactRequestArgs, ro2.b bVar) {
        ContactInfoItem contactInfoItemA = dn0.a(contactRequestArgs.f());
        if (contactInfoItemA != null) {
            bVar.a(contactInfoItemA);
            return;
        }
        try {
            new l92(new c(bVar), new d(bVar)).o(contactRequestArgs.f(), contactRequestArgs.e());
        } catch (DaoException e) {
            e.printStackTrace();
            bVar.onError("");
        }
    }

    public static void b(ContactRequestArgs contactRequestArgs) {
        a(contactRequestArgs, new a(contactRequestArgs));
    }

    public static void c(String str, String str2) {
        c40.b().c(str, new b(str, str2), true);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ro2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactRequestArgs f18104a;

        /* JADX INFO: renamed from: i55$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1209a implements c40.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactInfoItem f18105a;

            public C1209a(ContactInfoItem contactInfoItem) {
                this.f18105a = contactInfoItem;
            }

            @Override // c40.b
            public void a(ChatProfileInfo chatProfileInfo) {
                rn0.k(this.f18105a, a.this.f18104a, chatProfileInfo);
            }

            @Override // c40.b
            public void onFail() {
                rn0.k(this.f18105a, a.this.f18104a, null);
            }
        }

        public a(ContactRequestArgs contactRequestArgs) {
            this.f18104a = contactRequestArgs;
        }

        @Override // ro2.b
        public void a(ContactInfoItem contactInfoItem) {
            if (contactInfoItem != null) {
                c40.b().c(contactInfoItem.getUid(), new C1209a(contactInfoItem), true);
            }
        }

        @Override // ro2.b
        public void onError(String str) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c40.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18106a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.f18106a = str;
            this.b = str2;
        }

        @Override // c40.b
        public void a(ChatProfileInfo chatProfileInfo) {
            rn0.t(this.f18106a, this.b, chatProfileInfo);
        }

        @Override // c40.b
        public void onFail() {
        }
    }
}
