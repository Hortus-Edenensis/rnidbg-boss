package defpackage;

import android.content.ContentValues;
import android.net.Uri;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyState;
import com.zenmen.palmchat.chat.intimacy.vo.IntimacyStateItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactLocalExt;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.zh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ln0 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends jk2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zh.a f19034a;

        public a(zh.a aVar) {
            this.f19034a = aVar;
        }

        @Override // defpackage.jk2
        public void b(int i, Uri uri) {
            super.b(i, uri);
            this.f19034a.a(null);
        }
    }

    public static ContentValues[] a(List<IntimacyStateItem> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<IntimacyStateItem> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IntimacyStateItem next = it.next();
            if (next.fuid != null) {
                ContactInfoItem contactInfoItemO = bo0.r().o(next.fuid);
                String strD = d(contactInfoItemO != null ? contactInfoItemO.getContactLocalExt() : null, next.value);
                if (strD != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("contact_operation", (Integer) 1);
                    contentValues.put(DeviceInfoUtil.UID_TAG, next.fuid);
                    contentValues.put("rank", strD);
                    contentValues.put("local_update", Boolean.TRUE);
                    arrayList.add(contentValues);
                }
            }
        }
        if (arrayList.size() > 0) {
            return (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]);
        }
        return null;
    }

    public static void b(ContentValues contentValues, zh.a aVar) {
        zh.k(AppContext.getContext().getContentResolver()).h(100, new a(aVar), ho0.f18003a, contentValues);
    }

    public static void c(IntimacyState intimacyState) {
        List<IntimacyStateItem> list;
        ContentValues[] contentValuesArrA;
        if (intimacyState == null || (list = intimacyState.intimates) == null || list.size() <= 0 || (contentValuesArrA = a(intimacyState.intimates)) == null) {
            return;
        }
        LogUtil.i("IntimacyStatusManager", "updateIntimacyDbStatus" + contentValuesArrA);
        AppContext.getContext().getContentResolver().bulkInsert(ho0.f18003a, contentValuesArrA);
    }

    public static String d(ContactLocalExt contactLocalExt, float f) {
        float f2;
        if (contactLocalExt == null) {
            contactLocalExt = new ContactLocalExt();
            f2 = 0.0f;
        } else {
            f2 = contactLocalExt.intimacyScore;
        }
        if (f2 == f) {
            return null;
        }
        contactLocalExt.intimacyScore = f;
        return az2.c(contactLocalExt);
    }

    public static void e(String str, float f, boolean z) {
        LogUtil.i("IntimacyStatusManager", "updateIntimacyDbStatus single  start" + str + " localExt=" + f);
        ContactInfoItem contactInfoItemO = bo0.r().o(str);
        String strD = d(contactInfoItemO != null ? contactInfoItemO.getContactLocalExt() : null, f);
        if (strD != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("rank", strD);
            String[] strArr = {String.valueOf(str)};
            LogUtil.i("IntimacyStatusManager", "updateIntimacyDbStatus single inner " + str + " localExt=" + strD);
            if (z) {
                AppContext.getContext().getContentResolver().update(ho0.f18003a, contentValues, "uid=?", strArr);
            } else {
                zh.k(AppContext.getContext().getContentResolver()).j(0, null, ho0.f18003a, contentValues, "uid=?", strArr);
            }
        }
    }
}
