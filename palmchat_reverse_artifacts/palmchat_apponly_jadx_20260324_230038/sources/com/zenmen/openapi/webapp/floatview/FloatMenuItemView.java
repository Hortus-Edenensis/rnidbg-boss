package com.zenmen.openapi.webapp.floatview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.zenmen.openapi.R$id;
import com.zenmen.openapi.R$layout;
import com.zenmen.openapi.R$styleable;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import defpackage.fa3;
import defpackage.ma3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FloatMenuItemView extends LxRelativeLayout implements View.OnClickListener {
    public static final int VIEW_ACTION_FEEDBACK = 2;
    public static final int VIEW_ACTION_FLOAT_MENU = 4;
    public static final int VIEW_ACTION_FLOAT_MORE = 10;
    public static final int VIEW_ACTION_GO_LX = 3;
    public static final int VIEW_ACTION_SHARE_FRIENDS = 1;
    public static final int VIEW_ACTION_SHARE_MOMENT = 5;
    private int action;
    private ImageView iVMenuIcon;
    private fa3 mEventCallback;
    private TextView tVMenuName;

    public FloatMenuItemView(Context context) {
        this(context, null);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View.inflate(context, R$layout.lx_webapp_float_menu_item, this);
        this.iVMenuIcon = (ImageView) findViewById(R$id.lx_webapp_float_menu_item_icon);
        this.tVMenuName = (TextView) findViewById(R$id.lx_webapp_float_menu_item_text);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void initAttr(Context context, AttributeSet attributeSet) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatMenuItem);
        int i = R$styleable.FloatMenuItem_item_text;
        String string = typedArrayObtainStyledAttributes.getString(i);
        if (string != null) {
            this.tVMenuName.setText(string);
        } else {
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(i, 0);
            if (resourceId2 != 0) {
                this.tVMenuName.setText(resourceId2);
            }
        }
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.FloatMenuItem_item_icon, 0);
        if (resourceId3 != 0) {
            this.iVMenuIcon.setImageResource(resourceId3);
        }
        int i2 = R$styleable.FloatMenuItem_item_action;
        int i3 = typedArrayObtainStyledAttributes.getInt(i2, 0);
        this.action = i3;
        if (i3 == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0)) != 0) {
            this.action = getResources().getInteger(resourceId);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ma3.a("click v " + view, new Object[0]);
        disPatchEvent(this.action, null);
    }

    public FloatMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(context, attributeSet);
        setOnClickListener(this);
    }

    @RequiresApi(api = 21)
    public FloatMenuItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initAttr(context, attributeSet);
        setOnClickListener(this);
    }
}
