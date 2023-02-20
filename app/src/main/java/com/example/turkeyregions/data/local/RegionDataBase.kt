package com.example.turkeyregions.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

@Database (entities = [CodeEntity::class], version = 1)
abstract class RegionDataBase: RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        @Volatile private var INSTANCE: RegionDataBase? = null

        fun getInstance(context: Context): RegionDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context, RegionDataBase::class.java, "regionDatabase").addCallback(object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                ioThread {
                    getInstance(context).getDao().let {
                        it.insertRegion(CodeEntity("01", "Adana (Адана)"))
                        it.insertRegion(CodeEntity("02", "Adıyaman (Адыяман)"))
                        it.insertRegion(CodeEntity("03", "Afyonkarahisar (Афьонкарахисар)"))
                        it.insertRegion(CodeEntity("04", "Ağrı (Агры)"))
                        it.insertRegion(CodeEntity("05", "Amasya (Амасья)"))
                        it.insertRegion(CodeEntity("06", "Ankara (Анкара)"))
                        it.insertRegion(CodeEntity("07", "Antalya (Анталья)"))
                        it.insertRegion(CodeEntity("08", "Artvin (Артвин)"))
                        it.insertRegion(CodeEntity("09", "Aydın (Айдын)"))
                        it.insertRegion(CodeEntity("10", "Balıkesir (Балыкесир)"))
                        it.insertRegion(CodeEntity("11", "Bilecik (Биледжик)"))
                        it.insertRegion(CodeEntity("12", "Bingöl (Бингёль)"))
                        it.insertRegion(CodeEntity("13", "Bitlis (Битлис)"))
                        it.insertRegion(CodeEntity("14", "Bolu (Болу)"))
                        it.insertRegion(CodeEntity("15", "Burdur (Бурдур)"))
                        it.insertRegion(CodeEntity("16", "Bursa (Бурса)"))
                        it.insertRegion(CodeEntity("17", "Çanakkale (Чанаккале)"))
                        it.insertRegion(CodeEntity("18", "Çankırı (Чанкыры)"))
                        it.insertRegion(CodeEntity("19", "Çorum (Чорум)"))
                        it.insertRegion(CodeEntity("20", "Denizli (Денизли)"))
                        it.insertRegion(CodeEntity("21", "Diyarbakır (Диярбакыр)"))
                        it.insertRegion(CodeEntity("22", "Edirne (Эдирне)"))
                        it.insertRegion(CodeEntity("23", "Elazığ (Элязыг)"))
                        it.insertRegion(CodeEntity("24", "Erzincan (Эрзинджан)"))
                        it.insertRegion(CodeEntity("25", "Erzurum (Эрзурум)"))
                        it.insertRegion(CodeEntity("26", "Eskişehir (Эскишехир)"))
                        it.insertRegion(CodeEntity("27", "Gaziantep (Газиантеп)"))
                        it.insertRegion(CodeEntity("28", "Giresun (Гиресун)"))
                        it.insertRegion(CodeEntity("29", "Gümüşhane (Гюмюшхане)"))
                        it.insertRegion(CodeEntity("30", "Hakkari (Хаккяри)"))
                        it.insertRegion(CodeEntity("31", "Hatay (Хатай)"))
                        it.insertRegion(CodeEntity("32", "Isparta (Ыспарта)"))
                        it.insertRegion(CodeEntity("33", "Mersin (Мерсин)"))
                        it.insertRegion(CodeEntity("34", "İstanbul (Стамбул)"))
                        it.insertRegion(CodeEntity("35", "İzmir (Измир)"))
                        it.insertRegion(CodeEntity("36", "Kars (Карс)"))
                        it.insertRegion(CodeEntity("37", "Kastamonu (Кастамону)"))
                        it.insertRegion(CodeEntity("38", "Kayseri (Кайсери)"))
                        it.insertRegion(CodeEntity("39", "Kırklareli (Кыркларели)"))
                        it.insertRegion(CodeEntity("40", "Kırşehir (Кыршехир)"))
                        it.insertRegion(CodeEntity("41", "Kocaeli (Коджаели)"))
                        it.insertRegion(CodeEntity("42", "Konya (Конья)"))
                        it.insertRegion(CodeEntity("43", "Kütahya (Кютахья)"))
                        it.insertRegion(CodeEntity("44", "Malatya (Малатья)"))
                        it.insertRegion(CodeEntity("45", "Manisa (Маниса)"))
                        it.insertRegion(CodeEntity("46", "Kahramanmaraş (Кахраманмараш)"))
                        it.insertRegion(CodeEntity("47", "Mardin (Мардин)"))
                        it.insertRegion(CodeEntity("48", "Muğla (Мугла)"))
                        it.insertRegion(CodeEntity("49", "Muş (Муш)"))
                        it.insertRegion(CodeEntity("50", "Nevşehir (Невшехир)"))
                        it.insertRegion(CodeEntity("51", "Niğde (Нигде)"))
                        it.insertRegion(CodeEntity("52", "Ordu (Орду)"))
                        it.insertRegion(CodeEntity("53", "Rize (Ризе)"))
                        it.insertRegion(CodeEntity("54", "Sakarya (Сакарья)"))
                        it.insertRegion(CodeEntity("55", "Samsun (Самсун)"))
                        it.insertRegion(CodeEntity("56", "Siirt (Сиирт)"))
                        it.insertRegion(CodeEntity("57", "Sinop (Синоп)"))
                        it.insertRegion(CodeEntity("58", "Sivas (Сивас)"))
                        it.insertRegion(CodeEntity("59", "Tekirdağ (Текирдаг)"))
                        it.insertRegion(CodeEntity("60", "Tokat (Токат)"))
                        it.insertRegion(CodeEntity("61", "Trabzon (Трабзон)"))
                        it.insertRegion(CodeEntity("62", "Tunceli (Тунджели)"))
                        it.insertRegion(CodeEntity("63", "Şanlıurfa (Шанлыурфа)"))
                        it.insertRegion(CodeEntity("64", "Uşak (Ушак)"))
                        it.insertRegion(CodeEntity("65", "Van (Ван)"))
                        it.insertRegion(CodeEntity("66", "Yozgat (Йозгат)"))
                        it.insertRegion(CodeEntity("67", "Zonguldak (Зонгулдак)"))
                        it.insertRegion(CodeEntity("68", "Aksaray (Аксарай)"))
                        it.insertRegion(CodeEntity("69", "Bayburt (Байбурт)"))
                        it.insertRegion(CodeEntity("70", "Karaman (Караман)"))
                        it.insertRegion(CodeEntity("71", "Kırıkkale (Кырыккале)"))
                        it.insertRegion(CodeEntity("72", "Batman (Батман)"))
                        it.insertRegion(CodeEntity("73", "Şırnak (Ширнак)"))
                        it.insertRegion(CodeEntity("74", "Bartın (Бартын)"))
                        it.insertRegion(CodeEntity("75", "Ardahan (Ардахан)"))
                        it.insertRegion(CodeEntity("76", "Iğdır (Ыгдыр)"))
                        it.insertRegion(CodeEntity("77", "Yalova (Ялова)"))
                        it.insertRegion(CodeEntity("78", "Karabük (Карабюк)"))
                        it.insertRegion(CodeEntity("79", "Kilis (Килис)"))
                        it.insertRegion(CodeEntity("80", "Osmaniye (Османие)"))
                        it.insertRegion(CodeEntity("81", "Düzce (Дюздже)"))


                    }
                }
            }
        }).build()
    }
}


private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

/**
 * Utility method to run blocks on a dedicated background thread, used for io/database work.
 */
fun ioThread(f : () -> Unit) {
    IO_EXECUTOR.execute(f)
}

