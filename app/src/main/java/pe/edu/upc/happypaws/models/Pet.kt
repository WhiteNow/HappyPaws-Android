package pe.edu.upc.happypaws.models

import android.os.Parcel
import android.os.Parcelable

data class Pet(val _id: String, val name: String, val species: String,
               val birthdate: String, val gender: String, val weight: String,
               val vaccination: String, val desease: String, val surgery: String,
               val owner_id: String, val __v: String): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    constructor(): this("","","","","",
        "", "", "","", "", "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(name)
        parcel.writeString(species)
        parcel.writeString(birthdate)
        parcel.writeString(gender)
        parcel.writeString(weight)
        parcel.writeString(vaccination)
        parcel.writeString(desease)
        parcel.writeString(surgery)
        parcel.writeString(owner_id)
        parcel.writeString(__v)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pet> {
        override fun createFromParcel(parcel: Parcel): Pet {
            return Pet(parcel)
        }

        override fun newArray(size: Int): Array<Pet?> {
            return arrayOfNulls(size)
        }
    }

}