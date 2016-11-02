package com.ddmeng.helloretrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.ddmeng.helloretrofit.data.models.Endpoints;
import com.ddmeng.helloretrofit.data.remote.GitHubService;
import com.ddmeng.helloretrofit.data.remote.ServiceGenerator;
import com.ddmeng.helloretrofit.ui.people.PeopleFragment;
import com.ddmeng.helloretrofit.ui.repo.RepoFragment;
import com.ddmeng.helloretrofit.ui.user.UserFragment;
import com.ddmeng.helloretrofit.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
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
                        LogUtils.i("bottom user");
                        showFragment(new UserFragment(), UserFragment.TAG);
                        return true;
                    case R.id.action_repo:
                        LogUtils.i("bottom repo");
                        showFragment(new RepoFragment(), RepoFragment.TAG);
                        return true;
                    case R.id.action_people:
                        LogUtils.i("bottom people");
                        showFragment(new PeopleFragment(), PeopleFragment.TAG);
                        return true;
                }
                return false;
            }
        });

        showFragment(new UserFragment(), UserFragment.TAG);

    }

    private void showFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragmentByTag = fragmentManager.findFragmentByTag(tag);
        if (fragmentByTag == null) {
            LogUtils.i("show fragment: " + tag);
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content_container, fragment, tag)
                    .commitAllowingStateLoss();
        }
    }

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
