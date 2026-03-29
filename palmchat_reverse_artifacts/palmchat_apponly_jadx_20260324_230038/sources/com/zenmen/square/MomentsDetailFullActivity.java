package com.zenmen.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.listui.duration.BaseDurationActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.square.adapter.MomentsDetailAdapter;
import com.zenmen.square.lxpager.SquareViewPager2;
import defpackage.a46;
import defpackage.o22;
import defpackage.ub4;
import defpackage.wq3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MomentsDetailFullActivity extends BaseDurationActivity {
    public int r;
    public int s;

    public static Intent A1(Context context, Feed feed, Long l, String str, String str2, int i, ContactInfoItem contactInfoItem) {
        ArrayList arrayList = new ArrayList();
        if (feed != null) {
            arrayList.add(feed);
        } else if (l.longValue() > 0) {
            Feed feed2 = new Feed();
            feed2.setFeedId(l);
            feed2.setUid(str);
            arrayList.add(feed2);
        }
        return B1(context, arrayList, 0, str2, i, contactInfoItem);
    }

    public static Intent B1(Context context, List<Feed> list, int i, String str, int i2, ContactInfoItem contactInfoItem) {
        Intent intent = new Intent();
        intent.setClass(context, MomentsDetailFullActivity.class);
        intent.putExtra("KEY_FROM", str);
        intent.putExtra("from_type", i2);
        if (contactInfoItem != null) {
            intent.putExtra("user_detail_contact_info", contactInfoItem);
        }
        if (list != null) {
            intent.putExtra("key_target_position", i);
            intent.putParcelableArrayListExtra("key_feed_list", (ArrayList) list);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    public final void C1() {
        SquareViewPager2 squareViewPager2 = (SquareViewPager2) findViewById(R$id.square_detail_pager);
        squareViewPager2.setBackView(findViewById(R$id.back_arrow));
        MomentsDetailAdapter momentsDetailAdapter = new MomentsDetailAdapter(this);
        Bundle extras = getIntent().getExtras();
        extras.remove("key_feed_list");
        momentsDetailAdapter.k(extras);
        squareViewPager2.setAdapter(momentsDetailAdapter);
        wq3 wq3VarB = ub4.b(this.s, new Bundle(extras));
        squareViewPager2.setPagerListModel(wq3VarB);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_feed_list");
        ((Feed) parcelableArrayListExtra.get(this.r)).isTargetPosition = true;
        ((Feed) parcelableArrayListExtra.get(this.r)).isFirstRefresh = true;
        new o22(squareViewPager2, wq3VarB).l(parcelableArrayListExtra, this.r);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(com.zenmen.palmchat.framework.R$anim.scale_exit_in, com.zenmen.palmchat.framework.R$anim.scale_enter_out);
    }

    public final void initActionBar() {
        setStatusBarColor(-16777216);
        a46.A(getWindow(), false);
        findViewById(R$id.back_arrow).setPadding(0, a46.n(this), 0, 0);
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity
    public int o() {
        return 2;
    }

    public void onArrowPress(View view) {
        onBackPressed();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.zenmen.listui.duration.BaseDurationActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_moment_detail);
        this.r = getIntent().getIntExtra("key_target_position", 0);
        this.s = getIntent().getIntExtra("from_type", 0);
        initActionBar();
        C1();
    }
}
