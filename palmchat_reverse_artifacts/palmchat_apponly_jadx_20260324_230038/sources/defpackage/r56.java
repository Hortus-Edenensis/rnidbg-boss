package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.umeng.analytics.pro.bt;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.PhoneContactItem;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class r56 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20396a = "r56";

    public static ContentValues[] a(ArrayList<PhoneContactItem> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (PhoneContactItem phoneContactItem : arrayList) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("phone_number", yh4.b(phoneContactItem.y()));
                contentValues.put("number_md5", phoneContactItem.z());
                contentValues.put("phone_label", phoneContactItem.v());
                contentValues.put("phone_id", phoneContactItem.A());
                contentValues.put(bt.s, phoneContactItem.m());
                contentValues.put("given_name", phoneContactItem.s());
                contentValues.put("family_name", phoneContactItem.r());
                contentValues.put("prefix", phoneContactItem.B());
                contentValues.put("middle_name", phoneContactItem.w());
                contentValues.put("suffix", phoneContactItem.E());
                contentValues.put("company", phoneContactItem.l());
                contentValues.put("title", phoneContactItem.F());
                contentValues.put("note", phoneContactItem.x());
                contentValues.put(NotificationCompat.CATEGORY_EMAIL, phoneContactItem.n());
                contentValues.put("website", phoneContactItem.G());
                contentValues.put("address", phoneContactItem.j());
                contentValues.put("event", phoneContactItem.p());
                contentValues.put("im_data", phoneContactItem.t());
                contentValues.put("relation", phoneContactItem.C());
                arrayList2.add(contentValues);
            }
            if (arrayList2.size() > 0) {
                return (ContentValues[]) arrayList2.toArray(new ContentValues[arrayList2.size()]);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0215 A[PHI: r3
      0x0215: PHI (r3v3 android.database.Cursor) = (r3v2 android.database.Cursor), (r3v4 android.database.Cursor) binds: [B:41:0x0213, B:35:0x020a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<PhoneContactItem> b() {
        ArrayList<PhoneContactItem> arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(s56.f20670a, null, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        PhoneContactItem phoneContactItem = new PhoneContactItem();
                        phoneContactItem.T(yh4.a(cursorQuery.getString(cursorQuery.getColumnIndex("phone_number"))));
                        phoneContactItem.V(cursorQuery.getString(cursorQuery.getColumnIndex("phone_id")));
                        phoneContactItem.U(cursorQuery.getString(cursorQuery.getColumnIndex("number_md5")));
                        phoneContactItem.Q(cursorQuery.getString(cursorQuery.getColumnIndex("phone_label")));
                        phoneContactItem.K(cursorQuery.getString(cursorQuery.getColumnIndex(bt.s)));
                        phoneContactItem.O(cursorQuery.getString(cursorQuery.getColumnIndex("given_name")));
                        phoneContactItem.N(cursorQuery.getString(cursorQuery.getColumnIndex("family_name")));
                        phoneContactItem.W(cursorQuery.getString(cursorQuery.getColumnIndex("prefix")));
                        phoneContactItem.R(cursorQuery.getString(cursorQuery.getColumnIndex("middle_name")));
                        phoneContactItem.Y(cursorQuery.getString(cursorQuery.getColumnIndex("suffix")));
                        phoneContactItem.S(cursorQuery.getString(cursorQuery.getColumnIndex("note")));
                        phoneContactItem.J(cursorQuery.getString(cursorQuery.getColumnIndex("company")));
                        phoneContactItem.Z(cursorQuery.getString(cursorQuery.getColumnIndex("title")));
                        JSONArray jSONArray = new JSONArray(cursorQuery.getString(cursorQuery.getColumnIndex(NotificationCompat.CATEGORY_EMAIL)));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            PhoneContactItem.PhoneContactEmail phoneContactEmail = new PhoneContactItem.PhoneContactEmail();
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            phoneContactEmail.c(jSONObject.optString(NotificationCompat.CATEGORY_EMAIL));
                            phoneContactEmail.d(jSONObject.optString("label"));
                            phoneContactItem.b(phoneContactEmail);
                        }
                        JSONArray jSONArray2 = new JSONArray(cursorQuery.getString(cursorQuery.getColumnIndex("website")));
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            PhoneContactItem.PhoneContactWebsite phoneContactWebsite = new PhoneContactItem.PhoneContactWebsite();
                            phoneContactWebsite.b(jSONArray2.getJSONObject(i2).optString("address"));
                            phoneContactItem.f(phoneContactWebsite);
                        }
                        JSONArray jSONArray3 = new JSONArray(cursorQuery.getString(cursorQuery.getColumnIndex("address")));
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            PhoneContactItem.PhoneContactAddress phoneContactAddress = new PhoneContactItem.PhoneContactAddress();
                            JSONObject jSONObject2 = jSONArray3.getJSONObject(i3);
                            phoneContactAddress.c(jSONObject2.optString("address"));
                            phoneContactAddress.d(jSONObject2.optString("label"));
                            phoneContactItem.a(phoneContactAddress);
                        }
                        JSONArray jSONArray4 = new JSONArray(cursorQuery.getString(cursorQuery.getColumnIndex("event")));
                        for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                            PhoneContactItem.PhoneContactEvent phoneContactEvent = new PhoneContactItem.PhoneContactEvent();
                            JSONObject jSONObject3 = jSONArray4.getJSONObject(i4);
                            phoneContactEvent.d(jSONObject3.optString(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE));
                            phoneContactEvent.c(jSONObject3.optString("label"));
                            phoneContactItem.c(phoneContactEvent);
                        }
                        JSONArray jSONArray5 = new JSONArray(cursorQuery.getString(cursorQuery.getColumnIndex("im_data")));
                        for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                            PhoneContactItem.PhoneContactIm phoneContactIm = new PhoneContactItem.PhoneContactIm();
                            JSONObject jSONObject4 = jSONArray5.getJSONObject(i5);
                            phoneContactIm.c(jSONObject4.optString("content"));
                            phoneContactIm.d(jSONObject4.optString("type"));
                            phoneContactItem.d(phoneContactIm);
                        }
                        JSONArray jSONArray6 = new JSONArray(cursorQuery.getString(cursorQuery.getColumnIndex("relation")));
                        for (int i6 = 0; i6 < jSONArray6.length(); i6++) {
                            PhoneContactItem.PhoneContactRelation phoneContactRelation = new PhoneContactItem.PhoneContactRelation();
                            JSONObject jSONObject5 = jSONArray6.getJSONObject(i6);
                            phoneContactRelation.c(jSONObject5.optString("title"));
                            phoneContactRelation.d(jSONObject5.optString("label"));
                            phoneContactItem.e(phoneContactRelation);
                        }
                        arrayList.add(phoneContactItem);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static void c(ArrayList<PhoneContactItem> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ContentResolver contentResolver = AppContext.getContext().getContentResolver();
            Uri uri = s56.f20670a;
            contentResolver.delete(uri, null, null);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            String str = f20396a;
            z53.a(str, "DELETE time: " + jCurrentTimeMillis2);
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            AppContext.getContext().getContentResolver().bulkInsert(uri, a(arrayList));
            z53.a(str, "insert time: " + (System.currentTimeMillis() - jCurrentTimeMillis3));
        } catch (Exception unused) {
        }
    }
}
