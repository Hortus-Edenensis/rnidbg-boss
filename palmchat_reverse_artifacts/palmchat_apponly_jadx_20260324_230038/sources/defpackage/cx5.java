package defpackage;

import android.database.Cursor;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.conversations.threadgroup.ThreadFolderManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cx5 {
    public static String f = "ThreadStatusManager";
    public static volatile cx5 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16945a = -1;
    public int b = 0;
    public List<wk2> c = new ArrayList();
    public ic3 d = new ic3();
    public final Map<Integer, gu5> e = new ConcurrentHashMap();

    public static cx5 b() {
        if (g == null) {
            synchronized (cx5.class) {
                if (g == null) {
                    g = new cx5();
                }
            }
        }
        return g;
    }

    public int a() {
        return this.b;
    }

    public String c() {
        return this.d.e;
    }

    public int d() {
        return this.d.c;
    }

    public int e() {
        return this.d.f1847a;
    }

    public int f() {
        return this.d.b;
    }

    public void g() {
        this.d = new ic3();
        this.e.clear();
    }

    public void h(int i) {
        LogUtil.d("ChatMateGiftManagerTAG", "ThreadStatusManager ChatMateMsg 设置消息会话未读数 setChatMateMsgListCount count " + i);
        this.b = i;
        ch.s().J0(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i() {
        Exception exc;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        ic3 ic3Var;
        Cursor cursorQuery;
        boolean z;
        String string;
        String str2;
        String str3 = "thread_biz_type";
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        boolean z2 = true;
        Cursor cursor = null;
        String string2 = null;
        cursor = null;
        cursor = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                sb.append("thread_active");
                sb.append("=? and ");
                arrayList.add(String.valueOf(1));
                sb.append("contact_relate");
                sb.append(" !=? and ");
                arrayList.add("88888003");
                if (dd6.b()) {
                    try {
                        sb.append("contact_relate");
                        sb.append(" !=? and ");
                        arrayList.add("88888027");
                    } catch (Exception e) {
                        exc = e;
                        str = null;
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                    }
                }
                if (dd6.a()) {
                    sb.append("contact_relate");
                    sb.append(" !=? and ");
                    arrayList.add("88888010");
                }
                sb.append("thread_blacklist");
                sb.append("=? and  (( ");
                arrayList.add(String.valueOf(0));
                sb.append("thread_contact_ready");
                sb.append("=? and (");
                arrayList.add(String.valueOf(1));
                sb.append("thread_biz_type");
                sb.append("=? or ");
                arrayList.add(String.valueOf(0));
                fu5.a(sb, arrayList, false);
                sb.append("thread_biz_type");
                sb.append("=?)) or (");
                arrayList.add(String.valueOf(13));
                sb.append("thread_contact_ready");
                sb.append(" =? and ");
                arrayList.add(String.valueOf(0));
                sb.append("thread_biz_type");
                sb.append(" =? ))");
                arrayList.add(String.valueOf(22));
                String string3 = sb.toString();
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                LogUtil.i(f, "updateThreadsCount selection=" + string3);
                cursorQuery = AppContext.getContext().getContentResolver().query(dx5.f17178a, null, string3, strArr, "thread_priority DESC , thread_draft_time DESC , latest_message_time_stamp DESC");
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            exc = e2;
            str = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        while (cursorQuery != null) {
            try {
                try {
                } catch (Exception e3) {
                    e = e3;
                }
                if (!cursorQuery.moveToNext()) {
                    break;
                }
                boolean z3 = cursorQuery.getInt(cursorQuery.getColumnIndex("thread_nodisturb")) == z2;
                int i7 = cursorQuery.getInt(cursorQuery.getColumnIndex(str3));
                if (fu5.t(i7)) {
                    try {
                        z = fu5.k(i7).saveInTempTable;
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("contact_relate"));
                        if (!z) {
                            i4++;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        z2 = true;
                        exc = e;
                        str = string2;
                        cursor = cursorQuery;
                        exc.printStackTrace();
                        if (cursor != null) {
                        }
                        string2 = str;
                        i6 = this.b + i;
                        ic3Var = this.d;
                        if (ic3Var.f1847a == i6) {
                        }
                        ic3Var.f1847a = i6;
                        ic3Var.b = i2;
                        ic3Var.c = i3;
                        ic3Var.d = i5;
                        ic3Var.e = string2;
                        this.f16945a = i4;
                        while (r0.hasNext()) {
                        }
                        return z2;
                    }
                    if (z3) {
                        str2 = str3;
                        z2 = true;
                    } else {
                        int i8 = cursorQuery.getInt(cursorQuery.getColumnIndex("unread_message_count"));
                        if (z) {
                            try {
                                ArrayList arrayList2 = (ArrayList) concurrentHashMap2.get(Integer.valueOf(i7));
                                Integer num = (Integer) concurrentHashMap.get(Integer.valueOf(i7));
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                if (num == null) {
                                    try {
                                        num = 0;
                                    } catch (Exception e5) {
                                        e = e5;
                                        z2 = true;
                                        exc = e;
                                        str = string2;
                                        cursor = cursorQuery;
                                        exc.printStackTrace();
                                        if (cursor != null) {
                                        }
                                        string2 = str;
                                        i6 = this.b + i;
                                        ic3Var = this.d;
                                        if (ic3Var.f1847a == i6) {
                                        }
                                        ic3Var.f1847a = i6;
                                        ic3Var.b = i2;
                                        ic3Var.c = i3;
                                        ic3Var.d = i5;
                                        ic3Var.e = string2;
                                        this.f16945a = i4;
                                        while (r0.hasNext()) {
                                        }
                                        return z2;
                                    }
                                }
                                str2 = str3;
                                arrayList2.add(ThreadChatItem.parseCursor(cursorQuery));
                                Integer numValueOf = Integer.valueOf(num.intValue() + i8);
                                concurrentHashMap2.put(Integer.valueOf(i7), arrayList2);
                                concurrentHashMap.put(Integer.valueOf(i7), numValueOf);
                                z2 = true;
                            } catch (Exception e6) {
                                e = e6;
                            }
                        } else {
                            str2 = str3;
                            if (!ThreadFolderManager.e(i7)) {
                                i += i8;
                                if (!a65.f(string)) {
                                    i5 += i8;
                                }
                            }
                            int i9 = cursorQuery.getInt(cursorQuery.getColumnIndex("chat_type"));
                            z2 = true;
                            if (i9 == 1) {
                                i2 += i8;
                            }
                            if (i8 > 0) {
                                i3++;
                            }
                            try {
                                if (TextUtils.isEmpty(string2) && i8 > 0 && i9 == 0 && !ThreadFolderManager.e(i7) && !a65.f(string)) {
                                    string2 = cursorQuery.getString(cursorQuery.getColumnIndex("icon_url"));
                                }
                            } catch (Exception e7) {
                                e = e7;
                                exc = e;
                                str = string2;
                                cursor = cursorQuery;
                                exc.printStackTrace();
                                if (cursor != null) {
                                }
                                string2 = str;
                                i6 = this.b + i;
                                ic3Var = this.d;
                                if (ic3Var.f1847a == i6) {
                                }
                                ic3Var.f1847a = i6;
                                ic3Var.b = i2;
                                ic3Var.c = i3;
                                ic3Var.d = i5;
                                ic3Var.e = string2;
                                this.f16945a = i4;
                                while (r0.hasNext()) {
                                }
                                return z2;
                            }
                        }
                        exc.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        string2 = str;
                    }
                    str3 = str2;
                }
                i6 = this.b + i;
                ic3Var = this.d;
                if (ic3Var.f1847a == i6) {
                    z2 = false;
                }
                ic3Var.f1847a = i6;
                ic3Var.b = i2;
                ic3Var.c = i3;
                ic3Var.d = i5;
                ic3Var.e = string2;
                this.f16945a = i4;
                for (Integer num2 : concurrentHashMap2.keySet()) {
                    ArrayList<ThreadChatItem> arrayList3 = (ArrayList) concurrentHashMap2.get(num2);
                    Integer num3 = (Integer) concurrentHashMap.get(num2);
                    gu5 gu5Var = this.e.get(num2);
                    if (gu5Var == null) {
                        gu5Var = new gu5();
                    }
                    if (gu5Var.a(arrayList3)) {
                        gu5Var.b = arrayList3;
                        gu5Var.f1847a = num3.intValue();
                        this.e.put(num2, gu5Var);
                        ch.s().i0(num2.intValue());
                    }
                }
                return z2;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        i6 = this.b + i;
        ic3Var = this.d;
        if (ic3Var.f1847a == i6) {
        }
        ic3Var.f1847a = i6;
        ic3Var.b = i2;
        ic3Var.c = i3;
        ic3Var.d = i5;
        ic3Var.e = string2;
        this.f16945a = i4;
        while (r0.hasNext()) {
        }
        return z2;
    }
}
