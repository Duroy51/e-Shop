package com.example.e_shopstaff.data

import androidx.annotation.DrawableRes
import com.example.e_shopstaff.R

data class photo(val idPhoto: Int=0, @DrawableRes val lienPhoto: Int, val codePro: Int)

val photos = mutableListOf<photo>(
    photo(21, R.drawable.habittest, 11),
    photo(21, R.drawable.habittest, 12),
    photo(21, R.drawable.habittest, 13),
    photo(21, R.drawable.habittest, 14),
    photo(21, R.drawable.habittest, 15),
    photo(21, R.drawable.habittest, 16),
    photo(21, R.drawable.habittest, 17),
    photo(21, R.drawable.habittest, 18),

    photo(21, R.drawable.habittest2, 11),
    photo(21, R.drawable.habittest2, 12),
    photo(21, R.drawable.habittest2, 13),
    photo(21, R.drawable.habittest2, 14),
    photo(21, R.drawable.habittest2, 15),
    photo(21, R.drawable.habittest2, 16),
    photo(21, R.drawable.habittest2, 17),
    photo(21, R.drawable.habittest2, 18),
)