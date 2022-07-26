package Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "hotel_info")
data class entity(
    @PrimaryKey val hotel_id:Int,
    @ColumnInfo(name = "hotel_name")val hotelname:String,
    @ColumnInfo(name = "hotel_rating")val hotelrating:String,
    @ColumnInfo(name = "hotel_cost")val hotelcost:String,
    @ColumnInfo(name = "img")val image:String
)