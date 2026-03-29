package defpackage;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.zenmen.palmchat.greendao.model.ISupperFeedBean;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.tag.bean.SquareTagBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class nu5 extends no0 implements View.OnClickListener {
    public AppCompatTextView c;
    public TextView d;
    public TextView e;
    public TextView f;

    public nu5(ConstraintLayout constraintLayout) {
        super(constraintLayout);
    }

    @Override // defpackage.no0
    public void a(ISupperFeedBean iSupperFeedBean) {
        this.c.setText(vl1.c(iSupperFeedBean.getContent(), this.c.getContext(), vl1.i));
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        if (iSupperFeedBean instanceof SquareFeed) {
            SquareFeed squareFeed = (SquareFeed) iSupperFeedBean;
            if (TextUtils.isEmpty(squareFeed.location) || squareFeed.official) {
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.d.setText(squareFeed.location);
            }
            if (TextUtils.isEmpty(squareFeed.topicName)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.e.setText(squareFeed.topicName);
            }
            SquareTagBean squareTagBeanN = ai5.k().n(squareFeed.tagId);
            if (squareTagBeanN == null || TextUtils.isEmpty(squareTagBeanN.getName())) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(squareTagBeanN.getName());
            }
            this.f.setVisibility(8);
        }
    }

    @Override // defpackage.no0
    public int b() {
        return R$layout.layout_square_text_detail;
    }

    @Override // defpackage.no0
    public void c() {
        this.c = (AppCompatTextView) this.f19564a.findViewById(R$id.tv_feed_content_desc);
        this.d = (TextView) this.f19564a.findViewById(R$id.tv_text_only_location);
        this.e = (TextView) this.f19564a.findViewById(R$id.tv_topic_name);
        TextView textView = (TextView) this.f19564a.findViewById(R$id.tv_tag_name);
        this.f = textView;
        textView.setTag(2);
        this.e.setTag(1);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        fa3 fa3Var = this.b;
        if (fa3Var != null) {
            fa3Var.onEvent(((Integer) view.getTag()).intValue(), null);
        }
    }
}
