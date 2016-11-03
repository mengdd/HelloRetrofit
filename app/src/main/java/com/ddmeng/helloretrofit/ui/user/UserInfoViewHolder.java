package com.ddmeng.helloretrofit.ui.user;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.ddmeng.helloretrofit.R;
import com.ddmeng.helloretrofit.data.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;

class UserInfoViewHolder {

    @BindView(R.id.name)
    TextView nameText;
    @BindView(R.id.email)
    TextView emailText;
    @BindView(R.id.public_repos)
    TextView publicReposText;
    @BindView(R.id.following)
    TextView followingText;
    @BindView(R.id.followers)
    TextView followersText;

    private View view;
    private Context context;

    UserInfoViewHolder(View view) {
        this.view = view;
        this.context = view.getContext();
        ButterKnife.bind(this, view);
    }

    void populate(User user) {
        nameText.setText(String.format(context.getString(R.string.user_name), user.getName()));
        emailText.setText(String.format(context.getString(R.string.user_email), user.getEmail()));
        publicReposText.setText(String.format(context.getString(R.string.user_public_repos), user.getPublicRepos()));
        followingText.setText(String.format(context.getString(R.string.user_following), user.getFollowing()));
        followersText.setText(String.format(context.getString(R.string.user_followers), user.getFollowers()));

    }
}
