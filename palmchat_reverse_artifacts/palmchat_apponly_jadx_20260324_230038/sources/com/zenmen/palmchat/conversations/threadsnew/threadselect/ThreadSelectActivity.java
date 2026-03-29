package com.zenmen.palmchat.conversations.threadsnew.threadselect;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ThreadChatItem;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.conversations.threadsnew.threadselect.ThreadSelectFragment;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.zn6;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadSelectActivity extends BaseActionBarActivity {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ThreadSelectFragment.b {

        /* JADX INFO: renamed from: com.zenmen.palmchat.conversations.threadsnew.threadselect.ThreadSelectActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1043a extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThreadChatItem f13869a;

            public C1043a(ThreadChatItem threadChatItem) {
                this.f13869a = threadChatItem;
                put("target_uid", threadChatItem.getChatId());
            }
        }

        public a() {
        }

        @Override // com.zenmen.palmchat.conversations.threadsnew.threadselect.ThreadSelectFragment.b
        public void a(ThreadChatItem threadChatItem) {
            LogUtil.i("ContactSelectPlugin", "onSelect = " + threadChatItem);
            zn6.j("amulet_buypage_choose", "click", new C1043a(threadChatItem));
            Intent intent = new Intent();
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(threadChatItem.getChatId());
            contactInfoItem.setBizType(threadChatItem.getBizType());
            contactInfoItem.setNickName(threadChatItem.getChatName());
            intent.putExtra("KEY", contactInfoItem);
            ThreadSelectActivity.this.setResult(-1, intent);
            ThreadSelectActivity.this.finish();
        }
    }

    public final void A1() {
        Toolbar toolbarInitToolbar = initToolbar("最近聊天", true);
        this.mToolbar = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void B1() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        ThreadSelectFragment threadSelectFragment = new ThreadSelectFragment();
        threadSelectFragment.W(new a());
        fragmentTransactionBeginTransaction.add(R.id.fragment_container, threadSelectFragment).commit();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_thread_selector);
        A1();
        B1();
        zn6.c("amulet_buypage_choose", "view");
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
