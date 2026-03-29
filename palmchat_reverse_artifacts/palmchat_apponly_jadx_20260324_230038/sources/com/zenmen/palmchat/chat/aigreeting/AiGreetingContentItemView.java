package com.zenmen.palmchat.chat.aigreeting;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AiGreetingContentItemView extends FrameLayout {
    private View des;
    private TextView tv;

    public AiGreetingContentItemView(@NonNull Context context) {
        this(context, null);
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.layout_ai_greeting_content_item, this);
        this.tv = (TextView) findViewById(R.id.tv);
        this.des = findViewById(R.id.des);
    }

    public void update(String str) {
        boolean zContains = str.contains("||");
        this.des.setVisibility(zContains ? 0 : 8);
        if (!zContains) {
            this.tv.setText(str);
            return;
        }
        String strReplace = str.replace("||", "/");
        SpannableString spannableString = new SpannableString(strReplace);
        int iIndexOf = strReplace.indexOf("/");
        int i = iIndexOf + 1;
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#14CD64")), iIndexOf, i, 33);
        spannableString.setSpan(new RelativeSizeSpan(1.2f), iIndexOf, i, 33);
        this.tv.setText(spannableString);
    }

    public AiGreetingContentItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AiGreetingContentItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews();
    }
}
