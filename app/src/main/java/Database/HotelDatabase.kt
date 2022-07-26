package Database

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [entity::class], version = 1)
abstract class HotelDatabase:RoomDatabase(){
    abstract fun hotelDao():HotelDao
}