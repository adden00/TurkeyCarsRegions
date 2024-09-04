package com.addenisov00.turkeyregions.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

@Database(entities = [RegionNumberItem::class], version = 1)
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
                        it.insertRegion(RegionNumberItem("01", "Adana (Адана)"))
                        it.insertRegion(RegionNumberItem("02", "Adıyaman (Адыяман)"))
                        it.insertRegion(RegionNumberItem("03", "Afyonkarahisar (Афьонкарахисар)"))
                        it.insertRegion(RegionNumberItem("04", "Ağrı (Агры)"))
                        it.insertRegion(RegionNumberItem("05", "Amasya (Амасья)"))
                        it.insertRegion(RegionNumberItem("06", "Ankara (Анкара)"))
                        it.insertRegion(RegionNumberItem("07", "Antalya (Анталья)"))
                        it.insertRegion(RegionNumberItem("08", "Artvin (Артвин)"))
                        it.insertRegion(RegionNumberItem("09", "Aydın (Айдын)"))
                        it.insertRegion(RegionNumberItem("10", "Balıkesir (Балыкесир)"))
                        it.insertRegion(RegionNumberItem("11", "Bilecik (Биледжик)"))
                        it.insertRegion(RegionNumberItem("12", "Bingöl (Бингёль)"))
                        it.insertRegion(RegionNumberItem("13", "Bitlis (Битлис)"))
                        it.insertRegion(RegionNumberItem("14", "Bolu (Болу)"))
                        it.insertRegion(RegionNumberItem("15", "Burdur (Бурдур)"))
                        it.insertRegion(RegionNumberItem("16", "Bursa (Бурса)"))
                        it.insertRegion(RegionNumberItem("17", "Çanakkale (Чанаккале)"))
                        it.insertRegion(RegionNumberItem("18", "Çankırı (Чанкыры)"))
                        it.insertRegion(RegionNumberItem("19", "Çorum (Чорум)"))
                        it.insertRegion(RegionNumberItem("20", "Denizli (Денизли)"))
                        it.insertRegion(RegionNumberItem("21", "Diyarbakır (Диярбакыр)"))
                        it.insertRegion(RegionNumberItem("22", "Edirne (Эдирне)"))
                        it.insertRegion(RegionNumberItem("23", "Elazığ (Элязыг)"))
                        it.insertRegion(RegionNumberItem("24", "Erzincan (Эрзинджан)"))
                        it.insertRegion(RegionNumberItem("25", "Erzurum (Эрзурум)"))
                        it.insertRegion(RegionNumberItem("26", "Eskişehir (Эскишехир)"))
                        it.insertRegion(RegionNumberItem("27", "Gaziantep (Газиантеп)"))
                        it.insertRegion(RegionNumberItem("28", "Giresun (Гиресун)"))
                        it.insertRegion(RegionNumberItem("29", "Gümüşhane (Гюмюшхане)"))
                        it.insertRegion(RegionNumberItem("30", "Hakkari (Хаккяри)"))
                        it.insertRegion(RegionNumberItem("31", "Hatay (Хатай)"))
                        it.insertRegion(RegionNumberItem("32", "Isparta (Ыспарта)"))
                        it.insertRegion(RegionNumberItem("33", "Mersin (Мерсин)"))
                        it.insertRegion(RegionNumberItem("34", "İstanbul (Стамбул)"))
                        it.insertRegion(RegionNumberItem("35", "İzmir (Измир)"))
                        it.insertRegion(RegionNumberItem("36", "Kars (Карс)"))
                        it.insertRegion(RegionNumberItem("37", "Kastamonu (Кастамону)"))
                        it.insertRegion(RegionNumberItem("38", "Kayseri (Кайсери)"))
                        it.insertRegion(RegionNumberItem("39", "Kırklareli (Кыркларели)"))
                        it.insertRegion(RegionNumberItem("40", "Kırşehir (Кыршехир)"))
                        it.insertRegion(RegionNumberItem("41", "Kocaeli (Коджаели)"))
                        it.insertRegion(RegionNumberItem("42", "Konya (Конья)"))
                        it.insertRegion(RegionNumberItem("43", "Kütahya (Кютахья)"))
                        it.insertRegion(RegionNumberItem("44", "Malatya (Малатья)"))
                        it.insertRegion(RegionNumberItem("45", "Manisa (Маниса)"))
                        it.insertRegion(RegionNumberItem("46", "Kahramanmaraş (Кахраманмараш)"))
                        it.insertRegion(RegionNumberItem("47", "Mardin (Мардин)"))
                        it.insertRegion(RegionNumberItem("48", "Muğla (Мугла)"))
                        it.insertRegion(RegionNumberItem("49", "Muş (Муш)"))
                        it.insertRegion(RegionNumberItem("50", "Nevşehir (Невшехир)"))
                        it.insertRegion(RegionNumberItem("51", "Niğde (Нигде)"))
                        it.insertRegion(RegionNumberItem("52", "Ordu (Орду)"))
                        it.insertRegion(RegionNumberItem("53", "Rize (Ризе)"))
                        it.insertRegion(RegionNumberItem("54", "Sakarya (Сакарья)"))
                        it.insertRegion(RegionNumberItem("55", "Samsun (Самсун)"))
                        it.insertRegion(RegionNumberItem("56", "Siirt (Сиирт)"))
                        it.insertRegion(RegionNumberItem("57", "Sinop (Синоп)"))
                        it.insertRegion(RegionNumberItem("58", "Sivas (Сивас)"))
                        it.insertRegion(RegionNumberItem("59", "Tekirdağ (Текирдаг)"))
                        it.insertRegion(RegionNumberItem("60", "Tokat (Токат)"))
                        it.insertRegion(RegionNumberItem("61", "Trabzon (Трабзон)"))
                        it.insertRegion(RegionNumberItem("62", "Tunceli (Тунджели)"))
                        it.insertRegion(RegionNumberItem("63", "Şanlıurfa (Шанлыурфа)"))
                        it.insertRegion(RegionNumberItem("64", "Uşak (Ушак)"))
                        it.insertRegion(RegionNumberItem("65", "Van (Ван)"))
                        it.insertRegion(RegionNumberItem("66", "Yozgat (Йозгат)"))
                        it.insertRegion(RegionNumberItem("67", "Zonguldak (Зонгулдак)"))
                        it.insertRegion(RegionNumberItem("68", "Aksaray (Аксарай)"))
                        it.insertRegion(RegionNumberItem("69", "Bayburt (Байбурт)"))
                        it.insertRegion(RegionNumberItem("70", "Karaman (Караман)"))
                        it.insertRegion(RegionNumberItem("71", "Kırıkkale (Кырыккале)"))
                        it.insertRegion(RegionNumberItem("72", "Batman (Батман)"))
                        it.insertRegion(RegionNumberItem("73", "Şırnak (Ширнак)"))
                        it.insertRegion(RegionNumberItem("74", "Bartın (Бартын)"))
                        it.insertRegion(RegionNumberItem("75", "Ardahan (Ардахан)"))
                        it.insertRegion(RegionNumberItem("76", "Iğdır (Ыгдыр)"))
                        it.insertRegion(RegionNumberItem("77", "Yalova (Ялова)"))
                        it.insertRegion(RegionNumberItem("78", "Karabük (Карабюк)"))
                        it.insertRegion(RegionNumberItem("79", "Kilis (Килис)"))
                        it.insertRegion(RegionNumberItem("80", "Osmaniye (Османие)"))
                        it.insertRegion(RegionNumberItem("81", "Düzce (Дюздже)"))


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

