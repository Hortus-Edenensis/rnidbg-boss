package defpackage;

import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.amap.api.services.district.DistrictSearchQuery;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import com.zenmen.palmchat.contacts.bean.ContactLocalExt;
import com.zenmen.palmchat.modulemanager.InitExceptionHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class bo0 {
    public static final String k = "bo0";
    public static volatile bo0 l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f1786a;
    public Handler b;
    public ContentObserver d;
    public final nv c = new nv(ow5.f19890a);
    public CopyOnWriteArrayList<ContactInfoItem> e = new CopyOnWriteArrayList<>();
    public ArrayList<ContactInfoItem> f = new ArrayList<>();
    public ArrayList<ContactInfoItem> g = new ArrayList<>();
    public int h = 0;
    public ConcurrentHashMap<String, ContactInfoItem> i = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, String> j = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                removeMessages(0);
                LogUtil.i(bo0.k, "updateCache imp");
                bo0.this.B();
                try {
                    bo0.this.c.i(bo0.this.y());
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(new Intent(tq3.i));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bo0.this.B();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            LogUtil.i(bo0.k, "updateCache onchange");
            bo0.this.b.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements zk2 {
        @Override // defpackage.zk2
        public ContactInfoItem a(String str) {
            return bo0.r().l(str);
        }

        @Override // defpackage.zk2
        public void b(ContactInfoItem contactInfoItem) {
            AppContext.getContext().getContentResolver().update(ho0.f18003a, nn0.b(contactInfoItem), "uid=" + contactInfoItem.getUid(), null);
        }

        @Override // defpackage.zk2
        public ContactInfoItem c(String str) {
            if (str == null) {
                return null;
            }
            String strU = bo0.r().u(str);
            if (strU == null && str.equals(v4.b(com.zenmen.palmchat.c.b()))) {
                strU = v4.e(com.zenmen.palmchat.c.b());
            }
            if (strU != null) {
                return bo0.r().l(strU);
            }
            return null;
        }

        @Override // defpackage.zk2
        public boolean d(String str) {
            ContactInfoItem contactInfoItemA = a(str);
            return bo0.r().w(str) && !(contactInfoItemA != null && jw5.e(contactInfoItemA.getSessionConfig()));
        }
    }

    public bo0() {
        HandlerThread handlerThreadA = lg2.a("contacts_cache_working_thread");
        this.f1786a = handlerThreadA;
        handlerThreadA.start();
        this.b = new a(this.f1786a.getLooper());
        v();
    }

    public static bo0 r() {
        if (l == null) {
            synchronized (bo0.class) {
                if (l == null) {
                    l = new bo0();
                }
            }
        }
        return l;
    }

    public final String[] A(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("\\$");
    }

    public final synchronized void B() {
        ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
        ArrayList<ContactInfoItem> arrayList2 = new ArrayList<>();
        ArrayList<ContactInfoItem> arrayList3 = new ArrayList<>();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = AppContext.getContext().getContentResolver().query(ho0.f18003a, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    int i = 0;
                    do {
                        ContactInfoItem contactInfoItem = new ContactInfoItem();
                        contactInfoItem.setUid(cursorQuery.getString(cursorQuery.getColumnIndex(DeviceInfoUtil.UID_TAG)));
                        contactInfoItem.setExid(cursorQuery.getString(cursorQuery.getColumnIndex("data4")));
                        contactInfoItem.setNickName(cursorQuery.getString(cursorQuery.getColumnIndex("nick_name")));
                        contactInfoItem.setRemarkName(cursorQuery.getString(cursorQuery.getColumnIndex("remark_name")));
                        contactInfoItem.setDescription(cursorQuery.getString(cursorQuery.getColumnIndex("description")));
                        contactInfoItem.setSignature(cursorQuery.getString(cursorQuery.getColumnIndex(com.umeng.ccg.a.A)));
                        contactInfoItem.setBirthday(cursorQuery.getString(cursorQuery.getColumnIndex("birthday")));
                        contactInfoItem.setHobby(cursorQuery.getString(cursorQuery.getColumnIndex("hobby")));
                        contactInfoItem.setAge(cursorQuery.getString(cursorQuery.getColumnIndex("age")));
                        contactInfoItem.setIconURL(cursorQuery.getString(cursorQuery.getColumnIndex("head_img_url")));
                        contactInfoItem.setBigIconURL(cursorQuery.getString(cursorQuery.getColumnIndex("big_head_img_url")));
                        contactInfoItem.setMobile(cursorQuery.getString(cursorQuery.getColumnIndex("mobile")));
                        contactInfoItem.setEmail(cursorQuery.getString(cursorQuery.getColumnIndex(NotificationCompat.CATEGORY_EMAIL)));
                        contactInfoItem.setUpdateTime(cursorQuery.getInt(cursorQuery.getColumnIndex("update_time")));
                        contactInfoItem.setFirstPinyin(cursorQuery.getString(cursorQuery.getColumnIndex("first_pinyin")));
                        contactInfoItem.setAllPinyin(cursorQuery.getString(cursorQuery.getColumnIndex("all_pinyin")));
                        contactInfoItem.setRemarkFirstPinyin(cursorQuery.getString(cursorQuery.getColumnIndex("remark_first_pinyin")));
                        contactInfoItem.setRemarkAllPinyin(cursorQuery.getString(cursorQuery.getColumnIndex("remark_all_pinyin")));
                        contactInfoItem.setAlbumInfoUpdateLike(cursorQuery.getString(cursorQuery.getColumnIndex("data3")));
                        contactInfoItem.setGender(cursorQuery.getInt(cursorQuery.getColumnIndex("gender")));
                        int columnIndex = cursorQuery.getColumnIndex("gender");
                        if (cursorQuery.isNull(columnIndex)) {
                            contactInfoItem.setGenderReal(-1);
                        } else {
                            contactInfoItem.setGenderReal(cursorQuery.getInt(columnIndex));
                        }
                        contactInfoItem.setSourceType(cursorQuery.getInt(cursorQuery.getColumnIndex("source_type")));
                        contactInfoItem.setCity(cursorQuery.getString(cursorQuery.getColumnIndex(DistrictSearchQuery.KEYWORDS_CITY)));
                        contactInfoItem.setProvince(cursorQuery.getString(cursorQuery.getColumnIndex(DistrictSearchQuery.KEYWORDS_PROVINCE)));
                        contactInfoItem.setCountry(cursorQuery.getString(cursorQuery.getColumnIndex("country")));
                        contactInfoItem.setSessionConfig(cursorQuery.getInt(cursorQuery.getColumnIndex("chat_config")));
                        contactInfoItem.setAccount(cursorQuery.getString(cursorQuery.getColumnIndex("act")));
                        contactInfoItem.setRemarkTel(A(cursorQuery.getString(cursorQuery.getColumnIndex("remark_tel"))));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                        contactInfoItem.setHideRegisterMobile(TextUtils.isEmpty(string) ? false : string.equals("1"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("data2"));
                        contactInfoItem.setFriendType(TextUtils.isEmpty(string2) ? 0 : Integer.parseInt(string2));
                        contactInfoItem.setAccountType(cursorQuery.getInt(cursorQuery.getColumnIndex("account_type")));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("data5"));
                        contactInfoItem.setExt((ContactExtBean) az2.a(string3, ContactExtBean.class));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("rank"));
                        if (!TextUtils.isEmpty(string4)) {
                            contactInfoItem.setContactLocalExt((ContactLocalExt) az2.a(string4, ContactLocalExt.class));
                        }
                        if (x(contactInfoItem)) {
                            try {
                                JSONObject jSONObject = new JSONObject(string3);
                                contactInfoItem.setIntroduction(jSONObject.optString("introduction", ""));
                                contactInfoItem.setSupportConfig(jSONObject.optInt("supportConfig", 0));
                            } catch (Exception unused) {
                            }
                            if (jw5.i(contactInfoItem.getSessionConfig())) {
                                ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
                                contactInfoItemM792clone.setShowAsSpecialAttention(true);
                                e(arrayList2, contactInfoItemM792clone);
                            }
                            if (!contactInfoItem.getIsStranger() && !jw5.e(contactInfoItem.getSessionConfig()) && a65.i(contactInfoItem)) {
                                char cCharAt = contactInfoItem.getIndexPinyin(true).charAt(0);
                                if (cCharAt > 'Z' || cCharAt < 'A') {
                                    e(arrayList3, contactInfoItem);
                                } else {
                                    e(arrayList, contactInfoItem);
                                }
                                if (!a65.f(contactInfoItem.getUid())) {
                                    i++;
                                }
                            }
                            map.put(contactInfoItem.getUid(), contactInfoItem);
                            if (!TextUtils.isEmpty(contactInfoItem.getExid()) && !TextUtils.isEmpty(contactInfoItem.getUid())) {
                                map2.put(contactInfoItem.getExid(), contactInfoItem.getUid());
                            }
                        }
                    } while (cursorQuery.moveToNext());
                    this.e.clear();
                    this.g.clear();
                    this.i.clear();
                    this.j.clear();
                    this.f.clear();
                    this.e.addAll(arrayList2);
                    this.e.addAll(arrayList);
                    this.g.addAll(arrayList3);
                    this.i.putAll(map);
                    this.j.putAll(map2);
                    this.e.addAll(this.g);
                    this.f.addAll(arrayList2);
                    this.h = i;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public final void e(ArrayList<ContactInfoItem> arrayList, ContactInfoItem contactInfoItem) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (f(contactInfoItem.getIndexPinyin(true), arrayList.get(i).getIndexPinyin(true))) {
                arrayList.add(i, contactInfoItem);
                return;
            }
        }
        arrayList.add(contactInfoItem);
    }

    public final boolean f(String str, String str2) {
        for (int i = 0; i < str.length(); i++) {
            if (i >= str2.length() || str.charAt(i) > str2.charAt(i)) {
                return false;
            }
            if (str.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return true;
    }

    public final ContentObserver g() {
        return new c(this.b);
    }

    public ArrayList<ContactInfoItem> h() {
        ArrayList<ContactInfoItem> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, ContactInfoItem>> it = this.i.entrySet().iterator();
        while (it.hasNext()) {
            ContactInfoItem value = it.next().getValue();
            if (jw5.e(value.getSessionConfig())) {
                e(arrayList, value);
            }
        }
        return arrayList;
    }

    public nv i() {
        return this.c;
    }

    public int j() {
        Iterator<ContactInfoItem> it = p().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                return i - 1;
            }
            ContactInfoItem next = it.next();
            boolean z = next.showAsSpecialAttention() && !next.getIsStranger();
            if (!a65.e(next) && !z) {
                i++;
            }
        }
    }

    public int k() {
        return Math.max(0, this.h - 1);
    }

    public ContactInfoItem l(String str) {
        ConcurrentHashMap<String, ContactInfoItem> concurrentHashMap = this.i;
        return (concurrentHashMap == null || concurrentHashMap.size() <= 0) ? n(str) : o(str);
    }

    public final ContactInfoItem m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ContactInfoItem contactInfoItem = this.i.get(str);
        if (contactInfoItem != null || !str.equals(AccountUtils.p(AppContext.getContext()))) {
            return contactInfoItem;
        }
        ContactInfoItem contactInfoItem2 = new ContactInfoItem();
        contactInfoItem2.setUid(str);
        contactInfoItem2.setNickName(AccountUtils.l(AppContext.getContext()));
        contactInfoItem2.setMobile(AccountUtils.k(AppContext.getContext()));
        return contactInfoItem2;
    }

    public synchronized ContactInfoItem n(String str) {
        return m(str);
    }

    public ContactInfoItem o(String str) {
        return m(str);
    }

    public CopyOnWriteArrayList<ContactInfoItem> p() {
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            Iterator<ContactInfoItem> it = this.e.iterator();
            while (it.hasNext()) {
                copyOnWriteArrayList.add(it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    public CopyOnWriteArrayList<ContactInfoItem> q() {
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.addAll(this.f);
        return copyOnWriteArrayList;
    }

    public ContactInfoItem s() {
        return l(v4.e(com.zenmen.palmchat.c.b()));
    }

    public CopyOnWriteArrayList<ContactInfoItem> t(ContactInfoItem contactInfoItem) {
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (ContactInfoItem contactInfoItem2 : this.e) {
            if (!a65.e(contactInfoItem2)) {
                if (contactInfoItem == null) {
                    copyOnWriteArrayList.add(contactInfoItem2);
                } else if (!contactInfoItem.getUid().equals(contactInfoItem2.getUid())) {
                    copyOnWriteArrayList.add(contactInfoItem2);
                }
            }
        }
        return copyOnWriteArrayList;
    }

    public String u(String str) {
        if (str != null) {
            return this.j.get(str);
        }
        return null;
    }

    public final void v() {
        if (AccountUtils.r(AppContext.getContext())) {
            this.b.post(new b());
        }
    }

    public boolean w(String str) {
        ContactInfoItem contactInfoItem;
        return (TextUtils.isEmpty(str) || (contactInfoItem = this.i.get(str)) == null || contactInfoItem.getIsStranger()) ? false : true;
    }

    public final boolean x(ContactInfoItem contactInfoItem) {
        return (contactInfoItem.getFriendType() == 0 && TextUtils.isEmpty(contactInfoItem.getNickName()) && TextUtils.isEmpty(contactInfoItem.getIconURL()) && TextUtils.isEmpty(contactInfoItem.getBigIconURL())) ? false : true;
    }

    public fn0 y() {
        return new fn0();
    }

    public void z() {
        ContentObserver contentObserverG = g();
        this.d = contentObserverG;
        if (contentObserverG != null) {
            try {
                AppContext.getContext().getContentResolver().registerContentObserver(ho0.f18003a, true, this.d);
            } catch (Exception e) {
                e.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_CONTACT_REGISTERCONTENTOBSERVER, e);
            }
        }
    }
}
