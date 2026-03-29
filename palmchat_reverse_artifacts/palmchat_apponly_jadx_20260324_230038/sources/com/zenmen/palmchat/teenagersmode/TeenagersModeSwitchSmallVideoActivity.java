package com.zenmen.palmchat.teenagersmode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.smallvideo.SmallVideoEntranceController;
import com.zenmen.palmchat.smallvideo.VideoTabConfig;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gr2;
import defpackage.je1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TeenagersModeSwitchSmallVideoActivity extends BaseActionBarActivity {
    public ImageView q;
    public View r;
    public View s;
    public View t;
    public View u;
    public View v;
    public View w;
    public TeenagersModeManager.SmallVideoMode x;
    public je1 y;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TeenagersModeSwitchSmallVideoActivity.this.x = TeenagersModeManager.SmallVideoMode.NOT_ACCESS;
            TeenagersModeSwitchSmallVideoActivity.this.F1();
            TeenagersModeSwitchSmallVideoActivity.this.G1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TeenagersModeSwitchSmallVideoActivity.this.x = TeenagersModeManager.SmallVideoMode.ATTENTION;
            TeenagersModeSwitchSmallVideoActivity.this.F1();
            TeenagersModeSwitchSmallVideoActivity.this.G1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TeenagersModeSwitchSmallVideoActivity.this.x = TeenagersModeManager.SmallVideoMode.ALL;
            TeenagersModeSwitchSmallVideoActivity.this.F1();
            TeenagersModeSwitchSmallVideoActivity.this.G1();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15424a;

        static {
            int[] iArr = new int[TeenagersModeManager.SmallVideoMode.values().length];
            f15424a = iArr;
            try {
                iArr[TeenagersModeManager.SmallVideoMode.NOT_ACCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15424a[TeenagersModeManager.SmallVideoMode.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15424a[TeenagersModeManager.SmallVideoMode.ATTENTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final je1 D1() {
        if (this.y == null) {
            this.y = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).z(R.drawable.icon_video_entrance).B(R.drawable.icon_video_entrance).A(R.drawable.icon_video_entrance).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
        }
        return this.y;
    }

    public final void E1() {
        View viewFindViewById = findViewById(R.id.item_not_accessible);
        this.r = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        View viewFindViewById2 = findViewById(R.id.item_attention);
        this.s = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new b());
        View viewFindViewById3 = findViewById(R.id.item_all);
        this.t = viewFindViewById3;
        viewFindViewById3.setOnClickListener(new c());
        this.u = findViewById(R.id.img_not_accessible_selected);
        this.v = findViewById(R.id.img_attention_selected);
        this.w = findViewById(R.id.img_all_selected);
        this.q = (ImageView) findViewById(R.id.img_icon);
        VideoTabConfig videoTabConfigD = SmallVideoEntranceController.d();
        gr2.j().h(videoTabConfigD != null ? videoTabConfigD.iconUrl : null, this.q, D1());
        try {
            JSONObject jSONObject = new JSONObject();
            TeenagersModeManager.SmallVideoMode smallVideoMode = this.x;
            int i = smallVideoMode == TeenagersModeManager.SmallVideoMode.ATTENTION ? 2 : smallVideoMode == TeenagersModeManager.SmallVideoMode.NOT_ACCESS ? 1 : 3;
            jSONObject.put("setting", 4);
            jSONObject.put("smallVideoSetting", i);
            LogUtil.onClickEvent("settiings_show", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void F1() {
        int i = d.f15424a[this.x.ordinal()];
        if (i == 1) {
            this.u.setVisibility(0);
            this.w.setVisibility(8);
            this.v.setVisibility(8);
        } else if (i == 2) {
            this.u.setVisibility(8);
            this.w.setVisibility(0);
            this.v.setVisibility(8);
        } else {
            if (i != 3) {
                return;
            }
            this.u.setVisibility(8);
            this.w.setVisibility(8);
            this.v.setVisibility(0);
        }
    }

    public final void G1() {
        TeenagersModeManager.SmallVideoMode smallVideoMode = this.x;
        int i = smallVideoMode == TeenagersModeManager.SmallVideoMode.ATTENTION ? 2 : smallVideoMode == TeenagersModeManager.SmallVideoMode.NOT_ACCESS ? 1 : 3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("setting", i);
            LogUtil.onClickEvent("click_channelssetting", null, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("extra_mode", this.x.value());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_teenagers_mode_switch_small_video);
        initToolbar("");
        this.x = TeenagersModeManager.a().b();
        E1();
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        F1();
    }
}
