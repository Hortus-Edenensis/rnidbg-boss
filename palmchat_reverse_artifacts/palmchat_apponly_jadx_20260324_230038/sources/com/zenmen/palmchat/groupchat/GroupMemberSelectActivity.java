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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.widget.ClearEditText;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;
import defpackage.UI;
import defpackage.bq6;
import defpackage.gr2;
import defpackage.ie2;
import defpackage.je2;
import defpackage.lg2;
import defpackage.pm2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupMemberSelectActivity extends BaseActionBarActivity implements TextWatcher, pm2<Cursor> {
    public HandlerThread A;
    public Handler B;
    public ListView q;
    public d r;
    public TextView t;
    public ClearEditText u;
    public ImageView v;
    public String x;
    public InputMethodManager y;
    public f z;
    public Map<String, ContactInfoItem> s = new HashMap();
    public boolean w = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupMemberSelectActivity.this.J1(true);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupMemberSelectActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactInfoItem contactInfoItem = (ContactInfoItem) adapterView.getItemAtPosition(i);
            if (contactInfoItem != null) {
                String uid = contactInfoItem.getUid();
                Intent intent = new Intent();
                intent.putExtra("selected_item", uid);
                GroupMemberSelectActivity.this.setResult(-1, intent);
            }
            GroupMemberSelectActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f14296a;
        public List<ContactInfoItem> b;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public ImageView f14297a;
            public TextView b;

            public a() {
            }
        }

        public d(Context context, Collection<ContactInfoItem> collection) {
            this.f14296a = context;
            this.b = new ArrayList(collection);
        }

        public void a(Collection<ContactInfoItem> collection) {
            this.b.clear();
            this.b.addAll(collection);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f14296a).inflate(R.layout.list_item_group_member_name, (ViewGroup) null, false);
                aVar = new a();
                aVar.f14297a = (ImageView) view.findViewById(R.id.portrait);
                aVar.b = (TextView) view.findViewById(R.id.name);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            ContactInfoItem contactInfoItem = this.b.get(i);
            String iconURL = contactInfoItem.getIconURL();
            if (TextUtils.isEmpty(iconURL)) {
                aVar.f14297a.setImageResource(R.drawable.default_portrait);
            } else {
                gr2.j().h(iconURL, aVar.f14297a, bq6.s());
            }
            aVar.b.setText(contactInfoItem.getNameForShow());
            return view;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0 || GroupMemberSelectActivity.this.s == null) {
                return;
            }
            String str = (String) message.obj;
            if (TextUtils.isEmpty(str)) {
                GroupMemberSelectActivity.this.z.sendEmptyMessage(1);
                return;
            }
            String lowerCase = str.toLowerCase();
            Collection<ContactInfoItem> collectionValues = GroupMemberSelectActivity.this.s.values();
            ArrayList arrayList = new ArrayList();
            for (ContactInfoItem contactInfoItem : collectionValues) {
                String nickName = contactInfoItem.getNickName();
                String allPinyin = contactInfoItem.getAllPinyin();
                String firstPinyin = contactInfoItem.getFirstPinyin();
                String remarkName = contactInfoItem.getRemarkName();
                String remarkAllPinyin = contactInfoItem.getRemarkAllPinyin();
                String remarkFirstPinyin = contactInfoItem.getRemarkFirstPinyin();
                String groupRemarkName = contactInfoItem.getGroupRemarkName();
                if ((!TextUtils.isEmpty(nickName) && nickName.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(groupRemarkName) && groupRemarkName.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(remarkName) && remarkName.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(allPinyin) && allPinyin.toLowerCase().startsWith(lowerCase)) || ((!TextUtils.isEmpty(firstPinyin) && firstPinyin.toLowerCase().contains(lowerCase)) || ((!TextUtils.isEmpty(remarkFirstPinyin) && remarkFirstPinyin.toLowerCase().contains(lowerCase)) || (!TextUtils.isEmpty(remarkAllPinyin) && remarkAllPinyin.toLowerCase().startsWith(lowerCase)))))))) {
                    arrayList.add(contactInfoItem);
                }
            }
            Message message2 = new Message();
            message2.what = 1;
            message2.obj = arrayList;
            GroupMemberSelectActivity.this.z.sendMessage(message2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<GroupMemberSelectActivity> f14299a;

        public f(GroupMemberSelectActivity groupMemberSelectActivity) {
            this.f14299a = new WeakReference<>(groupMemberSelectActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1 || this.f14299a.get() == null) {
                return;
            }
            Collection<ContactInfoItem> arrayList = (List) message.obj;
            if (arrayList == null) {
                arrayList = new ArrayList<>((Collection<? extends ContactInfoItem>) this.f14299a.get().s.values());
            }
            this.f14299a.get().r.a(arrayList);
        }
    }

    public final void D1() {
        UI.c(this, 1, null, this);
    }

    public final void E1() {
        this.z = new f(this);
        HandlerThread handlerThreadA = lg2.a("search_thread");
        this.A = handlerThreadA;
        handlerThreadA.start();
        this.B = new e(this.A.getLooper());
    }

    public final void F1() {
        setSupportActionBar(initToolbar(-1, false));
        TextView textView = (TextView) findViewById(R.id.title);
        this.t = textView;
        textView.setText(R.string.title_choose_group_member);
        ClearEditText clearEditText = (ClearEditText) findViewById(R.id.searchInput);
        this.u = clearEditText;
        clearEditText.setClearDrawable(R.drawable.clear_search, R.drawable.clear_search);
        this.u.addTextChangedListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.searchIcon);
        this.v = imageView;
        imageView.setOnClickListener(new a());
        this.t.setVisibility(8);
        this.v.setVisibility(8);
        findViewById(R.id.cancel_search).setOnClickListener(new b());
    }

    public final void G1() {
        this.q = (ListView) findViewById(R.id.list);
        d dVar = new d(this, this.s.values());
        this.r = dVar;
        this.q.setAdapter((ListAdapter) dVar);
        this.q.setOnItemClickListener(new c());
        this.y = (InputMethodManager) getSystemService("input_method");
    }

    public final void H1(Intent intent) {
        this.x = intent.getStringExtra("group_id");
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader == null || loader.getId() != 1 || cursor == null) {
            return;
        }
        K1(cursor);
    }

    public final void J1(boolean z) {
        this.w = z;
        this.t.setVisibility(z ? 8 : 0);
        this.v.setVisibility(z ? 8 : 0);
        this.u.setVisibility(z ? 0 : 8);
        if (z) {
            KeyboardKt.d(this.u, this.y, Keyboard$SHOW_FLAG.DEFAULT, 0L);
        }
    }

    public final void K1(Cursor cursor) {
        this.s.clear();
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("name"));
            if (string != null && !string.equals(AccountUtils.p(this))) {
                ContactInfoItem contactInfoItemA = ie2.a(cursor);
                this.s.put(contactInfoItemA.getUid(), contactInfoItemA);
            }
        }
        this.r.a(this.s.values());
        this.r.notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.B.removeMessages(0);
        Message message = new Message();
        message.what = 0;
        message.obj = editable.toString();
        this.B.sendMessage(message);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_group_member_select);
        H1(getIntent());
        F1();
        G1();
        E1();
        D1();
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        if (i != 1) {
            return null;
        }
        return new CursorLoader(this, je2.f18392a, null, "group_id=? and group_member_state=?", new String[]{this.x, Integer.toString(0)}, null);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.A.quit();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.w) {
            return super.onKeyUp(i, keyEvent);
        }
        J1(false);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == R.id.menu_search) {
                J1(true);
            }
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.w) {
            this.y.hideSoftInputFromWindow(this.u.getWindowToken(), 0);
            J1(false);
        } else {
            finish();
        }
        return true;
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
