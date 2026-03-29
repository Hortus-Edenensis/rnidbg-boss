package com.zenmen.palmchat.groupchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.circle.ui.dialog.a;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.SocialPortraitView;
import defpackage.UI;
import defpackage.a46;
import defpackage.bo0;
import defpackage.bq6;
import defpackage.fg6;
import defpackage.gr2;
import defpackage.ie2;
import defpackage.iq5;
import defpackage.je2;
import defpackage.k80;
import defpackage.l03;
import defpackage.lg2;
import defpackage.m66;
import defpackage.oc0;
import defpackage.pm2;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.zd2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupMemberListActivity extends BaseActionBarActivity implements TextWatcher, pm2<Cursor> {
    public k80 A;
    public m C;
    public HandlerThread E;
    public Handler F;
    public ListView r;
    public k t;
    public TextView u;
    public TextView v;
    public EditText w;
    public View x;
    public GroupInfoItem y;
    public l03 z;
    public boolean q = true;
    public ArrayList<ContactInfoItem> s = new ArrayList<>();
    public k.d B = new b();
    public Response.ErrorListener G = new d();
    public Response.Listener<JSONObject> H = new e();
    public Response.Listener<JSONObject> I = new h();
    public Response.ErrorListener J = new i();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14276a;

        public a(ArrayList arrayList) {
            this.f14276a = arrayList;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (!GroupMemberListActivity.this.q) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("delete_list", this.f14276a);
                GroupMemberListActivity.this.setResult(-1, intent);
                GroupMemberListActivity.this.finish();
                return;
            }
            GroupMemberListActivity.this.z = new l03(GroupMemberListActivity.this.I, GroupMemberListActivity.this.J);
            try {
                GroupMemberListActivity.this.z.n(this.f14276a, GroupMemberListActivity.this.y.getGroupId(), 0);
                GroupMemberListActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            } catch (DaoException e) {
                e.printStackTrace();
                GroupMemberListActivity.this.hideBaseProgressBar();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements k.d {
        public b() {
        }

        @Override // com.zenmen.palmchat.groupchat.GroupMemberListActivity.k.d
        public void a(ContactInfoItem contactInfoItem) {
            if (GroupMemberListActivity.this.t.b().contains(contactInfoItem.getUid())) {
                GroupMemberListActivity.this.t.b().remove(contactInfoItem.getUid());
            } else {
                GroupMemberListActivity.this.t.b().add(contactInfoItem.getUid());
            }
            GroupMemberListActivity.this.f2();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GroupMemberListActivity.this.q) {
                GroupMemberListActivity.this.S1();
            } else {
                GroupMemberListActivity groupMemberListActivity = GroupMemberListActivity.this;
                groupMemberListActivity.R1(groupMemberListActivity.t.b());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Response.ErrorListener {
        public d() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GroupMemberListActivity.this.hideBaseProgressBar();
            GroupMemberListActivity.this.d2();
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Response.Listener<JSONObject> {
        public e() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            GroupMemberListActivity.this.hideBaseProgressBar();
            if (jSONObject.optInt("resultCode") == 0) {
                sy5.e(GroupMemberListActivity.this, R.string.sent, 0).g();
                return;
            }
            String strOptString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            GroupMemberListActivity groupMemberListActivity = GroupMemberListActivity.this;
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = GroupMemberListActivity.this.getString(R.string.send_failed);
            }
            sy5.f(groupMemberListActivity, strOptString, 0).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements AdapterView.OnItemClickListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) adapterView.getItemAtPosition(i);
            if (contactInfoItem != null) {
                GroupMemberListActivity.this.T1(contactInfoItem);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements AdapterView.OnItemLongClickListener {
        public g() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) adapterView.getItemAtPosition(i);
            if (contactInfoItem == null || contactInfoItem.getUid().equals(AccountUtils.p(GroupMemberListActivity.this)) || !GroupMemberListActivity.this.q || !GroupMemberListActivity.this.y.getGroupOwner().equals(AccountUtils.p(GroupMemberListActivity.this))) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(contactInfoItem.getUid());
            GroupMemberListActivity.this.R1(arrayList);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements Response.Listener<JSONObject> {
        public h() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            GroupMemberListActivity.this.hideBaseProgressBar();
            if (iOptInt == 0) {
                iq5.j(false, new String[0]);
                GroupMemberListActivity.this.e2();
            } else {
                if (GroupMemberListActivity.this.A.d(GroupMemberListActivity.this, iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG))) {
                    return;
                }
                GroupMemberListActivity.this.d2();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Response.ErrorListener {
        public i() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            GroupMemberListActivity.this.hideBaseProgressBar();
            GroupMemberListActivity.this.d2();
            LogUtil.d(BaseActionBarActivity.TAG, volleyError.toString());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f14285a;
        public final /* synthetic */ int b;

        public j(ArrayList arrayList, int i) {
            this.f14285a = arrayList;
            this.b = i;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (!GroupMemberListActivity.this.q) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("delete_list", this.f14285a);
                intent.putExtra("delete_type", this.b);
                GroupMemberListActivity.this.setResult(-1, intent);
                GroupMemberListActivity.this.finish();
                return;
            }
            GroupMemberListActivity.this.z = new l03(GroupMemberListActivity.this.I, GroupMemberListActivity.this.J);
            try {
                GroupMemberListActivity.this.z.n(this.f14285a, GroupMemberListActivity.this.y.getGroupId(), this.b);
                GroupMemberListActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            } catch (DaoException e) {
                e.printStackTrace();
                GroupMemberListActivity.this.hideBaseProgressBar();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14286a;
        public ArrayList<String> b = new ArrayList<>();
        public d c;
        public Context d;
        public List<ContactInfoItem> e;
        public GroupInfoItem f;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Comparator<ContactInfoItem> {
            public a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ContactInfoItem contactInfoItem, ContactInfoItem contactInfoItem2) {
                int iB = zd2.b(contactInfoItem.getNickName(), "连信用户") - zd2.b(contactInfoItem2.getNickName(), "连信用户");
                return iB != 0 ? iB : contactInfoItem.getRoleType() - contactInfoItem2.getRoleType();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactInfoItem f14288a;

            public b(ContactInfoItem contactInfoItem) {
                this.f14288a = contactInfoItem;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.c != null) {
                    k.this.c.a(this.f14288a);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements Comparator<ContactInfoItem> {
            public c() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ContactInfoItem contactInfoItem, ContactInfoItem contactInfoItem2) {
                int iB = zd2.b(contactInfoItem.getNickName(), "连信用户") - zd2.b(contactInfoItem2.getNickName(), "连信用户");
                return iB != 0 ? iB : contactInfoItem.getRoleType() - contactInfoItem2.getRoleType();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface d {
            void a(ContactInfoItem contactInfoItem);
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public SocialPortraitView f14290a;
            public ViewGroup b;
            public TextView c;
            public TextView d;
            public ImageView e;

            public e() {
            }
        }

        public k(Context context, Collection<ContactInfoItem> collection, d dVar, GroupInfoItem groupInfoItem, boolean z) {
            this.f14286a = true;
            this.e = new ArrayList();
            this.d = context;
            this.f14286a = z;
            ArrayList arrayList = new ArrayList(collection);
            this.e = arrayList;
            Collections.sort(arrayList, new a());
            this.c = dVar;
            this.f = groupInfoItem;
        }

        public ArrayList<String> b() {
            return this.b;
        }

        public void c(Collection<ContactInfoItem> collection) {
            this.e.clear();
            this.e.addAll(collection);
            Collections.sort(this.e, new c());
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.e.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.e.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x014b  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i, View view, ViewGroup viewGroup) {
            e eVar;
            String str;
            if (view == null) {
                view = LayoutInflater.from(this.d).inflate(R.layout.list_item_group_member, (ViewGroup) null, false);
                eVar = new e();
                SocialPortraitView socialPortraitView = (SocialPortraitView) view.findViewById(R.id.portrait);
                eVar.f14290a = socialPortraitView;
                socialPortraitView.changeShapeType(3);
                eVar.f14290a.setDegreeForRoundRectangle(10, 10);
                eVar.c = (TextView) view.findViewById(R.id.name);
                eVar.d = (TextView) view.findViewById(R.id.role_type_tv);
                eVar.e = (ImageView) view.findViewById(R.id.iv_vip);
                eVar.b = (ViewGroup) view.findViewById(R.id.selectLayout);
                view.setTag(eVar);
            } else {
                eVar = (e) view.getTag();
            }
            ContactInfoItem contactInfoItem = this.e.get(i);
            boolean z = oc0.f() && this.f.getRoleType() == 2 && contactInfoItem.getRoleType() == 2;
            if (this.f14286a || this.f.getGroupOwner().equals(contactInfoItem.getUid()) || z) {
                eVar.b.setVisibility(8);
            } else {
                eVar.b.setVisibility(0);
                if (this.b.contains(contactInfoItem.getUid())) {
                    eVar.b.getChildAt(0).setBackgroundResource(R.drawable.ic_checkbox_green_check);
                } else {
                    eVar.b.getChildAt(0).setBackgroundResource(R.drawable.ic_checkbox_uncheck);
                }
                eVar.b.setOnClickListener(new b(contactInfoItem));
            }
            String iconURL = contactInfoItem.getIconURL();
            if (TextUtils.isEmpty(iconURL)) {
                eVar.f14290a.setImageResource(R.drawable.default_portrait);
            } else {
                gr2.j().h(iconURL, eVar.f14290a, bq6.s());
            }
            eVar.c.setText(contactInfoItem.getNameForShow());
            if (!oc0.f() || (!(this.f.getRoomType() == 1 || this.f.getRoomType() == 2) || contactInfoItem.getRoleType() == 3)) {
                eVar.d.setVisibility(8);
            } else if (contactInfoItem.getRoleType() == 2) {
                eVar.d.setText("管理员");
                eVar.d.setVisibility(0);
            } else if (contactInfoItem.getRoleType() == 1) {
                GroupInfoItem groupInfoItem = this.f;
                if (groupInfoItem == null) {
                    str = "群主";
                    eVar.d.setText(str);
                    eVar.d.setVisibility(0);
                } else {
                    if (groupInfoItem.getGroupExtTypeFromExtension() == 2) {
                        str = "族长";
                    }
                    eVar.d.setText(str);
                    eVar.d.setVisibility(0);
                }
            } else {
                eVar.d.setVisibility(8);
            }
            int iG = fg6.g(contactInfoItem.getExt());
            eVar.c.setTextColor(fg6.n(this.d, iG));
            if (fg6.q(iG)) {
                eVar.e.setVisibility(0);
                eVar.e.setImageResource(fg6.c(iG));
            } else {
                eVar.e.setVisibility(8);
            }
            eVar.c.setMaxWidth(a46.m(this.d).x - a46.b(this.d, (((eVar.e.getVisibility() == 0 ? 24 : 0) + 90) + (eVar.d.getVisibility() == 0 ? 49 : 0)) + (eVar.b.getVisibility() == 0 ? 60 : 0)));
            return view;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends Handler {
        public l(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0 || GroupMemberListActivity.this.s == null) {
                return;
            }
            String str = (String) message.obj;
            if (TextUtils.isEmpty(str)) {
                GroupMemberListActivity.this.C.sendEmptyMessage(1);
                return;
            }
            String lowerCase = str.toLowerCase();
            CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayList = new CopyOnWriteArrayList(GroupMemberListActivity.this.s);
            ArrayList arrayList = new ArrayList();
            for (ContactInfoItem contactInfoItem : copyOnWriteArrayList) {
                String nickName = contactInfoItem.getNickName();
                String allPinyin = contactInfoItem.getAllPinyin();
                String firstPinyin = contactInfoItem.getFirstPinyin();
                String remarkName = contactInfoItem.getRemarkName();
                String remarkAllPinyin = contactInfoItem.getRemarkAllPinyin();
                String remarkFirstPinyin = contactInfoItem.getRemarkFirstPinyin();
                String groupRemarkName = contactInfoItem.getGroupRemarkName();
                String account = contactInfoItem.getAccount();
                if ((!TextUtils.isEmpty(nickName) && nickName.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(groupRemarkName) && groupRemarkName.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(remarkName) && remarkName.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(allPinyin) && allPinyin.toLowerCase().startsWith(lowerCase)) || ((!TextUtils.isEmpty(firstPinyin) && firstPinyin.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(remarkFirstPinyin) && remarkFirstPinyin.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(account) && account.toLowerCase().contains(lowerCase)) || (!TextUtils.isEmpty(remarkAllPinyin) && remarkAllPinyin.toLowerCase().startsWith(lowerCase))))))))) {
                    arrayList.add(contactInfoItem);
                }
            }
            Message message2 = new Message();
            message2.what = 1;
            message2.obj = arrayList;
            GroupMemberListActivity.this.C.sendMessage(message2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<GroupMemberListActivity> f14292a;

        public m(GroupMemberListActivity groupMemberListActivity) {
            this.f14292a = new WeakReference<>(groupMemberListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1 || this.f14292a.get() == null) {
                return;
            }
            Collection<ContactInfoItem> arrayList = (List) message.obj;
            if (arrayList == null) {
                arrayList = new ArrayList<>(this.f14292a.get().s);
            }
            this.f14292a.get().t.c(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(ArrayList arrayList, int i2) {
        boolean z = i2 == 0;
        new sd3(this).j(this.q ? z ? R.string.groupmember_delete : R.string.circle_groupmember_delete : z ? R.string.groupmember_delete_multi : R.string.circle_groupmember_delete_multi).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new j(arrayList, i2)).e().show();
    }

    public final void R1(final ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (oc0.f() && (this.y.getRoomType() == 1 || this.y.getRoomType() == 2)) {
            new com.zenmen.palmchat.circle.ui.dialog.a(this, new a.InterfaceC1015a() { // from class: fe2
                @Override // com.zenmen.palmchat.circle.ui.dialog.a.InterfaceC1015a
                public final void a(int i2) {
                    this.f17518a.Z1(arrayList, i2);
                }
            }).show();
        } else {
            new sd3(this).j(this.q ? R.string.groupmember_delete : R.string.groupmember_delete_multi).K(R.string.alert_dialog_cancel).O(R.string.alert_dialog_ok).f(new a(arrayList)).e().show();
        }
    }

    public final void S1() {
        Intent intent = new Intent(this, (Class<?>) GroupChatInitActivity.class);
        ArrayList<ContactInfoItem> arrayList = this.s;
        if (arrayList != null && arrayList.size() == 1) {
            intent.putParcelableArrayListExtra("init_members", this.s);
        }
        intent.putExtra("group_info_item", this.y);
        intent.putExtra("group_choose_contact", true);
        startActivityForResult(intent, 1);
    }

    public final void T1(ContactInfoItem contactInfoItem) {
        Intent intent = new Intent(this, (Class<?>) m66.c());
        ContactInfoItem contactInfoItemM792clone = contactInfoItem.m792clone();
        intent.putExtra("group_id", this.y.getGroupId());
        intent.putExtra("group_chat_info", this.y);
        intent.putExtra("from", 6);
        contactInfoItemM792clone.setGroupRemarkName(contactInfoItem.getGroupRemarkName());
        intent.putExtra("user_item_info", contactInfoItemM792clone);
        String nickName = "";
        if (this.s != null) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                if (this.s.get(i2).getUid().equals(AccountUtils.p(this))) {
                    ContactInfoItem contactInfoItem2 = this.s.get(i2);
                    if (!TextUtils.isEmpty(contactInfoItem2.getGroupRemarkName())) {
                        nickName = contactInfoItem2.getGroupRemarkName();
                    } else if (!TextUtils.isEmpty(contactInfoItem2.getNickName())) {
                        nickName = contactInfoItem2.getNickName();
                    }
                }
            }
        }
        intent.putExtra("groupchat_name", this.y.getGroupNameDisplay(nickName));
        startActivity(intent);
    }

    public final void U1() {
        UI.c(this, 0, null, this);
    }

    public final void V1(Cursor cursor) {
        this.u.setText(getString(R.string.groupmember_title, Integer.valueOf(cursor.getCount())));
        this.s.clear();
        ArrayList arrayList = new ArrayList();
        try {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                ContactInfoItem contactInfoItemA = ie2.a(cursor);
                ContactInfoItem contactInfoItemL = bo0.r().l(contactInfoItemA.getUid());
                if (contactInfoItemL != null) {
                    contactInfoItemA.setIconURL(contactInfoItemL.getIconURL());
                    contactInfoItemA.setRemarkName(contactInfoItemL.getRemarkName());
                    contactInfoItemA.setRemarkAllPinyin(contactInfoItemL.getRemarkAllPinyin());
                    contactInfoItemA.setRemarkFirstPinyin(contactInfoItemL.getRemarkFirstPinyin());
                    contactInfoItemA.setExt(contactInfoItemL.getExt());
                }
                arrayList.add(contactInfoItemA);
            }
        } catch (Exception e2) {
            LogUtil.e(BaseActionBarActivity.TAG, e2);
        }
        this.s.addAll(arrayList);
        this.t.c(this.s);
    }

    public final void W1() {
        this.C = new m(this);
        HandlerThread handlerThreadA = lg2.a("search_thread");
        this.E = handlerThreadA;
        handlerThreadA.start();
        this.F = new l(this.E.getLooper());
    }

    public final void X1() {
        setSupportActionBar(initToolbar(-1));
        TextView textView = (TextView) findViewById(R.id.title);
        this.u = textView;
        textView.setText(R.string.media_pick_activity_title);
        TextView textView2 = (TextView) findViewById(R.id.action_button);
        this.v = textView2;
        if (this.q) {
            textView2.setEnabled(true);
            this.v.setText(R.string.groupmember_add);
            if (oc0.f() && this.y.getInviteSwitch() == 0 && this.y.getRoleType() == 3) {
                this.v.setVisibility(8);
            } else {
                this.v.setVisibility(0);
            }
        } else {
            textView2.setEnabled(false);
            this.v.setText(R.string.string_delete);
        }
        this.v.setOnClickListener(new c());
        GroupInfoItem groupInfoItem = this.y;
        if (groupInfoItem == null || groupInfoItem.getGroupExtTypeFromExtension() != 1) {
            return;
        }
        this.v.setVisibility(8);
    }

    public final void Y1() {
        this.x = findViewById(R.id.search_container);
        EditText editText = (EditText) findViewById(R.id.search_edit_text);
        this.w = editText;
        editText.addTextChangedListener(this);
        this.r = (ListView) findViewById(R.id.list);
        k kVar = new k(this, this.s, this.B, this.y, this.q);
        this.t = kVar;
        this.r.setAdapter((ListAdapter) kVar);
        this.r.setOnItemClickListener(new f());
        this.r.setOnItemLongClickListener(new g());
    }

    public final void a2(Intent intent) {
        this.q = intent.getBooleanExtra("type_add", true);
        GroupInfoItem groupInfoItem = (GroupInfoItem) intent.getParcelableExtra("groupitem");
        this.y = groupInfoItem;
        if (groupInfoItem == null) {
            finish();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        c2(editable.toString());
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() != 0 || cursor == null) {
            return;
        }
        V1(cursor);
        c2(this.w.getText().toString());
    }

    public final void c2(String str) {
        if (str != null) {
            this.F.removeMessages(0);
            Message message = new Message();
            message.what = 0;
            message.obj = str;
            this.F.sendMessage(message);
        }
    }

    public final void d2() {
        sy5.e(this, R.string.send_failed, 0).g();
    }

    public final void e2() {
        sy5.e(this, R.string.send_success, 0).g();
    }

    public final void f2() {
        int size = this.t.b().size();
        this.v.setEnabled(size > 0);
        this.v.setText(size > 0 ? getString(R.string.string_delete_count, Integer.valueOf(size)) : getString(R.string.string_delete));
        this.t.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1 && intent != null) {
            intent.putExtra("groupMemberAdd", true);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_member_list);
        a2(getIntent());
        X1();
        Y1();
        W1();
        U1();
        this.A = new k80(this.y);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i2, Bundle bundle) {
        GroupInfoItem groupInfoItem;
        if (i2 != 0 || (groupInfoItem = this.y) == null || TextUtils.isEmpty(groupInfoItem.getGroupId())) {
            return null;
        }
        return new CursorLoader(this, je2.f18392a, null, "group_id=? and group_member_state=?", new String[]{this.y.getGroupId(), Integer.toString(0)}, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        l03 l03Var = this.z;
        if (l03Var != null) {
            l03Var.onCancel();
        }
        this.E.quit();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        UI.a(this);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c2(this.w.getText().toString());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
        UI.a(this);
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
