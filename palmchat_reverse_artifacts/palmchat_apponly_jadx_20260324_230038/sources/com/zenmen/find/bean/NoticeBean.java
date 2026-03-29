package com.zenmen.find.bean;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.constant.a;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.widget.LoopTextView;
import defpackage.bj5;
import defpackage.o73;
import defpackage.zn6;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
@Keep
public class NoticeBean implements BaseBean, LoopTextView.c {
    public String clickText;
    public String content;
    public String replace;
    public List<String> target;
    public long updateTime;
    public String targetUrl = "zenxin://activity?page=a0002&from=7";
    private int currentIndex = 0;

    public boolean hasContent() {
        List<String> list = this.target;
        return list != null && list.size() > 0;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - this.updateTime > a.n || !hasContent();
    }

    @Override // com.zenmen.palmchat.widget.LoopTextView.c
    public SpannableStringBuilder next(final FrameworkBaseActivity frameworkBaseActivity) {
        List<String> list = this.target;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (this.currentIndex >= this.target.size()) {
            this.currentIndex = 0;
        }
        String str = this.target.get(this.currentIndex);
        this.currentIndex++;
        return o73.a(str, this.content.replace(this.replace, ""), this.clickText, new ClickableSpan() { // from class: com.zenmen.find.bean.NoticeBean.1
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                zn6.c("profilebroad_clickgo", "click");
                bj5.b().a().c(frameworkBaseActivity, NoticeBean.this.targetUrl, false);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
                textPaint.setColor(Color.parseColor("#14CD64"));
            }
        });
    }
}
