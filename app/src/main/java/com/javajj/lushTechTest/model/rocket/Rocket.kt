package com.javajj.lushTechTest.model.rocket

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Class is used to represent rocket data
 */

data class Rocket(
	@SerializedName("links") val links : Links,
	@SerializedName("rocket") val rocket : String,
	@SerializedName("success") val success : Boolean,
	@SerializedName("details") val details : String,
	@SerializedName("name") val name : String,
	@SerializedName("date_utc") val date_utc : String,
	@SerializedName("upcoming") val upcoming : Boolean,
	@SerializedName("id") val id : String
)

/**
 *  TODO: Used to store the rocket to a room database. Needs correcting as there is an ad hoc issue with this not loading correctly
 */

@Entity
data class RocketResponse(
	@PrimaryKey val rocketResponseId: Int = 1,
	val rocketResponse: List<Rocket>
)

@Entity
data class Links (
	@SerializedName("patch") val badge : Badge,
)

@Entity
data class Badge (
	@SerializedName("small") val small : String?,
	@SerializedName("large") val large : String?
)

