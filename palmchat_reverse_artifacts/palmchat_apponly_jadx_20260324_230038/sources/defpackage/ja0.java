package defpackage;

import android.content.Context;
import com.zenmen.palmchat.circle.label.bean.CircleLabel;
import com.zenmen.palmchat.circle.label.ui.view.CircleLabelEditView;
import com.zenmen.palmchat.circle.label.ui.view.CircleLabelRecommendView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ja0 {
    public static CircleLabelEditView a(Context context, CircleLabel circleLabel, CircleLabelEditView.a aVar) {
        CircleLabelEditView circleLabelEditView = new CircleLabelEditView(context);
        circleLabelEditView.setData(circleLabel);
        circleLabelEditView.setLabelDelClickListener(aVar);
        return circleLabelEditView;
    }

    public static CircleLabelEditView b(Context context, String str, CircleLabelEditView.a aVar) {
        CircleLabel circleLabelB = fa0.b(str, d(str));
        CircleLabelEditView circleLabelEditView = new CircleLabelEditView(context);
        circleLabelEditView.setData(circleLabelB);
        circleLabelEditView.setLabelDelClickListener(aVar);
        return circleLabelEditView;
    }

    public static CircleLabelRecommendView c(Context context, CircleLabel circleLabel) {
        CircleLabelRecommendView circleLabelRecommendView = new CircleLabelRecommendView(context);
        circleLabelRecommendView.setData(circleLabel);
        return circleLabelRecommendView;
    }

    public static String d(String str) {
        return System.currentTimeMillis() + str;
    }
}
