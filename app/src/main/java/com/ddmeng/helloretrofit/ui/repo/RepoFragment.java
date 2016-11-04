package com.ddmeng.helloretrofit.ui.repo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ddmeng.helloretrofit.R;
import com.ddmeng.helloretrofit.data.models.Repo;
import com.ddmeng.helloretrofit.data.remote.GitHubService;
import com.ddmeng.helloretrofit.data.remote.ServiceGenerator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoFragment extends Fragment {
    public static final String TAG = "RepoFragment";

    @BindView(R.id.input_user_name)
    EditText inputUserNameView;
    @BindView(R.id.repos_list)
    RecyclerView reposRecyclerView;

    private ReposListAdapter reposListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.repo_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initViews();
    }

    private void initViews() {
        reposListAdapter = new ReposListAdapter();
        reposRecyclerView.setAdapter(reposListAdapter);
        reposRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick(R.id.get_user_repos)
    void getUserRepos() {
        GitHubService service = ServiceGenerator.createService(GitHubService.class);
        Call<List<Repo>> userReposCall = service.getUserRepos(inputUserNameView.getText().toString());
        userReposCall.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> reposList = response.body();
                reposListAdapter.setRepoList(reposList);
                reposListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
