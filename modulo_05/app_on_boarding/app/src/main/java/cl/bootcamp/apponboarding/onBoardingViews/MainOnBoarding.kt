package cl.bootcamp.apponboarding.onBoardingViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import cl.bootcamp.apponboarding.R
import cl.bootcamp.apponboarding.data.PageData
import cl.bootcamp.apponboarding.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(modifier: Modifier, navController: NavController, store: StoreBoarding) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.hola_android,
            "Hola Mundo!",
            "Descripción uno de nuestro onBoarding del Módulo 5"
        )
    )
    items.add(
        PageData(
            R.raw.page2,
            "Page 2",
            "Descripción dos de nuestro onBoarding del Módulo 5"
        )
    )
    items.add(
        PageData(
            R.raw.finish,
            "Finish!!",
            "Descripción tres de nuestro onBoarding del Módulo 5"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        navController,
        store
    )
}