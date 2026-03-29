package com.zenmen.palmchat.test;

import android.os.Bundle;
import android.view.View;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.rtc.bean.RoomInfo;
import defpackage.rx;
import defpackage.ww;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VeRtcTestActivity extends BaseActionBarActivity {
    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_vertc);
        initToolbar("火山Rtc测试");
    }

    public void testCreateRequest(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("5928807616890880");
        ww.a("1054582239", "muc.youni", 0, 0, arrayList, new a());
    }

    public void testCall(View view) {
    }

    public void testGroupCall(View view) {
    }

    public void testOnCall(View view) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements rx<LXBaseNetBean<RoomInfo>> {
        public a() {
        }

        @Override // defpackage.rx
        public void onResult(boolean z, LXBaseNetBean<RoomInfo> lXBaseNetBean, Exception exc) {
        }
    }
}
