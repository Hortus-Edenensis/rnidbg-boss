package com.zenmen.palmchat.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.tools.SQLiteRecoveryActivity;
import com.zenmen.palmchat.utils.SAppUtil;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.eq3;
import defpackage.fg6;
import defpackage.iq5;
import defpackage.k86;
import defpackage.nw5;
import defpackage.q05;
import defpackage.sd3;
import defpackage.yg4;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ChatSettingsActivity extends BaseActionBarActivity {
    public int q = 0;
    public CompoundButton.OnCheckedChangeListener r = new a();
    public Response.Listener<JSONObject> s = new b();
    public Response.ErrorListener t = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ChatSettingsActivity.this.K1(z, 33554432);
            HashMap map = new HashMap();
            map.put("privacyConfig", Integer.valueOf(ChatSettingsActivity.this.q));
            try {
                new eq3(ChatSettingsActivity.this.s, ChatSettingsActivity.this.t).n(map);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.Listener<JSONObject> {
        public b() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            iq5.j(false, new String[0]);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppContext.getContext().getTrayPreferences().i("receiver_mode", z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                super.onPositive(materialDialog);
                com.zenmen.palmchat.database.b.g();
                nw5.b();
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(ChatSettingsActivity.this).j(R.string.string_clear_content).O(R.string.string_clear).K(R.string.dialog_cancel).f(new a()).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements CompoundButton.OnCheckedChangeListener {
        public f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object c(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("谁看过我通知切换前: CheckBox状态=");
            sb.append(z);
            sb.append(", 保存值=");
            sb.append(!z);
            sb.append(", mPrivacyConfig=");
            sb.append(ChatSettingsActivity.this.q);
            sb.append(", 二进制=");
            sb.append(Integer.toBinaryString(ChatSettingsActivity.this.q));
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object d() {
            return "谁看过我通知切换后: mPrivacyConfig=" + ChatSettingsActivity.this.q + ", 二进制=" + Integer.toBinaryString(ChatSettingsActivity.this.q);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
            b05.c(new b05.a() { // from class: j40
                @Override // b05.a
                public final Object getValue() {
                    return this.f18326a.c(z);
                }
            });
            ChatSettingsActivity.this.K1(!z, 268435456);
            b05.c(new b05.a() { // from class: k40
                @Override // b05.a
                public final Object getValue() {
                    return this.f18569a.d();
                }
            });
            boolean zJ = fg6.j(ChatSettingsActivity.this.sInstance);
            HashMap map = new HashMap();
            map.put("change_type", z ? "1" : "0");
            map.put("vip_status", Integer.valueOf(zJ ? 1 : 0));
            q05.a("setting_chat_seeme", 2, map);
            HashMap map2 = new HashMap();
            map2.put("privacyConfig", Integer.valueOf(ChatSettingsActivity.this.q));
            try {
                new eq3(ChatSettingsActivity.this.s, ChatSettingsActivity.this.t).n(map2);
            } catch (DaoException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (zJ || !z) {
                return;
            }
            SAppUtil.K(ChatSettingsActivity.this.sInstance, "zenxin://activity?page=a0052&pkgId=wseem&urlExtra=?from=605");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I1(View view) {
        LogUtil.uploadInfoImmediate("chat001-cli", null);
        startActivity(new Intent(this, (Class<?>) SQLiteRecoveryActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object J1(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("谁看过我通知初始值: whoViewedMeCheck=");
        sb.append(z);
        sb.append(", 设置CheckBox为=");
        sb.append(!z);
        sb.append(", mPrivacyConfig=");
        sb.append(this.q);
        sb.append(", 二进制=");
        sb.append(Integer.toBinaryString(this.q));
        return sb.toString();
    }

    public final boolean G1(int i) {
        return yg4.a(this.q, i);
    }

    public final void H1() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.receiver_mode_checkbox);
        checkBox.setChecked(AppContext.getContext().getTrayPreferences().a("receiver_mode", false));
        checkBox.setOnCheckedChangeListener(new d());
        findViewById(R.id.setting_clear_messages).setOnClickListener(new e());
        findViewById(R.id.setting_database_recovery).setOnClickListener(new View.OnClickListener() { // from class: h40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17867a.I1(view);
            }
        });
        LogUtil.uploadInfoImmediate("chat001-show", null);
        findViewById(R.id.ai_quick_match_Layout);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.ai_quick_match);
        checkBox2.setChecked(G1(33554432));
        checkBox2.setOnCheckedChangeListener(this.r);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.who_viewed_me_notify_checkbox);
        final boolean zG1 = G1(268435456);
        b05.c(new b05.a() { // from class: i40
            @Override // b05.a
            public final Object getValue() {
                return this.f18098a.J1(zG1);
            }
        });
        checkBox3.setChecked(!zG1);
        checkBox3.setOnCheckedChangeListener(new f());
    }

    public final void K1(boolean z, int i) {
        this.q = yg4.b(this.q, z, i);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, zs1.a
    public int getPageId() {
        return 154;
    }

    public final void initActionBar() {
        initToolbar(R.string.settings_message_chat);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_settings);
        this.q = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
        initActionBar();
        H1();
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
    public class c implements Response.ErrorListener {
        public c() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }
    }
}
