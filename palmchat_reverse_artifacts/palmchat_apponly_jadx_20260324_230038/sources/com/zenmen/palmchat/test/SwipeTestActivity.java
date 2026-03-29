package com.zenmen.palmchat.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout;
import com.zenmen.palmchat.SwipeBackLayout.app.SwipeBackActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SwipeTestActivity extends SwipeBackActivity implements View.OnClickListener {
    public final void B1() {
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button) {
            z1();
        } else {
            if (id != R.id.button2) {
                return;
            }
            startActivity(new Intent(this, (Class<?>) SwipeTestActivity.class));
        }
    }

    @Override // com.zenmen.palmchat.SwipeBackLayout.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_test_swipe);
        A1(true);
        SwipeBackLayout swipeBackLayoutY1 = y1();
        swipeBackLayoutY1.setEdgeTrackingEnabled(1);
        swipeBackLayoutY1.addSwipeListener(new a());
        B1();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SwipeBackLayout.a {
        public a() {
        }

        @Override // com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout.a
        public void c(int i) {
        }

        @Override // com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout.a
        public void a() {
        }

        @Override // com.zenmen.palmchat.SwipeBackLayout.SwipeBackLayout.a
        public void b(int i, float f) {
        }
    }
}
