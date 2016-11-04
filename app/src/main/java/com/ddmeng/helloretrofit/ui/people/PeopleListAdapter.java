package com.ddmeng.helloretrofit.ui.people;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddmeng.helloretrofit.R;
import com.ddmeng.helloretrofit.data.models.User;
import com.ddmeng.helloretrofit.ui.people.viewholders.UserViewHolder;

import java.util.List;

public class PeopleListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<User> users;

    public PeopleListAdapter() {
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_view_holder_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.populate(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }
}
