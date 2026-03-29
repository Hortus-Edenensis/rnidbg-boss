package com.zenmen.palmchat.settings;

import android.app.Activity;
import android.content.ContentUris;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.settings.d;
import com.zenmen.palmchat.settings.d.a;
import defpackage.r75;
import j$.util.Objects;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class NotificationSoundSettingsActivity extends BaseActionBarActivity implements Runnable {
    public ListView q;
    public d r;
    public ArrayList<d.a> s = new ArrayList<>();
    public Handler t = null;
    public String u = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.a aVar = (d.a) adapterView.getItemAtPosition(i);
            NotificationSoundSettingsActivity.this.J1(i);
            r75.r(NotificationSoundSettingsActivity.this, "notify_sound_url", aVar.f15298a);
            NotificationSoundSettingsActivity.this.r.notifyDataSetChanged();
            NotificationSoundSettingsActivity.this.u = aVar.f15298a;
            NotificationSoundSettingsActivity.this.I1();
        }
    }

    public String E1() {
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this, 2);
        return actualDefaultRingtoneUri != null ? actualDefaultRingtoneUri.toString() : "";
    }

    public Ringtone F1(String str) {
        new RingtoneManager((Activity) this).setType(2);
        return RingtoneManager.getRingtone(this, Uri.parse(str));
    }

    public final void G1() {
        this.q = (ListView) findViewById(R.id.list);
        d dVar = new d(this, this.s);
        this.r = dVar;
        this.q.setAdapter((ListAdapter) dVar);
        this.q.setOnItemClickListener(new a());
        H1();
    }

    public final void H1() {
        boolean z;
        this.s.clear();
        String strI = r75.i(this, "notify_sound_url");
        String strE1 = E1();
        d dVar = this.r;
        Objects.requireNonNull(dVar);
        d.a aVar = dVar.new a();
        aVar.b = getString(R.string.settings_message_notify_sound_url_content);
        aVar.f15298a = strE1;
        if (TextUtils.isEmpty(strI) || strI.equals(strE1)) {
            aVar.c = true;
            z = true;
        } else {
            z = false;
        }
        this.s.add(aVar);
        try {
            RingtoneManager ringtoneManager = new RingtoneManager((Activity) this);
            ringtoneManager.setType(2);
            Cursor cursor = ringtoneManager.getCursor();
            if (cursor.moveToFirst()) {
                do {
                    d dVar2 = this.r;
                    Objects.requireNonNull(dVar2);
                    d.a aVar2 = dVar2.new a();
                    aVar2.b = cursor.getString(1);
                    String string = ContentUris.withAppendedId(Uri.parse(cursor.getString(2)), cursor.getLong(0)).toString();
                    aVar2.f15298a = string;
                    if (strI.equals(string) && !z) {
                        aVar2.c = true;
                        z = true;
                    }
                    this.s.add(aVar2);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.r.notifyDataSetChanged();
    }

    public final void I1() {
        this.t.removeCallbacks(this);
        this.t.postDelayed(this, 300L);
    }

    public final void J1(int i) {
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            d.a aVar = this.s.get(i2);
            if (i2 == i) {
                aVar.c = true;
            } else {
                aVar.c = false;
            }
        }
    }

    public final void initActionBar() {
        setSupportActionBar(initToolbar(R.string.settings_message_notify_sound_url));
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_sound_select_list);
        initActionBar();
        G1();
        this.t = new Handler();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        Ringtone ringtoneF1 = F1(this.u);
        if (ringtoneF1 == null || ringtoneF1.isPlaying()) {
            return;
        }
        ringtoneF1.play();
    }
}
