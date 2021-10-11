package com.lib.common.ui;

import android.text.Editable;
import android.text.TextWatcher;

public class EditTextTextWatcher implements TextWatcher {
    int length;
    EditTextLength editTextLength;

    public EditTextTextWatcher(int l, EditTextLength callback) {
        length = l;
        editTextLength = callback;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (start == length - 1) {
            editTextLength.isIndexOut(true);
        }
        if (count == length - 1) {
            editTextLength.isIndexOut(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
