package com.zenmen.palmchat.activity.search;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.bt;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.groupchat.GroupMemberInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a65;
import defpackage.bo0;
import defpackage.dx5;
import defpackage.f45;
import defpackage.ho0;
import defpackage.je2;
import defpackage.lg2;
import defpackage.m66;
import defpackage.nn0;
import defpackage.sd3;
import defpackage.v4;
import defpackage.vs0;
import defpackage.wf5;
import defpackage.xf5;
import defpackage.ye2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f12382a;
    public Handler b;
    public Handler c;
    public d d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseActionBarActivity f12383a;

        /* JADX INFO: renamed from: com.zenmen.palmchat.activity.search.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0961a extends MaterialDialog.e {
            public C0961a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends MaterialDialog.e {
            public b() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
            }
        }

        public a(BaseActionBarActivity baseActionBarActivity) {
            this.f12383a = baseActionBarActivity;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            this.f12383a.hideBaseProgressBar();
            try {
                int i = jSONObject.getInt("resultCode");
                if (i == 0) {
                    Intent intent = new Intent(this.f12383a, (Class<?>) m66.c());
                    intent.putExtra("user_item_info", nn0.d(jSONObject.getJSONObject("data")));
                    intent.putExtra("from", 1);
                    this.f12383a.startActivity(intent);
                } else if (i == 1001) {
                    new sd3(this.f12383a).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_token).O(R.string.dialog_confirm).f(new C0961a()).e().show();
                } else {
                    new sd3(this.f12383a).T(R.string.update_install_dialog_title).j(R.string.dialog_content_search_user).O(R.string.dialog_confirm).f(new b()).e().show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseActionBarActivity f12386a;

        public b(BaseActionBarActivity baseActionBarActivity) {
            this.f12386a = baseActionBarActivity;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f12386a.hideBaseProgressBar();
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.search.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class HandlerC0962c extends Handler {

        /* JADX INFO: renamed from: com.zenmen.palmchat.activity.search.c$c$a */
        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f12388a;

            public a(f fVar) {
                this.f12388a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.d != null) {
                    c.this.d.a(this.f12388a);
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.activity.search.c$c$b */
        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12389a;

            public b(String str) {
                this.f12389a = str;
                put("action", "SearchHelper");
                put("status", "fail");
                put("detail", "searchStr=" + str);
            }
        }

        public HandlerC0962c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            removeMessages(0);
            removeMessages(1);
            removeMessages(2);
            removeMessages(3);
            removeMessages(4);
            String str = (String) message.obj;
            try {
                f fVar = new f();
                fVar.f12391a = str;
                int i = message.what;
                if (i == 0) {
                    fVar.b = c.this.j(str);
                } else if (i == 1) {
                    fVar.b = c.this.j(str);
                    fVar.c = new HashMap();
                    HashMap map = new HashMap();
                    fVar.d = map;
                    c.this.l(str, fVar.c, map);
                } else if (i == 2) {
                    fVar.b = c.this.j(str);
                    fVar.c = new HashMap();
                    HashMap map2 = new HashMap();
                    fVar.d = map2;
                    c.this.l(str, fVar.c, map2);
                    fVar.e = c.this.m(str);
                } else if (i == 3) {
                    fVar.c = new HashMap();
                    HashMap map3 = new HashMap();
                    fVar.d = map3;
                    c.this.l(str, fVar.c, map3);
                } else if (i == 4) {
                    fVar.e = c.this.m(str);
                }
                c.this.c.post(new a(fVar));
            } catch (SQLiteException e) {
                LogUtil.i("SearchHelper", 3, new b(str), e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(f fVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12390a;
        public MessageVo b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12391a;
        public List<ContactInfoItem> b;
        public Map<String, GroupInfoItem> c;
        public Map<String, ArrayList<GroupMemberInfoItem>> d;
        public List<Object> e;
    }

    public c(d dVar, boolean z, boolean z2, boolean z3) {
        HandlerThread handlerThreadA = lg2.a("search_thread");
        this.f12382a = handlerThreadA;
        handlerThreadA.start();
        this.b = new HandlerC0962c(this.f12382a.getLooper());
        this.c = new Handler();
        this.d = dVar;
        this.e = z;
        this.f = z2;
        this.g = z3;
    }

    public static String f() {
        JSONObject config = vs0.a().getConfig("searchtext");
        String strOptString = config != null ? config.optString("fromadd") : null;
        return TextUtils.isEmpty(strOptString) ? "查找账号" : strOptString;
    }

    public static String g() {
        JSONObject config = vs0.a().getConfig("searchtext");
        String strOptString = config != null ? config.optString("fromsearch") : null;
        return TextUtils.isEmpty(strOptString) ? "查找账号:" : strOptString;
    }

    public static boolean h() {
        JSONObject config = vs0.a().getConfig("searchtext");
        if (config != null) {
            return config.optBoolean("enablePhoneSearch");
        }
        return false;
    }

    public static HashMap<String, GroupInfoItem> k() {
        HashMap<String, GroupInfoItem> map = new HashMap<>();
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ye2.class, 0), new String[]{"group_id", "name", "headImgUrl", "local_name"}, "group_state =" + Integer.toString(0), null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                GroupInfoItem groupInfoItem = new GroupInfoItem();
                String string = cursorQuery.getString(0);
                groupInfoItem.setGroupId(string);
                groupInfoItem.setGroupName(cursorQuery.getString(1));
                groupInfoItem.setGroupHeadImgUrl(cursorQuery.getString(2));
                groupInfoItem.setGroupLocalName(cursorQuery.getString(3));
                map.put(string, groupInfoItem);
            }
            cursorQuery.close();
        }
        Cursor cursorQuery2 = AppContext.getContext().getContentResolver().query(dx5.f17178a, new String[]{"contact_relate", "title", "icon_url"}, "thread_active" + ContainerUtils.KEY_VALUE_DELIMITER + "1 and chat_type" + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(1), null, null);
        if (cursorQuery != null && cursorQuery2 != null) {
            while (cursorQuery2.moveToNext()) {
                GroupInfoItem groupInfoItem2 = new GroupInfoItem();
                String string2 = cursorQuery2.getString(0);
                groupInfoItem2.setGroupId(string2);
                groupInfoItem2.setGroupLocalName(cursorQuery2.getString(1));
                groupInfoItem2.setGroupHeadImgUrl(cursorQuery2.getString(2));
                map.put(string2, groupInfoItem2);
            }
            cursorQuery2.close();
        }
        return map;
    }

    public static void o(BaseActionBarActivity baseActionBarActivity, String str) {
        baseActionBarActivity.showBaseProgressBar(R.string.search_sending, false);
        a aVar = new a(baseActionBarActivity);
        b bVar = new b(baseActionBarActivity);
        new f45(aVar, bVar).n(str, AccountUtils.i(baseActionBarActivity), "list_m");
    }

    public final String i(String str) {
        return str != null ? str.replaceAll("\"", "") : str;
    }

    public final List<ContactInfoItem> j(String str) {
        String strI = i(str);
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(ho0.f18003a, null, "data2" + String.format(" is \"%d\" and (", 0) + "nick_name like \"%" + strI + "%\" or remark_name like \"%" + strI + "%\" or first_pinyin like \"" + strI + "%\" or remark_first_pinyin like \"" + strI + "%\" or all_pinyin like \"" + strI + "%\" or remark_all_pinyin like \"" + strI + "%\" or act like \"" + strI + "%\")", null, null);
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null) {
            String strE = v4.e(AppContext.getContext());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(DeviceInfoUtil.UID_TAG));
                if (this.f || !"88888000".equals(string)) {
                    ContactInfoItem contactInfoItemL = bo0.r().l(string);
                    if (contactInfoItemL != null && a65.i(contactInfoItemL)) {
                        if (!(contactInfoItemL.getUid() != null && contactInfoItemL.getUid().equals(strE))) {
                            arrayList.add(contactInfoItemL);
                        } else if (this.g) {
                            arrayList.add(contactInfoItemL);
                        }
                    }
                }
            }
            cursorQuery.close();
        }
        return arrayList;
    }

    public final void l(String str, Map<String, GroupInfoItem> map, Map<String, ArrayList<GroupMemberInfoItem>> map2) {
        if (this.e) {
            HashMap<String, GroupInfoItem> mapK = k();
            String strI = i(str);
            if (mapK == null || TextUtils.isEmpty(strI) || map == null || map2 == null) {
                return;
            }
            Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ye2.class, 0), new String[]{"group_id", "name", "local_name"}, "name like \"%" + strI + "%\"", null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    if (mapK.containsKey(string)) {
                        GroupInfoItem groupInfoItem = mapK.get(string);
                        groupInfoItem.setGroupName(cursorQuery.getString(1));
                        groupInfoItem.setGroupLocalName(cursorQuery.getString(2));
                        map.put(string, groupInfoItem);
                    }
                }
                cursorQuery.close();
            }
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                map2.put(it.next(), new ArrayList<>());
            }
            Cursor cursorQuery2 = AppContext.getContext().getContentResolver().query(je2.f18392a, null, "group_member_state" + ContainerUtils.KEY_VALUE_DELIMITER + "0 and (remark_name like \"%" + strI + "%\" or remark_name_all_pinyin like \"" + strI + "%\" or remark_name_first_pinyin like \"" + strI + "%\" or nick_name like \"%" + strI + "%\" or nick_name_all_pinyin like \"" + strI + "%\" or nick_name_first_pinyin like \"" + strI + "%\" or " + bt.s + " like \"%" + strI + "%\" or extra_data1 like \"" + strI + "%\")", null, null);
            if (cursorQuery2 != null) {
                while (cursorQuery2.moveToNext()) {
                    String string2 = cursorQuery2.getString(cursorQuery2.getColumnIndex("group_id"));
                    if (mapK.containsKey(string2)) {
                        if (!map.containsKey(string2)) {
                            map.put(string2, mapK.get(string2));
                        }
                        ArrayList<GroupMemberInfoItem> arrayList = map2.get(string2);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            map2.put(string2, arrayList);
                        }
                        arrayList.add(GroupMemberInfoItem.buildFromCursor(cursorQuery2));
                    }
                }
                cursorQuery2.close();
            }
        }
    }

    public final List<Object> m(String str) {
        wf5 wf5VarA;
        String strI = i(str);
        if (TextUtils.isEmpty(strI) || (wf5VarA = xf5.a(AccountUtils.p(AppContext.getContext()))) == null) {
            return null;
        }
        Cursor cursorRawQuery = wf5VarA.getReadableDatabase().rawQuery(" select *, count(*) as totalcount ,case  when contact_relate like '%@%'  then  rtrim(contact_relate, replace(contact_relate, '@', '' ) ) when contact_relate not like  '%@%' then contact_relate end as result from " + DBUriManager.h(null) + " where message LIKE ? and ( msg_type=? or msg_type=? and data5=? )group by result;", new String[]{"%" + strI + "%", String.valueOf(1), String.valueOf(2), String.valueOf(1)});
        if (cursorRawQuery != null) {
            ArrayList arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                e eVar = new e();
                eVar.b = MessageVo.buildFromCursor(cursorRawQuery);
                eVar.f12390a = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("totalcount"));
                arrayList.add(eVar);
            }
            return arrayList;
        }
        return null;
    }

    public void n() {
        this.b.removeMessages(0);
        this.b.removeMessages(1);
        this.b.removeMessages(2);
        this.b.removeMessages(3);
        this.b.removeMessages(4);
    }

    public void p(int i, String str) {
        n();
        Message message = new Message();
        message.what = i;
        message.obj = str;
        this.b.sendMessage(message);
    }

    public void q() {
        HandlerThread handlerThread = this.f12382a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f12382a = null;
        }
    }

    public c(d dVar, boolean z, boolean z2) {
        this(dVar, z, z2, true);
    }

    public c(d dVar, boolean z) {
        this(dVar, z, true);
    }
}
