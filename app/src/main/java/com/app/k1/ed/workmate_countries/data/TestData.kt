package com.app.k1.ed.workmate_countries.data

data class Country(
    val name: String,
    val flagUrl: String
)

val countries = listOf(
    Country("American Samoa", "https://flagcdn.com/w320/as.png"),
    Country("Anguilla", "https://flagcdn.com/w320/ai.png"),
    Country("Antarctica", "https://flagcdn.com/w320/aq.png"),
    Country("Antigua and Barbuda", "https://flagcdn.com/w320/ag.png"),
    Country("Arab Republic of Egypt", "https://flagcdn.com/w320/eg.png"),
    Country("Argentine Republic", "https://flagcdn.com/w320/ar.png"),
    Country("Aruba", "https://flagcdn.com/w320/aw.png"),
    Country("Bailiwick of Guernsey", "https://flagcdn.com/w320/gg.png"),
    Country("Bailiwick of Jersey", "https://flagcdn.com/w320/je.png"),
    Country("Barbados", "https://flagcdn.com/w320/bb.png"),
    Country("Belize", "https://flagcdn.com/w320/bz.png"),
    Country("Bermuda", "https://flagcdn.com/w320/bm.png"),
    Country("Bolivarian Republic of Venezuela", "https://flagcdn.com/w320/ve.png"),
    Country("Bonaire, Sint Eustatius and Saba", "https://flagcdn.com/w320/bq.png"),
    Country("Bosnia and Herzegovina", "https://flagcdn.com/w320/ba.png"),
)