package Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HotelDao {
    @Insert
    fun insert(entity: entity)
    @Delete
    fun delete(entity: entity)
    @Query("SELECT * FROM hotel_info")
    fun getallhotels():List<entity>
    @Query("SELECT * FROM hotel_info where hotel_id=:hotelid")
    fun gethotelid(hotelid:String):entity
}