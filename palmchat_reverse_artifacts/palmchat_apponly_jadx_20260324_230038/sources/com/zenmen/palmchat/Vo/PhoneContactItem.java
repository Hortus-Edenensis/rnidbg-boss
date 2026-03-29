package com.zenmen.palmchat.Vo;

import androidx.core.app.NotificationCompat;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.umeng.analytics.pro.bt;
import com.wifi.ad.core.config.EventParams;
import defpackage.hs0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PhoneContactItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12162a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String l;
    public String m;
    public String n;
    public ArrayList<PhoneContactEmail> k = new ArrayList<>();
    public ArrayList<PhoneContactAddress> o = new ArrayList<>();
    public ArrayList<PhoneContactEvent> p = new ArrayList<>();
    public ArrayList<PhoneContactIm> q = new ArrayList<>();
    public ArrayList<PhoneContactWebsite> r = new ArrayList<>();
    public ArrayList<PhoneContactRelation> s = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public static class PhoneContactAddress {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12163a;
        public String b;

        public String a() {
            return this.f12163a;
        }

        public String b() {
            return this.b;
        }

        public void c(String str) {
            this.f12163a = str;
        }

        public void d(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PhoneContactEmail {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12164a;
        public String b;

        public String a() {
            return this.f12164a;
        }

        public String b() {
            return this.b;
        }

        public void c(String str) {
            this.f12164a = str;
        }

        public void d(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PhoneContactEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12165a;
        public String b;

        public String a() {
            return this.b;
        }

        public String b() {
            return this.f12165a;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
            this.f12165a = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PhoneContactIm {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12166a;
        public String b;

        public String a() {
            return this.f12166a;
        }

        public String b() {
            return this.b;
        }

        public void c(String str) {
            this.f12166a = str;
        }

        public void d(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PhoneContactNumber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12167a;
        public String b;
        public String c;

        public PhoneContactNumber(String str, String str2, String str3) {
            e(str);
            f(str2);
            d(str3);
        }

        public String a() {
            return this.c;
        }

        public String b() {
            return this.f12167a;
        }

        public String c() {
            return this.b;
        }

        public void d(String str) {
            this.c = str;
        }

        public void e(String str) {
            this.f12167a = str;
        }

        public void f(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PhoneContactRelation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12168a;
        public String b;

        public String a() {
            return this.f12168a;
        }

        public String b() {
            return this.b;
        }

        public void c(String str) {
            this.f12168a = str;
        }

        public void d(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PhoneContactWebsite {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12169a;

        public String a() {
            return this.f12169a;
        }

        public void b(String str) {
            this.f12169a = str;
        }
    }

    public static PhoneContactVo g(PhoneContactItem phoneContactItem) {
        PhoneContactVo phoneContactVo = new PhoneContactVo();
        phoneContactVo.setUid("");
        phoneContactVo.setMd5Phone(phoneContactItem.z());
        phoneContactVo.setIsFriend(0);
        phoneContactVo.setNickName("");
        phoneContactVo.setIconURL("");
        phoneContactVo.setBigIconURL("");
        phoneContactVo.setSignature("");
        phoneContactVo.setGender(0);
        phoneContactVo.setCountry("");
        phoneContactVo.setProvince("");
        phoneContactVo.setCity("");
        phoneContactVo.setEmail("");
        phoneContactVo.setSourceType(3);
        phoneContactVo.setFirstPinyin("");
        phoneContactVo.setAllPinyin("");
        phoneContactVo.setLocalNameAllPinyin("");
        phoneContactVo.setLocalNameFirstPinyin("");
        phoneContactVo.setLocalName(phoneContactItem.m());
        phoneContactVo.setLocalPhone(phoneContactItem.y());
        phoneContactVo.setLocalId(phoneContactItem.A());
        return phoneContactVo;
    }

    public static PhoneContactItem h(PhoneContactItem phoneContactItem) {
        PhoneContactItem phoneContactItem2 = new PhoneContactItem();
        if (phoneContactItem != null) {
            phoneContactItem2.K(phoneContactItem.m());
            phoneContactItem2.O(phoneContactItem.s());
            phoneContactItem2.N(phoneContactItem.r());
            phoneContactItem2.W(phoneContactItem.B());
            phoneContactItem2.R(phoneContactItem.w());
            phoneContactItem2.Y(phoneContactItem.E());
            phoneContactItem2.S(phoneContactItem.x());
            phoneContactItem2.J(phoneContactItem.l());
            phoneContactItem2.Z(phoneContactItem.F());
            phoneContactItem2.L(phoneContactItem.o());
            phoneContactItem2.a0(phoneContactItem.H());
            phoneContactItem2.I(phoneContactItem.k());
            phoneContactItem2.P(phoneContactItem.u());
            phoneContactItem2.M(phoneContactItem.q());
            phoneContactItem2.X(phoneContactItem.D());
        }
        return phoneContactItem2;
    }

    public static JSONArray i(ArrayList<PhoneContactItem> arrayList) {
        if (arrayList == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (PhoneContactItem phoneContactItem : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strY = phoneContactItem.y();
                jSONObject2.put("numberOrig", strY);
                jSONObject2.put("type", phoneContactItem.v());
                jSONObject2.put("numberMd5", phoneContactItem.z());
                jSONObject2.put("phoneId", phoneContactItem.A());
                String strC = hs0.g().c(strY);
                jSONObject2.put("ic", strC);
                jSONObject2.put(EventParams.KEY_PARAM_NUMBER, hs0.g().e(strY, strC));
                jSONObject.put("phone", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(bt.s, phoneContactItem.m());
                jSONObject3.put("given_name", phoneContactItem.s());
                jSONObject3.put("family_name", phoneContactItem.r());
                jSONObject3.put("prefix", phoneContactItem.B());
                jSONObject3.put("middle_name", phoneContactItem.w());
                jSONObject3.put("suffix", phoneContactItem.E());
                jSONObject.put("name", jSONObject3);
                jSONObject.put("note", phoneContactItem.x());
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("company", phoneContactItem.l());
                jSONObject4.put("title", phoneContactItem.F());
                jSONObject.put("organization", jSONObject4);
                JSONArray jSONArray2 = new JSONArray();
                for (PhoneContactEmail phoneContactEmail : phoneContactItem.o()) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(NotificationCompat.CATEGORY_EMAIL, phoneContactEmail.a());
                    jSONObject5.put("label", phoneContactEmail.b());
                    jSONArray2.put(jSONObject5);
                }
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                for (PhoneContactWebsite phoneContactWebsite : phoneContactItem.H()) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("address", phoneContactWebsite.a());
                    jSONArray3.put(jSONObject6);
                }
                jSONObject.put("website", jSONArray3);
                JSONArray jSONArray4 = new JSONArray();
                for (PhoneContactAddress phoneContactAddress : phoneContactItem.k()) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("address", phoneContactAddress.a());
                    jSONObject7.put("label", phoneContactAddress.b());
                    jSONArray4.put(jSONObject7);
                }
                jSONObject.put("address", jSONArray4);
                JSONArray jSONArray5 = new JSONArray();
                for (PhoneContactEvent phoneContactEvent : phoneContactItem.q()) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, phoneContactEvent.b());
                    jSONObject8.put("label", phoneContactEvent.a());
                    jSONArray5.put(jSONObject8);
                }
                jSONObject.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, jSONArray5);
                JSONArray jSONArray6 = new JSONArray();
                for (PhoneContactIm phoneContactIm : phoneContactItem.u()) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("type", phoneContactIm.b());
                    jSONObject9.put("label", phoneContactIm.a());
                    jSONArray6.put(jSONObject9);
                }
                jSONObject.put("IM", jSONArray6);
                JSONArray jSONArray7 = new JSONArray();
                for (PhoneContactRelation phoneContactRelation : phoneContactItem.D()) {
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put("title", phoneContactRelation.a());
                    jSONObject10.put("label", phoneContactRelation.b());
                    jSONArray7.put(jSONObject10);
                }
                jSONObject.put("relation", jSONArray7);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray;
    }

    public String A() {
        return this.d;
    }

    public String B() {
        return this.h;
    }

    public String C() {
        JSONArray jSONArray = new JSONArray();
        ArrayList<PhoneContactRelation> arrayList = this.s;
        if (arrayList != null) {
            try {
                for (PhoneContactRelation phoneContactRelation : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("title", phoneContactRelation.a());
                    jSONObject.put("label", phoneContactRelation.b());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public ArrayList<PhoneContactRelation> D() {
        return this.s;
    }

    public String E() {
        return this.j;
    }

    public String F() {
        return this.m;
    }

    public String G() {
        JSONArray jSONArray = new JSONArray();
        ArrayList<PhoneContactWebsite> arrayList = this.r;
        if (arrayList != null) {
            try {
                for (PhoneContactWebsite phoneContactWebsite : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("address", phoneContactWebsite.a());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public ArrayList<PhoneContactWebsite> H() {
        return this.r;
    }

    public void I(ArrayList<PhoneContactAddress> arrayList) {
        this.o = arrayList;
    }

    public void J(String str) {
        this.l = str;
    }

    public void K(String str) {
        this.e = str;
    }

    public void L(ArrayList<PhoneContactEmail> arrayList) {
        this.k = arrayList;
    }

    public void M(ArrayList<PhoneContactEvent> arrayList) {
        this.p = arrayList;
    }

    public void N(String str) {
        this.g = str;
    }

    public void O(String str) {
        this.f = str;
    }

    public void P(ArrayList<PhoneContactIm> arrayList) {
        this.q = arrayList;
    }

    public void Q(String str) {
        this.c = str;
    }

    public void R(String str) {
        this.i = str;
    }

    public void S(String str) {
        this.n = str;
    }

    public void T(String str) {
        this.f12162a = str;
    }

    public void U(String str) {
        this.b = str;
    }

    public void V(String str) {
        this.d = str;
    }

    public void W(String str) {
        this.h = str;
    }

    public void X(ArrayList<PhoneContactRelation> arrayList) {
        this.s = arrayList;
    }

    public void Y(String str) {
        this.j = str;
    }

    public void Z(String str) {
        this.m = str;
    }

    public void a(PhoneContactAddress phoneContactAddress) {
        ArrayList<PhoneContactAddress> arrayList = this.o;
        if (arrayList != null) {
            arrayList.add(phoneContactAddress);
            return;
        }
        ArrayList<PhoneContactAddress> arrayList2 = new ArrayList<>();
        arrayList2.add(phoneContactAddress);
        I(arrayList2);
    }

    public void a0(ArrayList<PhoneContactWebsite> arrayList) {
        this.r = arrayList;
    }

    public void b(PhoneContactEmail phoneContactEmail) {
        ArrayList<PhoneContactEmail> arrayList = this.k;
        if (arrayList != null) {
            arrayList.add(phoneContactEmail);
            return;
        }
        ArrayList<PhoneContactEmail> arrayList2 = new ArrayList<>();
        arrayList2.add(phoneContactEmail);
        L(arrayList2);
    }

    public void c(PhoneContactEvent phoneContactEvent) {
        ArrayList<PhoneContactEvent> arrayList = this.p;
        if (arrayList != null) {
            arrayList.add(phoneContactEvent);
            return;
        }
        ArrayList<PhoneContactEvent> arrayList2 = new ArrayList<>();
        arrayList2.add(phoneContactEvent);
        M(arrayList2);
    }

    public void d(PhoneContactIm phoneContactIm) {
        ArrayList<PhoneContactIm> arrayList = this.q;
        if (arrayList != null) {
            arrayList.add(phoneContactIm);
            return;
        }
        ArrayList<PhoneContactIm> arrayList2 = new ArrayList<>();
        arrayList2.add(phoneContactIm);
        P(arrayList2);
    }

    public void e(PhoneContactRelation phoneContactRelation) {
        ArrayList<PhoneContactRelation> arrayList = this.s;
        if (arrayList != null) {
            arrayList.add(phoneContactRelation);
            return;
        }
        ArrayList<PhoneContactRelation> arrayList2 = new ArrayList<>();
        arrayList2.add(phoneContactRelation);
        X(arrayList2);
    }

    public void f(PhoneContactWebsite phoneContactWebsite) {
        ArrayList<PhoneContactWebsite> arrayList = this.r;
        if (arrayList != null) {
            arrayList.add(phoneContactWebsite);
            return;
        }
        ArrayList<PhoneContactWebsite> arrayList2 = new ArrayList<>();
        arrayList2.add(phoneContactWebsite);
        a0(arrayList2);
    }

    public String j() {
        JSONArray jSONArray = new JSONArray();
        ArrayList<PhoneContactAddress> arrayList = this.o;
        if (arrayList != null) {
            try {
                for (PhoneContactAddress phoneContactAddress : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("address", phoneContactAddress.a());
                    jSONObject.put("label", phoneContactAddress.b());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public ArrayList<PhoneContactAddress> k() {
        return this.o;
    }

    public String l() {
        return this.l;
    }

    public String m() {
        return this.e;
    }

    public String n() {
        JSONArray jSONArray = new JSONArray();
        ArrayList<PhoneContactEmail> arrayList = this.k;
        if (arrayList != null) {
            try {
                for (PhoneContactEmail phoneContactEmail : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(NotificationCompat.CATEGORY_EMAIL, phoneContactEmail.a());
                    jSONObject.put("label", phoneContactEmail.b());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public ArrayList<PhoneContactEmail> o() {
        return this.k;
    }

    public String p() {
        JSONArray jSONArray = new JSONArray();
        ArrayList<PhoneContactEvent> arrayList = this.p;
        if (arrayList != null) {
            try {
                for (PhoneContactEvent phoneContactEvent : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, phoneContactEvent.b());
                    jSONObject.put("label", phoneContactEvent.a());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public ArrayList<PhoneContactEvent> q() {
        return this.p;
    }

    public String r() {
        return this.g;
    }

    public String s() {
        return this.f;
    }

    public String t() {
        JSONArray jSONArray = new JSONArray();
        ArrayList<PhoneContactIm> arrayList = this.q;
        if (arrayList != null) {
            try {
                for (PhoneContactIm phoneContactIm : arrayList) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("content", phoneContactIm.a());
                    jSONObject.put("type", phoneContactIm.b());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public ArrayList<PhoneContactIm> u() {
        return this.q;
    }

    public String v() {
        return this.c;
    }

    public String w() {
        return this.i;
    }

    public String x() {
        return this.n;
    }

    public String y() {
        return this.f12162a;
    }

    public String z() {
        return this.b;
    }
}
