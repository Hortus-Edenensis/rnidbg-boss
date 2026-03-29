package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.CollisionBehavior;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.baidu.platform.comapi.bmsdk.xmlui.BmXmlParse;
import com.baidu.platform.comapi.bmsdk.xmlui.a;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RichView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BmRichView f3726a = new BmRichView();
    private BmBaseUI b;

    public BmRichView getBmRichView() {
        return this.f3726a;
    }

    public BmBaseUI getView() {
        return this.b;
    }

    public void setAnimation(Animation animation) {
        BmAnimation bmAnimation;
        if (animation == null || (bmAnimation = animation.bmAnimation) == null) {
            return;
        }
        this.f3726a.a(bmAnimation);
    }

    public void setCollisionBehavior(CollisionBehavior collisionBehavior) {
        this.f3726a.a(collisionBehavior.getNumber());
    }

    public void setCollisionPriority(short s) {
        BmRichView bmRichView = this.f3726a;
        if (s < 0) {
            s = 0;
        }
        bmRichView.a(s);
    }

    public void setLocated(Located located) {
        this.f3726a.b(located.getNumber());
    }

    public void setScale(float f) {
        this.f3726a.a(f);
    }

    public void setScaleX(float f) {
        this.f3726a.b(f);
    }

    public void setScaleY(float f) {
        this.f3726a.c(f);
    }

    public void setShowLevel(int i, int i2) {
        this.f3726a.a(i, i2);
    }

    public void setView(BaseUI baseUI) {
        this.f3726a.a(baseUI.getBmBaseUI());
    }

    public void setVisibility(int i) {
        this.f3726a.c(i);
    }

    public void setXmlView(String str) {
        Document documentA = BmXmlParse.a(str.getBytes());
        if (documentA != null) {
            this.f3726a = new a().a(documentA);
        }
    }
}
