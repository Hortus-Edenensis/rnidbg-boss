package defpackage;

import android.database.Cursor;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.conversations.threadsnew.adapter.ConversationAdapter;
import com.zenmen.palmchat.conversations.threadsnew.riskthread.RiskInfo;
import com.zenmen.palmchat.conversations.threadsnew.riskthread.RiskQueryData;
import com.zenmen.palmchat.conversations.threadsnew.riskthread.RiskThreadItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ly4 {
    public static ly4 b = new ly4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, List<RiskThreadItem>> f19101a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<ArrayList<RiskThreadItem>> {
        public a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Comparator<RiskThreadItem> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RiskThreadItem riskThreadItem, RiskThreadItem riskThreadItem2) {
            long j = riskThreadItem.time;
            long j2 = riskThreadItem2.time;
            if (j > j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19105a;

        public d(String str) {
            this.f19105a = str;
            put("count", String.valueOf(ly4.this.e() != null ? ly4.this.e().size() : 0));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            put("fid", str);
        }
    }

    public static ly4 d() {
        return b;
    }

    public final RiskThreadItem a(List<ThreadChatItem> list, RiskInfo riskInfo) {
        if (!riskInfo.riskUser) {
            return null;
        }
        RiskThreadItem riskThreadItem = new RiskThreadItem();
        riskThreadItem.fid = riskInfo.fid;
        riskThreadItem.uid = riskInfo.uid;
        String chatName = "";
        long j = 0;
        String iconURL = "";
        for (ThreadChatItem threadChatItem : list) {
            if (riskInfo.uid.equals(threadChatItem.getChatId())) {
                chatName = threadChatItem.getChatName();
                iconURL = threadChatItem.getIconURL();
                j = threadChatItem.lastMessageDate;
            }
        }
        riskThreadItem.name = chatName;
        riskThreadItem.icon = iconURL;
        riskThreadItem.time = j;
        return riskThreadItem;
    }

    public final void b(List<RiskThreadItem> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int iMin = Math.min(list.size(), 50);
        for (int i = 0; i < iMin; i++) {
            String str = list.get(i).uid;
            if (i == iMin - 1) {
                sb.append("contact_relate= " + str);
            } else {
                sb.append("contact_relate= " + str + " or ");
            }
        }
        AppContext.getContext().getContentResolver().delete(DBUriManager.a(ho3.class, 0), sb.toString(), null);
        AppContext.getContext().getContentResolver().delete(dx5.f17178a, sb.toString(), null);
    }

    public void c(ArrayList<ConversationAdapter.a> arrayList) {
        List<RiskThreadItem> listE = e();
        if (listE == null || listE.size() <= 0 || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        long j = listE.get(0).time;
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ConversationAdapter.a aVar = arrayList.get(i2);
            if (aVar instanceof ConversationAdapter.a) {
                ThreadChatItem threadChatItem = aVar.f13812a;
                if (threadChatItem.lastMessageDate < j && threadChatItem.priority == 0) {
                    break;
                }
            }
            i++;
        }
        ThreadChatItem threadChatItem2 = new ThreadChatItem();
        threadChatItem2.isRiskThreadGroup = true;
        threadChatItem2.lastMessageDate = j;
        arrayList.add(i, new ConversationAdapter.a(threadChatItem2));
        LogUtil.i("RiskThreadManager", "fixThreadListForShow firstItem" + az2.c(listE.get(0)) + " position =" + i);
    }

    public List<RiskThreadItem> e() {
        if (!m()) {
            return null;
        }
        String strP = AccountUtils.p(AppContext.getContext());
        if (TextUtils.isEmpty(strP)) {
            return null;
        }
        List<RiskThreadItem> list = this.f19101a.get(strP);
        if (list != null) {
            return list;
        }
        List<RiskThreadItem> listF = f();
        this.f19101a.put(strP, listF);
        return listF;
    }

    public final List<RiskThreadItem> f() {
        List<RiskThreadItem> list;
        List<RiskThreadItem> arrayList = new ArrayList<>();
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, k86.a("KEY_THREAD_RISK_ITEM"), "");
        LogUtil.i("RiskThreadManager", "getListImp getString" + strN);
        if (!TextUtils.isEmpty(strN) && (list = (List) az2.b(strN, new a().getType())) != null) {
            arrayList = list;
        }
        LogUtil.i("RiskThreadManager", "getListImp " + az2.c(arrayList));
        return arrayList;
    }

    public final long g() {
        JSONObject config = vs0.a().getConfig("illegaluser_dialog");
        long jOptInt = config != null ? ((long) (config.optInt("chattime") * 60 * 60)) * 1000 : 0L;
        if (jOptInt == 0) {
            return 259200000L;
        }
        return jOptInt;
    }

    public String h(String str) {
        JSONObject config = vs0.a().getConfig("illegaluser_dialog");
        String strOptString = config != null ? config.optString("illegalalert") : null;
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = "系统发现对方账号(id:%)存在异常，已限制对方使用连信。请注意保护个人信息安全，谨慎交谈。";
        }
        return strOptString.replace("id:%", str);
    }

    public String i() {
        JSONObject config = vs0.a().getConfig("illegaluser_dialog");
        String strOptString = config != null ? config.optString("listtxt") : null;
        return TextUtils.isEmpty(strOptString) ? "异常消息记录本地仅保留30天" : strOptString;
    }

    public long j(boolean z) {
        long jOptInt = vs0.a().getConfig("illegaluser_dialog") != null ? r0.optInt("listsavetime") : 0L;
        if (jOptInt == 0) {
            jOptInt = 30;
        }
        return !z ? jOptInt * 24 * 60 * 60 * 1000 : jOptInt;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ac A[PHI: r2
      0x00ac: PHI (r2v3 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:15:0x00aa, B:9:0x00a1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ThreadChatItem> k(long j) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList2 = new ArrayList();
                sb.append("thread_active");
                sb.append("=? and ");
                arrayList2.add(String.valueOf(1));
                sb.append("thread_blacklist");
                sb.append(" =? and ");
                arrayList2.add(String.valueOf(0));
                sb.append("thread_contact_ready");
                sb.append(" =? and ");
                arrayList2.add(String.valueOf(1));
                sb.append("latest_message_time_stamp");
                sb.append(" >=? ");
                arrayList2.add(String.valueOf(System.currentTimeMillis() - j));
                String string = sb.toString();
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                LogUtil.i("RiskThreadManager", "updateThreadsCount selection=" + string);
                cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, string, strArr, "thread_priority DESC , thread_draft_time DESC , latest_message_time_stamp DESC");
                while (cursorQuery != null) {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    arrayList.add(ThreadChatItem.parseCursor(cursorQuery));
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

    public final long l() {
        JSONObject config = vs0.a().getConfig("illegaluser_dialog");
        long jOptInt = config != null ? ((long) (config.optInt("checktime") * 60 * 60)) * 1000 : 0L;
        if (jOptInt == 0) {
            return 21600000L;
        }
        return jOptInt;
    }

    public final boolean m() {
        return t66.h().f("LX-55510", false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<RiskThreadItem> n(List<ThreadChatItem> list) throws Exception {
        T t;
        LXBaseNetBean lXBaseNetBeanK = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ThreadChatItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().relativeContact);
        }
        try {
            lXBaseNetBeanK = zw4.k(new c(arrayList));
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("RiskThreadManager", " queryRiskThreadList Exception=", e);
        }
        LogUtil.i("RiskThreadManager", " queryRiskThreadList result=" + az2.c(lXBaseNetBeanK));
        ArrayList arrayList2 = new ArrayList();
        if (lXBaseNetBeanK != null && lXBaseNetBeanK.isSuccess() && (t = lXBaseNetBeanK.data) != 0) {
            Iterator<RiskInfo> it2 = ((RiskQueryData) t).riskInfo.iterator();
            while (it2.hasNext()) {
                RiskThreadItem riskThreadItemA = a(list, it2.next());
                if (riskThreadItemA != null) {
                    arrayList2.add(riskThreadItemA);
                }
            }
        }
        return arrayList2;
    }

    public void o(boolean z, String str) {
        zn6.h("pagemsg_blockcard", z ? "click" : "view", new d(str));
    }

    public void p(String str) {
        if (m()) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            if (Math.abs(sPUtil.i(scene, k86.a("KEY_THREAD_RISK_REFRESH_TIME"), 0L) - ir5.b()) < l()) {
                return;
            }
            LogUtil.i("RiskThreadManager", "update enter from=" + str);
            sPUtil.t(scene, k86.a("KEY_THREAD_RISK_REFRESH_TIME"), Long.valueOf(ir5.b()));
            try {
                q();
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.i("RiskThreadManager", "updateRiskList Exception ", e);
            }
        }
    }

    public final void q() throws Exception {
        List<ThreadChatItem> listK = k(g());
        LogUtil.i("RiskThreadManager", " updateRiskList getThreads=" + az2.c(listK));
        List<RiskThreadItem> listN = n(listK);
        LogUtil.i("RiskThreadManager", " updateRiskList riskThreadList=" + az2.c(listN));
        r(listN);
        b(listN);
    }

    public final void r(List<RiskThreadItem> list) {
        List<RiskThreadItem> listE = e();
        if (listE == null) {
            listE = new ArrayList<>();
        }
        if (list != null && list.size() > 0) {
            for (RiskThreadItem riskThreadItem : list) {
                if (listE.contains(riskThreadItem)) {
                    int iIndexOf = listE.indexOf(riskThreadItem);
                    if (iIndexOf >= 0) {
                        listE.get(iIndexOf).name = riskThreadItem.name;
                        listE.get(iIndexOf).icon = riskThreadItem.icon;
                        listE.get(iIndexOf).time = riskThreadItem.time;
                    }
                } else {
                    listE.add(riskThreadItem);
                }
            }
        }
        Collections.sort(listE, new b());
        ArrayList arrayList = new ArrayList();
        for (RiskThreadItem riskThreadItem2 : listE) {
            if (Math.abs(riskThreadItem2.time - ir5.b()) < j(false)) {
                arrayList.add(riskThreadItem2);
            }
        }
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("KEY_THREAD_RISK_ITEM"), az2.c(arrayList));
        this.f19101a.put(v4.e(AppContext.getContext()), arrayList);
        LogUtil.i("RiskThreadManager", " updateRiskThreadForShow result=" + az2.c(arrayList));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<RiskQueryData>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f19104a;

        public c(List list) {
            this.f19104a = list;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("fuids", this.f19104a);
            return sw4.b(1, nl0.z + "/user.risk.query.v1", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<RiskQueryData> lXBaseNetBean, Exception exc) {
        }
    }
}
