package defpackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.bytertc.engine.UserInfo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ja6 {
    public static ja6 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<va6> f18364a = new ArrayList();
    public va6 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<RoomUserInfo> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RoomUserInfo roomUserInfo, RoomUserInfo roomUserInfo2) {
            int i = (int) (roomUserInfo.entryTime - roomUserInfo2.entryTime);
            if (i > 0) {
                return 1;
            }
            return i == 0 ? 0 : -1;
        }
    }

    public static UserInfo c(ChatItem chatItem) {
        JSONObject jSONObject = new JSONObject();
        try {
            String chatName = chatItem.getChatName();
            if (chatName != null && chatName.length() > 8) {
                chatName = chatName.substring(0, 7);
            }
            jSONObject.put("name", chatName);
            jSONObject.put("icon", chatItem.getIconURL());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new UserInfo(b46.b(Long.parseLong(chatItem.getChatId())), jSONObject.toString());
    }

    @NonNull
    public static ja6 f() {
        if (c == null) {
            c = new ja6();
        }
        return c;
    }

    public void a(@Nullable va6 va6Var) {
        if (va6Var == null || TextUtils.isEmpty(va6Var.b)) {
            return;
        }
        if (!this.f18364a.contains(va6Var)) {
            this.f18364a.add(va6Var);
            fg5.a(new sy4(va6Var, true));
            fg5.a(new yu4(e()));
            return;
        }
        int iIndexOf = this.f18364a.indexOf(va6Var);
        if (iIndexOf != -1) {
            va6 va6Var2 = this.f18364a.get(iIndexOf);
            va6Var2.d = false;
            if (!TextUtils.isEmpty(va6Var.c)) {
                va6Var2.c = va6Var.c;
            }
            if (!TextUtils.isEmpty(va6Var.f21394a)) {
                va6Var2.f21394a = va6Var.f21394a;
            }
            fg5.a(new yu4(e()));
        }
    }

    public void b(@Nullable List<va6> list) {
        LogUtil.e("RTC", "addUsers " + az2.c(list));
        if (list == null || list.size() == 0) {
            return;
        }
        for (va6 va6Var : list) {
            if (!this.f18364a.contains(va6Var)) {
                this.f18364a.add(va6Var);
            }
        }
        fg5.a(new yu4(e()));
    }

    public int d() {
        List<va6> list = this.f18364a;
        int i = 0;
        if (list != null && list.size() > 0) {
            Iterator<va6> it = this.f18364a.iterator();
            while (it.hasNext()) {
                if (!it.next().d) {
                    i++;
                }
            }
        }
        return i;
    }

    @NonNull
    public List<va6> e() {
        ArrayList arrayList = new ArrayList(this.f18364a);
        va6 va6Var = this.b;
        if (va6Var != null) {
            arrayList.add(0, va6Var);
        }
        int iIndexOf = arrayList.indexOf(new va6(eg5.c().a()));
        if (iIndexOf != -1) {
            arrayList.add((va6) arrayList.remove(iIndexOf));
        }
        return arrayList;
    }

    public void g(rh6 rh6Var) {
        ArrayList<RoomUserInfo> arrayList;
        if (rh6Var == null || (arrayList = rh6Var.i) == null) {
            return;
        }
        Collections.sort(arrayList, new a());
        List<va6> listA = va6.a(rh6Var.i);
        ArrayList arrayList2 = new ArrayList();
        List<va6> listE = e();
        if (listE.size() > 0) {
            for (va6 va6Var : listE) {
                if (!va6Var.d) {
                    arrayList2.add(va6Var);
                }
            }
        }
        for (va6 va6Var2 : listA) {
            if (!arrayList2.contains(va6Var2)) {
                arrayList2.add(va6Var2);
            }
        }
        this.f18364a.clear();
        this.f18364a.addAll(arrayList2);
        fg5.a(new yu4(e()));
    }

    public void h() {
        this.f18364a.clear();
        this.b = null;
    }

    public void i(@Nullable String str) {
        LogUtil.e("RTC", "removeUser " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ListIterator<va6> listIterator = this.f18364a.listIterator();
        while (listIterator.hasNext()) {
            va6 next = listIterator.next();
            if (TextUtils.equals(next.b, str)) {
                listIterator.remove();
                fg5.a(new sy4(next, false));
                fg5.a(new yu4(e()));
            }
        }
    }

    public void j(@Nullable String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (va6 va6Var : this.f18364a) {
            if (TextUtils.equals(va6Var.b, str)) {
                va6Var.e = z;
            }
        }
        fg5.a(new vm3(str, 1, z ? 1 : 0));
    }

    public void k(@Nullable String str, boolean z) {
        for (va6 va6Var : this.f18364a) {
            if (TextUtils.equals(va6Var.b, str)) {
                va6Var.f = z;
            }
        }
        fg5.a(new vm3(str, 0, z ? 1 : 0));
    }
}
