package com.zenmen.palmchat.utils.ImageUtils;

import android.os.Bundle;
import com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends BaseActivityWithoutCheckAccount {
    public final ArrayList<b> q = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(c cVar);

        void b(c cVar);

        void c(c cVar);

        void d(c cVar);
    }

    public void A1(b bVar) {
        if (this.q.contains(bVar)) {
            return;
        }
        this.q.add(bVar);
    }

    public void B1(b bVar) {
        this.q.remove(bVar);
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Iterator<b> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<b> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Iterator<b> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().d(this);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Iterator<b> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements b {
        @Override // com.zenmen.palmchat.utils.ImageUtils.c.b
        public void b(c cVar) {
        }
    }
}
