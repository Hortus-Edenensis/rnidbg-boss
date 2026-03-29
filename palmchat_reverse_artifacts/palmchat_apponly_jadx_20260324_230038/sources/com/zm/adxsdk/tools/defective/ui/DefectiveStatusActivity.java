package com.zm.adxsdk.tools.defective.ui;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.zm.adxsdk.tools.a;
import com.zm.adxsdk.tools.d;
import com.zm.fission.fataar.R$color;
import com.zm.fission.fataar.R$id;
import com.zm.fission.fataar.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DefectiveStatusActivity extends AppCompatActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f16601a;
    public TextView b;
    public int c = 1;

    public final void a(int i) {
        TextView textView;
        Resources resources;
        int i2;
        if (i == 1) {
            this.f16601a.setBackgroundColor(getResources().getColor(R$color.wf_shell_df_white));
            this.f16601a.setTextColor(getResources().getColor(R$color.wf_shell_sdk_df_black));
            this.b.setBackgroundColor(getResources().getColor(R$color.wf_shell_df_white_e));
            textView = this.b;
            resources = getResources();
            i2 = R$color.wf_shell_df_title_8;
        } else {
            this.f16601a.setBackgroundColor(getResources().getColor(R$color.wf_shell_df_white_e));
            this.f16601a.setTextColor(getResources().getColor(R$color.wf_shell_df_title_8));
            this.b.setBackgroundColor(getResources().getColor(R$color.wf_shell_df_white));
            textView = this.b;
            resources = getResources();
            i2 = R$color.wf_shell_sdk_df_black;
        }
        textView.setTextColor(resources.getColor(i2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Fragment dVar;
        int i;
        if (view.getId() == R$id.wf_df_app_msg_txt) {
            dVar = new a();
            i = 1;
        } else {
            if (view.getId() != R$id.wf_df_code_check_txt) {
                dVar = null;
                a(this.c);
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R$id.wf_df_fragment_rl, dVar).commit();
            }
            dVar = new d();
            i = 2;
        }
        this.c = i;
        a(this.c);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out).replace(R$id.wf_df_fragment_rl, dVar).commit();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.wf_shell_df_layout_activity_defective_status);
        this.f16601a = (TextView) findViewById(R$id.wf_df_app_msg_txt);
        this.b = (TextView) findViewById(R$id.wf_df_code_check_txt);
        a(1);
        getSupportFragmentManager().beginTransaction().add(R$id.wf_df_fragment_rl, new a(), "TAG").commit();
        this.f16601a.setOnClickListener(this);
        this.b.setOnClickListener(this);
    }
}
