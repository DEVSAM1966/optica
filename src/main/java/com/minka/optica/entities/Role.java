package com.minka.optica.entities;

import com.minka.optica.entities.util.RolePermission;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ROLE_ADMINISTRATOR(Arrays.asList(
            RolePermission.READ_ALL_PACIENTS,
            RolePermission.READ_ONE_PACIENT,
            RolePermission.CREATE_ONE_PACIENT,
            RolePermission.UPDATE_ONE_PACIENT,
            RolePermission.DELETE_ONE_PACIENT,

            RolePermission.READ_ALL_OPTOMETRIES,
            RolePermission.READ_ONE_OPTOMETRY,
            RolePermission.CREATE_ONE_OPTOMETRY,
            RolePermission.UPDATE_ONE_OPTOMETRY,
            RolePermission.DELETE_ONE_OPTOMETRY,

            RolePermission.READ_MY_PROFILE
    )),
    ROLE_OPTOMETRIST(Arrays.asList(
            RolePermission.READ_ALL_PACIENTS,
            RolePermission.READ_ONE_PACIENT,
            RolePermission.CREATE_ONE_PACIENT,
            RolePermission.UPDATE_ONE_PACIENT,

            RolePermission.READ_ALL_OPTOMETRIES,
            RolePermission.READ_ONE_OPTOMETRY,
            RolePermission.CREATE_ONE_OPTOMETRY,
            RolePermission.UPDATE_ONE_OPTOMETRY,

            RolePermission.READ_MY_PROFILE
    )),
    ROLE_SELLER(Arrays.asList(
            RolePermission.READ_ALL_PACIENTS,
            RolePermission.READ_ONE_PACIENT,
            RolePermission.CREATE_ONE_PACIENT,
            RolePermission.UPDATE_ONE_PACIENT,

            RolePermission.READ_ALL_OPTOMETRIES,
            RolePermission.READ_ONE_OPTOMETRY,

            RolePermission.READ_MY_PROFILE
    ));

    private List<RolePermission> permissions;

    // Constructor.
    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

    // Getter & Setter

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

}
