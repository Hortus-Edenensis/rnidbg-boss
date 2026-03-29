package defpackage;

import android.content.ContentValues;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.contacts.ContactRequestsVO;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class un0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21245a = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c5<Object> {
        @Override // defpackage.c5
        public void call(Object obj) {
            LogUtil.i("ContactRequestSyncHelper", "subscribe" + Thread.currentThread().getName());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c5<Throwable> {
        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            LogUtil.i("ContactRequestSyncHelper", "Throwable" + Thread.currentThread().getName());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements b5 {
        @Override // defpackage.b5
        public void call() {
            LogUtil.i("ContactRequestSyncHelper", "doOnTerminate" + Thread.currentThread().getName());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements b5 {
        @Override // defpackage.b5
        public void call() {
            LogUtil.i("ContactRequestSyncHelper", "doOnSubscribe" + Thread.currentThread().getName());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements s42<List<ContactRequestsVO>, Object> {
        @Override // defpackage.s42
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object call(List<ContactRequestsVO> list) {
            LogUtil.i("ContactRequestSyncHelper", "map" + Thread.currentThread().getName());
            un0.g(list);
            return null;
        }
    }

    public static ArrayList<ContactInfoItem> b(ArrayList<String> arrayList) {
        ArrayList<ContactInfoItem> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(arrayList);
            arrayList2.addAll(new t92().o(hashSet));
        }
        return arrayList2;
    }

    public static int c(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int i = !str.contains("avatar/u/c/default/default") ? 1 : 0;
        return (str2.startsWith("连信用户") && str2.length() == 9) ? i : i + 1;
    }

    public static boolean d(ContactRequestsVO contactRequestsVO, ContactInfoItem contactInfoItem) {
        String str = contactRequestsVO.fromUid;
        return (str == null || !str.equals(contactInfoItem.getUid()) || ((contactInfoItem.getIconURL() == null || contactInfoItem.getIconURL().equals(contactRequestsVO.fromHeadIcon)) && (contactInfoItem.getNickName() == null || contactInfoItem.getNickName().equals(contactRequestsVO.fromNickName)))) ? false : true;
    }

    public static void e(en0 en0Var) {
        if (en0Var != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (en0Var.b() != null && en0Var.b().b() != null) {
                    arrayList.add(en0Var.b().b());
                }
                if (en0Var.c() != null) {
                    for (xh4 xh4Var : en0Var.c()) {
                        if (xh4Var.b() != null) {
                            arrayList.add(xh4Var.b());
                        }
                    }
                }
                f(arrayList, "notifyContactCard");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void f(List<ContactRequestsVO> list, String str) {
        LogUtil.i("ContactRequestSyncHelper", "startSyncContactRequestsVO " + str);
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            n54.f(list).h(new e()).u(b35.c()).i(wc.a()).c(new d()).d(new c()).q(new a(), new b());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized void g(List<ContactRequestsVO> list) {
        if (list != null) {
            try {
                LogUtil.i("ContactRequestSyncHelper", "syncContactRequests" + list.size());
                ArrayList arrayList = new ArrayList();
                for (ContactRequestsVO contactRequestsVO : list) {
                    if ((!bo0.r().w(contactRequestsVO.fromUid) && c(contactRequestsVO.fromHeadIcon, contactRequestsVO.fromNickName) != 2) || f21245a) {
                        arrayList.add(contactRequestsVO.fromUid);
                    }
                }
                ArrayList<ContactInfoItem> arrayListB = b(arrayList);
                LogUtil.i("ContactRequestSyncHelper", "syncContactRequests getContactInfoItems" + arrayListB.size());
                ArrayList arrayList2 = new ArrayList();
                for (ContactInfoItem contactInfoItem : arrayListB) {
                    Iterator<ContactRequestsVO> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ContactRequestsVO next = it.next();
                        String str = next.fromUid;
                        if (str != null && str.equals(contactInfoItem.getUid())) {
                            if (f21245a) {
                                contactInfoItem.setNickName(contactInfoItem.getNickName() + xn3.a());
                            }
                            if (d(next, contactInfoItem)) {
                                arrayList2.add(contactInfoItem);
                            }
                        }
                    }
                }
                LogUtil.i("ContactRequestSyncHelper", "syncContactRequests diffItems" + arrayList2.size());
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    h((ContactInfoItem) it2.next(), true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void h(ContactInfoItem contactInfoItem, boolean z) {
        LogUtil.e("ContactRequestSyncHelper", "updateDb" + contactInfoItem);
        if (contactInfoItem != null) {
            try {
                if (c(contactInfoItem.getIconURL(), contactInfoItem.getNickName()) != 0) {
                    String[] strArr = {contactInfoItem.getUid(), contactInfoItem.getNickName(), contactInfoItem.getIconURL()};
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("from_nick_name", contactInfoItem.getNickName());
                    contentValues.put("from_head_img_url", contactInfoItem.getIconURL());
                    if (z) {
                        AppContext.getContext().getContentResolver().update(vn0.f21483a, contentValues, "from_uid=? and (from_nick_name!=? or from_head_img_url!=?)", strArr);
                    } else {
                        zh.k(AppContext.getContext().getContentResolver()).j(0, null, vn0.f21483a, contentValues, "from_uid=? and (from_nick_name!=? or from_head_img_url!=?)", strArr);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
