package defpackage;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.friendcircle.R$id;
import com.zenmen.palmchat.friendcircle.R$layout;
import com.zenmen.palmchat.greendao.model.Comment;
import com.zenmen.palmchat.greendao.model.Feed;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ni0 extends mr implements View.OnClickListener {
    public TextView A;
    public TextView B;
    public RelativeLayout C;
    public RelativeLayout E;
    public Feed F;
    public boolean G;

    @Override // defpackage.mr
    public void N(View view) {
        H((-w()) - 10);
        I(((-s()) * 2) / 3);
        super.N(view);
        if (this.F.getStatus() == tq3.h || this.F.getStatus() == tq3.g) {
            this.C.setOnClickListener(null);
            this.E.setOnClickListener(null);
            this.A.setTextColor(Color.parseColor("#737373"));
            this.B.setTextColor(Color.parseColor("#737373"));
            return;
        }
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.A.setTextColor(Color.parseColor("#ffffff"));
        this.B.setTextColor(Color.parseColor("#ffffff"));
    }

    public void Q(@NonNull Feed feed) {
        this.F = feed;
        this.G = false;
        if (feed.getLikesList() != null && feed.getLikesList().size() >= 0) {
            Iterator<Comment> it = feed.getLikesList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (TextUtils.equals(it.next().getFromUid(), v4.e(c.b()))) {
                    this.G = true;
                    break;
                }
            }
        }
        this.A.setText(this.G ? "取消" : "赞");
    }

    @Override // defpackage.lr
    public View a() {
        return m(R$layout.popup_comment);
    }

    @Override // defpackage.lr
    public View c() {
        return p(R$id.comment_popup_contianer);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.item_like) {
            return;
        }
        view.getId();
    }

    @Override // defpackage.mr
    public View q() {
        return null;
    }

    @Override // defpackage.mr
    public Animation x() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, w() + 100, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(250L);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

    @Override // defpackage.mr
    public Animation z() {
        TranslateAnimation translateAnimation = new TranslateAnimation(w() + 300, 0.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(250L);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }
}
