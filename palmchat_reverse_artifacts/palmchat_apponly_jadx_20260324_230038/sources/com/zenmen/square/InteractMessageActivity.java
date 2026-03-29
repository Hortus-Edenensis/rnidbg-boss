package com.zenmen.square;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.fragment.InteractMessageFragment;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class InteractMessageActivity extends FrameworkBaseActivity {
    public static String r = "target_id";
    public static String s = "notice_type";
    public int q = 0;

    public static void A1(long j, int i, Context context) {
        Intent intent = new Intent(context, (Class<?>) InteractMessageActivity.class);
        intent.putExtra(s, i);
        intent.putExtra(r, j);
        if (context instanceof Activity) {
            context.startActivity(intent);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public final void initActionBar() {
        Intent intent = getIntent();
        if (intent != null) {
            this.q = intent.getIntExtra(s, 0);
        }
        int i = this.q;
        if (i == 0) {
            finish();
            return;
        }
        if (i == 1 || i == 2) {
            initToolbar(R$id.toolbar, "点赞列表", true);
        } else {
            initToolbar(R$id.toolbar, "评论列表", true);
        }
        getToolbar().setBackgroundResource(R$color.white);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_square_interact_message_act);
        initActionBar();
        InteractMessageFragment interactMessageFragment = new InteractMessageFragment();
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        if (getIntent() != null) {
            interactMessageFragment.setArguments(getIntent().getExtras());
        }
        fragmentTransactionBeginTransaction.replace(R$id.message_fragment_container, interactMessageFragment, "NestTagFeedsFragment");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        interactMessageFragment.i(true);
    }
}
