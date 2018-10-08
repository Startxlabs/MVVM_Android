package com.startxlabs.mvvm.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.startxlabs.mvvm.Repository.Room.Converters.DateConverter;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "Project")
public class Project implements Parcelable {

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };
    @SerializedName("id")
    @Expose(serialize = false, deserialize = true)
    @PrimaryKey
    @NonNull
    private long pid;
    @SerializedName("name")
    @Expose(serialize = false, deserialize = true)
    private String pname;
    @SerializedName("full_name")
    @Expose(serialize = false, deserialize = true)
    private String fullName;
    @SerializedName("owner")
    @Expose(serialize = false, deserialize = true)
    @Embedded
    private User owner;
    @SerializedName("html_url")
    @Expose(serialize = false, deserialize = true)
    private String pHtmlUrl;
    @SerializedName("description")
    @Expose(serialize = false, deserialize = true)
    private String description;
    @SerializedName("url")
    @Expose(serialize = false, deserialize = true)
    private String pUrl;
    @SerializedName("created_at")
    @Expose(serialize = false, deserialize = true)
    @TypeConverters(DateConverter.class)
    private Date pCreatedAt;
    @SerializedName("updated_at")
    @Expose(serialize = false, deserialize = true)
    @TypeConverters(DateConverter.class)
    private Date updatedAt;
    @SerializedName("pushed_at")
    @Expose(serialize = false, deserialize = true)
    @TypeConverters(DateConverter.class)
    private Date pushedAt;
    @SerializedName("git_url")
    @Expose(serialize = false, deserialize = true)
    private String gitUrl;
    @SerializedName("ssh_url")
    @Expose(serialize = false, deserialize = true)
    private String sshUrl;
    @SerializedName("clone_url")
    @Expose(serialize = false, deserialize = true)
    private String cloneUrl;
    @SerializedName("svn_url")
    @Expose(serialize = false, deserialize = true)
    private String svnUrl;
    @SerializedName("homepage")
    @Expose(serialize = false, deserialize = true)
    private String homepage;
    @SerializedName("stargazers_count")
    @Expose(serialize = false, deserialize = true)
    private int stargazersCount;
    @SerializedName("watchers_count")
    @Expose(serialize = false, deserialize = true)
    private int watchersCount;
    @SerializedName("language")
    @Expose(serialize = false, deserialize = true)
    private String language;
    @SerializedName("has_issues")
    @Expose(serialize = false, deserialize = true)
    private boolean hasIssues;
    @SerializedName("has_downloads")
    @Expose(serialize = false, deserialize = true)
    private boolean hasDownloads;
    @SerializedName("has_wiki")
    @Expose(serialize = false, deserialize = true)
    private boolean hasWiki;
    @SerializedName("has_pages")
    @Expose(serialize = false, deserialize = true)
    private boolean hasPages;
    @SerializedName("forks_count")
    @Expose(serialize = false, deserialize = true)
    private int forksCount;
    @SerializedName("open_issues_count")
    @Expose(serialize = false, deserialize = true)
    private int openIssuesCount;
    @SerializedName("forks")
    @Expose(serialize = false, deserialize = true)
    private int forks;
    @SerializedName("open_issues")
    @Expose(serialize = false, deserialize = true)
    private int openIssues;
    @SerializedName("watchers")
    @Expose(serialize = false, deserialize = true)
    private int watchers;
    @SerializedName("default_branch")
    @Expose(serialize = false, deserialize = true)
    private String defaultBranch;

    public Project() {

    }

    protected Project(Parcel in) {
        pid = in.readLong();
        pname = in.readString();
        fullName = in.readString();
        owner = in.readParcelable(User.class.getClassLoader());
        pHtmlUrl = in.readString();
        description = in.readString();
        pUrl = in.readString();
        gitUrl = in.readString();
        sshUrl = in.readString();
        cloneUrl = in.readString();
        svnUrl = in.readString();
        homepage = in.readString();
        stargazersCount = in.readInt();
        watchersCount = in.readInt();
        language = in.readString();
        hasIssues = in.readByte() != 0;
        hasDownloads = in.readByte() != 0;
        hasWiki = in.readByte() != 0;
        hasPages = in.readByte() != 0;
        forksCount = in.readInt();
        openIssuesCount = in.readInt();
        forks = in.readInt();
        openIssues = in.readInt();
        watchers = in.readInt();
        defaultBranch = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(pid);
        dest.writeString(pname);
        dest.writeString(fullName);
        dest.writeParcelable(owner, flags);
        dest.writeString(pHtmlUrl);
        dest.writeString(description);
        dest.writeString(pUrl);
        dest.writeString(gitUrl);
        dest.writeString(sshUrl);
        dest.writeString(cloneUrl);
        dest.writeString(svnUrl);
        dest.writeString(homepage);
        dest.writeInt(stargazersCount);
        dest.writeInt(watchersCount);
        dest.writeString(language);
        dest.writeByte((byte) (hasIssues ? 1 : 0));
        dest.writeByte((byte) (hasDownloads ? 1 : 0));
        dest.writeByte((byte) (hasWiki ? 1 : 0));
        dest.writeByte((byte) (hasPages ? 1 : 0));
        dest.writeInt(forksCount);
        dest.writeInt(openIssuesCount);
        dest.writeInt(forks);
        dest.writeInt(openIssues);
        dest.writeInt(watchers);
        dest.writeString(defaultBranch);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @NonNull
    public long getPid() {
        return pid;
    }

    public void setPid(@NonNull long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getPHtmlUrl() {
        return pHtmlUrl;
    }

    public void setPHtmlUrl(String pHtmlUrl) {
        this.pHtmlUrl = pHtmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPUrl() {
        return pUrl;
    }

    public void setPUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public Date getPCreatedAt() {
        return pCreatedAt;
    }

    public void setPCreatedAt(Date pCreatedAt) {
        this.pCreatedAt = pCreatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(Date pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(int watchersCount) {
        this.watchersCount = watchersCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public boolean isHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public boolean isHasPages() {
        return hasPages;
    }

    public void setHasPages(boolean hasPages) {
        this.hasPages = hasPages;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }
}
