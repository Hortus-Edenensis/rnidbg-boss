package com.zenmen.palmchat.groupchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.oplus.tblplayer.Constants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.search.c;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.ui.UpgradeGroupSelectActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.groupchat.b;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import com.zenmen.palmchat.settings.cert.a;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.CharIndexView;
import defpackage.UI;
import defpackage.al4;
import defpackage.bo0;
import defpackage.eo0;
import defpackage.fn0;
import defpackage.fu2;
import defpackage.gu2;
import defpackage.ie2;
import defpackage.ih;
import defpackage.il5;
import defpackage.iq5;
import defpackage.je2;
import defpackage.k86;
import defpackage.oc0;
import defpackage.pm2;
import defpackage.qm5;
import defpackage.rl0;
import defpackage.ry5;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.us2;
import defpackage.v8;
import defpackage.w4;
import defpackage.wd2;
import defpackage.xn3;
import defpackage.ze2;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupChatInitActivity extends BaseActionBarActivity implements CharIndexView.a, pm2<Cursor> {
    public static final String p0 = "GroupChatInitActivity";
    public static int q0 = 40;
    public HorizontalScrollView A;
    public LinearLayout B;
    public CharIndexView C;
    public TextView E;
    public TextView F;
    public EditText G;
    public TextWatcher H;
    public ListView I;
    public View J;
    public View K;
    public ImageView L;
    public wd2 M;
    public ArrayList<ContactInfoItem> N;
    public CopyOnWriteArrayList<ContactInfoItem> O;
    public int[] R;
    public HashMap<Character, Integer> S;
    public Response.ErrorListener T;
    public Response.Listener<JSONObject> U;
    public Response.ErrorListener V;
    public Response.Listener<JSONObject> W;
    public boolean X;
    public boolean Y;
    public com.zenmen.palmchat.activity.search.c f0;
    public ih h0;
    public boolean j0;
    public View k0;
    public View l0;
    public com.zenmen.palmchat.groupchat.b o0;
    public int q;
    public ArrayList<ContactInfoItem> t;
    public GroupInfoItem v;
    public List<ContactInfoItem> w;
    public List<ContactInfoItem> x;
    public ListView y;
    public wd2 z;
    public boolean r = false;
    public ArrayList<String> s = new ArrayList<>();
    public ContactInfoItem u = null;
    public ArrayList<ContactInfoItem> P = new ArrayList<>();
    public LinkedHashMap<String, ContactInfoItem> Q = new LinkedHashMap<>();
    public final int Z = 7;
    public final int e0 = 9;
    public String g0 = null;
    public final int i0 = 1;
    public float m0 = 0.0f;
    public c.d n0 = new s();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnKeyListener {
        public a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 67 || keyEvent.getAction() != 0 || !TextUtils.isEmpty(GroupChatInitActivity.this.G.getText())) {
                return false;
            }
            GroupChatInitActivity.this.o0.d();
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<Void, Void, GroupModifyResultVo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14236a;

        public b(ArrayList arrayList) {
            this.f14236a = arrayList;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupModifyResultVo doInBackground(Void... voidArr) {
            try {
                return new us2().n(this.f14236a, GroupChatInitActivity.this.g0);
            } catch (DaoException unused) {
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(GroupModifyResultVo groupModifyResultVo) {
            Intent intent;
            super.onPostExecute(groupModifyResultVo);
            GroupChatInitActivity.this.hideBaseProgressBar();
            if (groupModifyResultVo == null) {
                GroupChatInitActivity.this.y2();
                return;
            }
            int i = groupModifyResultVo.resultCode;
            if (i != 0 && i != 4001) {
                if (i == 4028) {
                    GroupChatInitActivity.this.A2(groupModifyResultVo);
                    return;
                }
                if (i == 4002) {
                    if (groupModifyResultVo.members != null) {
                        GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "view");
                        GroupChatInitActivity.this.w2(this.f14236a, groupModifyResultVo.members);
                    }
                    LogUtil.onClickEvent("512", "2", null);
                    return;
                }
                if (i == 4015) {
                    GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "view");
                    GroupChatInitActivity.this.z2();
                    return;
                } else if (TextUtils.isEmpty(groupModifyResultVo.errorMsg)) {
                    GroupChatInitActivity.this.y2();
                    return;
                } else {
                    GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "view");
                    GroupChatInitActivity.x2(groupModifyResultVo.errorMsg, GroupChatInitActivity.this);
                    return;
                }
            }
            GroupInfoItem groupInfoItemA = ze2.a(groupModifyResultVo.roomId, 0);
            GroupChatInitActivity groupChatInitActivity = GroupChatInitActivity.this;
            if (groupChatInitActivity.Y) {
                Intent intent2 = new Intent();
                intent2.putExtra("group_choose_contact_forward_chatitem", groupInfoItemA);
                GroupChatInitActivity.this.setResult(-1, intent2);
            } else {
                sy5.e(groupChatInitActivity, R.string.send_success, 0).g();
                LogUtil.onClickEvent("512", "1", null);
                if (groupInfoItemA != null) {
                    intent = new Intent(GroupChatInitActivity.this, (Class<?>) ChatterActivity.class);
                    intent.putExtra("fromType", 0);
                    intent.putExtra("chat_item", groupInfoItemA);
                    k86.X(intent);
                } else {
                    intent = new Intent();
                    intent.setClass(GroupChatInitActivity.this, MainTabsActivity.class);
                    k86.X(intent);
                    intent.putExtra("new_intent_position", "tab_msg");
                }
                GroupChatInitActivity.this.startActivity(intent);
            }
            GroupChatInitActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements a.b {
        public c() {
        }

        @Override // com.zenmen.palmchat.settings.cert.a.b
        public void onResult(boolean z) {
            if (z) {
                return;
            }
            ry5.a(GroupChatInitActivity.this.getString(R.string.circle_real_name_failed));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements al4 {
        public d() {
        }

        @Override // defpackage.al4
        public void a(GroupModifyResultVo groupModifyResultVo) {
            GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "click");
            GroupChatInitActivity.this.B2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14239a;
        public final /* synthetic */ String[] b;

        public e(ArrayList arrayList, String[] strArr) {
            this.f14239a = arrayList;
            this.b = strArr;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            GroupChatInitActivity.this.v2(this.f14239a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f14241a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ EditText c;

        public g(String[] strArr, ArrayList arrayList, EditText editText) {
            this.f14241a = strArr;
            this.b = arrayList;
            this.c = editText;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            String exid;
            HashMap map = new HashMap();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (String str : this.f14241a) {
                sb.append(str);
                sb.append(",");
                Iterator it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        exid = null;
                        break;
                    }
                    ContactInfoItem contactInfoItem = (ContactInfoItem) it.next();
                    if (contactInfoItem.getUid().equals(str)) {
                        exid = contactInfoItem.getExid();
                        break;
                    }
                }
                sb2.append(exid);
                sb2.append(",");
                sb3.append(String.valueOf(2));
                sb3.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb2.deleteCharAt(sb2.length() - 1);
            sb3.deleteCharAt(sb3.length() - 1);
            map.put("fuids", sb.toString());
            map.put("fexids", sb2.toString());
            map.put("info", this.c.getText().toString());
            map.put("sourceType", String.valueOf(12));
            map.put("subTypes", sb3.toString());
            GroupChatInitActivity.this.h0 = new ih(GroupChatInitActivity.this.W, GroupChatInitActivity.this.V);
            try {
                GroupChatInitActivity.this.h0.s(map);
                GroupChatInitActivity.this.showBaseProgressBar();
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.ErrorListener {
        public h() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GroupChatInitActivity.this.hideBaseProgressBar();
            GroupChatInitActivity.this.y2();
            LogUtil.d(GroupChatInitActivity.p0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.Listener<JSONObject> {
        public i() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            GroupChatInitActivity.this.hideBaseProgressBar();
            if (iOptInt != 0) {
                GroupChatInitActivity.this.y2();
                return;
            }
            sy5.e(GroupChatInitActivity.this, R.string.send_success, 0).g();
            iq5.j(false, new String[0]);
            Intent intent = new Intent();
            intent.setClass(GroupChatInitActivity.this, MainTabsActivity.class);
            k86.X(intent);
            intent.putExtra("new_intent_position", "tab_msg");
            GroupChatInitActivity.this.startActivity(intent);
            GroupChatInitActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupChatInitActivity.this.K.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements Response.ErrorListener {
        public k() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GroupChatInitActivity.this.hideBaseProgressBar();
            GroupChatInitActivity.this.y2();
            LogUtil.d(GroupChatInitActivity.p0, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements Response.Listener<JSONObject> {
        public l() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            GroupChatInitActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") == 0) {
                sy5.e(GroupChatInitActivity.this, R.string.sent, 0).g();
                return;
            }
            String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            GroupChatInitActivity groupChatInitActivity = GroupChatInitActivity.this;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = GroupChatInitActivity.this.getString(R.string.send_failed);
            }
            sy5.f(groupChatInitActivity, strOptString, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupChatInitActivity.this.z.c(GroupChatInitActivity.this.O);
            GroupChatInitActivity.this.z.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements AbsListView.OnScrollListener {
        public n() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int height = 0;
            View childAt = GroupChatInitActivity.this.y.getChildAt(0);
            if (childAt != null) {
                int firstVisiblePosition = GroupChatInitActivity.this.y.getFirstVisiblePosition();
                height = (firstVisiblePosition * childAt.getHeight()) + (-childAt.getTop());
            }
            if (height > 0) {
                return;
            }
            GroupChatInitActivity.this.J.setVisibility(8);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            GroupChatInitActivity.this.G.clearFocus();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements AdapterView.OnItemClickListener {
        public o() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i > 0) {
                ContactInfoItem contactInfoItem = (ContactInfoItem) GroupChatInitActivity.this.O.get(i - 1);
                if (contactInfoItem != null && !TextUtils.isEmpty(contactInfoItem.getMobile()) && contactInfoItem.getMobile().equals(GroupChatInitActivity.this.getResources().getString(R.string.group_chat_choose_group))) {
                    if (!GroupChatInitActivity.this.Y) {
                        Intent intent = new Intent(GroupChatInitActivity.this, (Class<?>) GroupListActivity.class);
                        intent.putExtra("extra_choose", true);
                        intent.putExtra("group_entry", true);
                        GroupChatInitActivity.this.startActivity(intent);
                        return;
                    }
                    Intent intent2 = new Intent(GroupChatInitActivity.this, (Class<?>) GroupListActivity.class);
                    intent2.putExtra("extra_choose", true);
                    intent2.putExtra("extra_choose_forward", true);
                    intent2.putExtra("group_entry", true);
                    GroupChatInitActivity.this.startActivityForResult(intent2, 0);
                    return;
                }
                if (contactInfoItem != null && !TextUtils.isEmpty(contactInfoItem.getMobile()) && contactInfoItem.getMobile().equals(GroupChatInitActivity.this.getResources().getString(R.string.group_upgrade_to_circle))) {
                    GroupChatInitActivity.this.startActivity(new Intent(GroupChatInitActivity.this, (Class<?>) UpgradeGroupSelectActivity.class));
                    return;
                }
                if (contactInfoItem == null || TextUtils.isEmpty(contactInfoItem.getMobile()) || !contactInfoItem.getMobile().equals(GroupChatInitActivity.this.getResources().getString(R.string.group_chat_init_face_to_face))) {
                    if (contactInfoItem != null && contactInfoItem.getUid() == "-1" && "all of person" == contactInfoItem.getExid()) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("extra_all_of", true);
                        GroupChatInitActivity.this.setResult(-1, intent3);
                        GroupChatInitActivity.this.finish();
                        return;
                    }
                    String strP = AccountUtils.p(AppContext.getContext());
                    if (GroupChatInitActivity.this.s == null || !(GroupChatInitActivity.this.s.contains(contactInfoItem.getUid()) || strP == null || strP.equals(contactInfoItem.getUid()))) {
                        GroupChatInitActivity.this.F2(contactInfoItem);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p implements b.InterfaceC1061b {
        public p() {
        }

        @Override // com.zenmen.palmchat.groupchat.b.InterfaceC1061b
        public void a(ContactInfoItem contactInfoItem) {
            if (contactInfoItem != null) {
                GroupChatInitActivity.this.F2(contactInfoItem);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("fromtype", Integer.valueOf(GroupChatInitActivity.this.q));
            }
        }

        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatItem chatItem;
            ArrayList arrayList = new ArrayList();
            if (GroupChatInitActivity.this.P != null) {
                for (ContactInfoItem contactInfoItem : GroupChatInitActivity.this.P) {
                    if (!AccountUtils.p(AppContext.getContext()).equals(contactInfoItem.getUid())) {
                        arrayList.add(contactInfoItem);
                    }
                }
            }
            if (GroupChatInitActivity.this.t != null) {
                for (ContactInfoItem contactInfoItem2 : GroupChatInitActivity.this.t) {
                    if (!AccountUtils.p(AppContext.getContext()).equals(contactInfoItem2.getUid())) {
                        arrayList.add(contactInfoItem2);
                    }
                }
            }
            if (GroupChatInitActivity.this.q == 9 || GroupChatInitActivity.this.q == 10) {
                Intent intent = new Intent();
                intent.putExtra("choose_contact_list", GroupChatInitActivity.this.P);
                GroupChatInitActivity.this.setResult(-1, intent);
                GroupChatInitActivity.this.finish();
            } else {
                GroupChatInitActivity groupChatInitActivity = GroupChatInitActivity.this;
                if (groupChatInitActivity.Y) {
                    if (groupChatInitActivity.P != null && GroupChatInitActivity.this.P.size() > 0) {
                        if (arrayList.size() >= 2) {
                            try {
                                GroupChatInitActivity.this.l2(arrayList);
                            } catch (Exception unused) {
                                GroupChatInitActivity.this.hideBaseProgressBar();
                            }
                        } else {
                            Intent intent2 = new Intent();
                            if (GroupChatInitActivity.this.P.size() == 1) {
                                intent2.putExtra("group_choose_contact_forward_chatitem", (Parcelable) GroupChatInitActivity.this.P.get(0));
                            } else {
                                intent2.putExtra("group_choose_contact_forward_chatitem", (Parcelable) arrayList.get(0));
                            }
                            GroupChatInitActivity.this.setResult(-1, intent2);
                            GroupChatInitActivity.this.finish();
                        }
                    }
                } else if (groupChatInitActivity.v != null && !TextUtils.isEmpty(GroupChatInitActivity.this.v.getGroupId())) {
                    try {
                        GroupChatInitActivity groupChatInitActivity2 = GroupChatInitActivity.this;
                        groupChatInitActivity2.k2(groupChatInitActivity2.P, GroupChatInitActivity.this.v.getGroupId());
                    } catch (Exception unused2) {
                        GroupChatInitActivity.this.hideBaseProgressBar();
                    }
                } else if (arrayList.size() > 1) {
                    try {
                        GroupChatInitActivity.this.l2(arrayList);
                    } catch (Exception unused3) {
                        GroupChatInitActivity.this.hideBaseProgressBar();
                    }
                } else if (arrayList.size() == 1 && (chatItem = (ChatItem) arrayList.get(0)) != null) {
                    Intent intent3 = new Intent(GroupChatInitActivity.this, (Class<?>) ChatterActivity.class);
                    intent3.putExtra("chat_item", chatItem);
                    k86.X(intent3);
                    GroupChatInitActivity.this.startActivity(intent3);
                    GroupChatInitActivity.this.finish();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("num", arrayList.size());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "15q5", "1", null, jSONObject.toString());
            oc0.h("lx_group_select_click", new a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s implements c.d {
        public s() {
        }

        @Override // com.zenmen.palmchat.activity.search.c.d
        public void a(c.f fVar) {
            GroupChatInitActivity.this.I.setVisibility(0);
            GroupChatInitActivity.this.y.setVisibility(8);
            GroupChatInitActivity.this.C.setVisibility(8);
            GroupChatInitActivity.this.K.setVisibility(8);
            GroupChatInitActivity.this.N.clear();
            if (fVar.b != null) {
                if (GroupChatInitActivity.this.u == null || GroupChatInitActivity.this.u.getUid() == null) {
                    GroupChatInitActivity.this.N.addAll(fVar.b);
                } else {
                    for (ContactInfoItem contactInfoItem : fVar.b) {
                        if (!GroupChatInitActivity.this.u.getUid().equals(contactInfoItem.getUid())) {
                            GroupChatInitActivity.this.N.add(contactInfoItem);
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(GroupChatInitActivity.this.G.getText())) {
                GroupChatInitActivity.this.M.g(false);
            } else {
                GroupChatInitActivity.this.M.g(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements AdapterView.OnItemClickListener {
        public u() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) GroupChatInitActivity.this.N.get(i);
            if (GroupChatInitActivity.this.s == null || !(GroupChatInitActivity.this.s.contains(contactInfoItem.getUid()) || AccountUtils.p(AppContext.getContext()).equals(contactInfoItem.getUid()))) {
                GroupChatInitActivity.this.F2(contactInfoItem);
                GroupChatInitActivity.this.N.clear();
                GroupChatInitActivity.this.M.notifyDataSetChanged();
                GroupChatInitActivity.this.G.setText("");
            }
        }
    }

    public static /* synthetic */ int s2(Comparator comparator, ContactInfoItem contactInfoItem, ContactInfoItem contactInfoItem2) {
        int i2 = 0;
        int i3 = TextUtils.equals(contactInfoItem.getUid(), "-1") ? 2 : 0;
        int i4 = TextUtils.equals(contactInfoItem2.getUid(), "-1") ? 2 : 0;
        if (Math.abs(i3 - i4) == 2) {
            return i4 - i3;
        }
        String indexPinyin = contactInfoItem.getIndexPinyin(true);
        String indexPinyin2 = contactInfoItem2.getIndexPinyin(true);
        int i5 = !TextUtils.isEmpty(indexPinyin) ? Character.isLetter(indexPinyin.charAt(0)) ? 1 : 0 : -1;
        if (TextUtils.isEmpty(indexPinyin2)) {
            i2 = -1;
        } else if (Character.isLetter(indexPinyin2.charAt(0))) {
            i2 = 1;
        }
        return i5 - i2 != 0 ? i2 - i5 : comparator.compare(indexPinyin, indexPinyin2);
    }

    public static void x2(String str, Context context) {
        new sd3(context).k(str.replace("\"", "")).O(R.string.alert_dialog_ok).f(null).e().show();
    }

    public final void A2(GroupModifyResultVo groupModifyResultVo) {
        w4.C(this, groupModifyResultVo, new d());
        GroupModifyResultVo.onDialogEvent(groupModifyResultVo, "view");
    }

    public final void B2() {
        com.zenmen.palmchat.settings.cert.a.a().d(this, new c());
    }

    public final void C2(ContactInfoItem contactInfoItem) {
        if (this.j0) {
            if (this.Q.get(contactInfoItem.getUid()) != null) {
                this.Q.remove(contactInfoItem.getUid());
            } else {
                this.Q.put(contactInfoItem.getUid(), contactInfoItem);
            }
            this.P.clear();
            this.P.addAll(this.Q.values());
            return;
        }
        this.P.clear();
        this.Q.clear();
        this.P.add(contactInfoItem);
        this.Q.put(contactInfoItem.getUid(), contactInfoItem);
        this.o0.c();
    }

    public final void D2() {
        long size = this.Q.size();
        String string = getResources().getString(R.string.circle_finish);
        if (size > 0) {
            string = getResources().getString(R.string.circle_finish_number, Long.valueOf(size));
            this.k0.setVisibility(0);
            this.l0.setVisibility(0);
        } else {
            this.k0.setVisibility(8);
            this.l0.setVisibility(8);
        }
        this.F.setText(string);
        if (size > 0) {
            this.F.setEnabled(true);
        } else {
            this.F.setEnabled(false);
        }
        if (size > q0) {
            this.K.setVisibility(0);
        }
    }

    public final void E2(Cursor cursor) {
        this.O = new CopyOnWriteArrayList<>();
        if (j2() && !this.r) {
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setNickName("所有人");
            contactInfoItem.setExid("all of person");
            contactInfoItem.setUid("-1");
            this.O.add(contactInfoItem);
        }
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("name"));
            if (string != null && !string.equals(AccountUtils.p(this))) {
                this.O.add(ie2.a(cursor));
            }
        }
        ArrayList arrayList = new ArrayList(this.O);
        final Collator collator = Collator.getInstance(Locale.CHINA);
        Collections.sort(arrayList, new Comparator() { // from class: vd2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return GroupChatInitActivity.s2(collator, (ContactInfoItem) obj, (ContactInfoItem) obj2);
            }
        });
        this.O.clear();
        this.O.addAll(arrayList);
        this.z.c(this.O);
        n2(this.O);
        this.z.notifyDataSetChanged();
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void F0() {
        this.E.setVisibility(8);
    }

    public final void F2(ContactInfoItem contactInfoItem) {
        if (!fu2.b(contactInfoItem, this.m0)) {
            sy5.h(this, gu2.a().specialsendmsg_toast, 1);
            return;
        }
        if (this.r && this.Q.get(contactInfoItem.getUid()) == null && this.Q.size() >= 9) {
            sy5.f(this, "每次仅可选择送给9个人哦～", 1).g();
            return;
        }
        C2(contactInfoItem);
        D2();
        this.z.notifyDataSetChanged();
        this.o0.e(contactInfoItem);
        int size = this.P.size() - 7;
        if (this.P.size() <= size || size < 0) {
            return;
        }
        this.A.scrollTo(5000, 0);
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void P0(char c2) {
        int iIntValue;
        this.E.setText(Character.toString(c2));
        if (this.S.get(Character.valueOf(c2)) == null || (iIntValue = this.S.get(Character.valueOf(c2)).intValue()) < 0) {
            return;
        }
        this.y.setSelectionFromTop(iIntValue + 1, (int) getResources().getDimension(R.dimen.list_group_header_height));
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 113;
    }

    public final boolean j2() {
        GroupInfoItem groupInfoItem = this.v;
        if (groupInfoItem != null) {
            return groupInfoItem.getRoleType() == 1 || this.v.getRoleType() == 2;
        }
        return false;
    }

    public final void k2(ArrayList<ContactInfoItem> arrayList, String str) {
        if (arrayList.size() > q0) {
            Intent intent = new Intent();
            intent.putExtra("add_group_member_beyoud_result", true);
            setResult(-1, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent();
        intent2.putParcelableArrayListExtra("add_group_member_result", arrayList);
        intent2.putExtra("add_group_member_id_result", str);
        setResult(-1, intent2);
        finish();
    }

    public final void l2(ArrayList<ContactInfoItem> arrayList) {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        new b(arrayList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final String m2(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                ContactInfoItem contactInfoItemL = bo0.r().l(strArr[i2]);
                if (contactInfoItemL != null) {
                    sb.append(contactInfoItemL.getNameForShow());
                    if (i2 != length - 1) {
                        sb.append(getString(R.string.name_divider));
                    }
                }
            }
        }
        return sb.toString();
    }

    public final void n2(List<ContactInfoItem> list) {
        if (this.j0 && !this.X) {
            r2(list);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            char cA = eo0.a(list.get(i3).getIndexPinyin(true).charAt(0));
            if (this.S.get(Character.valueOf(cA)) == null) {
                this.S.put(Character.valueOf(cA), Integer.valueOf(i3));
            }
        }
        char c2 = 0;
        while (true) {
            char[] cArr = CharIndexView.charArray;
            if (i2 >= cArr.length) {
                return;
            }
            char c3 = cArr[i2];
            if (this.S.get(Character.valueOf(c3)) != null) {
                c2 = c3;
            } else if (c2 != 0) {
                this.S.put(Character.valueOf(c3), this.S.get(Character.valueOf(c2)));
            }
            i2++;
        }
    }

    public final void o2() {
        this.T = new h();
        this.U = new i();
        this.V = new k();
        this.W = new l();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0 && i3 == -1 && intent != null) {
            GroupInfoItem groupInfoItem = (GroupInfoItem) intent.getParcelableExtra("group_choose_contact_forward_chatitem");
            Intent intent2 = new Intent();
            intent2.putExtra("group_choose_contact_forward_chatitem", groupInfoItem);
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.q == 6) {
            setResult(2);
        }
        super.onBackPressed();
    }

    @qm5
    public void onContactChanged(fn0 fn0Var) {
        if (this.q != 8) {
            if (this.x != null) {
                this.O = new CopyOnWriteArrayList<>(this.x);
            } else {
                this.O = bo0.r().t(this.u);
            }
            n2(this.O);
            runOnUiThread(new m());
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q0 = rl0.h().j().a();
        t2();
        UI.c(this, 1, null, this);
        setContentView(R.layout.layout_activity_init_group);
        q2();
        if (this.x != null) {
            this.O = new CopyOnWriteArrayList<>(this.x);
        } else if (this.q != 8) {
            this.O = bo0.r().t(this.u);
        } else {
            List<ContactInfoItem> list = this.w;
            if (list != null && list.size() > 0) {
                CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.O = copyOnWriteArrayList;
                copyOnWriteArrayList.addAll(this.w);
            }
        }
        if (v8.h() && this.O != null) {
            ArrayList arrayList = new ArrayList();
            for (ContactInfoItem contactInfoItem : this.O) {
                if (v8.C(contactInfoItem.getUid())) {
                    arrayList.add(contactInfoItem);
                }
            }
            if (arrayList.size() > 0) {
                LogUtil.d("AiChatPeopleManagerTag", "ChatGroupInitActivity removeAll aiItems size " + arrayList.size());
                this.O.removeAll(arrayList);
            }
        }
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayList2 = this.O;
        int size = copyOnWriteArrayList2 != null ? copyOnWriteArrayList2.size() - 1 : 0;
        int[] iArr = new int[CharIndexView.charArray.length];
        this.R = iArr;
        Arrays.fill(iArr, -1);
        this.S = new HashMap<>();
        this.l0 = findViewById(R.id.vw_line);
        TextView textView = (TextView) findViewById(R.id.tv_action_button);
        this.F = textView;
        textView.setEnabled(false);
        CharIndexView charIndexView = (CharIndexView) findViewById(R.id.index_view);
        this.C = charIndexView;
        charIndexView.setOnCharacterTouchedListener(this);
        this.E = (TextView) findViewById(R.id.char_indicator);
        this.G = (EditText) findViewById(R.id.search_edit_text);
        p2();
        this.J = findViewById(R.id.sepView);
        this.L = (ImageView) findViewById(R.id.tips_close);
        this.K = findViewById(R.id.big_group_select_tips);
        this.y = (ListView) findViewById(R.id.contacts_list);
        this.L.setOnClickListener(new j());
        this.y.setOnScrollListener(new n());
        this.y.setOnItemClickListener(new o());
        this.y.addHeaderView(getLayoutInflater().inflate(R.layout.list_headerview_group_chat_contacts_header, (ViewGroup) null, false));
        this.A = (HorizontalScrollView) findViewById(R.id.scrollView);
        this.B = (LinearLayout) findViewById(R.id.scrollContentView);
        this.o0 = new com.zenmen.palmchat.groupchat.b(this, new p(), this.A, this.B);
        o2();
        this.F.setOnClickListener(new q());
        wd2 wd2Var = new wd2(this, this.y, this.G);
        this.z = wd2Var;
        this.y.setAdapter((ListAdapter) wd2Var);
        this.z.f(this.s);
        this.z.e(this.q);
        this.z.b(this.Q);
        if (this.q != 8) {
            this.z.c(this.O);
            n2(this.O);
            this.z.notifyDataSetChanged();
        }
        bo0.r().i().j(this);
        this.f0 = new com.zenmen.palmchat.activity.search.c(this.n0, false, false);
        this.k0 = findViewById(R.id.searchContainner);
        if (this.w != null) {
            for (ContactInfoItem contactInfoItem2 : this.O) {
                Iterator<ContactInfoItem> it = this.w.iterator();
                while (it.hasNext()) {
                    if (it.next().getUid().equals(contactInfoItem2.getUid())) {
                        F2(contactInfoItem2);
                    }
                }
            }
        }
        this.g0 = xn3.a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fromtype", this.q);
            jSONObject.put("frdnum", size);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HashMap map = new HashMap(1);
        map.put("fromtype", String.valueOf(this.q));
        oc0.h("lx_group_select_show", map);
        LogUtil.uploadInfoImmediate(AccountUtils.p(AppContext.getContext()), "15q4", "1", null, jSONObject.toString());
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        GroupInfoItem groupInfoItem;
        if (i2 != 1 || (groupInfoItem = this.v) == null || TextUtils.isEmpty(groupInfoItem.getGroupId())) {
            return null;
        }
        return new CursorLoader(this, je2.f18392a, null, "group_id=? and group_member_state=?", new String[]{this.v.getGroupId(), Integer.toString(0)}, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ih ihVar = this.h0;
        if (ihVar != null) {
            ihVar.onCancel();
        }
        bo0.r().i().l(this);
        this.f0.q();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.q == 6) {
            setResult(2);
        }
        finish();
        return true;
    }

    public final void p2() {
        if (this.N == null) {
            this.N = new ArrayList<>();
        }
        if (this.I == null) {
            this.I = (ListView) findViewById(R.id.search_result_list);
        }
        this.I.setChoiceMode(2);
        if (this.M == null) {
            this.M = new wd2(this, this.I, this.G);
        }
        this.M.f(this.s);
        this.M.e(this.q);
        this.I.setAdapter((ListAdapter) this.M);
        this.M.c(this.N);
        this.M.b(this.Q);
        if (this.H == null) {
            this.H = new t();
        }
        this.I.setOnItemClickListener(new u());
        this.G.addTextChangedListener(this.H);
        this.G.setOnKeyListener(new a());
    }

    public final void q2() {
        Toolbar toolbarInitToolbar = (!this.j0 || this.X || this.Y) ? initToolbar(R.string.choose_contact) : initToolbar(R.string.group_chat_init_group);
        if (this.q == 8) {
            toolbarInitToolbar = this.r ? initToolbar("选择送礼对象") : initToolbar(R.string.circle_remind_title);
        }
        setSupportActionBar(toolbarInitToolbar);
    }

    @Override // com.zenmen.palmchat.widget.CharIndexView.a
    public void r() {
        this.E.setVisibility(0);
    }

    public final void r2(List<ContactInfoItem> list) {
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setNickName(AppContext.getContext().getString(R.string.group_chat_choose_group));
        contactInfoItem.setMobile(AppContext.getContext().getString(R.string.group_chat_choose_group));
        contactInfoItem.setFirstPinyin(Constants.STRING_VALUE_UNSET);
        list.add(0, contactInfoItem);
    }

    public final void t2() {
        Intent intent = getIntent();
        this.u = (ContactInfoItem) intent.getParcelableExtra("filter_member");
        this.t = intent.getParcelableArrayListExtra("init_members");
        this.w = intent.getParcelableArrayListExtra("init_choose_contact_list");
        this.x = intent.getParcelableArrayListExtra("display_contact_list");
        ArrayList<ContactInfoItem> arrayList = this.t;
        if (arrayList != null && arrayList.size() == 1) {
            this.s.add(this.t.get(0).getUid());
        }
        this.v = (GroupInfoItem) intent.getParcelableExtra("group_info_item");
        this.X = getIntent().getBooleanExtra("group_choose_contact", false);
        this.Y = getIntent().getBooleanExtra("group_choose_contact_forward", false);
        this.q = intent.getIntExtra("from_type", 5);
        this.r = intent.getBooleanExtra("is_select_for_gift", false);
        this.j0 = intent.getBooleanExtra("extra_key_is_show_group", true);
        this.m0 = intent.getFloatExtra("extra_key_forward_intimacy_score", 0.0f);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: u2, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() != 1 || cursor == null || cursor.isClosed()) {
            return;
        }
        if (this.q == 8) {
            E2(cursor);
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(cursor.getString(cursor.getColumnIndex("name")));
        }
        if (arrayList.size() > 0) {
            this.s.clear();
            this.s.addAll(arrayList);
            if (this.s.size() > q0) {
                this.K.setVisibility(0);
            }
            this.z.notifyDataSetChanged();
        }
    }

    public final void v2(ArrayList<ContactInfoItem> arrayList, String[] strArr) {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_dialog_add_friend_content, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.count);
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_text);
        editText.addTextChangedListener(new f(editText, textView));
        new sd3(this).p(viewInflate, false).T(R.string.string_add_friend_title).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new g(strArr, arrayList, editText)).e().show();
    }

    public final void w2(ArrayList<ContactInfoItem> arrayList, String[] strArr) {
        new sd3(this).T(R.string.string_create_group_failed_title).k(getString(R.string.string_create_group_failed_content, m2(strArr))).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_send_friend_request).f(new e(arrayList, strArr)).e().show();
    }

    public final void y2() {
        sy5.e(this, R.string.send_failed, 0).g();
        LogUtil.onClickEvent("512", "2", null);
    }

    public final void z2() {
        new sd3(this).k(getString(R.string.group_select_max_dialog_text, Integer.valueOf(q0))).O(R.string.alert_dialog_ok).f(new r()).e().show();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f14240a;
        public final /* synthetic */ TextView b;

        public f(EditText editText, TextView textView) {
            this.f14240a = editText;
            this.b = textView;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = this.f14240a.getText() != null ? this.f14240a.getText().length() : 0;
            this.b.setText((50 - length) + "");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r extends MaterialDialog.e {
        public r() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements TextWatcher {
        public t() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String strQ = il5.q(charSequence.toString().toLowerCase());
            if (TextUtils.isEmpty(strQ)) {
                GroupChatInitActivity.this.I.setVisibility(8);
                GroupChatInitActivity.this.y.setVisibility(0);
                GroupChatInitActivity.this.C.setVisibility(0);
                GroupChatInitActivity.this.N.clear();
                if (GroupChatInitActivity.this.O != null) {
                    GroupChatInitActivity.this.N.addAll(GroupChatInitActivity.this.O);
                }
                GroupChatInitActivity.this.M.g(false);
                return;
            }
            if ((GroupChatInitActivity.this.q != 10 && GroupChatInitActivity.this.q != 8) || GroupChatInitActivity.this.O == null) {
                GroupChatInitActivity.this.f0.p(0, strQ);
                return;
            }
            c.f fVar = new c.f();
            ArrayList arrayList = new ArrayList();
            for (ContactInfoItem contactInfoItem : GroupChatInitActivity.this.O) {
                if (contactInfoItem.getNickName() != null && contactInfoItem.getNickName().contains(strQ.trim())) {
                    arrayList.add(contactInfoItem);
                } else if (contactInfoItem.getMobile() != null && contactInfoItem.getMobile().contains(strQ.trim())) {
                    arrayList.add(contactInfoItem);
                }
            }
            fVar.b = arrayList;
            GroupChatInitActivity.this.n0.a(fVar);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
