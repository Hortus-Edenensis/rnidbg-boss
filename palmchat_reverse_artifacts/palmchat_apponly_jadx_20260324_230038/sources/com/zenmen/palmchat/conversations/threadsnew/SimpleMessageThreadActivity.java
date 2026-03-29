package com.zenmen.palmchat.conversations.threadsnew;

import android.os.Bundle;
import android.view.MenuItem;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SimpleMessageThreadActivity extends BaseActionBarActivity {

    /* JADX INFO: compiled from: SearchBox */
    public static class SimpleMessageFragment extends MessageFragment {
        @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment
        public boolean G0() {
            return false;
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.MessageFragment
        public boolean I0() {
            return true;
        }
    }

    public final void A1() {
        setSupportActionBar(initToolbar("我的消息", true));
    }

    public final void B1() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new SimpleMessageFragment()).commit();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_simple_thread);
        A1();
        B1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
