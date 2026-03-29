package com.zenmen.square.comment.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.zenmen.square.R$color;
import defpackage.pe6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MentionEditText extends AppCompatEditText {
    public static final String DEFAULT_MENTION_PATTERN = "#[\\u4e00-\\u9fa5\\w\\-]+";
    public static final String DEFAULT_MENTION_TAG = "#";
    boolean isEnableRang;
    private Runnable mAction;
    private boolean mIsSelected;
    private e mLastSelectedRange;
    private int mMentionTextColor;
    private d mOnMentionInputListener;
    private Map<String, Pattern> mPatternMap;
    private List<e> mRangeArrayList;
    private List<String> mTopicArrayList;
    protected int richMaxLength;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MentionEditText mentionEditText = MentionEditText.this;
            mentionEditText.setSelection(mentionEditText.getText().length());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EditText f16213a;

        public b(InputConnection inputConnection, boolean z, MentionEditText mentionEditText) {
            super(inputConnection, z);
            this.f16213a = mentionEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            return (i == 1 && i2 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                return super.sendKeyEvent(keyEvent);
            }
            int selectionStart = this.f16213a.getSelectionStart();
            e rangeOfClosestMentionString = MentionEditText.this.getRangeOfClosestMentionString(selectionStart, this.f16213a.getSelectionEnd());
            if (rangeOfClosestMentionString == null) {
                MentionEditText.this.mIsSelected = false;
                return super.sendKeyEvent(keyEvent);
            }
            if (MentionEditText.this.mIsSelected || selectionStart == rangeOfClosestMentionString.f16215a) {
                MentionEditText.this.mIsSelected = false;
                return super.sendKeyEvent(keyEvent);
            }
            MentionEditText.this.mIsSelected = true;
            MentionEditText.this.mLastSelectedRange = rangeOfClosestMentionString;
            setSelection(rangeOfClosestMentionString.b, rangeOfClosestMentionString.f16215a);
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16215a;
        public int b;

        public e(int i, int i2) {
            this.f16215a = i;
            this.b = i2;
        }

        public boolean a(int i, int i2) {
            return this.f16215a <= i && this.b >= i2;
        }

        public int b(int i) {
            int i2 = this.f16215a;
            int i3 = this.b;
            return (i - i2) - (i3 - i) >= 0 ? i3 : i2;
        }

        public boolean c(int i, int i2) {
            int i3 = this.f16215a;
            return (i3 == i && this.b == i2) || (i3 == i2 && this.b == i);
        }

        public boolean d(int i, int i2) {
            int i3 = this.f16215a;
            return (i > i3 && i < this.b) || (i2 > i3 && i2 < this.b);
        }
    }

    public MentionEditText(Context context) {
        super(context);
        this.mPatternMap = new HashMap();
        this.richMaxLength = 256;
        this.isEnableRang = false;
        init();
    }

    public static /* synthetic */ d access$100(MentionEditText mentionEditText) {
        mentionEditText.getClass();
        return null;
    }

    private void colorMentionString() {
        this.mIsSelected = false;
        List<e> list = this.mRangeArrayList;
        if (list != null) {
            list.clear();
        }
        List<String> list2 = this.mTopicArrayList;
        if (list2 != null) {
            list2.clear();
        }
        Editable text = getText();
        if (text == null || TextUtils.isEmpty(text.toString())) {
            return;
        }
        for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) text.getSpans(0, text.length(), ForegroundColorSpan.class)) {
            text.removeSpan(foregroundColorSpan);
        }
        String string = text.toString();
        Iterator<Map.Entry<String, Pattern>> it = this.mPatternMap.entrySet().iterator();
        while (it.hasNext()) {
            Matcher matcher = it.next().getValue().matcher(string);
            int i = -1;
            while (matcher.find()) {
                String strGroup = matcher.group();
                int iIndexOf = i != -1 ? string.indexOf(strGroup, i) : string.indexOf(strGroup);
                int length = strGroup.length() + iIndexOf;
                text.setSpan(new ForegroundColorSpan(this.mMentionTextColor), iIndexOf, length, 33);
                try {
                    this.mTopicArrayList.add(string.substring(iIndexOf, length));
                } catch (Exception unused) {
                }
                this.mRangeArrayList.add(new e(iIndexOf, length));
                i = length;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e getRangeOfClosestMentionString(int i, int i2) {
        List<e> list = this.mRangeArrayList;
        if (list == null) {
            return null;
        }
        for (e eVar : list) {
            if (eVar.a(i, i2)) {
                return eVar;
            }
        }
        return null;
    }

    private e getRangeOfNearbyMentionString(int i, int i2) {
        List<e> list = this.mRangeArrayList;
        if (list == null) {
            return null;
        }
        for (e eVar : list) {
            if (eVar.d(i, i2)) {
                return eVar;
            }
        }
        return null;
    }

    private void init() {
        this.mTopicArrayList = new ArrayList(5);
        this.mRangeArrayList = new ArrayList(5);
        setPattern("#", DEFAULT_MENTION_PATTERN);
        this.mMentionTextColor = pe6.a(R$color.square_color_red);
        addTextChangedListener(new c(this, null));
    }

    public void addPattern(String str, String str2) {
        this.mPatternMap.put(str, Pattern.compile(str2));
    }

    public List<String> getMentionList(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(getText().toString())) {
            return arrayList;
        }
        Iterator<Map.Entry<String, Pattern>> it = this.mPatternMap.entrySet().iterator();
        while (it.hasNext()) {
            Matcher matcher = it.next().getValue().matcher(getText().toString());
            while (matcher.find()) {
                String strGroup = matcher.group();
                if (z) {
                    strGroup = strGroup.substring(1);
                }
                if (!arrayList.contains(strGroup)) {
                    arrayList.add(strGroup);
                }
            }
        }
        return arrayList;
    }

    public List<e> getRangeArrayList() {
        return this.mRangeArrayList;
    }

    public List<String> getTopicArrayList() {
        List<String> list = this.mTopicArrayList;
        return list == null ? new ArrayList() : list;
    }

    public boolean isEnableRang() {
        return this.isEnableRang;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.isEnableRang ? new b(super.onCreateInputConnection(editorInfo), true, this) : super.onCreateInputConnection(editorInfo);
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.isEnableRang) {
            e eVar = this.mLastSelectedRange;
            if (eVar == null || !eVar.c(i, i2)) {
                e rangeOfClosestMentionString = getRangeOfClosestMentionString(i, i2);
                if (rangeOfClosestMentionString != null && rangeOfClosestMentionString.b == i2) {
                    this.mIsSelected = false;
                }
                e rangeOfNearbyMentionString = getRangeOfNearbyMentionString(i, i2);
                if (rangeOfNearbyMentionString == null) {
                    return;
                }
                if (i == i2) {
                    setSelection(rangeOfNearbyMentionString.b(i));
                    return;
                }
                int i3 = rangeOfNearbyMentionString.b;
                if (i2 < i3) {
                    setSelection(i, i3);
                }
                int i4 = rangeOfNearbyMentionString.f16215a;
                if (i > i4) {
                    setSelection(i4, i2);
                }
            }
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        colorMentionString();
    }

    public void setEnableRang(boolean z) {
        this.isEnableRang = z;
    }

    public void setMentionTextColor(int i) {
        this.mMentionTextColor = i;
    }

    public void setPattern(String str, String str2) {
        this.mPatternMap.clear();
        addPattern(str, str2);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.mAction == null) {
            this.mAction = new a();
        }
        post(this.mAction);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16214a;
        public String b;
        public int c;

        public c() {
            this.b = "";
            this.c = -1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            MentionEditText.access$100(MentionEditText.this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MentionEditText.access$100(MentionEditText.this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f16214a = i;
            this.c = i3;
            MentionEditText.access$100(MentionEditText.this);
        }

        public /* synthetic */ c(MentionEditText mentionEditText, a aVar) {
            this();
        }
    }

    public MentionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPatternMap = new HashMap();
        this.richMaxLength = 256;
        this.isEnableRang = false;
        init();
    }

    public List<String> getMentionList(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(getText().toString())) {
            return arrayList;
        }
        Iterator<Map.Entry<String, Pattern>> it = this.mPatternMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Pattern> next = it.next();
            if (next.getKey().equals(str)) {
                Matcher matcher = next.getValue().matcher(getText().toString());
                while (matcher.find()) {
                    String strGroup = matcher.group();
                    if (z) {
                        strGroup = strGroup.substring(1);
                    }
                    if (!arrayList.contains(strGroup)) {
                        arrayList.add(strGroup);
                    }
                }
            }
        }
        return arrayList;
    }

    public MentionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPatternMap = new HashMap();
        this.richMaxLength = 256;
        this.isEnableRang = false;
        init();
    }

    public void setOnMentionInputListener(d dVar) {
    }
}
