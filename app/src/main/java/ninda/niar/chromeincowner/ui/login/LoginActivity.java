package ninda.niar.chromeincowner.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import ninda.niar.chromeincowner.MainActivity;
import ninda.niar.chromeincowner.R;
import ninda.niar.chromeincowner.network.ApiClient;
import ninda.niar.chromeincowner.network.ApiService;
import ninda.niar.chromeincowner.network.responses.LoginResponse;
import ninda.niar.chromeincowner.utils.Preference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    TextView tvTitle, tvSubTitle;
    Animation animTitle;
    EditText etUsername, etPassword;
    ConstraintLayout constrainLayout;
    ProgressBar progressBar;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        anim();

        if (Preference.getLoggedInStatus(this)){
            if (getIntent().getBooleanExtra("EXIT", false)) {
                finish();
            }else {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("") && password.equals("")) {
                    Snackbar.make(constrainLayout, "Username dan Password Wajib Diisi", Snackbar.LENGTH_SHORT)
                            .show();
                } else {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    progressBar.setVisibility(View.VISIBLE);
                    login(username, password);
                }
            }
        });
    }

    private void anim() {
        tvTitle.startAnimation(animTitle);
        tvSubTitle.startAnimation(animTitle);
    }

    private void init() {
        progressBar = findViewById(R.id.progressbar);
        constrainLayout = findViewById(R.id.constrain_layout);
        apiService = ApiClient.getClient().create(ApiService.class);
        animTitle = AnimationUtils.loadAnimation(this, R.anim.login_title);
        btnLogin = findViewById(R.id.btn_login);
        tvTitle = findViewById(R.id.tv_title);
        tvSubTitle = findViewById(R.id.tv_subtitle);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
    }

    private void login(String username, String password) {
        apiService.login(username, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, final Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getStatus() == 1) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    progressBar.setVisibility(View.GONE);
                                    Preference.setLoggedInStatus(getApplicationContext(), true);
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                }
                            }, 3000);
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    progressBar.setVisibility(View.GONE);
                                    Snackbar.make(constrainLayout, "Username atau Password Salah", Snackbar.LENGTH_SHORT)
                                            .show();
                                }
                            }, 3000);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, final Throwable t) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        progressBar.setVisibility(View.GONE);
                        Snackbar.make(constrainLayout, t.getMessage(), Snackbar.LENGTH_SHORT)
                                .show();
                    }
                }, 3000);
            }
        });
    }
}