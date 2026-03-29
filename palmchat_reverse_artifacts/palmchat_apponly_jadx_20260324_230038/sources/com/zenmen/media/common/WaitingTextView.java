package com.zenmen.media.common;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class WaitingTextView extends AppCompatTextView {
    int number;
    boolean stop;
    String str;
    int textNumber;
    a updateHandler;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            String strTrim = WaitingTextView.this.getText().toString().replace(".", "").trim();
            WaitingTextView waitingTextView = WaitingTextView.this;
            int i2 = waitingTextView.number;
            if (i2 % 3 == 1) {
                waitingTextView.setText(strTrim + String.format(WaitingTextView.this.str, ".  "));
                WaitingTextView waitingTextView2 = WaitingTextView.this;
                waitingTextView2.number = waitingTextView2.number + 1;
            } else if (i2 % 3 == 2) {
                waitingTextView.setText(strTrim + String.format(WaitingTextView.this.str, ".. "));
                WaitingTextView waitingTextView3 = WaitingTextView.this;
                waitingTextView3.number = waitingTextView3.number + 1;
            } else {
                waitingTextView.setText(strTrim + String.format(WaitingTextView.this.str, "..."));
                WaitingTextView.this.number = 1;
            }
            if (WaitingTextView.this.stop) {
                sendEmptyMessageDelayed(i, 500L);
            }
        }
    }

    public WaitingTextView(Context context) {
        super(context);
        this.number = 1;
        this.stop = true;
        this.updateHandler = new a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 4) {
            a aVar = this.updateHandler;
            if (aVar != null) {
                aVar.removeMessages(0);
                this.updateHandler = null;
            }
            this.stop = true;
            return;
        }
        if (this.updateHandler == null) {
            a aVar2 = new a();
            this.updateHandler = aVar2;
            aVar2.sendEmptyMessage(0);
        }
        this.stop = false;
    }

    public WaitingTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.number = 1;
        this.stop = true;
        this.updateHandler = new a();
        this.str = context.getResources().getString(R.string.manychats_waiting_text_number);
    }
}
