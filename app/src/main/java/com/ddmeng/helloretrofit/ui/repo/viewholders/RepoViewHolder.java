package com.ddmeng.helloretrofit.ui.repo.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ddmeng.helloretrofit.R;
import com.ddmeng.helloretrofit.data.models.Repo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.repo_full_name)
    TextView repoFullName;
    @BindView(R.id.repo_description)
    TextView repoDescription;

    public RepoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(Repo repo) {
        repoFullName.setText(repo.getFullName());
        repoDescription.setText(repo.getDescription());
    }
}
