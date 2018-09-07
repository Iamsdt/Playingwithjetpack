/*
 * Developed By Shudipto Trafder
 * at 9/7/18 11:22 PM
 * Copyright (c) 9/7/18 11:22 PM Shudipto Trafder
 */

package com.iamsdt.playingwithjetpack.base.data.retrofit.pojo


import com.google.gson.annotations.SerializedName

data class Geo(@SerializedName("lng")
               val lng: String = "",
               @SerializedName("lat")
               val lat: String = "")


data class Company(@SerializedName("bs")
                   val bs: String = "",
                   @SerializedName("catchPhrase")
                   val catchPhrase: String = "",
                   @SerializedName("name")
                   val name: String = "")


data class Address(@SerializedName("zipcode")
                   val zipcode: String = "",
                   @SerializedName("geo")
                   val geo: Geo,
                   @SerializedName("suite")
                   val suite: String = "",
                   @SerializedName("city")
                   val city: String = "",
                   @SerializedName("street")
                   val street: String = "")


data class UsersPoJo(@SerializedName("website")
                 val website: String = "",
                 @SerializedName("address")
                 val address: Address,
                 @SerializedName("phone")
                 val phone: String = "",
                 @SerializedName("name")
                 val name: String = "",
                 @SerializedName("company")
                 val company: Company,
                 @SerializedName("id")
                 val id: Int = 0,
                 @SerializedName("email")
                 val email: String = "",
                 @SerializedName("username")
                 val username: String = "")


