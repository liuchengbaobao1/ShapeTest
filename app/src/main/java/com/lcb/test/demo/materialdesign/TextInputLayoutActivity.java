package com.lcb.test.demo.materialdesign;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.lcb.test.R;

public class TextInputLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);

        final TextInputLayout inputLayout = (TextInputLayout) findViewById(R.id.textinput);

        inputLayout.setHint("请输入姓名：");

        EditText editText = inputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 4) {
                    inputLayout.setErrorEnabled(true);
                    inputLayout.setError("姓名长度不能超过4个");
                } else {
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
