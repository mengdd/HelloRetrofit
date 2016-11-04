package com.ddmeng.helloretrofit.ui.people;

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
import com.ddmeng.helloretrofit.data.models.User;
import com.ddmeng.helloretrofit.data.remote.GitHubService;
import com.ddmeng.helloretrofit.data.remote.ServiceGenerator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PeopleFragment extends Fragment {
    public static final String TAG = "PeopleFragment";

    @BindView(R.id.input_user_name)
    EditText inputUserNameView;
    @BindView(R.id.following_people)
    RecyclerView peopleRecyclerView;

    private PeopleListAdapter peopleListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.people_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initViews();
    }

    private void initViews() {
        peopleListAdapter = new PeopleListAdapter();
        peopleRecyclerView.setAdapter(peopleListAdapter);
        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick(R.id.get_user_following)
    void getUserFollowing() {
        GitHubService service = ServiceGenerator.createService(GitHubService.class);
        Call<List<User>> userFollowing = service.getUserFollowing(inputUserNameView.getText().toString());
        userFollowing.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> followingUsers = response.body();
                peopleListAdapter.setUsers(followingUsers);
                peopleListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }
}
