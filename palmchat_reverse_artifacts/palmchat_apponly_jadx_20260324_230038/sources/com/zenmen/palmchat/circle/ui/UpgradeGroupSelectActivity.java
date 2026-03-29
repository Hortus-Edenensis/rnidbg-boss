package com.zenmen.palmchat.circle.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.ui.UpgradeGroupSelectActivity;
import com.zenmen.palmchat.circle.ui.adapter.UpgradeGroupSelectAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UpgradeGroupSelectActivity extends BaseActionBarActivity {
    public RecyclerView q;
    public TextView r;
    public EditText s;

    public final void D1() {
        Toolbar toolbarInitToolbar = initToolbar(-1);
        ((TextView) findViewById(R.id.title)).setText(R.string.circle_select_group);
        TextView textView = (TextView) findViewById(R.id.action_button);
        this.r = textView;
        textView.setText(R.string.circle_next);
        this.r.setEnabled(false);
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void E1() {
        this.q = (RecyclerView) findViewById(R.id.groupRecyclerView);
        this.s = (EditText) findViewById(R.id.search_edit_text);
        this.q.setLayoutManager(new LinearLayoutManager(this));
        this.q.setAdapter(new UpgradeGroupSelectAdapter(this));
    }

    public final void H1() {
        this.r.setOnClickListener(new View.OnClickListener() { // from class: g56
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpgradeGroupSelectActivity.F1(view);
            }
        });
        this.s.addTextChangedListener(new a());
        findViewById(R.id.toFriendLayout).setOnClickListener(new View.OnClickListener() { // from class: h56
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpgradeGroupSelectActivity.G1(view);
            }
        });
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upgrade_group_select);
        D1();
        E1();
        H1();
        C1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static /* synthetic */ void F1(View view) {
    }

    public static /* synthetic */ void G1(View view) {
    }

    public final void C1() {
    }
}
