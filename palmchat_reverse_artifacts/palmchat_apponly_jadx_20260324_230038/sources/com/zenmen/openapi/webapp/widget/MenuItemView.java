package com.zenmen.openapi.webapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MenuItemView extends RelativeLayout {
    private Function function;
    private ImageView menuIcon;
    private TextView menuText;

    /* JADX INFO: compiled from: SearchBox */
    public enum Function {
        ADD_FLOAT,
        SHARE,
        COPY,
        REFRESH,
        FEEDBACK,
        MOMENT
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12053a;
        public Function b;
        public int c;

        public a(int i, String str, Function function) {
            this.c = i;
            this.f12053a = str;
            this.b = function;
        }
    }

    public MenuItemView(Context context) {
        this(context, null);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_webapp_menu_item, this);
        this.menuIcon = (ImageView) findViewById(R.id.iv_webapp_menu_item_icon);
        this.menuText = (TextView) findViewById(R.id.tv_webapp_menu_item_text);
    }

    public Function getFunction() {
        return this.function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public void setMenuIcon(int i) {
        ImageView imageView = this.menuIcon;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setMenuText(String str) {
        TextView textView;
        if (str == null || (textView = this.menuText) == null) {
            return;
        }
        textView.setText(str);
    }

    public void updateItem(a aVar) {
        setMenuIcon(aVar.c);
        setMenuText(aVar.f12053a);
        setFunction(aVar.b);
    }

    public MenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @RequiresApi(api = 21)
    public MenuItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }
}
