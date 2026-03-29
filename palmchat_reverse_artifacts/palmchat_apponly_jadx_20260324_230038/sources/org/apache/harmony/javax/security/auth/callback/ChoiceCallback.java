package org.apache.harmony.javax.security.auth.callback;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ChoiceCallback implements Callback, Serializable {
    private static final long serialVersionUID = -3975664071579892167L;
    private String[] choices;
    private int defaultChoice;
    private boolean multipleSelectionsAllowed;
    private String prompt;
    private int[] selections;

    public ChoiceCallback(String str, String[] strArr, int i, boolean z) {
        setPrompt(str);
        setChoices(strArr);
        setDefaultChoice(i);
        this.multipleSelectionsAllowed = z;
    }

    private void setChoices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("auth.1C");
        }
        for (String str : strArr) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("auth.1C");
            }
        }
        this.choices = strArr;
    }

    private void setDefaultChoice(int i) {
        if (i < 0 || i >= this.choices.length) {
            throw new IllegalArgumentException("auth.1D");
        }
        this.defaultChoice = i;
    }

    private void setPrompt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("auth.14");
        }
        this.prompt = str;
    }

    public boolean allowMultipleSelections() {
        return this.multipleSelectionsAllowed;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public int getDefaultChoice() {
        return this.defaultChoice;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public int[] getSelectedIndexes() {
        return this.selections;
    }

    public void setSelectedIndex(int i) {
        this.selections = new int[]{i};
    }

    public void setSelectedIndexes(int[] iArr) {
        if (!this.multipleSelectionsAllowed) {
            throw new UnsupportedOperationException();
        }
        this.selections = iArr;
    }
}
