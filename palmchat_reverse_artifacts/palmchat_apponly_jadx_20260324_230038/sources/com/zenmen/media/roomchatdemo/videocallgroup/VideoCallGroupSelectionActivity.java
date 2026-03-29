package com.zenmen.media.roomchatdemo.videocallgroup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.media.roomchat.PopUpActivity;
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchat.permission.PermissionRequestActivity;
import com.zenmen.media.roomchatdemo.videocallgroup.a;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.modulemanager.module.LXRTCModule;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import defpackage.ct2;
import defpackage.ir2;
import defpackage.me1;
import defpackage.sd3;
import defpackage.u66;
import defpackage.we2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoCallGroupSelectionActivity extends PermissionRequestActivity implements Handler.Callback, a.d {
    public static String O = "VideoCallGroupSelectionActivity";
    public static List<u66> P;
    public static VideoCallGroupSelectionActivity Q;
    public LinearLayout A;
    public LinearLayout B;
    public EditText J;
    public com.zenmen.media.roomchatdemo.videocallgroup.a K;
    public Toolbar M;
    public long[] N;
    public List<Long> w;
    public com.zenmen.media.roomchatdemo.videocallgroup.c y;
    public LinearLayout z;
    public ListView x = null;
    public boolean C = false;
    public boolean E = false;
    public Handler F = null;
    public we2 G = null;
    public long H = 0;
    public List<userInfo> I = null;
    public int L = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoCallGroupSelectionActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoCallGroupSelectionActivity.this.C) {
                VideoCallGroupSelectionActivity.this.P1();
            } else {
                VideoCallGroupSelectionActivity.this.Q1();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements e {
        public c() {
        }

        @Override // com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupSelectionActivity.e
        public void a(long j, boolean z) {
            if (z) {
                VideoCallGroupSelectionActivity.this.w.add(Long.valueOf(j));
            } else {
                Iterator it = VideoCallGroupSelectionActivity.this.w.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((Long) it.next()).longValue() == j) {
                        it.remove();
                        break;
                    }
                }
            }
            List<userInfo> listQ = com.zenmen.media.roomchatdemo.videocallgroup.d.P().Q();
            if (listQ != null) {
                Iterator<userInfo> it2 = listQ.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    userInfo next = it2.next();
                    if (next.id == j) {
                        next.selected = z;
                        break;
                    }
                }
            }
            TextView textView = (TextView) VideoCallGroupSelectionActivity.this.findViewById(R.id.tv_action);
            if (VideoCallGroupSelectionActivity.this.L < VideoCallGroupSelectionActivity.this.w.size()) {
                textView.setEnabled(true);
                textView.setVisibility(0);
            } else {
                textView.setEnabled(false);
                textView.setVisibility(4);
            }
            VideoCallGroupSelectionActivity.this.Z1();
            if (VideoCallGroupSelectionActivity.this.J.getText().length() != 0) {
                VideoCallGroupSelectionActivity.this.J.setText("");
            }
        }

        @Override // com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupSelectionActivity.e
        public boolean b(int i) {
            boolean z;
            if (i > VideoCallGroupChattingUIActivity.S0) {
                VideoCallGroupSelectionActivity.this.W1("");
                z = true;
            } else {
                z = false;
            }
            Log.i("user counts:", String.valueOf(i));
            return z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {
        public d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(long j, boolean z);

        boolean b(int i);
    }

    public static VideoCallGroupSelectionActivity R1() {
        return Q;
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void B0() {
        super.B0();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity
    public void D1() {
        super.B0();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity
    public void E1() {
        super.E1();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity
    public void F1() {
        super.F1();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void I() {
        super.I();
    }

    public void O1() {
        List<userInfo> listV2 = VideoCallGroupChattingUIActivity.w2() != null ? VideoCallGroupChattingUIActivity.w2().v2() : null;
        if (listV2 != null && P != null) {
            ArrayList arrayList = new ArrayList();
            this.I = arrayList;
            arrayList.addAll(listV2);
            for (int i = 0; i < P.size(); i++) {
                u66 u66Var = P.get(i);
                if (u66Var != null) {
                    u66Var.j(false);
                    u66Var.k(false);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= listV2.size()) {
                            break;
                        }
                        if (u66Var.c() == listV2.get(i2).id) {
                            u66Var.j(true);
                            u66Var.k(true);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        this.y.notifyDataSetChanged();
    }

    public final void P1() {
        List<Long> list = this.w;
        ArrayList arrayList = new ArrayList();
        if (this.I != null) {
            for (int i = 0; i < this.I.size(); i++) {
                arrayList.add(Long.valueOf(this.I.get(i).id));
            }
        }
        list.removeAll(arrayList);
        this.N = new long[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.N[i2] = list.get(i2).longValue();
        }
        Intent intent = new Intent(RTCParameters.c(), (Class<?>) PopUpActivity.class);
        intent.putExtra("REQUEST_CODE", PopUpActivity.c);
        startActivityForResult(intent, PopUpActivity.c);
    }

    public final void Q1() {
        try {
            Intent intent = new Intent(RTCParameters.c(), (Class<?>) PopUpActivity.class);
            intent.putExtra("REQUEST_CODE", PopUpActivity.b);
            startActivityForResult(intent, PopUpActivity.b);
        } catch (Exception unused) {
        }
    }

    public final void S1(String str) {
        List<userInfo> listQ = com.zenmen.media.roomchatdemo.videocallgroup.d.P().Q();
        if (listQ != null) {
            List<u66> list = P;
            if (list != null) {
                list.clear();
            }
            P = new ArrayList();
            for (int i = 0; i < listQ.size(); i++) {
                if (str == null || str.isEmpty() || listQ.get(i).name.contains(str)) {
                    u66 u66Var = new u66();
                    u66Var.i(listQ.get(i).id);
                    u66Var.l(listQ.get(i).name);
                    u66Var.g(listQ.get(i).icon);
                    u66Var.h(listQ.get(i).iconurl);
                    u66Var.j(listQ.get(i).selected);
                    u66Var.k(false);
                    P.add(u66Var);
                }
            }
            for (int i2 = 0; i2 < P.size(); i2++) {
                Log.i(O, "userlistmodels:" + i2 + " " + P.get(i2).c());
            }
        }
        List<userInfo> listV2 = VideoCallGroupChattingUIActivity.w2() != null ? VideoCallGroupChattingUIActivity.w2().v2() : (ArrayList) getIntent().getSerializableExtra("USER_LIST_FOR_SELECTION");
        if (listV2 == null || P == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.I = arrayList;
        arrayList.addAll(listV2);
        for (int i3 = 0; i3 < P.size(); i3++) {
            u66 u66Var2 = P.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 >= listV2.size()) {
                    break;
                }
                if (u66Var2.c() == listV2.get(i4).id) {
                    u66Var2.j(true);
                    u66Var2.k(true);
                    break;
                }
                i4++;
            }
        }
    }

    public final void T1() {
        com.zenmen.media.roomchatdemo.videocallgroup.c cVar = new com.zenmen.media.roomchatdemo.videocallgroup.c(P, this, new c());
        this.y = cVar;
        this.x.setAdapter((ListAdapter) cVar);
    }

    public final void U1() {
        if (this.C) {
            this.M = initToolbar((Toolbar) findViewById(R.id.manychats_toolbar), getResources().getString(R.string.manychats_selection_member_title_add), true);
        } else {
            this.M = initToolbar((Toolbar) findViewById(R.id.manychats_toolbar), getResources().getString(R.string.manychats_selection_member_title_select), true);
        }
        setSupportActionBar(this.M);
    }

    public final void V1() {
        this.x = (ListView) findViewById(R.id.group_selection_user_listview);
    }

    public void W1(String str) {
        MaterialDialog materialDialogE = new sd3(this).k(getResources().getString(R.string.manychats_max_invited_warning, Integer.valueOf(RTCParameters.k.f11966a))).n(GravityEnum.CENTER).O(R.string.manychats_selection_member_title_ok).f(new d()).h(false).e();
        if (materialDialogE.i() != null) {
            materialDialogE.i().setTextSize(0, getResources().getDimension(R.dimen.manychats_text_size_big));
        }
        materialDialogE.show();
    }

    public final void X1(long[] jArr) {
        String str = "Invite list:";
        for (long j : jArr) {
            str = str + j + " \n";
        }
        Log.i(O, str);
        if (!this.E) {
            com.zenmen.media.roomchatdemo.videocallgroup.d.P().z(jArr);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        List<userInfo> listQ = com.zenmen.media.roomchatdemo.videocallgroup.d.P().Q();
        ArrayList<RoomUserInfo> arrayList2 = new ArrayList<>();
        for (long j2 : jArr) {
            arrayList.add(String.valueOf(j2));
            RoomUserInfo roomUserInfo = new RoomUserInfo();
            roomUserInfo.uid = String.valueOf(j2);
            Iterator<userInfo> it = listQ.iterator();
            while (true) {
                if (it.hasNext()) {
                    userInfo next = it.next();
                    if (j2 == next.id) {
                        roomUserInfo.nickName = next.name;
                        roomUserInfo.headImg = next.iconurl;
                        break;
                    }
                }
            }
            arrayList2.add(roomUserInfo);
        }
        LxVoipManager.b().i(arrayList, arrayList2);
    }

    public void Y1(long j) {
        getLoaderManager().initLoader(we2.d, null, new we2(this, j).c);
    }

    public final void Z1() {
        if (this.A == null) {
            this.z = (LinearLayout) findViewById(R.id.user_selected_container_row0);
        }
        if (this.A == null) {
            this.A = (LinearLayout) findViewById(R.id.user_selected_container_row1);
        }
        if (this.B == null) {
            this.B = (LinearLayout) findViewById(R.id.user_selected_container_row2);
        }
        if (this.z.getChildCount() > 0) {
            this.z.removeAllViews();
        }
        if (this.A.getChildCount() > 0) {
            this.A.removeAllViews();
        }
        if (this.B.getChildCount() > 0) {
            this.B.removeAllViews();
        }
        this.A.setVisibility(4);
        this.B.setVisibility(4);
        this.z.setVisibility(4);
        LinearLayout linearLayout = this.z;
        if (this.w.size() > 5) {
            linearLayout = this.A;
            linearLayout.setVisibility(0);
            this.B.setVisibility(0);
        } else {
            this.z.setVisibility(0);
        }
        int height = linearLayout.getHeight();
        int width = (linearLayout.getWidth() - (height * 5)) / 6;
        Iterator<Long> it = this.w.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(height, -1);
                layoutParams.setMargins(!z ? 0 : width, 0, 0, 0);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                ir2.a(this, imageView, ct2.f(jLongValue), ct2.g(jLongValue));
                linearLayout.addView(imageView);
                if (linearLayout.getChildCount() >= 5) {
                    break;
                } else {
                    z = true;
                }
            }
            return;
            linearLayout = this.B;
        }
    }

    public void a2(String str) {
        S1(str);
        T1();
    }

    @Override // com.zenmen.media.roomchatdemo.videocallgroup.a.d
    public void d(String str) {
        a2(str);
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        getLoaderManager().destroyLoader(we2.d);
        super.finish();
        Q = null;
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void g1() {
        finish();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        Z1();
        return false;
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public Toolbar initToolbar(Toolbar toolbar, String str, boolean z) {
        this.M = toolbar;
        if (toolbar != null) {
            toolbar.setPadding(0, me1.h(this), 0, 0);
            ViewGroup.LayoutParams layoutParams = this.M.getLayoutParams();
            layoutParams.height = me1.h(this) + me1.b(this, 48);
            this.M.setLayoutParams(layoutParams);
            this.M.setBackgroundResource(R.color.color_FFFFFF);
            if (str != null) {
                this.M.setTitle("");
                ((TextView) findViewById(R.id.tv_title)).setText(str);
            }
            if (z) {
                this.M.setNavigationIcon(R.drawable.selector_arrow_back);
                this.M.setNavigationOnClickListener(new a());
            }
            ((TextView) findViewById(R.id.tv_action)).setOnClickListener(new b());
        }
        return this.M;
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void l() {
        super.B0();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && i2 == -1) {
            setResult(-1);
            return;
        }
        if (i != PopUpActivity.b || i2 != PopUpActivity.e) {
            if (i == PopUpActivity.c && i2 == PopUpActivity.e) {
                X1(this.N);
                finish();
                return;
            }
            return;
        }
        Message message = new Message();
        message.what = 22;
        message.obj = this.w;
        if (LxVoipManager.f()) {
            LXRTCModule.startGroupCall(this, String.valueOf(com.zenmen.media.roomchatdemo.videocallgroup.d.P().O()), this.w, message);
        } else {
            com.zenmen.media.roomchatdemo.videocallgroup.d.P().N().sendMessage(message);
        }
        finish();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.manychats_activity_video_call_group_selection);
        this.w = new ArrayList();
        this.C = getIntent().getIntExtra("IS_INVITE_MODE", 0) != 0;
        boolean z = getIntent().getIntExtra("IS_VE_RTC", 0) == 1;
        this.E = z;
        if (z) {
            RoomSDKInfo roomSDKInfoC = LxVoipManager.b().c();
            if (roomSDKInfoC != null) {
                this.H = Long.parseLong(roomSDKInfoC.groupId);
            }
        } else {
            this.H = com.zenmen.media.roomchatdemo.videocallgroup.d.P().O();
        }
        EditText editText = (EditText) findViewById(R.id.manychats_select_search);
        this.J = editText;
        editText.clearFocus();
        this.K = new com.zenmen.media.roomchatdemo.videocallgroup.a(this, this, this.J);
        U1();
        V1();
        if (!this.C) {
            this.w.add(Long.valueOf(RTCParameters.l()));
        }
        Handler handler = new Handler(this);
        this.F = handler;
        handler.sendEmptyMessageDelayed(1, 500L);
        Q = this;
        Y1(this.H);
        this.L = this.w.size();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manychats_menu_user_selection, menu);
        TextView textView = (TextView) findViewById(R.id.tv_action);
        if (this.C) {
            textView.setText(getResources().getString(R.string.manychats_selection_member_title_ok));
        } else {
            textView.setText(getResources().getString(R.string.manychats_selection_member_title_start));
        }
        textView.setEnabled(false);
        textView.setVisibility(4);
        menu.findItem(R.id.action_start).setVisible(false);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.action_start) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.C) {
            P1();
        } else {
            Q1();
        }
        return true;
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity, com.zenmen.media.roomchat.permission.PermissionRequestInterface
    public void p1() {
        super.p1();
    }

    @Override // com.zenmen.media.roomchat.permission.PermissionRequestActivity
    public void G1() {
    }
}
