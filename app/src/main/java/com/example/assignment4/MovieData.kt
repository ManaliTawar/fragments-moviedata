import android.graphics.Color.alpha
import com.example.assignment4.R
import com.google.gson.Gson
import java.io.Serializable

class MovieList {
    val movieList: List<MovieData> = Gson().fromJson(movies, Array<MovieData>::class.java).asList()
    val posterTable: MutableMap<String, Int> = mutableMapOf()
    val genreTable: MutableMap<Int, String> = mutableMapOf()

    init {
        // create poster table mapping title and image id
        posterTable["The Godfather"] = R.drawable.god
        posterTable["The Shawshank Redemption"] = R.drawable.redemption
        posterTable["Cuando Sea Joven"] = R.drawable.seajoven
        posterTable["The Boy, the Mole, the Fox and the Horse"] = R.drawable.boy
        posterTable["The Godfather Part II"] = R.drawable.god2
        posterTable["Schindler's List"] = R.drawable.schinler
        posterTable["दिलवाले दुल्हनिया ले जायेंगे"] = R.drawable.dilwale
        /*posterTable["Hereditary"] = R.drawable.hereditary
        posterTable["The First Purge"] = R.drawable.purge
        posterTable["Incredibles 2"] = R.drawable.incredible
        posterTable["Upgrade"] = R.drawable.upgrade
        posterTable["Tag"] = R.drawable.tag
        posterTable["Adrift"] = R.drawable.adrift
        posterTable["Peppermint"] = R.drawable.peppermint
        posterTable["The Equalizer 2"] = R.drawable.equalizer
        posterTable["Crazy Rich Asians"] = R.drawable.crazy
        posterTable["Slender Man"] = R.drawable.slender
        posterTable["Searching"] = R.drawable.searching
        posterTable["Hotel Transylvania 3: Summer Vacation"] = R.drawable.hotel
        posterTable["BlacKkKlansman"] = R.drawable.black*/

        genreTable[28] = "Action"
        genreTable[12] = "Adventure"
        genreTable[16] = "Animation"
        genreTable[35] = "Comedy"
        genreTable[80] = "Crime"
        genreTable[99] = "Documentary"
        genreTable[18] = "Drama"
        genreTable[10751] = "Family"
        genreTable[14] = "Fantasy"
        genreTable[36] = "History"
        genreTable[27] = "Horror"
        genreTable[10402] = "Music"
        genreTable[9648] = "Mystery"
        genreTable[10749] = "Romance"
        genreTable[878] = "Science Fiction"
        genreTable[10770] = "TV Movies"
        genreTable[53] = "Thriller"
        genreTable[10752] = "War"
        genreTable[37] = "Western"

        for(movie in movieList){
            movie.poster_id = posterTable[movie.title]
            var g = ""
            for(i in movie.genre_ids!!){
                g += genreTable[i]
            }
            movie.genres = g
            movie.checked = false
        }
    }

    fun getMovieData():List<MovieData>{
        return movieList
    }
    fun getImageData():MutableMap<String, Int>{
        return posterTable
    }
}

data class MovieData(
    val vote_count: Int?,
    val id: Int?,
    val video: Boolean?,
    val vote_average: Double?,
    var title: String?,
    val popularity: Double?,
    val poster_path: String?,
    val original_language: String?,
    val original_title: String?,
    val genre_ids: List<Int?>?,
    val backdrop_path: String?,
    val overview: String?,
    val release_date: String?,
    var poster_id: Int?,
    var genres: String?,
    var checked: Boolean?
) : Serializable

val movies = """
            [
    {
    "page": 1,
    "results": [
        {
            "adult": false,
            "backdrop_path": "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 238,
            "original_language": "en",
            "original_title": "The Godfather",
            "overview": "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
            "popularity": 151.669,
            "poster_path": "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
            "release_date": "1972-03-14",
            "title": "The Godfather",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 17576
        },
        {
            "adult": false,
            "backdrop_path": "/wPU78OPN4BYEgWYdXyg0phMee64.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 278,
            "original_language": "en",
            "original_title": "The Shawshank Redemption",
            "overview": "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
            "popularity": 83.179,
            "poster_path": "/hBcY0fE9pfXzvVaY4GKarweriG2.jpg",
            "release_date": "1994-09-23",
            "title": "The Shawshank Redemption",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 23414
        },
        {
            "adult": false,
            "backdrop_path": "/ejniJnlOdtSgtbh8D7u2RxT6Uli.jpg",
            "genre_ids": [
                35,
                14
            ],
            "id": 772071,
            "original_language": "es",
            "original_title": "Cuando Sea Joven",
            "overview": "70-year-old Malena gets a second chance at life when she magically turns into her 22-year-old self. Now, posing as \"Maria\" to hide her true identity, she becomes the lead singer of her grandson's band and tries to recover her dream of singing, which she had to give up at some point.",
            "popularity": 38.924,
            "poster_path": "/6gIJuFHh5Lj4dNaPG3TzIMl7L68.jpg",
            "release_date": "2022-09-14",
            "title": "Cuando Sea Joven",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 210
        },
        {
            "adult": false,
            "backdrop_path": "/wxaBkuqVIgImjRHEMJoxL9Lq6i8.jpg",
            "genre_ids": [
                16,
                10751,
                12,
                14
            ],
            "id": 995133,
            "original_language": "en",
            "original_title": "The Boy, the Mole, the Fox and the Horse",
            "overview": "The unlikely friendship of a boy, a mole, a fox and a horse traveling together in the boy’s search for home.",
            "popularity": 40.709,
            "poster_path": "/oQRgyQCzcyZvE6w5heM9ktVY0LT.jpg",
            "release_date": "2022-12-25",
            "title": "The Boy, the Mole, the Fox and the Horse",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 254
        },
        {
            "adult": false,
            "backdrop_path": "/kGzFbGhp99zva6oZODW5atUtnqi.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 240,
            "original_language": "en",
            "original_title": "The Godfather Part II",
            "overview": "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.",
            "popularity": 71.623,
            "poster_path": "/hek3koDUyRQk7FIhPXsa6mT2Zc3.jpg",
            "release_date": "1974-12-20",
            "title": "The Godfather Part II",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 10641
        },
        {
            "adult": false,
            "backdrop_path": "/zb6fM1CX41D9rF9hdgclu0peUmy.jpg",
            "genre_ids": [
                18,
                36,
                10752
            ],
            "id": 424,
            "original_language": "en",
            "original_title": "Schindler's List",
            "overview": "The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.",
            "popularity": 58.558,
            "poster_path": "/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg",
            "release_date": "1993-12-15",
            "title": "Schindler's List",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 13841
        },
        {
            "adult": false,
            "backdrop_path": "/vI3aUGTuRRdM7J78KIdW98LdxE5.jpg",
            "genre_ids": [
                35,
                18,
                10749
            ],
            "id": 19404,
            "original_language": "hi",
            "original_title": "दिलवाले दुल्हनिया ले जायेंगे",
            "overview": "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
            "popularity": 30.694,
            "poster_path": "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
            "release_date": "1995-10-19",
            "title": "Dilwale Dulhania Le Jayenge",
            "video": false,
            "vote_average": 8.6,
            "vote_count": 4073
        }
  ]
        """.trimIndent()