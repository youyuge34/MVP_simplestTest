package com.example.yousheng.mvptest_wu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.user)
    EditText user;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.login_in_button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.login_in_button)
    private void submit() {
        String username=user.getText().toString();
        String pass=password.getText().toString();
        if(username.isEmpty()||pass.isEmpty()){
            Log.d("test", "submit: cannot be empty");
        }else if(username.length() <8 || pass.length()<9){
            Log.d("test", "submit: 账号至少8位，密码至少10位");
        }else {
            Log.d("test", "submit: success!");
        }
    }
}
