package com.zenmen.palmchat.activity.search;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.UI;
import defpackage.ho3;
import defpackage.k86;
import defpackage.pm2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MessageSearchResultActivity extends BaseActionBarActivity implements pm2<Cursor> {
    public String q = "";
    public ChatItem r = null;
    public String s = null;
    public MessageSearchResultAdapter t;
    public TextView u;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (MessageSearchResultActivity.this.r == null) {
                return;
            }
            Cursor cursor = MessageSearchResultActivity.this.t.getCursor();
            cursor.moveToPosition(i);
            long j2 = cursor.getLong(cursor.getColumnIndex(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE));
            long j3 = cursor.getLong(cursor.getColumnIndex("_id"));
            Intent intent = new Intent(MessageSearchResultActivity.this, (Class<?>) ChatterActivity.class);
            intent.putExtra("chat_item", MessageSearchResultActivity.this.r);
            intent.putExtra("chat_first_message", j2);
            intent.putExtra("chat_first_message_primary_id", j3);
            intent.putExtra("chat_need_back_to_main", false);
            k86.X(intent);
            MessageSearchResultActivity.this.startActivity(intent);
        }
    }

    public final void C1() {
        this.q = getIntent().getStringExtra("search_text");
        this.r = (ChatItem) getIntent().getParcelableExtra("search_relate_contact");
        this.s = getIntent().getStringExtra("search_relate_contact_string");
    }

    public final void D1() {
        initToolbar(this.r.getChatName());
    }

    public final void E1() {
        this.u = (TextView) findViewById(R.id.search_text);
        ListView listView = (ListView) findViewById(R.id.message_list);
        MessageSearchResultAdapter messageSearchResultAdapter = new MessageSearchResultAdapter(this, this.r, this.q);
        this.t = messageSearchResultAdapter;
        listView.setAdapter((ListAdapter) messageSearchResultAdapter);
        listView.setOnItemClickListener(new a());
    }

    @Override // defpackage.pm2
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            this.t.swapCursor(cursor);
        }
        TextView textView = this.u;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(cursor == null ? 0 : cursor.getCount());
        sb.append(getString(R.string.message_search_result_list_header_1, objArr));
        sb.append(getString(R.string.message_search_result_list_header_2, this.q));
        textView.setText(sb.toString());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_search_message_content);
        C1();
        D1();
        E1();
        UI.c(this, 0, null, this);
    }

    @Override // defpackage.pm2
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String str;
        String[] strArr;
        if (i != 0) {
            return null;
        }
        if (this.r.getChatType() == 0) {
            str = "contact_relate=? and message like ?";
            strArr = new String[]{DomainHelper.a(this.r, false), "%" + this.q + "%"};
        } else if (this.r.getChatType() == 1) {
            boolean zC = com.zenmen.palmchat.database.a.c();
            String str2 = "contact_relate" + com.zenmen.palmchat.database.a.b(zC) + " and message like ?";
            strArr = new String[]{DomainHelper.e(this.r) + com.zenmen.palmchat.database.a.a(zC), "%" + this.q + "%"};
            str = str2;
        } else {
            str = null;
            strArr = null;
        }
        return new CursorLoader(this, DBUriManager.b(ho3.class, this.r), null, str, strArr, "_id DESC");
    }

    @Override // defpackage.pm2
    public void onLoaderReset(Loader<Cursor> loader) {
        this.t.changeCursor(null);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
