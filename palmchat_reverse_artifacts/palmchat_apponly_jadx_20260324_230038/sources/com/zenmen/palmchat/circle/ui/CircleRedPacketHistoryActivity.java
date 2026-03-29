package com.zenmen.palmchat.circle.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.activity.search.c;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.circle.bean.CircleRedPacketShowInfo;
import com.zenmen.palmchat.circle.ui.adapter.CircleRedPacketAdapter;
import com.zenmen.palmchat.circle.ui.config.CircleConfig;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import com.zenmen.palmchat.redpacket.data.VoucherRedPacketVo;
import defpackage.b35;
import defpackage.bo0;
import defpackage.ho3;
import defpackage.ir5;
import defpackage.je2;
import defpackage.k86;
import defpackage.m40;
import defpackage.n54;
import defpackage.o54;
import defpackage.sm5;
import defpackage.wc;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleRedPacketHistoryActivity extends BaseActionBarActivity implements CircleRedPacketAdapter.c {
    public CircleRedPacketAdapter r;
    public RecyclerView t;
    public TextView u;
    public ChatItem v;
    public long q = ir5.b();
    public HashMap<String, GroupInfoItem> s = new HashMap<>();
    public HashMap<String, ContactInfoItem> w = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements o54<List<CircleRedPacketShowInfo>> {
        public a() {
        }

        @Override // defpackage.o54
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<CircleRedPacketShowInfo> list) {
            if (CircleRedPacketHistoryActivity.this.isFinishing()) {
                return;
            }
            CircleRedPacketHistoryActivity.this.hideBaseProgressBar();
            if (CircleRedPacketHistoryActivity.this.r != null) {
                CircleRedPacketHistoryActivity.this.r.g(list);
            }
        }

        @Override // defpackage.o54
        public void onCompleted() {
            if (CircleRedPacketHistoryActivity.this.isFinishing()) {
                return;
            }
            CircleRedPacketHistoryActivity.this.hideBaseProgressBar();
            CircleRedPacketHistoryActivity.this.R1();
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            CircleRedPacketHistoryActivity.this.hideBaseProgressBar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(String str, String[] strArr, String str2, sm5 sm5Var) {
        this.s = c.k();
        Q1();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(DBUriManager.a(ho3.class, 0), null, str, strArr, str2);
        if (cursorQuery == null) {
            sm5Var.onCompleted();
            return;
        }
        String str3 = "";
        while (cursorQuery.moveToNext()) {
            MessageVo messageVoBuildFromCursor = MessageVo.buildFromCursor(cursorQuery);
            VoucherRedPacketVo voucherRedPacketVoBuildFromMessageVo = VoucherRedPacketVo.buildFromMessageVo(messageVoBuildFromCursor);
            if (E1(voucherRedPacketVoBuildFromMessageVo)) {
                String strH1 = H1(messageVoBuildFromCursor.time);
                String strG1 = G1(messageVoBuildFromCursor.time);
                if (!TextUtils.equals(str3, strH1)) {
                    CircleRedPacketShowInfo circleRedPacketShowInfo = new CircleRedPacketShowInfo();
                    circleRedPacketShowInfo.infoType = 1;
                    circleRedPacketShowInfo.timeTitle = strH1;
                    arrayList.add(circleRedPacketShowInfo);
                    str3 = strH1;
                }
                CircleRedPacketShowInfo circleRedPacketShowInfo2 = new CircleRedPacketShowInfo();
                ContactInfoItem contactInfoItemF1 = F1(messageVoBuildFromCursor);
                if (contactInfoItemF1 != null) {
                    circleRedPacketShowInfo2.userAvatar = contactInfoItemF1.getIconURL();
                    circleRedPacketShowInfo2.nickName = contactInfoItemF1.getNickName();
                }
                circleRedPacketShowInfo2.infoType = 2;
                circleRedPacketShowInfo2.timeTitle = strH1;
                circleRedPacketShowInfo2.timeDetail = strG1;
                circleRedPacketShowInfo2.message = messageVoBuildFromCursor;
                circleRedPacketShowInfo2.voucherRedPacketVo = voucherRedPacketVoBuildFromMessageVo;
                arrayList.add(circleRedPacketShowInfo2);
            }
        }
        cursorQuery.close();
        if (arrayList.isEmpty()) {
            sm5Var.onCompleted();
        } else {
            sm5Var.onNext(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", CircleConfig.getCouponUrl());
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final boolean E1(VoucherRedPacketVo voucherRedPacketVo) {
        if (voucherRedPacketVo == null) {
            return false;
        }
        int i = voucherRedPacketVo.couponType;
        boolean z = i == 1 || i == 2;
        if ((i == 3 || i == 4) && TextUtils.equals(voucherRedPacketVo.specificUid, AccountUtils.p(AppContext.getContext()))) {
            return true;
        }
        return z;
    }

    public final ContactInfoItem F1(MessageVo messageVo) {
        HashMap<String, ContactInfoItem> map;
        if (messageVo == null) {
            return null;
        }
        if (messageVo.isSend) {
            return bo0.r().l(AccountUtils.p(AppContext.getContext()));
        }
        String strE = m40.e(messageVo.from);
        ContactInfoItem contactInfoItemL = bo0.r().l(strE);
        return (contactInfoItemL != null || (map = this.w) == null) ? contactInfoItemL : map.get(strE);
    }

    public final String G1(long j) {
        long j2 = this.q - j;
        if (j2 < 86400000) {
            return "今天";
        }
        if (j2 < 2592000000L) {
            return ((int) Math.floor(j2 / 8.64E7f)) + "天前";
        }
        if (j2 < 31104000000L) {
            return ((int) Math.floor(j2 / 2.592E9f)) + "个月前";
        }
        return ((int) Math.floor(j2 / 3.1104E10f)) + "年前";
    }

    public final String H1(long j) {
        return M1(j) ? "本周" : L1(j) ? "本月" : N1(j) ? "今年" : "更早";
    }

    public final void I1() {
        showBaseProgressBar("正在加载", true, true);
        final String[] strArr = {DomainHelper.a(this.v, false), String.valueOf(22)};
        final String str = "contact_relate=? and msg_type=?";
        final String str2 = "_id DESC";
        n54.a(new n54.a() { // from class: wb0
            @Override // defpackage.c5
            public final void call(Object obj) {
                this.f21649a.O1(str, strArr, str2, (sm5) obj);
            }
        }).u(b35.c()).i(wc.a()).r(new a());
    }

    public final void J1() {
        setSupportActionBar(initToolbar("劵红包中心"));
        findViewById(R.id.card_packet).setOnClickListener(new View.OnClickListener() { // from class: xb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21916a.P1(view);
            }
        });
        this.u = (TextView) findViewById(R.id.text_empty);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.circleRecyclerView);
        this.t = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CircleRedPacketAdapter circleRedPacketAdapter = new CircleRedPacketAdapter();
        this.r = circleRedPacketAdapter;
        circleRedPacketAdapter.f(this);
        this.t.setAdapter(this.r);
    }

    public final boolean K1(long j, String str) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date(this.q)));
    }

    public final boolean L1(long j) {
        return K1(j, "yyyy-MM");
    }

    public final boolean M1(long j) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(3);
        calendar.setTime(new Date(j));
        return calendar.get(3) == i;
    }

    public final boolean N1(long j) {
        return K1(j, "yyyy");
    }

    public final void Q1() {
        Cursor cursorQuery = AppContext.getContext().getContentResolver().query(je2.f18392a, null, "group_id=?", new String[]{this.v.getChatId()}, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                ContactInfoItem contactInfoItem = new ContactInfoItem();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                contactInfoItem.setIconURL(cursorQuery.getString(cursorQuery.getColumnIndex("head_icon_url")));
                contactInfoItem.setNickName(cursorQuery.getString(cursorQuery.getColumnIndex("nick_name")));
                this.w.put(string, contactInfoItem);
            }
            cursorQuery.close();
        }
    }

    @Override // com.zenmen.palmchat.circle.ui.adapter.CircleRedPacketAdapter.c
    public void R0(CircleRedPacketShowInfo circleRedPacketShowInfo) {
        MessageVo messageVo;
        if (circleRedPacketShowInfo == null || (messageVo = circleRedPacketShowInfo.message) == null) {
            return;
        }
        GroupInfoItem groupInfoItemL = m40.b(messageVo.contactRelate) == 0 ? bo0.r().l(messageVo.contactRelate) : this.s.get(m40.d(messageVo.contactRelate));
        Intent intent = new Intent(this, (Class<?>) ChatterActivity.class);
        intent.putExtra("chat_item", groupInfoItemL);
        intent.putExtra("chat_first_message", messageVo.time);
        intent.putExtra("chat_first_message_primary_id", messageVo._id);
        intent.putExtra("chat_need_back_to_main", false);
        k86.X(intent);
        startActivity(intent);
    }

    public final void R1() {
        this.u.setVisibility(0);
        this.t.setVisibility(8);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_red_packet_history);
        Intent intent = getIntent();
        if (intent != null) {
            this.v = (ChatItem) intent.getParcelableExtra("intent_group_info");
        }
        J1();
        I1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
