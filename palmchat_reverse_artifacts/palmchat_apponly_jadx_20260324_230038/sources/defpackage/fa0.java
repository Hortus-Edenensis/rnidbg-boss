package defpackage;

import com.zenmen.palmchat.circle.label.bean.CircleLabel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fa0 {
    public static CircleLabel a(CircleLabel circleLabel) {
        CircleLabel circleLabel2 = new CircleLabel(circleLabel.labelName);
        circleLabel2.isShowDel = true;
        circleLabel2.isChoose = true;
        circleLabel2.originGroup = circleLabel.originGroup;
        circleLabel2.curGroup = 1;
        circleLabel2.id = circleLabel.id;
        return circleLabel2;
    }

    public static CircleLabel b(String str, String str2) {
        CircleLabel circleLabel = new CircleLabel(str);
        circleLabel.id = str2;
        circleLabel.isShowDel = true;
        circleLabel.isChoose = true;
        circleLabel.originGroup = 1;
        circleLabel.curGroup = 1;
        return circleLabel;
    }

    public static CircleLabel c(String str, String str2) {
        CircleLabel circleLabel = new CircleLabel(str);
        circleLabel.id = str2;
        circleLabel.isShowDel = false;
        circleLabel.isChoose = false;
        circleLabel.originGroup = 2;
        circleLabel.curGroup = 2;
        return circleLabel;
    }

    public static CircleLabel d(String str, String str2) {
        CircleLabel circleLabel = new CircleLabel(str);
        circleLabel.id = str2;
        circleLabel.isShowDel = false;
        circleLabel.isChoose = true;
        circleLabel.originGroup = 1;
        circleLabel.curGroup = 1;
        return circleLabel;
    }
}
