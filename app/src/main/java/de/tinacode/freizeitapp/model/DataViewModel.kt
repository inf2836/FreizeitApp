package de.tinacode.freizeitapp.model

import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel() {

    val list:ArrayList<DataModel> = ArrayList()

    init {
        list.add(
            DataModel("Hallenbad Süd",
                "Erich-Reimann-Straße 5, 67061 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "1,2 km")
        )
        list.add(
            DataModel("Freibad am Willersinnweiher",
                "Strandweg 23, 67063 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "2,1 km")
        )
        list.add(
            DataModel("Hallenbad Süd",
                "Erich-Reimann-Straße 6, 67061 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "1,2 km")
        )
        list.add(
            DataModel("Hallenbad Süd",
                "Erich-Reimann-Straße 6, 67061 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "1,2 km")
        )
        list.add(
            DataModel("Hallenbad Süd",
                "Erich-Reimann-Straße 6, 67061 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "1,2 km")
        )
        list.add(
            DataModel("Hallenbad Süd",
                "Erich-Reimann-Straße 6, 67061 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "1,2 km")
        )
        list.add(
            DataModel("Hallenbad Süd",
                "Erich-Reimann-Straße 6, 67061 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "1,2 km")
        )
        list.add(
            DataModel("Hallenbad Süd",
                "Erich-Reimann-Straße 6, 67061 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "1,2 km")
        )
        list.add(
            DataModel("Hallenbad Süd",
                "Erich-Reimann-Straße 6, 67061 Ludwigshafen am Rhein",
                "0621 5042900",
                "So. 10:00 - 19:00\n Mo. 08:00 - 20:00", "1,2 km")
        )
    }
}