package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationSelectActivity;
import defpackage.c70;
import defpackage.k86;
import defpackage.sy5;
import defpackage.wi0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleAddLocationActivity extends BaseActionBarActivity implements View.OnClickListener {
    public TextView q;
    public Toolbar r;
    public int s;
    public GroupInfoItem t;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            CircleAddLocationActivity.this.hideBaseProgressBar();
            if (baseResponse.getResultCode() != 0) {
                sy5.e(CircleAddLocationActivity.this, R.string.send_failed, 0).g();
            } else {
                c70.R().C0(false, new String[0]);
                CircleAddLocationActivity.this.E1();
            }
        }
    }

    public final void B1() {
        this.s = getIntent().getIntExtra("fromType", 0);
        this.t = (GroupInfoItem) getIntent().getParcelableExtra("chat_item");
    }

    public final void C1() {
        Toolbar toolbarInitToolbar = initToolbar("群地点");
        this.r = toolbarInitToolbar;
        ((TextView) toolbarInitToolbar.findViewById(R.id.title)).setText(R.string.circle_create);
        setSupportActionBar(this.r);
        TextView textView = (TextView) this.r.findViewById(R.id.action_button);
        textView.setBackgroundDrawable(null);
        textView.setText("跳过");
        textView.setTextColor(getResources().getColor(R.color.Gd));
        textView.setOnClickListener(this);
        setSupportActionBar(this.r);
    }

    public final void D1() {
        C1();
        TextView textView = (TextView) findViewById(R.id.text_add_location);
        this.q = textView;
        textView.setOnClickListener(this);
    }

    public final void E1() {
        if (this.t == null) {
            finish();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) ChatterActivity.class);
        intent.putExtra("fromType", 0);
        intent.putExtra("chat_item", this.t);
        k86.X(intent);
        startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.t == null) {
            E1();
            return;
        }
        if (i == 1001 && i2 == -1) {
            LocationEx locationEx = (LocationEx) intent.getParcelableExtra("location");
            if (locationEx == null) {
                E1();
                return;
            }
            String address = locationEx.getAddress();
            String name = locationEx.getName();
            showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
            c70.R().x0(this.t.getGroupId(), address, name, locationEx.getCoorType(), String.valueOf(locationEx.getLongitude()), String.valueOf(locationEx.getLatitude()), new a());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.action_button) {
            E1();
        } else if (view.getId() == R.id.text_add_location) {
            BaseActivityPermissionDispatcher.b(this, BaseActivityPermissionDispatcher.PermissionType.LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_LOCATION);
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_add_location);
        B1();
        D1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        E1();
        finish();
        return true;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_LOCATION) {
            Intent intent = new Intent();
            intent.setClass(this, LocationSelectActivity.class);
            intent.putExtra("enable_map_drag", true);
            startActivityForResult(intent, 1001);
        }
    }
}
