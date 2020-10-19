package com.example.weather.common.permission

import java.security.Permissions

/**
 * @author: klaus
 * @date: 2020/10/16
 */
sealed class PermissionResult{
    object Grant : PermissionResult()
    class Deny(val permissions: Array<String>) : PermissionResult()
    class Rationale(val Permissions: Array<String>) : PermissionResult()
}