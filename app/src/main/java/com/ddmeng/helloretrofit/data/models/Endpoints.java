package com.ddmeng.helloretrofit.data.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Endpoints {

    @SerializedName("current_user_url")
    @Expose
    private String currentUserUrl;
    @SerializedName("current_user_authorizations_html_url")
    @Expose
    private String currentUserAuthorizationsHtmlUrl;
    @SerializedName("authorizations_url")
    @Expose
    private String authorizationsUrl;
    @SerializedName("code_search_url")
    @Expose
    private String codeSearchUrl;
    @SerializedName("emails_url")
    @Expose
    private String emailsUrl;
    @SerializedName("emojis_url")
    @Expose
    private String emojisUrl;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @SerializedName("feeds_url")
    @Expose
    private String feedsUrl;
    @SerializedName("followers_url")
    @Expose
    private String followersUrl;
    @SerializedName("following_url")
    @Expose
    private String followingUrl;
    @SerializedName("gists_url")
    @Expose
    private String gistsUrl;
    @SerializedName("hub_url")
    @Expose
    private String hubUrl;
    @SerializedName("issue_search_url")
    @Expose
    private String issueSearchUrl;
    @SerializedName("issues_url")
    @Expose
    private String issuesUrl;
    @SerializedName("keys_url")
    @Expose
    private String keysUrl;
    @SerializedName("notifications_url")
    @Expose
    private String notificationsUrl;
    @SerializedName("organization_repositories_url")
    @Expose
    private String organizationRepositoriesUrl;
    @SerializedName("organization_url")
    @Expose
    private String organizationUrl;
    @SerializedName("public_gists_url")
    @Expose
    private String publicGistsUrl;
    @SerializedName("rate_limit_url")
    @Expose
    private String rateLimitUrl;
    @SerializedName("repository_url")
    @Expose
    private String repositoryUrl;
    @SerializedName("repository_search_url")
    @Expose
    private String repositorySearchUrl;
    @SerializedName("current_user_repositories_url")
    @Expose
    private String currentUserRepositoriesUrl;
    @SerializedName("starred_url")
    @Expose
    private String starredUrl;
    @SerializedName("starred_gists_url")
    @Expose
    private String starredGistsUrl;
    @SerializedName("team_url")
    @Expose
    private String teamUrl;
    @SerializedName("user_url")
    @Expose
    private String userUrl;
    @SerializedName("user_organizations_url")
    @Expose
    private String userOrganizationsUrl;
    @SerializedName("user_repositories_url")
    @Expose
    private String userRepositoriesUrl;
    @SerializedName("user_search_url")
    @Expose
    private String userSearchUrl;

    /**
     * @return The currentUserUrl
     */
    public String getCurrentUserUrl() {
        return currentUserUrl;
    }

    /**
     * @param currentUserUrl The current_user_url
     */
    public void setCurrentUserUrl(String currentUserUrl) {
        this.currentUserUrl = currentUserUrl;
    }

    /**
     * @return The currentUserAuthorizationsHtmlUrl
     */
    public String getCurrentUserAuthorizationsHtmlUrl() {
        return currentUserAuthorizationsHtmlUrl;
    }

    /**
     * @param currentUserAuthorizationsHtmlUrl The current_user_authorizations_html_url
     */
    public void setCurrentUserAuthorizationsHtmlUrl(String currentUserAuthorizationsHtmlUrl) {
        this.currentUserAuthorizationsHtmlUrl = currentUserAuthorizationsHtmlUrl;
    }

    /**
     * @return The authorizationsUrl
     */
    public String getAuthorizationsUrl() {
        return authorizationsUrl;
    }

    /**
     * @param authorizationsUrl The authorizations_url
     */
    public void setAuthorizationsUrl(String authorizationsUrl) {
        this.authorizationsUrl = authorizationsUrl;
    }

    /**
     * @return The codeSearchUrl
     */
    public String getCodeSearchUrl() {
        return codeSearchUrl;
    }

    /**
     * @param codeSearchUrl The code_search_url
     */
    public void setCodeSearchUrl(String codeSearchUrl) {
        this.codeSearchUrl = codeSearchUrl;
    }

    /**
     * @return The emailsUrl
     */
    public String getEmailsUrl() {
        return emailsUrl;
    }

    /**
     * @param emailsUrl The emails_url
     */
    public void setEmailsUrl(String emailsUrl) {
        this.emailsUrl = emailsUrl;
    }

    /**
     * @return The emojisUrl
     */
    public String getEmojisUrl() {
        return emojisUrl;
    }

    /**
     * @param emojisUrl The emojis_url
     */
    public void setEmojisUrl(String emojisUrl) {
        this.emojisUrl = emojisUrl;
    }

    /**
     * @return The eventsUrl
     */
    public String getEventsUrl() {
        return eventsUrl;
    }

    /**
     * @param eventsUrl The events_url
     */
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    /**
     * @return The feedsUrl
     */
    public String getFeedsUrl() {
        return feedsUrl;
    }

    /**
     * @param feedsUrl The feeds_url
     */
    public void setFeedsUrl(String feedsUrl) {
        this.feedsUrl = feedsUrl;
    }

    /**
     * @return The followersUrl
     */
    public String getFollowersUrl() {
        return followersUrl;
    }

    /**
     * @param followersUrl The followers_url
     */
    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    /**
     * @return The followingUrl
     */
    public String getFollowingUrl() {
        return followingUrl;
    }

    /**
     * @param followingUrl The following_url
     */
    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    /**
     * @return The gistsUrl
     */
    public String getGistsUrl() {
        return gistsUrl;
    }

    /**
     * @param gistsUrl The gists_url
     */
    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    /**
     * @return The hubUrl
     */
    public String getHubUrl() {
        return hubUrl;
    }

    /**
     * @param hubUrl The hub_url
     */
    public void setHubUrl(String hubUrl) {
        this.hubUrl = hubUrl;
    }

    /**
     * @return The issueSearchUrl
     */
    public String getIssueSearchUrl() {
        return issueSearchUrl;
    }

    /**
     * @param issueSearchUrl The issue_search_url
     */
    public void setIssueSearchUrl(String issueSearchUrl) {
        this.issueSearchUrl = issueSearchUrl;
    }

    /**
     * @return The issuesUrl
     */
    public String getIssuesUrl() {
        return issuesUrl;
    }

    /**
     * @param issuesUrl The issues_url
     */
    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    /**
     * @return The keysUrl
     */
    public String getKeysUrl() {
        return keysUrl;
    }

    /**
     * @param keysUrl The keys_url
     */
    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    /**
     * @return The notificationsUrl
     */
    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    /**
     * @param notificationsUrl The notifications_url
     */
    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    /**
     * @return The organizationRepositoriesUrl
     */
    public String getOrganizationRepositoriesUrl() {
        return organizationRepositoriesUrl;
    }

    /**
     * @param organizationRepositoriesUrl The organization_repositories_url
     */
    public void setOrganizationRepositoriesUrl(String organizationRepositoriesUrl) {
        this.organizationRepositoriesUrl = organizationRepositoriesUrl;
    }

    /**
     * @return The organizationUrl
     */
    public String getOrganizationUrl() {
        return organizationUrl;
    }

    /**
     * @param organizationUrl The organization_url
     */
    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    /**
     * @return The publicGistsUrl
     */
    public String getPublicGistsUrl() {
        return publicGistsUrl;
    }

    /**
     * @param publicGistsUrl The public_gists_url
     */
    public void setPublicGistsUrl(String publicGistsUrl) {
        this.publicGistsUrl = publicGistsUrl;
    }

    /**
     * @return The rateLimitUrl
     */
    public String getRateLimitUrl() {
        return rateLimitUrl;
    }

    /**
     * @param rateLimitUrl The rate_limit_url
     */
    public void setRateLimitUrl(String rateLimitUrl) {
        this.rateLimitUrl = rateLimitUrl;
    }

    /**
     * @return The repositoryUrl
     */
    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    /**
     * @param repositoryUrl The repository_url
     */
    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    /**
     * @return The repositorySearchUrl
     */
    public String getRepositorySearchUrl() {
        return repositorySearchUrl;
    }

    /**
     * @param repositorySearchUrl The repository_search_url
     */
    public void setRepositorySearchUrl(String repositorySearchUrl) {
        this.repositorySearchUrl = repositorySearchUrl;
    }

    /**
     * @return The currentUserRepositoriesUrl
     */
    public String getCurrentUserRepositoriesUrl() {
        return currentUserRepositoriesUrl;
    }

    /**
     * @param currentUserRepositoriesUrl The current_user_repositories_url
     */
    public void setCurrentUserRepositoriesUrl(String currentUserRepositoriesUrl) {
        this.currentUserRepositoriesUrl = currentUserRepositoriesUrl;
    }

    /**
     * @return The starredUrl
     */
    public String getStarredUrl() {
        return starredUrl;
    }

    /**
     * @param starredUrl The starred_url
     */
    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    /**
     * @return The starredGistsUrl
     */
    public String getStarredGistsUrl() {
        return starredGistsUrl;
    }

    /**
     * @param starredGistsUrl The starred_gists_url
     */
    public void setStarredGistsUrl(String starredGistsUrl) {
        this.starredGistsUrl = starredGistsUrl;
    }

    /**
     * @return The teamUrl
     */
    public String getTeamUrl() {
        return teamUrl;
    }

    /**
     * @param teamUrl The team_url
     */
    public void setTeamUrl(String teamUrl) {
        this.teamUrl = teamUrl;
    }

    /**
     * @return The userUrl
     */
    public String getUserUrl() {
        return userUrl;
    }

    /**
     * @param userUrl The user_url
     */
    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    /**
     * @return The userOrganizationsUrl
     */
    public String getUserOrganizationsUrl() {
        return userOrganizationsUrl;
    }

    /**
     * @param userOrganizationsUrl The user_organizations_url
     */
    public void setUserOrganizationsUrl(String userOrganizationsUrl) {
        this.userOrganizationsUrl = userOrganizationsUrl;
    }

    /**
     * @return The userRepositoriesUrl
     */
    public String getUserRepositoriesUrl() {
        return userRepositoriesUrl;
    }

    /**
     * @param userRepositoriesUrl The user_repositories_url
     */
    public void setUserRepositoriesUrl(String userRepositoriesUrl) {
        this.userRepositoriesUrl = userRepositoriesUrl;
    }

    /**
     * @return The userSearchUrl
     */
    public String getUserSearchUrl() {
        return userSearchUrl;
    }

    /**
     * @param userSearchUrl The user_search_url
     */
    public void setUserSearchUrl(String userSearchUrl) {
        this.userSearchUrl = userSearchUrl;
    }

}