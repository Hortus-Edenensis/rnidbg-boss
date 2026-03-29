package com.zenmen.palmchat.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.QRCodeScan.ScannerActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.search.SearchContentActivity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.groupchat.GroupChatInitActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ad1;
import defpackage.ch;
import defpackage.f46;
import defpackage.fk2;
import defpackage.ip3;
import defpackage.is0;
import defpackage.k86;
import defpackage.nl0;
import defpackage.nx3;
import defpackage.qm5;
import defpackage.tj2;
import defpackage.uk5;
import org.apache.webplatform.jssdk.ContactPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ContactActivity extends BaseActionBarActivity {
    public Toolbar q;
    public String[] r;
    public int[] s;
    public ContactsFragment t;
    public is0.f u;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uk5 f13310a;

        public a(uk5 uk5Var) {
            this.f13310a = uk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk5 uk5Var = this.f13310a;
            if (uk5Var.f21235a != 22) {
                return;
            }
            String str = uk5Var.d;
            if (ad1.j(ad1.e, str)) {
                LogUtil.i("TYPE_DIALOG_PROCESS_MSG_RECEIVED", "onStatusChanged pageIndex = " + str);
                ad1.h().m(ad1.e, ContactActivity.this);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(ContactActivity.this, (Class<?>) SearchContentActivity.class);
            k86.X(intent);
            ContactActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements is0.f {
        public c() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0) {
                ip3.c("pagemy_frd_btngroup");
                ContactActivity.this.startActivity(new Intent(AppContext.getContext(), (Class<?>) GroupChatInitActivity.class));
                return;
            }
            if (i == 1) {
                ip3.c("pagemy_frd_btnapply");
                Intent intent = new Intent(AppContext.getContext(), (Class<?>) AddContactActivity.class);
                intent.putExtra(ContactPlugin.EXTRA_KEY_FROM, "upload_contact_from_menu");
                ContactActivity.this.startActivity(intent);
                return;
            }
            if (i == 2) {
                ip3.c("pagemy_frd_btscan");
                if (com.zenmen.palmchat.videocall.c.f()) {
                    return;
                }
                ContactActivity.this.startActivity(new Intent(ContactActivity.this, (Class<?>) ScannerActivity.class));
                return;
            }
            if (i != 3) {
                return;
            }
            ip3.c("pagemy_frd_bthelp");
            if (nx3.a("key_new_feedback")) {
                nx3.e("key_new_feedback");
            }
            Intent intent2 = new Intent();
            intent2.setClass(ContactActivity.this, CordovaWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("web_url", tj2.m());
            bundle.putBoolean("web_show_right_menu", false);
            bundle.putInt("BackgroundColor", -1);
            intent2.putExtras(bundle);
            ContactActivity.this.startActivity(intent2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements fk2 {
        @Override // defpackage.fk2
        public Intent a(Context context, fk2.a aVar) {
            return new Intent(context, (Class<?>) ContactActivity.class);
        }
    }

    public ContactActivity() {
        this.r = nl0.g() ? new String[]{AppContext.getContext().getResources().getString(R.string.main_menu_group_chat), AppContext.getContext().getResources().getString(R.string.main_menu_add), AppContext.getContext().getResources().getString(R.string.main_menu_scan), AppContext.getContext().getResources().getString(R.string.main_menu_help)} : new String[]{AppContext.getContext().getResources().getString(R.string.main_menu_group_chat), AppContext.getContext().getResources().getString(R.string.main_menu_add), AppContext.getContext().getResources().getString(R.string.main_menu_scan)};
        this.s = new int[]{R.drawable.icon_menu_group, R.drawable.icon_menu_add, R.drawable.icon_menu_sys, R.drawable.icon_menu_help};
        this.u = new c();
    }

    public final void A1() {
        Toolbar toolbarInitToolbar = initToolbar("我的朋友", true);
        this.q = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void B1() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        ContactsFragment contactsFragment = new ContactsFragment();
        this.t = contactsFragment;
        fragmentTransactionBeginTransaction.add(R.id.fragment_container, contactsFragment).commit();
        findViewById(R.id.search_area).setOnClickListener(new b());
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.MYTAB;
        sPUtil.t(scene, "key_has_load_new_friend", Boolean.valueOf(this.t.J));
        sPUtil.t(scene, "key_has_load_may_known", Boolean.valueOf(this.t.K));
        ch.s().U();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 201;
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_contact);
        A1();
        B1();
        f46.k(ch.s().u(), 4, null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
        } else if (itemId == R.id.menu_more) {
            showPopupMenu(this, getWindow().getDecorView(), this.r, this.s, this.u, null);
        } else if (itemId == R.id.menu_search) {
            Intent intent = new Intent(this, (Class<?>) SearchContentActivity.class);
            k86.X(intent);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ch.s().r().l(this);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ad1.h().m(ad1.e, this);
        try {
            ch.s().r().j(this);
        } catch (Exception unused) {
        }
    }

    @qm5
    public void onStatusChanged(uk5 uk5Var) {
        LogUtil.i(BaseActionBarActivity.TAG, "onStatusChanged type =" + uk5Var.f21235a);
        runOnUiThread(new a(uk5Var));
    }
}
