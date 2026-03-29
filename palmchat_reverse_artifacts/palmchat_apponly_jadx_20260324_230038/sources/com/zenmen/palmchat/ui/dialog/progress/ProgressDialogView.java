package com.zenmen.palmchat.ui.dialog.progress;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.ui.widget.common.CircleProgressView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ProgressDialogView extends LinearLayout {
    private CircleProgressView circleProgressView;
    private TextView progressMessage;

    public ProgressDialogView(Context context) {
        super(context);
        init();
    }

    private void init() {
        View.inflate(getContext(), R$layout.dialog_progress, this);
        this.progressMessage = (TextView) findViewById(R$id.progress_tips);
        this.circleProgressView = (CircleProgressView) findViewById(R$id.dialog_progress);
    }

    public void setMessage(String str) {
        this.progressMessage.setText(str);
    }

    public void setProgress(int i) {
        this.circleProgressView.setCurrentPresent(i);
    }

    public ProgressDialogView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ProgressDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
