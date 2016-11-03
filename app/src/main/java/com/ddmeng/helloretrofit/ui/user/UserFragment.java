package com.ddmeng.helloretrofit.ui.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.TextView;

import com.ddmeng.helloretrofit.R;
import com.ddmeng.helloretrofit.data.models.User;
import com.ddmeng.helloretrofit.data.remote.GitHubService;
import com.ddmeng.helloretrofit.data.remote.ServiceGenerator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment {

    public static final String TAG = "UserFragment";
    @BindView(R.id.input_user_name)
    EditText inputUserName;
    @BindView(R.id.output)
    TextView outputText;

    private UserInfoViewHolder userInfoViewHolder;
    private View userInfoContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.get_user_info)
    void getUserInfo() {
        String userName = inputUserName.getText().toString();
        GitHubService githubService = ServiceGenerator.createService(GitHubService.class);
        Call<User> userCall = githubService.getUser(userName);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null) {
                    if (userInfoContainer == null) {
                        ViewStub userInfoStub = (ViewStub) getView().findViewById(R.id.user_info_stub);
                        userInfoContainer = userInfoStub.inflate();
                    }
                    userInfoViewHolder = new UserInfoViewHolder(userInfoContainer);
                    userInfoViewHolder.populate(user);
                    outputText.setVisibility(View.GONE);
                } else {
                    outputText.setVisibility(View.VISIBLE);
                    outputText.setText(getString(R.string.user_not_found));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
