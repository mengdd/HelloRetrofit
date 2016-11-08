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
import android.widget.TextView;

import com.ddmeng.helloretrofit.R;
import com.ddmeng.helloretrofit.data.models.Repo;
import com.ddmeng.helloretrofit.data.models.User;
import com.ddmeng.helloretrofit.data.remote.GitHubService;
import com.ddmeng.helloretrofit.data.remote.ServiceGenerator;
import com.ddmeng.helloretrofit.utils.LogUtils;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


public class PeopleFragment extends Fragment {
    public static final String TAG = "PeopleFragment";

    @BindView(R.id.input_user_name)
    EditText inputUserNameView;
    @BindView(R.id.following_people)
    RecyclerView peopleRecyclerView;
    @BindView(R.id.repo_statistics)
    TextView repoStatisticsView;

    private PeopleListAdapter peopleListAdapter;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

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

    @Override
    public void onPause() {
        super.onPause();
        compositeSubscription.unsubscribe();
    }

    private void initViews() {
        peopleListAdapter = new PeopleListAdapter();
        peopleRecyclerView.setAdapter(peopleListAdapter);
        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick(R.id.get_user_following)
    void getUserFollowing() {
        GitHubService service = ServiceGenerator.createService(GitHubService.class);
        String username = inputUserNameView.getText().toString();

        requestWithRetrofitAndRxJava(service, username);
//        requestWithRetrofit(service, username);
    }

    @OnClick(R.id.get_repo_statistics)
    void getRepoStatistics() {
        repoStatisticsView.setVisibility(View.VISIBLE);
        repoStatisticsView.setText(R.string.loading_message);
        final GitHubService service = ServiceGenerator.createService(GitHubService.class);
        final String username = inputUserNameView.getText().toString();
        Subscription subscription = service.getUserFollowingObservable(username)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(new Func1<List<User>, Observable<User>>() {
                    @Override
                    public Observable<User> call(List<User> users) {
                        return Observable.from(users);
                    }
                })
                .flatMap(new Func1<User, Observable<List<Repo>>>() {
                    @Override
                    public Observable<List<Repo>> call(User user) {
                        return service.getUserReposObservable(user.getLogin()).subscribeOn(Schedulers.io());
                    }
                })
                .flatMap(new Func1<List<Repo>, Observable<Repo>>() {
                    @Override
                    public Observable<Repo> call(List<Repo> repos) {
                        return Observable.from(repos);
                    }
                })
                .reduce(new HashMap<String, Integer>(), new Func2<HashMap<String, Integer>, Repo, HashMap<String, Integer>>() {
                    @Override
                    public HashMap<String, Integer> call(HashMap<String, Integer> repoStatistics, Repo repo) {
                        if (repoStatistics.containsKey(repo.getLanguage())) {
                            repoStatistics.put(repo.getLanguage(), repoStatistics.get(repo.getLanguage()) + 1);
                        } else {
                            repoStatistics.put(repo.getLanguage(), 1);
                        }
                        return repoStatistics;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HashMap<String, Integer>>() {
                    @Override
                    public void call(HashMap<String, Integer> repoStatisticsMap) {
                        repoStatisticsView.setText(repoStatisticsMap.toString());
                    }
                });
        compositeSubscription.add(subscription);
    }

    private void requestWithRetrofitAndRxJava(final GitHubService service, final String username) {
        Subscription subscription = service.getUserFollowingObservable(username)
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<List<User>, Observable<User>>() {
                    @Override
                    public Observable<User> call(List<User> users) {
                        LogUtils.i("from");
                        return Observable.from(users);
                    }
                })
                .flatMap(new Func1<User, Observable<User>>() {
                    @Override
                    public Observable<User> call(User user) {
                        return service.getUserObservable(user.getLogin())
                                .subscribeOn(Schedulers.io())
                                .map(new Func1<User, User>() {
                                    @Override
                                    public User call(User user) {
                                        // this map operation is just used for showing log
                                        LogUtils.i("getUserObservable: " + user.getLogin());
                                        return user;
                                    }
                                });
                    }
                })
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        LogUtils.i("onNext: " + users.size());
                        peopleListAdapter.setUsers(users);
                        peopleListAdapter.notifyDataSetChanged();
                    }
                });
        compositeSubscription.add(subscription);
    }

    private void requestWithRetrofit(GitHubService service, String username) {
        Call<List<User>> userFollowing = service.getUserFollowing(username);
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
