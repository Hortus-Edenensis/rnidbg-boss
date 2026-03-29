package com.zenmen.palmchat.peoplenearby;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.conversations.ThreadsAdapter;
import com.zenmen.palmchat.conversations.threadgroup.ThreadFolderManager;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.UI;
import defpackage.dx5;
import defpackage.mo5;
import defpackage.nw5;
import defpackage.pm2;
import defpackage.td3;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GreetingsThreadsActivity extends BaseActionBarActivity implements pm2<Cursor> {
    public int q = 10001;
    public boolean r = false;
    public Toolbar s;
    public TextView t;
    public ListView u;
    public ThreadsAdapter v;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GreetingsThreadsActivity.this.q == 10001) {
                Intent intent = new Intent();
                intent.setClass(GreetingsThreadsActivity.this, MainTabsActivity.class);
                intent.putExtra("new_intent_position", "tab_discover");
                GreetingsThreadsActivity.this.startActivity(intent);
                GreetingsThreadsActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ThreadChatItem cursor;
            ChatItem chatItemConvert2ContactOrGroupChatInfo;
            Cursor cursor2 = (Cursor) adapterView.getItemAtPosition(i);
            if (cursor2 == null || (chatItemConvert2ContactOrGroupChatInfo = (cursor = ThreadChatItem.parseCursor(cursor2)).convert2ContactOrGroupChatInfo()) == null) {
                return;
            }
            Intent intent = new Intent(GreetingsThreadsActivity.this, (Class<?>) ChatterActivity.class);
            intent.putExtra("thread_biz_type", cursor.getBizType());
            intent.putExtra("chat_need_back_to_main", false);
            intent.putExtra("chat_back_to_greet", false);
            intent.putExtra("chat_item", chatItemConvert2ContactOrGroupChatInfo);
            intent.putExtra("chat_draft", cursor2.getString(cursor2.getColumnIndex("thread_draft")));
            GreetingsThreadsActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements AdapterView.OnItemLongClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements td3.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThreadChatItem f14936a;

            public a(ThreadChatItem threadChatItem) {
                this.f14936a = threadChatItem;
            }

            @Override // td3.f
            public void a(td3 td3Var, int i, CharSequence charSequence) {
                if (TextUtils.isEmpty(this.f14936a.getChatId())) {
                    return;
                }
                com.zenmen.palmchat.database.b.j(this.f14936a);
                nw5.d(DomainHelper.l(this.f14936a));
            }
        }

        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            Cursor cursor = (Cursor) adapterView.getItemAtPosition(i);
            if (cursor == null) {
                return true;
            }
            new td3.c(GreetingsThreadsActivity.this).c(new String[]{GreetingsThreadsActivity.this.getString(R.string.menu_dialog_item_delete)}).d(new a(ThreadChatItem.parseCursor(cursor))).a().b();
            return true;
        }
    }

    public final void B1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        this.s = toolbarInitToolbar;
        TextView textView = (TextView) toolbarInitToolbar.findViewById(R.id.title);
        this.t = textView;
        int i = this.q;
        if (i == 10001) {
            textView.setText(getString(R.string.greetings_group_title));
        } else if (i == 10005) {
            textView.setText(mo5.a());
        }
        setSupportActionBar(this.s);
        TextView textView2 = (TextView) this.s.findViewById(R.id.action_button);
        if (this.q == 10001) {
            textView2.setText(R.string.tab_find_friend);
        }
        textView2.setOnClickListener(new a());
    }

    public final void C1() {
        this.u = (ListView) findViewById(R.id.threads_list);
        ThreadsAdapter threadsAdapter = new ThreadsAdapter(this);
        this.v = threadsAdapter;
        this.u.setAdapter((ListAdapter) threadsAdapter);
        ((TextView) findViewById(R.id.tv_empty)).setVisibility(8);
        if (this.q == 10005) {
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_head_view_thread_list_square_greetings, (ViewGroup) null, false);
            ((TextView) viewInflate.findViewById(R.id.tv_tips)).setText(mo5.c());
            this.u.addHeaderView(viewInflate);
        }
        this.u.setOnItemClickListener(new b());
        this.u.setOnItemLongClickListener(new c());
        if (!this.r) {
            findViewById(R.id.action_button).setVisibility(8);
        }
        UI.c(this, 1, null, this);
    }

    public final void D1() {
        this.q = getIntent().getIntExtra("group_type", 10001);
        this.r = getIntent().getBooleanExtra("show_action_btn", true);
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (loader.getId() != 1 || cursor == null) {
            return;
        }
        if (this.q == 10001) {
            this.t.setText(getString(R.string.people_greetings, Integer.valueOf(cursor.getCount())));
        }
        this.v.swapCursor(cursor);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        D1();
        setContentView(R.layout.activity_greetings_threads);
        B1();
        C1();
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        if (i != 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        sb.append("thread_active");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        sb.append("thread_blacklist");
        sb.append("=? and ");
        arrayList.add(String.valueOf(0));
        sb.append("thread_contact_ready");
        sb.append("=? and ");
        arrayList.add(String.valueOf(1));
        ThreadFolderManager.b(sb, arrayList, this.q, false);
        return new CursorLoader(this, dx5.f17178a, null, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "thread_priority DESC , thread_draft_time DESC , latest_message_time_stamp DESC");
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
        this.v.changeCursor(null);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
