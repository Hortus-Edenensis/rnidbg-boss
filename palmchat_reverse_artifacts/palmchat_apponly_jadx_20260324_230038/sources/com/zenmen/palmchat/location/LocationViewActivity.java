package com.zenmen.palmchat.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.SendMessageActivity;
import defpackage.ad3;
import defpackage.ed3;
import defpackage.i53;
import defpackage.is0;
import defpackage.n53;
import defpackage.zn6;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LocationViewActivity extends BaseActionBarActivity implements i53 {
    public boolean q = true;
    public is0.f r = new a();
    public TextView s;
    public TextView t;
    public MessageVo u;
    public Toolbar v;
    public com.zenmen.palmchat.location.b w;
    public ad3 x;
    public ed3 y;
    public LocationEx z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements is0.f {
        public a() {
        }

        @Override // is0.f
        public void onItemClicked(int i) {
            if (i == 0) {
                LocationViewActivity.this.D1();
            } else {
                if (i != 1) {
                    return;
                }
                LocationViewActivity.this.finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LocationViewActivity.this.x.h(LocationViewActivity.this.z);
        }
    }

    public final void D1() {
        Intent intent = new Intent();
        intent.setClass(this, SendMessageActivity.class);
        intent.putExtra("message_vo", this.u);
        startActivity(intent);
    }

    public final void E1() {
        Toolbar toolbarInitToolbar = initToolbar(R.string.location_info);
        this.v = toolbarInitToolbar;
        setSupportActionBar(toolbarInitToolbar);
    }

    public final void F1() {
        ((ImageView) findViewById(R.id.navigation_btn)).setOnClickListener(new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d9  */
    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_view);
        E1();
        F1();
        com.zenmen.palmchat.location.b bVarA = com.zenmen.palmchat.location.b.a(this, null, LocationScene.CHAT_SEND_LOCATION);
        this.w = bVarA;
        bVarA.i(this);
        ad3 ad3VarD = this.w.d();
        this.x = ad3VarD;
        View viewF = ad3VarD.f(this);
        int i = 0;
        this.x.n(false);
        ((FrameLayout) findViewById(R.id.map_view_container)).addView(viewF, new FrameLayout.LayoutParams(-1, -1));
        this.x.onCreate(bundle);
        this.q = getIntent().getBooleanExtra("showPopupMenu", true);
        LocationEx locationEx = (LocationEx) getIntent().getParcelableExtra("location");
        this.x.h(locationEx);
        this.x.d(R.drawable.center_marker, locationEx, 0.5f, 1.0f, 1.0f);
        this.s = (TextView) findViewById(R.id.name);
        this.t = (TextView) findViewById(R.id.address);
        if (locationEx != null && locationEx.getName() != null) {
            this.s.setText(locationEx.getName());
        }
        if (locationEx != null && locationEx.getAddress() != null) {
            this.t.setText(locationEx.getAddress());
        }
        this.u = (MessageVo) getIntent().getParcelableExtra("message_vo");
        ChatItem chatItem = (ChatItem) getIntent().getParcelableExtra("chat_item");
        JSONObject jSONObject = new JSONObject();
        if (chatItem != null) {
            try {
                if (chatItem.getChatType() != 0) {
                    i = chatItem.getChatType() == 1 ? 1 : 2;
                }
                jSONObject.put("sourceType", i);
            } catch (Exception unused) {
            }
        }
        zn6.d("cpgl_msg_mapinfo_p", null, jSONObject.toString());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        if (!this.q) {
            return true;
        }
        menuInflater.inflate(R.menu.menu_user_info_detail, menu);
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.w.r(this);
        this.x.onDestroy();
    }

    @Override // defpackage.i53
    public void onLocationReceived(LocationEx locationEx, int i, String str) {
        if (locationEx == null) {
            return;
        }
        this.z = locationEx;
        ed3 ed3Var = this.y;
        if (ed3Var == null) {
            this.y = this.x.a(R.drawable.current_location_marker, locationEx);
        } else {
            this.x.i(ed3Var, locationEx);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_more) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.q) {
            showPopupMenu(this, this.v, new String[]{AppContext.getContext().getResources().getString(R.string.string_forward), AppContext.getContext().getResources().getString(R.string.alert_dialog_cancel)}, new int[]{R.drawable.icon_menu_forward, R.drawable.icon_menu_close}, this.r, null);
        }
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.x.onPause();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.x.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.x.onSaveInstanceState(bundle);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        d.g().k(LocationScene.CHAT_SEND_LOCATION, this);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // defpackage.i53
    public void onRegeocodeSearched(String str) {
    }

    @Override // defpackage.i53
    public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
    }
}
