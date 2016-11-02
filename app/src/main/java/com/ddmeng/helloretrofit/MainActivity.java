package com.ddmeng.helloretrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.ddmeng.helloretrofit.data.models.Endpoints;
import com.ddmeng.helloretrofit.data.remote.GitHubService;
import com.ddmeng.helloretrofit.data.remote.ServiceGenerator;
import com.ddmeng.helloretrofit.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_user:
                        return true;
                    case R.id.action_repo:
                        return true;
                    case R.id.action_people:
                        return true;
                }
                return false;
            }
        });
    }

    @OnClick(R.id.get_all_endpoints)
    void getAllEndpoints() {
        GitHubService gitHubService = ServiceGenerator.createService(GitHubService.class);
        Call<Endpoints> endpointsCall = gitHubService.getAllEndpoints("");
        endpointsCall.enqueue(new Callback<Endpoints>() {
            @Override
            public void onResponse(Call<Endpoints> call, Response<Endpoints> response) {
                Endpoints endpoints = response.body();
                String repositoryUrl = endpoints.getRepositoryUrl();
                LogUtils.i(repositoryUrl);
                Toast.makeText(MainActivity.this, "repository url: " + repositoryUrl, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Endpoints> call, Throwable t) {

            }
        });
    }
}
