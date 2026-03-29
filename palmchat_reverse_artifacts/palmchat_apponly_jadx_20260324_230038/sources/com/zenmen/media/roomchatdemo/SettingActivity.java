package com.zenmen.media.roomchatdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.zenmen.media.common.IPInfo;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SettingActivity extends AppCompatActivity {
    public EditText q = null;
    public EditText r = null;
    public EditText s = null;
    public EditText t = null;
    public EditText u = null;
    public CheckBox v = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RTCParameters.r(SettingActivity.this.q.getText().toString());
            RTCParameters.q(IPInfo.IP_Type.Notify, SettingActivity.this.r.getText().toString(), Integer.parseInt(SettingActivity.this.s.getText().toString()));
            RTCParameters.q(IPInfo.IP_Type.Cmd, SettingActivity.this.t.getText().toString(), Integer.parseInt(SettingActivity.this.u.getText().toString()));
            RTCParameters.p(SettingActivity.this.v.isChecked());
            SettingActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingActivity.this.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.manychats_activity_setting);
        EditText editText = (EditText) findViewById(R.id.setting_ed_netarea);
        this.q = editText;
        editText.setText(RTCParameters.g());
        EditText editText2 = (EditText) findViewById(R.id.setting_ed_notify_address);
        this.r = editText2;
        IPInfo.IP_Type iP_Type = IPInfo.IP_Type.Notify;
        editText2.setText(RTCParameters.e(iP_Type).a());
        EditText editText3 = (EditText) findViewById(R.id.setting_ed_notify_port);
        this.s = editText3;
        editText3.setText(Integer.toString(RTCParameters.e(iP_Type).b()));
        EditText editText4 = (EditText) findViewById(R.id.setting_ed_cmd_address);
        this.t = editText4;
        IPInfo.IP_Type iP_Type2 = IPInfo.IP_Type.Cmd;
        editText4.setText(RTCParameters.e(iP_Type2).a());
        EditText editText5 = (EditText) findViewById(R.id.setting_ed_cmd_port);
        this.u = editText5;
        editText5.setText(Integer.toString(RTCParameters.e(iP_Type2).b()));
        CheckBox checkBox = (CheckBox) findViewById(R.id.setting_ckb_flashroomlist);
        this.v = checkBox;
        checkBox.setChecked(RTCParameters.d());
        ((Button) findViewById(R.id.bt_setting_save)).setOnClickListener(new a());
        findViewById(R.id.bt_setting_cancel).setOnClickListener(new b());
    }
}
