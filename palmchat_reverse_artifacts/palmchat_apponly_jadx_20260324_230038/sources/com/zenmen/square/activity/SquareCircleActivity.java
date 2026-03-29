package com.zenmen.square.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.fragment.SquareMomentsFragmentNew;
import defpackage.gi5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareCircleActivity extends FrameworkBaseActivity {
    public static void A1(Context context) {
        Intent intent = new Intent(context, (Class<?>) SquareCircleActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.layout_square_circle_act);
        initToolbar(R$id.toolbar, gi5.j(), true);
        SquareMomentsFragmentNew squareMomentsFragmentNew = new SquareMomentsFragmentNew();
        squareMomentsFragmentNew.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        if (getIntent() != null) {
            squareMomentsFragmentNew.setArguments(getIntent().getExtras());
        }
        fragmentTransactionBeginTransaction.replace(R$id.circle_fragment_container, squareMomentsFragmentNew, "circleFragment");
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        squareMomentsFragmentNew.i(true);
    }
}
