package com.zenmen.palmchat.groupchat;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bt;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.UI;
import defpackage.ee2;
import defpackage.f25;
import defpackage.iq5;
import defpackage.je2;
import defpackage.lg2;
import defpackage.pm2;
import defpackage.sy5;
import defpackage.td3;
import defpackage.ve2;
import defpackage.ye2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupListActivity extends BaseActionBarActivity implements pm2<Cursor> {
    public LinearLayout G;
    public g H;
    public HandlerThread I;
    public h J;
    public TextView q;
    public LinearLayout r;
    public TextView s;
    public ListView t;
    public ee2 u;
    public ListView v;
    public ve2 w;
    public View x;
    public ClearEditText y;
    public f25 z;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean E = false;
    public TextWatcher F = new a();
    public Map<String, GroupInfoItem> K = new HashMap();
    public AdapterView.OnItemClickListener L = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            GroupListActivity.this.y.clearFocus();
            ((InputMethodManager) GroupListActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(GroupListActivity.this.y.getWindowToken(), 0);
            GroupInfoItem groupInfoItem = (GroupInfoItem) adapterView.getAdapter().getItem(i);
            if (groupInfoItem != null) {
                if (GroupListActivity.this.B) {
                    Intent intent = new Intent();
                    intent.putExtra("group_choose_contact_forward_chatitem", groupInfoItem);
                    GroupListActivity.this.setResult(-1, intent);
                } else {
                    Intent intent2 = new Intent(GroupListActivity.this, (Class<?>) ChatterActivity.class);
                    intent2.putExtra("fromType", 9);
                    intent2.putExtra("chat_item", groupInfoItem);
                    GroupListActivity.this.startActivity(intent2);
                }
                GroupListActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemLongClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            GroupInfoItem groupInfoItem;
            if (!GroupListActivity.this.C || (groupInfoItem = (GroupInfoItem) adapterView.getItemAtPosition(i)) == null) {
                return false;
            }
            GroupListActivity.this.Y1(groupInfoItem);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupListActivity.this.y.setText("");
            ((InputMethodManager) GroupListActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(GroupListActivity.this.y.getWindowToken(), 0);
            GroupListActivity.this.getToolbar().removeView(GroupListActivity.this.x);
            GroupListActivity.this.E = false;
            GroupListActivity.this.invalidateOptionsMenu();
            GroupListActivity.this.v.setVisibility(8);
            GroupListActivity.this.getToolbar().setNavigationIcon(R.drawable.selector_arrow_back);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements td3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupInfoItem f14271a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Response.Listener<JSONObject> {
            public a() {
            }

            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(JSONObject jSONObject) {
                GroupListActivity.this.hideBaseProgressBar();
                int iOptInt = jSONObject.optInt("resultCode");
                GroupListActivity.this.hideBaseProgressBar();
                if (iOptInt == 0) {
                    iq5.j(false, new String[0]);
                }
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b implements Response.ErrorListener {
            public b() {
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                GroupListActivity.this.hideBaseProgressBar();
                GroupListActivity.this.X1();
            }
        }

        public f(GroupInfoItem groupInfoItem) {
            this.f14271a = groupInfoItem;
        }

        @Override // td3.f
        public void a(td3 td3Var, int i, CharSequence charSequence) {
            if (GroupListActivity.this.z == null) {
                GroupListActivity.this.z = new f25(new a(), new b());
            }
            try {
                GroupListActivity.this.z.n(this.f14271a.getGroupId(), 0);
                GroupListActivity.this.showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            } catch (DaoException e) {
                e.printStackTrace();
                GroupListActivity.this.hideBaseProgressBar();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends Handler {
        public g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                Map mapW1 = GroupListActivity.this.W1((String) message.obj);
                Message message2 = new Message();
                message2.what = 1;
                message2.obj = mapW1;
                GroupListActivity.this.J.sendMessage(message2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<GroupListActivity> f14275a;

        public h(GroupListActivity groupListActivity) {
            this.f14275a = new WeakReference<>(groupListActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1 || this.f14275a.get() == null) {
                return;
            }
            Map map = (Map) message.obj;
            this.f14275a.get().w.a(map != null ? map.values() : null);
            this.f14275a.get().v.setVisibility(0);
            this.f14275a.get().t.setVisibility(8);
            this.f14275a.get().r.setVisibility(8);
            this.f14275a.get().s.setVisibility(8);
        }
    }

    public final void T1() {
        Toolbar toolbarInitToolbar = this.A ? initToolbar(R.string.choose_group_chat) : initToolbar(R.string.group_chat_title);
        toolbarInitToolbar.setBackgroundResource(R.color.color_FFFFFF);
        toolbarInitToolbar.setNavigationIcon(R.drawable.selector_arrow_back);
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void U1() {
        this.B = getIntent().getBooleanExtra("extra_choose_forward", false);
        this.A = getIntent().getBooleanExtra("extra_choose", false);
        this.C = getIntent().getBooleanExtra("extra_save", false);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() != 1 || cursor == null) {
            return;
        }
        int count = cursor.getCount();
        this.G.setVisibility(count == 0 ? 0 : 8);
        this.r.setVisibility(count == 0 ? 8 : 0);
        this.s.setVisibility(count == 0 ? 8 : 0);
        if (count == 1) {
            this.s.setText(getString(R.string.group_count_text, Integer.valueOf(count)));
        } else if (count > 1) {
            this.s.setText(getString(R.string.multi_group_count_text, Integer.valueOf(count)));
        }
        while (cursor.moveToNext()) {
            GroupInfoItem itemFromCursor = GroupInfoItem.getItemFromCursor(cursor, (ChatItem) null);
            this.K.put(itemFromCursor.getGroupId(), itemFromCursor);
        }
        this.u.swapCursor(cursor);
        if (getIntent().getBooleanExtra("group_entry", false)) {
            this.r.setVisibility(8);
            this.s.setVisibility(8);
        }
    }

    public final Map<String, GroupInfoItem> W1(String str) {
        if (TextUtils.isEmpty(str) || this.K.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        String[] strArr = {"group_id"};
        StringBuilder sb = new StringBuilder();
        sb.append("group_id");
        sb.append(" in (");
        for (String str2 : this.K.keySet()) {
            sb.append("\"");
            sb.append(str2);
            sb.append("\",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(") and ");
        String string = sb.toString();
        sb.append("name");
        sb.append(" like \"%");
        sb.append(str);
        sb.append("%\"");
        Cursor cursorQuery = getContentResolver().query(DBUriManager.a(ye2.class, 0), strArr, sb.toString(), null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                String string2 = cursorQuery.getString(0);
                map.put(string2, this.K.get(string2));
            }
            cursorQuery.close();
        }
        Cursor cursorQuery2 = getContentResolver().query(je2.f18392a, strArr, string + "group_member_state" + ContainerUtils.KEY_VALUE_DELIMITER + "0 and (remark_name like \"%" + str + "%\" or remark_name_all_pinyin like \"" + str + "%\" or remark_name_first_pinyin like \"" + str + "%\" or nick_name like \"%" + str + "%\" or nick_name_all_pinyin like \"" + str + "%\" or nick_name_first_pinyin like \"" + str + "%\" or " + bt.s + " like \"%" + str + "%\" or extra_data1 like \"" + str + "%\")", null, null);
        if (cursorQuery2 != null) {
            while (cursorQuery2.moveToNext()) {
                String string3 = cursorQuery2.getString(0);
                if (!map.containsKey(string3)) {
                    map.put(string3, this.K.get(string3));
                }
            }
            cursorQuery2.close();
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public final void X1() {
        sy5.e(this, R.string.send_failed, 0).g();
    }

    public final void Y1(GroupInfoItem groupInfoItem) {
        new td3.c(this).c(new String[]{getString(R.string.string_remove_group_chat)}).d(new f(groupInfoItem)).b(new e()).a().b();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        U1();
        setContentView(R.layout.layout_activity_group_list);
        T1();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lyt_group_text);
        this.r = linearLayout;
        if (this.A) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
        this.q = (TextView) findViewById(R.id.tip_text);
        this.G = (LinearLayout) findViewById(R.id.lin_empty);
        this.s = (TextView) findViewById(R.id.group_count);
        this.t = (ListView) findViewById(R.id.group_list);
        ee2 ee2Var = new ee2(this, null, 2, this.A);
        this.u = ee2Var;
        this.t.setAdapter((ListAdapter) ee2Var);
        this.t.setOnItemClickListener(this.L);
        this.t.setOnItemLongClickListener(new c());
        this.v = (ListView) findViewById(R.id.search_result_list);
        ve2 ve2Var = new ve2(this);
        this.w = ve2Var;
        this.v.setAdapter((ListAdapter) ve2Var);
        this.v.setOnItemClickListener(this.L);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_search, (ViewGroup) null);
        this.x = viewInflate;
        viewInflate.setLayoutParams(new Toolbar.LayoutParams(-1, -2));
        ClearEditText clearEditText = (ClearEditText) this.x.findViewById(R.id.search);
        this.y = clearEditText;
        clearEditText.setClearDrawable(R.drawable.clear_search, R.drawable.clear_search);
        this.y.addTextChangedListener(this.F);
        this.x.findViewById(R.id.cancel_search).setOnClickListener(new d());
        this.J = new h(this);
        HandlerThread handlerThreadA = lg2.a(BaseConstants.MARKET_URI_AUTHORITY_SEARCH);
        this.I = handlerThreadA;
        handlerThreadA.start();
        this.H = new g(this.I.getLooper());
        UI.c(this, 1, null, this);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] strArr;
        String str;
        if (i != 1) {
            return null;
        }
        if (this.C) {
            strArr = new String[]{Integer.toString(0), String.valueOf(1)};
            str = "group_state=? and type=?";
        } else {
            strArr = new String[]{Integer.toString(0)};
            str = "group_state=?";
        }
        String str2 = str;
        return new CursorLoader(this, DBUriManager.a(ye2.class, 0), null, str2, strArr, null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.A || this.E) {
            return super.onCreateOptionsMenu(menu);
        }
        getMenuInflater().inflate(R.menu.menu_group_chat_list, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        f25 f25Var = this.z;
        if (f25Var != null) {
            f25Var.onCancel();
        }
        this.I.quit();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.E) {
            return super.onKeyUp(i, keyEvent);
        }
        this.y.setText("");
        getToolbar().removeView(this.x);
        this.E = false;
        invalidateOptionsMenu();
        this.v.setVisibility(8);
        return true;
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
        this.u.swapCursor(null);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (this.E) {
                this.y.setText("");
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.y.getWindowToken(), 0);
                getToolbar().removeView(this.x);
                this.E = false;
                invalidateOptionsMenu();
                this.v.setVisibility(8);
                getToolbar().setNavigationIcon(R.drawable.selector_arrow_back);
            } else {
                finish();
            }
            return true;
        }
        if (itemId == R.id.menu_add) {
            startActivity(new Intent(this, (Class<?>) GroupChatInitActivity.class));
            return true;
        }
        if (itemId != R.id.menu_search) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.E = true;
        invalidateOptionsMenu();
        getToolbar().removeView(this.x);
        getToolbar().addView(this.x);
        getToolbar().setNavigationIcon((Drawable) null);
        KeyboardKt.a(this.y, this, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements td3.e {
        public e() {
        }

        @Override // td3.e
        public void a(td3 td3Var) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            GroupListActivity.this.H.removeMessages(0);
            if (GroupListActivity.this.u.getCount() == 0) {
                return;
            }
            if (TextUtils.isEmpty(editable) || GroupListActivity.this.K.isEmpty()) {
                GroupListActivity.this.v.setVisibility(8);
                GroupListActivity.this.t.setVisibility(0);
                GroupListActivity.this.r.setVisibility(0);
                GroupListActivity.this.s.setVisibility(0);
                return;
            }
            Message message = new Message();
            message.what = 0;
            message.obj = editable.toString();
            GroupListActivity.this.H.sendMessage(message);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
