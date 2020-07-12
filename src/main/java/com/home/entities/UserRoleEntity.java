package com.home.entities;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_role", schema = "dbo", catalog = "kmgnew")
public class UserRoleEntity {
    private int id;
    private String userRoleName;
    private Collection<AppUserEntity> appUsersById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_role_name")
    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleEntity that = (UserRoleEntity) o;
        return id == that.id &&
                Objects.equals(userRoleName, that.userRoleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userRoleName);
    }

    @OneToMany(mappedBy = "userRoleByUserRoleId")
    public Collection<AppUserEntity> getAppUsersById() {
        return appUsersById;
    }

    public void setAppUsersById(Collection<AppUserEntity> appUsersById) {
        this.appUsersById = appUsersById;
    }
}
