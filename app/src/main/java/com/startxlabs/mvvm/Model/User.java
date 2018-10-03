package com.startxlabs.mvvm.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.startxlabs.mvvm.Repository.Converters.DateConverter;

import java.util.Date;

import androidx.room.TypeConverters;

public class User implements Parcelable {

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    @SerializedName("id")
    @Expose(serialize = false, deserialize = true)
    private long id;
    @SerializedName("avatar_url")
    @Expose(serialize = false, deserialize = true)
    private String avatarUrl;
    @SerializedName("gravatar_id")
    @Expose(serialize = false, deserialize = true)
    private String gravatarId;
    @SerializedName("url")
    @Expose(serialize = false, deserialize = true)
    private String url;
    @SerializedName("html_url")
    @Expose(serialize = false, deserialize = true)
    private String htmlUrl;
    @SerializedName("followers_url")
    @Expose(serialize = false, deserialize = true)
    private String followersUrl;
    @SerializedName("following_url")
    @Expose(serialize = false, deserialize = true)
    private String followingUrl;
    @SerializedName("gists_url")
    @Expose(serialize = false, deserialize = true)
    private String gistsUrl;
    @SerializedName("starred_url")
    @Expose(serialize = false, deserialize = true)
    private String starredUrl;
    @SerializedName("subscriptions_url")
    @Expose(serialize = false, deserialize = true)
    private String subscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose(serialize = false, deserialize = true)
    private String organizationsUrl;
    @SerializedName("repos_url")
    @Expose(serialize = false, deserialize = true)
    private String reposUrl;
    @SerializedName("eventsUrl")
    @Expose(serialize = false, deserialize = true)
    private String events_url;
    @SerializedName("received_events_url")
    @Expose(serialize = false, deserialize = true)
    private String receivedEventsUrl;
    @SerializedName("type")
    @Expose(serialize = false, deserialize = true)
    private String type;
    @SerializedName("name")
    @Expose(serialize = false, deserialize = true)
    private String name;
    @SerializedName("blog")
    @Expose(serialize = false, deserialize = true)
    private String blog;
    @SerializedName("location")
    @Expose(serialize = false, deserialize = true)
    private String location;
    @SerializedName("email")
    @Expose(serialize = false, deserialize = true)
    private String email;
    @SerializedName("public_repos")
    @Expose(serialize = false, deserialize = true)
    private int publicRepos;
    @SerializedName("public_gists")
    @Expose(serialize = false, deserialize = true)
    private int publicGists;
    @SerializedName("followers")
    @Expose(serialize = false, deserialize = true)
    private int followers;
    @SerializedName("following")
    @Expose(serialize = false, deserialize = true)
    private int following;
    @SerializedName("created_at")
    @Expose(serialize = false, deserialize = true)
    @TypeConverters(DateConverter.class)
    private Date createdAt;
    @SerializedName("updatedAt")
    @Expose(serialize = false, deserialize = true)
    @TypeConverters(DateConverter.class)
    private Date updated_at;

    public User() {

    }

    protected User(Parcel in) {
        id = in.readLong();
        avatarUrl = in.readString();
        gravatarId = in.readString();
        url = in.readString();
        htmlUrl = in.readString();
        followersUrl = in.readString();
        followingUrl = in.readString();
        gistsUrl = in.readString();
        starredUrl = in.readString();
        subscriptionsUrl = in.readString();
        organizationsUrl = in.readString();
        reposUrl = in.readString();
        events_url = in.readString();
        receivedEventsUrl = in.readString();
        type = in.readString();
        name = in.readString();
        blog = in.readString();
        location = in.readString();
        email = in.readString();
        publicRepos = in.readInt();
        publicGists = in.readInt();
        followers = in.readInt();
        following = in.readInt();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    public int getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(int publicGists) {
        this.publicGists = publicGists;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(avatarUrl);
        dest.writeString(gravatarId);
        dest.writeString(url);
        dest.writeString(htmlUrl);
        dest.writeString(followersUrl);
        dest.writeString(followingUrl);
        dest.writeString(gistsUrl);
        dest.writeString(starredUrl);
        dest.writeString(subscriptionsUrl);
        dest.writeString(organizationsUrl);
        dest.writeString(reposUrl);
        dest.writeString(events_url);
        dest.writeString(receivedEventsUrl);
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(blog);
        dest.writeString(location);
        dest.writeString(email);
        dest.writeInt(publicRepos);
        dest.writeInt(publicGists);
        dest.writeInt(followers);
        dest.writeInt(following);
    }
}
