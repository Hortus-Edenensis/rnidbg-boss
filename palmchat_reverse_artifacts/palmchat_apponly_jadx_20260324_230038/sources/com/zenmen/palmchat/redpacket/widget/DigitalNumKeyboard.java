package com.zenmen.palmchat.redpacket.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.cdo.oaps.ad.Launcher;
import com.zenmen.palmchat.R;
import defpackage.a03;
import defpackage.tu;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DigitalNumKeyboard extends RelativeLayout {
    private int DK_line_color;
    private int DK_text_color;
    private ArrayList<tu> NumList;
    private GridView gridView;
    private ImageView imgBack;
    a03 keyBoardAdapter;
    private RelativeLayout layoutBack;
    private View line;
    private View line2;
    private View line3;
    private Context mContext;
    private c onImgBackListener;
    private d onNumBtnClickListener;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DigitalNumKeyboard.a(DigitalNumKeyboard.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            DigitalNumKeyboard.b(DigitalNumKeyboard.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    public DigitalNumKeyboard(Context context) {
        this(context, null);
    }

    public static /* bridge */ /* synthetic */ c a(DigitalNumKeyboard digitalNumKeyboard) {
        digitalNumKeyboard.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ d b(DigitalNumKeyboard digitalNumKeyboard) {
        digitalNumKeyboard.getClass();
        return null;
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DigitalNumKeyboard);
        this.DK_text_color = typedArrayObtainStyledAttributes.getColor(1, ContextCompat.getColor(this.mContext, R.color.DK_text_color));
        this.DK_line_color = typedArrayObtainStyledAttributes.getColor(0, ContextCompat.getColor(this.mContext, R.color.DK_line_color));
        View viewInflate = View.inflate(this.mContext, R.layout.layout_digital_num_keyboard, null);
        this.NumList = new ArrayList<>();
        this.gridView = (GridView) viewInflate.findViewById(R.id.gv_keybord);
        this.imgBack = (ImageView) viewInflate.findViewById(R.id.imgBack);
        this.line = viewInflate.findViewById(R.id.line);
        this.line2 = viewInflate.findViewById(R.id.line2);
        this.line3 = viewInflate.findViewById(R.id.line3);
        this.line.setBackgroundColor(this.DK_line_color);
        this.line2.setBackgroundColor(this.DK_line_color);
        this.line3.setBackgroundColor(this.DK_line_color);
        Drawable drawableWrap = DrawableCompat.wrap(ContextCompat.getDrawable(this.mContext, R.mipmap.keyboard_back_img));
        DrawableCompat.setTint(drawableWrap, this.DK_text_color);
        this.imgBack.setImageDrawable(drawableWrap);
        this.gridView.setBackgroundColor(this.DK_line_color);
        this.imgBack.setOnClickListener(new a());
        this.gridView.setOnItemClickListener(new b());
        initNumList();
        setupView();
        addView(viewInflate);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initNumList() {
        for (int i = 1; i < 13; i++) {
            tu tuVar = new tu();
            if (i < 10) {
                tuVar.b(String.valueOf(i));
                tuVar.c(1);
            } else if (i == 10) {
                tuVar.b(".");
                tuVar.c(2);
            } else if (i == 11) {
                tuVar.b("0");
                tuVar.c(1);
            } else if (i == 12) {
                tuVar.b(Launcher.Method.DELETE_CALLBACK);
                tuVar.c(3);
            }
            this.NumList.add(tuVar);
        }
    }

    private void setupView() {
        a03 a03Var = new a03(this.mContext, this.NumList, this.DK_text_color);
        this.keyBoardAdapter = a03Var;
        this.gridView.setAdapter((ListAdapter) a03Var);
    }

    public GridView getGridView() {
        return this.gridView;
    }

    public void updatePointBtn(boolean z) {
        this.keyBoardAdapter.a(z);
    }

    public DigitalNumKeyboard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DigitalNumKeyboard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init(attributeSet);
    }

    public void setOnImgBackListener(c cVar) {
    }

    public void setOnNumBtnClickListener(d dVar) {
    }
}
