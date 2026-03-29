package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.bc;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class InteractCfg implements Serializable {
    private static final int DEFAULT_TWIST_ACC = 15;
    private static final int DEFAULT_TWIST_DEGREE = 35;
    private static final int MIN_TWIST_ACC = 10;
    private static final long serialVersionUID = 9151867350505964337L;
    private Integer interactiveLogic;
    private Integer splashAdTagClickableType;
    private Integer splashInteractCfg;
    private String splashRedirectTxt;
    private String swipeClkTxt;
    private Integer swipeDirection;
    private Integer swipeDp;
    private String swipeTxt;
    private Integer twistAcc;
    private String twistClkTxt;
    private Integer twistDegree;
    private String twistTxt;

    public Integer B() {
        Integer num = this.interactiveLogic;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public Integer C() {
        return this.splashAdTagClickableType;
    }

    public Integer Code() {
        Integer num = this.splashInteractCfg;
        if (num == null || (num.intValue() >= 0 && this.splashInteractCfg.intValue() <= 4)) {
            return this.splashInteractCfg;
        }
        return 0;
    }

    public String D() {
        return bc.V(this.twistTxt);
    }

    public String F() {
        return bc.V(this.swipeTxt);
    }

    public Integer I() {
        Integer num = this.twistAcc;
        return Integer.valueOf((num == null || num.intValue() < 10) ? 15 : this.twistAcc.intValue());
    }

    public String L() {
        return bc.V(this.swipeClkTxt);
    }

    public Integer S() {
        Integer num = this.swipeDirection;
        if (num == null || !(num.intValue() == 0 || this.swipeDirection.intValue() == 1)) {
            return 0;
        }
        return this.swipeDirection;
    }

    public Integer V() {
        return this.swipeDp;
    }

    public Integer Z() {
        Integer num = this.twistDegree;
        int iIntValue = 35;
        if (num != null && num.intValue() >= 35) {
            iIntValue = this.twistDegree.intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public String a() {
        return bc.V(this.twistClkTxt);
    }

    public String b() {
        return bc.V(this.splashRedirectTxt);
    }

    public void Code(Integer num) {
        this.splashInteractCfg = num;
    }

    public void I(Integer num) {
        this.splashAdTagClickableType = num;
    }

    public void V(Integer num) {
        this.interactiveLogic = num;
    }
}
