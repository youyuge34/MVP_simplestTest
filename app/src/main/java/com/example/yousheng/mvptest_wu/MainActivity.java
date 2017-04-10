package com.example.yousheng.mvptest_wu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login_in_button)
    Button button;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //将此类的两个方法用接口的规范，构造器的方式传入p层
        mainPresenter = new MainPresenter(this);
    }

    @OnClick(R.id.login_in_button)
    void submit() {
        Log.d("test", "submit: "+"3423423");
        //把登录事件封装成了一个方法，直接调用就行了，代码看起来简洁而且容易理解
        //loginEvent();
        String username = user.getText().toString();
        String pass = password.getText().toString();
        /**
         *让p层去处理登陆实践，此v层只需写回调的两个接口
         */
        mainPresenter.login(username, pass);
    }

//    private void loginEvent() {
//        String username=user.getText().toString();
//        String pass=password.getText().toString();
//        if(username.isEmpty()||pass.isEmpty()){
//            Log.d("test", "submit: cannot be empty");
//        }else if(username.length() <8 || pass.length()<9){
//            Log.d("test", "submit: 账号至少8位，密码至少10位");
//        }else {
//            Log.d("test", "submit: success!");
//        }
//    }

    @Override
    public void LoginSuccess() {
        Log.d("test", "p层会回调此方法:登录成功");
    }

    @Override
    public void LoginFailed(String msg) {
        Log.e("test", "p层会回调此方法:" + msg);
    }
}
