package com.zenmen.palmchat.contacts;

import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.android.volley.VolleyError;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import com.zenmen.palmchat.Vo.PhoneContactVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.ao0;
import defpackage.hs0;
import defpackage.ir5;
import defpackage.k86;
import defpackage.lg2;
import defpackage.p56;
import defpackage.r56;
import defpackage.rb3;
import defpackage.tg4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class d {
    public static final String k = "d";
    public static volatile d l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f13568a;
    public Handler b;
    public ContentObserver c;
    public p56 g;
    public SharedPreferences h;
    public boolean d = false;
    public boolean e = false;
    public long f = 0;
    public ArrayList<PhoneContactItem> i = null;
    public RunnableC1024d j = new RunnableC1024d();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ContentObserver {

        /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1023a extends HashMap<String, Object> {
            public C1023a() {
                put("action", "upload_local_contact");
                put("status", "ContentObserverOnChange");
            }
        }

        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            if (!d.this.d || Math.abs(d.this.f - ir5.b()) <= 3000) {
                return;
            }
            LogUtil.i(d.k, 3, new C1023a(), (Throwable) null);
            d.this.u(null);
            d.this.f = ir5.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13571a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ c e;

        public b(int i, HashMap map, int i2, ArrayList arrayList, c cVar) {
            this.f13571a = i;
            this.b = map;
            this.c = i2;
            this.d = arrayList;
            this.e = cVar;
            put("action", "upload_local_contact");
            put("status", "start");
            put("diffFlag", String.valueOf(i));
            put("cacheSize", Integer.valueOf(map.size()));
            put("uploadSize", Integer.valueOf(i2));
            put("newUploadedSize", Integer.valueOf(arrayList.size()));
            put("isUserTrigger", Boolean.valueOf(cVar != null));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void onFinished(HashMap<String, PhoneContactVo> map);
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC1024d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f13572a;
        public String b;

        public RunnableC1024d() {
        }

        public void a(c cVar) {
            this.f13572a = cVar;
        }

        public void b(String str) {
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.h(this.f13572a, this.b);
        }
    }

    public d() {
        p();
        i();
    }

    public static d j() {
        if (l == null) {
            synchronized (d.class) {
                if (l == null) {
                    l = new d();
                }
            }
        }
        return l;
    }

    public void f() {
        synchronized (d.class) {
            ArrayList<PhoneContactItem> arrayList = this.i;
            if (arrayList != null) {
                arrayList.clear();
                this.i = null;
            }
        }
        this.d = false;
    }

    public final ContentObserver g() {
        return new a(this.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0122 A[Catch: OutOfMemoryError -> 0x01b4, JSONException -> 0x01bc, DaoException -> 0x01c1, all -> 0x0201, TRY_LEAVE, TryCatch #3 {JSONException -> 0x01bc, blocks: (B:23:0x0113, B:24:0x011a, B:26:0x0122, B:36:0x0185, B:34:0x0180, B:37:0x018d, B:39:0x01ac), top: B:60:0x0113, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018d A[Catch: OutOfMemoryError -> 0x01b4, JSONException -> 0x01bc, DaoException -> 0x01c1, all -> 0x0201, TryCatch #3 {JSONException -> 0x01bc, blocks: (B:23:0x0113, B:24:0x011a, B:26:0x0122, B:36:0x0185, B:34:0x0180, B:37:0x018d, B:39:0x01ac), top: B:60:0x0113, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean h(c cVar, String str) {
        boolean z;
        JSONObject jSONObjectN;
        String str2 = k;
        LogUtil.d(str2, "doUploadPhoneContact" + cVar + " uploadFrom=" + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<PhoneContactItem> arrayList = new ArrayList<>();
        HashMap<String, PhoneContactItem> mapO = o();
        int i = mapO.size() == 0 ? 0 : 1;
        if (i == 0) {
            LogUtil.uploadInfoImmediate("2321", "1", null, null);
        }
        ArrayList<PhoneContactItem> arrayListQ = q(mapO, arrayList);
        LogUtil.i("calculate", "readTime: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (i == 0) {
            LogUtil.uploadInfoImmediate("2322", "1", null, null);
        }
        LogUtil.i(str2, 3, new b(i, mapO, arrayListQ.size(), arrayList, cVar), (Throwable) null);
        if (arrayListQ.size() > 0) {
            HashMap map = new HashMap();
            map.put("md5Phone", rb3.c(AccountUtils.i(AppContext.getContext()) + AccountUtils.k(AppContext.getContext())));
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            map.put("contacts", PhoneContactItem.i(arrayListQ));
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            LogUtil.i("calculate", "Md5Time: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
            map.put("diffFlag", String.valueOf(i));
            map.put(WkParams.IMEI, ac1.i);
            map.put("sdid", ac1.v());
            if (ao0.f()) {
                map.put("sourceType", str);
            }
            if (this.g == null) {
                this.g = new p56();
            }
            if (i == 0) {
                try {
                    try {
                        LogUtil.uploadInfoImmediate("2323", "1", null, null);
                        jSONObjectN = this.g.n(map, null);
                        if (jSONObjectN == null) {
                            LogUtil.i(str2, "uploadPhoneContact response=" + jSONObjectN.toString());
                            LogUtil.i("calculate", "uploadTime: " + (System.currentTimeMillis() - jCurrentTimeMillis3));
                            try {
                                if (jSONObjectN.getInt("resultCode") == 0) {
                                    if (i == 0) {
                                        LogUtil.uploadInfoImmediate("2324", "1", null, null);
                                    }
                                    this.h.edit().putLong(k86.q(), System.currentTimeMillis()).apply();
                                    t(arrayList);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            if (cVar != null) {
                                cVar.onFinished(n());
                            }
                        } else {
                            LogUtil.i(str2, "error=" + new VolleyError().toString());
                            if (cVar != null) {
                                cVar.onFinished(n());
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } catch (DaoException e3) {
                    e3.printStackTrace();
                } catch (OutOfMemoryError e4) {
                    System.gc();
                    e4.printStackTrace();
                }
                z = true;
            } else {
                jSONObjectN = this.g.n(map, null);
                if (jSONObjectN == null) {
                }
                z = true;
            }
        }
        this.h.edit().putLong(k86.q(), System.currentTimeMillis()).apply();
        t(arrayList);
        if (cVar != null) {
            cVar.onFinished(n());
        }
        z = false;
        LogUtil.d(k, "doUploadPhoneContact result" + z);
        return z;
    }

    public void i() {
        this.d = AppContext.getContext().getTrayPreferences().a(k86.n(), false);
    }

    public int k() {
        synchronized (d.class) {
            s();
            ArrayList<PhoneContactItem> arrayList = this.i;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
    }

    public PhoneContactItem l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (d.class) {
            for (PhoneContactItem phoneContactItem : s()) {
                if (str.equals(phoneContactItem.z())) {
                    return phoneContactItem;
                }
            }
            return null;
        }
    }

    public HashMap<String, PhoneContactItem> m() {
        HashMap<String, PhoneContactItem> map = new HashMap<>();
        synchronized (d.class) {
            for (PhoneContactItem phoneContactItem : s()) {
                if (!TextUtils.isEmpty(phoneContactItem.z())) {
                    map.put(phoneContactItem.z(), phoneContactItem);
                }
            }
        }
        return map;
    }

    public HashMap<String, PhoneContactVo> n() {
        HashMap<String, PhoneContactVo> map = new HashMap<>();
        synchronized (d.class) {
            for (PhoneContactItem phoneContactItem : s()) {
                if (!TextUtils.isEmpty(phoneContactItem.z())) {
                    map.put(phoneContactItem.z(), PhoneContactItem.g(phoneContactItem));
                }
            }
        }
        return map;
    }

    public HashMap<String, PhoneContactItem> o() {
        HashMap<String, PhoneContactItem> map = new HashMap<>();
        synchronized (d.class) {
            for (PhoneContactItem phoneContactItem : s()) {
                map.put(phoneContactItem.A(), phoneContactItem);
            }
        }
        return map;
    }

    public final void p() {
        HandlerThread handlerThreadA = lg2.a("phone_contacts_cache_working_thread");
        this.f13568a = handlerThreadA;
        handlerThreadA.start();
        this.b = new Handler(this.f13568a.getLooper());
        this.h = PreferenceManager.getDefaultSharedPreferences(AppContext.getContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<PhoneContactItem> q(HashMap<String, PhoneContactItem> map, ArrayList<PhoneContactItem> arrayList) {
        Iterator it;
        int i;
        ArrayList<PhoneContactItem> arrayList2 = new ArrayList<>();
        ArrayList<PhoneContactItem.PhoneContactNumber> arrayList3 = new ArrayList();
        try {
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, "raw_contact_id");
            PhoneContactItem phoneContactItem = null;
            int i2 = -1;
            while (cursorQuery.moveToNext()) {
                StringBuilder sb = new StringBuilder("contactsId=");
                int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("raw_contact_id"));
                sb.append(i3);
                if (i2 != i3) {
                    if (phoneContactItem == null) {
                        phoneContactItem = new PhoneContactItem();
                        i2 = i3;
                    } else {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            PhoneContactItem.PhoneContactNumber phoneContactNumber = (PhoneContactItem.PhoneContactNumber) it2.next();
                            if (phoneContactNumber != null) {
                                String strB = phoneContactNumber.b();
                                String strC = phoneContactNumber.c();
                                String strA = phoneContactNumber.a();
                                if (TextUtils.isEmpty(strB)) {
                                    it = it2;
                                    i = i3;
                                } else {
                                    PhoneContactItem phoneContactItem2 = map.get(strC);
                                    it = it2;
                                    PhoneContactItem phoneContactItemH = PhoneContactItem.h(phoneContactItem);
                                    i = i3;
                                    phoneContactItemH.U(hs0.g().d(strB));
                                    phoneContactItemH.T(strB);
                                    phoneContactItemH.V(strC);
                                    phoneContactItemH.Q(strA);
                                    if (phoneContactItem2 == null) {
                                        if (!TextUtils.isEmpty(phoneContactItemH.z())) {
                                            arrayList2.add(phoneContactItemH);
                                            String str = k;
                                            LogUtil.i(str, "ca null result add: " + phoneContactItemH.A());
                                            LogUtil.i(str, "number: " + phoneContactItemH.y());
                                        }
                                    } else if (!phoneContactItem2.y().equals(strB) && !TextUtils.isEmpty(phoneContactItemH.z())) {
                                        arrayList2.add(phoneContactItemH);
                                        LogUtil.i(k, "ca !=null result add");
                                    }
                                    arrayList.add(phoneContactItemH);
                                }
                            }
                            it2 = it;
                            i3 = i;
                        }
                        phoneContactItem = new PhoneContactItem();
                        arrayList3.clear();
                        i2 = i3;
                    }
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("mimetype"));
                sb.append("mimetype: " + string);
                if (string.equals("vnd.android.cursor.item/name")) {
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data3"));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data4"));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("data5"));
                    String string7 = cursorQuery.getString(cursorQuery.getColumnIndex("data6"));
                    phoneContactItem.K(string2);
                    phoneContactItem.O(string3);
                    phoneContactItem.N(string4);
                    phoneContactItem.W(string5);
                    phoneContactItem.R(string6);
                    phoneContactItem.Y(string7);
                } else if (string.equals("vnd.android.cursor.item/phone_v2")) {
                    String string8 = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
                    String string9 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string10 = cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
                    String string11 = AppContext.getContext().getString(ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(Integer.parseInt(string10)));
                    sb.append(", number=" + string9);
                    sb.append(", type=" + string10);
                    sb.append(", label=" + string11);
                    sb.append(", id=" + string8);
                    arrayList3.add(new PhoneContactItem.PhoneContactNumber(string9, string8, string11));
                } else if (string.equals("vnd.android.cursor.item/email_v2")) {
                    String string12 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string13 = cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
                    if (string13 != null) {
                        String string14 = AppContext.getContext().getString(ContactsContract.CommonDataKinds.Email.getTypeLabelResource(Integer.parseInt(string13)));
                        PhoneContactItem.PhoneContactEmail phoneContactEmail = new PhoneContactItem.PhoneContactEmail();
                        phoneContactEmail.c(string12);
                        phoneContactEmail.d(string14);
                        phoneContactItem.b(phoneContactEmail);
                    }
                } else if (string.equals("vnd.android.cursor.item/organization")) {
                    String string15 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string16 = cursorQuery.getString(cursorQuery.getColumnIndex("data4"));
                    phoneContactItem.J(string15);
                    phoneContactItem.Z(string16);
                } else if (string.equals("vnd.android.cursor.item/postal-address_v2")) {
                    String string17 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string18 = AppContext.getContext().getString(ContactsContract.CommonDataKinds.StructuredPostal.getTypeLabelResource(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("data2")))));
                    PhoneContactItem.PhoneContactAddress phoneContactAddress = new PhoneContactItem.PhoneContactAddress();
                    phoneContactAddress.c(string17);
                    phoneContactAddress.d(string18);
                    phoneContactItem.a(phoneContactAddress);
                } else if (string.equals("vnd.android.cursor.item/contact_event")) {
                    String string19 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string20 = AppContext.getContext().getString(ContactsContract.CommonDataKinds.Event.getTypeResource(Integer.valueOf(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("data2"))))));
                    PhoneContactItem.PhoneContactEvent phoneContactEvent = new PhoneContactItem.PhoneContactEvent();
                    phoneContactEvent.d(string19);
                    phoneContactEvent.c(string20);
                    phoneContactItem.c(phoneContactEvent);
                } else if (string.equals("vnd.android.cursor.item/note")) {
                    phoneContactItem.S(cursorQuery.getString(cursorQuery.getColumnIndex("data1")));
                } else if (string.equals("vnd.android.cursor.item/website")) {
                    String string21 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    PhoneContactItem.PhoneContactWebsite phoneContactWebsite = new PhoneContactItem.PhoneContactWebsite();
                    phoneContactWebsite.b(string21);
                    phoneContactItem.f(phoneContactWebsite);
                } else if (string.equals("vnd.android.cursor.item/relation")) {
                    String string22 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string23 = AppContext.getContext().getString(ContactsContract.CommonDataKinds.Relation.getTypeLabelResource(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("data2")))));
                    PhoneContactItem.PhoneContactRelation phoneContactRelation = new PhoneContactItem.PhoneContactRelation();
                    phoneContactRelation.c(string22);
                    phoneContactRelation.d(string23);
                    phoneContactItem.e(phoneContactRelation);
                } else if (string.equals("vnd.android.cursor.item/im")) {
                    String string24 = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string25 = AppContext.getContext().getString(ContactsContract.CommonDataKinds.Im.getProtocolLabelResource(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("data5")))));
                    PhoneContactItem.PhoneContactIm phoneContactIm = new PhoneContactItem.PhoneContactIm();
                    phoneContactIm.c(string24);
                    phoneContactIm.d(string25);
                    phoneContactItem.d(phoneContactIm);
                }
                Log.i(k, sb.toString());
            }
            cursorQuery.close();
            for (PhoneContactItem.PhoneContactNumber phoneContactNumber2 : arrayList3) {
                if (phoneContactNumber2 != null) {
                    String strB2 = phoneContactNumber2.b();
                    String strC2 = phoneContactNumber2.c();
                    String strA2 = phoneContactNumber2.a();
                    if (!TextUtils.isEmpty(strB2)) {
                        PhoneContactItem phoneContactItem3 = map.get(strC2);
                        PhoneContactItem phoneContactItemH2 = PhoneContactItem.h(phoneContactItem);
                        phoneContactItemH2.U(hs0.g().d(strB2));
                        phoneContactItemH2.T(strB2);
                        phoneContactItemH2.V(strC2);
                        phoneContactItemH2.Q(strA2);
                        if (phoneContactItem3 == null) {
                            if (!TextUtils.isEmpty(phoneContactItemH2.z())) {
                                arrayList2.add(phoneContactItemH2);
                                String str2 = k;
                                LogUtil.i(str2, "ca null result add: " + phoneContactItemH2.A());
                                LogUtil.i(str2, "number: " + phoneContactItemH2.y());
                            }
                        } else if (!phoneContactItem3.y().equals(strB2) && !TextUtils.isEmpty(phoneContactItemH2.z())) {
                            arrayList2.add(phoneContactItemH2);
                            LogUtil.i(k, "ca !=null result add");
                        }
                        arrayList.add(phoneContactItemH2);
                    }
                }
            }
        } catch (Exception unused) {
            LogUtil.i(k, "exception");
        }
        return arrayList2;
    }

    public void r() {
        ContentObserver contentObserverG = g();
        this.c = contentObserverG;
        if (contentObserverG != null) {
            try {
                if (this.e || !tg4.b(AppContext.getContext(), BaseActivityPermissionDispatcher.PermissionType.CONTACT.permissionList)) {
                    return;
                }
                AppContext.getContext().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.c);
                this.e = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final ArrayList<PhoneContactItem> s() {
        if (this.i == null) {
            this.i = r56.b();
        }
        return this.i;
    }

    public final void t(ArrayList<PhoneContactItem> arrayList) {
        synchronized (d.class) {
            ArrayList<PhoneContactItem> arrayList2 = this.i;
            if (arrayList2 != null) {
                arrayList2.clear();
                this.i.addAll(arrayList);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        r56.c(arrayList);
        LogUtil.i("calculate", "cost time : " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void u(c cVar) {
        v(cVar, BaseWrapper.ENTER_ID_SYSTEM_HELPER);
    }

    public void v(c cVar, String str) {
        this.b.removeCallbacks(this.j);
        this.j.a(cVar);
        this.j.b(str);
        this.b.post(this.j);
        if (this.e) {
            return;
        }
        r();
    }
}
