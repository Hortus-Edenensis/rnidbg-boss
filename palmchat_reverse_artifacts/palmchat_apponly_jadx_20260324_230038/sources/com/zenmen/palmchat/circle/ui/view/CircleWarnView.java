package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleWarnView extends LinearLayout {
    private a closeListener;
    private ImageView cwClose;
    private TextView cwContent;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    public CircleWarnView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        a aVar = this.closeListener;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void init() {
        View viewInflate = View.inflate(getContext(), R.layout.circle_chat_warn, this);
        this.cwContent = (TextView) viewInflate.findViewById(R.id.cw_content);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.cw_close);
        this.cwClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: tc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20957a.lambda$init$0(view);
            }
        });
    }

    public void setCloseListener(a aVar) {
        this.closeListener = aVar;
    }

    public void setContent(String str) {
        this.cwContent.setText(str);
    }

    public CircleWarnView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleWarnView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
