package com.zenmen.palmchat.circle.ui;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.ui.adapter.MyCircleListAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MyCircleListActivity extends BaseActionBarActivity {
    public RecyclerView q;
    public RecyclerView r;

    public final void B1() {
        setSupportActionBar(initToolbar(R.string.group_chat_title));
    }

    public final void C1() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.circleRecyclerView);
        this.q = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.r = (RecyclerView) findViewById(R.id.searchResultRecyclerView);
        this.q.setAdapter(new MyCircleListAdapter(this));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_circle_list);
        B1();
        C1();
        D1();
        A1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public final void A1() {
    }

    public final void D1() {
    }
}
