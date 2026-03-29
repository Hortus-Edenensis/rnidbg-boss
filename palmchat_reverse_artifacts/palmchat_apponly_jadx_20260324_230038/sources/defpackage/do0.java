package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.litesuits.async.AsyncTask;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.ContactRequestArgs;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.contacts.NewContactRequestSendActivityV2;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class do0 implements al2 {
    public static final String h = "do0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e92 f17090a;
    public o2 b;
    public l92 c;
    public bq3 d;
    public ih e;
    public f7 f;
    public n56 g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17091a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ fo0 e;

        public a(boolean z, String str, int i, int i2, fo0 fo0Var) {
            this.f17091a = z;
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = fo0Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0 || iOptInt == 1) {
                if (this.f17091a) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("accept_status", (Long) 2L);
                    contentValues.put("request_type", (Integer) 0);
                    contentValues.put("rid", AccountUtils.p(AppContext.getContext()) + "_" + this.b);
                    AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=?", new String[]{this.b});
                } else {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("accept_status", (Long) 2L);
                    AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues2, "from_uid=?", new String[]{this.b});
                }
                if (this.c == 21) {
                    wh4.d(this.b, this.d);
                }
                this.e.onResponse(0, jSONObject.toString());
            } else if (iOptInt == 1320 || iOptInt != 1321) {
                this.e.onResponse(1, jSONObject.toString());
            } else {
                this.e.onResponse(1, jSONObject.toString());
            }
            rn0.g(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Void, Void, String> {
        public final /* synthetic */ fo0 m;

        public b(fo0 fo0Var) {
            this.m = fo0Var;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public String g(Void... voidArr) {
            try {
                Cursor cursorQuery = AppContext.getContext().getContentResolver().query(vn0.f21483a, null, "request_type = ? and insert_date=? ", new String[]{String.valueOf(302), um1.b().a()}, null);
                if (cursorQuery == null) {
                    return "";
                }
                LogUtil.i(do0.h, "queryHistoryEnhancedContact, size = " + cursorQuery.getColumnCount());
                ArrayList<ContactRequestsVO> arrayListBuildFromCursorForEnhancedContact = ContactRequestsVO.buildFromCursorForEnhancedContact(cursorQuery, false, true);
                for (ContactRequestsVO contactRequestsVO : arrayListBuildFromCursorForEnhancedContact) {
                    contactRequestsVO.getFormatShowName();
                    contactRequestsVO.getIsFriend();
                }
                cursorQuery.close();
                return az2.c(arrayListBuildFromCursorForEnhancedContact);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(String str) {
            this.m.onResponse(TextUtils.isEmpty(str) ? 1 : 0, str);
            super.n(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Response.Listener<JSONObject> {
        public c() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fo0 f17094a;

        public e(fo0 fo0Var) {
            this.f17094a = fo0Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            ContactInfoItem contactInfoItemL;
            if (jSONObject.optInt("resultCode") != 0) {
                this.f17094a.onResponse(1, "");
                return;
            }
            try {
                ContactInfoItem contactInfoItemP = l92.p(jSONObject);
                if (contactInfoItemP != null && ((contactInfoItemL = bo0.r().l(contactInfoItemP.getUid())) == null || contactInfoItemL.getIsStranger())) {
                    if (contactInfoItemL != null) {
                        contactInfoItemP.setRemarkName(contactInfoItemL.getRemarkName());
                        contactInfoItemP.setDescription(contactInfoItemL.getDescription());
                    }
                    AppContext.getContext().getContentResolver().insert(ho0.f18003a, nn0.a(contactInfoItemP));
                }
                this.f17094a.onResponse(0, az2.c(contactInfoItemP));
            } catch (Exception e) {
                this.f17094a.onResponse(1, "");
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fo0 f17095a;

        public f(fo0 fo0Var) {
            this.f17095a = fo0Var;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f17095a.onResponse(1, "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fo0 f17096a;

        public g(fo0 fo0Var) {
            this.f17096a = fo0Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject.optInt("resultCode") != 0) {
                this.f17096a.onResponse(1, "");
                return;
            }
            try {
                this.f17096a.onResponse(0, jSONObject.getJSONObject("data").toString());
            } catch (Exception e) {
                this.f17096a.onResponse(1, "");
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fo0 f17097a;

        public h(fo0 fo0Var) {
            this.f17097a = fo0Var;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f17097a.onResponse(1, "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fo0 f17098a;

        public i(fo0 fo0Var) {
            this.f17098a = fo0Var;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f17098a.onResponse(1, "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17099a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ fo0 e;

        public j(String str, String str2, int i, String str3, fo0 fo0Var) {
            this.f17099a = str;
            this.b = str2;
            this.c = i;
            this.d = str3;
            this.e = fo0Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject.optInt("resultCode") != 0) {
                this.e.onResponse(1, jSONObject.toString());
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("accept_status", (Long) 1L);
            AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "rid=?", new String[]{this.f17099a});
            rn0.h(this.b, this.c);
            ContactInfoItem contactInfoItemL = bo0.r().l(this.b);
            if (contactInfoItemL != null) {
                do0.this.n(contactInfoItemL, this.d);
            }
            this.e.onResponse(0, jSONObject.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17100a;
        public final /* synthetic */ int b;
        public final /* synthetic */ fo0 c;

        public k(String str, int i, fo0 fo0Var) {
            this.f17100a = str;
            this.b = i;
            this.c = fo0Var;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
                wh4.i(this.f17100a, this.b);
                this.c.onResponse(0, jSONObject.toString());
            } else {
                if (iOptInt == 1) {
                    this.c.onResponse(1, jSONObject.toString());
                    return;
                }
                if (iOptInt == 1318) {
                    this.c.onResponse(1, jSONObject.toString());
                } else if (iOptInt == 1320 || iOptInt == 1321) {
                    this.c.onResponse(1, jSONObject.toString());
                } else {
                    this.c.onResponse(1, jSONObject.toString());
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fo0 f17101a;

        public l(fo0 fo0Var) {
            this.f17101a = fo0Var;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f17101a.onResponse(1, "");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fo0 f17102a;

        public m(fo0 fo0Var) {
            this.f17102a = fo0Var;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f17102a.onResponse(1, "");
        }
    }

    @Override // defpackage.al2
    public void a() {
        io0.b();
    }

    @Override // defpackage.al2
    public void b(String str, String str2, fo0 fo0Var) {
        l92 l92Var = new l92(new e(fo0Var), new f(fo0Var));
        this.c = l92Var;
        try {
            l92Var.o(str, str2);
        } catch (DaoException e2) {
            e2.printStackTrace();
            fo0Var.onResponse(1, "");
        }
    }

    @Override // defpackage.al2
    public void c(String str, String str2, String str3, int i2, int i3, fo0 fo0Var) {
        String strM;
        try {
            if (jo6.i() && io0.t(i3)) {
                ContactInfoItem contactInfoItemL = bo0.r().l(str);
                if (contactInfoItemL == null || TextUtils.isEmpty(contactInfoItemL.getRemarkName())) {
                    PhoneContactItem phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(str3);
                    if (phoneContactItem != null) {
                        strM = phoneContactItem.m();
                    }
                } else {
                    strM = contactInfoItemL.getRemarkName();
                }
                i iVar = new i(fo0Var);
                j jVar = new j(str2, str, i3, strM, fo0Var);
                o2 o2Var = new o2();
                this.b = o2Var;
                o2Var.n(str2, i2, strM, iVar, jVar);
                return;
            }
            o2Var.n(str2, i2, strM, iVar, jVar);
            return;
        } catch (DaoException e2) {
            e2.printStackTrace();
            fo0Var.onResponse(1, "");
            return;
        }
        strM = "";
        i iVar2 = new i(fo0Var);
        j jVar2 = new j(str2, str, i3, strM, fo0Var);
        o2 o2Var2 = new o2();
        this.b = o2Var2;
    }

    @Override // defpackage.al2
    public void d() {
        if (um1.b().d()) {
            n56 n56Var = new n56();
            this.g = n56Var;
            try {
                n56Var.n();
            } catch (DaoException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // defpackage.al2
    public void e(fo0 fo0Var) {
        new b(fo0Var).h(new Void[0]);
        LogUtil.i(h, "getEnhancedContactList,asyncTask");
    }

    @Override // defpackage.al2
    public void f(String str, String str2, String str3, String str4, boolean z, int i2, int i3, int i4, fo0 fo0Var) {
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(new Pair<>(str, str2)).i(String.valueOf(i3)).j(String.valueOf(i4)).f(str3).g(str4).a();
        f7 f7Var = new f7(new k(str, i2, fo0Var), new l(fo0Var));
        this.f = f7Var;
        try {
            f7Var.n(contactRequestArgsA);
        } catch (Exception unused) {
            fo0Var.onResponse(1, "");
        }
    }

    @Override // defpackage.al2
    public void g(String str, String str2, String str3, String str4, boolean z, int i2, int i3, int i4, fo0 fo0Var) {
        ContactRequestArgs contactRequestArgsA = new ContactRequestArgs.Builder().e(new Pair<>(str, str2)).i(String.valueOf(i3)).j(String.valueOf(i4)).f(str3).g(str4).a();
        ih ihVar = new ih(new a(z, str, i4, i2, fo0Var), new m(fo0Var));
        this.e = ihVar;
        try {
            ihVar.v(false);
            this.e.r(contactRequestArgsA);
        } catch (Exception unused) {
            fo0Var.onResponse(1, "");
        }
    }

    @Override // defpackage.al2
    public void h(Activity activity, JSONObject jSONObject, int i2) {
        PhoneContactItem phoneContactItem;
        ContactRequestsVO contactRequestsVO = (ContactRequestsVO) az2.a(jSONObject.toString(), ContactRequestsVO.class);
        if (contactRequestsVO == null || TextUtils.isEmpty(contactRequestsVO.fromUid)) {
            return;
        }
        ContactInfoItem contactInfoItemConvert2ContactInfoItem = contactRequestsVO.convert2ContactInfoItem();
        Intent intent = new Intent(activity, (Class<?>) NewContactRequestSendActivityV2.class);
        intent.putExtra("user_item_info", contactInfoItemConvert2ContactInfoItem);
        intent.putExtra("uid_key", contactInfoItemConvert2ContactInfoItem.getUid());
        intent.putExtra("new_contact_source_type", contactInfoItemConvert2ContactInfoItem.getSourceType());
        intent.putExtra("send_from_type", 13);
        if (!TextUtils.isEmpty(contactInfoItemConvert2ContactInfoItem.getMobile())) {
            intent.putExtra("new_contact_local_phone_number", contactInfoItemConvert2ContactInfoItem.getMobile());
        } else if (!TextUtils.isEmpty(contactRequestsVO.identifyCode) && (phoneContactItem = com.zenmen.palmchat.contacts.d.j().m().get(contactRequestsVO.identifyCode)) != null) {
            intent.putExtra("new_contact_local_phone_number", phoneContactItem.y());
        }
        intent.putExtra("extra_request_type", contactInfoItemConvert2ContactInfoItem.getRequestType());
        intent.putExtra("subtype_key", i2);
        intent.putExtra("extra_request_from", 21);
        activity.startActivity(intent);
    }

    @Override // defpackage.al2
    public void i() {
        zf2.e().j(true);
    }

    @Override // defpackage.al2
    public void j() {
        SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_contact_enhanced_contact_new_tag"), 0);
        rn0.o();
        if (um1.b().d()) {
            if (this.g == null) {
                this.g = new n56();
            }
            try {
                this.g.o();
            } catch (DaoException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // defpackage.al2
    public void k(String str, fo0 fo0Var) {
        g gVar = new g(fo0Var);
        h hVar = new h(fo0Var);
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, str);
        e92 e92Var = new e92(gVar, hVar);
        this.f17090a = e92Var;
        try {
            e92Var.n(map);
        } catch (DaoException e2) {
            e2.printStackTrace();
            fo0Var.onResponse(1, "");
        } catch (JSONException e3) {
            e3.printStackTrace();
            fo0Var.onResponse(1, "");
        }
    }

    public final void n(ContactInfoItem contactInfoItem, String str) {
        c cVar = new c();
        d dVar = new d();
        HashMap map = new HashMap();
        map.put("fuid", contactInfoItem.getUid());
        map.put("remarkName", str);
        map.put("description", contactInfoItem.getDescription());
        bq3 bq3Var = new bq3(cVar, dVar);
        this.d = bq3Var;
        try {
            bq3Var.n(map);
        } catch (DaoException e2) {
            e2.printStackTrace();
            iq5.j(false, new String[0]);
        } catch (JSONException e3) {
            e3.printStackTrace();
            iq5.j(false, new String[0]);
        }
    }
}
