package com.ddmeng.helloretrofit.ui.people.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ddmeng.helloretrofit.R;
import com.ddmeng.helloretrofit.data.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.login_name)
    TextView loginNameText;

    private View view;
    private Context context;

    public UserViewHolder(View view) {
        super(view);
        this.view = view;
        this.context = view.getContext();
        ButterKnife.bind(this, view);
    }

    public void populate(User user) {
        loginNameText.setText(String.format(context.getString(R.string.user_login_name), user.getLogin()));
    }
}
