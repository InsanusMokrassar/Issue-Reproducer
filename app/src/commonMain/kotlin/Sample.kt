package project_group.project_name.lib

import kotlinx.serialization.Serializable

@Serializable
value class Sample(val value: String) : Comparable<Sample> {
    override fun compareTo(other: Sample): Int = value.compareTo(other.value)
}